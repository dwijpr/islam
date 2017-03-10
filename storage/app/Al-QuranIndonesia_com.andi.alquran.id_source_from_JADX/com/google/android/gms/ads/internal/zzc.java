package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.ip;
import com.google.android.gms.internal.ir;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.kg;
import com.google.android.gms.internal.lm;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.nb;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzqa;
import java.util.Map;

@op
public abstract class zzc extends zzb implements zzh, nb {

    /* renamed from: com.google.android.gms.ads.internal.zzc.1 */
    class C11601 implements kg {
        final /* synthetic */ zzc f2564a;

        C11601(zzc com_google_android_gms_ads_internal_zzc) {
            this.f2564a = com_google_android_gms_ads_internal_zzc;
        }

        public void m4049a(sx sxVar, Map<String, String> map) {
            if (this.f2564a.f.zzvk != null) {
                this.f2564a.h.m6053a(this.f2564a.f.zzvj, this.f2564a.f.zzvk, sxVar.m8760b(), (lm) sxVar);
            } else {
                sg.m8449e("Request to enable ActiveView before adState is available.");
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzc.2 */
    class C11612 implements Runnable {
        final /* synthetic */ C1938a f2565a;
        final /* synthetic */ zzc f2566b;

        C11612(zzc com_google_android_gms_ads_internal_zzc, C1938a c1938a) {
            this.f2566b = com_google_android_gms_ads_internal_zzc;
            this.f2565a = c1938a;
        }

        public void run() {
            this.f2566b.zzb(new rc(this.f2565a, null, null, null, null, null, null, null));
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzc.3 */
    class C11643 implements Runnable {
        final /* synthetic */ C1938a f2569a;
        final /* synthetic */ qw f2570b;
        final /* synthetic */ io f2571c;
        final /* synthetic */ zzc f2572d;

        /* renamed from: com.google.android.gms.ads.internal.zzc.3.1 */
        class C11621 implements OnTouchListener {
            final /* synthetic */ zze f2567a;

            C11621(C11643 c11643, zze com_google_android_gms_ads_internal_zze) {
                this.f2567a = com_google_android_gms_ads_internal_zze;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                this.f2567a.recordClick();
                return false;
            }
        }

        /* renamed from: com.google.android.gms.ads.internal.zzc.3.2 */
        class C11632 implements OnClickListener {
            final /* synthetic */ zze f2568a;

            C11632(C11643 c11643, zze com_google_android_gms_ads_internal_zze) {
                this.f2568a = com_google_android_gms_ads_internal_zze;
            }

            public void onClick(View view) {
                this.f2568a.recordClick();
            }
        }

        C11643(zzc com_google_android_gms_ads_internal_zzc, C1938a c1938a, qw qwVar, io ioVar) {
            this.f2572d = com_google_android_gms_ads_internal_zzc;
            this.f2569a = c1938a;
            this.f2570b = qwVar;
            this.f2571c = ioVar;
        }

        public void run() {
            if (this.f2569a.f5595b.f6600s && this.f2572d.f.f2740p != null) {
                String str = null;
                if (this.f2569a.f5595b.f6583b != null) {
                    str = zzv.zzcJ().m8501a(this.f2569a.f5595b.f6583b);
                }
                ir ipVar = new ip(this.f2572d, str, this.f2569a.f5595b.f6584c);
                this.f2572d.f.zzvF = 1;
                try {
                    this.f2572d.d = false;
                    this.f2572d.f.f2740p.m6767a(ipVar);
                    return;
                } catch (Throwable e) {
                    sg.m8447c("Could not call the onCustomRenderedAdLoadedListener.", e);
                    this.f2572d.d = true;
                }
            }
            zze com_google_android_gms_ads_internal_zze = new zze(this.f2572d.f.zzqr, this.f2569a);
            sx a = this.f2572d.m4050a(this.f2569a, com_google_android_gms_ads_internal_zze, this.f2570b);
            a.setOnTouchListener(new C11621(this, com_google_android_gms_ads_internal_zze));
            a.setOnClickListener(new C11632(this, com_google_android_gms_ads_internal_zze));
            this.f2572d.f.zzvF = 0;
            this.f2572d.f.zzvi = zzv.zzcI().m7817a(this.f2572d.f.zzqr, this.f2572d, this.f2569a, this.f2572d.f.f2726b, a, this.f2572d.j, this.f2572d, this.f2571c);
        }
    }

    public zzc(Context context, zzec com_google_android_gms_internal_zzec, String str, md mdVar, zzqa com_google_android_gms_internal_zzqa, zzd com_google_android_gms_ads_internal_zzd) {
        super(context, com_google_android_gms_internal_zzec, str, mdVar, com_google_android_gms_internal_zzqa, com_google_android_gms_ads_internal_zzd);
    }

    protected sx m4050a(C1938a c1938a, zze com_google_android_gms_ads_internal_zze, qw qwVar) {
        sx sxVar = null;
        View nextView = this.f.f2727c.getNextView();
        if (nextView instanceof sx) {
            sxVar = (sx) nextView;
            if (((Boolean) C1648if.ax.m6682c()).booleanValue()) {
                sg.m8444b("Reusing webview...");
                sxVar.m8750a(this.f.zzqr, this.f.zzvj, this.a);
            } else {
                sxVar.destroy();
                sxVar = null;
            }
        }
        if (sxVar == null) {
            if (nextView != null) {
                this.f.f2727c.removeView(nextView);
            }
            sxVar = zzv.zzcK().m8831a(this.f.zzqr, this.f.zzvj, false, false, this.f.f2726b, this.f.zzvf, this.a, this, this.i);
            if (this.f.zzvj.f6458h == null) {
                m4033a(sxVar.m8760b());
            }
        }
        sx sxVar2 = sxVar;
        sxVar2.m8776l().m8804a(this, this, this, this, false, this, null, com_google_android_gms_ads_internal_zze, this, qwVar);
        m4051a(sxVar2);
        sxVar2.m8763b(c1938a.f5594a.f6562w);
        return sxVar2;
    }

    protected void m4051a(lm lmVar) {
        lmVar.m7287a("/trackActiveViewUnit", new C11601(this));
    }

    public void zza(int i, int i2, int i3, int i4) {
        m4039c();
    }

    public void zza(is isVar) {
        C1314c.m4631b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f.f2740p = isVar;
    }

    protected void zza(C1938a c1938a, io ioVar) {
        if (c1938a.f5598e != -2) {
            rq.f5755a.post(new C11612(this, c1938a));
            return;
        }
        if (c1938a.f5597d != null) {
            this.f.zzvj = c1938a.f5597d;
        }
        if (!c1938a.f5595b.f6589h || c1938a.f5595b.f6567B) {
            rq.f5755a.post(new C11643(this, c1938a, null, ioVar));
            return;
        }
        this.f.zzvF = 0;
        this.f.zzvi = zzv.zzcI().m7817a(this.f.zzqr, this, c1938a, this.f.f2726b, null, this.j, this, ioVar);
    }

    protected boolean zza(rc rcVar, rc rcVar2) {
        if (this.f.zzdm() && this.f.f2727c != null) {
            this.f.f2727c.zzds().m8624b(rcVar2.f5604C);
        }
        return super.zza(rcVar, rcVar2);
    }

    public void zzbX() {
        onAdClicked();
    }

    public void zzbY() {
        recordImpression();
        zzbF();
    }

    public void zzbZ() {
        m4031a();
    }

    public void zzc(View view) {
        this.f.f2744t = view;
        zzb(new rc(this.f.zzvl, null, null, null, null, null, null, null));
    }
}
