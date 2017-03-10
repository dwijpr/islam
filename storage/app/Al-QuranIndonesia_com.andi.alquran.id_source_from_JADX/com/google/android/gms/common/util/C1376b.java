package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.ar;

/* renamed from: com.google.android.gms.common.util.b */
public class C1376b {
    @TargetApi(12)
    public static boolean m4925a(Context context, String str) {
        if (!C1387m.m4960b()) {
            return false;
        }
        "com.google.android.gms".equals(str);
        try {
            return (ar.m5144b(context).m5140a(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
