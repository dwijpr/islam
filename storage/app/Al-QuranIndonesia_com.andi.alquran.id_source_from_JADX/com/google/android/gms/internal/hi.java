package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@op
public final class hi {
    public static final String f4251a;
    private final Date f4252b;
    private final String f4253c;
    private final int f4254d;
    private final Set<String> f4255e;
    private final Location f4256f;
    private final boolean f4257g;
    private final Bundle f4258h;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> f4259i;
    private final String f4260j;
    private final String f4261k;
    private final SearchAdRequest f4262l;
    private final int f4263m;
    private final Set<String> f4264n;
    private final Bundle f4265o;
    private final Set<String> f4266p;
    private final boolean f4267q;

    /* renamed from: com.google.android.gms.internal.hi.a */
    public static final class C1627a {
        private final HashSet<String> f4236a;
        private final Bundle f4237b;
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> f4238c;
        private final HashSet<String> f4239d;
        private final Bundle f4240e;
        private final HashSet<String> f4241f;
        private Date f4242g;
        private String f4243h;
        private int f4244i;
        private Location f4245j;
        private boolean f4246k;
        private String f4247l;
        private String f4248m;
        private int f4249n;
        private boolean f4250o;

        public C1627a() {
            this.f4236a = new HashSet();
            this.f4237b = new Bundle();
            this.f4238c = new HashMap();
            this.f4239d = new HashSet();
            this.f4240e = new Bundle();
            this.f4241f = new HashSet();
            this.f4244i = -1;
            this.f4246k = false;
            this.f4249n = -1;
        }

        public void m6492a(int i) {
            this.f4244i = i;
        }

        public void m6493a(Location location) {
            this.f4245j = location;
        }

        @Deprecated
        public void m6494a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                m6495a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.f4238c.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void m6495a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f4237b.putBundle(cls.getName(), bundle);
        }

        public void m6496a(String str) {
            this.f4236a.add(str);
        }

        public void m6497a(String str, String str2) {
            this.f4240e.putString(str, str2);
        }

        public void m6498a(Date date) {
            this.f4242g = date;
        }

        public void m6499a(boolean z) {
            this.f4246k = z;
        }

        public void m6500b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.f4237b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.f4237b.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.f4237b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void m6501b(String str) {
            this.f4239d.add(str);
        }

        public void m6502b(boolean z) {
            this.f4249n = z ? 1 : 0;
        }

        public void m6503c(String str) {
            this.f4239d.remove(str);
        }

        public void m6504c(boolean z) {
            this.f4250o = z;
        }

        public void m6505d(String str) {
            this.f4243h = str;
        }

        public void m6506e(String str) {
            this.f4247l = str;
        }

        public void m6507f(String str) {
            this.f4248m = str;
        }

        public void m6508g(String str) {
            this.f4241f.add(str);
        }
    }

    static {
        f4251a = gr.m6416a().m8693a("emulator");
    }

    public hi(C1627a c1627a) {
        this(c1627a, null);
    }

    public hi(C1627a c1627a, SearchAdRequest searchAdRequest) {
        this.f4252b = c1627a.f4242g;
        this.f4253c = c1627a.f4243h;
        this.f4254d = c1627a.f4244i;
        this.f4255e = Collections.unmodifiableSet(c1627a.f4236a);
        this.f4256f = c1627a.f4245j;
        this.f4257g = c1627a.f4246k;
        this.f4258h = c1627a.f4237b;
        this.f4259i = Collections.unmodifiableMap(c1627a.f4238c);
        this.f4260j = c1627a.f4247l;
        this.f4261k = c1627a.f4248m;
        this.f4262l = searchAdRequest;
        this.f4263m = c1627a.f4249n;
        this.f4264n = Collections.unmodifiableSet(c1627a.f4239d);
        this.f4265o = c1627a.f4240e;
        this.f4266p = Collections.unmodifiableSet(c1627a.f4241f);
        this.f4267q = c1627a.f4250o;
    }

    @Deprecated
    public <T extends NetworkExtras> T m6509a(Class<T> cls) {
        return (NetworkExtras) this.f4259i.get(cls);
    }

    public Date m6510a() {
        return this.f4252b;
    }

    public boolean m6511a(Context context) {
        return this.f4264n.contains(gr.m6416a().m8692a(context));
    }

    public Bundle m6512b(Class<? extends MediationAdapter> cls) {
        return this.f4258h.getBundle(cls.getName());
    }

    public String m6513b() {
        return this.f4253c;
    }

    public int m6514c() {
        return this.f4254d;
    }

    public Bundle m6515c(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.f4258h.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(cls.getName()) : null;
    }

    public Set<String> m6516d() {
        return this.f4255e;
    }

    public Location m6517e() {
        return this.f4256f;
    }

    public boolean m6518f() {
        return this.f4257g;
    }

    public String m6519g() {
        return this.f4260j;
    }

    public String m6520h() {
        return this.f4261k;
    }

    public SearchAdRequest m6521i() {
        return this.f4262l;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> m6522j() {
        return this.f4259i;
    }

    public Bundle m6523k() {
        return this.f4258h;
    }

    public int m6524l() {
        return this.f4263m;
    }

    public Bundle m6525m() {
        return this.f4265o;
    }

    public Set<String> m6526n() {
        return this.f4266p;
    }

    public boolean m6527o() {
        return this.f4267q;
    }
}
