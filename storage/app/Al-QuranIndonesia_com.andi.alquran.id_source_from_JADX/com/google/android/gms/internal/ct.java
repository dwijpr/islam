package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.p041a.C1245b;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.internal.C1308t;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1317j.C1334i;
import com.google.android.gms.common.internal.C1319o;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.internal.cr.C1515a;

public class ct extends C1319o<cr> implements cl {
    private final boolean f3700e;
    private final C1338k f3701f;
    private final Bundle f3702g;
    private Integer f3703h;

    public ct(Context context, Looper looper, boolean z, C1338k c1338k, Bundle bundle, C0777b c0777b, C0778c c0778c) {
        super(context, looper, 44, c1338k, c0777b, c0778c);
        this.f3700e = z;
        this.f3701f = c1338k;
        this.f3702g = bundle;
        this.f3703h = c1338k.m4740i();
    }

    public ct(Context context, Looper looper, boolean z, C1338k c1338k, cm cmVar, C0777b c0777b, C0778c c0778c) {
        this(context, looper, z, c1338k, m5601a(c1338k), c0777b, c0778c);
    }

    public static Bundle m5601a(C1338k c1338k) {
        cm h = c1338k.m4739h();
        Integer i = c1338k.m4740i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c1338k.m4731a());
        if (i != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.m5558a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.m5559b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.m5560c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.m5561d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.m5562e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.m5563f());
            if (h.m5564g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.m5564g().longValue());
            }
            if (h.m5565h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.m5565h().longValue());
            }
        }
        return bundle;
    }

    private zzad m5602x() {
        Account b = this.f3701f.m4733b();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(b.name)) {
            googleSignInAccount = C1245b.m4406a(m4677o()).m4408a();
        }
        return new zzad(b, this.f3703h.intValue(), googleSignInAccount);
    }

    protected /* synthetic */ IInterface m5603a(IBinder iBinder) {
        return m5606b(iBinder);
    }

    public void m5604a(C1308t c1308t, boolean z) {
        try {
            ((cr) m4683u()).m5579a(c1308t, this.f3703h.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void m5605a(cq cqVar) {
        C1314c.m4624a((Object) cqVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((cr) m4683u()).m5585a(new zzaxz(m5602x()), cqVar);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                cqVar.m5053a(new zzayb(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected cr m5606b(IBinder iBinder) {
        return C1515a.m5597a(iBinder);
    }

    public boolean m5607d() {
        return this.f3700e;
    }

    protected String m5608i() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String m5609j() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public void m5610k() {
        try {
            ((cr) m4683u()).m5577a(this.f3703h.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void m5611l() {
        m4662a(new C1334i(this));
    }

    protected Bundle m5612r() {
        if (!m4677o().getPackageName().equals(this.f3701f.m4737f())) {
            this.f3702g.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f3701f.m4737f());
        }
        return this.f3702g;
    }
}
