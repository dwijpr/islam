package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class ActivityRecognitionResult extends zza implements ReflectedParcelable {
    public static final Creator<ActivityRecognitionResult> CREATOR;
    List<DetectedActivity> f6654a;
    long f6655b;
    long f6656c;
    int f6657d;
    Bundle f6658e;
    private final int f6659f;

    static {
        CREATOR = new C2090h();
    }

    public ActivityRecognitionResult(int i, List<DetectedActivity> list, long j, long j2, int i2, Bundle bundle) {
        this.f6659f = i;
        this.f6654a = list;
        this.f6655b = j;
        this.f6656c = j2;
        this.f6657d = i2;
        this.f6658e = bundle;
    }

    private static boolean m9789a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || (bundle != null && bundle2 == null)) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!m9789a(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int m9790a() {
        return this.f6659f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.f6655b == activityRecognitionResult.f6655b && this.f6656c == activityRecognitionResult.f6656c && this.f6657d == activityRecognitionResult.f6657d && C1313b.m4621a(this.f6654a, activityRecognitionResult.f6654a) && m9789a(this.f6658e, activityRecognitionResult.f6658e);
    }

    public int hashCode() {
        return C1313b.m4619a(Long.valueOf(this.f6655b), Long.valueOf(this.f6656c), Integer.valueOf(this.f6657d), this.f6654a, this.f6658e);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f6654a);
        long j = this.f6655b;
        return new StringBuilder(String.valueOf(valueOf).length() + 124).append("ActivityRecognitionResult [probableActivities=").append(valueOf).append(", timeMillis=").append(j).append(", elapsedRealtimeMillis=").append(this.f6656c).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2090h.m9835a(this, parcel, i);
    }
}
