package com.google.android.gms.maps.internal;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.p039a.C1097a;

public interface StreetViewLifecycleDelegate extends C1097a {
    void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback);
}
