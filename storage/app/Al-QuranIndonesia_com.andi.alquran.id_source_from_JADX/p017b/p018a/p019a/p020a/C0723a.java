package p017b.p018a.p019a.p020a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;

/* renamed from: b.a.a.a.a */
public class C0723a {
    public static final BigInteger f1122a;
    public static final BigInteger f1123b;
    public static final BigInteger f1124c;
    public static final BigInteger f1125d;
    public static final BigInteger f1126e;
    public static final BigInteger f1127f;
    public static final BigInteger f1128g;
    public static final BigInteger f1129h;
    public static final File[] f1130i;
    private static final Charset f1131j;

    static {
        f1122a = BigInteger.valueOf(1024);
        f1123b = f1122a.multiply(f1122a);
        f1124c = f1122a.multiply(f1123b);
        f1125d = f1122a.multiply(f1124c);
        f1126e = f1122a.multiply(f1125d);
        f1127f = f1122a.multiply(f1126e);
        f1128g = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
        f1129h = f1122a.multiply(f1128g);
        f1130i = new File[0];
        f1131j = Charset.forName("UTF-8");
    }

    public static void m2549a(File file) {
        if (file.exists()) {
            if (!C0723a.m2554f(file)) {
                C0723a.m2550b(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static void m2550b(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            IOException iOException = null;
            for (File c : listFiles) {
                try {
                    C0723a.m2551c(c);
                } catch (IOException e) {
                    iOException = e;
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } else {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static void m2551c(File file) {
        if (file.isDirectory()) {
            C0723a.m2549a(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (exists) {
                throw new IOException("Unable to delete file: " + file);
            }
            throw new FileNotFoundException("File does not exist: " + file);
        }
    }

    public static long m2552d(File file) {
        if (file.exists()) {
            return file.isDirectory() ? C0723a.m2553e(file) : file.length();
        } else {
            throw new IllegalArgumentException(file + " does not exist");
        }
    }

    public static long m2553e(File file) {
        C0723a.m2555g(file);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        long j = 0;
        for (File file2 : listFiles) {
            try {
                if (C0723a.m2554f(file2)) {
                    continue;
                } else {
                    j += C0723a.m2552d(file2);
                    if (j < 0) {
                        return j;
                    }
                }
            } catch (IOException e) {
            }
        }
        return j;
    }

    public static boolean m2554f(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        } else if (C0724b.m2557a()) {
            return false;
        } else {
            if (file.getParent() != null) {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        }
    }

    private static void m2555g(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }
}
