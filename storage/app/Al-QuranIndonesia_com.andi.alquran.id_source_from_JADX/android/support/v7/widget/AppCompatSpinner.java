package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v4.view.aj;
import android.support.v7.appcompat.C0627R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements ag {
    private static final int[] ATTRS_ANDROID_SPINNERMODE;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    DropdownPopup mPopup;
    private Context mPopupContext;
    private boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    /* renamed from: android.support.v7.widget.AppCompatSpinner.1 */
    class C06561 extends ForwardingListener {
        final /* synthetic */ DropdownPopup val$popup;

        C06561(View view, DropdownPopup dropdownPopup) {
            this.val$popup = dropdownPopup;
            super(view);
        }

        public ShowableListMenu getPopup() {
            return this.val$popup;
        }

        public boolean onForwardingStarted() {
            if (!AppCompatSpinner.this.mPopup.isShowing()) {
                AppCompatSpinner.this.mPopup.show();
            }
            return true;
        }
    }

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter2.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mListAdapter;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public int getCount() {
            return this.mAdapter == null ? AppCompatSpinner.MODE_DIALOG : this.mAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.mAdapter == null ? null : this.mAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            return this.mAdapter == null ? null : this.mAdapter.getItem(i);
        }

        public long getItemId(int i) {
            return this.mAdapter == null ? -1 : this.mAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return AppCompatSpinner.MODE_DIALOG;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return AppCompatSpinner.MODE_DROPDOWN;
        }

        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.mListAdapter;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class DropdownPopup extends ListPopupWindow {
        ListAdapter mAdapter;
        private CharSequence mHintText;
        private final Rect mVisibleRect;

        /* renamed from: android.support.v7.widget.AppCompatSpinner.DropdownPopup.1 */
        class C06571 implements OnItemClickListener {
            final /* synthetic */ AppCompatSpinner val$this$0;

            C06571(AppCompatSpinner appCompatSpinner) {
                this.val$this$0 = appCompatSpinner;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppCompatSpinner.this.setSelection(i);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    AppCompatSpinner.this.performItemClick(view, i, DropdownPopup.this.mAdapter.getItemId(i));
                }
                DropdownPopup.this.dismiss();
            }
        }

        /* renamed from: android.support.v7.widget.AppCompatSpinner.DropdownPopup.2 */
        class C06582 implements OnGlobalLayoutListener {
            C06582() {
            }

            public void onGlobalLayout() {
                if (DropdownPopup.this.isVisibleToUser(AppCompatSpinner.this)) {
                    DropdownPopup.this.computeContentWidth();
                    super.show();
                    return;
                }
                DropdownPopup.this.dismiss();
            }
        }

        /* renamed from: android.support.v7.widget.AppCompatSpinner.DropdownPopup.3 */
        class C06593 implements OnDismissListener {
            final /* synthetic */ OnGlobalLayoutListener val$layoutListener;

            C06593(OnGlobalLayoutListener onGlobalLayoutListener) {
                this.val$layoutListener = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
                }
            }
        }

        public DropdownPopup(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mVisibleRect = new Rect();
            setAnchorView(AppCompatSpinner.this);
            setModal(true);
            setPromptPosition(AppCompatSpinner.MODE_DIALOG);
            setOnItemClickListener(new C06571(AppCompatSpinner.this));
        }

        void computeContentWidth() {
            int i;
            Drawable background = getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.mTempRect);
                i = ViewUtils.isLayoutRtl(AppCompatSpinner.this) ? AppCompatSpinner.this.mTempRect.right : -AppCompatSpinner.this.mTempRect.left;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                AppCompatSpinner.this.mTempRect.right = AppCompatSpinner.MODE_DIALOG;
                rect.left = AppCompatSpinner.MODE_DIALOG;
                i = AppCompatSpinner.MODE_DIALOG;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.mDropDownWidth == -2) {
                int compatMeasureContentWidth = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
                int i2 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left) - AppCompatSpinner.this.mTempRect.right;
                if (compatMeasureContentWidth <= i2) {
                    i2 = compatMeasureContentWidth;
                }
                setContentWidth(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.mDropDownWidth == AppCompatSpinner.MODE_THEME) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(AppCompatSpinner.this.mDropDownWidth);
            }
            setHorizontalOffset(ViewUtils.isLayoutRtl(AppCompatSpinner.this) ? ((width - paddingRight) - getWidth()) + i : i + paddingLeft);
        }

        public CharSequence getHintText() {
            return this.mHintText;
        }

        boolean isVisibleToUser(View view) {
            return aj.m1848E(view) && view.getGlobalVisibleRect(this.mVisibleRect);
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = listAdapter;
        }

        public void setPromptText(CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        public void show() {
            boolean isShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(AppCompatSpinner.MODE_DROPDOWN);
            setSelection(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    OnGlobalLayoutListener c06582 = new C06582();
                    viewTreeObserver.addOnGlobalLayoutListener(c06582);
                    setOnDismissListener(new C06593(c06582));
                }
            }
        }
    }

    static {
        int[] iArr = new int[MODE_DROPDOWN];
        iArr[MODE_DIALOG] = 16843505;
        ATTRS_ANDROID_SPINNERMODE = iArr;
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, null, C0627R.attr.spinnerStyle, i);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0627R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, MODE_THEME);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        Throwable e;
        DropdownPopup dropdownPopup;
        TintTypedArray obtainStyledAttributes;
        CharSequence[] textArray;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0627R.styleable.Spinner, i, MODE_DIALOG);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        if (theme != null) {
            this.mPopupContext = new ContextThemeWrapper(context, theme);
        } else {
            int resourceId = obtainStyledAttributes2.getResourceId(C0627R.styleable.Spinner_popupTheme, MODE_DIALOG);
            if (resourceId != 0) {
                this.mPopupContext = new ContextThemeWrapper(context, resourceId);
            } else {
                this.mPopupContext = VERSION.SDK_INT < 23 ? context : null;
            }
        }
        if (this.mPopupContext != null) {
            if (i2 == MODE_THEME) {
                if (VERSION.SDK_INT >= 11) {
                    TypedArray obtainStyledAttributes3;
                    try {
                        obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, ATTRS_ANDROID_SPINNERMODE, i, MODE_DIALOG);
                        try {
                            if (obtainStyledAttributes3.hasValue(MODE_DIALOG)) {
                                i2 = obtainStyledAttributes3.getInt(MODE_DIALOG, MODE_DIALOG);
                            }
                            if (obtainStyledAttributes3 != null) {
                                obtainStyledAttributes3.recycle();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.i(TAG, "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes3 != null) {
                                    obtainStyledAttributes3.recycle();
                                }
                                if (i2 == MODE_DROPDOWN) {
                                    dropdownPopup = new DropdownPopup(this.mPopupContext, attributeSet, i);
                                    obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mPopupContext, attributeSet, C0627R.styleable.Spinner, i, MODE_DIALOG);
                                    this.mDropDownWidth = obtainStyledAttributes.getLayoutDimension(C0627R.styleable.Spinner_android_dropDownWidth, -2);
                                    dropdownPopup.setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0627R.styleable.Spinner_android_popupBackground));
                                    dropdownPopup.setPromptText(obtainStyledAttributes2.getString(C0627R.styleable.Spinner_android_prompt));
                                    obtainStyledAttributes.recycle();
                                    this.mPopup = dropdownPopup;
                                    this.mForwardingListener = new C06561(this, dropdownPopup);
                                }
                                textArray = obtainStyledAttributes2.getTextArray(C0627R.styleable.Spinner_android_entries);
                                if (textArray != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                                    arrayAdapter.setDropDownViewResource(C0627R.layout.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                obtainStyledAttributes2.recycle();
                                this.mPopupSet = true;
                                if (this.mTempAdapter != null) {
                                    setAdapter(this.mTempAdapter);
                                    this.mTempAdapter = null;
                                }
                                this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes3 != null) {
                                    obtainStyledAttributes3.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obtainStyledAttributes3 = null;
                        Log.i(TAG, "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes3 != null) {
                            obtainStyledAttributes3.recycle();
                        }
                        if (i2 == MODE_DROPDOWN) {
                            dropdownPopup = new DropdownPopup(this.mPopupContext, attributeSet, i);
                            obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mPopupContext, attributeSet, C0627R.styleable.Spinner, i, MODE_DIALOG);
                            this.mDropDownWidth = obtainStyledAttributes.getLayoutDimension(C0627R.styleable.Spinner_android_dropDownWidth, -2);
                            dropdownPopup.setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0627R.styleable.Spinner_android_popupBackground));
                            dropdownPopup.setPromptText(obtainStyledAttributes2.getString(C0627R.styleable.Spinner_android_prompt));
                            obtainStyledAttributes.recycle();
                            this.mPopup = dropdownPopup;
                            this.mForwardingListener = new C06561(this, dropdownPopup);
                        }
                        textArray = obtainStyledAttributes2.getTextArray(C0627R.styleable.Spinner_android_entries);
                        if (textArray != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                            arrayAdapter.setDropDownViewResource(C0627R.layout.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        obtainStyledAttributes2.recycle();
                        this.mPopupSet = true;
                        if (this.mTempAdapter != null) {
                            setAdapter(this.mTempAdapter);
                            this.mTempAdapter = null;
                        }
                        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes3 = null;
                        if (obtainStyledAttributes3 != null) {
                            obtainStyledAttributes3.recycle();
                        }
                        throw e;
                    }
                }
                i2 = MODE_DROPDOWN;
            }
            if (i2 == MODE_DROPDOWN) {
                dropdownPopup = new DropdownPopup(this.mPopupContext, attributeSet, i);
                obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mPopupContext, attributeSet, C0627R.styleable.Spinner, i, MODE_DIALOG);
                this.mDropDownWidth = obtainStyledAttributes.getLayoutDimension(C0627R.styleable.Spinner_android_dropDownWidth, -2);
                dropdownPopup.setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0627R.styleable.Spinner_android_popupBackground));
                dropdownPopup.setPromptText(obtainStyledAttributes2.getString(C0627R.styleable.Spinner_android_prompt));
                obtainStyledAttributes.recycle();
                this.mPopup = dropdownPopup;
                this.mForwardingListener = new C06561(this, dropdownPopup);
            }
        }
        textArray = obtainStyledAttributes2.getTextArray(C0627R.styleable.Spinner_android_entries);
        if (textArray != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(C0627R.layout.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        obtainStyledAttributes2.recycle();
        this.mPopupSet = true;
        if (this.mTempAdapter != null) {
            setAdapter(this.mTempAdapter);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
    }

    int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return MODE_DIALOG;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MODE_DIALOG);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MODE_DIALOG);
        int max = Math.max(MODE_DIALOG, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + MAX_ITEMS_MEASURED);
        int max2 = Math.max(MODE_DIALOG, max - (15 - (min - max)));
        View view = null;
        int i = MODE_DIALOG;
        max = MODE_DIALOG;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2 += MODE_DROPDOWN;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.mTempRect);
        return (this.mTempRect.left + this.mTempRect.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.applySupportBackgroundTint();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.mPopup != null ? this.mPopup.getHorizontalOffset() : VERSION.SDK_INT >= 16 ? super.getDropDownHorizontalOffset() : MODE_DIALOG;
    }

    public int getDropDownVerticalOffset() {
        return this.mPopup != null ? this.mPopup.getVerticalOffset() : VERSION.SDK_INT >= 16 ? super.getDropDownVerticalOffset() : MODE_DIALOG;
    }

    public int getDropDownWidth() {
        return this.mPopup != null ? this.mDropDownWidth : VERSION.SDK_INT >= 16 ? super.getDropDownWidth() : MODE_DIALOG;
    }

    public Drawable getPopupBackground() {
        return this.mPopup != null ? this.mPopup.getBackground() : VERSION.SDK_INT >= 16 ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.mPopup != null ? this.mPopupContext : VERSION.SDK_INT >= 23 ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.mPopup != null ? this.mPopup.getHintText() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.mBackgroundTintHelper != null ? this.mBackgroundTintHelper.getSupportBackgroundTintList() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.mBackgroundTintHelper != null ? this.mBackgroundTintHelper.getSupportBackgroundTintMode() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup != null && MeasureSpec.getMode(i) == RtlSpacingHelper.UNDEFINED) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.mForwardingListener == null || !this.mForwardingListener.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.mPopup == null) {
            return super.performClick();
        }
        if (!this.mPopup.isShowing()) {
            this.mPopup.show();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.mPopupSet) {
            super.setAdapter(spinnerAdapter);
            if (this.mPopup != null) {
                this.mPopup.setAdapter(new DropDownAdapter(spinnerAdapter, (this.mPopupContext == null ? getContext() : this.mPopupContext).getTheme()));
                return;
            }
            return;
        }
        this.mTempAdapter = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.onSetBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.onSetBackgroundResource(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.mPopup != null) {
            this.mPopup.setHorizontalOffset(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.mPopup != null) {
            this.mPopup.setVerticalOffset(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.mPopup != null) {
            this.mPopup.setBackgroundDrawable(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.mPopup != null) {
            this.mPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.setSupportBackgroundTintMode(mode);
        }
    }
}
