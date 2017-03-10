package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1240a.C1241a;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1270g;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1338k;

public final class ck {
    public static final C1270g<ct> f3681a;
    public static final C1270g<ct> f3682b;
    public static final C1266b<ct, cm> f3683c;
    static final C1266b<ct, C1510a> f3684d;
    public static final Scope f3685e;
    public static final Scope f3686f;
    public static final C1274a<cm> f3687g;
    public static final C1274a<C1510a> f3688h;

    /* renamed from: com.google.android.gms.internal.ck.1 */
    class C15081 extends C1266b<ct, cm> {
        C15081() {
        }

        public ct m5549a(Context context, Looper looper, C1338k c1338k, cm cmVar, C0777b c0777b, C0778c c0778c) {
            return new ct(context, looper, true, c1338k, cmVar == null ? cm.f3689a : cmVar, c0777b, c0778c);
        }
    }

    /* renamed from: com.google.android.gms.internal.ck.2 */
    class C15092 extends C1266b<ct, C1510a> {
        C15092() {
        }

        public ct m5551a(Context context, Looper looper, C1338k c1338k, C1510a c1510a, C0777b c0777b, C0778c c0778c) {
            return new ct(context, looper, false, c1338k, c1510a.m5552a(), c0777b, c0778c);
        }
    }

    /* renamed from: com.google.android.gms.internal.ck.a */
    public static class C1510a implements C1241a {
        private final Bundle f3680a;

        public Bundle m5552a() {
            return this.f3680a;
        }
    }

    static {
        f3681a = new C1270g();
        f3682b = new C1270g();
        f3683c = new C15081();
        f3684d = new C15092();
        f3685e = new Scope("profile");
        f3686f = new Scope(NotificationCompatApi24.CATEGORY_EMAIL);
        f3687g = new C1274a("SignIn.API", f3683c, f3681a);
        f3688h = new C1274a("SignIn.INTERNAL_API", f3684d, f3682b);
    }
}
