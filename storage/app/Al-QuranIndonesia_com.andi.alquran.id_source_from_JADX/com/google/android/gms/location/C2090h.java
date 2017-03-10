package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.location.h */
public class C2090h implements Creator<ActivityRecognitionResult> {
    static void m9835a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4852c(parcel, 1, activityRecognitionResult.f6654a, false);
        C1355b.m4832a(parcel, 2, activityRecognitionResult.f6655b);
        C1355b.m4832a(parcel, 3, activityRecognitionResult.f6656c);
        C1355b.m4831a(parcel, 4, activityRecognitionResult.f6657d);
        C1355b.m4833a(parcel, 5, activityRecognitionResult.f6658e, false);
        C1355b.m4831a(parcel, 1000, activityRecognitionResult.m9790a());
        C1355b.m4827a(parcel, a);
    }

    public ActivityRecognitionResult m9836a(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int i = 0;
        int b = C1354a.m4804b(parcel);
        long j2 = 0;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    list = C1354a.m4807c(parcel, a, DetectedActivity.CREATOR);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    j2 = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    bundle = C1354a.m4819n(parcel, a);
                    break;
                case 1000:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ActivityRecognitionResult(i2, list, j2, j, i, bundle);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public ActivityRecognitionResult[] m9837a(int i) {
        return new ActivityRecognitionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9836a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9837a(i);
    }
}
