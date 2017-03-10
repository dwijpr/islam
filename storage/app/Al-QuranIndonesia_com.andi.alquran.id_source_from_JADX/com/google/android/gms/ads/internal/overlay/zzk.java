package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sx;

@op
public abstract class zzk {
    protected boolean m3978a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return C1387m.m4961c() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11);
    }

    protected boolean m3979a(sx sxVar) {
        return sxVar.m8775k().f6455e;
    }

    public abstract zzj zza(Context context, sx sxVar, int i, boolean z, io ioVar);
}
