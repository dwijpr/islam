package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1240a.C1264b;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1274a.C1270g;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.internal.bo;
import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.bw;
import com.google.android.gms.internal.cc;
import com.google.android.gms.internal.wm.C1475a;

/* renamed from: com.google.android.gms.location.e */
public class C2088e {
    public static final C1274a<C1264b> f6702a;
    public static final C1481a f6703b;
    public static final C1482b f6704c;
    public static final C1506f f6705d;
    private static final C1270g<bw> f6706e;
    private static final C1266b<bw, C1264b> f6707f;

    /* renamed from: com.google.android.gms.location.e.a */
    public static abstract class C1476a<R extends C1263g> extends C1475a<R, bw> {
        public C1476a(C1277c c1277c) {
            super(C2088e.f6702a, c1277c);
        }
    }

    /* renamed from: com.google.android.gms.location.e.1 */
    class C20871 extends C1266b<bw, C1264b> {
        C20871() {
        }

        public /* synthetic */ C1269f m9829a(Context context, Looper looper, C1338k c1338k, Object obj, C0777b c0777b, C0778c c0778c) {
            return m9830a(context, looper, c1338k, (C1264b) obj, c0777b, c0778c);
        }

        public bw m9830a(Context context, Looper looper, C1338k c1338k, C1264b c1264b, C0777b c0777b, C0778c c0778c) {
            return new bw(context, looper, c0777b, c0778c, "locationServices", c1338k);
        }
    }

    static {
        f6706e = new C1270g();
        f6707f = new C20871();
        f6702a = new C1274a("LocationServices.API", f6707f, f6706e);
        f6703b = new bo();
        f6704c = new bq();
        f6705d = new cc();
    }

    public static bw m9831a(C1277c c1277c) {
        boolean z = true;
        C1314c.m4633b(c1277c != null, "GoogleApiClient parameter is required.");
        bw bwVar = (bw) c1277c.m4540a(f6706e);
        if (bwVar == null) {
            z = false;
        }
        C1314c.m4629a(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return bwVar;
    }
}
