package com.andi.alquran;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.andi.alquran.p024a.C0862a;
import com.andi.alquran.p025b.C0878a.C0876a;
import com.andi.alquran.p025b.C0878a.C0877b;
import com.andi.alquran.p026c.C0885a.C0884b;
import java.util.Date;

public class FragmentBookmark extends ListFragment {
    private App f1525a;
    private BookmarkAdapter f1526b;
    private final OnItemLongClickListener f1527c;

    /* renamed from: com.andi.alquran.FragmentBookmark.1 */
    class C08351 implements OnClickListener {
        final /* synthetic */ int f1502a;
        final /* synthetic */ int f1503b;
        final /* synthetic */ FragmentBookmark f1504c;

        C08351(FragmentBookmark fragmentBookmark, int i, int i2) {
            this.f1504c = fragmentBookmark;
            this.f1502a = i;
            this.f1503b = i2;
        }

        public void onClick(View view) {
            this.f1504c.m2967a(this.f1502a, this.f1503b);
        }
    }

    /* renamed from: com.andi.alquran.FragmentBookmark.2 */
    class C08362 implements DialogInterface.OnClickListener {
        final /* synthetic */ TextView f1505a;
        final /* synthetic */ C0876a f1506b;
        final /* synthetic */ FragmentBookmark f1507c;

        C08362(FragmentBookmark fragmentBookmark, TextView textView, C0876a c0876a) {
            this.f1507c = fragmentBookmark;
            this.f1505a = textView;
            this.f1506b = c0876a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f1505a.getText().length() > 0) {
                this.f1506b.m3045a(this.f1505a.getText().toString());
                this.f1506b.m3043a(1);
                this.f1507c.f1525a.f1452d.m3057a(this.f1507c.getActivity());
                this.f1507c.f1526b.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.andi.alquran.FragmentBookmark.3 */
    class C08373 implements OnItemLongClickListener {
        final /* synthetic */ FragmentBookmark f1508a;

        C08373(FragmentBookmark fragmentBookmark) {
            this.f1508a = fragmentBookmark;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object itemAtPosition = adapterView.getItemAtPosition(i);
            if (itemAtPosition instanceof C0876a) {
                this.f1508a.m2974b((C0876a) itemAtPosition);
            } else {
                this.f1508a.m2972a((C0877b) itemAtPosition);
            }
            return true;
        }
    }

    /* renamed from: com.andi.alquran.FragmentBookmark.4 */
    class C08384 implements DialogInterface.OnClickListener {
        final /* synthetic */ C0876a f1509a;
        final /* synthetic */ C0877b f1510b;
        final /* synthetic */ FragmentBookmark f1511c;

        C08384(FragmentBookmark fragmentBookmark, C0876a c0876a, C0877b c0877b) {
            this.f1511c = fragmentBookmark;
            this.f1509a = c0876a;
            this.f1510b = c0877b;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1509a.m3048b(this.f1510b);
            this.f1511c.f1525a.f1452d.m3057a(this.f1511c.getActivity());
            this.f1511c.f1526b.notifyDataSetChanged();
        }
    }

    /* renamed from: com.andi.alquran.FragmentBookmark.5 */
    class C08395 implements DialogInterface.OnClickListener {
        final /* synthetic */ C0876a f1512a;
        final /* synthetic */ FragmentBookmark f1513b;

        C08395(FragmentBookmark fragmentBookmark, C0876a c0876a) {
            this.f1513b = fragmentBookmark;
            this.f1512a = c0876a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1513b.f1525a.f1452d.m3060b(this.f1512a);
            this.f1513b.f1525a.f1452d.m3057a(this.f1513b.getActivity());
            this.f1513b.f1526b.notifyDataSetChanged();
        }
    }

    /* renamed from: com.andi.alquran.FragmentBookmark.6 */
    class C08406 implements OnClickListener {
        final /* synthetic */ int f1514a;
        final /* synthetic */ int f1515b;
        final /* synthetic */ FragmentBookmark f1516c;

        C08406(FragmentBookmark fragmentBookmark, int i, int i2) {
            this.f1516c = fragmentBookmark;
            this.f1514a = i;
            this.f1515b = i2;
        }

        public void onClick(View view) {
            this.f1516c.m2967a(this.f1514a, this.f1515b);
        }
    }

    /* renamed from: com.andi.alquran.FragmentBookmark.7 */
    class C08417 implements DialogInterface.OnClickListener {
        final /* synthetic */ Intent f1517a;
        final /* synthetic */ int f1518b;
        final /* synthetic */ int f1519c;
        final /* synthetic */ FragmentBookmark f1520d;

        C08417(FragmentBookmark fragmentBookmark, Intent intent, int i, int i2) {
            this.f1520d = fragmentBookmark;
            this.f1517a = intent;
            this.f1518b = i;
            this.f1519c = i2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                this.f1517a.putExtra("PAGING", 1);
                this.f1517a.putExtra("SURA", this.f1518b);
                this.f1517a.putExtra("AYA", this.f1519c);
                this.f1517a.putExtra("OPENFROMJUZ", false);
                this.f1520d.startActivity(this.f1517a);
            } else if (i == 1) {
                this.f1517a.putExtra("PAGING", 2);
                this.f1517a.putExtra("SURA", this.f1518b);
                this.f1517a.putExtra("AYA", this.f1519c);
                this.f1517a.putExtra("OPENFROMJUZ", false);
                this.f1520d.startActivity(this.f1517a);
            }
        }
    }

