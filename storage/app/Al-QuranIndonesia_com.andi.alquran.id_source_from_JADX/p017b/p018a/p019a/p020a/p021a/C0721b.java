package p017b.p018a.p019a.p020a.p021a;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: b.a.a.a.a.b */
class C0721b extends C0720a implements Serializable {
    private final Comparator<File> f1116a;

    public C0721b(Comparator<File> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Delegate comparator is missing");
        }
        this.f1116a = comparator;
    }

    public int m2547a(File file, File file2) {
        return this.f1116a.compare(file2, file);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2547a((File) obj, (File) obj2);
    }

    public String toString() {
        return super.toString() + "[" + this.f1116a.toString() + "]";
    }
}
