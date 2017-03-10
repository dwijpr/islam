package com.google.android.gms.common.util;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.common.util.m */
public final class C1387m {
    public static boolean m4959a() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean m4960b() {
        return VERSION.SDK_INT >= 12;
    }

    public static boolean m4961c() {
        return VERSION.SDK_INT >= 14;
    }

    public static boolean m4962d() {
        return VERSION.SDK_INT >= 15;
    }

    public static boolean m4963e() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean m4964f() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean m4965g() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean m4966h() {
        return VERSION.SDK_INT >= 20;
    }

    @Deprecated
    public static boolean m4967i() {
        return C1387m.m4968j();
    }

    public static boolean m4968j() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean m4969k() {
        return VERSION.SDK_INT >= 23;
    }

    public static boolean m4970l() {
        return VERSION.SDK_INT >= 24;
    }
}