    class BookmarkAdapter extends BaseAdapter {
        final /* synthetic */ FragmentBookmark f1521a;

        BookmarkAdapter(FragmentBookmark fragmentBookmark) {
            this.f1521a = fragmentBookmark;
        }

        public int getCount() {
            int a = this.f1521a.f1525a.f1452d.m3054a();
            for (int i = 0; i < this.f1521a.f1525a.f1452d.m3054a(); i++) {
                a += this.f1521a.f1525a.f1452d.m3055a(i).m3046b();
            }
            return a;
        }

        public Object getItem(int i) {
            int i2 = 0;
            while (i2 < this.f1521a.f1525a.f1452d.m3054a()) {
                if (i <= this.f1521a.f1525a.f1452d.m3055a(i2).m3046b()) {
                    return i == 0 ? this.f1521a.f1525a.f1452d.m3055a(i2) : this.f1521a.f1525a.f1452d.m3055a(i2).m3047b(i - 1);
                } else {
                    i -= this.f1521a.f1525a.f1452d.m3055a(i2).m3046b() + 1;
                    i2++;
                }
            }
            return null;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return getItem(i) instanceof C0876a ? 0 : 1;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            Object item = getItem(i);
            if (item instanceof C0876a) {
                FolderRowHolder folderRowHolder;
                if (view == null) {
                    View inflate = this.f1521a.f1525a.f1450b.f1676o == 1 ? this.f1521a.getActivity().getLayoutInflater().inflate(C0861R.layout.bookmark_folder_row, viewGroup, false) : this.f1521a.getActivity().getLayoutInflater().inflate(C0861R.layout.dark_bookmark_folder_row, viewGroup, false);
                    FolderRowHolder folderRowHolder2 = new FolderRowHolder();
                    folderRowHolder2.f1522a = (TextView) inflate.findViewById(C0861R.id.folder_name);
                    inflate.setTag(folderRowHolder2);
                    view = inflate;
                    folderRowHolder = folderRowHolder2;
                } else {
                    folderRowHolder = (FolderRowHolder) view.getTag();
                }
                folderRowHolder.f1522a.setText(((C0876a) item).m3042a());
                return view;
            }
            ItemRowHolder itemRowHolder;
            if (view == null) {
                inflate = this.f1521a.f1525a.f1450b.f1676o == 1 ? this.f1521a.getActivity().getLayoutInflater().inflate(C0861R.layout.bookmark_item_row, viewGroup, false) : this.f1521a.getActivity().getLayoutInflater().inflate(C0861R.layout.dark_bookmark_item_row, viewGroup, false);
                ItemRowHolder itemRowHolder2 = new ItemRowHolder();
                itemRowHolder2.f1523a = (TextView) inflate.findViewById(C0861R.id.sura_name);
                itemRowHolder2.f1524b = (TextView) inflate.findViewById(C0861R.id.date);
                inflate.setTag(itemRowHolder2);
                itemRowHolder = itemRowHolder2;
            } else {
                itemRowHolder = (ItemRowHolder) view.getTag();
                inflate = view;
            }
            C0877b c0877b = (C0877b) item;
            C0884b a = this.f1521a.f1525a.f1453e.m3073a(c0877b.m3051a());
            Date date = new Date(c0877b.m3053c());
            Date date2 = new Date();
            itemRowHolder.f1523a.setText(App.f1448m.m2902a(a.f1704a, c0877b.m3052b(), App.f1448m.f1453e.m3071a(2, a.f1704a, c0877b.m3052b())));
            if (date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDate() == date2.getDate()) {
                itemRowHolder.f1524b.setText(DateFormat.format("kk:mm", date));
                return inflate;
            }
            itemRowHolder.f1524b.setText(DateFormat.format("dd MMM yyyy kk:mm", date));
            return inflate;
        }

        public int getViewTypeCount() {
            return 2;
        }
    }

    private static class FolderRowHolder {
        public TextView f1522a;

        private FolderRowHolder() {
        }
    }

    private static class ItemRowHolder {
        public TextView f1523a;
        public TextView f1524b;

        private ItemRowHolder() {
        }
    }

    public FragmentBookmark() {
        this.f1527c = new C08373(this);
    }

    private int m2965a(SharedPreferences sharedPreferences, String str, int i) {
        return Integer.parseInt(sharedPreferences.getString(str, Integer.toString(i)));
    }

