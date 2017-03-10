package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.andi.alquran.C0861R;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class LocationRequest extends zza implements ReflectedParcelable {
    public static final Creator<LocationRequest> CREATOR;
    int f6675a;
    long f6676b;
    long f6677c;
    boolean f6678d;
    long f6679e;
    int f6680f;
    float f6681g;
    long f6682h;
    private final int f6683i;

    static {
        CREATOR = new C2099q();
    }

    public LocationRequest() {
        this.f6683i = 1;
        this.f6675a = C0861R.styleable.AppCompatTheme_buttonStyle;
        this.f6676b = 3600000;
        this.f6677c = 600000;
        this.f6678d = false;
        this.f6679e = Long.MAX_VALUE;
        this.f6680f = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f6681g = 0.0f;
        this.f6682h = 0;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.f6683i = i;
        this.f6675a = i2;
        this.f6676b = j;
        this.f6677c = j2;
        this.f6678d = z;
        this.f6679e = j3;
        this.f6680f = i3;
        this.f6681g = f;
        this.f6682h = j4;
    }

    public static LocationRequest m9803a() {
        return new LocationRequest();
    }

    public static String m9804b(int i) {
        switch (i) {
            case C0861R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /*100*/:
                return "PRIORITY_HIGH_ACCURACY";
            case C0861R.styleable.AppCompatTheme_buttonStyle /*102*/:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case C0861R.styleable.AppCompatTheme_checkboxStyle /*104*/:
                return "PRIORITY_LOW_POWER";
            case C0861R.styleable.AppCompatTheme_checkedTextViewStyle /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    private static void m9805b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void m9806c(int i) {
        switch (i) {
            case C0861R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /*100*/:
            case C0861R.styleable.AppCompatTheme_buttonStyle /*102*/:
            case C0861R.styleable.AppCompatTheme_checkboxStyle /*104*/:
            case C0861R.styleable.AppCompatTheme_checkedTextViewStyle /*105*/:
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public LocationRequest m9807a(int i) {
        m9806c(i);
        this.f6675a = i;
        return this;
    }

    public LocationRequest m9808a(long j) {
        m9805b(j);
        this.f6676b = j;
        if (!this.f6678d) {
            this.f6677c = (long) (((double) this.f6676b) / 6.0d);
        }
        return this;
    }

    int m9809b() {
        return this.f6683i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f6675a == locationRequest.f6675a && this.f6676b == locationRequest.f6676b && this.f6677c == locationRequest.f6677c && this.f6678d == locationRequest.f6678d && this.f6679e == locationRequest.f6679e && this.f6680f == locationRequest.f6680f && this.f6681g == locationRequest.f6681g;
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f6675a), Long.valueOf(this.f6676b), Long.valueOf(this.f6677c), Boolean.valueOf(this.f6678d), Long.valueOf(this.f6679e), Integer.valueOf(this.f6680f), Float.valueOf(this.f6681g));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(m9804b(this.f6675a));
        if (this.f6675a != C0861R.styleable.AppCompatTheme_checkedTextViewStyle) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.f6676b).append("ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.f6677c).append("ms");
        if (this.f6682h > this.f6676b) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.f6682h).append("ms");
        }
        if (this.f6679e != Long.MAX_VALUE) {
            long elapsedRealtime = this.f6679e - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime).append("ms");
        }
        if (this.f6680f != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            stringBuilder.append(" num=").append(this.f6680f);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2099q.m9859a(this, parcel, i);
    }
}
