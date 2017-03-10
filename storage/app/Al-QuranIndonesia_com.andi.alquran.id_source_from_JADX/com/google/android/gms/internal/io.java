package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@op
public class io {
    boolean f4417a;
    private final List<im> f4418b;
    private final Map<String, String> f4419c;
    private final Object f4420d;
    private String f4421e;
    private im f4422f;
    private io f4423g;

    public io(boolean z, String str, String str2) {
        this.f4418b = new LinkedList();
        this.f4419c = new LinkedHashMap();
        this.f4420d = new Object();
        this.f4417a = z;
        this.f4419c.put("action", str);
        this.f4419c.put("ad_format", str2);
    }

    public im m6740a() {
        return m6741a(zzv.zzcP().m4927b());
    }

    public im m6741a(long j) {
        return !this.f4417a ? null : new im(j, null, null);
    }

    public void m6742a(io ioVar) {
        synchronized (this.f4420d) {
            this.f4423g = ioVar;
        }
    }

    public void m6743a(String str) {
        if (this.f4417a) {
            synchronized (this.f4420d) {
                this.f4421e = str;
            }
        }
    }

    public void m6744a(String str, String str2) {
        if (this.f4417a && !TextUtils.isEmpty(str2)) {
            ih f = zzv.zzcN().m8412f();
            if (f != null) {
                synchronized (this.f4420d) {
                    f.m6715a(str).m6729a(this.f4419c, str, str2);
                }
            }
        }
    }

    public boolean m6745a(im imVar, long j, String... strArr) {
        synchronized (this.f4420d) {
            for (String imVar2 : strArr) {
                this.f4418b.add(new im(j, imVar2, imVar));
            }
        }
        return true;
    }

    public boolean m6746a(im imVar, String... strArr) {
        return (!this.f4417a || imVar == null) ? false : m6745a(imVar, zzv.zzcP().m4927b(), strArr);
    }

    public void m6747b() {
        synchronized (this.f4420d) {
            this.f4422f = m6740a();
        }
    }

    public String m6748c() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.f4420d) {
            for (im imVar : this.f4418b) {
                long a = imVar.m6734a();
                String b = imVar.m6735b();
                im imVar2 = imVar2.m6736c();
                if (imVar2 != null && a > 0) {
                    stringBuilder2.append(b).append('.').append(a - imVar2.m6734a()).append(',');
                }
            }
            this.f4418b.clear();
            if (!TextUtils.isEmpty(this.f4421e)) {
                stringBuilder2.append(this.f4421e);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    Map<String, String> m6749d() {
        Map<String, String> map;
        synchronized (this.f4420d) {
            ih f = zzv.zzcN().m8412f();
            if (f == null || this.f4423g == null) {
                map = this.f4419c;
            } else {
                map = f.m6717a(this.f4419c, this.f4423g.m6749d());
            }
        }
        return map;
    }

    public im m6750e() {
        im imVar;
        synchronized (this.f4420d) {
            imVar = this.f4422f;
        }
        return imVar;
    }
}
