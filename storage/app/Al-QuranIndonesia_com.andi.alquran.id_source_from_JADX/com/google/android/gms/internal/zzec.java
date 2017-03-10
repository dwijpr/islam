package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.zza;

@op
public class zzec extends zza {
    public static final Creator<zzec> CREATOR;
    public final int f6451a;
    public final String f6452b;
    public final int f6453c;
    public final int f6454d;
    public final boolean f6455e;
    public final int f6456f;
    public final int f6457g;
    public final zzec[] f6458h;
    public final boolean f6459i;
    public final boolean f6460j;
    public boolean f6461k;

    static {
        CREATOR = new gn();
    }

    public zzec() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    zzec(int i, String str, int i2, int i3, boolean z, int i4, int i5, zzec[] com_google_android_gms_internal_zzecArr, boolean z2, boolean z3, boolean z4) {
        this.f6451a = i;
        this.f6452b = str;
        this.f6453c = i2;
        this.f6454d = i3;
        this.f6455e = z;
        this.f6456f = i4;
        this.f6457g = i5;
        this.f6458h = com_google_android_gms_internal_zzecArr;
        this.f6459i = z2;
        this.f6460j = z3;
        this.f6461k = z4;
    }

    public zzec(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public zzec(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        AdSize adSize = adSizeArr[0];
        this.f6451a = 5;
        this.f6455e = false;
        this.f6460j = adSize.isFluid();
        if (this.f6460j) {
            this.f6456f = AdSize.BANNER.getWidth();
            this.f6453c = AdSize.BANNER.getHeight();
        } else {
            this.f6456f = adSize.getWidth();
            this.f6453c = adSize.getHeight();
        }
        boolean z = this.f6456f == -1;
        boolean z2 = this.f6453c == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (gr.m6416a().m8706c(context) && gr.m6416a().m8707d(context)) {
                this.f6457g = m9767a(displayMetrics) - gr.m6416a().m8708e(context);
            } else {
                this.f6457g = m9767a(displayMetrics);
            }
            double d = (double) (((float) this.f6457g) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.f6456f;
            this.f6457g = gr.m6416a().m8691a(displayMetrics, this.f6456f);
            i2 = i;
        }
        i = z2 ? m9771c(displayMetrics) : this.f6453c;
        this.f6454d = gr.m6416a().m8691a(displayMetrics, i);
        if (z || z2) {
            this.f6452b = i2 + "x" + i + "_as";
        } else if (this.f6460j) {
            this.f6452b = "320x50_mb";
        } else {
            this.f6452b = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.f6458h = new zzec[adSizeArr.length];
            for (int i3 = 0; i3 < adSizeArr.length; i3++) {
                this.f6458h[i3] = new zzec(context, adSizeArr[i3]);
            }
        } else {
            this.f6458h = null;
        }
        this.f6459i = false;
        this.f6461k = false;
    }

    public zzec(zzec com_google_android_gms_internal_zzec, zzec[] com_google_android_gms_internal_zzecArr) {
        this(5, com_google_android_gms_internal_zzec.f6452b, com_google_android_gms_internal_zzec.f6453c, com_google_android_gms_internal_zzec.f6454d, com_google_android_gms_internal_zzec.f6455e, com_google_android_gms_internal_zzec.f6456f, com_google_android_gms_internal_zzec.f6457g, com_google_android_gms_internal_zzecArr, com_google_android_gms_internal_zzec.f6459i, com_google_android_gms_internal_zzec.f6460j, com_google_android_gms_internal_zzec.f6461k);
    }

    public static int m9767a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static zzec m9768a() {
        return new zzec(5, "reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static zzec m9769a(Context context) {
        return new zzec(5, "320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static int m9770b(DisplayMetrics displayMetrics) {
        return (int) (((float) m9771c(displayMetrics)) * displayMetrics.density);
    }

    private static int m9771c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public void m9772a(boolean z) {
        this.f6461k = z;
    }

    public AdSize m9773b() {
        return com.google.android.gms.ads.zza.zza(this.f6456f, this.f6453c, this.f6452b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        gn.m6344a(this, parcel, i);
    }
}
