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
            @foreach ($surahs as $surah)
            <div class="ayat">
                @foreach ($surah->ayats as $ayat)
                    <div class="ayat-sentence">
                        @foreach ($ayat->are as $i => $word)
                        <div class="arabic-word pull-right">
                            <div class="ar">
                                {!! $word !!}
                            </div>
                            <div>
                                {!! $ayat->idn[$i] !!}
                            </div>
                            <div>
                                {!! $ayat->int[$i] !!}
                            </div>
                        </div>
                        @endforeach
                    </div>
                    <div>
                        {!! $ayat->idn_sentence !!}
                    </div>
                    <div>
                        {!! $ayat->int_sentence !!}
                    </div>
                    <hr>
                    <audio controls>
                        <source
                            src="{{ url('/quran/audio/'.$ayat->audio) }}"
                            type="audio/mpeg"
                        >
                        Your browser does not support the audio element.
                    </audio>
                @endforeach
            </div>
            @endforeach
        </div>
    </div>
</div>
@endsection
