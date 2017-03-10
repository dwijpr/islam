package p017b.p018a.p019a.p020a.p021a;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import p017b.p018a.p019a.p020a.C0723a;

/* renamed from: b.a.a.a.a.c */
public class C0722c extends C0720a implements Serializable {
    public static final Comparator<File> f1117a;
    public static final Comparator<File> f1118b;
    public static final Comparator<File> f1119c;
    public static final Comparator<File> f1120d;
    private final boolean f1121e;

    static {
        f1117a = new C0722c();
        f1118b = new C0721b(f1117a);
        f1119c = new C0722c(true);
        f1120d = new C0721b(f1119c);
    }

    public C0722c() {
        this.f1121e = false;
    }

    public C0722c(boolean z) {
        this.f1121e = z;
    }

    public int m2548a(File file, File file2) {
        long e = file.isDirectory() ? (this.f1121e && file.exists()) ? C0723a.m2553e(file) : 0 : file.length();
        long e2 = file2.isDirectory() ? (this.f1121e && file2.exists()) ? C0723a.m2553e(file2) : 0 : file2.length();
        e -= e2;
        return e < 0 ? -1 : e > 0 ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2548a((File) obj, (File) obj2);
    }

    public String toString() {
        return super.toString() + "[sumDirectoryContents=" + this.f1121e + "]";
    }
}
