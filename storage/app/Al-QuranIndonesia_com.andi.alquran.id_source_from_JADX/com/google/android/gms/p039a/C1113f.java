package com.google.android.gms.p039a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.C1295j;
import com.google.android.gms.common.internal.C1314c;

/* renamed from: com.google.android.gms.a.f */
public abstract class C1113f<T> {
    private final String f2303a;
    private T f2304b;

    /* renamed from: com.google.android.gms.a.f.a */
    public static class C1112a extends Exception {
        public C1112a(String str) {
            super(str);
        }

        public C1112a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C1113f(String str) {
        this.f2303a = str;
    }

    protected final T m3898a(Context context) {
        if (this.f2304b == null) {
            C1314c.m4623a((Object) context);
            Context i = C1295j.m4592i(context);
            if (i == null) {
                throw new C1112a("Could not get remote context.");
            }
            try {
                this.f2304b = m3899a((IBinder) i.getClassLoader().loadClass(this.f2303a).newInstance());
            } catch (Throwable e) {
                throw new C1112a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new C1112a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new C1112a("Could not access creator.", e22);
            }
        }
        return this.f2304b;
    }

    protected abstract T m3899a(IBinder iBinder);
}
