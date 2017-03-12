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

@push ('scripts')
<script>
$(function () {
    var Sura = function (data) {
        var el = $("<div>"+data.title+" ("+data.arti+")"+"</div>");
        $("#wrapper").append(el);
    };

    var Quran = function () {
        var surasData = {!! $suras->toJson() !!};
        var suras = [];
        surasData.forEach(function (sura) {
            suras.push(new Sura(sura));
        });
    };

    var quran = Quran();
});
</script>
@endpush

@section ('content')
<div class="container">
    <div class="row">
        <div class="col-sm-12"></div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div id="wrapper"></div>
        </div>
    </div>
</div>
@endsection
