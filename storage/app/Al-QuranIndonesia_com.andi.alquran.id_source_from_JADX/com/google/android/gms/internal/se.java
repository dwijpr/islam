package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzv;

@op
public final class se {
    private final View f5823a;
    private Activity f5824b;
    private boolean f5825c;
    private boolean f5826d;
    private boolean f5827e;
    private OnGlobalLayoutListener f5828f;
    private OnScrollChangedListener f5829g;

    public se(Activity activity, View view, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.f5824b = activity;
        this.f5823a = view;
        this.f5828f = onGlobalLayoutListener;
        this.f5829g = onScrollChangedListener;
    }

    private void m8681e() {
        if (!this.f5825c) {
            if (this.f5828f != null) {
                if (this.f5824b != null) {
                    zzv.zzcJ().m8507a(this.f5824b, this.f5828f);
                }
                zzv.zzdh().m8725a(this.f5823a, this.f5828f);
            }
            if (this.f5829g != null) {
                if (this.f5824b != null) {
                    zzv.zzcJ().m8508a(this.f5824b, this.f5829g);
                }
                zzv.zzdh().m8726a(this.f5823a, this.f5829g);
            }
            this.f5825c = true;
        }
    }

    private void m8682f() {
        if (this.f5824b != null && this.f5825c) {
            if (!(this.f5828f == null || this.f5824b == null)) {
                zzv.zzcL().m8566a(this.f5824b, this.f5828f);
            }
            if (!(this.f5829g == null || this.f5824b == null)) {
                zzv.zzcJ().m8533b(this.f5824b, this.f5829g);
            }
            this.f5825c = false;
        }
    }

    public void m8683a() {
        this.f5827e = true;
        if (this.f5826d) {
            m8681e();
        }
    }

    public void m8684a(Activity activity) {
        this.f5824b = activity;
    }

    public void m8685b() {
        this.f5827e = false;
        m8682f();
    }

    public void m8686c() {
        this.f5826d = true;
        if (this.f5827e) {
            m8681e();
        }
    }

    public void m8687d() {
        this.f5826d = false;
        m8682f();
    }
}
