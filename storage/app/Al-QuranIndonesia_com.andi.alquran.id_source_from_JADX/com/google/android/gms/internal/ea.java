package com.google.android.gms.internal;

public abstract class ea<M extends ea<M>> extends eg {
    protected ec ag;

    public void m5172a(dz dzVar) {
        if (this.ag != null) {
            for (int i = 0; i < this.ag.m5888a(); i++) {
                this.ag.m5891b(i).m5896a(dzVar);
            }
        }
    }

    protected final boolean m5173a(dy dyVar, int i) {
        int p = dyVar.m5798p();
        if (!dyVar.m5780b(i)) {
            return false;
        }
        int b = ej.m5924b(i);
        ei eiVar = new ei(i, dyVar.m5778a(p, dyVar.m5798p() - p));
        ed edVar = null;
        if (this.ag == null) {
            this.ag = new ec();
        } else {
            edVar = this.ag.m5889a(b);
        }
        if (edVar == null) {
            edVar = new ed();
            this.ag.m5890a(b, edVar);
        }
        edVar.m5897a(eiVar);
        return true;
    }

    protected int m5174b() {
        int i = 0;
        if (this.ag == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.ag.m5888a()) {
            i2 += this.ag.m5891b(i).m5895a();
            i++;
        }
        return i2;
    }

    public /* synthetic */ Object clone() {
        return m5175d();
    }

    public M m5175d() {
        ea eaVar = (ea) super.m5153e();
        ee.m5902a(this, eaVar);
        return eaVar;
    }

    public /* synthetic */ eg m5176e() {
        return (ea) clone();
    }
}
