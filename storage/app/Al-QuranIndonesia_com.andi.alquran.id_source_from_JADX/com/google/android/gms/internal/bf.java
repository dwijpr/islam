package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1317j.C1326b;
import com.google.android.gms.common.internal.C1317j.C1327c;
import com.google.android.gms.internal.au.C1444a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class bf {

    /* renamed from: com.google.android.gms.internal.bf.a */
    static class C1470a implements C1326b, C1327c {
        protected bg f3598a;
        private final String f3599b;
        private final String f3600c;
        private final LinkedBlockingQueue<C1444a> f3601d;
        private final HandlerThread f3602e;

        public C1470a(Context context, String str, String str2) {
            this.f3599b = str;
            this.f3600c = str2;
            this.f3602e = new HandlerThread("GassClient");
            this.f3602e.start();
            this.f3598a = new bg(context, this.f3602e.getLooper(), this, this);
            this.f3601d = new LinkedBlockingQueue();
            m5272c();
        }

        public C1444a m5266a() {
            return m5270b(2000);
        }

        public void m5267a(int i) {
            try {
                this.f3601d.put(new C1444a());
            } catch (InterruptedException e) {
            }
        }

        public void m5268a(Bundle bundle) {
            bj b = m5271b();
            if (b != null) {
                try {
                    this.f3601d.put(b.m5286a(new zzapv(this.f3599b, this.f3600c)).m9723b());
                } catch (Throwable th) {
                } finally {
                    m5273d();
                    this.f3602e.quit();
                }
            }
        }

        public void m5269a(ConnectionResult connectionResult) {
            try {
                this.f3601d.put(new C1444a());
            } catch (InterruptedException e) {
            }
        }

        public C1444a m5270b(int i) {
            C1444a c1444a;
            try {
                c1444a = (C1444a) this.f3601d.poll((long) i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                c1444a = null;
            }
            return c1444a == null ? new C1444a() : c1444a;
        }

        protected bj m5271b() {
            try {
                return this.f3598a.m5279k();
            } catch (IllegalStateException e) {
                return null;
            } catch (DeadObjectException e2) {
                return null;
            }
        }

        protected void m5272c() {
            this.f3598a.m4676n();
        }

        public void m5273d() {
            if (this.f3598a == null) {
                return;
            }
            if (this.f3598a.m4666b() || this.f3598a.m4667c()) {
                this.f3598a.m4656a();
            }
        }
    }

    public static C1444a m5274a(Context context, String str, String str2) {
        return new C1470a(context, str, str2).m5266a();
    }
}
