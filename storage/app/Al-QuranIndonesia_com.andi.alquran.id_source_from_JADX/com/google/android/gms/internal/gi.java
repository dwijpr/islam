package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.gz.C1154a;
import com.google.android.gms.internal.ha.C1616a;
import com.google.android.gms.p039a.C1111d;
import com.google.android.gms.p039a.C1113f;
import com.google.android.gms.p039a.C1113f.C1112a;

@op
public class gi extends C1113f<ha> {
    public gi() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public gz m6327a(Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i) {
        Throwable e;
        try {
            return C1154a.zzq(((ha) m3898a(context)).m6440a(C1111d.m3896a((Object) context), com_google_android_gms_internal_zzec, str, mdVar, 10084000, i));
        } catch (RemoteException e2) {
            e = e2;
            sg.m8442a("Could not create remote AdManager.", e);
            return null;
        } catch (C1112a e3) {
            e = e3;
            sg.m8442a("Could not create remote AdManager.", e);
            return null;
        }
    }

    protected /* synthetic */ Object m6328a(IBinder iBinder) {
        return m6329b(iBinder);
    }

    protected ha m6329b(IBinder iBinder) {
        return C1616a.m6443a(iBinder);
    }
}
