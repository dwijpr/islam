package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.stats.C1367a;
import java.util.Collections;

public class ui extends ud {
    private final C2025a f6081a;
    private vd f6082b;
    private final uu f6083c;
    private vn f6084d;

    /* renamed from: com.google.android.gms.internal.ui.1 */
    class C20221 extends uu {
        final /* synthetic */ ui f6073a;

        C20221(ui uiVar, uf ufVar) {
            this.f6073a = uiVar;
            super(ufVar);
        }

        public void m9208a() {
            this.f6073a.m9217f();
        }
    }

    /* renamed from: com.google.android.gms.internal.ui.a */
    protected class C2025a implements ServiceConnection {
        final /* synthetic */ ui f6078a;
        private volatile vd f6079b;
        private volatile boolean f6080c;

        /* renamed from: com.google.android.gms.internal.ui.a.1 */
        class C20231 implements Runnable {
            final /* synthetic */ vd f6074a;
            final /* synthetic */ C2025a f6075b;

            C20231(C2025a c2025a, vd vdVar) {
                this.f6075b = c2025a;
                this.f6074a = vdVar;
            }

            public void run() {
                if (!this.f6075b.f6078a.m9221b()) {
                    this.f6075b.f6078a.m4254c("Connected to service after a timeout");
                    this.f6075b.f6078a.m9214a(this.f6074a);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.ui.a.2 */
        class C20242 implements Runnable {
            final /* synthetic */ ComponentName f6076a;
            final /* synthetic */ C2025a f6077b;

            C20242(C2025a c2025a, ComponentName componentName) {
                this.f6077b = c2025a;
                this.f6076a = componentName;
            }

            public void run() {
                this.f6077b.f6078a.m9211a(this.f6076a);
            }
        }

        protected C2025a(ui uiVar) {
            this.f6078a = uiVar;
        }

        public vd m9209a() {
            vd vdVar = null;
            this.f6078a.m4264j();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context l = this.f6078a.m4266l();
            intent.putExtra("app_package_name", l.getPackageName());
            C1367a a = C1367a.m4904a();
            synchronized (this) {
                this.f6079b = null;
                this.f6080c = true;
                boolean a2 = a.m4910a(l, intent, this.f6078a.f6081a, 129);
                this.f6078a.m4247a("Bind to service requested", Boolean.valueOf(a2));
                if (a2) {
                    try {
                        wait(this.f6078a.m4268n().m9353v());
                    } catch (InterruptedException e) {
                        this.f6078a.m4260e("Wait for service connect was interrupted");
                    }
                    this.f6080c = false;
                    vdVar = this.f6079b;
                    this.f6079b = null;
                    if (vdVar == null) {
                        this.f6078a.m4262f("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.f6080c = false;
                }
            }
            return vdVar;
        }

        public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.internal.ui.a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void. bs: [B:3:0x0008, B:9:0x0015]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:57)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r4 = this;
            r0 = "AnalyticsServiceConnection.onServiceConnected";
            com.google.android.gms.common.internal.C1314c.m4631b(r0);
            monitor-enter(r4);
            if (r6 != 0) goto L_0x0014;
        L_0x0008:
            r0 = r4.f6078a;	 Catch:{ all -> 0x005a }
            r1 = "Service connected with null binder";	 Catch:{ all -> 0x005a }
            r0.m4262f(r1);	 Catch:{ all -> 0x005a }
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        L_0x0013:
            return;
        L_0x0014:
            r0 = 0;
            r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0051 }
            r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0051 }
            r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0051 }
            if (r2 == 0) goto L_0x0049;	 Catch:{ RemoteException -> 0x0051 }
        L_0x0021:
            r0 = com.google.android.gms.internal.vd.C2040a.m9420a(r6);	 Catch:{ RemoteException -> 0x0051 }
            r1 = r4.f6078a;	 Catch:{ RemoteException -> 0x0051 }
            r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0051 }
            r1.m4250b(r2);	 Catch:{ RemoteException -> 0x0051 }
        L_0x002c:
            if (r0 != 0) goto L_0x005f;
        L_0x002e:
            r0 = com.google.android.gms.common.stats.C1367a.m4904a();	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r4.f6078a;	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r1.m4266l();	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r4.f6078a;	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r2.f6081a;	 Catch:{ IllegalArgumentException -> 0x007c }
            r0.m4908a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x007c }
        L_0x0041:
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            goto L_0x0013;	 Catch:{ all -> 0x0046 }
        L_0x0046:
            r0 = move-exception;	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            throw r0;
        L_0x0049:
            r2 = r4.f6078a;	 Catch:{ RemoteException -> 0x0051 }
            r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0051 }
            r2.m4261e(r3, r1);	 Catch:{ RemoteException -> 0x0051 }
            goto L_0x002c;
        L_0x0051:
            r1 = move-exception;
            r1 = r4.f6078a;	 Catch:{ all -> 0x005a }
            r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x005a }
            r1.m4262f(r2);	 Catch:{ all -> 0x005a }
            goto L_0x002c;
        L_0x005a:
            r0 = move-exception;
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            throw r0;	 Catch:{ all -> 0x0046 }
        L_0x005f:
            r1 = r4.f6080c;	 Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0079;	 Catch:{ all -> 0x005a }
        L_0x0063:
            r1 = r4.f6078a;	 Catch:{ all -> 0x005a }
            r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x005a }
            r1.m4260e(r2);	 Catch:{ all -> 0x005a }
            r1 = r4.f6078a;	 Catch:{ all -> 0x005a }
            r1 = r1.m4269o();	 Catch:{ all -> 0x005a }
            r2 = new com.google.android.gms.internal.ui$a$1;	 Catch:{ all -> 0x005a }
            r2.<init>(r4, r0);	 Catch:{ all -> 0x005a }
            r1.m4371a(r2);	 Catch:{ all -> 0x005a }
            goto L_0x0041;	 Catch:{ all -> 0x005a }
        L_0x0079:
            r4.f6079b = r0;	 Catch:{ all -> 0x005a }
            goto L_0x0041;
        L_0x007c:
            r0 = move-exception;
            goto L_0x0041;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ui.a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C1314c.m4631b("AnalyticsServiceConnection.onServiceDisconnected");
            this.f6078a.m4269o().m4371a(new C20242(this, componentName));
        }
    }

    protected ui(uf ufVar) {
        super(ufVar);
        this.f6084d = new vn(ufVar.m9156d());
        this.f6081a = new C2025a(this);
        this.f6083c = new C20221(this, ufVar);
    }

    private void m9211a(ComponentName componentName) {
        m4264j();
        if (this.f6082b != null) {
            this.f6082b = null;
            m4247a("Disconnected from device AnalyticsService", componentName);
            m9218g();
        }
    }

    private void m9214a(vd vdVar) {
        m4264j();
        this.f6082b = vdVar;
        m9216e();
        m4271q().m9149g();
    }

    private void m9216e() {
        this.f6084d.m9501a();
        this.f6083c.m9203a(m4268n().m9352u());
    }

    private void m9217f() {
        m4264j();
        if (m9221b()) {
            m4250b("Inactivity, disconnecting from device AnalyticsService");
            m9223d();
        }
    }

    private void m9218g() {
        m4271q().m9147e();
    }

    protected void m9219a() {
    }

    public boolean m9220a(vc vcVar) {
        C1314c.m4623a((Object) vcVar);
        m4264j();
        m4280A();
        vd vdVar = this.f6082b;
        if (vdVar == null) {
            return false;
        }
        try {
            vdVar.m9415a(vcVar.m9407b(), vcVar.m9409d(), vcVar.m9411f() ? m4268n().m9345n() : m4268n().m9346o(), Collections.emptyList());
            m9216e();
            return true;
        } catch (RemoteException e) {
            m4250b("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public boolean m9221b() {
        m4264j();
        m4280A();
        return this.f6082b != null;
    }

    public boolean m9222c() {
        m4264j();
        m4280A();
        if (this.f6082b != null) {
            return true;
        }
        vd a = this.f6081a.m9209a();
        if (a == null) {
            return false;
        }
        this.f6082b = a;
        m9216e();
        return true;
    }

    public void m9223d() {
        m4264j();
        m4280A();
        try {
            C1367a.m4904a().m4908a(m4266l(), this.f6081a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.f6082b != null) {
            this.f6082b = null;
            m9218g();
        }
    }
}
