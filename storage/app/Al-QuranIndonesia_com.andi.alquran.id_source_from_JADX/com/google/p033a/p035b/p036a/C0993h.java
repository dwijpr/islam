package com.google.p033a.p035b.p036a;

import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.p035b.C1042g;
import com.google.p033a.p037d.C0984a;
import com.google.p033a.p037d.C0987c;
import com.google.p033a.p037d.C1063b;
import com.google.p033a.p038c.C1061a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.a.b.a.h */
public final class C0993h extends C0976r<Object> {
    public static final C0974s f2031a;
    private final C1073e f2032b;

    /* renamed from: com.google.a.b.a.h.1 */
    static class C09911 implements C0974s {
        C09911() {
        }

        public <T> C0976r<T> m3530a(C1073e c1073e, C1061a<T> c1061a) {
            return c1061a.m3772a() == Object.class ? new C0993h(null) : null;
        }
    }

    /* renamed from: com.google.a.b.a.h.2 */
    static /* synthetic */ class C09922 {
        static final /* synthetic */ int[] f2030a;

        static {
            f2030a = new int[C1063b.values().length];
            try {
                f2030a[C1063b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2030a[C1063b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2030a[C1063b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2030a[C1063b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2030a[C1063b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2030a[C1063b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    static {
        f2031a = new C09911();
    }

    private C0993h(C1073e c1073e) {
        this.f2032b = c1073e;
    }

    public void m3531a(C0987c c0987c, Object obj) {
        if (obj == null) {
            c0987c.m3505f();
            return;
        }
        C0976r a = this.f2032b.m3799a(obj.getClass());
        if (a instanceof C0993h) {
            c0987c.m3502d();
            c0987c.m3504e();
            return;
        }
        a.m3405a(c0987c, obj);
    }

    public Object m3532b(C0984a c0984a) {
        switch (C09922.f2030a[c0984a.m3453f().ordinal()]) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                List arrayList = new ArrayList();
                c0984a.m3447a();
                while (c0984a.m3452e()) {
                    arrayList.add(m3532b(c0984a));
                }
                c0984a.m3449b();
                return arrayList;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                Map c1042g = new C1042g();
                c0984a.m3450c();
                while (c0984a.m3452e()) {
                    c1042g.put(c0984a.m3454g(), m3532b(c0984a));
                }
                c0984a.m3451d();
                return c1042g;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return c0984a.m3455h();
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return Double.valueOf(c0984a.m3458k());
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return Boolean.valueOf(c0984a.m3456i());
            case C1096c.MapAttrs_liteMode /*6*/:
                c0984a.m3457j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
