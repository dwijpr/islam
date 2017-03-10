package com.google.android.gms.tagmanager;

import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.internal.aw.C1450a;
import java.net.URLEncoder;

class al {
    private static C2249w<C1450a> m10156a(C2249w<C1450a> c2249w) {
        try {
            return new C2249w(aj.m10146c(m10159a(aj.m10142a((C1450a) c2249w.m10289a()))), c2249w.m10290b());
        } catch (Throwable e) {
            C2238n.m10265a("Escape URI: unsupported encoding", e);
            return c2249w;
        }
    }

    private static C2249w<C1450a> m10157a(C2249w<C1450a> c2249w, int i) {
        if (m10160a((C1450a) c2249w.m10289a())) {
            switch (i) {
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    return m10156a((C2249w) c2249w);
                default:
                    C2238n.m10264a("Unsupported Value Escaping: " + i);
                    return c2249w;
            }
        }
        C2238n.m10264a("Escaping can only be applied to strings.");
        return c2249w;
    }

    static C2249w<C1450a> m10158a(C2249w<C1450a> c2249w, int... iArr) {
        C2249w a;
        for (int a2 : iArr) {
            a = m10157a(a, a2);
        }
        return a;
    }

    static String m10159a(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean m10160a(C1450a c1450a) {
        return aj.m10147c(c1450a) instanceof String;
    }
}
