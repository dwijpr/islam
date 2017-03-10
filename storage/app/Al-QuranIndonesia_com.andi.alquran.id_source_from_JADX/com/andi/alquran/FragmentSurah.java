package com.andi.alquran;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.andi.alquran.p026c.C0885a.C0884b;
import com.andi.alquran.services.MurattalService;

public class FragmentSurah extends ListFragment {
    private App f1588a;
    private SuraAdapter f1589b;

    class SuraAdapter extends BaseAdapter {
        final /* synthetic */ FragmentSurah f1582a;

        /* renamed from: com.andi.alquran.FragmentSurah.SuraAdapter.1 */
        class C08601 implements OnClickListener {
            final /* synthetic */ int f1579a;
            final /* synthetic */ boolean f1580b;
            final /* synthetic */ SuraAdapter f1581c;

            C08601(SuraAdapter suraAdapter, int i, boolean z) {
                this.f1581c = suraAdapter;
                this.f1579a = i;
                this.f1580b = z;
            }

            public void onClick(View view) {
                if (MurattalService.f1949b) {
                    MurattalService.m3349c();
                    this.f1581c.f1582a.getActivity().stopService(new Intent(this.f1581c.f1582a.getActivity(), MurattalService.class));
                }
                Editor edit = this.f1581c.f1582a.getActivity().getSharedPreferences("murattal_audio_by_andi", 0).edit();
                edit.putInt("pageSelected", 1);
                edit.putInt("suraSelected", this.f1579a + 1);
                edit.putInt("ayaSelected", 1);
                edit.apply();
                if (this.f1580b) {
                    Intent intent = new Intent(this.f1581c.f1582a.getActivity(), ActivityQuran.class);
                    intent.putExtra("PAGING", 1);
                    intent.putExtra("SURA", this.f1579a + 1);
                    intent.putExtra("AYA", 1);
                    intent.putExtra("SURA_ACTION", 1);
                    intent.putExtra("OPENFROMJUZ", false);
                    this.f1581c.f1582a.startActivity(intent);
                    return;
                }
                intent = new Intent(this.f1581c.f1582a.getActivity(), ActivityQuran.class);
                intent.putExtra("PAGING", 1);
                intent.putExtra("SURA", this.f1579a + 1);
                intent.putExtra("AYA", 1);
                intent.putExtra("SURA_ACTION", 2);
                intent.putExtra("OPENFROMJUZ", false);
                this.f1581c.f1582a.startActivity(intent);
            }
        }

        SuraAdapter(FragmentSurah fragmentSurah) {
            this.f1582a = fragmentSurah;
        }

        public int getCount() {
            return this.f1582a.f1588a.f1453e.m3070a();
        }

        public Object getItem(int i) {
            return this.f1582a.f1588a.f1453e.m3073a(i + 1);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            SuraRowHolder suraRowHolder;
            boolean z;
            if (view == null) {
                View inflate = this.f1582a.f1588a.f1450b.f1676o == 1 ? this.f1582a.getActivity().getLayoutInflater().inflate(C0861R.layout.root_sura_row, viewGroup, false) : this.f1582a.getActivity().getLayoutInflater().inflate(C0861R.layout.dark_root_sura_row, viewGroup, false);
                SuraRowHolder suraRowHolder2 = new SuraRowHolder();
                suraRowHolder2.f1583a = (TextView) inflate.findViewById(C0861R.id.sura_number);
                suraRowHolder2.f1584b = (TextView) inflate.findViewById(C0861R.id.sura_name);
                suraRowHolder2.f1585c = (TextView) inflate.findViewById(C0861R.id.sura_type_count_ayas);
                suraRowHolder2.f1586d = (ImageView) inflate.findViewById(C0861R.id.sura_img);
                suraRowHolder2.f1587e = (ImageButton) inflate.findViewById(C0861R.id.sura_action);
                inflate.setTag(suraRowHolder2);
                view = inflate;
                suraRowHolder = suraRowHolder2;
            } else {
                suraRowHolder = (SuraRowHolder) view.getTag();
            }
            C0884b c0884b = (C0884b) getItem(i);
            suraRowHolder.f1583a.setText(BuildConfig.VERSION_NAME + c0884b.f1704a + BuildConfig.VERSION_NAME);
            suraRowHolder.f1584b.setText(App.m2863a(c0884b.f1704a));
            suraRowHolder.f1585c.setText(App.m2864a(c0884b.f1712i, c0884b.f1706c));
            suraRowHolder.f1586d.setImageResource(c0884b.f1713j);
            if (App.m2874c(i + 1)) {
                suraRowHolder.f1587e.setImageResource(C0861R.drawable.ic_black_action_murattal_exist);
                z = true;
            } else {
                suraRowHolder.f1587e.setImageResource(C0861R.drawable.ic_black_action_download);
                z = false;
            }
            if (this.f1582a.f1588a.f1450b.f1676o == 1) {
                suraRowHolder.f1587e.setColorFilter(App.m2867b(this.f1582a.getActivity(), (int) C0861R.color.hitamnoterang), Mode.SRC_ATOP);
            } else {
                suraRowHolder.f1587e.setColorFilter(App.m2867b(this.f1582a.getActivity(), (int) C0861R.color.darkColorIcon), Mode.SRC_ATOP);
                suraRowHolder.f1586d.setColorFilter(App.m2867b(this.f1582a.getActivity(), (int) C0861R.color.bgListAlternate), Mode.SRC_ATOP);
            }
            suraRowHolder.f1587e.setOnClickListener(new C08601(this, i, z));
            return view;
        }
    }

    private static class SuraRowHolder {
        TextView f1583a;
        TextView f1584b;
        TextView f1585c;
        ImageView f1586d;
        ImageButton f1587e;

        private SuraRowHolder() {
        }
    }

    @SuppressLint({"InlinedApi"})
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1588a = (App) getActivity().getApplication();
        this.f1589b = new SuraAdapter(this);
        setListAdapter(this.f1589b);
        getListView().setFastScrollEnabled(true);
        if (VERSION.SDK_INT >= 11) {
            getListView().setVerticalScrollbarPosition(1);
        }
        if (this.f1588a.f1450b.f1676o == 1) {
            getListView().setDivider(new ColorDrawable(App.m2867b(getContext(), (int) C0861R.color.bgkatademikata)));
        } else {
            getListView().setDivider(new ColorDrawable(App.m2867b(getContext(), (int) C0861R.color.darkBgDivider)));
        }
        getListView().setDividerHeight(1);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Intent intent = new Intent(getActivity(), ActivityQuran.class);
        intent.putExtra("PAGING", 1);
        intent.putExtra("SURA", i + 1);
        intent.putExtra("AYA", 1);
        intent.putExtra("OPENFROMJUZ", false);
        startActivity(intent);
    }

    public void onResume() {
        super.onResume();
        this.f1589b.notifyDataSetChanged();
    }
}
