package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p005c.p006a.C0242a;
import android.support.v4.widget.C0557b;
import android.support.v7.appcompat.C0627R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList;
    private Mode mButtonTintMode;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(Drawable drawable);
    }

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = compoundButton;
    }

    void applyButtonTint() {
        Drawable a = C0557b.m2425a(this.mView);
        if (a == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            a = C0242a.m861f(a).mutate();
            if (this.mHasButtonTint) {
                C0242a.m851a(a, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                C0242a.m854a(a, this.mButtonTintMode);
            }
            if (a.isStateful()) {
                a.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(a);
        }
    }

    int getCompoundPaddingLeft(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0557b.m2425a(this.mView);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, C0627R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0627R.styleable.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0627R.styleable.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0627R.styleable.CompoundButton_buttonTint)) {
                C0557b.m2426a(this.mView, obtainStyledAttributes.getColorStateList(C0627R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0627R.styleable.CompoundButton_buttonTintMode)) {
                C0557b.m2427a(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0627R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    void setSupportButtonTintMode(Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
