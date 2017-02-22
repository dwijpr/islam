<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Storage, stdClass;

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
