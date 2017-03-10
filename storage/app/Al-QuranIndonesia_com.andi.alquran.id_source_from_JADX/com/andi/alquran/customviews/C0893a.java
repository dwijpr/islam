package com.andi.alquran.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import com.andi.alquran.ActivityPTimeQibla;
import com.andi.alquran.C0861R;

/* renamed from: com.andi.alquran.customviews.a */
public class C0893a extends View {
    private float f1742a;
    private float f1743b;
    private Bitmap f1744c;
    private Bitmap f1745d;
    private Matrix f1746e;
    private int f1747f;
    private int f1748g;
    private float f1749h;
    private float f1750i;

    public C0893a(Context context) {
        super(context);
        this.f1742a = 0.0f;
        this.f1743b = 0.0f;
        this.f1746e = new Matrix();
        this.f1747f = 240;
        this.f1748g = 240;
        this.f1749h = ((float) this.f1747f) * 0.5f;
        this.f1750i = ((float) this.f1748g) * 0.5f;
        m3106a();
    }

    private void m3106a() {
        this.f1745d = BitmapFactory.decodeResource(getResources(), C0861R.drawable.qibla_pin);
        this.f1744c = BitmapFactory.decodeResource(getResources(), C0861R.drawable.qibla_compass);
        this.f1747f = this.f1744c.getWidth() * 2;
        this.f1748g = this.f1744c.getHeight() * 2;
        this.f1749h = ((float) this.f1747f) * 0.5f;
        this.f1750i = ((float) this.f1748g) * 0.5f;
        this.f1746e.postTranslate(this.f1749h - ((float) (this.f1745d.getWidth() / 2)), this.f1750i - ((float) (this.f1745d.getHeight() / 2)));
        invalidate();
    }

    public void m3107a(float f, float f2) {
        this.f1742a = f;
        this.f1743b = f2;
        this.f1746e = new Matrix();
        this.f1746e.postRotate((float) ActivityPTimeQibla.f1291a, (float) (this.f1745d.getWidth() / 2), (float) (this.f1745d.getHeight() / 2));
        this.f1746e.postTranslate(this.f1749h - ((float) (this.f1745d.getWidth() / 2)), this.f1750i - ((float) (this.f1745d.getHeight() / 2)));
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        canvas.rotate(-this.f1742a, this.f1749h, this.f1750i);
        canvas.drawBitmap(this.f1744c, (float) (this.f1744c.getWidth() / 2), (float) (this.f1744c.getHeight() / 2), paint);
        canvas.drawBitmap(this.f1745d, this.f1746e, paint);
    }

    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f1747f, this.f1748g);
    }
}
