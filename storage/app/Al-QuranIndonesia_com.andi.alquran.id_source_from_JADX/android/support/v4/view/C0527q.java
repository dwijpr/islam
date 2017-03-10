package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p011d.p012a.C0261b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.view.q */
public final class C0527q {
    static final C0522d f950a;

    /* renamed from: android.support.v4.view.q.d */
    interface C0522d {
        MenuItem m2189a(MenuItem menuItem, View view);

        View m2190a(MenuItem menuItem);

        void m2191a(MenuItem menuItem, int i);

        MenuItem m2192b(MenuItem menuItem, int i);

        boolean m2193b(MenuItem menuItem);

        boolean m2194c(MenuItem menuItem);
    }

    /* renamed from: android.support.v4.view.q.a */
    static class C0523a implements C0522d {
        C0523a() {
        }

        public MenuItem m2195a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public View m2196a(MenuItem menuItem) {
            return null;
        }

        public void m2197a(MenuItem menuItem, int i) {
        }

        public MenuItem m2198b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public boolean m2199b(MenuItem menuItem) {
            return false;
        }

        public boolean m2200c(MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.q.b */
    static class C0524b implements C0522d {
        C0524b() {
        }

        public MenuItem m2201a(MenuItem menuItem, View view) {
            return C0528r.m2216a(menuItem, view);
        }

        public View m2202a(MenuItem menuItem) {
            return C0528r.m2217a(menuItem);
        }

        public void m2203a(MenuItem menuItem, int i) {
            C0528r.m2218a(menuItem, i);
        }

        public MenuItem m2204b(MenuItem menuItem, int i) {
            return C0528r.m2219b(menuItem, i);
        }

        public boolean m2205b(MenuItem menuItem) {
            return false;
        }

        public boolean m2206c(MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.q.c */
    static class C0525c extends C0524b {
        C0525c() {
        }

        public boolean m2207b(MenuItem menuItem) {
            return C0529s.m2220a(menuItem);
        }

        public boolean m2208c(MenuItem menuItem) {
            return C0529s.m2221b(menuItem);
        }
    }

    /* renamed from: android.support.v4.view.q.e */
    public interface C0526e {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f950a = new C0525c();
        } else if (VERSION.SDK_INT >= 11) {
            f950a = new C0524b();
        } else {
            f950a = new C0523a();
        }
    }

    public static MenuItem m2209a(MenuItem menuItem, C0491d c0491d) {
        if (menuItem instanceof C0261b) {
            return ((C0261b) menuItem).setSupportActionProvider(c0491d);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem m2210a(MenuItem menuItem, View view) {
        return menuItem instanceof C0261b ? ((C0261b) menuItem).setActionView(view) : f950a.m2189a(menuItem, view);
    }

    public static View m2211a(MenuItem menuItem) {
        return menuItem instanceof C0261b ? ((C0261b) menuItem).getActionView() : f950a.m2190a(menuItem);
    }

    public static void m2212a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0261b) {
            ((C0261b) menuItem).setShowAsAction(i);
        } else {
            f950a.m2191a(menuItem, i);
        }
    }

    public static MenuItem m2213b(MenuItem menuItem, int i) {
        return menuItem instanceof C0261b ? ((C0261b) menuItem).setActionView(i) : f950a.m2192b(menuItem, i);
    }

    public static boolean m2214b(MenuItem menuItem) {
        return menuItem instanceof C0261b ? ((C0261b) menuItem).expandActionView() : f950a.m2193b(menuItem);
    }

    public static boolean m2215c(MenuItem menuItem) {
        return menuItem instanceof C0261b ? ((C0261b) menuItem).isActionViewExpanded() : f950a.m2194c(menuItem);
    }
}
