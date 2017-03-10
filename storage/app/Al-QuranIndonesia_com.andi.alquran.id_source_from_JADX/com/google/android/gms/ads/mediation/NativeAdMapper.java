package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.internal.op;

@op
public abstract class NativeAdMapper {
    protected boolean f2242a;
    protected boolean f2243b;
    protected Bundle f2244c;

    public NativeAdMapper() {
        this.f2244c = new Bundle();
    }

    public final Bundle getExtras() {
        return this.f2244c;
    }

    public final boolean getOverrideClickHandling() {
        return this.f2243b;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.f2242a;
    }

    public void handleClick(View view) {
    }

    public void recordImpression() {
    }

    public final void setExtras(Bundle bundle) {
        this.f2244c = bundle;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.f2243b = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.f2242a = z;
    }

    public void trackView(View view) {
    }

    public void untrackView(View view) {
    }
}
