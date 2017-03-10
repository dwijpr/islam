package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p009b.C0173a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.GoogleMap;

public class PagerTabStrip extends ab {
    private int f765g;
    private int f766h;
    private int f767i;
    private int f768j;
    private int f769k;
    private int f770l;
    private final Paint f771m;
    private final Rect f772n;
    private int f773o;
    private boolean f774p;
    private boolean f775q;
    private int f776r;
    private boolean f777s;
    private float f778t;
    private float f779u;
    private int f780v;

    /* renamed from: android.support.v4.view.PagerTabStrip.1 */
    class C03621 implements OnClickListener {
        final /* synthetic */ PagerTabStrip f746a;

        C03621(PagerTabStrip pagerTabStrip) {
            this.f746a = pagerTabStrip;
        }

        public void onClick(View view) {
            this.f746a.a.setCurrentItem(this.f746a.a.getCurrentItem() - 1);
        }
    }

    /* renamed from: android.support.v4.view.PagerTabStrip.2 */
    class C03632 implements OnClickListener {
        final /* synthetic */ PagerTabStrip f747a;

        C03632(PagerTabStrip pagerTabStrip) {
            this.f747a = pagerTabStrip;
        }

        public void onClick(View view) {
            this.f747a.a.setCurrentItem(this.f747a.a.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f771m = new Paint();
        this.f772n = new Rect();
        this.f773o = 255;
        this.f774p = false;
        this.f775q = false;
        this.f765g = this.f;
        this.f771m.setColor(this.f765g);
        float f = context.getResources().getDisplayMetrics().density;
        this.f766h = (int) ((3.0f * f) + 0.5f);
        this.f767i = (int) ((6.0f * f) + 0.5f);
        this.f768j = (int) (64.0f * f);
        this.f770l = (int) ((16.0f * f) + 0.5f);
        this.f776r = (int) ((1.0f * f) + 0.5f);
        this.f769k = (int) ((f * 32.0f) + 0.5f);
        this.f780v = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener(new C03621(this));
        this.d.setFocusable(true);
        this.d.setOnClickListener(new C03632(this));
        if (getBackground() == null) {
            this.f774p = true;
        }
    }

    void m1281a(int i, float f, boolean z) {
        Rect rect = this.f772n;
        int height = getHeight();
        int i2 = height - this.f766h;
        rect.set(this.c.getLeft() - this.f770l, i2, this.c.getRight() + this.f770l, height);
        super.m1278a(i, f, z);
        this.f773o = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.c.getLeft() - this.f770l, i2, this.c.getRight() + this.f770l, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f774p;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f769k);
    }

    public int getTabIndicatorColor() {
        return this.f765g;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.f770l;
        int right = this.c.getRight() + this.f770l;
        int i = height - this.f766h;
        this.f771m.setColor((this.f773o << 24) | (this.f765g & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.f771m);
        if (this.f774p) {
            this.f771m.setColor(-16777216 | (this.f765g & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f776r), (float) (getWidth() - getPaddingRight()), (float) height, this.f771m);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f777s) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                this.f778t = x;
                this.f779u = y;
                this.f777s = false;
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                if (x >= ((float) (this.c.getLeft() - this.f770l))) {
                    if (x > ((float) (this.c.getRight() + this.f770l))) {
                        this.a.setCurrentItem(this.a.getCurrentItem() + 1);
                        break;
                    }
                }
                this.a.setCurrentItem(this.a.getCurrentItem() - 1);
                break;
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                if (Math.abs(x - this.f778t) > ((float) this.f780v) || Math.abs(y - this.f779u) > ((float) this.f780v)) {
                    this.f777s = true;
                    break;
                }
        }
        return true;
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.f775q) {
            this.f774p = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f775q) {
            this.f774p = drawable == null;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.f775q) {
            this.f774p = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f774p = z;
        this.f775q = true;
        invalidate();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f767i) {
            i4 = this.f767i;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(int i) {
        this.f765g = i;
        this.f771m.setColor(this.f765g);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(C0173a.getColor(getContext(), i));
    }

    public void setTextSpacing(int i) {
        if (i < this.f768j) {
            i = this.f768j;
        }
        super.setTextSpacing(i);
    }
}
