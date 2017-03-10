package com.google.android.gms.internal;

public final class ec implements Cloneable {
    private static final ed f3847a;
    private boolean f3848b;
    private int[] f3849c;
    private ed[] f3850d;
    private int f3851e;

    static {
        f3847a = new ed();
    }

    ec() {
        this(10);
    }

    ec(int i) {
        this.f3848b = false;
        int c = m5885c(i);
        this.f3849c = new int[c];
        this.f3850d = new ed[c];
        this.f3851e = 0;
    }

    private boolean m5883a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean m5884a(ed[] edVarArr, ed[] edVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!edVarArr[i2].equals(edVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int m5885c(int i) {
        return m5886d(i * 4) / 4;
    }

    private int m5886d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int m5887e(int i) {
        int i2 = 0;
        int i3 = this.f3851e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f3849c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    int m5888a() {
        return this.f3851e;
    }

    ed m5889a(int i) {
        int e = m5887e(i);
        return (e < 0 || this.f3850d[e] == f3847a) ? null : this.f3850d[e];
    }

    void m5890a(int i, ed edVar) {
        int e = m5887e(i);
        if (e >= 0) {
            this.f3850d[e] = edVar;
            return;
        }
        e ^= -1;
        if (e >= this.f3851e || this.f3850d[e] != f3847a) {
            if (this.f3851e >= this.f3849c.length) {
                int c = m5885c(this.f3851e + 1);
                Object obj = new int[c];
                Object obj2 = new ed[c];
                System.arraycopy(this.f3849c, 0, obj, 0, this.f3849c.length);
                System.arraycopy(this.f3850d, 0, obj2, 0, this.f3850d.length);
                this.f3849c = obj;
                this.f3850d = obj2;
            }
            if (this.f3851e - e != 0) {
                System.arraycopy(this.f3849c, e, this.f3849c, e + 1, this.f3851e - e);
                System.arraycopy(this.f3850d, e, this.f3850d, e + 1, this.f3851e - e);
            }
            this.f3849c[e] = i;
            this.f3850d[e] = edVar;
            this.f3851e++;
            return;
        }
        this.f3849c[e] = i;
        this.f3850d[e] = edVar;
    }

    ed m5891b(int i) {
        return this.f3850d[i];
    }

    public boolean m5892b() {
        return m5888a() == 0;
    }

    public final ec m5893c() {
        int a = m5888a();
        ec ecVar = new ec(a);
        System.arraycopy(this.f3849c, 0, ecVar.f3849c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f3850d[i] != null) {
                ecVar.f3850d[i] = (ed) this.f3850d[i].clone();
            }
        }
        ecVar.f3851e = a;
        return ecVar;
    }

    public /* synthetic */ Object clone() {
        return m5893c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ec)) {
            return false;
        }
        ec ecVar = (ec) obj;
        return m5888a() != ecVar.m5888a() ? false : m5883a(this.f3849c, ecVar.f3849c, this.f3851e) && m5884a(this.f3850d, ecVar.f3850d, this.f3851e);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f3851e; i2++) {
            i = (((i * 31) + this.f3849c[i2]) * 31) + this.f3850d[i2].hashCode();
        }
        return i;
    }
}
