package com.google.android.gms.internal;

import com.google.android.gms.internal.gw.C1175a;
import com.google.android.gms.internal.gx.C1176a;

public class hp extends C1176a {
    private gv f4311a;

    /* renamed from: com.google.android.gms.internal.hp.a */
    private class C1631a extends C1175a {
        final /* synthetic */ hp f4310a;

        /* renamed from: com.google.android.gms.internal.hp.a.1 */
        class C16301 implements Runnable {
            final /* synthetic */ C1631a f4309a;

            C16301(C1631a c1631a) {
                this.f4309a = c1631a;
            }

            public void run() {
                if (this.f4309a.f4310a.f4311a != null) {
                    try {
                        this.f4309a.f4310a.f4311a.m6314a(1);
                    } catch (Throwable e) {
                        sg.m8447c("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        }

        private C1631a(hp hpVar) {
            this.f4310a = hpVar;
        }

        public String getMediationAdapterClassName() {
            return null;
        }

        public boolean isLoading() {
            return false;
        }

        public void zzf(zzdy com_google_android_gms_internal_zzdy) {
            sg.m8446c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            sf.f5831a.post(new C16301(this));
        }
    }

    public void zza(js jsVar) {
    }

    public void zza(jt jtVar) {
    }

    public void zza(zzgw com_google_android_gms_internal_zzgw) {
    }

    public void zza(String str, jv jvVar, ju juVar) {
    }

    public void zzb(gv gvVar) {
        this.f4311a = gvVar;
    }

    public void zzb(hd hdVar) {
    }

    public gw zzci() {
        return new C1631a();
    }
}
