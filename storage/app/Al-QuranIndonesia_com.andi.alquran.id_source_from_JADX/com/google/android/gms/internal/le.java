package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.C1314c;
import java.util.Iterator;
import java.util.LinkedList;

@op
class le {
    private final LinkedList<C1755a> f4743a;
    private zzdy f4744b;
    private final String f4745c;
    private final int f4746d;
    private boolean f4747e;

    /* renamed from: com.google.android.gms.internal.le.a */
    class C1755a {
        zzl f4736a;
        zzdy f4737b;
        la f4738c;
        long f4739d;
        boolean f4740e;
        boolean f4741f;
        final /* synthetic */ le f4742g;

        C1755a(le leVar, kz kzVar) {
            this.f4742g = leVar;
            this.f4736a = kzVar.m7159b(leVar.f4745c);
            this.f4738c = new la();
            this.f4738c.m7239a(this.f4736a);
        }

        C1755a(le leVar, kz kzVar, zzdy com_google_android_gms_internal_zzdy) {
            this(leVar, kzVar);
            this.f4737b = com_google_android_gms_internal_zzdy;
        }

        void m7266a() {
            if (!this.f4740e) {
                this.f4741f = this.f4736a.zzb(lc.m7251b(this.f4737b != null ? this.f4737b : this.f4742g.f4744b));
                this.f4740e = true;
                this.f4739d = zzv.zzcP().m4926a();
            }
        }
    }

    le(zzdy com_google_android_gms_internal_zzdy, String str, int i) {
        C1314c.m4623a((Object) com_google_android_gms_internal_zzdy);
        C1314c.m4623a((Object) str);
        this.f4743a = new LinkedList();
        this.f4744b = com_google_android_gms_internal_zzdy;
        this.f4745c = str;
        this.f4746d = i;
    }

    C1755a m7269a(zzdy com_google_android_gms_internal_zzdy) {
        if (com_google_android_gms_internal_zzdy != null) {
            this.f4744b = com_google_android_gms_internal_zzdy;
        }
        return (C1755a) this.f4743a.remove();
    }

    zzdy m7270a() {
        return this.f4744b;
    }

    void m7271a(kz kzVar) {
        C1755a c1755a = new C1755a(this, kzVar);
        this.f4743a.add(c1755a);
        c1755a.m7266a();
    }

    void m7272a(kz kzVar, zzdy com_google_android_gms_internal_zzdy) {
        this.f4743a.add(new C1755a(this, kzVar, com_google_android_gms_internal_zzdy));
    }

    int m7273b() {
        return this.f4746d;
    }

    String m7274c() {
        return this.f4745c;
    }

    int m7275d() {
        return this.f4743a.size();
    }

    int m7276e() {
        Iterator it = this.f4743a.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((C1755a) it.next()).f4740e ? i + 1 : i;
        }
        return i;
    }

    void m7277f() {
        Iterator it = this.f4743a.iterator();
        while (it.hasNext()) {
            ((C1755a) it.next()).m7266a();
        }
    }

    void m7278g() {
        this.f4747e = true;
    }

    boolean m7279h() {
        return this.f4747e;
    }
}
