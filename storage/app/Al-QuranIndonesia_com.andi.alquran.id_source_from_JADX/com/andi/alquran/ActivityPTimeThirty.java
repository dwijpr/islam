package com.andi.alquran;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import com.andi.alquran.p025b.C0879b;
import com.andi.alquran.p027d.C0894a;
import com.andi.alquran.p028g.C0915a;
import com.andi.alquran.p032j.C0941c;
import com.andi.alquran.p032j.C0950i;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class ActivityPTimeThirty extends AppCompatActivity {
    private Context f1328a;
    private TableLayout f1329b;
    private SharedPreferences f1330c;
    private SharedPreferences f1331d;
    private InterstitialAd f1332e;

    /* renamed from: com.andi.alquran.ActivityPTimeThirty.1 */
    class C07961 implements OnMultiChoiceClickListener {
        final /* synthetic */ boolean[] f1323a;
        final /* synthetic */ ActivityPTimeThirty f1324b;

        C07961(ActivityPTimeThirty activityPTimeThirty, boolean[] zArr) {
            this.f1324b = activityPTimeThirty;
            this.f1323a = zArr;
        }

        public void onClick(DialogInterface dialogInterface, int i, boolean z) {
            this.f1323a[i] = z;
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeThirty.2 */
    class C07972 implements OnClickListener {
        final /* synthetic */ boolean[] f1325a;
        final /* synthetic */ ActivityPTimeThirty f1326b;

        C07972(ActivityPTimeThirty activityPTimeThirty, boolean[] zArr) {
            this.f1326b = activityPTimeThirty;
            this.f1325a = zArr;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Editor edit = this.f1326b.f1330c.edit();
            for (int i2 = 0; i2 < this.f1325a.length; i2++) {
                boolean z = this.f1325a[i2];
                String str;
                if (i2 == 0) {
                    str = "showItemHijr";
                    if (z) {
                        edit.putBoolean(str, true);
                    } else {
                        edit.putBoolean(str, false);
                    }
                } else if (i2 == 1) {
                    str = "showItemImsak";
                    if (z) {
                        edit.putBoolean(str, true);
                    } else {
                        edit.putBoolean(str, false);
                    }
                } else if (i2 == 2) {
                    str = "showItemSubuh";
                    if (z) {
                        edit.putBoolean(str, true);
                    } else {
                        edit.putBoolean(str, false);
                    }
                } else if (i2 == 3) {
                    str = "showItemTerbit";
                    if (z) {
                        edit.putBoolean(str, true);
                    } else {
                        edit.putBoolean(str, false);
                    }
                } else if (i2 == 4) {
                    str = "showItemDzuhur";
                    if (z) {
                        edit.putBoolean(str, true);
                    } else {
                        edit.putBoolean(str, false);
                    }
                } else if (i2 == 5) {
                    str = "showItemAshar";
                    if (z) {
                        edit.putBoolean(str, true);
                    } else {
                        edit.putBoolean(str, false);
                    }
                } else if (i2 == 6) {
                    str = "showItemMaghrib";
                    if (z) {
                        edit.putBoolean(str, true);
                    } else {
                        edit.putBoolean(str, false);
                    }
                } else if (i2 == 7) {
                    str = "showItemIsya";
                    if (z) {
                        edit.putBoolean(str, true);
                    } else {
                        edit.putBoolean(str, false);
                    }
                }
            }
            edit.apply();
            this.f1326b.m2711b();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeThirty.3 */
    class C07983 implements OnClickListener {
        final /* synthetic */ ActivityPTimeThirty f1327a;

        C07983(ActivityPTimeThirty activityPTimeThirty) {
            this.f1327a = activityPTimeThirty;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public ActivityPTimeThirty() {
        this.f1332e = null;
    }

    private void m2710a() {
        C0950i c0950i = new C0950i(App.m2868b(this.f1330c, "typeCalc", 0), App.m2868b(this.f1330c, "typeJuristic", 0), App.m2868b(this.f1330c, "typeTimeFormat", 0), App.m2868b(this.f1330c, "typeAdjustHighLat", 3));
        int floor = (int) Math.floor(Double.parseDouble(new SimpleDateFormat("Z", Locale.getDefault()).format(Calendar.getInstance(Locale.getDefault()).getTime())) / 100.0d);
        double a = App.m2856a(this.f1330c, "latitude", 0.0d);
        double a2 = App.m2856a(this.f1330c, "longitude", 0.0d);
        int b = App.m2868b(this.f1330c, "typeTimeFormat", 0);
        int i = this.f1330c.getInt("adjustHijrCal", 0);
        for (int i2 = 0; i2 <= 30; i2++) {
            Calendar instance = Calendar.getInstance(Locale.getDefault());
            Calendar instance2 = Calendar.getInstance(Locale.getDefault());
            instance.add(6, i2);
            instance2.add(6, i2 + i);
            ArrayList a3 = c0950i.m3305a(this.f1330c, instance, a, a2, (double) floor);
            Date time = instance.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", Locale.getDefault());
            ArrayList arrayList = new ArrayList();
            String format = simpleDateFormat.format(time);
            String a4 = C0941c.m3277a(instance2, true);
            arrayList.add(format);
            arrayList.add(a4);
            Iterator it = a3.iterator();
            while (it.hasNext()) {
                C0915a c0915a = (C0915a) it.next();
                if (b == 1) {
                    arrayList.add(C0894a.m3109b(c0915a.m3193b(), c0915a.m3194c()));
                } else {
                    arrayList.add(c0915a.m3197f());
                }
            }
            View tableRow = new TableRow(this.f1328a);
            tableRow.setLayoutParams(new LayoutParams(-1, -2));
            if (i2 % 2 == 0) {
                tableRow.setBackgroundColor(App.m2867b(this.f1328a, (int) C0861R.color.rowOdd));
            } else {
                tableRow.setBackgroundColor(App.m2867b(this.f1328a, (int) C0861R.color.bgThirty));
            }
            Iterator it2 = arrayList.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                a4 = (String) it2.next();
                View textView = new TextView(this.f1328a);
                textView.setLayoutParams(new TableRow.LayoutParams(-2, -2));
                textView.setGravity(17);
                textView.setTextSize(16.0f);
                textView.setPadding(5, 5, 5, 5);
                textView.setText(a4);
                if (i3 == 0) {
                    textView.setTextColor(App.m2867b(this.f1328a, C0861R.color.textDatePTime));
                } else {
                    textView.setTextColor(App.m2867b(this.f1328a, C0861R.color.putih));
                }
                textView.setTypeface(Typeface.create("sans-serif-light", 0));
                tableRow.addView(textView);
                i3++;
            }
            this.f1329b.addView(tableRow);
        }
        m2711b();
    }

    private void m2711b() {
        boolean z = this.f1330c.getBoolean("showItemHijr", true);
        boolean z2 = this.f1330c.getBoolean("showItemImsak", true);
        boolean z3 = this.f1330c.getBoolean("showItemSubuh", true);
        boolean z4 = this.f1330c.getBoolean("showItemTerbit", true);
        boolean z5 = this.f1330c.getBoolean("showItemDzuhur", true);
        boolean z6 = this.f1330c.getBoolean("showItemAshar", true);
        boolean z7 = this.f1330c.getBoolean("showItemMaghrib", true);
        boolean z8 = this.f1330c.getBoolean("showItemIsya", true);
        if (z) {
            this.f1329b.setColumnCollapsed(1, false);
        } else {
            this.f1329b.setColumnCollapsed(1, true);
        }
        if (z2) {
            this.f1329b.setColumnCollapsed(2, false);
        } else {
            this.f1329b.setColumnCollapsed(2, true);
        }
        if (z3) {
            this.f1329b.setColumnCollapsed(3, false);
        } else {
            this.f1329b.setColumnCollapsed(3, true);
        }
        if (z4) {
            this.f1329b.setColumnCollapsed(4, false);
        } else {
            this.f1329b.setColumnCollapsed(4, true);
        }
        if (z5) {
            this.f1329b.setColumnCollapsed(5, false);
        } else {
            this.f1329b.setColumnCollapsed(5, true);
        }
        if (z6) {
            this.f1329b.setColumnCollapsed(6, false);
        } else {
            this.f1329b.setColumnCollapsed(6, true);
        }
        if (z7) {
            this.f1329b.setColumnCollapsed(7, false);
        } else {
            this.f1329b.setColumnCollapsed(7, true);
        }
        if (z8) {
            this.f1329b.setColumnCollapsed(8, false);
        } else {
            this.f1329b.setColumnCollapsed(8, true);
        }
        this.f1329b.setStretchAllColumns(true);
    }

    private void m2713c() {
        Builder builder = new Builder(this);
        CharSequence[] charSequenceArr = new String[]{getString(C0861R.string.hijr), getString(C0861R.string.imsak), getString(C0861R.string.subuh), getString(C0861R.string.sunrise), getString(C0861R.string.dzuhur), getString(C0861R.string.ashar), getString(C0861R.string.maghrib), getString(C0861R.string.isya)};
        boolean z = this.f1330c.getBoolean("showItemHijr", true);
        boolean z2 = this.f1330c.getBoolean("showItemImsak", true);
        boolean z3 = this.f1330c.getBoolean("showItemSubuh", true);
        boolean z4 = this.f1330c.getBoolean("showItemTerbit", true);
        boolean z5 = this.f1330c.getBoolean("showItemDzuhur", true);
        boolean z6 = this.f1330c.getBoolean("showItemAshar", true);
        boolean z7 = this.f1330c.getBoolean("showItemMaghrib", true);
        boolean z8 = this.f1330c.getBoolean("showItemIsya", true);
        boolean[] zArr = new boolean[]{z, z2, z3, z4, z5, z6, z7, z8};
        builder.setMultiChoiceItems(charSequenceArr, zArr, new C07961(this, zArr));
        builder.setTitle(getString(C0861R.string.dlg_item_to_show_title));
        builder.setIcon((int) C0861R.drawable.ic_black_action_view);
        builder.setPositiveButton(getString(C0861R.string.save), new C07972(this, zArr));
        builder.setNegativeButton(getString(C0861R.string.cancel), new C07983(this));
        builder.create().show();
    }

    private void m2714d() {
        if (this.f1332e != null && this.f1332e.isLoaded()) {
            this.f1332e.show();
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = this.f1331d.edit();
            edit.putLong(C0879b.f1647d, currentTimeMillis);
            edit.apply();
        }
    }

    protected void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_thirty);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.f1328a = this;
        App app = (App) getApplication();
        app.f1450b.m3067a(this);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (app.f1450b.f1668g) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
        this.f1330c = this.f1328a.getSharedPreferences("prayer_time_by_andi", 0);
        this.f1331d = this.f1328a.getSharedPreferences(C0879b.f1644a, 0);
        this.f1329b = (TableLayout) findViewById(C0861R.id.tableLayout);
        View tableRow = new TableRow(this.f1328a);
        tableRow.setBackgroundColor(App.m2867b(this.f1328a, (int) C0861R.color.rowHeader));
        tableRow.setLayoutParams(new LayoutParams(-1, -2));
        for (CharSequence charSequence : new String[]{getString(C0861R.string.date), getString(C0861R.string.hijr), getString(C0861R.string.imsak), getString(C0861R.string.subuh), getString(C0861R.string.sunrise), getString(C0861R.string.dzuhur), getString(C0861R.string.ashar), getString(C0861R.string.maghrib), getString(C0861R.string.isya)}) {
            View textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(-2, -2));
            textView.setGravity(17);
            textView.setTextSize(16.0f);
            textView.setPadding(5, 10, 5, 7);
            textView.setText(charSequence);
            if (i == 0) {
                textView.setTextColor(App.m2867b(this.f1328a, (int) C0861R.color.textDatePTime));
            } else {
                textView.setTextColor(App.m2867b(this.f1328a, (int) C0861R.color.putih));
            }
            tableRow.addView(textView);
            i++;
        }
        this.f1329b.addView(tableRow);
        m2710a();
        if (!App.m2897v() && this.f1331d.getLong(C0879b.f1647d, 0) + ((long) ((C0879b.f1648e * 60) * 1000)) < System.currentTimeMillis()) {
            this.f1332e = new InterstitialAd(this);
            this.f1332e.setAdUnitId(App.m2895t());
            this.f1332e.loadAd(new AdRequest.Builder().build());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0861R.menu.menu_thirdy, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy() {
        m2714d();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        } else if (menuItem.getItemId() != C0861R.id.action_show) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m2713c();
            return true;
        }
    }
}
