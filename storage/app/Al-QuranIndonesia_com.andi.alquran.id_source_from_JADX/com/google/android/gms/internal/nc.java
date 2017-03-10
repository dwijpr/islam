package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.internal.nd.C1144a;
import com.google.android.gms.internal.ne.C1832a;
import com.google.android.gms.p039a.C1111d;
import com.google.android.gms.p039a.C1113f;

@op
public final class nc extends C1113f<ne> {
    public nc() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public nd m7756a(Activity activity) {
        try {
            return C1144a.zzT(((ne) m3898a((Context) activity)).m7759a(C1111d.m3896a((Object) activity)));
        } catch (Throwable e) {
            sg.m8447c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            sg.m8447c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m7757a(IBinder iBinder) {
        return m7758b(iBinder);
    }

    protected ne m7758b(IBinder iBinder) {
        return C1832a.m7761a(iBinder);
    }
}
