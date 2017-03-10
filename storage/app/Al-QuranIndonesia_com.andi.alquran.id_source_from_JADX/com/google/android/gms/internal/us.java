package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1388n;
import java.util.HashSet;
import java.util.Set;

public class us {
    private final uf f6130a;
    private volatile Boolean f6131b;
    private String f6132c;
    private Set<Integer> f6133d;

    protected us(uf ufVar) {
        C1314c.m4623a((Object) ufVar);
        this.f6130a = ufVar;
    }

    public int m9328A() {
        return ((Integer) uz.f6145E.m9383a()).intValue();
    }

    public int m9329B() {
        return ((Integer) uz.f6146F.m9383a()).intValue();
    }

    public long m9330C() {
        return ((Long) uz.f6147G.m9383a()).longValue();
    }

    public long m9331D() {
        return ((Long) uz.f6156P.m9383a()).longValue();
    }

    public boolean m9332a() {
        if (this.f6131b == null) {
            synchronized (this) {
                if (this.f6131b == null) {
                    ApplicationInfo applicationInfo = this.f6130a.m9154b().getApplicationInfo();
                    String a = C1388n.m4971a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.f6131b = Boolean.valueOf(z);
                    }
                    if ((this.f6131b == null || !this.f6131b.booleanValue()) && "com.google.android.gms.analytics".equals(a)) {
                        this.f6131b = Boolean.TRUE;
                    }
                    if (this.f6131b == null) {
                        this.f6131b = Boolean.TRUE;
                        this.f6130a.m9158f().m4262f("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f6131b.booleanValue();
    }

    public boolean m9333b() {
        return ((Boolean) uz.f6159b.m9383a()).booleanValue();
    }

    public int m9334c() {
        return ((Integer) uz.f6178u.m9383a()).intValue();
    }

    public int m9335d() {
        return ((Integer) uz.f6182y.m9383a()).intValue();
    }

    public int m9336e() {
        return ((Integer) uz.f6183z.m9383a()).intValue();
    }

    public int m9337f() {
        return ((Integer) uz.f6141A.m9383a()).intValue();
    }

    public long m9338g() {
        return ((Long) uz.f6167j.m9383a()).longValue();
    }

    public long m9339h() {
        return ((Long) uz.f6166i.m9383a()).longValue();
    }

    public long m9340i() {
        return ((Long) uz.f6170m.m9383a()).longValue();
    }

    public long m9341j() {
        return ((Long) uz.f6171n.m9383a()).longValue();
    }

    public int m9342k() {
        return ((Integer) uz.f6172o.m9383a()).intValue();
    }

    public int m9343l() {
        return ((Integer) uz.f6173p.m9383a()).intValue();
    }

    public long m9344m() {
        return (long) ((Integer) uz.f6143C.m9383a()).intValue();
    }

    public String m9345n() {
        return (String) uz.f6175r.m9383a();
    }

    public String m9346o() {
        return (String) uz.f6174q.m9383a();
    }

    public String m9347p() {
        return (String) uz.f6176s.m9383a();
    }

    public String m9348q() {
        return (String) uz.f6177t.m9383a();
    }

    public un m9349r() {
        return un.m9308a((String) uz.f6179v.m9383a());
    }

    public up m9350s() {
        return up.m9320a((String) uz.f6180w.m9383a());
    }

    public Set<Integer> m9351t() {
        String str = (String) uz.f6142B.m9383a();
        if (this.f6133d == null || this.f6132c == null || !this.f6132c.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.f6132c = str;
            this.f6133d = hashSet;
        }
        return this.f6133d;
    }

    public long m9352u() {
        return ((Long) uz.f6151K.m9383a()).longValue();
    }

    public long m9353v() {
        return ((Long) uz.f6152L.m9383a()).longValue();
    }

    public long m9354w() {
        return ((Long) uz.f6155O.m9383a()).longValue();
    }

    public int m9355x() {
        return ((Integer) uz.f6163f.m9383a()).intValue();
    }

    public int m9356y() {
        return ((Integer) uz.f6165h.m9383a()).intValue();
    }

    public String m9357z() {
        return "google_analytics_v4.db";
    }
}
