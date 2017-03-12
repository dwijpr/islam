<?php

namespace App\QuranDB;

use Illuminate\Database\Eloquent\Model;

class Sura extends Model
{
    protected $fillable = [
        'id', 'title', 'arti',
    ];
}
