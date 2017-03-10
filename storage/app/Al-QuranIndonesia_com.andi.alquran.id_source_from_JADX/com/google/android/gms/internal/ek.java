package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.C0861R;
import com.google.ads.AdSize;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.maps.GoogleMap;
import java.util.Arrays;

public interface ek {

    /* renamed from: com.google.android.gms.internal.ek.a */
    public static final class C1529a extends ea<C1529a> implements Cloneable {
        public int f3868a;
        public String f3869b;
        public String f3870c;

        public C1529a() {
            m5926a();
        }

        public C1529a m5926a() {
            this.f3868a = 0;
            this.f3869b = BuildConfig.VERSION_NAME;
            this.f3870c = BuildConfig.VERSION_NAME;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C1529a m5927a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiRotateGestures /*8*/:
                        this.f3868a = dyVar.m5785e();
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3869b = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.Toolbar_logoDescription /*26*/:
                        this.f3870c = dyVar.m5789g();
                        continue;
                    default:
                        if (!super.m5173a(dyVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m5928a(dz dzVar) {
            if (this.f3868a != 0) {
                dzVar.m5831a(1, this.f3868a);
            }
            if (!(this.f3869b == null || this.f3869b.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(2, this.f3869b);
            }
            if (!(this.f3870c == null || this.f3870c.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(3, this.f3870c);
            }
            super.m5172a(dzVar);
        }

        protected int m5929b() {
            int b = super.m5174b();
            if (this.f3868a != 0) {
                b += dz.m5807b(1, this.f3868a);
            }
            if (!(this.f3869b == null || this.f3869b.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(2, this.f3869b);
            }
            return (this.f3870c == null || this.f3870c.equals(BuildConfig.VERSION_NAME)) ? b : b + dz.m5809b(3, this.f3870c);
        }

        public /* synthetic */ eg m5930b(dy dyVar) {
            return m5927a(dyVar);
        }

        public C1529a m5931c() {
            try {
                return (C1529a) super.m5175d();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m5931c();
        }

        public /* synthetic */ ea m5932d() {
            return (C1529a) m5933e();
        }

        public /* synthetic */ eg m5933e() {
            return (C1529a) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1529a)) {
                return false;
            }
            C1529a c1529a = (C1529a) obj;
            if (this.f3868a != c1529a.f3868a) {
                return false;
            }
            if (this.f3869b == null) {
                if (c1529a.f3869b != null) {
                    return false;
                }
            } else if (!this.f3869b.equals(c1529a.f3869b)) {
                return false;
            }
            if (this.f3870c == null) {
                if (c1529a.f3870c != null) {
                    return false;
                }
            } else if (!this.f3870c.equals(c1529a.f3870c)) {
                return false;
            }
            return (this.ag == null || this.ag.m5892b()) ? c1529a.ag == null || c1529a.ag.m5892b() : this.ag.equals(c1529a.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3870c == null ? 0 : this.f3870c.hashCode()) + (((this.f3869b == null ? 0 : this.f3869b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f3868a) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m5892b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.ek.b */
    public static final class C1530b extends ea<C1530b> implements Cloneable {
        public byte[] f3871a;
        public String f3872b;
        public byte[][] f3873c;
        public boolean f3874d;

        public C1530b() {
            m5934a();
        }

        public C1530b m5934a() {
            this.f3871a = ej.f3867h;
            this.f3872b = BuildConfig.VERSION_NAME;
            this.f3873c = ej.f3866g;
            this.f3874d = false;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C1530b m5935a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        this.f3871a = dyVar.m5790h();
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        int b = ej.m5925b(dyVar, 18);
                        a = this.f3873c == null ? 0 : this.f3873c.length;
                        Object obj = new byte[(b + a)][];
                        if (a != 0) {
                            System.arraycopy(this.f3873c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = dyVar.m5790h();
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = dyVar.m5790h();
                        this.f3873c = obj;
                        continue;
                    case C0861R.styleable.Toolbar_navigationIcon /*24*/:
                        this.f3874d = dyVar.m5788f();
                        continue;
                    case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.f3872b = dyVar.m5789g();
                        continue;
                    default:
                        if (!super.m5173a(dyVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m5936a(dz dzVar) {
            if (!Arrays.equals(this.f3871a, ej.f3867h)) {
                dzVar.m5836a(1, this.f3871a);
            }
            if (this.f3873c != null && this.f3873c.length > 0) {
                for (byte[] bArr : this.f3873c) {
                    if (bArr != null) {
                        dzVar.m5836a(2, bArr);
                    }
                }
            }
            if (this.f3874d) {
                dzVar.m5835a(3, this.f3874d);
            }
            if (!(this.f3872b == null || this.f3872b.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(4, this.f3872b);
            }
            super.m5172a(dzVar);
        }

        protected int m5937b() {
            int i = 0;
            int b = super.m5174b();
            if (!Arrays.equals(this.f3871a, ej.f3867h)) {
                b += dz.m5811b(1, this.f3871a);
            }
            if (this.f3873c != null && this.f3873c.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.f3873c.length) {
                    byte[] bArr = this.f3873c[i];
                    if (bArr != null) {
                        i3++;
                        i2 += dz.m5816c(bArr);
                    }
                    i++;
                }
                b = (b + i2) + (i3 * 1);
            }
            if (this.f3874d) {
                b += dz.m5810b(3, this.f3874d);
            }
            return (this.f3872b == null || this.f3872b.equals(BuildConfig.VERSION_NAME)) ? b : b + dz.m5809b(4, this.f3872b);
        }

        public /* synthetic */ eg m5938b(dy dyVar) {
            return m5935a(dyVar);
        }

        public C1530b m5939c() {
            try {
                C1530b c1530b = (C1530b) super.m5175d();
                if (this.f3873c != null && this.f3873c.length > 0) {
                    c1530b.f3873c = (byte[][]) this.f3873c.clone();
                }
                return c1530b;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m5939c();
        }

        public /* synthetic */ ea m5940d() {
            return (C1530b) m5941e();
        }

        public /* synthetic */ eg m5941e() {
            return (C1530b) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1530b)) {
                return false;
            }
            C1530b c1530b = (C1530b) obj;
            if (!Arrays.equals(this.f3871a, c1530b.f3871a)) {
                return false;
            }
            if (this.f3872b == null) {
                if (c1530b.f3872b != null) {
                    return false;
                }
            } else if (!this.f3872b.equals(c1530b.f3872b)) {
                return false;
            }
            return (ee.m5905a(this.f3873c, c1530b.f3873c) && this.f3874d == c1530b.f3874d) ? (this.ag == null || this.ag.m5892b()) ? c1530b.ag == null || c1530b.ag.m5892b() : this.ag.equals(c1530b.ag) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3874d ? 1231 : 1237) + (((((this.f3872b == null ? 0 : this.f3872b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f3871a)) * 31)) * 31) + ee.m5901a(this.f3873c)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m5892b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.ek.c */
    public static final class C1531c extends ea<C1531c> implements Cloneable {
        public long f3875a;
        public long f3876b;
        public long f3877c;
        public String f3878d;
        public int f3879e;
        public int f3880f;
        public boolean f3881g;
        public C1532d[] f3882h;
        public byte[] f3883i;
        public C1529a f3884j;
        public byte[] f3885k;
        public String f3886l;
        public String f3887m;
        public String f3888n;
        public long f3889o;
        public C1530b f3890p;
        public byte[] f3891q;
        public String f3892r;
        public int f3893s;
        public int[] f3894t;
        public long f3895u;
        public C1533e f3896v;

        public C1531c() {
            m5942a();
        }

        public C1531c m5942a() {
            this.f3875a = 0;
            this.f3876b = 0;
            this.f3877c = 0;
            this.f3878d = BuildConfig.VERSION_NAME;
            this.f3879e = 0;
            this.f3880f = 0;
            this.f3881g = false;
            this.f3882h = C1532d.m5950a();
            this.f3883i = ej.f3867h;
            this.f3884j = null;
            this.f3885k = ej.f3867h;
            this.f3886l = BuildConfig.VERSION_NAME;
            this.f3887m = BuildConfig.VERSION_NAME;
            this.f3888n = BuildConfig.VERSION_NAME;
            this.f3889o = 180000;
            this.f3890p = null;
            this.f3891q = ej.f3867h;
            this.f3892r = BuildConfig.VERSION_NAME;
            this.f3893s = 0;
            this.f3894t = ej.f3860a;
            this.f3895u = 0;
            this.f3896v = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C1531c m5943a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                int b;
                Object obj;
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiRotateGestures /*8*/:
                        this.f3875a = dyVar.m5783d();
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3878d = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.Toolbar_logoDescription /*26*/:
                        b = ej.m5925b(dyVar, 26);
                        a = this.f3882h == null ? 0 : this.f3882h.length;
                        obj = new C1532d[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f3882h, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1532d();
                            dyVar.m5777a(obj[a]);
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = new C1532d();
                        dyVar.m5777a(obj[a]);
                        this.f3882h = obj;
                        continue;
                    case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.f3883i = dyVar.m5790h();
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.f3885k = dyVar.m5790h();
                        continue;
                    case C0861R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                        this.f3886l = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                        if (this.f3884j == null) {
                            this.f3884j = new C1529a();
                        }
                        dyVar.m5777a(this.f3884j);
                        continue;
                    case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        this.f3881g = dyVar.m5788f();
                        continue;
                    case C0861R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
                        this.f3879e = dyVar.m5785e();
                        continue;
                    case C0861R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                        this.f3880f = dyVar.m5785e();
                        continue;
                    case C0861R.styleable.AppCompatTheme_editTextStyle /*106*/:
                        this.f3887m = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                        this.f3888n = dyVar.m5789g();
                        continue;
                    case 120:
                        this.f3889o = dyVar.m5791i();
                        continue;
                    case 130:
                        if (this.f3890p == null) {
                            this.f3890p = new C1530b();
                        }
                        dyVar.m5777a(this.f3890p);
                        continue;
                    case 136:
                        this.f3876b = dyVar.m5783d();
                        continue;
                    case 146:
                        this.f3891q = dyVar.m5790h();
                        continue;
                    case 152:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                                this.f3893s = a;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        b = ej.m5925b(dyVar, 160);
                        a = this.f3894t == null ? 0 : this.f3894t.length;
                        obj = new int[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f3894t, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = dyVar.m5785e();
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = dyVar.m5785e();
                        this.f3894t = obj;
                        continue;
                    case 162:
                        int c = dyVar.m5781c(dyVar.m5792j());
                        b = dyVar.m5798p();
                        a = 0;
                        while (dyVar.m5796n() > 0) {
                            dyVar.m5785e();
                            a++;
                        }
                        dyVar.m5786e(b);
                        b = this.f3894t == null ? 0 : this.f3894t.length;
                        Object obj2 = new int[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f3894t, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = dyVar.m5785e();
                            b++;
                        }
                        this.f3894t = obj2;
                        dyVar.m5784d(c);
                        continue;
                    case 168:
                        this.f3877c = dyVar.m5783d();
                        continue;
                    case 176:
                        this.f3895u = dyVar.m5783d();
                        continue;
                    case 186:
                        if (this.f3896v == null) {
                            this.f3896v = new C1533e();
                        }
                        dyVar.m5777a(this.f3896v);
                        continue;
                    case 194:
                        this.f3892r = dyVar.m5789g();
                        continue;
                    default:
                        if (!super.m5173a(dyVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m5944a(dz dzVar) {
            int i = 0;
            if (this.f3875a != 0) {
                dzVar.m5842b(1, this.f3875a);
            }
            if (!(this.f3878d == null || this.f3878d.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(2, this.f3878d);
            }
            if (this.f3882h != null && this.f3882h.length > 0) {
                for (eg egVar : this.f3882h) {
                    if (egVar != null) {
                        dzVar.m5833a(3, egVar);
                    }
                }
            }
            if (!Arrays.equals(this.f3883i, ej.f3867h)) {
                dzVar.m5836a(4, this.f3883i);
            }
            if (!Arrays.equals(this.f3885k, ej.f3867h)) {
                dzVar.m5836a(6, this.f3885k);
            }
            if (!(this.f3886l == null || this.f3886l.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(8, this.f3886l);
            }
            if (this.f3884j != null) {
                dzVar.m5833a(9, this.f3884j);
            }
            if (this.f3881g) {
                dzVar.m5835a(10, this.f3881g);
            }
            if (this.f3879e != 0) {
                dzVar.m5831a(11, this.f3879e);
            }
            if (this.f3880f != 0) {
                dzVar.m5831a(12, this.f3880f);
            }
            if (!(this.f3887m == null || this.f3887m.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(13, this.f3887m);
            }
            if (!(this.f3888n == null || this.f3888n.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(14, this.f3888n);
            }
            if (this.f3889o != 180000) {
                dzVar.m5849c(15, this.f3889o);
            }
            if (this.f3890p != null) {
                dzVar.m5833a(16, this.f3890p);
            }
            if (this.f3876b != 0) {
                dzVar.m5842b(17, this.f3876b);
            }
            if (!Arrays.equals(this.f3891q, ej.f3867h)) {
                dzVar.m5836a(18, this.f3891q);
            }
            if (this.f3893s != 0) {
                dzVar.m5831a(19, this.f3893s);
            }
            if (this.f3894t != null && this.f3894t.length > 0) {
                while (i < this.f3894t.length) {
                    dzVar.m5831a(20, this.f3894t[i]);
                    i++;
                }
            }
            if (this.f3877c != 0) {
                dzVar.m5842b(21, this.f3877c);
            }
            if (this.f3895u != 0) {
                dzVar.m5842b(22, this.f3895u);
            }
            if (this.f3896v != null) {
                dzVar.m5833a(23, this.f3896v);
            }
            if (!(this.f3892r == null || this.f3892r.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(24, this.f3892r);
            }
            super.m5172a(dzVar);
        }

        protected int m5945b() {
            int i;
            int i2 = 0;
            int b = super.m5174b();
            if (this.f3875a != 0) {
                b += dz.m5821e(1, this.f3875a);
            }
            if (!(this.f3878d == null || this.f3878d.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(2, this.f3878d);
            }
            if (this.f3882h != null && this.f3882h.length > 0) {
                i = b;
                for (eg egVar : this.f3882h) {
                    if (egVar != null) {
                        i += dz.m5814c(3, egVar);
                    }
                }
                b = i;
            }
            if (!Arrays.equals(this.f3883i, ej.f3867h)) {
                b += dz.m5811b(4, this.f3883i);
            }
            if (!Arrays.equals(this.f3885k, ej.f3867h)) {
                b += dz.m5811b(6, this.f3885k);
            }
            if (!(this.f3886l == null || this.f3886l.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(8, this.f3886l);
            }
            if (this.f3884j != null) {
                b += dz.m5814c(9, this.f3884j);
            }
            if (this.f3881g) {
                b += dz.m5810b(10, this.f3881g);
            }
            if (this.f3879e != 0) {
                b += dz.m5807b(11, this.f3879e);
            }
            if (this.f3880f != 0) {
                b += dz.m5807b(12, this.f3880f);
            }
            if (!(this.f3887m == null || this.f3887m.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(13, this.f3887m);
            }
            if (!(this.f3888n == null || this.f3888n.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(14, this.f3888n);
            }
            if (this.f3889o != 180000) {
                b += dz.m5824f(15, this.f3889o);
            }
            if (this.f3890p != null) {
                b += dz.m5814c(16, this.f3890p);
            }
            if (this.f3876b != 0) {
                b += dz.m5821e(17, this.f3876b);
            }
            if (!Arrays.equals(this.f3891q, ej.f3867h)) {
                b += dz.m5811b(18, this.f3891q);
            }
            if (this.f3893s != 0) {
                b += dz.m5807b(19, this.f3893s);
            }
            if (this.f3894t != null && this.f3894t.length > 0) {
                i = 0;
                while (i2 < this.f3894t.length) {
                    i += dz.m5806b(this.f3894t[i2]);
                    i2++;
                }
                b = (b + i) + (this.f3894t.length * 2);
            }
            if (this.f3877c != 0) {
                b += dz.m5821e(21, this.f3877c);
            }
            if (this.f3895u != 0) {
                b += dz.m5821e(22, this.f3895u);
            }
            if (this.f3896v != null) {
                b += dz.m5814c(23, this.f3896v);
            }
            return (this.f3892r == null || this.f3892r.equals(BuildConfig.VERSION_NAME)) ? b : b + dz.m5809b(24, this.f3892r);
        }

        public /* synthetic */ eg m5946b(dy dyVar) {
            return m5943a(dyVar);
        }

        public C1531c m5947c() {
            try {
                C1531c c1531c = (C1531c) super.m5175d();
                if (this.f3882h != null && this.f3882h.length > 0) {
                    c1531c.f3882h = new C1532d[this.f3882h.length];
                    for (int i = 0; i < this.f3882h.length; i++) {
                        if (this.f3882h[i] != null) {
                            c1531c.f3882h[i] = (C1532d) this.f3882h[i].m5957e();
                        }
                    }
                }
                if (this.f3884j != null) {
                    c1531c.f3884j = (C1529a) this.f3884j.m5933e();
                }
                if (this.f3890p != null) {
                    c1531c.f3890p = (C1530b) this.f3890p.m5941e();
                }
                if (this.f3894t != null && this.f3894t.length > 0) {
                    c1531c.f3894t = (int[]) this.f3894t.clone();
                }
                if (this.f3896v != null) {
                    c1531c.f3896v = (C1533e) this.f3896v.m5966e();
                }
                return c1531c;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m5947c();
        }

        public /* synthetic */ ea m5948d() {
            return (C1531c) m5949e();
        }

        public /* synthetic */ eg m5949e() {
            return (C1531c) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1531c)) {
                return false;
            }
            C1531c c1531c = (C1531c) obj;
            if (this.f3875a != c1531c.f3875a || this.f3876b != c1531c.f3876b || this.f3877c != c1531c.f3877c) {
                return false;
            }
            if (this.f3878d == null) {
                if (c1531c.f3878d != null) {
                    return false;
                }
            } else if (!this.f3878d.equals(c1531c.f3878d)) {
                return false;
            }
            if (this.f3879e != c1531c.f3879e || this.f3880f != c1531c.f3880f || this.f3881g != c1531c.f3881g || !ee.m5904a(this.f3882h, c1531c.f3882h) || !Arrays.equals(this.f3883i, c1531c.f3883i)) {
                return false;
            }
            if (this.f3884j == null) {
                if (c1531c.f3884j != null) {
                    return false;
                }
            } else if (!this.f3884j.equals(c1531c.f3884j)) {
                return false;
            }
            if (!Arrays.equals(this.f3885k, c1531c.f3885k)) {
                return false;
            }
            if (this.f3886l == null) {
                if (c1531c.f3886l != null) {
                    return false;
                }
            } else if (!this.f3886l.equals(c1531c.f3886l)) {
                return false;
            }
            if (this.f3887m == null) {
                if (c1531c.f3887m != null) {
                    return false;
                }
            } else if (!this.f3887m.equals(c1531c.f3887m)) {
                return false;
            }
            if (this.f3888n == null) {
                if (c1531c.f3888n != null) {
                    return false;
                }
            } else if (!this.f3888n.equals(c1531c.f3888n)) {
                return false;
            }
            if (this.f3889o != c1531c.f3889o) {
                return false;
            }
            if (this.f3890p == null) {
                if (c1531c.f3890p != null) {
                    return false;
                }
            } else if (!this.f3890p.equals(c1531c.f3890p)) {
                return false;
            }
            if (!Arrays.equals(this.f3891q, c1531c.f3891q)) {
                return false;
            }
            if (this.f3892r == null) {
                if (c1531c.f3892r != null) {
                    return false;
                }
            } else if (!this.f3892r.equals(c1531c.f3892r)) {
                return false;
            }
            if (this.f3893s != c1531c.f3893s || !ee.m5903a(this.f3894t, c1531c.f3894t) || this.f3895u != c1531c.f3895u) {
                return false;
            }
            if (this.f3896v == null) {
                if (c1531c.f3896v != null) {
                    return false;
                }
            } else if (!this.f3896v.equals(c1531c.f3896v)) {
                return false;
            }
            return (this.ag == null || this.ag.m5892b()) ? c1531c.ag == null || c1531c.ag.m5892b() : this.ag.equals(c1531c.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3896v == null ? 0 : this.f3896v.hashCode()) + (((((((((this.f3892r == null ? 0 : this.f3892r.hashCode()) + (((((this.f3890p == null ? 0 : this.f3890p.hashCode()) + (((((this.f3888n == null ? 0 : this.f3888n.hashCode()) + (((this.f3887m == null ? 0 : this.f3887m.hashCode()) + (((this.f3886l == null ? 0 : this.f3886l.hashCode()) + (((((this.f3884j == null ? 0 : this.f3884j.hashCode()) + (((((((this.f3881g ? 1231 : 1237) + (((((((this.f3878d == null ? 0 : this.f3878d.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.f3875a ^ (this.f3875a >>> 32)))) * 31) + ((int) (this.f3876b ^ (this.f3876b >>> 32)))) * 31) + ((int) (this.f3877c ^ (this.f3877c >>> 32)))) * 31)) * 31) + this.f3879e) * 31) + this.f3880f) * 31)) * 31) + ee.m5900a(this.f3882h)) * 31) + Arrays.hashCode(this.f3883i)) * 31)) * 31) + Arrays.hashCode(this.f3885k)) * 31)) * 31)) * 31)) * 31) + ((int) (this.f3889o ^ (this.f3889o >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.f3891q)) * 31)) * 31) + this.f3893s) * 31) + ee.m5899a(this.f3894t)) * 31) + ((int) (this.f3895u ^ (this.f3895u >>> 32)))) * 31)) * 31;
            if (!(this.ag == null || this.ag.m5892b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.ek.d */
    public static final class C1532d extends ea<C1532d> implements Cloneable {
        private static volatile C1532d[] f3897c;
        public String f3898a;
        public String f3899b;

        public C1532d() {
            m5955c();
        }

        public static C1532d[] m5950a() {
            if (f3897c == null) {
                synchronized (ee.f3857c) {
                    if (f3897c == null) {
                        f3897c = new C1532d[0];
                    }
                }
            }
            return f3897c;
        }

        public C1532d m5951a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        this.f3898a = dyVar.m5789g();
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3899b = dyVar.m5789g();
                        continue;
                    default:
                        if (!super.m5173a(dyVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m5952a(dz dzVar) {
            if (!(this.f3898a == null || this.f3898a.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(1, this.f3898a);
            }
            if (!(this.f3899b == null || this.f3899b.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(2, this.f3899b);
            }
            super.m5172a(dzVar);
        }

        protected int m5953b() {
            int b = super.m5174b();
            if (!(this.f3898a == null || this.f3898a.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(1, this.f3898a);
            }
            return (this.f3899b == null || this.f3899b.equals(BuildConfig.VERSION_NAME)) ? b : b + dz.m5809b(2, this.f3899b);
        }

        public /* synthetic */ eg m5954b(dy dyVar) {
            return m5951a(dyVar);
        }

        public C1532d m5955c() {
            this.f3898a = BuildConfig.VERSION_NAME;
            this.f3899b = BuildConfig.VERSION_NAME;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public /* synthetic */ Object clone() {
            return m5958h();
        }

        public /* synthetic */ ea m5956d() {
            return (C1532d) m5957e();
        }

        public /* synthetic */ eg m5957e() {
            return (C1532d) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1532d)) {
                return false;
            }
            C1532d c1532d = (C1532d) obj;
            if (this.f3898a == null) {
                if (c1532d.f3898a != null) {
                    return false;
                }
            } else if (!this.f3898a.equals(c1532d.f3898a)) {
                return false;
            }
            if (this.f3899b == null) {
                if (c1532d.f3899b != null) {
                    return false;
                }
            } else if (!this.f3899b.equals(c1532d.f3899b)) {
                return false;
            }
            return (this.ag == null || this.ag.m5892b()) ? c1532d.ag == null || c1532d.ag.m5892b() : this.ag.equals(c1532d.ag);
        }

        public C1532d m5958h() {
            try {
                return (C1532d) super.m5175d();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3899b == null ? 0 : this.f3899b.hashCode()) + (((this.f3898a == null ? 0 : this.f3898a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m5892b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.ek.e */
    public static final class C1533e extends ea<C1533e> implements Cloneable {
        public int f3900a;
        public int f3901b;

        public C1533e() {
            m5959a();
        }

        public C1533e m5959a() {
            this.f3900a = -1;
            this.f3901b = 0;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C1533e m5960a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiRotateGestures /*8*/:
                        a = dyVar.m5785e();
                        switch (a) {
                            case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                            case C1096c.MapAttrs_cameraZoom /*5*/:
                            case C1096c.MapAttrs_liteMode /*6*/:
                            case C1096c.MapAttrs_uiCompass /*7*/:
                            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                            case C1096c.MapAttrs_uiTiltGestures /*10*/:
                            case C1096c.MapAttrs_uiZoomControls /*11*/:
                            case C1096c.MapAttrs_uiZoomGestures /*12*/:
                            case C1096c.MapAttrs_useViewLifecycle /*13*/:
                            case C1096c.MapAttrs_zOrderOnTop /*14*/:
                            case C1096c.MapAttrs_uiMapToolbar /*15*/:
                            case C1096c.MapAttrs_ambientEnabled /*16*/:
                            case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                                this.f3900a = a;
                                break;
                            default:
                                continue;
                        }
                    case C1096c.MapAttrs_ambientEnabled /*16*/:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                            case C1096c.MapAttrs_cameraZoom /*5*/:
                            case C1096c.MapAttrs_liteMode /*6*/:
                            case C1096c.MapAttrs_uiCompass /*7*/:
                            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                            case C1096c.MapAttrs_uiTiltGestures /*10*/:
                            case C1096c.MapAttrs_uiZoomControls /*11*/:
                            case C1096c.MapAttrs_uiZoomGestures /*12*/:
                            case C1096c.MapAttrs_useViewLifecycle /*13*/:
                            case C1096c.MapAttrs_zOrderOnTop /*14*/:
                            case C1096c.MapAttrs_uiMapToolbar /*15*/:
                            case C1096c.MapAttrs_ambientEnabled /*16*/:
                            case C0861R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /*100*/:
                                this.f3901b = a;
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!super.m5173a(dyVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m5961a(dz dzVar) {
            if (this.f3900a != -1) {
                dzVar.m5831a(1, this.f3900a);
            }
            if (this.f3901b != 0) {
                dzVar.m5831a(2, this.f3901b);
            }
            super.m5172a(dzVar);
        }

        protected int m5962b() {
            int b = super.m5174b();
            if (this.f3900a != -1) {
                b += dz.m5807b(1, this.f3900a);
            }
            return this.f3901b != 0 ? b + dz.m5807b(2, this.f3901b) : b;
        }

        public /* synthetic */ eg m5963b(dy dyVar) {
            return m5960a(dyVar);
        }

        public C1533e m5964c() {
            try {
                return (C1533e) super.m5175d();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m5964c();
        }

        public /* synthetic */ ea m5965d() {
            return (C1533e) m5966e();
        }

        public /* synthetic */ eg m5966e() {
            return (C1533e) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1533e)) {
                return false;
            }
            C1533e c1533e = (C1533e) obj;
            return (this.f3900a == c1533e.f3900a && this.f3901b == c1533e.f3901b) ? (this.ag == null || this.ag.m5892b()) ? c1533e.ag == null || c1533e.ag.m5892b() : this.ag.equals(c1533e.ag) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.f3900a) * 31) + this.f3901b) * 31;
            int hashCode2 = (this.ag == null || this.ag.m5892b()) ? 0 : this.ag.hashCode();
            return hashCode2 + hashCode;
        }
    }
}
