package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.lh.C1756a;
import com.google.android.gms.internal.sq.C1171c;
import com.google.android.gms.internal.sq.C1553a;
import com.google.android.gms.internal.sq.C1998b;
import java.util.Map;

@op
public class ll {
    private final Object f4826a;
    private final Context f4827b;
    private final String f4828c;
    private final zzqa f4829d;
    private rv<lh> f4830e;
    private rv<lh> f4831f;
    private C1786d f4832g;
    private int f4833h;

    /* renamed from: com.google.android.gms.internal.ll.1 */
    class C17731 implements Runnable {
        final /* synthetic */ cg f4798a;
        final /* synthetic */ C1786d f4799b;
        final /* synthetic */ ll f4800c;

        /* renamed from: com.google.android.gms.internal.ll.1.1 */
        class C17681 implements C1756a {
            final /* synthetic */ lh f4788a;
            final /* synthetic */ C17731 f4789b;

            /* renamed from: com.google.android.gms.internal.ll.1.1.1 */
            class C17671 implements Runnable {
                final /* synthetic */ C17681 f4787a;

                /* renamed from: com.google.android.gms.internal.ll.1.1.1.1 */
                class C17661 implements Runnable {
                    final /* synthetic */ C17671 f4786a;

                    C17661(C17671 c17671) {
                        this.f4786a = c17671;
                    }

                    public void run() {
                        this.f4786a.f4787a.f4788a.m7292a();
                    }
                }

                C17671(C17681 c17681) {
                    this.f4787a = c17681;
                }

                public void run() {
                    synchronized (this.f4787a.f4789b.f4800c.f4826a) {
                        if (this.f4787a.f4789b.f4799b.m7342b() == -1 || this.f4787a.f4789b.f4799b.m7342b() == 1) {
                            return;
                        }
                        this.f4787a.f4789b.f4799b.m7339a();
                        zzv.zzcJ().m8518a(new C17661(this));
                        rm.m8450a("Could not receive loaded message in a timely manner. Rejecting.");
                    }
                }
            }

            C17681(C17731 c17731, lh lhVar) {
                this.f4789b = c17731;
                this.f4788a = lhVar;
            }

            public void m7324a() {
                rq.f5755a.postDelayed(new C17671(this), (long) C1776a.f4806b);
            }
        }

        /* renamed from: com.google.android.gms.internal.ll.1.2 */
        class C17692 implements kg {
            final /* synthetic */ lh f4790a;
            final /* synthetic */ C17731 f4791b;

            C17692(C17731 c17731, lh lhVar) {
                this.f4791b = c17731;
                this.f4790a = lhVar;
            }

