package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0035a.C0028c;
import android.support.design.C0035a.C0029d;
import android.support.design.C0035a.C0030e;
import android.support.design.C0035a.C0032g;
import android.support.v4.p005c.p006a.C0242a;
import android.support.v4.p009b.p010a.C0212d;
import android.support.v4.view.C0036a;
import android.support.v4.view.aj;
import android.support.v4.view.p015a.C0404c;
import android.support.v4.widget.C0596w;
import android.support.v7.appcompat.C0627R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends C0038a implements ItemView {
    private static final int[] f125d;
    boolean f126c;
    private final int f127e;
    private boolean f128f;
    private final CheckedTextView f129g;
    private FrameLayout f130h;
    private MenuItemImpl f131i;
    private ColorStateList f132j;
    private boolean f133k;
    private Drawable f134l;
    private final C0036a f135m;

    /* renamed from: android.support.design.internal.NavigationMenuItemView.1 */
    class C00371 extends C0036a {
        final /* synthetic */ NavigationMenuItemView f118a;

        C00371(NavigationMenuItemView navigationMenuItemView) {
            this.f118a = navigationMenuItemView;
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0404c c0404c) {
            super.onInitializeAccessibilityNodeInfo(view, c0404c);
            c0404c.m1508a(this.f118a.f126c);
        }
    }

    static {
        f125d = new int[]{16842912};
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f135m = new C00371(this);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0032g.design_navigation_menu_item, this, true);
        this.f127e = context.getResources().getDimensionPixelSize(C0028c.design_navigation_icon_size);
        this.f129g = (CheckedTextView) findViewById(C0030e.design_menu_item_text);
        this.f129g.setDuplicateParentStateEnabled(true);
        aj.m1861a(this.f129g, this.f135m);
    }

    private boolean m84a() {
        return this.f131i.getTitle() == null && this.f131i.getIcon() == null && this.f131i.getActionView() != null;
    }

    private void m85b() {
        if (m84a()) {
            this.f129g.setVisibility(8);
            if (this.f130h != null) {
                LayoutParams layoutParams = (LayoutParams) this.f130h.getLayoutParams();
                layoutParams.width = -1;
                this.f130h.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f129g.setVisibility(0);
        if (this.f130h != null) {
            layoutParams = (LayoutParams) this.f130h.getLayoutParams();
            layoutParams.width = -2;
            this.f130h.setLayoutParams(layoutParams);
        }
    }

    private StateListDrawable m86c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0627R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f125d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f130h == null) {
                this.f130h = (FrameLayout) ((ViewStub) findViewById(C0030e.design_menu_item_action_area_stub)).inflate();
            }
            this.f130h.removeAllViews();
            this.f130h.addView(view);
        }
    }

    public MenuItemImpl getItemData() {
        return this.f131i;
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f131i = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            aj.m1860a((View) this, m86c());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        m85b();
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f131i != null && this.f131i.isCheckable() && this.f131i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f125d);
        }
        return onCreateDrawableState;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f126c != z) {
            this.f126c = z;
            this.f135m.sendAccessibilityEvent(this.f129g, ItemAnimator.FLAG_MOVED);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f129g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f133k) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = C0242a.m861f(drawable).mutate();
                C0242a.m851a(drawable, this.f132j);
            }
            drawable.setBounds(0, 0, this.f127e, this.f127e);
        } else if (this.f128f) {
            if (this.f134l == null) {
                this.f134l = C0212d.m749a(getResources(), C0029d.navigation_empty_icon, getContext().getTheme());
                if (this.f134l != null) {
                    this.f134l.setBounds(0, 0, this.f127e, this.f127e);
                }
            }
            drawable = this.f134l;
        }
        C0596w.m2540a(this.f129g, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f132j = colorStateList;
        this.f133k = this.f132j != null;
        if (this.f131i != null) {
            setIcon(this.f131i.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f128f = z;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearance(int i) {
        C0596w.m2539a(this.f129g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f129g.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f129g.setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }
}
