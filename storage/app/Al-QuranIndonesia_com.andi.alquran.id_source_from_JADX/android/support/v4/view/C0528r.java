package android.support.v4.view;

import android.annotation.TargetApi;
import android.view.MenuItem;
import android.view.View;

@TargetApi(11)
/* renamed from: android.support.v4.view.r */
class C0528r {
    public static MenuItem m2216a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static View m2217a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static void m2218a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m2219b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
