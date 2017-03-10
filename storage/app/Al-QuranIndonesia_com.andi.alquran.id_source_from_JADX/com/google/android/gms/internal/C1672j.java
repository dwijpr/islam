package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1268d;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1308t;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1317j.C1329f;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.common.internal.C1338k.C1337a;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.internal.C1829n.C1636a;
import com.google.android.gms.internal.wm.C1475a;
import com.google.android.gms.maps.GoogleMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.internal.j */
public class C1672j implements C1639m {
    private final C1829n f4492a;
    private final Lock f4493b;
    private final Context f4494c;
    private final C1261h f4495d;
    private ConnectionResult f4496e;
    private int f4497f;
    private int f4498g;
    private int f4499h;
    private final Bundle f4500i;
    private final Set<C1268d> f4501j;
    private cl f4502k;
    private int f4503l;
    private boolean f4504m;
    private boolean f4505n;
    private C1308t f4506o;
    private boolean f4507p;
    private boolean f4508q;
    private final C1338k f4509r;
    private final Map<C1274a<?>, Integer> f4510s;
    private final C1266b<? extends cl, cm> f4511t;
    private ArrayList<Future<?>> f4512u;

    /* renamed from: com.google.android.gms.internal.j.1 */
    class C16621 implements Runnable {
        final /* synthetic */ C1672j f4476a;

        C16621(C1672j c1672j) {
            this.f4476a = c1672j;
        }

        public void run() {
            this.f4476a.f4495d.m4470d(this.f4476a.f4494c);
        }
    }

    /* renamed from: com.google.android.gms.internal.j.a */
    private static class C1663a implements C1329f {
        private final WeakReference<C1672j> f4477a;
        private final C1274a<?> f4478b;
        private final int f4479c;

        public C1663a(C1672j c1672j, C1274a<?> c1274a, int i) {
            this.f4477a = new WeakReference(c1672j);
            this.f4478b = c1274a;
            this.f4479c = i;
        }

