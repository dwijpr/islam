package com.google.android.gms.internal;

import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;

public interface at {

    /* renamed from: com.google.android.gms.internal.at.a */
    public static final class C1441a extends ea<C1441a> {
        public String f3353a;
        public Long f3354b;
        public String f3355c;
        public String f3356d;
        public String f3357e;
        public Long f3358f;
        public Long f3359g;
        public String f3360h;
        public Long f3361i;
        public String f3362j;

        public C1441a() {
            this.f3353a = null;
            this.f3354b = null;
            this.f3355c = null;
            this.f3356d = null;
            this.f3357e = null;
            this.f3358f = null;
            this.f3359g = null;
            this.f3360h = null;
            this.f3361i = null;
            this.f3362j = null;
            this.ah = -1;
        }

        public C1441a m5177a(dy dyVar) {
            while (true) {
                int a = dyVar.m5775a();
                switch (a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        break;
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                        this.f3353a = dyVar.m5789g();
                        continue;
                    case C1096c.MapAttrs_ambientEnabled /*16*/:
                        this.f3354b = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.Toolbar_logoDescription /*26*/:
                        this.f3355c = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.f3356d = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.f3357e = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        this.f3358f = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_dividerVertical /*56*/:
                        this.f3359g = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                        this.f3360h = dyVar.m5789g();
                        continue;
                    case C0861R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                        this.f3361i = Long.valueOf(dyVar.m5783d());
                        continue;
                    case C0861R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                        this.f3362j = dyVar.m5789g();
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

        public void m5178a(dz dzVar) {
            if (this.f3353a != null) {
                dzVar.m5834a(1, this.f3353a);
            }
            if (this.f3354b != null) {
                dzVar.m5842b(2, this.f3354b.longValue());
            }
            if (this.f3355c != null) {
                dzVar.m5834a(3, this.f3355c);
            }
            if (this.f3356d != null) {
                dzVar.m5834a(4, this.f3356d);
            }
            if (this.f3357e != null) {
                dzVar.m5834a(5, this.f3357e);
            }
            if (this.f3358f != null) {
                dzVar.m5842b(6, this.f3358f.longValue());
            }
            if (this.f3359g != null) {
                dzVar.m5842b(7, this.f3359g.longValue());
            }
            if (this.f3360h != null) {
                dzVar.m5834a(8, this.f3360h);
            }
            if (this.f3361i != null) {
                dzVar.m5842b(9, this.f3361i.longValue());
            }
            if (this.f3362j != null) {
                dzVar.m5834a(10, this.f3362j);
            }
            super.m5172a(dzVar);
        }

        protected int m5179b() {
            int b = super.m5174b();
            if (this.f3353a != null) {
                b += dz.m5809b(1, this.f3353a);
            }
            if (this.f3354b != null) {
                b += dz.m5821e(2, this.f3354b.longValue());
            }
            if (this.f3355c != null) {
                b += dz.m5809b(3, this.f3355c);
            }
            if (this.f3356d != null) {
                b += dz.m5809b(4, this.f3356d);
            }
            if (this.f3357e != null) {
                b += dz.m5809b(5, this.f3357e);
            }
            if (this.f3358f != null) {
                b += dz.m5821e(6, this.f3358f.longValue());
            }
            if (this.f3359g != null) {
                b += dz.m5821e(7, this.f3359g.longValue());
            }
            if (this.f3360h != null) {
                b += dz.m5809b(8, this.f3360h);
            }
            if (this.f3361i != null) {
                b += dz.m5821e(9, this.f3361i.longValue());
            }
            return this.f3362j != null ? b + dz.m5809b(10, this.f3362j) : b;
        }

        public /* synthetic */ eg m5180b(dy dyVar) {
            return m5177a(dyVar);
        }
    }
}
