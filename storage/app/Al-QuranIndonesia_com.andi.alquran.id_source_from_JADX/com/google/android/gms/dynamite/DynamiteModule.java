package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamite.C1405a.C1407a;
import com.google.android.gms.dynamite.C1408b.C1410a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class DynamiteModule {
    public static final C1395b f3244a;
    public static final C1395b f3245b;
    public static final C1395b f3246c;
    public static final C1395b f3247d;
    public static final C1395b f3248e;
    private static C1405a f3249f;
    private static final HashMap<String, byte[]> f3250g;
    private static String f3251h;
    private static final C1392a f3252i;
    private static final C1392a f3253j;
    private final Context f3254k;

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.1 */
    class C13931 implements C1392a {
        C13931() {
        }

        public int m4991a(Context context, String str) {
            return DynamiteModule.m5006a(context, str);
        }

        public int m4992a(Context context, String str, boolean z) {
            return DynamiteModule.m5007a(context, str, z);
        }

        public DynamiteModule m4993a(Context context, String str, int i) {
            return DynamiteModule.m5016c(context, str, i);
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.2 */
    class C13942 implements C1392a {
        C13942() {
        }

        public int m4994a(Context context, String str) {
            return DynamiteModule.m5006a(context, str);
        }

        public int m4995a(Context context, String str, boolean z) {
            return DynamiteModule.m5013b(context, str, z);
        }

        public DynamiteModule m4996a(Context context, String str, int i) {
            return DynamiteModule.m5018d(context, str, i);
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.b */
    public interface C1395b {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule.b.a */
        public interface C1392a {
            int m4988a(Context context, String str);

            int m4989a(Context context, String str, boolean z);

            DynamiteModule m4990a(Context context, String str, int i);
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule.b.b */
        public static class C1404b {
            public int f3241a;
            public int f3242b;
            public int f3243c;

            public C1404b() {
                this.f3241a = 0;
                this.f3242b = 0;
                this.f3243c = 0;
            }
        }

        C1404b m4997a(Context context, String str, C1392a c1392a);
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.3 */
    class C13963 implements C1395b {
        C13963() {
        }

        public C1404b m4998a(Context context, String str, C1392a c1392a) {
            C1404b c1404b = new C1404b();
            c1404b.f3242b = c1392a.m4989a(context, str, true);
            if (c1404b.f3242b != 0) {
                c1404b.f3243c = 1;
            } else {
                c1404b.f3241a = c1392a.m4988a(context, str);
                if (c1404b.f3241a != 0) {
                    c1404b.f3243c = -1;
                }
            }
            return c1404b;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.4 */
    class C13974 implements C1395b {
        C13974() {
        }

        public C1404b m4999a(Context context, String str, C1392a c1392a) {
            C1404b c1404b = new C1404b();
            c1404b.f3241a = c1392a.m4988a(context, str);
            if (c1404b.f3241a != 0) {
                c1404b.f3243c = -1;
            } else {
                c1404b.f3242b = c1392a.m4989a(context, str, true);
                if (c1404b.f3242b != 0) {
                    c1404b.f3243c = 1;
                }
            }
            return c1404b;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.5 */
    class C13985 implements C1395b {
        C13985() {
        }

        public C1404b m5000a(Context context, String str, C1392a c1392a) {
            C1404b c1404b = new C1404b();
            c1404b.f3241a = c1392a.m4988a(context, str);
            c1404b.f3242b = c1392a.m4989a(context, str, true);
            if (c1404b.f3241a == 0 && c1404b.f3242b == 0) {
                c1404b.f3243c = 0;
            } else if (c1404b.f3241a >= c1404b.f3242b) {
                c1404b.f3243c = -1;
            } else {
                c1404b.f3243c = 1;
            }
            return c1404b;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.6 */
    class C13996 implements C1395b {
        C13996() {
        }

        public C1404b m5001a(Context context, String str, C1392a c1392a) {
            C1404b c1404b = new C1404b();
            c1404b.f3241a = c1392a.m4988a(context, str);
            c1404b.f3242b = c1392a.m4989a(context, str, true);
            if (c1404b.f3241a == 0 && c1404b.f3242b == 0) {
                c1404b.f3243c = 0;
            } else if (c1404b.f3242b >= c1404b.f3241a) {
                c1404b.f3243c = 1;
            } else {
                c1404b.f3243c = -1;
            }
            return c1404b;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.7 */
    class C14007 implements C1395b {
        C14007() {
        }

        public C1404b m5002a(Context context, String str, C1392a c1392a) {
            C1404b c1404b = new C1404b();
            c1404b.f3241a = c1392a.m4988a(context, str);
            if (c1404b.f3241a != 0) {
                c1404b.f3242b = c1392a.m4989a(context, str, false);
            } else {
                c1404b.f3242b = c1392a.m4989a(context, str, true);
            }
            if (c1404b.f3241a == 0 && c1404b.f3242b == 0) {
                c1404b.f3243c = 0;
            } else if (c1404b.f3242b >= c1404b.f3241a) {
                c1404b.f3243c = 1;
            } else {
                c1404b.f3243c = -1;
            }
            return c1404b;
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.8 */
    class C14018 implements C1392a {
        final /* synthetic */ int f3240a;

        C14018(int i) {
            this.f3240a = i;
        }

        public int m5003a(Context context, String str) {
            return this.f3240a;
        }

        public int m5004a(Context context, String str, boolean z) {
            return 0;
        }

        public DynamiteModule m5005a(Context context, String str, int i) {
            throw new C1403a(null);
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.9 */
    class C14029 extends PathClassLoader {
        C14029(String str, ClassLoader classLoader) {
            super(str, classLoader);
        }

        protected Class<?> loadClass(String str, boolean z) {
            if (!(str.startsWith("java.") || str.startsWith("android."))) {
                try {
                    return findClass(str);
                } catch (ClassNotFoundException e) {
                }
            }
            return super.loadClass(str, z);
        }
    }

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule.a */
    public static class C1403a extends Exception {
        private C1403a(String str) {
            super(str);
        }

        private C1403a(String str, Throwable th) {
            super(str, th);
        }
    }

    static {
        f3250g = new HashMap();
        f3252i = new C13931();
        f3253j = new C13942();
        f3244a = new C13963();
        f3245b = new C13974();
        f3246c = new C13985();
        f3247d = new C13996();
        f3248e = new C14007();
    }

    private DynamiteModule(Context context) {
        this.f3254k = (Context) C1314c.m4623a((Object) context);
    }

    public static int m5006a(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    public static int m5007a(Context context, String str, boolean z) {
        C1405a a = m5012a(context);
        if (a == null) {
            return 0;
        }
        try {
            return a.m5021a(C1111d.m3896a((Object) context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    private static Context m5008a(Context context, String str, byte[] bArr, String str2) {
        if (str2 == null || str2.isEmpty()) {
            Log.e("DynamiteModule", "No valid DynamiteLoader APK path");
            return null;
        }
        try {
            return (Context) C1111d.m3897a(C1410a.m5029a((IBinder) m5017c(context, str2).loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0])).m5027a(C1111d.m3896a((Object) context), str, bArr));
        } catch (Exception e) {
            String str3 = "DynamiteModule";
            String str4 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
            return null;
        }
    }

    public static DynamiteModule m5009a(Context context, C1395b c1395b, String str) {
        if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
            return m5010a(context, c1395b, str, f3252i);
        }
        try {
            return m5010a(context, c1395b, str, f3253j);
        } catch (C1403a e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to load module via fast route";
            String valueOf = String.valueOf(e.toString());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return m5010a(context, c1395b, str, f3252i);
        }
    }

    public static DynamiteModule m5010a(Context context, C1395b c1395b, String str, C1392a c1392a) {
        C1404b a = c1395b.m4997a(context, str, c1392a);
        Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(a.f3241a).append(" and remote module ").append(str).append(":").append(a.f3242b).toString());
        if (a.f3243c == 0 || ((a.f3243c == -1 && a.f3241a == 0) || (a.f3243c == 1 && a.f3242b == 0))) {
            throw new C1403a(null);
        } else if (a.f3243c == -1) {
            return m5014b(context, str);
        } else {
            if (a.f3243c == 1) {
                try {
                    return c1392a.m4990a(context, str, a.f3242b);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(th.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (a.f3241a != 0 && c1395b.m4997a(context, str, new C14018(a.f3241a)).f3243c == -1) {
                        return m5014b(context, str);
                    }
                    throw new C1403a(th, null);
                }
            }
            throw new C1403a(null);
        }
    }

    private static C1405a m5012a(Context context) {
        synchronized (DynamiteModule.class) {
            C1405a c1405a;
            if (f3249f != null) {
                c1405a = f3249f;
                return c1405a;
            } else if (C1261h.m4458b().m4460a(context) != 0) {
                return null;
            } else {
                try {
                    c1405a = C1407a.m5026a((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (c1405a != null) {
                        f3249f = c1405a;
                        return c1405a;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                return null;
            }
        }
    }

    public static int m5013b(Context context, String str, boolean z) {
        String str2;
        Throwable e;
        Cursor cursor;
        Cursor cursor2 = null;
        if (z) {
            try {
                str2 = "api_force_staging";
            } catch (Exception e2) {
                e = e2;
                cursor = null;
                try {
                    if (e instanceof C1403a) {
                        throw e;
                    }
                    throw new C1403a(e, null);
                } catch (Throwable th) {
                    e = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw e;
            }
        }
        str2 = "api";
        String valueOf = String.valueOf("content://com.google.android.gms.chimera/");
        Uri parse = Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str2).length()) + String.valueOf(str).length()).append(valueOf).append(str2).append("/").append(str).toString());
        if (context != null) {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                cursor = contentResolver.query(parse, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            int i = cursor.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    f3250g.put(new StringBuilder(String.valueOf(str).length() + 12).append(str).append(":").append(i).toString(), Base64.decode(cursor.getString(3), 0));
                                    f3251h = cursor.getString(2);
                                }
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new C1403a(null);
            }
        }
        throw new C1403a(null);
    }

    private static DynamiteModule m5014b(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule m5016c(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        C1405a a = m5012a(context);
        if (a == null) {
            throw new C1403a(null);
        }
        try {
            C1108c a2 = a.m5022a(C1111d.m3896a((Object) context), str, i);
            if (C1111d.m3897a(a2) != null) {
                return new DynamiteModule((Context) C1111d.m3897a(a2));
            }
            throw new C1403a(null);
        } catch (Throwable e) {
            throw new C1403a(e, null);
        }
    }

    private static ClassLoader m5017c(Context context, String str) {
        ClassLoader classLoader;
        synchronized (DynamiteLoaderClassLoader.class) {
            if (DynamiteLoaderClassLoader.sClassLoader != null) {
                classLoader = DynamiteLoaderClassLoader.sClassLoader;
            } else {
                Class loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                Field declaredField = loadClass.getDeclaredField("sClassLoader");
                synchronized (loadClass) {
                    DynamiteLoaderClassLoader.sClassLoader = (ClassLoader) declaredField.get(null);
                    if (DynamiteLoaderClassLoader.sClassLoader != null) {
                        classLoader = DynamiteLoaderClassLoader.sClassLoader;
                    } else {
                        DynamiteLoaderClassLoader.sClassLoader = new C14029(str, ClassLoader.getSystemClassLoader());
                        declaredField.set(null, DynamiteLoaderClassLoader.sClassLoader);
                        classLoader = DynamiteLoaderClassLoader.sClassLoader;
                    }
                }
            }
        }
        return classLoader;
    }

    private static DynamiteModule m5018d(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            byte[] bArr = (byte[]) f3250g.get(new StringBuilder(String.valueOf(str).length() + 12).append(str).append(":").append(i).toString());
            String str2 = f3251h;
        }
        if (bArr == null) {
            throw new C1403a(null);
        }
        Context a = m5008a(context.getApplicationContext(), str, bArr, str2);
        if (a != null) {
            return new DynamiteModule(a);
        }
        throw new C1403a(null);
    }

    public Context m5019a() {
        return this.f3254k;
    }
}
