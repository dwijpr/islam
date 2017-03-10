package com.google.android.gms.internal;

import android.support.v4.p014g.C0297j;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.oh.C1864a;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@op
public class ol implements C1864a<ja> {
    private final boolean f5252a;

    public ol(boolean z) {
        this.f5252a = z;
    }

    private <K, V> C0297j<K, V> m7917a(C0297j<K, Future<V>> c0297j) {
        C0297j<K, V> c0297j2 = new C0297j();
        for (int i = 0; i < c0297j.size(); i++) {
            c0297j2.put(c0297j.m1002b(i), ((Future) c0297j.m1003c(i)).get());
        }
        return c0297j2;
    }

    private void m7918a(oh ohVar, JSONObject jSONObject, C0297j<String, Future<ix>> c0297j) {
        c0297j.put(jSONObject.getString("name"), ohVar.m7890a(jSONObject, "image_value", this.f5252a));
    }

    private void m7919a(JSONObject jSONObject, C0297j<String, String> c0297j) {
        c0297j.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    public /* synthetic */ C1660a m7920a(oh ohVar, JSONObject jSONObject) {
        return m7921b(ohVar, jSONObject);
    }

    public ja m7921b(oh ohVar, JSONObject jSONObject) {
        C0297j c0297j = new C0297j();
        C0297j c0297j2 = new C0297j();
        Future b = ohVar.m7893b(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                m7919a(jSONObject2, c0297j2);
            } else if ("image".equals(string)) {
                m7918a(ohVar, jSONObject2, c0297j);
            } else {
                String str = "Unknown custom asset type: ";
                String valueOf = String.valueOf(string);
                sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        return new ja(jSONObject.getString("custom_template_id"), m7917a(c0297j), c0297j2, (iv) b.get());
    }
}
