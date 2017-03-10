package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.C1215c.C1211a;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.tn;
import com.google.android.gms.internal.ua;
import com.google.android.gms.internal.ud;
import com.google.android.gms.internal.ue;
import com.google.android.gms.internal.uf;
import com.google.android.gms.internal.uh;
import com.google.android.gms.internal.vc;
import com.google.android.gms.internal.ve;
import com.google.android.gms.internal.vo;
import com.google.android.gms.internal.vp;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/* renamed from: com.google.android.gms.analytics.g */
public class C1223g extends ud {
    private boolean f2860a;
    private final Map<String, String> f2861b;
    private final Map<String, String> f2862c;
    private final ve f2863d;
    private final C1222a f2864e;
    private C1210b f2865f;
    private vo f2866g;

    /* renamed from: com.google.android.gms.analytics.g.1 */
    class C12211 implements Runnable {
        final /* synthetic */ Map f2844a;
        final /* synthetic */ boolean f2845b;
        final /* synthetic */ String f2846c;
        final /* synthetic */ long f2847d;
        final /* synthetic */ boolean f2848e;
        final /* synthetic */ boolean f2849f;
        final /* synthetic */ String f2850g;
        final /* synthetic */ C1223g f2851h;

        C12211(C1223g c1223g, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
            this.f2851h = c1223g;
            this.f2844a = map;
            this.f2845b = z;
            this.f2846c = str;
            this.f2847d = j;
            this.f2848e = z2;
            this.f2849f = z3;
            this.f2850g = str2;
        }

        public void run() {
            boolean z = true;
            if (this.f2851h.f2864e.m4289b()) {
                this.f2844a.put("sc", "start");
            }
            vp.m9519b(this.f2844a, "cid", this.f2851h.m4270p().m4227g());
            String str = (String) this.f2844a.get("sf");
            if (str != null) {
                double a = vp.m9506a(str, 100.0d);
                if (vp.m9514a(a, (String) this.f2844a.get("cid"))) {
                    this.f2851h.m4251b("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(a));
                    return;
                }
            }
            ua b = this.f2851h.m4276v();
            if (this.f2845b) {
                vp.m9513a(this.f2844a, "ate", b.m9132b());
                vp.m9511a(this.f2844a, "adid", b.m9133c());
            } else {
                this.f2844a.remove("ate");
                this.f2844a.remove("adid");
            }
            tn c = this.f2851h.m4277w().m9268c();
            vp.m9511a(this.f2844a, "an", c.m8995a());
            vp.m9511a(this.f2844a, "av", c.m8999b());
            vp.m9511a(this.f2844a, "aid", c.m9001c());
            vp.m9511a(this.f2844a, "aiid", c.m9003d());
            this.f2844a.put("v", "1");
            this.f2844a.put("_v", ue.f6043b);
            vp.m9511a(this.f2844a, "ul", this.f2851h.m4278x().m9363b().m9051f());
            vp.m9511a(this.f2844a, "sr", this.f2851h.m4278x().m9364c());
            boolean z2 = this.f2846c.equals("transaction") || this.f2846c.equals("item");
            if (z2 || this.f2851h.f2863d.m9421a()) {
                long a2 = vp.m9507a((String) this.f2844a.get("ht"));
                if (a2 == 0) {
                    a2 = this.f2847d;
                }
                if (this.f2848e) {
                    this.f2851h.m4267m().m4255c("Dry run enabled. Would have sent hit", new vc(this.f2851h, this.f2844a, a2, this.f2849f));
                    return;
                }
                String str2 = (String) this.f2844a.get("cid");
                Map hashMap = new HashMap();
                vp.m9512a(hashMap, "uid", this.f2844a);
                vp.m9512a(hashMap, "an", this.f2844a);
                vp.m9512a(hashMap, "aid", this.f2844a);
                vp.m9512a(hashMap, "av", this.f2844a);
                vp.m9512a(hashMap, "aiid", this.f2844a);
                String str3 = this.f2850g;
                if (TextUtils.isEmpty((CharSequence) this.f2844a.get("adid"))) {
                    z = false;
                }
                this.f2844a.put("_s", String.valueOf(this.f2851h.m4271q().m9138a(new uh(0, str2, str3, z, 0, hashMap))));
                this.f2851h.m4271q().m9141a(new vc(this.f2851h, this.f2844a, a2, this.f2849f));
                return;
            }
            this.f2851h.m4267m().m9433a(this.f2844a, "Too many hits sent too quickly, rate limiting invoked");
        }
    }

    /* renamed from: com.google.android.gms.analytics.g.a */
    private class C1222a extends ud implements C1211a {
        final /* synthetic */ C1223g f2854a;
        private boolean f2855b;
        private int f2856c;
        private long f2857d;
        private boolean f2858e;
        private long f2859f;

        protected C1222a(C1223g c1223g, uf ufVar) {
            this.f2854a = c1223g;
            super(ufVar);
            this.f2857d = -1;
        }

        private void m4284d() {
            if (this.f2857d >= 0 || this.f2855b) {
                m4270p().m4219a(this.f2854a.f2864e);
            } else {
                m4270p().m4223b(this.f2854a.f2864e);
            }
        }

        protected void m4285a() {
        }

