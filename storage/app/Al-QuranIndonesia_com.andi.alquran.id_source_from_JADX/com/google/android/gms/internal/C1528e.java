package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v4.p014g.C0298a;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1268d;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1287m;
import com.google.android.gms.common.api.C1288n;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.common.internal.C1338k.C1337a;
import com.google.android.gms.internal.wm.C1475a;
import com.google.android.gms.p042b.C1248a;
import com.google.android.gms.p042b.C1249b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.internal.e */
public class C1528e implements C1504t {
    private final Map<C1268d<?>, C1288n<?>> f3831a;
    private final Map<C1274a<?>, Integer> f3832b;
    private final C1895p f3833c;
    private final C1727l f3834d;
    private final Lock f3835e;
    private final Looper f3836f;
    private final C1261h f3837g;
    private final Condition f3838h;
    private final C1338k f3839i;
    private boolean f3840j;
    private Map<wj<?>, ConnectionResult> f3841k;
    private ConnectionResult f3842l;

    /* renamed from: com.google.android.gms.internal.e.a */
    private class C1527a implements C1248a, C1249b<Void> {
        final /* synthetic */ C1528e f3830a;

        private C1527a(C1528e c1528e) {
            this.f3830a = c1528e;
        }

        private ConnectionResult m5854a() {
            ConnectionResult connectionResult = null;
            int i = 0;
            for (C1274a c1274a : this.f3830a.f3832b.keySet()) {
                ConnectionResult connectionResult2 = (ConnectionResult) this.f3830a.f3841k.get(((C1288n) this.f3830a.f3831a.get(c1274a.m4527c())).m4565a());
                if (!connectionResult2.m4452b()) {
                    int intValue = ((Integer) this.f3830a.f3832b.get(c1274a)).intValue();
                    if (intValue != 2 && (intValue != 1 || connectionResult2.m4451a() || this.f3830a.f3837g.m4463a(connectionResult2.m4453c()))) {
                        int a = c1274a.m4525a().m4508a();
                        if (connectionResult != null && i <= a) {
                            a = i;
                            connectionResult2 = connectionResult;
                        }
                        i = a;
                        connectionResult = connectionResult2;
                    }
                }
            }
            return connectionResult;
        }

        private void m5855b() {
            if (this.f3830a.f3839i == null) {
                this.f3830a.f3834d.f4687d = Collections.emptySet();
                return;
            }
            Set hashSet = new HashSet(this.f3830a.f3839i.m4734c());
            Map e = this.f3830a.f3839i.m4736e();
            for (C1274a c1274a : e.keySet()) {
                ConnectionResult connectionResult = (ConnectionResult) this.f3830a.f3841k.get(((C1288n) this.f3830a.f3831a.get(c1274a.m4527c())).m4565a());
                if (connectionResult != null && connectionResult.m4452b()) {
                    hashSet.addAll(((C1337a) e.get(c1274a)).f3088a);
                }
            }
            this.f3830a.f3834d.f4687d = hashSet;
        }

        public void m5856a(Exception exception) {
            C1287m c1287m = (C1287m) exception;
            this.f3830a.f3835e.lock();
            try {
                this.f3830a.f3841k = c1287m.m4561a();
                this.f3830a.f3842l = m5854a();
                if (this.f3830a.f3842l == null) {
                    m5855b();
                    this.f3830a.f3834d.m7178a(null);
                } else {
                    this.f3830a.f3840j = false;
                    this.f3830a.f3834d.m7179a(this.f3830a.f3842l);
                }
                this.f3830a.f3838h.signalAll();
            } finally {
                this.f3830a.f3835e.unlock();
            }
        }

        public /* synthetic */ void m5857a(Object obj) {
            m5858a((Void) obj);
        }

        public void m5858a(Void voidR) {
            this.f3830a.f3835e.lock();
            try {
                this.f3830a.f3841k = new C0298a(this.f3830a.f3831a.size());
                for (C1268d c1268d : this.f3830a.f3831a.keySet()) {
                    this.f3830a.f3841k.put(((C1288n) this.f3830a.f3831a.get(c1268d)).m4565a(), ConnectionResult.f2957a);
                }
                m5855b();
                this.f3830a.f3834d.m7178a(null);
                this.f3830a.f3838h.signalAll();
            } finally {
                this.f3830a.f3835e.unlock();
            }
        }
    }

    public C1528e(Context context, Lock lock, Looper looper, C1261h c1261h, Map<C1268d<?>, C1269f> map, C1338k c1338k, Map<C1274a<?>, Integer> map2, C1266b<? extends cl, cm> c1266b, ArrayList<wp> arrayList, C1727l c1727l) {
        this.f3831a = new HashMap();
        this.f3835e = lock;
        this.f3836f = looper;
        this.f3838h = lock.newCondition();
        this.f3837g = c1261h;
        this.f3834d = c1727l;
        this.f3832b = map2;
        this.f3839i = c1338k;
        Map hashMap = new HashMap();
        for (C1274a c1274a : map2.keySet()) {
            hashMap.put(c1274a.m4527c(), c1274a);
        }
        Map hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            wp wpVar = (wp) it.next();
            hashMap2.put(wpVar.f6337a, wpVar);
        }
        for (Entry entry : map.entrySet()) {
            C1274a c1274a2 = (C1274a) hashMap.get(entry.getKey());
            C1269f c1269f = (C1269f) entry.getValue();
            wp wpVar2 = (wp) hashMap2.get(c1274a2);
            this.f3831a.put((C1268d) entry.getKey(), new C1517d(context, c1274a2, looper, c1269f, wpVar2, c1338k, c1266b));
        }
        this.f3833c = C1895p.m8035a();
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m5871a(T t) {
        this.f3834d.f4692i.m5111a((wo) t);
        return ((C1288n) this.f3831a.get(t.m5321b())).m4566a(t);
    }

    public void m5872a() {
        this.f3835e.lock();
        try {
            if (!this.f3840j) {
                this.f3840j = true;
                this.f3841k = null;
                this.f3842l = null;
                C1248a c1527a = new C1527a();
                Executor anVar = new an(this.f3836f);
                this.f3833c.m8055a(this.f3831a.values()).m4422a(anVar, (C1249b) c1527a).m4421a(anVar, c1527a);
                this.f3835e.unlock();
            }
        } finally {
            this.f3835e.unlock();
        }
    }

    public void m5873a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void m5874b() {
        this.f3835e.lock();
        try {
            this.f3840j = false;
            this.f3841k = null;
            this.f3842l = null;
            this.f3838h.signalAll();
        } finally {
            this.f3835e.unlock();
        }
    }

    public boolean m5875c() {
        this.f3835e.lock();
        try {
            boolean z = this.f3841k != null && this.f3842l == null;
            this.f3835e.unlock();
            return z;
        } catch (Throwable th) {
            this.f3835e.unlock();
        }
    }

    public void m5876d() {
    }
}
