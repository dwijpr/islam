package com.google.p033a.p035b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.a.b.i */
public final class C1043i {
    private static final Map<Class<?>, Class<?>> f2182a;
    private static final Map<Class<?>, Class<?>> f2183b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        C1043i.m3748a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        C1043i.m3748a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        C1043i.m3748a(hashMap, hashMap2, Character.TYPE, Character.class);
        C1043i.m3748a(hashMap, hashMap2, Double.TYPE, Double.class);
        C1043i.m3748a(hashMap, hashMap2, Float.TYPE, Float.class);
        C1043i.m3748a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        C1043i.m3748a(hashMap, hashMap2, Long.TYPE, Long.class);
        C1043i.m3748a(hashMap, hashMap2, Short.TYPE, Short.class);
        C1043i.m3748a(hashMap, hashMap2, Void.TYPE, Void.class);
        f2182a = Collections.unmodifiableMap(hashMap);
        f2183b = Collections.unmodifiableMap(hashMap2);
    }

    public static <T> Class<T> m3747a(Class<T> cls) {
        Class<T> cls2 = (Class) f2182a.get(C1015a.m3677a((Object) cls));
        return cls2 == null ? cls : cls2;
    }

    private static void m3748a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean m3749a(Type type) {
        return f2182a.containsKey(type);
    }
}
