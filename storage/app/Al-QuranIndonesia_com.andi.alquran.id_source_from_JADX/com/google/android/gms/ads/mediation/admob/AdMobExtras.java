package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras implements NetworkExtras {
    private final Bundle f2752a;

    public AdMobExtras(Bundle bundle) {
        this.f2752a = bundle != null ? new Bundle(bundle) : null;
    }

    public Bundle getExtras() {
        return this.f2752a;
    }
}
