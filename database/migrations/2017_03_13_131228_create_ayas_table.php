<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateAyasTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ayas', function (Blueprint $table) {
            $table->integer('sura_id')->unsigned()->index();
            $table->integer('aya_id')->unsigned()->index();
            $table->text('lang_ar');
            $table->text('lang_id');
            $table->text('lang_en');
            $table->timestamps();
            $table->primary(['sura_id', 'aya_id']);
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ayas');
    }
}
