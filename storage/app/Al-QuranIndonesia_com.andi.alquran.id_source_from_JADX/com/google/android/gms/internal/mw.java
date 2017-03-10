package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@op
public class mw {
    private final sx f5036a;
    private final boolean f5037b;
    private final String f5038c;

    public mw(sx sxVar, Map<String, String> map) {
        this.f5036a = sxVar;
        this.f5038c = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f5037b = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.f5037b = true;
        }
    }

    public void m7710a() {
        if (this.f5036a == null) {
            sg.m8449e("AdWebView is null");
            return;
        }
        int b = "portrait".equalsIgnoreCase(this.f5038c) ? zzv.zzcL().m8574b() : "landscape".equalsIgnoreCase(this.f5038c) ? zzv.zzcL().m8560a() : this.f5037b ? -1 : zzv.zzcL().m8578c();
        this.f5036a.m8761b(b);
    }
}
