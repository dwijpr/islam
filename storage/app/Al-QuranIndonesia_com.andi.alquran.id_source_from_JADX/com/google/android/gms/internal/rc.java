package com.google.android.gms.internal;

import com.google.android.gms.internal.jd.C1660a;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@op
public class rc {
    public final long f5602A;
    public final long f5603B;
    public final String f5604C;
    public final String f5605D;
    public final C1660a f5606E;
    public boolean f5607F;
    public boolean f5608G;
    public boolean f5609H;
    public final List<String> f5610I;
    public final zzdy f5611a;
    public final sx f5612b;
    public final List<String> f5613c;
    public final int f5614d;
    public final List<String> f5615e;
    public final List<String> f5616f;
    public final int f5617g;
    public final long f5618h;
    public final String f5619i;
    public final JSONObject f5620j;
    public final boolean f5621k;
    public final zzmm f5622l;
    public boolean f5623m;
    public final boolean f5624n;
    public final lt f5625o;
    public final me f5626p;
    public final String f5627q;
    public final lu f5628r;
    public final lw f5629s;
    public final long f5630t;
    public final String f5631u;
    public final zzec f5632v;
    public final long f5633w;
    public final zzok f5634x;
    public final List<String> f5635y;
    public final List<String> f5636z;

    @op
    /* renamed from: com.google.android.gms.internal.rc.a */
    public static final class C1938a {
        public final zzmh f5594a;
        public final zzmk f5595b;
        public final lu f5596c;
        public final zzec f5597d;
        public final int f5598e;
        public final long f5599f;
        public final long f5600g;
        public final JSONObject f5601h;

        public C1938a(zzmh com_google_android_gms_internal_zzmh, zzmk com_google_android_gms_internal_zzmk, lu luVar, zzec com_google_android_gms_internal_zzec, int i, long j, long j2, JSONObject jSONObject) {
            this.f5594a = com_google_android_gms_internal_zzmh;
            this.f5595b = com_google_android_gms_internal_zzmk;
            this.f5596c = luVar;
            this.f5597d = com_google_android_gms_internal_zzec;
            this.f5598e = i;
            this.f5599f = j;
            this.f5600g = j2;
            this.f5601h = jSONObject;
        }
    }

    public rc(C1938a c1938a, sx sxVar, lt ltVar, me meVar, String str, lw lwVar, C1660a c1660a, String str2) {
        sx sxVar2 = sxVar;
        lt ltVar2 = ltVar;
        me meVar2 = meVar;
        String str3 = str;
        lw lwVar2 = lwVar;
        C1660a c1660a2 = c1660a;
        String str4 = str2;
        this(c1938a.f5594a.f6542c, sxVar2, c1938a.f5595b.f6585d, c1938a.f5598e, c1938a.f5595b.f6587f, c1938a.f5595b.f6591j, c1938a.f5595b.f6593l, c1938a.f5595b.f6592k, c1938a.f5594a.f6548i, c1938a.f5595b.f6589h, ltVar2, meVar2, str3, c1938a.f5596c, lwVar2, c1938a.f5595b.f6590i, c1938a.f5597d, c1938a.f5595b.f6588g, c1938a.f5599f, c1938a.f5600g, c1938a.f5595b.f6596o, c1938a.f5601h, c1660a2, c1938a.f5595b.f6568C, c1938a.f5595b.f6569D, c1938a.f5595b.f6569D, c1938a.f5595b.f6571F, c1938a.f5595b.f6572G, str4, c1938a.f5595b.f6575J, c1938a.f5595b.f6579N);
    }

    public rc(zzdy com_google_android_gms_internal_zzdy, sx sxVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, lt ltVar, me meVar, String str2, lu luVar, lw lwVar, long j2, zzec com_google_android_gms_internal_zzec, long j3, long j4, long j5, String str3, JSONObject jSONObject, C1660a c1660a, zzok com_google_android_gms_internal_zzok, List<String> list4, List<String> list5, boolean z2, zzmm com_google_android_gms_internal_zzmm, String str4, List<String> list6, String str5) {
        this.f5607F = false;
        this.f5608G = false;
        this.f5609H = false;
        this.f5611a = com_google_android_gms_internal_zzdy;
        this.f5612b = sxVar;
        this.f5613c = m8363a(list);
        this.f5614d = i;
        this.f5615e = m8363a(list2);
        this.f5616f = m8363a(list3);
        this.f5617g = i2;
        this.f5618h = j;
        this.f5619i = str;
        this.f5624n = z;
        this.f5625o = ltVar;
        this.f5626p = meVar;
        this.f5627q = str2;
        this.f5628r = luVar;
        this.f5629s = lwVar;
        this.f5630t = j2;
        this.f5632v = com_google_android_gms_internal_zzec;
        this.f5633w = j3;
        this.f5602A = j4;
        this.f5603B = j5;
        this.f5604C = str3;
        this.f5620j = jSONObject;
        this.f5606E = c1660a;
        this.f5634x = com_google_android_gms_internal_zzok;
        this.f5635y = m8363a(list4);
        this.f5636z = m8363a(list5);
        this.f5621k = z2;
        this.f5622l = com_google_android_gms_internal_zzmm;
        this.f5631u = str4;
        this.f5610I = m8363a(list6);
        this.f5605D = str5;
    }

    private static <T> List<T> m8363a(List<T> list) {
        return list == null ? null : Collections.unmodifiableList(list);
    }

    public boolean m8364a() {
        return (this.f5612b == null || this.f5612b.m8776l() == null) ? false : this.f5612b.m8776l().m8816b();
    }
}
