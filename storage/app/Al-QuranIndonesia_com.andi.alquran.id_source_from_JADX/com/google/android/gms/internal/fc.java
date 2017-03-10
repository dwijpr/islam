package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class fc implements OnGlobalLayoutListener, OnScrollChangedListener {
    protected final Object f3954a;
    protected final fa f3955b;
    BroadcastReceiver f3956c;
    private final WeakReference<rc> f3957d;
    private WeakReference<ViewTreeObserver> f3958e;
    private final fj f3959f;
    private final Context f3960g;
    private final WindowManager f3961h;
    private final PowerManager f3962i;
    private final KeyguardManager f3963j;
    private fd f3964k;
    private boolean f3965l;
    private boolean f3966m;
    private boolean f3967n;
    private boolean f3968o;
    private boolean f3969p;
    private boolean f3970q;
    private final HashSet<Object> f3971r;
    private sb f3972s;
    private final HashSet<fg> f3973t;

    /* renamed from: com.google.android.gms.internal.fc.1 */
    class C15441 extends BroadcastReceiver {
        final /* synthetic */ fc f3947a;

        C15441(fc fcVar) {
            this.f3947a = fcVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.f3947a.m6080a(3);
        }
    }

    /* renamed from: com.google.android.gms.internal.fc.a */
    public static class C1545a implements fj {
        private WeakReference<jd> f3948a;

        public C1545a(jd jdVar) {
            this.f3948a = new WeakReference(jdVar);
        }

        public View m6064a() {
            jd jdVar = (jd) this.f3948a.get();
            return jdVar != null ? jdVar.m6924d() : null;
        }

        public boolean m6065b() {
            return this.f3948a.get() == null;
        }

        public fj m6066c() {
            return new C1546b((jd) this.f3948a.get());
        }
    }

    /* renamed from: com.google.android.gms.internal.fc.b */
    public static class C1546b implements fj {
        private jd f3949a;

        public C1546b(jd jdVar) {
            this.f3949a = jdVar;
        }

        public View m6067a() {
            return this.f3949a != null ? this.f3949a.m6924d() : null;
        }

        public boolean m6068b() {
            return this.f3949a == null;
        }

        public fj m6069c() {
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.fc.c */
    public static class C1547c implements fj {
        private final View f3950a;
        private final rc f3951b;

        public C1547c(View view, rc rcVar) {
            this.f3950a = view;
            this.f3951b = rcVar;
        }

        public View m6070a() {
            return this.f3950a;
        }

        public boolean m6071b() {
            return this.f3951b == null || this.f3950a == null;
        }

        public fj m6072c() {
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.fc.d */
    public static class C1548d implements fj {
        private final WeakReference<View> f3952a;
        private final WeakReference<rc> f3953b;

        public C1548d(View view, rc rcVar) {
            this.f3952a = new WeakReference(view);
            this.f3953b = new WeakReference(rcVar);
        }

        public View m6073a() {
            return (View) this.f3952a.get();
        }

        public boolean m6074b() {
            return this.f3952a.get() == null || this.f3953b.get() == null;
        }

        public fj m6075c() {
            return new C1547c((View) this.f3952a.get(), (rc) this.f3953b.get());
        }
    }

    public fc(Context context, zzec com_google_android_gms_internal_zzec, rc rcVar, zzqa com_google_android_gms_internal_zzqa, fj fjVar) {
        this.f3954a = new Object();
        this.f3966m = false;
        this.f3967n = false;
        this.f3971r = new HashSet();
        this.f3973t = new HashSet();
        this.f3957d = new WeakReference(rcVar);
        this.f3959f = fjVar;
        this.f3958e = new WeakReference(null);
        this.f3968o = true;
        this.f3970q = false;
        this.f3972s = new sb(200);
        this.f3955b = new fa(UUID.randomUUID().toString(), com_google_android_gms_internal_zzqa, com_google_android_gms_internal_zzec.f6452b, rcVar.f5620j, rcVar.m8364a(), com_google_android_gms_internal_zzec.f6459i);
        this.f3961h = (WindowManager) context.getSystemService("window");
        this.f3962i = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.f3963j = (KeyguardManager) context.getSystemService("keyguard");
        this.f3960g = context;
    }

    protected int m6076a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected JSONObject m6077a(View view) {
        if (view == null) {
            return m6102l();
        }
        boolean a = zzv.zzcL().m8571a(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            sg.m8445b("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.f3961h.getDefaultDisplay().getWidth();
        rect2.bottom = this.f3961h.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject i = m6099i();
        i.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", a).put("viewBox", new JSONObject().put("top", m6076a(rect2.top, displayMetrics)).put("bottom", m6076a(rect2.bottom, displayMetrics)).put("left", m6076a(rect2.left, displayMetrics)).put("right", m6076a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m6076a(rect.top, displayMetrics)).put("bottom", m6076a(rect.bottom, displayMetrics)).put("left", m6076a(rect.left, displayMetrics)).put("right", m6076a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m6076a(rect3.top, displayMetrics)).put("bottom", m6076a(rect3.bottom, displayMetrics)).put("left", m6076a(rect3.left, displayMetrics)).put("right", m6076a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", m6076a(rect4.top, displayMetrics)).put("bottom", m6076a(rect4.bottom, displayMetrics)).put("left", m6076a(rect4.left, displayMetrics)).put("right", m6076a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", m6076a(rect5.top, displayMetrics)).put("bottom", m6076a(rect5.bottom, displayMetrics)).put("left", m6076a(rect5.left, displayMetrics)).put("right", m6076a(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zzv.zzcJ().m8526a(view, this.f3962i, this.f3963j));
        return i;
    }

    JSONObject m6078a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    protected void m6079a() {
        synchronized (this.f3954a) {
            if (this.f3956c != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f3956c = new C15441(this);
            this.f3960g.registerReceiver(this.f3956c, intentFilter);
        }
    }

    protected void m6080a(int i) {
        Object obj = null;
        synchronized (this.f3954a) {
            if (m6101k() && this.f3968o) {
                View a = this.f3959f.m6061a();
                boolean z = a != null && zzv.zzcJ().m8526a(a, this.f3962i, this.f3963j) && a.getGlobalVisibleRect(new Rect(), null);
                if (this.f3959f.m6062b()) {
                    m6094d();
                    return;
                }
                if (i == 1) {
                    obj = 1;
                }
                if (obj != null) {
                    if (!this.f3972s.m8677a() && z == this.f3970q) {
                        return;
                    }
                }
                if (z || this.f3970q || i != 1) {
                    try {
                        m6086a(m6077a(a), false);
                        this.f3970q = z;
                    } catch (JSONException e) {
                        Throwable e2 = e;
                        sg.m8442a("Active view update failed.", e2);
                        m6097g();
                        m6095e();
                        return;
                    } catch (RuntimeException e3) {
                        e2 = e3;
                        sg.m8442a("Active view update failed.", e2);
                        m6097g();
                        m6095e();
                        return;
                    }
                    m6097g();
                    m6095e();
                    return;
                }
                return;
            }
        }
    }

    protected void m6081a(View view, Map<String, String> map) {
        m6080a(3);
    }

    public void m6082a(fd fdVar) {
        synchronized (this.f3954a) {
            this.f3964k = fdVar;
        }
    }

    public void m6083a(fg fgVar) {
        if (this.f3973t.isEmpty()) {
            m6079a();
            m6080a(3);
        }
        this.f3973t.add(fgVar);
        try {
            fgVar.m6112a(m6078a(m6077a(this.f3959f.m6061a())), false);
        } catch (Throwable e) {
            sg.m8445b("Skipping measurement update for new client.", e);
        }
    }

    void m6084a(fg fgVar, Map<String, String> map) {
        String str = "Received request to untrack: ";
        String valueOf = String.valueOf(this.f3955b.m6046d());
        sg.m8444b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        m6090b(fgVar);
    }

    void m6085a(sx sxVar, Map<String, String> map) {
        m6081a(sxVar.m8760b(), (Map) map);
    }

    protected void m6086a(JSONObject jSONObject, boolean z) {
        try {
            m6092b(m6078a(jSONObject), z);
        } catch (Throwable th) {
            sg.m8445b("Skipping active view message.", th);
        }
    }

    protected void m6087a(boolean z) {
        Iterator it = this.f3971r.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    boolean m6088a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.f3955b.m6046d());
        return z;
    }

    protected void m6089b() {
        synchronized (this.f3954a) {
            if (this.f3956c != null) {
                try {
                    this.f3960g.unregisterReceiver(this.f3956c);
                } catch (Throwable e) {
                    sg.m8445b("Failed trying to unregister the receiver", e);
                } catch (Throwable e2) {
                    zzv.zzcN().m8399a(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                }
                this.f3956c = null;
            }
        }
    }

    public void m6090b(fg fgVar) {
        this.f3973t.remove(fgVar);
        fgVar.m6114b();
        if (this.f3973t.isEmpty()) {
            m6093c();
        }
    }

    void m6091b(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
            m6087a(z);
        }
    }

    protected void m6092b(JSONObject jSONObject, boolean z) {
        Iterator it = new ArrayList(this.f3973t).iterator();
        while (it.hasNext()) {
            ((fg) it.next()).m6112a(jSONObject, z);
        }
    }

    protected void m6093c() {
        synchronized (this.f3954a) {
            m6098h();
            m6089b();
            this.f3968o = false;
            m6095e();
            m6100j();
        }
    }

    public void m6094d() {
        synchronized (this.f3954a) {
            if (this.f3968o) {
                this.f3969p = true;
                try {
                    m6086a(m6104n(), true);
                } catch (Throwable e) {
                    sg.m8445b("JSON failure while processing active view data.", e);
                } catch (Throwable e2) {
                    sg.m8445b("Failure while processing active view data.", e2);
                }
                String str = "Untracking ad unit: ";
                String valueOf = String.valueOf(this.f3955b.m6046d());
                sg.m8444b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
    }

    protected void m6095e() {
        if (this.f3964k != null) {
            this.f3964k.m6049a(this);
        }
    }

    public boolean m6096f() {
        boolean z;
        synchronized (this.f3954a) {
            z = this.f3968o;
        }
        return z;
    }

    protected void m6097g() {
        View a = this.f3959f.m6063c().m6061a();
        if (a != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f3958e.get();
            ViewTreeObserver viewTreeObserver2 = a.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                m6098h();
                if (!this.f3965l || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                    this.f3965l = true;
                    viewTreeObserver2.addOnScrollChangedListener(this);
                    viewTreeObserver2.addOnGlobalLayoutListener(this);
                }
                this.f3958e = new WeakReference(viewTreeObserver2);
            }
        }
    }

    protected void m6098h() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f3958e.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject m6099i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f3955b.m6044b()).put("activeViewJSON", this.f3955b.m6045c()).put("timestamp", zzv.zzcP().m4927b()).put("adFormat", this.f3955b.m6043a()).put("hashCode", this.f3955b.m6046d()).put("isMraid", this.f3955b.m6047e()).put("isStopped", this.f3967n).put("isPaused", this.f3966m).put("isScreenOn", m6103m()).put("isNative", this.f3955b.m6048f()).put("appMuted", zzv.zzcJ().m8552h()).put("appVolume", (double) zzv.zzcJ().m8549g()).put("deviceVolume", (double) zzv.zzcJ().m8555j(this.f3960g));
        return jSONObject;
    }

    protected void m6100j() {
        Iterator it = new ArrayList(this.f3973t).iterator();
        while (it.hasNext()) {
            m6090b((fg) it.next());
        }
    }

    protected boolean m6101k() {
        Iterator it = this.f3973t.iterator();
        while (it.hasNext()) {
            if (((fg) it.next()).m6113a()) {
                return true;
            }
        }
        return false;
    }

    protected JSONObject m6102l() {
        return m6099i().put("isAttachedToWindow", false).put("isScreenOn", m6103m()).put("isVisible", false);
    }

    boolean m6103m() {
        return this.f3962i.isScreenOn();
    }

    protected JSONObject m6104n() {
        JSONObject i = m6099i();
        i.put("doneReasonCode", "u");
        return i;
    }

    public void m6105o() {
        synchronized (this.f3954a) {
            this.f3967n = true;
            m6080a(3);
        }
    }

    public void onGlobalLayout() {
        m6080a(2);
    }

    public void onScrollChanged() {
        m6080a(1);
    }

    public void m6106p() {
        synchronized (this.f3954a) {
            this.f3966m = true;
            m6080a(3);
        }
    }

    public void m6107q() {
        synchronized (this.f3954a) {
            this.f3966m = false;
            m6080a(3);
        }
    }

    public fa m6108r() {
        return this.f3955b;
    }
}
