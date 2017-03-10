package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.C0035a.C0026a;
import android.support.design.C0035a.C0034i;
import android.support.design.widget.C0132o.C0130a;
import android.support.design.widget.CoordinatorLayout.C0046a;
import android.support.design.widget.CoordinatorLayout.C0063d;
import android.support.design.widget.SwipeDismissBehavior.C0075a;
import android.support.v4.view.aj;
import android.support.v4.view.bd;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/* renamed from: android.support.design.widget.b */
public abstract class C0073b<B extends C0073b<B>> {
    static final Handler f277a;
    final C0072f f278b;
    final C0130a f279c;
    private final ViewGroup f280d;
    private final C0040c f281e;
    private List<C0105a<B>> f282f;
    private final AccessibilityManager f283g;

    /* renamed from: android.support.design.widget.b.c */
    public interface C0040c {
        void m87a(int i, int i2);

        void m88b(int i, int i2);
    }

    /* renamed from: android.support.design.widget.b.f */
    static class C0072f extends FrameLayout {
        private C0100e f275a;
        private C0098d f276b;

        C0072f(Context context) {
            this(context, null);
        }

        C0072f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(C0034i.SnackbarLayout_elevation)) {
                aj.m1879d((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(C0034i.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f276b != null) {
                this.f276b.m486a(this);
            }
            aj.m1898u(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f276b != null) {
                this.f276b.m487b(this);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f275a != null) {
                this.f275a.m490a(this, i, i2, i3, i4);
            }
        }

        void setOnAttachStateChangeListener(C0098d c0098d) {
            this.f276b = c0098d;
        }

        void setOnLayoutChangeListener(C0100e c0100e) {
            this.f275a = c0100e;
        }
    }

    /* renamed from: android.support.design.widget.b.1 */
    static class C00941 implements Callback {
        C00941() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    ((C0073b) message.obj).m367b();
                    return true;
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    ((C0073b) message.obj).m368b(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.design.widget.b.2 */
    class C00952 implements AnimationListener {
        final /* synthetic */ int f376a;
        final /* synthetic */ C0073b f377b;

        C00952(C0073b c0073b, int i) {
            this.f377b = c0073b;
            this.f376a = i;
        }

        public void onAnimationEnd(Animation animation) {
            this.f377b.m370c(this.f376a);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.b.3 */
    class C00963 implements C0075a {
        final /* synthetic */ C0073b f378a;

        C00963(C0073b c0073b) {
            this.f378a = c0073b;
        }

        public void m484a(int i) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    C0132o.m587a().m598d(this.f378a.f279c);
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    C0132o.m587a().m597c(this.f378a.f279c);
                default:
            }
        }

        public void m485a(View view) {
            view.setVisibility(8);
            this.f378a.m365a(0);
        }
    }

    /* renamed from: android.support.design.widget.b.d */
    interface C0098d {
        void m486a(View view);

        void m487b(View view);
    }

    /* renamed from: android.support.design.widget.b.4 */
    class C00994 implements C0098d {
        final /* synthetic */ C0073b f380a;

        /* renamed from: android.support.design.widget.b.4.1 */
        class C00971 implements Runnable {
            final /* synthetic */ C00994 f379a;

            C00971(C00994 c00994) {
                this.f379a = c00994;
            }

            public void run() {
                this.f379a.f380a.m370c(3);
            }
        }

        C00994(C0073b c0073b) {
            this.f380a = c0073b;
        }

        public void m488a(View view) {
        }

        public void m489b(View view) {
            if (this.f380a.m366a()) {
                C0073b.f277a.post(new C00971(this));
            }
        }
    }

    /* renamed from: android.support.design.widget.b.e */
    interface C0100e {
        void m490a(View view, int i, int i2, int i3, int i4);
    }

    /* renamed from: android.support.design.widget.b.5 */
    class C01015 implements C0100e {
        final /* synthetic */ C0073b f381a;

        C01015(C0073b c0073b) {
            this.f381a = c0073b;
        }

        public void m491a(View view, int i, int i2, int i3, int i4) {
            this.f381a.f278b.setOnLayoutChangeListener(null);
            if (this.f381a.m372e()) {
                this.f381a.m369c();
            } else {
                this.f381a.m371d();
            }
        }
    }

    /* renamed from: android.support.design.widget.b.6 */
    class C01026 extends bd {
        final /* synthetic */ C0073b f382a;

        C01026(C0073b c0073b) {
            this.f382a = c0073b;
        }

        public void onAnimationEnd(View view) {
            this.f382a.m371d();
        }

        public void onAnimationStart(View view) {
            this.f382a.f281e.m87a(70, 180);
        }
    }

    /* renamed from: android.support.design.widget.b.7 */
    class C01037 implements AnimationListener {
        final /* synthetic */ C0073b f383a;

        C01037(C0073b c0073b) {
            this.f383a = c0073b;
        }

        public void onAnimationEnd(Animation animation) {
            this.f383a.m371d();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.b.8 */
    class C01048 extends bd {
        final /* synthetic */ int f384a;
        final /* synthetic */ C0073b f385b;

        C01048(C0073b c0073b, int i) {
            this.f385b = c0073b;
            this.f384a = i;
        }

        public void onAnimationEnd(View view) {
            this.f385b.m370c(this.f384a);
        }

        public void onAnimationStart(View view) {
            this.f385b.f281e.m88b(0, 180);
        }
    }

    /* renamed from: android.support.design.widget.b.a */
    public static abstract class C0105a<B> {
        public void m492a(B b) {
        }

        public void m493a(B b, int i) {
        }
    }

    /* renamed from: android.support.design.widget.b.b */
    final class C0106b extends SwipeDismissBehavior<C0072f> {
        final /* synthetic */ C0073b f386a;

        C0106b(C0073b c0073b) {
            this.f386a = c0073b;
        }

        public boolean m494a(CoordinatorLayout coordinatorLayout, C0072f c0072f, MotionEvent motionEvent) {
            if (coordinatorLayout.m318a((View) c0072f, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        C0132o.m587a().m597c(this.f386a.f279c);
                        break;
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                        C0132o.m587a().m598d(this.f386a.f279c);
                        break;
                }
            }
            return super.m391a(coordinatorLayout, (View) c0072f, motionEvent);
        }

        public boolean m496a(View view) {
            return view instanceof C0072f;
        }
    }

    static {
        f277a = new Handler(Looper.getMainLooper(), new C00941());
    }

    private void m364d(int i) {
        if (VERSION.SDK_INT >= 14) {
            aj.m1894q(this.f278b).m2069c((float) this.f278b.getHeight()).m2065a(C0093a.f371b).m2062a(250).m2063a(new C01048(this, i)).m2070c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f278b.getContext(), C0026a.design_snackbar_out);
        loadAnimation.setInterpolator(C0093a.f371b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C00952(this, i));
        this.f278b.startAnimation(loadAnimation);
    }

    void m365a(int i) {
        C0132o.m587a().m594a(this.f279c, i);
    }

    public boolean m366a() {
        return C0132o.m587a().m599e(this.f279c);
    }

    final void m367b() {
        if (this.f278b.getParent() == null) {
            LayoutParams layoutParams = this.f278b.getLayoutParams();
            if (layoutParams instanceof C0063d) {
                C0063d c0063d = (C0063d) layoutParams;
                C0046a c0106b = new C0106b(this);
                c0106b.m388a(0.1f);
                c0106b.m393b(0.6f);
                c0106b.m389a(0);
                c0106b.m390a(new C00963(this));
                c0063d.m269a(c0106b);
                c0063d.f220g = 80;
            }
            this.f280d.addView(this.f278b);
        }
        this.f278b.setOnAttachStateChangeListener(new C00994(this));
        if (!aj.m1846C(this.f278b)) {
            this.f278b.setOnLayoutChangeListener(new C01015(this));
        } else if (m372e()) {
            m369c();
        } else {
            m371d();
        }
    }

    final void m368b(int i) {
        if (m372e() && this.f278b.getVisibility() == 0) {
            m364d(i);
        } else {
            m370c(i);
        }
    }

    void m369c() {
        if (VERSION.SDK_INT >= 14) {
            aj.m1870b(this.f278b, (float) this.f278b.getHeight());
            aj.m1894q(this.f278b).m2069c(0.0f).m2065a(C0093a.f371b).m2062a(250).m2063a(new C01026(this)).m2070c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f278b.getContext(), C0026a.design_snackbar_in);
        loadAnimation.setInterpolator(C0093a.f371b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C01037(this));
        this.f278b.startAnimation(loadAnimation);
    }

    void m370c(int i) {
        C0132o.m587a().m593a(this.f279c);
        if (this.f282f != null) {
            for (int size = this.f282f.size() - 1; size >= 0; size--) {
                ((C0105a) this.f282f.get(size)).m493a(this, i);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.f278b.setVisibility(8);
        }
        ViewParent parent = this.f278b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f278b);
        }
    }

    void m371d() {
        C0132o.m587a().m596b(this.f279c);
        if (this.f282f != null) {
            for (int size = this.f282f.size() - 1; size >= 0; size--) {
                ((C0105a) this.f282f.get(size)).m492a(this);
            }
        }
    }

    boolean m372e() {
        return !this.f283g.isEnabled();
    }
}
