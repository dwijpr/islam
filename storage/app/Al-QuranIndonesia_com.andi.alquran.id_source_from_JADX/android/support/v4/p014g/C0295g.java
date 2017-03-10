package android.support.v4.p014g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.g.g */
abstract class C0295g<K, V> {
    C0305b f619b;
    C0306c f620c;
    C0308e f621d;

    /* renamed from: android.support.v4.g.g.a */
    final class C0304a<T> implements Iterator<T> {
        final int f641a;
        int f642b;
        int f643c;
        boolean f644d;
        final /* synthetic */ C0295g f645e;

        C0304a(C0295g c0295g, int i) {
            this.f645e = c0295g;
            this.f644d = false;
            this.f641a = i;
            this.f642b = c0295g.m970a();
        }

        public boolean hasNext() {
            return this.f643c < this.f642b;
        }

        public T next() {
            T a = this.f645e.m972a(this.f643c, this.f641a);
            this.f643c++;
            this.f644d = true;
            return a;
        }

        public void remove() {
            if (this.f644d) {
                this.f643c--;
                this.f642b--;
                this.f644d = false;
                this.f645e.m974a(this.f643c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: android.support.v4.g.g.b */
    final class C0305b implements Set<Entry<K, V>> {
        final /* synthetic */ C0295g f646a;

        C0305b(C0295g c0295g) {
            this.f646a = c0295g;
        }

        public boolean m1026a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ boolean add(Object obj) {
            return m1026a((Entry) obj);
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f646a.m970a();
            for (Entry entry : collection) {
                this.f646a.m975a(entry.getKey(), entry.getValue());
            }
            return a != this.f646a.m970a();
        }

        public void clear() {
            this.f646a.m980c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f646a.m971a(entry.getKey());
            return a >= 0 ? C0299b.m1010a(this.f646a.m972a(a, 1), entry.getValue()) : false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return C0295g.m967a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f646a.m970a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f646a.m972a(a, 0);
                Object a3 = this.f646a.m972a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f646a.m970a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0307d(this.f646a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f646a.m970a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: android.support.v4.g.g.c */
    final class C0306c implements Set<K> {
        final /* synthetic */ C0295g f647a;

        C0306c(C0295g c0295g) {
            this.f647a = c0295g;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f647a.m980c();
        }

        public boolean contains(Object obj) {
            return this.f647a.m971a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0295g.m966a(this.f647a.m978b(), (Collection) collection);
        }

        public boolean equals(Object obj) {
            return C0295g.m967a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f647a.m970a() - 1; a >= 0; a--) {
                Object a2 = this.f647a.m972a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f647a.m970a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0304a(this.f647a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f647a.m971a(obj);
            if (a < 0) {
                return false;
            }
            this.f647a.m974a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0295g.m968b(this.f647a.m978b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0295g.m969c(this.f647a.m978b(), collection);
        }

        public int size() {
            return this.f647a.m970a();
        }

        public Object[] toArray() {
            return this.f647a.m979b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f647a.m976a((Object[]) tArr, 0);
        }
    }

    /* renamed from: android.support.v4.g.g.d */
    final class C0307d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f648a;
        int f649b;
        boolean f650c;
        final /* synthetic */ C0295g f651d;

        C0307d(C0295g c0295g) {
            this.f651d = c0295g;
            this.f650c = false;
            this.f648a = c0295g.m970a() - 1;
            this.f649b = -1;
        }

        public Entry<K, V> m1027a() {
            this.f649b++;
            this.f650c = true;
            return this;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f650c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0299b.m1010a(entry.getKey(), this.f651d.m972a(this.f649b, 0)) && C0299b.m1010a(entry.getValue(), this.f651d.m972a(this.f649b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            if (this.f650c) {
                return this.f651d.m972a(this.f649b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f650c) {
                return this.f651d.m972a(this.f649b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f649b < this.f648a;
        }

        public final int hashCode() {
            int i = 0;
            if (this.f650c) {
                Object a = this.f651d.m972a(this.f649b, 0);
                Object a2 = this.f651d.m972a(this.f649b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public /* synthetic */ Object next() {
            return m1027a();
        }

        public void remove() {
            if (this.f650c) {
                this.f651d.m974a(this.f649b);
                this.f649b--;
                this.f648a--;
                this.f650c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f650c) {
                return this.f651d.m973a(this.f649b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: android.support.v4.g.g.e */
    final class C0308e implements Collection<V> {
        final /* synthetic */ C0295g f652a;

        C0308e(C0295g c0295g) {
            this.f652a = c0295g;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f652a.m980c();
        }

        public boolean contains(Object obj) {
            return this.f652a.m977b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f652a.m970a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0304a(this.f652a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f652a.m977b(obj);
            if (b < 0) {
                return false;
            }
            this.f652a.m974a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f652a.m970a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f652a.m972a(i, 1))) {
                    this.f652a.m974a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f652a.m970a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f652a.m972a(i, 1))) {
                    this.f652a.m974a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f652a.m970a();
        }

        public Object[] toArray() {
            return this.f652a.m979b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f652a.m976a((Object[]) tArr, 1);
        }
    }

    C0295g() {
    }

    public static <K, V> boolean m966a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean m967a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <K, V> boolean m968b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m969c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int m970a();

    protected abstract int m971a(Object obj);

    protected abstract Object m972a(int i, int i2);

    protected abstract V m973a(int i, V v);

    protected abstract void m974a(int i);

    protected abstract void m975a(K k, V v);

    public <T> T[] m976a(T[] tArr, int i) {
        int a = m970a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = m972a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    protected abstract int m977b(Object obj);

    protected abstract Map<K, V> m978b();

    public Object[] m979b(int i) {
        int a = m970a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m972a(i2, i);
        }
        return objArr;
    }

    protected abstract void m980c();

    public Set<Entry<K, V>> m981d() {
        if (this.f619b == null) {
            this.f619b = new C0305b(this);
        }
        return this.f619b;
    }

    public Set<K> m982e() {
        if (this.f620c == null) {
            this.f620c = new C0306c(this);
        }
        return this.f620c;
    }

    public Collection<V> m983f() {
        if (this.f621d == null) {
            this.f621d = new C0308e(this);
        }
        return this.f621d;
    }
}
