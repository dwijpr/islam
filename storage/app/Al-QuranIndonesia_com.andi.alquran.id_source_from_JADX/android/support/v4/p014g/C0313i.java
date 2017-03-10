package android.support.v4.p014g;

/* renamed from: android.support.v4.g.i */
public final class C0313i {

    /* renamed from: android.support.v4.g.i.a */
    public interface C0310a<T> {
        T m1029a();

        boolean m1030a(T t);
    }

    /* renamed from: android.support.v4.g.i.b */
    public static class C0311b<T> implements C0310a<T> {
        private final Object[] f655a;
        private int f656b;

        public C0311b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f655a = new Object[i];
        }

        private boolean m1031b(T t) {
            for (int i = 0; i < this.f656b; i++) {
                if (this.f655a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        public T m1032a() {
            if (this.f656b <= 0) {
                return null;
            }
            int i = this.f656b - 1;
            T t = this.f655a[i];
            this.f655a[i] = null;
            this.f656b--;
            return t;
        }

        public boolean m1033a(T t) {
            if (m1031b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f656b >= this.f655a.length) {
                return false;
            } else {
                this.f655a[this.f656b] = t;
                this.f656b++;
                return true;
            }
        }
    }

    /* renamed from: android.support.v4.g.i.c */
    public static class C0312c<T> extends C0311b<T> {
        private final Object f657a;

        public C0312c(int i) {
            super(i);
            this.f657a = new Object();
        }

        public T m1034a() {
            T a;
            synchronized (this.f657a) {
                a = super.m1032a();
            }
            return a;
        }

        public boolean m1035a(T t) {
            boolean a;
            synchronized (this.f657a) {
                a = super.m1033a(t);
            }
            return a;
        }
    }
}
