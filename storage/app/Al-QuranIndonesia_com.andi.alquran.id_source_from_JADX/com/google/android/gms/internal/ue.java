package com.google.android.gms.internal;

import com.google.android.gms.common.C1261h;

public class ue {
    public static final String f6042a;
    public static final String f6043b;

    static {
        f6042a = String.valueOf(C1261h.f2969b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        String str = "ma";
        String valueOf = String.valueOf(f6042a);
        f6043b = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
