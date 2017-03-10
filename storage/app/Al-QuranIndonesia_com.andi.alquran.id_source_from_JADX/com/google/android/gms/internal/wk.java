package com.google.android.gms.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.internal.C1314c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class wk extends wn {
    private final SparseArray<C2069a> f6328e;

    /* renamed from: com.google.android.gms.internal.wk.a */
    private class C2069a implements C0778c {
        public final int f6324a;
        public final C1277c f6325b;
        public final C0778c f6326c;
        final /* synthetic */ wk f6327d;

        public C2069a(wk wkVar, int i, C1277c c1277c, C0778c c0778c) {
            this.f6327d = wkVar;
            this.f6324a = i;
            this.f6325b = c1277c;
            this.f6326c = c0778c;
            c1277c.m4543a((C0778c) this);
        }

        public void m9673a() {
            this.f6325b.m4547b((C0778c) this);
            this.f6325b.m4549c();
        }

        public void m9674a(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            this.f6327d.m6294b(connectionResult, this.f6324a);
        }

        public void m9675a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.f6324a);
            printWriter.println(":");
            this.f6325b.m4545a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    private wk(C2057w c2057w) {
        super(c2057w);
        this.f6328e = new SparseArray();
        this.a.m9612a("AutoManageHelper", (C1587v) this);
    }

    public static wk m9676b(C2015u c2015u) {
        C2057w a = C1587v.m6277a(c2015u);
        wk wkVar = (wk) a.m9611a("AutoManageHelper", wk.class);
        return wkVar != null ? wkVar : new wk(a);
    }

    public void m9677a() {
        super.m6288a();
        boolean z = this.b;
        String valueOf = String.valueOf(this.f6328e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.c) {
            for (int i = 0; i < this.f6328e.size(); i++) {
                ((C2069a) this.f6328e.valueAt(i)).f6325b.m4546b();
            }
        }
    }

    public void m9678a(int i) {
        C2069a c2069a = (C2069a) this.f6328e.get(i);
        this.f6328e.remove(i);
        if (c2069a != null) {
            c2069a.m9673a();
        }
    }

    public void m9679a(int i, C1277c c1277c, C0778c c0778c) {
        C1314c.m4624a((Object) c1277c, (Object) "GoogleApiClient instance cannot be null");
        C1314c.m4629a(this.f6328e.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + this.b + " " + this.c);
        this.f6328e.put(i, new C2069a(this, i, c1277c, c0778c));
        if (this.b && !this.c) {
            String valueOf = String.valueOf(c1277c);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            c1277c.m4546b();
        }
    }

    protected void m9680a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C2069a c2069a = (C2069a) this.f6328e.get(i);
        if (c2069a != null) {
            m9678a(i);
            C0778c c0778c = c2069a.f6326c;
            if (c0778c != null) {
                c0778c.m2644a(connectionResult);
            }
        }
    }

    public void m9681a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f6328e.size(); i++) {
            ((C2069a) this.f6328e.valueAt(i)).m9675a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void m9682b() {
        super.m6292b();
        for (int i = 0; i < this.f6328e.size(); i++) {
            ((C2069a) this.f6328e.valueAt(i)).f6325b.m4549c();
        }
    }

    protected void m9683c() {
        for (int i = 0; i < this.f6328e.size(); i++) {
            ((C2069a) this.f6328e.valueAt(i)).f6325b.m4546b();
        }
    }
}
