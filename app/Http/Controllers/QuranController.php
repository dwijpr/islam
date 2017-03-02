<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Storage, stdClass;
use App\QuranSura;

class Ayat {
    public function __construct($surah, $ayat) {
        $sura_dir_name = text_to_url(QuranSura::$NAMES[$surah]);
        $path =
            'quran/'.sprintf('%03d', $surah).'-'.$sura_dir_name
            .'/'.sprintf('%03d', $ayat);
        $this->ar = Storage::get($path.'/ar.md');
        $this->id = Storage::get($path.'/id.md');
        $this->en = Storage::get($path.'/en.md');
        $word_directories = Storage::directories($path.'/words');
        foreach ($word_directories as $i => $directory) {
            $word = Storage::get($directory.'/ar.md');
            $word_id =
                Storage::exists($directory.'/id.md')
                ?Storage::get($directory.'/id.md'):'';
            $this->words[] = $word;
            $view = view('partial.quran-word-span', [
                'word' => $word,
                'trans' => $word_id,
            ])->render();
            $this->ar = preg_replace(
                '/'.$word.'/'
                , $view
                , $this->ar, 1
            );
        }
        $this->audio = sprintf('%03d', $surah).sprintf('%03d', $ayat);
    }
}

class Surah {
    var $progress;
    
    public function __construct($input) {
        $this->identifier = str_replace('quran/', '', $input);
        preg_match('/(\d{3})-.+$/', $input, $match);
        $this->id = $match[1];
        $this->quranSura = new QuranSura(intval($this->id));
        $this->ayats = [];
        $directories = Storage::directories('quran/'.$input);
        foreach ($directories as $i => $directory) {
            preg_match('/quran\/'.$this->id.'.*\/(\d+)/', $directory, $match);
            $id = $match[1];
            $this->ayats[] = new Ayat(intval($this->id), $id);
        }
    }
}

class QuranController extends Controller
{
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
