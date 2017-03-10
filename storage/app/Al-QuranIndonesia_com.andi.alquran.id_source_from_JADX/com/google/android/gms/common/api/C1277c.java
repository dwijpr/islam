package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.p014g.C0298a;
import android.view.View;
import com.google.android.gms.common.C1262a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1274a.C1240a;
import com.google.android.gms.common.api.C1274a.C1240a.C1242c;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1268d;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.common.internal.C1338k.C1337a;
import com.google.android.gms.internal.C1727l;
import com.google.android.gms.internal.C2015u;
import com.google.android.gms.internal.aj;
import com.google.android.gms.internal.ck;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cm;
import com.google.android.gms.internal.wk;
import com.google.android.gms.internal.wm.C1475a;
import com.google.android.gms.internal.wp;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.c */
public abstract class C1277c {
    private static final Set<C1277c> f3010a;

    /* renamed from: com.google.android.gms.common.api.c.b */
    public interface C0777b {
        void m2642a(int i);

        void m2643a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.api.c.c */
    public interface C0778c {
        void m2644a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.api.c.a */
    public static final class C1276a {
        private Account f2991a;
        private final Set<Scope> f2992b;
        private final Set<Scope> f2993c;
        private int f2994d;
        private View f2995e;
        private String f2996f;
        private String f2997g;
        private final Map<C1274a<?>, C1337a> f2998h;
        private final Context f2999i;
        private final Map<C1274a<?>, C1240a> f3000j;
        private C2015u f3001k;
        private int f3002l;
        private C0778c f3003m;
        private Looper f3004n;
        private C1262a f3005o;
        private C1266b<? extends cl, cm> f3006p;
        private final ArrayList<C0777b> f3007q;
        private final ArrayList<C0778c> f3008r;
        private boolean f3009s;

        public C1276a(Context context) {
            this.f2992b = new HashSet();
            this.f2993c = new HashSet();
            this.f2998h = new C0298a();
            this.f3000j = new C0298a();
            this.f3002l = -1;
            this.f3005o = C1262a.m4471a();
            this.f3006p = ck.f3683c;
            this.f3007q = new ArrayList();
            this.f3008r = new ArrayList();
            this.f3009s = false;
            this.f2999i = context;
            this.f3004n = context.getMainLooper();
            this.f2996f = context.getPackageName();
            this.f2997g = context.getClass().getName();
        }

        private static <C extends C1269f, O> C m4530a(C1266b<C, O> c1266b, Object obj, Context context, Looper looper, C1338k c1338k, C0777b c0777b, C0778c c0778c) {
            return c1266b.m4510a(context, looper, c1338k, obj, c0777b, c0778c);
        }

        private void m4531a(C1277c c1277c) {
            wk.m9676b(this.f3001k).m9679a(this.f3002l, c1277c, this.f3003m);
        }

        private C1277c m4532c() {
            C1338k a = m4536a();
            C1274a c1274a = null;
            Map e = a.m4736e();
            Map c0298a = new C0298a();
            Map c0298a2 = new C0298a();
            ArrayList arrayList = new ArrayList();
            C1274a c1274a2 = null;
            for (C1274a c1274a3 : this.f3000j.keySet()) {
                C1274a c1274a32;
                Object obj = this.f3000j.get(c1274a32);
                int i = 0;
                if (e.get(c1274a32) != null) {
                    i = ((C1337a) e.get(c1274a32)).f3089b ? 1 : 2;
                }
                c0298a.put(c1274a32, Integer.valueOf(i));
                C0777b wpVar = new wp(c1274a32, i);
                arrayList.add(wpVar);
                C1266b b = c1274a32.m4526b();
                C1274a c1274a4 = b.m4508a() == 1 ? c1274a32 : c1274a2;
                C1269f a2 = C1276a.m4530a(b, obj, this.f2999i, this.f3004n, a, wpVar, wpVar);
                c0298a2.put(c1274a32.m4527c(), a2);
                if (!a2.m4519f()) {
                    c1274a32 = c1274a;
                } else if (c1274a != null) {
                    String valueOf = String.valueOf(c1274a32.m4528d());
                    String valueOf2 = String.valueOf(c1274a.m4528d());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                c1274a2 = c1274a4;
                c1274a = c1274a32;
            }
            if (c1274a != null) {
                if (c1274a2 != null) {
                    valueOf = String.valueOf(c1274a.m4528d());
                    valueOf2 = String.valueOf(c1274a2.m4528d());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                C1314c.m4630a(this.f2991a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", c1274a.m4528d());
                C1314c.m4630a(this.f2992b.equals(this.f2993c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", c1274a.m4528d());
            }
            return new C1727l(this.f2999i, new ReentrantLock(), this.f3004n, a, this.f3005o, this.f3006p, c0298a, this.f3007q, this.f3008r, c0298a2, this.f3002l, C1727l.m7165a(c0298a2.values(), true), arrayList, false);
        }

        public C1276a m4533a(C1274a<? extends C1242c> c1274a) {
            C1314c.m4624a((Object) c1274a, (Object) "Api must not be null");
            this.f3000j.put(c1274a, null);
            Collection a = c1274a.m4525a().m4509a(null);
            this.f2993c.addAll(a);
            this.f2992b.addAll(a);
            return this;
        }

        public C1276a m4534a(C0777b c0777b) {
            C1314c.m4624a((Object) c0777b, (Object) "Listener must not be null");
            this.f3007q.add(c0777b);
            return this;
        }

        public C1276a m4535a(C0778c c0778c) {
            C1314c.m4624a((Object) c0778c, (Object) "Listener must not be null");
            this.f3008r.add(c0778c);
            return this;
        }

        public C1338k m4536a() {
            cm cmVar = cm.f3689a;
            if (this.f3000j.containsKey(ck.f3687g)) {
                cmVar = (cm) this.f3000j.get(ck.f3687g);
            }
            return new C1338k(this.f2991a, this.f2992b, this.f2998h, this.f2994d, this.f2995e, this.f2996f, this.f2997g, cmVar);
        }

        public C1277c m4537b() {
            C1314c.m4633b(!this.f3000j.isEmpty(), "must call addApi() to add at least one API");
            C1277c c = m4532c();
            synchronized (C1277c.f3010a) {
                C1277c.f3010a.add(c);
            }
            if (this.f3002l >= 0) {
                m4531a(c);
            }
            return c;
        }
    }

    static {
        f3010a = Collections.newSetFromMap(new WeakHashMap());
    }

    public Looper m4539a() {
        throw new UnsupportedOperationException();
    }

    public <C extends C1269f> C m4540a(C1268d<C> c1268d) {
        throw new UnsupportedOperationException();
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m4541a(T t) {
        throw new UnsupportedOperationException();
    }

    public void m4542a(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void m4543a(C0778c c0778c);

    public void m4544a(aj ajVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void m4545a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void m4546b();

    public abstract void m4547b(C0778c c0778c);

    public void m4548b(aj ajVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void m4549c();
}
