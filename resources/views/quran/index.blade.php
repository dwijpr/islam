@extends ('layout.bootstrap')

@push ('styles')
<style>
.arabic-word {
    display: inline-block;
    padding-left: 15px;
}

.arabic-word:hover {
    color: green;
}

.ayat {
    border: 1px solid #efefef;
    padding: 19px;
}

.ayat .ayat-sentence {
    overflow: auto;
}
</style>
@endpush

@section ('content')
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="row">
                @foreach ($surahs as $surah)
                    <div class="col-md-2 col-sm-4 col-xs-6">
                        {{ Html::link(
                            '/quran/'.$surah->quranSura->id
                            , $surah->quranSura->name
                            , [
                                'style' =>
                                    'opacity: '.($surah->progress/100).';',
                            ]
                        ) }}
                    </div>
                @endforeach
            </div>
        </div>
    </div>
</div>
@endsection
