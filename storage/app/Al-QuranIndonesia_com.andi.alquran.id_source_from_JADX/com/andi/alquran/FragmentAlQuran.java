package com.andi.alquran;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.andi.alquran.customviews.MyWord;
import com.andi.alquran.p024a.C0862a;
import com.andi.alquran.p025b.C0878a.C0876a;
import com.andi.alquran.p025b.C0878a.C0877b;
import com.andi.alquran.p026c.C0885a.C0883a;
import com.andi.alquran.p026c.C0885a.C0884b;
import com.andi.alquran.services.MurattalService;
import com.google.android.gms.maps.GoogleMap;

public class FragmentAlQuran extends ListFragment {
    private final QuranAdapter f1490a;
    private App f1491b;
    private int f1492c;
    private C0883a f1493d;
    private C0883a f1494e;
    private SharedPreferences f1495f;
    private Typeface f1496g;
    private Typeface f1497h;
    private Typeface f1498i;
    private Typeface f1499j;
    private OnScrollListener f1500k;
    private final OnItemLongClickListener f1501l;

    /* renamed from: com.andi.alquran.FragmentAlQuran.1 */
    class C08281 implements OnScrollListener {
        final /* synthetic */ FragmentAlQuran f1463a;

        C08281(FragmentAlQuran fragmentAlQuran) {
            this.f1463a = fragmentAlQuran;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f1463a.getUserVisibleHint()) {
                this.f1463a.m2928a(i);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: com.andi.alquran.FragmentAlQuran.2 */
    class C08292 implements OnClickListener {
        final /* synthetic */ C0883a f1464a;
        final /* synthetic */ FragmentAlQuran f1465b;

        C08292(FragmentAlQuran fragmentAlQuran, C0883a c0883a) {
            this.f1465b = fragmentAlQuran;
            this.f1464a = c0883a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                this.f1465b.m2958f(this.f1464a);
            } else if (i == 1) {
                this.f1465b.m2932a(this.f1464a);
            } else if (i == 2) {
                this.f1465b.m2942b(this.f1464a);
            } else if (i == 3) {
                this.f1465b.m2948c(this.f1464a);
            } else if (i == 4) {
                this.f1465b.m2952d(this.f1464a);
            }
        }
    }

    /* renamed from: com.andi.alquran.FragmentAlQuran.3 */
    class C08313 implements OnItemLongClickListener {
        final /* synthetic */ FragmentAlQuran f1468a;

        /* renamed from: com.andi.alquran.FragmentAlQuran.3.1 */
        class C08301 implements OnClickListener {
            final /* synthetic */ C0883a f1466a;
            final /* synthetic */ C08313 f1467b;

            C08301(C08313 c08313, C0883a c0883a) {
                this.f1467b = c08313;
                this.f1466a = c0883a;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    this.f1467b.f1468a.m2958f(this.f1466a);
                } else if (i == 1) {
                    this.f1467b.f1468a.m2932a(this.f1466a);
                } else if (i == 2) {
                    this.f1467b.f1468a.m2942b(this.f1466a);
                } else if (i == 3) {
                    this.f1467b.f1468a.m2948c(this.f1466a);
                } else if (i == 4) {
                    this.f1467b.f1468a.m2952d(this.f1466a);
                }
            }
        }

