package com.andi.alquran.p032j;

import android.content.SharedPreferences;
import android.support.v7.recyclerview.BuildConfig;
import android.util.SparseArray;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p028g.C0915a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: com.andi.alquran.j.i */
public class C0950i {
    private int f1901a;
    private int f1902b;
    private int f1903c;
    private int f1904d;
    private double f1905e;
    private double f1906f;
    private double f1907g;
    private double f1908h;
    private ArrayList<String> f1909i;
    private SparseArray<double[]> f1910j;
    private int[] f1911k;
    private ArrayList<C0915a> f1912l;
    private double f1913m;
    private double f1914n;
    private double f1915o;
    private double f1916p;
    private double f1917q;
    private double f1918r;
    private double f1919s;

    /* renamed from: com.andi.alquran.j.i.1 */
    class C09491 implements Comparator<C0915a> {
        final /* synthetic */ C0950i f1900a;

        C09491(C0950i c0950i) {
            this.f1900a = c0950i;
        }

        public int m3288a(C0915a c0915a, C0915a c0915a2) {
            return c0915a.m3195d() > c0915a2.m3195d() ? 1 : -1;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3288a((C0915a) obj, (C0915a) obj2);
        }
    }

    public C0950i() {
        this.f1911k = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.f1912l = new ArrayList();
        this.f1913m = -0.16666666666666666d;
        this.f1914n = 0.0d;
        this.f1915o = 0.0d;
        this.f1916p = 0.0d;
        this.f1917q = 0.0d;
        this.f1918r = 0.0d;
        this.f1919s = 0.0d;
        this.f1901a = 5;
        this.f1902b = 0;
        this.f1903c = 1;
        this.f1904d = 0;
        m3303g();
    }

    public C0950i(int i, int i2, int i3, int i4) {
        this.f1911k = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.f1912l = new ArrayList();
        this.f1913m = -0.16666666666666666d;
        this.f1914n = 0.0d;
        this.f1915o = 0.0d;
        this.f1916p = 0.0d;
        this.f1917q = 0.0d;
        this.f1918r = 0.0d;
        this.f1919s = 0.0d;
        this.f1901a = i;
        this.f1902b = i2;
        this.f1904d = i3;
        this.f1903c = i4;
        if (i == 0) {
            this.f1914n = 0.0d;
            this.f1915o = -0.05d;
            this.f1916p = 0.03333333333333333d;
            this.f1917q = 0.03333333333333333d;
            this.f1918r = 0.1d;
            this.f1919s = 0.025d;
        } else if (i == 4) {
            this.f1914n = -0.008333333333333333d;
            this.f1915o = -0.016666666666666666d;
            this.f1916p = 0.0d;
            this.f1917q = -0.008333333333333333d;
            this.f1918r = 0.06666666666666667d;
            this.f1919s = 0.06666666666666667d;
        } else if (i == 8) {
            this.f1914n = -0.16666666666666666d;
            this.f1915o = -0.05d;
            this.f1916p = 0.08333333333333333d;
            this.f1917q = 0.0d;
            this.f1918r = 0.15d;
            this.f1919s = 0.0d;
        } else if (i == 9) {
            this.f1914n = -0.08333333333333333d;
            this.f1916p = 0.08333333333333333d;
            this.f1918r = 0.15d;
            this.f1919s = 0.08333333333333333d;
        } else if (i == 10) {
            this.f1914n = 0.16666666666666666d;
            this.f1915o = -0.016666666666666666d;
            this.f1916p = 0.016666666666666666d;
            this.f1917q = 0.1d;
            this.f1918r = 0.13333333333333333d;
            this.f1919s = 0.08333333333333333d;
        }
        m3303g();
    }

    private double m3289a(double d, double d2) {
        double c = m3296c(m3310f() + d2);
        double d3 = m3299d(d2);
        c = C0951j.m3320i(((-C0951j.m3316e(d)) - (C0951j.m3316e(c) * C0951j.m3316e(m3307c()))) / (C0951j.m3317f(c) * C0951j.m3317f(m3307c()))) / 15.0d;
        if (d > 90.0d) {
            c = -c;
        }
        return c + d3;
    }

    private double m3290a(int i, int i2, int i3) {
        if (i2 <= 2) {
            i--;
            i2 += 12;
        }
        double floor = Math.floor(((double) i) / 100.0d);
        return ((Math.floor(floor / 4.0d) + (2.0d - floor)) + ((Math.floor(365.25d * ((double) (i + 4716))) + Math.floor(30.6001d * ((double) (i2 + 1)))) + ((double) i3))) - 1524.5d;
    }

