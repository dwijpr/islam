package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1274a.C1240a.C1264b;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1274a.C1270g;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.api.C1279d;
import com.google.android.gms.common.api.C1280e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.common.util.C1377c;
import com.google.android.gms.common.util.C1379e;
import com.google.android.gms.internal.ek.C1531c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class vx {
    public static final C1270g<wb> f6290a;
    public static final C1266b<wb, C1264b> f6291b;
    @Deprecated
    public static final C1274a<C1264b> f6292c;
    private final String f6293d;
    private final int f6294e;
    private String f6295f;
    private int f6296g;
    private String f6297h;
    private String f6298i;
    private final boolean f6299j;
    private int f6300k;
    private final vy f6301l;
    private final C1377c f6302m;
    private C2056d f6303n;
    private final C2054b f6304o;

    /* renamed from: com.google.android.gms.internal.vx.1 */
    class C20521 extends C1266b<wb, C1264b> {
        C20521() {
        }

        public /* synthetic */ C1269f m9576a(Context context, Looper looper, C1338k c1338k, Object obj, C0777b c0777b, C0778c c0778c) {
            return m9577a(context, looper, c1338k, (C1264b) obj, c0777b, c0778c);
        }

        public wb m9577a(Context context, Looper looper, C1338k c1338k, C1264b c1264b, C0777b c0777b, C0778c c0778c) {
            return new wb(context, looper, c1338k, c0777b, c0778c);
        }
    }

    /* renamed from: com.google.android.gms.internal.vx.a */
    public class C2053a {
        final /* synthetic */ vx f6276a;
        private int f6277b;
        private String f6278c;
        private String f6279d;
        private String f6280e;
        private int f6281f;
        private final C2055c f6282g;
        private ArrayList<Integer> f6283h;
        private ArrayList<String> f6284i;
        private ArrayList<Integer> f6285j;
        private ArrayList<byte[]> f6286k;
        private boolean f6287l;
        private final C1531c f6288m;
        private boolean f6289n;

        private C2053a(vx vxVar, byte[] bArr) {
            this(vxVar, bArr, null);
        }

        private C2053a(vx vxVar, byte[] bArr, C2055c c2055c) {
            this.f6276a = vxVar;
            this.f6277b = this.f6276a.f6296g;
            this.f6278c = this.f6276a.f6295f;
            this.f6279d = this.f6276a.f6297h;
            this.f6280e = this.f6276a.f6298i;
            this.f6281f = 0;
            this.f6283h = null;
            this.f6284i = null;
            this.f6285j = null;
            this.f6286k = null;
            this.f6287l = true;
            this.f6288m = new C1531c();
            this.f6289n = false;
            this.f6279d = vxVar.f6297h;
            this.f6280e = vxVar.f6298i;
            this.f6288m.f3875a = vxVar.f6302m.m4926a();
            this.f6288m.f3876b = vxVar.f6302m.m4927b();
            this.f6288m.f3889o = vxVar.f6303n.m9585a(this.f6288m.f3875a);
            if (bArr != null) {
                this.f6288m.f3885k = bArr;
            }
            this.f6282g = c2055c;
        }

        @Deprecated
        public C1279d<Status> m9578a(C1277c c1277c) {
            return m9581b();
        }

        public C2053a m9579a(int i) {
            this.f6288m.f3879e = i;
            return this;
        }

        public zzzh m9580a() {
            return new zzzh(new zzawe(this.f6276a.f6293d, this.f6276a.f6294e, this.f6277b, this.f6278c, this.f6279d, this.f6280e, this.f6276a.f6299j, this.f6281f), this.f6288m, this.f6282g, null, vx.m9594d(null), vx.m9596e(null), vx.m9594d(null), vx.m9598f(null), this.f6287l);
        }

        @Deprecated
        public C1279d<Status> m9581b() {
            if (this.f6289n) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f6289n = true;
            zzzh a = m9580a();
            zzawe com_google_android_gms_internal_zzawe = a.f6644b;
            return this.f6276a.f6304o.m9583a(com_google_android_gms_internal_zzawe.f6405h, com_google_android_gms_internal_zzawe.f6401d) ? this.f6276a.f6301l.m9606a(a) : C1280e.m4554a(Status.f2975a);
        }

        public C2053a m9582b(int i) {
            this.f6288m.f3880f = i;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.vx.b */
    public interface C2054b {
        boolean m9583a(String str, int i);
    }

    /* renamed from: com.google.android.gms.internal.vx.c */
    public interface C2055c {
        byte[] m9584a();
    }

    /* renamed from: com.google.android.gms.internal.vx.d */
    public static class C2056d {
        public long m9585a(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    static {
        f6290a = new C1270g();
        f6291b = new C20521();
        f6292c = new C1274a("ClearcutLogger.API", f6291b, f6290a);
    }

    public vx(Context context, int i, String str, String str2, String str3, boolean z, vy vyVar, C1377c c1377c, C2056d c2056d, C2054b c2054b) {
        boolean z2 = false;
        this.f6296g = -1;
        this.f6300k = 0;
        this.f6293d = context.getPackageName();
        this.f6294e = m9586a(context);
        this.f6296g = i;
        this.f6295f = str;
        this.f6297h = str2;
        this.f6298i = str3;
        this.f6299j = z;
        this.f6301l = vyVar;
        this.f6302m = c1377c;
        if (c2056d == null) {
            c2056d = new C2056d();
        }
        this.f6303n = c2056d;
        this.f6300k = 0;
        this.f6304o = c2054b;
        if (this.f6299j) {
            if (this.f6297h == null) {
                z2 = true;
            }
            C1314c.m4633b(z2, "can't be anonymous with an upload account");
        }
    }

    public vx(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, wa.m9622a(context), C1379e.m4937d(), null, new wf(context));
    }

    private int m9586a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    private static int[] m9594d(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) it.next()).intValue();
            i = i2;
        }
        return iArr;
    }

    private static String[] m9596e(ArrayList<String> arrayList) {
        return arrayList == null ? null : (String[]) arrayList.toArray(new String[0]);
    }

    private static byte[][] m9598f(ArrayList<byte[]> arrayList) {
        return arrayList == null ? null : (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public C2053a m9605a(byte[] bArr) {
        return new C2053a(bArr, null);
    }
}
