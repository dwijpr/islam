package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.C0036a;
import android.support.v4.view.aj;
import android.support.v4.view.p015a.C0404c;
import android.support.v7.appcompat.C0627R;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] f209a;
    private boolean f210b;

    /* renamed from: android.support.design.widget.CheckableImageButton.1 */
    class C00571 extends C0036a {
        final /* synthetic */ CheckableImageButton f208a;

        C00571(CheckableImageButton checkableImageButton) {
            this.f208a = checkableImageButton;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(this.f208a.isChecked());
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0404c c0404c) {
            super.onInitializeAccessibilityNodeInfo(view, c0404c);
            c0404c.m1508a(true);
            c0404c.m1512b(this.f208a.isChecked());
        }
    }

    static {
        f209a = new int[]{16842912};
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0627R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aj.m1861a((View) this, new C00571(this));
    }

    public boolean isChecked() {
        return this.f210b;
    }

    public int[] onCreateDrawableState(int i) {
        return this.f210b ? mergeDrawableStates(super.onCreateDrawableState(f209a.length + i), f209a) : super.onCreateDrawableState(i);
    }

    public void setChecked(boolean z) {
        if (this.f210b != z) {
            this.f210b = z;
            refreshDrawableState();
            sendAccessibilityEvent(ItemAnimator.FLAG_MOVED);
        }
    }

    public void toggle() {
        setChecked(!this.f210b);
    }
}
