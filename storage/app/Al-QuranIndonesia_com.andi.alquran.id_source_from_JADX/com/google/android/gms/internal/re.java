package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@op
public class re {
    private final long f5654a;
    private final List<String> f5655b;
    private final Map<String, C1941b> f5656c;
    private String f5657d;
    private String f5658e;
    private boolean f5659f;

    /* renamed from: com.google.android.gms.internal.re.a */
    class C1940a {
        private final List<String> f5651a;
        private final Bundle f5652b;

        public C1940a(re reVar, List<String> list, Bundle bundle) {
            this.f5651a = list;
            this.f5652b = bundle;
        }
    }

    /* renamed from: com.google.android.gms.internal.re.b */
    class C1941b {
        final List<C1940a> f5653a;

        C1941b(re reVar) {
            this.f5653a = new ArrayList();
        }

        public void m8378a(C1940a c1940a) {
            this.f5653a.add(c1940a);
        }
    }

    public re(String str, long j) {
        this.f5655b = new ArrayList();
        this.f5656c = new HashMap();
        this.f5659f = false;
        this.f5658e = str;
        this.f5654a = j;
        m8379a(str);
    }

    private void m8379a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(NotificationCompatApi24.CATEGORY_STATUS, -1) != 1) {
                    this.f5659f = false;
                    sg.m8449e("App settings could not be fetched successfully.");
                    return;
                }
                this.f5659f = true;
                this.f5657d = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        m8380a(optJSONArray.getJSONObject(i));
                    }
                }
            } catch (Throwable e) {
                sg.m8447c("Exception occurred while processing app setting json", e);
                zzv.zzcN().m8399a(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    private void m8380a(JSONObject jSONObject) {
        String optString = jSONObject.optString("format");
        CharSequence optString2 = jSONObject.optString("ad_unit_id");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            if ("interstitial".equalsIgnoreCase(optString)) {
                this.f5655b.add(optString2);
            } else if ("rewarded".equalsIgnoreCase(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("ad_networks");
                    if (optJSONArray != null) {
                        int i = 0;
                        while (i < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("adapters");
                            if (optJSONArray2 != null) {
                                List arrayList = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    arrayList.add(optJSONArray2.getString(i2));
                                }
                                jSONObject2 = jSONObject2.optJSONObject("data");
                                if (jSONObject2 != null) {
                                    Bundle bundle = new Bundle();
                                    Iterator keys = jSONObject2.keys();
                                    while (keys.hasNext()) {
                                        optString = (String) keys.next();
                                        bundle.putString(optString, jSONObject2.getString(optString));
                                    }
                                    C1940a c1940a = new C1940a(this, arrayList, bundle);
                                    C1941b c1941b = this.f5656c.containsKey(optString2) ? (C1941b) this.f5656c.get(optString2) : new C1941b(this);
                                    c1941b.m8378a(c1940a);
                                    this.f5656c.put(optString2, c1941b);
                                    i++;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    public long m8381a() {
        return this.f5654a;
    }

    public boolean m8382b() {
        return this.f5659f;
    }

    public String m8383c() {
        return this.f5658e;
    }

    public String m8384d() {
        return this.f5657d;
    }
}
