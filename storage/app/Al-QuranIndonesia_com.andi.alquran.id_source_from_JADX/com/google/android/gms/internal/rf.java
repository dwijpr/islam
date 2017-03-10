package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.fn.C1574b;
import com.google.android.gms.internal.ro.C1942b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;

@op
public class rf implements C1574b, C1942b {
    private String f5660A;
    private long f5661B;
    private long f5662C;
    private int f5663D;
    private final Object f5664a;
    private final String f5665b;
    private final rg f5666c;
    private fb f5667d;
    private BigInteger f5668e;
    private final HashSet<rd> f5669f;
    private final HashMap<String, rj> f5670g;
    private boolean f5671h;
    private boolean f5672i;
    private int f5673j;
    private boolean f5674k;
    private Context f5675l;
    private zzqa f5676m;
    private ih f5677n;
    private boolean f5678o;
    private boolean f5679p;
    private fo f5680q;
    private fl f5681r;
    private String f5682s;
    private String f5683t;
    private Boolean f5684u;
    private String f5685v;
    private boolean f5686w;
    private boolean f5687x;
    private boolean f5688y;
    private boolean f5689z;

    public rf(rq rqVar) {
        this.f5664a = new Object();
        this.f5668e = BigInteger.ONE;
        this.f5669f = new HashSet();
        this.f5670g = new HashMap();
        this.f5671h = false;
        this.f5672i = true;
        this.f5673j = 0;
        this.f5674k = false;
        this.f5677n = null;
        this.f5678o = true;
        this.f5679p = true;
        this.f5680q = null;
        this.f5681r = null;
        this.f5684u = null;
        this.f5686w = false;
        this.f5687x = false;
        this.f5688y = false;
        this.f5689z = false;
        this.f5660A = BuildConfig.VERSION_NAME;
        this.f5661B = 0;
        this.f5662C = 0;
        this.f5663D = -1;
        this.f5665b = rqVar.m8543d();
        this.f5666c = new rg(this.f5665b);
    }

