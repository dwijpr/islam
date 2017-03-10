package com.andi.alquran.p032j;

import com.andi.alquran.BuildConfig;
import java.util.Calendar;

/* renamed from: com.andi.alquran.j.c */
public class C0941c {
    static double m3276a(double d, double d2) {
        return ((d % d2) + d2) % d2;
    }

    public static String m3277a(Calendar calendar, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) || BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu")) {
            strArr = new String[]{"Muharram", "Safar", "Rabiul Awal", "Rabiul Akhir", "Jumadil Awal", "Jumadil Akhir", "Rajab", "Syaban", "Ramadhan", "Syawal", "DzulKaidah", "DzulHijjah"};
            strArr2 = new String[]{"Muharram", "Safar", "Rab Awal", "Rab Akhir", "Jum Awal", "Jum Akhir", "Rajab", "Syaban", "Ramadhan", "Syawal", "DzulKaidah", "DzulHijjah"};
        } else {
            strArr = new String[]{"Mu\u1e25arram", "Safar", "Rabi al-Awwal", "Rabi al-Thani", "Jumada al-Awwal", "Jumada al-Thani", "Rajab", "Sha'ban", "Ramadan", "Shawwal", "Dhul-Qa'dah", "Dhul-Hijjah"};
            strArr2 = new String[]{"Mu\u1e25arram", "Safar", "Rabi al-Awwal", "Rabi al-Thani", "Jum al-Awwal", "Jum al-Thani", "Rajab", "Sha'ban", "Ramadan", "Shawwal", "DhulQa'dah", "DhulHijjah"};
        }
        double d = (double) calendar.get(5);
        double d2 = (double) calendar.get(1);
        double d3 = ((double) calendar.get(2)) + 1.0d;
        if (d3 < 3.0d) {
            d2 -= 1.0d;
            d3 += 12.0d;
        }
        double floor = Math.floor(d2 / 100.0d);
        floor = Math.floor(floor / 4.0d) + (2.0d - floor);
        if (d2 < 1583.0d) {
            floor = 0.0d;
        }
        if (d2 == 1582.0d) {
            if (d3 > 10.0d) {
                floor = -10.0d;
            }
            if (d3 == 10.0d) {
                floor = 0.0d;
                if (d > 4.0d) {
                    floor = -10.0d;
                }
            }
        }
        floor = (((Math.floor((d2 + 4716.0d) * 365.25d) + Math.floor((d3 + 1.0d) * 30.6001d)) + d) + floor) - 1524.0d;
        d2 = 0.0d;
        if (floor > 2299160.0d) {
            d2 = Math.floor((floor - 1867216.25d) / 36524.25d);
            d2 = (1.0d + d2) - Math.floor(d2 / 4.0d);
        }
        d3 = 1524.0d + (d2 + floor);
        d2 = Math.floor((d3 - 122.1d) / 365.25d);
        d = Math.floor(365.25d * d2);
        double floor2 = Math.floor((d3 - d) / 30.6001d);
        d = (d3 - d) - Math.floor(30.6001d * floor2);
        d3 = floor2 - 1.0d;
        if (floor2 > 13.0d) {
            d2 += 1.0d;
            d3 = floor2 - 13.0d;
        }
        floor2 = d2 - 4716.0d;
        double a = 1.0d + C0941c.m3276a(1.0d + floor, 7.0d);
        double d4 = floor - 1948084.0d;
        double floor3 = Math.floor(d4 / 10631.0d);
        d4 -= 10631.0d * floor3;
        double floor4 = Math.floor((d4 - 0.1335d) / 354.3666666666667d);
        floor3 = (floor3 * 30.0d) + floor4;
        d4 -= Math.floor((354.3666666666667d * floor4) + 0.1335d);
        d2 = Math.floor((28.5001d + d4) / 29.5d);
        if (d2 == 13.0d) {
            d2 = 12.0d;
        }
        d4 -= Math.floor((29.5001d * d2) - 29.0d);
        double[] dArr = new double[]{d, d3 - 1.0d, floor2, floor - 1.0d, a - 1.0d, d4, d2 - 1.0d, floor3};
        return z ? ((int) dArr[5]) + " " + strArr2[(int) dArr[6]] + " " + ((int) dArr[7]) + "H" : ((int) dArr[5]) + " " + strArr[(int) dArr[6]] + " " + ((int) dArr[7]) + " H";
    }
}
