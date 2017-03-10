package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.C1292b;
import com.google.android.gms.common.C1295j;
import com.google.android.gms.common.C1297f;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.stats.C1367a;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.ez.C1541a;
import com.google.android.gms.maps.GoogleMap;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    C1297f f2348a;
    ez f2349b;
    boolean f2350c;
    Object f2351d;
    C1121a f2352e;
    final long f2353f;
    private final Context f2354g;

    /* renamed from: com.google.android.gms.ads.identifier.AdvertisingIdClient.1 */
    class C11201 extends Thread {
        final /* synthetic */ String f2341a;

        C11201(AdvertisingIdClient advertisingIdClient, String str) {
            this.f2341a = str;
        }

        public void run() {
            new zza().zzu(this.f2341a);
        }
    }

    public static final class Info {
        private final String f2342a;
        private final boolean f2343b;

        public Info(String str, boolean z) {
            this.f2342a = str;
            this.f2343b = z;
        }

        public String getId() {
            return this.f2342a;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f2343b;
        }

        public String toString() {
            String str = this.f2342a;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.f2343b).toString();
        }
    }

    /* renamed from: com.google.android.gms.ads.identifier.AdvertisingIdClient.a */
    static class C1121a extends Thread {
        CountDownLatch f2344a;
        boolean f2345b;
        private WeakReference<AdvertisingIdClient> f2346c;
        private long f2347d;

        public C1121a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f2346c = new WeakReference(advertisingIdClient);
            this.f2347d = j;
            this.f2344a = new CountDownLatch(1);
            this.f2345b = false;
            start();
        }

        private void m3917c() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f2346c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f2345b = true;
            }
        }

        public void m3918a() {
            this.f2344a.countDown();
        }

        public boolean m3919b() {
            return this.f2345b;
        }

        public void run() {
            try {
                if (!this.f2344a.await(this.f2347d, TimeUnit.MILLISECONDS)) {
                    m3917c();
                }
            } catch (InterruptedException e) {
                m3917c();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z) {
        this.f2351d = new Object();
        C1314c.m4623a((Object) context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.f2354g = context;
        } else {
            this.f2354g = context;
        }
        this.f2350c = false;
        this.f2353f = j;
    }

    static C1297f m3920a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (C1261h.m4458b().m4460a(context)) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    ServiceConnection c1297f = new C1297f();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (C1367a.m4904a().m4910a(context, intent, c1297f, 1)) {
                            return c1297f;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new C1292b(9);
        }
    }

    static ez m3921a(Context context, C1297f c1297f) {
        try {
            return C1541a.m6035a(c1297f.m4598a(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void m3922a() {
        synchronized (this.f2351d) {
            if (this.f2352e != null) {
                this.f2352e.m3918a();
                try {
                    this.f2352e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f2353f > 0) {
                this.f2352e = new C1121a(this, this.f2353f);
            }
        }
    }

    private void m3923a(Info info, boolean z, float f, Throwable th) {
        if (Math.random() <= ((double) f)) {
            new C11201(this, m3924a(info, z, th).toString()).start();
        }
    }

    public static Info getAdvertisingIdInfo(Context context) {
        Info info;
        float f = 0.0f;
        boolean z = false;
        try {
            Context i = C1295j.m4592i(context);
            if (i != null) {
                SharedPreferences sharedPreferences = i.getSharedPreferences("google_ads_flags", 1);
                z = sharedPreferences.getBoolean("gads:ad_id_app_context:enabled", false);
                f = sharedPreferences.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
            }
        } catch (Throwable e) {
            Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", e);
        }
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z);
        try {
            advertisingIdClient.m3925a(false);
            info = advertisingIdClient.getInfo();
            advertisingIdClient.m3923a(info, z, f, null);
            return info;
        } catch (Throwable th) {
            info = th;
            advertisingIdClient.m3923a(null, z, f, info);
            return null;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    Uri m3924a(Info info, boolean z, Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putString("app_context", z ? "1" : "0");
        if (info != null) {
            bundle.putString("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (!(info == null || info.getId() == null)) {
            bundle.putString("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            bundle.putString("error", th.getClass().getName());
        }
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : bundle.keySet()) {
            buildUpon.appendQueryParameter(str, bundle.getString(str));
        }
        return buildUpon.build();
    }

    protected void m3925a(boolean z) {
        C1314c.m4635c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f2350c) {
                finish();
            }
            this.f2348a = m3920a(this.f2354g);
            this.f2349b = m3921a(this.f2354g, this.f2348a);
            this.f2350c = true;
            if (z) {
                m3922a();
            }
        }
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    public void finish() {
        C1314c.m4635c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f2354g == null || this.f2348a == null) {
                return;
            }
            try {
                if (this.f2350c) {
                    C1367a.m4904a().m4908a(this.f2354g, this.f2348a);
                }
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            } catch (Throwable e2) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e2);
            }
            this.f2350c = false;
            this.f2349b = null;
            this.f2348a = null;
        }
    }

    public Info getInfo() {
        Info info;
        C1314c.m4635c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f2350c) {
                synchronized (this.f2351d) {
                    if (this.f2352e == null || !this.f2352e.m3919b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    m3925a(false);
                    if (!this.f2350c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C1314c.m4623a(this.f2348a);
            C1314c.m4623a(this.f2349b);
            info = new Info(this.f2349b.m6027a(), this.f2349b.m6030a(true));
        }
        m3922a();
        return info;
    }

    public void start() {
        m3925a(true);
    }
}
