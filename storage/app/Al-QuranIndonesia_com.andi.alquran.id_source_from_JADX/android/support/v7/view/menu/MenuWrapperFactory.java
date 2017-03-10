package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p011d.p012a.C0260a;
import android.support.v4.p011d.p012a.C0261b;
import android.support.v4.p011d.p012a.C0262c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class MenuWrapperFactory {
    private MenuWrapperFactory() {
    }

    public static Menu wrapSupportMenu(Context context, C0260a c0260a) {
        if (VERSION.SDK_INT >= 14) {
            return new MenuWrapperICS(context, c0260a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem wrapSupportMenuItem(Context context, C0261b c0261b) {
        if (VERSION.SDK_INT >= 16) {
            return new MenuItemWrapperJB(context, c0261b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new MenuItemWrapperICS(context, c0261b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu wrapSupportSubMenu(Context context, C0262c c0262c) {
        if (VERSION.SDK_INT >= 14) {
            return new SubMenuWrapperICS(context, c0262c);
        }
        throw new UnsupportedOperationException();
    }
}
