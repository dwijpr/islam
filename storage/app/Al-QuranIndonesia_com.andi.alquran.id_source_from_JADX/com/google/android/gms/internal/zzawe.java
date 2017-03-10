package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzawe extends zza {
    public static final Creator<zzawe> CREATOR;
    public final int f6398a;
    public final String f6399b;
    public final int f6400c;
    public final int f6401d;
    public final String f6402e;
    public final String f6403f;
    public final boolean f6404g;
    public final String f6405h;
    public final boolean f6406i;
    public final int f6407j;

    static {
        CREATOR = new ci();
    }

    public zzawe(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.f6398a = i;
        this.f6399b = str;
        this.f6400c = i2;
        this.f6401d = i3;
        this.f6402e = str2;
        this.f6403f = str3;
        this.f6404g = z;
        this.f6405h = str4;
        this.f6406i = z2;
        this.f6407j = i4;
    }

    public zzawe(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.f6398a = 1;
        this.f6399b = (String) C1314c.m4623a((Object) str);
        this.f6400c = i;
        this.f6401d = i2;
        this.f6405h = str2;
        this.f6402e = str3;
        this.f6403f = str4;
        this.f6404g = !z;
        this.f6406i = z;
        this.f6407j = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzawe)) {
            return false;
        }
        zzawe com_google_android_gms_internal_zzawe = (zzawe) obj;
        return this.f6398a == com_google_android_gms_internal_zzawe.f6398a && this.f6399b.equals(com_google_android_gms_internal_zzawe.f6399b) && this.f6400c == com_google_android_gms_internal_zzawe.f6400c && this.f6401d == com_google_android_gms_internal_zzawe.f6401d && C1313b.m4621a(this.f6405h, com_google_android_gms_internal_zzawe.f6405h) && C1313b.m4621a(this.f6402e, com_google_android_gms_internal_zzawe.f6402e) && C1313b.m4621a(this.f6403f, com_google_android_gms_internal_zzawe.f6403f) && this.f6404g == com_google_android_gms_internal_zzawe.f6404g && this.f6406i == com_google_android_gms_internal_zzawe.f6406i && this.f6407j == com_google_android_gms_internal_zzawe.f6407j;
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f6398a), this.f6399b, Integer.valueOf(this.f6400c), Integer.valueOf(this.f6401d), this.f6405h, this.f6402e, this.f6403f, Boolean.valueOf(this.f6404g), Boolean.valueOf(this.f6406i), Integer.valueOf(this.f6407j));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.f6398a).append(',');
        stringBuilder.append("package=").append(this.f6399b).append(',');
        stringBuilder.append("packageVersionCode=").append(this.f6400c).append(',');
        stringBuilder.append("logSource=").append(this.f6401d).append(',');
        stringBuilder.append("logSourceName=").append(this.f6405h).append(',');
        stringBuilder.append("uploadAccount=").append(this.f6402e).append(',');
        stringBuilder.append("loggingId=").append(this.f6403f).append(',');
        stringBuilder.append("logAndroidId=").append(this.f6404g).append(',');
        stringBuilder.append("isAnonymous=").append(this.f6406i).append(',');
        stringBuilder.append("qosTier=").append(this.f6407j);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ci.m5540a(this, parcel, i);
    }
}
