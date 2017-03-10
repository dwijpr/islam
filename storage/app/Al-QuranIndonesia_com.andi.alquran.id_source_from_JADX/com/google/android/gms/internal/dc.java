package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.C1292b;
import com.google.android.gms.common.C1294c;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1277c.C1276a;
import com.google.android.gms.internal.au.C1444a;
import com.google.android.gms.internal.au.C1447d;
import com.google.android.gms.internal.cj.C1507a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class dc {
    protected static final Object f3736c;
    protected static final Object f3737e;
    private static final String f3738h;
    private static C1261h f3739u;
    protected Context f3740a;
    protected Context f3741b;
    protected boolean f3742d;
    protected boolean f3743f;
    protected boolean f3744g;
    private ExecutorService f3745i;
    private DexClassLoader f3746j;
    private cj f3747k;
    private byte[] f3748l;
    private volatile AdvertisingIdClient f3749m;
    private volatile boolean f3750n;
    private Future f3751o;
    private volatile C1444a f3752p;
    private Future f3753q;
    private volatile boolean f3754r;
    private bc f3755s;
    private C1277c f3756t;
    private Map<Pair<String, String>, eq> f3757v;

    /* renamed from: com.google.android.gms.internal.dc.1 */
    class C15181 implements Runnable {
        final /* synthetic */ dc f3733a;

        C15181(dc dcVar) {
            this.f3733a = dcVar;
        }

        public void run() {
            this.f3733a.m5692s();
        }
    }

    /* renamed from: com.google.android.gms.internal.dc.2 */
    class C15192 implements Runnable {
        final /* synthetic */ dc f3734a;

        C15192(dc dcVar) {
            this.f3734a = dcVar;
        }

        public void run() {
            this.f3734a.m5694u();
            synchronized (dc.f3736c) {
                this.f3734a.f3754r = false;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.dc.3 */
    class C15203 implements Runnable {
        final /* synthetic */ dc f3735a;

        C15203(dc dcVar) {
            this.f3735a = dcVar;
        }

        public void run() {
            C1648if.m6704a(this.f3735a.f3740a);
        }
    }

    static {
        f3738h = dc.class.getSimpleName();
        f3736c = new Object();
        f3737e = new Object();
        f3739u = null;
    }

    private dc(Context context) {
        this.f3749m = null;
        this.f3750n = false;
        this.f3751o = null;
        this.f3752p = null;
        this.f3753q = null;
        this.f3754r = false;
        this.f3756t = null;
        this.f3742d = false;
        this.f3743f = false;
        this.f3744g = false;
        this.f3740a = context;
        this.f3741b = context.getApplicationContext();
        this.f3757v = new HashMap();
    }

    public static dc m5679a(Context context, String str, String str2, boolean z) {
        dc dcVar = new dc(context);
        try {
            dcVar.m5687a(str, str2, z);
            return dcVar;
        } catch (cy e) {
            return null;
        }
    }

    private File m5680a(String str, File file, String str2) {
        File file2 = new File(String.format("%s/%s.jar", new Object[]{file, str2}));
        if (!file2.exists()) {
            byte[] a = this.f3747k.m5547a(this.f3748l, str);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(a, 0, a.length);
            fileOutputStream.close();
        }
        return file2;
    }

    private void m5682a(File file) {
        if (file.exists()) {
            file.delete();
            return;
        }
        Log.d(f3738h, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
    }

    private void m5683a(File file, String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
            if (file3.exists()) {
                long length = file3.length();
                if (length > 0) {
                    byte[] bArr = new byte[((int) length)];
                    try {
                        fileInputStream = new FileInputStream(file3);
                        try {
                            if (fileInputStream.read(bArr) <= 0) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                }
                                m5682a(file3);
                                return;
                            }
                            eg c1447d = new C1447d();
                            c1447d.f3441d = VERSION.SDK.getBytes();
                            c1447d.f3440c = str.getBytes();
                            bArr = this.f3747k.m5545a(this.f3748l, bArr).getBytes();
                            c1447d.f3438a = bArr;
                            c1447d.f3439b = ba.m5239a(bArr);
                            file2.createNewFile();
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] a = eg.m5148a(c1447d);
                                fileOutputStream.write(a, 0, a.length);
                                fileOutputStream.close();
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                }
                                m5682a(file3);
                            } catch (IOException e4) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                m5682a(file3);
                            } catch (NoSuchAlgorithmException e7) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                m5682a(file3);
                            } catch (C1507a e8) {
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                m5682a(file3);
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                fileOutputStream2 = fileOutputStream;
                                th = th3;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e9) {
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                m5682a(file3);
                                throw th;
                            }
                        } catch (IOException e11) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            m5682a(file3);
                        } catch (NoSuchAlgorithmException e12) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            m5682a(file3);
                        } catch (C1507a e13) {
                            fileOutputStream = null;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            m5682a(file3);
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            m5682a(file3);
                            throw th;
                        }
                    } catch (IOException e14) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        m5682a(file3);
                    } catch (NoSuchAlgorithmException e15) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        m5682a(file3);
                    } catch (C1507a e16) {
                        fileOutputStream = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        m5682a(file3);
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        m5682a(file3);
                        throw th;
                    }
                }
            }
        }
    }

    private void m5684a(String str) {
        this.f3747k = new cj(null);
        try {
            this.f3748l = this.f3747k.m5546a(str);
        } catch (Throwable e) {
            throw new cy(e);
        }
    }

    private void m5685a(boolean z) {
        this.f3750n = z;
        if (z) {
            this.f3751o = this.f3745i.submit(new C15181(this));
        }
    }

    private boolean m5687a(String str, String str2, boolean z) {
        this.f3745i = Executors.newCachedThreadPool();
        m5685a(z);
        m5695v();
        m5693t();
        if (de.m5721b() && ((Boolean) C1648if.bL.m6682c()).booleanValue()) {
            throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
        }
        m5684a(str);
        m5690b(str2);
        this.f3755s = new bc(this);
        return true;
    }

    private boolean m5689b(File file, String str) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
        if (file3.exists()) {
            return false;
        }
        FileInputStream fileInputStream2;
        try {
            long length = file2.length();
            if (length <= 0) {
                m5682a(file2);
                return false;
            }
            byte[] bArr = new byte[((int) length)];
            fileInputStream2 = new FileInputStream(file2);
            try {
                if (fileInputStream2.read(bArr) <= 0) {
                    Log.d(f3738h, "Cannot read the cache data.");
                    m5682a(file2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                    }
                    return false;
                }
                C1447d a = C1447d.m5203a(bArr);
                if (str.equals(new String(a.f3440c)) && Arrays.equals(a.f3439b, ba.m5239a(a.f3438a)) && Arrays.equals(a.f3441d, VERSION.SDK.getBytes())) {
                    bArr = this.f3747k.m5547a(this.f3748l, new String(a.f3438a));
                    file3.createNewFile();
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                    try {
                        fileOutputStream3.write(bArr, 0, bArr.length);
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                        }
                        try {
                            fileOutputStream3.close();
                            return true;
                        } catch (IOException e3) {
                            return true;
                        }
                    } catch (IOException e4) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        return false;
                    } catch (NoSuchAlgorithmException e7) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (C1507a e8) {
                        fileOutputStream = fileOutputStream3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream3;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                }
                m5682a(file2);
                try {
                    fileInputStream2.close();
                } catch (IOException e11) {
                }
                return false;
            } catch (IOException e12) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (NoSuchAlgorithmException e13) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (C1507a e14) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (IOException e15) {
            fileOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (NoSuchAlgorithmException e16) {
            fileOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (C1507a e17) {
            fileOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    private boolean m5690b(String str) {
        File file;
        String b;
        File a;
        try {
            File cacheDir = this.f3740a.getCacheDir();
            if (cacheDir == null) {
                cacheDir = this.f3740a.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new cy();
                }
            }
            file = cacheDir;
            b = cu.m5627b();
            a = m5680a(str, file, b);
            m5689b(file, b);
            this.f3746j = new DexClassLoader(a.getAbsolutePath(), file.getAbsolutePath(), null, this.f3740a.getClassLoader());
            m5682a(a);
            m5683a(file, b);
            m5691c(String.format("%s/%s.dex", new Object[]{file, b}));
            return true;
        } catch (Throwable e) {
            throw new cy(e);
        } catch (Throwable e2) {
            throw new cy(e2);
        } catch (Throwable e22) {
            throw new cy(e22);
        } catch (Throwable e222) {
            throw new cy(e222);
        } catch (Throwable th) {
            m5682a(a);
            m5683a(file, b);
            m5691c(String.format("%s/%s.dex", new Object[]{file, b}));
        }
    }

    private void m5691c(String str) {
        m5682a(new File(str));
    }

    private void m5692s() {
        try {
            if (this.f3749m == null && this.f3741b != null) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f3741b);
                advertisingIdClient.start();
                this.f3749m = advertisingIdClient;
            }
        } catch (C1292b e) {
            this.f3749m = null;
        } catch (IOException e2) {
            this.f3749m = null;
        } catch (C1294c e3) {
            this.f3749m = null;
        }
    }

    private void m5693t() {
        if (((Boolean) C1648if.bN.m6682c()).booleanValue()) {
            m5711n();
        }
    }

    private void m5694u() {
        if (this.f3743f) {
            try {
                this.f3752p = bf.m5274a(this.f3740a, this.f3740a.getPackageName(), Integer.toString(this.f3740a.getPackageManager().getPackageInfo(this.f3740a.getPackageName(), 0).versionCode));
            } catch (NameNotFoundException e) {
            }
        }
    }

    private void m5695v() {
        boolean z = true;
        this.f3745i.execute(new C15203(this));
        f3739u = C1261h.m4458b();
        this.f3742d = f3739u.m4465b(this.f3740a) > 0;
        if (f3739u.m4460a(this.f3740a) != 0) {
            z = false;
        }
        this.f3743f = z;
        if (this.f3740a.getApplicationContext() != null) {
            this.f3756t = new C1276a(this.f3740a).m4533a(vx.f6292c).m4537b();
        }
    }

    public Context m5696a() {
        return this.f3740a;
    }

    public Method m5697a(String str, String str2) {
        eq eqVar = (eq) this.f3757v.get(new Pair(str, str2));
        return eqVar == null ? null : eqVar.m5974a();
    }

    public boolean m5698a(String str, String str2, List<Class> list) {
        if (this.f3757v.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.f3757v.put(new Pair(str, str2), new eq(this, str, str2, list));
        return true;
    }

    public Context m5699b() {
        return this.f3741b;
    }

    public ExecutorService m5700c() {
        return this.f3745i;
    }

    public DexClassLoader m5701d() {
        return this.f3746j;
    }

    public cj m5702e() {
        return this.f3747k;
    }

    public byte[] m5703f() {
        return this.f3748l;
    }

    public C1277c m5704g() {
        return this.f3756t;
    }

    public boolean m5705h() {
        return this.f3742d;
    }

    public boolean m5706i() {
        return this.f3744g;
    }

    public bc m5707j() {
        return this.f3755s;
    }

    public boolean m5708k() {
        return this.f3743f;
    }

    public C1444a m5709l() {
        return this.f3752p;
    }

    public Future m5710m() {
        return this.f3753q;
    }

    public void m5711n() {
        synchronized (f3736c) {
            if (!this.f3754r) {
                this.f3753q = this.f3745i.submit(new C15192(this));
                this.f3754r = true;
            }
        }
    }

    public AdvertisingIdClient m5712o() {
        if (!this.f3750n) {
            return null;
        }
        if (this.f3749m != null) {
            return this.f3749m;
        }
        if (this.f3751o != null) {
            try {
                this.f3751o.get(2000, TimeUnit.MILLISECONDS);
                this.f3751o = null;
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            } catch (TimeoutException e3) {
                this.f3751o.cancel(true);
            }
        }
        return this.f3749m;
    }

    public void m5713p() {
        synchronized (f3737e) {
            if (this.f3744g) {
                return;
            }
            if (!this.f3743f || this.f3756t == null) {
                this.f3744g = false;
            } else {
                this.f3756t.m4546b();
                this.f3744g = true;
            }
        }
    }

    public void m5714q() {
        synchronized (f3737e) {
            if (this.f3744g && this.f3756t != null) {
                this.f3756t.m4549c();
                this.f3744g = false;
            }
        }
    }

    public int m5715r() {
        bc j = m5707j();
        return j != null ? j.m5263a() : RtlSpacingHelper.UNDEFINED;
    }
}
