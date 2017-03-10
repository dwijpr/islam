package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p011d.p012a.C0261b;
import android.support.v4.view.C0491d;
import android.support.v4.view.C0527q.C0526e;
import android.support.v7.view.CollapsibleActionView;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class MenuItemWrapperICS extends BaseMenuWrapper<C0261b> implements MenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;

    class ActionProviderWrapper extends C0491d {
        final ActionProvider mInner;

        public ActionProviderWrapper(Context context, ActionProvider actionProvider) {
            super(context);
            this.mInner = actionProvider;
        }

        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        public View onCreateActionView() {
            return this.mInner.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(subMenu));
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView mWrappedView;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.mWrappedView = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        View getWrappedView() {
            return (View) this.mWrappedView;
        }

        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }
    }

    private class OnActionExpandListenerWrapper extends BaseWrapper<OnActionExpandListener> implements C0526e {
        OnActionExpandListenerWrapper(OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.mWrappedObject).onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.mWrappedObject).onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    private class OnMenuItemClickListenerWrapper extends BaseWrapper<OnMenuItemClickListener> implements OnMenuItemClickListener {
        OnMenuItemClickListenerWrapper(OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.mWrappedObject).onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    MenuItemWrapperICS(Context context, C0261b c0261b) {
        super(context, c0261b);
    }

    public boolean collapseActionView() {
        return ((C0261b) this.mWrappedObject).collapseActionView();
    }

    ActionProviderWrapper createActionProviderWrapper(ActionProvider actionProvider) {
        return new ActionProviderWrapper(this.mContext, actionProvider);
    }

    public boolean expandActionView() {
        return ((C0261b) this.mWrappedObject).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0491d supportActionProvider = ((C0261b) this.mWrappedObject).getSupportActionProvider();
        return supportActionProvider instanceof ActionProviderWrapper ? ((ActionProviderWrapper) supportActionProvider).mInner : null;
    }

    public View getActionView() {
        View actionView = ((C0261b) this.mWrappedObject).getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).getWrappedView() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((C0261b) this.mWrappedObject).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((C0261b) this.mWrappedObject).getGroupId();
    }

    public Drawable getIcon() {
        return ((C0261b) this.mWrappedObject).getIcon();
    }

    public Intent getIntent() {
        return ((C0261b) this.mWrappedObject).getIntent();
    }

    public int getItemId() {
        return ((C0261b) this.mWrappedObject).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0261b) this.mWrappedObject).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((C0261b) this.mWrappedObject).getNumericShortcut();
    }

    public int getOrder() {
        return ((C0261b) this.mWrappedObject).getOrder();
    }

    public SubMenu getSubMenu() {
        return getSubMenuWrapper(((C0261b) this.mWrappedObject).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((C0261b) this.mWrappedObject).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((C0261b) this.mWrappedObject).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((C0261b) this.mWrappedObject).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((C0261b) this.mWrappedObject).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((C0261b) this.mWrappedObject).isCheckable();
    }

    public boolean isChecked() {
        return ((C0261b) this.mWrappedObject).isChecked();
    }

    public boolean isEnabled() {
        return ((C0261b) this.mWrappedObject).isEnabled();
    }

    public boolean isVisible() {
        return ((C0261b) this.mWrappedObject).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0261b) this.mWrappedObject).setSupportActionProvider(actionProvider != null ? createActionProviderWrapper(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0261b) this.mWrappedObject).setActionView(i);
        View actionView = ((C0261b) this.mWrappedObject).getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            ((C0261b) this.mWrappedObject).setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        ((C0261b) this.mWrappedObject).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0261b) this.mWrappedObject).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((C0261b) this.mWrappedObject).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((C0261b) this.mWrappedObject).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((C0261b) this.mWrappedObject).setEnabled(z);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = ((C0261b) this.mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        }
    }

    public MenuItem setIcon(int i) {
        ((C0261b) this.mWrappedObject).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0261b) this.mWrappedObject).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((C0261b) this.mWrappedObject).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0261b) this.mWrappedObject).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0261b) this.mWrappedObject).setSupportOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0261b) this.mWrappedObject).setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0261b) this.mWrappedObject).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((C0261b) this.mWrappedObject).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0261b) this.mWrappedObject).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0261b) this.mWrappedObject).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0261b) this.mWrappedObject).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0261b) this.mWrappedObject).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((C0261b) this.mWrappedObject).setVisible(z);
    }
}
