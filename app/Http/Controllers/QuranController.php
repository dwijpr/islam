<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Storage, stdClass;

class Surah {
    public function __construct($input) {
        $this->name = str_replace('quran/', '', $input);
        $this->ayats = [];
        $directories = Storage::directories($input);
        foreach ($directories as $i => $directory) {
            $ayat = new stdClass;
            $ayat->are = Storage::get($directory.'/are.md');
            $ayat->idn = Storage::get($directory.'/idn.md');
            $ayat->int = Storage::get($directory.'/int.md');
            $this->ayats[] = $ayat;
        }
    }
}

class QuranController extends Controller
{
    public function index() {
        $surahs = [];
        $directories = Storage::directories('quran');
        foreach ($directories as $i => $directory) {
            $surah = new Surah($directory);
            $surahs[] = $surah;
        }
        return view('quran.index', [
            'surahs' => $surahs,
        ]);
    }
}
