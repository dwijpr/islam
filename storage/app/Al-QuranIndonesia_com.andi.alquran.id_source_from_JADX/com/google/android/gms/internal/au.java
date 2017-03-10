package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.andi.alquran.C0861R;
import com.google.ads.AdSize;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;

public interface au {

    /* renamed from: com.google.android.gms.internal.au.a */
    public static final class C1444a extends ea<C1444a> {
        public Long f3379A;
        public String f3380B;
        public Long f3381C;
        public Long f3382D;
        public Long f3383E;
        public C1445b f3384F;
        public Long f3385G;
        public Long f3386H;
        public Long f3387I;
        public Long f3388J;
        public Long f3389K;
        public Long f3390L;
        public String f3391M;
        public String f3392N;
        public Integer f3393O;
        public Integer f3394P;
        public Long f3395Q;
        public Long f3396R;
        public Long f3397S;
        public Long f3398T;
        public Long f3399U;
        public Integer f3400V;
        public C1442a f3401W;
        public C1442a[] f3402X;
        public C1443b f3403Y;
        public Long f3404Z;
        public String f3405a;
        public String aa;
        public Integer ab;
        public Boolean ac;
        public String ad;
        public Long ae;
        public C1448e af;
        public String f3406b;
        public Long f3407c;
        public Long f3408d;
        public Long f3409e;
        public Long f3410f;
        public Long f3411g;
        public Long f3412h;
        public Long f3413i;
        public Long f3414j;
        public Long f3415k;
        public Long f3416l;
        public String f3417m;
        public Long f3418n;
        public Long f3419o;
        public Long f3420p;
        public Long f3421q;
        public Long f3422r;
        public Long f3423s;
        public Long f3424t;
        public Long f3425u;
        public Long f3426v;
        public String f3427w;
        public String f3428x;
        public Long f3429y;
        public Long f3430z;

        /* renamed from: com.google.android.gms.internal.au.a.a */
        public static final class C1442a extends ea<C1442a> {
            private static volatile C1442a[] f3363m;
            public Long f3364a;
            public Long f3365b;
            public Long f3366c;
            public Long f3367d;
            public Long f3368e;
            public Long f3369f;
            public Integer f3370g;
            public Long f3371h;
            public Long f3372i;
            public Long f3373j;
            public Integer f3374k;
            public Long f3375l;

            public C1442a() {
                this.f3364a = null;
                this.f3365b = null;
                this.f3366c = null;
                this.f3367d = null;
                this.f3368e = null;
                this.f3369f = null;
                this.f3370g = null;
                this.f3371h = null;
                this.f3372i = null;
                this.f3373j = null;
                this.f3374k = null;
                this.f3375l = null;
                this.ah = -1;
            }

            public static C1442a[] m5181a() {
                if (f3363m == null) {
                    synchronized (ee.f3857c) {
                        if (f3363m == null) {
                            f3363m = new C1442a[0];
                        }
                    }
                }
                return f3363m;
            }

