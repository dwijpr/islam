<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use App\Quran as QuranModel;
use stdClass, Storage;
use App\QuranSura;

class Quran extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'quran:console {type?}';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'Quran Console ---';

    /**
     * Create a new command instance.
     *
     * @return void
     */
    public function __construct()
    {
        parent::__construct();
    }

    function build() {
        $suras = QuranModel::getAllSura();
        $items = [];
        foreach ($suras as $i => $sura) {
            $item = new stdClass;
            $item->dir = 
                sprintf('%03d', $sura->id).'-'.text_to_url($sura->name);
            $item->count = count($sura->ayas);
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
        $template =
            Storage::get('/template/quran-sura-aya-data.json');
        foreach ($items as $i => $item) {
            $item_directory = $quran_path.'/'.$item->dir;
            if (!Storage::makeDirectory($item_directory)) {
                $this->error('Failed to create Quran directory...');
            } else {
                $this->line('creating directory '.$item_directory);
                $success_directory_creation_count = 0;
                for ($_i=1; $_i <= $item->count ; $_i++) { 
                    $aya_directory = $item_directory.'/'.sprintf('%03d', $_i);
                    Storage::makeDirectory($aya_directory);
                    Storage::put($aya_directory.'/ar.md', '');
                    Storage::put($aya_directory.'/id.md', '');
                    Storage::put($aya_directory.'/en.md', '');
                    Storage::put($aya_directory.'/data.json', $template);
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

    function show() {
        $suras = [];
        $directories = Storage::directories('quran');
        foreach ($directories as $i => $directory) {
            if ($directory === 'quran/audio') {
                continue;
            }
            $sura = new Sura($directory);
            if ($sura->progress) {
                $suras[] = $sura;
            }
        }
        foreach ($suras as $i => $sura) {
            foreach ($sura->ayas as $_i => $aya) {
                if (!$aya->progress) {
                    unset($suras[$i]->ayas[$_i]);
                }
            }
        }
        dd($suras);
    }

    /**
     * Execute the console command.
     *
     * @return mixed
     */
    public function handle()
    {
        $this->error('---------------------------------------');
        $this->error('            Quran Console              ');
        $this->error('---------------------------------------');
        $typeCmd = $this->argument('type');
        $availableTypeCmd = [
            'build', 'show', 'sync',
        ];
        if (!$typeCmd or !in_array($typeCmd, $availableTypeCmd)) {
            $this->line('type command:');
            foreach ($availableTypeCmd as $i => $cmd) {
                $this->info(($i+1).'. '.$cmd);
            }
        } else {
            $this->{$typeCmd}();
        }
    }
}

class Aya {
    var $progress = 0;

    public function __construct($sura, $aya) {
        $this->_id = $aya;
        $sura_dir_name = text_to_url(QuranSura::$NAMES[$sura]);
        $path =
            'quran/'.sprintf('%03d', $sura).'-'.$sura_dir_name
            .'/'.sprintf('%03d', $aya);
        $this->ar = Storage::get($path.'/ar.md');
        $this->id = Storage::get($path.'/id.md');
        $this->en = Storage::get($path.'/en.md');
        $word_directories = Storage::directories($path.'/words');
        $data = json_decode(Storage::get($path.'/data.json'));
        $this->audio = sprintf('%03d', $sura).sprintf('%03d', $aya);
        if (!Storage::exists('/quran/audio/'.$this->audio.'.mp3')) {
            $this->audio = false;
        }
        if ($this->ar) {
            $this->progress += 25;
            if ($this->id) {
                $this->progress += 15;
            }
            if ($this->en) {
                $this->progress += 10;
            }
            if ($this->audio) {
                $this->progress += 5;
            }
        }
        if ($data->words->count) {
            $this->progress += 1;
            $per_word_progress = 44/$data->words->count;
        }
        $marks = [
            'ۖ', 'ؕ', 'ۙ', 'ۚ',
        ];
        foreach ($marks as $i => $mark) {
            $view = view('partial.quran-mark-span', [
                'mark' => $mark,
            ])->render();
            $this->ar = str_replace($mark, $view, $this->ar);
        }
        foreach ($word_directories as $i => $directory) {
            if (@$per_word_progress) {
                if (Storage::exists($directory.'/ar.md')) {
                    $this->progress += $per_word_progress/2;
                    if (Storage::exists($directory.'/id.md')) {
                        $this->progress += $per_word_progress/3;
                    }
                    if (Storage::exists($directory.'/en.md')) {
                        $this->progress += $per_word_progress/6;
                    }
                }
            }
            $word = 
                Storage::exists($directory.'/ar.md')
                ?Storage::get($directory.'/ar.md'):'';
            $word_id =
                Storage::exists($directory.'/id.md')
                ?Storage::get($directory.'/id.md'):'';
            $word_en =
                Storage::exists($directory.'/en.md')
                ?Storage::get($directory.'/en.md'):'';
            $this->words[] = $word;
            $view = view('partial.quran-word-span', [
                'word' => $word,
                'trans' => $word_id.' | '.$word_en,
            ])->render();
            $this->ar = preg_replace(
                '/'.$word.'/'
                , $view
                , $this->ar, 1
            );
        }
    }
}

class Sura {
    var $progress = 0;
    
    public function __construct($input) {
        $this->identifier = str_replace('quran/', '', $input);
        preg_match('/(\d{3})-.+$/', $input, $match);
        $this->id = $match[1];
        $this->_id = intval($this->id);
        $this->quranSura = new QuranSura(intval($this->id));
        $this->ayas = [];
        $directories = Storage::directories('quran/'.$this->identifier);
        foreach ($directories as $i => $directory) {
            preg_match('/quran\/'.$this->id.'.*\/(\d+)/', $directory, $match);
            $id = $match[1];
            $aya = new Aya(intval($this->id), intval($id));
            $this->progress += $aya->progress;
            $this->ayas[] = $aya;
        }
        $this->progress = ($this->progress/$this->quranSura->count);
    }
}
