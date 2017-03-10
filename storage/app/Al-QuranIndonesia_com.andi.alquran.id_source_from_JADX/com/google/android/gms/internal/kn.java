package com.google.android.gms.internal;

import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.common.util.C1378d;
import com.google.android.gms.maps.GoogleMap;
import java.util.Map;

@op
public class kn implements kg {
    static final Map<String, Integer> f4639a;
    private final zze f4640b;
    private final mv f4641c;

    static {
        f4639a = C1378d.m4929a("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    }

    public kn(zze com_google_android_gms_ads_internal_zze, mv mvVar) {
        this.f4640b = com_google_android_gms_ads_internal_zze;
        this.f4641c = mvVar;
    }

    public void m7113a(sx sxVar, Map<String, String> map) {
        int intValue = ((Integer) f4639a.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.f4640b == null || this.f4640b.zzcb()) {
            switch (intValue) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    this.f4641c.m7703a((Map) map);
                    return;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    new mx(sxVar, map).m7714a();
                    return;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    new mu(sxVar, map).m7697a();
                    return;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    new mw(sxVar, map).m7710a();
                    return;
                case C1096c.MapAttrs_liteMode /*6*/:
                    this.f4641c.m7704a(true);
                    return;
                default:
                    sg.m8448d("Unknown MRAID command called.");
                    return;
            }
        }
        this.f4640b.zzx(null);
    }
}
