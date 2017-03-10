package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.C1262a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.C1937r.C1725a;

public abstract class wn extends C1587v implements OnCancelListener {
    protected boolean f4134b;
    protected boolean f4135c;
    protected final C1262a f4136d;
    private ConnectionResult f4137e;
    private int f4138f;
    private final Handler f4139g;

    /* renamed from: com.google.android.gms.internal.wn.a */
    private class C2072a implements Runnable {
        final /* synthetic */ wn f6335a;

        /* renamed from: com.google.android.gms.internal.wn.a.1 */
        class C20711 extends C1725a {
            final /* synthetic */ Dialog f6333a;
            final /* synthetic */ C2072a f6334b;

            C20711(C2072a c2072a, Dialog dialog) {
                this.f6334b = c2072a;
                this.f6333a = dialog;
            }

            public void m9688a() {
                this.f6334b.f6335a.m6296g();
                if (this.f6333a.isShowing()) {
                    this.f6333a.dismiss();
                }
            }
        }

        private C2072a(wn wnVar) {
            this.f6335a = wnVar;
        }

        public void run() {
            if (!this.f6335a.f4134b) {
                return;
            }
            if (this.f6335a.f4137e.m4451a()) {
                this.f6335a.a.startActivityForResult(GoogleApiActivity.m4498b(this.f6335a.m6284e(), this.f6335a.f4137e.m4454d(), this.f6335a.f4138f, false), 1);
            } else if (this.f6335a.f4136d.m4485a(this.f6335a.f4137e.m4453c())) {
                this.f6335a.f4136d.m4486a(this.f6335a.m6284e(), this.f6335a.a, this.f6335a.f4137e.m4453c(), 2, this.f6335a);
            } else if (this.f6335a.f4137e.m4453c() == 18) {
                this.f6335a.f4136d.m4479a(this.f6335a.m6284e().getApplicationContext(), new C20711(this, this.f6335a.f4136d.m4474a(this.f6335a.m6284e(), this.f6335a)));
            } else {
                this.f6335a.m6291a(this.f6335a.f4137e, this.f6335a.f4138f);
            }
        }
    }

    protected wn(C2057w c2057w) {
        this(c2057w, C1262a.m4471a());
    }

    wn(C2057w c2057w, C1262a c1262a) {
        super(c2057w);
        this.f4138f = -1;
        this.f4139g = new Handler(Looper.getMainLooper());
        this.f4136d = c1262a;
    }

    public void m6288a() {
        super.m6278a();
        this.f4134b = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6289a(int r6, int r7, android.content.Intent r8) {
        /*
        r5 = this;
        r4 = 18;
        r2 = 13;
        r0 = 1;
        r1 = 0;
        switch(r6) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0010;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 == 0) goto L_0x003d;
    L_0x000c:
        r5.m6296g();
    L_0x000f:
        return;
    L_0x0010:
        r2 = r5.f4136d;
        r3 = r5.m6284e();
        r2 = r2.m4472a(r3);
        if (r2 != 0) goto L_0x0047;
    L_0x001c:
        r1 = r5.f4137e;
        r1 = r1.m4453c();
        if (r1 != r4) goto L_0x000a;
    L_0x0024:
        if (r2 != r4) goto L_0x000a;
    L_0x0026:
        goto L_0x000f;
    L_0x0027:
        r3 = -1;
        if (r7 == r3) goto L_0x000a;
    L_0x002a:
        if (r7 != 0) goto L_0x0009;
    L_0x002c:
        if (r8 == 0) goto L_0x0045;
    L_0x002e:
        r0 = "<<ResolutionFailureErrorDetail>>";
        r0 = r8.getIntExtra(r0, r2);
    L_0x0034:
        r2 = new com.google.android.gms.common.ConnectionResult;
        r3 = 0;
        r2.<init>(r0, r3);
        r5.f4137e = r2;
        goto L_0x0009;
    L_0x003d:
        r0 = r5.f4137e;
        r1 = r5.f4138f;
        r5.m6291a(r0, r1);
        goto L_0x000f;
    L_0x0045:
        r0 = r2;
        goto L_0x0034;
    L_0x0047:
        r0 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wn.a(int, int, android.content.Intent):void");
    }

    public void m6290a(Bundle bundle) {
        super.m6280a(bundle);
        if (bundle != null) {
            this.f4135c = bundle.getBoolean("resolving_error", false);
            if (this.f4135c) {
                this.f4138f = bundle.getInt("failed_client_id", -1);
                this.f4137e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    protected abstract void m6291a(ConnectionResult connectionResult, int i);

    public void m6292b() {
        super.m6282b();
        this.f4134b = false;
    }

    public void m6293b(Bundle bundle) {
        super.m6283b(bundle);
        bundle.putBoolean("resolving_error", this.f4135c);
        if (this.f4135c) {
            bundle.putInt("failed_client_id", this.f4138f);
            bundle.putInt("failed_status", this.f4137e.m4453c());
            bundle.putParcelable("failed_resolution", this.f4137e.m4454d());
        }
    }

    public void m6294b(ConnectionResult connectionResult, int i) {
        if (!this.f4135c) {
            this.f4135c = true;
            this.f4138f = i;
            this.f4137e = connectionResult;
            this.f4139g.post(new C2072a());
        }
    }

    protected abstract void m6295c();

    protected void m6296g() {
        this.f4138f = -1;
        this.f4135c = false;
        this.f4137e = null;
        m6295c();
    }

    public void onCancel(DialogInterface dialogInterface) {
        m6291a(new ConnectionResult(13, null), this.f4138f);
        m6296g();
    }
}
