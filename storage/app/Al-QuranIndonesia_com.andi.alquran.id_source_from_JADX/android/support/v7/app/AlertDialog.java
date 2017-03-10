package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AlertController.AlertParams;
import android.support.v7.appcompat.C0627R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class Builder {
        private final AlertParams f1111P;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, AlertDialog.LAYOUT_HINT_NONE));
        }

        public Builder(Context context, int i) {
            this.f1111P = new AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f1111P.mContext, this.mTheme);
            this.f1111P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.f1111P.mCancelable);
            if (this.f1111P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f1111P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f1111P.mOnDismissListener);
            if (this.f1111P.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f1111P.mOnKeyListener);
            }
            return alertDialog;
        }

        public Context getContext() {
            return this.f1111P.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f1111P.mAdapter = listAdapter;
            this.f1111P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f1111P.mCancelable = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, OnClickListener onClickListener, String str) {
            this.f1111P.mCursor = cursor;
            this.f1111P.mLabelColumn = str;
            this.f1111P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.f1111P.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(int i) {
            this.f1111P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f1111P.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f1111P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.f1111P.mIconId = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.f1111P.mForceInverseBackground = z;
            return this;
        }

        public Builder setItems(int i, OnClickListener onClickListener) {
            this.f1111P.mItems = this.f1111P.mContext.getResources().getTextArray(i);
            this.f1111P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            this.f1111P.mItems = charSequenceArr;
            this.f1111P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(int i) {
            this.f1111P.mMessage = this.f1111P.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f1111P.mMessage = charSequence;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1111P.mItems = this.f1111P.mContext.getResources().getTextArray(i);
            this.f1111P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1111P.mCheckedItems = zArr;
            this.f1111P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1111P.mCursor = cursor;
            this.f1111P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1111P.mIsCheckedColumn = str;
            this.f1111P.mLabelColumn = str2;
            this.f1111P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f1111P.mItems = charSequenceArr;
            this.f1111P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f1111P.mCheckedItems = zArr;
            this.f1111P.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(int i, OnClickListener onClickListener) {
            this.f1111P.mNegativeButtonText = this.f1111P.mContext.getText(i);
            this.f1111P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1111P.mNegativeButtonText = charSequence;
            this.f1111P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, OnClickListener onClickListener) {
            this.f1111P.mNeutralButtonText = this.f1111P.mContext.getText(i);
            this.f1111P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1111P.mNeutralButtonText = charSequence;
            this.f1111P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.f1111P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.f1111P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
            this.f1111P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            this.f1111P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(int i, OnClickListener onClickListener) {
            this.f1111P.mPositiveButtonText = this.f1111P.mContext.getText(i);
            this.f1111P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1111P.mPositiveButtonText = charSequence;
            this.f1111P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f1111P.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, OnClickListener onClickListener) {
            this.f1111P.mItems = this.f1111P.mContext.getResources().getTextArray(i);
            this.f1111P.mOnClickListener = onClickListener;
            this.f1111P.mCheckedItem = i2;
            this.f1111P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, OnClickListener onClickListener) {
            this.f1111P.mCursor = cursor;
            this.f1111P.mOnClickListener = onClickListener;
            this.f1111P.mCheckedItem = i;
            this.f1111P.mLabelColumn = str;
            this.f1111P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, OnClickListener onClickListener) {
            this.f1111P.mAdapter = listAdapter;
            this.f1111P.mOnClickListener = onClickListener;
            this.f1111P.mCheckedItem = i;
            this.f1111P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener) {
            this.f1111P.mItems = charSequenceArr;
            this.f1111P.mOnClickListener = onClickListener;
            this.f1111P.mCheckedItem = i;
            this.f1111P.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(int i) {
            this.f1111P.mTitle = this.f1111P.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f1111P.mTitle = charSequence;
            return this;
        }

        public Builder setView(int i) {
            this.f1111P.mView = null;
            this.f1111P.mViewLayoutResId = i;
            this.f1111P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.f1111P.mView = view;
            this.f1111P.mViewLayoutResId = AlertDialog.LAYOUT_HINT_NONE;
            this.f1111P.mViewSpacingSpecified = false;
            return this;
        }

        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.f1111P.mView = view;
            this.f1111P.mViewLayoutResId = AlertDialog.LAYOUT_HINT_NONE;
            this.f1111P.mViewSpacingSpecified = true;
            this.f1111P.mViewSpacingLeft = i;
            this.f1111P.mViewSpacingTop = i2;
            this.f1111P.mViewSpacingRight = i3;
            this.f1111P.mViewSpacingBottom = i4;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }

    protected AlertDialog(Context context) {
        this(context, LAYOUT_HINT_NONE);
    }

    protected AlertDialog(Context context, int i) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean z, OnCancelListener onCancelListener) {
        this(context, LAYOUT_HINT_NONE);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    static int resolveDialogTheme(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0627R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mAlert.onKeyDown(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mAlert.onKeyUp(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i, charSequence, null, message);
    }

    void setButtonPanelLayoutHint(int i) {
        this.mAlert.setButtonPanelLayoutHint(i);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }
}
