package com.google.android.gms.internal;

public final class ej {
    public static final int[] f3860a;
    public static final long[] f3861b;
    public static final float[] f3862c;
    public static final double[] f3863d;
    public static final boolean[] f3864e;
    public static final String[] f3865f;
    public static final byte[][] f3866g;
    public static final byte[] f3867h;

    static {
        f3860a = new int[0];
        f3861b = new long[0];
        f3862c = new float[0];
        f3863d = new double[0];
        f3864e = new boolean[0];
        f3865f = new String[0];
        f3866g = new byte[0][];
        f3867h = new byte[0];
    }

    static int m5921a(int i) {
        return i & 7;
    }

    public static int m5922a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean m5923a(dy dyVar, int i) {
        return dyVar.m5780b(i);
    }

    public static int m5924b(int i) {
        return i >>> 3;
    }

    public static final int m5925b(dy dyVar, int i) {
        int i2 = 1;
        int p = dyVar.m5798p();
        dyVar.m5780b(i);
        while (dyVar.m5775a() == i) {
            dyVar.m5780b(i);
            i2++;
        }
        dyVar.m5786e(p);
        return i2;
    }
}
