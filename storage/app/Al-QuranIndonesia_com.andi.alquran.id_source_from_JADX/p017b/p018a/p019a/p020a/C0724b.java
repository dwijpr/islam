package p017b.p018a.p019a.p020a;

import java.io.File;

/* renamed from: b.a.a.a.b */
public class C0724b {
    public static final String f1132a;
    private static final char f1133b;
    private static final char f1134c;

    static {
        f1132a = Character.toString('.');
        f1133b = File.separatorChar;
        if (C0724b.m2557a()) {
            f1134c = '/';
        } else {
            f1134c = '\\';
        }
    }

    public static int m2556a(String str) {
        return str == null ? -1 : Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    static boolean m2557a() {
        return f1133b == '\\';
    }

    public static int m2558b(String str) {
        if (str == null) {
            return -1;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return C0724b.m2556a(str) <= lastIndexOf ? lastIndexOf : -1;
    }

    public static String m2559c(String str) {
        if (str == null) {
            return null;
        }
        int b = C0724b.m2558b(str);
        return b != -1 ? str.substring(0, b) : str;
    }
}
