package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.aj;
import android.support.v7.recyclerview.C0628R;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ItemTouchUIUtilImpl {

    static class Gingerbread implements ItemTouchUIUtil {
        Gingerbread() {
        }

        private void draw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view, 0);
            canvas.restore();
        }

        public void clearView(View view) {
            view.setVisibility(0);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i != 2) {
                draw(canvas, recyclerView, view, f, f2);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i == 2) {
                draw(canvas, recyclerView, view, f, f2);
            }
        }

        public void onSelected(View view) {
            view.setVisibility(4);
        }
    }

    static class Honeycomb implements ItemTouchUIUtil {
        Honeycomb() {
        }

        public void clearView(View view) {
            aj.m1854a(view, 0.0f);
            aj.m1870b(view, 0.0f);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            aj.m1854a(view, f);
            aj.m1870b(view, f2);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        }

        public void onSelected(View view) {
        }
    }

    static class Lollipop extends Honeycomb {
        Lollipop() {
        }

        private float findMaxElevation(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float r = aj.m1895r(childAt);
                    if (r > f) {
                        f = r;
                    }
                }
            }
            return f;
        }

        public void clearView(View view) {
            Object tag = view.getTag(C0628R.id.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                aj.m1879d(view, ((Float) tag).floatValue());
            }
            view.setTag(C0628R.id.item_touch_helper_previous_elevation, null);
            super.clearView(view);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(C0628R.id.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(aj.m1895r(view));
                aj.m1879d(view, 1.0f + findMaxElevation(recyclerView, view));
                view.setTag(C0628R.id.item_touch_helper_previous_elevation, valueOf);
            }
            super.onDraw(canvas, recyclerView, view, f, f2, i, z);
        }
    }

    ItemTouchUIUtilImpl() {
    }
}
