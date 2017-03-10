package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1268d;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1314c;

public class wm {

    /* renamed from: com.google.android.gms.internal.wm.b */
    public interface C1474b<R> {
        void m5317a(R r);
    }

    /* renamed from: com.google.android.gms.internal.wm.a */
    public static abstract class C1475a<R extends C1263g, A extends C1267c> extends wo<R> implements C1474b<R> {
        private final C1268d<A> f3619a;
        private final C1274a<?> f3620b;

        protected C1475a(C1274a<?> c1274a, C1277c c1277c) {
            super((C1277c) C1314c.m4624a((Object) c1277c, (Object) "GoogleApiClient must not be null"));
            this.f3619a = c1274a.m4527c();
            this.f3620b = c1274a;
        }

        private void m5318a(RemoteException remoteException) {
            m5324c(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void m5319a(A a);

        public /* synthetic */ void m5320a(Object obj) {
            super.m5076a((C1263g) obj);
        }

        public final C1268d<A> m5321b() {
            return this.f3619a;
        }

        public final void m5322b(A a) {
            try {
                m5319a((C1267c) a);
            } catch (RemoteException e) {
                m5318a(e);
                throw e;
            } catch (RemoteException e2) {
                m5318a(e2);
            }
        }

        public final C1274a<?> m5323c() {
            return this.f3620b;
        }

        public final void m5324c(Status status) {
            C1314c.m4633b(!status.m4505d(), "Failed result must not be success");
            m5076a(m5079b(status));
        }
    }
}
