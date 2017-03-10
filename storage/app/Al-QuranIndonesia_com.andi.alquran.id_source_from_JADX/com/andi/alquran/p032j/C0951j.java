package com.andi.alquran.p032j;

/* renamed from: com.andi.alquran.j.j */
public class C0951j {
    public static double m3311a(double d) {
        double floor = d - (Math.floor(d / 360.0d) * 360.0d);
        return floor < 0.0d ? floor + 360.0d : floor;
    }

    public static double m3312a(double d, double d2) {
        return C0951j.m3314c(Math.atan2(d, d2));
    }

    public static double m3313b(double d) {
        double floor = d - (Math.floor(d / 24.0d) * 24.0d);
        return floor < 0.0d ? floor + 24.0d : floor;
    }

    public static double m3314c(double d) {
        return (180.0d * d) / 3.141592653589793d;
    }

    public static double m3315d(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    public static double m3316e(double d) {
        return Math.sin(C0951j.m3315d(d));
    }

    public static double m3317f(double d) {
        return Math.cos(C0951j.m3315d(d));
    }

    public static double m3318g(double d) {
        return Math.tan(C0951j.m3315d(d));
    }

    public static double m3319h(double d) {
        return C0951j.m3314c(Math.asin(d));
    }

    public static double m3320i(double d) {
        return C0951j.m3314c(Math.acos(d));
    }

    public static double m3321j(double d) {
        return C0951j.m3314c(Math.atan2(1.0d, d));
    }
}
