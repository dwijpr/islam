package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.p040a.C1206a;
import com.google.android.gms.analytics.p040a.C1207b;
import com.google.android.gms.analytics.p040a.C1208c;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.tn;
import com.google.android.gms.internal.to;
import com.google.android.gms.internal.tp;
import com.google.android.gms.internal.tq;
import com.google.android.gms.internal.tr;
import com.google.android.gms.internal.ts;
import com.google.android.gms.internal.tt;
import com.google.android.gms.internal.tu;
import com.google.android.gms.internal.tv;
import com.google.android.gms.internal.tw;
import com.google.android.gms.internal.tx;
import com.google.android.gms.internal.ty;
import com.google.android.gms.internal.tz;
import com.google.android.gms.internal.uc;
import com.google.android.gms.internal.ue;
import com.google.android.gms.internal.uf;
import com.google.android.gms.internal.uh;
import com.google.android.gms.internal.vc;
import com.google.android.gms.internal.vp;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.i */
public class C1225i extends uc implements C1224p {
    private static DecimalFormat f2867a;
    private final uf f2868b;
    private final String f2869c;
    private final Uri f2870d;
    private final boolean f2871e;
    private final boolean f2872f;

    public C1225i(uf ufVar, String str) {
        this(ufVar, str, true, false);
    }

    public C1225i(uf ufVar, String str, boolean z, boolean z2) {
        super(ufVar);
        C1314c.m4625a(str);
        this.f2868b = ufVar;
        this.f2869c = str;
        this.f2871e = z;
        this.f2872f = z2;
        this.f2870d = C1225i.m4318a(this.f2869c);
    }

    static Uri m4318a(String str) {
        C1314c.m4625a(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String m4319a(double d) {
        if (f2867a == null) {
            f2867a = new DecimalFormat("0.######");
        }
        return f2867a.format(d);
    }

    private static String m4320a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return TextUtils.isEmpty(str) ? null : str;
        } else if (!(obj instanceof Double)) {
            return obj instanceof Boolean ? obj != Boolean.FALSE ? "1" : null : String.valueOf(obj);
        } else {
            Double d = (Double) obj;
            return d.doubleValue() != 0.0d ? C1225i.m4319a(d.doubleValue()) : null;
        }
    }

