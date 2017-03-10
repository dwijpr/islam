package android.support.p003a.p004a;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.p003a.p004a.C0016c.C0015b;
import android.support.v4.p005c.p006a.C0242a;
import android.support.v4.p009b.p010a.C0212d;
import android.support.v4.p014g.C0298a;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.a.a.f */
public class C0025f extends C0012e {
    static final Mode f107a;
    private C0023f f108c;
    private PorterDuffColorFilter f109d;
    private ColorFilter f110e;
    private boolean f111f;
    private boolean f112g;
    private ConstantState f113h;
    private final float[] f114i;
    private final Matrix f115j;
    private final Rect f116k;

    /* renamed from: android.support.a.a.f.d */
    private static class C0018d {
        protected C0015b[] f49m;
        String f50n;
        int f51o;

        public C0018d() {
            this.f49m = null;
        }

        public C0018d(C0018d c0018d) {
            this.f49m = null;
            this.f50n = c0018d.f50n;
            this.f51o = c0018d.f51o;
            this.f49m = C0016c.m35a(c0018d.f49m);
        }

        public void m43a(Path path) {
            path.reset();
            if (this.f49m != null) {
                C0015b.m28a(this.f49m, path);
            }
        }

        public boolean m44a() {
            return false;
        }

        public C0015b[] getPathData() {
            return this.f49m;
        }

        public String getPathName() {
            return this.f50n;
        }

        public void setPathData(C0015b[] c0015bArr) {
            if (C0016c.m32a(this.f49m, c0015bArr)) {
                C0016c.m36b(this.f49m, c0015bArr);
            } else {
                this.f49m = C0016c.m35a(c0015bArr);
            }
        }
    }

    /* renamed from: android.support.a.a.f.a */
    private static class C0019a extends C0018d {
        public C0019a(C0019a c0019a) {
            super(c0019a);
        }

