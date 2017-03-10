package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1275b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1330w.C1331a;
import com.google.android.gms.common.internal.C1359x.C1361a;
import com.google.android.gms.maps.GoogleMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.j */
public abstract class C1317j<T extends IInterface> {
    public static final String[] f3045d;
    final Handler f3046a;
    protected C1329f f3047b;
    protected AtomicInteger f3048c;
    private int f3049e;
    private long f3050f;
    private long f3051g;
    private int f3052h;
    private long f3053i;
    private final Context f3054j;
    private final Looper f3055k;
    private final C1347q f3056l;
    private final C1261h f3057m;
    private final Object f3058n;
    private final Object f3059o;
    private C1359x f3060p;
    private T f3061q;
    private final ArrayList<C1324e<?>> f3062r;
    private C1333h f3063s;
    private int f3064t;
    private final C1326b f3065u;
    private final C1327c f3066v;
    private final int f3067w;
    private final String f3068x;

    /* renamed from: com.google.android.gms.common.internal.j.e */
    protected abstract class C1324e<TListener> {
        private TListener f3073a;
        private boolean f3074b;
        final /* synthetic */ C1317j f3075d;

        public C1324e(C1317j c1317j, TListener tListener) {
            this.f3075d = c1317j;
            this.f3073a = tListener;
            this.f3074b = false;
        }

        protected abstract void m4705a(TListener tListener);

