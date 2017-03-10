package com.google.android.gms.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.C1214h;
import com.google.android.gms.analytics.C1229l;
import com.google.android.gms.analytics.C1230m;
import com.google.android.gms.analytics.C1236o;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.common.internal.C1314c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class um extends ud {
    private boolean f6104a;
    private final uk f6105b;
    private final vi f6106c;
    private final vh f6107d;
    private final ui f6108e;
    private long f6109f;
    private final uu f6110g;
    private final uu f6111h;
    private final vn f6112i;
    private long f6113j;
    private boolean f6114k;

    /* renamed from: com.google.android.gms.internal.um.1 */
    class C20291 extends uu {
        final /* synthetic */ um f6100a;

        C20291(um umVar, uf ufVar) {
            this.f6100a = umVar;
            super(ufVar);
        }

        public void m9269a() {
            this.f6100a.m9274J();
        }
    }

    /* renamed from: com.google.android.gms.internal.um.2 */
    class C20302 extends uu {
        final /* synthetic */ um f6101a;

        C20302(um umVar, uf ufVar) {
            this.f6101a = umVar;
            super(ufVar);
        }

        public void m9270a() {
            this.f6101a.m9275K();
        }
    }

    /* renamed from: com.google.android.gms.internal.um.3 */
    class C20313 implements Runnable {
        final /* synthetic */ um f6102a;

        C20313(um umVar) {
            this.f6102a = umVar;
        }

        public void run() {
            this.f6102a.m9302c();
        }
    }

    /* renamed from: com.google.android.gms.internal.um.4 */
    class C20324 implements ux {
        final /* synthetic */ um f6103a;

        C20324(um umVar) {
            this.f6103a = umVar;
        }

        public void m9272a(Throwable th) {
            this.f6103a.m9289F();
        }
    }

    protected um(uf ufVar, ug ugVar) {
        super(ufVar);
        C1314c.m4623a((Object) ugVar);
        this.f6109f = Long.MIN_VALUE;
        this.f6107d = ugVar.m9185k(ufVar);
        this.f6105b = ugVar.m9187m(ufVar);
        this.f6106c = ugVar.m9188n(ufVar);
        this.f6108e = ugVar.m9189o(ufVar);
        this.f6112i = new vn(m4265k());
        this.f6110g = new C20291(this, ufVar);
        this.f6111h = new C20302(this, ufVar);
    }

    private void m9273I() {
        m4264j();
        Context b = m4263i().m9154b();
        if (!vl.m9491a(b)) {
            m4260e("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!vm.m9495a(b)) {
            m4262f("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.m4184a(b)) {
            m4260e("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!CampaignTrackingService.m4188a(b)) {
            m4260e("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    private void m9274J() {
        m9295a(new C20324(this));
    }

    private void m9275K() {
        try {
            this.f6105b.m9263g();
            m9289F();
        } catch (SQLiteException e) {
            m4258d("Failed to delete stale hits", e);
        }
        this.f6111h.m9203a(86400000);
    }

    private boolean m9276L() {
        return !this.f6114k && m9290G() > 0;
    }

    private void m9277M() {
        uw r = m4272r();
        if (r.m9367b() && !r.m9368c()) {
            long E = m9288E();
            if (E != 0 && Math.abs(m4265k().m4926a() - E) <= m4268n().m9341j()) {
                m4247a("Dispatch alarm scheduled (ms)", Long.valueOf(m4268n().m9340i()));
                r.m9369d();
            }
        }
    }

    private void m9278N() {
        m9277M();
        long G = m9290G();
        long d = m4274t().m9487d();
        if (d != 0) {
            d = G - Math.abs(m4265k().m4926a() - d);
            if (d <= 0) {
                d = Math.min(m4268n().m9338g(), G);
            }
        } else {
            d = Math.min(m4268n().m9338g(), G);
        }
        m4247a("Dispatch scheduled (ms)", Long.valueOf(d));
        if (this.f6110g.m9206c()) {
            this.f6110g.m9205b(Math.max(1, d + this.f6110g.m9204b()));
            return;
        }
        this.f6110g.m9203a(d);
    }

    private void m9279O() {
        m9280P();
        m9281Q();
    }

    private void m9280P() {
        if (this.f6110g.m9206c()) {
            m4250b("All hits dispatched or no network/service. Going to power save mode");
        }
        this.f6110g.m9207d();
    }

    private void m9281Q() {
        uw r = m4272r();
        if (r.m9368c()) {
            r.m9370e();
        }
    }

    private void m9282a(uh uhVar, to toVar) {
        C1314c.m4623a((Object) uhVar);
        C1314c.m4623a((Object) toVar);
        C1214h c1214h = new C1214h(m4263i());
        c1214h.m4206b(uhVar.m9195c());
        c1214h.m4207b(uhVar.m9196d());
        C1229l k = c1214h.m4210k();
        tw twVar = (tw) k.m4347b(tw.class);
        twVar.m9079a("data");
        twVar.m9083b(true);
        k.m4346a((C1230m) toVar);
        tr trVar = (tr) k.m4347b(tr.class);
        tn tnVar = (tn) k.m4347b(tn.class);
        for (Entry entry : uhVar.m9198f().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                tnVar.m8998a(str2);
            } else if ("av".equals(str)) {
                tnVar.m9000b(str2);
            } else if ("aid".equals(str)) {
                tnVar.m9002c(str2);
            } else if ("aiid".equals(str)) {
                tnVar.m9004d(str2);
            } else if ("uid".equals(str)) {
                twVar.m9085c(str2);
            } else {
                trVar.m9037a(str, str2);
            }
        }
        m4252b("Sending installation campaign to", uhVar.m9195c(), toVar);
        k.m4345a(m4274t().m9485b());
        k.m4351e();
    }

    private boolean m9285g(String str) {
        return ar.m5144b(m4266l()).m5138a(str) == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean m9286C() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.analytics.C1236o.m4367d();
        r12.m4280A();
        r0 = "Dispatching a batch of local hits";
        r12.m4250b(r0);
        r0 = r12.f6108e;
        r0 = r0.m9221b();
        if (r0 != 0) goto L_0x0028;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        r3 = r12.f6106c;
        r3 = r3.m9467b();
        if (r3 != 0) goto L_0x002a;
    L_0x001e:
        if (r0 == 0) goto L_0x002c;
    L_0x0020:
        if (r1 == 0) goto L_0x002c;
    L_0x0022:
        r0 = "No network or service available. Will retry later";
        r12.m4250b(r0);
    L_0x0027:
        return r2;
    L_0x0028:
        r0 = r2;
        goto L_0x0016;
    L_0x002a:
        r1 = r2;
        goto L_0x001e;
    L_0x002c:
        r0 = r12.m4268n();
        r0 = r0.m9342k();
        r1 = r12.m4268n();
        r1 = r1.m9343l();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
    L_0x0048:
        r0 = r12.f6105b;	 Catch:{ all -> 0x01d7 }
        r0.m9256b();	 Catch:{ all -> 0x01d7 }
        r3.clear();	 Catch:{ all -> 0x01d7 }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x00c9 }
        r8 = r0.m9255b(r6);	 Catch:{ SQLiteException -> 0x00c9 }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00c9 }
        if (r0 == 0) goto L_0x0079;
    L_0x005c:
        r0 = "Store is empty, nothing to dispatch";
        r12.m4250b(r0);	 Catch:{ SQLiteException -> 0x00c9 }
        r12.m9279O();	 Catch:{ SQLiteException -> 0x00c9 }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x006f }
        r0.m9257c();	 Catch:{ SQLiteException -> 0x006f }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x006f }
        r0.m9260d();	 Catch:{ SQLiteException -> 0x006f }
        goto L_0x0027;
    L_0x006f:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.m4261e(r1, r0);
        r12.m9279O();
        goto L_0x0027;
    L_0x0079:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00c9 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00c9 }
        r12.m4247a(r0, r1);	 Catch:{ SQLiteException -> 0x00c9 }
        r1 = r8.iterator();	 Catch:{ all -> 0x01d7 }
    L_0x008a:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01d7 }
        if (r0 == 0) goto L_0x00e9;
    L_0x0090:
        r0 = r1.next();	 Catch:{ all -> 0x01d7 }
        r0 = (com.google.android.gms.internal.vc) r0;	 Catch:{ all -> 0x01d7 }
        r10 = r0.m9408c();	 Catch:{ all -> 0x01d7 }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x008a;
    L_0x009e:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01d7 }
        r3 = r8.size();	 Catch:{ all -> 0x01d7 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01d7 }
        r12.m4259d(r0, r1, r3);	 Catch:{ all -> 0x01d7 }
        r12.m9279O();	 Catch:{ all -> 0x01d7 }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x00be }
        r0.m9257c();	 Catch:{ SQLiteException -> 0x00be }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x00be }
        r0.m9260d();	 Catch:{ SQLiteException -> 0x00be }
        goto L_0x0027;
    L_0x00be:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.m4261e(r1, r0);
        r12.m9279O();
        goto L_0x0027;
    L_0x00c9:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.m4258d(r1, r0);	 Catch:{ all -> 0x01d7 }
        r12.m9279O();	 Catch:{ all -> 0x01d7 }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x00de }
        r0.m9257c();	 Catch:{ SQLiteException -> 0x00de }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x00de }
        r0.m9260d();	 Catch:{ SQLiteException -> 0x00de }
        goto L_0x0027;
    L_0x00de:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.m4261e(r1, r0);
        r12.m9279O();
        goto L_0x0027;
    L_0x00e9:
        r0 = r12.f6108e;	 Catch:{ all -> 0x01d7 }
        r0 = r0.m9221b();	 Catch:{ all -> 0x01d7 }
        if (r0 == 0) goto L_0x01ee;
    L_0x00f1:
        r0 = "Service connected, sending hits to the service";
        r12.m4250b(r0);	 Catch:{ all -> 0x01d7 }
    L_0x00f6:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01d7 }
        if (r0 != 0) goto L_0x01ee;
    L_0x00fc:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01d7 }
        r0 = (com.google.android.gms.internal.vc) r0;	 Catch:{ all -> 0x01d7 }
        r1 = r12.f6108e;	 Catch:{ all -> 0x01d7 }
        r1 = r1.m9220a(r0);	 Catch:{ all -> 0x01d7 }
        if (r1 != 0) goto L_0x0134;
    L_0x010b:
        r0 = r4;
    L_0x010c:
        r4 = r12.f6106c;	 Catch:{ all -> 0x01d7 }
        r4 = r4.m9467b();	 Catch:{ all -> 0x01d7 }
        if (r4 == 0) goto L_0x0182;
    L_0x0114:
        r4 = r12.f6106c;	 Catch:{ all -> 0x01d7 }
        r8 = r4.m9463a(r8);	 Catch:{ all -> 0x01d7 }
        r9 = r8.iterator();	 Catch:{ all -> 0x01d7 }
        r4 = r0;
    L_0x011f:
        r0 = r9.hasNext();	 Catch:{ all -> 0x01d7 }
        if (r0 == 0) goto L_0x0179;
    L_0x0125:
        r0 = r9.next();	 Catch:{ all -> 0x01d7 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01d7 }
        r0 = r0.longValue();	 Catch:{ all -> 0x01d7 }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01d7 }
        goto L_0x011f;
    L_0x0134:
        r10 = r0.m9408c();	 Catch:{ all -> 0x01d7 }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01d7 }
        r8.remove(r0);	 Catch:{ all -> 0x01d7 }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.m4251b(r1, r0);	 Catch:{ all -> 0x01d7 }
        r1 = r12.f6105b;	 Catch:{ SQLiteException -> 0x0159 }
        r10 = r0.m9408c();	 Catch:{ SQLiteException -> 0x0159 }
        r1.m9258c(r10);	 Catch:{ SQLiteException -> 0x0159 }
        r0 = r0.m9408c();	 Catch:{ SQLiteException -> 0x0159 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0159 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0159 }
        goto L_0x00f6;
    L_0x0159:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.m4261e(r1, r0);	 Catch:{ all -> 0x01d7 }
        r12.m9279O();	 Catch:{ all -> 0x01d7 }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x016e }
        r0.m9257c();	 Catch:{ SQLiteException -> 0x016e }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x016e }
        r0.m9260d();	 Catch:{ SQLiteException -> 0x016e }
        goto L_0x0027;
    L_0x016e:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.m4261e(r1, r0);
        r12.m9279O();
        goto L_0x0027;
    L_0x0179:
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x019f }
        r0.m9254a(r8);	 Catch:{ SQLiteException -> 0x019f }
        r3.addAll(r8);	 Catch:{ SQLiteException -> 0x019f }
        r0 = r4;
    L_0x0182:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01d7 }
        if (r4 == 0) goto L_0x01bf;
    L_0x0188:
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x0194 }
        r0.m9257c();	 Catch:{ SQLiteException -> 0x0194 }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x0194 }
        r0.m9260d();	 Catch:{ SQLiteException -> 0x0194 }
        goto L_0x0027;
    L_0x0194:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.m4261e(r1, r0);
        r12.m9279O();
        goto L_0x0027;
    L_0x019f:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.m4261e(r1, r0);	 Catch:{ all -> 0x01d7 }
        r12.m9279O();	 Catch:{ all -> 0x01d7 }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x01b4 }
        r0.m9257c();	 Catch:{ SQLiteException -> 0x01b4 }
        r0 = r12.f6105b;	 Catch:{ SQLiteException -> 0x01b4 }
        r0.m9260d();	 Catch:{ SQLiteException -> 0x01b4 }
        goto L_0x0027;
    L_0x01b4:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.m4261e(r1, r0);
        r12.m9279O();
        goto L_0x0027;
    L_0x01bf:
        r4 = r12.f6105b;	 Catch:{ SQLiteException -> 0x01cc }
        r4.m9257c();	 Catch:{ SQLiteException -> 0x01cc }
        r4 = r12.f6105b;	 Catch:{ SQLiteException -> 0x01cc }
        r4.m9260d();	 Catch:{ SQLiteException -> 0x01cc }
        r4 = r0;
        goto L_0x0048;
    L_0x01cc:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.m4261e(r1, r0);
        r12.m9279O();
        goto L_0x0027;
    L_0x01d7:
        r0 = move-exception;
        r1 = r12.f6105b;	 Catch:{ SQLiteException -> 0x01e3 }
        r1.m9257c();	 Catch:{ SQLiteException -> 0x01e3 }
        r1 = r12.f6105b;	 Catch:{ SQLiteException -> 0x01e3 }
        r1.m9260d();	 Catch:{ SQLiteException -> 0x01e3 }
        throw r0;
    L_0x01e3:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.m4261e(r1, r0);
        r12.m9279O();
        goto L_0x0027;
    L_0x01ee:
        r0 = r4;
        goto L_0x010c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.um.C():boolean");
    }

    public void m9287D() {
        C1236o.m4367d();
        m4280A();
        m4254c("Sync dispatching local hits");
        long j = this.f6113j;
        m9306g();
        try {
            m9286C();
            m4274t().m9488e();
            m9289F();
            if (this.f6113j != j) {
                this.f6107d.m9441c();
            }
        } catch (Throwable th) {
            m4261e("Sync local dispatch failed", th);
            m9289F();
        }
    }

    public long m9288E() {
        C1236o.m4367d();
        m4280A();
        try {
            return this.f6105b.m9265h();
        } catch (SQLiteException e) {
            m4261e("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    public void m9289F() {
        m4263i().m9171s();
        m4280A();
        if (!m9276L()) {
            this.f6107d.m9440b();
            m9279O();
        } else if (this.f6105b.m9262f()) {
            this.f6107d.m9440b();
            m9279O();
        } else {
            boolean z;
            if (((Boolean) uz.f6150J.m9383a()).booleanValue()) {
                z = true;
            } else {
                this.f6107d.m9439a();
                z = this.f6107d.m9443e();
            }
            if (z) {
                m9278N();
                return;
            }
            m9279O();
            m9277M();
        }
    }

    public long m9290G() {
        if (this.f6109f != Long.MIN_VALUE) {
            return this.f6109f;
        }
        return m4273s().m9529e() ? ((long) m4273s().m9530f()) * 1000 : m4268n().m9339h();
    }

    public void m9291H() {
        m4280A();
        m4264j();
        this.f6114k = true;
        this.f6108e.m9223d();
        m9289F();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m9292a(com.google.android.gms.internal.uh r6, boolean r7) {
        /*
        r5 = this;
        com.google.android.gms.common.internal.C1314c.m4623a(r6);
        r5.m4280A();
        r5.m4264j();
        r0 = r5.f6105b;	 Catch:{ SQLiteException -> 0x0049 }
        r0.m9256b();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.f6105b;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.m9192a();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.m9194b();	 Catch:{ SQLiteException -> 0x0049 }
        r0.m9251a(r2, r1);	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.f6105b;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.m9192a();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.m9194b();	 Catch:{ SQLiteException -> 0x0049 }
        r4 = r6.m9195c();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r0.m9247a(r2, r1, r4);	 Catch:{ SQLiteException -> 0x0049 }
        if (r7 != 0) goto L_0x0042;
    L_0x002f:
        r6.m9193a(r0);	 Catch:{ SQLiteException -> 0x0049 }
    L_0x0032:
        r2 = r5.f6105b;	 Catch:{ SQLiteException -> 0x0049 }
        r2.m9252a(r6);	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.f6105b;	 Catch:{ SQLiteException -> 0x0049 }
        r2.m9257c();	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.f6105b;	 Catch:{ SQLiteException -> 0x0057 }
        r2.m9260d();	 Catch:{ SQLiteException -> 0x0057 }
    L_0x0041:
        return r0;
    L_0x0042:
        r2 = 1;
        r2 = r2 + r0;
        r6.m9193a(r2);	 Catch:{ SQLiteException -> 0x0049 }
        goto L_0x0032;
    L_0x0049:
        r0 = move-exception;
        r1 = "Failed to update Analytics property";
        r5.m4261e(r1, r0);	 Catch:{ all -> 0x0065 }
        r0 = r5.f6105b;	 Catch:{ SQLiteException -> 0x005e }
        r0.m9260d();	 Catch:{ SQLiteException -> 0x005e }
    L_0x0054:
        r0 = -1;
        goto L_0x0041;
    L_0x0057:
        r2 = move-exception;
        r3 = "Failed to end transaction";
        r5.m4261e(r3, r2);
        goto L_0x0041;
    L_0x005e:
        r0 = move-exception;
        r1 = "Failed to end transaction";
        r5.m4261e(r1, r0);
        goto L_0x0054;
    L_0x0065:
        r0 = move-exception;
        r1 = r5.f6105b;	 Catch:{ SQLiteException -> 0x006c }
        r1.m9260d();	 Catch:{ SQLiteException -> 0x006c }
    L_0x006b:
        throw r0;
    L_0x006c:
        r1 = move-exception;
        r2 = "Failed to end transaction";
        r5.m4261e(r2, r1);
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.um.a(com.google.android.gms.internal.uh, boolean):long");
    }

    protected void m9293a() {
        this.f6105b.m4281B();
        this.f6106c.m4281B();
        this.f6108e.m4281B();
    }

    protected void m9294a(uh uhVar) {
        m4264j();
        m4251b("Sending first hit to property", uhVar.m9195c());
        if (!m4274t().m9486c().m9502a(m4268n().m9330C())) {
            String f = m4274t().m9489f();
            if (!TextUtils.isEmpty(f)) {
                to a = vp.m9508a(m4267m(), f);
                m4251b("Found relevant installation campaign", a);
                m9282a(uhVar, a);
            }
        }
    }

    public void m9295a(ux uxVar) {
        m9296a(uxVar, this.f6113j);
    }

    public void m9296a(ux uxVar, long j) {
        C1236o.m4367d();
        m4280A();
        long j2 = -1;
        long d = m4274t().m9487d();
        if (d != 0) {
            j2 = Math.abs(m4265k().m4926a() - d);
        }
        m4251b("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        m9306g();
        try {
            m9286C();
            m4274t().m9488e();
            m9289F();
            if (uxVar != null) {
                uxVar.m9271a(null);
            }
            if (this.f6113j != j) {
                this.f6107d.m9441c();
            }
        } catch (Throwable th) {
            m4261e("Local dispatch failed", th);
            m4274t().m9488e();
            m9289F();
            if (uxVar != null) {
                uxVar.m9271a(th);
            }
        }
    }

    public void m9297a(vc vcVar) {
        C1314c.m4623a((Object) vcVar);
        C1236o.m4367d();
        m4280A();
        if (this.f6114k) {
            m4254c("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            m4247a("Delivering hit", vcVar);
        }
        vc b = m9300b(vcVar);
        m9306g();
        if (this.f6108e.m9220a(b)) {
            m4254c("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.f6105b.m9253a(b);
            m9289F();
        } catch (SQLiteException e) {
            m4261e("Delivery failed to save hit to a database", e);
            m4267m().m9432a(b, "deliver: failed to insert hit to database");
        }
    }

    public void m9298a(String str) {
        C1314c.m4625a(str);
        m4264j();
        to a = vp.m9508a(m4267m(), str);
        if (a == null) {
            m4258d("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence f = m4274t().m9489f();
        if (str.equals(f)) {
            m4260e("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(f)) {
            m4274t().m9484a(str);
            if (m4274t().m9486c().m9502a(m4268n().m9330C())) {
                m4258d("Campaign received too late, ignoring", a);
                return;
            }
            m4251b("Received installation campaign", a);
            for (uh a2 : this.f6105b.m9259d(0)) {
                m9282a(a2, a);
            }
        } else {
            m4259d("Ignoring multiple install campaigns. original, new", f, str);
        }
    }

    public void m9299a(boolean z) {
        m9289F();
    }

    vc m9300b(vc vcVar) {
        if (!TextUtils.isEmpty(vcVar.m9413h())) {
            return vcVar;
        }
        Pair a = m4274t().m9490g().m9479a();
        if (a == null) {
            return vcVar;
        }
        Long l = (Long) a.second;
        String str = (String) a.first;
        String valueOf = String.valueOf(l);
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
        Map hashMap = new HashMap(vcVar.m9407b());
        hashMap.put("_m", valueOf);
        return vc.m9400a(this, vcVar, hashMap);
    }

    void m9301b() {
        m4280A();
        C1314c.m4629a(!this.f6104a, (Object) "Analytics backend already started");
        this.f6104a = true;
        m4269o().m4371a(new C20313(this));
    }

    protected void m9302c() {
        m4280A();
        m9273I();
        m4274t().m9485b();
        if (!m9285g("android.permission.ACCESS_NETWORK_STATE")) {
            m4262f("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            m9291H();
        }
        if (!m9285g("android.permission.INTERNET")) {
            m4262f("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            m9291H();
        }
        if (vm.m9495a(m4266l())) {
            m4250b("AnalyticsService registered in the app manifest and enabled");
        } else {
            m4260e("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.f6114k || this.f6105b.m9262f())) {
            m9306g();
        }
        m9289F();
    }

    void m9303d() {
        m4264j();
        this.f6113j = m4265k().m4926a();
    }

    protected void m9304e() {
        m4264j();
        m9307h();
    }

    public void m9305f() {
        C1236o.m4367d();
        m4280A();
        m4250b("Service disconnected");
    }

    protected void m9306g() {
        if (!this.f6114k && m4268n().m9333b() && !this.f6108e.m9221b()) {
            if (this.f6112i.m9502a(m4268n().m9354w())) {
                this.f6112i.m9501a();
                m4250b("Connecting to service");
                if (this.f6108e.m9222c()) {
                    m4250b("Connected to service");
                    this.f6112i.m9503b();
                    m9304e();
                }
            }
        }
    }

    public void m9307h() {
        C1236o.m4367d();
        m4280A();
        if (!m4268n().m9333b()) {
            m4260e("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.f6108e.m9221b()) {
            m4250b("Service not connected");
        } else if (!this.f6105b.m9262f()) {
            m4250b("Dispatching local hits to device AnalyticsService");
            while (true) {
                try {
                    break;
                    List b = this.f6105b.m9255b((long) m4268n().m9342k());
                    if (b.isEmpty()) {
                        vc vcVar;
                        while (true) {
                            if (!b.isEmpty()) {
                                vcVar = (vc) b.get(0);
                                if (this.f6108e.m9220a(vcVar)) {
                                    m9289F();
                                    return;
                                }
                                b.remove(vcVar);
                                try {
                                    this.f6105b.m9258c(vcVar.m9408c());
                                } catch (SQLiteException e) {
                                    m4261e("Failed to remove hit that was send for delivery", e);
                                    m9279O();
                                    return;
                                }
                            }
                        }
                        List b2 = this.f6105b.m9255b((long) m4268n().m9342k());
                        if (b2.isEmpty()) {
                            while (true) {
                                if (b2.isEmpty()) {
                                    vcVar = (vc) b2.get(0);
                                    if (this.f6108e.m9220a(vcVar)) {
                                        b2.remove(vcVar);
                                        this.f6105b.m9258c(vcVar.m9408c());
                                    } else {
                                        m9289F();
                                        return;
                                    }
                                }
                            }
                        }
                        m9289F();
                        return;
                    }
                    m9289F();
                    return;
                } catch (SQLiteException e2) {
                    m4261e("Failed to read hits from store", e2);
                    m9279O();
                    return;
                }
            }
        }
    }
}
