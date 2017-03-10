package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.google.android.gms.C1114a.C1095b;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.C1307i.C1306d;
import com.google.android.gms.common.internal.C1365z;
import com.google.android.gms.common.util.C1380f;
import com.google.android.gms.common.util.C1382h;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.common.util.C1390p;
import com.google.android.gms.maps.GoogleMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.j */
public class C1295j {
    private static boolean f3025a;
    @Deprecated
    public static final int f3026b;
    public static boolean f3027c;
    public static boolean f3028d;
    static boolean f3029e;
    static final AtomicBoolean f3030f;
    private static final AtomicBoolean f3031g;

    static {
        f3026b = 10084000;
        f3027c = false;
        f3028d = false;
        f3029e = false;
        f3025a = false;
        f3030f = new AtomicBoolean();
        f3031g = new AtomicBoolean();
    }

    @Deprecated
    public static String m4578a(int i) {
        return ConnectionResult.m4450a(i);
    }

    private static void m4579a(Context context) {
        if (!f3031g.get()) {
            int a = C1365z.m4866a(context);
            if (a == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (a != f3026b) {
                int i = f3026b;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(a).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    @Deprecated
    public static boolean m4580a() {
        return C1380f.m4941a();
    }

    @Deprecated
    public static boolean m4581a(Context context, int i) {
        return C1390p.m4974a(context, i);
    }

    @TargetApi(21)
    static boolean m4582a(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (C1387m.m4968j()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, FragmentTransaction.TRANSIT_EXIT_MASK);
            if (equals) {
                return applicationInfo.enabled;
            }
            boolean z = applicationInfo.enabled && !C1295j.m4594k(context);
            return z;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static void m4583b(Context context) {
        if (!f3025a) {
            C1295j.m4586c(context);
        }
    }

    @Deprecated
    public static boolean m4584b(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean m4585b(Context context, int i) {
        return i == 18 ? true : i == 1 ? C1295j.m4582a(context, "com.google.android.gms") : false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m4586c(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = com.google.android.gms.internal.ar.m5144b(r7);	 Catch:{ NameNotFoundException -> 0x002e }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.m5142b(r1, r2);	 Catch:{ NameNotFoundException -> 0x002e }
        if (r0 == 0) goto L_0x002a;
    L_0x000f:
        r1 = com.google.android.gms.common.C1366k.m4881a(r7);	 Catch:{ NameNotFoundException -> 0x002e }
        r2 = 1;
        r2 = new com.google.android.gms.common.C1307i.C1301a[r2];	 Catch:{ NameNotFoundException -> 0x002e }
        r3 = 0;
        r4 = com.google.android.gms.common.C1307i.C1306d.f3039a;	 Catch:{ NameNotFoundException -> 0x002e }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x002e }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x002e }
        r0 = r1.m4882a(r0, r2);	 Catch:{ NameNotFoundException -> 0x002e }
        if (r0 == 0) goto L_0x002a;
    L_0x0024:
        r0 = 1;
        f3029e = r0;	 Catch:{ NameNotFoundException -> 0x002e }
    L_0x0027:
        f3025a = r6;
    L_0x0029:
        return;
    L_0x002a:
        r0 = 0;
        f3029e = r0;	 Catch:{ NameNotFoundException -> 0x002e }
        goto L_0x0027;
    L_0x002e:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0039 }
        f3025a = r6;
        goto L_0x0029;
    L_0x0039:
        r0 = move-exception;
        f3025a = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.j.c(android.content.Context):void");
    }

    @Deprecated
    public static int m4587d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C1095b.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            C1295j.m4579a(context);
        }
        int i = (C1380f.m4943b(context) || C1380f.m4945d(context)) ? 0 : 1;
        PackageInfo packageInfo = null;
        if (i != 0) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            C1366k a = C1366k.m4881a(context);
            if (i != 0) {
                if (a.m4882a(packageInfo, C1306d.f3039a) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (a.m4882a(packageInfo2, a.m4882a(packageInfo, C1306d.f3039a)) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (a.m4882a(packageInfo2, C1306d.f3039a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (C1382h.m4949a(packageInfo2.versionCode) < C1382h.m4949a(f3026b)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f3026b + " but found " + packageInfo2.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    public static boolean m4588e(Context context) {
        C1295j.m4583b(context);
        return f3029e;
    }

    public static boolean m4589f(Context context) {
        return C1295j.m4588e(context) || !C1295j.m4580a();
    }

    @Deprecated
    public static void m4590g(Context context) {
        if (!f3030f.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException e) {
            }
        }
    }

    public static Resources m4591h(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Context m4592i(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int m4593j(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    @TargetApi(18)
    public static boolean m4594k(Context context) {
        if (C1387m.m4964f()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }
}
