package com.google.android.gms.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import com.google.android.gms.internal.C2078x.C1490c;
import com.google.android.gms.internal.C2078x.C2077b;
import com.google.android.gms.location.C0779d;
import com.google.android.gms.location.C1493n;
import com.google.android.gms.location.C1493n.C1494a;
import com.google.android.gms.location.C1497o;
import com.google.android.gms.location.C1497o.C1498a;
import com.google.android.gms.location.C2086c;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import java.util.HashMap;
import java.util.Map;

public class bv {
    private final cb<bt> f3633a;
    private final Context f3634b;
    private ContentProviderClient f3635c;
    private boolean f3636d;
    private final Map<C2077b<C0779d>, C1499b> f3637e;
    private final Map<C2077b<C2086c>, C1495a> f3638f;

    /* renamed from: com.google.android.gms.internal.bv.a */
    private static class C1495a extends C1494a {
        private final C2078x<C2086c> f3630a;

        /* renamed from: com.google.android.gms.internal.bv.a.1 */
        class C14911 implements C1490c<C2086c> {
            final /* synthetic */ LocationResult f3628a;

            C14911(C1495a c1495a, LocationResult locationResult) {
                this.f3628a = locationResult;
            }

            public void m5423a() {
            }

            public void m5424a(C2086c c2086c) {
                c2086c.m9828a(this.f3628a);
            }

            public /* synthetic */ void m5425a(Object obj) {
                m5424a((C2086c) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.bv.a.2 */
        class C14922 implements C1490c<C2086c> {
            final /* synthetic */ LocationAvailability f3629a;

            C14922(C1495a c1495a, LocationAvailability locationAvailability) {
                this.f3629a = locationAvailability;
            }

            public void m5426a() {
            }

            public void m5427a(C2086c c2086c) {
                c2086c.m9827a(this.f3629a);
            }

            public /* synthetic */ void m5428a(Object obj) {
                m5427a((C2086c) obj);
            }
        }

        public void m5432a(LocationAvailability locationAvailability) {
            this.f3630a.m9699a(new C14922(this, locationAvailability));
        }

        public void m5433a(LocationResult locationResult) {
            this.f3630a.m9699a(new C14911(this, locationResult));
        }
    }

    /* renamed from: com.google.android.gms.internal.bv.b */
    private static class C1499b extends C1498a {
        private final C2078x<C0779d> f3632a;

        /* renamed from: com.google.android.gms.internal.bv.b.1 */
        class C14961 implements C1490c<C0779d> {
            final /* synthetic */ Location f3631a;

            C14961(C1499b c1499b, Location location) {
                this.f3631a = location;
            }

            public void m5434a() {
            }

            public void m5435a(C0779d c0779d) {
                c0779d.m2645a(this.f3631a);
            }

            public /* synthetic */ void m5436a(Object obj) {
                m5435a((C0779d) obj);
            }
        }

        C1499b(C2078x<C0779d> c2078x) {
            this.f3632a = c2078x;
        }

        public synchronized void m5439a(Location location) {
            this.f3632a.m9699a(new C14961(this, location));
        }
    }

    public bv(Context context, cb<bt> cbVar) {
        this.f3635c = null;
        this.f3636d = false;
        this.f3637e = new HashMap();
        this.f3638f = new HashMap();
        this.f3634b = context;
        this.f3633a = cbVar;
    }

    private C1499b m5440a(C2078x<C0779d> c2078x) {
        C1499b c1499b;
        synchronized (this.f3637e) {
            c1499b = (C1499b) this.f3637e.get(c2078x.m9700b());
            if (c1499b == null) {
                c1499b = new C1499b(c2078x);
            }
            this.f3637e.put(c2078x.m9700b(), c1499b);
        }
        return c1499b;
    }

    public Location m5441a() {
        this.f3633a.m5303a();
        try {
            return ((bt) this.f3633a.m5304c()).m5374b(this.f3634b.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m5442a(LocationRequest locationRequest, C2078x<C0779d> c2078x, br brVar) {
        this.f3633a.m5303a();
        ((bt) this.f3633a.m5304c()).m5360a(zzarx.m9730a(zzarv.m9727a(locationRequest), m5440a((C2078x) c2078x), brVar));
    }

    public void m5443a(boolean z) {
        this.f3633a.m5303a();
        ((bt) this.f3633a.m5304c()).m5372a(z);
        this.f3636d = z;
    }

    public void m5444b() {
        try {
            synchronized (this.f3637e) {
                for (C1497o c1497o : this.f3637e.values()) {
                    if (c1497o != null) {
                        ((bt) this.f3633a.m5304c()).m5360a(zzarx.m9732a(c1497o, null));
                    }
                }
                this.f3637e.clear();
            }
            synchronized (this.f3638f) {
                for (C1493n c1493n : this.f3638f.values()) {
                    if (c1493n != null) {
                        ((bt) this.f3633a.m5304c()).m5360a(zzarx.m9731a(c1493n, null));
                    }
                }
                this.f3638f.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m5445c() {
        if (this.f3636d) {
            try {
                m5443a(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
