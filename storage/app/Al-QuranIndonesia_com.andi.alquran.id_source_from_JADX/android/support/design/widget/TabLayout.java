package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0035a.C0028c;
import android.support.design.C0035a.C0032g;
import android.support.design.C0035a.C0033h;
import android.support.design.C0035a.C0034i;
import android.support.design.widget.C0144s.C0041c;
import android.support.design.widget.C0144s.C0084b;
import android.support.v4.p014g.C0313i.C0310a;
import android.support.v4.p014g.C0313i.C0311b;
import android.support.v4.p014g.C0313i.C0312c;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0078e;
import android.support.v4.view.ViewPager.C0088f;
import android.support.v4.view.ViewPager.C0369a;
import android.support.v4.view.aa;
import android.support.v4.view.ad;
import android.support.v4.view.aj;
import android.support.v4.widget.C0596w;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.C0627R;
import android.support.v7.content.res.AppCompatResources;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@C0369a
public class TabLayout extends HorizontalScrollView {
    private static final C0310a<C0087e> f339n;
    private DataSetObserver f340A;
    private C0089f f341B;
    private C0079a f342C;
    private boolean f343D;
    private final C0310a<C0090g> f344E;
    int f345a;
    int f346b;
    int f347c;
    int f348d;
    int f349e;
    ColorStateList f350f;
    float f351g;
    float f352h;
    final int f353i;
    int f354j;
    int f355k;
    int f356l;
    ViewPager f357m;
    private final ArrayList<C0087e> f358o;
    private C0087e f359p;
    private final C0086d f360q;
    private final int f361r;
    private final int f362s;
    private final int f363t;
    private int f364u;
    private C0080b f365v;
    private final ArrayList<C0080b> f366w;
    private C0080b f367x;
    private C0144s f368y;
    private aa f369z;

    /* renamed from: android.support.design.widget.TabLayout.1 */
    class C00771 implements C0041c {
        final /* synthetic */ TabLayout f300a;

        C00771(TabLayout tabLayout) {
            this.f300a = tabLayout;
        }

        public void m395a(C0144s c0144s) {
            this.f300a.scrollTo(c0144s.m637c(), 0);
        }
    }

    /* renamed from: android.support.design.widget.TabLayout.a */
    private class C0079a implements C0078e {
        final /* synthetic */ TabLayout f301a;
        private boolean f302b;

        C0079a(TabLayout tabLayout) {
            this.f301a = tabLayout;
        }

        public void m397a(ViewPager viewPager, aa aaVar, aa aaVar2) {
            if (this.f301a.f357m == viewPager) {
                this.f301a.m474a(aaVar2, this.f302b);
            }
        }

        void m398a(boolean z) {
            this.f302b = z;
        }
    }

    /* renamed from: android.support.design.widget.TabLayout.b */
    public interface C0080b {
        void m399a(C0087e c0087e);

        void m400b(C0087e c0087e);

        void m401c(C0087e c0087e);
    }

    /* renamed from: android.support.design.widget.TabLayout.c */
    private class C0081c extends DataSetObserver {
        final /* synthetic */ TabLayout f303a;

        C0081c(TabLayout tabLayout) {
            this.f303a = tabLayout;
        }

        public void onChanged() {
            this.f303a.m481c();
        }

        public void onInvalidated() {
            this.f303a.m481c();
        }
    }

    /* renamed from: android.support.design.widget.TabLayout.d */
    private class C0086d extends LinearLayout {
        int f311a;
        float f312b;
        final /* synthetic */ TabLayout f313c;
        private int f314d;
        private final Paint f315e;
        private int f316f;
        private int f317g;
        private C0144s f318h;

        /* renamed from: android.support.design.widget.TabLayout.d.1 */
        class C00821 implements C0041c {
            final /* synthetic */ int f304a;
            final /* synthetic */ int f305b;
            final /* synthetic */ int f306c;
            final /* synthetic */ int f307d;
            final /* synthetic */ C0086d f308e;

            C00821(C0086d c0086d, int i, int i2, int i3, int i4) {
                this.f308e = c0086d;
                this.f304a = i;
                this.f305b = i2;
                this.f306c = i3;
                this.f307d = i4;
            }

            public void m402a(C0144s c0144s) {
                float e = c0144s.m639e();
                this.f308e.m413a(C0093a.m482a(this.f304a, this.f305b, e), C0093a.m482a(this.f306c, this.f307d, e));
            }
        }

