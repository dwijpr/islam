package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.support.v4.p014g.C0297j;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C1114a.C1095b;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.C1296d;
import com.google.android.gms.common.util.C1380f;
import com.google.android.gms.internal.ar;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.internal.l */
public final class C1339l {
    private static final C0297j<String, String> f3100a;

    static {
        f3100a = new C0297j();
    }

    public static String m4741a(Context context) {
        String str = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
            try {
                str = ar.m5144b(context).m5143b(context.getPackageName()).toString();
            } catch (NameNotFoundException e) {
            }
        }
        return str;
    }

    public static String m4742a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return resources.getString(C1095b.common_google_play_services_install_title);
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return resources.getString(C1095b.common_google_play_services_update_title);
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return resources.getString(C1095b.common_google_play_services_enable_title);
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
            case C1096c.MapAttrs_liteMode /*6*/:
            case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                return null;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return C1339l.m4743a(context, "common_google_play_services_invalid_account_title");
            case C1096c.MapAttrs_uiCompass /*7*/:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return C1339l.m4743a(context, "common_google_play_services_network_error_title");
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case C1096c.MapAttrs_uiTiltGestures /*10*/:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case C1096c.MapAttrs_uiZoomControls /*11*/:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return C1339l.m4743a(context, "common_google_play_services_sign_in_failed_title");
            case C1096c.MapAttrs_latLngBoundsSouthWestLongitude /*20*/:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return C1339l.m4743a(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    private static String m4743a(Context context, String str) {
        synchronized (f3100a) {
            String str2 = (String) f3100a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources b = C1296d.m4596b(context);
            if (b == null) {
                return null;
            }
            int identifier = b.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            Object string = b.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            f3100a.put(str, string);
            return string;
        }
    }

    private static String m4744a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a = C1339l.m4743a(context, str);
        if (a == null) {
            a = resources.getString(C1095b.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a, new Object[]{str2});
    }

    public static String m4745b(Context context, int i) {
        String a = i == 6 ? C1339l.m4743a(context, "common_google_play_services_resolution_required_title") : C1339l.m4742a(context, i);
        return a == null ? context.getResources().getString(C1095b.common_google_play_services_notification_ticker) : a;
    }

    public static String m4746c(Context context, int i) {
        Resources resources = context.getResources();
        String a = C1339l.m4741a(context);
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return resources.getString(C1095b.common_google_play_services_install_text, new Object[]{a});
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                if (C1380f.m4943b(context)) {
                    return resources.getString(C1095b.common_google_play_services_wear_update_text);
                }
                return resources.getString(C1095b.common_google_play_services_update_text, new Object[]{a});
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return resources.getString(C1095b.common_google_play_services_enable_text, new Object[]{a});
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return C1339l.m4744a(context, "common_google_play_services_invalid_account_text", a);
            case C1096c.MapAttrs_uiCompass /*7*/:
                return C1339l.m4744a(context, "common_google_play_services_network_error_text", a);
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                return resources.getString(C1095b.common_google_play_services_unsupported_text, new Object[]{a});
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                return C1339l.m4744a(context, "common_google_play_services_api_unavailable_text", a);
            case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                return C1339l.m4744a(context, "common_google_play_services_sign_in_failed_text", a);
            case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                return resources.getString(C1095b.common_google_play_services_updating_text, new Object[]{a});
            case C1096c.MapAttrs_latLngBoundsSouthWestLongitude /*20*/:
                return C1339l.m4744a(context, "common_google_play_services_restricted_profile_text", a);
            default:
                return resources.getString(C1095b.common_google_play_services_unknown_issue, new Object[]{a});
        }
    }

    public static String m4747d(Context context, int i) {
        return i == 6 ? C1339l.m4744a(context, "common_google_play_services_resolution_required_text", C1339l.m4741a(context)) : C1339l.m4746c(context, i);
    }

    public static String m4748e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return resources.getString(C1095b.common_google_play_services_install_button);
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return resources.getString(C1095b.common_google_play_services_update_button);
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return resources.getString(C1095b.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
