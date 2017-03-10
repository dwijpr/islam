package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C1313b;
import java.util.ArrayList;
import java.util.List;

@op
public class rw {
    private final String[] f5792a;
    private final double[] f5793b;
    private final double[] f5794c;
    private final int[] f5795d;
    private int f5796e;

    /* renamed from: com.google.android.gms.internal.rw.a */
    public static class C1981a {
        public final String f5784a;
        public final double f5785b;
        public final double f5786c;
        public final double f5787d;
        public final int f5788e;

        public C1981a(String str, double d, double d2, double d3, int i) {
            this.f5784a = str;
            this.f5786c = d;
            this.f5785b = d2;
            this.f5787d = d3;
            this.f5788e = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1981a)) {
                return false;
            }
            C1981a c1981a = (C1981a) obj;
            return C1313b.m4621a(this.f5784a, c1981a.f5784a) && this.f5785b == c1981a.f5785b && this.f5786c == c1981a.f5786c && this.f5788e == c1981a.f5788e && Double.compare(this.f5787d, c1981a.f5787d) == 0;
        }

        public int hashCode() {
            return C1313b.m4619a(this.f5784a, Double.valueOf(this.f5785b), Double.valueOf(this.f5786c), Double.valueOf(this.f5787d), Integer.valueOf(this.f5788e));
        }

        public String toString() {
            return C1313b.m4620a((Object) this).m4618a("name", this.f5784a).m4618a("minBound", Double.valueOf(this.f5786c)).m4618a("maxBound", Double.valueOf(this.f5785b)).m4618a("percent", Double.valueOf(this.f5787d)).m4618a("count", Integer.valueOf(this.f5788e)).toString();
        }
    }

    /* renamed from: com.google.android.gms.internal.rw.b */
    public static class C1982b {
        private final List<String> f5789a;
        private final List<Double> f5790b;
        private final List<Double> f5791c;

        public C1982b() {
            this.f5789a = new ArrayList();
            this.f5790b = new ArrayList();
            this.f5791c = new ArrayList();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.internal.rw.C1982b m8645a(java.lang.String r7, double r8, double r10) {
            /*
            r6 = this;
            r0 = 0;
            r1 = r0;
        L_0x0002:
            r0 = r6.f5789a;
            r0 = r0.size();
            if (r1 >= r0) goto L_0x0026;
        L_0x000a:
            r0 = r6.f5791c;
            r0 = r0.get(r1);
            r0 = (java.lang.Double) r0;
            r2 = r0.doubleValue();
            r0 = r6.f5790b;
            r0 = r0.get(r1);
            r0 = (java.lang.Double) r0;
            r4 = r0.doubleValue();
            r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x003e;
        L_0x0026:
            r0 = r6.f5789a;
            r0.add(r1, r7);
            r0 = r6.f5791c;
            r2 = java.lang.Double.valueOf(r8);
            r0.add(r1, r2);
            r0 = r6.f5790b;
            r2 = java.lang.Double.valueOf(r10);
            r0.add(r1, r2);
            return r6;
        L_0x003e:
            r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
            if (r0 != 0) goto L_0x0046;
        L_0x0042:
            r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
            if (r0 < 0) goto L_0x0026;
        L_0x0046:
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0002;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.rw.b.a(java.lang.String, double, double):com.google.android.gms.internal.rw$b");
        }

        public rw m8646a() {
            return new rw();
        }
    }

    private rw(C1982b c1982b) {
        int size = c1982b.f5790b.size();
        this.f5792a = (String[]) c1982b.f5789a.toArray(new String[size]);
        this.f5793b = m8647a(c1982b.f5790b);
        this.f5794c = m8647a(c1982b.f5791c);
        this.f5795d = new int[size];
        this.f5796e = 0;
    }

    private double[] m8647a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<C1981a> m8648a() {
        List<C1981a> arrayList = new ArrayList(this.f5792a.length);
        for (int i = 0; i < this.f5792a.length; i++) {
            arrayList.add(new C1981a(this.f5792a[i], this.f5794c[i], this.f5793b[i], ((double) this.f5795d[i]) / ((double) this.f5796e), this.f5795d[i]));
        }
        return arrayList;
    }

    public void m8649a(double d) {
        this.f5796e++;
        int i = 0;
        while (i < this.f5794c.length) {
            if (this.f5794c[i] <= d && d < this.f5793b[i]) {
                int[] iArr = this.f5795d;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.f5794c[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
