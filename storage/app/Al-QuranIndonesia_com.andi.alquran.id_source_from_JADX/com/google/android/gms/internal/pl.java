package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@op
public final class pl {
    private zzmm f5417A;
    private boolean f5418B;
    private String f5419C;
    private List<String> f5420D;
    private boolean f5421E;
    private String f5422F;
    private zzon f5423G;
    private final zzmh f5424H;
    private String f5425a;
    private String f5426b;
    private String f5427c;
    private List<String> f5428d;
    private String f5429e;
    private String f5430f;
    private String f5431g;
    private List<String> f5432h;
    private long f5433i;
    private boolean f5434j;
    private final long f5435k;
    private List<String> f5436l;
    private long f5437m;
    private int f5438n;
    private boolean f5439o;
    private boolean f5440p;
    private boolean f5441q;
    private boolean f5442r;
    private boolean f5443s;
    private String f5444t;
    private boolean f5445u;
    private boolean f5446v;
    private zzok f5447w;
    private List<String> f5448x;
    private List<String> f5449y;
    private boolean f5450z;

    public pl(zzmh com_google_android_gms_internal_zzmh, String str) {
        this.f5433i = -1;
        this.f5434j = false;
        this.f5435k = -1;
        this.f5437m = -1;
        this.f5438n = -1;
        this.f5439o = false;
        this.f5440p = false;
        this.f5441q = false;
        this.f5442r = true;
        this.f5443s = true;
        this.f5444t = BuildConfig.VERSION_NAME;
        this.f5445u = false;
        this.f5446v = false;
        this.f5450z = false;
        this.f5418B = false;
        this.f5426b = str;
        this.f5424H = com_google_android_gms_internal_zzmh;
    }

    private void m8143A(Map<String, List<String>> map) {
        this.f5418B |= m8154d(map, "X-Afma-Auto-Collect-Location");
    }

    private void m8144B(Map<String, List<String>> map) {
        List c = m8151c(map, "X-Afma-Remote-Ping-Urls");
        if (c != null) {
            this.f5420D = c;
        }
    }

