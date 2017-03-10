package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.util.Log;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1286l;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.C1895p.C1892a;
import com.google.android.gms.internal.C2078x.C2077b;
import com.google.android.gms.internal.wm.C1475a;
import com.google.android.gms.p042b.C1252e;

public abstract class wh {
    public final int f6316a;

    /* renamed from: com.google.android.gms.internal.wh.a */
    private static abstract class C2066a extends wh {
        protected final C1252e<Void> f6317b;

        public C2066a(int i, C1252e<Void> c1252e) {
            super(i);
            this.f6317b = c1252e;
        }

        public void m9660a(Status status) {
            this.f6317b.m4429b(new C1286l(status));
        }

        public void m9661a(C1543f c1543f, boolean z) {
        }

        public final void m9662a(C1892a<?> c1892a) {
            try {
                m9663b(c1892a);
            } catch (RemoteException e) {
                m9660a(wh.m9656b(e));
                throw e;
            } catch (RemoteException e2) {
                m9660a(wh.m9656b(e2));
            }
        }

        protected abstract void m9663b(C1892a<?> c1892a);
    }

    /* renamed from: com.google.android.gms.internal.wh.b */
    public static class C2067b<A extends C1475a<? extends C1263g, C1267c>> extends wh {
        protected final A f6318b;

        public C2067b(int i, A a) {
            super(i);
            this.f6318b = a;
        }

        public void m9664a(Status status) {
            this.f6318b.m5324c(status);
        }

        public void m9665a(C1543f c1543f, boolean z) {
            c1543f.m6039a(this.f6318b, z);
        }

        public void m9666a(C1892a<?> c1892a) {
            this.f6318b.m5322b(c1892a.m8013b());
        }
    }

    /* renamed from: com.google.android.gms.internal.wh.c */
    public static final class C2068c extends C2066a {
        public final C2077b<?> f6319c;

        public C2068c(C2077b<?> c2077b, C1252e<Void> c1252e) {
            super(4, c1252e);
            this.f6319c = c2077b;
        }

        public /* bridge */ /* synthetic */ void m9667a(Status status) {
            super.m9660a(status);
        }

        public /* bridge */ /* synthetic */ void m9668a(C1543f c1543f, boolean z) {
            super.m9661a(c1543f, z);
        }

        public void m9669b(C1892a<?> c1892a) {
            ac acVar = (ac) c1892a.m8015c().remove(this.f6319c);
            if (acVar != null) {
                acVar.f3277a.m5041a();
                return;
            }
            Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
            this.b.m4429b(new C1286l(Status.f2977c));
        }
    }

    public wh(int i) {
        this.f6316a = i;
    }

    private static Status m9656b(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        if (C1387m.m4962d() && (remoteException instanceof TransactionTooLargeException)) {
            stringBuilder.append("TransactionTooLargeException: ");
        }
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(8, stringBuilder.toString());
    }

    public abstract void m9657a(Status status);

    public abstract void m9658a(C1543f c1543f, boolean z);

    public abstract void m9659a(C1892a<?> c1892a);
}