    private double[] m3291a(double d) {
        double d2 = d - 2451545.0d;
        double a = C0951j.m3311a(357.529d + (0.98560028d * d2));
        double a2 = C0951j.m3311a(280.459d + (0.98564736d * d2));
        a = C0951j.m3311a((C0951j.m3316e(a * 2.0d) * 0.02d) + ((1.915d * C0951j.m3316e(a)) + a2));
        d2 = 23.439d - (d2 * 3.6E-7d);
        double h = C0951j.m3319h(C0951j.m3316e(d2) * C0951j.m3316e(a));
        d2 = (a2 / 15.0d) - C0951j.m3313b(C0951j.m3312a(C0951j.m3317f(d2) * C0951j.m3316e(a), C0951j.m3317f(a)) / 15.0d);
        double[] dArr = new double[3];
        dArr[1] = h;
        dArr[2] = d2;
        return dArr;
    }

    private double[] m3292a(double[] dArr) {
        double[] d = m3300d(dArr);
        double a = m3289a(180.0d - ((double[]) this.f1910j.get(this.f1901a))[0], d[0]);
        double a2 = m3289a(180.0d - ((double[]) this.f1910j.get(this.f1901a))[0], d[1]);
        double a3 = m3289a(179.167d, d[2]);
        double d2 = m3299d(d[3]);
        double b = m3294b((double) (this.f1902b + 1), d[4]);
        double a4 = m3289a(((double[]) this.f1910j.get(this.f1901a))[2], d[5]);
        double d3 = ((double[]) this.f1910j.get(this.f1901a))[4];
        double a5 = m3289a(r20, d[6]);
        return new double[]{a, a2, a3, d2, b, a4, a5};
    }

    private double m3293b(double d) {
        return m3291a(d)[2];
    }

    private double m3294b(double d, double d2) {
        return m3289a(-C0951j.m3321j(C0951j.m3318g(Math.abs(m3307c() - m3296c(m3310f() + d2))) + d), d2);
    }

