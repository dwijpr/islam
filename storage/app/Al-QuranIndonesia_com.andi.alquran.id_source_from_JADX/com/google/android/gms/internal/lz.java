package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@op
public class lz {
    public List<String> m7435a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void m7436a(Context context, String str, rc rcVar, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? "1" : "0";
            for (String replaceAll : list) {
                String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", rcVar.f5628r.f4860h).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", zzv.zzcN().m8388a()).replaceAll("@gw_seqnum@", rcVar.f5619i);
                if (!TextUtils.isEmpty(rcVar.f5631u)) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetstatus@", rcVar.f5631u);
                }
                if (rcVar.f5625o != null) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", rcVar.f5625o.f4838b).replaceAll("@gw_allocid@", rcVar.f5625o.f4840d);
                }
                new sa(context, str, replaceAll2).zziw();
            }
        }
    }
}
