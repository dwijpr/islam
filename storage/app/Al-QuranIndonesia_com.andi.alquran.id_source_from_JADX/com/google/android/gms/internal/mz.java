package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.my.C1827a;
import java.util.Map;

@op
public class mz extends na implements kg {
    DisplayMetrics f5055a;
    int f5056b;
    int f5057c;
    int f5058d;
    int f5059e;
    int f5060f;
    int f5061g;
    private final sx f5062h;
    private final Context f5063i;
    private final WindowManager f5064j;
    private final hx f5065k;
    private float f5066l;
    private int f5067m;

    public mz(sx sxVar, Context context, hx hxVar) {
        super(sxVar);
        this.f5056b = -1;
        this.f5057c = -1;
        this.f5058d = -1;
        this.f5059e = -1;
        this.f5060f = -1;
        this.f5061g = -1;
        this.f5062h = sxVar;
        this.f5063i = context;
        this.f5065k = hxVar;
        this.f5064j = (WindowManager) context.getSystemService("window");
    }

    private void m7727g() {
        this.f5055a = new DisplayMetrics();
        Display defaultDisplay = this.f5064j.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f5055a);
        this.f5066l = this.f5055a.density;
        this.f5067m = defaultDisplay.getRotation();
    }

    private void m7728h() {
        int[] iArr = new int[2];
        this.f5062h.getLocationOnScreen(iArr);
        m7731a(gr.m6416a().m8702b(this.f5063i, iArr[0]), gr.m6416a().m8702b(this.f5063i, iArr[1]));
    }

    private my m7729i() {
        return new C1827a().m7722b(this.f5065k.m6643a()).m7720a(this.f5065k.m6645b()).m7723c(this.f5065k.m6647e()).m7724d(this.f5065k.m6646c()).m7725e(true).m7721a();
    }

    void m7730a() {
        this.f5056b = gr.m6416a().m8703b(this.f5055a, this.f5055a.widthPixels);
        this.f5057c = gr.m6416a().m8703b(this.f5055a, this.f5055a.heightPixels);
        Activity f = this.f5062h.m8770f();
        if (f == null || f.getWindow() == null) {
            this.f5058d = this.f5056b;
            this.f5059e = this.f5057c;
            return;
        }
        int[] a = zzv.zzcJ().m8528a(f);
        this.f5058d = gr.m6416a().m8703b(this.f5055a, a[0]);
        this.f5059e = gr.m6416a().m8703b(this.f5055a, a[1]);
    }

    public void m7731a(int i, int i2) {
        int i3 = this.f5063i instanceof Activity ? zzv.zzcJ().m8544d((Activity) this.f5063i)[0] : 0;
        if (this.f5062h.m8775k() == null || !this.f5062h.m8775k().f6455e) {
            this.f5060f = gr.m6416a().m8702b(this.f5063i, this.f5062h.getMeasuredWidth());
            this.f5061g = gr.m6416a().m8702b(this.f5063i, this.f5062h.getMeasuredHeight());
        }
        m7689b(i, i2 - i3, this.f5060f, this.f5061g);
        this.f5062h.m8776l().m8798a(i, i2);
    }

    public void m7732a(sx sxVar, Map<String, String> map) {
        m7734c();
    }

    void m7733b() {
        if (this.f5062h.m8775k().f6455e) {
            this.f5060f = this.f5056b;
            this.f5061g = this.f5057c;
            return;
        }
        this.f5062h.measure(0, 0);
    }

    public void m7734c() {
        m7727g();
        m7730a();
        m7733b();
        m7736e();
        m7737f();
        m7728h();
        m7735d();
    }

    void m7735d() {
        if (sg.m8443a(2)) {
            sg.m8448d("Dispatching Ready Event.");
        }
        m7691c(this.f5062h.m8779o().f6636b);
    }

    void m7736e() {
        m7688a(this.f5056b, this.f5057c, this.f5058d, this.f5059e, this.f5066l, this.f5067m);
    }

    void m7737f() {
        this.f5062h.m7291b("onDeviceFeaturesReceived", m7729i().m7726a());
    }
}
