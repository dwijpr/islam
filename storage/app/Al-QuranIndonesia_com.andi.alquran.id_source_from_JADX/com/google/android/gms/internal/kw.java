package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.C1322h;
import java.util.Map;

@op
public class kw implements kg {
    public void m7150a(sx sxVar, Map<String, String> map) {
        ku zzdg = zzv.zzdg();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                sg.m8449e("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : BuildConfig.VERSION_NAME;
            if (zzdg.m7138b(sxVar)) {
                sg.m8449e("Precache task already running.");
                return;
            }
            C1322h.m4701a(sxVar.m8772h());
            new kt(sxVar, sxVar.m8772h().zzsM.m7066a(sxVar, parseInt, str2), str).zziw();
        } else if (!zzdg.m7136a(sxVar)) {
            sg.m8449e("Precache abort but no preload task running.");
        }
    }
}
