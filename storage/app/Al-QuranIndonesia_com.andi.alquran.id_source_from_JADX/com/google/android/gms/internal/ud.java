package com.google.android.gms.internal;

public abstract class ud extends uc {
    private boolean f2853a;

    protected ud(uf ufVar) {
        super(ufVar);
    }

    protected void m4280A() {
        if (!m4283z()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public void m4281B() {
        m4282a();
        this.f2853a = true;
    }

    protected abstract void m4282a();

    public boolean m4283z() {
        return this.f2853a;
    }
}
