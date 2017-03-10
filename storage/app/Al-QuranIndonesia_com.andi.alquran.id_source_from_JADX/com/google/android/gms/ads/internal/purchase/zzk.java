package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;

@op
public class zzk {
    private final String f2544a;

    public zzk(String str) {
        this.f2544a = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String zze = zzv.zzcX().zze(intent);
        String zzf = zzv.zzcX().zzf(intent);
        if (zze == null || zzf == null) {
            return false;
        }
        if (!str.equals(zzv.zzcX().zzaD(zze))) {
            sg.m8449e("Developer payload not match.");
            return false;
        } else if (this.f2544a == null || zzl.zzc(this.f2544a, zze, zzf)) {
            return true;
        } else {
            sg.m8449e("Fail to verify signature.");
            return false;
        }
    }

    public String zzis() {
        return zzv.zzcJ().m8543d();
    }
}
