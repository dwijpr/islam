package com.andi.alquran.customviews;

import android.content.Context;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;

public class MyCategoryPreference extends PreferenceCategory {
    private Context f1721a;

    public MyCategoryPreference(Context context) {
        super(context);
        this.f1721a = context;
    }

    public MyCategoryPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1721a = context;
    }

    public MyCategoryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1721a = context;
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        ((TextView) view.findViewById(16908310)).setTextColor(App.m2867b(this.f1721a, (int) C0861R.color.bgHeader));
    }
}
