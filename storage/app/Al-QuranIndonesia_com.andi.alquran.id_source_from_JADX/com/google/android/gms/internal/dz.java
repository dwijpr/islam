package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import com.andi.alquran.C0861R;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class dz {
    private final ByteBuffer f3829a;

    /* renamed from: com.google.android.gms.internal.dz.a */
    public static class C1525a extends IOException {
        C1525a(int i, int i2) {
            super(new StringBuilder(C0861R.styleable.AppCompatTheme_ratingBarStyle).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(i).append(" limit ").append(i2).append(").").toString());
        }
    }

    private dz(ByteBuffer byteBuffer) {
        this.f3829a = byteBuffer;
        this.f3829a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private dz(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m5800a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '\u0080') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= '\u0800') {
                i += m5801a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m5801a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < '\u0800') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('\ud800' <= charAt && charAt <= '\udfff') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m5802a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '\u0080') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '\u0080' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < '\u0800' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            } else if ((charAt2 < '\ud800' || '\udfff' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static dz m5803a(byte[] bArr) {
        return m5804a(bArr, 0, bArr.length);
    }

    public static dz m5804a(byte[] bArr, int i, int i2) {
        return new dz(bArr, i, i2);
    }

    private static void m5805a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m5802a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m5813b(charSequence, byteBuffer);
        }
    }

    public static int m5806b(int i) {
        return i >= 0 ? m5823f(i) : 10;
    }

    public static int m5807b(int i, int i2) {
        return m5817d(i) + m5806b(i2);
    }

    public static int m5808b(int i, eg egVar) {
        return (m5817d(i) * 2) + m5815c(egVar);
    }

    public static int m5809b(int i, String str) {
        return m5817d(i) + m5812b(str);
    }

    public static int m5810b(int i, boolean z) {
        return m5817d(i) + 1;
    }

    public static int m5811b(int i, byte[] bArr) {
        return m5817d(i) + m5816c(bArr);
    }

    public static int m5812b(String str) {
        int a = m5800a((CharSequence) str);
        return a + m5823f(a);
    }

    private static void m5813b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '\u0080') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < '\u0800') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
            } else if (charAt < '\ud800' || '\udfff' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                byteBuffer.put((byte) ((charAt & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                        byteBuffer.put((byte) ((toCodePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int m5814c(int i, eg egVar) {
        return m5817d(i) + m5820d(egVar);
    }

    public static int m5815c(eg egVar) {
        return egVar.m5155g();
    }

    public static int m5816c(byte[] bArr) {
        return m5823f(bArr.length) + bArr.length;
    }

    public static int m5817d(int i) {
        return m5823f(ej.m5922a(i, 0));
    }

    public static int m5818d(int i, long j) {
        return m5817d(i) + m5819d(j);
    }

    public static int m5819d(long j) {
        return m5826h(j);
    }

    public static int m5820d(eg egVar) {
        int g = egVar.m5155g();
        return g + m5823f(g);
    }

    public static int m5821e(int i, long j) {
        return m5817d(i) + m5822e(j);
    }

    public static int m5822e(long j) {
        return m5826h(j);
    }

    public static int m5823f(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m5824f(int i, long j) {
        return m5817d(i) + m5825f(j);
    }

    public static int m5825f(long j) {
        return m5826h(m5827i(j));
    }

    public static int m5826h(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long m5827i(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public int m5828a() {
        return this.f3829a.remaining();
    }

    public void m5829a(byte b) {
        if (this.f3829a.hasRemaining()) {
            this.f3829a.put(b);
            return;
        }
        throw new C1525a(this.f3829a.position(), this.f3829a.limit());
    }

    public void m5830a(int i) {
        if (i >= 0) {
            m5852e(i);
        } else {
            m5853g((long) i);
        }
    }

    public void m5831a(int i, int i2) {
        m5848c(i, 0);
        m5830a(i2);
    }

    public void m5832a(int i, long j) {
        m5848c(i, 0);
        m5837a(j);
    }

    public void m5833a(int i, eg egVar) {
        m5848c(i, 2);
        m5844b(egVar);
    }

    public void m5834a(int i, String str) {
        m5848c(i, 2);
        m5839a(str);
    }

    public void m5835a(int i, boolean z) {
        m5848c(i, 0);
        m5840a(z);
    }

    public void m5836a(int i, byte[] bArr) {
        m5848c(i, 2);
        m5845b(bArr);
    }

    public void m5837a(long j) {
        m5853g(j);
    }

    public void m5838a(eg egVar) {
        egVar.m5150a(this);
    }

    public void m5839a(String str) {
        try {
            int f = m5823f(str.length());
            if (f == m5823f(str.length() * 3)) {
                int position = this.f3829a.position();
                if (this.f3829a.remaining() < f) {
                    throw new C1525a(f + position, this.f3829a.limit());
                }
                this.f3829a.position(position + f);
                m5805a((CharSequence) str, this.f3829a);
                int position2 = this.f3829a.position();
                this.f3829a.position(position);
                m5852e((position2 - position) - f);
                this.f3829a.position(position2);
                return;
            }
            m5852e(m5800a((CharSequence) str));
            m5805a((CharSequence) str, this.f3829a);
        } catch (Throwable e) {
            C1525a c1525a = new C1525a(this.f3829a.position(), this.f3829a.limit());
            c1525a.initCause(e);
            throw c1525a;
        }
    }

    public void m5840a(boolean z) {
        m5847c(z ? 1 : 0);
    }

    public void m5841b() {
        if (m5828a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m5842b(int i, long j) {
        m5848c(i, 0);
        m5843b(j);
    }

    public void m5843b(long j) {
        m5853g(j);
    }

    public void m5844b(eg egVar) {
        m5852e(egVar.m5154f());
        egVar.m5150a(this);
    }

    public void m5845b(byte[] bArr) {
        m5852e(bArr.length);
        m5851d(bArr);
    }

    public void m5846b(byte[] bArr, int i, int i2) {
        if (this.f3829a.remaining() >= i2) {
            this.f3829a.put(bArr, i, i2);
            return;
        }
        throw new C1525a(this.f3829a.position(), this.f3829a.limit());
    }

    public void m5847c(int i) {
        m5829a((byte) i);
    }

    public void m5848c(int i, int i2) {
        m5852e(ej.m5922a(i, i2));
    }

    public void m5849c(int i, long j) {
        m5848c(i, 0);
        m5850c(j);
    }

    public void m5850c(long j) {
        m5853g(m5827i(j));
    }

    public void m5851d(byte[] bArr) {
        m5846b(bArr, 0, bArr.length);
    }

    public void m5852e(int i) {
        while ((i & -128) != 0) {
            m5847c((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            i >>>= 7;
        }
        m5847c(i);
    }

    public void m5853g(long j) {
        while ((-128 & j) != 0) {
            m5847c((((int) j) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            j >>>= 7;
        }
        m5847c((int) j);
    }
}
