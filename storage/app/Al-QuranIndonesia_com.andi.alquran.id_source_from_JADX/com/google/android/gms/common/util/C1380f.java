package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.C1295j;

/* renamed from: com.google.android.gms.common.util.f */
public final class C1380f {
    private static Boolean f3222a;
    private static Boolean f3223b;
    private static Boolean f3224c;

    public static boolean m4941a() {
        boolean z = C1295j.f3027c;
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean m4942a(Context context) {
        if (f3222a == null) {
            boolean z = C1387m.m4966h() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            f3222a = Boolean.valueOf(z);
        }
        return f3222a.booleanValue();
    }

    @TargetApi(24)
    public static boolean m4943b(Context context) {
        return !C1387m.m4970l() && C1380f.m4942a(context);
    }

    @TargetApi(21)
    public static boolean m4944c(Context context) {
        if (f3223b == null) {
            boolean z = C1387m.m4968j() && context.getPackageManager().hasSystemFeature("cn.google");
            f3223b = Boolean.valueOf(z);
        }
        return f3223b.booleanValue();
    }

    public static boolean m4945d(Context context) {
        if (f3224c == null) {
            f3224c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
        }
        return f3224c.booleanValue();
    }
}
