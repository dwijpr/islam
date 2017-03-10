package com.google.android.gms.analytics;

import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.internal.vf;

/* renamed from: com.google.android.gms.analytics.j */
public final class C1226j {
    public static String m4329a(int i) {
        return C1226j.m4330a("cd", i);
    }

    private static String m4330a(String str, int i) {
        if (i >= 1) {
            return new StringBuilder(String.valueOf(str).length() + 11).append(str).append(i).toString();
        }
        vf.m9425a("index out of range for prefix", str);
        return BuildConfig.VERSION_NAME;
    }

    public static String m4331b(int i) {
        return C1226j.m4330a("cm", i);
    }

    public static String m4332c(int i) {
        return C1226j.m4330a("&pr", i);
    }

    public static String m4333d(int i) {
        return C1226j.m4330a("pr", i);
    }

    public static String m4334e(int i) {
        return C1226j.m4330a("&promo", i);
    }

    public static String m4335f(int i) {
        return C1226j.m4330a(NotificationCompatApi24.CATEGORY_PROMO, i);
    }

    public static String m4336g(int i) {
        return C1226j.m4330a("pi", i);
    }

    public static String m4337h(int i) {
        return C1226j.m4330a("&il", i);
    }

    public static String m4338i(int i) {
        return C1226j.m4330a("il", i);
    }
}
