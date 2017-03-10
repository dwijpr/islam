package com.google.android.gms.p039a;

import android.os.IBinder;
import com.google.android.gms.p039a.C1108c.C1110a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.a.d */
public final class C1111d<T> extends C1110a {
    private final T f2302a;

    private C1111d(T t) {
        this.f2302a = t;
    }

    public static <T> C1108c m3896a(T t) {
        return new C1111d(t);
    }

    public static <T> T m3897a(C1108c c1108c) {
        int i = 0;
        if (c1108c instanceof C1111d) {
            return ((C1111d) c1108c).f2302a;
        }
        IBinder asBinder = c1108c.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field2 = declaredFields[i2];
            if (field2.isSynthetic()) {
                field2 = field;
            } else {
                i++;
            }
            i2++;
            field = field2;
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        } else if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        }
    }
}
