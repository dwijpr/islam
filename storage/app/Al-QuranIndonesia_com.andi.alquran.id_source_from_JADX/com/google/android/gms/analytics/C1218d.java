package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.p040a.C1206a;
import com.google.android.gms.analytics.p040a.C1207b;
import com.google.android.gms.analytics.p040a.C1208c;
import com.google.android.gms.internal.vf;
import com.google.android.gms.internal.vp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.d */
public class C1218d {

    /* renamed from: com.google.android.gms.analytics.d.b */
    protected static class C1216b<T extends C1216b> {
        C1207b f2838a;
        Map<String, List<C1206a>> f2839b;
        List<C1208c> f2840c;
        List<C1206a> f2841d;
        private Map<String, String> f2842e;

        protected C1216b() {
            this.f2842e = new HashMap();
            this.f2839b = new HashMap();
            this.f2840c = new ArrayList();
            this.f2841d = new ArrayList();
        }

        public final T m4230a(String str, String str2) {
            if (str != null) {
                this.f2842e.put(str, str2);
            } else {
                vf.m9427b("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public Map<String, String> m4231a() {
            Map<String, String> hashMap = new HashMap(this.f2842e);
            if (this.f2838a != null) {
                hashMap.putAll(this.f2838a.m4192a());
            }
            int i = 1;
            for (C1208c a : this.f2840c) {
                hashMap.putAll(a.m4193a(C1226j.m4334e(i)));
                i++;
            }
            i = 1;
            for (C1206a a2 : this.f2841d) {
                hashMap.putAll(a2.m4191a(C1226j.m4332c(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.f2839b.entrySet()) {
                List<C1206a> list = (List) entry.getValue();
                String h = C1226j.m4337h(i2);
                int i3 = 1;
                for (C1206a c1206a : list) {
                    String valueOf = String.valueOf(h);
                    String valueOf2 = String.valueOf(C1226j.m4336g(i3));
                    hashMap.putAll(c1206a.m4191a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    String valueOf3 = String.valueOf(h);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }
    }

    /* renamed from: com.google.android.gms.analytics.d.a */
    public static class C1217a extends C1216b<C1217a> {
        public C1217a() {
            m4230a("&t", "exception");
        }

        public C1217a m4232a(String str) {
            m4230a("&exd", str);
            return this;
        }

        public C1217a m4233a(boolean z) {
            m4230a("&exf", vp.m9510a(z));
            return this;
        }

        public /* bridge */ /* synthetic */ Map m4234a() {
            return super.m4231a();
        }
    }
}
