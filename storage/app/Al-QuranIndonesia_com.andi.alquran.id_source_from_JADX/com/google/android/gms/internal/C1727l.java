package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.recyclerview.BuildConfig;
import android.util.Log;
import com.google.android.gms.common.C1262a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1268d;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.common.internal.C1346p;
import com.google.android.gms.common.internal.C1346p.C1318a;
import com.google.android.gms.internal.C1504t.C1501a;
import com.google.android.gms.internal.C1937r.C1725a;
import com.google.android.gms.internal.wm.C1475a;
import com.google.android.gms.maps.GoogleMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.internal.l */
public final class C1727l extends C1277c implements C1501a {
    final Queue<C1475a<?, ?>> f4684a;
    C1937r f4685b;
    final Map<C1268d<?>, C1269f> f4686c;
    Set<Scope> f4687d;
    final C1338k f4688e;
    final Map<C1274a<?>, Integer> f4689f;
    final C1266b<? extends cl, cm> f4690g;
    Set<aj> f4691h;
    final ak f4692i;
    private final Lock f4693j;
    private boolean f4694k;
    private final C1346p f4695l;
    private C1504t f4696m;
    private final int f4697n;
    private final Context f4698o;
    private final Looper f4699p;
    private volatile boolean f4700q;
    private long f4701r;
    private long f4702s;
    private final C1724a f4703t;
    private final C1262a f4704u;
    private final C2079z f4705v;
    private final ArrayList<wp> f4706w;
    private Integer f4707x;
    private final C1318a f4708y;

    /* renamed from: com.google.android.gms.internal.l.1 */
    class C17231 implements C1318a {
        final /* synthetic */ C1727l f4681a;

        C17231(C1727l c1727l) {
            this.f4681a = c1727l;
        }

        public boolean m7161b() {
            return this.f4681a.m7188e();
        }

        public Bundle m7162t() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.l.a */
    final class C1724a extends Handler {
        final /* synthetic */ C1727l f4682a;

