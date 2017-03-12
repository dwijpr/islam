<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\QuranDB\Sura;
use Storage;

class QuranDBController extends Controller
{
    static $path = 'Al-QuranIndonesia_com.andi.alquran.id_source_from_JADX';
    public function index() {
        $suras = Sura::all();
        return view('qurandb.index', [
            'suras' => $suras,
        ]);
    }

    public function suraTitle(Sura $sura) {
        $file = Storage::get(
            self::$path.'/res/drawable/'.'sname_'.$sura->id.'.png'
        );
        return $file;
    }
}
