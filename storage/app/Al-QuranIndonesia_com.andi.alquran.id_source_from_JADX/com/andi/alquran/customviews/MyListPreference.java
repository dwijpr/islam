package com.andi.alquran.customviews;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import com.andi.alquran.C0861R;

public class MyListPreference extends ListPreference {
    private int f1724a;
    private Context f1725b;

    /* renamed from: com.andi.alquran.customviews.MyListPreference.1 */
    class C08901 extends ArrayAdapter<CharSequence> {
        final /* synthetic */ MyListPreference f1722a;

        C08901(MyListPreference myListPreference, Context context, int i, CharSequence[] charSequenceArr) {
            this.f1722a = myListPreference;
            super(context, i, charSequenceArr);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (CheckedTextView) view;
            View view2 = view == null ? (CheckedTextView) View.inflate(getContext(), C0861R.layout.pref_listpreference, null) : view;
            view2.setText(this.f1722a.getEntries()[i]);
            return view2;
        }
    }

    /* renamed from: com.andi.alquran.customviews.MyListPreference.2 */
    class C08912 implements OnClickListener {
        final /* synthetic */ MyListPreference f1723a;

        C08912(MyListPreference myListPreference) {
            this.f1723a = myListPreference;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1723a.f1724a = i;
            this.f1723a.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    public MyListPreference(Context context) {
        super(context);
        this.f1725b = context;
    }

    public MyListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1725b = context;
    }

    protected void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        if (z && this.f1724a >= 0 && getEntryValues() != null) {
            String charSequence = getEntryValues()[this.f1724a].toString();
            if (callChangeListener(charSequence)) {
                setValue(charSequence);
            }
        }
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        if (getEntries() == null || getEntryValues() == null) {
            super.onPrepareDialogBuilder(builder);
            return;
        }
        ListAdapter c08901 = new C08901(this, getContext(), C0861R.layout.pref_listpreference, getEntries());
        this.f1724a = findIndexOfValue(getValue());
        builder.setSingleChoiceItems(c08901, this.f1724a, new C08912(this));
        builder.setPositiveButton(null, null);
        builder.setNegativeButton(this.f1725b.getResources().getString(C0861R.string.cancel), null);
    }
}
