package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.p041a.C1245b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1274a.C1266b;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1308t;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.common.internal.zzaf;
import java.util.HashSet;
import java.util.Set;

public class ag extends co implements C0777b, C0778c {
    private static C1266b<? extends cl, cm> f3282a;
    private final Context f3283b;
    private final Handler f3284c;
    private final C1266b<? extends cl, cm> f3285d;
    private final boolean f3286e;
    private Set<Scope> f3287f;
    private C1338k f3288g;
    private cl f3289h;
    private C1425a f3290i;

    /* renamed from: com.google.android.gms.internal.ag.1 */
    class C14241 implements Runnable {
        final /* synthetic */ zzayb f3280a;
        final /* synthetic */ ag f3281b;

        C14241(ag agVar, zzayb com_google_android_gms_internal_zzayb) {
            this.f3281b = agVar;
            this.f3280a = com_google_android_gms_internal_zzayb;
        }

        public void run() {
            this.f3281b.m5062b(this.f3280a);
        }
    }

    /* renamed from: com.google.android.gms.internal.ag.a */
    public interface C1425a {
        void m5048a(C1308t c1308t, Set<Scope> set);

        void m5049b(ConnectionResult connectionResult);
    }

    static {
        f3282a = ck.f3683c;
    }

    public ag(Context context, Handler handler) {
        this.f3283b = context;
        this.f3284c = handler;
        GoogleSignInOptions b = C1245b.m4406a(this.f3283b).m4410b();
        this.f3287f = b == null ? new HashSet() : new HashSet(b.m4396a());
        this.f3288g = new C1338k(null, this.f3287f, null, 0, null, null, null, cm.f3689a);
        this.f3285d = f3282a;
        this.f3286e = true;
    }

    public ag(Context context, Handler handler, C1338k c1338k, C1266b<? extends cl, cm> c1266b) {
        this.f3283b = context;
        this.f3284c = handler;
        this.f3288g = c1338k;
        this.f3287f = c1338k.m4734c();
        this.f3285d = c1266b;
        this.f3286e = false;
    }

    private void m5062b(zzayb com_google_android_gms_internal_zzayb) {
        ConnectionResult a = com_google_android_gms_internal_zzayb.m9759a();
        if (a.m4452b()) {
            zzaf b = com_google_android_gms_internal_zzayb.m9760b();
            ConnectionResult b2 = b.m4872b();
            if (b2.m4452b()) {
                this.f3290i.m5048a(b.m4871a(), this.f3287f);
            } else {
                String valueOf = String.valueOf(b2);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                this.f3290i.m5049b(b2);
                this.f3289h.m4511a();
                return;
            }
        }
        this.f3290i.m5049b(a);
        this.f3289h.m4511a();
    }

    public void m5063a() {
        this.f3289h.m4511a();
    }

    public void m5064a(int i) {
        this.f3289h.m4511a();
    }

    public void m5065a(Bundle bundle) {
        this.f3289h.m5554a(this);
    }

    public void m5066a(ConnectionResult connectionResult) {
        this.f3290i.m5049b(connectionResult);
    }

    public void m5067a(C1425a c1425a) {
        if (this.f3289h != null) {
            this.f3289h.m4511a();
        }
        if (this.f3286e) {
            GoogleSignInOptions b = C1245b.m4406a(this.f3283b).m4410b();
            this.f3287f = b == null ? new HashSet() : new HashSet(b.m4396a());
            this.f3288g = new C1338k(null, this.f3287f, null, 0, null, null, null, cm.f3689a);
        }
        this.f3289h = (cl) this.f3285d.m4510a(this.f3283b, this.f3284c.getLooper(), this.f3288g, this.f3288g.m4739h(), this, this);
        this.f3290i = c1425a;
        this.f3289h.m5556l();
    }

    public void m5068a(zzayb com_google_android_gms_internal_zzayb) {
        this.f3284c.post(new C14241(this, com_google_android_gms_internal_zzayb));
    }
}