            public C1442a m5182a(dy dyVar) {
                while (true) {
                    int a = dyVar.m5775a();
                    switch (a) {
                        case GoogleMap.MAP_TYPE_NONE /*0*/:
                            break;
                        case C1096c.MapAttrs_uiRotateGestures /*8*/:
                            this.f3364a = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C1096c.MapAttrs_ambientEnabled /*16*/:
                            this.f3365b = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C0861R.styleable.Toolbar_navigationIcon /*24*/:
                            this.f3366c = Long.valueOf(dyVar.m5783d());
                            continue;
                        case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                            this.f3367d = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C0861R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                            this.f3368e = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C0861R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                            this.f3369f = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C0861R.styleable.AppCompatTheme_dividerVertical /*56*/:
                            a = dyVar.m5785e();
                            switch (a) {
                                case GoogleMap.MAP_TYPE_NONE /*0*/:
                                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                                case 1000:
                                    this.f3370g = Integer.valueOf(a);
                                    break;
                                default:
                                    continue;
                            }
                        case C0861R.styleable.AppCompatTheme_editTextBackground /*64*/:
                            this.f3371h = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C0861R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                            this.f3372i = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                            this.f3373j = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C0861R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
                            a = dyVar.m5785e();
                            switch (a) {
                                case GoogleMap.MAP_TYPE_NONE /*0*/:
                                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                                case 1000:
                                    this.f3374k = Integer.valueOf(a);
                                    break;
                                default:
                                    continue;
                            }
                        case C0861R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                            this.f3375l = Long.valueOf(dyVar.m5783d());
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

            public void m5183a(dz dzVar) {
                if (this.f3364a != null) {
                    dzVar.m5842b(1, this.f3364a.longValue());
                }
                if (this.f3365b != null) {
                    dzVar.m5842b(2, this.f3365b.longValue());
                }
                if (this.f3366c != null) {
                    dzVar.m5842b(3, this.f3366c.longValue());
                }
                if (this.f3367d != null) {
                    dzVar.m5842b(4, this.f3367d.longValue());
                }
                if (this.f3368e != null) {
                    dzVar.m5842b(5, this.f3368e.longValue());
                }
                if (this.f3369f != null) {
                    dzVar.m5842b(6, this.f3369f.longValue());
                }
                if (this.f3370g != null) {
                    dzVar.m5831a(7, this.f3370g.intValue());
                }
                if (this.f3371h != null) {
                    dzVar.m5842b(8, this.f3371h.longValue());
                }
                if (this.f3372i != null) {
                    dzVar.m5842b(9, this.f3372i.longValue());
                }
                if (this.f3373j != null) {
                    dzVar.m5842b(10, this.f3373j.longValue());
                }
                if (this.f3374k != null) {
                    dzVar.m5831a(11, this.f3374k.intValue());
                }
                if (this.f3375l != null) {
                    dzVar.m5842b(12, this.f3375l.longValue());
                }
                super.m5172a(dzVar);
            }

            protected int m5184b() {
                int b = super.m5174b();
                if (this.f3364a != null) {
                    b += dz.m5821e(1, this.f3364a.longValue());
                }
                if (this.f3365b != null) {
                    b += dz.m5821e(2, this.f3365b.longValue());
                }
                if (this.f3366c != null) {
                    b += dz.m5821e(3, this.f3366c.longValue());
                }
                if (this.f3367d != null) {
                    b += dz.m5821e(4, this.f3367d.longValue());
                }
                if (this.f3368e != null) {
                    b += dz.m5821e(5, this.f3368e.longValue());
                }
                if (this.f3369f != null) {
                    b += dz.m5821e(6, this.f3369f.longValue());
                }
                if (this.f3370g != null) {
                    b += dz.m5807b(7, this.f3370g.intValue());
                }
                if (this.f3371h != null) {
                    b += dz.m5821e(8, this.f3371h.longValue());
                }
                if (this.f3372i != null) {
                    b += dz.m5821e(9, this.f3372i.longValue());
                }
                if (this.f3373j != null) {
                    b += dz.m5821e(10, this.f3373j.longValue());
                }
                if (this.f3374k != null) {
                    b += dz.m5807b(11, this.f3374k.intValue());
                }
                return this.f3375l != null ? b + dz.m5821e(12, this.f3375l.longValue()) : b;
            }

            public /* synthetic */ eg m5185b(dy dyVar) {
                return m5182a(dyVar);
            }
        }

        /* renamed from: com.google.android.gms.internal.au.a.b */
        public static final class C1443b extends ea<C1443b> {
            public Long f3376a;
            public Long f3377b;
            public Long f3378c;

            public C1443b() {
                this.f3376a = null;
                this.f3377b = null;
                this.f3378c = null;
                this.ah = -1;
            }

            public C1443b m5186a(dy dyVar) {
                while (true) {
                    int a = dyVar.m5775a();
                    switch (a) {
                        case GoogleMap.MAP_TYPE_NONE /*0*/:
                            break;
                        case C1096c.MapAttrs_uiRotateGestures /*8*/:
                            this.f3376a = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C1096c.MapAttrs_ambientEnabled /*16*/:
                            this.f3377b = Long.valueOf(dyVar.m5783d());
                            continue;
                        case C0861R.styleable.Toolbar_navigationIcon /*24*/:
                            this.f3378c = Long.valueOf(dyVar.m5783d());
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

            public void m5187a(dz dzVar) {
                if (this.f3376a != null) {
                    dzVar.m5842b(1, this.f3376a.longValue());
                }
                if (this.f3377b != null) {
                    dzVar.m5842b(2, this.f3377b.longValue());
                }
                if (this.f3378c != null) {
                    dzVar.m5842b(3, this.f3378c.longValue());
                }
                super.m5172a(dzVar);
            }

            protected int m5188b() {
                int b = super.m5174b();
                if (this.f3376a != null) {
                    b += dz.m5821e(1, this.f3376a.longValue());
                }
                if (this.f3377b != null) {
                    b += dz.m5821e(2, this.f3377b.longValue());
                }
                return this.f3378c != null ? b + dz.m5821e(3, this.f3378c.longValue()) : b;
            }

            public /* synthetic */ eg m5189b(dy dyVar) {
                return m5186a(dyVar);
            }
        }

        public C1444a() {
            this.f3405a = null;
            this.f3406b = null;
            this.f3407c = null;
            this.f3408d = null;
            this.f3409e = null;
            this.f3410f = null;
            this.f3411g = null;
            this.f3412h = null;
            this.f3413i = null;
            this.f3414j = null;
            this.f3415k = null;
            this.f3416l = null;
            this.f3417m = null;
            this.f3418n = null;
            this.f3419o = null;
            this.f3420p = null;
            this.f3421q = null;
            this.f3422r = null;
            this.f3423s = null;
            this.f3424t = null;
            this.f3425u = null;
            this.f3426v = null;
            this.f3427w = null;
            this.f3428x = null;
            this.f3429y = null;
            this.f3430z = null;
            this.f3379A = null;
            this.f3380B = null;
            this.f3381C = null;
            this.f3382D = null;
            this.f3383E = null;
            this.f3385G = null;
            this.f3386H = null;
            this.f3387I = null;
            this.f3388J = null;
            this.f3389K = null;
            this.f3390L = null;
            this.f3391M = null;
            this.f3392N = null;
            this.f3393O = null;
            this.f3394P = null;
            this.f3395Q = null;
            this.f3396R = null;
            this.f3397S = null;
            this.f3398T = null;
            this.f3399U = null;
            this.f3400V = null;
            this.f3402X = C1442a.m5181a();
            this.f3404Z = null;
            this.aa = null;
            this.ab = null;
            this.ac = null;
            this.ad = null;
            this.ae = null;
            this.ah = -1;
        }

        public static C1444a m5190a(byte[] bArr) {
            return (C1444a) eg.m5146a(new C1444a(), bArr);
        }

        public C1444a m5191a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        this.f3405a = dyVar.m5789g();
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3406b = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.Toolbar_navigationIcon /*24*/:
                        this.f3407c = Long.valueOf(dyVar.m5783d());
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.f3408d = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.f3409e = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        this.f3410f = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_dividerVertical /*56*/:
                        this.f3411g = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_editTextBackground /*64*/:
                        this.f3412h = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        this.f3413i = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                        this.f3414j = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
                        this.f3415k = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_alertDialogTheme /*96*/:
                        this.f3416l = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_editTextStyle /*106*/:
                        this.f3417m = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_spinnerStyle /*112*/:
                        this.f3418n = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 120:
                        this.f3419o = Long.valueOf(dyVar.m5783d());
                        continue;
                    case NotificationCompat.FLAG_HIGH_PRIORITY /*128*/:
                        this.f3420p = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 136:
                        this.f3421q = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 144:
                        this.f3422r = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 152:
                        this.f3423s = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 160:
                        this.f3424t = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 168:
                        this.f3404Z = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 176:
                        this.f3425u = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 184:
                        this.f3426v = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 194:
                        this.aa = dyVar.m5789g();
                        continue;
                    case Callback.DEFAULT_DRAG_ANIMATION_DURATION /*200*/:
                        this.ae = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 208:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                            case C1096c.MapAttrs_cameraZoom /*5*/:
                            case C1096c.MapAttrs_liteMode /*6*/:
                                this.ab = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 218:
                        this.f3427w = dyVar.m5789g();
                        continue;
                    case 224:
                        this.ac = Boolean.valueOf(dyVar.m5788f());
                        continue;
                    case 234:
                        this.f3428x = dyVar.m5789g();
                        continue;
                    case 242:
                        this.ad = dyVar.m5789g();
                        continue;
                    case 248:
                        this.f3429y = Long.valueOf(dyVar.m5783d());
                        continue;
                    case NotificationCompat.FLAG_LOCAL_ONLY /*256*/:
                        this.f3430z = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 264:
                        this.f3379A = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 274:
                        this.f3380B = dyVar.m5789g();
                        continue;
                    case 280:
                        this.f3381C = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 288:
                        this.f3382D = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 296:
                        this.f3383E = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 306:
                        if (this.f3384F == null) {
                            this.f3384F = new C1445b();
                        }
                        dyVar.m5777a(this.f3384F);
                        continue;
                    case 312:
                        this.f3385G = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 320:
                        this.f3386H = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 328:
                        this.f3387I = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 336:
                        this.f3388J = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 346:
                        int b = ej.m5925b(dyVar, 346);
                        a = this.f3402X == null ? 0 : this.f3402X.length;
                        Object obj = new C1442a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f3402X, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1442a();
                            dyVar.m5777a(obj[a]);
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = new C1442a();
                        dyVar.m5777a(obj[a]);
                        this.f3402X = obj;
                        continue;
                    case 352:
                        this.f3389K = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 360:
                        this.f3390L = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 370:
                        this.f3391M = dyVar.m5789g();
                        continue;
                    case 378:
                        this.f3392N = dyVar.m5789g();
                        continue;
                    case 384:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            case 1000:
                                this.f3393O = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 392:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            case 1000:
                                this.f3394P = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 402:
                        if (this.f3401W == null) {
                            this.f3401W = new C1442a();
                        }
                        dyVar.m5777a(this.f3401W);
                        continue;
                    case 408:
                        this.f3395Q = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 416:
                        this.f3396R = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 424:
                        this.f3397S = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 432:
                        this.f3398T = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 440:
                        this.f3399U = Long.valueOf(dyVar.m5783d());
                        continue;
                    case 448:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            case 1000:
                                this.f3400V = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 458:
                        if (this.f3403Y == null) {
                            this.f3403Y = new C1443b();
                        }
                        dyVar.m5777a(this.f3403Y);
                        continue;
                    case 1610:
                        if (this.af == null) {
                            this.af = new C1448e();
                        }
                        dyVar.m5777a(this.af);
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

        public void m5192a(dz dzVar) {
            if (this.f3405a != null) {
                dzVar.m5834a(1, this.f3405a);
            }
            if (this.f3406b != null) {
                dzVar.m5834a(2, this.f3406b);
            }
            if (this.f3407c != null) {
                dzVar.m5842b(3, this.f3407c.longValue());
            }
            if (this.f3408d != null) {
                dzVar.m5842b(4, this.f3408d.longValue());
            }
            if (this.f3409e != null) {
                dzVar.m5842b(5, this.f3409e.longValue());
            }
            if (this.f3410f != null) {
                dzVar.m5842b(6, this.f3410f.longValue());
            }
            if (this.f3411g != null) {
                dzVar.m5842b(7, this.f3411g.longValue());
            }
            if (this.f3412h != null) {
                dzVar.m5842b(8, this.f3412h.longValue());
            }
            if (this.f3413i != null) {
                dzVar.m5842b(9, this.f3413i.longValue());
            }
            if (this.f3414j != null) {
                dzVar.m5842b(10, this.f3414j.longValue());
            }
            if (this.f3415k != null) {
                dzVar.m5842b(11, this.f3415k.longValue());
            }
            if (this.f3416l != null) {
                dzVar.m5842b(12, this.f3416l.longValue());
            }
            if (this.f3417m != null) {
                dzVar.m5834a(13, this.f3417m);
            }
            if (this.f3418n != null) {
                dzVar.m5842b(14, this.f3418n.longValue());
            }
            if (this.f3419o != null) {
                dzVar.m5842b(15, this.f3419o.longValue());
            }
            if (this.f3420p != null) {
                dzVar.m5842b(16, this.f3420p.longValue());
            }
            if (this.f3421q != null) {
                dzVar.m5842b(17, this.f3421q.longValue());
            }
            if (this.f3422r != null) {
                dzVar.m5842b(18, this.f3422r.longValue());
            }
            if (this.f3423s != null) {
                dzVar.m5842b(19, this.f3423s.longValue());
            }
            if (this.f3424t != null) {
                dzVar.m5842b(20, this.f3424t.longValue());
            }
            if (this.f3404Z != null) {
                dzVar.m5842b(21, this.f3404Z.longValue());
            }
            if (this.f3425u != null) {
                dzVar.m5842b(22, this.f3425u.longValue());
            }
            if (this.f3426v != null) {
                dzVar.m5842b(23, this.f3426v.longValue());
            }
            if (this.aa != null) {
                dzVar.m5834a(24, this.aa);
            }
            if (this.ae != null) {
                dzVar.m5842b(25, this.ae.longValue());
            }
            if (this.ab != null) {
                dzVar.m5831a(26, this.ab.intValue());
            }
            if (this.f3427w != null) {
                dzVar.m5834a(27, this.f3427w);
            }
            if (this.ac != null) {
                dzVar.m5835a(28, this.ac.booleanValue());
            }
            if (this.f3428x != null) {
                dzVar.m5834a(29, this.f3428x);
            }
            if (this.ad != null) {
                dzVar.m5834a(30, this.ad);
            }
            if (this.f3429y != null) {
                dzVar.m5842b(31, this.f3429y.longValue());
            }
            if (this.f3430z != null) {
                dzVar.m5842b(32, this.f3430z.longValue());
            }
            if (this.f3379A != null) {
                dzVar.m5842b(33, this.f3379A.longValue());
            }
            if (this.f3380B != null) {
                dzVar.m5834a(34, this.f3380B);
            }
            if (this.f3381C != null) {
                dzVar.m5842b(35, this.f3381C.longValue());
            }
            if (this.f3382D != null) {
                dzVar.m5842b(36, this.f3382D.longValue());
            }
            if (this.f3383E != null) {
                dzVar.m5842b(37, this.f3383E.longValue());
            }
            if (this.f3384F != null) {
                dzVar.m5833a(38, this.f3384F);
            }
            if (this.f3385G != null) {
                dzVar.m5842b(39, this.f3385G.longValue());
            }
            if (this.f3386H != null) {
                dzVar.m5842b(40, this.f3386H.longValue());
            }
            if (this.f3387I != null) {
                dzVar.m5842b(41, this.f3387I.longValue());
            }
            if (this.f3388J != null) {
                dzVar.m5842b(42, this.f3388J.longValue());
            }
            if (this.f3402X != null && this.f3402X.length > 0) {
                for (eg egVar : this.f3402X) {
                    if (egVar != null) {
                        dzVar.m5833a(43, egVar);
                    }
                }
            }
            if (this.f3389K != null) {
                dzVar.m5842b(44, this.f3389K.longValue());
            }
            if (this.f3390L != null) {
                dzVar.m5842b(45, this.f3390L.longValue());
            }
            if (this.f3391M != null) {
                dzVar.m5834a(46, this.f3391M);
            }
            if (this.f3392N != null) {
                dzVar.m5834a(47, this.f3392N);
            }
            if (this.f3393O != null) {
                dzVar.m5831a(48, this.f3393O.intValue());
            }
            if (this.f3394P != null) {
                dzVar.m5831a(49, this.f3394P.intValue());
            }
            if (this.f3401W != null) {
                dzVar.m5833a(50, this.f3401W);
            }
            if (this.f3395Q != null) {
                dzVar.m5842b(51, this.f3395Q.longValue());
            }
            if (this.f3396R != null) {
                dzVar.m5842b(52, this.f3396R.longValue());
            }
            if (this.f3397S != null) {
                dzVar.m5842b(53, this.f3397S.longValue());
            }
            if (this.f3398T != null) {
                dzVar.m5842b(54, this.f3398T.longValue());
            }
            if (this.f3399U != null) {
                dzVar.m5842b(55, this.f3399U.longValue());
            }
            if (this.f3400V != null) {
                dzVar.m5831a(56, this.f3400V.intValue());
            }
            if (this.f3403Y != null) {
                dzVar.m5833a(57, this.f3403Y);
            }
            if (this.af != null) {
                dzVar.m5833a(201, this.af);
            }
            super.m5172a(dzVar);
        }

        protected int m5193b() {
            int b = super.m5174b();
            if (this.f3405a != null) {
                b += dz.m5809b(1, this.f3405a);
            }
            if (this.f3406b != null) {
                b += dz.m5809b(2, this.f3406b);
            }
            if (this.f3407c != null) {
                b += dz.m5821e(3, this.f3407c.longValue());
            }
            if (this.f3408d != null) {
                b += dz.m5821e(4, this.f3408d.longValue());
            }
            if (this.f3409e != null) {
                b += dz.m5821e(5, this.f3409e.longValue());
            }
            if (this.f3410f != null) {
                b += dz.m5821e(6, this.f3410f.longValue());
            }
            if (this.f3411g != null) {
                b += dz.m5821e(7, this.f3411g.longValue());
            }
            if (this.f3412h != null) {
                b += dz.m5821e(8, this.f3412h.longValue());
            }
            if (this.f3413i != null) {
                b += dz.m5821e(9, this.f3413i.longValue());
            }
            if (this.f3414j != null) {
                b += dz.m5821e(10, this.f3414j.longValue());
            }
            if (this.f3415k != null) {
                b += dz.m5821e(11, this.f3415k.longValue());
            }
            if (this.f3416l != null) {
                b += dz.m5821e(12, this.f3416l.longValue());
            }
            if (this.f3417m != null) {
                b += dz.m5809b(13, this.f3417m);
            }
            if (this.f3418n != null) {
                b += dz.m5821e(14, this.f3418n.longValue());
            }
            if (this.f3419o != null) {
                b += dz.m5821e(15, this.f3419o.longValue());
            }
            if (this.f3420p != null) {
                b += dz.m5821e(16, this.f3420p.longValue());
            }
            if (this.f3421q != null) {
                b += dz.m5821e(17, this.f3421q.longValue());
            }
            if (this.f3422r != null) {
                b += dz.m5821e(18, this.f3422r.longValue());
            }
            if (this.f3423s != null) {
                b += dz.m5821e(19, this.f3423s.longValue());
            }
            if (this.f3424t != null) {
                b += dz.m5821e(20, this.f3424t.longValue());
            }
            if (this.f3404Z != null) {
                b += dz.m5821e(21, this.f3404Z.longValue());
            }
            if (this.f3425u != null) {
                b += dz.m5821e(22, this.f3425u.longValue());
            }
            if (this.f3426v != null) {
                b += dz.m5821e(23, this.f3426v.longValue());
            }
            if (this.aa != null) {
                b += dz.m5809b(24, this.aa);
            }
            if (this.ae != null) {
                b += dz.m5821e(25, this.ae.longValue());
            }
            if (this.ab != null) {
                b += dz.m5807b(26, this.ab.intValue());
            }
            if (this.f3427w != null) {
                b += dz.m5809b(27, this.f3427w);
            }
            if (this.ac != null) {
                b += dz.m5810b(28, this.ac.booleanValue());
            }
            if (this.f3428x != null) {
                b += dz.m5809b(29, this.f3428x);
            }
            if (this.ad != null) {
                b += dz.m5809b(30, this.ad);
            }
            if (this.f3429y != null) {
                b += dz.m5821e(31, this.f3429y.longValue());
            }
            if (this.f3430z != null) {
                b += dz.m5821e(32, this.f3430z.longValue());
            }
            if (this.f3379A != null) {
                b += dz.m5821e(33, this.f3379A.longValue());
            }
            if (this.f3380B != null) {
                b += dz.m5809b(34, this.f3380B);
            }
            if (this.f3381C != null) {
                b += dz.m5821e(35, this.f3381C.longValue());
            }
            if (this.f3382D != null) {
                b += dz.m5821e(36, this.f3382D.longValue());
            }
            if (this.f3383E != null) {
                b += dz.m5821e(37, this.f3383E.longValue());
            }
            if (this.f3384F != null) {
                b += dz.m5814c(38, this.f3384F);
            }
            if (this.f3385G != null) {
                b += dz.m5821e(39, this.f3385G.longValue());
            }
            if (this.f3386H != null) {
                b += dz.m5821e(40, this.f3386H.longValue());
            }
            if (this.f3387I != null) {
                b += dz.m5821e(41, this.f3387I.longValue());
            }
            if (this.f3388J != null) {
                b += dz.m5821e(42, this.f3388J.longValue());
            }
            if (this.f3402X != null && this.f3402X.length > 0) {
                int i = b;
                for (eg egVar : this.f3402X) {
                    if (egVar != null) {
                        i += dz.m5814c(43, egVar);
                    }
                }
                b = i;
            }
            if (this.f3389K != null) {
                b += dz.m5821e(44, this.f3389K.longValue());
            }
            if (this.f3390L != null) {
                b += dz.m5821e(45, this.f3390L.longValue());
            }
            if (this.f3391M != null) {
                b += dz.m5809b(46, this.f3391M);
            }
            if (this.f3392N != null) {
                b += dz.m5809b(47, this.f3392N);
            }
            if (this.f3393O != null) {
                b += dz.m5807b(48, this.f3393O.intValue());
            }
            if (this.f3394P != null) {
                b += dz.m5807b(49, this.f3394P.intValue());
            }
            if (this.f3401W != null) {
                b += dz.m5814c(50, this.f3401W);
            }
            if (this.f3395Q != null) {
                b += dz.m5821e(51, this.f3395Q.longValue());
            }
            if (this.f3396R != null) {
                b += dz.m5821e(52, this.f3396R.longValue());
            }
            if (this.f3397S != null) {
                b += dz.m5821e(53, this.f3397S.longValue());
            }
            if (this.f3398T != null) {
                b += dz.m5821e(54, this.f3398T.longValue());
            }
            if (this.f3399U != null) {
                b += dz.m5821e(55, this.f3399U.longValue());
            }
            if (this.f3400V != null) {
                b += dz.m5807b(56, this.f3400V.intValue());
            }
            if (this.f3403Y != null) {
                b += dz.m5814c(57, this.f3403Y);
            }
            return this.af != null ? b + dz.m5814c(201, this.af) : b;
        }

        public /* synthetic */ eg m5194b(dy dyVar) {
            return m5191a(dyVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.au.b */
    public static final class C1445b extends ea<C1445b> {
        public Long f3431a;
        public Integer f3432b;
        public Boolean f3433c;
        public int[] f3434d;
        public Long f3435e;

        public C1445b() {
            this.f3431a = null;
            this.f3432b = null;
            this.f3433c = null;
            this.f3434d = ej.f3860a;
            this.f3435e = null;
            this.ah = -1;
        }

        public C1445b m5195a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                int b;
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiRotateGestures /*8*/:
                        this.f3431a = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C1096c.MapAttrs_ambientEnabled /*16*/:
                        this.f3432b = Integer.valueOf(dyVar.m5785e());
                        continue;
                    case C0861R.styleable.Toolbar_navigationIcon /*24*/:
                        this.f3433c = Boolean.valueOf(dyVar.m5788f());
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        b = ej.m5925b(dyVar, 32);
                        a = this.f3434d == null ? 0 : this.f3434d.length;
                        Object obj = new int[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f3434d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = dyVar.m5785e();
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = dyVar.m5785e();
                        this.f3434d = obj;
                        continue;
                    case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        int c = dyVar.m5781c(dyVar.m5792j());
                        b = dyVar.m5798p();
                        a = 0;
                        while (dyVar.m5796n() > 0) {
                            dyVar.m5785e();
                            a++;
                        }
                        dyVar.m5786e(b);
                        b = this.f3434d == null ? 0 : this.f3434d.length;
                        Object obj2 = new int[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f3434d, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = dyVar.m5785e();
                            b++;
                        }
                        this.f3434d = obj2;
                        dyVar.m5784d(c);
                        continue;
                    case C0861R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.f3435e = Long.valueOf(dyVar.m5782c());
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

        public void m5196a(dz dzVar) {
            if (this.f3431a != null) {
                dzVar.m5842b(1, this.f3431a.longValue());
            }
            if (this.f3432b != null) {
                dzVar.m5831a(2, this.f3432b.intValue());
            }
            if (this.f3433c != null) {
                dzVar.m5835a(3, this.f3433c.booleanValue());
            }
            if (this.f3434d != null && this.f3434d.length > 0) {
                for (int a : this.f3434d) {
                    dzVar.m5831a(4, a);
                }
            }
            if (this.f3435e != null) {
                dzVar.m5832a(5, this.f3435e.longValue());
            }
            super.m5172a(dzVar);
        }

        protected int m5197b() {
            int i = 0;
            int b = super.m5174b();
            if (this.f3431a != null) {
                b += dz.m5821e(1, this.f3431a.longValue());
            }
            if (this.f3432b != null) {
                b += dz.m5807b(2, this.f3432b.intValue());
            }
            if (this.f3433c != null) {
                b += dz.m5810b(3, this.f3433c.booleanValue());
            }
            if (this.f3434d != null && this.f3434d.length > 0) {
                int i2 = 0;
                while (i < this.f3434d.length) {
                    i2 += dz.m5806b(this.f3434d[i]);
                    i++;
                }
                b = (b + i2) + (this.f3434d.length * 1);
            }
            return this.f3435e != null ? b + dz.m5818d(5, this.f3435e.longValue()) : b;
        }

        public /* synthetic */ eg m5198b(dy dyVar) {
            return m5195a(dyVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.au.c */
    public static final class C1446c extends ea<C1446c> {
        public byte[] f3436a;
        public byte[] f3437b;

        public C1446c() {
            this.f3436a = null;
            this.f3437b = null;
            this.ah = -1;
        }

        public C1446c m5199a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        this.f3436a = dyVar.m5790h();
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3437b = dyVar.m5790h();
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

        public void m5200a(dz dzVar) {
            if (this.f3436a != null) {
                dzVar.m5836a(1, this.f3436a);
            }
            if (this.f3437b != null) {
                dzVar.m5836a(2, this.f3437b);
            }
            super.m5172a(dzVar);
        }

        protected int m5201b() {
            int b = super.m5174b();
            if (this.f3436a != null) {
                b += dz.m5811b(1, this.f3436a);
            }
            return this.f3437b != null ? b + dz.m5811b(2, this.f3437b) : b;
        }

        public /* synthetic */ eg m5202b(dy dyVar) {
            return m5199a(dyVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.au.d */
    public static final class C1447d extends ea<C1447d> {
        public byte[] f3438a;
        public byte[] f3439b;
        public byte[] f3440c;
        public byte[] f3441d;

        public C1447d() {
            this.f3438a = null;
            this.f3439b = null;
            this.f3440c = null;
            this.f3441d = null;
            this.ah = -1;
        }

        public static C1447d m5203a(byte[] bArr) {
            return (C1447d) eg.m5146a(new C1447d(), bArr);
        }

        public C1447d m5204a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        this.f3438a = dyVar.m5790h();
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3439b = dyVar.m5790h();
                        continue;
                    case C0861R.styleable.Toolbar_logoDescription /*26*/:
                        this.f3440c = dyVar.m5790h();
                        continue;
                    case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.f3441d = dyVar.m5790h();
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

        public void m5205a(dz dzVar) {
            if (this.f3438a != null) {
                dzVar.m5836a(1, this.f3438a);
            }
            if (this.f3439b != null) {
                dzVar.m5836a(2, this.f3439b);
            }
            if (this.f3440c != null) {
                dzVar.m5836a(3, this.f3440c);
            }
            if (this.f3441d != null) {
                dzVar.m5836a(4, this.f3441d);
            }
            super.m5172a(dzVar);
        }

        protected int m5206b() {
            int b = super.m5174b();
            if (this.f3438a != null) {
                b += dz.m5811b(1, this.f3438a);
            }
            if (this.f3439b != null) {
                b += dz.m5811b(2, this.f3439b);
            }
            if (this.f3440c != null) {
                b += dz.m5811b(3, this.f3440c);
            }
            return this.f3441d != null ? b + dz.m5811b(4, this.f3441d) : b;
        }

        public /* synthetic */ eg m5207b(dy dyVar) {
            return m5204a(dyVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.au.e */
    public static final class C1448e extends ea<C1448e> {
        public Long f3442a;
        public String f3443b;
        public byte[] f3444c;

        public C1448e() {
            this.f3442a = null;
            this.f3443b = null;
            this.f3444c = null;
            this.ah = -1;
        }

        public C1448e m5208a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiRotateGestures /*8*/:
                        this.f3442a = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.Toolbar_logoDescription /*26*/:
                        this.f3443b = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.f3444c = dyVar.m5790h();
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

        public void m5209a(dz dzVar) {
            if (this.f3442a != null) {
                dzVar.m5842b(1, this.f3442a.longValue());
            }
            if (this.f3443b != null) {
                dzVar.m5834a(3, this.f3443b);
            }
            if (this.f3444c != null) {
                dzVar.m5836a(4, this.f3444c);
            }
            super.m5172a(dzVar);
        }

        protected int m5210b() {
            int b = super.m5174b();
            if (this.f3442a != null) {
                b += dz.m5821e(1, this.f3442a.longValue());
            }
            if (this.f3443b != null) {
                b += dz.m5809b(3, this.f3443b);
            }
            return this.f3444c != null ? b + dz.m5811b(4, this.f3444c) : b;
        }

        public /* synthetic */ eg m5211b(dy dyVar) {
            return m5208a(dyVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.au.f */
    public static final class C1449f extends ea<C1449f> {
        public byte[][] f3445a;
        public byte[] f3446b;
        public Integer f3447c;
        public Integer f3448d;

        public C1449f() {
            this.f3445a = ej.f3866g;
            this.f3446b = null;
            this.f3447c = null;
            this.f3448d = null;
            this.ah = -1;
        }

        public C1449f m5212a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        int b = ej.m5925b(dyVar, 10);
                        a = this.f3445a == null ? 0 : this.f3445a.length;
                        Object obj = new byte[(b + a)][];
                        if (a != 0) {
                            System.arraycopy(this.f3445a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = dyVar.m5790h();
                            dyVar.m5775a();
                            a++;
                        }
                        obj[a] = dyVar.m5790h();
                        this.f3445a = obj;
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3446b = dyVar.m5790h();
                        continue;
                    case C0861R.styleable.Toolbar_navigationIcon /*24*/:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                                this.f3447c = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                                this.f3448d = Integer.valueOf(a);
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

        public void m5213a(dz dzVar) {
            if (this.f3445a != null && this.f3445a.length > 0) {
                for (byte[] bArr : this.f3445a) {
                    if (bArr != null) {
                        dzVar.m5836a(1, bArr);
                    }
                }
            }
            if (this.f3446b != null) {
                dzVar.m5836a(2, this.f3446b);
            }
            if (this.f3447c != null) {
                dzVar.m5831a(3, this.f3447c.intValue());
            }
            if (this.f3448d != null) {
                dzVar.m5831a(4, this.f3448d.intValue());
            }
            super.m5172a(dzVar);
        }

        protected int m5214b() {
            int i = 0;
            int b = super.m5174b();
            if (this.f3445a == null || this.f3445a.length <= 0) {
                i = b;
            } else {
                int i2 = 0;
                int i3 = 0;
                while (i < this.f3445a.length) {
                    byte[] bArr = this.f3445a[i];
                    if (bArr != null) {
                        i3++;
                        i2 += dz.m5816c(bArr);
                    }
                    i++;
                }
                i = (b + i2) + (i3 * 1);
            }
            if (this.f3446b != null) {
                i += dz.m5811b(2, this.f3446b);
            }
            if (this.f3447c != null) {
                i += dz.m5807b(3, this.f3447c.intValue());
            }
            return this.f3448d != null ? i + dz.m5807b(4, this.f3448d.intValue()) : i;
        }

        public /* synthetic */ eg m5215b(dy dyVar) {
            return m5212a(dyVar);
        }
    }
}
