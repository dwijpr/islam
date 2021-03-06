package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0242a;
import android.support.v4.view.aj;
import android.support.v7.appcompat.C0627R;
import android.util.AttributeSet;
import android.widget.SeekBar;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList;
    private Mode mTickMarkTintMode;
    private final SeekBar mView;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = seekBar;
    }

    private void applyTickMarkTint() {
        if (this.mTickMark == null) {
            return;
        }
        if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
            this.mTickMark = C0242a.m861f(this.mTickMark.mutate());
            if (this.mHasTickMarkTint) {
                C0242a.m851a(this.mTickMark, this.mTickMarkTintList);
            }
            if (this.mHasTickMarkTintMode) {
                C0242a.m854a(this.mTickMark, this.mTickMarkTintMode);
            }
            if (this.mTickMark.isStateful()) {
                this.mTickMark.setState(this.mView.getDrawableState());
            }
        }
    }

    void drawTickMarks(Canvas canvas) {
        int i = 1;
        if (this.mTickMark != null) {
            int max = this.mView.getMax();
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.mTickMark.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight())) / ((float) max);
                intrinsicHeight = canvas.save();
                canvas.translate((float) this.mView.getPaddingLeft(), (float) (this.mView.getHeight() / 2));
                for (i = 0; i <= max; i++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicHeight);
            }
        }
    }

    void drawableStateChanged() {
        Drawable drawable = this.mTickMark;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.mView.getDrawableState())) {
            this.mView.invalidateDrawable(drawable);
        }
    }

    Drawable getTickMark() {
        return this.mTickMark;
    }

    ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    @TargetApi(11)
    void jumpDrawablesToCurrentState() {
        if (this.mTickMark != null) {
            this.mTickMark.jumpToCurrentState();
        }
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, C0627R.styleable.AppCompatSeekBar, i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(C0627R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.mView.setThumb(drawableIfKnown);
        }
        setTickMark(obtainStyledAttributes.getDrawable(C0627R.styleable.AppCompatSeekBar_tickMark));
        if (obtainStyledAttributes.hasValue(C0627R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0627R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(C0627R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.mTickMarkTintList = obtainStyledAttributes.getColorStateList(C0627R.styleable.AppCompatSeekBar_tickMarkTint);
            this.mHasTickMarkTint = true;
        }
        obtainStyledAttributes.recycle();
        applyTickMarkTint();
    }

    void setTickMark(Drawable drawable) {
        if (this.mTickMark != null) {
            this.mTickMark.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this.mView);
            C0242a.m857b(drawable, aj.m1884g(this.mView));
            if (drawable.isStateful()) {
                drawable.setState(this.mView.getDrawableState());
            }
            applyTickMarkTint();
        }
        this.mView.invalidate();
    }

    void setTickMarkTintList(ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    void setTickMarkTintMode(Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }
}
