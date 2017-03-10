package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.internal.C1308t;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1317j.C1329f;
import com.google.android.gms.common.internal.C1338k;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.common.api.a */
public final class C1274a<O extends C1240a> {
    private final C1266b<?, O> f2986a;
    private final C1272i<?, O> f2987b;
    private final C1270g<?> f2988c;
    private final C1273j<?> f2989d;
    private final String f2990e;

    /* renamed from: com.google.android.gms.common.api.a.a */
    public interface C1240a {

        /* renamed from: com.google.android.gms.common.api.a.a.a */
        public interface C1241a extends C1240a {
        }

        /* renamed from: com.google.android.gms.common.api.a.a.c */
        public interface C1242c extends C1240a {
        }

        /* renamed from: com.google.android.gms.common.api.a.a.d */
        public interface C1243d extends C1241a, C1242c {
        }

        /* renamed from: com.google.android.gms.common.api.a.a.b */
        public static final class C1264b implements C1242c {
            private C1264b() {
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.e */
    public static abstract class C1265e<T extends C1267c, O> {
        public int m4508a() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public List<Scope> m4509a(O o) {
            return Collections.emptyList();
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.b */
    public static abstract class C1266b<T extends C1269f, O> extends C1265e<T, O> {
        public abstract T m4510a(Context context, Looper looper, C1338k c1338k, O o, C0777b c0777b, C0778c c0778c);
    }

    /* renamed from: com.google.android.gms.common.api.a.c */
    public interface C1267c {
    }

    /* renamed from: com.google.android.gms.common.api.a.d */
    public static class C1268d<C extends C1267c> {
    }

    /* renamed from: com.google.android.gms.common.api.a.f */
    public interface C1269f extends C1267c {
        void m4511a();

        void m4512a(C1329f c1329f);

        void m4513a(C1308t c1308t, Set<Scope> set);

        void m4514a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean m4515b();

        boolean m4516c();

        boolean m4517d();

        boolean m4518e();

        boolean m4519f();

        Intent m4520g();

        IBinder m4521h();
    }

    /* renamed from: com.google.android.gms.common.api.a.g */
    public static final class C1270g<C extends C1269f> extends C1268d<C> {
    }

    /* renamed from: com.google.android.gms.common.api.a.h */
    public interface C1271h<T extends IInterface> extends C1267c {
        T m4522a(IBinder iBinder);

        String m4523a();

        String m4524b();
    }

    /* renamed from: com.google.android.gms.common.api.a.i */
    public static abstract class C1272i<T extends C1271h, O> extends C1265e<T, O> {
    }

    /* renamed from: com.google.android.gms.common.api.a.j */
    public static final class C1273j<C extends C1271h> extends C1268d<C> {
    }

    public <C extends C1269f> C1274a(String str, C1266b<C, O> c1266b, C1270g<C> c1270g) {
        C1314c.m4624a((Object) c1266b, (Object) "Cannot construct an Api with a null ClientBuilder");
        C1314c.m4624a((Object) c1270g, (Object) "Cannot construct an Api with a null ClientKey");
        this.f2990e = str;
        this.f2986a = c1266b;
        this.f2987b = null;
        this.f2988c = c1270g;
        this.f2989d = null;
    }

    public C1265e<?, O> m4525a() {
        return this.f2986a;
    }

    public C1266b<?, O> m4526b() {
        C1314c.m4629a(this.f2986a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f2986a;
    }

    public C1268d<?> m4527c() {
        if (this.f2988c != null) {
            return this.f2988c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public String m4528d() {
        return this.f2990e;
    }
}
