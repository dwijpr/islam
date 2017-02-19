@extends ('layout.bootstrap')

@section ('content')
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            @foreach ($surahs as $surah)
            <div>
                @foreach($surah->ayats as $ayat)
                <div class="ar">
                    {!! $ayat->are !!}
                </div>
                <audio controls>
                    <source
                        src="{{ url('/quran/audio/'.$ayat->audio) }}"
                        type="audio/mpeg"
                    >
                    Your browser does not support the audio element.
                </audio>
                <div>
                    {!! $ayat->idn !!}
                </div>
                @endforeach
            </div>
            @endforeach
        </div>
    </div>
</div>
@endsection
