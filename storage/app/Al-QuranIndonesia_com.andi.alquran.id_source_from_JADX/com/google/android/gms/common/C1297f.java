package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.C1314c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.common.f */
public class C1297f implements ServiceConnection {
    boolean f3033a;
    private final BlockingQueue<IBinder> f3034b;

    public C1297f() {
        this.f3033a = false;
        this.f3034b = new LinkedBlockingQueue();
    }

    public IBinder m4598a(long j, TimeUnit timeUnit) {
        C1314c.m4635c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f3033a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f3033a = true;
        IBinder iBinder = (IBinder) this.f3034b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3034b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
