package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.jo.C1661a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.util.List;

@op
public class iz extends C1661a implements C1660a {
    private String f4466a;
    private List<ix> f4467b;
    private String f4468c;
    private jh f4469d;
    private String f4470e;
    private String f4471f;
    private iv f4472g;
    private Bundle f4473h;
    private Object f4474i;
    private jd f4475j;

    public iz(String str, List list, String str2, jh jhVar, String str3, String str4, iv ivVar, Bundle bundle) {
        this.f4474i = new Object();
        this.f4466a = str;
        this.f4467b = list;
        this.f4468c = str2;
        this.f4469d = jhVar;
        this.f4470e = str3;
        this.f4471f = str4;
        this.f4472g = ivVar;
        this.f4473h = bundle;
    }

    public String m6835a() {
        return this.f4466a;
    }

    public void m6836a(jd jdVar) {
        synchronized (this.f4474i) {
            this.f4475j = jdVar;
        }
    }

    public List m6837b() {
        return this.f4467b;
    }

    public String m6838c() {
        return this.f4468c;
    }

    public jh m6839d() {
        return this.f4469d;
    }

    public String m6840e() {
        return this.f4470e;
    }

    public String m6841f() {
        return this.f4471f;
    }

    public C1108c m6842g() {
        return C1111d.m3896a(this.f4475j);
    }

    public Bundle m6843h() {
        return this.f4473h;
    }

    public void m6844i() {
        this.f4466a = null;
        this.f4467b = null;
        this.f4468c = null;
        this.f4469d = null;
        this.f4470e = null;
        this.f4471f = null;
        this.f4472g = null;
        this.f4473h = null;
        this.f4474i = null;
        this.f4475j = null;
    }

    public String m6845k() {
        return "1";
    }

    public String m6846l() {
        return BuildConfig.VERSION_NAME;
    }

    public iv m6847m() {
        return this.f4472g;
    }
}
