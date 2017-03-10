package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.internal.au.C1444a;
import com.google.android.gms.internal.au.C1446c;
import com.google.android.gms.internal.au.C1449f;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class ba {
    static boolean f3522a;
    static CountDownLatch f3523b;
    private static MessageDigest f3524c;
    private static final Object f3525d;
    private static final Object f3526e;

    /* renamed from: com.google.android.gms.internal.ba.a */
    private static final class C1453a implements Runnable {
        private C1453a() {
        }

        public void run() {
            try {
                ba.f3524c = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            } finally {
                ba.f3523b.countDown();
            }
        }
    }

    static {
        f3522a = false;
        f3524c = null;
        f3525d = new Object();
        f3526e = new Object();
        f3523b = new CountDownLatch(1);
    }

    private static int m5230a(boolean z) {
        return z ? 239 : 255;
    }

    static C1444a m5231a(long j) {
        C1444a c1444a = new C1444a();
        c1444a.f3424t = Long.valueOf(j);
        return c1444a;
    }

    static String m5232a(C1444a c1444a, String str, boolean z) {
        return m5234a(eg.m5148a((eg) c1444a), str, z);
    }

    static String m5233a(String str, String str2, boolean z) {
        byte[] b = m5242b(str, str2, z);
        return b != null ? ay.m5225a(b, true) : Integer.toString(7);
    }

    static String m5234a(byte[] bArr, String str, boolean z) {
        return ay.m5225a(z ? m5243b(bArr, str) : m5240a(bArr, str), true);
    }

    static Vector<byte[]> m5236a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + i) - 1) / i;
        Vector<byte[]> vector = new Vector();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * i;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > i ? i3 + i : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    static void m5237a() {
        synchronized (f3526e) {
            if (!f3522a) {
                f3522a = true;
                new Thread(new C1453a()).start();
            }
        }
    }

    static void m5238a(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new dw(str.getBytes("UTF-8")).m5770a(bArr);
    }

    public static byte[] m5239a(byte[] bArr) {
        byte[] digest;
        synchronized (f3525d) {
            MessageDigest b = m5241b();
            if (b == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            b.reset();
            b.update(bArr);
            digest = f3524c.digest();
        }
        return digest;
    }

    static byte[] m5240a(byte[] bArr, String str) {
        Vector a = m5236a(bArr, 255);
        if (a == null || a.size() == 0) {
            return m5243b(eg.m5148a(m5231a(4096)), str);
        }
        eg c1449f = new C1449f();
        c1449f.f3445a = new byte[a.size()][];
        Iterator it = a.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            c1449f.f3445a[i] = m5244b((byte[]) it.next(), str, false);
            i = i2;
        }
        c1449f.f3446b = m5239a(bArr);
        return eg.m5148a(c1449f);
    }

    static MessageDigest m5241b() {
        m5237a();
        boolean z = false;
        try {
            z = f3523b.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return (z && f3524c != null) ? f3524c : null;
    }

    static byte[] m5242b(String str, String str2, boolean z) {
        eg c1446c = new C1446c();
        try {
            c1446c.f3436a = str.length() < 3 ? str.getBytes("ISO-8859-1") : ay.m5226a(str, true);
            byte[] bytes = z ? str2.length() < 3 ? str2.getBytes("ISO-8859-1") : ay.m5226a(str2, true) : (str2 == null || str2.length() == 0) ? Integer.toString(5).getBytes("ISO-8859-1") : ay.m5226a(m5234a(str2.getBytes("ISO-8859-1"), null, ((Boolean) C1648if.bs.m6682c()).booleanValue()), true);
            c1446c.f3437b = bytes;
            return eg.m5148a(c1446c);
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }

    static byte[] m5243b(byte[] bArr, String str) {
        return m5244b(bArr, str, true);
    }

    private static byte[] m5244b(byte[] bArr, String str, boolean z) {
        byte[] bArr2;
        byte[] array;
        int a = m5230a(z);
        if (bArr.length > a) {
            bArr = eg.m5148a(m5231a(4096));
        }
        if (bArr.length < a) {
            bArr2 = new byte[(a - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(a + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(a + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(NotificationCompat.FLAG_LOCAL_ONLY).put(m5239a(array)).put(array).array();
        }
        bArr2 = new byte[NotificationCompat.FLAG_LOCAL_ONLY];
        new bb().m5258a(array, bArr2);
        if (str != null && str.length() > 0) {
            m5238a(str, bArr2);
        }
        return bArr2;
    }
}
