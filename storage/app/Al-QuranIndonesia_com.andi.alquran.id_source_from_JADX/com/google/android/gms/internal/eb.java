package com.google.android.gms.internal;

import com.google.android.gms.C1114a.C1096c;
import java.lang.reflect.Array;

public class eb<M extends ea<M>, T> {
    protected final int f3843a;
    protected final Class<T> f3844b;
    public final int f3845c;
    protected final boolean f3846d;

    int m5877a(Object obj) {
        return this.f3846d ? m5879b(obj) : m5881c(obj);
    }

    void m5878a(Object obj, dz dzVar) {
        if (this.f3846d) {
            m5882c(obj, dzVar);
        } else {
            m5880b(obj, dzVar);
        }
    }

    protected int m5879b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m5881c(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void m5880b(Object obj, dz dzVar) {
        try {
            dzVar.m5852e(this.f3845c);
            switch (this.f3843a) {
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    eg egVar = (eg) obj;
                    int b = ej.m5924b(this.f3845c);
                    dzVar.m5838a(egVar);
                    dzVar.m5848c(b, 4);
                    return;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    dzVar.m5844b((eg) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f3843a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected int m5881c(Object obj) {
        int b = ej.m5924b(this.f3845c);
        switch (this.f3843a) {
            case C1096c.MapAttrs_uiTiltGestures /*10*/:
                return dz.m5808b(b, (eg) obj);
            case C1096c.MapAttrs_uiZoomControls /*11*/:
                return dz.m5814c(b, (eg) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f3843a);
        }
    }

    protected void m5882c(Object obj, dz dzVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m5880b(obj2, dzVar);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eb)) {
            return false;
        }
        eb ebVar = (eb) obj;
        return this.f3843a == ebVar.f3843a && this.f3844b == ebVar.f3844b && this.f3845c == ebVar.f3845c && this.f3846d == ebVar.f3846d;
    }

    public int hashCode() {
        return (this.f3846d ? 1 : 0) + ((((((this.f3843a + 1147) * 31) + this.f3844b.hashCode()) * 31) + this.f3845c) * 31);
    }
}
