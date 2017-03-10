package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@op
public final class rm extends sg {
    public static void m8450a(String str) {
        if (m8452b()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean m8451a() {
        return ((Boolean) C1648if.aV.m6682c()).booleanValue();
    }

    public static boolean m8452b() {
        return sg.m8443a(2) && m8451a();
    }
}
