package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.vl;

public final class AnalyticsReceiver extends BroadcastReceiver {
    private vl f2800a;

    private vl m4178a() {
        if (this.f2800a == null) {
            this.f2800a = new vl();
        }
        return this.f2800a;
    }

    public void onReceive(Context context, Intent intent) {
        m4178a().m9492a(context, intent);
    }
}
