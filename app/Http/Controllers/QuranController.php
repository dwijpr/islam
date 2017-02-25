<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Storage, stdClass;
use App\Quran;

class Ayat {
    public function __construct($surah, $ayat) {
        $path = 'quran/'.sprintf('%03d', $surah).'/'.$ayat;
        $this->are = Storage::get($path.'/are.md');
        $this->idn = Storage::get($path.'/idn.md');
        $this->int = Storage::get($path.'/int.md');
        $this->audio = $this->id.sprintf('%03d', $ayat);
    }
}

class Surah {
    public function __construct($input) {
        $this->name = str_replace('quran/', '', $input);
        preg_match('/(\d{3})-.+$/', $input, $match);
        $this->id = $match[1];
        $this->ayats = [];
        $directories = Storage::directories($input);
        foreach ($directories as $i => $directory) {
            $ayat = new stdClass;
            preg_match('/quran\/'.$this->id.'.*\/(\d+)/', $directory, $match);
            $ayat->id = $match[1];
            $ayat->are = Storage::get($directory.'/are.md');
            $ayat->idn = Storage::get($directory.'/idn.md');
            $ayat->int = Storage::get($directory.'/int.md');
            $ayat->audio = $this->id.sprintf('%03d', $ayat->id);
            $this->ayats[] = $ayat;
        }
    }
}

class QuranController extends Controller
{
    public function audio($key) {
        return Storage::get('quran/audio/'.$key.'.mp3');
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
