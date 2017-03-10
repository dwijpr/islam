package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.C1377c;
import com.google.android.gms.common.util.C1379e;

/* renamed from: com.google.android.gms.tagmanager.e */
public class C2230e {
    private static Object f7113l;
    private static C2230e f7114m;
    private volatile long f7115a;
    private volatile long f7116b;
    private volatile boolean f7117c;
    private volatile Info f7118d;
    private volatile long f7119e;
    private volatile long f7120f;
    private final Context f7121g;
    private final C1377c f7122h;
    private final Thread f7123i;
    private final Object f7124j;
    private C2227a f7125k;

    /* renamed from: com.google.android.gms.tagmanager.e.a */
    public interface C2227a {
        Info m10245a();
    }

    /* renamed from: com.google.android.gms.tagmanager.e.1 */
    class C22281 implements C2227a {
        final /* synthetic */ C2230e f7111a;

        C22281(C2230e c2230e) {
            this.f7111a = c2230e;
        }

        public Info m10246a() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.f7111a.f7121g);
            } catch (Throwable e) {
                C2238n.m10267b("IllegalStateException getting Advertising Id Info", e);
            } catch (Throwable e2) {
                C2238n.m10267b("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            } catch (Throwable e22) {
                C2238n.m10267b("IOException getting Ad Id Info", e22);
            } catch (Throwable e222) {
                C2238n.m10267b("GooglePlayServicesNotAvailableException getting Advertising Id Info", e222);
            } catch (Throwable e2222) {
                C2238n.m10267b("Unknown exception. Could not get the Advertising Id Info.", e2222);
            }
            return info;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.e.2 */
    class C22292 implements Runnable {
        final /* synthetic */ C2230e f7112a;

        C22292(C2230e c2230e) {
            this.f7112a = c2230e;
        }

        public void run() {
            this.f7112a.m10249b();
        }
    }

    static {
        f7113l = new Object();
    }

    private C2230e(Context context) {
        this(context, null, C1379e.m4937d());
    }

    public C2230e(Context context, C2227a c2227a, C1377c c1377c) {
        this.f7115a = 900000;
        this.f7116b = 30000;
        this.f7117c = false;
        this.f7124j = new Object();
        this.f7125k = new C22281(this);
        this.f7122h = c1377c;
        if (context != null) {
            this.f7121g = context.getApplicationContext();
        } else {
            this.f7121g = context;
        }
        if (c2227a != null) {
            this.f7125k = c2227a;
        }
        this.f7119e = this.f7122h.m4926a();
        this.f7123i = new Thread(new C22292(this));
    }

    public static C2230e m10248a(Context context) {
        if (f7114m == null) {
            synchronized (f7113l) {
                if (f7114m == null) {
                    f7114m = new C2230e(context);
                    f7114m.m10251a();
                }
            }
        }
        return f7114m;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10249b() {
        /*
        r4 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r0 = r4.f7117c;
        r0 = r4.f7125k;
        r0 = r0.m10245a();
        if (r0 == 0) goto L_0x001e;
    L_0x000f:
        r4.f7118d = r0;
        r0 = r4.f7122h;
        r0 = r0.m4926a();
        r4.f7120f = r0;
        r0 = "Obtained fresh AdvertisingId info from GmsCore.";
        com.google.android.gms.tagmanager.C2238n.m10268c(r0);
    L_0x001e:
        monitor-enter(r4);
        r4.notifyAll();	 Catch:{ all -> 0x0039 }
        monitor-exit(r4);	 Catch:{ all -> 0x0039 }
        r1 = r4.f7124j;	 Catch:{ InterruptedException -> 0x0032 }
        monitor-enter(r1);	 Catch:{ InterruptedException -> 0x0032 }
        r0 = r4.f7124j;	 Catch:{ all -> 0x002f }
        r2 = r4.f7115a;	 Catch:{ all -> 0x002f }
        r0.wait(r2);	 Catch:{ all -> 0x002f }
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        goto L_0x0005;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        throw r0;	 Catch:{ InterruptedException -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        r0 = "sleep interrupted in AdvertiserDataPoller thread; continuing";
        com.google.android.gms.tagmanager.C2238n.m10268c(r0);
        goto L_0x0005;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.e.b():void");
    }

    public void m10251a() {
        this.f7123i.start();
    }
}
