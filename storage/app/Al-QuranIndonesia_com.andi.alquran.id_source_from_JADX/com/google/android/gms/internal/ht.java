package com.google.android.gms.internal;

import com.google.android.gms.internal.qa.C1635a;
import com.google.android.gms.p039a.C1108c;

public class ht extends C1635a {
    private qc f4315a;

    /* renamed from: com.google.android.gms.internal.ht.1 */
    class C16341 implements Runnable {
        final /* synthetic */ ht f4314a;

        C16341(ht htVar) {
            this.f4314a = htVar;
        }

        public void run() {
            if (this.f4314a.f4315a != null) {
                try {
                    this.f4314a.f4315a.m7224a(1);
                } catch (Throwable e) {
                    sg.m8447c("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void m6621a() {
    }

    public void m6622a(C1108c c1108c) {
    }

    public void m6623a(qc qcVar) {
        this.f4315a = qcVar;
    }

    public void m6624a(zznx com_google_android_gms_internal_zznx) {
        sg.m8446c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        sf.f5831a.post(new C16341(this));
    }

    public void m6625a(String str) {
    }

    public void m6626b(C1108c c1108c) {
    }

    public boolean m6627b() {
        return false;
    }

    public void m6628c() {
    }

    public void m6629c(C1108c c1108c) {
    }

    public void m6630d() {
    }

    public void m6631e() {
    }
}
