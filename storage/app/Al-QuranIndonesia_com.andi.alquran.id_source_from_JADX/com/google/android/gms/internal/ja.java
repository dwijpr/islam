package com.google.android.gms.internal;

import android.support.v4.p014g.C0297j;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.jq.C1673a;
import java.util.Arrays;
import java.util.List;

@op
public class ja extends C1673a implements C1660a {
    private final iv f4513a;
    private final String f4514b;
    private final C0297j<String, ix> f4515c;
    private final C0297j<String, String> f4516d;
    private final Object f4517e;
    private jd f4518f;

    public ja(String str, C0297j<String, ix> c0297j, C0297j<String, String> c0297j2, iv ivVar) {
        this.f4517e = new Object();
        this.f4514b = str;
        this.f4515c = c0297j;
        this.f4516d = c0297j2;
        this.f4513a = ivVar;
    }

    public String m6906a(String str) {
        return (String) this.f4516d.get(str);
    }

    public List<String> m6907a() {
        int i = 0;
        String[] strArr = new String[(this.f4515c.size() + this.f4516d.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f4515c.size(); i3++) {
            strArr[i2] = (String) this.f4515c.m1002b(i3);
            i2++;
        }
        while (i < this.f4516d.size()) {
            strArr[i2] = (String) this.f4516d.m1002b(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public void m6908a(jd jdVar) {
        synchronized (this.f4517e) {
            this.f4518f = jdVar;
        }
    }

    public jh m6909b(String str) {
        return (jh) this.f4515c.get(str);
    }

    public void m6910b() {
        synchronized (this.f4517e) {
            if (this.f4518f == null) {
                sg.m8446c("Attempt to perform recordImpression before ad initialized.");
                return;
            }
            this.f4518f.m6920a(null, null);
        }
    }

    public void m6911c(String str) {
        synchronized (this.f4517e) {
            if (this.f4518f == null) {
                sg.m8446c("Attempt to call performClick before ad initialized.");
                return;
            }
            this.f4518f.m6919a(null, str, null, null, null);
        }
    }

    public String m6912k() {
        return "3";
    }

    public String m6913l() {
        return this.f4514b;
    }

    public iv m6914m() {
        return this.f4513a;
    }
}
