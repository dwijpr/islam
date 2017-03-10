package android.support.p003a.p004a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.p005c.p006a.C0242a;
import android.support.v4.p014g.C0298a;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@SuppressLint({"NewApi"})
/* renamed from: android.support.a.a.b */
public class C0013b extends C0012e implements Animatable {
    final Callback f41a;
    private C0009a f42c;
    private Context f43d;
    private ArgbEvaluator f44e;

    /* renamed from: android.support.a.a.b.1 */
    class C00081 implements Callback {
        final /* synthetic */ C0013b f34a;

        C00081(C0013b c0013b) {
            this.f34a = c0013b;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f34a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f34a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f34a.unscheduleSelf(runnable);
        }
    }

    /* renamed from: android.support.a.a.b.a */
    private static class C0009a extends ConstantState {
        int f35a;
        C0025f f36b;
        ArrayList<Animator> f37c;
        C0298a<Animator, String> f38d;

        public C0009a(Context context, C0009a c0009a, Callback callback, Resources resources) {
            int i = 0;
            if (c0009a != null) {
                this.f35a = c0009a.f35a;
                if (c0009a.f36b != null) {
                    ConstantState constantState = c0009a.f36b.getConstantState();
                    if (resources != null) {
                        this.f36b = (C0025f) constantState.newDrawable(resources);
                    } else {
                        this.f36b = (C0025f) constantState.newDrawable();
                    }
                    this.f36b = (C0025f) this.f36b.mutate();
                    this.f36b.setCallback(callback);
                    this.f36b.setBounds(c0009a.f36b.getBounds());
                    this.f36b.m83a(false);
                }
                if (c0009a.f37c != null) {
                    int size = c0009a.f37c.size();
                    this.f37c = new ArrayList(size);
                    this.f38d = new C0298a(size);
                    while (i < size) {
                        Animator animator = (Animator) c0009a.f37c.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c0009a.f38d.get(animator);
                        clone.setTarget(this.f36b.m82a(str));
                        this.f37c.add(clone);
                        this.f38d.put(clone, str);
                        i++;
                    }
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f35a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* renamed from: android.support.a.a.b.b */
    private static class C0010b extends ConstantState {
        private final ConstantState f39a;

        public C0010b(ConstantState constantState) {
            this.f39a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f39a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f39a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable c0013b = new C0013b();
            c0013b.b = this.f39a.newDrawable();
            c0013b.b.setCallback(c0013b.f41a);
            return c0013b;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0013b = new C0013b();
            c0013b.b = this.f39a.newDrawable(resources);
            c0013b.b.setCallback(c0013b.f41a);
            return c0013b;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0013b = new C0013b();
            c0013b.b = this.f39a.newDrawable(resources, theme);
            c0013b.b.setCallback(c0013b.f41a);
            return c0013b;
        }
    }

    C0013b() {
        this(null, null, null);
    }

    private C0013b(Context context) {
        this(context, null, null);
    }

    private C0013b(Context context, C0009a c0009a, Resources resources) {
        this.f44e = null;
        this.f41a = new C00081(this);
        this.f43d = context;
        if (c0009a != null) {
            this.f42c = c0009a;
        } else {
            this.f42c = new C0009a(context, c0009a, this.f41a, resources);
        }
    }

    public static C0013b m21a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0013b c0013b = new C0013b(context);
        c0013b.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0013b;
    }

    private void m22a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m22a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f44e == null) {
                    this.f44e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f44e);
            }
        }
    }

    private void m23a(String str, Animator animator) {
        animator.setTarget(this.f42c.f36b.m82a(str));
        if (VERSION.SDK_INT < 21) {
            m22a(animator);
        }
        if (this.f42c.f37c == null) {
            this.f42c.f37c = new ArrayList();
            this.f42c.f38d = new C0298a();
        }
        this.f42c.f37c.add(animator);
        this.f42c.f38d.put(animator, str);
    }

    private boolean m24a() {
        ArrayList arrayList = this.f42c.f37c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.b != null) {
            C0242a.m852a(this.b, theme);
        }
    }

    public boolean canApplyTheme() {
        return this.b != null ? C0242a.m859d(this.b) : false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        this.f42c.f36b.draw(canvas);
        if (m24a()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.b != null ? C0242a.m858c(this.b) : this.f42c.f36b.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.f42c.f35a;
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        return this.b != null ? new C0010b(this.b.getConstantState()) : null;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : this.f42c.f36b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : this.f42c.f36b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.b != null ? this.b.getOpacity() : this.f42c.f36b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            C0242a.m853a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1) {
            if (xmlPullParser.getDepth() >= depth || eventType != 3) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    TypedArray a;
                    if ("animated-vector".equals(name)) {
                        a = C0012e.m20a(resources, theme, attributeSet, C0007a.f32e);
                        int resourceId = a.getResourceId(0, 0);
                        if (resourceId != 0) {
                            C0025f a2 = C0025f.m76a(resources, resourceId, theme);
                            a2.m83a(false);
                            a2.setCallback(this.f41a);
                            if (this.f42c.f36b != null) {
                                this.f42c.f36b.setCallback(null);
                            }
                            this.f42c.f36b = a2;
                        }
                        a.recycle();
                    } else if ("target".equals(name)) {
                        a = resources.obtainAttributes(attributeSet, C0007a.f33f);
                        String string = a.getString(0);
                        int resourceId2 = a.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            if (this.f43d != null) {
                                m23a(string, AnimatorInflater.loadAnimator(this.f43d, resourceId2));
                            } else {
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                        }
                        a.recycle();
                    } else {
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    public boolean isAutoMirrored() {
        return this.b != null ? C0242a.m856b(this.b) : this.f42c.f36b.isAutoMirrored();
    }

    public boolean isRunning() {
        if (this.b != null) {
            return ((AnimatedVectorDrawable) this.b).isRunning();
        }
        ArrayList arrayList = this.f42c.f37c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStateful() {
        return this.b != null ? this.b.isStateful() : this.f42c.f36b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        } else {
            this.f42c.f36b.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.b != null ? this.b.setLevel(i) : this.f42c.f36b.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        return this.b != null ? this.b.setState(iArr) : this.f42c.f36b.setState(iArr);
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else {
            this.f42c.f36b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            this.b.setAutoMirrored(z);
        } else {
            this.f42c.f36b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
        } else {
            this.f42c.f36b.setColorFilter(colorFilter);
        }
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.b != null) {
            C0242a.m849a(this.b, i);
        } else {
            this.f42c.f36b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            C0242a.m851a(this.b, colorStateList);
        } else {
            this.f42c.f36b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            C0242a.m854a(this.b, mode);
        } else {
            this.f42c.f36b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        this.f42c.f36b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).start();
        } else if (!m24a()) {
            ArrayList arrayList = this.f42c.f37c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).stop();
            return;
        }
        ArrayList arrayList = this.f42c.f37c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
