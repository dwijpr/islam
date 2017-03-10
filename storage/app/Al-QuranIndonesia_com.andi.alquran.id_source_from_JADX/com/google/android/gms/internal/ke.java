package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@op
public final class ke implements kg {
    private long m7068a(long j) {
        return (j - zzv.zzcP().m4926a()) + zzv.zzcP().m4927b();
    }

    private void m7069b(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("label");
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            sg.m8449e("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            sg.m8449e("No timestamp given for CSI tick.");
        } else {
            try {
                long a = m7068a(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                sxVar.m8789y().m6739a(str, str2, a);
            } catch (Throwable e) {
                sg.m8447c("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private void m7070c(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            sg.m8449e("No value given for CSI experiment.");
            return;
        }
        io a = sxVar.m8789y().m6737a();
        if (a == null) {
            sg.m8449e("No ticker for WebView, dropping experiment ID.");
        } else {
            a.m6744a("e", str);
        }
    }

    private void m7071d(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get("value");
        if (TextUtils.isEmpty(str2)) {
            sg.m8449e("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            sg.m8449e("No name given for CSI extra.");
        } else {
            io a = sxVar.m8789y().m6737a();
            if (a == null) {
                sg.m8449e("No ticker for WebView, dropping extra parameter.");
            } else {
                a.m6744a(str, str2);
            }
        }
    }

    public void m7072a(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            m7069b(sxVar, map);
        } else if ("experiment".equals(str)) {
            m7070c(sxVar, map);
        } else if ("extra".equals(str)) {
            m7071d(sxVar, map);
        }
    }
}
