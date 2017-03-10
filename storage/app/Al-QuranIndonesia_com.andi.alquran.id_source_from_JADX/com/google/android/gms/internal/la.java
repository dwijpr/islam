package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.gu.C1591a;
import com.google.android.gms.internal.gv.C1592a;
import com.google.android.gms.internal.hb.C1595a;
import com.google.android.gms.internal.is.C1656a;
import com.google.android.gms.internal.nl.C1738a;
import com.google.android.gms.internal.qc.C1751a;
import java.util.LinkedList;
import java.util.List;

@op
class la {
    private final List<C1728a> f4724a;

    /* renamed from: com.google.android.gms.internal.la.a */
    interface C1728a {
        void m7195a(lb lbVar);
    }

    /* renamed from: com.google.android.gms.internal.la.1 */
    class C17341 extends C1592a {
        final /* synthetic */ la f4710a;

        /* renamed from: com.google.android.gms.internal.la.1.1 */
        class C17291 implements C1728a {
            C17291(C17341 c17341) {
            }

            public void m7196a(lb lbVar) {
                if (lbVar.f4726a != null) {
                    lbVar.f4726a.m6313a();
                }
                zzv.zzcY().m7258a();
            }
        }

        /* renamed from: com.google.android.gms.internal.la.1.2 */
        class C17302 implements C1728a {
            final /* synthetic */ int f4709a;

            C17302(C17341 c17341, int i) {
                this.f4709a = i;
            }