    private void m8145C(Map<String, List<String>> map) {
        Object a = m8148a(map, "X-Afma-Auto-Protection-Configuration");
        if (a == null || TextUtils.isEmpty(a)) {
            Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.f5430f)) {
                buildUpon.appendQueryParameter("debugDialog", this.f5430f);
            }
            boolean booleanValue = ((Boolean) C1648if.f4372j.m6682c()).booleanValue();
            String[] strArr = new String[1];
            String valueOf = String.valueOf(buildUpon.toString());
            String valueOf2 = String.valueOf("navigationURL");
            strArr[0] = new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append(valueOf).append("&").append(valueOf2).append("={NAVIGATION_URL}").toString();
            this.f5417A = new zzmm(booleanValue, Arrays.asList(strArr));
            return;
        }
        try {
            this.f5417A = zzmm.m9774a(new JSONObject(a));
        } catch (Throwable e) {
            sg.m8447c("Error parsing configuration JSON", e);
            this.f5417A = new zzmm();
        }
    }

    private void m8146D(Map<String, List<String>> map) {
        this.f5419C = m8148a(map, "Set-Cookie");
    }

    private void m8147E(Map<String, List<String>> map) {
        Object a = m8148a(map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(a)) {
            try {
                this.f5423G = zzon.m9782a(new JSONObject(a));
            } catch (Throwable e) {
                sg.m8447c("Error parsing safe browsing header", e);
            }
        }
    }

    static String m8148a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static long m8149b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                sg.m8449e(new StringBuilder((String.valueOf(str).length() + 36) + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1;
    }

    private void m8150b(Map<String, List<String>> map) {
        this.f5425a = m8148a(map, "X-Afma-Ad-Size");
    }

    static List<String> m8151c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m8152c(Map<String, List<String>> map) {
        this.f5422F = m8148a(map, "X-Afma-Ad-Slot-Size");
    }

    private void m8153d(Map<String, List<String>> map) {
        List c = m8151c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f5428d = c;
        }
    }

    private boolean m8154d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    private void m8155e(Map<String, List<String>> map) {
        this.f5429e = m8148a(map, "X-Afma-Debug-Signals");
    }

    private void m8156f(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.f5430f = (String) list.get(0);
        }
    }

    private void m8157g(Map<String, List<String>> map) {
        List c = m8151c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f5432h = c;
        }
    }

    private void m8158h(Map<String, List<String>> map) {
        long b = m8149b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f5433i = b;
        }
    }

    private void m8159i(Map<String, List<String>> map) {
        this.f5431g = m8148a(map, "X-Afma-ActiveView");
    }

    private void m8160j(Map<String, List<String>> map) {
        this.f5440p = "native".equals(m8148a(map, "X-Afma-Ad-Format"));
    }

    private void m8161k(Map<String, List<String>> map) {
        this.f5439o |= m8154d(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void m8162l(Map<String, List<String>> map) {
        this.f5434j |= m8154d(map, "X-Afma-Mediation");
    }

    private void m8163m(Map<String, List<String>> map) {
        this.f5421E |= m8154d(map, "X-Afma-Render-In-Browser");
    }

    private void m8164n(Map<String, List<String>> map) {
        List c = m8151c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f5436l = c;
        }
    }

    private void m8165o(Map<String, List<String>> map) {
        long b = m8149b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f5437m = b;
        }
    }

    private void m8166p(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.f5438n = zzv.zzcL().m8574b();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.f5438n = zzv.zzcL().m8560a();
            }
        }
    }

    private void m8167q(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.f5441q = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m8168r(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.f5442r = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m8169s(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Vertical-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.f5443s = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m8170t(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Gws-Query-Id");
        if (list != null && !list.isEmpty()) {
            this.f5444t = (String) list.get(0);
        }
    }

    private void m8171u(Map<String, List<String>> map) {
        String a = m8148a(map, "X-Afma-Fluid");
        if (a != null && a.equals("height")) {
            this.f5445u = true;
        }
    }

    private void m8172v(Map<String, List<String>> map) {
        this.f5446v = "native_express".equals(m8148a(map, "X-Afma-Ad-Format"));
    }

    private void m8173w(Map<String, List<String>> map) {
        this.f5447w = zzok.m9779a(m8148a(map, "X-Afma-Rewards"));
    }

    private void m8174x(Map<String, List<String>> map) {
        if (this.f5448x == null) {
            this.f5448x = m8151c(map, "X-Afma-Reward-Video-Start-Urls");
        }
    }

    private void m8175y(Map<String, List<String>> map) {
        if (this.f5449y == null) {
            this.f5449y = m8151c(map, "X-Afma-Reward-Video-Complete-Urls");
        }
    }

    private void m8176z(Map<String, List<String>> map) {
        this.f5450z |= m8154d(map, "X-Afma-Use-Displayed-Impression");
    }

    public zzmk m8177a(long j) {
        return new zzmk(this.f5424H, this.f5426b, this.f5427c, this.f5428d, this.f5432h, this.f5433i, this.f5434j, -1, this.f5436l, this.f5437m, this.f5438n, this.f5425a, j, this.f5430f, this.f5431g, this.f5439o, this.f5440p, this.f5441q, this.f5442r, false, this.f5444t, this.f5445u, this.f5446v, this.f5447w, this.f5448x, this.f5449y, this.f5450z, this.f5417A, this.f5418B, this.f5419C, this.f5420D, this.f5421E, this.f5422F, this.f5423G, this.f5429e, this.f5443s);
    }

    public void m8178a(String str, Map<String, List<String>> map, String str2) {
        this.f5427c = str2;
        m8179a((Map) map);
    }

    public void m8179a(Map<String, List<String>> map) {
        m8150b(map);
        m8152c(map);
        m8153d(map);
        m8155e(map);
        m8156f(map);
        m8157g(map);
        m8158h(map);
        m8162l(map);
        m8164n(map);
        m8165o(map);
        m8166p(map);
        m8159i(map);
        m8167q(map);
        m8161k(map);
        m8160j(map);
        m8168r(map);
        m8169s(map);
        m8170t(map);
        m8171u(map);
        m8172v(map);
        m8173w(map);
        m8174x(map);
        m8175y(map);
        m8176z(map);
        m8143A(map);
        m8146D(map);
        m8145C(map);
        m8144B(map);
        m8147E(map);
        m8163m(map);
    }
}
