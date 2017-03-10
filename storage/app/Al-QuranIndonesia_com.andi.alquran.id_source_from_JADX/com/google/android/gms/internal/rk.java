package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.math.BigInteger;
import java.util.Locale;

@op
public final class rk {
    private static final Object f5703a;
    private static String f5704b;

    static {
        f5703a = new Object();
    }

    public static String m8439a() {
        String str;
        synchronized (f5703a) {
            str = f5704b;
        }
        return str;
    }

    public static String m8440a(Context context, String str, String str2) {
        String str3;
        synchronized (f5703a) {
            if (f5704b == null && !TextUtils.isEmpty(str)) {
                m8441b(context, str, str2);
            }
            str3 = f5704b;
        }
        return str3;
    }

    private static void m8441b(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (zzv.zzcJ().m8527a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            f5704b = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            f5704b = NotificationCompatApi24.CATEGORY_ERROR;
        }
    }
}
