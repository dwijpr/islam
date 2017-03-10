package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;

public final class dy {
    private final byte[] f3819a;
    private int f3820b;
    private int f3821c;
    private int f3822d;
    private int f3823e;
    private int f3824f;
    private int f3825g;
    private int f3826h;
    private int f3827i;
    private int f3828j;

    private dy(byte[] bArr, int i, int i2) {
        this.f3825g = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f3827i = 64;
        this.f3828j = 67108864;
        this.f3819a = bArr;
        this.f3820b = i;
        this.f3821c = i + i2;
        this.f3823e = i;
    }

    public static long m5772a(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static dy m5773a(byte[] bArr, int i, int i2) {
        return new dy(bArr, i, i2);
    }

    private void m5774r() {
        this.f3821c += this.f3822d;
        int i = this.f3821c;
        if (i > this.f3825g) {
            this.f3822d = i - this.f3825g;
            this.f3821c -= this.f3822d;
            return;
        }
        this.f3822d = 0;
    }

    public int m5775a() {
        if (m5797o()) {
            this.f3824f = 0;
            return 0;
        }
        this.f3824f = m5792j();
        if (this.f3824f != 0) {
            return this.f3824f;
        }
        throw ef.m5909d();
    }

    public void m5776a(int i) {
        if (this.f3824f != i) {
            throw ef.m5910e();
        }
    }

    public void m5777a(eg egVar) {
        int j = m5792j();
        if (this.f3826h >= this.f3827i) {
            throw ef.m5912g();
        }
        j = m5781c(j);
        this.f3826h++;
        egVar.m5152b(this);
        m5776a(0);
        this.f3826h--;
        m5784d(j);
    }

    public byte[] m5778a(int i, int i2) {
        if (i2 == 0) {
            return ej.f3867h;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f3819a, this.f3820b + i, obj, 0, i2);
        return obj;
    }

    public void m5779b() {
        int a;
        do {
            a = m5775a();
            if (a == 0) {
                return;
            }
        } while (m5780b(a));
    }

    public boolean m5780b(int i) {
        switch (ej.m5921a(i)) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                m5785e();
                return true;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                m5795m();
                return true;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                m5787f(m5792j());
                return true;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                m5779b();
                m5776a(ej.m5922a(ej.m5924b(i), 4));
                return true;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return false;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                m5794l();
                return true;
            default:
                throw ef.m5911f();
        }
    }

    public int m5781c(int i) {
        if (i < 0) {
            throw ef.m5907b();
        }
        int i2 = this.f3823e + i;
        int i3 = this.f3825g;
        if (i2 > i3) {
            throw ef.m5906a();
        }
        this.f3825g = i2;
        m5774r();
        return i3;
    }

    public long m5782c() {
        return m5793k();
    }

    public long m5783d() {
        return m5793k();
    }

    public void m5784d(int i) {
        this.f3825g = i;
        m5774r();
    }

    public int m5785e() {
        return m5792j();
    }

    public void m5786e(int i) {
        if (i > this.f3823e - this.f3820b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f3823e - this.f3820b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f3823e = this.f3820b + i;
        }
    }

    public void m5787f(int i) {
        if (i < 0) {
            throw ef.m5907b();
        } else if (this.f3823e + i > this.f3825g) {
            m5787f(this.f3825g - this.f3823e);
            throw ef.m5906a();
        } else if (i <= this.f3821c - this.f3823e) {
            this.f3823e += i;
        } else {
            throw ef.m5906a();
        }
    }

    public boolean m5788f() {
        return m5792j() != 0;
    }

    public String m5789g() {
        int j = m5792j();
        if (j < 0) {
            throw ef.m5907b();
        } else if (j > this.f3821c - this.f3823e) {
            throw ef.m5906a();
        } else {
            String str = new String(this.f3819a, this.f3823e, j, ee.f3855a);
            this.f3823e = j + this.f3823e;
            return str;
        }
    }

    public byte[] m5790h() {
        int j = m5792j();
        if (j < 0) {
            throw ef.m5907b();
        } else if (j == 0) {
            return ej.f3867h;
        } else {
            if (j > this.f3821c - this.f3823e) {
                throw ef.m5906a();
            }
            Object obj = new byte[j];
            System.arraycopy(this.f3819a, this.f3823e, obj, 0, j);
            this.f3823e = j + this.f3823e;
            return obj;
        }
    }

    public long m5791i() {
        return m5772a(m5793k());
    }

    public int m5792j() {
        byte q = m5799q();
        if (q >= null) {
            return q;
        }
        int i = q & 127;
        byte q2 = m5799q();
        if (q2 >= null) {
            return i | (q2 << 7);
        }
        i |= (q2 & 127) << 7;
        q2 = m5799q();
        if (q2 >= null) {
            return i | (q2 << 14);
        }
        i |= (q2 & 127) << 14;
        q2 = m5799q();
        if (q2 >= null) {
            return i | (q2 << 21);
        }
        i |= (q2 & 127) << 21;
        q2 = m5799q();
        i |= q2 << 28;
        if (q2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m5799q() >= null) {
                return i;
            }
        }
        throw ef.m5908c();
    }

    public long m5793k() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte q = m5799q();
            j |= ((long) (q & 127)) << i;
            if ((q & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                return j;
            }
        }
        throw ef.m5908c();
    }

    public int m5794l() {
        return (((m5799q() & 255) | ((m5799q() & 255) << 8)) | ((m5799q() & 255) << 16)) | ((m5799q() & 255) << 24);
    }

    public long m5795m() {
        byte q = m5799q();
        byte q2 = m5799q();
        return ((((((((((long) q2) & 255) << 8) | (((long) q) & 255)) | ((((long) m5799q()) & 255) << 16)) | ((((long) m5799q()) & 255) << 24)) | ((((long) m5799q()) & 255) << 32)) | ((((long) m5799q()) & 255) << 40)) | ((((long) m5799q()) & 255) << 48)) | ((((long) m5799q()) & 255) << 56);
    }

    public int m5796n() {
        if (this.f3825g == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.f3825g - this.f3823e;
    }

    public boolean m5797o() {
        return this.f3823e == this.f3821c;
    }

    public int m5798p() {
        return this.f3823e - this.f3820b;
    }

    public byte m5799q() {
        if (this.f3823e == this.f3821c) {
            throw ef.m5906a();
        }
        byte[] bArr = this.f3819a;
        int i = this.f3823e;
        this.f3823e = i + 1;
        return bArr[i];
    }
}
