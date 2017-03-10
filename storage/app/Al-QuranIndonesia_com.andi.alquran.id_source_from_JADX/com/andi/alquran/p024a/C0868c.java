package com.andi.alquran.p024a;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p028g.C0915a;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.Calendar;

/* renamed from: com.andi.alquran.a.c */
public class C0868c extends BaseAdapter {
    private Context f1604a;
    private ArrayList<C0915a> f1605b;

    /* renamed from: com.andi.alquran.a.c.a */
    private static class C0867a {
        TextView f1601a;
        TextView f1602b;
        ImageView f1603c;

        private C0867a() {
        }
    }

    public C0868c(Context context, ArrayList<C0915a> arrayList, Calendar calendar) {
        this.f1604a = context;
        this.f1605b = arrayList;
    }

    public int getCount() {
        return this.f1605b.size();
    }

    public Object getItem(int i) {
        return this.f1605b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0867a c0867a;
        boolean z = false;
        if (view == null) {
            c0867a = new C0867a();
            view = ((LayoutInflater) this.f1604a.getSystemService("layout_inflater")).inflate(C0861R.layout.item_prayer, viewGroup, false);
            c0867a.f1601a = (TextView) view.findViewById(C0861R.id.itemPrayerName);
            c0867a.f1603c = (ImageView) view.findViewById(C0861R.id.itemPlayerAlarmIcon);
            c0867a.f1602b = (TextView) view.findViewById(C0861R.id.itemPrayerTime);
            view.setTag(c0867a);
        }
        C0915a c0915a = (C0915a) this.f1605b.get(i);
        c0867a = (C0867a) view.getTag();
        c0867a.f1603c.setImageResource(C0861R.drawable.ic_alarm_off);
        SharedPreferences sharedPreferences = this.f1604a.getSharedPreferences("prayer_time_by_andi", 0);
        int b = App.m2868b(sharedPreferences, "typeTimeFormat", 0);
        switch (c0915a.m3196e()) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                z = sharedPreferences.getInt("typeNotificationImsak", 4);
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                z = sharedPreferences.getInt("typeNotificationSubuh", 4);
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                z = sharedPreferences.getInt("typeNotificationTerbit", 4);
                break;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                z = sharedPreferences.getInt("typeNotificationDzuhur", 4);
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                z = sharedPreferences.getInt("typeNotificationAshar", 4);
                break;
            case C1096c.MapAttrs_liteMode /*6*/:
                z = sharedPreferences.getInt("typeNotificationMaghrib", 4);
                break;
            case C1096c.MapAttrs_uiCompass /*7*/:
                z = sharedPreferences.getInt("typeNotificationIsya", 4);
                break;
        }
        if (!z) {
            c0867a.f1603c.setImageResource(C0861R.drawable.ic_alarm_on);
        }
        if (c0915a.m3198g()) {
            c0867a.f1601a.setTextColor(App.m2867b(this.f1604a, (int) C0861R.color.nextPrayer));
            c0867a.f1602b.setTextColor(App.m2867b(this.f1604a, (int) C0861R.color.nextPrayer));
        } else {
            c0867a.f1601a.setTextColor(App.m2867b(this.f1604a, (int) C0861R.color.hitamnoterang));
            c0867a.f1602b.setTextColor(App.m2867b(this.f1604a, (int) C0861R.color.hitamnoterang));
        }
        c0867a.f1601a.setText(c0915a.m3190a());
        c0867a.f1602b.setText(c0915a.m3191a(b));
        return view;
    }
}
