<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Storage;

class AndroidAssetController extends Controller
{
    static $path = 'Al-QuranIndonesia_com.andi.alquran.id_source_from_JADX';

    public function getDrawable($filename) {
        return Storage::get(self::$path.'/res/drawable/'.$filename);
    }
}
