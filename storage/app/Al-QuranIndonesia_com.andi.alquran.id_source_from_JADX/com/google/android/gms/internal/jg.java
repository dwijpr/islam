package com.google.android.gms.internal;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.jk.C1633a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class jg extends C1633a implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    boolean f4554a;
    int f4555b;
    int f4556c;
    private final Object f4557d;
    private final FrameLayout f4558e;
    private FrameLayout f4559f;
    private Map<String, WeakReference<View>> f4560g;
    private iw f4561h;
    private jd f4562i;

    /* renamed from: com.google.android.gms.internal.jg.1 */
    class C16841 implements Runnable {
        final /* synthetic */ je f4550a;
        final /* synthetic */ jg f4551b;

        C16841(jg jgVar, je jeVar) {
            this.f4551b = jgVar;
            this.f4550a = jeVar;
        }

        public void run() {
            sx c = this.f4550a.m6948c();
            if (!(c == null || this.f4551b.f4559f == null)) {
                this.f4551b.f4559f.addView(c.m8760b());
            }
            if (!(this.f4550a instanceof jc)) {
                this.f4551b.m6983b(this.f4550a);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.jg.2 */
    class C16852 implements jb {
        final /* synthetic */ View f4552a;
        final /* synthetic */ jg f4553b;

        C16852(jg jgVar, View view) {
            this.f4553b = jgVar;
            this.f4552a = view;
        }

        public void m6979a() {
            this.f4553b.onClick(this.f4552a);
        }

        public void m6980a(MotionEvent motionEvent) {
            this.f4553b.onTouch(null, motionEvent);
        }
    }

    public jg(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f4557d = new Object();
        this.f4560g = new HashMap();
        this.f4554a = false;
        this.f4558e = frameLayout;
        this.f4559f = frameLayout2;
        zzv.zzdh().m8725a(this.f4558e, (OnGlobalLayoutListener) this);
        zzv.zzdh().m8726a(this.f4558e, (OnScrollChangedListener) this);
        this.f4558e.setOnTouchListener(this);
        this.f4558e.setOnClickListener(this);
    }

    private void m6983b(je jeVar) {
        synchronized (this.f4557d) {
            if (this.f4560g == null || !this.f4560g.containsKey("2011")) {
                jeVar.m6953f();
                return;
            }
            View view = (View) ((WeakReference) this.f4560g.get("2011")).get();
            if (view instanceof FrameLayout) {
                jeVar.m6939a(view, new C16852(this, view));
                return;
            }
            jeVar.m6953f();
        }
    }

    int m6984a(int i) {
        return gr.m6416a().m8702b(this.f4562i.m6925e(), i);
    }

    Point m6985a(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.f4558e.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    public C1108c m6986a(String str) {
        Object obj = null;
        synchronized (this.f4557d) {
            if (this.f4560g == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) this.f4560g.get(str);
            if (weakReference != null) {
                View view = (View) weakReference.get();
            }
            C1108c a = C1111d.m3896a(obj);
            return a;
        }
    }

    iw m6987a(je jeVar) {
        return jeVar.m6935a((OnClickListener) this);
    }

    public void m6988a() {
        synchronized (this.f4557d) {
            if (this.f4559f != null) {
                this.f4559f.removeAllViews();
            }
            this.f4559f = null;
            this.f4560g = null;
            this.f4561h = null;
            this.f4562i = null;
        }
    }

    void m6989a(View view) {
        if (this.f4562i != null) {
            jd b = this.f4562i instanceof jc ? ((jc) this.f4562i).m6962b() : this.f4562i;
            if (b != null) {
                b.m6918a(view);
            }
        }
    }

    public void m6990a(C1108c c1108c) {
        synchronized (this.f4557d) {
            m6989a(null);
            Object a = C1111d.m3897a(c1108c);
            if (a instanceof je) {
                if (this.f4559f != null) {
                    this.f4559f.setLayoutParams(new LayoutParams(0, 0));
                    this.f4558e.requestLayout();
                }
                this.f4554a = true;
                je jeVar = (je) a;
                if (this.f4562i != null && ((Boolean) C1648if.cf.m6682c()).booleanValue()) {
                    this.f4562i.m6922b(this.f4558e, this.f4560g);
                }
                if ((this.f4562i instanceof jc) && ((jc) this.f4562i).m6961a()) {
                    ((jc) this.f4562i).m6960a((jd) jeVar);
                } else {
                    this.f4562i = jeVar;
                    if (jeVar instanceof jc) {
                        ((jc) jeVar).m6960a(null);
                    }
                }
                if (((Boolean) C1648if.cf.m6682c()).booleanValue()) {
                    this.f4559f.setClickable(false);
                }
                this.f4559f.removeAllViews();
                this.f4561h = m6987a(jeVar);
                if (this.f4561h != null) {
                    if (this.f4560g != null) {
                        this.f4560g.put("1007", new WeakReference(this.f4561h.m6783a()));
                    }
                    this.f4559f.addView(this.f4561h);
                }
                jeVar.m6942a(this.f4558e, this.f4560g, (OnTouchListener) this, (OnClickListener) this);
                rq.f5755a.post(new C16841(this, jeVar));
                m6989a(this.f4558e);
                return;
            }
            sg.m8449e("Not an instance of native engine. This is most likely a transient error");
        }
    }

    public void m6991a(String str, C1108c c1108c) {
        View view = (View) C1111d.m3897a(c1108c);
        synchronized (this.f4557d) {
            if (this.f4560g == null) {
                return;
            }
            if (view == null) {
                this.f4560g.remove(str);
            } else {
                this.f4560g.put(str, new WeakReference(view));
                view.setOnTouchListener(this);
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    int m6992b() {
        return this.f4558e.getMeasuredWidth();
    }

    int m6993c() {
        return this.f4558e.getMeasuredHeight();
    }

    public void onClick(View view) {
        synchronized (this.f4557d) {
            if (this.f4562i == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", m6984a(this.f4555b));
                jSONObject.put("y", m6984a(this.f4556c));
            } catch (JSONException e) {
                sg.m8449e("Unable to get click location");
            }
            if (this.f4561h == null || !this.f4561h.m6783a().equals(view)) {
                this.f4562i.m6921a(view, this.f4560g, jSONObject, this.f4558e);
            } else if (!(this.f4562i instanceof jc) || ((jc) this.f4562i).m6962b() == null) {
                this.f4562i.m6919a(view, "1007", jSONObject, this.f4560g, this.f4558e);
            } else {
                ((jc) this.f4562i).m6962b().m6919a(view, "1007", jSONObject, this.f4560g, this.f4558e);
            }
        }
    }

    public void onGlobalLayout() {
        synchronized (this.f4557d) {
            if (this.f4554a) {
                int b = m6992b();
                int c = m6993c();
                if (!(b == 0 || c == 0 || this.f4559f == null)) {
                    this.f4559f.setLayoutParams(new LayoutParams(b, c));
                    this.f4554a = false;
                }
            }
            if (this.f4562i != null) {
                this.f4562i.m6923c(this.f4558e, this.f4560g);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.f4557d) {
            if (this.f4562i != null) {
                this.f4562i.m6923c(this.f4558e, this.f4560g);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f4557d) {
            if (this.f4562i == null) {
            } else {
                Point a = m6985a(motionEvent);
                this.f4555b = a.x;
                this.f4556c = a.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) a.x, (float) a.y);
                this.f4562i.m6917a(obtain);
                obtain.recycle();
            }
        }
        return false;
    }
}
