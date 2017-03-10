package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.C1367a;
import com.google.android.gms.maps.GoogleMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.r */
final class C1351r extends C1347q implements Callback {
    private final HashMap<C1348a, C1350b> f3132a;
    private final Context f3133b;
    private final Handler f3134c;
    private final C1367a f3135d;
    private final long f3136e;

    /* renamed from: com.google.android.gms.common.internal.r.a */
    private static final class C1348a {
        private final String f3120a;
        private final String f3121b;
        private final ComponentName f3122c;

        public C1348a(String str, String str2) {
            this.f3120a = C1314c.m4625a(str);
            this.f3121b = C1314c.m4625a(str2);
            this.f3122c = null;
        }

        public Intent m4771a() {
            return this.f3120a != null ? new Intent(this.f3120a).setPackage(this.f3121b) : new Intent().setComponent(this.f3122c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1348a)) {
                return false;
            }
            C1348a c1348a = (C1348a) obj;
            return C1313b.m4621a(this.f3120a, c1348a.f3120a) && C1313b.m4621a(this.f3122c, c1348a.f3122c);
        }

        public int hashCode() {
            return C1313b.m4619a(this.f3120a, this.f3122c);
        }

        public String toString() {
            return this.f3120a == null ? this.f3122c.flattenToString() : this.f3120a;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.r.b */
    private final class C1350b {
        final /* synthetic */ C1351r f3124a;
        private final C1349a f3125b;
        private final Set<ServiceConnection> f3126c;
        private int f3127d;
        private boolean f3128e;
        private IBinder f3129f;
        private final C1348a f3130g;
        private ComponentName f3131h;

        /* renamed from: com.google.android.gms.common.internal.r.b.a */
        public class C1349a implements ServiceConnection {
            final /* synthetic */ C1350b f3123a;

            public C1349a(C1350b c1350b) {
                this.f3123a = c1350b;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.f3123a.f3124a.f3132a) {
                    this.f3123a.f3129f = iBinder;
                    this.f3123a.f3131h = componentName;
                    for (ServiceConnection onServiceConnected : this.f3123a.f3126c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.f3123a.f3127d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.f3123a.f3124a.f3132a) {
                    this.f3123a.f3129f = null;
                    this.f3123a.f3131h = componentName;
                    for (ServiceConnection onServiceDisconnected : this.f3123a.f3126c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.f3123a.f3127d = 2;
                }
            }
        }

        public C1350b(C1351r c1351r, C1348a c1348a) {
            this.f3124a = c1351r;
            this.f3130g = c1348a;
            this.f3125b = new C1349a(this);
            this.f3126c = new HashSet();
            this.f3127d = 2;
        }

        public void m4776a(ServiceConnection serviceConnection, String str) {
            this.f3124a.f3135d.m4909a(this.f3124a.f3133b, serviceConnection, str, this.f3130g.m4771a());
            this.f3126c.add(serviceConnection);
        }

        @TargetApi(14)
        public void m4777a(String str) {
            this.f3127d = 3;
            this.f3128e = this.f3124a.f3135d.m4911a(this.f3124a.f3133b, str, this.f3130g.m4771a(), this.f3125b, 129);
            if (!this.f3128e) {
                this.f3127d = 2;
                try {
                    this.f3124a.f3135d.m4908a(this.f3124a.f3133b, this.f3125b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public boolean m4778a() {
            return this.f3128e;
        }

        public boolean m4779a(ServiceConnection serviceConnection) {
            return this.f3126c.contains(serviceConnection);
        }

        public int m4780b() {
            return this.f3127d;
        }

        public void m4781b(ServiceConnection serviceConnection, String str) {
            this.f3124a.f3135d.m4912b(this.f3124a.f3133b, serviceConnection);
            this.f3126c.remove(serviceConnection);
        }

        public void m4782b(String str) {
            this.f3124a.f3135d.m4908a(this.f3124a.f3133b, this.f3125b);
            this.f3128e = false;
            this.f3127d = 2;
        }

        public boolean m4783c() {
            return this.f3126c.isEmpty();
        }

        public IBinder m4784d() {
            return this.f3129f;
        }

        public ComponentName m4785e() {
            return this.f3131h;
        }
    }

    C1351r(Context context) {
        this.f3132a = new HashMap();
        this.f3133b = context.getApplicationContext();
        this.f3134c = new Handler(context.getMainLooper(), this);
        this.f3135d = C1367a.m4904a();
        this.f3136e = 5000;
    }

    private boolean m4787a(C1348a c1348a, ServiceConnection serviceConnection, String str) {
        boolean a;
        C1314c.m4624a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f3132a) {
            C1350b c1350b = (C1350b) this.f3132a.get(c1348a);
            if (c1350b != null) {
                this.f3134c.removeMessages(0, c1348a);
                if (!c1350b.m4779a(serviceConnection)) {
                    c1350b.m4776a(serviceConnection, str);
                    switch (c1350b.m4780b()) {
                        case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            serviceConnection.onServiceConnected(c1350b.m4785e(), c1350b.m4784d());
                            break;
                        case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            c1350b.m4777a(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(c1348a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            c1350b = new C1350b(this, c1348a);
            c1350b.m4776a(serviceConnection, str);
            c1350b.m4777a(str);
            this.f3132a.put(c1348a, c1350b);
            a = c1350b.m4778a();
        }
        return a;
    }

    private void m4789b(C1348a c1348a, ServiceConnection serviceConnection, String str) {
        C1314c.m4624a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f3132a) {
            C1350b c1350b = (C1350b) this.f3132a.get(c1348a);
            String valueOf;
            if (c1350b == null) {
                valueOf = String.valueOf(c1348a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (c1350b.m4779a(serviceConnection)) {
                c1350b.m4781b(serviceConnection, str);
                if (c1350b.m4783c()) {
                    this.f3134c.sendMessageDelayed(this.f3134c.obtainMessage(0, c1348a), this.f3136e);
                }
            } else {
                valueOf = String.valueOf(c1348a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean m4791a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return m4787a(new C1348a(str, str2), serviceConnection, str3);
    }

    public void m4792b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        m4789b(new C1348a(str, str2), serviceConnection, str3);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                C1348a c1348a = (C1348a) message.obj;
                synchronized (this.f3132a) {
                    C1350b c1350b = (C1350b) this.f3132a.get(c1348a);
                    if (c1350b != null && c1350b.m4783c()) {
                        if (c1350b.m4778a()) {
                            c1350b.m4782b("GmsClientSupervisor");
                        }
                        this.f3132a.remove(c1348a);
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
