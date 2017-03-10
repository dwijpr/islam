package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.analytics.C1215c;
import com.google.android.gms.analytics.C1236o;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1377c;
import com.google.android.gms.common.util.C1379e;

public class ug {
    private final Context f6061a;
    private final Context f6062b;

    public ug(Context context) {
        C1314c.m4623a((Object) context);
        Object applicationContext = context.getApplicationContext();
        C1314c.m4624a(applicationContext, (Object) "Application context can't be null");
        this.f6061a = applicationContext;
        this.f6062b = applicationContext;
    }

    public Context m9172a() {
        return this.f6061a;
    }

    protected C1236o m9173a(Context context) {
        return C1236o.m4362a(context);
    }

    protected uv m9174a(uf ufVar) {
        return new uv(ufVar);
    }

    public Context m9175b() {
        return this.f6062b;
    }

    protected ul m9176b(uf ufVar) {
        return new ul(ufVar);
    }

    protected ua m9177c(uf ufVar) {
        return new ua(ufVar);
    }

    protected uo m9178d(uf ufVar) {
        return new uo(ufVar);
    }

    protected vq m9179e(uf ufVar) {
        return new vq(ufVar);
    }

    protected vg m9180f(uf ufVar) {
        return new vg(ufVar);
    }

    protected us m9181g(uf ufVar) {
        return new us(ufVar);
    }

    protected C1377c m9182h(uf ufVar) {
        return C1379e.m4937d();
    }

    protected C1215c m9183i(uf ufVar) {
        return new C1215c(ufVar);
    }

    um m9184j(uf ufVar) {
        return new um(ufVar, this);
    }

    vh m9185k(uf ufVar) {
        return new vh(ufVar);
    }

    protected ub m9186l(uf ufVar) {
        return new ub(ufVar, this);
    }

    public uk m9187m(uf ufVar) {
        return new uk(ufVar);
    }

    public vi m9188n(uf ufVar) {
        return new vi(ufVar);
    }

    public ui m9189o(uf ufVar) {
        return new ui(ufVar);
    }

    public uw m9190p(uf ufVar) {
        return new uw(ufVar);
    }

    public vk m9191q(uf ufVar) {
        return new vk(ufVar);
    }
}
