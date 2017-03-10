package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;

@op
public final class sa extends rl {
    private final sh f5817a;
    private final String f5818b;

    public sa(Context context, String str, String str2) {
        this(str2, zzv.zzcJ().m8498a(context, str));
    }

    public sa(String str, String str2) {
        this.f5817a = new sh(str2);
        this.f5818b = str;
    }

    public void onStop() {
    }

    public void zzcm() {
        this.f5817a.m8709a(this.f5818b);
    }
}
