package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class kp implements kg {
    private final Object f4646a;
    private final Map<String, C1718a> f4647b;

    /* renamed from: com.google.android.gms.internal.kp.a */
    public interface C1718a {
    }

    public kp() {
        this.f4646a = new Object();
        this.f4647b = new HashMap();
    }

    public void m7124a(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        map.get("fail_reason");
        String str3 = (String) map.get("result");
        synchronized (this.f4646a) {
            if (((C1718a) this.f4647b.remove(str)) == null) {
                str2 = "Received result for unexpected method invocation: ";
                str = String.valueOf(str);
                sg.m8449e(str.length() != 0 ? str2.concat(str) : new String(str2));
            } else if (!TextUtils.isEmpty(str2)) {
            } else if (str3 == null) {
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                } catch (JSONException e) {
                    e.getMessage();
                }
            }
        }
    }
}
