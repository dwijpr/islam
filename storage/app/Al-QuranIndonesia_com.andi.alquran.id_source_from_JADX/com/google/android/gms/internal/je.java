package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.jh.C1658a;
import com.google.android.gms.internal.og.C1674a;
import com.google.android.gms.internal.sy.C1137a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class je implements jd {
    boolean f4519a;
    private final Object f4520b;
    private final zzr f4521c;
    private final Context f4522d;
    private final JSONObject f4523e;
    private final og f4524f;
    private final C1660a f4525g;
    private final cg f4526h;
    private final zzqa f4527i;
    private sx f4528j;
    private String f4529k;
    private String f4530l;
    private WeakReference<View> f4531m;

    /* renamed from: com.google.android.gms.internal.je.1 */
    class C16751 extends C1674a {
        final /* synthetic */ JSONObject f4538a;

        C16751(je jeVar, JSONObject jSONObject) {
            this.f4538a = jSONObject;
        }

        public void m6967a(lm lmVar) {
            lmVar.m7289a("google.afma.nativeAds.handleClickGmsg", this.f4538a);
        }
    }

    /* renamed from: com.google.android.gms.internal.je.2 */
    class C16762 extends C1674a {
        final /* synthetic */ JSONObject f4539a;

        C16762(je jeVar, JSONObject jSONObject) {
            this.f4539a = jSONObject;
        }

        public void m6968a(lm lmVar) {
            lmVar.m7289a("google.afma.nativeAds.handleImpressionPing", this.f4539a);
        }
    }

    /* renamed from: com.google.android.gms.internal.je.3 */
    class C16833 extends C1674a {
        final /* synthetic */ je f4549a;

        /* renamed from: com.google.android.gms.internal.je.3.1 */
        class C16781 implements kg {
            final /* synthetic */ lm f4542a;
            final /* synthetic */ C16833 f4543b;

            /* renamed from: com.google.android.gms.internal.je.3.1.1 */
            class C16771 implements C1137a {
                final /* synthetic */ Map f4540a;
                final /* synthetic */ C16781 f4541b;

                C16771(C16781 c16781, Map map) {
                    this.f4541b = c16781;
                    this.f4540a = map;
                }

                public void m6969a(sx sxVar, boolean z) {
                    this.f4541b.f4543b.f4549a.f4529k = (String) this.f4540a.get("id");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("messageType", "htmlLoaded");
                        jSONObject.put("id", this.f4541b.f4543b.f4549a.f4529k);
                        this.f4541b.f4542a.m7291b("sendMessageToNativeJs", jSONObject);
                    } catch (Throwable e) {
                        sg.m8445b("Unable to dispatch sendMessageToNativeJs event", e);
                    }
                }
            }

            C16781(C16833 c16833, lm lmVar) {
                this.f4543b = c16833;
                this.f4542a = lmVar;
            }

            public void m6970a(sx sxVar, Map<String, String> map) {
                this.f4543b.f4549a.f4528j.m8776l().m8806a(new C16771(this, map));
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    this.f4543b.f4549a.f4528j.loadData(str, "text/html", "UTF-8");
                } else {
                    this.f4543b.f4549a.f4528j.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.je.3.2 */
        class C16792 implements kg {
            final /* synthetic */ C16833 f4544a;

            C16792(C16833 c16833) {
                this.f4544a = c16833;
            }

            public void m6971a(sx sxVar, Map<String, String> map) {
                this.f4544a.f4549a.f4528j.m8760b().setVisibility(0);
            }
        }

        /* renamed from: com.google.android.gms.internal.je.3.3 */
        class C16803 implements kg {
            final /* synthetic */ C16833 f4545a;

            C16803(C16833 c16833) {
                this.f4545a = c16833;
            }

            public void m6972a(sx sxVar, Map<String, String> map) {
                this.f4545a.f4549a.f4528j.m8760b().setVisibility(8);
            }
        }

        /* renamed from: com.google.android.gms.internal.je.3.4 */
        class C16814 implements kg {
            final /* synthetic */ C16833 f4546a;

            C16814(C16833 c16833) {
                this.f4546a = c16833;
            }

            public void m6973a(sx sxVar, Map<String, String> map) {
                this.f4546a.f4549a.f4528j.m8760b().setVisibility(8);
            }
        }

        /* renamed from: com.google.android.gms.internal.je.3.5 */
        class C16825 implements kg {
            final /* synthetic */ lm f4547a;
            final /* synthetic */ C16833 f4548b;

            C16825(C16833 c16833, lm lmVar) {
                this.f4548b = c16833;
                this.f4547a = lmVar;
            }

            public void m6974a(sx sxVar, Map<String, String> map) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : map.keySet()) {
                        jSONObject.put(str, map.get(str));
                    }
                    jSONObject.put("id", this.f4548b.f4549a.f4529k);
                    this.f4547a.m7291b("sendMessageToNativeJs", jSONObject);
                } catch (Throwable e) {
                    sg.m8445b("Unable to dispatch sendMessageToNativeJs event", e);
                }
            }
        }

        C16833(je jeVar) {
            this.f4549a = jeVar;
        }

        public void m6975a(lm lmVar) {
            lmVar.m7287a("/loadHtml", new C16781(this, lmVar));
            lmVar.m7287a("/showOverlay", new C16792(this));
            lmVar.m7287a("/hideOverlay", new C16803(this));
            this.f4549a.f4528j.m8776l().m8810a("/hideOverlay", new C16814(this));
            this.f4549a.f4528j.m8776l().m8810a("/sendMessageToSdk", new C16825(this, lmVar));
        }
    }

    public je(Context context, zzr com_google_android_gms_ads_internal_zzr, og ogVar, cg cgVar, JSONObject jSONObject, C1660a c1660a, zzqa com_google_android_gms_internal_zzqa, String str) {
        this.f4520b = new Object();
        this.f4531m = null;
        this.f4522d = context;
        this.f4521c = com_google_android_gms_ads_internal_zzr;
        this.f4524f = ogVar;
        this.f4526h = cgVar;
        this.f4523e = jSONObject;
        this.f4525g = c1660a;
        this.f4527i = com_google_android_gms_internal_zzqa;
        this.f4530l = str;
    }

    private JSONObject m6928a(Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", m6934a(rect.left));
        jSONObject.put("y", m6934a(rect.top));
        jSONObject.put("width", m6934a(rect.right - rect.left));
        jSONObject.put("height", m6934a(rect.bottom - rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private JSONObject m6929a(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        try {
            int[] b = m6946b(view);
            for (Entry entry : map.entrySet()) {
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] b2 = m6946b(view2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("width", m6934a(m6947c(view2)));
                    jSONObject2.put("height", m6934a(m6950d(view2)));
                    jSONObject2.put("x", m6934a(b2[0] - b[0]));
                    jSONObject2.put("y", m6934a(b2[1] - b[1]));
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                }
            }
        } catch (JSONException e) {
            sg.m8449e("Unable to get all view rectangles");
        }
        return jSONObject;
    }

    private JSONObject m6931b(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        int[] b = m6946b(view);
        for (Entry entry : map.entrySet()) {
            View view2 = (View) ((WeakReference) entry.getValue()).get();
            if (view2 != null) {
                int[] b2 = m6946b(view2);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    Object a;
                    jSONObject3.put("width", m6934a(m6947c(view2)));
                    jSONObject3.put("height", m6934a(m6950d(view2)));
                    jSONObject3.put("x", m6934a(b2[0] - b[0]));
                    jSONObject3.put("y", m6934a(b2[1] - b[1]));
                    jSONObject3.put("relative_to", "ad_view");
                    jSONObject2.put("frame", jSONObject3);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        a = m6928a(rect);
                    } else {
                        a = new JSONObject();
                        a.put("x", m6934a(b2[0] - b[0]));
                        a.put("y", m6934a(b2[1] - b[1]));
                        a.put("width", 0);
                        a.put("height", 0);
                        a.put("relative_to", "ad_view");
                    }
                    jSONObject2.put("visible_bounds", a);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject2.put("text_color", textView.getCurrentTextColor());
                        jSONObject2.put("font_size", (double) textView.getTextSize());
                        jSONObject2.put("text", textView.getText());
                    }
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                } catch (JSONException e) {
                    sg.m8449e("Unable to get asset views information");
                }
            }
        }
        return jSONObject;
    }

    private JSONObject m6932e(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                jSONObject.put("width", m6934a(m6947c(view)));
                jSONObject.put("height", m6934a(m6950d(view)));
            } catch (Exception e) {
                sg.m8449e("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    private JSONObject m6933f(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                Object a;
                int[] b = m6946b(view);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", m6934a(m6947c(view)));
                jSONObject2.put("height", m6934a(m6950d(view)));
                jSONObject2.put("x", m6934a(b[0]));
                jSONObject2.put("y", m6934a(b[1]));
                jSONObject2.put("relative_to", "window");
                jSONObject.put("frame", jSONObject2);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    a = m6928a(rect);
                } else {
                    a = new JSONObject();
                    a.put("x", m6934a(b[0]));
                    a.put("y", m6934a(b[1]));
                    a.put("width", 0);
                    a.put("height", 0);
                    a.put("relative_to", "window");
                }
                jSONObject.put("visible_bounds", a);
            } catch (Exception e) {
                sg.m8449e("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    int m6934a(int i) {
        return gr.m6416a().m8702b(this.f4522d, i);
    }

    public iw m6935a(OnClickListener onClickListener) {
        iv m = this.f4525g.m6807m();
        if (m == null) {
            return null;
        }
        iw iwVar = new iw(this.f4522d, m);
        iwVar.setLayoutParams(new LayoutParams(-1, -1));
        iwVar.m6783a().setOnClickListener(onClickListener);
        iwVar.m6783a().setContentDescription((CharSequence) C1648if.ck.m6682c());
        return iwVar;
    }

    jh m6936a(Object obj) {
        return obj instanceof IBinder ? C1658a.m6787a((IBinder) obj) : null;
    }

    public void m6937a(MotionEvent motionEvent) {
        this.f4526h.m5532a(motionEvent);
    }

    public void m6938a(View view) {
        this.f4531m = new WeakReference(view);
    }

    public void m6939a(View view, jb jbVar) {
        if (this.f4525g instanceof iy) {
            iy iyVar = (iy) this.f4525g;
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            if (iyVar.m6823o() != null) {
                ((FrameLayout) view).addView(iyVar.m6823o(), layoutParams);
                this.f4521c.zza(jbVar);
            } else if (iyVar.m6810b() != null && iyVar.m6810b().size() > 0) {
                jh a = m6936a(iyVar.m6810b().get(0));
                if (a != null) {
                    try {
                        C1108c a2 = a.m6784a();
                        if (a2 != null) {
                            Drawable drawable = (Drawable) C1111d.m3897a(a2);
                            View h = m6955h();
                            h.setImageDrawable(drawable);
                            h.setScaleType(ScaleType.CENTER_INSIDE);
                            ((FrameLayout) view).addView(h, layoutParams);
                        }
                    } catch (RemoteException e) {
                        sg.m8449e("Could not get drawable from image");
                    }
                }
            }
        }
    }

    public void m6940a(View view, String str, JSONObject jSONObject, Map<String, WeakReference<View>> map, View view2) {
        C1314c.m4631b("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("asset", str);
            jSONObject2.put("template", this.f4525g.m6805k());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad", this.f4523e);
            jSONObject3.put("click", jSONObject2);
            jSONObject3.put("has_custom_click_handler", this.f4521c.zzz(this.f4525g.m6806l()) != null);
            if (((Boolean) C1648if.cm.m6682c()).booleanValue()) {
                if (((Boolean) C1648if.cn.m6682c()).booleanValue()) {
                    jSONObject3.put("asset_view_signal", m6931b((Map) map, view2));
                    jSONObject3.put("ad_view_signal", m6933f(view2));
                } else {
                    jSONObject3.put("view_rectangles", m6929a((Map) map, view2));
                    jSONObject3.put("native_view_rectangle", m6932e(view2));
                }
            }
            if (jSONObject != null) {
                jSONObject3.put("click_point", jSONObject);
            }
            try {
                JSONObject optJSONObject = this.f4523e.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject2.put("click_signals", this.f4526h.m5531a().m3927a(this.f4522d, optJSONObject.optString("click_string"), view));
            } catch (Throwable e) {
                sg.m8445b("Exception obtaining click signals", e);
            }
            jSONObject3.put("ads_id", this.f4530l);
            this.f4524f.m7849a(new C16751(this, jSONObject3));
        } catch (Throwable e2) {
            sg.m8445b("Unable to create click JSON.", e2);
        }
    }

    public void m6941a(View view, Map<String, WeakReference<View>> map) {
        C1314c.m4631b("recordImpression must be called on the main UI thread.");
        m6944a(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f4523e);
            jSONObject.put("ads_id", this.f4530l);
            if (((Boolean) C1648if.cm.m6682c()).booleanValue()) {
                if (((Boolean) C1648if.cn.m6682c()).booleanValue()) {
                    jSONObject.put("asset_view_signal", m6931b((Map) map, view));
                    jSONObject.put("ad_view_signal", m6933f(view));
                } else {
                    jSONObject.put("view_rectangles", m6929a((Map) map, view));
                    jSONObject.put("native_view_rectangle", m6932e(view));
                }
            }
            this.f4524f.m7849a(new C16762(this, jSONObject));
        } catch (Throwable e) {
            sg.m8445b("Unable to create impression JSON.", e);
        }
        this.f4521c.zza((jd) this);
    }

    public void m6942a(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        if (((Boolean) C1648if.ch.m6682c()).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(onTouchListener);
                        view2.setClickable(true);
                        view2.setOnClickListener(onClickListener);
                    }
                }
            }
        }
    }

    public void m6943a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2) {
        C1314c.m4631b("performClick must be called on the main UI thread.");
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    m6940a(view, (String) entry.getKey(), jSONObject, map, view2);
                    return;
                }
            }
        }
        if ("2".equals(this.f4525g.m6805k())) {
            m6940a(view, "2099", jSONObject, map, view2);
        } else if ("1".equals(this.f4525g.m6805k())) {
            m6940a(view, "1099", jSONObject, map, view2);
        }
    }

    protected void m6944a(boolean z) {
        this.f4519a = z;
    }

    public void m6945b(View view, Map<String, WeakReference<View>> map) {
        if (!((Boolean) C1648if.cg.m6682c()).booleanValue()) {
            view.setOnTouchListener(null);
            view.setClickable(false);
            view.setOnClickListener(null);
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(null);
                        view2.setClickable(false);
                        view2.setOnClickListener(null);
                    }
                }
            }
        }
    }

    int[] m6946b(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    int m6947c(View view) {
        return view.getMeasuredWidth();
    }

    public sx m6948c() {
        this.f4528j = m6954g();
        this.f4528j.m8760b().setVisibility(8);
        this.f4524f.m7849a(new C16833(this));
        return this.f4528j;
    }

    public void m6949c(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.f4520b) {
            if (this.f4519a) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                m6941a(view, (Map) map);
            }
        }
    }

    int m6950d(View view) {
        return view.getMeasuredHeight();
    }

    public View m6951d() {
        return this.f4531m != null ? (View) this.f4531m.get() : null;
    }

    public Context m6952e() {
        return this.f4522d;
    }

    public void m6953f() {
        if (this.f4525g instanceof iy) {
            this.f4521c.zzct();
        }
    }

    sx m6954g() {
        return zzv.zzcK().m8830a(this.f4522d, zzec.m9769a(this.f4522d), false, false, this.f4526h, this.f4527i);
    }

    ImageView m6955h() {
        return new ImageView(this.f4522d);
    }
}
