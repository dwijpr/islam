package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.C1314c;

class vh extends BroadcastReceiver {
    static final String f6210a;
    private final uf f6211b;
    private boolean f6212c;
    private boolean f6213d;

    static {
        f6210a = vh.class.getName();
    }

    vh(uf ufVar) {
        C1314c.m4623a((Object) ufVar);
        this.f6211b = ufVar;
    }

    private void m9435g() {
        m9437i();
        m9438j();
    }

    private Context m9436h() {
        return this.f6211b.m9154b();
    }

    private vg m9437i() {
        return this.f6211b.m9158f();
    }

    private ub m9438j() {
        return this.f6211b.m9161i();
    }

    public void m9439a() {
        m9435g();
        if (!this.f6212c) {
            Context h = m9436h();
            h.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(h.getPackageName());
            h.registerReceiver(this, intentFilter);
            this.f6213d = m9444f();
            this.f6211b.m9158f().m4247a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f6213d));
            this.f6212c = true;
        }
    }

    public void m9440b() {
        if (m9442d()) {
            this.f6211b.m9158f().m4250b("Unregistering connectivity change receiver");
            this.f6212c = false;
            this.f6213d = false;
            try {
                m9436h().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m9437i().m4261e("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void m9441c() {
        if (VERSION.SDK_INT > 10) {
            Context h = m9436h();
            Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
            intent.addCategory(h.getPackageName());
            intent.putExtra(f6210a, true);
            h.sendOrderedBroadcast(intent, null);
        }
    }

    public boolean m9442d() {
        return this.f6212c;
    }

    public boolean m9443e() {
        if (!this.f6212c) {
            this.f6211b.m9158f().m4260e("Connectivity unknown. Receiver not registered");
        }
        return this.f6213d;
    }

    protected boolean m9444f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) m9436h().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        m9435g();
        String action = intent.getAction();
        this.f6211b.m9158f().m4247a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f = m9444f();
            if (this.f6213d != f) {
                this.f6213d = f;
                m9438j().m9143a(f);
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f6211b.m9158f().m4258d("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(f6210a)) {
            m9438j().m9148f();
        }
    }
}
