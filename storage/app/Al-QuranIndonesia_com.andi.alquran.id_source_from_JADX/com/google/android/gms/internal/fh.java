package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzv;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(14)
@op
public class fh implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long f4010c;
    BroadcastReceiver f4011a;
    WeakReference<View> f4012b;
    private final Context f4013d;
    private Application f4014e;
    private final WindowManager f4015f;
    private final PowerManager f4016g;
    private final KeyguardManager f4017h;
    private WeakReference<ViewTreeObserver> f4018i;
    private fi f4019j;
    private sb f4020k;
    private boolean f4021l;
    private int f4022m;
    private HashSet<C1563b> f4023n;
    private DisplayMetrics f4024o;

    /* renamed from: com.google.android.gms.internal.fh.1 */
    class C15601 implements Runnable {
        final /* synthetic */ fh f3995a;

        C15601(fh fhVar) {
            this.f3995a = fhVar;
        }

        public void run() {
            this.f3995a.m6141a(3);
        }
    }

    /* renamed from: com.google.android.gms.internal.fh.2 */
    class C15612 extends BroadcastReceiver {
        final /* synthetic */ fh f3996a;

        C15612(fh fhVar) {
            this.f3996a = fhVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.f3996a.m6141a(3);
        }
    }

    /* renamed from: com.google.android.gms.internal.fh.a */
    public static class C1562a {
        public final long f3997a;
        public final boolean f3998b;
        public final boolean f3999c;
        public final int f4000d;
        public final Rect f4001e;
        public final Rect f4002f;
        public final Rect f4003g;
        public final boolean f4004h;
        public final Rect f4005i;
        public final boolean f4006j;
        public final Rect f4007k;
        public final float f4008l;
        public final boolean f4009m;

        public C1562a(long j, boolean z, boolean z2, int i, Rect rect, Rect rect2, Rect rect3, boolean z3, Rect rect4, boolean z4, Rect rect5, float f, boolean z5) {
            this.f3997a = j;
            this.f3998b = z;
            this.f3999c = z2;
            this.f4000d = i;
            this.f4001e = rect;
            this.f4002f = rect2;
            this.f4003g = rect3;
            this.f4004h = z3;
            this.f4005i = rect4;
            this.f4006j = z4;
            this.f4007k = rect5;
            this.f4008l = f;
            this.f4009m = z5;
        }
    }

    /* renamed from: com.google.android.gms.internal.fh.b */
    public interface C1563b {
        void m6139a(C1562a c1562a);
    }

    static {
        f4010c = ((Long) C1648if.aY.m6682c()).longValue();
    }

    public fh(Context context, View view) {
        this.f4020k = new sb(f4010c);
        this.f4021l = false;
        this.f4022m = -1;
        this.f4023n = new HashSet();
        this.f4013d = context.getApplicationContext();
        this.f4015f = (WindowManager) context.getSystemService("window");
        this.f4016g = (PowerManager) this.f4013d.getSystemService("power");
        this.f4017h = (KeyguardManager) context.getSystemService("keyguard");
        if (this.f4013d instanceof Application) {
            this.f4014e = (Application) this.f4013d;
            this.f4019j = new fi((Application) this.f4013d, this);
        }
        this.f4024o = context.getResources().getDisplayMetrics();
        m6150a(view);
    }

    private void m6140a() {
        zzv.zzcJ();
        rq.f5755a.post(new C15601(this));
    }

    private void m6141a(int i) {
        if (this.f4023n.size() != 0 && this.f4012b != null) {
            View view = (View) this.f4012b.get();
            Object obj = i == 1 ? 1 : null;
            Object obj2 = view == null ? 1 : null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            boolean z = false;
            Rect rect3 = new Rect();
            boolean z2 = false;
            Rect rect4 = new Rect();
            Rect rect5 = new Rect();
            rect5.right = this.f4015f.getDefaultDisplay().getWidth();
            rect5.bottom = this.f4015f.getDefaultDisplay().getHeight();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                z = view.getGlobalVisibleRect(rect2);
                z2 = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Throwable e) {
                    sg.m8445b("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
            }
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            if (this.f4022m != -1) {
                windowVisibility = this.f4022m;
            }
            boolean z3 = obj2 == null && zzv.zzcJ().m8526a(view, this.f4016g, this.f4017h) && z && z2 && windowVisibility == 0;
            if (obj != null && !this.f4020k.m8677a() && z3 == this.f4021l) {
                return;
            }
            if (z3 || this.f4021l || i != 1) {
                C1562a c1562a = new C1562a(zzv.zzcP().m4927b(), this.f4016g.isScreenOn(), view != null ? zzv.zzcL().m8571a(view) : false, view != null ? view.getWindowVisibility() : 8, m6149a(rect5), m6149a(rect), m6149a(rect2), z, m6149a(rect3), z2, m6149a(rect4), this.f4024o.density, z3);
                Iterator it = this.f4023n.iterator();
                while (it.hasNext()) {
                    ((C1563b) it.next()).m6139a(c1562a);
                }
                this.f4021l = z3;
            }
        }
    }

    private void m6142a(Activity activity, int i) {
        if (this.f4012b != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.f4012b.get();
                if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                    this.f4022m = i;
                }
            }
        }
    }

    private int m6144b(int i) {
        return (int) (((float) i) / this.f4024o.density);
    }

    private void m6145b() {
        if (this.f4011a == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f4011a = new C15612(this);
            this.f4013d.registerReceiver(this.f4011a, intentFilter);
        }
    }

    private void m6146b(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f4018i = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        m6145b();
        if (this.f4014e != null) {
            try {
                this.f4014e.registerActivityLifecycleCallbacks(this.f4019j);
            } catch (Throwable e) {
                sg.m8445b("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private void m6147c() {
        if (this.f4011a != null) {
            try {
                this.f4013d.unregisterReceiver(this.f4011a);
            } catch (Throwable e) {
                sg.m8445b("Failed trying to unregister the receiver", e);
            } catch (Throwable e2) {
                zzv.zzcN().m8399a(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.f4011a = null;
        }
    }

    private void m6148c(View view) {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.f4018i != null) {
                viewTreeObserver = (ViewTreeObserver) this.f4018i.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f4018i = null;
            }
        } catch (Throwable e) {
            sg.m8445b("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this);
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        } catch (Throwable e2) {
            sg.m8445b("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        m6147c();
        if (this.f4014e != null) {
            try {
                this.f4014e.unregisterActivityLifecycleCallbacks(this.f4019j);
            } catch (Throwable e22) {
                sg.m8445b("Error registering activity lifecycle callbacks.", e22);
            }
        }
    }

    Rect m6149a(Rect rect) {
        return new Rect(m6144b(rect.left), m6144b(rect.top), m6144b(rect.right), m6144b(rect.bottom));
    }

    public void m6150a(View view) {
        View view2 = this.f4012b != null ? (View) this.f4012b.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m6148c(view2);
        }
        this.f4012b = new WeakReference(view);
        if (view != null) {
            if (zzv.zzcL().m8571a(view)) {
                m6146b(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public void m6151a(C1563b c1563b) {
        this.f4023n.add(c1563b);
        m6141a(3);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        m6142a(activity, 0);
        m6141a(3);
        m6140a();
    }

    public void onActivityDestroyed(Activity activity) {
        m6141a(3);
        m6140a();
    }

    public void onActivityPaused(Activity activity) {
        m6142a(activity, 4);
        m6141a(3);
        m6140a();
    }

    public void onActivityResumed(Activity activity) {
        m6142a(activity, 0);
        m6141a(3);
        m6140a();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m6141a(3);
        m6140a();
    }

    public void onActivityStarted(Activity activity) {
        m6142a(activity, 0);
        m6141a(3);
        m6140a();
    }

    public void onActivityStopped(Activity activity) {
        m6141a(3);
        m6140a();
    }

    public void onGlobalLayout() {
        m6141a(2);
    }

    public void onScrollChanged() {
        m6141a(1);
    }

    public void onViewAttachedToWindow(View view) {
        this.f4022m = -1;
        m6146b(view);
        m6141a(3);
    }

    public void onViewDetachedFromWindow(View view) {
        this.f4022m = -1;
        m6141a(3);
        m6148c(view);
    }
}
