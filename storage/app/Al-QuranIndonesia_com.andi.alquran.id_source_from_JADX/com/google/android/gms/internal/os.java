package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.C1380f;
import com.google.android.gms.internal.ot.C1886a;
import com.google.android.gms.internal.ot.C1887b;

@op
public final class os {

    /* renamed from: com.google.android.gms.internal.os.a */
    public interface C1881a {
        void m7943a(zzmk com_google_android_gms_internal_zzmk);
    }

    /* renamed from: com.google.android.gms.internal.os.b */
    interface C1882b {
        boolean m7953a(zzqa com_google_android_gms_internal_zzqa);
    }

    /* renamed from: com.google.android.gms.internal.os.1 */
    class C18831 implements C1882b {
        final /* synthetic */ Context f5281a;

        C18831(Context context) {
            this.f5281a = context;
        }

        public boolean m7954a(zzqa com_google_android_gms_internal_zzqa) {
            return com_google_android_gms_internal_zzqa.f6639e || (C1380f.m4944c(this.f5281a) && !((Boolean) C1648if.f4352P.m6682c()).booleanValue());
        }
    }

    private static rs m7955a(Context context, sq<zzmh> sqVar, C1881a c1881a) {
        sg.m8444b("Fetching ad response from local ad request service.");
        rs c1886a = new C1886a(context, sqVar, c1881a);
        c1886a.zziw();
        return c1886a;
    }

    public static rs m7956a(Context context, zzqa com_google_android_gms_internal_zzqa, sq<zzmh> sqVar, C1881a c1881a) {
        return m7957a(context, com_google_android_gms_internal_zzqa, sqVar, c1881a, new C18831(context));
    }

    static rs m7957a(Context context, zzqa com_google_android_gms_internal_zzqa, sq<zzmh> sqVar, C1881a c1881a, C1882b c1882b) {
        return c1882b.m7953a(com_google_android_gms_internal_zzqa) ? m7955a(context, sqVar, c1881a) : m7958b(context, com_google_android_gms_internal_zzqa, sqVar, c1881a);
    }

    private static rs m7958b(Context context, zzqa com_google_android_gms_internal_zzqa, sq<zzmh> sqVar, C1881a c1881a) {
        sg.m8444b("Fetching ad response from remote ad request service.");
        if (gr.m6416a().m8705b(context)) {
            return new C1887b(context, com_google_android_gms_internal_zzqa, sqVar, c1881a);
        }
        sg.m8449e("Failed to connect to remote ad request service.");
        return null;
    }
}
