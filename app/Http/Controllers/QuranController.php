<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Storage, stdClass;
use App\QuranSura;

class Ayat {
    var $progress = 0;

    public function __construct($surah, $ayat) {
        $this->_id = $ayat;
        $sura_dir_name = text_to_url(QuranSura::$NAMES[$surah]);
        $path =
            'quran/'.sprintf('%03d', $surah).'-'.$sura_dir_name
            .'/'.sprintf('%03d', $ayat);
        $this->ar = Storage::get($path.'/ar.md');
        $this->id = Storage::get($path.'/id.md');
        $this->en = Storage::get($path.'/en.md');
        $word_directories = Storage::directories($path.'/words');
        $data = json_decode(Storage::get($path.'/data.json'));
        $this->audio = sprintf('%03d', $surah).sprintf('%03d', $ayat);
        if (!Storage::exists('/quran/audio/'.$this->audio.'.mp3')) {
            $this->audio = false;
        }
        if ($this->ar) {
            $this->progress += 25;
            if ($this->id) {
                $this->progress += 15;
            }
            if ($this->en) {
                $this->progress += 10;
            }
            if ($this->audio) {
                $this->progress += 5;
            }
        }
        if ($data->words->count) {
            $this->progress += 1;
            $per_word_progress = 44/$data->words->count;
        }
        $marks = [
            'ۖ', 'ؕ', 'ۙ', 'ۚ',
        ];
        foreach ($marks as $i => $mark) {
            $view = view('partial.quran-mark-span', [
                'mark' => $mark,
            ])->render();
            $this->ar = str_replace($mark, $view, $this->ar);
        }
        foreach ($word_directories as $i => $directory) {
            if (@$per_word_progress) {
                if (Storage::exists($directory.'/ar.md')) {
                    $this->progress += $per_word_progress/2;
                    if (Storage::exists($directory.'/id.md')) {
                        $this->progress += $per_word_progress/3;
                    }
                    if (Storage::exists($directory.'/en.md')) {
                        $this->progress += $per_word_progress/6;
                    }
                }
            }
            $word = 
                Storage::exists($directory.'/ar.md')
                ?Storage::get($directory.'/ar.md'):'';
            $word_id =
                Storage::exists($directory.'/id.md')
                ?Storage::get($directory.'/id.md'):'';
            $word_en =
                Storage::exists($directory.'/en.md')
                ?Storage::get($directory.'/en.md'):'';
            $this->words[] = $word;
            $view = view('partial.quran-word-span', [
                'word' => $word,
                'trans' => $word_id.' | '.$word_en,
            ])->render();
            $this->ar = preg_replace(
                '/'.$word.'/'
                , $view
                , $this->ar, 1
            );
        }
        $this->progress = ceil($this->progress);
    }
}

class Surah {
    var $progress = 0;

    static $sura_artis = false;
    static $resource_dir =
        'Al-QuranIndonesia_com.andi.alquran.id_source_from_JADX';
    
    public function __construct($input) {
        if (!self::$sura_artis) {
            $this->load();
        }
        $this->identifier = str_replace('quran/', '', $input);
        preg_match('/(\d{3})-.+$/', $input, $match);
        $this->id = $match[1];
        $this->_id = intval($this->id);
        $this->quranSura = new QuranSura(intval($this->id));
        $this->ayats = [];
        $directories = Storage::directories('quran/'.$this->identifier);
        foreach ($directories as $i => $directory) {
            preg_match('/quran\/'.$this->id.'.*\/(\d+)/', $directory, $match);
            $id = $match[1];
            $ayat = new Ayat(intval($this->id), intval($id));
            $this->progress += $ayat->progress;
            $this->ayats[] = $ayat;
        }
        $this->progress = ($this->progress/$this->quranSura->count);
        $this->arti = self::$sura_artis[$this->_id-1];
    }

    function load() {
        $dataPath = self::$resource_dir.'/res/values/arrays.xml';
        $xml = simplexml_load_string(Storage::get($dataPath));
        $sura_artis = $xml->{"string-array"}[26];
        self::$sura_artis = [];
        foreach ($sura_artis as $i => $sura_arti) {
            self::$sura_artis[] = str_replace('"', '', strval($sura_arti));
        }
    }
}

class QuranController extends Controller
{
    public function progress() {
        $surahs = [];
        $directories = Storage::directories('quran');
        foreach ($directories as $i => $directory) {
            if ($directory === 'quran/audio') {
                continue;
            }
            $surah = new Surah($directory);
            if ($surah->progress) {
                $surahs[] = $surah;
            }
        }
        foreach ($surahs as $i => $sura) {
            foreach ($sura->ayats as $_i => $aya) {
                if (!$aya->progress) {
                    unset($surahs[$i]->ayats[$_i]);
                }
            }
        }
        return view('quran.progress', [
            'surahs' => $surahs,
        ]);
    }

    public function audio($key) {
        return Storage::get('quran/audio/'.$key.'.mp3');
    }

    public function sura($sura = 1) {
        $quranSura = new QuranSura($sura);
        $input = sprintf('%03d', $sura).'-'.text_to_url($quranSura->name);
        $sura = new Surah($input);
        return view('quran.sura', [
            'sura' => $sura,
        ]);
    }

    public function ayat($surah = 1, $ayat = 1) {
        $ayat = new Ayat($surah, $ayat);
        return view('quran.ayat', [
            'ayat' => $ayat,
        ]);
    }

    public function index() {
        $surahs = [];
        $directories = Storage::directories('quran');
        foreach ($directories as $i => $directory) {
            if ($directory === 'quran/audio') {
                continue;
            }
            $surah = new Surah($directory);
            $surahs[] = $surah;
        }
        return view('quran.index', [
            'surahs' => $surahs,
        ]);
    }
}
