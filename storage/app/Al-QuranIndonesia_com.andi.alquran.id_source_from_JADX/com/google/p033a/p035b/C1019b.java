package com.google.p033a.p035b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: com.google.a.b.b */
public final class C1019b {
    static final Type[] f2119a;

    /* renamed from: com.google.a.b.b.a */
    private static final class C1016a implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type f2113a;

        public C1016a(Type type) {
            this.f2113a = C1019b.m3695d(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C1019b.m3689a((Type) this, (GenericArrayType) obj);
        }

        public Type getGenericComponentType() {
            return this.f2113a;
        }

        public int hashCode() {
            return this.f2113a.hashCode();
        }

        public String toString() {
            return C1019b.m3697f(this.f2113a) + "[]";
        }
    }

    /* renamed from: com.google.a.b.b.b */
    private static final class C1017b implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final Type f2114a;
        private final Type f2115b;
        private final Type[] f2116c;

        public C1017b(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                int i2 = (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null) ? 1 : 0;
                boolean z = (type == null && i2 == 0) ? false : true;
                C1015a.m3678a(z);
            }
            this.f2114a = type == null ? null : C1019b.m3695d(type);
            this.f2115b = C1019b.m3695d(type2);
            this.f2116c = (Type[]) typeArr.clone();
            while (i < this.f2116c.length) {
                C1015a.m3677a(this.f2116c[i]);
                C1019b.m3700i(this.f2116c[i]);
                this.f2116c[i] = C1019b.m3695d(this.f2116c[i]);
                i++;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C1019b.m3689a((Type) this, (ParameterizedType) obj);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f2116c.clone();
        }

        public Type getOwnerType() {
            return this.f2114a;
        }

