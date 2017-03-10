package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

@op
public class mb implements ls {
    private final zzmh f4917a;
    private final md f4918b;
    private final Context f4919c;
    private final Object f4920d;
    private final lu f4921e;
    private final boolean f4922f;
    private final long f4923g;
    private final long f4924h;
    private final io f4925i;
    private final boolean f4926j;
    private boolean f4927k;
    private lx f4928l;
    private List<ly> f4929m;

    /* renamed from: com.google.android.gms.internal.mb.1 */
    class C17951 implements Runnable {
        final /* synthetic */ ly f4916a;

        C17951(mb mbVar, ly lyVar) {
            this.f4916a = lyVar;
        }

        public void run() {
            try {
                this.f4916a.f4894c.m7473c();
            } catch (Throwable e) {
                sg.m8447c("Could not destroy mediation adapter.", e);
            }
        }
    }

    public mb(Context context, zzmh com_google_android_gms_internal_zzmh, md mdVar, lu luVar, boolean z, boolean z2, long j, long j2, io ioVar) {
        this.f4920d = new Object();
        this.f4927k = false;
        this.f4929m = new ArrayList();
        this.f4919c = context;
        this.f4917a = com_google_android_gms_internal_zzmh;
        this.f4918b = mdVar;
        this.f4921e = luVar;
        this.f4922f = z;
        this.f4926j = z2;
        this.f4923g = j;
        this.f4924h = j2;
        this.f4925i = ioVar;
    }

    public ly m7449a(List<lt> list) {
        sg.m8444b("Starting mediation.");
        Iterable arrayList = new ArrayList();
        im a = this.f4925i.m6740a();
        for (lt ltVar : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(ltVar.f4838b);
            sg.m8448d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String str2 : ltVar.f4839c) {
                im a2 = this.f4925i.m6740a();
                synchronized (this.f4920d) {
                    if (this.f4927k) {
                        ly lyVar = new ly(-1);
                        return lyVar;
                    }
                    this.f4928l = new lx(this.f4919c, str2, this.f4918b, this.f4921e, ltVar, this.f4917a.f6542c, this.f4917a.f6543d, this.f4917a.f6550k, this.f4922f, this.f4926j, this.f4917a.f6565z, this.f4917a.f6553n);
                    lyVar = this.f4928l.m7430a(this.f4923g, this.f4924h);
                    this.f4929m.add(lyVar);
                    if (lyVar.f4892a == 0) {
                        sg.m8444b("Adapter succeeded.");
                        this.f4925i.m6744a("mediation_network_succeed", str2);
                        if (!arrayList.isEmpty()) {
                            this.f4925i.m6744a("mediation_networks_fail", TextUtils.join(",", arrayList));
                        }
                        this.f4925i.m6746a(a2, "mls");
                        this.f4925i.m6746a(a, "ttm");
                        return lyVar;
                    }
                    arrayList.add(str2);
                    this.f4925i.m6746a(a2, "mlf");
                    if (lyVar.f4894c != null) {
                        rq.f5755a.post(new C17951(this, lyVar));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f4925i.m6744a("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new ly(1);
    }

    public void m7450a() {
        synchronized (this.f4920d) {
            this.f4927k = true;
            if (this.f4928l != null) {
                this.f4928l.m7432a();
            }
        }
    }

    public List<ly> m7451b() {
        return this.f4929m;
    }
}