        public void m4286a(Activity activity) {
            if (this.f2856c == 0 && m4290c()) {
                this.f2858e = true;
            }
            this.f2856c++;
            if (this.f2855b) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.f2854a.m4309a(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                this.f2854a.m4310a("&cd", this.f2854a.f2866g != null ? this.f2854a.f2866g.m9504a(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    CharSequence a = C1223g.m4292a(activity);
                    if (!TextUtils.isEmpty(a)) {
                        hashMap.put("&dr", a);
                    }
                }
                this.f2854a.m4311a(hashMap);
            }
        }

        public void m4287a(boolean z) {
            this.f2855b = z;
            m4284d();
        }

        public void m4288b(Activity activity) {
            this.f2856c--;
            this.f2856c = Math.max(0, this.f2856c);
            if (this.f2856c == 0) {
                this.f2859f = m4265k().m4927b();
            }
        }

        public synchronized boolean m4289b() {
            boolean z;
            z = this.f2858e;
            this.f2858e = false;
            return z;
        }

        boolean m4290c() {
            return m4265k().m4927b() >= this.f2859f + Math.max(1000, this.f2857d);
        }
    }

    C1223g(uf ufVar, String str, ve veVar) {
        super(ufVar);
        this.f2861b = new HashMap();
        this.f2862c = new HashMap();
        if (str != null) {
            this.f2861b.put("&tid", str);
        }
        this.f2861b.put("useSecure", "1");
        this.f2861b.put("&a", Integer.toString(new Random().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        if (veVar == null) {
            this.f2863d = new ve("tracking", m4265k());
        } else {
            this.f2863d = veVar;
        }
        this.f2864e = new C1222a(this, ufVar);
    }

    static String m4292a(Activity activity) {
        C1314c.m4623a((Object) activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        CharSequence stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return !TextUtils.isEmpty(stringExtra) ? stringExtra : null;
    }

    private static void m4293a(Map<String, String> map, Map<String, String> map2) {
        C1314c.m4623a((Object) map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String b = C1223g.m4296b(entry);
                if (b != null) {
                    map2.put(b, (String) entry.getValue());
                }
            }
        }
    }

    private static boolean m4294a(Entry<String, String> entry) {
        String str = (String) entry.getKey();
        entry.getValue();
        return str.startsWith("&") && str.length() >= 2;
    }

    private static String m4296b(Entry<String, String> entry) {
        return !C1223g.m4294a((Entry) entry) ? null : ((String) entry.getKey()).substring(1);
    }

    private static void m4297b(Map<String, String> map, Map<String, String> map2) {
        C1314c.m4623a((Object) map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String b = C1223g.m4296b(entry);
                if (!(b == null || map2.containsKey(b))) {
                    map2.put(b, (String) entry.getValue());
                }
            }
        }
    }

    private boolean m4299c() {
        return this.f2865f != null;
    }

    protected void m4308a() {
        this.f2864e.m4281B();
        String c = m4273s().m9527c();
        if (c != null) {
            m4310a("&an", c);
        }
        c = m4273s().m9526b();
        if (c != null) {
            m4310a("&av", c);
        }
    }

    public void m4309a(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            CharSequence queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String str = "http://hostname/?";
                String valueOf = String.valueOf(queryParameter);
                Uri parse = Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                str = parse.getQueryParameter("utm_id");
                if (str != null) {
                    this.f2862c.put("&ci", str);
                }
                str = parse.getQueryParameter("anid");
                if (str != null) {
                    this.f2862c.put("&anid", str);
                }
                str = parse.getQueryParameter("utm_campaign");
                if (str != null) {
                    this.f2862c.put("&cn", str);
                }
                str = parse.getQueryParameter("utm_content");
                if (str != null) {
                    this.f2862c.put("&cc", str);
                }
                str = parse.getQueryParameter("utm_medium");
                if (str != null) {
                    this.f2862c.put("&cm", str);
                }
                str = parse.getQueryParameter("utm_source");
                if (str != null) {
                    this.f2862c.put("&cs", str);
                }
                str = parse.getQueryParameter("utm_term");
                if (str != null) {
                    this.f2862c.put("&ck", str);
                }
                str = parse.getQueryParameter("dclid");
                if (str != null) {
                    this.f2862c.put("&dclid", str);
                }
                str = parse.getQueryParameter("gclid");
                if (str != null) {
                    this.f2862c.put("&gclid", str);
                }
                valueOf = parse.getQueryParameter("aclid");
                if (valueOf != null) {
                    this.f2862c.put("&aclid", valueOf);
                }
            }
        }
    }

    public void m4310a(String str, String str2) {
        C1314c.m4624a((Object) str, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.f2861b.put(str, str2);
        }
    }

    public void m4311a(Map<String, String> map) {
        long a = m4265k().m4926a();
        if (m4270p().m4226f()) {
            m4254c("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean e = m4270p().m4225e();
        Map hashMap = new HashMap();
        C1223g.m4293a(this.f2861b, hashMap);
        C1223g.m4293a((Map) map, hashMap);
        boolean a2 = vp.m9517a((String) this.f2861b.get("useSecure"), true);
        C1223g.m4297b(this.f2862c, hashMap);
        this.f2862c.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            m4267m().m9433a(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            m4267m().m9433a(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean b = m4314b();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.f2861b.get("&a")) + 1;
                if (parseInt >= ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                    parseInt = 1;
                }
                this.f2861b.put("&a", Integer.toString(parseInt));
            }
        }
        m4269o().m4371a(new C12211(this, hashMap, b, str, a, e, a2, str2));
    }

    public void m4312a(boolean z) {
        synchronized (this) {
            if (m4299c() == z) {
                return;
            }
            if (z) {
                this.f2865f = new C1210b(this, Thread.getDefaultUncaughtExceptionHandler(), m4266l());
                Thread.setDefaultUncaughtExceptionHandler(this.f2865f);
                m4250b("Uncaught exceptions will be reported to Google Analytics");
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this.f2865f.m4196b());
                m4250b("Uncaught exceptions will not be reported to Google Analytics");
            }
        }
    }

    public void m4313b(boolean z) {
        this.f2864e.m4287a(z);
    }

    boolean m4314b() {
        return this.f2860a;
    }

    public void m4315c(boolean z) {
        this.f2860a = z;
    }
}
