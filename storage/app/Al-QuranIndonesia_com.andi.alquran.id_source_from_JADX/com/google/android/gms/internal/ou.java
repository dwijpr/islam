package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C1317j;
import com.google.android.gms.common.internal.C1317j.C1326b;
import com.google.android.gms.common.internal.C1317j.C1327c;
import com.google.android.gms.internal.pa.C1897a;

@op
public class ou extends C1317j<pa> {
    final int f5296e;

    public ou(Context context, Looper looper, C1326b c1326b, C1327c c1327c, int i) {
        super(context, looper, 8, c1326b, c1327c, null);
        this.f5296e = i;
    }

    protected /* synthetic */ IInterface m7976a(IBinder iBinder) {
        return m7977b(iBinder);
    }

    protected pa m7977b(IBinder iBinder) {
        return C1897a.m8068a(iBinder);
    }

    protected String m7978i() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String m7979j() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public pa m7980k() {
        return (pa) super.m4683u();
    }
}
