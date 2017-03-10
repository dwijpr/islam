package android.support.v4.p009b;

import android.support.v4.p014g.C0300c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.b.k */
public class C0227k<D> {
    int f547a;
    C0201b<D> f548b;
    C0200a<D> f549c;
    boolean f550d;
    boolean f551e;
    boolean f552f;
    boolean f553g;
    boolean f554h;

    /* renamed from: android.support.v4.b.k.a */
    public interface C0200a<D> {
    }

    /* renamed from: android.support.v4.b.k.b */
    public interface C0201b<D> {
    }

    public String m772a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0300c.m1013a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m773a() {
        this.f550d = true;
        this.f552f = false;
        this.f551e = false;
        m778b();
    }

    public void m774a(int i, C0201b<D> c0201b) {
        if (this.f548b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f548b = c0201b;
        this.f547a = i;
    }

    public void m775a(C0200a<D> c0200a) {
        if (this.f549c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f549c = c0200a;
    }

    public void m776a(C0201b<D> c0201b) {
        if (this.f548b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f548b != c0201b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f548b = null;
        }
    }

    public void m777a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f547a);
        printWriter.print(" mListener=");
        printWriter.println(this.f548b);
        if (this.f550d || this.f553g || this.f554h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f550d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f553g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f554h);
        }
        if (this.f551e || this.f552f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f551e);
            printWriter.print(" mReset=");
            printWriter.println(this.f552f);
        }
    }

    protected void m778b() {
    }

    public void m779b(C0200a<D> c0200a) {
        if (this.f549c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f549c != c0200a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f549c = null;
        }
    }

    public boolean m780c() {
        return m781d();
    }

    protected boolean m781d() {
        return false;
    }

    public void m782e() {
        this.f550d = false;
        m783f();
    }

    protected void m783f() {
    }

    public void m784g() {
        this.f551e = true;
        m785h();
    }

    protected void m785h() {
    }

    public void m786i() {
        m787j();
        this.f552f = true;
        this.f550d = false;
        this.f551e = false;
        this.f553g = false;
        this.f554h = false;
    }

    protected void m787j() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0300c.m1013a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f547a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
