package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.C1262a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1240a;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.api.C1288n;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1308t;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1317j.C1329f;
import com.google.android.gms.common.internal.C1320f;
import com.google.android.gms.common.util.C1375a;
import com.google.android.gms.internal.C2078x.C2077b;
import com.google.android.gms.internal.ag.C1425a;
import com.google.android.gms.internal.wh.C2067b;
import com.google.android.gms.internal.wh.C2068c;
import com.google.android.gms.internal.wm.C1475a;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p042b.C1251d;
import com.google.android.gms.p042b.C1252e;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.p */
public class C1895p implements Callback {
    public static final Status f5322a;
    private static final Status f5323b;
    private static final Object f5324f;
    private static C1895p f5325g;
    private long f5326c;
    private long f5327d;
    private long f5328e;
    private final Context f5329h;
    private final C1262a f5330i;
    private int f5331j;
    private final AtomicInteger f5332k;
    private final AtomicInteger f5333l;
    private final Map<wj<?>, C1892a<?>> f5334m;
    private C1588g f5335n;
    private final Set<wj<?>> f5336o;
    private final Set<wj<?>> f5337p;
    private final Handler f5338q;

    /* renamed from: com.google.android.gms.internal.p.a */
    public class C1892a<O extends C1240a> implements C0777b, C0778c, wq {
        final /* synthetic */ C1895p f5302a;
        private final Queue<wh> f5303b;
        private final C1269f f5304c;
        private final C1267c f5305d;
        private final wj<O> f5306e;
        private final C1543f f5307f;
        private final Set<wl> f5308g;
        private final Map<C2077b<?>, ac> f5309h;
        private final int f5310i;
        private final ag f5311j;
        private boolean f5312k;
        private ConnectionResult f5313l;

        /* renamed from: com.google.android.gms.internal.p.a.1 */
        class C18891 implements Runnable {
            final /* synthetic */ C1892a f5298a;

            C18891(C1892a c1892a) {
                this.f5298a = c1892a;
            }

            public void run() {
                this.f5298a.m8000m();
            }
        }

        /* renamed from: com.google.android.gms.internal.p.a.2 */
        class C18902 implements Runnable {
            final /* synthetic */ C1892a f5299a;

            C18902(C1892a c1892a) {
                this.f5299a = c1892a;
            }

            public void run() {
                this.f5299a.m8001n();
            }
        }

        /* renamed from: com.google.android.gms.internal.p.a.3 */
        class C18913 implements Runnable {
            final /* synthetic */ ConnectionResult f5300a;
            final /* synthetic */ C1892a f5301b;

            C18913(C1892a c1892a, ConnectionResult connectionResult) {
                this.f5301b = c1892a;
                this.f5300a = connectionResult;
            }

            public void run() {
                this.f5301b.m8008a(this.f5300a);
            }
        }

        public C1892a(C1895p c1895p, C1288n<O> c1288n) {
            this.f5302a = c1895p;
            this.f5303b = new LinkedList();
            this.f5308g = new HashSet();
            this.f5309h = new HashMap();
            this.f5313l = null;
            this.f5304c = c1288n.m4563a(c1895p.f5338q.getLooper(), this);
            if (this.f5304c instanceof C1320f) {
                this.f5305d = ((C1320f) this.f5304c).m4697k();
            } else {
                this.f5305d = this.f5304c;
            }
            this.f5306e = c1288n.m4565a();
            this.f5307f = new C1543f();
            this.f5310i = c1288n.m4567b();
            if (this.f5304c.m4517d()) {
                this.f5311j = c1288n.m4564a(c1895p.f5329h, c1895p.f5338q);
            } else {
                this.f5311j = null;
            }
        }

        private void m7998b(wh whVar) {
            whVar.m9658a(this.f5307f, m8023k());
            try {
                whVar.m9659a(this);
            } catch (DeadObjectException e) {
                m8006a(1);
                this.f5304c.m4511a();
            }
        }

        private void m7999c(ConnectionResult connectionResult) {
            for (wl a : this.f5308g) {
                a.m9685a(this.f5306e, connectionResult);
            }
            this.f5308g.clear();
        }

