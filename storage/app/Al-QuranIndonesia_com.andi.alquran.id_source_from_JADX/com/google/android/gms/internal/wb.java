package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.internal.C1319o;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.internal.we.C2063a;

public class wb extends C1319o<we> {
    public wb(Context context, Looper looper, C1338k c1338k, C0777b c0777b, C0778c c0778c) {
        super(context, looper, 40, c1338k, c0777b, c0778c);
    }

    protected /* synthetic */ IInterface m9625a(IBinder iBinder) {
        return m9627b(iBinder);
    }

    public void m9626a(wd wdVar, zzzh com_google_android_gms_internal_zzzh) {
        ((we) m4683u()).m9642a(wdVar, com_google_android_gms_internal_zzzh);
    }

    protected we m9627b(IBinder iBinder) {
        return C2063a.m9645a(iBinder);
    }

    protected String m9628i() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected String m9629j() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
