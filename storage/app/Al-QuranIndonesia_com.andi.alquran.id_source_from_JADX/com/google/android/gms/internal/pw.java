package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.internal.pz.C1920a;

@op
public class pw extends C1920a {
    private final String f5521a;
    private final int f5522b;

    public pw(String str, int i) {
        this.f5521a = str;
        this.f5522b = i;
    }

    public String m8207a() {
        return this.f5521a;
    }

    public int m8208b() {
        return this.f5522b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof pw)) {
            return false;
        }
        pw pwVar = (pw) obj;
        return C1313b.m4621a(m8207a(), pwVar.m8207a()) && C1313b.m4621a(Integer.valueOf(m8208b()), Integer.valueOf(pwVar.m8208b()));
    }
}
