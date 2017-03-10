package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;

@op
public final class zzmk extends zza {
    public static final Creator<zzmk> CREATOR;
    public final boolean f6566A;
    public final boolean f6567B;
    public final zzok f6568C;
    public final List<String> f6569D;
    public final List<String> f6570E;
    public final boolean f6571F;
    public final zzmm f6572G;
    public final boolean f6573H;
    public String f6574I;
    public final List<String> f6575J;
    public final boolean f6576K;
    public final String f6577L;
    public final zzon f6578M;
    public final String f6579N;
    public final boolean f6580O;
    private zzmh f6581P;
    public final int f6582a;
    public final String f6583b;
    public String f6584c;
    public final List<String> f6585d;
    public final int f6586e;
    public final List<String> f6587f;
    public final long f6588g;
    public final boolean f6589h;
    public final long f6590i;
    public final List<String> f6591j;
    public final long f6592k;
    public final int f6593l;
    public final String f6594m;
    public final long f6595n;
    public final String f6596o;
    public final boolean f6597p;
    public final String f6598q;
    public final String f6599r;
    public final boolean f6600s;
    public final boolean f6601t;
    public final boolean f6602u;
    public final boolean f6603v;
    public final boolean f6604w;
    public zzms f6605x;
    public String f6606y;
    public final String f6607z;

    static {
        CREATOR = new ox();
    }

    public zzmk(int i) {
        this(18, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true);
    }

    public zzmk(int i, long j) {
        this(18, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true);
    }

    zzmk(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, zzms com_google_android_gms_internal_zzms, String str7, String str8, boolean z8, boolean z9, zzok com_google_android_gms_internal_zzok, List<String> list4, List<String> list5, boolean z10, zzmm com_google_android_gms_internal_zzmm, boolean z11, String str9, List<String> list6, boolean z12, String str10, zzon com_google_android_gms_internal_zzon, String str11, boolean z13) {
        this.f6582a = i;
        this.f6583b = str;
        this.f6584c = str2;
        this.f6585d = list != null ? Collections.unmodifiableList(list) : null;
        this.f6586e = i2;
        this.f6587f = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f6588g = j;
        this.f6589h = z;
        this.f6590i = j2;
        this.f6591j = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f6592k = j3;
        this.f6593l = i3;
        this.f6594m = str3;
        this.f6595n = j4;
        this.f6596o = str4;
        this.f6597p = z2;
        this.f6598q = str5;
        this.f6599r = str6;
        this.f6600s = z3;
        this.f6601t = z4;
        this.f6602u = z5;
        this.f6603v = z6;
        this.f6580O = z13;
        this.f6604w = z7;
        this.f6605x = com_google_android_gms_internal_zzms;
        this.f6606y = str7;
        this.f6607z = str8;
        if (this.f6584c == null && this.f6605x != null) {
            zzmv com_google_android_gms_internal_zzmv = (zzmv) this.f6605x.m9777a(zzmv.CREATOR);
            if (!(com_google_android_gms_internal_zzmv == null || TextUtils.isEmpty(com_google_android_gms_internal_zzmv.m9778a()))) {
                this.f6584c = com_google_android_gms_internal_zzmv.m9778a();
            }
        }
        this.f6566A = z8;
        this.f6567B = z9;
        this.f6568C = com_google_android_gms_internal_zzok;
        this.f6569D = list4;
        this.f6570E = list5;
        this.f6571F = z10;
        this.f6572G = com_google_android_gms_internal_zzmm;
        this.f6573H = z11;
        this.f6574I = str9;
        this.f6575J = list6;
        this.f6576K = z12;
        this.f6577L = str10;
        this.f6578M = com_google_android_gms_internal_zzon;
        this.f6579N = str11;
    }

    public zzmk(zzmh com_google_android_gms_internal_zzmh, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, zzok com_google_android_gms_internal_zzok, List<String> list4, List<String> list5, boolean z9, zzmm com_google_android_gms_internal_zzmm, boolean z10, String str7, List<String> list6, boolean z11, String str8, zzon com_google_android_gms_internal_zzon, String str9, boolean z12) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, null, null, str6, z7, z8, com_google_android_gms_internal_zzok, list4, list5, z9, com_google_android_gms_internal_zzmm, z10, str7, list6, z11, str8, com_google_android_gms_internal_zzon, str9, z12);
        this.f6581P = com_google_android_gms_internal_zzmh;
    }

    public zzmk(zzmh com_google_android_gms_internal_zzmh, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzok com_google_android_gms_internal_zzok, List<String> list4, List<String> list5, boolean z10, zzmm com_google_android_gms_internal_zzmm, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzon com_google_android_gms_internal_zzon, String str10, boolean z13) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, com_google_android_gms_internal_zzok, list4, list5, z10, com_google_android_gms_internal_zzmm, z11, str8, list6, z12, str9, com_google_android_gms_internal_zzon, str10, z13);
        this.f6581P = com_google_android_gms_internal_zzmh;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (!(this.f6581P == null || this.f6581P.f6540a < 9 || TextUtils.isEmpty(this.f6584c))) {
            this.f6605x = new zzms(new zzmv(this.f6584c));
            this.f6584c = null;
        }
        ox.m7987a(this, parcel, i);
    }
}
