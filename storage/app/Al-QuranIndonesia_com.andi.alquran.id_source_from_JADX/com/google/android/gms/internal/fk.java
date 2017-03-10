package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Iterator;

@op
public class fk {
    private final int f4036a;
    private final int f4037b;
    private final int f4038c;
    private final fr f4039d;
    private final fw f4040e;
    private final Object f4041f;
    private ArrayList<String> f4042g;
    private ArrayList<String> f4043h;
    private ArrayList<fp> f4044i;
    private int f4045j;
    private int f4046k;
    private int f4047l;
    private int f4048m;
    private String f4049n;
    private String f4050o;
    private String f4051p;

    public fk(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f4041f = new Object();
        this.f4042g = new ArrayList();
        this.f4043h = new ArrayList();
        this.f4044i = new ArrayList();
        this.f4045j = 0;
        this.f4046k = 0;
        this.f4047l = 0;
        this.f4049n = BuildConfig.VERSION_NAME;
        this.f4050o = BuildConfig.VERSION_NAME;
        this.f4051p = BuildConfig.VERSION_NAME;
        this.f4036a = i;
        this.f4037b = i2;
        this.f4038c = i3;
        this.f4039d = new fr(i4);
        this.f4040e = new fw(i5, i6, i7);
    }

    private String m6161a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return BuildConfig.VERSION_NAME;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void m6162c(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.f4038c) {
            synchronized (this.f4041f) {
                this.f4042g.add(str);
                this.f4045j += str.length();
                if (z) {
                    this.f4043h.add(str);
                    this.f4044i.add(new fp(f, f2, f3, f4, this.f4043h.size() - 1));
                }
            }
        }
    }

    int m6163a(int i, int i2) {
        return (this.f4036a * i) + (this.f4037b * i2);
    }

    public void m6164a(int i) {
        this.f4046k = i;
    }

    public void m6165a(String str, boolean z, float f, float f2, float f3, float f4) {
        m6162c(str, z, f, f2, f3, f4);
        synchronized (this.f4041f) {
            if (this.f4047l < 0) {
                sg.m8444b("ActivityContent: negative number of WebViews.");
            }
            m6174h();
        }
    }

    public boolean m6166a() {
        boolean z;
        synchronized (this.f4041f) {
            z = this.f4047l == 0;
        }
        return z;
    }

    public String m6167b() {
        return this.f4049n;
    }

    public void m6168b(String str, boolean z, float f, float f2, float f3, float f4) {
        m6162c(str, z, f, f2, f3, f4);
    }

    public String m6169c() {
        return this.f4050o;
    }

    public String m6170d() {
        return this.f4051p;
    }

    public void m6171e() {
        synchronized (this.f4041f) {
            this.f4048m -= 100;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof fk)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        fk fkVar = (fk) obj;
        return fkVar.m6167b() != null && fkVar.m6167b().equals(m6167b());
    }

    public void m6172f() {
        synchronized (this.f4041f) {
            this.f4047l--;
        }
    }

    public void m6173g() {
        synchronized (this.f4041f) {
            this.f4047l++;
        }
    }

    public void m6174h() {
        synchronized (this.f4041f) {
            int a = m6163a(this.f4045j, this.f4046k);
            if (a > this.f4048m) {
                this.f4048m = a;
                if (((Boolean) C1648if.ae.m6682c()).booleanValue() && !zzv.zzcN().m8405b()) {
                    this.f4049n = this.f4039d.m6229a(this.f4042g);
                    this.f4050o = this.f4039d.m6229a(this.f4043h);
                }
                if (((Boolean) C1648if.ag.m6682c()).booleanValue() && !zzv.zzcN().m8407c()) {
                    this.f4051p = this.f4040e.m6250a(this.f4043h, this.f4044i);
                }
            }
        }
    }

    public int hashCode() {
        return m6167b().hashCode();
    }

    public int m6175i() {
        return this.f4048m;
    }

    int m6176j() {
        return this.f4045j;
    }

    public String toString() {
        int i = this.f4046k;
        int i2 = this.f4048m;
        int i3 = this.f4045j;
        String valueOf = String.valueOf(m6161a(this.f4042g, 100));
        String valueOf2 = String.valueOf(m6161a(this.f4043h, 100));
        String str = this.f4049n;
        String str2 = this.f4050o;
        String str3 = this.f4051p;
        return new StringBuilder(((((String.valueOf(valueOf).length() + 165) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(valueOf).append("\n viewableText").append(valueOf2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).append("\n viewableSignatureForVertical: ").append(str3).toString();
    }
}
