package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.jh.C1658a;
import com.google.android.gms.p039a.C1108c;
import java.util.ArrayList;
import java.util.List;

@op
public class jn extends NativeAppInstallAd {
    private final jm f4571a;
    private final List<Image> f4572b;
    private final jj f4573c;
    private VideoController f4574d;

    public jn(jm jmVar) {
        jj jjVar;
        this.f4572b = new ArrayList();
        this.f4574d = new VideoController();
        this.f4571a = jmVar;
        try {
            List<Object> b = this.f4571a.m6792b();
            if (b != null) {
                for (Object a : b) {
                    jh a2 = m7016a(a);
                    if (a2 != null) {
                        this.f4572b.add(new jj(a2));
                    }
                }
            }
        } catch (Throwable e) {
            sg.m8445b("Failed to get image.", e);
        }
        try {
            jh d = this.f4571a.m6794d();
            if (d != null) {
                jjVar = new jj(d);
                this.f4573c = jjVar;
            }
        } catch (Throwable e2) {
            sg.m8445b("Failed to get icon.", e2);
        }
        jjVar = null;
        this.f4573c = jjVar;
    }

    jh m7016a(Object obj) {
        return obj instanceof IBinder ? C1658a.m6787a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object m7017a() {
        return m7018b();
    }

    protected C1108c m7018b() {
        try {
            return this.f4571a.m6800j();
        } catch (Throwable e) {
            sg.m8445b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    public void destroy() {
        try {
            this.f4571a.m6802p();
        } catch (Throwable e) {
            sg.m8445b("Failed to destroy", e);
        }
    }

    public CharSequence getBody() {
        try {
            return this.f4571a.m6793c();
        } catch (Throwable e) {
            sg.m8445b("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.f4571a.m6795e();
        } catch (Throwable e) {
            sg.m8445b("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.f4571a.m6801n();
        } catch (Throwable e) {
            sg.m8445b("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.f4571a.m6791a();
        } catch (Throwable e) {
            sg.m8445b("Failed to get headline.", e);
            return null;
        }
    }

    public Image getIcon() {
        return this.f4573c;
    }

    public List<Image> getImages() {
        return this.f4572b;
    }

    public CharSequence getPrice() {
        try {
            return this.f4571a.m6798h();
        } catch (Throwable e) {
            sg.m8445b("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        Double d = null;
        try {
            double f = this.f4571a.m6796f();
            if (f != -1.0d) {
                d = Double.valueOf(f);
            }
        } catch (Throwable e) {
            sg.m8445b("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence getStore() {
        try {
            return this.f4571a.m6797g();
        } catch (Throwable e) {
            sg.m8445b("Failed to get store", e);
            return null;
        }
    }

    public VideoController getVideoController() {
        try {
            if (this.f4571a.m6799i() != null) {
                this.f4574d.zza(this.f4571a.m6799i());
            }
        } catch (Throwable e) {
            sg.m8445b("Exception occurred while getting video controller", e);
        }
        return this.f4574d;
    }
}
