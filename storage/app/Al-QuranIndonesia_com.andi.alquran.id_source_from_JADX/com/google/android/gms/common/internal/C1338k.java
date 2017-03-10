package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1277c.C1276a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.cm;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.k */
public final class C1338k {
    private final Account f3090a;
    private final Set<Scope> f3091b;
    private final Set<Scope> f3092c;
    private final Map<C1274a<?>, C1337a> f3093d;
    private final int f3094e;
    private final View f3095f;
    private final String f3096g;
    private final String f3097h;
    private final cm f3098i;
    private Integer f3099j;

    /* renamed from: com.google.android.gms.common.internal.k.a */
    public static final class C1337a {
        public final Set<Scope> f3088a;
        public final boolean f3089b;
    }

    public C1338k(Account account, Set<Scope> set, Map<C1274a<?>, C1337a> map, int i, View view, String str, String str2, cm cmVar) {
        Map map2;
        this.f3090a = account;
        this.f3091b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f3093d = map2;
        this.f3095f = view;
        this.f3094e = i;
        this.f3096g = str;
        this.f3097h = str2;
        this.f3098i = cmVar;
        Set hashSet = new HashSet(this.f3091b);
        for (C1337a c1337a : this.f3093d.values()) {
            hashSet.addAll(c1337a.f3088a);
        }
        this.f3092c = Collections.unmodifiableSet(hashSet);
    }

    public static C1338k m4730a(Context context) {
        return new C1276a(context).m4536a();
    }

    public Account m4731a() {
        return this.f3090a;
    }

    public void m4732a(Integer num) {
        this.f3099j = num;
    }

    public Account m4733b() {
        return this.f3090a != null ? this.f3090a : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> m4734c() {
        return this.f3091b;
    }

    public Set<Scope> m4735d() {
        return this.f3092c;
    }

    public Map<C1274a<?>, C1337a> m4736e() {
        return this.f3093d;
    }

    public String m4737f() {
        return this.f3096g;
    }

    public String m4738g() {
        return this.f3097h;
    }

    public cm m4739h() {
        return this.f3098i;
    }

    public Integer m4740i() {
        return this.f3099j;
    }
}