        private void m8000m() {
            m8016d();
            m7999c(ConnectionResult.f2957a);
            m8003p();
            Iterator it = this.f5309h.values().iterator();
            while (it.hasNext()) {
                it.next();
                try {
                    C1252e c1252e = new C1252e();
                } catch (DeadObjectException e) {
                    m8006a(1);
                    this.f5304c.m4511a();
                } catch (RemoteException e2) {
                }
            }
            m8002o();
            m8004q();
        }

        private void m8001n() {
            m8016d();
            this.f5312k = true;
            this.f5307f.m6042c();
            this.f5302a.f5338q.sendMessageDelayed(Message.obtain(this.f5302a.f5338q, 7, this.f5306e), this.f5302a.f5326c);
            this.f5302a.f5338q.sendMessageDelayed(Message.obtain(this.f5302a.f5338q, 9, this.f5306e), this.f5302a.f5327d);
            this.f5302a.f5331j = -1;
        }

        private void m8002o() {
            while (this.f5304c.m4515b() && !this.f5303b.isEmpty()) {
                m7998b((wh) this.f5303b.remove());
            }
        }

        private void m8003p() {
            if (this.f5312k) {
                this.f5302a.f5338q.removeMessages(9, this.f5306e);
                this.f5302a.f5338q.removeMessages(7, this.f5306e);
                this.f5312k = false;
            }
        }

        private void m8004q() {
            this.f5302a.f5338q.removeMessages(10, this.f5306e);
            this.f5302a.f5338q.sendMessageDelayed(this.f5302a.f5338q.obtainMessage(10, this.f5306e), this.f5302a.f5328e);
        }

        public void m8005a() {
            C1314c.m4627a(this.f5302a.f5338q);
            m8010a(C1895p.f5322a);
            this.f5307f.m6041b();
            for (C2077b c2068c : this.f5309h.keySet()) {
                m8011a(new C2068c(c2068c, new C1252e()));
            }
            this.f5304c.m4511a();
        }

        public void m8006a(int i) {
            if (Looper.myLooper() == this.f5302a.f5338q.getLooper()) {
                m8001n();
            } else {
                this.f5302a.f5338q.post(new C18902(this));
            }
        }

        public void m8007a(Bundle bundle) {
            if (Looper.myLooper() == this.f5302a.f5338q.getLooper()) {
                m8000m();
            } else {
                this.f5302a.f5338q.post(new C18891(this));
            }
        }

        public void m8008a(ConnectionResult connectionResult) {
            C1314c.m4627a(this.f5302a.f5338q);
            if (this.f5311j != null) {
                this.f5311j.m5063a();
            }
            m8016d();
            this.f5302a.f5331j = -1;
            m7999c(connectionResult);
            if (connectionResult.m4453c() == 4) {
                m8010a(C1895p.f5323b);
            } else if (this.f5303b.isEmpty()) {
                this.f5313l = connectionResult;
            } else {
                synchronized (C1895p.f5324f) {
                    if (this.f5302a.f5335n == null || !this.f5302a.f5336o.contains(this.f5306e)) {
                        if (!this.f5302a.m8059a(connectionResult, this.f5310i)) {
                            if (connectionResult.m4453c() == 18) {
                                this.f5312k = true;
                            }
                            if (this.f5312k) {
                                this.f5302a.f5338q.sendMessageDelayed(Message.obtain(this.f5302a.f5338q, 7, this.f5306e), this.f5302a.f5326c);
                                return;
                            }
                            String valueOf = String.valueOf(this.f5306e.m9672a());
                            m8010a(new Status(17, new StringBuilder(String.valueOf(valueOf).length() + 38).append("API: ").append(valueOf).append(" is not available on this device.").toString()));
                            return;
                        }
                        return;
                    }
                    this.f5302a.f5335n.m6294b(connectionResult, this.f5310i);
                }
            }
        }

        public void m8009a(ConnectionResult connectionResult, C1274a<?> c1274a, int i) {
            if (Looper.myLooper() == this.f5302a.f5338q.getLooper()) {
                m8008a(connectionResult);
            } else {
                this.f5302a.f5338q.post(new C18913(this, connectionResult));
            }
        }

