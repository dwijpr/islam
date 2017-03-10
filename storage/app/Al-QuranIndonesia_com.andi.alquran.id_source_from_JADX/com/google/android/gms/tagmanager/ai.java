package com.google.android.gms.tagmanager;

class ai extends Number implements Comparable<ai> {
    private double f7052a;
    private long f7053b;
    private boolean f7054c;

    private ai(long j) {
        this.f7053b = j;
        this.f7054c = true;
    }

    public static ai m10133a(long j) {
        return new ai(j);
    }

    public int m10134a(ai aiVar) {
        return (m10136b() && aiVar.m10136b()) ? new Long(this.f7053b).compareTo(Long.valueOf(aiVar.f7053b)) : Double.compare(doubleValue(), aiVar.doubleValue());
    }

    public boolean m10135a() {
        return !m10136b();
    }

    public boolean m10136b() {
        return this.f7054c;
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public long m10137c() {
        return m10136b() ? this.f7053b : (long) this.f7052a;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m10134a((ai) obj);
    }

    public int m10138d() {
        return (int) longValue();
    }

    public double doubleValue() {
        return m10136b() ? (double) this.f7053b : this.f7052a;
    }

    public short m10139e() {
        return (short) ((int) longValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof ai) && m10134a((ai) obj) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return m10138d();
    }

    public long longValue() {
        return m10137c();
    }

    public short shortValue() {
        return m10139e();
    }

    public String toString() {
        return m10136b() ? Long.toString(this.f7053b) : Double.toString(this.f7052a);
    }
}
