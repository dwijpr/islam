package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ed implements Cloneable {
    private eb<?, ?> f3852a;
    private Object f3853b;
    private List<ei> f3854c;

    ed() {
        this.f3854c = new ArrayList();
    }

    private byte[] m5894c() {
        byte[] bArr = new byte[m5895a()];
        m5896a(dz.m5803a(bArr));
        return bArr;
    }

    int m5895a() {
        if (this.f3853b != null) {
            return this.f3852a.m5877a(this.f3853b);
        }
        int i = 0;
        for (ei a : this.f3854c) {
            i = a.m5919a() + i;
        }
        return i;
    }

    void m5896a(dz dzVar) {
        if (this.f3853b != null) {
            this.f3852a.m5878a(this.f3853b, dzVar);
            return;
        }
        for (ei a : this.f3854c) {
            a.m5920a(dzVar);
        }
    }

    void m5897a(ei eiVar) {
        this.f3854c.add(eiVar);
    }

    public final ed m5898b() {
        ed edVar = new ed();
        try {
            edVar.f3852a = this.f3852a;
            if (this.f3854c == null) {
                edVar.f3854c = null;
            } else {
                edVar.f3854c.addAll(this.f3854c);
            }
            if (this.f3853b != null) {
                if (this.f3853b instanceof eg) {
                    edVar.f3853b = (eg) ((eg) this.f3853b).clone();
                } else if (this.f3853b instanceof byte[]) {
                    edVar.f3853b = ((byte[]) this.f3853b).clone();
                } else if (this.f3853b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f3853b;
                    r4 = new byte[bArr.length][];
                    edVar.f3853b = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.f3853b instanceof boolean[]) {
                    edVar.f3853b = ((boolean[]) this.f3853b).clone();
                } else if (this.f3853b instanceof int[]) {
                    edVar.f3853b = ((int[]) this.f3853b).clone();
                } else if (this.f3853b instanceof long[]) {
                    edVar.f3853b = ((long[]) this.f3853b).clone();
                } else if (this.f3853b instanceof float[]) {
                    edVar.f3853b = ((float[]) this.f3853b).clone();
                } else if (this.f3853b instanceof double[]) {
                    edVar.f3853b = ((double[]) this.f3853b).clone();
                } else if (this.f3853b instanceof eg[]) {
                    eg[] egVarArr = (eg[]) this.f3853b;
                    r4 = new eg[egVarArr.length];
                    edVar.f3853b = r4;
                    for (r2 = 0; r2 < egVarArr.length; r2++) {
                        r4[r2] = (eg) egVarArr[r2].clone();
                    }
                }
            }
            return edVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() {
        return m5898b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ed)) {
            return false;
        }
        ed edVar = (ed) obj;
        if (this.f3853b != null && edVar.f3853b != null) {
            return this.f3852a == edVar.f3852a ? !this.f3852a.f3844b.isArray() ? this.f3853b.equals(edVar.f3853b) : this.f3853b instanceof byte[] ? Arrays.equals((byte[]) this.f3853b, (byte[]) edVar.f3853b) : this.f3853b instanceof int[] ? Arrays.equals((int[]) this.f3853b, (int[]) edVar.f3853b) : this.f3853b instanceof long[] ? Arrays.equals((long[]) this.f3853b, (long[]) edVar.f3853b) : this.f3853b instanceof float[] ? Arrays.equals((float[]) this.f3853b, (float[]) edVar.f3853b) : this.f3853b instanceof double[] ? Arrays.equals((double[]) this.f3853b, (double[]) edVar.f3853b) : this.f3853b instanceof boolean[] ? Arrays.equals((boolean[]) this.f3853b, (boolean[]) edVar.f3853b) : Arrays.deepEquals((Object[]) this.f3853b, (Object[]) edVar.f3853b) : false;
        } else {
            if (this.f3854c != null && edVar.f3854c != null) {
                return this.f3854c.equals(edVar.f3854c);
            }
            try {
                return Arrays.equals(m5894c(), edVar.m5894c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m5894c()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
