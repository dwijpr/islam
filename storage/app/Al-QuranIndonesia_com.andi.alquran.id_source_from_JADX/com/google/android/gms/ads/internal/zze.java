package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.zzmm;

@op
public class zze {
    private final Context f2573a;
    private final zzmm f2574b;
    private boolean f2575c;

    public zze(Context context) {
        this(context, false);
    }

    public zze(Context context, C1938a c1938a) {
        this.f2573a = context;
        if (c1938a == null || c1938a.f5595b.f6572G == null) {
            this.f2574b = new zzmm();
        } else {
            this.f2574b = c1938a.f5595b.f6572G;
        }
    }

    public zze(Context context, boolean z) {
        this.f2573a = context;
        this.f2574b = new zzmm(z);
    }

    public void recordClick() {
        this.f2575c = true;
    }

    public boolean zzcb() {
        return !this.f2574b.f6609b || this.f2575c;
    }

    public void zzx(String str) {
        if (str == null) {
            str = BuildConfig.VERSION_NAME;
        }
        sg.m8448d("Action was blocked because no touch was detected.");
        if (this.f2574b.f6609b && this.f2574b.f6610c != null) {
            for (String str2 : this.f2574b.f6610c) {
                if (!TextUtils.isEmpty(str2)) {
                    zzv.zzcJ().m8512a(this.f2573a, BuildConfig.VERSION_NAME, str2.replace("{NAVIGATION_URL}", Uri.encode(str)));
                }
            }
        }
    }
}
