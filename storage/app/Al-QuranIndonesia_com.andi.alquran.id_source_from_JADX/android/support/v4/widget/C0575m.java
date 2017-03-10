package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.m */
public final class C0575m {
    public static void m2485a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            C0577o.m2487a(listView, i);
        } else {
            C0576n.m2486a(listView, i);
        }
    }
}
