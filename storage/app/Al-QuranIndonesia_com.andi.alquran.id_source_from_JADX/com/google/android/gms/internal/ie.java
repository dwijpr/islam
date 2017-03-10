package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.C1295j;
import java.util.concurrent.Callable;

@op
public class ie {
    private final Object f4332a;
    private final ConditionVariable f4333b;
    private volatile boolean f4334c;
    private SharedPreferences f4335d;

    /* renamed from: com.google.android.gms.internal.ie.1 */
    class C16461 implements Callable<T> {
        final /* synthetic */ ib f4330a;
        final /* synthetic */ ie f4331b;

        C16461(ie ieVar, ib ibVar) {
            this.f4331b = ieVar;
            this.f4330a = ibVar;
        }

        public T call() {
            return this.f4330a.m6679a(this.f4331b.f4335d);
        }
    }

    public ie() {
        this.f4332a = new Object();
        this.f4333b = new ConditionVariable();
        this.f4334c = false;
        this.f4335d = null;
    }

    public <T> T m6700a(ib<T> ibVar) {
        if (this.f4333b.block(5000)) {
            if (!this.f4334c) {
                synchronized (this.f4332a) {
                    if (this.f4334c) {
                    } else {
                        T b = ibVar.m6681b();
                        return b;
                    }
                }
            }
            return sd.m8680a(new C16461(this, ibVar));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }

    public void m6701a(Context context) {
        if (!this.f4334c) {
            synchronized (this.f4332a) {
                if (this.f4334c) {
                    return;
                }
                try {
                    Context i = C1295j.m4592i(context);
                    if (i == null) {
                        return;
                    }
                    this.f4335d = zzv.zzcT().m6698a(i);
                    this.f4334c = true;
                    this.f4333b.open();
                } finally {
                    this.f4333b.open();
                }
            }
        }
    }
}
