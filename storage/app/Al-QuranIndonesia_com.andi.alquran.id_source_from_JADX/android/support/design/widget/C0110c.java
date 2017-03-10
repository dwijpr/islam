package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.C0035a.C0027b;
import android.support.design.C0035a.C0030e;
import android.support.design.C0035a.C0032g;
import android.support.design.C0035a.C0033h;
import android.support.design.widget.BottomSheetBehavior.C0055a;
import android.support.v4.view.C0036a;
import android.support.v4.view.aj;
import android.support.v4.view.p015a.C0404c;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

/* renamed from: android.support.design.widget.c */
public class C0110c extends AppCompatDialog {
    boolean f390a;
    private BottomSheetBehavior<FrameLayout> f391b;
    private boolean f392c;
    private boolean f393d;
    private C0055a f394e;

    /* renamed from: android.support.design.widget.c.1 */
    class C01071 implements OnClickListener {
        final /* synthetic */ C0110c f387a;

        C01071(C0110c c0110c) {
            this.f387a = c0110c;
        }

        public void onClick(View view) {
            if (this.f387a.f390a && this.f387a.isShowing() && this.f387a.m501a()) {
                this.f387a.cancel();
            }
        }
    }

    /* renamed from: android.support.design.widget.c.2 */
    class C01082 extends C0036a {
        final /* synthetic */ C0110c f388a;

        C01082(C0110c c0110c) {
            this.f388a = c0110c;
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0404c c0404c) {
            super.onInitializeAccessibilityNodeInfo(view, c0404c);
            if (this.f388a.f390a) {
                c0404c.m1503a(1048576);
                c0404c.m1515d(true);
                return;
            }
            c0404c.m1515d(false);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i != 1048576 || !this.f388a.f390a) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            this.f388a.cancel();
            return true;
        }
    }

    /* renamed from: android.support.design.widget.c.3 */
    class C01093 extends C0055a {
        final /* synthetic */ C0110c f389a;

        C01093(C0110c c0110c) {
            this.f389a = c0110c;
        }

        public void m497a(View view, float f) {
        }

        public void m498a(View view, int i) {
            if (i == 5) {
                this.f389a.cancel();
            }
        }
    }

    public C0110c(Context context, int i) {
        super(context, C0110c.m499a(context, i));
        this.f390a = true;
        this.f392c = true;
        this.f394e = new C01093(this);
        supportRequestWindowFeature(1);
    }

    private static int m499a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(C0027b.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : C0033h.Theme_Design_Light_BottomSheetDialog;
    }

    private View m500a(int i, View view, LayoutParams layoutParams) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) View.inflate(getContext(), C0032g.design_bottom_sheet_dialog, null);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(C0030e.design_bottom_sheet);
        this.f391b = BottomSheetBehavior.m241a(view2);
        this.f391b.m246a(this.f394e);
        this.f391b.m250a(this.f390a);
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(C0030e.touch_outside).setOnClickListener(new C01071(this));
        aj.m1861a(view2, new C01082(this));
        return coordinatorLayout;
    }

    boolean m501a() {
        if (!this.f393d) {
            if (VERSION.SDK_INT < 11) {
                this.f392c = true;
            } else {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
                this.f392c = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            this.f393d = true;
        }
        return this.f392c;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f390a != z) {
            this.f390a = z;
            if (this.f391b != null) {
                this.f391b.m250a(z);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f390a) {
            this.f390a = true;
        }
        this.f392c = z;
        this.f393d = true;
    }

    public void setContentView(int i) {
        super.setContentView(m500a(i, null, null));
    }

    public void setContentView(View view) {
        super.setContentView(m500a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(m500a(0, view, layoutParams));
    }
}
