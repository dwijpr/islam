package com.google.android.gms.internal;

public enum up {
    NONE,
    GZIP;

    public static up m9320a(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
