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
                @if ($ayat->progress !== 100)
                    <h1 style="opacity: {{
                        !$ayat->progress?1:((100-$ayat->progress)/100)
                    }};">
                        {{ $ayat->progress.' %' }}
                    </h1>
                @endif
                <div class="ar">
                    {!! $ayat->ar !!}
                </div>
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