        /* renamed from: android.support.design.widget.TabLayout.d.2 */
        class C00852 extends C0084b {
            final /* synthetic */ int f309a;
            final /* synthetic */ C0086d f310b;

            C00852(C0086d c0086d, int i) {
                this.f310b = c0086d;
                this.f309a = i;
            }

            public void m409b(C0144s c0144s) {
                this.f310b.f311a = this.f309a;
                this.f310b.f312b = 0.0f;
            }
        }

        C0086d(TabLayout tabLayout, Context context) {
            this.f313c = tabLayout;
            super(context);
            this.f311a = -1;
            this.f316f = -1;
            this.f317g = -1;
            setWillNotDraw(false);
            this.f315e = new Paint();
        }

        private void m410c() {
            int i;
            int i2;
            View childAt = getChildAt(this.f311a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                if (this.f312b > 0.0f && this.f311a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f311a + 1);
                    i2 = (int) ((((float) i2) * (1.0f - this.f312b)) + (this.f312b * ((float) childAt2.getLeft())));
                    i = (int) ((((float) i) * (1.0f - this.f312b)) + (((float) childAt2.getRight()) * this.f312b));
                }
            }
            m413a(i2, i);
        }

        void m411a(int i) {
            if (this.f315e.getColor() != i) {
                this.f315e.setColor(i);
                aj.m1874c(this);
            }
        }

        void m412a(int i, float f) {
            if (this.f318h != null && this.f318h.m636b()) {
                this.f318h.m638d();
            }
            this.f311a = i;
            this.f312b = f;
            m410c();
        }

        void m413a(int i, int i2) {
            if (i != this.f316f || i2 != this.f317g) {
                this.f316f = i;
                this.f317g = i2;
                aj.m1874c(this);
            }
        }

        boolean m414a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        float m415b() {
            return ((float) this.f311a) + this.f312b;
        }

        void m416b(int i) {
            if (this.f314d != i) {
                this.f314d = i;
                aj.m1874c(this);
            }
        }

