<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use App\Quran as QuranModel;
use stdClass, Storage;
use App\QuranSura;
use App\QuranDB\Sura as QuranDBSura;
use App\QuranDB\Aya as QuranDBAya;
use App\QuranDB\Word as QuranDBWord;

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
        $this->warn('disabled! check the code for execution...');
        return;
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
        $template =
            Storage::get('/template/quran-sura-ayat-data.json');
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
        $data = $this->data();
        $suras = $data['suras'];
        $ayas = $data['ayas'];
        $words = $data['words'];
        $headers = ['#', 'Title', 'Arti'];
        $this->table($headers, $suras);
        $headers = ['Sura ID', 'Aya ID', 'Ar', 'Id', 'En'];
        $this->table($headers, $ayas);
        $headers = ['Sura ID', 'Aya ID', 'Word ID', 'Ar', 'Id', 'En'];
        $this->table($headers, $words);
    }

    function sync() {
        $data = $this->data();
        $suras  = $data['suras'];
        $ayas   = $data['ayas'];
        $words  = $data['words'];
        foreach ($suras as $i => $sura) {
            $result = QuranDBSura::updateOrCreate($sura);
            $this->info($result);
        }
        foreach ($ayas as $i => $aya) {
            $result = QuranDBAya::updateOrCreate($aya);
            $this->info($result);
        }
        foreach ($words as $i => $word) {
            $result = QuranDBWord::updateOrCreate($word);
            $this->info($result);
        }
    }

    function sura($sura) {
        $directories = Storage::directories('quran');
        $match = preg_grep("/(".sprintf("%03d", $sura).").+$/", $directories);
        $directory = @array_values($match)[0];
        if ($directory) {
            $sura = new Sura($directory);
            return [
                'id' => $sura->_id,
                'title' => $sura->title,
                'arti' => $sura->arti,
            ];
        }
        $this->line('');
        $this->error('ERROR!!! no sura found!');
        dd();
    }

    function data() {
        $words = $ayas = $suras = [];
        $directories = Storage::directories('quran');
        foreach ($directories as $i => $directory) {
            if ($directory === 'quran/audio') {
                continue;
            }
            $sura = new Sura($directory);
            $suras[] = [
                'id' => $sura->_id,
                'title' => $sura->title,
                'arti' => $sura->arti,
            ];
            foreach ($sura->ayas as $aya) {
                if (@$aya->ar) {
                    $ayas[] = [
                        'sura_id' => $sura->_id,
                        'aya_id' => $aya->_id,
                        'lang_ar' => $aya->ar,
                        'lang_id' => $aya->id,
                        'lang_en' => $aya->en,
                    ];
                    if (@$aya->words) {
                        foreach ($aya->words as $word) {
                            if ($word->lang->ar) {
                                $words[] = [
                                    'sura_id' => $sura->_id,
                                    'aya_id' => $aya->_id,
                                    'word_id' => $word->_id,
                                    'lang_ar' => $word->lang->ar,
                                    'lang_id' => $word->lang->id,
                                    'lang_en' => $word->lang->en,
                                ];
                            }
                        }
                    }
                }
            }
        }
        return [
            'suras' => $suras,
            'ayas' => $ayas,
            'words' => $words,
        ];
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

class Word {
    public function __construct($sura, $aya, $word) {
        $this->_id = $word;
        $sura_dir_name = text_to_url(QuranSura::$NAMES[$sura]);
        $path =
            'quran/'.sprintf('%03d', $sura).'-'.$sura_dir_name
            .'/'.sprintf('%03d', $aya)
            .'/words/'.sprintf('%03d', $word)
        ;
        $this->lang = new stdClass;
        $this->lang->ar = 
            Storage::exists($path.'/ar.md')
            ?Storage::get($path.'/ar.md'):'';
        $this->lang->id =
            Storage::exists($path.'/id.md')
            ?Storage::get($path.'/id.md'):'';
        $this->lang->en =
            Storage::exists($path.'/en.md')
            ?Storage::get($path.'/en.md'):'';
    }
}

class Aya {

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
        for ($i=0; $i < $data->words->count; $i++) { 
            $word = new Word($sura, $aya, $i+1);
            $this->words[] = $word;
        }
    }
}

class Sura {
    var $progress = 0;

    static $sura_artis = false;
    static $sura_titles = false;
    static $resource_dir =
        'Al-QuranIndonesia_com.andi.alquran.id_source_from_JADX';
    
    public function __construct($input) {
        if (!self::$sura_artis) {
            $this->load();
        }
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
            $this->ayas[] = $aya;
        }
        $this->arti = self::$sura_artis[$this->_id-1];
        $this->title = self::$sura_titles[$this->_id-1];
    }

    function load() {
        $dataPath = self::$resource_dir.'/res/values/arrays.xml';
        $xml = simplexml_load_string(Storage::get($dataPath));

        $sura_artis = $xml->{"string-array"}[26];
        self::$sura_artis = [];
        foreach ($sura_artis as $i => $sura_arti) {
            self::$sura_artis[] = str_replace('"', '', strval($sura_arti));
        }

        $sura_titles = $xml->{"string-array"}[27];
        self::$sura_titles = [];
        foreach ($sura_titles as $i => $sura_title) {
            self::$sura_titles[] = str_replace('"', '', strval($sura_title));
        }
    }
}
