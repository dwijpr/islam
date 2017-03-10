package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.android.gms.internal.b */
public class C1451b extends ByteArrayOutputStream {
    private final vr f3521a;

    public C1451b(vr vrVar, int i) {
        this.f3521a = vrVar;
        this.buf = this.f3521a.m9536a(Math.max(i, NotificationCompat.FLAG_LOCAL_ONLY));
    }

    private void m5229a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f3521a.m9536a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f3521a.m9535a(this.buf);
            this.buf = a;
        }
    }

    public void close() {
        this.f3521a.m9535a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f3521a.m9535a(this.buf);
    }

    public synchronized void write(int i) {
        m5229a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m5229a(i2);
        super.write(bArr, i, i2);
    }
}
