package android.support.v4.p014g;

import java.util.Map;

/* renamed from: android.support.v4.g.j */
public class C0297j<K, V> {
    static Object[] f623b;
    static int f624c;
    static Object[] f625d;
    static int f626e;
    int[] f627f;
    Object[] f628g;
    int f629h;

    public C0297j() {
        this.f627f = C0299b.f631a;
        this.f628g = C0299b.f633c;
        this.f629h = 0;
    }

    public C0297j(int i) {
        if (i == 0) {
            this.f627f = C0299b.f631a;
            this.f628g = C0299b.f633c;
        } else {
            m994e(i);
        }
        this.f629h = 0;
    }

    private static void m993a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0298a.class) {
                if (f626e < 10) {
                    objArr[0] = f625d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f625d = objArr;
                    f626e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0298a.class) {
                if (f624c < 10) {
                    objArr[0] = f623b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f623b = objArr;
                    f624c++;
                }
            }
        }
    }

    private void m994e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0298a.class) {
                if (f625d != null) {
                    objArr = f625d;
                    this.f628g = objArr;
                    f625d = (Object[]) objArr[0];
                    this.f627f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f626e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0298a.class) {
                if (f623b != null) {
                    objArr = f623b;
                    this.f628g = objArr;
                    f623b = (Object[]) objArr[0];
                    this.f627f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f624c--;
                    return;
                }
            }
        }
        this.f627f = new int[i];
        this.f628g = new Object[(i << 1)];
    }

    int m995a() {
        int i = this.f629h;
        if (i == 0) {
            return -1;
        }
        int a = C0299b.m1008a(this.f627f, i, 0);
        if (a < 0 || this.f628g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f627f[i2] == 0) {
            if (this.f628g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f627f[a] == 0) {
            if (this.f628g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    public int m996a(Object obj) {
        return obj == null ? m995a() : m997a(obj, obj.hashCode());
    }

    int m997a(Object obj, int i) {
        int i2 = this.f629h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0299b.m1008a(this.f627f, i2, i);
        if (a < 0 || obj.equals(this.f628g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f627f[i3] == i) {
            if (obj.equals(this.f628g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f627f[a] == i) {
            if (obj.equals(this.f628g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public V m998a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f628g[i2];
        this.f628g[i2] = v;
        return v2;
    }

    public void m999a(int i) {
        if (this.f627f.length < i) {
            Object obj = this.f627f;
            Object obj2 = this.f628g;
            m994e(i);
            if (this.f629h > 0) {
                System.arraycopy(obj, 0, this.f627f, 0, this.f629h);
                System.arraycopy(obj2, 0, this.f628g, 0, this.f629h << 1);
            }
            C0297j.m993a(obj, obj2, this.f629h);
        }
    }

    public void m1000a(C0297j<? extends K, ? extends V> c0297j) {
        int i = 0;
        int i2 = c0297j.f629h;
        m999a(this.f629h + i2);
        if (this.f629h != 0) {
            while (i < i2) {
                put(c0297j.m1002b(i), c0297j.m1003c(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(c0297j.f627f, 0, this.f627f, 0, i2);
            System.arraycopy(c0297j.f628g, 0, this.f628g, 0, i2 << 1);
            this.f629h = i2;
        }
    }

    int m1001b(Object obj) {
        int i = 1;
        int i2 = this.f629h * 2;
        Object[] objArr = this.f628g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public K m1002b(int i) {
        return this.f628g[i << 1];
    }

    public V m1003c(int i) {
        return this.f628g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f629h != 0) {
            C0297j.m993a(this.f627f, this.f628g, this.f629h);
            this.f627f = C0299b.f631a;
            this.f628g = C0299b.f633c;
            this.f629h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return m996a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m1001b(obj) >= 0;
    }

    public V m1004d(int i) {
        int i2 = 8;
        V v = this.f628g[(i << 1) + 1];
        if (this.f629h <= 1) {
            C0297j.m993a(this.f627f, this.f628g, this.f629h);
            this.f627f = C0299b.f631a;
            this.f628g = C0299b.f633c;
            this.f629h = 0;
        } else if (this.f627f.length <= 8 || this.f629h >= this.f627f.length / 3) {
            this.f629h--;
            if (i < this.f629h) {
                System.arraycopy(this.f627f, i + 1, this.f627f, i, this.f629h - i);
                System.arraycopy(this.f628g, (i + 1) << 1, this.f628g, i << 1, (this.f629h - i) << 1);
            }
            this.f628g[this.f629h << 1] = null;
            this.f628g[(this.f629h << 1) + 1] = null;
        } else {
            if (this.f629h > 8) {
                i2 = this.f629h + (this.f629h >> 1);
            }
            Object obj = this.f627f;
            Object obj2 = this.f628g;
            m994e(i2);
            this.f629h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f627f, 0, i);
                System.arraycopy(obj2, 0, this.f628g, 0, i << 1);
            }
            if (i < this.f629h) {
                System.arraycopy(obj, i + 1, this.f627f, i, this.f629h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f628g, i << 1, (this.f629h - i) << 1);
            }
        }
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object b;
        Object c;
        Object obj2;
        if (obj instanceof C0297j) {
            C0297j c0297j = (C0297j) obj;
            if (size() != c0297j.size()) {
                return false;
            }
            i = 0;
            while (i < this.f629h) {
                try {
                    b = m1002b(i);
                    c = m1003c(i);
                    obj2 = c0297j.get(b);
                    if (c == null) {
                        if (obj2 != null || !c0297j.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.f629h) {
                try {
                    b = m1002b(i);
                    c = m1003c(i);
                    obj2 = map.get(b);
                    if (c == null) {
                        if (obj2 != null || !map.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public V get(Object obj) {
        int a = m996a(obj);
        return a >= 0 ? this.f628g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f627f;
        Object[] objArr = this.f628g;
        int i = this.f629h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f629h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m995a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m997a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f628g[i3];
            this.f628g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f629h >= this.f627f.length) {
            if (this.f629h >= 8) {
                i2 = this.f629h + (this.f629h >> 1);
            } else if (this.f629h < 4) {
                i2 = 4;
            }
            Object obj = this.f627f;
            Object obj2 = this.f628g;
            m994e(i2);
            if (this.f627f.length > 0) {
                System.arraycopy(obj, 0, this.f627f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f628g, 0, obj2.length);
            }
            C0297j.m993a(obj, obj2, this.f629h);
        }
        if (a < this.f629h) {
            System.arraycopy(this.f627f, a, this.f627f, a + 1, this.f629h - a);
            System.arraycopy(this.f628g, a << 1, this.f628g, (a + 1) << 1, (this.f629h - a) << 1);
        }
        this.f627f[a] = i;
        this.f628g[a << 1] = k;
        this.f628g[(a << 1) + 1] = v;
        this.f629h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m996a(obj);
        return a >= 0 ? m1004d(a) : null;
    }

    public int size() {
        return this.f629h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f629h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f629h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0297j b = m1002b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1003c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
