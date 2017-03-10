package com.google.android.gms.tagmanager;

class ag extends af {
    private static final Object f7040a;
    private static ag f7041k;
    private C2236k f7042b;
    private volatile C2235j f7043c;
    private int f7044d;
    private boolean f7045e;
    private boolean f7046f;
    private boolean f7047g;
    private boolean f7048h;
    private C2202l f7049i;
    private boolean f7050j;

    /* renamed from: com.google.android.gms.tagmanager.ag.1 */
    class C22031 implements C2202l {
        final /* synthetic */ ag f7038a;

        C22031(ag agVar) {
            this.f7038a = agVar;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ag.2 */
    class C22042 implements Runnable {
        final /* synthetic */ ag f7039a;

        C22042(ag agVar) {
            this.f7039a = agVar;
        }

        public void run() {
            this.f7039a.f7042b.m10261a();
        }
    }

    static {
        f7040a = new Object();
    }

    private ag() {
        this.f7044d = 1800000;
        this.f7045e = true;
        this.f7046f = false;
        this.f7047g = true;
        this.f7048h = true;
        this.f7049i = new C22031(this);
        this.f7050j = false;
    }

    public static ag m10129b() {
        if (f7041k == null) {
            f7041k = new ag();
        }
        return f7041k;
    }

    public synchronized void m10130a() {
        if (this.f7046f) {
            this.f7043c.m10260a(new C22042(this));
        } else {
            C2238n.m10269d("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f7045e = true;
        }
    }
}
