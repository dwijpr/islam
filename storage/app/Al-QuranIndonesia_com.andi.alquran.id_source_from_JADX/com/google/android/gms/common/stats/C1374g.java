package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.C1381g;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.g */
public class C1374g {
    private static String f3217a;
    private static C1374g f3218b;
    private static Boolean f3219c;

    static {
        f3217a = "WakeLockTracker";
        f3218b = new C1374g();
    }

    public static C1374g m4919a() {
        return f3218b;
    }

    private static boolean m4920a(Context context) {
        if (f3219c == null) {
            f3219c = Boolean.valueOf(C1374g.m4921b(context));
        }
        return f3219c.booleanValue();
    }

    private static boolean m4921b(Context context) {
        return false;
    }

    public void m4922a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        m4923a(context, str, i, str2, str3, str4, i2, list, 0);
    }

    public void m4923a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (!C1374g.m4920a(context)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            String str5 = f3217a;
            String str6 = "missing wakeLock key. ";
            String valueOf = String.valueOf(str);
            Log.e(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (7 == i || 8 == i || 10 == i || 11 == i) {
            try {
                context.startService(new Intent().setComponent(C1370c.f3205a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, C1372e.m4915a((List) list), str, SystemClock.elapsedRealtime(), C1381g.m4946a(context), str3, C1372e.m4914a(context.getPackageName()), C1381g.m4948b(context), j, str4)));
            } catch (Throwable e) {
                Log.wtf(f3217a, e);
            }
        }
    }
}
