<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\QuranDB\Sura;

class QuranDBController extends Controller
{
    public function index() {
        $suras = Sura::all();
        return view('qurandb.index', [
            'suras' => $suras,
        ]);
    }
}
