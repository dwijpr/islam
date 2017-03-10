package com.google.android.gms.internal;

import com.google.android.gms.internal.ur.C2035a;

public class va extends ur<vb> {

    /* renamed from: com.google.android.gms.internal.va.a */
    private static class C2038a implements C2035a<vb> {
        private final uf f6184a;
        private final vb f6185b;

        public C2038a(uf ufVar) {
            this.f6184a = ufVar;
            this.f6185b = new vb();
        }

        public /* synthetic */ uq m9384a() {
            return m9388b();
        }

        public void m9385a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.f6185b.f6189d = i;
            } else {
                this.f6184a.m9158f().m4258d("Int xml configuration name not recognized", str);
            }
        }

        public void m9386a(String str, String str2) {
        }

        public void m9387a(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.f6185b.f6190e = z ? 1 : 0;
                return;
            }
            this.f6184a.m9158f().m4258d("Bool xml configuration name not recognized", str);
        }

        public vb m9388b() {
            return this.f6185b;
        }

        public void m9389b(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.f6185b.f6186a = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.f6185b.f6187b = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.f6185b.f6188c = str2;
            } else {
                this.f6184a.m9158f().m4258d("String xml configuration name not recognized", str);
            }
        }
    }

    public va(uf ufVar) {
        super(ufVar, new C2038a(ufVar));
    }
}
