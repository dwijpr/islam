@extends ('layout.bootstrap')

@push ('styles')
<style>
#sura-wrapper {
    border: 1px solid #eaeaea;
    border-bottom: none;
}
#sura-wrapper .sura {
    border-bottom: 1px solid #eaeaea;
    padding: 3px 9px;
}
#sura-wrapper .sura .sura-number {
    position: relative;
}
#sura-wrapper .sura .sura-number .frame {
    width: 100%;
}
#sura-wrapper .sura .sura-number .frame img {
    width: 48px;
}
#aya-wrapper .aya .aya-number .frame img {
    width: 56px;
}
#sura-wrapper .sura .sura-number .sura-number-value
, #aya-wrapper .aya .aya-number .aya-number-value {
    width: 100%;
    position: absolute;
    top: 14px;
    left: 0;
}
#aya-wrapper .aya .aya-number .aya-number-value {
    top: 23px;
}
</style>
@endpush

@push ('scripts')
@include ('qurandb.script')
@endpush

@section ('content')
<div style="display: none;">
    <span class="aya row">
        <div class="aya-number col-xs-3">
            <div class="frame text-center">
                <img src="{{ url(
                    "/quran/android/asset/drawable/box_nomor_ayah.png"
                ) }}">
            </div>
            <div class="aya-number-value text-center"></div>
        </div>
        <div class="aya-lang col-xs-9">
            <div class="ar aya-lang-ar"></div>
        </div>
    </span>
    <div class="sura">
        <div class="row sura-header">
            <div class="sura-number col-xs-3">
                <div class="frame text-center">
                    <img src="{{ url(
                        "/quran/android/asset/drawable/box_nomor_sura_juz.png"
                    ) }}">
                </div>
                <div class="sura-number-value text-center"></div>
            </div>
            <div class="sura-title col-xs-9">
                <div class="sura-title-real"></div>
                <div class="sura-title-arti"></div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-12" id="sura-wrapper"></div>
    </div>
    <div class="row">
        <div class="col-sm-12" id="aya-wrapper"></div>
    </div>
</div>
@endsection
