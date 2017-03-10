package com.google.p033a.p035b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.google.a.b.k */
public abstract class C1048k {

    /* renamed from: com.google.a.b.k.1 */
    static class C10491 extends C1048k {
        final /* synthetic */ Method f2187a;
        final /* synthetic */ Object f2188b;

        C10491(Method method, Object obj) {
            this.f2187a = method;
            this.f2188b = obj;
        }

        public <T> T m3754a(Class<T> cls) {
            return this.f2187a.invoke(this.f2188b, new Object[]{cls});
        }
    }

    /* renamed from: com.google.a.b.k.2 */
    static class C10502 extends C1048k {
        final /* synthetic */ Method f2189a;
        final /* synthetic */ int f2190b;

        C10502(Method method, int i) {
            this.f2189a = method;
            this.f2190b = i;
        }

        public <T> T m3755a(Class<T> cls) {
            return this.f2189a.invoke(null, new Object[]{cls, Integer.valueOf(this.f2190b)});
        }
    }

    /* renamed from: com.google.a.b.k.3 */
    static class C10513 extends C1048k {
        final /* synthetic */ Method f2191a;

        C10513(Method method) {
            this.f2191a = method;
        }

        public <T> T m3756a(Class<T> cls) {
            return this.f2191a.invoke(null, new Object[]{cls, Object.class});
        }
    }

    /* renamed from: com.google.a.b.k.4 */
    static class C10524 extends C1048k {
        C10524() {
        }

        public <T> T m3757a(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static C1048k m3752a() {
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new C10491(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get(null));
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new C10502(declaredMethod2, intValue);
            } catch (Exception e2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    return new C10513(declaredMethod3);
                } catch (Exception e3) {
                    return new C10524();
                }
            }
        }
    }

    public abstract <T> T m3753a(Class<T> cls);
}
