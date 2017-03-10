package com.google.android.gms.common.util;

import android.support.v4.p014g.C0298a;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.google.android.gms.common.util.a */
public class C1375a<E> extends AbstractSet<E> {
    private final C0298a<E, E> f3220a;

    public C1375a() {
        this.f3220a = new C0298a();
    }

    public C1375a(int i) {
        this.f3220a = new C0298a(i);
    }

    public C1375a(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean m4924a(C1375a<? extends E> c1375a) {
        int size = size();
        this.f3220a.m1000a(c1375a.f3220a);
        return size() > size;
    }

    public boolean add(E e) {
        if (this.f3220a.containsKey(e)) {
            return false;
        }
        this.f3220a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof C1375a ? m4924a((C1375a) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f3220a.clear();
    }

    public boolean contains(Object obj) {
        return this.f3220a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f3220a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f3220a.containsKey(obj)) {
            return false;
        }
        this.f3220a.remove(obj);
        return true;
    }

    public int size() {
        return this.f3220a.size();
    }
}
