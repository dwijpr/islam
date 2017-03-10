package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.google.android.gms.internal.op;

@TargetApi(14)
@op
public class zzab implements OnAudioFocusChangeListener {
    private final AudioManager f2369a;
    private final C1128a f2370b;
    private boolean f2371c;
    private boolean f2372d;
    private boolean f2373e;
    private float f2374f;

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzab.a */
    interface C1128a {
        void zzhh();
    }

    public zzab(Context context, C1128a c1128a) {
        this.f2374f = 1.0f;
        this.f2369a = (AudioManager) context.getSystemService("audio");
        this.f2370b = c1128a;
    }

    private void m3955a() {
        Object obj = (!this.f2372d || this.f2373e || this.f2374f <= 0.0f) ? null : 1;
        if (obj != null && !this.f2371c) {
            m3956b();
            this.f2370b.zzhh();
        } else if (obj == null && this.f2371c) {
            m3957c();
            this.f2370b.zzhh();
        }
    }

    private void m3956b() {
        boolean z = true;
        if (this.f2369a != null && !this.f2371c) {
            if (this.f2369a.requestAudioFocus(this, 3, 2) != 1) {
                z = false;
            }
            this.f2371c = z;
        }
    }

    private void m3957c() {
        if (this.f2369a != null && this.f2371c) {
            this.f2371c = this.f2369a.abandonAudioFocus(this) == 0;
        }
    }

    public void onAudioFocusChange(int i) {
        this.f2371c = i > 0;
        this.f2370b.zzhh();
    }

    public void setMuted(boolean z) {
        this.f2373e = z;
        m3955a();
    }

    public void zzb(float f) {
        this.f2374f = f;
        m3955a();
    }

    public void zzib() {
        this.f2372d = true;
        m3955a();
    }

    public void zzic() {
        this.f2372d = false;
        m3955a();
    }

    public float zzie() {
        return this.f2371c ? this.f2373e ? 0.0f : this.f2374f : 0.0f;
    }
}
