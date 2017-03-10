package android.support.v4.p013f;

import android.os.Build.VERSION;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.maps.GoogleMap;
import java.util.Locale;

/* renamed from: android.support.v4.f.g */
public final class C0293g {
    public static final Locale f615a;
    static String f616b;
    static String f617c;
    private static final C0291a f618d;

    /* renamed from: android.support.v4.f.g.a */
    private static class C0291a {
        C0291a() {
        }

        private static int m961b(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    return 1;
                default:
                    return 0;
            }
        }

        public int m962a(Locale locale) {
            if (!(locale == null || locale.equals(C0293g.f615a))) {
                String a = C0280b.m945a(locale);
                if (a == null) {
                    return C0291a.m961b(locale);
                }
                if (a.equalsIgnoreCase(C0293g.f616b) || a.equalsIgnoreCase(C0293g.f617c)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    /* renamed from: android.support.v4.f.g.b */
    private static class C0292b extends C0291a {
        C0292b() {
        }

        public int m963a(Locale locale) {
            return C0294h.m965a(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f618d = new C0292b();
        } else {
            f618d = new C0291a();
        }
        f615a = new Locale(BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME);
        f616b = "Arab";
        f617c = "Hebr";
    }

    public static int m964a(Locale locale) {
        return f618d.m962a(locale);
    }
}
