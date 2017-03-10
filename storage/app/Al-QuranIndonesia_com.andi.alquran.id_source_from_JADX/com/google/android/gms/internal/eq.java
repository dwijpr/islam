package com.google.android.gms.internal;

import com.google.android.gms.internal.cj.C1507a;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class eq {
    protected static final String f3906a;
    private final dc f3907b;
    private final String f3908c;
    private final String f3909d;
    private final int f3910e;
    private volatile Method f3911f;
    private List<Class> f3912g;
    private CountDownLatch f3913h;

    /* renamed from: com.google.android.gms.internal.eq.1 */
    class C15341 implements Runnable {
        final /* synthetic */ eq f3905a;

        C15341(eq eqVar) {
            this.f3905a = eqVar;
        }

        public void run() {
            this.f3905a.m5973b();
        }
    }

    static {
        f3906a = eq.class.getSimpleName();
    }

    public eq(dc dcVar, String str, String str2, List<Class> list) {
        this.f3910e = 2;
        this.f3911f = null;
        this.f3913h = new CountDownLatch(1);
        this.f3907b = dcVar;
        this.f3908c = str;
        this.f3909d = str2;
        this.f3912g = new ArrayList(list);
        this.f3907b.m5700c().submit(new C15341(this));
    }

    private String m5971a(byte[] bArr, String str) {
        return new String(this.f3907b.m5702e().m5547a(bArr, str), "UTF-8");
    }

    private void m5973b() {
        try {
            Class loadClass = this.f3907b.m5701d().loadClass(m5971a(this.f3907b.m5703f(), this.f3908c));
            if (loadClass != null) {
                this.f3911f = loadClass.getMethod(m5971a(this.f3907b.m5703f(), this.f3909d), (Class[]) this.f3912g.toArray(new Class[this.f3912g.size()]));
                if (this.f3911f == null) {
                    this.f3913h.countDown();
                } else {
                    this.f3913h.countDown();
                }
            }
        } catch (C1507a e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.f3913h.countDown();
        }
    }

    public Method m5974a() {
        if (this.f3911f != null) {
            return this.f3911f;
        }
        try {
            return this.f3913h.await(2, TimeUnit.SECONDS) ? this.f3911f : null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
