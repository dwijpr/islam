package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.C0861R;
import com.google.ads.AdSize;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;

public interface aw {

    /* renamed from: com.google.android.gms.internal.aw.a */
    public static final class C1450a extends ea<C1450a> {
        private static volatile C1450a[] f3502m;
        public int f3503a;
        public String f3504b;
        public C1450a[] f3505c;
        public C1450a[] f3506d;
        public C1450a[] f3507e;
        public String f3508f;
        public String f3509g;
        public long f3510h;
        public boolean f3511i;
        public C1450a[] f3512j;
        public int[] f3513k;
        public boolean f3514l;

        public C1450a() {
            m5221c();
        }

        public static C1450a[] m5216a() {
            if (f3502m == null) {
                synchronized (ee.f3857c) {
                    if (f3502m == null) {
                        f3502m = new C1450a[0];
                    }
                }
            }
            return f3502m;
        }

        public C1450a m5217a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                int b;
                Object obj;
                int i;
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiRotateGestures /*8*/:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                            case C1096c.MapAttrs_cameraZoom /*5*/:
                            case C1096c.MapAttrs_liteMode /*6*/:
                            case C1096c.MapAttrs_uiCompass /*7*/:
                            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                                this.f3503a = a;
                                break;
                            default:
                                continue;
                        }
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3504b = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.Toolbar_logoDescription /*26*/:
                        b = ej.m5925b(dyVar, 26);
                        a = this.f3505c == null ? 0 : this.f3505c.length;
                        obj = new C1450a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f3505c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1450a();
                            dyVar.m5777a(obj[a]);
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = new C1450a();
                        dyVar.m5777a(obj[a]);
                        this.f3505c = obj;
                        continue;
                    case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        b = ej.m5925b(dyVar, 34);
                        a = this.f3506d == null ? 0 : this.f3506d.length;
                        obj = new C1450a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f3506d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1450a();
                            dyVar.m5777a(obj[a]);
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = new C1450a();
                        dyVar.m5777a(obj[a]);
                        this.f3506d = obj;
                        continue;
                    case C0861R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        b = ej.m5925b(dyVar, 42);
                        a = this.f3507e == null ? 0 : this.f3507e.length;
                        obj = new C1450a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f3507e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1450a();
                            dyVar.m5777a(obj[a]);
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = new C1450a();
                        dyVar.m5777a(obj[a]);
                        this.f3507e = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.f3508f = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                        this.f3509g = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_editTextBackground /*64*/:
                        this.f3510h = dyVar.m5783d();
                        continue;
                    case C0861R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        this.f3514l = dyVar.m5788f();
                        continue;
                    case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        int b2 = ej.m5925b(dyVar, 80);
                        Object obj2 = new int[b2];
                        i = 0;
                        b = 0;
                        while (i < b2) {
                            if (i != 0) {
                                dyVar.m5775a();
                            }
                            int e = dyVar.m5785e();
                            switch (e) {
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
                                    a = b + 1;
                                    obj2[b] = e;
                                    break;
                                default:
                                    a = b;
                                    break;
                            }
                            i++;
                            b = a;
                        }
                        if (b != 0) {
                            a = this.f3513k == null ? 0 : this.f3513k.length;
                            if (a != 0 || b != obj2.length) {
                                Object obj3 = new int[(a + b)];
                                if (a != 0) {
                                    System.arraycopy(this.f3513k, 0, obj3, 0, a);
                                }
                                System.arraycopy(obj2, 0, obj3, a, b);
                                this.f3513k = obj3;
                                break;
                            }
                            this.f3513k = obj2;
                            break;
                        }
                        continue;
                    case C0861R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        i = dyVar.m5781c(dyVar.m5792j());
                        b = dyVar.m5798p();
                        a = 0;
                        while (dyVar.m5796n() > 0) {
                            switch (dyVar.m5785e()) {
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
                                    a++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (a != 0) {
                            dyVar.m5786e(b);
                            b = this.f3513k == null ? 0 : this.f3513k.length;
                            Object obj4 = new int[(a + b)];
                            if (b != 0) {
                                System.arraycopy(this.f3513k, 0, obj4, 0, b);
                            }
                            while (dyVar.m5796n() > 0) {
                                int e2 = dyVar.m5785e();
                                switch (e2) {
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
                                        a = b + 1;
                                        obj4[b] = e2;
                                        b = a;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.f3513k = obj4;
                        }
                        dyVar.m5784d(i);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        b = ej.m5925b(dyVar, 90);
                        a = this.f3512j == null ? 0 : this.f3512j.length;
                        obj = new C1450a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f3512j, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1450a();
                            dyVar.m5777a(obj[a]);
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = new C1450a();
                        dyVar.m5777a(obj[a]);
                        this.f3512j = obj;
                        continue;
                    case C0861R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                        this.f3511i = dyVar.m5788f();
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

        public void m5218a(dz dzVar) {
            int i = 0;
            dzVar.m5831a(1, this.f3503a);
            if (!(this.f3504b == null || this.f3504b.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(2, this.f3504b);
            }
            if (this.f3505c != null && this.f3505c.length > 0) {
                for (eg egVar : this.f3505c) {
                    if (egVar != null) {
                        dzVar.m5833a(3, egVar);
                    }
                }
            }
            if (this.f3506d != null && this.f3506d.length > 0) {
                for (eg egVar2 : this.f3506d) {
                    if (egVar2 != null) {
                        dzVar.m5833a(4, egVar2);
                    }
                }
            }
            if (this.f3507e != null && this.f3507e.length > 0) {
                for (eg egVar22 : this.f3507e) {
                    if (egVar22 != null) {
                        dzVar.m5833a(5, egVar22);
                    }
                }
            }
            if (!(this.f3508f == null || this.f3508f.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(6, this.f3508f);
            }
            if (!(this.f3509g == null || this.f3509g.equals(BuildConfig.VERSION_NAME))) {
                dzVar.m5834a(7, this.f3509g);
            }
            if (this.f3510h != 0) {
                dzVar.m5842b(8, this.f3510h);
            }
            if (this.f3514l) {
                dzVar.m5835a(9, this.f3514l);
            }
            if (this.f3513k != null && this.f3513k.length > 0) {
                for (int a : this.f3513k) {
                    dzVar.m5831a(10, a);
                }
            }
            if (this.f3512j != null && this.f3512j.length > 0) {
                while (i < this.f3512j.length) {
                    eg egVar3 = this.f3512j[i];
                    if (egVar3 != null) {
                        dzVar.m5833a(11, egVar3);
                    }
                    i++;
                }
            }
            if (this.f3511i) {
                dzVar.m5835a(12, this.f3511i);
            }
            super.m5172a(dzVar);
        }

        protected int m5219b() {
            int i;
            int i2 = 0;
            int b = super.m5174b() + dz.m5807b(1, this.f3503a);
            if (!(this.f3504b == null || this.f3504b.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(2, this.f3504b);
            }
            if (this.f3505c != null && this.f3505c.length > 0) {
                i = b;
                for (eg egVar : this.f3505c) {
                    if (egVar != null) {
                        i += dz.m5814c(3, egVar);
                    }
                }
                b = i;
            }
            if (this.f3506d != null && this.f3506d.length > 0) {
                i = b;
                for (eg egVar2 : this.f3506d) {
                    if (egVar2 != null) {
                        i += dz.m5814c(4, egVar2);
                    }
                }
                b = i;
            }
            if (this.f3507e != null && this.f3507e.length > 0) {
                i = b;
                for (eg egVar22 : this.f3507e) {
                    if (egVar22 != null) {
                        i += dz.m5814c(5, egVar22);
                    }
                }
                b = i;
            }
            if (!(this.f3508f == null || this.f3508f.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(6, this.f3508f);
            }
            if (!(this.f3509g == null || this.f3509g.equals(BuildConfig.VERSION_NAME))) {
                b += dz.m5809b(7, this.f3509g);
            }
            if (this.f3510h != 0) {
                b += dz.m5821e(8, this.f3510h);
            }
            if (this.f3514l) {
                b += dz.m5810b(9, this.f3514l);
            }
            if (this.f3513k != null && this.f3513k.length > 0) {
                int i3 = 0;
                for (int b2 : this.f3513k) {
                    i3 += dz.m5806b(b2);
                }
                b = (b + i3) + (this.f3513k.length * 1);
            }
            if (this.f3512j != null && this.f3512j.length > 0) {
                while (i2 < this.f3512j.length) {
                    eg egVar3 = this.f3512j[i2];
                    if (egVar3 != null) {
                        b += dz.m5814c(11, egVar3);
                    }
                    i2++;
                }
            }
            return this.f3511i ? b + dz.m5810b(12, this.f3511i) : b;
        }

        public /* synthetic */ eg m5220b(dy dyVar) {
            return m5217a(dyVar);
        }

        public C1450a m5221c() {
            this.f3503a = 1;
            this.f3504b = BuildConfig.VERSION_NAME;
            this.f3505c = C1450a.m5216a();
            this.f3506d = C1450a.m5216a();
            this.f3507e = C1450a.m5216a();
            this.f3508f = BuildConfig.VERSION_NAME;
            this.f3509g = BuildConfig.VERSION_NAME;
            this.f3510h = 0;
            this.f3511i = false;
            this.f3512j = C1450a.m5216a();
            this.f3513k = ej.f3860a;
            this.f3514l = false;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1450a)) {
                return false;
            }
            C1450a c1450a = (C1450a) obj;
            if (this.f3503a != c1450a.f3503a) {
                return false;
            }
            if (this.f3504b == null) {
                if (c1450a.f3504b != null) {
                    return false;
                }
            } else if (!this.f3504b.equals(c1450a.f3504b)) {
                return false;
            }
            if (!ee.m5904a(this.f3505c, c1450a.f3505c) || !ee.m5904a(this.f3506d, c1450a.f3506d) || !ee.m5904a(this.f3507e, c1450a.f3507e)) {
                return false;
            }
            if (this.f3508f == null) {
                if (c1450a.f3508f != null) {
                    return false;
                }
            } else if (!this.f3508f.equals(c1450a.f3508f)) {
                return false;
            }
            if (this.f3509g == null) {
                if (c1450a.f3509g != null) {
                    return false;
                }
            } else if (!this.f3509g.equals(c1450a.f3509g)) {
                return false;
            }
            return (this.f3510h == c1450a.f3510h && this.f3511i == c1450a.f3511i && ee.m5904a(this.f3512j, c1450a.f3512j) && ee.m5903a(this.f3513k, c1450a.f3513k) && this.f3514l == c1450a.f3514l) ? (this.ag == null || this.ag.m5892b()) ? c1450a.ag == null || c1450a.ag.m5892b() : this.ag.equals(c1450a.ag) : false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.f3511i ? 1231 : 1237) + (((((this.f3509g == null ? 0 : this.f3509g.hashCode()) + (((this.f3508f == null ? 0 : this.f3508f.hashCode()) + (((((((((this.f3504b == null ? 0 : this.f3504b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f3503a) * 31)) * 31) + ee.m5900a(this.f3505c)) * 31) + ee.m5900a(this.f3506d)) * 31) + ee.m5900a(this.f3507e)) * 31)) * 31)) * 31) + ((int) (this.f3510h ^ (this.f3510h >>> 32)))) * 31)) * 31) + ee.m5900a(this.f3512j)) * 31) + ee.m5899a(this.f3513k)) * 31;
            if (!this.f3514l) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.ag == null || this.ag.m5892b())) {
                i2 = this.ag.hashCode();
            }
            return hashCode + i2;
        }
    }
}