        private void m45a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = C0016c.m34a(string);
            }
        }

        public void m46a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0017d.m41a(xmlPullParser, "pathData")) {
                TypedArray a = C0012e.m20a(resources, theme, attributeSet, C0007a.f31d);
                m45a(a);
                a.recycle();
            }
        }

        public boolean m47a() {
            return true;
        }
    }

    /* renamed from: android.support.a.a.f.b */
    private static class C0020b extends C0018d {
        int f52a;
        float f53b;
        int f54c;
        float f55d;
        int f56e;
        float f57f;
        float f58g;
        float f59h;
        float f60i;
        Cap f61j;
        Join f62k;
        float f63l;
        private int[] f64p;

        public C0020b() {
            this.f52a = 0;
            this.f53b = 0.0f;
            this.f54c = 0;
            this.f55d = 1.0f;
            this.f57f = 1.0f;
            this.f58g = 0.0f;
            this.f59h = 1.0f;
            this.f60i = 0.0f;
            this.f61j = Cap.BUTT;
            this.f62k = Join.MITER;
            this.f63l = 4.0f;
        }

        public C0020b(C0020b c0020b) {
            super(c0020b);
            this.f52a = 0;
            this.f53b = 0.0f;
            this.f54c = 0;
            this.f55d = 1.0f;
            this.f57f = 1.0f;
            this.f58g = 0.0f;
            this.f59h = 1.0f;
            this.f60i = 0.0f;
            this.f61j = Cap.BUTT;
            this.f62k = Join.MITER;
            this.f63l = 4.0f;
            this.f64p = c0020b.f64p;
            this.f52a = c0020b.f52a;
            this.f53b = c0020b.f53b;
            this.f55d = c0020b.f55d;
            this.f54c = c0020b.f54c;
            this.f56e = c0020b.f56e;
            this.f57f = c0020b.f57f;
            this.f58g = c0020b.f58g;
            this.f59h = c0020b.f59h;
            this.f60i = c0020b.f60i;
            this.f61j = c0020b.f61j;
            this.f62k = c0020b.f62k;
            this.f63l = c0020b.f63l;
        }

        private Cap m48a(int i, Cap cap) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    return Cap.BUTT;
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    return Cap.ROUND;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join m49a(int i, Join join) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    return Join.MITER;
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    return Join.ROUND;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        private void m50a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f64p = null;
            if (C0017d.m41a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = C0016c.m34a(string);
                }
                this.f54c = C0017d.m42b(typedArray, xmlPullParser, "fillColor", 1, this.f54c);
                this.f57f = C0017d.m38a(typedArray, xmlPullParser, "fillAlpha", 12, this.f57f);
                this.f61j = m48a(C0017d.m39a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f61j);
                this.f62k = m49a(C0017d.m39a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f62k);
                this.f63l = C0017d.m38a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f63l);
                this.f52a = C0017d.m42b(typedArray, xmlPullParser, "strokeColor", 3, this.f52a);
                this.f55d = C0017d.m38a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f55d);
                this.f53b = C0017d.m38a(typedArray, xmlPullParser, "strokeWidth", 4, this.f53b);
                this.f59h = C0017d.m38a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f59h);
                this.f60i = C0017d.m38a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f60i);
                this.f58g = C0017d.m38a(typedArray, xmlPullParser, "trimPathStart", 5, this.f58g);
            }
        }

        public void m51a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0012e.m20a(resources, theme, attributeSet, C0007a.f30c);
            m50a(a, xmlPullParser);
            a.recycle();
        }

        float getFillAlpha() {
            return this.f57f;
        }

        int getFillColor() {
            return this.f54c;
        }

        float getStrokeAlpha() {
            return this.f55d;
        }

        int getStrokeColor() {
            return this.f52a;
        }

        float getStrokeWidth() {
            return this.f53b;
        }

        float getTrimPathEnd() {
            return this.f59h;
        }

        float getTrimPathOffset() {
            return this.f60i;
        }

        float getTrimPathStart() {
            return this.f58g;
        }

        void setFillAlpha(float f) {
            this.f57f = f;
        }

        void setFillColor(int i) {
            this.f54c = i;
        }

        void setStrokeAlpha(float f) {
            this.f55d = f;
        }

        void setStrokeColor(int i) {
            this.f52a = i;
        }

        void setStrokeWidth(float f) {
            this.f53b = f;
        }

        void setTrimPathEnd(float f) {
            this.f59h = f;
        }

        void setTrimPathOffset(float f) {
            this.f60i = f;
        }

        void setTrimPathStart(float f) {
            this.f58g = f;
        }
    }

    /* renamed from: android.support.a.a.f.c */
    private static class C0021c {
        final ArrayList<Object> f65a;
        float f66b;
        int f67c;
        private final Matrix f68d;
        private float f69e;
        private float f70f;
        private float f71g;
        private float f72h;
        private float f73i;
        private float f74j;
        private final Matrix f75k;
        private int[] f76l;
        private String f77m;

        public C0021c() {
            this.f68d = new Matrix();
            this.f65a = new ArrayList();
            this.f66b = 0.0f;
            this.f69e = 0.0f;
            this.f70f = 0.0f;
            this.f71g = 1.0f;
            this.f72h = 1.0f;
            this.f73i = 0.0f;
            this.f74j = 0.0f;
            this.f75k = new Matrix();
            this.f77m = null;
        }

        public C0021c(C0021c c0021c, C0298a<String, Object> c0298a) {
            this.f68d = new Matrix();
            this.f65a = new ArrayList();
            this.f66b = 0.0f;
            this.f69e = 0.0f;
            this.f70f = 0.0f;
            this.f71g = 1.0f;
            this.f72h = 1.0f;
            this.f73i = 0.0f;
            this.f74j = 0.0f;
            this.f75k = new Matrix();
            this.f77m = null;
            this.f66b = c0021c.f66b;
            this.f69e = c0021c.f69e;
            this.f70f = c0021c.f70f;
            this.f71g = c0021c.f71g;
            this.f72h = c0021c.f72h;
            this.f73i = c0021c.f73i;
            this.f74j = c0021c.f74j;
            this.f76l = c0021c.f76l;
            this.f77m = c0021c.f77m;
            this.f67c = c0021c.f67c;
            if (this.f77m != null) {
                c0298a.put(this.f77m, this);
            }
            this.f75k.set(c0021c.f75k);
            ArrayList arrayList = c0021c.f65a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C0021c) {
                    this.f65a.add(new C0021c((C0021c) obj, c0298a));
                } else {
                    C0018d c0020b;
                    if (obj instanceof C0020b) {
                        c0020b = new C0020b((C0020b) obj);
                    } else if (obj instanceof C0019a) {
                        c0020b = new C0019a((C0019a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f65a.add(c0020b);
                    if (c0020b.f50n != null) {
                        c0298a.put(c0020b.f50n, c0020b);
                    }
                }
            }
        }

        private void m53a() {
            this.f75k.reset();
            this.f75k.postTranslate(-this.f69e, -this.f70f);
            this.f75k.postScale(this.f71g, this.f72h);
            this.f75k.postRotate(this.f66b, 0.0f, 0.0f);
            this.f75k.postTranslate(this.f73i + this.f69e, this.f74j + this.f70f);
        }

        private void m54a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f76l = null;
            this.f66b = C0017d.m38a(typedArray, xmlPullParser, "rotation", 5, this.f66b);
            this.f69e = typedArray.getFloat(1, this.f69e);
            this.f70f = typedArray.getFloat(2, this.f70f);
            this.f71g = C0017d.m38a(typedArray, xmlPullParser, "scaleX", 3, this.f71g);
            this.f72h = C0017d.m38a(typedArray, xmlPullParser, "scaleY", 4, this.f72h);
            this.f73i = C0017d.m38a(typedArray, xmlPullParser, "translateX", 6, this.f73i);
            this.f74j = C0017d.m38a(typedArray, xmlPullParser, "translateY", 7, this.f74j);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f77m = string;
            }
            m53a();
        }

        public void m56a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0012e.m20a(resources, theme, attributeSet, C0007a.f29b);
            m54a(a, xmlPullParser);
            a.recycle();
        }

        public String getGroupName() {
            return this.f77m;
        }

        public Matrix getLocalMatrix() {
            return this.f75k;
        }

        public float getPivotX() {
            return this.f69e;
        }

        public float getPivotY() {
            return this.f70f;
        }

        public float getRotation() {
            return this.f66b;
        }

        public float getScaleX() {
            return this.f71g;
        }

        public float getScaleY() {
            return this.f72h;
        }

        public float getTranslateX() {
            return this.f73i;
        }

        public float getTranslateY() {
            return this.f74j;
        }

        public void setPivotX(float f) {
            if (f != this.f69e) {
                this.f69e = f;
                m53a();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f70f) {
                this.f70f = f;
                m53a();
            }
        }

        public void setRotation(float f) {
            if (f != this.f66b) {
                this.f66b = f;
                m53a();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f71g) {
                this.f71g = f;
                m53a();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f72h) {
                this.f72h = f;
                m53a();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f73i) {
                this.f73i = f;
                m53a();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f74j) {
                this.f74j = f;
                m53a();
            }
        }
    }

    /* renamed from: android.support.a.a.f.e */
    private static class C0022e {
        private static final Matrix f78k;
        final C0021c f79a;
        float f80b;
        float f81c;
        float f82d;
        float f83e;
        int f84f;
        String f85g;
        final C0298a<String, Object> f86h;
        private final Path f87i;
        private final Path f88j;
        private final Matrix f89l;
        private Paint f90m;
        private Paint f91n;
        private PathMeasure f92o;
        private int f93p;

        static {
            f78k = new Matrix();
        }

        public C0022e() {
            this.f89l = new Matrix();
            this.f80b = 0.0f;
            this.f81c = 0.0f;
            this.f82d = 0.0f;
            this.f83e = 0.0f;
            this.f84f = 255;
            this.f85g = null;
            this.f86h = new C0298a();
            this.f79a = new C0021c();
            this.f87i = new Path();
            this.f88j = new Path();
        }

        public C0022e(C0022e c0022e) {
            this.f89l = new Matrix();
            this.f80b = 0.0f;
            this.f81c = 0.0f;
            this.f82d = 0.0f;
            this.f83e = 0.0f;
            this.f84f = 255;
            this.f85g = null;
            this.f86h = new C0298a();
            this.f79a = new C0021c(c0022e.f79a, this.f86h);
            this.f87i = new Path(c0022e.f87i);
            this.f88j = new Path(c0022e.f88j);
            this.f80b = c0022e.f80b;
            this.f81c = c0022e.f81c;
            this.f82d = c0022e.f82d;
            this.f83e = c0022e.f83e;
            this.f93p = c0022e.f93p;
            this.f84f = c0022e.f84f;
            this.f85g = c0022e.f85g;
            if (c0022e.f85g != null) {
                this.f86h.put(c0022e.f85g, this);
            }
        }

        private static float m57a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float m58a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = C0022e.m57a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            return hypot > 0.0f ? Math.abs(a) / hypot : 0.0f;
        }

        private void m61a(C0021c c0021c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0021c.f68d.set(matrix);
            c0021c.f68d.preConcat(c0021c.f75k);
            canvas.save();
            for (int i3 = 0; i3 < c0021c.f65a.size(); i3++) {
                Object obj = c0021c.f65a.get(i3);
                if (obj instanceof C0021c) {
                    m61a((C0021c) obj, c0021c.f68d, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0018d) {
                    m62a(c0021c, (C0018d) obj, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        private void m62a(C0021c c0021c, C0018d c0018d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f82d;
            float f2 = ((float) i2) / this.f83e;
            float min = Math.min(f, f2);
            Matrix a = c0021c.f68d;
            this.f89l.set(a);
            this.f89l.postScale(f, f2);
            f = m58a(a);
            if (f != 0.0f) {
                c0018d.m43a(this.f87i);
                Path path = this.f87i;
                this.f88j.reset();
                if (c0018d.m44a()) {
                    this.f88j.addPath(path, this.f89l);
                    canvas.clipPath(this.f88j);
                    return;
                }
                Paint paint;
                C0020b c0020b = (C0020b) c0018d;
                if (!(c0020b.f58g == 0.0f && c0020b.f59h == 1.0f)) {
                    float f3 = (c0020b.f58g + c0020b.f60i) % 1.0f;
                    float f4 = (c0020b.f59h + c0020b.f60i) % 1.0f;
                    if (this.f92o == null) {
                        this.f92o = new PathMeasure();
                    }
                    this.f92o.setPath(this.f87i, false);
                    float length = this.f92o.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.f92o.getSegment(f3, length, path, true);
                        this.f92o.getSegment(0.0f, f4, path, true);
                    } else {
                        this.f92o.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f88j.addPath(path, this.f89l);
                if (c0020b.f54c != 0) {
                    if (this.f91n == null) {
                        this.f91n = new Paint();
                        this.f91n.setStyle(Style.FILL);
                        this.f91n.setAntiAlias(true);
                    }
                    paint = this.f91n;
                    paint.setColor(C0025f.m74a(c0020b.f54c, c0020b.f57f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.f88j, paint);
                }
                if (c0020b.f52a != 0) {
                    if (this.f90m == null) {
                        this.f90m = new Paint();
                        this.f90m.setStyle(Style.STROKE);
                        this.f90m.setAntiAlias(true);
                    }
                    paint = this.f90m;
                    if (c0020b.f62k != null) {
                        paint.setStrokeJoin(c0020b.f62k);
                    }
                    if (c0020b.f61j != null) {
                        paint.setStrokeCap(c0020b.f61j);
                    }
                    paint.setStrokeMiter(c0020b.f63l);
                    paint.setColor(C0025f.m74a(c0020b.f52a, c0020b.f55d));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth((f * min) * c0020b.f53b);
                    canvas.drawPath(this.f88j, paint);
                }
            }
        }

        public void m65a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m61a(this.f79a, f78k, canvas, i, i2, colorFilter);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f84f;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (255.0f * f));
        }

        public void setRootAlpha(int i) {
            this.f84f = i;
        }
    }

    /* renamed from: android.support.a.a.f.f */
    private static class C0023f extends ConstantState {
        int f94a;
        C0022e f95b;
        ColorStateList f96c;
        Mode f97d;
        boolean f98e;
        Bitmap f99f;
        ColorStateList f100g;
        Mode f101h;
        int f102i;
        boolean f103j;
        boolean f104k;
        Paint f105l;

        public C0023f() {
            this.f96c = null;
            this.f97d = C0025f.f107a;
            this.f95b = new C0022e();
        }

        public C0023f(C0023f c0023f) {
            this.f96c = null;
            this.f97d = C0025f.f107a;
            if (c0023f != null) {
                this.f94a = c0023f.f94a;
                this.f95b = new C0022e(c0023f.f95b);
                if (c0023f.f95b.f91n != null) {
                    this.f95b.f91n = new Paint(c0023f.f95b.f91n);
                }
                if (c0023f.f95b.f90m != null) {
                    this.f95b.f90m = new Paint(c0023f.f95b.f90m);
                }
                this.f96c = c0023f.f96c;
                this.f97d = c0023f.f97d;
                this.f98e = c0023f.f98e;
            }
        }

        public Paint m66a(ColorFilter colorFilter) {
            if (!m69a() && colorFilter == null) {
                return null;
            }
            if (this.f105l == null) {
                this.f105l = new Paint();
                this.f105l.setFilterBitmap(true);
            }
            this.f105l.setAlpha(this.f95b.getRootAlpha());
            this.f105l.setColorFilter(colorFilter);
            return this.f105l;
        }

        public void m67a(int i, int i2) {
            this.f99f.eraseColor(0);
            this.f95b.m65a(new Canvas(this.f99f), i, i2, null);
        }

        public void m68a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f99f, null, rect, m66a(colorFilter));
        }

        public boolean m69a() {
            return this.f95b.getRootAlpha() < 255;
        }

        public void m70b(int i, int i2) {
            if (this.f99f == null || !m73c(i, i2)) {
                this.f99f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f104k = true;
            }
        }

        public boolean m71b() {
            return !this.f104k && this.f100g == this.f96c && this.f101h == this.f97d && this.f103j == this.f98e && this.f102i == this.f95b.getRootAlpha();
        }

        public void m72c() {
            this.f100g = this.f96c;
            this.f101h = this.f97d;
            this.f102i = this.f95b.getRootAlpha();
            this.f103j = this.f98e;
            this.f104k = false;
        }

        public boolean m73c(int i, int i2) {
            return i == this.f99f.getWidth() && i2 == this.f99f.getHeight();
        }

        public int getChangingConfigurations() {
            return this.f94a;
        }

        public Drawable newDrawable() {
            return new C0025f(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0025f(this);
        }
    }

    /* renamed from: android.support.a.a.f.g */
    private static class C0024g extends ConstantState {
        private final ConstantState f106a;

        public C0024g(ConstantState constantState) {
            this.f106a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f106a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f106a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable c0025f = new C0025f();
            c0025f.b = (VectorDrawable) this.f106a.newDrawable();
            return c0025f;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0025f = new C0025f();
            c0025f.b = (VectorDrawable) this.f106a.newDrawable(resources);
            return c0025f;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0025f = new C0025f();
            c0025f.b = (VectorDrawable) this.f106a.newDrawable(resources, theme);
            return c0025f;
        }
    }

    static {
        f107a = Mode.SRC_IN;
    }

    C0025f() {
        this.f112g = true;
        this.f114i = new float[9];
        this.f115j = new Matrix();
        this.f116k = new Rect();
        this.f108c = new C0023f();
    }

    C0025f(C0023f c0023f) {
        this.f112g = true;
        this.f114i = new float[9];
        this.f115j = new Matrix();
        this.f116k = new Rect();
        this.f108c = c0023f;
        this.f109d = m81a(this.f109d, c0023f.f96c, c0023f.f97d);
    }

    static int m74a(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    private static Mode m75a(int i, Mode mode) {
        switch (i) {
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return Mode.SRC_OVER;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return Mode.SRC_IN;
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                return Mode.SRC_ATOP;
            case C1096c.MapAttrs_zOrderOnTop /*14*/:
                return Mode.MULTIPLY;
            case C1096c.MapAttrs_uiMapToolbar /*15*/:
                return Mode.SCREEN;
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                return VERSION.SDK_INT >= 11 ? Mode.ADD : mode;
            default:
                return mode;
        }
    }

    @SuppressLint({"NewApi"})
    public static C0025f m76a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            C0025f c0025f = new C0025f();
            c0025f.b = C0212d.m749a(resources, i, theme);
            c0025f.f113h = new C0024g(c0025f.b.getConstantState());
            return c0025f;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C0025f.m77a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public static C0025f m77a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0025f c0025f = new C0025f();
        c0025f.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0025f;
    }

    private void m78a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0023f c0023f = this.f108c;
        C0022e c0022e = c0023f.f95b;
        c0023f.f97d = C0025f.m75a(C0017d.m39a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0023f.f96c = colorStateList;
        }
        c0023f.f98e = C0017d.m40a(typedArray, xmlPullParser, "autoMirrored", 5, c0023f.f98e);
        c0022e.f82d = C0017d.m38a(typedArray, xmlPullParser, "viewportWidth", 7, c0022e.f82d);
        c0022e.f83e = C0017d.m38a(typedArray, xmlPullParser, "viewportHeight", 8, c0022e.f83e);
        if (c0022e.f82d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0022e.f83e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0022e.f80b = typedArray.getDimension(3, c0022e.f80b);
            c0022e.f81c = typedArray.getDimension(2, c0022e.f81c);
            if (c0022e.f80b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0022e.f81c <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0022e.setAlpha(C0017d.m38a(typedArray, xmlPullParser, "alpha", 4, c0022e.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0022e.f85g = string;
                    c0022e.f86h.put(string, c0022e);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private boolean m79a() {
        boolean z = true;
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!(isAutoMirrored() && getLayoutDirection() == 1)) {
            z = false;
        }
        return z;
    }

    private void m80b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0023f c0023f = this.f108c;
        C0022e c0022e = c0023f.f95b;
        Stack stack = new Stack();
        stack.push(c0022e.f79a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0021c c0021c = (C0021c) stack.peek();
                if ("path".equals(name)) {
                    C0020b c0020b = new C0020b();
                    c0020b.m51a(resources, attributeSet, theme, xmlPullParser);
                    c0021c.f65a.add(c0020b);
                    if (c0020b.getPathName() != null) {
                        c0022e.f86h.put(c0020b.getPathName(), c0020b);
                    }
                    obj2 = null;
                    c0023f.f94a = c0020b.o | c0023f.f94a;
                } else if ("clip-path".equals(name)) {
                    C0019a c0019a = new C0019a();
                    c0019a.m46a(resources, attributeSet, theme, xmlPullParser);
                    c0021c.f65a.add(c0019a);
                    if (c0019a.getPathName() != null) {
                        c0022e.f86h.put(c0019a.getPathName(), c0019a);
                    }
                    c0023f.f94a |= c0019a.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0021c c0021c2 = new C0021c();
                        c0021c2.m56a(resources, attributeSet, theme, xmlPullParser);
                        c0021c.f65a.add(c0021c2);
                        stack.push(c0021c2);
                        if (c0021c2.getGroupName() != null) {
                            c0022e.f86h.put(c0021c2.getGroupName(), c0021c2);
                        }
                        c0023f.f94a |= c0021c2.f67c;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    PorterDuffColorFilter m81a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object m82a(String str) {
        return this.f108c.f95b.f86h.get(str);
    }

    void m83a(boolean z) {
        this.f112g = z;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        if (this.b != null) {
            C0242a.m859d(this.b);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        copyBounds(this.f116k);
        if (this.f116k.width() > 0 && this.f116k.height() > 0) {
            ColorFilter colorFilter = this.f110e == null ? this.f109d : this.f110e;
            canvas.getMatrix(this.f115j);
            this.f115j.getValues(this.f114i);
            float abs = Math.abs(this.f114i[0]);
            float abs2 = Math.abs(this.f114i[4]);
            float abs3 = Math.abs(this.f114i[1]);
            float abs4 = Math.abs(this.f114i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f116k.height()));
            int min = Math.min(ItemAnimator.FLAG_MOVED, (int) (abs * ((float) this.f116k.width())));
            height = Math.min(ItemAnimator.FLAG_MOVED, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f116k.left, (float) this.f116k.top);
                if (m79a()) {
                    canvas.translate((float) this.f116k.width(), 0.0f);
                    canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
                }
                this.f116k.offsetTo(0, 0);
                this.f108c.m70b(min, height);
                if (!this.f112g) {
                    this.f108c.m67a(min, height);
                } else if (!this.f108c.m71b()) {
                    this.f108c.m67a(min, height);
                    this.f108c.m72c();
                }
                this.f108c.m68a(canvas, colorFilter, this.f116k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.b != null ? C0242a.m858c(this.b) : this.f108c.f95b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.f108c.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        if (this.b != null) {
            return new C0024g(this.b.getConstantState());
        }
        this.f108c.f94a = getChangingConfigurations();
        return this.f108c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : (int) this.f108c.f95b.f81c;
    }

    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : (int) this.f108c.f95b.f80b;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.b != null ? this.b.getOpacity() : -3;
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

    @SuppressLint({"NewApi"})
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.b != null) {
            this.b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            C0242a.m853a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0023f c0023f = this.f108c;
        c0023f.f95b = new C0022e();
        TypedArray a = C0012e.m20a(resources, theme, attributeSet, C0007a.f28a);
        m78a(a, xmlPullParser);
        a.recycle();
        c0023f.f94a = getChangingConfigurations();
        c0023f.f104k = true;
        m80b(resources, xmlPullParser, attributeSet, theme);
        this.f109d = m81a(this.f109d, c0023f.f96c, c0023f.f97d);
    }

    public void invalidateSelf() {
        if (this.b != null) {
            this.b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        return this.b != null ? C0242a.m856b(this.b) : this.f108c.f98e;
    }

    public boolean isStateful() {
        return this.b != null ? this.b.isStateful() : super.isStateful() || !(this.f108c == null || this.f108c.f96c == null || !this.f108c.f96c.isStateful());
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        } else if (!this.f111f && super.mutate() == this) {
            this.f108c = new C0023f(this.f108c);
            this.f111f = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        C0023f c0023f = this.f108c;
        if (c0023f.f96c == null || c0023f.f97d == null) {
            return false;
        }
        this.f109d = m81a(this.f109d, c0023f.f96c, c0023f.f97d);
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.b != null) {
            this.b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else if (this.f108c.f95b.getRootAlpha() != i) {
            this.f108c.f95b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            C0242a.m855a(this.b, z);
        } else {
            this.f108c.f98e = z;
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
            return;
        }
        this.f110e = colorFilter;
        invalidateSelf();
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

    @SuppressLint({"NewApi"})
    public void setTint(int i) {
        if (this.b != null) {
            C0242a.m849a(this.b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            C0242a.m851a(this.b, colorStateList);
            return;
        }
        C0023f c0023f = this.f108c;
        if (c0023f.f96c != colorStateList) {
            c0023f.f96c = colorStateList;
            this.f109d = m81a(this.f109d, colorStateList, c0023f.f97d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            C0242a.m854a(this.b, mode);
            return;
        }
        C0023f c0023f = this.f108c;
        if (c0023f.f97d != mode) {
            c0023f.f97d = mode;
            this.f109d = m81a(this.f109d, c0023f.f96c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.b != null ? this.b.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.b != null) {
            this.b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
