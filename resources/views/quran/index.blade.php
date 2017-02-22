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
                    <div class="ar">
                        {{ $ayat->are }}
                    </div>
                    <div>
                        {{ $ayat->idn }}
                    </div>
                    <div>
                        {{ $ayat->int }}
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
