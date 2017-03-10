package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v7.recyclerview.BuildConfig;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rm;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
@op
public class zzd extends zzj implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> f2389c;
    private final zzz f2390d;
    private final boolean f2391e;
    private int f2392f;
    private int f2393g;
    private MediaPlayer f2394h;
    private Uri f2395i;
    private int f2396j;
    private int f2397k;
    private int f2398l;
    private int f2399m;
    private int f2400n;
    private zzy f2401o;
    private boolean f2402p;
    private int f2403q;
    private zzi f2404r;

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd.1 */
    class C11291 implements Runnable {
        final /* synthetic */ zzd f2375a;

        C11291(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f2375a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f2375a.f2404r != null) {
                this.f2375a.f2404r.zzhz();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd.2 */
    class C11302 implements Runnable {
        final /* synthetic */ zzd f2376a;

        C11302(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f2376a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f2376a.f2404r != null) {
                this.f2376a.f2404r.zzhB();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd.3 */
    class C11313 implements Runnable {
        final /* synthetic */ String f2377a;
        final /* synthetic */ String f2378b;
        final /* synthetic */ zzd f2379c;

        C11313(zzd com_google_android_gms_ads_internal_overlay_zzd, String str, String str2) {
            this.f2379c = com_google_android_gms_ads_internal_overlay_zzd;
            this.f2377a = str;
            this.f2378b = str2;
        }

        public void run() {
            if (this.f2379c.f2404r != null) {
                this.f2379c.f2404r.zzk(this.f2377a, this.f2378b);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd.4 */
    class C11324 implements Runnable {
        final /* synthetic */ zzd f2380a;

        C11324(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f2380a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f2380a.f2404r != null) {
                this.f2380a.f2404r.zzhy();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd.5 */
    class C11335 implements Runnable {
        final /* synthetic */ int f2381a;
        final /* synthetic */ int f2382b;
        final /* synthetic */ zzd f2383c;

        C11335(zzd com_google_android_gms_ads_internal_overlay_zzd, int i, int i2) {
            this.f2383c = com_google_android_gms_ads_internal_overlay_zzd;
            this.f2381a = i;
            this.f2382b = i2;
        }

        public void run() {
            if (this.f2383c.f2404r != null) {
                this.f2383c.f2404r.zzf(this.f2381a, this.f2382b);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd.6 */
    class C11346 implements Runnable {
        final /* synthetic */ zzd f2384a;

        C11346(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f2384a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f2384a.f2404r != null) {
                this.f2384a.f2404r.onPaused();
                this.f2384a.f2404r.zzhC();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd.7 */
    class C11357 implements Runnable {
        final /* synthetic */ zzd f2385a;

        C11357(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f2385a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f2385a.f2404r != null) {
                this.f2385a.f2404r.zzhA();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.zzd.8 */
    class C11368 implements Runnable {
        final /* synthetic */ zzd f2386a;

        C11368(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f2386a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f2386a.f2404r != null) {
                this.f2386a.f2404r.onPaused();
            }
        }
    }

    static {
        f2389c = new HashMap();
        if (VERSION.SDK_INT >= 17) {
            f2389c.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
            f2389c.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
            f2389c.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
            f2389c.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
            f2389c.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        f2389c.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        f2389c.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        f2389c.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        f2389c.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f2389c.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        f2389c.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        f2389c.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        f2389c.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        f2389c.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        if (VERSION.SDK_INT >= 19) {
            f2389c.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            f2389c.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzd(Context context, boolean z, boolean z2, zzz com_google_android_gms_ads_internal_overlay_zzz) {
        super(context);
        this.f2392f = 0;
        this.f2393g = 0;
        setSurfaceTextureListener(this);
        this.f2390d = com_google_android_gms_ads_internal_overlay_zzz;
        this.f2402p = z;
        this.f2391e = z2;
        this.f2390d.zza(this);
    }

    private void m3960a() {
        Throwable e;
        String valueOf;
        rm.m8450a("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f2395i != null && surfaceTexture != null) {
            m3963a(false);
            try {
                SurfaceTexture zzhQ;
                this.f2394h = zzv.zzda().zzhO();
                this.f2394h.setOnBufferingUpdateListener(this);
                this.f2394h.setOnCompletionListener(this);
                this.f2394h.setOnErrorListener(this);
                this.f2394h.setOnInfoListener(this);
                this.f2394h.setOnPreparedListener(this);
                this.f2394h.setOnVideoSizeChangedListener(this);
                this.f2398l = 0;
                if (this.f2402p) {
                    this.f2401o = new zzy(getContext());
                    this.f2401o.zza(surfaceTexture, getWidth(), getHeight());
                    this.f2401o.start();
                    zzhQ = this.f2401o.zzhQ();
                    if (zzhQ == null) {
                        this.f2401o.zzhP();
                        this.f2401o = null;
                    }
                    this.f2394h.setDataSource(getContext(), this.f2395i);
                    this.f2394h.setSurface(zzv.zzdb().zza(zzhQ));
                    this.f2394h.setAudioStreamType(3);
                    this.f2394h.setScreenOnWhilePlaying(true);
                    this.f2394h.prepareAsync();
                    m3962a(1);
                }
                zzhQ = surfaceTexture;
                this.f2394h.setDataSource(getContext(), this.f2395i);
                this.f2394h.setSurface(zzv.zzdb().zza(zzhQ));
                this.f2394h.setAudioStreamType(3);
                this.f2394h.setScreenOnWhilePlaying(true);
                this.f2394h.prepareAsync();
                m3962a(1);
            } catch (IOException e2) {
                e = e2;
                valueOf = String.valueOf(this.f2395i);
                sg.m8447c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f2394h, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                valueOf = String.valueOf(this.f2395i);
                sg.m8447c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f2394h, 1, 0);
            } catch (IllegalStateException e4) {
                e = e4;
                valueOf = String.valueOf(this.f2395i);
                sg.m8447c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f2394h, 1, 0);
            }
        }
    }

    private void m3961a(float f) {
        if (this.f2394h != null) {
            try {
                this.f2394h.setVolume(f, f);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        sg.m8449e("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    private void m3962a(int i) {
        if (i == 3) {
            this.f2390d.zzib();
            this.b.zzib();
        } else if (this.f2392f == 3) {
            this.f2390d.zzic();
            this.b.zzic();
        }
        this.f2392f = i;
    }

    private void m3963a(boolean z) {
        rm.m8450a("AdMediaPlayerView release");
        if (this.f2401o != null) {
            this.f2401o.zzhP();
            this.f2401o = null;
        }
        if (this.f2394h != null) {
            this.f2394h.reset();
            this.f2394h.release();
            this.f2394h = null;
            m3962a(0);
            if (z) {
                this.f2393g = 0;
                m3965b(0);
            }
        }
    }

    private void m3964b() {
        if (this.f2391e && m3966c() && this.f2394h.getCurrentPosition() > 0 && this.f2393g != 3) {
            rm.m8450a("AdMediaPlayerView nudging MediaPlayer");
            m3961a(0.0f);
            this.f2394h.start();
            int currentPosition = this.f2394h.getCurrentPosition();
            long a = zzv.zzcP().m4926a();
            while (m3966c() && this.f2394h.getCurrentPosition() == currentPosition) {
                if (zzv.zzcP().m4926a() - a > 250) {
                    break;
                }
            }
            this.f2394h.pause();
            zzhh();
        }
    }

    private void m3965b(int i) {
        this.f2393g = i;
    }

    private boolean m3966c() {
        return (this.f2394h == null || this.f2392f == -1 || this.f2392f == 0 || this.f2392f == 1) ? false : true;
    }

    public int getCurrentPosition() {
        return m3966c() ? this.f2394h.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return m3966c() ? this.f2394h.getDuration() : -1;
    }

    public int getVideoHeight() {
        return this.f2394h != null ? this.f2394h.getVideoHeight() : 0;
    }

    public int getVideoWidth() {
        return this.f2394h != null ? this.f2394h.getVideoWidth() : 0;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f2398l = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        rm.m8450a("AdMediaPlayerView completion");
        m3962a(5);
        m3965b(5);
        rq.f5755a.post(new C11302(this));
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f2389c.get(Integer.valueOf(i));
        String str2 = (String) f2389c.get(Integer.valueOf(i2));
        sg.m8449e(new StringBuilder((String.valueOf(str).length() + 38) + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        m3962a(-1);
        m3965b(-1);
        rq.f5755a.post(new C11313(this, str, str2));
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f2389c.get(Integer.valueOf(i));
        String str2 = (String) f2389c.get(Integer.valueOf(i2));
        rm.m8450a(new StringBuilder((String.valueOf(str).length() + 37) + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.f2396j, i);
        int defaultSize2 = getDefaultSize(this.f2397k, i2);
        if (this.f2396j > 0 && this.f2397k > 0 && this.f2401o == null) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f2396j * defaultSize2 < this.f2397k * size) {
                    defaultSize = (this.f2396j * defaultSize2) / this.f2397k;
                } else if (this.f2396j * defaultSize2 > this.f2397k * size) {
                    defaultSize2 = (this.f2397k * size) / this.f2396j;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.f2397k * size) / this.f2396j;
                if (mode2 != RtlSpacingHelper.UNDEFINED || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f2396j * defaultSize2) / this.f2397k;
                if (mode == RtlSpacingHelper.UNDEFINED && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.f2396j;
                defaultSize = this.f2397k;
                if (mode2 != RtlSpacingHelper.UNDEFINED || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.f2396j * defaultSize2) / this.f2397k;
                }
                if (mode == RtlSpacingHelper.UNDEFINED && r1 > size) {
                    defaultSize2 = (this.f2397k * size) / this.f2396j;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.f2401o != null) {
            this.f2401o.zzi(defaultSize, defaultSize2);
        }
        if (VERSION.SDK_INT == 16) {
            if ((this.f2399m > 0 && this.f2399m != defaultSize) || (this.f2400n > 0 && this.f2400n != defaultSize2)) {
                m3964b();
            }
            this.f2399m = defaultSize;
            this.f2400n = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        rm.m8450a("AdMediaPlayerView prepared");
        m3962a(2);
        this.f2390d.zzhz();
        rq.f5755a.post(new C11291(this));
        this.f2396j = mediaPlayer.getVideoWidth();
        this.f2397k = mediaPlayer.getVideoHeight();
        if (this.f2403q != 0) {
            seekTo(this.f2403q);
        }
        m3964b();
        int i = this.f2396j;
        sg.m8448d("AdMediaPlayerView stream dimensions: " + i + " x " + this.f2397k);
        if (this.f2393g == 3) {
            play();
        }
        zzhh();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        rm.m8450a("AdMediaPlayerView surface created");
        m3960a();
        rq.f5755a.post(new C11324(this));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        rm.m8450a("AdMediaPlayerView surface destroyed");
        if (this.f2394h != null && this.f2403q == 0) {
            this.f2403q = this.f2394h.getCurrentPosition();
        }
        if (this.f2401o != null) {
            this.f2401o.zzhP();
        }
        rq.f5755a.post(new C11346(this));
        m3963a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Object obj = 1;
        rm.m8450a("AdMediaPlayerView surface changed");
        Object obj2 = this.f2393g == 3 ? 1 : null;
        if (!(this.f2396j == i && this.f2397k == i2)) {
            obj = null;
        }
        if (!(this.f2394h == null || obj2 == null || r1 == null)) {
            if (this.f2403q != 0) {
                seekTo(this.f2403q);
            }
            play();
        }
        if (this.f2401o != null) {
            this.f2401o.zzi(i, i2);
        }
        rq.f5755a.post(new C11335(this, i, i2));
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f2390d.zzb(this);
        this.a.zza(surfaceTexture, this.f2404r);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        rm.m8450a("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.f2396j = mediaPlayer.getVideoWidth();
        this.f2397k = mediaPlayer.getVideoHeight();
        if (this.f2396j != 0 && this.f2397k != 0) {
            requestLayout();
        }
    }

    public void pause() {
        rm.m8450a("AdMediaPlayerView pause");
        if (m3966c() && this.f2394h.isPlaying()) {
            this.f2394h.pause();
            m3962a(4);
            rq.f5755a.post(new C11368(this));
        }
        m3965b(4);
    }

    public void play() {
        rm.m8450a("AdMediaPlayerView play");
        if (m3966c()) {
            this.f2394h.start();
            m3962a(3);
            this.a.zzhA();
            rq.f5755a.post(new C11357(this));
        }
        m3965b(3);
    }

    public void seekTo(int i) {
        rm.m8450a("AdMediaPlayerView seek " + i);
        if (m3966c()) {
            this.f2394h.seekTo(i);
            this.f2403q = 0;
            return;
        }
        this.f2403q = i;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.f2395i = uri;
        this.f2403q = 0;
        m3960a();
        requestLayout();
        invalidate();
    }

    public void stop() {
        rm.m8450a("AdMediaPlayerView stop");
        if (this.f2394h != null) {
            this.f2394h.stop();
            this.f2394h.release();
            this.f2394h = null;
            m3962a(0);
            m3965b(0);
        }
        this.f2390d.onStop();
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getName());
        String valueOf2 = String.valueOf(Integer.toHexString(hashCode()));
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("@").append(valueOf2).toString();
    }

    public void zza(float f, float f2) {
        if (this.f2401o != null) {
            this.f2401o.zzb(f, f2);
        }
    }

    public void zza(zzi com_google_android_gms_ads_internal_overlay_zzi) {
        this.f2404r = com_google_android_gms_ads_internal_overlay_zzi;
    }

    public String zzhd() {
        String str = "MediaPlayer";
        String valueOf = String.valueOf(this.f2402p ? " spherical" : BuildConfig.VERSION_NAME);
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public void zzhh() {
        m3961a(this.b.zzie());
    }
}
