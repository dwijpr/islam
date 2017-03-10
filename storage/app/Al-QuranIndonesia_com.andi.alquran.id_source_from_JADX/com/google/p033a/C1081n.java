package com.google.p033a;

import com.google.p033a.p035b.C1015a;
import com.google.p033a.p035b.C1034f;
import java.math.BigInteger;

/* renamed from: com.google.a.n */
public final class C1081n extends C1075i {
    private static final Class<?>[] f2232a;
    private Object f2233b;

    static {
        f2232a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    }

    public C1081n(Boolean bool) {
        m3834a((Object) bool);
    }

    public C1081n(Number number) {
        m3834a((Object) number);
    }

    public C1081n(String str) {
        m3834a((Object) str);
    }

    private static boolean m3831a(C1081n c1081n) {
        if (!(c1081n.f2233b instanceof Number)) {
            return false;
        }
        Number number = (Number) c1081n.f2233b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean m3832b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : f2232a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public Number m3833a() {
        return this.f2233b instanceof String ? new C1034f((String) this.f2233b) : (Number) this.f2233b;
    }

    void m3834a(Object obj) {
        if (obj instanceof Character) {
            this.f2233b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || C1081n.m3832b(obj);
        C1015a.m3678a(z);
        this.f2233b = obj;
    }

    public String m3835b() {
        return m3842p() ? m3833a().toString() : m3841o() ? m3840n().toString() : (String) this.f2233b;
    }

    public double m3836c() {
        return m3842p() ? m3833a().doubleValue() : Double.parseDouble(m3835b());
    }

    public long m3837d() {
        return m3842p() ? m3833a().longValue() : Long.parseLong(m3835b());
    }

    public int m3838e() {
        return m3842p() ? m3833a().intValue() : Integer.parseInt(m3835b());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1081n c1081n = (C1081n) obj;
        if (this.f2233b == null) {
            return c1081n.f2233b == null;
        } else {
            if (C1081n.m3831a(this) && C1081n.m3831a(c1081n)) {
                return m3833a().longValue() == c1081n.m3833a().longValue();
            } else {
                if (!(this.f2233b instanceof Number) || !(c1081n.f2233b instanceof Number)) {
                    return this.f2233b.equals(c1081n.f2233b);
                }
                double doubleValue = m3833a().doubleValue();
                double doubleValue2 = c1081n.m3833a().doubleValue();
                if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                    z = true;
                }
                return z;
            }
        }
    }

    public boolean m3839f() {
        return m3841o() ? m3840n().booleanValue() : Boolean.parseBoolean(m3835b());
    }

    public int hashCode() {
        if (this.f2233b == null) {
            return 31;
        }
        long longValue;
        if (C1081n.m3831a(this)) {
            longValue = m3833a().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f2233b instanceof Number)) {
            return this.f2233b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(m3833a().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    Boolean m3840n() {
        return (Boolean) this.f2233b;
    }

    public boolean m3841o() {
        return this.f2233b instanceof Boolean;
    }

    public boolean m3842p() {
        return this.f2233b instanceof Number;
    }

    public boolean m3843q() {
        return this.f2233b instanceof String;
    }
}