    private static String m4321a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static void m4322a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, C1225i.m4319a(d));
        }
    }

    private static void m4323a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void m4324a(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void m4325a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    public static Map<String, String> m4326b(C1229l c1229l) {
        CharSequence a;
        Map hashMap = new HashMap();
        tr trVar = (tr) c1229l.m4344a(tr.class);
        if (trVar != null) {
            for (Entry entry : trVar.m9034a().entrySet()) {
                String a2 = C1225i.m4320a(entry.getValue());
                if (a2 != null) {
                    hashMap.put((String) entry.getKey(), a2);
                }
            }
        }
        tw twVar = (tw) c1229l.m4344a(tw.class);
        if (twVar != null) {
            C1225i.m4324a(hashMap, "t", twVar.m9075a());
            C1225i.m4324a(hashMap, "cid", twVar.m9081b());
            C1225i.m4324a(hashMap, "uid", twVar.m9084c());
            C1225i.m4324a(hashMap, "sc", twVar.m9090f());
            C1225i.m4322a(hashMap, "sf", twVar.m9092h());
            C1225i.m4325a(hashMap, "ni", twVar.m9091g());
            C1225i.m4324a(hashMap, "adid", twVar.m9086d());
            C1225i.m4325a(hashMap, "ate", twVar.m9089e());
        }
        tx txVar = (tx) c1229l.m4344a(tx.class);
        if (txVar != null) {
            C1225i.m4324a(hashMap, "cd", txVar.m9099b());
            C1225i.m4322a(hashMap, "a", (double) txVar.m9103c());
            C1225i.m4324a(hashMap, "dr", txVar.m9105d());
        }
        tu tuVar = (tu) c1229l.m4344a(tu.class);
        if (tuVar != null) {
            C1225i.m4324a(hashMap, "ec", tuVar.m9059a());
            C1225i.m4324a(hashMap, "ea", tuVar.m9064b());
            C1225i.m4324a(hashMap, "el", tuVar.m9066c());
            C1225i.m4322a(hashMap, "ev", (double) tuVar.m9068d());
        }
        to toVar = (to) c1229l.m4344a(to.class);
        if (toVar != null) {
            C1225i.m4324a(hashMap, "cn", toVar.m9005a());
            C1225i.m4324a(hashMap, "cs", toVar.m9009b());
            C1225i.m4324a(hashMap, "cm", toVar.m9011c());
            C1225i.m4324a(hashMap, "ck", toVar.m9013d());
            C1225i.m4324a(hashMap, "cc", toVar.m9015e());
            C1225i.m4324a(hashMap, "ci", toVar.m9017f());
            C1225i.m4324a(hashMap, "anid", toVar.m9019g());
            C1225i.m4324a(hashMap, "gclid", toVar.m9021h());
            C1225i.m4324a(hashMap, "dclid", toVar.m9023i());
            C1225i.m4324a(hashMap, "aclid", toVar.m9025j());
        }
        tv tvVar = (tv) c1229l.m4344a(tv.class);
        if (tvVar != null) {
            C1225i.m4324a(hashMap, "exd", tvVar.m9069a());
            C1225i.m4325a(hashMap, "exf", tvVar.m9074b());
        }
        ty tyVar = (ty) c1229l.m4344a(ty.class);
        if (tyVar != null) {
            C1225i.m4324a(hashMap, "sn", tyVar.m9106a());
            C1225i.m4324a(hashMap, "sa", tyVar.m9110b());
            C1225i.m4324a(hashMap, "st", tyVar.m9112c());
        }
        tz tzVar = (tz) c1229l.m4344a(tz.class);
        if (tzVar != null) {
            C1225i.m4324a(hashMap, "utv", tzVar.m9114a());
            C1225i.m4322a(hashMap, "utt", (double) tzVar.m9119b());
            C1225i.m4324a(hashMap, "utc", tzVar.m9121c());
            C1225i.m4324a(hashMap, "utl", tzVar.m9123d());
        }
        tp tpVar = (tp) c1229l.m4344a(tp.class);
        if (tpVar != null) {
            for (Entry entry2 : tpVar.m9027a().entrySet()) {
                a = C1226j.m4329a(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(a)) {
                    hashMap.put(a, (String) entry2.getValue());
                }
            }
        }
        tq tqVar = (tq) c1229l.m4344a(tq.class);
        if (tqVar != null) {
            for (Entry entry22 : tqVar.m9030a().entrySet()) {
                a = C1226j.m4331b(((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(a)) {
                    hashMap.put(a, C1225i.m4319a(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        tt ttVar = (tt) c1229l.m4344a(tt.class);
        if (ttVar != null) {
            C1207b a3 = ttVar.m9052a();
            if (a3 != null) {
                for (Entry entry3 : a3.m4192a().entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), (String) entry3.getValue());
                    } else {
                        hashMap.put((String) entry3.getKey(), (String) entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (C1208c a4 : ttVar.m9058d()) {
                hashMap.putAll(a4.m4193a(C1226j.m4335f(i)));
                i++;
            }
            i = 1;
            for (C1206a a5 : ttVar.m9056b()) {
                hashMap.putAll(a5.m4191a(C1226j.m4333d(i)));
                i++;
            }
            i = 1;
            for (Entry entry222 : ttVar.m9057c().entrySet()) {
                List<C1206a> list = (List) entry222.getValue();
                String i2 = C1226j.m4338i(i);
                int i3 = 1;
                for (C1206a a52 : list) {
                    String valueOf = String.valueOf(i2);
                    String valueOf2 = String.valueOf(C1226j.m4336g(i3));
                    hashMap.putAll(a52.m4191a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry222.getKey())) {
                    String valueOf3 = String.valueOf(i2);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry222.getKey());
                }
                i++;
            }
        }
        ts tsVar = (ts) c1229l.m4344a(ts.class);
        if (tsVar != null) {
            C1225i.m4324a(hashMap, "ul", tsVar.m9051f());
            C1225i.m4322a(hashMap, "sd", (double) tsVar.m9038a());
            C1225i.m4323a(hashMap, "sr", tsVar.m9043b(), tsVar.m9045c());
            C1225i.m4323a(hashMap, "vp", tsVar.m9047d(), tsVar.m9049e());
        }
        tn tnVar = (tn) c1229l.m4344a(tn.class);
        if (tnVar != null) {
            C1225i.m4324a(hashMap, "an", tnVar.m8995a());
            C1225i.m4324a(hashMap, "aid", tnVar.m9001c());
            C1225i.m4324a(hashMap, "aiid", tnVar.m9003d());
            C1225i.m4324a(hashMap, "av", tnVar.m8999b());
        }
        return hashMap;
    }

    public Uri m4327a() {
        return this.f2870d;
    }

    public void m4328a(C1229l c1229l) {
        C1314c.m4623a((Object) c1229l);
        C1314c.m4633b(c1229l.m4352f(), "Can't deliver not submitted measurement");
        C1314c.m4635c("deliver should be called on worker thread");
        C1229l a = c1229l.m4343a();
        tw twVar = (tw) a.m4347b(tw.class);
        if (TextUtils.isEmpty(twVar.m9075a())) {
            m4267m().m9433a(C1225i.m4326b(a), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(twVar.m9081b())) {
            m4267m().m9433a(C1225i.m4326b(a), "Ignoring measurement without client id");
        } else if (!this.f2868b.m9163k().m4226f()) {
            double h = twVar.m9092h();
            if (vp.m9514a(h, twVar.m9081b())) {
                m4251b("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(h));
                return;
            }
            Map b = C1225i.m4326b(a);
            b.put("v", "1");
            b.put("_v", ue.f6043b);
            b.put("tid", this.f2869c);
            if (this.f2868b.m9163k().m4225e()) {
                m4255c("Dry run is enabled. GoogleAnalytics would have sent", C1225i.m4321a(b));
                return;
            }
            Map hashMap = new HashMap();
            vp.m9511a(hashMap, "uid", twVar.m9084c());
            tn tnVar = (tn) c1229l.m4344a(tn.class);
            if (tnVar != null) {
                vp.m9511a(hashMap, "an", tnVar.m8995a());
                vp.m9511a(hashMap, "aid", tnVar.m9001c());
                vp.m9511a(hashMap, "av", tnVar.m8999b());
                vp.m9511a(hashMap, "aiid", tnVar.m9003d());
            }
            b.put("_s", String.valueOf(m4271q().m9138a(new uh(0, twVar.m9081b(), this.f2869c, !TextUtils.isEmpty(twVar.m9086d()), 0, hashMap))));
            m4271q().m9141a(new vc(m4267m(), b, c1229l.m4350d(), true));
        }
    }
}
