@extends ('layout.bootstrap')

@push ('styles')
<style>
.ar-word {
    padding-left: 9px;
}

.ar-word:hover {
    color: green;
}

.ayat {
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
            <h1 class="text-center">{{ $sura->quranSura->name }}</h1>
            @if ($sura->progress !== 100)
                <h1 class="text-center" style="opacity: {{
                    !$sura->progress?1:((100-$sura->progress)/100)
                }};">
                    {{ $sura->progress.' %' }}
                </h1>
            @endif
            <hr>
            @foreach ($sura->ayats as $ayat)
                <?php
                    if ($ayat->progress < 1) {
                        continue;
                    }
                ?>
                <div
                    class="ayat"
                    style="opacity: {{ $ayat->progress/100 }};"
                >
                    <div class="ar">
                        {!! $ayat->ar !!}
                    </div>
                    <br>
                    {{ Html::link(
                        '/quran/'.$sura->_id.'/'.$ayat->_id
                        , $sura->_id.':'.$ayat->_id
                    ) }}
                    <br>
                    <div>
                        {{ $ayat->id }}
                    </div>
                    <br>
                    <div>
                        {{ $ayat->en }}
                    </div>
                    <hr>
                    @if ($ayat->audio)
                        <audio controls>
                            <source
                                src="{{ url('/quran/audio/'.$ayat->audio) }}"
                                type="audio/mpeg"
                            >
                            Your browser does not support the audio element.
                        </audio>
                    @endif
                </div>
            @endforeach
        </div>
    </div>
</div>
@endsection

@push ('scripts')
<script>
$(function () {
    $('[data-toggle="tooltip"]').tooltip();
});
</script>
@endpush
