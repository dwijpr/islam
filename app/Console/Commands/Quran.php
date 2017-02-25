<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use App\Quran as QuranModel;
use stdClass, Storage;

class Quran extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'quran:console';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'Command description';

    /**
     * Create a new command instance.
     *
     * @return void
     */
    public function __construct()
    {
        parent::__construct();
    }

    /**
     * Execute the console command.
     *
     * @return mixed
     */
    public function handle()
    {
        $this->info('Quran Console');
        $suras = QuranModel::getAllSura();
        $items = [];
        foreach ($suras as $i => $sura) {
            $item = new stdClass;
            $item->dir = sprintf('%03d', $sura->id).'-'.text_to_url($sura->name);
            $items[] = $item;
        }
        $this->comment('creating Quran directory...');
        $quran_path = 'quran';
        if (Storage::exists($quran_path)) {
            $this->warn('Warning!!! Deleting '.$quran_path.' directory');
            Storage::deleteDirectory($quran_path);
        }
        if (!Storage::makeDirectory($quran_path)) {
            $this->error('Failed to create Quran directory...');
        }
        foreach ($items as $i => $item) {
            if (!Storage::makeDirectory($quran_path.'/'.$item->dir)) {
                $this->error('Failed to create Quran directory...');
            } else {
                $this->line('creating directory '.$quran_path.'/'.$item->dir);
            }
        }
    }
}
