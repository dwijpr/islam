package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.jh.C1658a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@op
public class ix extends C1658a {
    private final Drawable f4449a;
    private final Uri f4450b;
    private final double f4451c;

    public ix(Drawable drawable, Uri uri, double d) {
        this.f4449a = drawable;
        this.f4450b = uri;
        this.f4451c = d;
    }

    public C1108c m6788a() {
        return C1111d.m3896a(this.f4449a);
    }

    public Uri m6789b() {
        return this.f4450b;
    }

    public double m6790c() {
        return this.f4451c;
    }
}
