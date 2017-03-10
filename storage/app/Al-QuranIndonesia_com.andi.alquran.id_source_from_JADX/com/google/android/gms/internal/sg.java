package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@op
public class sg {
    public static void m8442a(String str, Throwable th) {
        if (m8443a(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean m8443a(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }

    public static void m8444b(String str) {
        if (m8443a(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void m8445b(String str, Throwable th) {
        if (m8443a(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m8446c(String str) {
        if (m8443a(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void m8447c(String str, Throwable th) {
        if (m8443a(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m8448d(String str) {
        if (m8443a(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void m8449e(String str) {
        if (m8443a(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
