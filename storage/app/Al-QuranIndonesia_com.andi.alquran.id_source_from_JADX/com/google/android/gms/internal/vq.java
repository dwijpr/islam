package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class vq extends ud {
    protected String f6248a;
    protected String f6249b;
    protected int f6250c;
    protected boolean f6251d;
    protected int f6252e;
    protected boolean f6253f;
    protected boolean f6254g;

    public vq(uf ufVar) {
        super(ufVar);
    }

    private static int m9522a(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    protected void m9523C() {
        ApplicationInfo applicationInfo;
        Context l = m4266l();
        try {
            applicationInfo = l.getPackageManager().getApplicationInfo(l.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            m4258d("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            m4260e("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                vb vbVar = (vb) new va(m4263i()).m9327a(i);
                if (vbVar != null) {
                    m9525a(vbVar);
                }
            }
        }
    }

    protected void m9524a() {
        m9523C();
    }

    void m9525a(vb vbVar) {
        int a;
        m4250b("Loading global XML config values");
        if (vbVar.m9390a()) {
            String b = vbVar.m9391b();
            this.f6249b = b;
            m4251b("XML config - app name", b);
        }
        if (vbVar.m9392c()) {
            b = vbVar.m9393d();
            this.f6248a = b;
            m4251b("XML config - app version", b);
        }
        if (vbVar.m9394e()) {
            a = m9522a(vbVar.m9395f());
            if (a >= 0) {
                this.f6250c = a;
                m4247a("XML config - log level", Integer.valueOf(a));
            }
        }
        if (vbVar.m9396g()) {
            a = vbVar.m9397h();
            this.f6252e = a;
            this.f6251d = true;
            m4251b("XML config - dispatch period (sec)", Integer.valueOf(a));
        }
        if (vbVar.m9398i()) {
            boolean j = vbVar.m9399j();
            this.f6254g = j;
            this.f6253f = true;
            m4251b("XML config - dry run", Boolean.valueOf(j));
        }
    }

    public String m9526b() {
        m4280A();
        return this.f6248a;
    }

    public String m9527c() {
        m4280A();
        return this.f6249b;
    }

    public boolean m9528d() {
        m4280A();
        return false;
    }

    public boolean m9529e() {
        m4280A();
        return this.f6251d;
    }

    public int m9530f() {
        m4280A();
        return this.f6252e;
    }

    public boolean m9531g() {
        m4280A();
        return this.f6253f;
    }

    public boolean m9532h() {
        m4280A();
        return this.f6254g;
    }
}
