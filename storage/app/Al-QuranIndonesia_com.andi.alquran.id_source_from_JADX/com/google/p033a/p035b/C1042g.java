package com.google.p033a.p035b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: com.google.a.b.g */
public final class C1042g<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f2173f;
    private static final Comparator<Comparable> f2174g;
    Comparator<? super K> f2175a;
    C1041d<K, V> f2176b;
    int f2177c;
    int f2178d;
    final C1041d<K, V> f2179e;
    private C1038a f2180h;
    private C1040b f2181i;

    /* renamed from: com.google.a.b.g.1 */
    static class C10351 implements Comparator<Comparable> {
        C10351() {
        }

        public int m3732a(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3732a((Comparable) obj, (Comparable) obj2);
        }
    }

    /* renamed from: com.google.a.b.g.c */
    private abstract class C1036c<T> implements Iterator<T> {
        C1041d<K, V> f2157b;
        C1041d<K, V> f2158c;
        int f2159d;
        final /* synthetic */ C1042g f2160e;

        private C1036c(C1042g c1042g) {
            this.f2160e = c1042g;
            this.f2157b = this.f2160e.f2179e.f2168d;
            this.f2158c = null;
            this.f2159d = this.f2160e.f2178d;
        }

        final C1041d<K, V> m3733b() {
            C1041d<K, V> c1041d = this.f2157b;
            if (c1041d == this.f2160e.f2179e) {
                throw new NoSuchElementException();
            } else if (this.f2160e.f2178d != this.f2159d) {
                throw new ConcurrentModificationException();
            } else {
                this.f2157b = c1041d.f2168d;
                this.f2158c = c1041d;
                return c1041d;
            }
        }

        public final boolean hasNext() {
            return this.f2157b != this.f2160e.f2179e;
        }

        public final void remove() {
            if (this.f2158c == null) {
                throw new IllegalStateException();
            }
            this.f2160e.m3745a(this.f2158c, true);
            this.f2158c = null;
            this.f2159d = this.f2160e.f2178d;
        }
    }

    /* renamed from: com.google.a.b.g.a */
    class C1038a extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ C1042g f2162a;

        /* renamed from: com.google.a.b.g.a.1 */
        class C10371 extends C1036c<Entry<K, V>> {
            final /* synthetic */ C1038a f2161a;

            C10371(C1038a c1038a) {
                this.f2161a = c1038a;
                super(null);
            }

            public Entry<K, V> m3734a() {
                return m3733b();
            }

            public /* synthetic */ Object next() {
                return m3734a();
            }
        }

        C1038a(C1042g c1042g) {
            this.f2162a = c1042g;
        }

        public void clear() {
            this.f2162a.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && this.f2162a.m3744a((Entry) obj) != null;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C10371(this);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            C1041d a = this.f2162a.m3744a((Entry) obj);
            if (a == null) {
                return false;
            }
            this.f2162a.m3745a(a, true);
            return true;
        }

        public int size() {
            return this.f2162a.f2177c;
        }
    }

    /* renamed from: com.google.a.b.g.b */
    final class C1040b extends AbstractSet<K> {
        final /* synthetic */ C1042g f2164a;

        /* renamed from: com.google.a.b.g.b.1 */
        class C10391 extends C1036c<K> {
            final /* synthetic */ C1040b f2163a;

            C10391(C1040b c1040b) {
                this.f2163a = c1040b;
                super(null);
            }

            public K next() {
                return m3733b().f2170f;
            }
        }

        C1040b(C1042g c1042g) {
            this.f2164a = c1042g;
        }

        public void clear() {
            this.f2164a.clear();
        }

        public boolean contains(Object obj) {
            return this.f2164a.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new C10391(this);
        }

        public boolean remove(Object obj) {
            return this.f2164a.m3746b(obj) != null;
        }

        public int size() {
            return this.f2164a.f2177c;
        }
    }

    /* renamed from: com.google.a.b.g.d */
    static final class C1041d<K, V> implements Entry<K, V> {
        C1041d<K, V> f2165a;
        C1041d<K, V> f2166b;
        C1041d<K, V> f2167c;
        C1041d<K, V> f2168d;
        C1041d<K, V> f2169e;
        final K f2170f;
        V f2171g;
        int f2172h;

        C1041d() {
            this.f2170f = null;
            this.f2169e = this;
            this.f2168d = this;
        }

        C1041d(C1041d<K, V> c1041d, K k, C1041d<K, V> c1041d2, C1041d<K, V> c1041d3) {
            this.f2165a = c1041d;
            this.f2170f = k;
            this.f2172h = 1;
            this.f2168d = c1041d2;
            this.f2169e = c1041d3;
            c1041d3.f2168d = this;
            c1041d2.f2169e = this;
        }

        public C1041d<K, V> m3735a() {
            C1041d<K, V> c1041d;
            for (C1041d<K, V> c1041d2 = this.f2166b; c1041d2 != null; c1041d2 = c1041d2.f2166b) {
                c1041d = c1041d2;
            }
            return c1041d;
        }

        public C1041d<K, V> m3736b() {
            C1041d<K, V> c1041d;
            for (C1041d<K, V> c1041d2 = this.f2167c; c1041d2 != null; c1041d2 = c1041d2.f2167c) {
                c1041d = c1041d2;
            }
            return c1041d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f2170f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f2170f.equals(entry.getKey())) {
                return false;
            }
            if (this.f2171g == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.f2171g.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f2170f;
        }

        public V getValue() {
            return this.f2171g;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f2170f == null ? 0 : this.f2170f.hashCode();
            if (this.f2171g != null) {
                i = this.f2171g.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            V v2 = this.f2171g;
            this.f2171g = v;
            return v2;
        }

        public String toString() {
            return this.f2170f + "=" + this.f2171g;
        }
    }

    static {
        f2173f = !C1042g.class.desiredAssertionStatus();
        f2174g = new C10351();
    }

    public C1042g() {
        this(f2174g);
    }

    public C1042g(Comparator<? super K> comparator) {
        Comparator comparator2;
        this.f2177c = 0;
        this.f2178d = 0;
        this.f2179e = new C1041d();
        if (comparator == null) {
            comparator2 = f2174g;
        }
        this.f2175a = comparator2;
    }

    private void m3737a(C1041d<K, V> c1041d) {
        int i = 0;
        C1041d c1041d2 = c1041d.f2166b;
        C1041d c1041d3 = c1041d.f2167c;
        C1041d c1041d4 = c1041d3.f2166b;
        C1041d c1041d5 = c1041d3.f2167c;
        c1041d.f2167c = c1041d4;
        if (c1041d4 != null) {
            c1041d4.f2165a = c1041d;
        }
        m3738a((C1041d) c1041d, c1041d3);
        c1041d3.f2166b = c1041d;
        c1041d.f2165a = c1041d3;
        c1041d.f2172h = Math.max(c1041d2 != null ? c1041d2.f2172h : 0, c1041d4 != null ? c1041d4.f2172h : 0) + 1;
        int i2 = c1041d.f2172h;
        if (c1041d5 != null) {
            i = c1041d5.f2172h;
        }
        c1041d3.f2172h = Math.max(i2, i) + 1;
    }

    private void m3738a(C1041d<K, V> c1041d, C1041d<K, V> c1041d2) {
        C1041d c1041d3 = c1041d.f2165a;
        c1041d.f2165a = null;
        if (c1041d2 != null) {
            c1041d2.f2165a = c1041d3;
        }
        if (c1041d3 == null) {
            this.f2176b = c1041d2;
        } else if (c1041d3.f2166b == c1041d) {
            c1041d3.f2166b = c1041d2;
        } else if (f2173f || c1041d3.f2167c == c1041d) {
            c1041d3.f2167c = c1041d2;
        } else {
            throw new AssertionError();
        }
    }

    private boolean m3739a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void m3740b(C1041d<K, V> c1041d) {
        int i = 0;
        C1041d c1041d2 = c1041d.f2166b;
        C1041d c1041d3 = c1041d.f2167c;
        C1041d c1041d4 = c1041d2.f2166b;
        C1041d c1041d5 = c1041d2.f2167c;
        c1041d.f2166b = c1041d5;
        if (c1041d5 != null) {
            c1041d5.f2165a = c1041d;
        }
        m3738a((C1041d) c1041d, c1041d2);
        c1041d2.f2167c = c1041d;
        c1041d.f2165a = c1041d2;
        c1041d.f2172h = Math.max(c1041d3 != null ? c1041d3.f2172h : 0, c1041d5 != null ? c1041d5.f2172h : 0) + 1;
        int i2 = c1041d.f2172h;
        if (c1041d4 != null) {
            i = c1041d4.f2172h;
        }
        c1041d2.f2172h = Math.max(i2, i) + 1;
    }

    private void m3741b(C1041d<K, V> c1041d, boolean z) {
        C1041d c1041d2;
        while (c1041d2 != null) {
            C1041d c1041d3 = c1041d2.f2166b;
            C1041d c1041d4 = c1041d2.f2167c;
            int i = c1041d3 != null ? c1041d3.f2172h : 0;
            int i2 = c1041d4 != null ? c1041d4.f2172h : 0;
            int i3 = i - i2;
            C1041d c1041d5;
            if (i3 == -2) {
                c1041d3 = c1041d4.f2166b;
                c1041d5 = c1041d4.f2167c;
                i2 = (c1041d3 != null ? c1041d3.f2172h : 0) - (c1041d5 != null ? c1041d5.f2172h : 0);
                if (i2 == -1 || (i2 == 0 && !z)) {
                    m3737a(c1041d2);
                } else if (f2173f || i2 == 1) {
                    m3740b(c1041d4);
                    m3737a(c1041d2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                c1041d4 = c1041d3.f2166b;
                c1041d5 = c1041d3.f2167c;
                i2 = (c1041d4 != null ? c1041d4.f2172h : 0) - (c1041d5 != null ? c1041d5.f2172h : 0);
                if (i2 == 1 || (i2 == 0 && !z)) {
                    m3740b(c1041d2);
                } else if (f2173f || i2 == -1) {
                    m3737a(c1041d3);
                    m3740b(c1041d2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c1041d2.f2172h = i + 1;
                if (z) {
                    return;
                }
            } else if (f2173f || i3 == -1 || i3 == 1) {
                c1041d2.f2172h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            c1041d2 = c1041d2.f2165a;
        }
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    C1041d<K, V> m3742a(Object obj) {
        C1041d<K, V> c1041d = null;
        if (obj != null) {
            try {
                c1041d = m3743a(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return c1041d;
    }

    C1041d<K, V> m3743a(K k, boolean z) {
        int i;
        Comparator comparator = this.f2175a;
        C1041d<K, V> c1041d = this.f2176b;
        if (c1041d != null) {
            int compareTo;
            Comparable comparable = comparator == f2174g ? (Comparable) k : null;
            while (true) {
                compareTo = comparable != null ? comparable.compareTo(c1041d.f2170f) : comparator.compare(k, c1041d.f2170f);
                if (compareTo == 0) {
                    return c1041d;
                }
                C1041d<K, V> c1041d2 = compareTo < 0 ? c1041d.f2166b : c1041d.f2167c;
                if (c1041d2 == null) {
                    break;
                }
                c1041d = c1041d2;
            }
            int i2 = compareTo;
            C1041d c1041d3 = c1041d;
            i = i2;
        } else {
            C1041d<K, V> c1041d4 = c1041d;
            i = 0;
        }
        if (!z) {
            return null;
        }
        C1041d<K, V> c1041d5;
        C1041d c1041d6 = this.f2179e;
        if (c1041d3 != null) {
            c1041d5 = new C1041d(c1041d3, k, c1041d6, c1041d6.f2169e);
            if (i < 0) {
                c1041d3.f2166b = c1041d5;
            } else {
                c1041d3.f2167c = c1041d5;
            }
            m3741b(c1041d3, true);
        } else if (comparator != f2174g || (k instanceof Comparable)) {
            c1041d5 = new C1041d(c1041d3, k, c1041d6, c1041d6.f2169e);
            this.f2176b = c1041d5;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.f2177c++;
        this.f2178d++;
        return c1041d5;
    }

    C1041d<K, V> m3744a(Entry<?, ?> entry) {
        C1041d<K, V> a = m3742a(entry.getKey());
        Object obj = (a == null || !m3739a(a.f2171g, entry.getValue())) ? null : 1;
        return obj != null ? a : null;
    }

    void m3745a(C1041d<K, V> c1041d, boolean z) {
        int i = 0;
        if (z) {
            c1041d.f2169e.f2168d = c1041d.f2168d;
            c1041d.f2168d.f2169e = c1041d.f2169e;
        }
        C1041d c1041d2 = c1041d.f2166b;
        C1041d c1041d3 = c1041d.f2167c;
        C1041d c1041d4 = c1041d.f2165a;
        if (c1041d2 == null || c1041d3 == null) {
            if (c1041d2 != null) {
                m3738a((C1041d) c1041d, c1041d2);
                c1041d.f2166b = null;
            } else if (c1041d3 != null) {
                m3738a((C1041d) c1041d, c1041d3);
                c1041d.f2167c = null;
            } else {
                m3738a((C1041d) c1041d, null);
            }
            m3741b(c1041d4, false);
            this.f2177c--;
            this.f2178d++;
            return;
        }
        int i2;
        c1041d2 = c1041d2.f2172h > c1041d3.f2172h ? c1041d2.m3736b() : c1041d3.m3735a();
        m3745a(c1041d2, false);
        c1041d4 = c1041d.f2166b;
        if (c1041d4 != null) {
            i2 = c1041d4.f2172h;
            c1041d2.f2166b = c1041d4;
            c1041d4.f2165a = c1041d2;
            c1041d.f2166b = null;
        } else {
            i2 = 0;
        }
        c1041d4 = c1041d.f2167c;
        if (c1041d4 != null) {
            i = c1041d4.f2172h;
            c1041d2.f2167c = c1041d4;
            c1041d4.f2165a = c1041d2;
            c1041d.f2167c = null;
        }
        c1041d2.f2172h = Math.max(i2, i) + 1;
        m3738a((C1041d) c1041d, c1041d2);
    }

    C1041d<K, V> m3746b(Object obj) {
        C1041d a = m3742a(obj);
        if (a != null) {
            m3745a(a, true);
        }
        return a;
    }

    public void clear() {
        this.f2176b = null;
        this.f2177c = 0;
        this.f2178d++;
        C1041d c1041d = this.f2179e;
        c1041d.f2169e = c1041d;
        c1041d.f2168d = c1041d;
    }

    public boolean containsKey(Object obj) {
        return m3742a(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.f2180h;
        if (set != null) {
            return set;
        }
        set = new C1038a(this);
        this.f2180h = set;
        return set;
    }

    public V get(Object obj) {
        C1041d a = m3742a(obj);
        return a != null ? a.f2171g : null;
    }

    public Set<K> keySet() {
        Set set = this.f2181i;
        if (set != null) {
            return set;
        }
        set = new C1040b(this);
        this.f2181i = set;
        return set;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C1041d a = m3743a((Object) k, true);
        V v2 = a.f2171g;
        a.f2171g = v;
        return v2;
    }

    public V remove(Object obj) {
        C1041d b = m3746b(obj);
        return b != null ? b.f2171g : null;
    }

    public int size() {
        return this.f2177c;
    }
}
