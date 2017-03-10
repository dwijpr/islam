package com.andi.alquran;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.andi.alquran.p026c.C0885a.C0883a;
import com.andi.alquran.p026c.C0885a.C0884b;

public class FragmentJuz extends ListFragment {
    private App f1532a;

    class JuzAdapter extends BaseAdapter {
        final /* synthetic */ FragmentJuz f1528a;

        JuzAdapter(FragmentJuz fragmentJuz) {
            this.f1528a = fragmentJuz;
        }

        public int getCount() {
            return this.f1528a.f1532a.f1453e.m3074b(2);
        }

        public Object getItem(int i) {
            return this.f1528a.f1532a.f1453e.m3072a(2, i + 1);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            JuzRowHolder juzRowHolder;
            if (view == null) {
                View inflate = this.f1528a.f1532a.f1450b.f1676o == 1 ? this.f1528a.getActivity().getLayoutInflater().inflate(C0861R.layout.root_juz_row, viewGroup, false) : this.f1528a.getActivity().getLayoutInflater().inflate(C0861R.layout.dark_root_juz_row, viewGroup, false);
                JuzRowHolder juzRowHolder2 = new JuzRowHolder();
                juzRowHolder2.f1529a = (TextView) inflate.findViewById(C0861R.id.juz_number);
                juzRowHolder2.f1530b = (TextView) inflate.findViewById(C0861R.id.juz_name);
                juzRowHolder2.f1531c = (TextView) inflate.findViewById(C0861R.id.sura_name_and_aya);
                inflate.setTag(juzRowHolder2);
                view = inflate;
                juzRowHolder = juzRowHolder2;
            } else {
                juzRowHolder = (JuzRowHolder) view.getTag();
            }
            C0884b a = this.f1528a.f1532a.f1453e.m3073a(((C0883a) getItem(i)).f1702a);
            juzRowHolder.f1529a.setText(BuildConfig.VERSION_NAME + (i + 1));
            juzRowHolder.f1530b.setText("Juz " + (i + 1));
            juzRowHolder.f1531c.setText(this.f1528a.getString(C0861R.string.juz_start_from_sura, App.m2863a(a.f1704a), BuildConfig.VERSION_NAME + r0.f1703b));
            return view;
        }
    }

    private static class JuzRowHolder {
        public TextView f1529a;
        public TextView f1530b;
        public TextView f1531c;

        private JuzRowHolder() {
        }
    }

    @SuppressLint({"InlinedApi"})
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1532a = (App) getActivity().getApplication();
        setListAdapter(new JuzAdapter(this));
        getListView().setFastScrollEnabled(true);
        if (VERSION.SDK_INT >= 11) {
            getListView().setVerticalScrollbarPosition(1);
        }
        if (this.f1532a.f1450b.f1676o == 1) {
            getListView().setDivider(new ColorDrawable(App.m2867b(getContext(), (int) C0861R.color.bgkatademikata)));
        } else {
            getListView().setDivider(new ColorDrawable(App.m2867b(getContext(), (int) C0861R.color.darkBgDivider)));
        }
        getListView().setDividerHeight(1);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        Intent intent = new Intent(getActivity(), ActivityQuran.class);
        C0883a a = this.f1532a.f1453e.m3072a(2, i + 1);
        intent.putExtra("PAGING", 2);
        intent.putExtra("SURA", a.f1702a);
        intent.putExtra("AYA", a.f1703b);
        intent.putExtra("OPENFROMJUZ", true);
        startActivity(intent);
    }
}
