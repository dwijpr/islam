package android.support.v4.p014g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.g.a */
public class C0298a<K, V> extends C0297j<K, V> implements Map<K, V> {
    C0295g<K, V> f630a;

    /* renamed from: android.support.v4.g.a.1 */
    class C02961 extends C0295g<K, V> {
        final /* synthetic */ C0298a f622a;

        C02961(C0298a c0298a) {
            this.f622a = c0298a;
        }

        protected int m984a() {
            return this.f622a.h;
        }

        protected int m985a(Object obj) {
            return this.f622a.m996a(obj);
        }

        protected Object m986a(int i, int i2) {
            return this.f622a.g[(i << 1) + i2];
        }

        protected V m987a(int i, V v) {
            return this.f622a.m998a(i, (Object) v);
        }

        protected void m988a(int i) {
            this.f622a.m1004d(i);
        }

        protected void m989a(K k, V v) {
            this.f622a.put(k, v);
        }

        protected int m990b(Object obj) {
            return this.f622a.m1001b(obj);
        }

        protected Map<K, V> m991b() {
            return this.f622a;
        }

        protected void m992c() {
            this.f622a.clear();
        }
    }

    public C0298a(int i) {
        super(i);
    }

    private C0295g<K, V> m1005b() {
        if (this.f630a == null) {
            this.f630a = new C02961(this);
        }
        return this.f630a;
    }

    public boolean m1006a(Collection<?> collection) {
        return C0295g.m969c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m1005b().m981d();
    }

    public Set<K> keySet() {
        return m1005b().m982e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m999a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return m1005b().m983f();
    }
}
