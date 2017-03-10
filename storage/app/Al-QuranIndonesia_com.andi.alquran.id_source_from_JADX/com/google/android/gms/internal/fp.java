package com.google.android.gms.internal;

@op
public class fp {
    private final float f4097a;
    private final float f4098b;
    private final float f4099c;
    private final float f4100d;
    private final int f4101e;

    public fp(float f, float f2, float f3, float f4, int i) {
        this.f4097a = f;
        this.f4098b = f2;
        this.f4099c = f + f3;
        this.f4100d = f2 + f4;
        this.f4101e = i;
    }

    float m6218a() {
        return this.f4097a;
    }

    float m6219b() {
        return this.f4098b;
    }

    float m6220c() {
        return this.f4099c;
    }

    float m6221d() {
        return this.f4100d;
    }

    int m6222e() {
        return this.f4101e;
    }
}
