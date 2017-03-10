package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.C1262a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1317j.C1326b;
import com.google.android.gms.common.internal.C1317j.C1327c;
import com.google.android.gms.common.internal.C1346p.C1318a;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.o */
public abstract class C1319o<T extends IInterface> extends C1317j<T> implements C1269f, C1318a {
    private final C1338k f3069e;
    private final Set<Scope> f3070f;
    private final Account f3071g;

    /* renamed from: com.google.android.gms.common.internal.o.1 */
    class C13441 implements C1326b {
        final /* synthetic */ C0777b f3107a;

        C13441(C0777b c0777b) {
            this.f3107a = c0777b;
        }

        public void m4757a(int i) {
            this.f3107a.m2642a(i);
        }

        public void m4758a(Bundle bundle) {
            this.f3107a.m2643a(bundle);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.o.2 */
    class C13452 implements C1327c {
        final /* synthetic */ C0778c f3108a;

        C13452(C0778c c0778c) {
            this.f3108a = c0778c;
        }

        public void m4759a(ConnectionResult connectionResult) {
            this.f3108a.m2644a(connectionResult);
        }
    }

    protected C1319o(Context context, Looper looper, int i, C1338k c1338k, C0777b c0777b, C0778c c0778c) {
        this(context, looper, C1347q.m4768a(context), C1262a.m4471a(), i, c1338k, (C0777b) C1314c.m4623a((Object) c0777b), (C0778c) C1314c.m4623a((Object) c0778c));
    }

    protected C1319o(Context context, Looper looper, C1347q c1347q, C1262a c1262a, int i, C1338k c1338k, C0777b c0777b, C0778c c0778c) {
        super(context, looper, c1347q, c1262a, i, C1319o.m4688a(c0777b), C1319o.m4689a(c0778c), c1338k.m4738g());
        this.f3069e = c1338k;
        this.f3071g = c1338k.m4731a();
        this.f3070f = m4690b(c1338k.m4735d());
    }

    private static C1326b m4688a(C0777b c0777b) {
        return c0777b == null ? null : new C13441(c0777b);
    }

    private static C1327c m4689a(C0778c c0778c) {
        return c0778c == null ? null : new C13452(c0778c);
    }

    private Set<Scope> m4690b(Set<Scope> set) {
        Set<Scope> a = m4691a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    protected Set<Scope> m4691a(Set<Scope> set) {
        return set;
    }

    public final Account m4692p() {
        return this.f3071g;
    }

    protected final Set<Scope> m4693w() {
        return this.f3070f;
    }
}
