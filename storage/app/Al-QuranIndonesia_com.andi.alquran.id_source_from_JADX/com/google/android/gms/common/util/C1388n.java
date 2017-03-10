package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

/* renamed from: com.google.android.gms.common.util.n */
public class C1388n {
    private static String f3232a;
    private static final int f3233b;

    static {
        f3232a = null;
        f3233b = Process.myPid();
    }

    public static String m4971a() {
        if (f3232a == null) {
            f3232a = C1388n.m4972a(f3233b);
        }
        return f3232a;
    }

    static String m4972a(int i) {
        ThreadPolicy allowThreadDiskReads;
        Closeable bufferedReader;
        Throwable th;
        String str = null;
        if (i > 0) {
            try {
                allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
                try {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    str = bufferedReader.readLine().trim();
                    C1385k.m4955a(bufferedReader);
                } catch (IOException e) {
                    C1385k.m4955a(bufferedReader);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C1385k.m4955a(bufferedReader);
                    throw th;
                }
            } catch (IOException e2) {
                bufferedReader = str;
                C1385k.m4955a(bufferedReader);
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = str;
                th = th4;
                C1385k.m4955a(bufferedReader);
                throw th;
            }
        }
        return str;
    }
}
