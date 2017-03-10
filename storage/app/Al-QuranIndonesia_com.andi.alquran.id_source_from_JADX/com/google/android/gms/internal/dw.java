package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;

public class dw {
    private final byte[] f3814a;
    private int f3815b;
    private int f3816c;

    public dw(byte[] bArr) {
        int i;
        this.f3814a = new byte[NotificationCompat.FLAG_LOCAL_ONLY];
        for (i = 0; i < NotificationCompat.FLAG_LOCAL_ONLY; i++) {
            this.f3814a[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < NotificationCompat.FLAG_LOCAL_ONLY; i2++) {
            i = ((i + this.f3814a[i2]) + bArr[i2 % bArr.length]) & 255;
            byte b = this.f3814a[i2];
            this.f3814a[i2] = this.f3814a[i];
            this.f3814a[i] = b;
        }
        this.f3815b = 0;
        this.f3816c = 0;
    }

    public void m5770a(byte[] bArr) {
        int i = this.f3815b;
        int i2 = this.f3816c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.f3814a[i]) & 255;
            byte b = this.f3814a[i];
            this.f3814a[i] = this.f3814a[i2];
            this.f3814a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f3814a[(this.f3814a[i] + this.f3814a[i2]) & 255]);
        }
        this.f3815b = i;
        this.f3816c = i2;
    }
}
