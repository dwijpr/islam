package android.support.v4.p013f;

import android.annotation.TargetApi;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
/* renamed from: android.support.v4.f.d */
class C0282d {
    private static Method f600a;
    private static Method f601b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f600a = cls.getMethod("getScript", new Class[]{String.class});
                f601b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f600a = null;
            f601b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    private static String m947a(String str) {
        try {
            if (f600a != null) {
                return (String) f600a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String m948a(Locale locale) {
        String b = C0282d.m949b(locale);
        return b != null ? C0282d.m947a(b) : null;
    }

    private static String m949b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f601b != null) {
                return (String) f601b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
