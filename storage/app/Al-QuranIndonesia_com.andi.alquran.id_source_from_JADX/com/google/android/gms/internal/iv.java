package com.google.android.gms.internal;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import java.util.List;

@op
public class iv {
    static final int f4435a;
    static final int f4436b;
    private static final int f4437c;
    private static final int f4438d;
    private final String f4439e;
    private final List<Drawable> f4440f;
    private final int f4441g;
    private final int f4442h;
    private final int f4443i;
    private final int f4444j;
    private final int f4445k;

    static {
        f4437c = Color.rgb(12, 174, 206);
        f4438d = Color.rgb(204, 204, 204);
        f4435a = f4438d;
        f4436b = f4437c;
    }

    public iv(String str, List<Drawable> list, Integer num, Integer num2, Integer num3, int i, int i2) {
        this.f4439e = str;
        this.f4440f = list;
        this.f4441g = num != null ? num.intValue() : f4435a;
        this.f4442h = num2 != null ? num2.intValue() : f4436b;
        this.f4443i = num3 != null ? num3.intValue() : 12;
        this.f4444j = i;
        this.f4445k = i2;
    }

    public String m6776a() {
        return this.f4439e;
    }

    public List<Drawable> m6777b() {
        return this.f4440f;
    }

    public int m6778c() {
        return this.f4441g;
    }

    public int m6779d() {
        return this.f4442h;
    }

    public int m6780e() {
        return this.f4443i;
    }

    public int m6781f() {
        return this.f4444j;
    }

    public int m6782g() {
        return this.f4445k;
    }
}
