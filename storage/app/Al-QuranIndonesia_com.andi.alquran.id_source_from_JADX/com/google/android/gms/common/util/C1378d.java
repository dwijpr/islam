package com.google.android.gms.common.util;

import android.support.v4.p014g.C0298a;
import com.google.android.gms.maps.GoogleMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.util.d */
public final class C1378d {
    public static <K, V> Map<K, V> m4929a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map c0298a = new C0298a(6);
        c0298a.put(k, v);
        c0298a.put(k2, v2);
        c0298a.put(k3, v3);
        c0298a.put(k4, v4);
        c0298a.put(k5, v5);
        c0298a.put(k6, v6);
        return Collections.unmodifiableMap(c0298a);
    }

    public static <T> Set<T> m4930a() {
        return Collections.emptySet();
    }

    public static <T> Set<T> m4931a(T t) {
        return Collections.singleton(t);
    }

    public static <T> Set<T> m4932a(T t, T t2) {
        Set c1375a = new C1375a(2);
        c1375a.add(t);
        c1375a.add(t2);
        return Collections.unmodifiableSet(c1375a);
    }

    public static <T> Set<T> m4933a(T t, T t2, T t3) {
        Set c1375a = new C1375a(3);
        c1375a.add(t);
        c1375a.add(t2);
        c1375a.add(t3);
        return Collections.unmodifiableSet(c1375a);
    }

    public static <T> Set<T> m4934a(T t, T t2, T t3, T t4) {
        Set c1375a = new C1375a(4);
        c1375a.add(t);
        c1375a.add(t2);
        c1375a.add(t3);
        c1375a.add(t4);
        return Collections.unmodifiableSet(c1375a);
    }

    public static <T> Set<T> m4935a(T... tArr) {
        switch (tArr.length) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return C1378d.m4930a();
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return C1378d.m4931a(tArr[0]);
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return C1378d.m4932a(tArr[0], tArr[1]);
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return C1378d.m4933a(tArr[0], tArr[1], tArr[2]);
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return C1378d.m4934a(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(tArr.length <= 32 ? new C1375a(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
        }
    }

    public static <K, V> Map<K, V> m4936b(K k, V v) {
        return Collections.singletonMap(k, v);
    }
}
