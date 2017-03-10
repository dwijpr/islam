package com.andi.alquran.p024a;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p028g.p029a.C0910d;
import com.andi.alquran.p028g.p029a.C0911a;
import com.andi.alquran.p028g.p029a.C0912b;
import com.andi.alquran.p028g.p029a.C0914e;
import com.andi.alquran.p032j.C0939a;
import com.andi.alquran.services.MultiDownloadService;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.andi.alquran.a.b */
public class C0865b extends ArrayAdapter<C0912b> {
    private LayoutInflater f1597a;
    private Context f1598b;
    private ArrayList<C0912b> f1599c;
    private long f1600d;

    /* renamed from: com.andi.alquran.a.b.a */
    private static class C0864a {
        private ImageView f1591a;
        private TextView f1592b;
        private TextView f1593c;
        private TextView f1594d;
        private ProgressBar f1595e;
        private CheckBox f1596f;

        private C0864a() {
        }
    }

    public C0865b(Context context, ArrayList<C0912b> arrayList) {
        super(context, 0, arrayList);
        this.f1600d = 0;
        this.f1599c = arrayList;
        this.f1597a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f1598b = context;
    }

    public ArrayList<C0912b> m3014a() {
        return this.f1599c;
    }

    public void m3015a(int i) {
        C0912b c0912b = (C0912b) this.f1599c.get(i);
        if (c0912b.m3170a()) {
            if (c0912b.m3182j() && !new File(App.m2887l() + App.m2870b(c0912b.m3174c(), 1)).exists()) {
                MultiDownloadService.m3330b(this.f1598b, C0914e.m3186a(c0912b.m3176d(), c0912b.m3171b(), c0912b.m3179g(), true));
                App.m2871b(this.f1598b.getString(C0861R.string.msg_download_exception_cancel, new Object[]{((C0912b) getItem(i)).m3171b()}));
            }
            c0912b.m3169a(false);
        } else {
            c0912b.m3169a(true);
        }
        notifyDataSetChanged();
    }

    public void m3016a(C0911a c0911a) {
        for (int i = 0; i < getCount(); i++) {
            if (((C0912b) getItem(i)).m3176d().equals(c0911a.m3157f())) {
                ((C0912b) getItem(i)).m3166a(c0911a.m3160a().intValue());
                ((C0912b) getItem(i)).m3167a(c0911a.m3162b());
                ((C0912b) getItem(i)).m3172b(c0911a.m3163c());
                ((C0912b) getItem(i)).m3175c(true);
                ((C0912b) getItem(i)).m3169a(true);
                if (c0911a.m3160a().intValue() >= 100) {
                    notifyDataSetChanged();
                }
                if (System.currentTimeMillis() - this.f1600d > 1000) {
                    this.f1600d = System.currentTimeMillis();
                    notifyDataSetChanged();
                }
            }
        }
        if (System.currentTimeMillis() - this.f1600d > 1000) {
            this.f1600d = System.currentTimeMillis();
            notifyDataSetChanged();
        }
    }

