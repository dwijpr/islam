package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.ps.C1919a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@op
public class pf {
    public Bundle f5361a;
    public Bundle f5362b;
    public List<String> f5363c;
    public Location f5364d;
    public C1919a f5365e;
    public String f5366f;
    public String f5367g;
    public zzmh f5368h;
    public po f5369i;
    public JSONObject f5370j;

    public pf() {
        this.f5370j = new JSONObject();
        this.f5363c = new ArrayList();
    }

    public pf m8093a(Location location) {
        this.f5364d = location;
        return this;
    }

    public pf m8094a(Bundle bundle) {
        this.f5362b = bundle;
        return this;
    }

    public pf m8095a(po poVar) {
        this.f5369i = poVar;
        return this;
    }

    public pf m8096a(C1919a c1919a) {
        this.f5365e = c1919a;
        return this;
    }

    public pf m8097a(zzmh com_google_android_gms_internal_zzmh) {
        this.f5368h = com_google_android_gms_internal_zzmh;
        return this;
    }

    public pf m8098a(String str) {
        this.f5367g = str;
        return this;
    }

    public pf m8099a(List<String> list) {
        if (list == null) {
            this.f5363c.clear();
        }
        this.f5363c = list;
        return this;
    }

    public pf m8100a(JSONObject jSONObject) {
        this.f5370j = jSONObject;
        return this;
    }

    public pf m8101b(Bundle bundle) {
        this.f5361a = bundle;
        return this;
    }

    public pf m8102b(String str) {
        this.f5366f = str;
        return this;
    }
}
