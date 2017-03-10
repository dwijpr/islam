package com.google.android.gms.common.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.common.util.k */
public final class C1385k {
    public static long m4953a(InputStream inputStream, OutputStream outputStream, boolean z) {
        return C1385k.m4954a(inputStream, outputStream, z, 1024);
    }

    public static long m4954a(InputStream inputStream, OutputStream outputStream, boolean z, int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    C1385k.m4955a((Closeable) inputStream);
                    C1385k.m4955a((Closeable) outputStream);
                }
            }
        }
        return j;
    }

    public static void m4955a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] m4956a(InputStream inputStream) {
        return C1385k.m4957a(inputStream, true);
    }

    public static byte[] m4957a(InputStream inputStream, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1385k.m4953a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }
}
