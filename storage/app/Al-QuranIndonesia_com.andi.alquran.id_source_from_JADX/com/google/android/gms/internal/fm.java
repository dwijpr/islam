package com.google.android.gms.internal;

public class fm implements qi {
    private int f4055a;
    private int f4056b;
    private final int f4057c;
    private final float f4058d;

    public fm() {
        this(2500, 1, 1.0f);
    }

    public fm(int i, int i2, float f) {
        this.f4055a = i;
        this.f4057c = i2;
        this.f4058d = f;
    }

    public int m6184a() {
        return this.f4055a;
    }

    public void m6185a(ti tiVar) {
        this.f4056b++;
        this.f4055a = (int) (((float) this.f4055a) + (((float) this.f4055a) * this.f4058d));
        if (!m6187c()) {
            throw tiVar;
        }
    }

    public int m6186b() {
        return this.f4056b;
    }

    protected boolean m6187c() {
        return this.f4056b <= this.f4057c;
    }
}
