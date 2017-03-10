package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;

@op
public final class zzmh extends zza {
    public static final Creator<zzmh> CREATOR;
    public final List<String> f6524A;
    public final long f6525B;
    public final zzmo f6526C;
    public final String f6527D;
    public final float f6528E;
    public final int f6529F;
    public final int f6530G;
    public final boolean f6531H;
    public final boolean f6532I;
    public final String f6533J;
    public final boolean f6534K;
    public final String f6535L;
    public final boolean f6536M;
    public final int f6537N;
    public final Bundle f6538O;
    public final String f6539P;
    public final int f6540a;
    public final Bundle f6541b;
    public final zzdy f6542c;
    public final zzec f6543d;
    public final String f6544e;
    public final ApplicationInfo f6545f;
    public final PackageInfo f6546g;
    public final String f6547h;
    public final String f6548i;
    public final String f6549j;
    public final zzqa f6550k;
    public final Bundle f6551l;
    public final int f6552m;
    public final List<String> f6553n;
    public final Bundle f6554o;
    public final boolean f6555p;
    public final Messenger f6556q;
    public final int f6557r;
    public final int f6558s;
    public final float f6559t;
    public final String f6560u;
    public final long f6561v;
    public final String f6562w;
    public final List<String> f6563x;
    public final String f6564y;
    public final zzgw f6565z;

    @op
    /* renamed from: com.google.android.gms.internal.zzmh.a */
    public static final class C2082a {
        public final String f6485A;
        public final float f6486B;
        public final boolean f6487C;
        public final int f6488D;
        public final int f6489E;
        public final boolean f6490F;
        public final boolean f6491G;
        public final String f6492H;
        public final String f6493I;
        public final boolean f6494J;
        public final int f6495K;
        public final Bundle f6496L;
        public final String f6497M;
        public final Bundle f6498a;
        public final zzdy f6499b;
        public final zzec f6500c;
        public final String f6501d;
        public final ApplicationInfo f6502e;
        public final PackageInfo f6503f;
        public final String f6504g;
        public final String f6505h;
        public final Bundle f6506i;
        public final zzqa f6507j;
        public final int f6508k;
        public final List<String> f6509l;
        public final List<String> f6510m;
        public final Bundle f6511n;
        public final boolean f6512o;
        public final Messenger f6513p;
        public final int f6514q;
        public final int f6515r;
        public final float f6516s;
        public final String f6517t;
        public final long f6518u;
        public final String f6519v;
        public final List<String> f6520w;
        public final String f6521x;
        public final zzgw f6522y;
        public final zzmo f6523z;

        public C2082a(Bundle bundle, zzdy com_google_android_gms_internal_zzdy, zzec com_google_android_gms_internal_zzec, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, zzqa com_google_android_gms_internal_zzqa, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, List<String> list3, String str6, zzgw com_google_android_gms_internal_zzgw, zzmo com_google_android_gms_internal_zzmo, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, boolean z5, int i5, Bundle bundle4, String str10) {
            this.f6498a = bundle;
            this.f6499b = com_google_android_gms_internal_zzdy;
            this.f6500c = com_google_android_gms_internal_zzec;
            this.f6501d = str;
            this.f6502e = applicationInfo;
            this.f6503f = packageInfo;
            this.f6504g = str2;
            this.f6505h = str3;
            this.f6507j = com_google_android_gms_internal_zzqa;
            this.f6506i = bundle2;
            this.f6512o = z;
            this.f6513p = messenger;
            this.f6514q = i;
            this.f6515r = i2;
            this.f6516s = f;
            if (list == null || list.size() <= 0) {
                this.f6508k = 0;
                this.f6509l = null;
                this.f6510m = null;
            } else {
                this.f6508k = 3;
                this.f6509l = list;
                this.f6510m = list2;
            }
            this.f6511n = bundle3;
            this.f6517t = str4;
            this.f6518u = j;
            this.f6519v = str5;
            this.f6520w = list3;
            this.f6521x = str6;
            this.f6522y = com_google_android_gms_internal_zzgw;
            this.f6523z = com_google_android_gms_internal_zzmo;
            this.f6485A = str7;
            this.f6486B = f2;
            this.f6487C = z2;
            this.f6488D = i3;
            this.f6489E = i4;
            this.f6490F = z3;
            this.f6491G = z4;
            this.f6492H = str8;
            this.f6493I = str9;
            this.f6494J = z5;
            this.f6495K = i5;
            this.f6496L = bundle4;
            this.f6497M = str10;
        }
    }

