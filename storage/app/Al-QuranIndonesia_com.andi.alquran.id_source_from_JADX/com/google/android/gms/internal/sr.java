package com.google.android.gms.internal;

import com.google.android.gms.internal.sq.C1171c;
import com.google.android.gms.internal.sq.C1553a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@op
public class sr<T> implements sq<T> {
    protected int f4809a;
    protected final BlockingQueue<C1999a> f4810b;
    protected T f4811c;
    private final Object f4812d;

    /* renamed from: com.google.android.gms.internal.sr.a */
    class C1999a {
        public final C1171c<T> f5852a;
        public final C1553a f5853b;

        public C1999a(sr srVar, C1171c<T> c1171c, C1553a c1553a) {
            this.f5852a = c1171c;
            this.f5853b = c1553a;
        }
    }

    public sr() {
        this.f4812d = new Object();
        this.f4809a = 0;
        this.f4810b = new LinkedBlockingQueue();
    }

    public void m7339a() {
        synchronized (this.f4812d) {
            if (this.f4809a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f4809a = -1;
            for (C1999a c1999a : this.f4810b) {
                c1999a.f5853b.m6123a();
            }
            this.f4810b.clear();
        }
    }

    public void m7340a(C1171c<T> c1171c, C1553a c1553a) {
        synchronized (this.f4812d) {
            if (this.f4809a == 1) {
                c1171c.m4065a(this.f4811c);
            } else if (this.f4809a == -1) {
                c1553a.m6123a();
            } else if (this.f4809a == 0) {
                this.f4810b.add(new C1999a(this, c1171c, c1553a));
            }
        }
    }

    public void m7341a(T t) {
        synchronized (this.f4812d) {
            if (this.f4809a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f4811c = t;
            this.f4809a = 1;
            for (C1999a c1999a : this.f4810b) {
                c1999a.f5852a.m4065a(t);
            }
            this.f4810b.clear();
        }
    }

    public int m7342b() {
        return this.f4809a;
    }
}
