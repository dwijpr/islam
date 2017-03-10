package com.andi.alquran.p027d;

/* renamed from: com.andi.alquran.d.a */
public class C0894a {
    public static String m3108a(int i, int i2) {
        String str = i >= 12 ? "pm" : "am";
        int i3 = (((i + 12) - 1) % 12) + 1;
        return (i3 < 0 || i3 > 9 || i2 < 0 || i2 > 9) ? (i3 < 0 || i3 > 9) ? (i2 < 0 || i2 > 9) ? i3 + ":" + Math.round((float) i2) + " " + str : i3 + ":0" + Math.round((float) i2) + " " + str : "0" + i3 + ":" + Math.round((float) i2) + " " + str : "0" + i3 + ":0" + Math.round((float) i2) + " " + str;
    }

    public static String m3109b(int i, int i2) {
        String str = i >= 12 ? "pm" : "am";
        int i3 = (((i + 12) - 1) % 12) + 1;
        return (i3 < 0 || i3 > 9 || i2 < 0 || i2 > 9) ? (i3 < 0 || i3 > 9) ? (i2 < 0 || i2 > 9) ? i3 + ":" + Math.round((float) i2) + str : i3 + ":0" + Math.round((float) i2) + str : "0" + i3 + ":" + Math.round((float) i2) + str : "0" + i3 + ":0" + Math.round((float) i2) + str;
    }
}
