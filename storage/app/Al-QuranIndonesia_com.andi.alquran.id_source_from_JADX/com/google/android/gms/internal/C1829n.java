package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.common.api.C1274a.C1268d;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.internal.C1504t.C1501a;
import com.google.android.gms.internal.wm.C1475a;
import com.google.android.gms.maps.GoogleMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.internal.n */
public class C1829n implements C1504t, wq {
    final Map<C1268d<?>, C1269f> f5069a;
    final Map<C1268d<?>, ConnectionResult> f5070b;
    final C1338k f5071c;
    final Map<C1274a<?>, Integer> f5072d;
    final C1266b<? extends cl, cm> f5073e;
    int f5074f;
    final C1727l f5075g;
    final C1501a f5076h;
    private final Lock f5077i;
    private final Condition f5078j;
    private final Context f5079k;
    private final C1261h f5080l;
    private final C1828b f5081m;
    private volatile C1639m f5082n;
    private ConnectionResult f5083o;

    /* renamed from: com.google.android.gms.internal.n.a */
    static abstract class C1636a {
        private final C1639m f4319a;

        protected C1636a(C1639m c1639m) {
            this.f4319a = c1639m;
        }

        protected abstract void m6651a();

        public final void m6652a(C1829n c1829n) {
            c1829n.f5077i.lock();
            try {
                if (c1829n.f5082n == this.f4319a) {
                    m6651a();
                    c1829n.f5077i.unlock();
                }
            } finally {
                c1829n.f5077i.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.n.b */
    final class C1828b extends Handler {
        final /* synthetic */ C1829n f5068a;

        C1828b(C1829n c1829n, Looper looper) {
            this.f5068a = c1829n;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    ((C1636a) message.obj).m6652a(this.f5068a);
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
            }
        }
    }

    public C1829n(Context context, C1727l c1727l, Lock lock, Looper looper, C1261h c1261h, Map<C1268d<?>, C1269f> map, C1338k c1338k, Map<C1274a<?>, Integer> map2, C1266b<? extends cl, cm> c1266b, ArrayList<wp> arrayList, C1501a c1501a) {
        this.f5070b = new HashMap();
        this.f5083o = null;
        this.f5079k = context;
        this.f5077i = lock;
        this.f5080l = c1261h;
        this.f5069a = map;
        this.f5071c = c1338k;
        this.f5072d = map2;
        this.f5073e = c1266b;
        this.f5075g = c1727l;
        this.f5076h = c1501a;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((wp) it.next()).m9697a((wq) this);
        }
        this.f5081m = new C1828b(this, looper);
        this.f5078j = lock.newCondition();
        this.f5082n = new C1701k(this);
    }

    public <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m7741a(T t) {
        t.m5086i();
        return this.f5082n.m6655a((C1475a) t);
    }

    public void m7742a() {
        this.f5082n.m6661c();
    }

    public void m7743a(int i) {
        this.f5077i.lock();
        try {
            this.f5082n.m6657a(i);
        } finally {
            this.f5077i.unlock();
        }
    }

    public void m7744a(Bundle bundle) {
        this.f5077i.lock();
        try {
            this.f5082n.m6658a(bundle);
        } finally {
            this.f5077i.unlock();
        }
    }

    void m7745a(ConnectionResult connectionResult) {
        this.f5077i.lock();
        try {
            this.f5083o = connectionResult;
            this.f5082n = new C1701k(this);
            this.f5082n.m6656a();
            this.f5078j.signalAll();
        } finally {
            this.f5077i.unlock();
        }
    }

    public void m7746a(ConnectionResult connectionResult, C1274a<?> c1274a, int i) {
        this.f5077i.lock();
        try {
            this.f5082n.m6659a(connectionResult, c1274a, i);
        } finally {
            this.f5077i.unlock();
        }
    }

    void m7747a(C1636a c1636a) {
        this.f5081m.sendMessage(this.f5081m.obtainMessage(1, c1636a));
    }

    void m7748a(RuntimeException runtimeException) {
        this.f5081m.sendMessage(this.f5081m.obtainMessage(2, runtimeException));
    }

    public void m7749a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f5082n);
        for (C1274a c1274a : this.f5072d.keySet()) {
            printWriter.append(str).append(c1274a.m4528d()).println(":");
            ((C1269f) this.f5069a.get(c1274a.m4527c())).m4514a(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public void m7750b() {
        if (this.f5082n.m6660b()) {
            this.f5070b.clear();
        }
    }

    public boolean m7751c() {
        return this.f5082n instanceof C1640i;
    }

    public void m7752d() {
        if (m7751c()) {
            ((C1640i) this.f5082n).m6671d();
        }
    }

    void m7753e() {
        this.f5077i.lock();
        try {
            this.f5082n = new C1672j(this, this.f5071c, this.f5072d, this.f5080l, this.f5073e, this.f5077i, this.f5079k);
            this.f5082n.m6656a();
            this.f5078j.signalAll();
        } finally {
            this.f5077i.unlock();
        }
    }

    void m7754f() {
        this.f5077i.lock();
        try {
            this.f5075g.m7191h();
            this.f5082n = new C1640i(this);
            this.f5082n.m6656a();
            this.f5078j.signalAll();
        } finally {
            this.f5077i.unlock();
        }
    }

    void m7755g() {
        for (C1269f a : this.f5069a.values()) {
            a.m4511a();
        }
    }
}
