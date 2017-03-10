package com.andi.alquran.p032j;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

/* renamed from: com.andi.alquran.j.h */
public class C0948h {
    private static WakeLock f1899a;

    public static void m3286a() {
        if (f1899a != null && f1899a.isHeld()) {
            f1899a.release();
        }
        f1899a = null;
    }

    public static void m3287a(Context context) {
        if (f1899a == null || !f1899a.isHeld()) {
            f1899a = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "Notif Alarm Wake Lock Andi");
            f1899a.acquire();
        }
    }
}
