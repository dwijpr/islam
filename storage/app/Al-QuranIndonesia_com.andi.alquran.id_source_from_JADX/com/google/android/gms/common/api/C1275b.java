package com.google.android.gms.common.api;

import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.api.b */
public class C1275b {
    public static String m4529a(int i) {
        switch (i) {
            case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                return "SUCCESS_CACHE";
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return "SUCCESS";
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
            case C1096c.MapAttrs_uiTiltGestures /*10*/:
                return "DEVELOPER_ERROR";
            case C1096c.MapAttrs_useViewLifecycle /*13*/:
                return "ERROR";
            case C1096c.MapAttrs_zOrderOnTop /*14*/:
                return "INTERRUPTED";
            case C1096c.MapAttrs_uiMapToolbar /*15*/:
                return "TIMEOUT";
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                return "CANCELED";
            case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                return "API_NOT_CONNECTED";
            case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                return "DEAD_CLIENT";
            default:
                return "unknown status code: " + i;
        }
    }
}
