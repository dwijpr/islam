package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@op
public class kq implements kg {
    private final C1180a f4648a;

    /* renamed from: com.google.android.gms.internal.kq.a */
    public interface C1180a {
        void zzb(zzok com_google_android_gms_internal_zzok);

        void zzcl();
    }

    public kq(C1180a c1180a) {
        this.f4648a = c1180a;
    }

    public static void m7125a(sx sxVar, C1180a c1180a) {
        sxVar.m8776l().m8810a("/reward", new kq(c1180a));
    }

    private void m7126a(Map<String, String> map) {
        zzok com_google_android_gms_internal_zzok;
        try {
            int parseInt = Integer.parseInt((String) map.get("amount"));
            String str = (String) map.get("type");
            if (!TextUtils.isEmpty(str)) {
                com_google_android_gms_internal_zzok = new zzok(str, parseInt);
                this.f4648a.zzb(com_google_android_gms_internal_zzok);
            }
        } catch (Throwable e) {
            sg.m8447c("Unable to parse reward amount.", e);
        }
        com_google_android_gms_internal_zzok = null;
        this.f4648a.zzb(com_google_android_gms_internal_zzok);
    }

    private void m7127b(Map<String, String> map) {
        this.f4648a.zzcl();
    }

    public void m7128a(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            m7126a(map);
        } else if ("video_start".equals(str)) {
            m7127b(map);
        }
    }
}
