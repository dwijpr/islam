package com.google.android.gms.internal;

import android.os.SystemClock;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.internal.cz.C1516a;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class vs implements cz {
    private final Map<String, C2048a> f6269a;
    private long f6270b;
    private final File f6271c;
    private final int f6272d;

    /* renamed from: com.google.android.gms.internal.vs.a */
    static class C2048a {
        public long f6260a;
        public String f6261b;
        public String f6262c;
        public long f6263d;
        public long f6264e;
        public long f6265f;
        public long f6266g;
        public Map<String, String> f6267h;

        private C2048a() {
        }

        public C2048a(String str, C1516a c1516a) {
            this.f6261b = str;
            this.f6260a = (long) c1516a.f3717a.length;
            this.f6262c = c1516a.f3718b;
            this.f6263d = c1516a.f3719c;
            this.f6264e = c1516a.f3720d;
            this.f6265f = c1516a.f3721e;
            this.f6266g = c1516a.f3722f;
            this.f6267h = c1516a.f3723g;
        }

        public static C2048a m9537a(InputStream inputStream) {
            C2048a c2048a = new C2048a();
            if (vs.m9541a(inputStream) != 538247942) {
                throw new IOException();
            }
            c2048a.f6261b = vs.m9550c(inputStream);
            c2048a.f6262c = vs.m9550c(inputStream);
            if (c2048a.f6262c.equals(BuildConfig.VERSION_NAME)) {
                c2048a.f6262c = null;
            }
            c2048a.f6263d = vs.m9549b(inputStream);
            c2048a.f6264e = vs.m9549b(inputStream);
            c2048a.f6265f = vs.m9549b(inputStream);
            c2048a.f6266g = vs.m9549b(inputStream);
            c2048a.f6267h = vs.m9552d(inputStream);
            return c2048a;
        }

        public C1516a m9538a(byte[] bArr) {
            C1516a c1516a = new C1516a();
            c1516a.f3717a = bArr;
            c1516a.f3718b = this.f6262c;
            c1516a.f3719c = this.f6263d;
            c1516a.f3720d = this.f6264e;
            c1516a.f3721e = this.f6265f;
            c1516a.f3722f = this.f6266g;
            c1516a.f3723g = this.f6267h;
            return c1516a;
        }

        public boolean m9539a(OutputStream outputStream) {
            try {
                vs.m9543a(outputStream, 538247942);
                vs.m9545a(outputStream, this.f6261b);
                vs.m9545a(outputStream, this.f6262c == null ? BuildConfig.VERSION_NAME : this.f6262c);
                vs.m9544a(outputStream, this.f6263d);
                vs.m9544a(outputStream, this.f6264e);
                vs.m9544a(outputStream, this.f6265f);
                vs.m9544a(outputStream, this.f6266g);
                vs.m9547a(this.f6267h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                uj.m9229b("%s", e.toString());
                return false;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.vs.b */
    private static class C2049b extends FilterInputStream {
        private int f6268a;

        private C2049b(InputStream inputStream) {
            super(inputStream);
            this.f6268a = 0;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f6268a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f6268a += read;
            }
            return read;
        }
    }

    public vs(File file) {
        this(file, 5242880);
    }

    public vs(File file, int i) {
        this.f6269a = new LinkedHashMap(16, 0.75f, true);
        this.f6270b = 0;
        this.f6271c = file;
        this.f6272d = i;
    }

    static int m9541a(InputStream inputStream) {
        return ((((m9553e(inputStream) << 0) | 0) | (m9553e(inputStream) << 8)) | (m9553e(inputStream) << 16)) | (m9553e(inputStream) << 24);
    }

    private void m9542a(int i) {
        if (this.f6270b + ((long) i) >= ((long) this.f6272d)) {
            int i2;
            if (uj.f6092b) {
                uj.m9227a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f6270b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f6269a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C2048a c2048a = (C2048a) ((Entry) it.next()).getValue();
                if (m9559c(c2048a.f6261b).delete()) {
                    this.f6270b -= c2048a.f6260a;
                } else {
                    uj.m9229b("Could not delete cache entry for key=%s, filename=%s", c2048a.f6261b, m9551d(c2048a.f6261b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f6270b + ((long) i))) < ((float) this.f6272d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (uj.f6092b) {
                uj.m9227a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f6270b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void m9543a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void m9544a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m9545a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m9544a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void m9546a(String str, C2048a c2048a) {
        if (this.f6269a.containsKey(str)) {
            C2048a c2048a2 = (C2048a) this.f6269a.get(str);
            this.f6270b = (c2048a.f6260a - c2048a2.f6260a) + this.f6270b;
        } else {
            this.f6270b += c2048a.f6260a;
        }
        this.f6269a.put(str, c2048a);
    }

    static void m9547a(Map<String, String> map, OutputStream outputStream) {
        if (map != null) {
            m9543a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                m9545a(outputStream, (String) entry.getKey());
                m9545a(outputStream, (String) entry.getValue());
            }
            return;
        }
        m9543a(outputStream, 0);
    }

    private static byte[] m9548a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long m9549b(InputStream inputStream) {
        return (((((((0 | ((((long) m9553e(inputStream)) & 255) << null)) | ((((long) m9553e(inputStream)) & 255) << 8)) | ((((long) m9553e(inputStream)) & 255) << 16)) | ((((long) m9553e(inputStream)) & 255) << 24)) | ((((long) m9553e(inputStream)) & 255) << 32)) | ((((long) m9553e(inputStream)) & 255) << 40)) | ((((long) m9553e(inputStream)) & 255) << 48)) | ((((long) m9553e(inputStream)) & 255) << 56);
    }

    static String m9550c(InputStream inputStream) {
        return new String(m9548a(inputStream, (int) m9549b(inputStream)), "UTF-8");
    }

    private String m9551d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> m9552d(InputStream inputStream) {
        int a = m9541a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(m9550c(inputStream).intern(), m9550c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int m9553e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private void m9554e(String str) {
        C2048a c2048a = (C2048a) this.f6269a.get(str);
        if (c2048a != null) {
            this.f6270b -= c2048a.f6260a;
            this.f6269a.remove(str);
        }
    }

    public synchronized C1516a m9555a(String str) {
        C1516a c1516a;
        IOException e;
        Throwable th;
        C2048a c2048a = (C2048a) this.f6269a.get(str);
        if (c2048a == null) {
            c1516a = null;
        } else {
            File c = m9559c(str);
            C2049b c2049b;
            try {
                c2049b = new C2049b(null);
                try {
                    C2048a.m9537a((InputStream) c2049b);
                    c1516a = c2048a.m9538a(m9548a((InputStream) c2049b, (int) (c.length() - ((long) c2049b.f6268a))));
                    try {
                        c2049b.close();
                    } catch (IOException e2) {
                        c1516a = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        uj.m9229b("%s: %s", c.getAbsolutePath(), e.toString());
                        m9558b(str);
                        if (c2049b != null) {
                            try {
                                c2049b.close();
                            } catch (IOException e4) {
                                c1516a = null;
                            }
                        }
                        c1516a = null;
                        return c1516a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (c2049b != null) {
                            try {
                                c2049b.close();
                            } catch (IOException e5) {
                                c1516a = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                c2049b = null;
                uj.m9229b("%s: %s", c.getAbsolutePath(), e.toString());
                m9558b(str);
                if (c2049b != null) {
                    c2049b.close();
                }
                c1516a = null;
                return c1516a;
            } catch (Throwable th3) {
                th = th3;
                c2049b = null;
                if (c2049b != null) {
                    c2049b.close();
                }
                throw th;
            }
        }
        return c1516a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m9556a() {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.f6271c;	 Catch:{ all -> 0x006a }
        r1 = r1.exists();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x0025;
    L_0x000a:
        r0 = r9.f6271c;	 Catch:{ all -> 0x006a }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0023;
    L_0x0012:
        r0 = "Unable to create cache dir %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x006a }
        r2 = 0;
        r3 = r9.f6271c;	 Catch:{ all -> 0x006a }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x006a }
        r1[r2] = r3;	 Catch:{ all -> 0x006a }
        com.google.android.gms.internal.uj.m9230c(r0, r1);	 Catch:{ all -> 0x006a }
    L_0x0023:
        monitor-exit(r9);
        return;
    L_0x0025:
        r1 = r9.f6271c;	 Catch:{ all -> 0x006a }
        r3 = r1.listFiles();	 Catch:{ all -> 0x006a }
        if (r3 == 0) goto L_0x0023;
    L_0x002d:
        r4 = r3.length;	 Catch:{ all -> 0x006a }
        r2 = r0;
    L_0x002f:
        if (r2 >= r4) goto L_0x0023;
    L_0x0031:
        r5 = r3[r2];	 Catch:{ all -> 0x006a }
        r1 = 0;
        r0 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0054, all -> 0x0063 }
        r6 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0054, all -> 0x0063 }
        r6.<init>(r5);	 Catch:{ IOException -> 0x0054, all -> 0x0063 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x0054, all -> 0x0063 }
        r1 = com.google.android.gms.internal.vs.C2048a.m9537a(r0);	 Catch:{ IOException -> 0x0076 }
        r6 = r5.length();	 Catch:{ IOException -> 0x0076 }
        r1.f6260a = r6;	 Catch:{ IOException -> 0x0076 }
        r6 = r1.f6261b;	 Catch:{ IOException -> 0x0076 }
        r9.m9546a(r6, r1);	 Catch:{ IOException -> 0x0076 }
        r0.close();	 Catch:{ IOException -> 0x006d }
    L_0x0050:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x002f;
    L_0x0054:
        r0 = move-exception;
        r0 = r1;
    L_0x0056:
        if (r5 == 0) goto L_0x005b;
    L_0x0058:
        r5.delete();	 Catch:{ all -> 0x0071 }
    L_0x005b:
        if (r0 == 0) goto L_0x0050;
    L_0x005d:
        r0.close();	 Catch:{ IOException -> 0x0061 }
        goto L_0x0050;
    L_0x0061:
        r0 = move-exception;
        goto L_0x0050;
    L_0x0063:
        r0 = move-exception;
    L_0x0064:
        if (r1 == 0) goto L_0x0069;
    L_0x0066:
        r1.close();	 Catch:{ IOException -> 0x006f }
    L_0x0069:
        throw r0;	 Catch:{ all -> 0x006a }
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x006d:
        r0 = move-exception;
        goto L_0x0050;
    L_0x006f:
        r1 = move-exception;
        goto L_0x0069;
    L_0x0071:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0064;
    L_0x0076:
        r1 = move-exception;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vs.a():void");
    }

    public synchronized void m9557a(String str, C1516a c1516a) {
        m9542a(c1516a.f3717a.length);
        File c = m9559c(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(c);
            C2048a c2048a = new C2048a(str, c1516a);
            if (c2048a.m9539a(fileOutputStream)) {
                fileOutputStream.write(c1516a.f3717a);
                fileOutputStream.close();
                m9546a(str, c2048a);
            } else {
                fileOutputStream.close();
                uj.m9229b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!c.delete()) {
                uj.m9229b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m9558b(String str) {
        boolean delete = m9559c(str).delete();
        m9554e(str);
        if (!delete) {
            uj.m9229b("Could not delete cache entry for key=%s, filename=%s", str, m9551d(str));
        }
    }

    public File m9559c(String str) {
        return new File(this.f6271c, m9551d(str));
    }
}
