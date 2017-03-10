package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.C0500f;
import android.support.v4.view.aj;
import android.support.v7.appcompat.C0627R;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, OnKeyListener, OnDismissListener {
    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener;
    private final int mMenuMaxWidth;
    private OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List<MenuBuilder> mPendingMenus;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private Callback mPresenterCallback;
    private int mRawDropDownGravity;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    final List<CascadingMenuInfo> mShowingMenus;
    View mShownAnchorView;
    final Handler mSubMenuHoverHandler;
    private ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;

    /* renamed from: android.support.v7.view.menu.CascadingMenuPopup.1 */
    class C06381 implements OnGlobalLayoutListener {
        C06381() {
        }

        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.mShowingMenus.size() > 0 && !((CascadingMenuInfo) CascadingMenuPopup.this.mShowingMenus.get(CascadingMenuPopup.HORIZ_POSITION_LEFT)).window.isModal()) {
                View view = CascadingMenuPopup.this.mShownAnchorView;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.mShowingMenus) {
                    cascadingMenuInfo.window.show();
                }
            }
        }
    }

    /* renamed from: android.support.v7.view.menu.CascadingMenuPopup.2 */
    class C06402 implements MenuItemHoverListener {

        /* renamed from: android.support.v7.view.menu.CascadingMenuPopup.2.1 */
        class C06391 implements Runnable {
            final /* synthetic */ MenuItem val$item;
            final /* synthetic */ MenuBuilder val$menu;
            final /* synthetic */ CascadingMenuInfo val$nextInfo;

            C06391(CascadingMenuInfo cascadingMenuInfo, MenuItem menuItem, MenuBuilder menuBuilder) {
                this.val$nextInfo = cascadingMenuInfo;
                this.val$item = menuItem;
                this.val$menu = menuBuilder;
            }

            public void run() {
                if (this.val$nextInfo != null) {
                    CascadingMenuPopup.this.mShouldCloseImmediately = true;
                    this.val$nextInfo.menu.close(false);
                    CascadingMenuPopup.this.mShouldCloseImmediately = false;
                }
                if (this.val$item.isEnabled() && this.val$item.hasSubMenu()) {
                    this.val$menu.performItemAction(this.val$item, CascadingMenuPopup.HORIZ_POSITION_LEFT);
                }
            }
        }

        C06402() {
        }

        public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
            int i;
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.mShowingMenus.size();
            for (int i2 = CascadingMenuPopup.HORIZ_POSITION_LEFT; i2 < size; i2 += CascadingMenuPopup.HORIZ_POSITION_RIGHT) {
                if (menuBuilder == ((CascadingMenuInfo) CascadingMenuPopup.this.mShowingMenus.get(i2)).menu) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                i += CascadingMenuPopup.HORIZ_POSITION_RIGHT;
                CascadingMenuPopup.this.mSubMenuHoverHandler.postAtTime(new C06391(i < CascadingMenuPopup.this.mShowingMenus.size() ? (CascadingMenuInfo) CascadingMenuPopup.this.mShowingMenus.get(i) : null, menuItem, menuBuilder), menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
        }
    }

    private static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        this.mPendingMenus = new LinkedList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new C06381();
        this.mMenuItemHoverListener = new C06402();
        this.mRawDropDownGravity = HORIZ_POSITION_LEFT;
        this.mDropDownGravity = HORIZ_POSITION_LEFT;
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        this.mOverflowOnly = z;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0627R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuPopupWindow.setHoverListener(this.mMenuItemHoverListener);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.mAnchorView);
        menuPopupWindow.setDropDownGravity(this.mDropDownGravity);
        menuPopupWindow.setModal(true);
        return menuPopupWindow;
    }

    private int findIndexOfAddedMenu(MenuBuilder menuBuilder) {
        int size = this.mShowingMenus.size();
        for (int i = HORIZ_POSITION_LEFT; i < size; i += HORIZ_POSITION_RIGHT) {
            if (menuBuilder == ((CascadingMenuInfo) this.mShowingMenus.get(i)).menu) {
                return i;
            }
        }
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = HORIZ_POSITION_LEFT; i < size; i += HORIZ_POSITION_RIGHT) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View findParentViewForSubmenu(CascadingMenuInfo cascadingMenuInfo, MenuBuilder menuBuilder) {
        int i = HORIZ_POSITION_LEFT;
        MenuItem findMenuItemForSubmenu = findMenuItemForSubmenu(cascadingMenuInfo.menu, menuBuilder);
        if (findMenuItemForSubmenu == null) {
            return null;
        }
        int headersCount;
        MenuAdapter menuAdapter;
        int i2;
        ListView listView = cascadingMenuInfo.getListView();
        ListAdapter adapter = listView.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            headersCount = HORIZ_POSITION_LEFT;
        }
        int count = menuAdapter.getCount();
        while (i < count) {
            if (findMenuItemForSubmenu == menuAdapter.getItem(i)) {
                i2 = i;
                break;
            }
            i += HORIZ_POSITION_RIGHT;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - listView.getFirstVisiblePosition();
        return (i2 < 0 || i2 >= listView.getChildCount()) ? null : listView.getChildAt(i2);
    }

    private int getInitialMenuPosition() {
        return aj.m1884g(this.mAnchorView) == HORIZ_POSITION_RIGHT ? HORIZ_POSITION_LEFT : HORIZ_POSITION_RIGHT;
    }

    private int getNextMenuPosition(int i) {
        ListView listView = ((CascadingMenuInfo) this.mShowingMenus.get(this.mShowingMenus.size() - 1)).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
        if (this.mLastPosition != HORIZ_POSITION_RIGHT) {
            return iArr[HORIZ_POSITION_LEFT] - i < 0 ? HORIZ_POSITION_RIGHT : HORIZ_POSITION_LEFT;
        } else {
            return (listView.getWidth() + iArr[HORIZ_POSITION_LEFT]) + i > rect.right ? HORIZ_POSITION_LEFT : HORIZ_POSITION_RIGHT;
        }
    }

    private void showMenu(MenuBuilder menuBuilder) {
        View findParentViewForSubmenu;
        CascadingMenuInfo cascadingMenuInfo;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        Object menuAdapter = new MenuAdapter(menuBuilder, from, this.mOverflowOnly);
        if (!isShowing() && this.mForceShowIcon) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(menuBuilder));
        }
        int measureIndividualMenuWidth = MenuPopup.measureIndividualMenuWidth(menuAdapter, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow createPopupWindow = createPopupWindow();
        createPopupWindow.setAdapter(menuAdapter);
        createPopupWindow.setContentWidth(measureIndividualMenuWidth);
        createPopupWindow.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() > 0) {
            CascadingMenuInfo cascadingMenuInfo2 = (CascadingMenuInfo) this.mShowingMenus.get(this.mShowingMenus.size() - 1);
            findParentViewForSubmenu = findParentViewForSubmenu(cascadingMenuInfo2, menuBuilder);
            cascadingMenuInfo = cascadingMenuInfo2;
        } else {
            findParentViewForSubmenu = null;
            cascadingMenuInfo = null;
        }
        if (findParentViewForSubmenu != null) {
            createPopupWindow.setTouchModal(false);
            createPopupWindow.setEnterTransition(null);
            int nextMenuPosition = getNextMenuPosition(measureIndividualMenuWidth);
            boolean z = nextMenuPosition == HORIZ_POSITION_RIGHT;
            this.mLastPosition = nextMenuPosition;
            int[] iArr = new int[2];
            findParentViewForSubmenu.getLocationInWindow(iArr);
            int horizontalOffset = cascadingMenuInfo.window.getHorizontalOffset() + iArr[HORIZ_POSITION_LEFT];
            int verticalOffset = iArr[HORIZ_POSITION_RIGHT] + cascadingMenuInfo.window.getVerticalOffset();
            int width = (this.mDropDownGravity & 5) == 5 ? z ? horizontalOffset + measureIndividualMenuWidth : horizontalOffset - findParentViewForSubmenu.getWidth() : z ? findParentViewForSubmenu.getWidth() + horizontalOffset : horizontalOffset - measureIndividualMenuWidth;
            createPopupWindow.setHorizontalOffset(width);
            createPopupWindow.setVerticalOffset(verticalOffset);
        } else {
            if (this.mHasXOffset) {
                createPopupWindow.setHorizontalOffset(this.mXOffset);
            }
            if (this.mHasYOffset) {
                createPopupWindow.setVerticalOffset(this.mYOffset);
            }
            createPopupWindow.setEpicenterBounds(getEpicenterBounds());
        }
        this.mShowingMenus.add(new CascadingMenuInfo(createPopupWindow, menuBuilder, this.mLastPosition));
        createPopupWindow.show();
        if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.getHeaderTitle() != null) {
            ViewGroup listView = createPopupWindow.getListView();
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0627R.layout.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, null, false);
            createPopupWindow.show();
        }
    }

    public void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    protected boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    public void dismiss() {
        int size = this.mShowingMenus.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[size]);
            for (size--; size >= 0; size--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[size];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        return this.mShowingMenus.isEmpty() ? null : ((CascadingMenuInfo) this.mShowingMenus.get(this.mShowingMenus.size() - 1)).getListView();
    }

    public boolean isShowing() {
        return this.mShowingMenus.size() > 0 && ((CascadingMenuInfo) this.mShowingMenus.get(HORIZ_POSITION_LEFT)).window.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int findIndexOfAddedMenu = findIndexOfAddedMenu(menuBuilder);
        if (findIndexOfAddedMenu >= 0) {
            int i = findIndexOfAddedMenu + HORIZ_POSITION_RIGHT;
            if (i < this.mShowingMenus.size()) {
                ((CascadingMenuInfo) this.mShowingMenus.get(i)).menu.close(false);
            }
            CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) this.mShowingMenus.remove(findIndexOfAddedMenu);
            cascadingMenuInfo.menu.removeMenuPresenter(this);
            if (this.mShouldCloseImmediately) {
                cascadingMenuInfo.window.setExitTransition(null);
                cascadingMenuInfo.window.setAnimationStyle(HORIZ_POSITION_LEFT);
            }
            cascadingMenuInfo.window.dismiss();
            findIndexOfAddedMenu = this.mShowingMenus.size();
            if (findIndexOfAddedMenu > 0) {
                this.mLastPosition = ((CascadingMenuInfo) this.mShowingMenus.get(findIndexOfAddedMenu - 1)).position;
            } else {
                this.mLastPosition = getInitialMenuPosition();
            }
            if (findIndexOfAddedMenu == 0) {
                dismiss();
                if (this.mPresenterCallback != null) {
                    this.mPresenterCallback.onCloseMenu(menuBuilder, true);
                }
                if (this.mTreeObserver != null) {
                    if (this.mTreeObserver.isAlive()) {
                        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                    }
                    this.mTreeObserver = null;
                }
                this.mOnDismissListener.onDismiss();
            } else if (z) {
                ((CascadingMenuInfo) this.mShowingMenus.get(HORIZ_POSITION_LEFT)).menu.close(false);
            }
        }
    }

    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.mShowingMenus.size();
        for (int i = HORIZ_POSITION_LEFT; i < size; i += HORIZ_POSITION_RIGHT) {
            cascadingMenuInfo = (CascadingMenuInfo) this.mShowingMenus.get(i);
            if (!cascadingMenuInfo.window.isShowing()) {
                break;
            }
        }
        cascadingMenuInfo = null;
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != HORIZ_POSITION_RIGHT || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.getListView().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        addMenu(subMenuBuilder);
        if (this.mPresenterCallback != null) {
            this.mPresenterCallback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    public void setAnchorView(View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = C0500f.m2143a(this.mRawDropDownGravity, aj.m1884g(this.mAnchorView));
        }
    }

    public void setCallback(Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    public void setGravity(int i) {
        if (this.mRawDropDownGravity != i) {
            this.mRawDropDownGravity = i;
            this.mDropDownGravity = C0500f.m2143a(i, aj.m1884g(this.mAnchorView));
        }
    }

    public void setHorizontalOffset(int i) {
        this.mHasXOffset = true;
        this.mXOffset = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    public void setVerticalOffset(int i) {
        this.mHasYOffset = true;
        this.mYOffset = i;
    }

    public void show() {
        if (!isShowing()) {
            for (MenuBuilder showMenu : this.mPendingMenus) {
                showMenu(showMenu);
            }
            this.mPendingMenus.clear();
            this.mShownAnchorView = this.mAnchorView;
            if (this.mShownAnchorView != null) {
                Object obj = this.mTreeObserver == null ? HORIZ_POSITION_RIGHT : null;
                this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
                if (obj != null) {
                    this.mTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                }
            }
        }
    }

    public void updateMenuView(boolean z) {
        for (CascadingMenuInfo listView : this.mShowingMenus) {
            MenuPopup.toMenuAdapter(listView.getListView().getAdapter()).notifyDataSetChanged();
        }
    }
}
