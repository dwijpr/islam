package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@op
public class km implements kg {
    final HashMap<String, sk<JSONObject>> f4638a;

    public km() {
        this.f4638a = new HashMap();
    }

    public Future<JSONObject> m7109a(String str) {
        Future skVar = new sk();
        this.f4638a.put(str, skVar);
        return skVar;
    }

    public void m7110a(sx sxVar, Map<String, String> map) {
        m7111a((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public void m7111a(String str, String str2) {
        sg.m8444b("Received ad from the cache.");
        sk skVar = (sk) this.f4638a.get(str);
        if (skVar == null) {
            sg.m8446c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            skVar.m7304b(new JSONObject(str2));
        } catch (Throwable e) {
            sg.m8445b("Failed constructing JSON object from value passed from javascript", e);
            skVar.m7304b(null);
        } finally {
            this.f4638a.remove(str);
        }
    }

    public void m7112b(String str) {
        sk skVar = (sk) this.f4638a.get(str);
        if (skVar == null) {
            sg.m8446c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!skVar.isDone()) {
            skVar.cancel(true);
        }
        this.f4638a.remove(str);
    }
}
