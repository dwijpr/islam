package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.jh.C1658a;
import com.google.android.gms.p039a.C1108c;
import java.util.ArrayList;
import java.util.List;

@op
public class jp extends NativeContentAd {
    private final jo f4576a;
    private final List<Image> f4577b;
    private final jj f4578c;

    public jp(jo joVar) {
        jj jjVar;
        this.f4577b = new ArrayList();
        this.f4576a = joVar;
        try {
            List<Object> b = this.f4576a.m6826b();
            if (b != null) {
                for (Object a : b) {
                    jh a2 = m7028a(a);
                    if (a2 != null) {
                        this.f4577b.add(new jj(a2));
                    }
                }
            }
        } catch (Throwable e) {
            sg.m8445b("Failed to get image.", e);
        }
        try {
            jh d = this.f4576a.m6828d();
            if (d != null) {
                jjVar = new jj(d);
                this.f4578c = jjVar;
            }
        } catch (Throwable e2) {
            sg.m8445b("Failed to get icon.", e2);
        }
        jjVar = null;
        this.f4578c = jjVar;
    }

    jh m7028a(Object obj) {
        return obj instanceof IBinder ? C1658a.m6787a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object m7029a() {
        return m7030b();
    }

    protected C1108c m7030b() {
        try {
            return this.f4576a.m6831g();
        } catch (Throwable e) {
            sg.m8445b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    public void destroy() {
        try {
            this.f4576a.m6833i();
        } catch (Throwable e) {
            sg.m8445b("Failed to destroy", e);
        }
    }

    public CharSequence getAdvertiser() {
        try {
            return this.f4576a.m6830f();
        } catch (Throwable e) {
            sg.m8445b("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence getBody() {
        try {
            return this.f4576a.m6827c();
        } catch (Throwable e) {
            sg.m8445b("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.f4576a.m6829e();
        } catch (Throwable e) {
            sg.m8445b("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.f4576a.m6832h();
        } catch (Throwable e) {
            sg.m8447c("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.f4576a.m6825a();
        } catch (Throwable e) {
            sg.m8445b("Failed to get headline.", e);
            return null;
        }
    }

    public List<Image> getImages() {
        return this.f4577b;
    }

    public Image getLogo() {
        return this.f4578c;
    }
}
