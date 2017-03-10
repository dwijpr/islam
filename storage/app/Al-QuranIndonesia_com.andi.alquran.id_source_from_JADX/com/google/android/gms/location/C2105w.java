package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.location.w */
public class C2105w implements Creator<zzv> {
    static void m9877a(zzv com_google_android_gms_location_zzv, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4850b(parcel, 1, com_google_android_gms_location_zzv.m9905b(), false);
        C1355b.m4835a(parcel, 2, com_google_android_gms_location_zzv.m9906c(), i, false);
        C1355b.m4838a(parcel, 3, com_google_android_gms_location_zzv.m9907d(), false);
        C1355b.m4831a(parcel, 1000, com_google_android_gms_location_zzv.m9904a());
        C1355b.m4827a(parcel, a);
    }

    public zzv m9878a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int b = C1354a.m4804b(parcel);
        int i = 0;
        String str = BuildConfig.VERSION_NAME;
        List list = null;
        while (parcel.dataPosition() < b) {
            int i2;
            String str2;
            PendingIntent pendingIntent2;
            List list2;
            int a = C1354a.m4798a(parcel);
            String str3;
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = i;
                    PendingIntent pendingIntent3 = pendingIntent;
                    Object t = C1354a.m4825t(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    list2 = list;
                    i2 = i;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) C1354a.m4800a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    str2 = C1354a.m4817l(parcel, a);
                    pendingIntent2 = pendingIntent;
                    list2 = list;
                    i2 = i;
                    break;
                case 1000:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    list2 = list;
                    i2 = C1354a.m4811f(parcel, a);
                    str2 = str3;
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    list2 = list;
                    i2 = i;
                    break;
            }
            i = i2;
            list = list2;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new zzv(i, list, pendingIntent, str);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public zzv[] m9879a(int i) {
        return new zzv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9878a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9879a(i);
    }
}
