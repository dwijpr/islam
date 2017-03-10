package com.google.android.gms.tagmanager;

/* renamed from: com.google.android.gms.tagmanager.a */
public class C2195a {
    private final String f7011a;
    private ad f7012b;

    private synchronized ad m10090c() {
        return this.f7012b;
    }

    public String m10091a() {
        return this.f7011a;
    }

    public void m10092a(String str) {
        m10090c().m10123a(str);
    }

    void m10093b() {
        this.f7012b = null;
    }
}
