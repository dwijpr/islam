<style>
@font-face {
    font-family: me_quran;
    src: url('{{ asset('/font/me_quran.ttf') }}');
}

.quran {
    font-family: me_quran;
    font-size: 48px;
    text-align: right;
}

</style>

<h1>
    <a href="{{ url('/') }}">Home</a>
    >
    Quran
</h1>
@foreach ($surahs as $surah)
<div>
    @foreach($surah->ayats as $ayat)
    <div class="quran">
        {!! $ayat->are !!}
    </div>
    <div>
        {!! $ayat->idn !!}
    </div>
    @endforeach
</div>
@endforeach
