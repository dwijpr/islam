package com.google.android.gms.internal;

import android.content.Context;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.C1215c;
import com.google.android.gms.analytics.C1236o;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1377c;

public class uc {
    private final uf f2852a;

    protected uc(uf ufVar) {
        C1314c.m4623a((Object) ufVar);
        this.f2852a = ufVar;
    }

    private static String m4244a(Object obj) {
        if (obj == null) {
            return BuildConfig.VERSION_NAME;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
        } else {
            return obj == Boolean.TRUE ? "true" : "false";
        }
    }

    private void m4245a(int i, String str, Object obj, Object obj2, Object obj3) {
        vg vgVar = null;
        if (this.f2852a != null) {
            vgVar = this.f2852a.m9159g();
        }
        if (vgVar != null) {
            vgVar.m9431a(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) uz.f6160c.m9383a();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, m4246c(str, obj, obj2, obj3));
        }
    }

    protected static String m4246c(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = BuildConfig.VERSION_NAME;
        }
        Object a = m4244a(obj);
        Object a2 = m4244a(obj2);
        Object a3 = m4244a(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = BuildConfig.VERSION_NAME;
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    public void m4247a(String str, Object obj) {
        m4245a(2, str, obj, null, null);
    }

    public void m4248a(String str, Object obj, Object obj2) {
        m4245a(2, str, obj, obj2, null);
    }

    public void m4249a(String str, Object obj, Object obj2, Object obj3) {
        m4245a(3, str, obj, obj2, obj3);
    }

    public void m4250b(String str) {
        m4245a(2, str, null, null, null);
    }

    public void m4251b(String str, Object obj) {
        m4245a(3, str, obj, null, null);
    }

    public void m4252b(String str, Object obj, Object obj2) {
        m4245a(3, str, obj, obj2, null);
    }

    public void m4253b(String str, Object obj, Object obj2, Object obj3) {
        m4245a(5, str, obj, obj2, obj3);
    }

    public void m4254c(String str) {
        m4245a(3, str, null, null, null);
    }

    public void m4255c(String str, Object obj) {
        m4245a(4, str, obj, null, null);
    }

    public void m4256c(String str, Object obj, Object obj2) {
        m4245a(5, str, obj, obj2, null);
    }

    public void m4257d(String str) {
        m4245a(4, str, null, null, null);
    }

    public void m4258d(String str, Object obj) {
        m4245a(5, str, obj, null, null);
    }

    public void m4259d(String str, Object obj, Object obj2) {
        m4245a(6, str, obj, obj2, null);
    }

    public void m4260e(String str) {
        m4245a(5, str, null, null, null);
    }

    public void m4261e(String str, Object obj) {
        m4245a(6, str, obj, null, null);
    }

    public void m4262f(String str) {
        m4245a(6, str, null, null, null);
    }

    public uf m4263i() {
        return this.f2852a;
    }

    protected void m4264j() {
        this.f2852a.m9171s();
    }

    protected C1377c m4265k() {
        return this.f2852a.m9156d();
    }

    protected Context m4266l() {
        return this.f2852a.m9154b();
    }

    protected vg m4267m() {
        return this.f2852a.m9158f();
    }

    protected us m4268n() {
        return this.f2852a.m9157e();
    }

    protected C1236o m4269o() {
        return this.f2852a.m9160h();
    }

    public C1215c m4270p() {
        return this.f2852a.m9163k();
    }

    protected ub m4271q() {
        return this.f2852a.m9161i();
    }

    protected uw m4272r() {
        return this.f2852a.m9162j();
    }

    protected vq m4273s() {
        return this.f2852a.m9164l();
    }

    protected vk m4274t() {
        return this.f2852a.m9165m();
    }

    protected uo m4275u() {
        return this.f2852a.m9168p();
    }

    protected ua m4276v() {
        return this.f2852a.m9167o();
    }

    protected ul m4277w() {
        return this.f2852a.m9169q();
    }

    protected uv m4278x() {
        return this.f2852a.m9170r();
    }

    public boolean m4279y() {
        return Log.isLoggable((String) uz.f6160c.m9383a(), 2);
    }
}
