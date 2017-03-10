package com.andi.alquran.p024a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.recyclerview.BuildConfig;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.andi.alquran.C0861R;
import com.andi.alquran.p030h.C0917a;
import com.andi.alquran.p030h.C0918b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.andi.alquran.a.e */
public class C0872e extends BaseExpandableListAdapter {
    private Context f1613a;
    private ArrayList<C0917a> f1614b;
    private String f1615c;
    private Typeface f1616d;
    private boolean f1617e;

    public C0872e(Context context, ArrayList<C0917a> arrayList, String str, boolean z) {
        this.f1615c = BuildConfig.VERSION_NAME;
        this.f1613a = context;
        this.f1614b = new ArrayList();
        this.f1614b.addAll(arrayList);
        this.f1615c = str;
        this.f1617e = z;
        this.f1616d = Typeface.createFromAsset(context.getAssets(), "Fontin-Regular.ttf");
    }

    private boolean m3027a(int i, int i2) {
        return (i == 7 && i2 == 206) || ((i == 13 && i2 == 15) || ((i == 16 && i2 == 49) || ((i == 16 && i2 == 50) || ((i == 17 && i2 == C0861R.styleable.AppCompatTheme_radioButtonStyle) || ((i == 17 && i2 == C0861R.styleable.AppCompatTheme_ratingBarStyle) || ((i == 17 && i2 == C0861R.styleable.AppCompatTheme_ratingBarStyleIndicator) || ((i == 19 && i2 == 58) || ((i == 22 && i2 == 18) || ((i == 22 && i2 == 77) || ((i == 25 && i2 == 60) || ((i == 27 && i2 == 24) || ((i == 27 && i2 == 25) || ((i == 27 && i2 == 26) || ((i == 32 && i2 == 15) || ((i == 38 && i2 == 24) || ((i == 41 && i2 == 37) || ((i == 41 && i2 == 38) || ((i == 53 && i2 == 59) || ((i == 53 && i2 == 60) || ((i == 53 && i2 == 62) || ((i == 84 && i2 == 20) || ((i == 84 && i2 == 21) || (i == 96 && i2 == 19)))))))))))))))))))))));
    }

    public Object getChild(int i, int i2) {
        return ((C0917a) this.f1614b.get(i)).m3201c().get(i2);
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C0918b c0918b = (C0918b) getChild(i, i2);
        if (view == null) {
            view = ((LayoutInflater) this.f1613a.getSystemService("layout_inflater")).inflate(this.f1617e ? C0861R.layout.search_row_item : C0861R.layout.dark_search_row_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C0861R.id.textSearch);
        ImageView imageView = (ImageView) view.findViewById(C0861R.id.iconSajadah);
        ((TextView) view.findViewById(C0861R.id.numberSearch)).setText(c0918b.m3204b());
        if (m3027a(Integer.parseInt(c0918b.m3202a()), Integer.parseInt(c0918b.m3204b()))) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        Matcher matcher = Pattern.compile(this.f1615c, 2).matcher(c0918b.m3206c());
        CharSequence spannableStringBuilder = new SpannableStringBuilder(c0918b.m3206c());
        if (this.f1617e) {
            while (matcher.find()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), matcher.start(), matcher.end(), 33);
            }
        } else {
            while (matcher.find()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-256), matcher.start(), matcher.end(), 33);
            }
        }
        textView.setTypeface(this.f1616d);
        textView.setText(spannableStringBuilder);
        return view;
    }

    public int getChildrenCount(int i) {
        return ((C0917a) this.f1614b.get(i)).m3201c().size();
    }

    public Object getGroup(int i) {
        return this.f1614b.get(i);
    }

    public int getGroupCount() {
        return this.f1614b.size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C0917a c0917a = (C0917a) getGroup(i);
        if (view == null) {
            view = ((LayoutInflater) this.f1613a.getSystemService("layout_inflater")).inflate(this.f1617e ? C0861R.layout.search_row_group : C0861R.layout.dark_search_row_group, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C0861R.id.countGroupName);
        ((TextView) view.findViewById(C0861R.id.suraGroupName)).setText(c0917a.m3199a());
        textView.setText(c0917a.m3200b());
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
