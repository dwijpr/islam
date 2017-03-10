package com.google.android.gms.internal;

import java.util.Map;

@op
public class kk implements kg {
    private final kl f4637a;

    public kk(kl klVar) {
        this.f4637a = klVar;
    }

    public void m7108a(sx sxVar, Map<String, String> map) {
        float parseFloat;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.f4637a.zzg(equals);
                this.f4637a.zza(equals2, parseFloat);
            }
        } catch (Throwable e) {
            sg.m8445b("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.f4637a.zzg(equals);
        this.f4637a.zza(equals2, parseFloat);
    }
}
