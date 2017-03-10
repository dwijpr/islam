package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class aw {
    static final C0460b f888a;

    /* renamed from: android.support.v4.view.aw.b */
    interface C0460b {
        void m1988a(ViewParent viewParent, View view);

        void m1989a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void m1990a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean m1991a(ViewParent viewParent, View view, float f, float f2);

        boolean m1992a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean m1993a(ViewParent viewParent, View view, View view2, int i);

        void m1994b(ViewParent viewParent, View view, View view2, int i);
    }

    /* renamed from: android.support.v4.view.aw.e */
    static class C0461e implements C0460b {
        C0461e() {
        }

        public void m1995a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0066x) {
                ((C0066x) viewParent).onStopNestedScroll(view);
            }
        }

        public void m1996a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0066x) {
                ((C0066x) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void m1997a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0066x) {
                ((C0066x) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean m1998a(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof C0066x ? ((C0066x) viewParent).onNestedPreFling(view, f, f2) : false;
        }

        public boolean m1999a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof C0066x ? ((C0066x) viewParent).onNestedFling(view, f, f2, z) : false;
        }

        public boolean m2000a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof C0066x ? ((C0066x) viewParent).onStartNestedScroll(view, view2, i) : false;
        }

        public void m2001b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0066x) {
                ((C0066x) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    /* renamed from: android.support.v4.view.aw.a */
    static class C0462a extends C0461e {
        C0462a() {
        }
    }

    /* renamed from: android.support.v4.view.aw.c */
    static class C0463c extends C0462a {
        C0463c() {
        }
    }

    /* renamed from: android.support.v4.view.aw.d */
    static class C0464d extends C0463c {
        C0464d() {
        }

        public void m2002a(ViewParent viewParent, View view) {
            ax.m2016a(viewParent, view);
        }

        public void m2003a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            ax.m2017a(viewParent, view, i, i2, i3, i4);
        }

        public void m2004a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            ax.m2018a(viewParent, view, i, i2, iArr);
        }

        public boolean m2005a(ViewParent viewParent, View view, float f, float f2) {
            return ax.m2019a(viewParent, view, f, f2);
        }

        public boolean m2006a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return ax.m2020a(viewParent, view, f, f2, z);
        }

        public boolean m2007a(ViewParent viewParent, View view, View view2, int i) {
            return ax.m2021a(viewParent, view, view2, i);
        }

        public void m2008b(ViewParent viewParent, View view, View view2, int i) {
            ax.m2022b(viewParent, view, view2, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f888a = new C0464d();
        } else if (i >= 19) {
            f888a = new C0463c();
        } else if (i >= 14) {
            f888a = new C0462a();
        } else {
            f888a = new C0461e();
        }
    }

    public static void m2009a(ViewParent viewParent, View view) {
        f888a.m1988a(viewParent, view);
    }

    public static void m2010a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f888a.m1989a(viewParent, view, i, i2, i3, i4);
    }

    public static void m2011a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f888a.m1990a(viewParent, view, i, i2, iArr);
    }

    public static boolean m2012a(ViewParent viewParent, View view, float f, float f2) {
        return f888a.m1991a(viewParent, view, f, f2);
    }

    public static boolean m2013a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f888a.m1992a(viewParent, view, f, f2, z);
    }

    public static boolean m2014a(ViewParent viewParent, View view, View view2, int i) {
        return f888a.m1993a(viewParent, view, view2, i);
    }

    public static void m2015b(ViewParent viewParent, View view, View view2, int i) {
        f888a.m1994b(viewParent, view, view2, i);
    }
}
