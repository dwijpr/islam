package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.internal.ex.C1536a;
import com.google.android.gms.internal.ey.C1539a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import com.google.android.gms.p039a.C1113f;
import com.google.android.gms.p039a.C1113f.C1112a;

public final class ew extends C1113f<ey> {
    private static final ew f3927a;

    static {
        f3927a = new ew();
    }

    private ew() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static ex m6006a(String str, Context context, boolean z) {
        if (C1261h.m4458b().m4460a(context) == 0) {
            ex b = f3927a.m6007b(str, context, z);
            if (b != null) {
                return b;
            }
        }
        return new ev(str, context, z);
    }

    private ex m6007b(String str, Context context, boolean z) {
        IBinder a;
        C1108c a2 = C1111d.m3896a((Object) context);
        if (z) {
            try {
                a = ((ey) m3898a(context)).m6022a(str, a2);
            } catch (RemoteException e) {
                return null;
            } catch (C1112a e2) {
                return null;
            }
        }
        a = ((ey) m3898a(context)).m6023b(str, a2);
        return C1536a.m5992a(a);
    }

    protected /* synthetic */ Object m6008a(IBinder iBinder) {
        return m6009b(iBinder);
    }

    protected ey m6009b(IBinder iBinder) {
        return C1539a.m6026a(iBinder);
    }
}
