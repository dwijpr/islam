package com.google.android.gms.internal;

import java.util.Arrays;

final class ei {
    final int f3858a;
    final byte[] f3859b;

    ei(int i, byte[] bArr) {
        this.f3858a = i;
        this.f3859b = bArr;
    }

    int m5919a() {
        return (dz.m5823f(this.f3858a) + 0) + this.f3859b.length;
    }

    void m5920a(dz dzVar) {
        dzVar.m5852e(this.f3858a);
        dzVar.m5851d(this.f3859b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ei)) {
            return false;
        }
        ei eiVar = (ei) obj;
        return this.f3858a == eiVar.f3858a && Arrays.equals(this.f3859b, eiVar.f3859b);
    }

    public int hashCode() {
        return ((this.f3858a + 527) * 31) + Arrays.hashCode(this.f3859b);
    }
}
