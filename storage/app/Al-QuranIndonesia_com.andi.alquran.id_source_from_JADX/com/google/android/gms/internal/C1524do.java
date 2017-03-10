package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.au.C1444a;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.do */
public class C1524do extends er {
    public C1524do(dc dcVar, String str, String str2, C1444a c1444a, int i, int i2) {
        super(dcVar, str, str2, c1444a, i, i2);
    }

    private void m5760c() {
        synchronized (this.e) {
            this.e.aa = (String) this.f.invoke(null, new Object[]{this.b.m5699b()});
        }
    }

    private void m5761d() {
        AdvertisingIdClient o = this.b.m5712o();
        if (o != null) {
            try {
                Info info = o.getInfo();
                String a = de.m5719a(info.getId());
                if (a != null) {
                    synchronized (this.e) {
                        this.e.aa = a;
                        this.e.ac = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                        this.e.ab = Integer.valueOf(5);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    protected void m5762a() {
        if (this.b.m5705h()) {
            m5761d();
        } else {
            m5760c();
        }
    }
}
