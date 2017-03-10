package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.common.util.C1389o;
import com.google.android.gms.common.util.C1391q;

public class cx {
    private static String f3704a;
    private static String f3705b;
    private static boolean f3706c;
    private final WakeLock f3707d;
    private WorkSource f3708e;
    private final int f3709f;
    private final String f3710g;
    private final String f3711h;
    private final String f3712i;
    private final Context f3713j;
    private boolean f3714k;
    private int f3715l;
    private int f3716m;

    static {
        f3704a = "WakeLock";
        f3705b = "*gcore*:";
        f3706c = false;
    }

    public cx(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public cx(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public cx(Context context, int i, String str, String str2, String str3, String str4) {
        this.f3714k = true;
        C1314c.m4626a(str, (Object) "Wake lock name can NOT be empty");
        this.f3709f = i;
        this.f3711h = str2;
        this.f3712i = str4;
        this.f3713j = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f3710g = str;
        } else {
            String valueOf = String.valueOf(f3705b);
            String valueOf2 = String.valueOf(str);
            this.f3710g = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.f3707d = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (C1391q.m4982a(this.f3713j)) {
            if (C1389o.m4973a(str3)) {
                str3 = context.getPackageName();
            }
            this.f3708e = C1391q.m4978a(context, str3);
            m5665a(this.f3708e);
        }
    }

    private String m5658a(String str, boolean z) {
        return this.f3714k ? z ? str : this.f3711h : this.f3711h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5659a(java.lang.String r10) {
        /*
        r9 = this;
        r0 = r9.m5662b(r10);
        r5 = r9.m5658a(r10, r0);
        monitor-enter(r9);
        r1 = r9.f3714k;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r9.f3715l;	 Catch:{ all -> 0x0045 }
        r1 = r1 + -1;
        r9.f3715l = r1;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0020;
    L_0x0015:
        if (r0 != 0) goto L_0x0020;
    L_0x0017:
        r0 = r9.f3714k;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0043;
    L_0x001b:
        r0 = r9.f3716m;	 Catch:{ all -> 0x0045 }
        r1 = 1;
        if (r0 != r1) goto L_0x0043;
    L_0x0020:
        r0 = com.google.android.gms.common.stats.C1374g.m4919a();	 Catch:{ all -> 0x0045 }
        r1 = r9.f3713j;	 Catch:{ all -> 0x0045 }
        r2 = r9.f3707d;	 Catch:{ all -> 0x0045 }
        r2 = com.google.android.gms.common.stats.C1372e.m4913a(r2, r5);	 Catch:{ all -> 0x0045 }
        r3 = 8;
        r4 = r9.f3710g;	 Catch:{ all -> 0x0045 }
        r6 = r9.f3712i;	 Catch:{ all -> 0x0045 }
        r7 = r9.f3709f;	 Catch:{ all -> 0x0045 }
        r8 = r9.f3708e;	 Catch:{ all -> 0x0045 }
        r8 = com.google.android.gms.common.util.C1391q.m4984b(r8);	 Catch:{ all -> 0x0045 }
        r0.m4922a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0045 }
        r0 = r9.f3716m;	 Catch:{ all -> 0x0045 }
        r0 = r0 + -1;
        r9.f3716m = r0;	 Catch:{ all -> 0x0045 }
    L_0x0043:
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        return;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cx.a(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5660a(java.lang.String r13, long r14) {
        /*
        r12 = this;
        r0 = r12.m5662b(r13);
        r6 = r12.m5658a(r13, r0);
        monitor-enter(r12);
        r1 = r12.f3714k;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r12.f3715l;	 Catch:{ all -> 0x0044 }
        r2 = r1 + 1;
        r12.f3715l = r2;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x001f;
    L_0x0015:
        if (r0 != 0) goto L_0x001f;
    L_0x0017:
        r0 = r12.f3714k;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001b:
        r0 = r12.f3716m;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001f:
        r1 = com.google.android.gms.common.stats.C1374g.m4919a();	 Catch:{ all -> 0x0044 }
        r2 = r12.f3713j;	 Catch:{ all -> 0x0044 }
        r0 = r12.f3707d;	 Catch:{ all -> 0x0044 }
        r3 = com.google.android.gms.common.stats.C1372e.m4913a(r0, r6);	 Catch:{ all -> 0x0044 }
        r4 = 7;
        r5 = r12.f3710g;	 Catch:{ all -> 0x0044 }
        r7 = r12.f3712i;	 Catch:{ all -> 0x0044 }
        r8 = r12.f3709f;	 Catch:{ all -> 0x0044 }
        r0 = r12.f3708e;	 Catch:{ all -> 0x0044 }
        r9 = com.google.android.gms.common.util.C1391q.m4984b(r0);	 Catch:{ all -> 0x0044 }
        r10 = r14;
        r1.m4923a(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0044 }
        r0 = r12.f3716m;	 Catch:{ all -> 0x0044 }
        r0 = r0 + 1;
        r12.f3716m = r0;	 Catch:{ all -> 0x0044 }
    L_0x0042:
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        return;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cx.a(java.lang.String, long):void");
    }

    private void m5661b(WorkSource workSource) {
        try {
            this.f3707d.setWorkSource(workSource);
        } catch (IllegalArgumentException e) {
            Log.wtf(f3704a, e.toString());
        }
    }

    private boolean m5662b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.f3711h)) ? false : true;
    }

    public void m5663a() {
        m5659a(null);
        this.f3707d.release();
    }

    public void m5664a(long j) {
        if (!C1387m.m4961c() && this.f3714k) {
            String str = f3704a;
            String str2 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ";
            String valueOf = String.valueOf(this.f3710g);
            Log.wtf(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        m5660a(null, j);
        this.f3707d.acquire(j);
    }

    public void m5665a(WorkSource workSource) {
        if (workSource != null && C1391q.m4982a(this.f3713j)) {
            if (this.f3708e != null) {
                this.f3708e.add(workSource);
            } else {
                this.f3708e = workSource;
            }
            m5661b(this.f3708e);
        }
    }

    public void m5666a(boolean z) {
        this.f3707d.setReferenceCounted(z);
        this.f3714k = z;
    }

    public boolean m5667b() {
        return this.f3707d.isHeld();
    }
}