            public void m7197a(lb lbVar) {
                if (lbVar.f4726a != null) {
                    lbVar.f4726a.m6314a(this.f4709a);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.1.3 */
        class C17313 implements C1728a {
            C17313(C17341 c17341) {
            }

            public void m7198a(lb lbVar) {
                if (lbVar.f4726a != null) {
                    lbVar.f4726a.m6315b();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.1.4 */
        class C17324 implements C1728a {
            C17324(C17341 c17341) {
            }

            public void m7199a(lb lbVar) {
                if (lbVar.f4726a != null) {
                    lbVar.f4726a.m6316c();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.1.5 */
        class C17335 implements C1728a {
            C17335(C17341 c17341) {
            }

            public void m7200a(lb lbVar) {
                if (lbVar.f4726a != null) {
                    lbVar.f4726a.m6317d();
                }
            }
        }

        C17341(la laVar) {
            this.f4710a = laVar;
        }

        public void m7201a() {
            this.f4710a.f4724a.add(new C17291(this));
        }

        public void m7202a(int i) {
            this.f4710a.f4724a.add(new C17302(this, i));
            rm.m8450a("Pooled interstitial failed to load.");
        }

        public void m7203b() {
            this.f4710a.f4724a.add(new C17313(this));
        }

        public void m7204c() {
            this.f4710a.f4724a.add(new C17324(this));
            rm.m8450a("Pooled interstitial loaded.");
        }

        public void m7205d() {
            this.f4710a.f4724a.add(new C17335(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.la.2 */
    class C17362 extends C1595a {
        final /* synthetic */ la f4713a;

        /* renamed from: com.google.android.gms.internal.la.2.1 */
        class C17351 implements C1728a {
            final /* synthetic */ String f4711a;
            final /* synthetic */ String f4712b;

            C17351(C17362 c17362, String str, String str2) {
                this.f4711a = str;
                this.f4712b = str2;
            }

            public void m7206a(lb lbVar) {
                if (lbVar.f4727b != null) {
                    lbVar.f4727b.m6347a(this.f4711a, this.f4712b);
                }
            }
        }

        C17362(la laVar) {
            this.f4713a = laVar;
        }

        public void m7207a(String str, String str2) {
            this.f4713a.f4724a.add(new C17351(this, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.internal.la.3 */
    class C17393 extends C1738a {
        final /* synthetic */ la f4715a;

        /* renamed from: com.google.android.gms.internal.la.3.1 */
        class C17371 implements C1728a {
            final /* synthetic */ nk f4714a;

            C17371(C17393 c17393, nk nkVar) {
                this.f4714a = nkVar;
            }

            public void m7208a(lb lbVar) {
                if (lbVar.f4728c != null) {
                    lbVar.f4728c.m7209a(this.f4714a);
                }
            }
        }

        C17393(la laVar) {
            this.f4715a = laVar;
        }

        public void m7211a(nk nkVar) {
            this.f4715a.f4724a.add(new C17371(this, nkVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.la.4 */
    class C17414 extends C1656a {
        final /* synthetic */ la f4717a;

        /* renamed from: com.google.android.gms.internal.la.4.1 */
        class C17401 implements C1728a {
            final /* synthetic */ ir f4716a;

            C17401(C17414 c17414, ir irVar) {
                this.f4716a = irVar;
            }

            public void m7212a(lb lbVar) {
                if (lbVar.f4729d != null) {
                    lbVar.f4729d.m6767a(this.f4716a);
                }
            }
        }

        C17414(la laVar) {
            this.f4717a = laVar;
        }

        public void m7213a(ir irVar) {
            this.f4717a.f4724a.add(new C17401(this, irVar));
        }
    }

    /* renamed from: com.google.android.gms.internal.la.5 */
    class C17435 extends C1591a {
        final /* synthetic */ la f4718a;

        /* renamed from: com.google.android.gms.internal.la.5.1 */
        class C17421 implements C1728a {
            C17421(C17435 c17435) {
            }

            public void m7214a(lb lbVar) {
                if (lbVar.f4730e != null) {
                    lbVar.f4730e.m6310a();
                }
            }
        }

        C17435(la laVar) {
            this.f4718a = laVar;
        }

        public void m7215a() {
            this.f4718a.f4724a.add(new C17421(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.la.6 */
    class C17526 extends C1751a {
        final /* synthetic */ la f4721a;

        /* renamed from: com.google.android.gms.internal.la.6.1 */
        class C17441 implements C1728a {
            C17441(C17526 c17526) {
            }

            public void m7216a(lb lbVar) {
                if (lbVar.f4731f != null) {
                    lbVar.f4731f.m7223a();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.6.2 */
        class C17452 implements C1728a {
            C17452(C17526 c17526) {
            }

            public void m7217a(lb lbVar) {
                if (lbVar.f4731f != null) {
                    lbVar.f4731f.m7226b();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.6.3 */
        class C17463 implements C1728a {
            C17463(C17526 c17526) {
            }

            public void m7218a(lb lbVar) {
                if (lbVar.f4731f != null) {
                    lbVar.f4731f.m7227c();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.6.4 */
        class C17474 implements C1728a {
            C17474(C17526 c17526) {
            }

            public void m7219a(lb lbVar) {
                if (lbVar.f4731f != null) {
                    lbVar.f4731f.m7228d();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.6.5 */
        class C17485 implements C1728a {
            final /* synthetic */ pz f4719a;

            C17485(C17526 c17526, pz pzVar) {
                this.f4719a = pzVar;
            }

            public void m7220a(lb lbVar) {
                if (lbVar.f4731f != null) {
                    lbVar.f4731f.m7225a(this.f4719a);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.6.6 */
        class C17496 implements C1728a {
            C17496(C17526 c17526) {
            }

            public void m7221a(lb lbVar) {
                if (lbVar.f4731f != null) {
                    lbVar.f4731f.m7229e();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.la.6.7 */
        class C17507 implements C1728a {
            final /* synthetic */ int f4720a;

            C17507(C17526 c17526, int i) {
                this.f4720a = i;
            }

            public void m7222a(lb lbVar) {
                if (lbVar.f4731f != null) {
                    lbVar.f4731f.m7224a(this.f4720a);
                }
            }
        }

        C17526(la laVar) {
            this.f4721a = laVar;
        }

        public void m7231a() {
            this.f4721a.f4724a.add(new C17441(this));
        }

        public void m7232a(int i) {
            this.f4721a.f4724a.add(new C17507(this, i));
        }

        public void m7233a(pz pzVar) {
            this.f4721a.f4724a.add(new C17485(this, pzVar));
        }

        public void m7234b() {
            this.f4721a.f4724a.add(new C17452(this));
        }

        public void m7235c() {
            this.f4721a.f4724a.add(new C17463(this));
        }

        public void m7236d() {
            this.f4721a.f4724a.add(new C17474(this));
        }

        public void m7237e() {
            this.f4721a.f4724a.add(new C17496(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.la.7 */
    class C17537 implements Runnable {
        final /* synthetic */ C1728a f4722a;
        final /* synthetic */ lb f4723b;

        C17537(la laVar, C1728a c1728a, lb lbVar) {
            this.f4722a = c1728a;
            this.f4723b = lbVar;
        }

        public void run() {
            try {
                this.f4722a.m7195a(this.f4723b);
            } catch (Throwable e) {
                sg.m8447c("Could not propagate interstitial ad event.", e);
            }
        }
    }

    la() {
        this.f4724a = new LinkedList();
    }

    void m7239a(zzl com_google_android_gms_ads_internal_zzl) {
        com_google_android_gms_ads_internal_zzl.zza(new C17341(this));
        com_google_android_gms_ads_internal_zzl.zza(new C17362(this));
        com_google_android_gms_ads_internal_zzl.zza(new C17393(this));
        com_google_android_gms_ads_internal_zzl.zza(new C17414(this));
        com_google_android_gms_ads_internal_zzl.zza(new C17435(this));
        com_google_android_gms_ads_internal_zzl.zza(new C17526(this));
    }

    void m7240a(lb lbVar) {
        Handler handler = rq.f5755a;
        for (C1728a c17537 : this.f4724a) {
            handler.post(new C17537(this, c17537, lbVar));
        }
        this.f4724a.clear();
    }
}
