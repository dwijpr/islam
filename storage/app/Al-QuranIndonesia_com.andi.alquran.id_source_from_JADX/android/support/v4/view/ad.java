package android.support.v4.view;

import android.content.Context;
import android.support.v4.p007e.C0265c;

public final class ad {
    static final C0435c f872a;
    private Object f873b;

    /* renamed from: android.support.v4.view.ad.c */
    interface C0435c {
        Object m1634a(Context context, int i);
    }

    /* renamed from: android.support.v4.view.ad.b */
    static class C0436b implements C0435c {
        C0436b() {
        }

        public Object m1635a(Context context, int i) {
            return null;
        }
    }

    /* renamed from: android.support.v4.view.ad.a */
    static class C0437a extends C0436b {
        C0437a() {
        }

        public Object m1636a(Context context, int i) {
            return ae.m1639a(context, i);
        }
    }

    static {
        if (C0265c.m909a()) {
            f872a = new C0437a();
        } else {
            f872a = new C0436b();
        }
    }

    private ad(Object obj) {
        this.f873b = obj;
    }

    public static ad m1637a(Context context, int i) {
        return new ad(f872a.m1634a(context, i));
    }

    public Object m1638a() {
        return this.f873b;
    }
}
