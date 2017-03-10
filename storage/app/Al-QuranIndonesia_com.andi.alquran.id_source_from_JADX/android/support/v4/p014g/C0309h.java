package android.support.v4.p014g;

/* renamed from: android.support.v4.g.h */
public class C0309h<F, S> {
    public final F f653a;
    public final S f654b;

    public C0309h(F f, S s) {
        this.f653a = f;
        this.f654b = s;
    }

    private static boolean m1028a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0309h)) {
            return false;
        }
        C0309h c0309h = (C0309h) obj;
        return C0309h.m1028a(c0309h.f653a, this.f653a) && C0309h.m1028a(c0309h.f654b, this.f654b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f653a == null ? 0 : this.f653a.hashCode();
        if (this.f654b != null) {
            i = this.f654b.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f653a) + " " + String.valueOf(this.f654b) + "}";
    }
}
