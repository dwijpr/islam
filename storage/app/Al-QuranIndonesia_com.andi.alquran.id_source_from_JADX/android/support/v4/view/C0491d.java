package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.view.d */
public abstract class C0491d {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private C0489a mSubUiVisibilityListener;
    private C0490b mVisibilityListener;

    /* renamed from: android.support.v4.view.d.a */
    public interface C0489a {
        void onSubUiVisibilityChanged(boolean z);
    }

    /* renamed from: android.support.v4.view.d.b */
    public interface C0490b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public C0491d(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        }
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(C0489a c0489a) {
        this.mSubUiVisibilityListener = c0489a;
    }

    public void setVisibilityListener(C0490b c0490b) {
        if (!(this.mVisibilityListener == null || c0490b == null)) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = c0490b;
    }

    public void subUiVisibilityChanged(boolean z) {
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(z);
        }
    }
}
