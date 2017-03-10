package com.google.android.gms.auth.api.signin.p041a;

/* renamed from: com.google.android.gms.auth.api.signin.a.a */
public class C1244a {
    static int f2932a;
    private int f2933b;

    static {
        f2932a = 31;
    }

    public C1244a() {
        this.f2933b = 1;
    }

    public int m4403a() {
        return this.f2933b;
    }

    public C1244a m4404a(Object obj) {
        this.f2933b = (obj == null ? 0 : obj.hashCode()) + (this.f2933b * f2932a);
        return this;
    }

    public C1244a m4405a(boolean z) {
        this.f2933b = (z ? 1 : 0) + (this.f2933b * f2932a);
        return this;
    }
}