    private double[] m3295b(double[] dArr) {
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = dArr[i] + (m3309e() - (m3308d() / 15.0d));
        }
        if (m3306b() != 0) {
            dArr = m3298c(dArr);
        }
        dArr[1] = dArr[1] + this.f1914n;
        dArr[0] = dArr[1] + this.f1913m;
        dArr[2] = dArr[2] + this.f1915o;
        dArr[3] = dArr[3] + this.f1916p;
        dArr[4] = dArr[4] + this.f1917q;
        dArr[5] = dArr[5] + this.f1918r;
        dArr[6] = dArr[6] + this.f1919s;
        if (((double[]) this.f1910j.get(m3304a()))[1] == 1.0d) {
            dArr[5] = dArr[5] + (((double[]) this.f1910j.get(m3304a()))[2] / 60.0d);
        }
        if (((double[]) this.f1910j.get(m3304a()))[3] == 1.0d) {
            dArr[6] = dArr[5] + (((double[]) this.f1910j.get(m3304a()))[4] / 60.0d);
        }
        return dArr;
    }

    private double m3296c(double d) {
        return m3291a(d)[1];
    }

    private double m3297c(double d, double d2) {
        return C0951j.m3313b(d2 - d);
    }

    private double[] m3298c(double[] dArr) {
        double c = m3297c(dArr[5], dArr[2]);
        double e = m3301e(((double[]) this.f1910j.get(m3304a()))[0]) * c;
        if (Double.isNaN(dArr[1]) || m3297c(dArr[1], dArr[2]) > e) {
            dArr[1] = dArr[2] - e;
        }
        e = m3301e(((double[]) this.f1910j.get(m3304a()))[3] == 0.0d ? ((double[]) this.f1910j.get(m3304a()))[4] : 18.0d) * c;
        if (Double.isNaN(dArr[6]) || m3297c(dArr[5], dArr[6]) > e) {
            dArr[6] = e + dArr[5];
        }
        e = m3301e(((double[]) this.f1910j.get(m3304a()))[1] == 0.0d ? ((double[]) this.f1910j.get(m3304a()))[2] : 4.0d) * c;
        if (Double.isNaN(dArr[5]) || m3297c(dArr[5], dArr[5]) > e) {
            dArr[5] = e + dArr[5];
        }
        return dArr;
    }

    private double m3299d(double d) {
        return C0951j.m3313b(12.0d - m3293b(m3310f() + d));
    }

    private double[] m3300d(double[] dArr) {
        for (int i = 0; i < 7; i++) {
            dArr[i] = dArr[i] / 24.0d;
        }
        return dArr;
    }

    private double m3301e(double d) {
        return this.f1903c == 3 ? d / 60.0d : this.f1903c == 1 ? 0.5d : this.f1903c == 2 ? 0.14286d : 0.0d;
    }

    private double[] m3302e(double[] dArr) {
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = dArr[i] + (((double) this.f1911k[i]) / 60.0d);
        }
        return dArr;
    }

    private void m3303g() {
        this.f1909i = new ArrayList();
        this.f1909i.add("Imsak");
        this.f1909i.add("Subuh");
        this.f1909i.add("Terbit");
        this.f1909i.add("Dzuhur");
        this.f1909i.add("Ashar");
        this.f1909i.add("Maghrib");
        this.f1909i.add("Isya");
        this.f1911k = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.f1910j = new SparseArray();
        this.f1910j.put(0, new double[]{19.5d, 1.0d, 0.0d, 0.0d, 18.0d});
        this.f1910j.put(1, new double[]{18.0d, 1.0d, 0.0d, 0.0d, 18.0d});
        this.f1910j.put(2, new double[]{15.0d, 1.0d, 0.0d, 0.0d, 15.0d});
        this.f1910j.put(3, new double[]{18.0d, 1.0d, 0.0d, 0.0d, 17.0d});
        this.f1910j.put(4, new double[]{18.5d, 1.0d, 0.0d, 1.0d, 90.0d});
        this.f1910j.put(5, new double[]{19.5d, 1.0d, 0.0d, 0.0d, 17.5d});
        this.f1910j.put(6, new double[]{17.7d, 0.0d, 4.5d, 0.0d, 14.0d});
        this.f1910j.put(7, new double[]{16.0d, 0.0d, 4.0d, 0.0d, 14.0d});
        this.f1910j.put(8, new double[]{12.0d, 0.0d, 0.0d, 0.0d, 9.5d});
        this.f1910j.put(9, new double[]{12.0d, 0.0d, 0.0d, 0.0d, 12.0d});
        this.f1910j.put(10, new double[]{19.5d, 0.0d, 0.0d, 1.0d, 90.0d});
    }

    public int m3304a() {
        return this.f1901a;
    }

    public ArrayList<C0915a> m3305a(SharedPreferences sharedPreferences, Calendar calendar, double d, double d2, double d3) {
        int i = sharedPreferences.getInt("adjustManualImsak", 0);
        int i2 = sharedPreferences.getInt("adjustManualSubuh", 0);
        int i3 = sharedPreferences.getInt("adjustManualTerbit", 0);
        int i4 = sharedPreferences.getInt("adjustManualDzuhur", 0);
        int i5 = sharedPreferences.getInt("adjustManualAshar", 0);
        int i6 = sharedPreferences.getInt("adjustManualMaghrib", 0);
        int i7 = sharedPreferences.getInt("adjustManualIsya", 0);
        int i8 = calendar.get(1);
        int i9 = calendar.get(2) + 1;
        int i10 = calendar.get(5);
        this.f1905e = d;
        this.f1906f = d2;
        this.f1907g = d3;
        this.f1908h = m3290a(i8, i9, i10);
        this.f1908h -= d2 / 360.0d;
        double[] dArr = new double[]{5.0d, 5.0d, 6.0d, 12.0d, 13.0d, 18.0d, 18.0d};
        for (i8 = 1; i8 <= dArr.length; i8++) {
            dArr = m3292a(dArr);
        }
        double[] e = m3302e(m3295b(dArr));
        this.f1912l = new ArrayList();
        String str = BuildConfig.VERSION_NAME;
        for (int i11 = 0; i11 < e.length; i11++) {
            i10 = 1;
            double d4 = e[i11];
            if (i11 == 0) {
                i10 = 1;
                d4 += ((double) i) / 60.0d;
                str = App.m2860a().getString(C0861R.string.imsak);
            } else if (i11 == 1) {
                i10 = 2;
                d4 += ((double) i2) / 60.0d;
                str = App.m2860a().getString(C0861R.string.subuh);
            } else if (i11 == 2) {
                i10 = 3;
                d4 += ((double) i3) / 60.0d;
                str = App.m2860a().getString(C0861R.string.sunrise);
            } else if (i11 == 3) {
                i10 = 4;
                d4 += ((double) i4) / 60.0d;
                str = App.m2860a().getString(C0861R.string.dzuhur);
            } else if (i11 == 4) {
                i10 = 5;
                d4 += ((double) i5) / 60.0d;
                str = App.m2860a().getString(C0861R.string.ashar);
            } else if (i11 == 5) {
                i10 = 6;
                d4 += ((double) i6) / 60.0d;
                str = App.m2860a().getString(C0861R.string.maghrib);
            } else if (i11 == 6) {
                i10 = 7;
                d4 += ((double) i7) / 60.0d;
                str = App.m2860a().getString(C0861R.string.isya);
            }
            this.f1912l.add(new C0915a(i10, str, d4));
        }
        if (this.f1912l.size() > 0) {
            Collections.sort(this.f1912l, new C09491(this));
        }
        return this.f1912l;
    }

    public int m3306b() {
        return this.f1903c;
    }

    public double m3307c() {
        return this.f1905e;
    }

    public double m3308d() {
        return this.f1906f;
    }

    public double m3309e() {
        return this.f1907g;
    }

    public double m3310f() {
        return this.f1908h;
    }
}
