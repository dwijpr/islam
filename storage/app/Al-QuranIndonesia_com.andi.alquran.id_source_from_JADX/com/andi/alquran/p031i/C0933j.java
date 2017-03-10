package com.andi.alquran.p031i;

import android.os.Handler;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p028g.p029a.C0911a;
import com.andi.alquran.p028g.p029a.C0913c;
import com.andi.alquran.p028g.p029a.C0914e;
import com.andi.alquran.p032j.C0953l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import p017b.p018a.p019a.p020a.C0723a;

/* renamed from: com.andi.alquran.i.j */
public class C0933j extends C0932i {
    private C0914e f1880c;
    private C0911a f1881d;

    private C0933j(Handler handler, C0914e c0914e) {
        super(handler);
        this.f1880c = c0914e;
        this.f1881d = new C0911a(this.f1880c.m3157f(), c0914e.m3158g(), Integer.valueOf(0));
    }

    public static C0933j m3246a(Handler handler, C0914e c0914e) {
        return new C0933j(handler, c0914e);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3247a(com.andi.alquran.p028g.p029a.C0914e r16) {
        /*
        r15 = this;
        r0 = 0;
        r8 = r15.m3252c();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x01d5, IOException -> 0x01d0, Exception -> 0x01cb, all -> 0x01ba }
        r0 = r15.m3253d();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x01d5, IOException -> 0x01d0, Exception -> 0x01cb, all -> 0x01ba }
        r1 = r0.getContentLength();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r6 = (long) r1;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r4 = 0;
        r1 = new java.io.File;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r15.f1881d;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r2.m3164d();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = r1.exists();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r1 == 0) goto L_0x0031;
    L_0x0021:
        r1 = new java.io.File;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r15.f1881d;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r2.m3164d();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r4 = r1.length();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r6 = r6 + r4;
    L_0x0031:
        r9 = r0.getInputStream();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r10 = new byte[r1];	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = 0;
        r3 = -1;
        r14 = r3;
        r3 = r1;
        r1 = r14;
    L_0x003e:
        r11 = r9.read(r10);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = -1;
        if (r11 == r2) goto L_0x0066;
    L_0x0045:
        r2 = r15.b;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r2 != 0) goto L_0x0066;
    L_0x0049:
        r2 = (long) r11;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r4 = r4 + r2;
        r2 = 100;
        r2 = r2 * r4;
        r2 = r2 / r6;
        r3 = (int) r2;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r12 = 0;
        r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r2 <= 0) goto L_0x0060;
    L_0x0056:
        if (r3 <= r1) goto L_0x0060;
    L_0x0058:
        r2 = r16.m3157f();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = r15;
        r1.m3249a(r2, r3, r4, r6);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
    L_0x0060:
        r1 = 0;
        r8.write(r10, r1, r11);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = r3;
        goto L_0x003e;
    L_0x0066:
        r1 = r15.b;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r1 == 0) goto L_0x009a;
    L_0x006a:
        r1 = new java.lang.InterruptedException;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = com.andi.alquran.App.m2860a();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r3 = 2131296495; // 0x7f0900ef float:1.8210908E38 double:1.0530003793E-314;
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r5 = 0;
        r6 = r16.m3158g();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r4[r5] = r6;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r2.getString(r3, r4);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        throw r1;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
    L_0x0085:
        r1 = move-exception;
        r1 = com.andi.alquran.App.m2860a();	 Catch:{ all -> 0x01c4 }
        r2 = 2131296499; // 0x7f0900f3 float:1.8210916E38 double:1.0530003813E-314;
        r1 = r1.getString(r2);	 Catch:{ all -> 0x01c4 }
        r15.m3248a(r1);	 Catch:{ all -> 0x01c4 }
        if (r0 == 0) goto L_0x0099;
    L_0x0096:
        r0.disconnect();
    L_0x0099:
        return;
    L_0x009a:
        r1 = r15.f1881d;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = com.andi.alquran.p032j.C0939a.m3273a(r1);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r1 != 0) goto L_0x00c8;
    L_0x00a2:
        r1 = new java.lang.Exception;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = com.andi.alquran.App.m2860a();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r3 = 2131296497; // 0x7f0900f1 float:1.8210912E38 double:1.0530003803E-314;
        r2 = r2.getString(r3);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        throw r1;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
    L_0x00b3:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x00b7:
        r2 = r0.getMessage();	 Catch:{ all -> 0x01c9 }
        if (r2 != 0) goto L_0x01a3;
    L_0x00bd:
        r0 = "";
    L_0x00bf:
        r15.m3250b(r0);	 Catch:{ all -> 0x01c9 }
        if (r1 == 0) goto L_0x0099;
    L_0x00c4:
        r1.disconnect();
        goto L_0x0099;
    L_0x00c8:
        r1 = new com.andi.alquran.j.l;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r15.f1881d;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r2.m3165e();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r8 = com.andi.alquran.App.m2887l();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.<init>(r2, r8);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.m3325a();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = new java.io.File;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r15.f1881d;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r2.m3165e();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r1.exists();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r2 == 0) goto L_0x00ee;
    L_0x00eb:
        r1.delete();	 Catch:{ Exception -> 0x014f, SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154 }
    L_0x00ee:
        r1 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.<init>();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = com.andi.alquran.App.m2887l();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = "000_license.dat";
        r1 = r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = r1.toString();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = new java.io.File;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = r2.exists();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r1 == 0) goto L_0x0113;
    L_0x0110:
        r2.delete();	 Catch:{ Exception -> 0x0188, SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154 }
    L_0x0113:
        r1 = new java.io.File;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r8 = com.andi.alquran.App.m2887l();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r2.append(r8);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r8 = r16.m3157f();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r2.append(r8);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r2.toString();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r2 = r1.exists();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r2 == 0) goto L_0x0140;
    L_0x0137:
        r2 = r1.isDirectory();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r2 == 0) goto L_0x0140;
    L_0x013d:
        p017b.p018a.p019a.p020a.C0723a.m2549a(r1);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
    L_0x0140:
        r2 = r16.m3157f();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        r1 = r15;
        r1.m3251b(r2, r3, r4, r6);	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        if (r0 == 0) goto L_0x0099;
    L_0x014a:
        r0.disconnect();
        goto L_0x0099;
    L_0x014f:
        r1 = move-exception;
        r1.getMessage();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        goto L_0x00ee;
    L_0x0154:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x0158:
        r2 = r0.getMessage();	 Catch:{ all -> 0x01c9 }
        if (r2 == 0) goto L_0x01a9;
    L_0x015e:
        r0 = r0.getMessage();	 Catch:{ all -> 0x01c9 }
        r2 = com.andi.alquran.App.m2860a();	 Catch:{ all -> 0x01c9 }
        r3 = 2131296496; // 0x7f0900f0 float:1.821091E38 double:1.05300038E-314;
        r2 = r2.getString(r3);	 Catch:{ all -> 0x01c9 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x01c9 }
        if (r0 == 0) goto L_0x01a9;
    L_0x0173:
        r0 = com.andi.alquran.App.m2860a();	 Catch:{ all -> 0x01c9 }
        r2 = 2131296496; // 0x7f0900f0 float:1.821091E38 double:1.05300038E-314;
        r0 = r0.getString(r2);	 Catch:{ all -> 0x01c9 }
    L_0x017e:
        r15.m3248a(r0);	 Catch:{ all -> 0x01c9 }
        if (r1 == 0) goto L_0x0099;
    L_0x0183:
        r1.disconnect();
        goto L_0x0099;
    L_0x0188:
        r1 = move-exception;
        r1.getMessage();	 Catch:{ SocketTimeoutException -> 0x0085, InterruptedException -> 0x00b3, IOException -> 0x0154, Exception -> 0x018d }
        goto L_0x0113;
    L_0x018d:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x0191:
        r2 = r0.getMessage();	 Catch:{ all -> 0x01c9 }
        if (r2 != 0) goto L_0x01b5;
    L_0x0197:
        r0 = "";
    L_0x0199:
        r15.m3248a(r0);	 Catch:{ all -> 0x01c9 }
        if (r1 == 0) goto L_0x0099;
    L_0x019e:
        r1.disconnect();
        goto L_0x0099;
    L_0x01a3:
        r0 = r0.getMessage();	 Catch:{ all -> 0x01c9 }
        goto L_0x00bf;
    L_0x01a9:
        r0 = com.andi.alquran.App.m2860a();	 Catch:{ all -> 0x01c9 }
        r2 = 2131296498; // 0x7f0900f2 float:1.8210914E38 double:1.053000381E-314;
        r0 = r0.getString(r2);	 Catch:{ all -> 0x01c9 }
        goto L_0x017e;
    L_0x01b5:
        r0 = r0.getMessage();	 Catch:{ all -> 0x01c9 }
        goto L_0x0199;
    L_0x01ba:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x01be:
        if (r1 == 0) goto L_0x01c3;
    L_0x01c0:
        r1.disconnect();
    L_0x01c3:
        throw r0;
    L_0x01c4:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
        goto L_0x01be;
    L_0x01c9:
        r0 = move-exception;
        goto L_0x01be;
    L_0x01cb:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
        goto L_0x0191;
    L_0x01d0:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
        goto L_0x0158;
    L_0x01d5:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
        goto L_0x00b7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.andi.alquran.i.j.a(com.andi.alquran.g.a.e):void");
    }

    private void m3248a(String str) {
        m3244a(this.a.obtainMessage(-1, new C0913c(this.f1881d.m3157f(), this.f1881d.m3158g(), str)));
    }

    private void m3249a(String str, int i, long j, long j2) {
        this.f1881d.m3161a(str, Integer.valueOf(i), j, j2);
        m3244a(this.a.obtainMessage(1, this.f1881d));
    }

    private void m3250b(String str) {
        m3244a(this.a.obtainMessage(-1, new C0913c(this.f1881d.m3157f(), this.f1881d.m3158g(), str, true)));
    }

    private void m3251b(String str, int i, long j, long j2) {
        this.f1881d.m3161a(str, Integer.valueOf(i), j, j2);
        m3244a(this.a.obtainMessage(2, this.f1881d));
    }

    private RandomAccessFile m3252c() {
        File file = new File(this.f1881d.m3164d());
        if (file.getParentFile().isDirectory() || file.getParentFile().mkdirs()) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            long length = new File(this.f1881d.m3164d()).exists() ? new File(this.f1881d.m3164d()).length() : 0;
            if (length != 0) {
                randomAccessFile.seek(length);
            }
            return randomAccessFile;
        }
        throw new IOException(App.m2860a().getString(C0861R.string.msg_download_exception_cannot_dir));
    }

    private HttpURLConnection m3253d() {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1880c.m3187a()).openConnection();
        httpURLConnection.setConnectTimeout(7000);
        httpURLConnection.setReadTimeout(7000);
        httpURLConnection.setUseCaches(true);
        long length = new File(this.f1881d.m3164d()).exists() ? new File(this.f1881d.m3164d()).length() : 0;
        if (length != 0) {
            httpURLConnection.setRequestProperty("Range", "bytes=" + length + "-");
        }
        return httpURLConnection;
    }

    protected void m3254a() {
        File file = new File(this.f1881d.m3165e());
        if (file.exists()) {
            long length = file.length();
            m3249a(this.f1880c.m3157f(), 100, length, length);
            new C0953l(this.f1881d.m3165e(), App.m2887l()).m3325a();
            file = new File(this.f1881d.m3165e());
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            File file2 = new File(App.m2887l() + "000_license.dat");
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
            file = new File(App.m2887l() + this.f1880c.m3157f());
            if (file.exists() && file.isDirectory()) {
                C0723a.m2549a(file);
            }
            m3251b(this.f1880c.m3157f(), 100, length, length);
            return;
        }
        m3247a(this.f1880c);
    }
}
