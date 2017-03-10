package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;

public interface tm extends MediationInterstitialAdapter {
    Bundle getInterstitialAdapterInfo();
}
