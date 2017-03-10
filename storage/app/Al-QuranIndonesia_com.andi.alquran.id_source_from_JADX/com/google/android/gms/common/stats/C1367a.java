package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.stats.C1369b.C1368a;
import com.google.android.gms.common.util.C1376b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.a */
public class C1367a {
    private static final Object f3188a;
    private static C1367a f3189b;
    private static Integer f3190h;
    private final List<String> f3191c;
    private final List<String> f3192d;
    private final List<String> f3193e;
    private final List<String> f3194f;
    private C1371d f3195g;
    private C1371d f3196i;

    static {
        f3188a = new Object();
    }

    private C1367a() {
        if (m4906b()) {
            this.f3191c = Collections.EMPTY_LIST;
            this.f3192d = Collections.EMPTY_LIST;
            this.f3193e = Collections.EMPTY_LIST;
            this.f3194f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) C1368a.f3198b.m5119a();
        this.f3191c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1368a.f3199c.m5119a();
        this.f3192d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1368a.f3200d.m5119a();
        this.f3193e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1368a.f3201e.m5119a();
        this.f3194f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.f3195g = new C1371d(1024, ((Long) C1368a.f3202f.m5119a()).longValue());
        this.f3196i = new C1371d(1024, ((Long) C1368a.f3202f.m5119a()).longValue());
    }

    public static C1367a m4904a() {
        synchronized (f3188a) {
            if (f3189b == null) {
                f3189b = new C1367a();
            }
        }
        return f3189b;
    }

    private boolean m4905a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? false : C1376b.m4925a(context, component.getPackageName());
    }

    private boolean m4906b() {
        return C1367a.m4907c() == C1370c.f3206b;
    }

    private static int m4907c() {
        if (f3190h == null) {
            try {
                f3190h = Integer.valueOf(C1370c.f3206b);
            } catch (SecurityException e) {
                f3190h = Integer.valueOf(C1370c.f3206b);
            }
        }
        return f3190h.intValue();
    }

    @SuppressLint({"UntrackedBindService"})
    public void m4908a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public void m4909a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
    }

    public boolean m4910a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m4911a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean m4911a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (!m4905a(context, intent)) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public void m4912b(Context context, ServiceConnection serviceConnection) {
    }
}
