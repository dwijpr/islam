package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p011d.p012a.C0260a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

@TargetApi(14)
class MenuWrapperICS extends BaseMenuWrapper<C0260a> implements Menu {
    MenuWrapperICS(Context context, C0260a c0260a) {
        super(context, c0260a);
    }

    public MenuItem add(int i) {
        return getMenuItemWrapper(((C0260a) this.mWrappedObject).add(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return getMenuItemWrapper(((C0260a) this.mWrappedObject).add(i, i2, i3, i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return getMenuItemWrapper(((C0260a) this.mWrappedObject).add(i, i2, i3, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(((C0260a) this.mWrappedObject).add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((C0260a) this.mWrappedObject).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = getMenuItemWrapper(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i) {
        return getSubMenuWrapper(((C0260a) this.mWrappedObject).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return getSubMenuWrapper(((C0260a) this.mWrappedObject).addSubMenu(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return getSubMenuWrapper(((C0260a) this.mWrappedObject).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(((C0260a) this.mWrappedObject).addSubMenu(charSequence));
    }

    public void clear() {
        internalClear();
        ((C0260a) this.mWrappedObject).clear();
    }

    public void close() {
        ((C0260a) this.mWrappedObject).close();
    }

    public MenuItem findItem(int i) {
        return getMenuItemWrapper(((C0260a) this.mWrappedObject).findItem(i));
    }

    public MenuItem getItem(int i) {
        return getMenuItemWrapper(((C0260a) this.mWrappedObject).getItem(i));
    }

    public boolean hasVisibleItems() {
        return ((C0260a) this.mWrappedObject).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0260a) this.mWrappedObject).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0260a) this.mWrappedObject).performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0260a) this.mWrappedObject).performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        internalRemoveGroup(i);
        ((C0260a) this.mWrappedObject).removeGroup(i);
    }

    public void removeItem(int i) {
        internalRemoveItem(i);
        ((C0260a) this.mWrappedObject).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0260a) this.mWrappedObject).setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0260a) this.mWrappedObject).setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0260a) this.mWrappedObject).setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        ((C0260a) this.mWrappedObject).setQwertyMode(z);
    }

    public int size() {
        return ((C0260a) this.mWrappedObject).size();
    }
}
