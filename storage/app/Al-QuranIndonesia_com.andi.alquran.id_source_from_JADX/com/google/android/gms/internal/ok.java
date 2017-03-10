package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.oh.C1864a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@op
public class ok implements C1864a<iz> {
    private final boolean f5250a;
    private final boolean f5251b;

    public ok(boolean z, boolean z2) {
        this.f5250a = z;
        this.f5251b = z2;
    }

    public /* synthetic */ C1660a m7915a(oh ohVar, JSONObject jSONObject) {
        return m7916b(ohVar, jSONObject);
    }

    public iz m7916b(oh ohVar, JSONObject jSONObject) {
        List<sn> a = ohVar.m7889a(jSONObject, "images", true, this.f5250a, this.f5251b);
        Future a2 = ohVar.m7888a(jSONObject, "secondary_image", false, this.f5250a);
        Future b = ohVar.m7893b(jSONObject);
        List arrayList = new ArrayList();
        for (sn snVar : a) {
            arrayList.add((ix) snVar.get());
        }
        return new iz(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (jh) a2.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (iv) b.get(), new Bundle());
    }
}
