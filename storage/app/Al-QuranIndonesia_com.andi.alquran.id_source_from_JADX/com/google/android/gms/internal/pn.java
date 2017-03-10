package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@op
class pn {
    private final List<String> f5451a;
    private final List<String> f5452b;
    private final String f5453c;
    private final String f5454d;
    private final String f5455e;
    private final String f5456f;
    private final boolean f5457g;
    private final boolean f5458h;
    private final String f5459i;
    private final String f5460j;
    private String f5461k;
    private int f5462l;

    public pn(int i, Map<String, String> map) {
        this.f5461k = (String) map.get("url");
        this.f5454d = (String) map.get("base_uri");
        this.f5455e = (String) map.get("post_parameters");
        this.f5457g = m8180b((String) map.get("drt_include"));
        this.f5458h = m8180b((String) map.get("pan_include"));
        this.f5453c = (String) map.get("activation_overlay_url");
        this.f5452b = m8181c((String) map.get("check_packages"));
        this.f5459i = (String) map.get("request_id");
        this.f5456f = (String) map.get("type");
        this.f5451a = m8181c((String) map.get("errors"));
        this.f5462l = i;
        this.f5460j = (String) map.get("fetched_ad");
    }

    private static boolean m8180b(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    private List<String> m8181c(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    public int m8182a() {
        return this.f5462l;
    }

    public void m8183a(String str) {
        this.f5461k = str;
    }

    public List<String> m8184b() {
        return this.f5451a;
    }

    public String m8185c() {
        return this.f5454d;
    }

    public String m8186d() {
        return this.f5455e;
    }

    public String m8187e() {
        return this.f5461k;
    }

    public String m8188f() {
        return this.f5456f;
    }

    public boolean m8189g() {
        return this.f5457g;
    }

    public String m8190h() {
        return this.f5459i;
    }

    public String m8191i() {
        return this.f5460j;
    }
}