    private void m2967a(int i, int i2) {
        String[] strArr = new String[]{getString(C0861R.string.open_as_sura), getString(C0861R.string.open_as_juz)};
        int i3 = C0861R.drawable.ic_black_action_view;
        if (this.f1525a.f1450b.f1676o == 2) {
            i3 = C0861R.drawable.ic_white_action_view;
        }
        ListAdapter c0862a = new C0862a(getActivity(), strArr, new Integer[]{Integer.valueOf(i3), Integer.valueOf(i3)});
        Intent intent = new Intent(getActivity(), ActivityQuran.class);
        new Builder(getActivity()).setTitle(this.f1525a.m2902a(i, i2, App.f1448m.f1453e.m3071a(2, i, i2))).setAdapter(c0862a, new C08417(this, intent, i, i2)).show();
    }

    @SuppressLint({"InflateParams"})
    private void m2971a(C0876a c0876a) {
        View inflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(C0861R.layout.folder_editor, null);
        TextView textView = (TextView) inflate.findViewById(C0861R.id.folder_name);
        textView.setText(c0876a.m3042a());
        new Builder(getActivity()).setCancelable(true).setTitle((int) C0861R.string.edit_folder_title).setView(inflate).setPositiveButton((int) C0861R.string.save, new C08362(this, textView, c0876a)).setNegativeButton((int) C0861R.string.cancel, null).show();
    }

    private void m2972a(C0877b c0877b) {
        new Builder(getActivity()).setCancelable(true).setMessage((int) C0861R.string.delete_bookmark_item).setPositiveButton((int) C0861R.string.delete, new C08384(this, this.f1525a.f1452d.m3056a(c0877b), c0877b)).setNegativeButton((int) C0861R.string.cancel, null).show();
    }

    private void m2974b(C0876a c0876a) {
        new Builder(getActivity()).setCancelable(true).setMessage((int) C0861R.string.delete_bookmark_folder).setPositiveButton((int) C0861R.string.delete, new C08395(this, c0876a)).setNegativeButton((int) C0861R.string.cancel, null).show();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1525a = (App) getActivity().getApplication();
        this.f1526b = new BookmarkAdapter(this);
        setListAdapter(this.f1526b);
        getListView().setFastScrollEnabled(true);
        getListView().setOnItemLongClickListener(this.f1527c);
        if (this.f1525a.f1450b.f1676o == 1) {
            getListView().setDivider(new ColorDrawable(App.m2867b(getContext(), (int) C0861R.color.bgkatademikata)));
        } else {
            getListView().setDivider(new ColorDrawable(App.m2867b(getContext(), (int) C0861R.color.darkBgDivider)));
        }
        getListView().setDividerHeight(1);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1525a = (App) getActivity().getApplication();
        View inflate = this.f1525a.f1450b.f1676o == 1 ? layoutInflater.inflate(C0861R.layout.activity_bookmark_list, viewGroup, false) : layoutInflater.inflate(C0861R.layout.dark_activity_bookmark_list, viewGroup, false);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        int a = m2965a(defaultSharedPreferences, "lastReadSura", 1);
        int a2 = m2965a(defaultSharedPreferences, "lastReadAya", 1);
        long j = defaultSharedPreferences.getLong("lastReadDate", 0);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(C0861R.id.lastReadClicked);
        ((TextView) inflate.findViewById(C0861R.id.suraNameLastRead)).setText(App.f1448m.m2902a(a, a2, App.f1448m.f1453e.m3071a(2, a, a2)));
        TextView textView = (TextView) inflate.findViewById(C0861R.id.dateLastRead);
        if (j > 0) {
            Date date = new Date(j);
            Date date2 = new Date();
            if (date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDate() == date2.getDate()) {
                textView.setText(DateFormat.format("kk:mm", date));
            } else {
                textView.setText(DateFormat.format("dd MMM yyyy kk:mm", date));
            }
        } else {
            textView.setText(BuildConfig.VERSION_NAME);
        }
        relativeLayout.setOnClickListener(new C08351(this, a, a2));
        return inflate;
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Object item = getListAdapter().getItem(i);
        if (item instanceof C0877b) {
            C0877b c0877b = (C0877b) item;
            m2967a(c0877b.m3051a(), c0877b.m3052b());
            return;
        }
        m2971a((C0876a) item);
    }

    public void onResume() {
        super.onResume();
        this.f1526b.notifyDataSetChanged();
        View view = getView();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        int a = m2965a(defaultSharedPreferences, "lastReadSura", 1);
        int a2 = m2965a(defaultSharedPreferences, "lastReadAya", 1);
        long j = defaultSharedPreferences.getLong("lastReadDate", 0);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C0861R.id.lastReadClicked);
        ((TextView) view.findViewById(C0861R.id.suraNameLastRead)).setText(App.f1448m.m2902a(a, a2, App.f1448m.f1453e.m3071a(2, a, a2)));
        TextView textView = (TextView) view.findViewById(C0861R.id.dateLastRead);
        if (j > 0) {
            Date date = new Date(j);
            Date date2 = new Date();
            if (date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDate() == date2.getDate()) {
                textView.setText(DateFormat.format("kk:mm", date));
            } else {
                textView.setText(DateFormat.format("dd MMM yyyy kk:mm", date));
            }
        } else {
            textView.setText(BuildConfig.VERSION_NAME);
        }
        relativeLayout.setOnClickListener(new C08406(this, a, a2));
    }
}
