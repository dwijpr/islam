package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class Space extends View {
    public Space(Context context) {
        this(context, null);
    }

    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Space(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    private static int m2338a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public void draw(Canvas canvas) {
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m2338a(getSuggestedMinimumWidth(), i), m2338a(getSuggestedMinimumHeight(), i2));
    }
}
