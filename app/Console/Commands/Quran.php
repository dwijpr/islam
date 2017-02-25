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
            $item->dir = 
                sprintf('%03d', $sura->id).'-'.text_to_url($sura->name);
            $item->count = count($sura->ayats);
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
            $item_directory = $quran_path.'/'.$item->dir;
            if (!Storage::makeDirectory($item_directory)) {
                $this->error('Failed to create Quran directory...');
            } else {
                $this->line('creating directory '.$item_directory);
                $success_directory_creation_count = 0;
                for ($_i=1; $_i <= $item->count ; $_i++) { 
                    $ayat_directory = $item_directory.'/'.sprintf('%03d', $_i);
                    Storage::makeDirectory($ayat_directory);
                    Storage::put($ayat_directory.'/ar.md', '');
                    Storage::put($ayat_directory.'/id.md', '');
                    Storage::put($ayat_directory.'/en.md', '');
                    $success_directory_creation_count++;
                }
                if ($success_directory_creation_count == $item->count) {
                    $this->info(
                        'all '.$item->count.' directories created successfully!'
                    );
                } else {
                    $this->error(
                        'directories created: '
                        .$success_directory_creation_count
                        .' ... but should create '.$item->count.' directories'
                    );
                }
            }
        }
    }
}
