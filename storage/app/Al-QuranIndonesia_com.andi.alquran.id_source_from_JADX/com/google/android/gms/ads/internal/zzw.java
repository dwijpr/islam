package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.p014g.C0297j;
import android.support.v7.recyclerview.BuildConfig;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.nl;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.qc;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.rd;
import com.google.android.gms.internal.rj;
import com.google.android.gms.internal.rl;
import com.google.android.gms.internal.rm;
import com.google.android.gms.internal.rs;
import com.google.android.gms.internal.rt;
import com.google.android.gms.internal.sb;
import com.google.android.gms.internal.se;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.sy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzqa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@op
public final class zzw implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean f2722A;
    private boolean f2723B;
    private boolean f2724C;
    final String f2725a;
    final cg f2726b;
    zza f2727c;
    gu f2728d;
    gv f2729e;
    hb f2730f;
    hd f2731g;
    nl f2732h;
    nq f2733i;
    js f2734j;
    jt f2735k;
    C0297j<String, ju> f2736l;
    C0297j<String, jv> f2737m;
    zzgw f2738n;
    zzfn f2739o;
    is f2740p;
    qc f2741q;
    List<String> f2742r;
    zzk f2743s;
    View f2744t;
    boolean f2745u;
    boolean f2746v;
    private HashSet<rd> f2747w;
    private int f2748x;
    private int f2749y;
    private sb f2750z;
    public final Context zzqr;
    public rj zzvD;
    public int zzvF;
    public String zzvd;
    public final zzqa zzvf;
    public rl zzvh;
    public rs zzvi;
    public zzec zzvj;
    public rc zzvk;
    public C1938a zzvl;
    public rd zzvm;

    public static class zza extends ViewSwitcher {
        private final rt f2719a;
        private final se f2720b;
        private boolean f2721c;

        public zza(Context context, String str, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.f2719a = new rt(context);
            this.f2719a.m8623a(str);
            this.f2721c = true;
            if (context instanceof Activity) {
                this.f2720b = new se((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
            } else {
                this.f2720b = new se(null, this, onGlobalLayoutListener, onScrollChangedListener);
            }
            this.f2720b.m8683a();
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f2720b != null) {
                this.f2720b.m8686c();
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f2720b != null) {
                this.f2720b.m8687d();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (this.f2721c) {
                this.f2719a.m8622a(motionEvent);
            }
            return false;
        }

        public void removeAllViews() {
            List<sx> arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof sx)) {
                    arrayList.add((sx) childAt);
                }
            }
            super.removeAllViews();
            for (sx destroy : arrayList) {
                destroy.destroy();
            }
        }

        public void zzdo() {
            rm.m8450a("Disable position monitoring on adFrame.");
            if (this.f2720b != null) {
                this.f2720b.m8685b();
            }
        }

        public rt zzds() {
            return this.f2719a;
        }

        public void zzdt() {
            rm.m8450a("Enable debug gesture detector on adFrame.");
            this.f2721c = true;
        }

        public void zzdu() {
            rm.m8450a("Disable debug gesture detector on adFrame.");
            this.f2721c = false;
        }
    }

    public zzw(Context context, zzec com_google_android_gms_internal_zzec, String str, zzqa com_google_android_gms_internal_zzqa) {
        this(context, com_google_android_gms_internal_zzec, str, com_google_android_gms_internal_zzqa, null);
    }

    zzw(Context context, zzec com_google_android_gms_internal_zzec, String str, zzqa com_google_android_gms_internal_zzqa, cg cgVar) {
        this.zzvD = null;
        this.f2744t = null;
        this.zzvF = 0;
        this.f2745u = false;
        this.f2746v = false;
        this.f2747w = null;
        this.f2748x = -1;
        this.f2749y = -1;
        this.f2722A = true;
        this.f2723B = true;
        this.f2724C = false;
        C1648if.m6704a(context);
        if (zzv.zzcN().m8412f() != null) {
            List b = C1648if.m6705b();
            if (com_google_android_gms_internal_zzqa.f6637c != 0) {
                b.add(Integer.toString(com_google_android_gms_internal_zzqa.f6637c));
            }
            zzv.zzcN().m8412f().m6718a(b);
        }
        this.f2725a = UUID.randomUUID().toString();
        if (com_google_android_gms_internal_zzec.f6455e || com_google_android_gms_internal_zzec.f6459i) {
            this.f2727c = null;
        } else {
            this.f2727c = new zza(context, str, this, this);
            this.f2727c.setMinimumWidth(com_google_android_gms_internal_zzec.f6457g);
            this.f2727c.setMinimumHeight(com_google_android_gms_internal_zzec.f6454d);
            this.f2727c.setVisibility(4);
        }
        this.zzvj = com_google_android_gms_internal_zzec;
        this.zzvd = str;
        this.zzqr = context;
        this.zzvf = com_google_android_gms_internal_zzqa;
        if (cgVar == null) {
            cgVar = new cg(new C1123a(this));
        }
        this.f2726b = cgVar;
        this.f2750z = new sb(200);
        this.f2737m = new C0297j();
    }

    private void m4154a() {
        if (this.f2727c != null) {
            View findViewById = this.f2727c.getRootView().findViewById(16908290);
            if (findViewById != null) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                this.f2727c.getGlobalVisibleRect(rect);
                findViewById.getGlobalVisibleRect(rect2);
                if (rect.top != rect2.top) {
                    this.f2722A = false;
                }
                if (rect.bottom != rect2.bottom) {
                    this.f2723B = false;
                }
            }
        }
    }

    private void m4155a(boolean z) {
        boolean z2 = true;
        if (this.f2727c != null && this.zzvk != null && this.zzvk.f5612b != null && this.zzvk.f5612b.m8776l() != null) {
            if (!z || this.f2750z.m8677a()) {
                if (this.zzvk.f5612b.m8776l().m8816b()) {
                    int[] iArr = new int[2];
                    this.f2727c.getLocationOnScreen(iArr);
                    int b = gr.m6416a().m8702b(this.zzqr, iArr[0]);
                    int b2 = gr.m6416a().m8702b(this.zzqr, iArr[1]);
                    if (!(b == this.f2748x && b2 == this.f2749y)) {
                        this.f2748x = b;
                        this.f2749y = b2;
                        sy l = this.zzvk.f5612b.m8776l();
                        b = this.f2748x;
                        int i = this.f2749y;
                        if (z) {
                            z2 = false;
                        }
                        l.m8799a(b, i, z2);
                    }
                }
                m4154a();
            }
        }
    }

    public void destroy() {
        zzdo();
        this.f2729e = null;
        this.f2730f = null;
        this.f2733i = null;
        this.f2732h = null;
        this.f2740p = null;
        this.f2731g = null;
        zzi(false);
        if (this.f2727c != null) {
            this.f2727c.removeAllViews();
        }
        zzdj();
        zzdl();
        this.zzvk = null;
    }

    public void onGlobalLayout() {
        m4155a(false);
    }

    public void onScrollChanged() {
        m4155a(true);
        this.f2724C = true;
    }

    public void zza(HashSet<rd> hashSet) {
        this.f2747w = hashSet;
    }

    public HashSet<rd> zzdi() {
        return this.f2747w;
    }

    public void zzdj() {
        if (this.zzvk != null && this.zzvk.f5612b != null) {
            this.zzvk.f5612b.destroy();
        }
    }

    public void zzdk() {
        if (this.zzvk != null && this.zzvk.f5612b != null) {
            this.zzvk.f5612b.stopLoading();
        }
    }

    public void zzdl() {
        if (this.zzvk != null && this.zzvk.f5626p != null) {
            try {
                this.zzvk.f5626p.m7473c();
            } catch (RemoteException e) {
                sg.m8449e("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean zzdm() {
        return this.zzvF == 0;
    }

    public boolean zzdn() {
        return this.zzvF == 1;
    }

    public void zzdo() {
        if (this.f2727c != null) {
            this.f2727c.zzdo();
        }
    }

    public String zzdq() {
        return (this.f2722A && this.f2723B) ? BuildConfig.VERSION_NAME : this.f2722A ? this.f2724C ? "top-scrollable" : "top-locked" : this.f2723B ? this.f2724C ? "bottom-scrollable" : "bottom-locked" : BuildConfig.VERSION_NAME;
    }

    public void zzdr() {
        if (this.zzvm != null) {
            if (this.zzvk != null) {
                this.zzvm.m8370a(this.zzvk.f5602A);
                this.zzvm.m8374b(this.zzvk.f5603B);
                this.zzvm.m8375b(this.zzvk.f5624n);
            }
            this.zzvm.m8372a(this.zzvj.f6455e);
        }
    }

    public void zzi(boolean z) {
        if (this.zzvF == 0) {
            zzdk();
        }
        if (this.zzvh != null) {
            this.zzvh.cancel();
        }
        if (this.zzvi != null) {
            this.zzvi.cancel();
        }
        if (z) {
            this.zzvk = null;
        }
    }
}
