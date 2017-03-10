package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.C1307i.C1301a;
import com.google.android.gms.common.C1307i.C1302b;
import com.google.android.gms.common.C1307i.C1306d;
import com.google.android.gms.common.internal.C1314c;

/* renamed from: com.google.android.gms.common.k */
public class C1366k {
    private static C1366k f3171a;
    private final Context f3172b;

    private C1366k(Context context) {
        this.f3172b = context.getApplicationContext();
    }

    public static C1366k m4881a(Context context) {
        C1314c.m4623a((Object) context);
        synchronized (C1366k.class) {
            if (f3171a == null) {
                C1307i.m4613a(context);
                f3171a = new C1366k(context);
            }
        }
        return f3171a;
    }

    C1301a m4882a(PackageInfo packageInfo, C1301a... c1301aArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C1302b c1302b = new C1302b(packageInfo.signatures[0].toByteArray());
        while (i < c1301aArr.length) {
            if (c1301aArr[i].equals(c1302b)) {
                return c1301aArr[i];
            }
            i++;
        }
        return null;
    }

    public boolean m4883a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            C1301a a;
            if (z) {
                a = m4882a(packageInfo, C1306d.f3039a);
            } else {
                a = m4882a(packageInfo, C1306d.f3039a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m4884a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m4883a(packageInfo, false)) {
            return true;
        }
        if (!m4883a(packageInfo, true)) {
            return false;
        }
        if (C1295j.m4589f(this.f3172b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }
}
