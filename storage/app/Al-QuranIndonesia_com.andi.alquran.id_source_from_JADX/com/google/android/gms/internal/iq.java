package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.p039a.C1111d;

@op
public class iq implements CustomRenderedAd {
    private final ir f4427a;

    public iq(ir irVar) {
        this.f4427a = irVar;
    }

    public String getBaseUrl() {
        try {
            return this.f4427a.m6751a();
        } catch (Throwable e) {
            sg.m8447c("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.f4427a.m6753b();
        } catch (Throwable e) {
            sg.m8447c("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.f4427a.m6752a(view != null ? C1111d.m3896a((Object) view) : null);
        } catch (Throwable e) {
            sg.m8447c("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.f4427a.m6754c();
        } catch (Throwable e) {
            sg.m8447c("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.f4427a.m6755d();
        } catch (Throwable e) {
            sg.m8447c("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
