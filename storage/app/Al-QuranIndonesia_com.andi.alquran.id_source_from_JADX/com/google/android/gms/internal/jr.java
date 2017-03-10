package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;

@op
public class jr implements NativeCustomTemplateAd {
    private final jq f4580a;

    public jr(jq jqVar) {
        this.f4580a = jqVar;
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.f4580a.m6900a();
        } catch (Throwable e) {
            sg.m8445b("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.f4580a.m6904l();
        } catch (Throwable e) {
            sg.m8445b("Failed to get custom template id.", e);
            return null;
        }
    }

    public Image getImage(String str) {
        try {
            jh b = this.f4580a.m6901b(str);
            if (b != null) {
                return new jj(b);
            }
        } catch (Throwable e) {
            sg.m8445b("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String str) {
        try {
            return this.f4580a.m6899a(str);
        } catch (Throwable e) {
            sg.m8445b("Failed to get string.", e);
            return null;
        }
    }

    public void performClick(String str) {
        try {
            this.f4580a.m6903c(str);
        } catch (Throwable e) {
            sg.m8445b("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.f4580a.m6902b();
        } catch (Throwable e) {
            sg.m8445b("Failed to record impression.", e);
        }
    }
}