            public void m7325a(sx sxVar, Map<String, String> map) {
                synchronized (this.f4791b.f4800c.f4826a) {
                    if (this.f4791b.f4799b.m7342b() == -1 || this.f4791b.f4799b.m7342b() == 1) {
                        return;
                    }
                    this.f4791b.f4800c.f4833h = 0;
                    this.f4791b.f4800c.f4830e.m7330a(this.f4790a);
                    this.f4791b.f4799b.m7341a(this.f4790a);
                    this.f4791b.f4800c.f4832g = this.f4791b.f4799b;
                    rm.m8450a("Successfully loaded JS Engine.");
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.ll.1.3 */
        class C17703 implements kg {
            final /* synthetic */ lh f4792a;
            final /* synthetic */ sc f4793b;
            final /* synthetic */ C17731 f4794c;

            C17703(C17731 c17731, lh lhVar, sc scVar) {
                this.f4794c = c17731;
                this.f4792a = lhVar;
                this.f4793b = scVar;
            }

            public void m7326a(sx sxVar, Map<String, String> map) {
                synchronized (this.f4794c.f4800c.f4826a) {
                    sg.m8448d("JS Engine is requesting an update");
                    if (this.f4794c.f4800c.f4833h == 0) {
                        sg.m8448d("Starting reload.");
                        this.f4794c.f4800c.f4833h = 2;
                        this.f4794c.f4800c.m7369a(this.f4794c.f4798a);
                    }
                    this.f4792a.m7290b("/requestReload", (kg) this.f4793b.m8678a());
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.ll.1.4 */
        class C17724 implements Runnable {
            final /* synthetic */ lh f4796a;
            final /* synthetic */ C17731 f4797b;

            /* renamed from: com.google.android.gms.internal.ll.1.4.1 */
            class C17711 implements Runnable {
                final /* synthetic */ C17724 f4795a;

                C17711(C17724 c17724) {
                    this.f4795a = c17724;
                }

                public void run() {
                    this.f4795a.f4796a.m7292a();
                }
            }

            C17724(C17731 c17731, lh lhVar) {
                this.f4797b = c17731;
                this.f4796a = lhVar;
            }

            public void run() {
                synchronized (this.f4797b.f4800c.f4826a) {
                    if (this.f4797b.f4799b.m7342b() == -1 || this.f4797b.f4799b.m7342b() == 1) {
                        return;
                    }
                    this.f4797b.f4799b.m7339a();
                    zzv.zzcJ().m8518a(new C17711(this));
                    rm.m8450a("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }

        C17731(ll llVar, cg cgVar, C1786d c1786d) {
            this.f4800c = llVar;
            this.f4798a = cgVar;
            this.f4799b = c1786d;
        }

        public void run() {
            lh a = this.f4800c.m7367a(this.f4800c.f4827b, this.f4800c.f4829d, this.f4798a);
            a.m7294a(new C17681(this, a));
            a.m7287a("/jsLoaded", new C17692(this, a));
            sc scVar = new sc();
            kg c17703 = new C17703(this, a, scVar);
            scVar.m8679a(c17703);
            a.m7287a("/requestReload", c17703);
            if (this.f4800c.f4828c.endsWith(".js")) {
                a.m7295a(this.f4800c.f4828c);
            } else if (this.f4800c.f4828c.startsWith("<html>")) {
                a.m7298c(this.f4800c.f4828c);
            } else {
                a.m7297b(this.f4800c.f4828c);
            }
            rq.f5755a.postDelayed(new C17724(this, a), (long) C1776a.f4805a);
        }
    }

    /* renamed from: com.google.android.gms.internal.ll.2 */
    class C17742 implements C1171c<lh> {
        final /* synthetic */ C1786d f4801a;
        final /* synthetic */ ll f4802b;

        C17742(ll llVar, C1786d c1786d) {
            this.f4802b = llVar;
            this.f4801a = c1786d;
        }

        public void m7327a(lh lhVar) {
            synchronized (this.f4802b.f4826a) {
                this.f4802b.f4833h = 0;
                if (!(this.f4802b.f4832g == null || this.f4801a == this.f4802b.f4832g)) {
                    rm.m8450a("New JS engine is loaded, marking previous one as destroyable.");
                    this.f4802b.f4832g.m7350c();
                }
                this.f4802b.f4832g = this.f4801a;
            }
        }

        public /* synthetic */ void m7328a(Object obj) {
            m7327a((lh) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.ll.3 */
    class C17753 implements C1553a {
        final /* synthetic */ C1786d f4803a;
        final /* synthetic */ ll f4804b;

        C17753(ll llVar, C1786d c1786d) {
            this.f4804b = llVar;
            this.f4803a = c1786d;
        }

        public void m7329a() {
            synchronized (this.f4804b.f4826a) {
                this.f4804b.f4833h = 1;
                rm.m8450a("Failed loading new engine. Marking new engine destroyable.");
                this.f4803a.m7350c();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ll.a */
    static class C1776a {
        static int f4805a;
        static int f4806b;

        static {
            f4805a = 60000;
            f4806b = 10000;
        }
    }

    /* renamed from: com.google.android.gms.internal.ll.b */
    public static class C1777b<T> implements rv<T> {
        public void m7331a(T t) {
        }
    }

    /* renamed from: com.google.android.gms.internal.ll.c */
    public static class C1781c extends sr<lm> {
        private final Object f4813d;
        private final C1786d f4814e;
        private boolean f4815f;

        /* renamed from: com.google.android.gms.internal.ll.c.1 */
        class C17781 implements C1171c<lm> {
            C17781(C1781c c1781c) {
            }

            public void m7332a(lm lmVar) {
                rm.m8450a("Ending javascript session.");
                ((ln) lmVar).m7371a();
            }

            public /* synthetic */ void m7333a(Object obj) {
                m7332a((lm) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.ll.c.2 */
        class C17792 implements C1171c<lm> {
            final /* synthetic */ C1781c f4807a;

            C17792(C1781c c1781c) {
                this.f4807a = c1781c;
            }

            public void m7334a(lm lmVar) {
                rm.m8450a("Releasing engine reference.");
                this.f4807a.f4814e.d_();
            }

            public /* synthetic */ void m7335a(Object obj) {
                m7334a((lm) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.ll.c.3 */
        class C17803 implements C1553a {
            final /* synthetic */ C1781c f4808a;

            C17803(C1781c c1781c) {
                this.f4808a = c1781c;
            }

            public void m7336a() {
                this.f4808a.f4814e.d_();
            }
        }

        public C1781c(C1786d c1786d) {
            this.f4813d = new Object();
            this.f4814e = c1786d;
        }

        public void b_() {
            synchronized (this.f4813d) {
                if (this.f4815f) {
                    return;
                }
                this.f4815f = true;
                m7340a(new C17781(this), new C1998b());
                m7340a(new C17792(this), new C17803(this));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ll.d */
    public static class C1786d extends sr<lh> {
        private final Object f4821d;
        private rv<lh> f4822e;
        private boolean f4823f;
        private int f4824g;

        /* renamed from: com.google.android.gms.internal.ll.d.1 */
        class C17821 implements C1171c<lh> {
            final /* synthetic */ C1781c f4816a;

            C17821(C1786d c1786d, C1781c c1781c) {
                this.f4816a = c1781c;
            }

            public void m7344a(lh lhVar) {
                rm.m8450a("Getting a new session for JS Engine.");
                this.f4816a.m7341a(lhVar.m7296b());
            }

            public /* synthetic */ void m7345a(Object obj) {
                m7344a((lh) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.ll.d.2 */
        class C17832 implements C1553a {
            final /* synthetic */ C1781c f4817a;

            C17832(C1786d c1786d, C1781c c1781c) {
                this.f4817a = c1781c;
            }

            public void m7346a() {
                rm.m8450a("Rejecting reference for JS Engine.");
                this.f4817a.m7339a();
            }
        }

        /* renamed from: com.google.android.gms.internal.ll.d.3 */
        class C17853 implements C1171c<lh> {
            final /* synthetic */ C1786d f4820a;

            /* renamed from: com.google.android.gms.internal.ll.d.3.1 */
            class C17841 implements Runnable {
                final /* synthetic */ lh f4818a;
                final /* synthetic */ C17853 f4819b;

                C17841(C17853 c17853, lh lhVar) {
                    this.f4819b = c17853;
                    this.f4818a = lhVar;
                }

                public void run() {
                    this.f4819b.f4820a.f4822e.m7330a(this.f4818a);
                    this.f4818a.m7292a();
                }
            }

            C17853(C1786d c1786d) {
                this.f4820a = c1786d;
            }

            public void m7347a(lh lhVar) {
                zzv.zzcJ().m8518a(new C17841(this, lhVar));
            }

            public /* synthetic */ void m7348a(Object obj) {
                m7347a((lh) obj);
            }
        }

        public C1786d(rv<lh> rvVar) {
            this.f4821d = new Object();
            this.f4822e = rvVar;
            this.f4823f = false;
            this.f4824g = 0;
        }

        public void m7350c() {
            boolean z = true;
            synchronized (this.f4821d) {
                if (this.f4824g < 0) {
                    z = false;
                }
                C1314c.m4628a(z);
                rm.m8450a("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.f4823f = true;
                m7351d();
            }
        }

        public C1781c c_() {
            C1781c c1781c = new C1781c(this);
            synchronized (this.f4821d) {
                m7340a(new C17821(this, c1781c), new C17832(this, c1781c));
                C1314c.m4628a(this.f4824g >= 0);
                this.f4824g++;
            }
            return c1781c;
        }

        protected void m7351d() {
            synchronized (this.f4821d) {
                C1314c.m4628a(this.f4824g >= 0);
                if (this.f4823f && this.f4824g == 0) {
                    rm.m8450a("No reference is left (including root). Cleaning up engine.");
                    m7340a(new C17853(this), new C1998b());
                } else {
                    rm.m8450a("There are still references to the engine. Not destroying.");
                }
            }
        }

        protected void d_() {
            boolean z = true;
            synchronized (this.f4821d) {
                if (this.f4824g < 1) {
                    z = false;
                }
                C1314c.m4628a(z);
                rm.m8450a("Releasing 1 reference for JS Engine");
                this.f4824g--;
                m7351d();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ll.e */
    public static class C1787e extends sr<lm> {
        private C1781c f4825d;

        public C1787e(C1781c c1781c) {
            this.f4825d = c1781c;
        }

        public void m7352a() {
            this.f4825d.m7339a();
        }

        public void m7353a(lm lmVar) {
            this.f4825d.m7341a(lmVar);
        }

        public void m7354a(C1171c<lm> c1171c, C1553a c1553a) {
            this.f4825d.m7340a(c1171c, c1553a);
        }

        public /* synthetic */ void m7355a(Object obj) {
            m7353a((lm) obj);
        }

        public int m7356b() {
            return this.f4825d.m7342b();
        }

        public void finalize() {
            this.f4825d.b_();
            this.f4825d = null;
        }
    }

    public ll(Context context, zzqa com_google_android_gms_internal_zzqa, String str) {
        this.f4826a = new Object();
        this.f4833h = 1;
        this.f4828c = str;
        this.f4827b = context.getApplicationContext();
        this.f4829d = com_google_android_gms_internal_zzqa;
        this.f4830e = new C1777b();
        this.f4831f = new C1777b();
    }

    public ll(Context context, zzqa com_google_android_gms_internal_zzqa, String str, rv<lh> rvVar, rv<lh> rvVar2) {
        this(context, com_google_android_gms_internal_zzqa, str);
        this.f4830e = rvVar;
        this.f4831f = rvVar2;
    }

    private C1786d m7361c(cg cgVar) {
        C1786d c1786d = new C1786d(this.f4831f);
        zzv.zzcJ().m8518a(new C17731(this, cgVar, c1786d));
        return c1786d;
    }

    protected lh m7367a(Context context, zzqa com_google_android_gms_internal_zzqa, cg cgVar) {
        return new lj(context, com_google_android_gms_internal_zzqa, cgVar, null);
    }

    public C1781c m7368a() {
        return m7370b(null);
    }

    protected C1786d m7369a(cg cgVar) {
        C1786d c = m7361c(cgVar);
        c.m7340a(new C17742(this, c), new C17753(this, c));
        return c;
    }

    public C1781c m7370b(cg cgVar) {
        C1781c c_;
        synchronized (this.f4826a) {
            if (this.f4832g == null || this.f4832g.m7342b() == -1) {
                this.f4833h = 2;
                this.f4832g = m7369a(cgVar);
                c_ = this.f4832g.c_();
            } else if (this.f4833h == 0) {
                c_ = this.f4832g.c_();
            } else if (this.f4833h == 1) {
                this.f4833h = 2;
                m7369a(cgVar);
                c_ = this.f4832g.c_();
            } else if (this.f4833h == 2) {
                c_ = this.f4832g.c_();
            } else {
                c_ = this.f4832g.c_();
            }
        }
        return c_;
    }
}
