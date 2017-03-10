package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1352s;
import com.google.android.gms.common.util.C1380f;
import com.google.android.gms.internal.ar;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.h */
public class C1261h {
    private static final C1261h f2968a;
    public static final int f2969b;

    static {
        f2969b = C1295j.f3026b;
        f2968a = new C1261h();
    }

    C1261h() {
    }

    public static C1261h m4458b() {
        return f2968a;
    }

    static String m4459b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f2969b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(ar.m5144b(context).m5142b(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int m4460a(Context context) {
        int d = C1295j.m4587d(context);
        return C1295j.m4585b(context, d) ? 18 : d;
    }

    public PendingIntent m4461a(Context context, int i, int i2) {
        return m4462a(context, i, i2, null);
    }

    public PendingIntent m4462a(Context context, int i, int i2, String str) {
        Intent b = m4467b(context, i, str);
        return b == null ? null : PendingIntent.getActivity(context, i2, b, 268435456);
    }

    public boolean m4463a(int i) {
        return C1295j.m4584b(i);
    }

    public boolean m4464a(Context context, String str) {
        return C1295j.m4582a(context, str);
    }

    public int m4465b(Context context) {
        return C1295j.m4593j(context);
    }

    @Deprecated
    public Intent m4466b(int i) {
        return m4467b(null, i, null);
    }

    public Intent m4467b(Context context, int i, String str) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return (context == null || !C1380f.m4943b(context)) ? C1352s.m4795a("com.google.android.gms", C1261h.m4459b(context, str)) : C1352s.m4793a();
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return C1352s.m4794a("com.google.android.gms");
            default:
                return null;
        }
    }

    public boolean m4468b(Context context, int i) {
        return C1295j.m4585b(context, i);
    }

    public String m4469c(int i) {
        return C1295j.m4578a(i);
    }

    public void m4470d(Context context) {
        C1295j.m4590g(context);
    }
}
