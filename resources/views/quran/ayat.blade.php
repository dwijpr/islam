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
            <div class="ayat">
                <div class="ar">
                    {{ $ayat->ar }}
                </div>
                <div>
                    {{ $ayat->id }}
                </div>
                <div>
                    {{ $ayat->en }}
                </div>
                <hr>
                <audio controls>
                    <source
                        src="{{ url('/quran/audio/'.$ayat->audio) }}"
                        type="audio/mpeg"
                    >
                    Your browser does not support the audio element.
                </audio>
            </div>
        </div>
    </div>
</div>
@endsection
