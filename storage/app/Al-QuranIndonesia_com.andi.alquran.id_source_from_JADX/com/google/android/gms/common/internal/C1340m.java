package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.internal.C2057w;

/* renamed from: com.google.android.gms.common.internal.m */
public abstract class C1340m implements OnClickListener {

    /* renamed from: com.google.android.gms.common.internal.m.1 */
    class C13411 extends C1340m {
        final /* synthetic */ Intent f3101a;
        final /* synthetic */ Activity f3102b;
        final /* synthetic */ int f3103c;

        C13411(Intent intent, Activity activity, int i) {
            this.f3101a = intent;
            this.f3102b = activity;
            this.f3103c = i;
        }

        public void m4752a() {
            if (this.f3101a != null) {
                this.f3102b.startActivityForResult(this.f3101a, this.f3103c);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.m.2 */
    class C13422 extends C1340m {
        final /* synthetic */ Intent f3104a;
        final /* synthetic */ C2057w f3105b;
        final /* synthetic */ int f3106c;

        C13422(Intent intent, C2057w c2057w, int i) {
            this.f3104a = intent;
            this.f3105b = c2057w;
            this.f3106c = i;
        }

        @TargetApi(11)
        public void m4753a() {
            if (this.f3104a != null) {
                this.f3105b.startActivityForResult(this.f3104a, this.f3106c);
            }
        }
    }

    public static C1340m m4749a(Activity activity, Intent intent, int i) {
        return new C13411(intent, activity, i);
    }

    public static C1340m m4750a(C2057w c2057w, Intent intent, int i) {
        return new C13422(intent, c2057w, i);
    }

    protected abstract void m4751a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            m4751a();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
