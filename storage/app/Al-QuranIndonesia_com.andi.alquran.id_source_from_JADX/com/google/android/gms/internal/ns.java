package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.internal.nn.C1150a;
import com.google.android.gms.internal.no.C1839a;
import com.google.android.gms.p039a.C1111d;
import com.google.android.gms.p039a.C1113f;

@op
public final class ns extends C1113f<no> {
    public ns() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public nn m7783a(Activity activity) {
        try {
            return C1150a.zzY(((no) m3898a((Context) activity)).m7774a(C1111d.m3896a((Object) activity)));
        } catch (Throwable e) {
            sg.m8447c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            sg.m8447c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m7784a(IBinder iBinder) {
        return m7785b(iBinder);
    }

    protected no m7785b(IBinder iBinder) {
        return C1839a.m7776a(iBinder);
    }
}