    public void m3017a(C0910d c0910d) {
        for (int i = 0; i < getCount(); i++) {
            if (((C0912b) getItem(i)).m3176d().equals(c0910d.m3157f())) {
                ((C0912b) getItem(i)).m3175c(false);
                ((C0912b) getItem(i)).m3169a(false);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void m3018b(int i) {
        ((C0912b) this.f1599c.get(i)).m3169a(true);
        notifyDataSetChanged();
    }

    public void m3019b(C0910d c0910d) {
        for (int i = 0; i < getCount(); i++) {
            if (((C0912b) getItem(i)).m3176d().equals(c0910d.m3157f())) {
                ((C0912b) getItem(i)).m3175c(false);
                ((C0912b) getItem(i)).m3173b(true);
                ((C0912b) getItem(i)).m3169a(false);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void m3020c(int i) {
        C0912b c0912b = (C0912b) this.f1599c.get(i);
        if (c0912b.m3182j() && !new File(App.m2887l() + App.m2870b(c0912b.m3174c(), 1)).exists()) {
            MultiDownloadService.m3330b(this.f1598b, C0914e.m3186a(c0912b.m3176d(), c0912b.m3171b(), c0912b.m3179g(), true));
        }
        c0912b.m3169a(false);
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0864a c0864a;
        C0912b c0912b = (C0912b) getItem(i);
        if (view == null) {
            C0864a c0864a2 = new C0864a();
            view = this.f1597a.inflate(C0861R.layout.row_audio_manager, viewGroup, false);
            c0864a2.f1591a = (ImageView) view.findViewById(C0861R.id.imageIcon);
            c0864a2.f1592b = (TextView) view.findViewById(C0861R.id.suraNameAudio);
            c0864a2.f1593c = (TextView) view.findViewById(C0861R.id.percentProgress);
            c0864a2.f1595e = (ProgressBar) view.findViewById(C0861R.id.progressDownload);
            c0864a2.f1594d = (TextView) view.findViewById(C0861R.id.infoStatus);
            c0864a2.f1596f = (CheckBox) view.findViewById(C0861R.id.checkAUdio);
            view.setTag(c0864a2);
            c0864a = c0864a2;
        } else {
            c0864a = (C0864a) view.getTag();
        }
        c0864a.f1596f.setVisibility(0);
        if (c0912b.m3170a()) {
            c0864a.f1596f.setChecked(true);
        } else {
            c0864a.f1596f.setChecked(false);
        }
        CharSequence string = this.f1598b.getString(C0861R.string.msg_download_multi_row_not_downloaded);
        if (App.m2874c(c0912b.m3174c())) {
            c0864a.f1591a.setImageResource(C0861R.drawable.ic_black_action_murattal_exist);
            c0864a.f1591a.setColorFilter(App.m2867b(this.f1598b, (int) C0861R.color.bgHeader), Mode.SRC_ATOP);
            string = this.f1598b.getString(C0861R.string.msg_download_multi_row_is_completed);
        } else {
            c0864a.f1591a.setImageResource(C0861R.drawable.ic_black_action_download);
            if (new File(c0912b.m3180h()).exists()) {
                string = this.f1598b.getString(C0861R.string.msg_download_multi_row_not_completed);
                c0864a.f1591a.setColorFilter(App.m2867b(this.f1598b, (int) C0861R.color.kuningNotComplete), Mode.SRC_ATOP);
            } else {
                c0864a.f1591a.setColorFilter(App.m2867b(this.f1598b, (int) C0861R.color.hitamnoterang), Mode.SRC_ATOP);
            }
        }
        c0864a.f1592b.setText(c0912b.m3171b());
        c0864a.f1593c.setText(this.f1598b.getString(C0861R.string.msg_download_multi_row_percent_progress, new Object[]{Integer.valueOf(c0912b.m3177e())}));
        if (c0912b.m3182j()) {
            c0912b.m3169a(true);
            c0864a.f1591a.setColorFilter(App.m2867b(this.f1598b, (int) C0861R.color.kuningNotComplete), Mode.SRC_ATOP);
            c0864a.f1595e.setVisibility(0);
            if (c0912b.m3177e() >= 100) {
                string = this.f1598b.getString(C0861R.string.msg_download_multi_row_status_extracting);
                c0864a.f1595e.setIndeterminate(true);
                c0912b.m3169a(false);
                c0864a.f1596f.setChecked(false);
                c0864a.f1596f.setVisibility(4);
            } else {
                c0864a.f1595e.setIndeterminate(false);
                string = this.f1598b.getString(C0861R.string.msg_download_multi_row_status_progress, new Object[]{C0939a.m3271a(c0912b.m3177e(), c0912b.m3178f())});
            }
            if (c0912b.m3177e() <= 0) {
                string = this.f1598b.getString(C0861R.string.msg_download_multi_row_status_waiting);
                c0864a.f1595e.setIndeterminate(true);
            }
            c0864a.f1595e.setProgress(c0912b.m3177e());
            c0864a.f1593c.setVisibility(0);
        } else {
            c0864a.f1595e.setVisibility(8);
            c0864a.f1593c.setVisibility(8);
        }
        if (c0912b.m3181i()) {
            c0864a.f1595e.setIndeterminate(false);
        }
        c0864a.f1594d.setText(string);
        return view;
    }
}
