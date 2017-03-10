package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.p014g.C0298a;
import android.util.Log;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1268d;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.internal.C1504t.C1501a;
import com.google.android.gms.internal.wm.C1475a;
import com.google.android.gms.maps.GoogleMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.internal.c */
final class C1505c implements C1504t {
    private final Context f3654a;
    private final C1727l f3655b;
    private final Looper f3656c;
    private final C1829n f3657d;
    private final C1829n f3658e;
    private final Map<C1268d<?>, C1829n> f3659f;
    private final Set<af> f3660g;
    private final C1269f f3661h;
    private Bundle f3662i;
    private ConnectionResult f3663j;
    private ConnectionResult f3664k;
    private boolean f3665l;
    private final Lock f3666m;
    private int f3667n;

    /* renamed from: com.google.android.gms.internal.c.1 */
    class C15001 implements Runnable {
        final /* synthetic */ C1505c f3651a;

        public void run() {
            this.f3651a.f3666m.lock();
            try {
                this.f3651a.m5508g();
            } finally {
                this.f3651a.f3666m.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.c.a */
    private class C1502a implements C1501a {
        final /* synthetic */ C1505c f3652a;

        private C1502a(C1505c c1505c) {
            this.f3652a = c1505c;
        }

        public void m5478a(int i, boolean z) {
            this.f3652a.f3666m.lock();
            try {
                if (this.f3652a.f3665l || this.f3652a.f3664k == null || !this.f3652a.f3664k.m4452b()) {
                    this.f3652a.f3665l = false;
                    this.f3652a.m5493a(i, z);
                    return;
                }
                this.f3652a.f3665l = true;
                this.f3652a.f3658e.m7743a(i);
                this.f3652a.f3666m.unlock();
            } finally {
                this.f3652a.f3666m.unlock();
            }
        }

        public void m5479a(Bundle bundle) {
            this.f3652a.f3666m.lock();
            try {
                this.f3652a.m5494a(bundle);
                this.f3652a.f3663j = ConnectionResult.f2957a;
                this.f3652a.m5508g();
            } finally {
                this.f3652a.f3666m.unlock();
            }
        }

        public void m5480a(ConnectionResult connectionResult) {
            this.f3652a.f3666m.lock();
            try {
                this.f3652a.f3663j = connectionResult;
                this.f3652a.m5508g();
            } finally {
                this.f3652a.f3666m.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.c.b */
    private class C1503b implements C1501a {
        final /* synthetic */ C1505c f3653a;

        private C1503b(C1505c c1505c) {
            this.f3653a = c1505c;
        }

        public void m5481a(int i, boolean z) {
            this.f3653a.f3666m.lock();
            try {
                if (this.f3653a.f3665l) {
                    this.f3653a.f3665l = false;
                    this.f3653a.m5493a(i, z);
                    return;
                }
                this.f3653a.f3665l = true;
                this.f3653a.f3657d.m7743a(i);
                this.f3653a.f3666m.unlock();
            } finally {
                this.f3653a.f3666m.unlock();
            }
        }

        public void m5482a(Bundle bundle) {
            this.f3653a.f3666m.lock();
            try {
                this.f3653a.f3664k = ConnectionResult.f2957a;
                this.f3653a.m5508g();
            } finally {
                this.f3653a.f3666m.unlock();
            }
        }

        public void m5483a(ConnectionResult connectionResult) {
            this.f3653a.f3666m.lock();
            try {
                this.f3653a.f3664k = connectionResult;
                this.f3653a.m5508g();
            } finally {
                this.f3653a.f3666m.unlock();
            }
        }
    }

    private C1505c(Context context, C1727l c1727l, Lock lock, Looper looper, C1261h c1261h, Map<C1268d<?>, C1269f> map, Map<C1268d<?>, C1269f> map2, C1338k c1338k, C1266b<? extends cl, cm> c1266b, C1269f c1269f, ArrayList<wp> arrayList, ArrayList<wp> arrayList2, Map<C1274a<?>, Integer> map3, Map<C1274a<?>, Integer> map4) {
        this.f3660g = Collections.newSetFromMap(new WeakHashMap());
        this.f3663j = null;
        this.f3664k = null;
        this.f3665l = false;
        this.f3667n = 0;
        this.f3654a = context;
        this.f3655b = c1727l;
        this.f3666m = lock;
        this.f3656c = looper;
        this.f3661h = c1269f;
        this.f3657d = new C1829n(context, this.f3655b, lock, looper, c1261h, map2, null, map4, null, arrayList2, new C1502a());
        this.f3658e = new C1829n(context, this.f3655b, lock, looper, c1261h, map, c1338k, map3, c1266b, arrayList, new C1503b());
        Map c0298a = new C0298a();
        for (C1268d put : map2.keySet()) {
            c0298a.put(put, this.f3657d);
        }
        for (C1268d put2 : map.keySet()) {
            c0298a.put(put2, this.f3658e);
        }
        this.f3659f = Collections.unmodifiableMap(c0298a);
    }

    public static C1505c m5491a(Context context, C1727l c1727l, Lock lock, Looper looper, C1261h c1261h, Map<C1268d<?>, C1269f> map, C1338k c1338k, Map<C1274a<?>, Integer> map2, C1266b<? extends cl, cm> c1266b, ArrayList<wp> arrayList) {
        C1269f c1269f = null;
        Map c0298a = new C0298a();
        Map c0298a2 = new C0298a();
        for (Entry entry : map.entrySet()) {
            C1269f c1269f2 = (C1269f) entry.getValue();
            if (c1269f2.m4519f()) {
                c1269f = c1269f2;
            }
            if (c1269f2.m4517d()) {
                c0298a.put((C1268d) entry.getKey(), c1269f2);
            } else {
                c0298a2.put((C1268d) entry.getKey(), c1269f2);
            }
        }
        C1314c.m4629a(!c0298a.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map c0298a3 = new C0298a();
        Map c0298a4 = new C0298a();
        for (C1274a c1274a : map2.keySet()) {
            C1268d c = c1274a.m4527c();
            if (c0298a.containsKey(c)) {
                c0298a3.put(c1274a, (Integer) map2.get(c1274a));
            } else if (c0298a2.containsKey(c)) {
                c0298a4.put(c1274a, (Integer) map2.get(c1274a));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            wp wpVar = (wp) it.next();
            if (c0298a3.containsKey(wpVar.f6337a)) {
                arrayList2.add(wpVar);
            } else if (c0298a4.containsKey(wpVar.f6337a)) {
                arrayList3.add(wpVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new C1505c(context, c1727l, lock, looper, c1261h, c0298a, c0298a2, c1338k, c1266b, c1269f, arrayList2, arrayList3, c0298a3, c0298a4);
    }

    private void m5493a(int i, boolean z) {
        this.f3655b.m7177a(i, z);
        this.f3664k = null;
        this.f3663j = null;
    }

    private void m5494a(Bundle bundle) {
        if (this.f3662i == null) {
            this.f3662i = bundle;
        } else if (bundle != null) {
            this.f3662i.putAll(bundle);
        }
    }

    private void m5495a(ConnectionResult connectionResult) {
        switch (this.f3667n) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                this.f3655b.m7179a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m5510i();
        this.f3667n = 0;
    }

    private static boolean m5501b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m4452b();
    }

    private boolean m5502b(C1475a<? extends C1263g, ? extends C1267c> c1475a) {
        C1268d b = c1475a.m5321b();
        C1314c.m4633b(this.f3659f.containsKey(b), "GoogleApiClient is not configured to use the API required for this call.");
        return ((C1829n) this.f3659f.get(b)).equals(this.f3658e);
    }

    private void m5507f() {
        this.f3664k = null;
        this.f3663j = null;
        this.f3657d.m7742a();
        this.f3658e.m7742a();
    }

    private void m5508g() {
        if (C1505c.m5501b(this.f3663j)) {
            if (C1505c.m5501b(this.f3664k) || m5511j()) {
                m5509h();
            } else if (this.f3664k == null) {
            } else {
                if (this.f3667n == 1) {
                    m5510i();
                    return;
                }
                m5495a(this.f3664k);
                this.f3657d.m7750b();
            }
        } else if (this.f3663j != null && C1505c.m5501b(this.f3664k)) {
            this.f3658e.m7750b();
            m5495a(this.f3663j);
        } else if (this.f3663j != null && this.f3664k != null) {
            ConnectionResult connectionResult = this.f3663j;
            if (this.f3658e.f5074f < this.f3657d.f5074f) {
                connectionResult = this.f3664k;
            }
            m5495a(connectionResult);
        }
    }

    private void m5509h() {
        switch (this.f3667n) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                this.f3655b.m7178a(this.f3662i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        m5510i();
        this.f3667n = 0;
    }

    private void m5510i() {
        for (af a : this.f3660g) {
            a.m5047a();
        }
        this.f3660g.clear();
    }

    private boolean m5511j() {
        return this.f3664k != null && this.f3664k.m4453c() == 4;
    }

    private PendingIntent m5512k() {
        return this.f3661h == null ? null : PendingIntent.getActivity(this.f3654a, this.f3655b.m7194k(), this.f3661h.m4520g(), 134217728);
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m5513a(T t) {
        if (!m5502b((C1475a) t)) {
            return this.f3657d.m7741a((C1475a) t);
        }
        if (!m5511j()) {
            return this.f3658e.m7741a((C1475a) t);
        }
        t.m5324c(new Status(4, null, m5512k()));
        return t;
    }

    public void m5514a() {
        this.f3667n = 2;
        this.f3665l = false;
        m5507f();
    }

    public void m5515a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f3658e.m7749a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f3657d.m7749a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public void m5516b() {
        this.f3664k = null;
        this.f3663j = null;
        this.f3667n = 0;
        this.f3657d.m7750b();
        this.f3658e.m7750b();
        m5510i();
    }

    public boolean m5517c() {
        boolean z = true;
        this.f3666m.lock();
        try {
            if (!(this.f3657d.m7751c() && (m5519e() || m5511j() || this.f3667n == 1))) {
                z = false;
            }
            this.f3666m.unlock();
            return z;
        } catch (Throwable th) {
            this.f3666m.unlock();
        }
    }

    public void m5518d() {
        this.f3657d.m7752d();
        this.f3658e.m7752d();
    }

    public boolean m5519e() {
        return this.f3658e.m7751c();
    }
}
