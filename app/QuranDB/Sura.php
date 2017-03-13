<?php

namespace App\QuranDB;

use Illuminate\Database\Eloquent\Model;

class Sura extends Model
{
    protected $fillable = [
        'id', 'title', 'arti',
    ];
    protected $appends = [
        'image_title', 'aya_count',
    ];

    public function getAyaCountAttribute() {
        return $this->ayas()->count();
    }

    public function getImageTitleAttribute() {
        return url('/qurandb/sura/title/'.$this->id);
    }

    public function ayas() {
        return $this->hasMany(Aya::class);
    }
}
