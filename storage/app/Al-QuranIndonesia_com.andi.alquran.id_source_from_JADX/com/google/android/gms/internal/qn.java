package com.google.android.gms.internal;

import com.google.android.gms.internal.qr.C1933a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@op
public class qn extends C1933a {
    private volatile ql f5571a;
    private volatile qo f5572b;
    private volatile qm f5573c;

    public qn(qm qmVar) {
        this.f5573c = qmVar;
    }

    public void m8318a(C1108c c1108c) {
        if (this.f5571a != null) {
            this.f5571a.m8282c();
        }
    }

    public void m8319a(C1108c c1108c, int i) {
        if (this.f5571a != null) {
            this.f5571a.m8281a(i);
        }
    }

    public void m8320a(C1108c c1108c, zzok com_google_android_gms_internal_zzok) {
        if (this.f5573c != null) {
            this.f5573c.m8220b(com_google_android_gms_internal_zzok);
        }
    }

    public void m8321a(ql qlVar) {
        this.f5571a = qlVar;
    }

    public void m8322a(qo qoVar) {
        this.f5572b = qoVar;
    }

    public void m8323b(C1108c c1108c) {
        if (this.f5572b != null) {
            this.f5572b.m8283a(C1111d.m3897a(c1108c).getClass().getName());
        }
    }

    public void m8324b(C1108c c1108c, int i) {
        if (this.f5572b != null) {
            this.f5572b.m8284a(C1111d.m3897a(c1108c).getClass().getName(), i);
        }
    }

    public void m8325c(C1108c c1108c) {
        if (this.f5573c != null) {
            this.f5573c.m8221i();
        }
    }

    public void m8326d(C1108c c1108c) {
        if (this.f5573c != null) {
            this.f5573c.m8222j();
        }
    }

    public void m8327e(C1108c c1108c) {
        if (this.f5573c != null) {
            this.f5573c.m8223k();
        }
    }

    public void m8328f(C1108c c1108c) {
        if (this.f5573c != null) {
            this.f5573c.m8224l();
        }
    }

    public void m8329g(C1108c c1108c) {
        if (this.f5573c != null) {
            this.f5573c.m8225m();
        }
    }
}
