package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.ex.C1536a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@op
public final class ev extends C1536a {
    private final cf f3923a;
    private final cg f3924b;
    private final bz f3925c;
    private boolean f3926d;

    public ev(String str, Context context, boolean z) {
        this.f3926d = false;
        this.f3923a = cf.m5524a(str, context, z);
        this.f3924b = new cg(this.f3923a);
        this.f3925c = z ? null : bz.m5469b(context);
    }

    private C1108c m5993a(C1108c c1108c, C1108c c1108c2, boolean z) {
        try {
            Uri uri = (Uri) C1111d.m3897a(c1108c);
            Context context = (Context) C1111d.m3897a(c1108c2);
            return C1111d.m3896a(z ? this.f3924b.m5529a(uri, context) : this.f3924b.m5536b(uri, context));
        } catch (ch e) {
            return null;
        }
    }

    public C1108c m5994a(C1108c c1108c, C1108c c1108c2) {
        return m5993a(c1108c, c1108c2, true);
    }

    public String m5995a() {
        return "ms";
    }

    public String m5996a(C1108c c1108c, String str) {
        return this.f3923a.m5297a((Context) C1111d.m3897a(c1108c), str);
    }

    public String m5997a(C1108c c1108c, byte[] bArr) {
        Context context = (Context) C1111d.m3897a(c1108c);
        String a = this.f3923a.m5299a(context, bArr);
        if (this.f3925c == null || !this.f3926d) {
            return a;
        }
        String a2 = this.f3925c.m5471a(a, this.f3925c.m5299a(context, bArr));
        this.f3926d = false;
        return a2;
    }

    public void m5998a(String str) {
        this.f3924b.m5533a(str);
    }

    public void m5999a(String str, String str2) {
        this.f3924b.m5534a(str, str2);
    }

    public boolean m6000a(C1108c c1108c) {
        return this.f3924b.m5535a((Uri) C1111d.m3897a(c1108c));
    }

    public boolean m6001a(String str, boolean z) {
        if (this.f3925c == null) {
            return false;
        }
        this.f3925c.m5472a(new Info(str, z));
        this.f3926d = true;
        return true;
    }

    public C1108c m6002b(C1108c c1108c, C1108c c1108c2) {
        return m5993a(c1108c, c1108c2, false);
    }

    public boolean m6003b(C1108c c1108c) {
        return this.f3924b.m5538c((Uri) C1111d.m3897a(c1108c));
    }

    public String m6004c(C1108c c1108c) {
        return m5997a(c1108c, null);
    }

    public void m6005d(C1108c c1108c) {
        this.f3924b.m5532a((MotionEvent) C1111d.m3897a(c1108c));
    }
}
