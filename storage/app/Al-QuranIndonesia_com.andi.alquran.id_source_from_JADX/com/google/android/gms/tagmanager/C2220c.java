package com.google.android.gms.tagmanager;

import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.C0861R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.tagmanager.c */
public class C2220c {
    public static final Object f7092a;
    static final String[] f7093b;
    private static final Pattern f7094c;
    private final ConcurrentHashMap<C2201b, Integer> f7095d;
    private final Map<String, Object> f7096e;
    private final ReentrantLock f7097f;
    private final LinkedList<Map<String, Object>> f7098g;
    private final C2213c f7099h;
    private final CountDownLatch f7100i;

    /* renamed from: com.google.android.gms.tagmanager.c.b */
    interface C2201b {
        void m10125a(Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.c.c */
    interface C2213c {

        /* renamed from: com.google.android.gms.tagmanager.c.c.a */
        public interface C2217a {
            void m10216a(List<C2219a> list);
        }

        void m10178a(C2217a c2217a);

        void m10179a(List<C2219a> list, long j);
    }

    /* renamed from: com.google.android.gms.tagmanager.c.1 */
    class C22161 implements C2213c {
        C22161() {
        }

        public void m10214a(C2217a c2217a) {
            c2217a.m10216a(new ArrayList());
        }

        public void m10215a(List<C2219a> list, long j) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.c.2 */
    class C22182 implements C2217a {
        final /* synthetic */ C2220c f7089a;

        C22182(C2220c c2220c) {
            this.f7089a = c2220c;
        }

        public void m10217a(List<C2219a> list) {
            for (C2219a c2219a : list) {
                this.f7089a.m10224b(this.f7089a.m10231a(c2219a.f7090a, c2219a.f7091b));
            }
            this.f7089a.f7100i.countDown();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.c.a */
    static final class C2219a {
        public final String f7090a;
        public final Object f7091b;

        C2219a(String str, Object obj) {
            this.f7090a = str;
            this.f7091b = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C2219a)) {
                return false;
            }
            C2219a c2219a = (C2219a) obj;
            return this.f7090a.equals(c2219a.f7090a) && this.f7091b.equals(c2219a.f7091b);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f7090a.hashCode()), Integer.valueOf(this.f7091b.hashCode())});
        }

        public String toString() {
            String str = this.f7090a;
            String valueOf = String.valueOf(this.f7091b.toString());
            return new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()).append("Key: ").append(str).append(" value: ").append(valueOf).toString();
        }
    }

    static {
        f7092a = new Object();
        f7093b = "gtm.lifetime".toString().split("\\.");
        f7094c = Pattern.compile("(\\d+)\\s*([smhd]?)");
    }

    C2220c() {
        this(new C22161());
    }

    C2220c(C2213c c2213c) {
        this.f7099h = c2213c;
        this.f7095d = new ConcurrentHashMap();
        this.f7096e = new HashMap();
        this.f7097f = new ReentrantLock();
        this.f7098g = new LinkedList();
        this.f7100i = new CountDownLatch(1);
        m10220a();
    }

    static Long m10218a(String str) {
        Matcher matcher = f7094c.matcher(str);
        String str2;
        String valueOf;
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                str2 = "illegal number in _lifetime value: ";
                valueOf = String.valueOf(str);
                C2238n.m10266b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                parseLong = 0;
            }
            if (parseLong <= 0) {
                str2 = "non-positive _lifetime: ";
                valueOf = String.valueOf(str);
                C2238n.m10268c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            }
            valueOf = matcher.group(2);
            if (valueOf.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (valueOf.charAt(0)) {
                case C0861R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /*100*/:
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case C0861R.styleable.AppCompatTheme_checkboxStyle /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case C0861R.styleable.AppCompatTheme_ratingBarStyleIndicator /*109*/:
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    str2 = "unknown units in _lifetime: ";
                    valueOf = String.valueOf(str);
                    C2238n.m10266b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
            }
        }
        str2 = "unknown _lifetime: ";
        valueOf = String.valueOf(str);
        C2238n.m10268c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return null;
    }

    private void m10220a() {
        this.f7099h.m10178a(new C22182(this));
    }

    private void m10222a(Map<String, Object> map, String str, Collection<C2219a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str.length() == 0 ? BuildConfig.VERSION_NAME : ".";
            String str3 = (String) entry.getKey();
            str3 = new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(str2).append(str3).toString();
            if (entry.getValue() instanceof Map) {
                m10222a((Map) entry.getValue(), str3, collection);
            } else if (!str3.equals("gtm.lifetime")) {
                collection.add(new C2219a(str3, entry.getValue()));
            }
        }
    }

    private void m10223b() {
        int i = 0;
        while (true) {
            Map map = (Map) this.f7098g.poll();
            if (map != null) {
                m10229g(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    break;
                }
                i = i2;
            } else {
                return;
            }
        }
        this.f7098g.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    private void m10224b(Map<String, Object> map) {
        this.f7097f.lock();
        try {
            this.f7098g.offer(map);
            if (this.f7097f.getHoldCount() == 1) {
                m10223b();
            }
            m10225c(map);
        } finally {
            this.f7097f.unlock();
        }
    }

    private void m10225c(Map<String, Object> map) {
        Long d = m10226d(map);
        if (d != null) {
            List f = m10228f(map);
            f.remove("gtm.lifetime");
            this.f7099h.m10179a(f, d.longValue());
        }
    }

    private Long m10226d(Map<String, Object> map) {
        Object e = m10227e(map);
        return e == null ? null : C2220c.m10218a(e.toString());
    }

    private Object m10227e(Map<String, Object> map) {
        String[] strArr = f7093b;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<C2219a> m10228f(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        m10222a(map, BuildConfig.VERSION_NAME, arrayList);
        return arrayList;
    }

    private void m10229g(Map<String, Object> map) {
        synchronized (this.f7096e) {
            for (String str : map.keySet()) {
                m10235a(m10231a(str, map.get(str)), this.f7096e);
            }
        }
        m10230h(map);
    }

    private void m10230h(Map<String, Object> map) {
        for (C2201b a : this.f7095d.keySet()) {
            a.m10125a(map);
        }
    }

    Map<String, Object> m10231a(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    void m10232a(C2201b c2201b) {
        this.f7095d.put(c2201b, Integer.valueOf(0));
    }

    void m10233a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m10233a((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m10235a((Map) obj, (Map) list2.get(i));
            } else if (obj != f7092a) {
                list2.set(i, obj);
            }
        }
    }

    public void m10234a(Map<String, Object> map) {
        try {
            this.f7100i.await();
        } catch (InterruptedException e) {
            C2238n.m10266b("DataLayer.push: unexpected InterruptedException");
        }
        m10224b(map);
    }

    void m10235a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m10233a((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m10235a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.f7096e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.f7096e.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
