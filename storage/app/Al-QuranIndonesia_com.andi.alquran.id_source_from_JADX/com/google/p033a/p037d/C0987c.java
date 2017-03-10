package com.google.p033a.p037d;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.google.a.d.c */
public class C0987c implements Closeable, Flushable {
    private static final String[] f2008a;
    private static final String[] f2009b;
    private final Writer f2010c;
    private int[] f2011d;
    private int f2012e;
    private String f2013f;
    private String f2014g;
    private boolean f2015h;
    private boolean f2016i;
    private String f2017j;
    private boolean f2018k;

    static {
        f2008a = new String[NotificationCompat.FLAG_HIGH_PRIORITY];
        for (int i = 0; i <= 31; i++) {
            f2008a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f2008a[34] = "\\\"";
        f2008a[92] = "\\\\";
        f2008a[9] = "\\t";
        f2008a[8] = "\\b";
        f2008a[10] = "\\n";
        f2008a[13] = "\\r";
        f2008a[12] = "\\f";
        f2009b = (String[]) f2008a.clone();
        f2009b[60] = "\\u003c";
        f2009b[62] = "\\u003e";
        f2009b[38] = "\\u0026";
        f2009b[61] = "\\u003d";
        f2009b[39] = "\\u0027";
    }

    public C0987c(Writer writer) {
        this.f2011d = new int[32];
        this.f2012e = 0;
        m3485a(6);
        this.f2014g = ":";
        this.f2018k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f2010c = writer;
    }

    private int m3482a() {
        if (this.f2012e != 0) {
            return this.f2011d[this.f2012e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private C0987c m3483a(int i, int i2, String str) {
        int a = m3482a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f2017j != null) {
            throw new IllegalStateException("Dangling name: " + this.f2017j);
        } else {
            this.f2012e--;
            if (a == i2) {
                m3490k();
            }
            this.f2010c.write(str);
            return this;
        }
    }

    private C0987c m3484a(int i, String str) {
        m3488e(true);
        m3485a(i);
        this.f2010c.write(str);
        return this;
    }

    private void m3485a(int i) {
        if (this.f2012e == this.f2011d.length) {
            Object obj = new int[(this.f2012e * 2)];
            System.arraycopy(this.f2011d, 0, obj, 0, this.f2012e);
            this.f2011d = obj;
        }
        int[] iArr = this.f2011d;
        int i2 = this.f2012e;
        this.f2012e = i2 + 1;
        iArr[i2] = i;
    }

    private void m3486b(int i) {
        this.f2011d[this.f2012e - 1] = i;
    }

    private void m3487d(String str) {
        int i = 0;
        String[] strArr = this.f2016i ? f2009b : f2008a;
        this.f2010c.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2;
            if (charAt < '\u0080') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.f2010c.write(str, i, i2 - i);
                }
                this.f2010c.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == '\u2028') {
                    str2 = "\\u2028";
                } else if (charAt == '\u2029') {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.f2010c.write(str, i, i2 - i);
                }
                this.f2010c.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f2010c.write(str, i, length - i);
        }
        this.f2010c.write("\"");
    }

    private void m3488e(boolean z) {
        switch (m3482a()) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                m3486b(2);
                m3490k();
                return;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                this.f2010c.append(',');
                m3490k();
                return;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                this.f2010c.append(this.f2014g);
                m3486b(5);
                return;
            case C1096c.MapAttrs_liteMode /*6*/:
                break;
            case C1096c.MapAttrs_uiCompass /*7*/:
                if (!this.f2015h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.f2015h || z) {
            m3486b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    private void m3489j() {
        if (this.f2017j != null) {
            m3491l();
            m3487d(this.f2017j);
            this.f2017j = null;
        }
    }

    private void m3490k() {
        if (this.f2013f != null) {
            this.f2010c.write("\n");
            int i = this.f2012e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f2010c.write(this.f2013f);
            }
        }
    }

    private void m3491l() {
        int a = m3482a();
        if (a == 5) {
            this.f2010c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m3490k();
        m3486b(4);
    }

    public C0987c m3492a(long j) {
        m3489j();
        m3488e(false);
        this.f2010c.write(Long.toString(j));
        return this;
    }

    public C0987c m3493a(Number number) {
        if (number == null) {
            return m3505f();
        }
        m3489j();
        CharSequence obj = number.toString();
        if (this.f2015h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m3488e(false);
            this.f2010c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public C0987c m3494a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f2017j != null) {
            throw new IllegalStateException();
        } else if (this.f2012e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f2017j = str;
            return this;
        }
    }

    public C0987c m3495a(boolean z) {
        m3489j();
        m3488e(false);
        this.f2010c.write(z ? "true" : "false");
        return this;
    }

    public C0987c m3496b() {
        m3489j();
        return m3484a(1, "[");
    }

    public C0987c m3497b(String str) {
        if (str == null) {
            return m3505f();
        }
        m3489j();
        m3488e(false);
        m3487d(str);
        return this;
    }

    public final void m3498b(boolean z) {
        this.f2015h = z;
    }

    public C0987c m3499c() {
        return m3483a(1, 2, "]");
    }

    public final void m3500c(String str) {
        if (str.length() == 0) {
            this.f2013f = null;
            this.f2014g = ":";
            return;
        }
        this.f2013f = str;
        this.f2014g = ": ";
    }

    public final void m3501c(boolean z) {
        this.f2016i = z;
    }

    public void close() {
        this.f2010c.close();
        int i = this.f2012e;
        if (i > 1 || (i == 1 && this.f2011d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f2012e = 0;
    }

    public C0987c m3502d() {
        m3489j();
        return m3484a(3, "{");
    }

    public final void m3503d(boolean z) {
        this.f2018k = z;
    }

    public C0987c m3504e() {
        return m3483a(3, 5, "}");
    }

    public C0987c m3505f() {
        if (this.f2017j != null) {
            if (this.f2018k) {
                m3489j();
            } else {
                this.f2017j = null;
                return this;
            }
        }
        m3488e(false);
        this.f2010c.write("null");
        return this;
    }

    public void flush() {
        if (this.f2012e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f2010c.flush();
    }

    public boolean m3506g() {
        return this.f2015h;
    }

    public final boolean m3507h() {
        return this.f2016i;
    }

    public final boolean m3508i() {
        return this.f2018k;
    }
}