        public void m6849a(ConnectionResult connectionResult) {
            boolean z = false;
            C1672j c1672j = (C1672j) this.f4477a.get();
            if (c1672j != null) {
                if (Looper.myLooper() == c1672j.f4492a.f5075g.m7173a()) {
                    z = true;
                }
                C1314c.m4629a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                c1672j.f4493b.lock();
                try {
                    if (c1672j.m6871b(0)) {
                        if (!connectionResult.m4452b()) {
                            c1672j.m6870b(connectionResult, this.f4478b, this.f4479c);
                        }
                        if (c1672j.m6878d()) {
                            c1672j.m6879e();
                        }
                        c1672j.f4493b.unlock();
                    }
                } finally {
                    c1672j.f4493b.unlock();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.j.f */
    private abstract class C1666f implements Runnable {
        final /* synthetic */ C1672j f4483b;

        private C1666f(C1672j c1672j) {
            this.f4483b = c1672j;
        }

        protected abstract void m6852a();

        public void run() {
            this.f4483b.f4493b.lock();
            try {
                if (!Thread.interrupted()) {
                    m6852a();
                    this.f4483b.f4493b.unlock();
                }
            } catch (RuntimeException e) {
                this.f4483b.f4492a.m7748a(e);
            } finally {
                this.f4483b.f4493b.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.j.b */
    private class C1667b extends C1666f {
        final /* synthetic */ C1672j f4484a;
        private final Map<C1269f, C1663a> f4485c;

        /* renamed from: com.google.android.gms.internal.j.b.1 */
        class C16641 extends C1636a {
            final /* synthetic */ ConnectionResult f4480a;
            final /* synthetic */ C1667b f4481b;

            C16641(C1667b c1667b, C1639m c1639m, ConnectionResult connectionResult) {
                this.f4481b = c1667b;
                this.f4480a = connectionResult;
                super(c1639m);
            }

            public void m6850a() {
                this.f4481b.f4484a.m6876c(this.f4480a);
            }
        }

        /* renamed from: com.google.android.gms.internal.j.b.2 */
        class C16652 extends C1636a {
            final /* synthetic */ C1329f f4482a;

            C16652(C1667b c1667b, C1639m c1639m, C1329f c1329f) {
                this.f4482a = c1329f;
                super(c1639m);
            }

            public void m6851a() {
                this.f4482a.m4718a(new ConnectionResult(16, null));
            }
        }

        public C1667b(C1672j c1672j, Map<C1269f, C1663a> map) {
            this.f4484a = c1672j;
            super(null);
            this.f4485c = map;
        }

        public void m6853a() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (C1269f c1269f : this.f4485c.keySet()) {
                if (!c1269f.m4518e()) {
                    i = 0;
                    i4 = i5;
                } else if (((C1663a) this.f4485c.get(c1269f)).f4479c == 0) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = this.f4484a.f4495d.m4460a(this.f4484a.f4494c);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (this.f4484a.f4504m) {
                    this.f4484a.f4502k.m5556l();
                }
                for (C1269f c1269f2 : this.f4485c.keySet()) {
                    C1329f c1329f = (C1329f) this.f4485c.get(c1269f2);
                    if (!c1269f2.m4518e() || i3 == 0) {
                        c1269f2.m4512a(c1329f);
                    } else {
                        this.f4484a.f4492a.m7747a(new C16652(this, this.f4484a, c1329f));
                    }
                }
                return;
            }
            this.f4484a.f4492a.m7747a(new C16641(this, this.f4484a, new ConnectionResult(i3, null)));
        }
    }

    /* renamed from: com.google.android.gms.internal.j.c */
    private class C1668c extends C1666f {
        final /* synthetic */ C1672j f4486a;
        private final ArrayList<C1269f> f4487c;

        public C1668c(C1672j c1672j, ArrayList<C1269f> arrayList) {
            this.f4486a = c1672j;
            super(null);
            this.f4487c = arrayList;
        }

        public void m6854a() {
            this.f4486a.f4492a.f5075g.f4687d = this.f4486a.m6889j();
            Iterator it = this.f4487c.iterator();
            while (it.hasNext()) {
                ((C1269f) it.next()).m4513a(this.f4486a.f4506o, this.f4486a.f4492a.f5075g.f4687d);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.j.d */
    private static class C1670d extends co {
        private final WeakReference<C1672j> f4490a;

        /* renamed from: com.google.android.gms.internal.j.d.1 */
        class C16691 extends C1636a {
            final /* synthetic */ C1672j f4488a;
            final /* synthetic */ zzayb f4489b;

            C16691(C1670d c1670d, C1639m c1639m, C1672j c1672j, zzayb com_google_android_gms_internal_zzayb) {
                this.f4488a = c1672j;
                this.f4489b = com_google_android_gms_internal_zzayb;
                super(c1639m);
            }

            public void m6855a() {
                this.f4488a.m6864a(this.f4489b);
            }
        }

        C1670d(C1672j c1672j) {
            this.f4490a = new WeakReference(c1672j);
        }

        public void m6856a(zzayb com_google_android_gms_internal_zzayb) {
            C1672j c1672j = (C1672j) this.f4490a.get();
            if (c1672j != null) {
                c1672j.f4492a.m7747a(new C16691(this, c1672j, c1672j, com_google_android_gms_internal_zzayb));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.j.e */
    private class C1671e implements C0777b, C0778c {
        final /* synthetic */ C1672j f4491a;

        private C1671e(C1672j c1672j) {
            this.f4491a = c1672j;
        }

        public void m6857a(int i) {
        }

        public void m6858a(Bundle bundle) {
            this.f4491a.f4502k.m5554a(new C1670d(this.f4491a));
        }

        public void m6859a(ConnectionResult connectionResult) {
            this.f4491a.f4493b.lock();
            try {
                if (this.f4491a.m6872b(connectionResult)) {
                    this.f4491a.m6886h();
                    this.f4491a.m6879e();
                } else {
                    this.f4491a.m6876c(connectionResult);
                }
                this.f4491a.f4493b.unlock();
            } catch (Throwable th) {
                this.f4491a.f4493b.unlock();
            }
        }
    }

    public C1672j(C1829n c1829n, C1338k c1338k, Map<C1274a<?>, Integer> map, C1261h c1261h, C1266b<? extends cl, cm> c1266b, Lock lock, Context context) {
        this.f4498g = 0;
        this.f4500i = new Bundle();
        this.f4501j = new HashSet();
        this.f4512u = new ArrayList();
        this.f4492a = c1829n;
        this.f4509r = c1338k;
        this.f4510s = map;
        this.f4495d = c1261h;
        this.f4511t = c1266b;
        this.f4493b = lock;
        this.f4494c = context;
    }

    private void m6864a(zzayb com_google_android_gms_internal_zzayb) {
        if (m6871b(0)) {
            ConnectionResult a = com_google_android_gms_internal_zzayb.m9759a();
            if (a.m4452b()) {
                zzaf b = com_google_android_gms_internal_zzayb.m9760b();
                ConnectionResult b2 = b.m4872b();
                if (b2.m4452b()) {
                    this.f4505n = true;
                    this.f4506o = b.m4871a();
                    this.f4507p = b.m4873c();
                    this.f4508q = b.m4874d();
                    m6879e();
                    return;
                }
                String valueOf = String.valueOf(b2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                m6876c(b2);
            } else if (m6872b(a)) {
                m6886h();
                m6879e();
            } else {
                m6876c(a);
            }
        }
    }

    private void m6865a(boolean z) {
        if (this.f4502k != null) {
            if (this.f4502k.m4515b() && z) {
                this.f4502k.m5555k();
            }
            this.f4502k.m4511a();
            this.f4506o = null;
        }
    }

    private boolean m6866a(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || m6867a(connectionResult)) ? this.f4496e == null || i < this.f4497f : false;
    }

    private boolean m6867a(ConnectionResult connectionResult) {
        return connectionResult.m4451a() || this.f4495d.m4466b(connectionResult.m4453c()) != null;
    }

    private void m6870b(ConnectionResult connectionResult, C1274a<?> c1274a, int i) {
        if (i != 2) {
            int a = c1274a.m4525a().m4508a();
            if (m6866a(a, i, connectionResult)) {
                this.f4496e = connectionResult;
                this.f4497f = a;
            }
        }
        this.f4492a.f5070b.put(c1274a.m4527c(), connectionResult);
    }

    private boolean m6871b(int i) {
        if (this.f4498g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f4492a.f5075g.m7193j());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.f4499h);
        valueOf = String.valueOf(m6874c(this.f4498g));
        String valueOf2 = String.valueOf(m6874c(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        m6876c(new ConnectionResult(8, null));
        return false;
    }

    private boolean m6872b(ConnectionResult connectionResult) {
        return this.f4503l != 2 ? this.f4503l == 1 && !connectionResult.m4451a() : true;
    }

    private String m6874c(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void m6876c(ConnectionResult connectionResult) {
        m6887i();
        m6865a(!connectionResult.m4451a());
        this.f4492a.m7745a(connectionResult);
        this.f4492a.f5076h.m5477a(connectionResult);
    }

    private boolean m6878d() {
        this.f4499h--;
        if (this.f4499h > 0) {
            return false;
        }
        if (this.f4499h < 0) {
            Log.w("GoogleApiClientConnecting", this.f4492a.f5075g.m7193j());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m6876c(new ConnectionResult(8, null));
            return false;
        } else if (this.f4496e == null) {
            return true;
        } else {
            this.f4492a.f5074f = this.f4497f;
            m6876c(this.f4496e);
            return false;
        }
    }

    private void m6879e() {
        if (this.f4499h == 0) {
            if (!this.f4504m || this.f4505n) {
                m6882f();
            }
        }
    }

    private void m6882f() {
        ArrayList arrayList = new ArrayList();
        this.f4498g = 1;
        this.f4499h = this.f4492a.f5069a.size();
        for (C1268d c1268d : this.f4492a.f5069a.keySet()) {
            if (!this.f4492a.f5070b.containsKey(c1268d)) {
                arrayList.add((C1269f) this.f4492a.f5069a.get(c1268d));
            } else if (m6878d()) {
                m6884g();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f4512u.add(C1848o.m7816a().submit(new C1668c(this, arrayList)));
        }
    }

    private void m6884g() {
        this.f4492a.m7754f();
        C1848o.m7816a().execute(new C16621(this));
        if (this.f4502k != null) {
            if (this.f4507p) {
                this.f4502k.m5553a(this.f4506o, this.f4508q);
            }
            m6865a(false);
        }
        for (C1268d c1268d : this.f4492a.f5070b.keySet()) {
            ((C1269f) this.f4492a.f5069a.get(c1268d)).m4511a();
        }
        this.f4492a.f5076h.m5476a(this.f4500i.isEmpty() ? null : this.f4500i);
    }

    private void m6886h() {
        this.f4504m = false;
        this.f4492a.f5075g.f4687d = Collections.emptySet();
        for (C1268d c1268d : this.f4501j) {
            if (!this.f4492a.f5070b.containsKey(c1268d)) {
                this.f4492a.f5070b.put(c1268d, new ConnectionResult(17, null));
            }
        }
    }

    private void m6887i() {
        Iterator it = this.f4512u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f4512u.clear();
    }

    private Set<Scope> m6889j() {
        if (this.f4509r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.f4509r.m4734c());
        Map e = this.f4509r.m4736e();
        for (C1274a c1274a : e.keySet()) {
            if (!this.f4492a.f5070b.containsKey(c1274a.m4527c())) {
                hashSet.addAll(((C1337a) e.get(c1274a)).f3088a);
            }
        }
        return hashSet;
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m6892a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void m6893a() {
        this.f4492a.f5070b.clear();
        this.f4504m = false;
        this.f4496e = null;
        this.f4498g = 0;
        this.f4503l = 2;
        this.f4505n = false;
        this.f4507p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (C1274a c1274a : this.f4510s.keySet()) {
            C1269f c1269f = (C1269f) this.f4492a.f5069a.get(c1274a.m4527c());
            int intValue = ((Integer) this.f4510s.get(c1274a)).intValue();
            int i2 = (c1274a.m4525a().m4508a() == 1 ? 1 : 0) | i;
            if (c1269f.m4517d()) {
                this.f4504m = true;
                if (intValue < this.f4503l) {
                    this.f4503l = intValue;
                }
                if (intValue != 0) {
                    this.f4501j.add(c1274a.m4527c());
                }
            }
            hashMap.put(c1269f, new C1663a(this, c1274a, intValue));
            i = i2;
        }
        if (i != 0) {
            this.f4504m = false;
        }
        if (this.f4504m) {
            this.f4509r.m4732a(Integer.valueOf(this.f4492a.f5075g.m7194k()));
            C0777b c1671e = new C1671e();
            this.f4502k = (cl) this.f4511t.m4510a(this.f4494c, this.f4492a.f5075g.m7173a(), this.f4509r, this.f4509r.m4739h(), c1671e, c1671e);
        }
        this.f4499h = this.f4492a.f5069a.size();
        this.f4512u.add(C1848o.m7816a().submit(new C1667b(this, hashMap)));
    }

    public void m6894a(int i) {
        m6876c(new ConnectionResult(8, null));
    }

    public void m6895a(Bundle bundle) {
        if (m6871b(1)) {
            if (bundle != null) {
                this.f4500i.putAll(bundle);
            }
            if (m6878d()) {
                m6884g();
            }
        }
    }

    public void m6896a(ConnectionResult connectionResult, C1274a<?> c1274a, int i) {
        if (m6871b(1)) {
            m6870b(connectionResult, c1274a, i);
            if (m6878d()) {
                m6884g();
            }
        }
    }

    public boolean m6897b() {
        m6887i();
        m6865a(true);
        this.f4492a.m7745a(null);
        return true;
    }

    public void m6898c() {
    }
}
