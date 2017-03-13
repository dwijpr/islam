@extends ('layout.bootstrap')

@push ('styles')
<style>
#wrapper {
    border: 1px solid #eaeaea;
    border-bottom: none;
}
#wrapper .sura {
    border-bottom: 1px solid #eaeaea;
    padding: 3px 9px;
}
#wrapper .sura .sura-number {
    position: relative;
}
#wrapper .sura .sura-number .frame {
    width: 100%;
}
#wrapper .sura .sura-number .frame img {
    width: 48px;
}
#wrapper .sura .sura-number .sura-number-value {
    width: 100%;
    position: absolute;
    top: 14px;
    left: 0;
}
</style>
@endpush

@push ('scripts')
<script>
var quran = false;
$(function () {
    var template = $(".sura");
    var Sura = function (data) {
        if (data.aya_count) {
            var el = template.clone();
            el.find(".sura-number .sura-number-value").html(data.id);
            el.find(".sura-title .sura-title-real").html(data.title);
            el.find(".sura-title .sura-title-arti").html(data.arti);
            $("#wrapper").append(el);
        }
        this.getData = function () {
            return data;
        };
    };

    var Quran = function () {
        var surasData = {!! $suras->toJson() !!};
        var suras = [];
        surasData.forEach(function (sura) {
            suras.push(new Sura(sura));
        });
        this.getSuras = function () {
            return suras;
        };
    };

    quran = new Quran();
});
</script>
@endpush

@section ('content')
<div style="display: none;">
    <div class="sura row">
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
<div class="container">
    <div class="row">
        <div class="col-sm-12" id="wrapper">
        </div>
    </div>
</div>
@endsection
