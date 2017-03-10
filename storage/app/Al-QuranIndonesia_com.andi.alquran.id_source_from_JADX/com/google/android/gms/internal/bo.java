package com.google.android.gms.internal;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1279d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.br.C1479a;
import com.google.android.gms.internal.wm.C1474b;
import com.google.android.gms.location.C0779d;
import com.google.android.gms.location.C1481a;
import com.google.android.gms.location.C2088e;
import com.google.android.gms.location.C2088e.C1476a;
import com.google.android.gms.location.LocationRequest;

public class bo implements C1481a {

    /* renamed from: com.google.android.gms.internal.bo.a */
    private static abstract class C1477a extends C1476a<Status> {
        public C1477a(C1277c c1277c) {
            super(c1277c);
        }

        public Status m5325a(Status status) {
            return status;
        }

        public /* synthetic */ C1263g m5326b(Status status) {
            return m5325a(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.bo.1 */
    class C14781 extends C1477a {
        final /* synthetic */ LocationRequest f3621a;
        final /* synthetic */ C0779d f3622b;

        C14781(bo boVar, C1277c c1277c, LocationRequest locationRequest, C0779d c0779d) {
            this.f3621a = locationRequest;
            this.f3622b = c0779d;
            super(c1277c);
        }

        protected void m5328a(bw bwVar) {
            bwVar.m5447a(this.f3621a, C2079z.m9702a(this.f3622b, cd.m5523a(), C0779d.class.getSimpleName()), new C1480b(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.bo.b */
    private static class C1480b extends C1479a {
        private final C1474b<Status> f3623a;

        public C1480b(C1474b<Status> c1474b) {
            this.f3623a = c1474b;
        }

        public void m5331a(zzarm com_google_android_gms_internal_zzarm) {
            this.f3623a.m5317a(com_google_android_gms_internal_zzarm.m9726b());
        }
    }

    public Location m5334a(C1277c c1277c) {
        try {
            return C2088e.m9831a(c1277c).m5448k();
        } catch (Exception e) {
            return null;
        }
    }

    public C1279d<Status> m5335a(C1277c c1277c, LocationRequest locationRequest, C0779d c0779d) {
        C1314c.m4624a(Looper.myLooper(), (Object) "Calling thread must be a prepared Looper thread.");
        return c1277c.m4541a(new C14781(this, c1277c, locationRequest, c0779d));
    }
}