        public void m8010a(Status status) {
            C1314c.m4627a(this.f5302a.f5338q);
            for (wh a : this.f5303b) {
                a.m9657a(status);
            }
            this.f5303b.clear();
        }

        public void m8011a(wh whVar) {
            C1314c.m4627a(this.f5302a.f5338q);
            if (this.f5304c.m4515b()) {
                m7998b(whVar);
                m8004q();
                return;
            }
            this.f5303b.add(whVar);
            if (this.f5313l == null || !this.f5313l.m4451a()) {
                m8021i();
            } else {
                m8008a(this.f5313l);
            }
        }

        public void m8012a(wl wlVar) {
            C1314c.m4627a(this.f5302a.f5338q);
            this.f5308g.add(wlVar);
        }

        public C1269f m8013b() {
            return this.f5304c;
        }

        public void m8014b(ConnectionResult connectionResult) {
            C1314c.m4627a(this.f5302a.f5338q);
            this.f5304c.m4511a();
            m8008a(connectionResult);
        }

        public Map<C2077b<?>, ac> m8015c() {
            return this.f5309h;
        }

        public void m8016d() {
            C1314c.m4627a(this.f5302a.f5338q);
            this.f5313l = null;
        }

        public ConnectionResult m8017e() {
            C1314c.m4627a(this.f5302a.f5338q);
            return this.f5313l;
        }

        public void m8018f() {
            C1314c.m4627a(this.f5302a.f5338q);
            if (this.f5312k) {
                m8021i();
            }
        }

        public void m8019g() {
            C1314c.m4627a(this.f5302a.f5338q);
            if (this.f5312k) {
                m8003p();
                m8010a(this.f5302a.f5330i.m4472a(this.f5302a.f5329h) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f5304c.m4511a();
            }
        }

        public void m8020h() {
            C1314c.m4627a(this.f5302a.f5338q);
            if (!this.f5304c.m4515b() || this.f5309h.size() != 0) {
                return;
            }
            if (this.f5307f.m6040a()) {
                m8004q();
            } else {
                this.f5304c.m4511a();
            }
        }

        public void m8021i() {
            C1314c.m4627a(this.f5302a.f5338q);
            if (!this.f5304c.m4515b() && !this.f5304c.m4516c()) {
                if (this.f5304c.m4518e() && this.f5302a.f5331j != 0) {
                    this.f5302a.f5331j = this.f5302a.f5330i.m4472a(this.f5302a.f5329h);
                    if (this.f5302a.f5331j != 0) {
                        m8008a(new ConnectionResult(this.f5302a.f5331j, null));
                        return;
                    }
                }
                C1425a c1894b = new C1894b(this.f5302a, this.f5304c, this.f5306e);
                if (this.f5304c.m4517d()) {
                    this.f5311j.m5067a(c1894b);
                }
                this.f5304c.m4512a(c1894b);
            }
        }

        boolean m8022j() {
            return this.f5304c.m4515b();
        }

        public boolean m8023k() {
            return this.f5304c.m4517d();
        }

        public int m8024l() {
            return this.f5310i;
        }
    }

    /* renamed from: com.google.android.gms.internal.p.b */
    private class C1894b implements C1329f, C1425a {
        final /* synthetic */ C1895p f5316a;
        private final C1269f f5317b;
        private final wj<?> f5318c;
        private C1308t f5319d;
        private Set<Scope> f5320e;
        private boolean f5321f;

        /* renamed from: com.google.android.gms.internal.p.b.1 */
        class C18931 implements Runnable {
            final /* synthetic */ ConnectionResult f5314a;
            final /* synthetic */ C1894b f5315b;

            C18931(C1894b c1894b, ConnectionResult connectionResult) {
                this.f5315b = c1894b;
                this.f5314a = connectionResult;
            }

            public void run() {
                if (this.f5314a.m4452b()) {
                    this.f5315b.f5321f = true;
                    if (this.f5315b.f5317b.m4517d()) {
                        this.f5315b.m8026a();
                        return;
                    } else {
                        this.f5315b.f5317b.m4513a(null, Collections.emptySet());
                        return;
                    }
                }
                ((C1892a) this.f5315b.f5316a.f5334m.get(this.f5315b.f5318c)).m8008a(this.f5314a);
            }
        }

