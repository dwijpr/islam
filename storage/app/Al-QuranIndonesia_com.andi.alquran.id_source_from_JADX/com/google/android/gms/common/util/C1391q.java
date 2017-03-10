package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.support.v7.recyclerview.BuildConfig;
import android.util.Log;
import com.google.android.gms.internal.ar;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.common.util.q */
public class C1391q {
    private static final Method f3235a;
    private static final Method f3236b;
    private static final Method f3237c;
    private static final Method f3238d;
    private static final Method f3239e;

    static {
        f3235a = C1391q.m4980a();
        f3236b = C1391q.m4983b();
        f3237c = C1391q.m4985c();
        f3238d = C1391q.m4986d();
        f3239e = C1391q.m4987e();
    }

    public static int m4976a(WorkSource workSource) {
        if (f3237c != null) {
            try {
                return ((Integer) f3237c.invoke(workSource, new Object[0])).intValue();
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static WorkSource m4977a(int i, String str) {
        WorkSource workSource = new WorkSource();
        C1391q.m4981a(workSource, i, str);
        return workSource;
    }

    public static WorkSource m4978a(Context context, String str) {
        String str2;
        String str3;
        String valueOf;
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo a = ar.m5144b(context).m5140a(str, 0);
            if (a != null) {
                return C1391q.m4977a(a.uid, str);
            }
            str2 = "WorkSourceUtil";
            str3 = "Could not get applicationInfo from package: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        } catch (NameNotFoundException e) {
            str2 = "WorkSourceUtil";
            str3 = "Could not find package: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
    }

    public static String m4979a(WorkSource workSource, int i) {
        if (f3239e != null) {
            try {
                return (String) f3239e.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    private static Method m4980a() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    public static void m4981a(WorkSource workSource, int i, String str) {
        if (f3236b != null) {
            if (str == null) {
                str = BuildConfig.VERSION_NAME;
            }
            try {
                f3236b.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else if (f3235a != null) {
            try {
                f3235a.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
    }

    public static boolean m4982a(Context context) {
        return (context == null || context.getPackageManager() == null || ar.m5144b(context).m5139a("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static Method m4983b() {
        Method method = null;
        if (C1387m.m4964f()) {
            try {
                method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        return method;
    }

    public static List<String> m4984b(WorkSource workSource) {
        int i = 0;
        int a = workSource == null ? 0 : C1391q.m4976a(workSource);
        if (a == 0) {
            return Collections.EMPTY_LIST;
        }
        List<String> arrayList = new ArrayList();
        while (i < a) {
            String a2 = C1391q.m4979a(workSource, i);
            if (!C1389o.m4973a(a2)) {
                arrayList.add(a2);
            }
            i++;
        }
        return arrayList;
    }

    private static Method m4985c() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
        }
        return method;
    }

    private static Method m4986d() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method m4987e() {
        Method method = null;
        if (C1387m.m4964f()) {
            try {
                method = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        return method;
    }
}
