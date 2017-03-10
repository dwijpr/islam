package com.google.android.gms.internal;

import java.security.MessageDigest;

@op
public class ft extends fq {
    private MessageDigest f4110b;

    byte m6237a(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    public byte[] m6238a(String str) {
        byte[] bArr;
        int i = 4;
        byte[] a = m6239a(str.split(" "));
        this.f4110b = m6223a();
        synchronized (this.a) {
            if (this.f4110b == null) {
                bArr = new byte[0];
            } else {
                this.f4110b.reset();
                this.f4110b.update(a);
                Object digest = this.f4110b.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }

    byte[] m6239a(String[] strArr) {
        int i = 0;
        if (strArr.length == 1) {
            return fs.m6234b(fs.m6230a(strArr[0]));
        }
        if (strArr.length < 5) {
            byte[] bArr = new byte[(strArr.length * 2)];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                byte[] b = m6240b(fs.m6230a(strArr[i2]));
                bArr[i2 * 2] = b[0];
                bArr[(i2 * 2) + 1] = b[1];
            }
            return bArr;
        }
        byte[] bArr2 = new byte[strArr.length];
        while (i < strArr.length) {
            bArr2[i] = m6237a(fs.m6230a(strArr[i]));
            i++;
        }
        return bArr2;
    }

    byte[] m6240b(int i) {
        int i2 = (65535 & i) ^ ((-65536 & i) >> 16);
        return new byte[]{(byte) i2, (byte) (i2 >> 8)};
    }
}
