package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@op
public final class lu {
    public final List<lt> f4853a;
    public final long f4854b;
    public final List<String> f4855c;
    public final List<String> f4856d;
    public final List<String> f4857e;
    public final List<String> f4858f;
    public final boolean f4859g;
    public final String f4860h;
    public final long f4861i;
    public final String f4862j;
    public final int f4863k;
    public final int f4864l;
    public final long f4865m;
    public final boolean f4866n;
    public int f4867o;
    public int f4868p;

    public lu(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (sg.m8443a(2)) {
            String str2 = "Mediation Response JSON: ";
            String valueOf = String.valueOf(jSONObject.toString(2));
            rm.m8450a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            lt ltVar = new lt(jSONArray.getJSONObject(i2));
            arrayList.add(ltVar);
            if (i < 0 && m7383a(ltVar)) {
                i = i2;
            }
        }
        this.f4867o = i;
        this.f4868p = jSONArray.length();
        this.f4853a = Collections.unmodifiableList(arrayList);
        this.f4860h = jSONObject.getString("qdata");
        this.f4864l = jSONObject.optInt("fs_model_type", -1);
        this.f4865m = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f4854b = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.f4855c = zzv.zzdc().m7435a(optJSONObject, "click_urls");
            this.f4856d = zzv.zzdc().m7435a(optJSONObject, "imp_urls");
            this.f4857e = zzv.zzdc().m7435a(optJSONObject, "nofill_urls");
            this.f4858f = zzv.zzdc().m7435a(optJSONObject, "remote_ping_urls");
            this.f4859g = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.f4861i = optLong > 0 ? optLong * 1000 : -1;
            zzok a = zzok.m9780a(optJSONObject.optJSONArray("rewards"));
            if (a == null) {
                this.f4862j = null;
                this.f4863k = 0;
            } else {
                this.f4862j = a.f6627b;
                this.f4863k = a.f6628c;
            }
            this.f4866n = optJSONObject.optBoolean("use_displayed_impression", false);
            return;
        }
        this.f4854b = -1;
        this.f4855c = null;
        this.f4856d = null;
        this.f4857e = null;
        this.f4858f = null;
        this.f4861i = -1;
        this.f4862j = null;
        this.f4863k = 0;
        this.f4866n = false;
        this.f4859g = false;
    }

    public lu(List<lt> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.f4853a = list;
        this.f4854b = j;
        this.f4855c = list2;
        this.f4856d = list3;
        this.f4857e = list4;
        this.f4858f = list5;
        this.f4859g = z;
        this.f4860h = str;
        this.f4861i = j2;
        this.f4867o = i;
        this.f4868p = i2;
        this.f4862j = str2;
        this.f4863k = i3;
        this.f4864l = i4;
        this.f4865m = j3;
        this.f4866n = z2;
    }

    private boolean m7383a(lt ltVar) {
        for (String equals : ltVar.f4839c) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
