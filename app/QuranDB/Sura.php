<?php

namespace App\QuranDB;

use Illuminate\Database\Eloquent\Model;

class Sura extends Model
{
    protected $fillable = [
        'id', 'title', 'arti',
    ];
    protected $appends = [
        'image_title',
    ];

    public function getImageTitleAttribute() {
        return url('/qurandb/sura/title/'.$this->id);
    }
}
