package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@op
public final class lt {
    public final String f4837a;
    public final String f4838b;
    public final List<String> f4839c;
    public final String f4840d;
    public final String f4841e;
    public final List<String> f4842f;
    public final List<String> f4843g;
    public final List<String> f4844h;
    public final String f4845i;
    public final List<String> f4846j;
    public final List<String> f4847k;
    public final String f4848l;
    public final String f4849m;
    public final String f4850n;
    public final List<String> f4851o;
    public final String f4852p;

    public lt(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, String str5, String str6, List<String> list4, List<String> list5, String str7, String str8, String str9, List<String> list6, String str10, List<String> list7) {
        this.f4837a = str;
        this.f4838b = str2;
        this.f4839c = list;
        this.f4840d = str3;
        this.f4841e = str4;
        this.f4842f = list2;
        this.f4843g = list3;
        this.f4845i = str5;
        this.f4846j = list4;
        this.f4847k = list5;
        this.f4848l = str7;
        this.f4849m = str8;
        this.f4850n = str9;
        this.f4851o = list6;
        this.f4852p = str10;
        this.f4844h = list7;
    }

    public lt(JSONObject jSONObject) {
        String str = null;
        this.f4838b = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f4839c = Collections.unmodifiableList(arrayList);
        this.f4840d = jSONObject.optString("allocation_id", null);
        this.f4842f = zzv.zzdc().m7435a(jSONObject, "clickurl");
        this.f4843g = zzv.zzdc().m7435a(jSONObject, "imp_urls");
        this.f4844h = zzv.zzdc().m7435a(jSONObject, "fill_urls");
        this.f4846j = zzv.zzdc().m7435a(jSONObject, "video_start_urls");
        this.f4847k = zzv.zzdc().m7435a(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.f4837a = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.f4845i = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.f4841e = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.f4848l = jSONObject.optString("html_template", null);
        this.f4849m = jSONObject.optString("ad_base_url", null);
        optJSONObject = jSONObject.optJSONObject("assets");
        this.f4850n = optJSONObject != null ? optJSONObject.toString() : null;
        this.f4851o = zzv.zzdc().m7435a(jSONObject, "template_ids");
        optJSONObject = jSONObject.optJSONObject("ad_loader_options");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        this.f4852p = str;
    }
}