        C1724a(C1727l c1727l, Looper looper) {
            this.f4682a = c1727l;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    this.f4682a.m7172n();
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    this.f4682a.m7171m();
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.l.b */
    static class C1726b extends C1725a {
        private WeakReference<C1727l> f4683a;

        C1726b(C1727l c1727l) {
            this.f4683a = new WeakReference(c1727l);
        }

        public void m7164a() {
            C1727l c1727l = (C1727l) this.f4683a.get();
            if (c1727l != null) {
                c1727l.m7171m();
            }
        }
    }

    public C1727l(Context context, Lock lock, Looper looper, C1338k c1338k, C1262a c1262a, C1266b<? extends cl, cm> c1266b, Map<C1274a<?>, Integer> map, List<C0777b> list, List<C0778c> list2, Map<C1268d<?>, C1269f> map2, int i, int i2, ArrayList<wp> arrayList, boolean z) {
        this.f4696m = null;
        this.f4684a = new LinkedList();
        this.f4701r = 120000;
        this.f4702s = 5000;
        this.f4687d = new HashSet();
        this.f4705v = new C2079z();
        this.f4707x = null;
        this.f4691h = null;
        this.f4708y = new C17231(this);
        this.f4698o = context;
        this.f4693j = lock;
        this.f4694k = z;
        this.f4695l = new C1346p(looper, this.f4708y);
        this.f4699p = looper;
        this.f4703t = new C1724a(this, looper);
        this.f4704u = c1262a;
        this.f4697n = i;
        if (this.f4697n >= 0) {
            this.f4707x = Integer.valueOf(i2);
        }
        this.f4689f = map;
        this.f4686c = map2;
        this.f4706w = arrayList;
        this.f4692i = new ak(this.f4686c);
        for (C0777b a : list) {
            this.f4695l.m4764a(a);
        }
        for (C0778c a2 : list2) {
            this.f4695l.m4765a(a2);
        }
        this.f4688e = c1338k;
        this.f4690g = c1266b;
    }

    public static int m7165a(Iterable<C1269f> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (C1269f c1269f : iterable) {
            if (c1269f.m4517d()) {
                i2 = 1;
            }
            i = c1269f.m4519f() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    static String m7167b(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return "SIGN_IN_MODE_REQUIRED";
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return "SIGN_IN_MODE_OPTIONAL";
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m7169c(int i) {
        if (this.f4707x == null) {
            this.f4707x = Integer.valueOf(i);
        } else if (this.f4707x.intValue() != i) {
            String valueOf = String.valueOf(C1727l.m7167b(i));
            String valueOf2 = String.valueOf(C1727l.m7167b(this.f4707x.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.f4696m == null) {
            Object obj = null;
            Object obj2 = null;
            for (C1269f c1269f : this.f4686c.values()) {
                if (c1269f.m4517d()) {
                    obj2 = 1;
                }
                obj = c1269f.m4519f() ? 1 : obj;
            }
            switch (this.f4707x.intValue()) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    if (obj2 != null) {
                        this.f4696m = C1505c.m5491a(this.f4698o, this, this.f4693j, this.f4699p, this.f4704u, this.f4686c, this.f4688e, this.f4689f, this.f4690g, this.f4706w);
                        return;
                    }
                    break;
            }
            if (this.f4694k && obj == null) {
                this.f4696m = new C1528e(this.f4698o, this.f4693j, this.f4699p, this.f4704u, this.f4686c, this.f4688e, this.f4689f, this.f4690g, this.f4706w, this);
            } else {
                this.f4696m = new C1829n(this.f4698o, this, this.f4693j, this.f4699p, this.f4704u, this.f4686c, this.f4688e, this.f4689f, this.f4690g, this.f4706w, this);
            }
        }
    }

    private void m7170l() {
        this.f4695l.m4766b();
        this.f4696m.m5485a();
    }

    private void m7171m() {
        this.f4693j.lock();
        try {
            if (m7189f()) {
                m7170l();
            }
            this.f4693j.unlock();
        } catch (Throwable th) {
            this.f4693j.unlock();
        }
    }

    private void m7172n() {
        this.f4693j.lock();
        try {
            if (m7191h()) {
                m7170l();
            }
            this.f4693j.unlock();
        } catch (Throwable th) {
            this.f4693j.unlock();
        }
    }

    public Looper m7173a() {
        return this.f4699p;
    }

    public <C extends C1269f> C m7174a(C1268d<C> c1268d) {
        Object obj = (C1269f) this.f4686c.get(c1268d);
        C1314c.m4624a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m7175a(T t) {
        C1314c.m4633b(t.m5321b() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f4686c.containsKey(t.m5321b());
        String d = t.m5323c() != null ? t.m5323c().m4528d() : "the API";
        C1314c.m4633b(containsKey, new StringBuilder(String.valueOf(d).length() + 65).append("GoogleApiClient is not configured to use ").append(d).append(" required for this call.").toString());
        this.f4693j.lock();
        try {
            if (this.f4696m == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m7189f()) {
                this.f4684a.add(t);
                while (!this.f4684a.isEmpty()) {
                    wo woVar = (C1475a) this.f4684a.remove();
                    this.f4692i.m5111a(woVar);
                    woVar.m5324c(Status.f2977c);
                }
            } else {
                t = this.f4696m.m5484a(t);
                this.f4693j.unlock();
            }
            return t;
        } finally {
            this.f4693j.unlock();
        }
    }

    public void m7176a(int i) {
        boolean z = true;
        this.f4693j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            C1314c.m4633b(z, "Illegal sign-in mode: " + i);
            m7169c(i);
            m7170l();
        } finally {
            this.f4693j.unlock();
        }
    }

    public void m7177a(int i, boolean z) {
        if (i == 1 && !z) {
            m7190g();
        }
        this.f4692i.m5113b();
        this.f4695l.m4761a(i);
        this.f4695l.m4760a();
        if (i == 2) {
            m7170l();
        }
    }

    public void m7178a(Bundle bundle) {
        while (!this.f4684a.isEmpty()) {
            m7175a((C1475a) this.f4684a.remove());
        }
        this.f4695l.m4762a(bundle);
    }

    public void m7179a(ConnectionResult connectionResult) {
        if (!this.f4704u.m4491b(this.f4698o, connectionResult.m4453c())) {
            m7191h();
        }
        if (!m7189f()) {
            this.f4695l.m4763a(connectionResult);
            this.f4695l.m4760a();
        }
    }

    public void m7180a(C0778c c0778c) {
        this.f4695l.m4765a(c0778c);
    }

    public void m7181a(aj ajVar) {
        this.f4693j.lock();
        try {
            if (this.f4691h == null) {
                this.f4691h = new HashSet();
            }
            this.f4691h.add(ajVar);
        } finally {
            this.f4693j.unlock();
        }
    }

    public void m7182a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f4698o);
        printWriter.append(str).append("mResuming=").print(this.f4700q);
        printWriter.append(" mWorkQueue.size()=").print(this.f4684a.size());
        this.f4692i.m5112a(printWriter);
        if (this.f4696m != null) {
            this.f4696m.m5486a(str, fileDescriptor, printWriter, strArr);
        }
    }

    <C extends C1269f> C m7183b(C1268d<?> c1268d) {
        Object obj = (C1269f) this.f4686c.get(c1268d);
        C1314c.m4624a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public void m7184b() {
        boolean z = false;
        this.f4693j.lock();
        try {
            if (this.f4697n >= 0) {
                if (this.f4707x != null) {
                    z = true;
                }
                C1314c.m4629a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f4707x == null) {
                this.f4707x = Integer.valueOf(C1727l.m7165a(this.f4686c.values(), false));
            } else if (this.f4707x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m7176a(this.f4707x.intValue());
        } finally {
            this.f4693j.unlock();
        }
    }

    public void m7185b(C0778c c0778c) {
        this.f4695l.m4767b(c0778c);
    }

    public void m7186b(aj ajVar) {
        this.f4693j.lock();
        try {
            if (this.f4691h == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f4691h.remove(ajVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m7192i()) {
                this.f4696m.m5489d();
            }
            this.f4693j.unlock();
        } catch (Throwable th) {
            this.f4693j.unlock();
        }
    }

    public void m7187c() {
        this.f4693j.lock();
        try {
            this.f4692i.m5110a();
            if (this.f4696m != null) {
                this.f4696m.m5487b();
            }
            this.f4705v.m9703a();
            for (C1475a c1475a : this.f4684a) {
                c1475a.m5078a(null);
                c1475a.m5082e();
            }
            this.f4684a.clear();
            if (this.f4696m != null) {
                m7191h();
                this.f4695l.m4760a();
                this.f4693j.unlock();
            }
        } finally {
            this.f4693j.unlock();
        }
    }

    public boolean m7188e() {
        return this.f4696m != null && this.f4696m.m5488c();
    }

    boolean m7189f() {
        return this.f4700q;
    }

    void m7190g() {
        if (!m7189f()) {
            this.f4700q = true;
            if (this.f4685b == null) {
                this.f4685b = this.f4704u.m4479a(this.f4698o.getApplicationContext(), new C1726b(this));
            }
            this.f4703t.sendMessageDelayed(this.f4703t.obtainMessage(1), this.f4701r);
            this.f4703t.sendMessageDelayed(this.f4703t.obtainMessage(2), this.f4702s);
        }
    }

    boolean m7191h() {
        if (!m7189f()) {
            return false;
        }
        this.f4700q = false;
        this.f4703t.removeMessages(2);
        this.f4703t.removeMessages(1);
        if (this.f4685b != null) {
            this.f4685b.m8359a();
            this.f4685b = null;
        }
        return true;
    }

    boolean m7192i() {
        boolean z = false;
        this.f4693j.lock();
        try {
            if (this.f4691h != null) {
                if (!this.f4691h.isEmpty()) {
                    z = true;
                }
                this.f4693j.unlock();
            }
            return z;
        } finally {
            this.f4693j.unlock();
        }
    }

    String m7193j() {
        Writer stringWriter = new StringWriter();
        m7182a(BuildConfig.VERSION_NAME, null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int m7194k() {
        return System.identityHashCode(this);
    }
}
