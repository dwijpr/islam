package com.google.p033a.p035b;

import com.google.p033a.C1075i;
import com.google.p033a.p035b.p036a.C1014m;
import com.google.p033a.p037d.C0987c;
import java.io.Writer;

/* renamed from: com.google.a.b.j */
public final class C1047j {

    /* renamed from: com.google.a.b.j.a */
    private static final class C1046a extends Writer {
        private final Appendable f2185a;
        private final C1045a f2186b;

        /* renamed from: com.google.a.b.j.a.a */
        static class C1045a implements CharSequence {
            char[] f2184a;

            C1045a() {
            }

            public char charAt(int i) {
                return this.f2184a[i];
            }

            public int length() {
                return this.f2184a.length;
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.f2184a, i, i2 - i);
            }
        }

        private C1046a(Appendable appendable) {
            this.f2186b = new C1045a();
            this.f2185a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) {
            this.f2185a.append((char) i);
        }

        public void write(char[] cArr, int i, int i2) {
            this.f2186b.f2184a = cArr;
            this.f2185a.append(this.f2186b, i, i + i2);
        }
    }

    public static Writer m3750a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C1046a(null);
    }

    public static void m3751a(C1075i c1075i, C0987c c0987c) {
        C1014m.f2084P.m3405a(c0987c, c1075i);
    }
}
