package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C1366k;
import com.google.android.gms.internal.ar;

/* renamed from: com.google.android.gms.common.util.p */
public final class C1390p {
    public static boolean m4974a(Context context, int i) {
        boolean z = false;
        if (!C1390p.m4975a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return C1366k.m4881a(context).m4884a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean m4975a(Context context, int i, String str) {
        return ar.m5144b(context).m5141a(i, str);
    }
}
