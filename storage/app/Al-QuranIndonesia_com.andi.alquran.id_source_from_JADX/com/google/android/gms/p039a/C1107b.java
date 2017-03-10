package com.google.android.gms.p039a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.C1262a;
import com.google.android.gms.common.internal.C1339l;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.a.b */
public abstract class C1107b<T extends C1097a> {
    private T f2297a;
    private Bundle f2298b;
    private LinkedList<C1100a> f2299c;
    private final C1098e<T> f2300d;

    /* renamed from: com.google.android.gms.a.b.1 */
    class C10991 implements C1098e<T> {
        final /* synthetic */ C1107b f2281a;

        C10991(C1107b c1107b) {
            this.f2281a = c1107b;
        }

        public void m3860a(T t) {
            this.f2281a.f2297a = t;
            Iterator it = this.f2281a.f2299c.iterator();
            while (it.hasNext()) {
                ((C1100a) it.next()).m3862a(this.f2281a.f2297a);
            }
            this.f2281a.f2299c.clear();
            this.f2281a.f2298b = null;
        }
    }

    /* renamed from: com.google.android.gms.a.b.a */
    private interface C1100a {
        int m3861a();

        void m3862a(C1097a c1097a);
    }

    /* renamed from: com.google.android.gms.a.b.2 */
    class C11012 implements C1100a {
        final /* synthetic */ Activity f2282a;
        final /* synthetic */ Bundle f2283b;
        final /* synthetic */ Bundle f2284c;
        final /* synthetic */ C1107b f2285d;

        C11012(C1107b c1107b, Activity activity, Bundle bundle, Bundle bundle2) {
            this.f2285d = c1107b;
            this.f2282a = activity;
            this.f2283b = bundle;
            this.f2284c = bundle2;
        }

        public int m3863a() {
            return 0;
        }

        public void m3864a(C1097a c1097a) {
            this.f2285d.f2297a.m3850a(this.f2282a, this.f2283b, this.f2284c);
        }
    }

    /* renamed from: com.google.android.gms.a.b.3 */
    class C11023 implements C1100a {
        final /* synthetic */ Bundle f2286a;
        final /* synthetic */ C1107b f2287b;

        C11023(C1107b c1107b, Bundle bundle) {
            this.f2287b = c1107b;
            this.f2286a = bundle;
        }

        public int m3865a() {
            return 1;
        }

        public void m3866a(C1097a c1097a) {
            this.f2287b.f2297a.m3851a(this.f2286a);
        }
    }

    /* renamed from: com.google.android.gms.a.b.4 */
    class C11034 implements C1100a {
        final /* synthetic */ FrameLayout f2288a;
        final /* synthetic */ LayoutInflater f2289b;
        final /* synthetic */ ViewGroup f2290c;
        final /* synthetic */ Bundle f2291d;
        final /* synthetic */ C1107b f2292e;

        C11034(C1107b c1107b, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f2292e = c1107b;
            this.f2288a = frameLayout;
            this.f2289b = layoutInflater;
            this.f2290c = viewGroup;
            this.f2291d = bundle;
        }

        public int m3867a() {
            return 2;
        }

        public void m3868a(C1097a c1097a) {
            this.f2288a.removeAllViews();
            this.f2288a.addView(this.f2292e.f2297a.m3848a(this.f2289b, this.f2290c, this.f2291d));
        }
    }

    /* renamed from: com.google.android.gms.a.b.5 */
    class C11045 implements OnClickListener {
        final /* synthetic */ Context f2293a;
        final /* synthetic */ Intent f2294b;

        C11045(Context context, Intent intent) {
            this.f2293a = context;
            this.f2294b = intent;
        }

        public void onClick(View view) {
            try {
                this.f2293a.startActivity(this.f2294b);
            } catch (Throwable e) {
                Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.a.b.6 */
    class C11056 implements C1100a {
        final /* synthetic */ C1107b f2295a;

        C11056(C1107b c1107b) {
            this.f2295a = c1107b;
        }

        public int m3869a() {
            return 4;
        }

        public void m3870a(C1097a c1097a) {
            this.f2295a.f2297a.m3849a();
        }
    }

    /* renamed from: com.google.android.gms.a.b.7 */
    class C11067 implements C1100a {
        final /* synthetic */ C1107b f2296a;

        C11067(C1107b c1107b) {
            this.f2296a = c1107b;
        }

        public int m3871a() {
            return 5;
        }

        public void m3872a(C1097a c1097a) {
            this.f2296a.f2297a.m3852b();
        }
    }

    public C1107b() {
        this.f2300d = new C10991(this);
    }

    private void m3876a(int i) {
        while (!this.f2299c.isEmpty() && ((C1100a) this.f2299c.getLast()).m3861a() >= i) {
            this.f2299c.removeLast();
        }
    }

    private void m3877a(Bundle bundle, C1100a c1100a) {
        if (this.f2297a != null) {
            c1100a.m3862a(this.f2297a);
            return;
        }
        if (this.f2299c == null) {
            this.f2299c = new LinkedList();
        }
        this.f2299c.add(c1100a);
        if (bundle != null) {
            if (this.f2298b == null) {
                this.f2298b = (Bundle) bundle.clone();
            } else {
                this.f2298b.putAll(bundle);
            }
        }
        m3886a(this.f2300d);
    }

    static void m3878a(FrameLayout frameLayout, C1262a c1262a) {
        Context context = frameLayout.getContext();
        int a = c1262a.m4472a(context);
        CharSequence c = C1339l.m4746c(context, a);
        CharSequence e = C1339l.m4748e(context, a);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(c);
        linearLayout.addView(textView);
        Intent b = c1262a.m4489b(context, a, null);
        if (b != null) {
            View button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(e);
            linearLayout.addView(button);
            button.setOnClickListener(new C11045(context, b));
        }
    }

    public static void m3880b(FrameLayout frameLayout) {
        C1107b.m3878a(frameLayout, C1262a.m4471a());
    }

    public View m3881a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        m3877a(bundle, new C11034(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f2297a == null) {
            m3885a(frameLayout);
        }
        return frameLayout;
    }

    public T m3882a() {
        return this.f2297a;
    }

    public void m3883a(Activity activity, Bundle bundle, Bundle bundle2) {
        m3877a(bundle2, new C11012(this, activity, bundle, bundle2));
    }

    public void m3884a(Bundle bundle) {
        m3877a(bundle, new C11023(this, bundle));
    }

    protected void m3885a(FrameLayout frameLayout) {
        C1107b.m3880b(frameLayout);
    }

    protected abstract void m3886a(C1098e<T> c1098e);

    public void m3887b() {
        m3877a(null, new C11056(this));
    }

    public void m3888b(Bundle bundle) {
        if (this.f2297a != null) {
            this.f2297a.m3853b(bundle);
        } else if (this.f2298b != null) {
            bundle.putAll(this.f2298b);
        }
    }

    public void m3889c() {
        m3877a(null, new C11067(this));
    }

    public void m3890d() {
        if (this.f2297a != null) {
            this.f2297a.m3854c();
        } else {
            m3876a(5);
        }
    }

    public void m3891e() {
        if (this.f2297a != null) {
            this.f2297a.m3855d();
        } else {
            m3876a(4);
        }
    }

    public void m3892f() {
        if (this.f2297a != null) {
            this.f2297a.m3856e();
        } else {
            m3876a(2);
        }
    }

    public void m3893g() {
        if (this.f2297a != null) {
            this.f2297a.m3857f();
        } else {
            m3876a(1);
        }
    }

    public void m3894h() {
        if (this.f2297a != null) {
            this.f2297a.m3858g();
        }
    }
}
