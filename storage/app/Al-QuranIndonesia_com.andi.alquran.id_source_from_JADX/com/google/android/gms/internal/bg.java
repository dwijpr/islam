package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C1317j;
import com.google.android.gms.common.internal.C1317j.C1326b;
import com.google.android.gms.common.internal.C1317j.C1327c;
import com.google.android.gms.internal.bj.C1472a;

public class bg extends C1317j<bj> {
    public bg(Context context, Looper looper, C1326b c1326b, C1327c c1327c) {
        super(context, looper, 116, c1326b, c1327c, null);
    }

    protected /* synthetic */ IInterface m5275a(IBinder iBinder) {
        return m5276b(iBinder);
    }

    protected bj m5276b(IBinder iBinder) {
        return C1472a.m5288a(iBinder);
    }

    protected String m5277i() {
        return "com.google.android.gms.gass.START";
    }

    protected String m5278j() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public bj m5279k() {
        return (bj) super.m4683u();
    }
}
