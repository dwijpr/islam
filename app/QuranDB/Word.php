<?php

namespace App\QuranDB;

use Illuminate\Database\Eloquent\Model;

class Word extends Model
{
    protected $primaryKey = ['sura_id', 'aya_id', 'word_id'];
    
    protected $fillable = [
        'sura_id', 'aya_id', 'word_id', 'lang_ar', 'lang_id', 'lang_en',
    ];

    public $incrementing = false;
}
