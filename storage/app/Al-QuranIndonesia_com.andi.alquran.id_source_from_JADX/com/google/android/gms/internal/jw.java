package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.internal.jk.C1633a;
import com.google.android.gms.internal.jl.C1689a;
import com.google.android.gms.p039a.C1111d;
import com.google.android.gms.p039a.C1113f;
import com.google.android.gms.p039a.C1113f.C1112a;

@op
public class jw extends C1113f<jl> {
    public jw() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public jk m7049a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return C1633a.m6603a(((jl) m3898a(context)).m7001a(C1111d.m3896a((Object) context), C1111d.m3896a((Object) frameLayout), C1111d.m3896a((Object) frameLayout2), 10084000));
        } catch (RemoteException e2) {
            e = e2;
            sg.m8447c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (C1112a e3) {
            e = e3;
            sg.m8447c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected /* synthetic */ Object m7050a(IBinder iBinder) {
        return m7051b(iBinder);
    }

    protected jl m7051b(IBinder iBinder) {
        return C1689a.m7003a(iBinder);
    }
}
