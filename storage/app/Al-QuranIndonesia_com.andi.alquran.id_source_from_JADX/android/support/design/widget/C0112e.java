package android.support.design.widget;

import android.support.v4.p014g.C0297j;
import android.support.v4.p014g.C0313i.C0310a;
import android.support.v4.p014g.C0313i.C0311b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: android.support.design.widget.e */
final class C0112e<T> {
    private final C0310a<ArrayList<T>> f407a;
    private final C0297j<T, ArrayList<T>> f408b;
    private final ArrayList<T> f409c;
    private final HashSet<T> f410d;

    C0112e() {
        this.f407a = new C0311b(10);
        this.f408b = new C0297j();
        this.f409c = new ArrayList();
        this.f410d = new HashSet();
    }

    private void m505a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.f408b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m505a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    private void m506a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f407a.m1030a(arrayList);
    }

    private ArrayList<T> m507c() {
        ArrayList<T> arrayList = (ArrayList) this.f407a.m1029a();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    void m508a() {
        int size = this.f408b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f408b.m1003c(i);
            if (arrayList != null) {
                m506a(arrayList);
            }
        }
        this.f408b.clear();
    }

    void m509a(T t) {
        if (!this.f408b.containsKey(t)) {
            this.f408b.put(t, null);
        }
    }

    void m510a(T t, T t2) {
        if (this.f408b.containsKey(t) && this.f408b.containsKey(t2)) {
            ArrayList arrayList = (ArrayList) this.f408b.get(t);
            if (arrayList == null) {
                arrayList = m507c();
                this.f408b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    ArrayList<T> m511b() {
        this.f409c.clear();
        this.f410d.clear();
        int size = this.f408b.size();
        for (int i = 0; i < size; i++) {
            m505a(this.f408b.m1002b(i), this.f409c, this.f410d);
        }
        return this.f409c;
    }

    boolean m512b(T t) {
        return this.f408b.containsKey(t);
    }

    List m513c(T t) {
        return (List) this.f408b.get(t);
    }

    List m514d(T t) {
        List list = null;
        int size = this.f408b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f408b.m1003c(i);
            if (arrayList != null && arrayList.contains(t)) {
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    List list2 = list;
                }
                arrayList.add(this.f408b.m1002b(i));
                list = arrayList;
            }
        }
        return list;
    }

    boolean m515e(T t) {
        int size = this.f408b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f408b.m1003c(i);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
