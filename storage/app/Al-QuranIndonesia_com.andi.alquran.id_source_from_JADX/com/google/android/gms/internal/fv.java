package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.security.MessageDigest;

@op
public class fv extends fq {
    private MessageDigest f4114b;
    private final int f4115c;
    private final int f4116d;

    public fv(int i) {
        int i2 = i / 8;
        if (i % 8 > 0) {
            i2++;
        }
        this.f4115c = i2;
        this.f4116d = i;
    }

    public byte[] m6247a(String str) {
        byte[] bArr;
        synchronized (this.a) {
            this.f4114b = m6223a();
            if (this.f4114b == null) {
                bArr = new byte[0];
            } else {
                this.f4114b.reset();
                this.f4114b.update(str.getBytes(Charset.forName("UTF-8")));
                Object digest = this.f4114b.digest();
                bArr = new byte[(digest.length > this.f4115c ? this.f4115c : digest.length)];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
                if (this.f4116d % 8 > 0) {
                    int i;
                    long j = 0;
                    for (i = 0; i < bArr.length; i++) {
                        if (i > 0) {
                            j <<= 8;
                        }
                        j += (long) (bArr[i] & 255);
                    }
                    j >>>= 8 - (this.f4116d % 8);
                    for (i = this.f4115c - 1; i >= 0; i--) {
                        bArr[i] = (byte) ((int) (255 & j));
                        j >>>= 8;
                    }
                }
            }
        }
        return bArr;
    }
}
