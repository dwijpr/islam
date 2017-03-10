package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.safeparcel.C1354a;
import com.google.android.gms.common.internal.safeparcel.C1354a.C1353a;
import com.google.android.gms.common.internal.safeparcel.C1355b;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.f */
public class C1373f implements Creator<WakeLockEvent> {
    static void m4916a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a = C1355b.m4826a(parcel);
        C1355b.m4831a(parcel, 1, wakeLockEvent.f3173a);
        C1355b.m4832a(parcel, 2, wakeLockEvent.m4889a());
        C1355b.m4838a(parcel, 4, wakeLockEvent.m4893e(), false);
        C1355b.m4831a(parcel, 5, wakeLockEvent.m4896h());
        C1355b.m4850b(parcel, 6, wakeLockEvent.m4897i(), false);
        C1355b.m4832a(parcel, 8, wakeLockEvent.m4899k());
        C1355b.m4838a(parcel, 10, wakeLockEvent.m4894f(), false);
        C1355b.m4831a(parcel, 11, wakeLockEvent.m4890b());
        C1355b.m4838a(parcel, 12, wakeLockEvent.m4898j(), false);
        C1355b.m4838a(parcel, 13, wakeLockEvent.m4901m(), false);
        C1355b.m4831a(parcel, 14, wakeLockEvent.m4900l());
        C1355b.m4830a(parcel, 15, wakeLockEvent.m4902n());
        C1355b.m4832a(parcel, 16, wakeLockEvent.m4903o());
        C1355b.m4838a(parcel, 17, wakeLockEvent.m4895g(), false);
        C1355b.m4827a(parcel, a);
    }

    public WakeLockEvent m4917a(Parcel parcel) {
        int b = C1354a.m4804b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = C1354a.m4798a(parcel);
            switch (C1354a.m4797a(a)) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i = C1354a.m4811f(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    j = C1354a.m4813h(parcel, a);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    str = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    i3 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    list = C1354a.m4825t(parcel, a);
                    break;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    j2 = C1354a.m4813h(parcel, a);
                    break;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    str3 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    i2 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    str2 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    str4 = C1354a.m4817l(parcel, a);
                    break;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    i4 = C1354a.m4811f(parcel, a);
                    break;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    f = C1354a.m4814i(parcel, a);
                    break;
                case C1096c.MapAttrs_ambientEnabled /*16*/:
                    j3 = C1354a.m4813h(parcel, a);
                    break;
                case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                    str5 = C1354a.m4817l(parcel, a);
                    break;
                default:
                    C1354a.m4805b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new C1353a("Overread allowed size end=" + b, parcel);
    }

    public WakeLockEvent[] m4918a(int i) {
        return new WakeLockEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4917a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4918a(i);
    }
}
