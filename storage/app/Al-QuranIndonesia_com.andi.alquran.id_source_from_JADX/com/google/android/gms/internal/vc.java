package com.google.android.gms.internal;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1314c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class vc {
    private final Map<String, String> f6191a;
    private final List<zzsf> f6192b;
    private final long f6193c;
    private final long f6194d;
    private final int f6195e;
    private final boolean f6196f;
    private final String f6197g;

    public vc(uc ucVar, Map<String, String> map, long j, boolean z) {
        this(ucVar, map, j, z, 0, 0, null);
    }

    public vc(uc ucVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(ucVar, map, j, z, j2, i, null);
    }

    public vc(uc ucVar, Map<String, String> map, long j, boolean z, long j2, int i, List<zzsf> list) {
        String a;
        C1314c.m4623a((Object) ucVar);
        C1314c.m4623a((Object) map);
        this.f6194d = j;
        this.f6196f = z;
        this.f6193c = j2;
        this.f6195e = i;
        this.f6192b = list != null ? list : Collections.emptyList();
        this.f6197g = m9403a((List) list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (m9404a(entry.getKey())) {
                a = m9401a(ucVar, entry.getKey());
                if (a != null) {
                    hashMap.put(a, m9405b(ucVar, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!m9404a(entry2.getKey())) {
                a = m9401a(ucVar, entry2.getKey());
                if (a != null) {
                    hashMap.put(a, m9405b(ucVar, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.f6197g)) {
            vp.m9511a(hashMap, "_v", this.f6197g);
            if (this.f6197g.equals("ma4.0.0") || this.f6197g.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.f6191a = Collections.unmodifiableMap(hashMap);
    }

    public static vc m9400a(uc ucVar, vc vcVar, Map<String, String> map) {
        return new vc(ucVar, map, vcVar.m9409d(), vcVar.m9411f(), vcVar.m9408c(), vcVar.m9406a(), vcVar.m9410e());
    }

    private static String m9401a(uc ucVar, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > NotificationCompat.FLAG_LOCAL_ONLY) {
            obj2 = obj2.substring(0, NotificationCompat.FLAG_LOCAL_ONLY);
            ucVar.m4256c("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private String m9402a(String str, String str2) {
        C1314c.m4625a(str);
        C1314c.m4633b(!str.startsWith("&"), "Short param name required");
        String str3 = (String) this.f6191a.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String m9403a(List<zzsf> list) {
        CharSequence b;
        if (list != null) {
            for (zzsf com_google_android_gms_internal_zzsf : list) {
                if ("appendVersion".equals(com_google_android_gms_internal_zzsf.m9787a())) {
                    b = com_google_android_gms_internal_zzsf.m9788b();
                    break;
                }
            }
        }
        b = null;
        return TextUtils.isEmpty(b) ? null : b;
    }

    private static boolean m9404a(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private static String m9405b(uc ucVar, Object obj) {
        String obj2 = obj == null ? BuildConfig.VERSION_NAME : obj.toString();
        int length = obj2.length();
        if (length <= FragmentTransaction.TRANSIT_EXIT_MASK) {
            return obj2;
        }
        obj2 = obj2.substring(0, FragmentTransaction.TRANSIT_EXIT_MASK);
        ucVar.m4256c("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    public int m9406a() {
        return this.f6195e;
    }

    public Map<String, String> m9407b() {
        return this.f6191a;
    }

    public long m9408c() {
        return this.f6193c;
    }

    public long m9409d() {
        return this.f6194d;
    }

    public List<zzsf> m9410e() {
        return this.f6192b;
    }

    public boolean m9411f() {
        return this.f6196f;
    }

    public long m9412g() {
        return vp.m9507a(m9402a("_s", "0"));
    }

    public String m9413h() {
        return m9402a("_m", BuildConfig.VERSION_NAME);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.f6194d);
        if (this.f6193c != 0) {
            stringBuffer.append(", dbId=").append(this.f6193c);
        }
        if (this.f6195e != 0) {
            stringBuffer.append(", appUID=").append(this.f6195e);
        }
        List<String> arrayList = new ArrayList(this.f6191a.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.f6191a.get(str));
        }
        return stringBuffer.toString();
    }
}
