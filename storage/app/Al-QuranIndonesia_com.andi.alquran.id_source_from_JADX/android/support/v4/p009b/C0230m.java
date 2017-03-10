package android.support.v4.p009b;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.b.m */
public final class C0230m {
    public static Executor m788a() {
        return VERSION.SDK_INT >= 11 ? C0220h.m766a() : C0229l.f556a;
    }
}
