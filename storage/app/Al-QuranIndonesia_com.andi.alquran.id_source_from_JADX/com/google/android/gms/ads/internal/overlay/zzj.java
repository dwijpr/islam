package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.ads.internal.overlay.zzab.C1128a;
import com.google.android.gms.internal.op;

@TargetApi(14)
@op
public abstract class zzj extends TextureView implements C1128a {
    protected final zzw f2387a;
    protected final zzab f2388b;

    public zzj(Context context) {
        super(context);
        this.f2387a = new zzw();
        this.f2388b = new zzab(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzi com_google_android_gms_ads_internal_overlay_zzi);

    public void zzb(float f) {
        this.f2388b.zzb(f);
        zzhh();
    }

    public void zzhE() {
        this.f2388b.setMuted(true);
        zzhh();
    }

    public void zzhF() {
        this.f2388b.setMuted(false);
        zzhh();
    }

    public abstract String zzhd();

    public abstract void zzhh();
}
