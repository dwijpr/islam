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
        $("#aya-wrapper").append(el);
        return self;
    }

    var Sura = function (quran, data) {
        var self = this;
        var ayas = [];
        this.add = function (aya) {
            ayas.push(aya);
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
            $("#sura-wrapper").append(el);
            el.click(function () {
                var suraContent = $(el.find('.sura-ayas').parents('.row')[0]);
                suraContent.toggle();
                quran.hide();
            });
        }
        return self;
    };

    var Quran = function () {
        var self = this;
        var surasData = {!! $suras->toJson() !!};
        var suras = [];
        surasData.forEach(function (sura) {
            suras.push(new Sura(self, sura));
        });
        this.getSuras = function () {
            return suras;
        };
        this.hide = function () {
            $("#sura-wrapper").hide();
            $("#aya-wrapper").show();
        };
        return self;
    };

    quran = new Quran();
});
</script>
