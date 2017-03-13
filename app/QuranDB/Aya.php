<?php

namespace App\QuranDB;

use Illuminate\Database\Eloquent\Model;

class Aya extends Model
{
    protected $primaryKey = ['sura_id', 'aya_id'];
    
    protected $fillable = [
        'sura_id', 'aya_id', 'lang_ar', 'lang_id', 'lang_en',
    ];

    public $incrementing = false;

    public function words() {
        return $this->hasMany(Word::class);
    }
}