        C08313(FragmentAlQuran fragmentAlQuran) {
            this.f1468a = fragmentAlQuran;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f1468a.f1491b.f1450b.f1677p != 1) {
                C0883a c0883a = (C0883a) adapterView.getItemAtPosition(i);
                if (c0883a.f1703b > 0) {
                    String[] strArr = new String[]{this.f1468a.getString(C0861R.string.action_play_murattal), this.f1468a.getString(C0861R.string.action_copy), this.f1468a.getString(C0861R.string.action_share), this.f1468a.getString(C0861R.string.action_add_to_bookmark), this.f1468a.getString(C0861R.string.action_set_last_read)};
                    Integer[] numArr = new Integer[]{Integer.valueOf(C0861R.drawable.ic_black_action_play_murattal), Integer.valueOf(C0861R.drawable.ic_black_action_copy), Integer.valueOf(C0861R.drawable.ic_black_action_share), Integer.valueOf(C0861R.drawable.ic_black_action_add_to_bookmark), Integer.valueOf(C0861R.drawable.ic_black_action_set_last_read)};
                    if (this.f1468a.f1491b.f1450b.f1676o == 2) {
                        numArr = new Integer[]{Integer.valueOf(C0861R.drawable.ic_action_play), Integer.valueOf(C0861R.drawable.ic_white_copy), Integer.valueOf(C0861R.drawable.ic_white_share), Integer.valueOf(C0861R.drawable.ic_white_add_to_bookmark), Integer.valueOf(C0861R.drawable.ic_white_mark_last_read)};
                    }
                    new Builder(this.f1468a.getActivity()).setTitle(this.f1468a.f1491b.m2903a(c0883a)).setAdapter(new C0862a(this.f1468a.getActivity(), strArr, numArr), new C08301(this, c0883a)).show();
                }
            }
            return false;
        }
    }

    /* renamed from: com.andi.alquran.FragmentAlQuran.4 */
    class C08324 implements OnClickListener {
        final /* synthetic */ C0883a f1469a;
        final /* synthetic */ FragmentAlQuran f1470b;

        C08324(FragmentAlQuran fragmentAlQuran, C0883a c0883a) {
            this.f1470b = fragmentAlQuran;
            this.f1469a = c0883a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i < this.f1470b.f1491b.f1452d.m3054a()) {
                this.f1470b.m2933a(this.f1469a, this.f1470b.f1491b.f1452d.m3055a(i));
                return;
            }
            this.f1470b.m2955e(this.f1469a);
        }
    }

    /* renamed from: com.andi.alquran.FragmentAlQuran.5 */
    class C08335 implements OnClickListener {
        final /* synthetic */ SharedPreferences f1471a;
        final /* synthetic */ C0883a f1472b;
        final /* synthetic */ String f1473c;
        final /* synthetic */ FragmentAlQuran f1474d;

        C08335(FragmentAlQuran fragmentAlQuran, SharedPreferences sharedPreferences, C0883a c0883a, String str) {
            this.f1474d = fragmentAlQuran;
            this.f1471a = sharedPreferences;
            this.f1472b = c0883a;
            this.f1473c = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f1471a.edit();
            edit.putString("lastReadSura", BuildConfig.VERSION_NAME + this.f1472b.f1702a);
            edit.putString("lastReadAya", BuildConfig.VERSION_NAME + this.f1472b.f1703b);
            edit.putLong("lastReadDate", System.currentTimeMillis());
            edit.apply();
            App.m2865a(this.f1474d.getString(C0861R.string.msg_last_read_success_changed, this.f1473c));
        }
    }

    /* renamed from: com.andi.alquran.FragmentAlQuran.6 */
    class C08346 implements OnClickListener {
        final /* synthetic */ TextView f1475a;
        final /* synthetic */ C0883a f1476b;
        final /* synthetic */ FragmentAlQuran f1477c;

        C08346(FragmentAlQuran fragmentAlQuran, TextView textView, C0883a c0883a) {
            this.f1477c = fragmentAlQuran;
            this.f1475a = textView;
            this.f1476b = c0883a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f1475a.getText().length() > 0) {
                C0876a c0876a = new C0876a(this.f1475a.getText().toString(), 1);
                this.f1477c.f1491b.f1452d.m3058a(c0876a);
                this.f1477c.m2933a(this.f1476b, c0876a);
            }
        }
    }

    private static class AyaRowHolder {
        public TextView f1478a;
        public TextView f1479b;
        public TextView f1480c;
        private TextView f1481d;
        private View f1482e;
        private MyWord f1483f;
        private ImageView f1484g;

        private AyaRowHolder() {
        }
    }

    public class QuranAdapter extends BaseAdapter {
        final /* synthetic */ FragmentAlQuran f1485a;

        public QuranAdapter(FragmentAlQuran fragmentAlQuran) {
            this.f1485a = fragmentAlQuran;
        }

        private Drawable m2913a() {
            return this.f1485a.f1491b.f1450b.f1676o == 1 ? App.m2861a(this.f1485a.getActivity(), (int) C0861R.drawable.bg_list_number_normal) : App.m2861a(this.f1485a.getActivity(), (int) C0861R.drawable.bg_list_number_normal_dark);
        }

        private Drawable m2914b() {
            return this.f1485a.f1491b.f1450b.f1676o == 1 ? App.m2861a(this.f1485a.getActivity(), (int) C0861R.drawable.bg_list_number_alternate) : App.m2861a(this.f1485a.getActivity(), (int) C0861R.drawable.bg_list_number_alternate_dark);
        }

        private Drawable m2915c() {
            return this.f1485a.f1491b.f1450b.f1676o == 1 ? App.m2861a(this.f1485a.getActivity(), (int) C0861R.drawable.bg_list_number_selected) : App.m2861a(this.f1485a.getActivity(), (int) C0861R.drawable.bg_list_number_selected_dark);
        }

        public int getCount() {
            int i = 0;
            int i2 = this.f1485a.f1493d.f1703b == 1 ? 0 : this.f1485a.f1493d.f1703b;
            int i3 = this.f1485a.f1493d.f1702a;
            int i4 = i2;
            while (i3 < this.f1485a.f1494e.f1702a) {
                i3++;
                i = ((this.f1485a.f1491b.f1453e.m3073a(i3).f1706c + 1) - i4) + i;
                i4 = 0;
            }
            return ((this.f1485a.f1494e.f1703b - i4) + 1) + i;
        }

        public Object getItem(int i) {
            int i2 = this.f1485a.f1493d.f1702a;
            int i3 = this.f1485a.f1493d.f1703b == 1 ? 0 : this.f1485a.f1493d.f1703b;
            while (i > this.f1485a.f1491b.f1453e.m3073a(i2).f1706c - i3) {
                i -= (this.f1485a.f1491b.f1453e.m3073a(i2).f1706c - i3) + 1;
                i2++;
                i3 = 0;
            }
            return new C0883a(i2, i3 + i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return ((C0883a) getItem(i)).f1703b == 0 ? 0 : 1;
        }

        @SuppressLint({"RtlHardcoded"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0883a c0883a = (C0883a) getItem(i);
            int i2 = App.m2857a(this.f1485a.getActivity()) == 3 ? 6 : App.m2857a(this.f1485a.getActivity()) == 4 ? 7 : 0;
            View inflate;
            if (c0883a.f1703b == 0) {
                SuraRowHolder suraRowHolder;
                if (view == null) {
                    inflate = this.f1485a.f1491b.f1450b.f1676o == 1 ? this.f1485a.getActivity().getLayoutInflater().inflate(C0861R.layout.row_sura, viewGroup, false) : this.f1485a.getActivity().getLayoutInflater().inflate(C0861R.layout.dark_row_sura, viewGroup, false);
                    SuraRowHolder suraRowHolder2 = new SuraRowHolder();
                    suraRowHolder2.f1486a = (TextView) inflate.findViewById(C0861R.id.sura_name);
                    suraRowHolder2.f1487b = (TextView) inflate.findViewById(C0861R.id.sura_traslation);
                    suraRowHolder2.f1488c = (TextView) inflate.findViewById(C0861R.id.sura_type_count_ayas);
                    suraRowHolder2.f1489d = (TextView) inflate.findViewById(C0861R.id.bismillah);
                    inflate.setTag(suraRowHolder2);
                    suraRowHolder = suraRowHolder2;
                } else {
                    suraRowHolder = (SuraRowHolder) view.getTag();
                    inflate = view;
                }
                C0884b a = this.f1485a.f1491b.f1453e.m3073a(c0883a.f1702a);
                suraRowHolder.f1486a.setText(BuildConfig.VERSION_NAME + c0883a.f1702a + ". " + App.m2863a(c0883a.f1702a));
                suraRowHolder.f1487b.setText("(" + App.m2869b(c0883a.f1702a) + ")");
                suraRowHolder.f1488c.setText(App.m2864a(a.f1712i, a.f1706c));
                if (this.f1485a.f1492c == 1) {
                    suraRowHolder.f1486a.setVisibility(8);
                }
                if (c0883a.f1702a == 1 || c0883a.f1702a == 9) {
                    suraRowHolder.f1489d.setVisibility(8);
                } else {
                    suraRowHolder.f1489d.setVisibility(0);
                    CharSequence a2 = this.f1485a.f1491b.f1450b.f1670i == 0 ? this.f1485a.f1491b.f1454f.m3077a(1, 1) : this.f1485a.f1491b.f1455g.m3077a(1, 1);
                    suraRowHolder.f1489d.setTextSize(2, (float) (i2 + (this.f1485a.f1491b.f1450b.f1671j + 2)));
                    suraRowHolder.f1489d.setText(a2);
                }
                return inflate;
            }
            AyaRowHolder ayaRowHolder;
            int i3;
            int length;
            if (view == null) {
                inflate = this.f1485a.f1491b.f1450b.f1676o == 1 ? this.f1485a.getActivity().getLayoutInflater().inflate(C0861R.layout.row_aya, viewGroup, false) : this.f1485a.getActivity().getLayoutInflater().inflate(C0861R.layout.dark_row_aya, viewGroup, false);
                AyaRowHolder ayaRowHolder2 = new AyaRowHolder();
                ayaRowHolder2.f1482e = inflate.findViewById(C0861R.id.bagian_nomor);
                ayaRowHolder2.f1481d = (TextView) inflate.findViewById(C0861R.id.aya_number);
                ayaRowHolder2.f1478a = (TextView) inflate.findViewById(C0861R.id.arabic);
                ayaRowHolder2.f1479b = (TextView) inflate.findViewById(C0861R.id.latin);
                ayaRowHolder2.f1480c = (TextView) inflate.findViewById(C0861R.id.translation);
                ayaRowHolder2.f1483f = (MyWord) inflate.findViewById(C0861R.id.word_by_word);
                ayaRowHolder2.f1484g = (ImageView) inflate.findViewById(C0861R.id.iconSajadah);
                inflate.setTag(ayaRowHolder2);
                view = inflate;
                ayaRowHolder = ayaRowHolder2;
            } else {
                ayaRowHolder = (AyaRowHolder) view.getTag();
            }
            if (this.f1485a.m2943b(c0883a.f1702a, c0883a.f1703b)) {
                ayaRowHolder.f1484g.setVisibility(0);
            } else {
                ayaRowHolder.f1484g.setVisibility(8);
            }
            CharSequence charSequence = BuildConfig.VERSION_NAME;
            if (this.f1485a.f1491b.f1450b.f1670i == 0) {
                charSequence = this.f1485a.m2927a(this.f1485a.f1491b.f1454f.m3077a(c0883a.f1702a, c0883a.f1703b));
                if (this.f1485a.f1491b.f1450b.f1665d) {
                    charSequence = charSequence + "  \ufd3f" + this.f1485a.m2937b(c0883a.f1703b) + "\ufd3e";
                }
                i3 = i2 - 1;
            } else {
                if (this.f1485a.f1491b.f1450b.f1670i == 1) {
                    charSequence = this.f1485a.m2927a(this.f1485a.f1491b.f1455g.m3077a(c0883a.f1702a, c0883a.f1703b));
                    if (this.f1485a.f1491b.f1450b.f1665d) {
                        charSequence = charSequence + " " + this.f1485a.m2937b(c0883a.f1703b);
                        i3 = i2;
                    }
                }
                i3 = i2;
            }
            ayaRowHolder.f1478a.setVisibility(0);
            ayaRowHolder.f1478a.setText(charSequence);
            ayaRowHolder.f1478a.setTextSize(2, (float) ((this.f1485a.f1491b.f1450b.f1671j + 6) + i3));
            ayaRowHolder.f1478a.setGravity(5);
            if (this.f1485a.f1491b.f1450b.f1662a) {
                if (this.f1485a.f1491b.f1450b.f1675n == 1) {
                    charSequence = this.f1485a.f1491b.f1458j.m3077a(c0883a.f1702a, c0883a.f1703b);
                    if (BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) || BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu")) {
                        charSequence = this.f1485a.m2946c((String) charSequence);
                    }
                    ayaRowHolder.f1479b.setText(charSequence);
                    ayaRowHolder.f1479b.setTypeface(this.f1485a.f1496g);
                } else {
                    Object a3 = this.f1485a.f1491b.f1459k.m3077a(c0883a.f1702a, c0883a.f1703b);
                    ayaRowHolder.f1479b.setText(a3);
                    ayaRowHolder.f1479b.setText(Html.fromHtml(a3));
                    ayaRowHolder.f1479b.setTypeface(this.f1485a.f1497h);
                }
                ayaRowHolder.f1479b.setTextSize(2, (float) (this.f1485a.f1491b.f1450b.f1673l + i2));
                ayaRowHolder.f1479b.setVisibility(0);
            } else {
                ayaRowHolder.f1479b.setVisibility(8);
            }
            if (this.f1485a.f1491b.f1450b.f1663b) {
                charSequence = (this.f1485a.f1491b.f1450b.f1674m == 1 ? this.f1485a.f1491b.f1456h.m3077a(c0883a.f1702a, c0883a.f1703b) : this.f1485a.f1491b.f1457i.m3077a(c0883a.f1702a, c0883a.f1703b)).trim();
                if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu")) {
                    ayaRowHolder.f1480c.setTypeface(this.f1485a.f1498i);
                    ayaRowHolder.f1480c.setGravity(5);
                    ayaRowHolder.f1480c.setTextSize(2, (float) ((this.f1485a.f1491b.f1450b.f1672k + 6) + i2));
                } else {
                    ayaRowHolder.f1480c.setTypeface(this.f1485a.f1499j);
                    ayaRowHolder.f1480c.setTextSize(2, (float) (this.f1485a.f1491b.f1450b.f1672k + i2));
                }
                ayaRowHolder.f1480c.setText(charSequence);
                if (this.f1485a.f1491b.f1450b.f1662a) {
                    if (this.f1485a.f1491b.f1450b.f1676o == 1) {
                        ayaRowHolder.f1480c.setTextColor(App.m2867b(this.f1485a.getActivity(), (int) C0861R.color.texttranslation2));
                    } else {
                        ayaRowHolder.f1480c.setTextColor(App.m2867b(this.f1485a.getActivity(), (int) C0861R.color.darkTextQuran3));
                    }
                } else if (this.f1485a.f1491b.f1450b.f1676o == 1) {
                    ayaRowHolder.f1480c.setTextColor(App.m2867b(this.f1485a.getActivity(), (int) C0861R.color.texttranslation));
                } else {
                    ayaRowHolder.f1480c.setTextColor(App.m2867b(this.f1485a.getActivity(), (int) C0861R.color.darkTextQuran3));
                }
                ayaRowHolder.f1480c.setVisibility(0);
            } else {
                ayaRowHolder.f1480c.setVisibility(8);
            }
            if (App.f1448m.f1450b.f1666e) {
                ayaRowHolder.f1483f.setVisibility(0);
                String[][] a4 = App.f1448m.f1460l.m3082a(c0883a.f1702a, c0883a.f1703b);
                LayoutInflater layoutInflater = this.f1485a.getActivity().getLayoutInflater();
                if (this.f1485a.f1491b.f1450b.f1676o == 1) {
                    while (ayaRowHolder.f1483f.getChildCount() < a4.length) {
                        ayaRowHolder.f1483f.addView(layoutInflater.inflate(C0861R.layout.katademikata, viewGroup, false));
                    }
                } else {
                    while (ayaRowHolder.f1483f.getChildCount() < a4.length) {
                        ayaRowHolder.f1483f.addView(layoutInflater.inflate(C0861R.layout.dark_katademikata, viewGroup, false));
                    }
                }
                int i4 = this.f1485a.f1491b.f1450b.f1670i == 0 ? i2 - 1 : i2;
                for (int i5 = 0; i5 < a4.length; i5++) {
                    View childAt = ayaRowHolder.f1483f.getChildAt(i5);
                    TextView textView = (TextView) childAt.findViewById(C0861R.id.arabic);
                    TextView textView2 = (TextView) childAt.findViewById(C0861R.id.translation);
                    textView.setText(this.f1485a.m2940b(a4[i5][0]));
                    textView2.setText(a4[i5][1]);
                    textView.setTextSize(2, (float) ((this.f1485a.f1491b.f1450b.f1671j + 5) + i3));
                    textView2.setTextSize(2, (float) ((this.f1485a.f1491b.f1450b.f1672k + i4) - 2));
                    textView2.setTypeface(this.f1485a.f1499j);
                    childAt.setVisibility(0);
                }
                for (length = a4.length; length < ayaRowHolder.f1483f.getChildCount(); length++) {
                    ayaRowHolder.f1483f.getChildAt(length).setVisibility(8);
                }
            } else {
                ayaRowHolder.f1483f.setVisibility(8);
            }
            ayaRowHolder.f1482e.setVisibility(0);
            ayaRowHolder.f1481d.setText(BuildConfig.VERSION_NAME + c0883a.f1703b + BuildConfig.VERSION_NAME);
            if (MurattalService.f1949b) {
                length = this.f1485a.f1495f.getInt("suraSelected", 1);
                i2 = this.f1485a.f1495f.getInt("ayaSelected", 1);
                C0884b a5 = this.f1485a.f1491b.f1453e.m3073a(c0883a.f1702a);
                if (i == this.f1485a.m2924a(length, i2) || (i2 == 1 && i == this.f1485a.m2924a(length, i2) + 1)) {
                    if (length == a5.f1704a) {
                        if (VERSION.SDK_INT >= 16) {
                            view.setBackground(m2915c());
                            return view;
                        }
                        view.setBackgroundDrawable(m2915c());
                        return view;
                    } else if (VERSION.SDK_INT >= 16) {
                        if (i % 2 == 1) {
                            view.setBackground(m2914b());
                            return view;
                        }
                        view.setBackground(m2913a());
                        return view;
                    } else if (i % 2 == 1) {
                        view.setBackgroundDrawable(m2914b());
                        return view;
                    } else {
                        view.setBackgroundDrawable(m2913a());
                        return view;
                    }
                } else if (VERSION.SDK_INT >= 16) {
                    if (i % 2 == 1) {
                        view.setBackground(m2914b());
                        return view;
                    }
                    view.setBackground(m2913a());
                    return view;
                } else if (i % 2 == 1) {
                    view.setBackgroundDrawable(m2914b());
                    return view;
                } else {
                    view.setBackgroundDrawable(m2913a());
                    return view;
                }
            } else if (VERSION.SDK_INT >= 16) {
                if (i % 2 == 1) {
                    view.setBackground(m2914b());
                    return view;
                }
                view.setBackground(m2913a());
                return view;
            } else if (i % 2 == 1) {
                view.setBackgroundDrawable(m2914b());
                return view;
            } else {
                view.setBackgroundDrawable(m2913a());
                return view;
            }
        }

        public int getViewTypeCount() {
            return 2;
        }
    }

    private static class SuraRowHolder {
        private TextView f1486a;
        private TextView f1487b;
        private TextView f1488c;
        private TextView f1489d;

        private SuraRowHolder() {
        }
    }

    public FragmentAlQuran() {
        this.f1490a = new QuranAdapter(this);
        this.f1500k = new C08281(this);
        this.f1501l = new C08313(this);
    }

    private int m2924a(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1493d.f1703b == 1 ? 0 : this.f1493d.f1703b;
        int i6 = this.f1493d.f1702a;
        int i7 = i5;
        while (i6 < i) {
            i6++;
            i4 = ((this.f1491b.f1453e.m3073a(i6).f1706c + 1) - i7) + i4;
            i7 = 0;
        }
        i6 = i2 - i7;
        if (i2 == 1) {
            i3 = 1;
        }
        return (i6 - i3) + i4;
    }

    private String m2927a(String str) {
        return (this.f1491b.f1450b.f1670i == 0 ? str.replaceAll("\u06db\u06da\u06d6", "\u06db").replaceAll("\u06db\u06da", " \u06db ").replaceAll("\u06e0", "\u06e1").replaceAll("\u0646\u0651\u064e\u0627\u0652", "\u0646\u0651\u064e\u0623\u0652").replaceAll(" \u0627\u064e\u0646\u064e\u0627", " \u0627\u064e\u0646\u064e\u0627\u06e1").replaceAll("\u0627\u064e\u0646\u064e\u0627\u06e1\u0628\u064e", "\u0627\u064e\u0646\u064e\u0627\u0628\u064e").replaceAll("\u064a\u064e\u0633\u0652\u062a\u064e\u0640\u0627\u062e\u0650\u0631\u064f", "\u064a\u064e\u0633\u0652\u062a\u064e\u0640\u0654\u06e1\u062e\u0650\u0631\u064f").replaceAll("\u064a\u064e\u0633\u0652\u062a\u064e\u0627\u0652\u062e\u0650\u0631\u064f", "\u064a\u064e\u0633\u0652\u062a\u064e\u0640\u0654\u06e1\u062e\u0650\u0631\u064f").replaceAll("\u0627\u0652", "\u0623\u0652").replaceAll("\u066e\u0655", "\u0626").replaceAll("\u0640\u0655", "\u0626").replaceAll("\ue01a", " \ue01a ").replaceAll("\ue021", " \ue021 ").replaceAll("\u066e\u0655", "\u0626").replaceAll("\u0640\u0654", "\u0626").replaceAll("\u0636\u064f\u0614\u0639\u0652\u0641\u064d", "\u0636\u064e\u0639\u0652\u0641\u064d").replaceAll("\u0636\u064f\u0614\u0639\u0652\u0641\u064b", "\u0636\u064e\u0639\u0652\u0641\u064b").replaceAll("\u06df", "\u06e1").replaceAll("\ue021", BuildConfig.VERSION_NAME).replaceAll("\u200c", BuildConfig.VERSION_NAME).replaceAll("\u2002", BuildConfig.VERSION_NAME).replaceAll("\u0614", BuildConfig.VERSION_NAME).replaceAll("\u2003", BuildConfig.VERSION_NAME).replaceAll("\ue01e", "\u06d9").replaceAll("\ue01a", "\u06d6").replaceAll("\ue01b", "\u06d6").replaceAll("\ue01c", "\u06d9").replaceAll("\u06d9\u06e2", "\u06e2").replaceAll("\u06d6\u06da", "\u06da").replaceAll("\u06d6  \u06da", "\u06da").replaceAll("\u06d6   \u06da", "\u06d6").replaceAll("\u06da\u06d9", "\u06da").replaceAll("\u06db\u0615", "\u06db").replaceAll("\u06d6\u06d9", "\u06d6").replaceAll("\u06d8\u0604", " \u06dc ").replaceAll("\u06d9\u06da", "\u06d9").replaceAll("\u06da\u06d6", "\u06d6").replaceAll("\ue01f", "\u0615").replaceAll("\u06d6\u06d9", "\u06d6").replaceAll("\u06d6 \u06d9", "\u06d6").replaceAll("\u06d6  \u06d9", "\u06d6").replaceAll("\u06d9\u06d6", "\u06d6").replaceAll("\u06d9 \u06d6", "\u06d6").replaceAll("\u06d9  \u06d6", "\u06d6").replaceAll("\u06d6\u06d6", "\u06d6").replaceAll("\u06d6 \u06d6", "\u06d6").replaceAll("\u06d6  \u06d6", "\u06d6").replaceAll("\u06d9\u0615", "\u0615").replaceAll("\u06d9 \u0615", "\u0615").replaceAll("\u06d9  \u0615", "\u0615").replaceAll("\u0644\u064e\u0649\u0670", "\u0644\u0670\u0649").replaceAll("\u064e\u0649\u0670\u06e4", "\u0670\u06e4\u0649").replaceAll("\u0649\u0652", "\u064a\u0652").replaceAll("\u0649\u0651", "\u064a\u0651").replaceAll("\u0649\u0650", "\u064a\u0650").replaceAll("\u0649\u064f", "\u064a\u064f").replaceAll("\u0649\u064e", "\u064a\u064e").replaceAll("\u0649\u064d", "\u064a\u064d").replaceAll("\u0649\u064c", "\u064a\u064c").replaceAll("\u0649\u064b", "\u064a\u064b").replaceAll("\u0649\u0656", "\u064a\u0656").replaceAll("\u0649\u0670", "\u064a\u0670").replaceAll("\u0644\u064e\u0627\u064e\u064a\u064e\u0629", "\u0644\u064e\u0627\u0670\u064a\u064e\u0629").replaceAll("\u0627\u064e\u0644\u064e\u0627", "\u0627\u064e \u0644\u064e\u0627").replaceAll("\u0604", " \u06dc ").replaceAll("\u06e6", "\u064a").replaceAll("\u06dc\u064e", "\u064e\u06dc").replaceAll("\u06db\u06da", "\u06db").replaceAll("\u06da\u06db", "\u06db").replaceAll("\u06db\u06d9", "\u06db").replaceAll("\u0643\u064e  \u0643", "\u0643\u064e \u0643").replaceAll("\u06e8\u0627", "\u0627\u06e8 ").replaceAll("\u0644\u0651\u0670\u0653\u0640\u064a\u0650\u0654\u0652", "\u0644\u0651\u0653\u0640\u0670\u0640\u0626\u0650\u0640\u064a\u0652").replaceAll("\u0644([\u064b-\u0657])\u0627\u064e  \u0643([\u064b-\u065e])([\u0628-\u064a]|$)", "\u0644$1\u0627\u064e\u06aa$2$3").replaceAll("\u0644([\u064b-\u0657])\u0627\u064e \u0643([\u064b-\u065e])([\u0628-\u064a]|$)", "\u0644$1\u0627\u064e\u06aa$2$3").replaceAll("\u0644([\u064b-\u0657])\u0627\u064e\u0643([\u064b-\u065e])([\u0628-\u064a]|$)", "\u0644$1\u0627\u064e\u06aa$2$3") : str.replaceAll("([\u0645\u0646])([ \u0627-\u064a]|$)", "$1\u0652$2").replaceAll("\u0640\u0654", "\u0626").replaceAll("\u06ed", BuildConfig.VERSION_NAME).replaceAll("\u0650\u06e6\u0645", "\u0650\u0640\u06e7\u0645").replaceAll("\u0644\u0651\u0670\u0653\u0626\u0650\u0649", "\u0644\u0651\u064e\u0640\u0670\u0653\u0640\u0640\u0654\u0650\u0649")).replaceAll("\u06da", " \u06da ").replaceAll("\u061e", " \u061e ").replaceAll("\u06db", " \u06db ").replaceAll("\u06d9", " \u06d9 ").replaceAll("\u06d6", " \u06d6 ").replaceAll("\u06d7", " \u06d7 ").replaceAll("\u0615", "  \u0615 ").replaceAll("\u06e5", " \u06e5 ").replaceAll("\u06d8", " \u06d8 ").replaceAll("\u0617", " \u0617 ").replaceAll("\u0616", " \u0616 ").replaceAll("\u0604", " \u0604 ").replaceAll("\u06e9", BuildConfig.VERSION_NAME);
    }

    private void m2928a(int i) {
        C0883a c0883a = (C0883a) this.f1490a.getItem(i);
        C0884b a = this.f1491b.f1453e.m3073a(c0883a.f1702a);
        int a2 = this.f1491b.f1453e.m3071a(2, c0883a.f1702a, c0883a.f1703b);
        if (this.f1492c == 1 && ((a.f1704a == 17 || a.f1704a == 21 || a.f1704a == 23 || a.f1704a == 46 || a.f1704a == 58 || a.f1704a == 67 || a.f1704a == 78) && i == 0)) {
            a2++;
        }
        if (this.f1492c == 2) {
            CharSequence charSequence = BuildConfig.VERSION_NAME + a.f1704a + ". " + App.m2863a(a.f1704a);
        } else {
            Object obj = "Juz " + a2;
        }
        TextView textView = (TextView) getActivity().findViewById(C0861R.id.titleBar);
        if (textView != null) {
            textView.setMinEms(charSequence.length());
            textView.setText(charSequence);
        }
    }

    private void m2932a(C0883a c0883a) {
        CharSequence g = m2960g(c0883a);
        if (VERSION.SDK_INT >= 11) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label", g));
        } else {
            ((android.text.ClipboardManager) getActivity().getSystemService("clipboard")).setText(g);
        }
        App.m2871b(getString(C0861R.string.msg_copied, this.f1491b.m2903a(c0883a)));
    }

    private void m2933a(C0883a c0883a, C0876a c0876a) {
        c0876a.m3044a(new C0877b(c0883a.f1702a, c0883a.f1703b, this.f1492c));
        this.f1491b.f1452d.m3057a(getActivity());
        App.m2871b(getString(C0861R.string.msg_added_to_bookmark, this.f1491b.m2903a(c0883a), c0876a.m3042a()));
    }

    private String m2937b(int i) {
        StringBuffer stringBuffer = new StringBuffer(Integer.toString(i));
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            char charAt = stringBuffer.charAt(i2);
            switch (this.f1491b.f1450b.f1670i) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    charAt = (char) (charAt + 1728);
                    break;
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    charAt = (char) (charAt + 1584);
                    break;
                default:
                    break;
            }
            stringBuffer.setCharAt(i2, charAt);
        }
        if (this.f1491b.f1450b.f1670i == 0) {
            stringBuffer.reverse();
        }
        return stringBuffer.toString();
    }

    private String m2940b(String str) {
        return (this.f1491b.f1450b.f1670i == 0 ? str.replaceAll("\u0650\u06e6", "\u0656").replaceAll("\u0650\u0640\u06e6", "\u0656\u0640").replaceAll("\u0650\u0640\u0640\u06e6", "\u0656\u0640\u0640").replaceAll("\u0650\u06e7", "\u0656").replaceAll("\u0650\u0640\u06e7", "\u0656\u0640").replaceAll("\u0650\u0640\u0640\u06e7", "\u0656\u0640\u0640").replaceAll("\u0649\u0652", "\u064a\u0652").replaceAll("\u0649\u0651", "\u064a\u0651").replaceAll("\u0649\u0650", "\u064a\u0650").replaceAll("\u0649\u064f", "\u064a\u064f").replaceAll("\u0649\u064e", "\u064a\u064e").replaceAll("\u0649\u064d", "\u064a\u064d").replaceAll("\u0649\u064c", "\u064a\u064c").replaceAll("\u0649\u064b", "\u064a\u064b").replaceAll("\u0649\u0656", "\u064a\u0656").replaceAll("\u0649\u0670", "\u064a\u0670").replaceAll("\u064f\u06e5", "\u0657").replaceAll("\u0644\u0644\u0651\u064e\u0647", "\u0644\u0644\u0651\u0670\u0647").replaceAll("\u0644\u0650\u0644\u0651\u064e\u0647", "\u0644\u0650\u0644\u0651\u0670\u0647").replaceAll("\u0644\u064e\u0644\u0651\u064e\u0647", "\u0644\u064e\u0644\u0651\u0670\u0647").replaceAll("\u0644\u064f\u0644\u0651\u064e\u0647", "\u0644\u064f\u0644\u0651\u0670\u0647").replaceAll("\u0644\u0651\u0650\u0644\u0651\u064e\u0647", "\u0644\u0651\u0650\u0644\u0651\u0670\u0647").replaceAll("\u0644\u0651\u064e\u0640\u0670\u0653\u0640\u0640\u0654\u0650\u0649", "\u0644\u0651\u0653\u0640\u0670\u0640\u0626\u0650\u0640\u064a\u0652").replaceAll("\u0644\u0651\u0670\u0653\u0640\u0654\u0650\u0649", "\u0644\u0651\u0653\u0640\u0670\u0640\u0626\u0650\u0640\u064a\u0652").replaceAll("\u0627\u0644\u0653\u0631", "\u0627\u0644\u0653\u0631\u0670").replaceAll("\u0627\u0644\u0653\u0645\u0653", "\u0627\u0644\u0653\u0645\u0651\u0653").replaceAll("\u0627\u0644\u0653\u0640\u0645\u0651\u0653\u0631", "\u0627\u0644\u0653\u0640\u0645\u0651\u0653\u0631\u0670").replaceAll("\u064a\u0633\u0653", "\u064a\u0670\u0633\u0653").replaceAll("\u0643\u0653\u0647\u064a\u0639\u0653\u0635\u0653", "\u0643\u0653\u0647\u0670\u064a\u0670\u0640\u0639\u0653\u0640\u0635\u0653").replaceAll("\u062d\u0645\u0653", "\u062d\u0670\u0645\u0653").replaceAll("\u0637\u0633\u0653\u0645\u0653", "\u0637\u0670\u0633\u0653\u0645\u0651\u0653").replaceAll("\u0644([\u064b-\u0657])\u0623\u064e\u0643([\u064b-\u065e])([\u0628-\u064a]|$)", "\u0644$1\u0623\u064e\u2063\u06aa$2$3").replaceAll("\u06e0", "\u06e1") : str.replaceAll("\u0644\u0651\u0670\u0653\u0640\u0654\u0650\u0649", "\u0644\u0651\u064e\u0640\u0670\u0653\u0640\u0640\u0654\u0650\u0649")).replaceAll("([\u0645\u0646])([ \u0627-\u064a]|$)", "$1\u0652$2").replaceAll("\u0640\u0654", "\u0626").replaceAll("\u06ed", BuildConfig.VERSION_NAME);
    }

    private void m2942b(C0883a c0883a) {
        CharSequence string = getString(C0861R.string.msg_share_title, this.f1491b.m2903a(c0883a));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", m2960g(c0883a));
        startActivity(Intent.createChooser(intent, string));
    }

    private boolean m2943b(int i, int i2) {
        return (i == 7 && i2 == 206) || ((i == 13 && i2 == 15) || ((i == 16 && i2 == 49) || ((i == 16 && i2 == 50) || ((i == 17 && i2 == C0861R.styleable.AppCompatTheme_radioButtonStyle) || ((i == 17 && i2 == C0861R.styleable.AppCompatTheme_ratingBarStyle) || ((i == 17 && i2 == C0861R.styleable.AppCompatTheme_ratingBarStyleIndicator) || ((i == 19 && i2 == 58) || ((i == 22 && i2 == 18) || ((i == 22 && i2 == 77) || ((i == 25 && i2 == 60) || ((i == 27 && i2 == 24) || ((i == 27 && i2 == 25) || ((i == 27 && i2 == 26) || ((i == 32 && i2 == 15) || ((i == 38 && i2 == 24) || ((i == 41 && i2 == 37) || ((i == 41 && i2 == 38) || ((i == 53 && i2 == 59) || ((i == 53 && i2 == 60) || ((i == 53 && i2 == 62) || ((i == 84 && i2 == 20) || ((i == 84 && i2 == 21) || (i == 96 && i2 == 19)))))))))))))))))))))));
    }

    private String m2946c(String str) {
        return str.replaceAll("\\$", "aa").replaceAll("\\[", "aaa").replaceAll("\\%", "ii").replaceAll("\\*", "iii").replaceAll("\\^", "uu").replaceAll("\\(", "uuu").replaceAll("K", "kh").replaceAll("khaaa", "khooo").replaceAll("khaa", "khoo").replaceAll("kha", "kho").replaceAll("raaa", "rooo").replaceAll("raa", "roo").replaceAll("ra", "ro").replaceAll("\\#", "sh").replaceAll("shaaa", "shooo").replaceAll("shaa", "shoo").replaceAll("sha", "sho").replaceAll("D", "dh").replaceAll("dhaaa", "dhooo").replaceAll("dhaa", "dhoo").replaceAll("dha", "dho").replaceAll("T", "th").replaceAll("thaaa", "thooo").replaceAll("thaa", "thoo").replaceAll("tha", "tho").replaceAll("Z", "zh").replaceAll("zhaaa", "zhooo").replaceAll("zhaa", "zhoo").replaceAll("zha", "zho").replaceAll("G", "gh").replaceAll("ghaaa", "ghooo").replaceAll("ghaa", "ghoo").replaceAll("gha", "gho").replaceAll("qaaa", "qooo").replaceAll("qaa", "qoo").replaceAll("qa", "qo").replaceAll("allaah", "alloh").replaceAll("ullaah", "ulloh");
    }

    private void m2948c(C0883a c0883a) {
        if (c0883a.f1703b > 0) {
            int i = C0861R.drawable.ic_folder_bookmark;
            int i2 = C0861R.drawable.ic_black_action_add_to_bookmark;
            if (this.f1491b.f1450b.f1676o == 2) {
                i = C0861R.drawable.ic_white_folder_bookmark;
                i2 = C0861R.drawable.ic_white_add_to_bookmark;
            }
            String[] strArr = new String[(this.f1491b.f1452d.m3054a() + 1)];
            Integer[] numArr = new Integer[(this.f1491b.f1452d.m3054a() + 1)];
            for (int i3 = 0; i3 < this.f1491b.f1452d.m3054a(); i3++) {
                strArr[i3] = this.f1491b.f1452d.m3055a(i3).m3042a();
                numArr[i3] = Integer.valueOf(i);
            }
            strArr[strArr.length - 1] = getString(C0861R.string.create_new);
            numArr[numArr.length - 1] = Integer.valueOf(i2);
            new Builder(getActivity()).setTitle((int) C0861R.string.select_folder).setAdapter(new C0862a(getActivity(), strArr, numArr), new C08324(this, c0883a)).show();
        }
    }

    private String m2950d(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        str = str.trim();
        String substring = str.substring(str.length() - 1, str.length());
        return (substring.equals("\u06d9") || substring.equals("\u06da") || substring.equals("\u061e") || substring.equals("\u06db") || substring.equals("\u06d9") || substring.equals("\u06e5") || substring.equals("\u06d6") || substring.equals("\u06d7") || substring.equals("\u0615") || substring.equals("\u06d8") || substring.equals("\u0617") || substring.equals("\u0616") || substring.equals("\u06e8") || substring.equals("\u06dc") || substring.equals("\u0604") || substring.equals("\u06e9")) ? str.substring(0, str.length() - 1) : str;
    }

    private void m2952d(C0883a c0883a) {
        if (c0883a.f1703b > 0) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            int a = App.m2858a(defaultSharedPreferences, "lastReadSura", 1);
            int a2 = App.m2858a(defaultSharedPreferences, "lastReadAya", 1);
            String a3 = this.f1491b.m2903a(c0883a);
            String str = "QS. " + App.m2863a(a) + ": " + getString(C0861R.string.ayat_name) + " " + a2;
            OnClickListener c08335 = new C08335(this, defaultSharedPreferences, c0883a, a3);
            int i = C0861R.drawable.ic_black_action_set_last_read;
            if (this.f1491b.f1450b.f1676o == 2) {
                i = C0861R.drawable.ic_white_mark_last_read;
            }
            new Builder(getActivity()).setCancelable(true).setIcon(i).setTitle((int) C0861R.string.action_set_last_read).setMessage(getString(C0861R.string.msg_last_read_desc, str, a3)).setPositiveButton((int) C0861R.string.ok, c08335).setNegativeButton((int) C0861R.string.cancel, null).show();
        }
    }

    @SuppressLint({"InflateParams"})
    private void m2955e(C0883a c0883a) {
        View inflate = getActivity().getLayoutInflater().inflate(C0861R.layout.folder_editor, null);
        new Builder(getActivity()).setCancelable(true).setTitle((int) C0861R.string.create_folder_title).setView(inflate).setPositiveButton((int) C0861R.string.create_add, new C08346(this, (TextView) inflate.findViewById(C0861R.id.folder_name), c0883a)).setNegativeButton((int) C0861R.string.cancel, null).show();
    }

    private void m2958f(C0883a c0883a) {
        if (MurattalService.f1949b) {
            ((ActivityQuran) getActivity()).m2781h();
        }
        Editor edit = this.f1495f.edit();
        edit.putInt("pageSelected", this.f1492c);
        edit.putInt("suraSelected", c0883a.f1702a);
        edit.putInt("ayaSelected", c0883a.f1703b);
        edit.apply();
        ((ActivityQuran) getActivity()).m2779f();
    }

    private String m2960g(C0883a c0883a) {
        String d = m2950d(this.f1491b.f1450b.f1670i == 0 ? m2927a(this.f1491b.f1454f.m3077a(c0883a.f1702a, c0883a.f1703b)) : m2927a(this.f1491b.f1455g.m3077a(c0883a.f1702a, c0883a.f1703b)));
        return getString(C0861R.string.msg_share_say) + "\n\n" + d + "\n\"" + (this.f1491b.f1450b.f1674m == 1 ? this.f1491b.f1456h.m3077a(c0883a.f1702a, c0883a.f1703b) : this.f1491b.f1457i.m3077a(c0883a.f1702a, c0883a.f1703b)).trim() + "\"" + "\n" + ("(" + this.f1491b.m2903a(c0883a) + ")") + "\n\n" + getString(C0861R.string.msg_copy_share_appendlink);
    }

    public void m2963a() {
        this.f1490a.notifyDataSetChanged();
    }

    public C0883a m2964b() {
        C0883a c0883a = (C0883a) this.f1490a.getItem(getListView().getFirstVisiblePosition());
        if (c0883a.f1703b == 0) {
            c0883a.f1703b = 1;
        }
        return c0883a;
    }

    @SuppressLint({"InlinedApi"})
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1491b = (App) getActivity().getApplication();
        this.f1496g = Typeface.createFromAsset(getActivity().getAssets(), "font-mobile-ok.ttf");
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en")) {
            this.f1497h = Typeface.createFromAsset(getActivity().getAssets(), "font-mobile-ok-english.ttf");
        }
        if (BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu")) {
            this.f1497h = Typeface.createFromAsset(getActivity().getAssets(), "font-mobile-ok-english.ttf");
            this.f1498i = Typeface.createFromAsset(getActivity().getAssets(), "urdu.ttf");
        }
        this.f1499j = Typeface.createFromAsset(getActivity().getAssets(), "Fontin-Regular.ttf");
        Bundle arguments = getArguments();
        this.f1492c = arguments.getInt("PAGING");
        this.f1495f = getActivity().getSharedPreferences("murattal_audio_by_andi", 0);
        int i = arguments.getInt("SURA");
        int i2 = arguments.getInt("AYA");
        boolean z = arguments.getBoolean("OPENFROMJUZ", false);
        int a = this.f1491b.f1453e.m3071a(this.f1492c, i, i2);
        this.f1493d = this.f1491b.f1453e.m3072a(this.f1492c, a);
        this.f1494e = this.f1491b.f1453e.m3075b(this.f1492c, a);
        setListAdapter(this.f1490a);
        getListView().setOnScrollListener(this.f1500k);
        getListView().setFastScrollEnabled(true);
        getListView().setOnItemLongClickListener(this.f1501l);
        getListView().setSelection(m2924a(i, i2));
        if (z) {
            getListView().setSelectionAfterHeaderView();
        }
        if (VERSION.SDK_INT >= 11) {
            getListView().setVerticalScrollbarPosition(1);
        }
        setHasOptionsMenu(true);
        if (this.f1491b.f1450b.f1676o == 1) {
            getListView().setDivider(new ColorDrawable(App.m2867b(getContext(), (int) C0861R.color.bgkatademikata)));
        } else {
            getListView().setDivider(new ColorDrawable(App.m2867b(getContext(), (int) C0861R.color.darkBgDivider)));
        }
        getListView().setDividerHeight(1);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        if (this.f1491b.f1450b.f1677p != 2) {
            C0883a c0883a = (C0883a) listView.getItemAtPosition(i);
            if (c0883a.f1703b > 0) {
                String[] strArr = new String[]{getString(C0861R.string.action_play_murattal), getString(C0861R.string.action_copy), getString(C0861R.string.action_share), getString(C0861R.string.action_add_to_bookmark), getString(C0861R.string.action_set_last_read)};
                Integer[] numArr = new Integer[]{Integer.valueOf(C0861R.drawable.ic_black_action_play_murattal), Integer.valueOf(C0861R.drawable.ic_black_action_copy), Integer.valueOf(C0861R.drawable.ic_black_action_share), Integer.valueOf(C0861R.drawable.ic_black_action_add_to_bookmark), Integer.valueOf(C0861R.drawable.ic_black_action_set_last_read)};
                if (this.f1491b.f1450b.f1676o == 2) {
                    numArr = new Integer[]{Integer.valueOf(C0861R.drawable.ic_action_play), Integer.valueOf(C0861R.drawable.ic_white_copy), Integer.valueOf(C0861R.drawable.ic_white_share), Integer.valueOf(C0861R.drawable.ic_white_add_to_bookmark), Integer.valueOf(C0861R.drawable.ic_white_mark_last_read)};
                }
                new Builder(getActivity()).setTitle(this.f1491b.m2903a(c0883a)).setAdapter(new C0862a(getActivity(), strArr, numArr), new C08292(this, c0883a)).show();
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.f1490a.notifyDataSetChanged();
    }
}
