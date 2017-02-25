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

.sura {
    border: 1px solid #efefef;
    margin-bottom: 16px;
    padding: 9px;
}

.ayat {
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
            @foreach ($suras as $sura)
            <div class="sura">
                <h2 class="text-center">
                    {{ $sura->name }}
                </h2>
                @foreach ($sura->ayats as $ayat)
                <div class="ayat">
                    <div class="ar">
                        {{ $ayat->AyahText }}
                    </div>
                </div>
                @endforeach
            </div>
            @endforeach
        </div>
    </div>
</div>
@endsection
