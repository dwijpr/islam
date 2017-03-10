package com.andi.alquran.arabic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.andi.alquran.C0861R;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"RtlHardcoded"})
public class ArabView extends TextView {
    private final ArrayList<C0874a> f1624a;
    private final Paint f1625b;
    private final StringBuffer f1626c;
    private String[] f1627d;
    private int f1628e;
    private int f1629f;
    private int f1630g;
    private int f1631h;
    private C0875a f1632i;

    /* renamed from: com.andi.alquran.arabic.ArabView.a */
    private static class C0874a {
        int f1618a;
        int f1619b;
        int f1620c;
        int f1621d;
        int f1622e;
        int f1623f;

        private C0874a() {
        }
    }

    public ArabView(Context context) {
        super(context);
        this.f1624a = new ArrayList();
        this.f1625b = new Paint();
        this.f1626c = new StringBuffer();
        this.f1627d = new String[0];
        setGravity(5);
        this.f1632i = C0875a.m3035a();
    }

    public ArabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1624a = new ArrayList();
        this.f1625b = new Paint();
        this.f1626c = new StringBuffer();
        this.f1627d = new String[0];
        setGravity(5);
        this.f1632i = C0875a.m3035a();
    }

    private int m3028a(int i, int i2) {
        int length = this.f1627d.length - 1;
        int textSize = (int) getTextSize();
        int[] b = m3033b(m3030a(this.f1626c, i, length), textSize);
        if (i2 < b[0] && i < length) {
            int i3 = b[0];
            length--;
            int i4 = 0;
            int i5 = i;
            while (length > i5) {
                int i6;
                int i7 = (i5 + 1) + (((length - i5) * (i2 - i4)) / (i3 - i4));
                int[] b2 = m3033b(m3030a(this.f1626c, i, i7), textSize);
                if (i2 < b2[0]) {
                    length = i7 - 1;
                    i3 = b2[0];
                    i6 = length;
                    length = i5;
                } else {
                    i4 = b2[0];
                    b = b2;
                    i6 = length;
                    length = i7;
                }
                i5 = length;
                length = i6;
            }
        }
        C0874a c0874a = new C0874a();
        c0874a.f1618a = this.f1624a.size();
        c0874a.f1619b = i;
        c0874a.f1620c = length;
        c0874a.f1621d = b[0];
        c0874a.f1622e = b[1];
        c0874a.f1623f = this.f1630g - b[2];
        this.f1624a.add(c0874a);
        return length + 1;
    }

    private Bitmap m3029a(String str, int i) {
        Bitmap a = this.f1632i.m3036a(str);
        if (a != null) {
            return a;
        }
        a = BacaArab.setTextEnd(str, i);
        this.f1632i.m3037a(str, a);
        return a;
    }

    private String m3030a(StringBuffer stringBuffer, int i, int i2) {
        stringBuffer.setLength(0);
        for (int i3 = i; i3 <= i2; i3++) {
            if (i3 > i) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(this.f1627d[i3]);
        }
        return stringBuffer.toString();
    }

    private void m3031a(int i) {
        int i2 = 0;
        this.f1624a.clear();
        int i3 = 0;
        while (i3 < this.f1627d.length) {
            i3 = m3028a(i3, i);
        }
        this.f1628e = 0;
        if (this.f1624a.size() > 0) {
            C0874a c0874a = (C0874a) this.f1624a.get(0);
            if (c0874a.f1623f < 0) {
                this.f1628e = -c0874a.f1623f;
            }
            c0874a = (C0874a) this.f1624a.get(this.f1624a.size() - 1);
            if (c0874a.f1623f + c0874a.f1622e > this.f1629f) {
                i2 = (c0874a.f1622e + c0874a.f1623f) - this.f1629f;
            }
        }
        this.f1631h = (this.f1628e + i2) + (this.f1629f * this.f1624a.size());
    }

    public static String[] m3032a(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.trim().split(" +");
        int length = split.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            String str3 = split[i];
            if (str3.length() > 0 && str3.charAt(0) >= '\u06d6' && str2 != null) {
                str3 = str2 + ' ' + str3;
                arrayList.remove(arrayList.size() - 1);
            }
            arrayList.add(str3);
            i++;
            str2 = str3;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private int[] m3033b(String str, int i) {
        int[] b = this.f1632i.m3040b(str);
        if (b != null) {
            return b;
        }
        b = BacaArab.setBitmap(str, i);
        this.f1632i.m3038a(str, b);
        return b;
    }

    public int getLineCount() {
        return this.f1624a.size();
    }

    public int getLineHeight() {
        return this.f1629f;
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int width = (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        int height = (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
        int currentTextColor = getCurrentTextColor();
        this.f1625b.setColorFilter(new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) Color.red(currentTextColor), 0.0f, 0.0f, 0.0f, 0.0f, (float) Color.green(currentTextColor), 0.0f, 0.0f, 0.0f, 0.0f, (float) Color.blue(currentTextColor), 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        Rect clipBounds = canvas.getClipBounds();
        int textSize = (int) getTextSize();
        Iterator it = this.f1624a.iterator();
        while (it.hasNext()) {
            C0874a c0874a = (C0874a) it.next();
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int gravity = getGravity() & 7;
            if (gravity == 5) {
                compoundPaddingLeft += width - c0874a.f1621d;
            } else if (gravity == 1) {
                compoundPaddingLeft += (width - c0874a.f1621d) / 2;
            }
            gravity = ((getCompoundPaddingTop() + this.f1628e) + (c0874a.f1618a * this.f1629f)) + c0874a.f1623f;
            int gravity2 = getGravity() & C0861R.styleable.AppCompatTheme_spinnerStyle;
            if (gravity2 == 80) {
                gravity += height - this.f1631h;
            } else if (gravity2 == 16) {
                gravity += (height - this.f1631h) / 2;
            }
            if (clipBounds.intersects(compoundPaddingLeft, gravity, c0874a.f1621d + compoundPaddingLeft, c0874a.f1622e + gravity)) {
                canvas.drawBitmap(m3029a(m3030a(this.f1626c, c0874a.f1619b, c0874a.f1620c), textSize), new Rect(0, 0, c0874a.f1621d, c0874a.f1622e), new Rect(compoundPaddingLeft, gravity, c0874a.f1621d + compoundPaddingLeft, c0874a.f1622e + gravity), this.f1625b);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int max;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int[] b = m3033b(m3030a(this.f1626c, 0, this.f1627d.length - 1), (int) getTextSize());
        int i3 = b[0];
        this.f1629f = b[3];
        this.f1630g = b[4];
        if (mode != 1073741824) {
            max = Math.max((getCompoundPaddingLeft() + i3) + getCompoundPaddingRight(), getSuggestedMinimumWidth());
            size = mode == RtlSpacingHelper.UNDEFINED ? Math.min(max, size) : max;
        }
        m3031a((size - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        if (mode2 == 1073741824) {
            max = size2;
        } else {
            max = Math.max((this.f1631h + getCompoundPaddingTop()) + getCompoundPaddingBottom(), getSuggestedMinimumHeight());
            if (mode2 == RtlSpacingHelper.UNDEFINED) {
                max = Math.min(max, size2);
            }
        }
        setMeasuredDimension(size, max);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.f1627d = m3032a(charSequence.toString());
        requestLayout();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        requestLayout();
    }
}
