<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateWordsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('words', function (Blueprint $table) {
            $table->integer('sura_id')->unsigned()->index();
            $table->integer('aya_id')->unsigned()->index();
            $table->integer('word_id')->unsigned()->index();
            $table->text('lang_ar');
            $table->text('lang_id');
            $table->text('lang_en');
            $table->timestamps();
            $table->primary(['sura_id', 'aya_id', 'word_id']);
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('words');
    }
}
