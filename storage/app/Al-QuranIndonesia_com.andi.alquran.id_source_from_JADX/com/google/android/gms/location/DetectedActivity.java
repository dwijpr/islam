package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.GoogleMap;
import java.util.Comparator;

public class DetectedActivity extends zza {
    public static final Creator<DetectedActivity> CREATOR;
    public static final Comparator<DetectedActivity> f6660a;
    public static final int[] f6661b;
    public static final int[] f6662c;
    int f6663d;
    int f6664e;
    private final int f6665f;

    /* renamed from: com.google.android.gms.location.DetectedActivity.1 */
    class C20851 implements Comparator<DetectedActivity> {
        C20851() {
        }

        public int m9791a(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.m9795b()).compareTo(Integer.valueOf(detectedActivity.m9795b()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.m9794a()).compareTo(Integer.valueOf(detectedActivity2.m9794a())) : compareTo;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9791a((DetectedActivity) obj, (DetectedActivity) obj2);
        }
    }

    static {
        f6660a = new C20851();
        f6661b = new int[]{9, 10};
        f6662c = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14};
        CREATOR = new C2093k();
    }

    public DetectedActivity(int i, int i2, int i3) {
        this.f6665f = i;
        this.f6663d = i2;
        this.f6664e = i3;
    }

    public static String m9792a(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return "IN_VEHICLE";
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return "ON_BICYCLE";
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return "ON_FOOT";
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return "STILL";
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return "UNKNOWN";
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return "TILTING";
            case C1096c.MapAttrs_uiCompass /*7*/:
                return "WALKING";
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                return "RUNNING";
            default:
                return Integer.toString(i);
        }
    }

    private int m9793b(int i) {
        return i > 15 ? 4 : i;
    }

    public int m9794a() {
        return m9793b(this.f6663d);
    }

    public int m9795b() {
        return this.f6664e;
    }

    public int m9796c() {
        return this.f6665f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.f6663d == detectedActivity.f6663d && this.f6664e == detectedActivity.f6664e;
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f6663d), Integer.valueOf(this.f6664e));
    }

    public String toString() {
        String valueOf = String.valueOf(m9792a(m9794a()));
        return new StringBuilder(String.valueOf(valueOf).length() + 48).append("DetectedActivity [type=").append(valueOf).append(", confidence=").append(this.f6664e).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2093k.m9844a(this, parcel, i);
    }
}
