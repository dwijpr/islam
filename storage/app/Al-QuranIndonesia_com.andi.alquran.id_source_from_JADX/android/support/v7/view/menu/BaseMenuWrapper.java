package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p011d.p012a.C0261b;
import android.support.v4.p011d.p012a.C0262c;
import android.support.v4.p014g.C0298a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
    final Context mContext;
    private Map<C0261b, MenuItem> mMenuItems;
    private Map<C0262c, SubMenu> mSubMenus;

    BaseMenuWrapper(Context context, T t) {
        super(t);
        this.mContext = context;
    }

    final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof C0261b)) {
            return menuItem;
        }
        C0261b c0261b = (C0261b) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new C0298a();
        }
        MenuItem menuItem2 = (MenuItem) this.mMenuItems.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = MenuWrapperFactory.wrapSupportMenuItem(this.mContext, c0261b);
        this.mMenuItems.put(c0261b, menuItem2);
        return menuItem2;
    }

    final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        if (!(subMenu instanceof C0262c)) {
            return subMenu;
        }
        C0262c c0262c = (C0262c) subMenu;
        if (this.mSubMenus == null) {
            this.mSubMenus = new C0298a();
        }
        SubMenu subMenu2 = (SubMenu) this.mSubMenus.get(c0262c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = MenuWrapperFactory.wrapSupportSubMenu(this.mContext, c0262c);
        this.mSubMenus.put(c0262c, subMenu2);
        return subMenu2;
    }

    final void internalClear() {
        if (this.mMenuItems != null) {
            this.mMenuItems.clear();
        }
        if (this.mSubMenus != null) {
            this.mSubMenus.clear();
        }
    }

    final void internalRemoveGroup(int i) {
        if (this.mMenuItems != null) {
            Iterator it = this.mMenuItems.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void internalRemoveItem(int i) {
        if (this.mMenuItems != null) {
            Iterator it = this.mMenuItems.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
