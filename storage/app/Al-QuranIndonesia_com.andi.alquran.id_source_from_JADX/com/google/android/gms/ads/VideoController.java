package com.google.android.gms.ads;

import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hv;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;

@op
public final class VideoController {
    private final Object f2320a;
    private hg f2321b;
    private VideoLifecycleCallbacks f2322c;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }
    }

    public VideoController() {
        this.f2320a = new Object();
    }

    public float getAspectRatio() {
        float f = 0.0f;
        synchronized (this.f2320a) {
            if (this.f2321b == null) {
            } else {
                try {
                    f = this.f2321b.m6457g();
                } catch (Throwable e) {
                    sg.m8445b("Unable to call getAspectRatio on video controller.", e);
                }
            }
        }
        return f;
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.f2320a) {
            videoLifecycleCallbacks = this.f2322c;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.f2320a) {
            z = this.f2321b != null;
        }
        return z;
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        C1314c.m4624a((Object) videoLifecycleCallbacks, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f2320a) {
            this.f2322c = videoLifecycleCallbacks;
            if (this.f2321b == null) {
                return;
            }
            try {
                this.f2321b.m6450a(new hv(videoLifecycleCallbacks));
            } catch (Throwable e) {
                sg.m8445b("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public void zza(hg hgVar) {
        synchronized (this.f2320a) {
            this.f2321b = hgVar;
            if (this.f2322c != null) {
                setVideoLifecycleCallbacks(this.f2322c);
            }
        }
    }

    public hg zzbt() {
        hg hgVar;
        synchronized (this.f2320a) {
            hgVar = this.f2321b;
        }
        return hgVar;
    }
}
