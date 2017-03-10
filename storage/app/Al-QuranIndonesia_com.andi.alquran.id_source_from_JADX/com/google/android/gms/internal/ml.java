package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.cz.C1516a;
import com.google.android.gms.internal.on.C1875a;
import com.google.android.gms.internal.uj.C2027a;
import java.util.Collections;
import java.util.Map;

public abstract class ml<T> implements Comparable<ml<T>> {
    private final C2027a f4954a;
    private final int f4955b;
    private final String f4956c;
    private final int f4957d;
    private final C1875a f4958e;
    private Integer f4959f;
    private nm f4960g;
    private boolean f4961h;
    private boolean f4962i;
    private boolean f4963j;
    private long f4964k;
    private qi f4965l;
    private C1516a f4966m;

    /* renamed from: com.google.android.gms.internal.ml.1 */
    class C18061 implements Runnable {
        final /* synthetic */ String f4946a;
        final /* synthetic */ long f4947b;
        final /* synthetic */ ml f4948c;

        C18061(ml mlVar, String str, long j) {
            this.f4948c = mlVar;
            this.f4946a = str;
            this.f4947b = j;
        }

        public void run() {
            this.f4948c.f4954a.m9226a(this.f4946a, this.f4947b);
            this.f4948c.f4954a.m9225a(toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.ml.a */
    public enum C1807a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public ml(int i, String str, C1875a c1875a) {
        this.f4954a = C2027a.f6088a ? new C2027a() : null;
        this.f4961h = true;
        this.f4962i = false;
        this.f4963j = false;
        this.f4964k = 0;
        this.f4966m = null;
        this.f4955b = i;
        this.f4956c = str;
        this.f4958e = c1875a;
        m7603a(new fm());
        this.f4957d = m7596a(str);
    }

    private static int m7596a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    public int m7598a() {
        return this.f4955b;
    }

    public int m7599a(ml<T> mlVar) {
        C1807a m = m7621m();
        C1807a m2 = mlVar.m7621m();
        return m == m2 ? this.f4959f.intValue() - mlVar.f4959f.intValue() : m2.ordinal() - m.ordinal();
    }

    public final ml<?> m7600a(int i) {
        this.f4959f = Integer.valueOf(i);
        return this;
    }

    public ml<?> m7601a(C1516a c1516a) {
        this.f4966m = c1516a;
        return this;
    }

    public ml<?> m7602a(nm nmVar) {
        this.f4960g = nmVar;
        return this;
    }

    public ml<?> m7603a(qi qiVar) {
        this.f4965l = qiVar;
        return this;
    }

    protected abstract on<T> m7604a(kj kjVar);

    protected ti m7605a(ti tiVar) {
        return tiVar;
    }

    protected abstract void m7606a(T t);

    public int m7607b() {
        return this.f4957d;
    }

    public void m7608b(ti tiVar) {
        if (this.f4958e != null) {
            this.f4958e.m7935a(tiVar);
        }
    }

    public void m7609b(String str) {
        if (C2027a.f6088a) {
            this.f4954a.m9226a(str, Thread.currentThread().getId());
        } else if (this.f4964k == 0) {
            this.f4964k = SystemClock.elapsedRealtime();
        }
    }

    public String m7610c() {
        return this.f4956c;
    }

    void m7611c(String str) {
        if (this.f4960g != null) {
            this.f4960g.m7772b(this);
        }
        if (C2027a.f6088a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C18061(this, str, id));
                return;
            }
            this.f4954a.m9226a(str, id);
            this.f4954a.m9225a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f4964k >= 3000) {
            uj.m9229b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f4964k), toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m7599a((ml) obj);
    }

    public String m7612d() {
        return m7610c();
    }

    public C1516a m7613e() {
        return this.f4966m;
    }

    public Map<String, String> m7614f() {
        return Collections.emptyMap();
    }

    @Deprecated
    public String m7615g() {
        return m7618j();
    }

    @Deprecated
    public byte[] m7616h() {
        return null;
    }

    protected String m7617i() {
        return "UTF-8";
    }

    public String m7618j() {
        String str = "application/x-www-form-urlencoded; charset=";
        String valueOf = String.valueOf(m7617i());
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public byte[] m7619k() {
        return null;
    }

    public final boolean m7620l() {
        return this.f4961h;
    }

    public C1807a m7621m() {
        return C1807a.NORMAL;
    }

    public final int m7622n() {
        return this.f4965l.m6181a();
    }

    public qi m7623o() {
        return this.f4965l;
    }

    public void m7624p() {
        this.f4963j = true;
    }

    public boolean m7625q() {
        return this.f4963j;
    }

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(m7607b()));
        valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        str = "[ ] ";
        String valueOf2 = String.valueOf(m7610c());
        String valueOf3 = String.valueOf(m7621m());
        String valueOf4 = String.valueOf(this.f4959f);
        return new StringBuilder(((((String.valueOf(str).length() + 3) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append(str).append(valueOf2).append(" ").append(valueOf).append(" ").append(valueOf3).append(" ").append(valueOf4).toString();
    }
}
