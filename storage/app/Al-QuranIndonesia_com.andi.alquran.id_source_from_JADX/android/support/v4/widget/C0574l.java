package android.support.v4.widget;

import android.widget.ListView;

/* renamed from: android.support.v4.widget.l */
public class C0574l extends C0550a {
    private final ListView f1099f;

    public C0574l(ListView listView) {
        super(listView);
        this.f1099f = listView;
    }

    public void m2482a(int i, int i2) {
        C0575m.m2485a(this.f1099f, i2);
    }

    public boolean m2483e(int i) {
        return false;
    }

    public boolean m2484f(int i) {
        ListView listView = this.f1099f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