    static {
        CREATOR = new ov();
    }

    zzmh(int i, Bundle bundle, zzdy com_google_android_gms_internal_zzdy, zzec com_google_android_gms_internal_zzec, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzqa com_google_android_gms_internal_zzqa, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, zzgw com_google_android_gms_internal_zzgw, List<String> list3, long j2, zzmo com_google_android_gms_internal_zzmo, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4, String str11) {
        this.f6540a = i;
        this.f6541b = bundle;
        this.f6542c = com_google_android_gms_internal_zzdy;
        this.f6543d = com_google_android_gms_internal_zzec;
        this.f6544e = str;
        this.f6545f = applicationInfo;
        this.f6546g = packageInfo;
        this.f6547h = str2;
        this.f6548i = str3;
        this.f6549j = str4;
        this.f6550k = com_google_android_gms_internal_zzqa;
        this.f6551l = bundle2;
        this.f6552m = i2;
        this.f6553n = list;
        this.f6524A = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.f6554o = bundle3;
        this.f6555p = z;
        this.f6556q = messenger;
        this.f6557r = i3;
        this.f6558s = i4;
        this.f6559t = f;
        this.f6560u = str5;
        this.f6561v = j;
        this.f6562w = str6;
        this.f6563x = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f6564y = str7;
        this.f6565z = com_google_android_gms_internal_zzgw;
        this.f6525B = j2;
        this.f6526C = com_google_android_gms_internal_zzmo;
        this.f6527D = str8;
        this.f6528E = f2;
        this.f6534K = z2;
        this.f6529F = i5;
        this.f6530G = i6;
        this.f6531H = z3;
        this.f6532I = z4;
        this.f6533J = str9;
        this.f6535L = str10;
        this.f6536M = z5;
        this.f6537N = i7;
        this.f6538O = bundle4;
        this.f6539P = str11;
    }

    public zzmh(Bundle bundle, zzdy com_google_android_gms_internal_zzdy, zzec com_google_android_gms_internal_zzec, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzqa com_google_android_gms_internal_zzqa, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, zzgw com_google_android_gms_internal_zzgw, long j2, zzmo com_google_android_gms_internal_zzmo, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11) {
        this(19, bundle, com_google_android_gms_internal_zzdy, com_google_android_gms_internal_zzec, str, applicationInfo, packageInfo, str2, str3, str4, com_google_android_gms_internal_zzqa, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, j, str6, list3, str7, com_google_android_gms_internal_zzgw, list2, j2, com_google_android_gms_internal_zzmo, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11);
    }

    public zzmh(C2082a c2082a, String str, long j) {
        String str2 = str;
        long j2 = j;
        this(c2082a.f6498a, c2082a.f6499b, c2082a.f6500c, c2082a.f6501d, c2082a.f6502e, c2082a.f6503f, str2, c2082a.f6504g, c2082a.f6505h, c2082a.f6507j, c2082a.f6506i, c2082a.f6508k, c2082a.f6509l, c2082a.f6510m, c2082a.f6511n, c2082a.f6512o, c2082a.f6513p, c2082a.f6514q, c2082a.f6515r, c2082a.f6516s, c2082a.f6517t, c2082a.f6518u, c2082a.f6519v, c2082a.f6520w, c2082a.f6521x, c2082a.f6522y, j2, c2082a.f6523z, c2082a.f6485A, c2082a.f6486B, c2082a.f6487C, c2082a.f6488D, c2082a.f6489E, c2082a.f6490F, c2082a.f6491G, c2082a.f6492H, c2082a.f6493I, c2082a.f6494J, c2082a.f6495K, c2082a.f6496L, c2082a.f6497M);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ov.m7981a(this, parcel, i);
    }
}
