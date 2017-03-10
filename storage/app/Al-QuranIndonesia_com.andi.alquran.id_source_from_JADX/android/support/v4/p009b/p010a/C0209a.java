package android.support.v4.p009b.p010a;

import android.content.res.Resources;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.b.a.a */
public final class C0209a {
    private static final C0205a f545a;

    /* renamed from: android.support.v4.b.a.a.a */
    private interface C0205a {
        int m731a(Resources resources);

        int m732b(Resources resources);

        int m733c(Resources resources);
    }

    /* renamed from: android.support.v4.b.a.a.b */
    private static class C0206b implements C0205a {
        C0206b() {
        }

        public int m734a(Resources resources) {
            return C0210b.m743a(resources);
        }

        public int m735b(Resources resources) {
            return C0210b.m744b(resources);
        }

        public int m736c(Resources resources) {
            return C0210b.m745c(resources);
        }
    }

    /* renamed from: android.support.v4.b.a.a.c */
    private static class C0207c extends C0206b {
        C0207c() {
        }

        public int m737a(Resources resources) {
            return C0211c.m746a(resources);
        }

        public int m738b(Resources resources) {
            return C0211c.m747b(resources);
        }

        public int m739c(Resources resources) {
            return C0211c.m748c(resources);
        }
    }

    /* renamed from: android.support.v4.b.a.a.d */
    private static class C0208d extends C0207c {
        C0208d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f545a = new C0208d();
        } else if (i >= 13) {
            f545a = new C0207c();
        } else {
            f545a = new C0206b();
        }
    }

    public static int m740a(Resources resources) {
        return f545a.m731a(resources);
    }

    public static int m741b(Resources resources) {
        return f545a.m732b(resources);
    }

    public static int m742c(Resources resources) {
        return f545a.m733c(resources);
    }
}
