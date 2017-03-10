package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.location.C0779d;
import com.google.android.gms.location.LocationRequest;

public class bw extends bm {
    private final bv f3639f;

    public bw(Context context, Looper looper, C0777b c0777b, C0778c c0778c, String str, C1338k c1338k) {
        super(context, looper, c0777b, c0778c, str, c1338k);
        this.f3639f = new bv(context, this.e);
    }

    public void m5446a() {
        synchronized (this.f3639f) {
            if (m4666b()) {
                try {
                    this.f3639f.m5444b();
                    this.f3639f.m5445c();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.m4656a();
        }
    }

    public void m5447a(LocationRequest locationRequest, C2078x<C0779d> c2078x, br brVar) {
        synchronized (this.f3639f) {
            this.f3639f.m5442a(locationRequest, c2078x, brVar);
        }
    }

    public Location m5448k() {
        return this.f3639f.m5441a();
    }
}
