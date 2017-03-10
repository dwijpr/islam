package com.andi.alquran.p024a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.andi.alquran.C0861R;

/* renamed from: com.andi.alquran.a.d */
public class C0871d extends ArrayAdapter<String> {
    private Context f1609a;
    private String[] f1610b;
    private String[] f1611c;
    private int f1612d;

    /* renamed from: com.andi.alquran.a.d.a */
    private static class C0870a {
        private TextView f1606a;
        private TextView f1607b;
        private CheckedTextView f1608c;

        private C0870a() {
        }
    }

    public C0871d(Context context, String[] strArr, String[] strArr2, int i) {
        super(context, 17367057, strArr);
        this.f1609a = context;
        this.f1612d = i;
        this.f1610b = strArr;
        this.f1611c = strArr2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f1609a.getSystemService("layout_inflater")).inflate(C0861R.layout.sdcard_item, viewGroup, false);
            C0870a c0870a = new C0870a();
            c0870a.f1606a = (TextView) view.findViewById(C0861R.id.storage_label);
            c0870a.f1607b = (TextView) view.findViewById(C0861R.id.available_free_space);
            c0870a.f1608c = (CheckedTextView) view.findViewById(C0861R.id.checked_text_view);
            view.setTag(c0870a);
        }
        C0870a c0870a2 = (C0870a) view.getTag();
        c0870a2.f1606a.setText(this.f1610b[i]);
        c0870a2.f1607b.setText(this.f1611c[i]);
        c0870a2.f1608c.setText(null);
        if (i == this.f1612d) {
            c0870a2.f1608c.setChecked(true);
        } else {
            c0870a2.f1608c.setChecked(false);
        }
        return view;
    }
}