        public void m4706b() {
            synchronized (this) {
                Object obj = this.f3073a;
                if (this.f3074b) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (obj != null) {
                try {
                    m4705a(obj);
                } catch (RuntimeException e) {
                    throw e;
                }
            }
            synchronized (this) {
                this.f3074b = true;
            }
            m4707c();
        }

        public void m4707c() {
            m4708d();
            synchronized (this.f3075d.f3062r) {
                this.f3075d.f3062r.remove(this);
            }
        }

        public void m4708d() {
            synchronized (this) {
                this.f3073a = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.j.a */
    private abstract class C1325a extends C1324e<Boolean> {
        public final int f3076a;
        public final Bundle f3077b;
        final /* synthetic */ C1317j f3078c;

        protected C1325a(C1317j c1317j, int i, Bundle bundle) {
            this.f3078c = c1317j;
            super(c1317j, Boolean.valueOf(true));
            this.f3076a = i;
            this.f3077b = bundle;
        }

        protected abstract void m4709a(ConnectionResult connectionResult);

        protected void m4710a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.f3078c.m4644a(1, null);
                return;
            }
            switch (this.f3076a) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    if (!m4712a()) {
                        this.f3078c.m4644a(1, null);
                        m4709a(new ConnectionResult(8, null));
                    }
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    this.f3078c.m4644a(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.f3078c.m4644a(1, null);
                    if (this.f3077b != null) {
                        pendingIntent = (PendingIntent) this.f3077b.getParcelable("pendingIntent");
                    }
                    m4709a(new ConnectionResult(this.f3076a, pendingIntent));
            }
        }

        protected /* synthetic */ void m4711a(Object obj) {
            m4710a((Boolean) obj);
        }

        protected abstract boolean m4712a();
    }

    /* renamed from: com.google.android.gms.common.internal.j.b */
    public interface C1326b {
        void m4713a(int i);

        void m4714a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.internal.j.c */
    public interface C1327c {
        void m4715a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.j.d */
    final class C1328d extends Handler {
        final /* synthetic */ C1317j f3079a;

        public C1328d(C1317j c1317j, Looper looper) {
            this.f3079a = c1317j;
            super(looper);
        }

        private void m4716a(Message message) {
            ((C1324e) message.obj).m4707c();
        }

        private boolean m4717b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.f3079a.f3048c.get() != message.arg1) {
                if (m4717b(message)) {
                    m4716a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.f3079a.m4667c()) {
                m4716a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.f3079a.f3047b.m4718a(connectionResult);
                this.f3079a.m4661a(connectionResult);
            } else if (message.what == 4) {
                this.f3079a.m4644a(4, null);
                if (this.f3079a.f3065u != null) {
                    this.f3079a.f3065u.m4713a(message.arg2);
                }
                this.f3079a.m4657a(message.arg2);
                this.f3079a.m4647a(4, 1, null);
            } else if (message.what == 2 && !this.f3079a.m4666b()) {
                m4716a(message);
            } else if (m4717b(message)) {
                ((C1324e) message.obj).m4706b();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.j.f */
    public interface C1329f {
        void m4718a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.j.g */
    public static final class C1332g extends C1331a {
        private C1317j f3080a;
        private final int f3081b;

        public C1332g(C1317j c1317j, int i) {
            this.f3080a = c1317j;
            this.f3081b = i;
        }

        private void m4722a() {
            this.f3080a = null;
        }

        public void m4723a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public void m4724a(int i, IBinder iBinder, Bundle bundle) {
            C1314c.m4624a(this.f3080a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f3080a.m4659a(i, iBinder, bundle, this.f3081b);
            m4722a();
        }
    }

    /* renamed from: com.google.android.gms.common.internal.j.h */
    public final class C1333h implements ServiceConnection {
        final /* synthetic */ C1317j f3082a;
        private final int f3083b;

        public C1333h(C1317j c1317j, int i) {
            this.f3082a = c1317j;
            this.f3083b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder == null) {
                this.f3082a.m4650b(new ConnectionResult(8, null, "ServiceBroker IBinder is null"));
                return;
            }
            synchronized (this.f3082a.f3059o) {
                this.f3082a.f3060p = C1361a.m4862a(iBinder);
            }
            this.f3082a.m4658a(0, null, this.f3083b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.f3082a.f3059o) {
                this.f3082a.f3060p = null;
            }
            this.f3082a.f3046a.sendMessage(this.f3082a.f3046a.obtainMessage(4, this.f3083b, 1));
        }
    }

    /* renamed from: com.google.android.gms.common.internal.j.i */
    protected class C1334i implements C1329f {
        final /* synthetic */ C1317j f3084a;

        public C1334i(C1317j c1317j) {
            this.f3084a = c1317j;
        }

        public void m4725a(ConnectionResult connectionResult) {
            if (connectionResult.m4452b()) {
                this.f3084a.m4663a(null, this.f3084a.m4685w());
            } else if (this.f3084a.f3066v != null) {
                this.f3084a.f3066v.m4715a(connectionResult);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.j.j */
    protected final class C1335j extends C1325a {
        public final IBinder f3085e;
        final /* synthetic */ C1317j f3086f;

        public C1335j(C1317j c1317j, int i, IBinder iBinder, Bundle bundle) {
            this.f3086f = c1317j;
            super(c1317j, i, bundle);
            this.f3085e = iBinder;
        }

        protected void m4726a(ConnectionResult connectionResult) {
            if (this.f3086f.f3066v != null) {
                this.f3086f.f3066v.m4715a(connectionResult);
            }
            this.f3086f.m4661a(connectionResult);
        }

        protected boolean m4727a() {
            try {
                String interfaceDescriptor = this.f3085e.getInterfaceDescriptor();
                if (this.f3086f.m4674j().equals(interfaceDescriptor)) {
                    IInterface a = this.f3086f.m4655a(this.f3085e);
                    if (a == null || !this.f3086f.m4647a(2, 3, a)) {
                        return false;
                    }
                    Bundle t = this.f3086f.m4682t();
                    if (this.f3086f.f3065u != null) {
                        this.f3086f.f3065u.m4714a(t);
                    }
                    return true;
                }
                String valueOf = String.valueOf(this.f3086f.m4674j());
                Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.j.k */
    protected final class C1336k extends C1325a {
        final /* synthetic */ C1317j f3087e;

        public C1336k(C1317j c1317j, int i, Bundle bundle) {
            this.f3087e = c1317j;
            super(c1317j, i, bundle);
        }

        protected void m4728a(ConnectionResult connectionResult) {
            this.f3087e.f3047b.m4718a(connectionResult);
            this.f3087e.m4661a(connectionResult);
        }

        protected boolean m4729a() {
            this.f3087e.f3047b.m4718a(ConnectionResult.f2957a);
            return true;
        }
    }

    static {
        f3045d = new String[]{"service_esmobile", "service_googleme"};
    }

    protected C1317j(Context context, Looper looper, int i, C1326b c1326b, C1327c c1327c, String str) {
        this(context, looper, C1347q.m4768a(context), C1261h.m4458b(), i, (C1326b) C1314c.m4623a((Object) c1326b), (C1327c) C1314c.m4623a((Object) c1327c), str);
    }

    protected C1317j(Context context, Looper looper, C1347q c1347q, C1261h c1261h, int i, C1326b c1326b, C1327c c1327c, String str) {
        this.f3058n = new Object();
        this.f3059o = new Object();
        this.f3062r = new ArrayList();
        this.f3064t = 1;
        this.f3048c = new AtomicInteger(0);
        this.f3054j = (Context) C1314c.m4624a((Object) context, (Object) "Context must not be null");
        this.f3055k = (Looper) C1314c.m4624a((Object) looper, (Object) "Looper must not be null");
        this.f3056l = (C1347q) C1314c.m4624a((Object) c1347q, (Object) "Supervisor must not be null");
        this.f3057m = (C1261h) C1314c.m4624a((Object) c1261h, (Object) "API availability must not be null");
        this.f3046a = new C1328d(this, looper);
        this.f3067w = i;
        this.f3065u = c1326b;
        this.f3066v = c1327c;
        this.f3068x = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4644a(int r5, T r6) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        r2 = 3;
        if (r5 != r2) goto L_0x001a;
    L_0x0005:
        r3 = r0;
    L_0x0006:
        if (r6 == 0) goto L_0x001c;
    L_0x0008:
        r2 = r0;
    L_0x0009:
        if (r3 != r2) goto L_0x001e;
    L_0x000b:
        com.google.android.gms.common.internal.C1314c.m4632b(r0);
        r1 = r4.f3058n;
        monitor-enter(r1);
        r4.f3064t = r5;	 Catch:{ all -> 0x0024 }
        r4.f3061q = r6;	 Catch:{ all -> 0x0024 }
        switch(r5) {
            case 1: goto L_0x002b;
            case 2: goto L_0x0020;
            case 3: goto L_0x0027;
            default: goto L_0x0018;
        };	 Catch:{ all -> 0x0024 }
    L_0x0018:
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        return;
    L_0x001a:
        r3 = r1;
        goto L_0x0006;
    L_0x001c:
        r2 = r1;
        goto L_0x0009;
    L_0x001e:
        r0 = r1;
        goto L_0x000b;
    L_0x0020:
        r4.m4653k();	 Catch:{ all -> 0x0024 }
        goto L_0x0018;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        throw r0;
    L_0x0027:
        r4.m4660a(r6);	 Catch:{ all -> 0x0024 }
        goto L_0x0018;
    L_0x002b:
        r4.m4654x();	 Catch:{ all -> 0x0024 }
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.j.a(int, android.os.IInterface):void");
    }

    private boolean m4647a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f3058n) {
            if (this.f3064t != i) {
                z = false;
            } else {
                m4644a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    private void m4650b(ConnectionResult connectionResult) {
        this.f3046a.sendMessage(this.f3046a.obtainMessage(3, this.f3048c.get(), connectionResult.m4453c(), connectionResult.m4454d()));
    }

    private void m4653k() {
        if (this.f3063s != null) {
            String valueOf = String.valueOf(m4673i());
            String valueOf2 = String.valueOf(a_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f3056l.m4770b(m4673i(), a_(), this.f3063s, m4675m());
            this.f3048c.incrementAndGet();
        }
        this.f3063s = new C1333h(this, this.f3048c.get());
        if (!this.f3056l.m4769a(m4673i(), a_(), this.f3063s, m4675m())) {
            valueOf = String.valueOf(m4673i());
            valueOf2 = String.valueOf(a_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            m4658a(16, null, this.f3048c.get());
        }
    }

    private void m4654x() {
        if (this.f3063s != null) {
            this.f3056l.m4770b(m4673i(), a_(), this.f3063s, m4675m());
            this.f3063s = null;
        }
    }

    protected abstract T m4655a(IBinder iBinder);

    public void m4656a() {
        this.f3048c.incrementAndGet();
        synchronized (this.f3062r) {
            int size = this.f3062r.size();
            for (int i = 0; i < size; i++) {
                ((C1324e) this.f3062r.get(i)).m4708d();
            }
            this.f3062r.clear();
        }
        synchronized (this.f3059o) {
            this.f3060p = null;
        }
        m4644a(1, null);
    }

    protected void m4657a(int i) {
        this.f3049e = i;
        this.f3050f = System.currentTimeMillis();
    }

    protected void m4658a(int i, Bundle bundle, int i2) {
        this.f3046a.sendMessage(this.f3046a.obtainMessage(5, i2, -1, new C1336k(this, i, bundle)));
    }

    protected void m4659a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f3046a.sendMessage(this.f3046a.obtainMessage(1, i2, -1, new C1335j(this, i, iBinder, bundle)));
    }

    protected void m4660a(T t) {
        this.f3051g = System.currentTimeMillis();
    }

    protected void m4661a(ConnectionResult connectionResult) {
        this.f3052h = connectionResult.m4453c();
        this.f3053i = System.currentTimeMillis();
    }

    public void m4662a(C1329f c1329f) {
        this.f3047b = (C1329f) C1314c.m4624a((Object) c1329f, (Object) "Connection progress callbacks cannot be null.");
        m4644a(2, null);
    }

    public void m4663a(C1308t c1308t, Set<Scope> set) {
        zzj a = new zzj(this.f3067w).m4879a(this.f3054j.getPackageName()).m4877a(m4680r());
        if (set != null) {
            a.m4880a((Collection) set);
        }
        if (m4668d()) {
            a.m4876a(m4679q()).m4878a(c1308t);
        } else if (m4684v()) {
            a.m4876a(m4678p());
        }
        try {
            synchronized (this.f3059o) {
                if (this.f3060p != null) {
                    this.f3060p.m4859a(new C1332g(this, this.f3048c.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m4665b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        } catch (SecurityException e3) {
            throw e3;
        } catch (Throwable e22) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e22);
            m4650b(new ConnectionResult(8, null, "IGmsServiceBroker.getService failed."));
        }
    }

    public void m4664a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f3058n) {
            int i = this.f3064t;
            IInterface iInterface = this.f3061q;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                printWriter.print("DISCONNECTED");
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                printWriter.print("CONNECTING");
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                printWriter.print("CONNECTED");
                break;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(m4674j()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f3051g > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f3051g;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f3051g)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f3050f > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f3049e) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f3049e));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.f3050f;
            valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f3050f)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f3053i > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(C1275b.m4529a(this.f3052h));
            append = printWriter.append(" lastFailedTime=");
            j = this.f3053i;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f3053i)));
            append.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j).append(" ").append(valueOf2).toString());
        }
    }

    protected String a_() {
        return "com.google.android.gms";
    }

    public void m4665b(int i) {
        this.f3046a.sendMessage(this.f3046a.obtainMessage(4, this.f3048c.get(), i));
    }

    public boolean m4666b() {
        boolean z;
        synchronized (this.f3058n) {
            z = this.f3064t == 3;
        }
        return z;
    }

    public boolean m4667c() {
        boolean z;
        synchronized (this.f3058n) {
            z = this.f3064t == 2;
        }
        return z;
    }

    public boolean m4668d() {
        return false;
    }

    public boolean m4669e() {
        return true;
    }

    public boolean m4670f() {
        return false;
    }

    public Intent m4671g() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public IBinder m4672h() {
        IBinder iBinder;
        synchronized (this.f3059o) {
            if (this.f3060p == null) {
                iBinder = null;
            } else {
                iBinder = this.f3060p.asBinder();
            }
        }
        return iBinder;
    }

    protected abstract String m4673i();

    protected abstract String m4674j();

    protected final String m4675m() {
        return this.f3068x == null ? this.f3054j.getClass().getName() : this.f3068x;
    }

    public void m4676n() {
        int a = this.f3057m.m4460a(this.f3054j);
        if (a != 0) {
            m4644a(1, null);
            this.f3047b = new C1334i(this);
            this.f3046a.sendMessage(this.f3046a.obtainMessage(3, this.f3048c.get(), a));
            return;
        }
        m4662a(new C1334i(this));
    }

    public final Context m4677o() {
        return this.f3054j;
    }

    public Account m4678p() {
        return null;
    }

    public final Account m4679q() {
        return m4678p() != null ? m4678p() : new Account("<<default account>>", "com.google");
    }

    protected Bundle m4680r() {
        return new Bundle();
    }

    protected final void m4681s() {
        if (!m4666b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle m4682t() {
        return null;
    }

    public final T m4683u() {
        T t;
        synchronized (this.f3058n) {
            if (this.f3064t == 4) {
                throw new DeadObjectException();
            }
            m4681s();
            C1314c.m4629a(this.f3061q != null, (Object) "Client is connected but service is null");
            t = this.f3061q;
        }
        return t;
    }

    public boolean m4684v() {
        return false;
    }

    protected Set<Scope> m4685w() {
        return Collections.EMPTY_SET;
    }
}
