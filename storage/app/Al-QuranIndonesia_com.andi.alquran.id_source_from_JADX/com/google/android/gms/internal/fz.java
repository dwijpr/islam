package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C1317j;
import com.google.android.gms.common.internal.C1317j.C1326b;
import com.google.android.gms.common.internal.C1317j.C1327c;
import com.google.android.gms.internal.gc.C1590a;

@op
public class fz extends C1317j<gc> {
    fz(Context context, Looper looper, C1326b c1326b, C1327c c1327c) {
        super(context, looper, 123, c1326b, c1327c, null);
    }

    protected /* synthetic */ IInterface m6272a(IBinder iBinder) {
        return m6273b(iBinder);
    }

    protected gc m6273b(IBinder iBinder) {
        return C1590a.m6308a(iBinder);
    }

    protected String m6274i() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    protected String m6275j() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    public gc m6276k() {
        return (gc) super.m4683u();
    }
}