        public C1894b(C1895p c1895p, C1269f c1269f, wj<?> wjVar) {
            this.f5316a = c1895p;
            this.f5319d = null;
            this.f5320e = null;
            this.f5321f = false;
            this.f5317b = c1269f;
            this.f5318c = wjVar;
        }

        private void m8026a() {
            if (this.f5321f && this.f5319d != null) {
                this.f5317b.m4513a(this.f5319d, this.f5320e);
            }
        }

        public void m8030a(ConnectionResult connectionResult) {
            this.f5316a.f5338q.post(new C18931(this, connectionResult));
        }

        public void m8031a(C1308t c1308t, Set<Scope> set) {
            if (c1308t == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                m8032b(new ConnectionResult(4));
                return;
            }
            this.f5319d = c1308t;
            this.f5320e = set;
            m8026a();
        }

        public void m8032b(ConnectionResult connectionResult) {
            ((C1892a) this.f5316a.f5334m.get(this.f5318c)).m8014b(connectionResult);
        }
    }

    static {
        f5322a = new Status(4, "Sign-out occurred while this API call was in progress.");
        f5323b = new Status(4, "The user must be signed in to make this API call.");
        f5324f = new Object();
    }

    private C1895p(Context context, Looper looper, C1262a c1262a) {
        this.f5326c = 5000;
        this.f5327d = 120000;
        this.f5328e = 10000;
        this.f5331j = -1;
        this.f5332k = new AtomicInteger(1);
        this.f5333l = new AtomicInteger(0);
        this.f5334m = new ConcurrentHashMap(5, 0.75f, 1);
        this.f5335n = null;
        this.f5336o = new C1375a();
        this.f5337p = new C1375a();
        this.f5329h = context;
        this.f5338q = new Handler(looper, this);
        this.f5330i = c1262a;
    }

    public static C1895p m8035a() {
        C1895p c1895p;
        synchronized (f5324f) {
            C1314c.m4624a(f5325g, (Object) "Must guarantee manager is non-null before using getInstance");
            c1895p = f5325g;
        }
        return c1895p;
    }

    public static C1895p m8036a(Context context) {
        C1895p c1895p;
        synchronized (f5324f) {
            if (f5325g == null) {
                f5325g = new C1895p(context.getApplicationContext(), C1895p.m8047f(), C1262a.m4471a());
            }
            c1895p = f5325g;
        }
        return c1895p;
    }

    private void m8037a(int i, ConnectionResult connectionResult) {
        for (C1892a c1892a : this.f5334m.values()) {
            if (c1892a.m8024l() == i) {
                break;
            }
        }
        C1892a c1892a2 = null;
        if (c1892a2 != null) {
            String valueOf = String.valueOf(this.f5330i.m4492c(connectionResult.m4453c()));
            String valueOf2 = String.valueOf(connectionResult.m4455e());
            c1892a2.m8010a(new Status(17, new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(valueOf2).length()).append("Error resolution was canceled by the user, original error message: ").append(valueOf).append(": ").append(valueOf2).toString()));
            return;
        }
        Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
    }

    private void m8038a(aa aaVar) {
        C1892a c1892a = (C1892a) this.f5334m.get(aaVar.f3275c.m4565a());
        if (c1892a == null) {
            m8041b(aaVar.f3275c);
            c1892a = (C1892a) this.f5334m.get(aaVar.f3275c.m4565a());
        }
        if (!c1892a.m8023k() || this.f5333l.get() == aaVar.f3274b) {
            c1892a.m8011a(aaVar.f3273a);
            return;
        }
        aaVar.f3273a.m9657a(f5322a);
        c1892a.m8005a();
    }

    private void m8039a(wl wlVar) {
        for (wj wjVar : wlVar.m9684a()) {
            C1892a c1892a = (C1892a) this.f5334m.get(wjVar);
            if (c1892a == null) {
                wlVar.m9685a(wjVar, new ConnectionResult(13));
                return;
            } else if (c1892a.m8022j()) {
                wlVar.m9685a(wjVar, ConnectionResult.f2957a);
            } else if (c1892a.m8017e() != null) {
                wlVar.m9685a(wjVar, c1892a.m8017e());
            } else {
                c1892a.m8012a(wlVar);
            }
        }
    }

