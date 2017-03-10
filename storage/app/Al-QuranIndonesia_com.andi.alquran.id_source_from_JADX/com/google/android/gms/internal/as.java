package com.google.android.gms.internal;

import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;

public interface as {

    /* renamed from: com.google.android.gms.internal.as.a */
    public static final class C1438a extends eg {
        public C1439b f3345a;
        public C1440c f3346b;

        public C1438a() {
            m5157a();
        }

        public static C1438a m5156a(byte[] bArr) {
            return (C1438a) eg.m5146a(new C1438a(), bArr);
        }

        public C1438a m5157a() {
            this.f3345a = null;
            this.f3346b = null;
            this.ah = -1;
            return this;
        }

        public C1438a m5158a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        if (this.f3345a == null) {
                            this.f3345a = new C1439b();
                        }
                        dyVar.m5777a(this.f3345a);
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        if (this.f3346b == null) {
                            this.f3346b = new C1440c();
                        }
                        dyVar.m5777a(this.f3346b);
                        continue;
                    default:
                        if (!ej.m5923a(dyVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m5159a(dz dzVar) {
            if (this.f3345a != null) {
                dzVar.m5833a(1, this.f3345a);
            }
            if (this.f3346b != null) {
                dzVar.m5833a(2, this.f3346b);
            }
            super.m5150a(dzVar);
        }

        protected int m5160b() {
            int b = super.m5151b();
            if (this.f3345a != null) {
                b += dz.m5814c(1, this.f3345a);
            }
            return this.f3346b != null ? b + dz.m5814c(2, this.f3346b) : b;
        }

        public /* synthetic */ eg m5161b(dy dyVar) {
            return m5158a(dyVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.as.b */
    public static final class C1439b extends eg {
        public Integer f3347a;

        public C1439b() {
            m5162a();
        }

        public C1439b m5162a() {
            this.ah = -1;
            return this;
        }

        public C1439b m5163a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case 216:
                        a = dyVar.m5785e();
                        switch (a) {
                            case GoogleMap.MAP_TYPE_NONE /*0*/:
                            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                                this.f3347a = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!ej.m5923a(dyVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m5164a(dz dzVar) {
            if (this.f3347a != null) {
                dzVar.m5831a(27, this.f3347a.intValue());
            }
            super.m5150a(dzVar);
        }

        protected int m5165b() {
            int b = super.m5151b();
            return this.f3347a != null ? b + dz.m5807b(27, this.f3347a.intValue()) : b;
        }

        public /* synthetic */ eg m5166b(dy dyVar) {
            return m5163a(dyVar);
        }
    }

    /* renamed from: com.google.android.gms.internal.as.c */
    public static final class C1440c extends eg {
        public String f3348a;
        public String f3349b;
        public String f3350c;
        public String f3351d;
        public String f3352e;

        public C1440c() {
            m5167a();
        }

        public C1440c m5167a() {
            this.f3348a = null;
            this.f3349b = null;
            this.f3350c = null;
            this.f3351d = null;
            this.f3352e = null;
            this.ah = -1;
            return this;
        }

        public C1440c m5168a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        this.f3348a = dyVar.m5789g();
                        continue;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        this.f3349b = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.Toolbar_logoDescription /*26*/:
                        this.f3350c = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.f3351d = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.f3352e = dyVar.m5789g();
                        continue;
                    default:
                        if (!ej.m5923a(dyVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m5169a(dz dzVar) {
            if (this.f3348a != null) {
                dzVar.m5834a(1, this.f3348a);
            }
            if (this.f3349b != null) {
                dzVar.m5834a(2, this.f3349b);
            }
            if (this.f3350c != null) {
                dzVar.m5834a(3, this.f3350c);
            }
            if (this.f3351d != null) {
                dzVar.m5834a(4, this.f3351d);
            }
            if (this.f3352e != null) {
                dzVar.m5834a(5, this.f3352e);
            }
            super.m5150a(dzVar);
        }

        protected int m5170b() {
            int b = super.m5151b();
            if (this.f3348a != null) {
                b += dz.m5809b(1, this.f3348a);
            }
            if (this.f3349b != null) {
                b += dz.m5809b(2, this.f3349b);
            }
            if (this.f3350c != null) {
                b += dz.m5809b(3, this.f3350c);
            }
            if (this.f3351d != null) {
                b += dz.m5809b(4, this.f3351d);
            }
            return this.f3352e != null ? b + dz.m5809b(5, this.f3352e) : b;
        }

        public /* synthetic */ eg m5171b(dy dyVar) {
            return m5168a(dyVar);
        }
    }
}
