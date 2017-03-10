package android.support.v4.p008a;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v4.a.a */
public final class C0158a {
    private static final C0160c f522a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f522a = new C0169f();
        } else {
            f522a = new C0165e();
        }
    }

    public static C0163g m689a() {
        return f522a.m691a();
    }

    public static void m690a(View view) {
        f522a.m692a(view);
    }
}