        void m417b(int i, int i2) {
            if (this.f318h != null && this.f318h.m636b()) {
                this.f318h.m638d();
            }
            Object obj = aj.m1884g(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                m410c();
                return;
            }
            int i3;
            int i4;
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i - this.f311a) <= 1) {
                i3 = this.f316f;
                i4 = this.f317g;
            } else {
                int b = this.f313c.m476b(24);
                if (i < this.f311a) {
                    if (obj != null) {
                        i4 = left - b;
                        i3 = i4;
                    } else {
                        i4 = right + b;
                        i3 = i4;
                    }
                } else if (obj != null) {
                    i4 = right + b;
                    i3 = i4;
                } else {
                    i4 = left - b;
                    i3 = i4;
                }
            }
            if (i3 != left || i4 != right) {
                C0144s a = C0157z.m687a();
                this.f318h = a;
                a.m635a(C0093a.f371b);
                a.m632a((long) i2);
                a.m630a(0.0f, 1.0f);
                a.m634a(new C00821(this, i3, left, i4, right));
                a.m633a(new C00852(this, i));
                a.m629a();
            }
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f316f >= 0 && this.f317g > this.f316f) {
                canvas.drawRect((float) this.f316f, (float) (getHeight() - this.f314d), (float) this.f317g, (float) getHeight(), this.f315e);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f318h == null || !this.f318h.m636b()) {
                m410c();
                return;
            }
            this.f318h.m638d();
            m417b(this.f311a, Math.round(((float) this.f318h.m641g()) * (1.0f - this.f318h.m639e())));
        }

        protected void onMeasure(int i, int i2) {
            boolean z = false;
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824 && this.f313c.f356l == 1 && this.f313c.f355k == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    i3++;
                    i4 = childAt.getVisibility() == 0 ? Math.max(i4, childAt.getMeasuredWidth()) : i4;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (this.f313c.m476b(16) * 2)) {
                        i3 = 0;
                        while (i3 < childCount) {
                            boolean z2;
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                z2 = z;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                            i3++;
                            z = z2;
                        }
                    } else {
                        this.f313c.f355k = 0;
                        this.f313c.m475a(false);
                        z = true;
                    }
                    if (z) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }
    }

    /* renamed from: android.support.design.widget.TabLayout.e */
    public static final class C0087e {
        TabLayout f319a;
        C0090g f320b;
        private Object f321c;
        private Drawable f322d;
        private CharSequence f323e;
        private CharSequence f324f;
        private int f325g;
        private View f326h;

        C0087e() {
            this.f325g = -1;
        }

        public C0087e m418a(int i) {
            return m420a(LayoutInflater.from(this.f320b.getContext()).inflate(i, this.f320b, false));
        }

        public C0087e m419a(Drawable drawable) {
            this.f322d = drawable;
            m431h();
            return this;
        }

        public C0087e m420a(View view) {
            this.f326h = view;
            m431h();
            return this;
        }

        public C0087e m421a(CharSequence charSequence) {
            this.f323e = charSequence;
            m431h();
            return this;
        }

        public View m422a() {
            return this.f326h;
        }

        public Drawable m423b() {
            return this.f322d;
        }

        public C0087e m424b(CharSequence charSequence) {
            this.f324f = charSequence;
            m431h();
            return this;
        }

        void m425b(int i) {
            this.f325g = i;
        }

        public int m426c() {
            return this.f325g;
        }

        public CharSequence m427d() {
            return this.f323e;
        }

        public void m428e() {
            if (this.f319a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f319a.m479b(this);
        }

        public boolean m429f() {
            if (this.f319a != null) {
                return this.f319a.getSelectedTabPosition() == this.f325g;
            } else {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
        }

        public CharSequence m430g() {
            return this.f324f;
        }

        void m431h() {
            if (this.f320b != null) {
                this.f320b.m444b();
            }
        }

        void m432i() {
            this.f319a = null;
            this.f320b = null;
            this.f321c = null;
            this.f322d = null;
            this.f323e = null;
            this.f324f = null;
            this.f325g = -1;
            this.f326h = null;
        }
    }

    /* renamed from: android.support.design.widget.TabLayout.f */
    public static class C0089f implements C0088f {
        private final WeakReference<TabLayout> f327a;
        private int f328b;
        private int f329c;

        public C0089f(TabLayout tabLayout) {
            this.f327a = new WeakReference(tabLayout);
        }

        void m436a() {
            this.f329c = 0;
            this.f328b = 0;
        }

        public void m437a(int i) {
            this.f328b = this.f329c;
            this.f329c = i;
        }

        public void m438a(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = (TabLayout) this.f327a.get();
            if (tabLayout != null) {
                boolean z2 = this.f329c != 2 || this.f328b == 1;
                if (!(this.f329c == 2 && this.f328b == 0)) {
                    z = true;
                }
                tabLayout.m468a(i, f, z2, z);
            }
        }

        public void m439b(int i) {
            TabLayout tabLayout = (TabLayout) this.f327a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                boolean z = this.f329c == 0 || (this.f329c == 2 && this.f328b == 0);
                tabLayout.m480b(tabLayout.m466a(i), z);
            }
        }
    }

    /* renamed from: android.support.design.widget.TabLayout.g */
    class C0090g extends LinearLayout implements OnLongClickListener {
        final /* synthetic */ TabLayout f330a;
        private C0087e f331b;
        private TextView f332c;
        private ImageView f333d;
        private View f334e;
        private TextView f335f;
        private ImageView f336g;
        private int f337h;

        public C0090g(TabLayout tabLayout, Context context) {
            this.f330a = tabLayout;
            super(context);
            this.f337h = 2;
            if (tabLayout.f353i != 0) {
                aj.m1860a((View) this, AppCompatResources.getDrawable(context, tabLayout.f353i));
            }
            aj.m1856a(this, tabLayout.f345a, tabLayout.f346b, tabLayout.f347c, tabLayout.f348d);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            aj.m1862a((View) this, ad.m1637a(getContext(), 1002));
        }

        private float m440a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        private void m441a(TextView textView, ImageView imageView) {
            Drawable b = this.f331b != null ? this.f331b.m423b() : null;
            CharSequence d = this.f331b != null ? this.f331b.m427d() : null;
            CharSequence g = this.f331b != null ? this.f331b.m430g() : null;
            if (imageView != null) {
                if (b != null) {
                    imageView.setImageDrawable(b);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(g);
            }
            boolean z = !TextUtils.isEmpty(d);
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(g);
            }
            if (imageView != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                int b2 = (z && imageView.getVisibility() == 0) ? this.f330a.m476b(8) : 0;
                if (b2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = b2;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(g)) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        void m442a() {
            m443a(null);
            setSelected(false);
        }

        void m443a(C0087e c0087e) {
            if (c0087e != this.f331b) {
                this.f331b = c0087e;
                m444b();
            }
        }

        final void m444b() {
            C0087e c0087e = this.f331b;
            View a = c0087e != null ? c0087e.m422a() : null;
            if (a != null) {
                C0090g parent = a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(a);
                    }
                    addView(a);
                }
                this.f334e = a;
                if (this.f332c != null) {
                    this.f332c.setVisibility(8);
                }
                if (this.f333d != null) {
                    this.f333d.setVisibility(8);
                    this.f333d.setImageDrawable(null);
                }
                this.f335f = (TextView) a.findViewById(16908308);
                if (this.f335f != null) {
                    this.f337h = C0596w.m2538a(this.f335f);
                }
                this.f336g = (ImageView) a.findViewById(16908294);
            } else {
                if (this.f334e != null) {
                    removeView(this.f334e);
                    this.f334e = null;
                }
                this.f335f = null;
                this.f336g = null;
            }
            if (this.f334e == null) {
                if (this.f333d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C0032g.design_layout_tab_icon, this, false);
                    addView(imageView, 0);
                    this.f333d = imageView;
                }
                if (this.f332c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0032g.design_layout_tab_text, this, false);
                    addView(textView);
                    this.f332c = textView;
                    this.f337h = C0596w.m2538a(this.f332c);
                }
                C0596w.m2539a(this.f332c, this.f330a.f349e);
                if (this.f330a.f350f != null) {
                    this.f332c.setTextColor(this.f330a.f350f);
                }
                m441a(this.f332c, this.f333d);
            } else if (!(this.f335f == null && this.f336g == null)) {
                m441a(this.f335f, this.f336g);
            }
            boolean z = c0087e != null && c0087e.m429f();
            setSelected(z);
        }

        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(Tab.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(Tab.class.getName());
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            Rect rect = new Rect();
            getLocationOnScreen(iArr);
            getWindowVisibleDisplayFrame(rect);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = iArr[1] + (height / 2);
            width = (width / 2) + iArr[0];
            if (aj.m1884g(view) == 0) {
                width = context.getResources().getDisplayMetrics().widthPixels - width;
            }
            Toast makeText = Toast.makeText(context, this.f331b.m430g(), 0);
            if (i < rect.height()) {
                makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
            } else {
                makeText.setGravity(81, 0, height);
            }
            makeText.show();
            return true;
        }

        public void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int tabMaxWidth = this.f330a.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = MeasureSpec.makeMeasureSpec(this.f330a.f354j, RtlSpacingHelper.UNDEFINED);
            }
            super.onMeasure(i, i2);
            if (this.f332c != null) {
                getResources();
                float f = this.f330a.f351g;
                size = this.f337h;
                if (this.f333d != null && this.f333d.getVisibility() == 0) {
                    size = 1;
                } else if (this.f332c != null && this.f332c.getLineCount() > 1) {
                    f = this.f330a.f352h;
                }
                float textSize = this.f332c.getTextSize();
                int lineCount = this.f332c.getLineCount();
                int a = C0596w.m2538a(this.f332c);
                if (f != textSize || (a >= 0 && size != a)) {
                    if (this.f330a.f356l == 1 && f > textSize && lineCount == 1) {
                        Layout layout = this.f332c.getLayout();
                        if (layout == null || m440a(layout, 0, f) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.f332c.setTextSize(0, f);
                        this.f332c.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f331b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f331b.m428e();
            return true;
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z && VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.f332c != null) {
                this.f332c.setSelected(z);
            }
            if (this.f333d != null) {
                this.f333d.setSelected(z);
            }
            if (this.f334e != null) {
                this.f334e.setSelected(z);
            }
        }
    }

    /* renamed from: android.support.design.widget.TabLayout.h */
    public static class C0091h implements C0080b {
        private final ViewPager f338a;

        public C0091h(ViewPager viewPager) {
            this.f338a = viewPager;
        }

        public void m445a(C0087e c0087e) {
            this.f338a.setCurrentItem(c0087e.m426c());
        }

        public void m446b(C0087e c0087e) {
        }

        public void m447c(C0087e c0087e) {
        }
    }

    static {
        f339n = new C0312c(16);
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f358o = new ArrayList();
        this.f354j = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f366w = new ArrayList();
        this.f344E = new C0311b(12);
        C0137r.m606a(context);
        setHorizontalScrollBarEnabled(false);
        this.f360q = new C0086d(this, context);
        super.addView(this.f360q, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0034i.TabLayout, i, C0033h.Widget_Design_TabLayout);
        this.f360q.m416b(obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabIndicatorHeight, 0));
        this.f360q.m411a(obtainStyledAttributes.getColor(C0034i.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabPadding, 0);
        this.f348d = dimensionPixelSize;
        this.f347c = dimensionPixelSize;
        this.f346b = dimensionPixelSize;
        this.f345a = dimensionPixelSize;
        this.f345a = obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabPaddingStart, this.f345a);
        this.f346b = obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabPaddingTop, this.f346b);
        this.f347c = obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabPaddingEnd, this.f347c);
        this.f348d = obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabPaddingBottom, this.f348d);
        this.f349e = obtainStyledAttributes.getResourceId(C0034i.TabLayout_tabTextAppearance, C0033h.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.f349e, C0627R.styleable.TextAppearance);
        try {
            this.f351g = (float) obtainStyledAttributes2.getDimensionPixelSize(C0627R.styleable.TextAppearance_android_textSize, 0);
            this.f350f = obtainStyledAttributes2.getColorStateList(C0627R.styleable.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(C0034i.TabLayout_tabTextColor)) {
                this.f350f = obtainStyledAttributes.getColorStateList(C0034i.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(C0034i.TabLayout_tabSelectedTextColor)) {
                this.f350f = m449a(this.f350f.getDefaultColor(), obtainStyledAttributes.getColor(C0034i.TabLayout_tabSelectedTextColor, 0));
            }
            this.f361r = obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabMinWidth, -1);
            this.f362s = obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabMaxWidth, -1);
            this.f353i = obtainStyledAttributes.getResourceId(C0034i.TabLayout_tabBackground, 0);
            this.f364u = obtainStyledAttributes.getDimensionPixelSize(C0034i.TabLayout_tabContentStart, 0);
            this.f356l = obtainStyledAttributes.getInt(C0034i.TabLayout_tabMode, 1);
            this.f355k = obtainStyledAttributes.getInt(C0034i.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.f352h = (float) resources.getDimensionPixelSize(C0028c.design_tab_text_size_2line);
            this.f363t = resources.getDimensionPixelSize(C0028c.design_tab_scrollable_min_width);
            m462f();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private int m448a(int i, float f) {
        int i2 = 0;
        if (this.f356l != 0) {
            return 0;
        }
        View childAt = this.f360q.getChildAt(i);
        View childAt2 = i + 1 < this.f360q.getChildCount() ? this.f360q.getChildAt(i + 1) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private static ColorStateList m449a(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r0[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private void m450a(C0087e c0087e, int i) {
        c0087e.m425b(i);
        this.f358o.add(i, c0087e);
        int size = this.f358o.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((C0087e) this.f358o.get(i2)).m425b(i2);
        }
    }

    private void m451a(C0136q c0136q) {
        C0087e a = m465a();
        if (c0136q.f487a != null) {
            a.m421a(c0136q.f487a);
        }
        if (c0136q.f488b != null) {
            a.m419a(c0136q.f488b);
        }
        if (c0136q.f489c != 0) {
            a.m418a(c0136q.f489c);
        }
        if (!TextUtils.isEmpty(c0136q.getContentDescription())) {
            a.m424b(c0136q.getContentDescription());
        }
        m470a(a);
    }

    private void m452a(ViewPager viewPager, boolean z, boolean z2) {
        if (this.f357m != null) {
            if (this.f341B != null) {
                this.f357m.m1327b(this.f341B);
            }
            if (this.f342C != null) {
                this.f357m.m1326b(this.f342C);
            }
        }
        if (this.f367x != null) {
            m478b(this.f367x);
            this.f367x = null;
        }
        if (viewPager != null) {
            this.f357m = viewPager;
            if (this.f341B == null) {
                this.f341B = new C0089f(this);
            }
            this.f341B.m436a();
            viewPager.m1320a(this.f341B);
            this.f367x = new C0091h(viewPager);
            m469a(this.f367x);
            aa adapter = viewPager.getAdapter();
            if (adapter != null) {
                m474a(adapter, z);
            }
            if (this.f342C == null) {
                this.f342C = new C0079a(this);
            }
            this.f342C.m398a(z);
            viewPager.m1319a(this.f342C);
            m467a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f357m = null;
            m474a(null, false);
        }
        this.f343D = z2;
    }

    private void m453a(View view) {
        if (view instanceof C0136q) {
            m451a((C0136q) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void m454a(LayoutParams layoutParams) {
        if (this.f356l == 1 && this.f355k == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private C0090g m455c(C0087e c0087e) {
        C0090g c0090g = this.f344E != null ? (C0090g) this.f344E.m1029a() : null;
        if (c0090g == null) {
            c0090g = new C0090g(this, getContext());
        }
        c0090g.m443a(c0087e);
        c0090g.setFocusable(true);
        c0090g.setMinimumWidth(getTabMinWidth());
        return c0090g;
    }

    private void m456c(int i) {
        C0090g c0090g = (C0090g) this.f360q.getChildAt(i);
        this.f360q.removeViewAt(i);
        if (c0090g != null) {
            c0090g.m442a();
            this.f344E.m1030a(c0090g);
        }
        requestLayout();
    }

    private void m457d() {
        int size = this.f358o.size();
        for (int i = 0; i < size; i++) {
            ((C0087e) this.f358o.get(i)).m431h();
        }
    }

    private void m458d(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !aj.m1846C(this) || this.f360q.m414a()) {
                m467a(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int a = m448a(i, 0.0f);
            if (scrollX != a) {
                if (this.f368y == null) {
                    this.f368y = C0157z.m687a();
                    this.f368y.m635a(C0093a.f371b);
                    this.f368y.m632a(300);
                    this.f368y.m634a(new C00771(this));
                }
                this.f368y.m631a(scrollX, a);
                this.f368y.m629a();
            }
            this.f360q.m417b(i, 300);
        }
    }

    private void m459d(C0087e c0087e) {
        this.f360q.addView(c0087e.f320b, c0087e.m426c(), m460e());
    }

    private LayoutParams m460e() {
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        m454a(layoutParams);
        return layoutParams;
    }

    private void m461e(C0087e c0087e) {
        for (int size = this.f366w.size() - 1; size >= 0; size--) {
            ((C0080b) this.f366w.get(size)).m399a(c0087e);
        }
    }

    private void m462f() {
        aj.m1856a(this.f360q, this.f356l == 0 ? Math.max(0, this.f364u - this.f345a) : 0, 0, 0, 0);
        switch (this.f356l) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                this.f360q.setGravity(8388611);
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                this.f360q.setGravity(1);
                break;
        }
        m475a(true);
    }

    private void m463f(C0087e c0087e) {
        for (int size = this.f366w.size() - 1; size >= 0; size--) {
            ((C0080b) this.f366w.get(size)).m400b(c0087e);
        }
    }

    private void m464g(C0087e c0087e) {
        for (int size = this.f366w.size() - 1; size >= 0; size--) {
            ((C0080b) this.f366w.get(size)).m401c(c0087e);
        }
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.f358o.size();
        for (int i = 0; i < size; i++) {
            C0087e c0087e = (C0087e) this.f358o.get(i);
            if (c0087e != null && c0087e.m423b() != null && !TextUtils.isEmpty(c0087e.m427d())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        return obj != null ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.f360q.m415b();
    }

    private int getTabMinWidth() {
        return this.f361r != -1 ? this.f361r : this.f356l == 0 ? this.f363t : 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f360q.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f360q.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.f360q.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    public C0087e m465a() {
        C0087e c0087e = (C0087e) f339n.m1029a();
        if (c0087e == null) {
            c0087e = new C0087e();
        }
        c0087e.f319a = this;
        c0087e.f320b = m455c(c0087e);
        return c0087e;
    }

    public C0087e m466a(int i) {
        return (i < 0 || i >= getTabCount()) ? null : (C0087e) this.f358o.get(i);
    }

    public void m467a(int i, float f, boolean z) {
        m468a(i, f, z, true);
    }

    void m468a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.f360q.getChildCount()) {
            if (z2) {
                this.f360q.m412a(i, f);
            }
            if (this.f368y != null && this.f368y.m636b()) {
                this.f368y.m638d();
            }
            scrollTo(m448a(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public void m469a(C0080b c0080b) {
        if (!this.f366w.contains(c0080b)) {
            this.f366w.add(c0080b);
        }
    }

    public void m470a(C0087e c0087e) {
        m472a(c0087e, this.f358o.isEmpty());
    }

    public void m471a(C0087e c0087e, int i, boolean z) {
        if (c0087e.f319a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m450a(c0087e, i);
        m459d(c0087e);
        if (z) {
            c0087e.m428e();
        }
    }

    public void m472a(C0087e c0087e, boolean z) {
        m471a(c0087e, this.f358o.size(), z);
    }

    public void m473a(ViewPager viewPager, boolean z) {
        m452a(viewPager, z, false);
    }

    void m474a(aa aaVar, boolean z) {
        if (!(this.f369z == null || this.f340A == null)) {
            this.f369z.unregisterDataSetObserver(this.f340A);
        }
        this.f369z = aaVar;
        if (z && aaVar != null) {
            if (this.f340A == null) {
                this.f340A = new C0081c(this);
            }
            aaVar.registerDataSetObserver(this.f340A);
        }
        m481c();
    }

    void m475a(boolean z) {
        for (int i = 0; i < this.f360q.getChildCount(); i++) {
            View childAt = this.f360q.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            m454a((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public void addView(View view) {
        m453a(view);
    }

    public void addView(View view, int i) {
        m453a(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m453a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m453a(view);
    }

    int m476b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    public void m477b() {
        for (int childCount = this.f360q.getChildCount() - 1; childCount >= 0; childCount--) {
            m456c(childCount);
        }
        Iterator it = this.f358o.iterator();
        while (it.hasNext()) {
            C0087e c0087e = (C0087e) it.next();
            it.remove();
            c0087e.m432i();
            f339n.m1030a(c0087e);
        }
        this.f359p = null;
    }

    public void m478b(C0080b c0080b) {
        this.f366w.remove(c0080b);
    }

    void m479b(C0087e c0087e) {
        m480b(c0087e, true);
    }

    void m480b(C0087e c0087e, boolean z) {
        C0087e c0087e2 = this.f359p;
        if (c0087e2 != c0087e) {
            int c = c0087e != null ? c0087e.m426c() : -1;
            if (z) {
                if ((c0087e2 == null || c0087e2.m426c() == -1) && c != -1) {
                    m467a(c, 0.0f, true);
                } else {
                    m458d(c);
                }
                if (c != -1) {
                    setSelectedTabView(c);
                }
            }
            if (c0087e2 != null) {
                m463f(c0087e2);
            }
            this.f359p = c0087e;
            if (c0087e != null) {
                m461e(c0087e);
            }
        } else if (c0087e2 != null) {
            m464g(c0087e);
            m458d(c0087e.m426c());
        }
    }

    void m481c() {
        m477b();
        if (this.f369z != null) {
            int i;
            int count = this.f369z.getCount();
            for (i = 0; i < count; i++) {
                m472a(m465a().m421a(this.f369z.getPageTitle(i)), false);
            }
            if (this.f357m != null && count > 0) {
                i = this.f357m.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    m479b(m466a(i));
                }
            }
        }
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        return this.f359p != null ? this.f359p.m426c() : -1;
    }

    public int getTabCount() {
        return this.f358o.size();
    }

    public int getTabGravity() {
        return this.f355k;
    }

    int getTabMaxWidth() {
        return this.f354j;
    }

    public int getTabMode() {
        return this.f356l;
    }

    public ColorStateList getTabTextColors() {
        return this.f350f;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f357m == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m452a((ViewPager) parent, true, true);
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f343D) {
            setupWithViewPager(null);
            this.f343D = false;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int b = (m476b(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(b, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                i2 = MeasureSpec.makeMeasureSpec(b, 1073741824);
                break;
        }
        b = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            this.f354j = this.f362s > 0 ? this.f362s : b - m476b(56);
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.f356l) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        b = 0;
                        break;
                    } else {
                        b = 1;
                        break;
                    }
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    b = i3;
                    break;
                default:
                    b = 0;
                    break;
            }
            if (b != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(C0080b c0080b) {
        if (this.f365v != null) {
            m478b(this.f365v);
        }
        this.f365v = c0080b;
        if (c0080b != null) {
            m469a(c0080b);
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f360q.m411a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f360q.m416b(i);
    }

    public void setTabGravity(int i) {
        if (this.f355k != i) {
            this.f355k = i;
            m462f();
        }
    }

    public void setTabMode(int i) {
        if (i != this.f356l) {
            this.f356l = i;
            m462f();
        }
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f350f != colorStateList) {
            this.f350f = colorStateList;
            m457d();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(aa aaVar) {
        m474a(aaVar, false);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m473a(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
