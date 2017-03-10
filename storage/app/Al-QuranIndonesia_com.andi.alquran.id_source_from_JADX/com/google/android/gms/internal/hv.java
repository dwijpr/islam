package com.google.android.gms.internal;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import com.google.android.gms.internal.hh.C1626a;

public final class hv extends C1626a {
    private final VideoLifecycleCallbacks f4316a;

    public hv(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.f4316a = videoLifecycleCallbacks;
    }

    public void m6635a() {
    }

    public void m6636b() {
    }

    public void m6637c() {
    }

    public void m6638d() {
        this.f4316a.onVideoEnd();
    }
}
