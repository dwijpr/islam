package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@op
public class jj extends Image {
    private final jh f4564a;
    private final Drawable f4565b;
    private final Uri f4566c;
    private final double f4567d;

    public jj(jh jhVar) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.f4564a = jhVar;
        try {
            C1108c a = this.f4564a.m6784a();
            if (a != null) {
                drawable = (Drawable) C1111d.m3897a(a);
                this.f4565b = drawable;
                uri = this.f4564a.m6785b();
                this.f4566c = uri;
                d = 1.0d;
                d = this.f4564a.m6786c();
                this.f4567d = d;
            }
        } catch (Throwable e) {
            sg.m8445b("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.f4565b = drawable;
        try {
            uri = this.f4564a.m6785b();
        } catch (Throwable e2) {
            sg.m8445b("Failed to get uri.", e2);
        }
        this.f4566c = uri;
        d = 1.0d;
        try {
            d = this.f4564a.m6786c();
        } catch (Throwable e3) {
            sg.m8445b("Failed to get scale.", e3);
        }
        this.f4567d = d;
    }

    public Drawable getDrawable() {
        return this.f4565b;
    }

    public double getScale() {
        return this.f4567d;
    }

    public Uri getUri() {
        return this.f4566c;
    }
}
