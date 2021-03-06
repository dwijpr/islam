package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.C0534t;
import android.support.v4.view.ay;
import android.support.v4.widget.C0574l;
import android.support.v7.appcompat.C0627R;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;

class DropDownListView extends ListViewCompat {
    private ay mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private C0574l mScrollHelper;

    public DropDownListView(Context context, boolean z) {
        super(context, null, C0627R.attr.dropDownListViewStyle);
        this.mHijackFocus = z;
        setCacheColorHint(0);
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.mClickAnimation != null) {
            this.mClickAnimation.m2068b();
            this.mClickAnimation = null;
        }
    }

    private void clickPressedItem(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void setPressedItem(View view, int i, float f, float f2) {
        this.mDrawsInPressedState = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.mMotionPosition != -1) {
            View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.mMotionPosition = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public boolean hasFocus() {
        return this.mHijackFocus || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.mHijackFocus || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.mHijackFocus || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }

    public boolean onForwardedEvent(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = C0534t.m2226a(motionEvent);
        switch (a) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                z = false;
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                z = true;
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                setPressedItem(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    clickPressedItem(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            clearPressedItem();
        }
        if (z2) {
            if (this.mScrollHelper == null) {
                this.mScrollHelper = new C0574l(this);
            }
            this.mScrollHelper.m2361a(true);
            this.mScrollHelper.onTouch(this, motionEvent);
        } else if (this.mScrollHelper != null) {
            this.mScrollHelper.m2361a(false);
        }
        return z2;
    }

    void setListSelectionHidden(boolean z) {
        this.mListSelectionHidden = z;
    }

    protected boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
    }
}
