<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('/quran/progress', 'QuranController@progress');
Route::get('/quran', 'QuranController@index');
Route::get('/quran/audio/{key}', 'QuranController@audio');
Route::get('/quran/{surah}', 'QuranController@sura');
Route::get('/quran/{surah}/{ayat}', 'QuranController@ayat');

Route::get('/qurandb', 'QuranDBController@index');
Route::get('/qurandb/sura/title/{sura}', 'QuranDBController@suraTitle');
