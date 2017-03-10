package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.android.gms.internal.ar;

/* renamed from: com.google.android.gms.common.internal.z */
public class C1365z {
    private static Object f3143a;
    private static boolean f3144b;
    private static String f3145c;
    private static int f3146d;

    static {
        f3143a = new Object();
    }

    public static int m4866a(Context context) {
        C1365z.m4867b(context);
        return f3146d;
    }

    private static void m4867b(Context context) {
        synchronized (f3143a) {
            if (f3144b) {
                return;
            }
            f3144b = true;
            try {
                Bundle bundle = ar.m5144b(context).m5140a(context.getPackageName(), (int) NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
                if (bundle == null) {
                    return;
                }
                f3145c = bundle.getString("com.google.app.id");
                f3146d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
