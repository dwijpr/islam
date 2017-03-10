package com.google.android.gms.internal;

import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1240a;
import com.google.android.gms.common.internal.C1313b;

public final class wj<O extends C1240a> {
    private final boolean f6320a;
    private final int f6321b;
    private final C1274a<O> f6322c;
    private final O f6323d;

    private wj(C1274a<O> c1274a) {
        this.f6320a = true;
        this.f6322c = c1274a;
        this.f6323d = null;
        this.f6321b = System.identityHashCode(this);
    }

    private wj(C1274a<O> c1274a, O o) {
        this.f6320a = false;
        this.f6322c = c1274a;
        this.f6323d = o;
        this.f6321b = C1313b.m4619a(this.f6322c, this.f6323d);
    }

    public static <O extends C1240a> wj<O> m9670a(C1274a<O> c1274a) {
        return new wj(c1274a);
    }

    public static <O extends C1240a> wj<O> m9671a(C1274a<O> c1274a, O o) {
        return new wj(c1274a, o);
    }

    public String m9672a() {
        return this.f6322c.m4528d();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wj)) {
            return false;
        }
        wj wjVar = (wj) obj;
        return !this.f6320a && !wjVar.f6320a && C1313b.m4621a(this.f6322c, wjVar.f6322c) && C1313b.m4621a(this.f6323d, wjVar.f6323d);
    }

    public int hashCode() {
        return this.f6321b;
    }
}
