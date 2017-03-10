package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.C2220c.C2201b;
import com.google.android.gms.tagmanager.C2251x.C2250a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.tagmanager.d */
public class C2226d {
    private static C2226d f7104g;
    private final C2222a f7105a;
    private final Context f7106b;
    private final C2220c f7107c;
    private final af f7108d;
    private final ConcurrentMap<String, an> f7109e;
    private final ao f7110f;

    /* renamed from: com.google.android.gms.tagmanager.d.1 */
    class C22211 implements C2201b {
        final /* synthetic */ C2226d f7101a;

        C22211(C2226d c2226d) {
            this.f7101a = c2226d;
        }

        public void m10236a(Map<String, Object> map) {
            Object obj = map.get(NotificationCompatApi24.CATEGORY_EVENT);
            if (obj != null) {
                this.f7101a.m10239a(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.d.a */
    public interface C2222a {
    }

    /* renamed from: com.google.android.gms.tagmanager.d.2 */
    class C22232 implements C2222a {
        C22232() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.d.3 */
    class C22243 implements ComponentCallbacks2 {
        final /* synthetic */ C2226d f7102a;

        C22243(C2226d c2226d) {
            this.f7102a = c2226d;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.f7102a.m10242a();
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.d.4 */
    static /* synthetic */ class C22254 {
        static final /* synthetic */ int[] f7103a;

        static {
            f7103a = new int[C2250a.values().length];
            try {
                f7103a[C2250a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7103a[C2250a.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7103a[C2250a.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    C2226d(Context context, C2222a c2222a, C2220c c2220c, af afVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.f7106b = context.getApplicationContext();
        this.f7108d = afVar;
        this.f7105a = c2222a;
        this.f7109e = new ConcurrentHashMap();
        this.f7107c = c2220c;
        this.f7107c.m10232a(new C22211(this));
        this.f7107c.m10232a(new ae(this.f7106b));
        this.f7110f = new ao();
        m10240b();
        m10241c();
    }

    public static C2226d m10237a(Context context) {
        C2226d c2226d;
        synchronized (C2226d.class) {
            if (f7104g == null) {
                if (context == null) {
                    C2238n.m10264a("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                f7104g = new C2226d(context, new C22232(), new C2220c(new aq(context)), ag.m10129b());
            }
            c2226d = f7104g;
        }
        return c2226d;
    }

    private void m10239a(String str) {
        for (an a : this.f7109e.values()) {
            a.m10168a(str);
        }
    }

    @TargetApi(14)
    private void m10240b() {
        if (VERSION.SDK_INT >= 14) {
            this.f7106b.registerComponentCallbacks(new C22243(this));
        }
    }

    private void m10241c() {
        C2230e.m10248a(this.f7106b);
    }

    public void m10242a() {
        this.f7108d.m10127a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean m10243a(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r2 = com.google.android.gms.tagmanager.C2251x.m10291a();	 Catch:{ all -> 0x0033 }
        r0 = r2.m10294a(r6);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0073;
    L_0x000b:
        r3 = r2.m10297d();	 Catch:{ all -> 0x0033 }
        r0 = com.google.android.gms.tagmanager.C2226d.C22254.f7103a;	 Catch:{ all -> 0x0033 }
        r1 = r2.m10295b();	 Catch:{ all -> 0x0033 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x0033 }
        r0 = r0[r1];	 Catch:{ all -> 0x0033 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x0036;
            case 3: goto L_0x0036;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.f7109e;	 Catch:{ all -> 0x0033 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0033 }
        r0 = (com.google.android.gms.tagmanager.an) r0;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x001e;
    L_0x002b:
        r1 = 0;
        r0.m10170b(r1);	 Catch:{ all -> 0x0033 }
        r0.m10171c();	 Catch:{ all -> 0x0033 }
        goto L_0x001e;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0036:
        r0 = r5.f7109e;	 Catch:{ all -> 0x0033 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0033 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0033 }
    L_0x0040:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x001e;
    L_0x0046:
        r0 = r4.next();	 Catch:{ all -> 0x0033 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0033 }
        r1 = r5.f7109e;	 Catch:{ all -> 0x0033 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x0033 }
        r1 = (com.google.android.gms.tagmanager.an) r1;	 Catch:{ all -> 0x0033 }
        r0 = r0.equals(r3);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0065;
    L_0x005a:
        r0 = r2.m10296c();	 Catch:{ all -> 0x0033 }
        r1.m10170b(r0);	 Catch:{ all -> 0x0033 }
        r1.m10171c();	 Catch:{ all -> 0x0033 }
        goto L_0x0040;
    L_0x0065:
        r0 = r1.m10173e();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0040;
    L_0x006b:
        r0 = 0;
        r1.m10170b(r0);	 Catch:{ all -> 0x0033 }
        r1.m10171c();	 Catch:{ all -> 0x0033 }
        goto L_0x0040;
    L_0x0073:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.d.a(android.net.Uri):boolean");
    }

    public boolean m10244a(an anVar) {
        return this.f7109e.remove(anVar.m10172d()) != null;
    }
}
