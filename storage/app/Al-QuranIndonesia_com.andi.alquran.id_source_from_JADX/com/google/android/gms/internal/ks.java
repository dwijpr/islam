package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@op
class ks implements kg {
    ks() {
    }

    private int m7131a(Map<String, String> map) {
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        return (parseInt < 0 || 3 < parseInt) ? 0 : parseInt;
    }

    public void m7132a(sx sxVar, Map<String, String> map) {
        Throwable e;
        if (((Boolean) C1648if.bi.m6682c()).booleanValue()) {
            tc tcVar;
            tc z = sxVar.m8790z();
            if (z == null) {
                try {
                    z = new tc(sxVar, Float.parseFloat((String) map.get("duration")));
                    sxVar.m8753a(z);
                    tcVar = z;
                } catch (NullPointerException e2) {
                    e = e2;
                    sg.m8445b("Unable to parse videoMeta message.", e);
                    zzv.zzcN().m8399a(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                } catch (NumberFormatException e3) {
                    e = e3;
                    sg.m8445b("Unable to parse videoMeta message.", e);
                    zzv.zzcN().m8399a(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                }
            }
            tcVar = z;
            boolean equals = "1".equals(map.get("muted"));
            float parseFloat = Float.parseFloat((String) map.get("currentTime"));
            int a = m7131a(map);
            String str = (String) map.get("aspectRatio");
            float parseFloat2 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (sg.m8443a(3)) {
                sg.m8444b(new StringBuilder(String.valueOf(str).length() + 79).append("Video Meta GMSG: isMuted : ").append(equals).append(" , playbackState : ").append(a).append(" , aspectRatio : ").append(str).toString());
            }
            tcVar.m8974a(parseFloat, a, equals, parseFloat2);
        }
    }
}
