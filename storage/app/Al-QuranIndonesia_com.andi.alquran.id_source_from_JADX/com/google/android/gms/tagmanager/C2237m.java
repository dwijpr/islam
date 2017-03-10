package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
public class C2237m {
    static Map<String, String> f7127a;

    static {
        f7127a = new HashMap();
    }

    public static String m10262a(String str, String str2) {
        if (str2 == null) {
            return str.length() > 0 ? str : null;
        } else {
            String str3 = "http://hostname/?";
            String valueOf = String.valueOf(str);
            return Uri.parse(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).getQueryParameter(str2);
        }
    }

    public static void m10263a(Context context, String str) {
        String a = C2237m.m10262a(str, "conv");
        if (a != null && a.length() > 0) {
            f7127a.put(a, str);
            ah.m10131a(context, "gtm_click_referrers", a, str);
        }
    }
}
