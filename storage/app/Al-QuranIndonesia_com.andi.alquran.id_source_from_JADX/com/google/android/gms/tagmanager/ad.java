package com.google.android.gms.tagmanager;

import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.aw.C1450a;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.dh.C1521a;
import com.google.android.gms.internal.dh.C1522b;
import com.google.android.gms.maps.GoogleMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ad {
    private static final C2249w<C1450a> f7025a;
    private final C2232g f7026b;
    private final Map<String, C2233h> f7027c;
    private final Map<String, C2233h> f7028d;
    private final Map<String, C2233h> f7029e;
    private final am<C1521a, C2249w<C1450a>> f7030f;
    private final am<String, C2199b> f7031g;
    private final Set<C1522b> f7032h;
    private final C2220c f7033i;
    private final Map<String, C2200c> f7034j;
    private volatile String f7035k;
    private int f7036l;

    /* renamed from: com.google.android.gms.tagmanager.ad.a */
    interface C2196a {
        void m10102a(C1522b c1522b, Set<C1521a> set, Set<C1521a> set2, ab abVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.ad.1 */
    class C21971 implements C2196a {
        final /* synthetic */ Map f7013a;
        final /* synthetic */ Map f7014b;
        final /* synthetic */ Map f7015c;
        final /* synthetic */ Map f7016d;

        C21971(ad adVar, Map map, Map map2, Map map3, Map map4) {
            this.f7013a = map;
            this.f7014b = map2;
            this.f7015c = map3;
            this.f7016d = map4;
        }

        public void m10103a(C1522b c1522b, Set<C1521a> set, Set<C1521a> set2, ab abVar) {
            List list = (List) this.f7013a.get(c1522b);
            this.f7014b.get(c1522b);
            if (list != null) {
                set.addAll(list);
                abVar.m10097c();
            }
            list = (List) this.f7015c.get(c1522b);
            this.f7016d.get(c1522b);
            if (list != null) {
                set2.addAll(list);
                abVar.m10098d();
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ad.2 */
    class C21982 implements C2196a {
        C21982(ad adVar) {
        }

        public void m10104a(C1522b c1522b, Set<C1521a> set, Set<C1521a> set2, ab abVar) {
            set.addAll(c1522b.m5733c());
            set2.addAll(c1522b.m5734d());
            abVar.m10099e();
            abVar.m10100f();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ad.b */
    private static class C2199b {
        private C2249w<C1450a> f7017a;
        private C1450a f7018b;

        public C2199b(C2249w<C1450a> c2249w, C1450a c1450a) {
            this.f7017a = c2249w;
            this.f7018b = c1450a;
        }

        public C2249w<C1450a> m10105a() {
            return this.f7017a;
        }

        public C1450a m10106b() {
            return this.f7018b;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ad.c */
    private static class C2200c {
        private final Set<C1522b> f7019a;
        private final Map<C1522b, List<C1521a>> f7020b;
        private final Map<C1522b, List<C1521a>> f7021c;
        private final Map<C1522b, List<String>> f7022d;
        private final Map<C1522b, List<String>> f7023e;
        private C1521a f7024f;

        public C2200c() {
            this.f7019a = new HashSet();
            this.f7020b = new HashMap();
            this.f7022d = new HashMap();
            this.f7021c = new HashMap();
            this.f7023e = new HashMap();
        }

        public Set<C1522b> m10107a() {
            return this.f7019a;
        }

        public Map<C1522b, List<C1521a>> m10108b() {
            return this.f7020b;
        }

        public Map<C1522b, List<String>> m10109c() {
            return this.f7022d;
        }

        public Map<C1522b, List<String>> m10110d() {
            return this.f7023e;
        }

        public Map<C1522b, List<C1521a>> m10111e() {
            return this.f7021c;
        }

        public C1521a m10112f() {
            return this.f7024f;
        }
    }

    static {
        f7025a = new C2249w(aj.m10140a(), true);
    }

    private C2249w<C1450a> m10113a(C1450a c1450a, Set<String> set, ak akVar) {
        if (!c1450a.f3514l) {
            return new C2249w(c1450a, true);
        }
        C1450a a;
        int i;
        C2249w a2;
        String str;
        String valueOf;
        switch (c1450a.f3503a) {
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                a = dh.m5737a(c1450a);
                a.f3505c = new C1450a[c1450a.f3505c.length];
                for (i = 0; i < c1450a.f3505c.length; i++) {
                    a2 = m10113a(c1450a.f3505c[i], (Set) set, akVar.m10151a(i));
                    if (a2 == f7025a) {
                        return f7025a;
                    }
                    a.f3505c[i] = (C1450a) a2.m10289a();
                }
                return new C2249w(a, false);
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                a = dh.m5737a(c1450a);
                if (c1450a.f3506d.length != c1450a.f3507e.length) {
                    str = "Invalid serving value: ";
                    valueOf = String.valueOf(c1450a.toString());
                    C2238n.m10264a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return f7025a;
                }
                a.f3506d = new C1450a[c1450a.f3506d.length];
                a.f3507e = new C1450a[c1450a.f3506d.length];
                for (i = 0; i < c1450a.f3506d.length; i++) {
                    a2 = m10113a(c1450a.f3506d[i], (Set) set, akVar.m10153b(i));
                    C2249w a3 = m10113a(c1450a.f3507e[i], (Set) set, akVar.m10154c(i));
                    if (a2 == f7025a || a3 == f7025a) {
                        return f7025a;
                    }
                    a.f3506d[i] = (C1450a) a2.m10289a();
                    a.f3507e[i] = (C1450a) a3.m10289a();
                }
                return new C2249w(a, false);
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                if (set.contains(c1450a.f3508f)) {
                    valueOf = String.valueOf(c1450a.f3508f);
                    str = String.valueOf(set.toString());
                    C2238n.m10264a(new StringBuilder((String.valueOf(valueOf).length() + 79) + String.valueOf(str).length()).append("Macro cycle detected.  Current macro reference: ").append(valueOf).append(".  Previous macro references: ").append(str).append(".").toString());
                    return f7025a;
                }
                set.add(c1450a.f3508f);
                C2249w<C1450a> a4 = al.m10158a(m10114a(c1450a.f3508f, (Set) set, akVar.m10152a()), c1450a.f3513k);
                set.remove(c1450a.f3508f);
                return a4;
            case C1096c.MapAttrs_uiCompass /*7*/:
                a = dh.m5737a(c1450a);
                a.f3512j = new C1450a[c1450a.f3512j.length];
                for (i = 0; i < c1450a.f3512j.length; i++) {
                    a2 = m10113a(c1450a.f3512j[i], (Set) set, akVar.m10155d(i));
                    if (a2 == f7025a) {
                        return f7025a;
                    }
                    a.f3512j[i] = (C1450a) a2.m10289a();
                }
                return new C2249w(a, false);
            default:
                C2238n.m10264a("Unknown type: " + c1450a.f3503a);
                return f7025a;
        }
    }

    private C2249w<C1450a> m10114a(String str, Set<String> set, C2239p c2239p) {
        this.f7036l++;
        C2199b c2199b = (C2199b) this.f7031g.m10161a(str);
        if (c2199b != null) {
            m10118a(c2199b.m10106b(), (Set) set);
            this.f7036l--;
            return c2199b.m10105a();
        }
        C2200c c2200c = (C2200c) this.f7034j.get(str);
        if (c2200c == null) {
            String valueOf = String.valueOf(m10117a());
            C2238n.m10264a(new StringBuilder((String.valueOf(valueOf).length() + 15) + String.valueOf(str).length()).append(valueOf).append("Invalid macro: ").append(str).toString());
            this.f7036l--;
            return f7025a;
        }
        C1521a f;
        C2249w a = m10121a(str, c2200c.m10107a(), c2200c.m10108b(), c2200c.m10109c(), c2200c.m10111e(), c2200c.m10110d(), set, c2239p.m10271b());
        if (((Set) a.m10289a()).isEmpty()) {
            f = c2200c.m10112f();
        } else {
            if (((Set) a.m10289a()).size() > 1) {
                valueOf = String.valueOf(m10117a());
                C2238n.m10266b(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(str).length()).append(valueOf).append("Multiple macros active for macroName ").append(str).toString());
            }
            f = (C1521a) ((Set) a.m10289a()).iterator().next();
        }
        if (f == null) {
            this.f7036l--;
            return f7025a;
        }
        C2249w a2 = m10115a(this.f7029e, f, (Set) set, c2239p.m10270a());
        boolean z = a.m10290b() && a2.m10290b();
        C2249w<C1450a> c2249w = a2 == f7025a ? f7025a : new C2249w((C1450a) a2.m10289a(), z);
        C1450a b = f.m5730b();
        if (c2249w.m10290b()) {
            this.f7031g.m10162a(str, new C2199b(c2249w, b));
        }
        m10118a(b, (Set) set);
        this.f7036l--;
        return c2249w;
    }

    private C2249w<C1450a> m10115a(Map<String, C2233h> map, C1521a c1521a, Set<String> set, C2241y c2241y) {
        boolean z = true;
        C1450a c1450a = (C1450a) c1521a.m5728a().get(av.FUNCTION.toString());
        if (c1450a == null) {
            C2238n.m10264a("No function id in properties");
            return f7025a;
        }
        String str = c1450a.f3509g;
        C2233h c2233h = (C2233h) map.get(str);
        if (c2233h == null) {
            C2238n.m10264a(String.valueOf(str).concat(" has no backing implementation."));
            return f7025a;
        }
        C2249w<C1450a> c2249w = (C2249w) this.f7030f.m10161a(c1521a);
        if (c2249w != null) {
            return c2249w;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c1521a.m5728a().entrySet()) {
            C2249w a = m10113a((C1450a) entry.getValue(), (Set) set, c2241y.m10274a((String) entry.getKey()).m10094a((C1450a) entry.getValue()));
            if (a == f7025a) {
                return f7025a;
            }
            boolean z3;
            if (a.m10290b()) {
                c1521a.m5729a((String) entry.getKey(), (C1450a) a.m10289a());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put((String) entry.getKey(), (C1450a) a.m10289a());
            z2 = z3;
        }
        if (c2233h.m10256a(hashMap.keySet())) {
            if (!(z2 && c2233h.m10255a())) {
                z = false;
            }
            c2249w = new C2249w(c2233h.m10254a(hashMap), z);
            if (!z) {
                return c2249w;
            }
            this.f7030f.m10162a(c1521a, c2249w);
            return c2249w;
        }
        String valueOf = String.valueOf(c2233h.m10257b());
        String valueOf2 = String.valueOf(hashMap.keySet());
        C2238n.m10264a(new StringBuilder(((String.valueOf(str).length() + 43) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append("Incorrect keys for function ").append(str).append(" required ").append(valueOf).append(" had ").append(valueOf2).toString());
        return f7025a;
    }

    private C2249w<Set<C1521a>> m10116a(Set<C1522b> set, Set<String> set2, C2196a c2196a, ac acVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C1522b c1522b : set) {
            ab a = acVar.m10101a();
            C2249w a2 = m10120a(c1522b, (Set) set2, a);
            if (((Boolean) a2.m10289a()).booleanValue()) {
                c2196a.m10102a(c1522b, hashSet, hashSet2, a);
            }
            boolean z2 = z && a2.m10290b();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        return new C2249w(hashSet, z);
    }

    private String m10117a() {
        if (this.f7036l <= 1) {
            return BuildConfig.VERSION_NAME;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.f7036l));
        for (int i = 2; i < this.f7036l; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    private void m10118a(C1450a c1450a, Set<String> set) {
        if (c1450a != null) {
            C2249w a = m10113a(c1450a, (Set) set, new C2248v());
            if (a != f7025a) {
                Object c = aj.m10147c((C1450a) a.m10289a());
                if (c instanceof Map) {
                    this.f7033i.m10234a((Map) c);
                } else if (c instanceof List) {
                    for (Object c2 : (List) c2) {
                        if (c2 instanceof Map) {
                            this.f7033i.m10234a((Map) c2);
                        } else {
                            C2238n.m10266b("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    C2238n.m10266b("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    C2249w<Boolean> m10119a(C1521a c1521a, Set<String> set, C2241y c2241y) {
        C2249w a = m10115a(this.f7028d, c1521a, (Set) set, c2241y);
        Object b = aj.m10144b((C1450a) a.m10289a());
        aj.m10146c(b);
        return new C2249w(b, a.m10290b());
    }

    C2249w<Boolean> m10120a(C1522b c1522b, Set<String> set, ab abVar) {
        boolean z = true;
        for (C1521a a : c1522b.m5732b()) {
            C2249w a2 = m10119a(a, (Set) set, abVar.m10095a());
            if (((Boolean) a2.m10289a()).booleanValue()) {
                aj.m10146c(Boolean.valueOf(false));
                return new C2249w(Boolean.valueOf(false), a2.m10290b());
            }
            boolean z2 = z && a2.m10290b();
            z = z2;
        }
        for (C1521a a3 : c1522b.m5731a()) {
            a2 = m10119a(a3, (Set) set, abVar.m10096b());
            if (((Boolean) a2.m10289a()).booleanValue()) {
                z = z && a2.m10290b();
            } else {
                aj.m10146c(Boolean.valueOf(false));
                return new C2249w(Boolean.valueOf(false), a2.m10290b());
            }
        }
        aj.m10146c(Boolean.valueOf(true));
        return new C2249w(Boolean.valueOf(true), z);
    }

    C2249w<Set<C1521a>> m10121a(String str, Set<C1522b> set, Map<C1522b, List<C1521a>> map, Map<C1522b, List<String>> map2, Map<C1522b, List<C1521a>> map3, Map<C1522b, List<String>> map4, Set<String> set2, ac acVar) {
        return m10116a((Set) set, (Set) set2, new C21971(this, map, map2, map3, map4), acVar);
    }

    C2249w<Set<C1521a>> m10122a(Set<C1522b> set, ac acVar) {
        return m10116a((Set) set, new HashSet(), new C21982(this), acVar);
    }

    public synchronized void m10123a(String str) {
        m10124b(str);
        ap a = this.f7026b.m10253a(str).m10252a();
        for (C1521a a2 : (Set) m10122a(this.f7032h, a.m10175b()).m10289a()) {
            m10115a(this.f7027c, a2, new HashSet(), a.m10174a());
        }
        m10124b(null);
    }

    synchronized void m10124b(String str) {
        this.f7035k = str;
    }
}