    public Bundle m8386a(Context context, ri riVar, String str) {
        Bundle bundle;
        synchronized (this.f5664a) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f5666c.m8431a(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.f5670g.keySet()) {
                bundle2.putBundle(str2, ((rj) this.f5670g.get(str2)).m8437a());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f5669f.iterator();
            while (it.hasNext()) {
                arrayList.add(((rd) it.next()).m8377d());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            riVar.zza(this.f5669f);
            this.f5669f.clear();
        }
        return bundle;
    }

    public fo m8387a(Context context) {
        if (!((Boolean) C1648if.f4361Y.m6682c()).booleanValue()) {
            return null;
        }
        if (!C1387m.m4961c()) {
            return null;
        }
        if (!((Boolean) C1648if.ag.m6682c()).booleanValue() && !((Boolean) C1648if.ae.m6682c()).booleanValue()) {
            return null;
        }
        if (m8405b() && m8407c()) {
            return null;
        }
        synchronized (this.f5664a) {
            if (Looper.getMainLooper() == null || context == null) {
                return null;
            }
            if (this.f5681r == null) {
                this.f5681r = new fl();
            }
            if (this.f5680q == null) {
                this.f5680q = new fo(this.f5681r, om.m7923a(this.f5675l, this.f5676m));
            }
            this.f5680q.m6205a();
            fo foVar = this.f5680q;
            return foVar;
        }
    }

    public String m8388a() {
        return this.f5665b;
    }

    public Future m8389a(int i) {
        Future a;
        synchronized (this.f5664a) {
            this.f5663D = i;
            a = ro.m8454a(this.f5675l, i);
        }
        return a;
    }

    public Future m8390a(long j) {
        Future a;
        synchronized (this.f5664a) {
            if (this.f5662C < j) {
                this.f5662C = j;
                a = ro.m8455a(this.f5675l, j);
            } else {
                a = null;
            }
        }
        return a;
    }

    public Future m8391a(Context context, String str) {
        Future a;
        this.f5661B = zzv.zzcP().m4926a();
        synchronized (this.f5664a) {
            if (str != null) {
                if (!str.equals(this.f5660A)) {
                    this.f5660A = str;
                    a = ro.m8458a(context, str, this.f5661B);
                }
            }
            a = null;
        }
        return a;
    }

    public Future m8392a(Context context, boolean z) {
        Future a;
        synchronized (this.f5664a) {
            if (z != this.f5672i) {
                this.f5672i = z;
                a = ro.m8459a(context, z);
            } else {
                a = null;
            }
        }
        return a;
    }

    public Future m8393a(String str) {
        Future a;
        synchronized (this.f5664a) {
            if (str != null) {
                if (!str.equals(this.f5682s)) {
                    this.f5682s = str;
                    a = ro.m8457a(this.f5675l, str);
                }
            }
            a = null;
        }
        return a;
    }

    @TargetApi(23)
    public void m8394a(Context context, zzqa com_google_android_gms_internal_zzqa) {
        synchronized (this.f5664a) {
            if (!this.f5674k) {
                this.f5675l = context.getApplicationContext();
                this.f5676m = com_google_android_gms_internal_zzqa;
                zzv.zzcM().m6201a((C1574b) this);
                ro.m8456a(context, (C1942b) this);
                ro.m8460b(context, (C1942b) this);
                ro.m8463c(context, (C1942b) this);
                ro.m8465d(context, this);
                ro.m8466e(context, this);
                ro.m8467f(context, this);
                ro.m8468g(context, this);
                m8426t();
                this.f5685v = zzv.zzcJ().m8498a(context, com_google_android_gms_internal_zzqa.f6636b);
                if (C1387m.m4969k() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.f5687x = true;
                }
                this.f5667d = new fb(context.getApplicationContext(), this.f5676m, zzv.zzcJ().m8495a(context, com_google_android_gms_internal_zzqa));
                m8428v();
                zzv.zzcX().zzr(this.f5675l);
                this.f5674k = true;
            }
        }
    }

    public void m8395a(Bundle bundle) {
        synchronized (this.f5664a) {
            this.f5672i = bundle.getBoolean("use_https", this.f5672i);
            this.f5673j = bundle.getInt("webview_cache_version", this.f5673j);
            if (bundle.containsKey("content_url_opted_out")) {
                m8404b(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.f5682s = bundle.getString("content_url_hashes");
            }
            this.f5688y = bundle.getBoolean("auto_collect_location", this.f5688y);
            if (bundle.containsKey("content_vertical_opted_out")) {
                m8406c(bundle.getBoolean("content_vertical_opted_out"));
            }
            if (bundle.containsKey("content_vertical_hashes")) {
                this.f5683t = bundle.getString("content_vertical_hashes");
            }
            this.f5660A = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.f5660A;
            this.f5661B = bundle.getLong("app_settings_last_update_ms", this.f5661B);
            this.f5662C = bundle.getLong("app_last_background_time_ms", this.f5662C);
            this.f5663D = bundle.getInt("request_in_session_count", this.f5663D);
        }
    }

    public void m8396a(rd rdVar) {
        synchronized (this.f5664a) {
            this.f5669f.add(rdVar);
        }
    }

    public void m8397a(Boolean bool) {
        synchronized (this.f5664a) {
            this.f5684u = bool;
        }
    }

    public void m8398a(String str, rj rjVar) {
        synchronized (this.f5664a) {
            this.f5670g.put(str, rjVar);
        }
    }

    public void m8399a(Throwable th, String str) {
        om.m7923a(this.f5675l, this.f5676m).m7922a(th, str);
    }

    public void m8400a(HashSet<rd> hashSet) {
        synchronized (this.f5664a) {
            this.f5669f.addAll(hashSet);
        }
    }

    public void m8401a(boolean z) {
        if (!z) {
            m8390a(zzv.zzcP().m4926a());
            m8389a(this.f5666c.m8436d());
        } else if (zzv.zzcP().m4926a() - this.f5662C > ((Long) C1648if.aF.m6682c()).longValue()) {
            this.f5666c.m8432a(-1);
        } else {
            this.f5666c.m8432a(this.f5663D);
        }
    }

    public Future m8402b(Context context, boolean z) {
        Future c;
        synchronized (this.f5664a) {
            if (z != this.f5688y) {
                this.f5688y = z;
                c = ro.m8464c(context, z);
            } else {
                c = null;
            }
        }
        return c;
    }

    public Future m8403b(String str) {
        Future b;
        synchronized (this.f5664a) {
            if (str != null) {
                if (!str.equals(this.f5683t)) {
                    this.f5683t = str;
                    b = ro.m8461b(this.f5675l, str);
                }
            }
            b = null;
        }
        return b;
    }

    public void m8404b(boolean z) {
        synchronized (this.f5664a) {
            if (this.f5678o != z) {
                ro.m8462b(this.f5675l, z);
            }
            this.f5678o = z;
            fo a = m8387a(this.f5675l);
            if (!(a == null || a.isAlive())) {
                sg.m8448d("start fetching content...");
                a.m6205a();
            }
        }
    }

    public boolean m8405b() {
        boolean z;
        synchronized (this.f5664a) {
            z = this.f5678o;
        }
        return z;
    }

    public void m8406c(boolean z) {
        synchronized (this.f5664a) {
            if (this.f5679p != z) {
                ro.m8462b(this.f5675l, z);
            }
            ro.m8462b(this.f5675l, z);
            this.f5679p = z;
            fo a = m8387a(this.f5675l);
            if (!(a == null || a.isAlive())) {
                sg.m8448d("start fetching content...");
                a.m6205a();
            }
        }
    }

    public boolean m8407c() {
        boolean z;
        synchronized (this.f5664a) {
            z = this.f5679p;
        }
        return z;
    }

    public String m8408d() {
        String bigInteger;
        synchronized (this.f5664a) {
            bigInteger = this.f5668e.toString();
            this.f5668e = this.f5668e.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public void m8409d(boolean z) {
        this.f5689z = z;
    }

    public rg m8410e() {
        rg rgVar;
        synchronized (this.f5664a) {
            rgVar = this.f5666c;
        }
        return rgVar;
    }

    public void m8411e(boolean z) {
        synchronized (this.f5664a) {
            this.f5686w = z;
        }
    }

    public ih m8412f() {
        ih ihVar;
        synchronized (this.f5664a) {
            ihVar = this.f5677n;
        }
        return ihVar;
    }

    public boolean m8413g() {
        boolean z;
        synchronized (this.f5664a) {
            z = this.f5671h;
            this.f5671h = true;
        }
        return z;
    }

    public boolean m8414h() {
        boolean z;
        synchronized (this.f5664a) {
            z = this.f5672i || this.f5687x;
        }
        return z;
    }

    public String m8415i() {
        String str;
        synchronized (this.f5664a) {
            str = this.f5685v;
        }
        return str;
    }

    public String m8416j() {
        String str;
        synchronized (this.f5664a) {
            str = this.f5682s;
        }
        return str;
    }

    public String m8417k() {
        String str;
        synchronized (this.f5664a) {
            str = this.f5683t;
        }
        return str;
    }

    public Boolean m8418l() {
        Boolean bool;
        synchronized (this.f5664a) {
            bool = this.f5684u;
        }
        return bool;
    }

    public boolean m8419m() {
        boolean z;
        synchronized (this.f5664a) {
            z = this.f5688y;
        }
        return z;
    }

    public long m8420n() {
        long j;
        synchronized (this.f5664a) {
            j = this.f5662C;
        }
        return j;
    }

    public int m8421o() {
        int i;
        synchronized (this.f5664a) {
            i = this.f5663D;
        }
        return i;
    }

    public boolean m8422p() {
        return this.f5689z;
    }

    public re m8423q() {
        re reVar;
        synchronized (this.f5664a) {
            reVar = new re(this.f5660A, this.f5661B);
        }
        return reVar;
    }

    public fb m8424r() {
        return this.f5667d;
    }

    public Resources m8425s() {
        if (this.f5676m.f6639e) {
            return this.f5675l.getResources();
        }
        try {
            DynamiteModule a = DynamiteModule.m5009a(this.f5675l, DynamiteModule.f3244a, ModuleDescriptor.MODULE_ID);
            return a != null ? a.m5019a().getResources() : null;
        } catch (Throwable e) {
            sg.m8447c("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public void m8426t() {
        om.m7923a(this.f5675l, this.f5676m);
    }

    public boolean m8427u() {
        boolean z;
        synchronized (this.f5664a) {
            z = this.f5686w;
        }
        return z;
    }

    void m8428v() {
        try {
            this.f5677n = zzv.zzcQ().m6723a(new ig(this.f5675l, this.f5676m.f6636b));
        } catch (Throwable e) {
            sg.m8447c("Cannot initialize CSI reporter.", e);
        }
    }
}
