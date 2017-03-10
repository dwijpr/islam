package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1355b;

@op
public class zzfl extends zzec {
    public zzfl(zzec com_google_android_gms_internal_zzec) {
        super(com_google_android_gms_internal_zzec.f6451a, com_google_android_gms_internal_zzec.f6452b, com_google_android_gms_internal_zzec.f6453c, com_google_android_gms_internal_zzec.f6454d, com_google_android_gms_internal_zzec.f6455e, com_google_android_gms_internal_zzec.f6456f, com_google_android_gms_internal_zzec.f6457g, com_google_android_gms_internal_zzec.f6458h, com_google_android_gms_internal_zzec.f6459i, com_google_android_gms_internal_zzec.f6460j, com_google_android_gms_internal_zzec.f6461k);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, this.a);
        C1355b.m4838a(parcel, 2, this.b, false);
        C1355b.m4831a(parcel, 3, this.c);
        C1355b.m4831a(parcel, 6, this.f);
        C1355b.m4827a(parcel, a);
    }
}