        public Type getRawType() {
            return this.f2115b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f2116c) ^ this.f2115b.hashCode()) ^ C1019b.m3690b(this.f2114a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder((this.f2116c.length + 1) * 30);
            stringBuilder.append(C1019b.m3697f(this.f2115b));
            if (this.f2116c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<").append(C1019b.m3697f(this.f2116c[0]));
            for (int i = 1; i < this.f2116c.length; i++) {
                stringBuilder.append(", ").append(C1019b.m3697f(this.f2116c[i]));
            }
            return stringBuilder.append(">").toString();
        }
    }

    /* renamed from: com.google.a.b.b.c */
    private static final class C1018c implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final Type f2117a;
        private final Type f2118b;

        public C1018c(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            C1015a.m3678a(typeArr2.length <= 1);
            C1015a.m3678a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C1015a.m3677a(typeArr2[0]);
                C1019b.m3700i(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z = false;
                }
                C1015a.m3678a(z);
                this.f2118b = C1019b.m3695d(typeArr2[0]);
                this.f2117a = Object.class;
                return;
            }
            C1015a.m3677a(typeArr[0]);
            C1019b.m3700i(typeArr[0]);
            this.f2118b = null;
            this.f2117a = C1019b.m3695d(typeArr[0]);
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C1019b.m3689a((Type) this, (WildcardType) obj);
        }

        public Type[] getLowerBounds() {
            if (this.f2118b == null) {
                return C1019b.f2119a;
            }
            return new Type[]{this.f2118b};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f2117a};
        }

        public int hashCode() {
            return (this.f2118b != null ? this.f2118b.hashCode() + 31 : 1) ^ (this.f2117a.hashCode() + 31);
        }

        public String toString() {
            return this.f2118b != null ? "? super " + C1019b.m3697f(this.f2118b) : this.f2117a == Object.class ? "?" : "? extends " + C1019b.m3697f(this.f2117a);
        }
    }

    static {
        f2119a = new Type[0];
    }

    private static int m3680a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> m3681a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        return genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
    }

    public static GenericArrayType m3682a(Type type) {
        return new C1016a(type);
    }

    public static ParameterizedType m3683a(Type type, Type type2, Type... typeArr) {
        return new C1017b(type, type2, typeArr);
    }

    public static Type m3684a(Type type, Class<?> cls) {
        Type b = C1019b.m3691b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        return b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments()[0] : Object.class;
    }

    static Type m3685a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return C1019b.m3685a(cls.getGenericInterfaces()[i], interfaces[i], (Class) cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            Class cls3;
            while (cls3 != Object.class) {
                Class superclass = cls3.getSuperclass();
                if (superclass == cls2) {
                    return cls3.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return C1019b.m3685a(cls3.getGenericSuperclass(), superclass, (Class) cls2);
                }
                cls3 = superclass;
            }
        }
        return cls2;
    }

    public static Type m3686a(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            type3 = (TypeVariable) type3;
            type2 = C1019b.m3687a(type, (Class) cls, (TypeVariable) type3);
            if (type2 == type3) {
                return type2;
            }
            type3 = type2;
        }
        Type componentType;
        Type a;
        if ((type3 instanceof Class) && ((Class) type3).isArray()) {
            Class cls2 = (Class) type3;
            componentType = cls2.getComponentType();
            a = C1019b.m3686a(type, (Class) cls, componentType);
            return componentType != a ? C1019b.m3682a(a) : cls2;
        } else if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            componentType = genericArrayType.getGenericComponentType();
            a = C1019b.m3686a(type, (Class) cls, componentType);
            return componentType != a ? C1019b.m3682a(a) : genericArrayType;
        } else if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            componentType = parameterizedType.getOwnerType();
            Type a2 = C1019b.m3686a(type, (Class) cls, componentType);
            int i = a2 != componentType ? 1 : 0;
            r4 = parameterizedType.getActualTypeArguments();
            int length = r4.length;
            int i2 = i;
            r1 = r4;
            for (int i3 = 0; i3 < length; i3++) {
                Type a3 = C1019b.m3686a(type, (Class) cls, r1[i3]);
                if (a3 != r1[i3]) {
                    if (i2 == 0) {
                        r1 = (Type[]) r1.clone();
                        i2 = 1;
                    }
                    r1[i3] = a3;
                }
            }
            return i2 != 0 ? C1019b.m3683a(a2, parameterizedType.getRawType(), r1) : parameterizedType;
        } else if (!(type3 instanceof WildcardType)) {
            return type3;
        } else {
            WildcardType wildcardType = (WildcardType) type3;
            r1 = wildcardType.getLowerBounds();
            r4 = wildcardType.getUpperBounds();
            if (r1.length == 1) {
                a = C1019b.m3686a(type, (Class) cls, r1[0]);
                return a != r1[0] ? C1019b.m3694c(a) : wildcardType;
            } else if (r4.length != 1) {
                return wildcardType;
            } else {
                componentType = C1019b.m3686a(type, (Class) cls, r4[0]);
                return componentType != r4[0] ? C1019b.m3692b(componentType) : wildcardType;
            }
        }
    }

    static Type m3687a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a = C1019b.m3681a((TypeVariable) typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = C1019b.m3685a(type, (Class) cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[C1019b.m3680a(a.getTypeParameters(), (Object) typeVariable)];
    }

    static boolean m3688a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean m3689a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!(C1019b.m3688a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()))) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return C1019b.m3689a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!(Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()))) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (!(typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName()))) {
                z = false;
            }
            return z;
        }
    }

    private static int m3690b(Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }

    static Type m3691b(Type type, Class<?> cls, Class<?> cls2) {
        C1015a.m3678a(cls2.isAssignableFrom(cls));
        return C1019b.m3686a(type, (Class) cls, C1019b.m3685a(type, (Class) cls, (Class) cls2));
    }

    public static WildcardType m3692b(Type type) {
        return new C1018c(new Type[]{type}, f2119a);
    }

    public static Type[] m3693b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = C1019b.m3691b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static WildcardType m3694c(Type type) {
        return new C1018c(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type m3695d(Type type) {
        if (type instanceof Class) {
            C1016a c1016a;
            Class cls = (Class) type;
            if (cls.isArray()) {
                c1016a = new C1016a(C1019b.m3695d(cls.getComponentType()));
            } else {
                Object obj = cls;
            }
            return c1016a;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C1017b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new C1016a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new C1018c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> m3696e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C1015a.m3678a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(C1019b.m3696e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return C1019b.m3696e(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    public static String m3697f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type m3698g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    private static void m3700i(Type type) {
        boolean z = ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
        C1015a.m3678a(z);
    }
}
