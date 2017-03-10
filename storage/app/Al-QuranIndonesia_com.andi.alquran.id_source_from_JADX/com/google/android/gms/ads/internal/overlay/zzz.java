package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rw;
import com.google.android.gms.internal.rw.C1981a;
import com.google.android.gms.internal.rw.C1982b;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.zzqa;
import java.util.concurrent.TimeUnit;

@op
public class zzz {
    private final Context f2488a;
    private final String f2489b;
    private final zzqa f2490c;
    private final im f2491d;
    private final io f2492e;
    private final rw f2493f;
    private final long[] f2494g;
    private final String[] f2495h;
    private boolean f2496i;
    private boolean f2497j;
    private boolean f2498k;
    private boolean f2499l;
    private boolean f2500m;
    private zzj f2501n;
    private boolean f2502o;
    private boolean f2503p;
    private long f2504q;

    public zzz(Context context, zzqa com_google_android_gms_internal_zzqa, String str, io ioVar, im imVar) {
        this.f2493f = new C1982b().m8645a("min_1", Double.MIN_VALUE, 1.0d).m8645a("1_5", 1.0d, 5.0d).m8645a("5_10", 5.0d, 10.0d).m8645a("10_20", 10.0d, 20.0d).m8645a("20_30", 20.0d, 30.0d).m8645a("30_max", 30.0d, Double.MAX_VALUE).m8646a();
        this.f2496i = false;
        this.f2497j = false;
        this.f2498k = false;
        this.f2499l = false;
        this.f2504q = -1;
        this.f2488a = context;
        this.f2490c = com_google_android_gms_internal_zzqa;
        this.f2489b = str;
        this.f2492e = ioVar;
        this.f2491d = imVar;
        String str2 = (String) C1648if.f4388z.m6682c();
        if (str2 == null) {
            this.f2495h = new String[0];
            this.f2494g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.f2495h = new String[split.length];
        this.f2494g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.f2494g[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                sg.m8447c("Unable to parse frame hash target time number.", e);
                this.f2494g[i] = -1;
            }
        }
    }

    private void m4006a() {
        if (this.f2498k && !this.f2499l) {
            ik.m6727a(this.f2492e, this.f2491d, "vff2");
            this.f2499l = true;
        }
        long c = zzv.zzcP().m4928c();
        if (this.f2500m && this.f2503p && this.f2504q != -1) {
            this.f2493f.m8649a(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (c - this.f2504q)));
        }
        this.f2503p = this.f2500m;
        this.f2504q = c;
    }

    private void m4007a(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        long longValue = ((Long) C1648if.f4337A.m6682c()).longValue();
        long currentPosition = (long) com_google_android_gms_ads_internal_overlay_zzj.getCurrentPosition();
        int i = 0;
        while (i < this.f2495h.length) {
            if (this.f2495h[i] == null && longValue > Math.abs(currentPosition - this.f2494g[i])) {
                this.f2495h[i] = m4008a((TextureView) com_google_android_gms_ads_internal_overlay_zzj);
                return;
            }
            i++;
        }
    }

    @TargetApi(14)
    String m4008a(TextureView textureView) {
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j = 0;
        long j2 = 63;
        int i = 0;
        while (i < 8) {
            long j3 = j;
            j = j2;
            for (int i2 = 0; i2 < 8; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                j3 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > NotificationCompat.FLAG_HIGH_PRIORITY ? 1 : 0) << ((int) j);
                j--;
            }
            i++;
            j2 = j;
            j = j3;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j)});
    }

    public void onStop() {
        if (((Boolean) C1648if.f4387y.m6682c()).booleanValue() && !this.f2502o) {
            String valueOf;
            String valueOf2;
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.f2489b);
            bundle.putString("player", this.f2501n.zzhd());
            for (C1981a c1981a : this.f2493f.m8648a()) {
                valueOf = String.valueOf("fps_c_");
                valueOf2 = String.valueOf(c1981a.f5784a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(c1981a.f5788e));
                valueOf = String.valueOf("fps_p_");
                valueOf2 = String.valueOf(c1981a.f5784a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Double.toString(c1981a.f5787d));
            }
            for (int i = 0; i < this.f2494g.length; i++) {
                valueOf2 = this.f2495h[i];
                if (valueOf2 != null) {
                    String valueOf3 = String.valueOf("fh_");
                    valueOf = String.valueOf(Long.valueOf(this.f2494g[i]));
                    bundle.putString(new StringBuilder((String.valueOf(valueOf3).length() + 0) + String.valueOf(valueOf).length()).append(valueOf3).append(valueOf).toString(), valueOf2);
                }
            }
            zzv.zzcJ().m8513a(this.f2488a, this.f2490c.f6636b, "gmob-apps", bundle, true);
            this.f2502o = true;
        }
    }

    public void zza(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        ik.m6727a(this.f2492e, this.f2491d, "vpc2");
        this.f2496i = true;
        if (this.f2492e != null) {
            this.f2492e.m6744a("vpn", com_google_android_gms_ads_internal_overlay_zzj.zzhd());
        }
        this.f2501n = com_google_android_gms_ads_internal_overlay_zzj;
    }

    public void zzb(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        m4006a();
        m4007a(com_google_android_gms_ads_internal_overlay_zzj);
    }

    public void zzhz() {
        if (this.f2496i && !this.f2497j) {
            ik.m6727a(this.f2492e, this.f2491d, "vfr2");
            this.f2497j = true;
        }
    }

    public void zzib() {
        this.f2500m = true;
        if (this.f2497j && !this.f2498k) {
            ik.m6727a(this.f2492e, this.f2491d, "vfp2");
            this.f2498k = true;
        }
    }

    public void zzic() {
        this.f2500m = false;
    }
}
