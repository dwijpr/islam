package com.andi.alquran.p024a;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.andi.alquran.C0861R;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.andi.alquran.a.a */
public class C0862a extends ArrayAdapter<String> {
    private List<Integer> f1590a;

    public C0862a(Context context, String[] strArr, Integer[] numArr) {
        super(context, C0861R.layout.dialog_with_icon, strArr);
        this.f1590a = Arrays.asList(numArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        TextView textView = (TextView) view2.findViewById(16908308);
        textView.setCompoundDrawablesWithIntrinsicBounds(((Integer) this.f1590a.get(i)).intValue(), 0, 0, 0);
        textView.setCompoundDrawablePadding((int) TypedValue.applyDimension(1, 12.0f, getContext().getResources().getDisplayMetrics()));
        return view2;
    }
}
