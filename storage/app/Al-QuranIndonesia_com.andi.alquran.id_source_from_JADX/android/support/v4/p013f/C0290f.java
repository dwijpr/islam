package android.support.v4.p013f;

import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.Locale;

/* renamed from: android.support.v4.f.f */
public final class C0290f {
    public static final C0283e f609a;
    public static final C0283e f610b;
    public static final C0283e f611c;
    public static final C0283e f612d;
    public static final C0283e f613e;
    public static final C0283e f614f;

    /* renamed from: android.support.v4.f.f.c */
    private interface C0284c {
        int m951a(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: android.support.v4.f.f.a */
    private static class C0285a implements C0284c {
        public static final C0285a f602a;
        public static final C0285a f603b;
        private final boolean f604c;

        static {
            f602a = new C0285a(true);
            f603b = new C0285a(false);
        }

        private C0285a(boolean z) {
            this.f604c = z;
        }

        public int m952a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 0;
            while (i < i3) {
                switch (C0290f.m959a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        if (!this.f604c) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                        if (this.f604c) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
                i++;
            }
            return i4 != 0 ? !this.f604c ? 0 : 1 : 2;
        }
    }

    /* renamed from: android.support.v4.f.f.b */
    private static class C0286b implements C0284c {
        public static final C0286b f605a;

        static {
            f605a = new C0286b();
        }

        private C0286b() {
        }

        public int m953a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = C0290f.m960b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* renamed from: android.support.v4.f.f.d */
    private static abstract class C0287d implements C0283e {
        private final C0284c f606a;

        public C0287d(C0284c c0284c) {
            this.f606a = c0284c;
        }

        private boolean m954b(CharSequence charSequence, int i, int i2) {
            switch (this.f606a.m951a(charSequence, i, i2)) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    return true;
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    return false;
                default:
                    return m955a();
            }
        }

        protected abstract boolean m955a();

        public boolean m956a(CharSequence charSequence, int i, int i2) {
            if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                return this.f606a == null ? m955a() : m954b(charSequence, i, i2);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /* renamed from: android.support.v4.f.f.e */
    private static class C0288e extends C0287d {
        private final boolean f607a;

        C0288e(C0284c c0284c, boolean z) {
            super(c0284c);
            this.f607a = z;
        }

        protected boolean m957a() {
            return this.f607a;
        }
    }

    /* renamed from: android.support.v4.f.f.f */
    private static class C0289f extends C0287d {
        public static final C0289f f608a;

        static {
            f608a = new C0289f();
        }

        public C0289f() {
            super(null);
        }

        protected boolean m958a() {
            return C0293g.m964a(Locale.getDefault()) == 1;
        }
    }

    static {
        f609a = new C0288e(null, false);
        f610b = new C0288e(null, true);
        f611c = new C0288e(C0286b.f605a, false);
        f612d = new C0288e(C0286b.f605a, true);
        f613e = new C0288e(C0285a.f602a, false);
        f614f = C0289f.f608a;
    }

    static int m959a(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return 1;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return 0;
            default:
                return 2;
        }
    }

    static int m960b(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
            case C1096c.MapAttrs_zOrderOnTop /*14*/:
            case C1096c.MapAttrs_uiMapToolbar /*15*/:
                return 1;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
            case C1096c.MapAttrs_ambientEnabled /*16*/:
            case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                return 0;
            default:
                return 2;
        }
    }
}