    private void m8041b(C1288n<?> c1288n) {
        wj a = c1288n.m4565a();
        if (!this.f5334m.containsKey(a)) {
            this.f5334m.put(a, new C1892a(this, c1288n));
        }
        C1892a c1892a = (C1892a) this.f5334m.get(a);
        if (c1892a.m8023k()) {
            this.f5337p.add(a);
        }
        c1892a.m8021i();
    }

    private static Looper m8047f() {
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        return handlerThread.getLooper();
    }

    private void m8050g() {
        for (C1892a c1892a : this.f5334m.values()) {
            c1892a.m8016d();
            c1892a.m8021i();
        }
    }

    private void m8052h() {
        for (wj remove : this.f5337p) {
            ((C1892a) this.f5334m.remove(remove)).m8005a();
        }
        this.f5337p.clear();
    }

    public C1251d<Void> m8055a(Iterable<C1288n<?>> iterable) {
        wl wlVar = new wl(iterable);
        for (C1288n a : iterable) {
            C1892a c1892a = (C1892a) this.f5334m.get(a.m4565a());
            if (c1892a != null) {
                if (!c1892a.m8022j()) {
                }
            }
            this.f5338q.sendMessage(this.f5338q.obtainMessage(1, wlVar));
            return wlVar.m9686b();
        }
        wlVar.m9687c();
        return wlVar.m9686b();
    }

    public void m8056a(C1288n<?> c1288n) {
        this.f5338q.sendMessage(this.f5338q.obtainMessage(5, c1288n));
    }

    public <O extends C1240a> void m8057a(C1288n<O> c1288n, int i, C1475a<? extends C1263g, C1267c> c1475a) {
        this.f5338q.sendMessage(this.f5338q.obtainMessage(3, new aa(new C2067b(i, c1475a), this.f5333l.get(), c1288n)));
    }

    public void m8058a(C1588g c1588g) {
        synchronized (f5324f) {
            if (this.f5335n != c1588g) {
                this.f5335n = c1588g;
                this.f5336o.clear();
                this.f5336o.addAll(c1588g.m6301d());
            }
        }
    }

    boolean m8059a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.m4451a() && !this.f5330i.m4485a(connectionResult.m4453c())) {
            return false;
        }
        this.f5330i.m4484a(this.f5329h, connectionResult, i);
        return true;
    }

    public int m8060b() {
        return this.f5332k.getAndIncrement();
    }

    public void m8061b(ConnectionResult connectionResult, int i) {
        if (!m8059a(connectionResult, i)) {
            this.f5338q.sendMessage(this.f5338q.obtainMessage(4, i, 0, connectionResult));
        }
    }

    void m8062b(C1588g c1588g) {
        synchronized (f5324f) {
            if (this.f5335n == c1588g) {
                this.f5335n = null;
                this.f5336o.clear();
            }
        }
    }

    public void m8063c() {
        this.f5338q.sendMessage(this.f5338q.obtainMessage(2));
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                m8039a((wl) message.obj);
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                m8050g();
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
            case C1096c.MapAttrs_liteMode /*6*/:
            case C1096c.MapAttrs_uiZoomControls /*11*/:
                m8038a((aa) message.obj);
                break;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                m8037a(message.arg1, (ConnectionResult) message.obj);
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                m8041b((C1288n) message.obj);
                break;
            case C1096c.MapAttrs_uiCompass /*7*/:
                if (this.f5334m.containsKey(message.obj)) {
                    ((C1892a) this.f5334m.get(message.obj)).m8018f();
                    break;
                }
                break;
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                m8052h();
                break;
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                if (this.f5334m.containsKey(message.obj)) {
                    ((C1892a) this.f5334m.get(message.obj)).m8019g();
                    break;
                }
                break;
            case C1096c.MapAttrs_uiTiltGestures /*10*/:
                if (this.f5334m.containsKey(message.obj)) {
                    ((C1892a) this.f5334m.get(message.obj)).m8020h();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
