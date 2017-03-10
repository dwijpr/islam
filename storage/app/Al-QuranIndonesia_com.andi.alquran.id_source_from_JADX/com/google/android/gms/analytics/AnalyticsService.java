package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.vm;
import com.google.android.gms.internal.vm.C1202a;

public final class AnalyticsService extends Service implements C1202a {
    private vm f2801a;

    private vm m4181b() {
        if (this.f2801a == null) {
            this.f2801a = new vm(this);
        }
        return this.f2801a;
    }

    public Context m4182a() {
        return this;
    }

    public boolean m4183a(int i) {
        return stopSelfResult(i);
    }

    public IBinder onBind(Intent intent) {
        m4181b();
        return null;
    }

    public void onCreate() {
        super.onCreate();
        m4181b().m9499a();
    }

    public void onDestroy() {
        m4181b().m9500b();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return m4181b().m9498a(intent, i, i2);
    }
}
