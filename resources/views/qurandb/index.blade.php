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
#wrapper .aya .aya-number .frame img {
    width: 56px;
}
#wrapper .sura .sura-number .sura-number-value
, #wrapper .aya .aya-number .aya-number-value {
    width: 100%;
    position: absolute;
    top: 14px;
    left: 0;
}
#wrapper .aya .aya-number .aya-number-value {
    top: 23px;
}
</style>
@endpush

@push ('scripts')
<script>
var quran = false;
$(function () {
    var suraTemplate = $(".sura");
    var ayaTemplate = $(".aya");

    var Aya = function (data) {
        var self = this;
        var el = ayaTemplate.clone();
        el.find(".aya-number .aya-number-value").html(data.aya_id);
        el.find(".aya-lang .aya-lang-ar").html(data.lang_ar);
        this.view = function () {
            return el;
        }
        return self;
    }

    var Sura = function (data) {
        var self = this;
        var ayas = [];
        this.add = function (aya) {
            el.find('.sura-ayas').append(aya.view());
        }
        if (data.aya_count) {
            var el = suraTemplate.clone();
            el.find(".sura-number .sura-number-value").html(data.id);
            el.find(".sura-title .sura-title-real").html(data.title);
            el.find(".sura-title .sura-title-arti").html(data.arti);
            for (var i = 0; i < data.aya_count; i++) {
                var aya = new Aya(data.ayas[i]);
                self.add(aya);
            }
            $("#wrapper").append(el);
        }
        return self;
    };

    var Quran = function () {
        var self = this;
        var surasData = {!! $suras->toJson() !!};
        var suras = [];
        surasData.forEach(function (sura) {
            suras.push(new Sura(sura));
        });
        this.getSuras = function () {
            return suras;
        };
        return self;
    };

    quran = new Quran();
});
</script>
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
        <div class="row">
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
        <div class="row">
            <div class="col-sm-12 sura-ayas">
            </div>
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
