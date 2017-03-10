package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.be;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.b */
public class C1422b {
    private static SharedPreferences f3270a;

    /* renamed from: com.google.android.gms.flags.impl.b.1 */
    class C14211 implements Callable<SharedPreferences> {
        final /* synthetic */ Context f3269a;

        C14211(Context context) {
            this.f3269a = context;
        }

        public SharedPreferences m5038a() {
            return this.f3269a.getSharedPreferences("google_sdk_flags", 1);
        }

        public /* synthetic */ Object call() {
            return m5038a();
        }
    }

    static {
        f3270a = null;
    }

    public static SharedPreferences m5039a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f3270a == null) {
                f3270a = (SharedPreferences) be.m5265a(new C14211(context));
            }
            sharedPreferences = f3270a;
        }
        return sharedPreferences;
    }
}
