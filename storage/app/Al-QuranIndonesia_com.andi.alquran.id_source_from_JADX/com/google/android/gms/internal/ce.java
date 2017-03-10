package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.as.C1438a;
import com.google.android.gms.internal.au.C1444a;
import com.google.android.gms.internal.au.C1444a.C1442a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class ce extends bl {
    protected static final Object f3640l;
    protected static volatile dc f3641m;
    static boolean f3642n;
    private static final String f3643s;
    private static long f3644t;
    protected boolean f3645o;
    protected String f3646p;
    protected boolean f3647q;
    protected boolean f3648r;

    static {
        f3640l = new Object();
        f3643s = ce.class.getSimpleName();
        f3641m = null;
        f3642n = false;
        f3644t = 0;
    }

    protected ce(Context context, String str) {
        super(context);
        this.f3645o = false;
        this.f3647q = false;
        this.f3648r = false;
        this.f3646p = str;
        this.f3645o = false;
    }

    protected ce(Context context, String str, boolean z) {
        super(context);
        this.f3645o = false;
        this.f3647q = false;
        this.f3648r = false;
        this.f3646p = str;
        this.f3645o = z;
    }

    static dd m5455a(dc dcVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        Throwable e;
        Method a = dcVar.m5697a(cu.m5620H(), cu.m5621I());
        if (a == null || motionEvent == null) {
            throw new cy();
        }
        try {
            return new dd((String) a.invoke(null, new Object[]{motionEvent, displayMetrics}));
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new cy(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new cy(e);
        }
    }

    protected static synchronized void m5456a(Context context, boolean z) {
        synchronized (ce.class) {
            if (!f3642n) {
                f3644t = de.m5718a().longValue() / 1000;
                f3641m = m5459b(context, z);
                f3642n = true;
            }
        }
    }

    private static void m5457a(dc dcVar) {
        List singletonList = Collections.singletonList(Context.class);
        dcVar.m5698a(cu.m5639n(), cu.m5640o(), singletonList);
        dcVar.m5698a(cu.m5649x(), cu.m5650y(), singletonList);
        dcVar.m5698a(cu.m5647v(), cu.m5648w(), singletonList);
        dcVar.m5698a(cu.m5633h(), cu.m5634i(), singletonList);
        dcVar.m5698a(cu.m5643r(), cu.m5644s(), singletonList);
        dcVar.m5698a(cu.m5629d(), cu.m5630e(), singletonList);
        dcVar.m5698a(cu.m5622J(), cu.m5623K(), singletonList);
        singletonList = Arrays.asList(new Class[]{MotionEvent.class, DisplayMetrics.class});
        dcVar.m5698a(cu.m5620H(), cu.m5621I(), singletonList);
        dcVar.m5698a(cu.m5618F(), cu.m5619G(), singletonList);
        dcVar.m5698a(cu.m5637l(), cu.m5638m(), Collections.emptyList());
        dcVar.m5698a(cu.m5616D(), cu.m5617E(), Collections.emptyList());
        dcVar.m5698a(cu.m5645t(), cu.m5646u(), Collections.emptyList());
        dcVar.m5698a(cu.m5635j(), cu.m5636k(), Collections.emptyList());
        dcVar.m5698a(cu.m5641p(), cu.m5642q(), Collections.emptyList());
        dcVar.m5698a(cu.m5614B(), cu.m5615C(), Collections.emptyList());
        dcVar.m5698a(cu.m5631f(), cu.m5632g(), Arrays.asList(new Class[]{Context.class, Boolean.TYPE, Boolean.TYPE}));
        dcVar.m5698a(cu.m5651z(), cu.m5613A(), Arrays.asList(new Class[]{StackTraceElement[].class}));
        dcVar.m5698a(cu.m5624L(), cu.m5625M(), Arrays.asList(new Class[]{View.class}));
    }

    private void m5458a(dc dcVar, C1444a c1444a) {
        dd a;
        C1442a c1442a;
        int i = 0;
        try {
            a = m5455a(dcVar, this.a, this.k);
            c1444a.f3418n = a.f3758a;
            c1444a.f3419o = a.f3759b;
            c1444a.f3420p = a.f3760c;
            if (this.j) {
                c1444a.f3382D = a.f3761d;
                c1444a.f3383E = a.f3762e;
            }
            if (((Boolean) C1648if.bA.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue()) {
                c1442a = new C1442a();
                dd b = m5466b(this.a);
                c1442a.f3364a = b.f3758a;
                c1442a.f3365b = b.f3759b;
                c1442a.f3371h = b.f3760c;
                if (this.j) {
                    c1442a.f3366c = b.f3762e;
                    c1442a.f3368e = b.f3761d;
                    c1442a.f3370g = Integer.valueOf(b.f3763f.longValue() != 0 ? 1 : 0);
                    if (this.d > 0) {
                        c1442a.f3367d = this.k != null ? Long.valueOf(Math.round(((double) this.i) / ((double) this.d))) : null;
                        c1442a.f3369f = Long.valueOf(Math.round(((double) this.h) / ((double) this.d)));
                    }
                    c1442a.f3373j = b.f3766i;
                    c1442a.f3372i = b.f3767j;
                    c1442a.f3374k = Integer.valueOf(b.f3768k.longValue() != 0 ? 1 : 0);
                    if (this.g > 0) {
                        c1442a.f3375l = Long.valueOf(this.g);
                    }
                }
                c1444a.f3401W = c1442a;
            }
        } catch (cy e) {
        }
        if (this.c > 0) {
            c1444a.f3387I = Long.valueOf(this.c);
        }
        if (this.d > 0) {
            c1444a.f3386H = Long.valueOf(this.d);
        }
        if (this.e > 0) {
            c1444a.f3385G = Long.valueOf(this.e);
        }
        if (this.f > 0) {
            c1444a.f3388J = Long.valueOf(this.f);
        }
        try {
            int size = this.b.size() - 1;
            if (size > 0) {
                c1444a.f3402X = new C1442a[size];
                while (i < size) {
                    a = m5455a(dcVar, (MotionEvent) this.b.get(i), this.k);
                    c1442a = new C1442a();
                    c1442a.f3364a = a.f3758a;
                    c1442a.f3365b = a.f3759b;
                    c1444a.f3402X[i] = c1442a;
                    i++;
                }
            }
        } catch (cy e2) {
            c1444a.f3402X = null;
        }
    }

    protected static dc m5459b(Context context, boolean z) {
        if (f3641m == null) {
            synchronized (f3640l) {
                if (f3641m == null) {
                    dc a = dc.m5679a(context, cu.m5626a(), cu.m5628c(), z);
                    m5457a(a);
                    f3641m = a;
                }
            }
        }
        return f3641m;
    }

    protected long m5460a(StackTraceElement[] stackTraceElementArr) {
        Throwable e;
        Method a = f3641m.m5697a(cu.m5651z(), cu.m5613A());
        if (a == null || stackTraceElementArr == null) {
            throw new cy();
        }
        try {
            return new da((String) a.invoke(null, new Object[]{stackTraceElementArr})).f3728a.longValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new cy(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new cy(e);
        }
    }

    protected C1444a m5461a(Context context, View view) {
        C1444a c1444a = new C1444a();
        if (!TextUtils.isEmpty(this.f3646p)) {
            c1444a.f3406b = this.f3646p;
        }
        dc b = m5459b(context, this.f3645o);
        b.m5713p();
        m5468b(b, c1444a, view);
        b.m5714q();
        return c1444a;
    }

    protected C1444a m5462a(Context context, C1438a c1438a) {
        C1444a c1444a = new C1444a();
        if (!TextUtils.isEmpty(this.f3646p)) {
            c1444a.f3406b = this.f3646p;
        }
        dc b = m5459b(context, this.f3645o);
        b.m5713p();
        m5464a(b, c1444a, c1438a);
        b.m5714q();
        return c1444a;
    }

    protected List<Callable<Void>> m5463a(dc dcVar, C1444a c1444a, View view) {
        ArrayList arrayList = new ArrayList();
        if (dcVar.m5700c() == null) {
            return arrayList;
        }
        int r = dcVar.m5715r();
        arrayList.add(new dp(dcVar, c1444a));
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new ds(dcVar, cu.m5645t(), cu.m5646u(), c1444a, r, 1));
        arrayList2 = arrayList;
        arrayList2.add(new dn(dcVar, cu.m5637l(), cu.m5638m(), c1444a, f3644t, r, 25));
        arrayList2 = arrayList;
        arrayList2.add(new dm(dcVar, cu.m5635j(), cu.m5636k(), c1444a, r, 44));
        arrayList2 = arrayList;
        arrayList2.add(new dg(dcVar, cu.m5629d(), cu.m5630e(), c1444a, r, 3));
        arrayList2 = arrayList;
        arrayList2.add(new dq(dcVar, cu.m5641p(), cu.m5642q(), c1444a, r, 22));
        if (((Boolean) C1648if.bG.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new dl(dcVar, cu.m5633h(), cu.m5634i(), c1444a, r, 5));
        }
        if (((Boolean) C1648if.bz.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new em(dcVar, cu.m5622J(), cu.m5623K(), c1444a, r, 48));
        }
        if (((Boolean) C1648if.bE.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new dv(dcVar, cu.m5614B(), cu.m5615C(), c1444a, r, 51));
        }
        if (((Boolean) C1648if.bJ.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new du(dcVar, cu.m5651z(), cu.m5613A(), c1444a, r, 45, new Throwable().getStackTrace()));
        }
        if (((Boolean) C1648if.bK.m6682c()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new ep(dcVar, cu.m5624L(), cu.m5625M(), c1444a, r, 57, view));
        }
        return arrayList;
    }

    protected void m5464a(dc dcVar, C1444a c1444a, C1438a c1438a) {
        if (dcVar.m5700c() != null) {
            m5465a(m5467b(dcVar, c1444a, c1438a));
        }
    }

    protected void m5465a(List<Callable<Void>> list) {
        if (f3641m != null) {
            ExecutorService c = f3641m.m5700c();
            if (c != null && !list.isEmpty()) {
                try {
                    c.invokeAll(list, ((Long) C1648if.bq.m6682c()).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable e) {
                    Log.d(f3643s, String.format("class methods got exception: %s", new Object[]{de.m5720a(e)}));
                }
            }
        }
    }

    protected dd m5466b(MotionEvent motionEvent) {
        Throwable e;
        Method a = f3641m.m5697a(cu.m5618F(), cu.m5619G());
        if (a == null || motionEvent == null) {
            throw new cy();
        }
        try {
            return new dd((String) a.invoke(null, new Object[]{motionEvent, this.k}));
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new cy(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new cy(e);
        }
    }

    protected List<Callable<Void>> m5467b(dc dcVar, C1444a c1444a, C1438a c1438a) {
        int r = dcVar.m5715r();
        List arrayList = new ArrayList();
        String f = cu.m5631f();
        String g = cu.m5632g();
        boolean z = ((Boolean) C1648if.bu.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue();
        arrayList.add(new dj(dcVar, f, g, c1444a, r, 27, z, c1438a));
        arrayList.add(new dn(dcVar, cu.m5637l(), cu.m5638m(), c1444a, f3644t, r, 25));
        arrayList.add(new ds(dcVar, cu.m5645t(), cu.m5646u(), c1444a, r, 1));
        arrayList.add(new dt(dcVar, cu.m5647v(), cu.m5648w(), c1444a, r, 31));
        arrayList.add(new dx(dcVar, cu.m5616D(), cu.m5617E(), c1444a, r, 33));
        arrayList.add(new di(dcVar, cu.m5649x(), cu.m5650y(), c1444a, r, 29));
        arrayList.add(new dl(dcVar, cu.m5633h(), cu.m5634i(), c1444a, r, 5));
        arrayList.add(new dr(dcVar, cu.m5643r(), cu.m5644s(), c1444a, r, 12));
        arrayList.add(new dg(dcVar, cu.m5629d(), cu.m5630e(), c1444a, r, 3));
        arrayList.add(new dm(dcVar, cu.m5635j(), cu.m5636k(), c1444a, r, 44));
        arrayList.add(new dq(dcVar, cu.m5641p(), cu.m5642q(), c1444a, r, 22));
        if (((Boolean) C1648if.bx.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue()) {
            arrayList.add(new em(dcVar, cu.m5622J(), cu.m5623K(), c1444a, r, 48));
        }
        if (((Boolean) C1648if.bC.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue()) {
            arrayList.add(new dv(dcVar, cu.m5614B(), cu.m5615C(), c1444a, r, 51));
        }
        return arrayList;
    }

    protected void m5468b(dc dcVar, C1444a c1444a, View view) {
        m5458a(dcVar, c1444a);
        m5465a(m5463a(dcVar, c1444a, view));
    }
}
