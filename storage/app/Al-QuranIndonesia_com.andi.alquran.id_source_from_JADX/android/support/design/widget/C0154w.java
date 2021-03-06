package android.support.design.widget;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

@TargetApi(11)
/* renamed from: android.support.design.widget.w */
class C0154w {
    private static final ThreadLocal<Matrix> f514a;
    private static final ThreadLocal<RectF> f515b;

    static {
        f514a = new ThreadLocal();
        f515b = new ThreadLocal();
    }

    public static void m679a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = (Matrix) f514a.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            f514a.set(matrix2);
            matrix = matrix2;
        } else {
            matrix2.reset();
            matrix = matrix2;
        }
        C0154w.m680a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) f515b.get();
        if (rectF == null) {
            rectF = new RectF();
            f515b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    static void m680a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            C0154w.m680a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
