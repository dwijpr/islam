package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.GoogleMap;

public final class ConnectionResult extends zza {
    public static final Creator<ConnectionResult> CREATOR;
    public static final ConnectionResult f2957a;
    final int f2958b;
    private final int f2959c;
    private final PendingIntent f2960d;
    private final String f2961e;

    static {
        f2957a = new ConnectionResult(0);
        CREATOR = new C1298g();
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f2958b = i;
        this.f2959c = i2;
        this.f2960d = pendingIntent;
        this.f2961e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String m4450a(int i) {
        switch (i) {
            case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                return "UNKNOWN";
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return "SUCCESS";
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return "SERVICE_MISSING";
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return "SERVICE_DISABLED";
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return "SIGN_IN_REQUIRED";
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return "INVALID_ACCOUNT";
            case C1096c.MapAttrs_liteMode /*6*/:
                return "RESOLUTION_REQUIRED";
            case C1096c.MapAttrs_uiCompass /*7*/:
                return "NETWORK_ERROR";
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                return "INTERNAL_ERROR";
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                return "SERVICE_INVALID";
            case C1096c.MapAttrs_uiTiltGestures /*10*/:
                return "DEVELOPER_ERROR";
            case C1096c.MapAttrs_uiZoomControls /*11*/:
                return "LICENSE_CHECK_FAILED";
            case C1096c.MapAttrs_useViewLifecycle /*13*/:
                return "CANCELED";
            case C1096c.MapAttrs_zOrderOnTop /*14*/:
                return "TIMEOUT";
            case C1096c.MapAttrs_uiMapToolbar /*15*/:
                return "INTERRUPTED";
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                return "API_UNAVAILABLE";
            case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                return "SIGN_IN_FAILED";
            case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                return "SERVICE_UPDATING";
            case C1096c.MapAttrs_latLngBoundsSouthWestLatitude /*19*/:
                return "SERVICE_MISSING_PERMISSION";
            case C1096c.MapAttrs_latLngBoundsSouthWestLongitude /*20*/:
                return "RESTRICTED_PROFILE";
            case C1096c.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                return "API_VERSION_UPDATE_REQUIRED";
            case C0861R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /*99*/:
                return "UNFINISHED";
            case 1500:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public boolean m4451a() {
        return (this.f2959c == 0 || this.f2960d == null) ? false : true;
    }

    public boolean m4452b() {
        return this.f2959c == 0;
    }

    public int m4453c() {
        return this.f2959c;
    }

    public PendingIntent m4454d() {
        return this.f2960d;
    }

    public String m4455e() {
        return this.f2961e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f2959c == connectionResult.f2959c && C1313b.m4621a(this.f2960d, connectionResult.f2960d) && C1313b.m4621a(this.f2961e, connectionResult.f2961e);
    }

    public int hashCode() {
        return C1313b.m4619a(Integer.valueOf(this.f2959c), this.f2960d, this.f2961e);
    }

    public String toString() {
        return C1313b.m4620a((Object) this).m4618a("statusCode", m4450a(this.f2959c)).m4618a("resolution", this.f2960d).m4618a("message", this.f2961e).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1298g.m4599a(this, parcel, i);
    }
}
