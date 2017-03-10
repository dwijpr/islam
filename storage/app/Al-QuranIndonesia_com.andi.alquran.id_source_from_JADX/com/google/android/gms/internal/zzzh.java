package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.ek.C1531c;
import com.google.android.gms.internal.vx.C2055c;
import java.util.Arrays;

public class zzzh extends zza {
    public static final Creator<zzzh> CREATOR;
    public final int f6643a;
    public zzawe f6644b;
    public byte[] f6645c;
    public int[] f6646d;
    public String[] f6647e;
    public int[] f6648f;
    public byte[][] f6649g;
    public boolean f6650h;
    public final C1531c f6651i;
    public final C2055c f6652j;
    public final C2055c f6653k;

    static {
        CREATOR = new vz();
    }

    zzzh(int i, zzawe com_google_android_gms_internal_zzawe, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z) {
        this.f6643a = i;
        this.f6644b = com_google_android_gms_internal_zzawe;
        this.f6645c = bArr;
        this.f6646d = iArr;
        this.f6647e = strArr;
        this.f6651i = null;
        this.f6652j = null;
        this.f6653k = null;
        this.f6648f = iArr2;
        this.f6649g = bArr2;
        this.f6650h = z;
    }

    public zzzh(zzawe com_google_android_gms_internal_zzawe, C1531c c1531c, C2055c c2055c, C2055c c2055c2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, boolean z) {
        this.f6643a = 1;
        this.f6644b = com_google_android_gms_internal_zzawe;
        this.f6651i = c1531c;
        this.f6652j = c2055c;
        this.f6653k = c2055c2;
        this.f6646d = iArr;
        this.f6647e = strArr;
        this.f6648f = iArr2;
        this.f6649g = bArr;
        this.f6650h = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzh)) {
            return false;
        }
        zzzh com_google_android_gms_internal_zzzh = (zzzh) obj;
        return this.f6643a == com_google_android_gms_internal_zzzh.f6643a && C1313b.m4621a(this.f6644b, com_google_android_gms_internal_zzzh.f6644b) && Arrays.equals(this.f6645c, com_google_android_gms_internal_zzzh.f6645c) && Arrays.equals(this.f6646d, com_google_android_gms_internal_zzzh.f6646d) && Arrays.equals(this.f6647e, com_google_android_gms_internal_zzzh.f6647e) && C1313b.m4621a(this.f6651i, com_google_android_gms_internal_zzzh.f6651i) && C1313b.m4621a(this.f6652j, com_google_android_gms_internal_zzzh.f6652j) && C1313b.m4621a(this.f6653k, com_google_android_gms_internal_zzzh.f6653k) && Arrays.equals(this.f6648f, com_google_android_gms_internal_zzzh.f6648f) && Arrays.deepEquals(this.f6649g, com_google_android_gms_internal_zzzh.f6649g) && this.f6650h == com_google_android_gms_internal_zzzh.f6650h;
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f6643a), this.f6644b, this.f6645c, this.f6646d, this.f6647e, this.f6651i, this.f6652j, this.f6653k, this.f6648f, this.f6649g, Boolean.valueOf(this.f6650h));
    }

    public String toString() {
        return "LogEventParcelable[" + this.f6643a + ", " + this.f6644b + ", " + "LogEventBytes: " + (this.f6645c == null ? null : new String(this.f6645c)) + ", " + "TestCodes: " + Arrays.toString(this.f6646d) + ", " + "MendelPackages: " + Arrays.toString(this.f6647e) + ", " + "LogEvent: " + this.f6651i + ", " + "ExtensionProducer: " + this.f6652j + ", " + "VeProducer: " + this.f6653k + ", " + "ExperimentIDs: " + Arrays.toString(this.f6648f) + ", " + "ExperimentTokens: " + Arrays.toString(this.f6649g) + ", " + "AddPhenotypeExperimentTokens: " + this.f6650h + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        vz.m9607a(this, parcel, i);
    }
}
