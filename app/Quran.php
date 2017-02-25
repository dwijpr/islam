<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Quran extends Model
{
    protected $table = 'Quran';

    public static function getAllSura() {
        $suras = [];
        $surasDB = self::all()->groupBy('SuraID');
        foreach ($surasDB as $i => $sura) {
            $_sura = new QuranSura($sura->first()->SuraID);
            $_sura->ayats = $sura->all();
            $suras[] = $_sura;
        }
        return collect($suras);
    }
}
