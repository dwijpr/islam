package com.google.android.gms.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1378d;
import com.google.android.gms.maps.GoogleMap;
import java.util.Map;
import java.util.Set;

@op
public class mv extends na {
    static final Set<String> f5017a;
    private String f5018b;
    private boolean f5019c;
    private int f5020d;
    private int f5021e;
    private int f5022f;
    private int f5023g;
    private int f5024h;
    private int f5025i;
    private final Object f5026j;
    private final sx f5027k;
    private final Activity f5028l;
    private zzec f5029m;
    private ImageView f5030n;
    private LinearLayout f5031o;
    private nb f5032p;
    private PopupWindow f5033q;
    private RelativeLayout f5034r;
    private ViewGroup f5035s;

    /* renamed from: com.google.android.gms.internal.mv.1 */
    class C18231 implements OnClickListener {
        final /* synthetic */ mv f5016a;

        C18231(mv mvVar) {
            this.f5016a = mvVar;
        }

        public void onClick(View view) {
            this.f5016a.m7704a(true);
        }
    }

    static {
        f5017a = C1378d.m4935a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public mv(sx sxVar, nb nbVar) {
        super(sxVar, "resize");
        this.f5018b = "top-right";
        this.f5019c = true;
        this.f5020d = 0;
        this.f5021e = 0;
        this.f5022f = -1;
        this.f5023g = 0;
        this.f5024h = 0;
        this.f5025i = -1;
        this.f5026j = new Object();
        this.f5027k = sxVar;
        this.f5028l = sxVar.m8770f();
        this.f5032p = nbVar;
    }

    private void m7699b(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.f5025i = zzv.zzcJ().m8530b((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.f5022f = zzv.zzcJ().m8530b((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.f5023g = zzv.zzcJ().m8530b((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.f5024h = zzv.zzcJ().m8530b((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.f5019c = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.f5018b = str;
        }
    }

    private int[] m7700d() {
        if (!m7709c()) {
            return null;
        }
        if (this.f5019c) {
            return new int[]{this.f5020d + this.f5023g, this.f5021e + this.f5024h};
        }
        int[] b = zzv.zzcJ().m8537b(this.f5028l);
        int[] d = zzv.zzcJ().m8544d(this.f5028l);
        int i = b[0];
        int i2 = this.f5020d + this.f5023g;
        int i3 = this.f5021e + this.f5024h;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.f5025i + i2 > i) {
            i2 = i - this.f5025i;
        }
        if (i3 < d[0]) {
            i3 = d[0];
        } else if (this.f5022f + i3 > d[1]) {
            i3 = d[1] - this.f5022f;
        }
        return new int[]{i2, i3};
    }

    void m7701a(int i, int i2) {
        if (this.f5032p != null) {
            this.f5032p.zza(i, i2, this.f5025i, this.f5022f);
        }
    }

    public void m7702a(int i, int i2, boolean z) {
        synchronized (this.f5026j) {
            this.f5020d = i;
            this.f5021e = i2;
            if (this.f5033q != null && z) {
                int[] d = m7700d();
                if (d != null) {
                    this.f5033q.update(gr.m6416a().m8690a(this.f5028l, d[0]), gr.m6416a().m8690a(this.f5028l, d[1]), this.f5033q.getWidth(), this.f5033q.getHeight());
                    m7706b(d[0], d[1]);
                } else {
                    m7704a(true);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7703a(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.f5026j;
        monitor-enter(r6);
        r1 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m8775k();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m8775k();	 Catch:{ all -> 0x0020 }
        r1 = r1.f6455e;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0034:
        r1 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m8780p();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0043;
    L_0x003c:
        r1 = "Cannot resize an expanded banner.";
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0043:
        r12.m7699b(r13);	 Catch:{ all -> 0x0020 }
        r1 = r12.m7705a();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0053:
        r1 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0061;
    L_0x005b:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0068;
    L_0x0061:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0068:
        r8 = r12.m7700d();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0075;
    L_0x006e:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0075:
        r1 = com.google.android.gms.internal.gr.m6416a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r9 = r12.f5025i;	 Catch:{ all -> 0x0020 }
        r9 = r1.m8690a(r2, r9);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.gr.m6416a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r10 = r12.f5022f;	 Catch:{ all -> 0x0020 }
        r10 = r1.m8690a(r2, r10);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m8760b();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x01d5;
    L_0x0099:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x01d5;
    L_0x009d:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r11 = r11.m8760b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5033q;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01ce;
    L_0x00ae:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r12.f5035s = r2;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x0020 }
        r2 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m8760b();	 Catch:{ all -> 0x0020 }
        r1 = r1.m8491a(r2);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r12.f5030n = r2;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5030n;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m8775k();	 Catch:{ all -> 0x0020 }
        r12.f5029m = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f5035s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5030n;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f5034r = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f5034r;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5034r;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x0020 }
        r2 = r12.f5034r;	 Catch:{ all -> 0x0020 }
        r11 = 0;
        r1 = r1.m8494a(r2, r9, r10, r11);	 Catch:{ all -> 0x0020 }
        r12.f5033q = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f5033q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5033q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r12.f5033q;	 Catch:{ all -> 0x0020 }
        r1 = r12.f5019c;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01dd;
    L_0x0115:
        r1 = r5;
    L_0x0116:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5034r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m8760b();	 Catch:{ all -> 0x0020 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f5031o = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.gr.m6416a();	 Catch:{ all -> 0x0020 }
        r9 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r10 = 50;
        r1 = r1.m8690a(r9, r10);	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.internal.gr.m6416a();	 Catch:{ all -> 0x0020 }
        r10 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r9 = r9.m8690a(r10, r11);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5018b;	 Catch:{ all -> 0x0020 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r9) {
            case -1364013995: goto L_0x01f6;
            case -1012429441: goto L_0x01e0;
            case -655373719: goto L_0x0201;
            case 1163912186: goto L_0x0217;
            case 1288627767: goto L_0x020c;
            case 1755462605: goto L_0x01eb;
            default: goto L_0x0155;
        };	 Catch:{ all -> 0x0020 }
    L_0x0155:
        r1 = r4;
    L_0x0156:
        switch(r1) {
            case 0: goto L_0x0222;
            case 1: goto L_0x022e;
            case 2: goto L_0x023a;
            case 3: goto L_0x0241;
            case 4: goto L_0x024d;
            case 5: goto L_0x0259;
            default: goto L_0x0159;
        };	 Catch:{ all -> 0x0020 }
    L_0x0159:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x0163:
        r1 = r12.f5031o;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.internal.mv$1;	 Catch:{ all -> 0x0020 }
        r3.<init>(r12);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5031o;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5034r;	 Catch:{ all -> 0x0020 }
        r3 = r12.f5031o;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5033q;	 Catch:{ RuntimeException -> 0x0265 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0265 }
        r3 = 0;
        r4 = com.google.android.gms.internal.gr.m6416a();	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r12.f5028l;	 Catch:{ RuntimeException -> 0x0265 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0265 }
        r4 = r4.m8690a(r5, r7);	 Catch:{ RuntimeException -> 0x0265 }
        r5 = com.google.android.gms.internal.gr.m6416a();	 Catch:{ RuntimeException -> 0x0265 }
        r7 = r12.f5028l;	 Catch:{ RuntimeException -> 0x0265 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r5.m8690a(r7, r9);	 Catch:{ RuntimeException -> 0x0265 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0265 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m7701a(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r2 = new com.google.android.gms.internal.zzec;	 Catch:{ all -> 0x0020 }
        r3 = r12.f5028l;	 Catch:{ all -> 0x0020 }
        r4 = new com.google.android.gms.ads.AdSize;	 Catch:{ all -> 0x0020 }
        r5 = r12.f5025i;	 Catch:{ all -> 0x0020 }
        r7 = r12.f5022f;	 Catch:{ all -> 0x0020 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0020 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0020 }
        r1.m8754a(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m7706b(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r12.m7692d(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01ce:
        r1 = r12.f5033q;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x00dd;
    L_0x01d5:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01dd:
        r1 = r3;
        goto L_0x0116;
    L_0x01e0:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01e8:
        r1 = r3;
        goto L_0x0156;
    L_0x01eb:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01f3:
        r1 = r5;
        goto L_0x0156;
    L_0x01f6:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01fe:
        r1 = 2;
        goto L_0x0156;
    L_0x0201:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0209:
        r1 = 3;
        goto L_0x0156;
    L_0x020c:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0214:
        r1 = 4;
        goto L_0x0156;
    L_0x0217:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x021f:
        r1 = 5;
        goto L_0x0156;
    L_0x0222:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x022e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x023a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0241:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x024d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0259:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0265:
        r1 = move-exception;
        r2 = "Cannot show popup window: ";
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x0020 }
        r3 = r1.length();	 Catch:{ all -> 0x0020 }
        if (r3 == 0) goto L_0x02a8;
    L_0x0276:
        r1 = r2.concat(r1);	 Catch:{ all -> 0x0020 }
    L_0x027a:
        r12.m7690b(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5034r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m8760b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5035s;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x02a5;
    L_0x028c:
        r1 = r12.f5035s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5030n;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5035s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m8760b();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f5027k;	 Catch:{ all -> 0x0020 }
        r2 = r12.f5029m;	 Catch:{ all -> 0x0020 }
        r1.m8754a(r2);	 Catch:{ all -> 0x0020 }
    L_0x02a5:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x02a8:
        r1 = new java.lang.String;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        goto L_0x027a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mv.a(java.util.Map):void");
    }

    public void m7704a(boolean z) {
        synchronized (this.f5026j) {
            if (this.f5033q != null) {
                this.f5033q.dismiss();
                this.f5034r.removeView(this.f5027k.m8760b());
                if (this.f5035s != null) {
                    this.f5035s.removeView(this.f5030n);
                    this.f5035s.addView(this.f5027k.m8760b());
                    this.f5027k.m8754a(this.f5029m);
                }
                if (z) {
                    m7692d("default");
                    if (this.f5032p != null) {
                        this.f5032p.zzbZ();
                    }
                }
                this.f5033q = null;
                this.f5034r = null;
                this.f5035s = null;
                this.f5031o = null;
            }
        }
    }

    boolean m7705a() {
        return this.f5025i > -1 && this.f5022f > -1;
    }

    void m7706b(int i, int i2) {
        m7687a(i, i2 - zzv.zzcJ().m8544d(this.f5028l)[0], this.f5025i, this.f5022f);
    }

    public boolean m7707b() {
        boolean z;
        synchronized (this.f5026j) {
            z = this.f5033q != null;
        }
        return z;
    }

    public void m7708c(int i, int i2) {
        this.f5020d = i;
        this.f5021e = i2;
    }

    boolean m7709c() {
        int[] b = zzv.zzcJ().m8537b(this.f5028l);
        int[] d = zzv.zzcJ().m8544d(this.f5028l);
        int i = b[0];
        int i2 = b[1];
        if (this.f5025i < 50 || this.f5025i > i) {
            sg.m8449e("Width is too small or too large.");
            return false;
        } else if (this.f5022f < 50 || this.f5022f > i2) {
            sg.m8449e("Height is too small or too large.");
            return false;
        } else if (this.f5022f == i2 && this.f5025i == i) {
            sg.m8449e("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.f5019c) {
                int i3;
                String str = this.f5018b;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            z = false;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        i3 = this.f5023g + this.f5020d;
                        i2 = this.f5021e + this.f5024h;
                        break;
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                        i3 = ((this.f5020d + this.f5023g) + (this.f5025i / 2)) - 25;
                        i2 = this.f5021e + this.f5024h;
                        break;
                    case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                        i3 = ((this.f5020d + this.f5023g) + (this.f5025i / 2)) - 25;
                        i2 = ((this.f5021e + this.f5024h) + (this.f5022f / 2)) - 25;
                        break;
                    case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                        i3 = this.f5023g + this.f5020d;
                        i2 = ((this.f5021e + this.f5024h) + this.f5022f) - 50;
                        break;
                    case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                        i3 = ((this.f5020d + this.f5023g) + (this.f5025i / 2)) - 25;
                        i2 = ((this.f5021e + this.f5024h) + this.f5022f) - 50;
                        break;
                    case C1096c.MapAttrs_cameraZoom /*5*/:
                        i3 = ((this.f5020d + this.f5023g) + this.f5025i) - 50;
                        i2 = ((this.f5021e + this.f5024h) + this.f5022f) - 50;
                        break;
                    default:
                        i3 = ((this.f5020d + this.f5023g) + this.f5025i) - 50;
                        i2 = this.f5021e + this.f5024h;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < d[0] || r2 + 50 > d[1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
