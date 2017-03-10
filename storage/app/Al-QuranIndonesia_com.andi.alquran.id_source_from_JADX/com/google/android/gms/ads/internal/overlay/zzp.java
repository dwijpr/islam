package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.op;

@op
public class zzp extends FrameLayout implements OnClickListener {
    private final ImageButton f2454a;
    private final zzv f2455b;

    public zzp(Context context, int i, zzv com_google_android_gms_ads_internal_overlay_zzv) {
        super(context);
        this.f2455b = com_google_android_gms_ads_internal_overlay_zzv;
        setOnClickListener(this);
        this.f2454a = new ImageButton(context);
        this.f2454a.setImageResource(17301527);
        this.f2454a.setBackgroundColor(0);
        this.f2454a.setOnClickListener(this);
        this.f2454a.setPadding(0, 0, 0, 0);
        this.f2454a.setContentDescription("Interstitial close button");
        int a = gr.m6416a().m8690a(context, i);
        addView(this.f2454a, new LayoutParams(a, a, 17));
    }

    public void onClick(View view) {
        if (this.f2455b != null) {
            this.f2455b.zzhj();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.f2454a.setVisibility(0);
        } else if (z) {
            this.f2454a.setVisibility(4);
        } else {
            this.f2454a.setVisibility(8);
        }
    }
}
