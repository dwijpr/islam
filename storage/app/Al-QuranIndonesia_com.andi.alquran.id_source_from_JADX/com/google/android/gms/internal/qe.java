package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.qa.C1635a;
import com.google.android.gms.internal.qb.C1927a;
import com.google.android.gms.p039a.C1111d;
import com.google.android.gms.p039a.C1113f;
import com.google.android.gms.p039a.C1113f.C1112a;

@op
public class qe extends C1113f<qb> {
    public qe() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public qa m8268a(Context context, md mdVar) {
        Throwable e;
        try {
            return C1635a.m6619a(((qb) m3898a(context)).m8258a(C1111d.m3896a((Object) context), mdVar, 10084000));
        } catch (RemoteException e2) {
            e = e2;
            sg.m8447c("Could not get remote RewardedVideoAd.", e);
            return null;
        } catch (C1112a e3) {
            e = e3;
            sg.m8447c("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    protected /* synthetic */ Object m8269a(IBinder iBinder) {
        return m8270b(iBinder);
    }

    protected qb m8270b(IBinder iBinder) {
        return C1927a.m8260a(iBinder);
    }
}
