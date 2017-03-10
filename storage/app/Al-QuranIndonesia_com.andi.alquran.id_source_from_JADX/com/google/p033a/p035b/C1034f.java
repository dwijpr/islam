package com.google.p033a.p035b;

import java.math.BigDecimal;

/* renamed from: com.google.a.b.f */
public final class C1034f extends Number {
    private final String f2156a;

    public C1034f(String str) {
        this.f2156a = str;
    }

    private Object writeReplace() {
        return new BigDecimal(this.f2156a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f2156a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1034f)) {
            return false;
        }
        C1034f c1034f = (C1034f) obj;
        return this.f2156a == c1034f.f2156a || this.f2156a.equals(c1034f.f2156a);
    }

    public float floatValue() {
        return Float.parseFloat(this.f2156a);
    }

    public int hashCode() {
        return this.f2156a.hashCode();
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f2156a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f2156a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f2156a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f2156a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f2156a).longValue();
        }
    }

    public String toString() {
        return this.f2156a;
    }
}
