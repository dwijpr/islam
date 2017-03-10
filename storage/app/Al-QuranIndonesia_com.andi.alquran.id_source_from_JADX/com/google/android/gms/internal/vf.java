package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.analytics.C1219e;

@Deprecated
public class vf {
    private static volatile C1219e f6206a;

    static {
        m9423a(new ut());
    }

    public static C1219e m9422a() {
        return f6206a;
    }

    public static void m9423a(C1219e c1219e) {
        f6206a = c1219e;
    }

    public static void m9424a(String str) {
        vg b = vg.m9428b();
        if (b != null) {
            b.m4250b(str);
        } else if (m9426a(0)) {
            Log.v((String) uz.f6160c.m9383a(), str);
        }
        C1219e c1219e = f6206a;
        if (c1219e != null) {
            c1219e.m4236a(str);
        }
    }

    public static void m9425a(String str, Object obj) {
        vg b = vg.m9428b();
        if (b != null) {
            b.m4261e(str, obj);
        } else if (m9426a(3)) {
            String stringBuilder;
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()).append(str).append(":").append(valueOf).toString();
            } else {
                stringBuilder = str;
            }
            Log.e((String) uz.f6160c.m9383a(), stringBuilder);
        }
        C1219e c1219e = f6206a;
        if (c1219e != null) {
            c1219e.m4238c(str);
        }
    }

    public static boolean m9426a(int i) {
        return m9422a() != null && m9422a().m4235a() <= i;
    }

    public static void m9427b(String str) {
        vg b = vg.m9428b();
        if (b != null) {
            b.m4260e(str);
        } else if (m9426a(2)) {
            Log.w((String) uz.f6160c.m9383a(), str);
        }
        C1219e c1219e = f6206a;
        if (c1219e != null) {
            c1219e.m4237b(str);
        }
    }
}
