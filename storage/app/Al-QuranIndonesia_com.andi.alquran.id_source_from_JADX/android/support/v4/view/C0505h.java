package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;

/* renamed from: android.support.v4.view.h */
public final class C0505h {
    static final C0502c f944a;

    /* renamed from: android.support.v4.view.h.c */
    interface C0502c {
        boolean m2147a(int i, int i2);

        boolean m2148a(KeyEvent keyEvent);

        boolean m2149b(int i);
    }

    /* renamed from: android.support.v4.view.h.a */
    static class C0503a implements C0502c {
        C0503a() {
        }

        private static int m2150a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 == null) {
                return obj != null ? i & (i3 ^ -1) : i;
            } else {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            }
        }

        public int m2151a(int i) {
            int i2 = (i & 192) != 0 ? i | 1 : i;
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean m2152a(int i, int i2) {
            return C0503a.m2150a(C0503a.m2150a(m2151a(i) & 247, i2, 1, 64, NotificationCompat.FLAG_HIGH_PRIORITY), i2, 2, 16, 32) == i2;
        }

        public boolean m2153a(KeyEvent keyEvent) {
            return false;
        }

        public boolean m2154b(int i) {
            return (m2151a(i) & 247) == 0;
        }
    }

    /* renamed from: android.support.v4.view.h.b */
    static class C0504b extends C0503a {
        C0504b() {
        }

        public int m2155a(int i) {
            return C0506i.m2162a(i);
        }

        public boolean m2156a(int i, int i2) {
            return C0506i.m2163a(i, i2);
        }

        public boolean m2157a(KeyEvent keyEvent) {
            return C0506i.m2164a(keyEvent);
        }

        public boolean m2158b(int i) {
            return C0506i.m2165b(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f944a = new C0504b();
        } else {
            f944a = new C0503a();
        }
    }

    public static boolean m2159a(KeyEvent keyEvent) {
        return f944a.m2149b(keyEvent.getMetaState());
    }

    public static boolean m2160a(KeyEvent keyEvent, int i) {
        return f944a.m2147a(keyEvent.getMetaState(), i);
    }

    public static boolean m2161b(KeyEvent keyEvent) {
        return f944a.m2148a(keyEvent);
    }
}
