package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* renamed from: com.google.android.gms.common.util.g */
public final class C1381g {
    private static IntentFilter f3225a;
    private static long f3226b;
    private static float f3227c;

    static {
        f3225a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        f3227c = Float.NaN;
    }

    @TargetApi(20)
    public static int m4946a(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f3225a);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i3 = (C1381g.m4947a(powerManager) ? 1 : 0) << 1;
        if (i2 == 0) {
            i = 0;
        }
        return i3 | i;
    }

    @TargetApi(20)
    public static boolean m4947a(PowerManager powerManager) {
        return C1387m.m4966h() ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    public static synchronized float m4948b(Context context) {
        float f;
        synchronized (C1381g.class) {
            if (SystemClock.elapsedRealtime() - f3226b >= 60000 || Float.isNaN(f3227c)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f3225a);
                if (registerReceiver != null) {
                    f3227c = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                f3226b = SystemClock.elapsedRealtime();
                f = f3227c;
            } else {
                f = f3227c;
            }
        }
        return f;
    }
}
