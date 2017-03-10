package com.andi.alquran;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.p009b.C0173a;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.recyclerview.BuildConfig;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.andi.alquran.p022f.C0774a;
import com.andi.alquran.p022f.C0775c;
import com.andi.alquran.p022f.C0776d;
import com.andi.alquran.p024a.C0868c;
import com.andi.alquran.p027d.C0895b;
import com.andi.alquran.p028g.C0915a;
import com.andi.alquran.p028g.C0916b;
import com.andi.alquran.p031i.C0919a;
import com.andi.alquran.p031i.C0928e;
import com.andi.alquran.p031i.C0929f;
import com.andi.alquran.p032j.C0941c;
import com.andi.alquran.p032j.C0943e;
import com.andi.alquran.p032j.C0951j;
import com.andi.alquran.services.NotifSholatService;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.api.C1277c.C1276a;
import com.google.android.gms.location.C0779d;
import com.google.android.gms.location.C2088e;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

public class ActivityPTime extends AppCompatActivity implements OnClickListener, OnItemClickListener, C0774a, C0775c, C0776d, C0777b, C0778c, C0779d {
    private Runnable f1244A;
    Location f1245a;
    Handler f1246b;
    private ListView f1247c;
    private TextView f1248d;
    private TextView f1249e;
    private TextView f1250f;
    private TextView f1251g;
    private TextView f1252h;
    private TextView f1253i;
    private TextView f1254j;
    private Calendar f1255k;
    private ArrayList<C0915a> f1256l;
    private String f1257m;
    private double f1258n;
    private double f1259o;
    private SharedPreferences f1260p;
    private C0868c f1261q;
    private ProgressBar f1262r;
    private Context f1263s;
    private Button f1264t;
    private Button f1265u;
    private App f1266v;
    private C1277c f1267w;
    private double f1268x;
    private double f1269y;
    private ProgressDialog f1270z;

    /* renamed from: com.andi.alquran.ActivityPTime.1 */
    class C07651 implements OnClickListener {
        final /* synthetic */ ActivityPTime f1231a;

        C07651(ActivityPTime activityPTime) {
            this.f1231a = activityPTime;
        }

        public void onClick(View view) {
            this.f1231a.m2660f();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTime.2 */
    class C07662 implements OnClickListener {
        final /* synthetic */ ActivityPTime f1232a;

        C07662(ActivityPTime activityPTime) {
            this.f1232a = activityPTime;
        }

        public void onClick(View view) {
            this.f1232a.m2662g();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTime.3 */
    class C07673 extends AdListener {
        final /* synthetic */ LinearLayout f1233a;
        final /* synthetic */ ActivityPTime f1234b;

        C07673(ActivityPTime activityPTime, LinearLayout linearLayout) {
            this.f1234b = activityPTime;
            this.f1233a = linearLayout;
        }

        public void onAdLoaded() {
            this.f1233a.setVisibility(0);
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTime.4 */
    class C07684 implements OnClickListener {
        final /* synthetic */ ActivityPTime f1235a;

        C07684(ActivityPTime activityPTime) {
            this.f1235a = activityPTime;
        }

        public void onClick(View view) {
            this.f1235a.finish();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTime.5 */
    class C07695 implements DialogInterface.OnClickListener {
        final /* synthetic */ C0915a f1236a;
        final /* synthetic */ String f1237b;
        final /* synthetic */ String f1238c;
        final /* synthetic */ ActivityPTime f1239d;

        C07695(ActivityPTime activityPTime, C0915a c0915a, String str, String str2) {
            this.f1239d = activityPTime;
            this.f1236a = c0915a;
            this.f1237b = str;
            this.f1238c = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f1236a.m3196e() == 1 || this.f1236a.m3196e() == 3) {
                i++;
            }
            Editor edit = this.f1239d.f1260p.edit();
            edit.putInt(this.f1237b, i);
            edit.apply();
            this.f1239d.f1261q.notifyDataSetChanged();
            if (i == 4) {
                App.m2871b(this.f1239d.getString(C0861R.string.msg_alarm_set_to_off, new Object[]{this.f1238c}));
            }
            C0895b.m3111b(this.f1239d.f1263s);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTime.6 */
    class C07706 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivityPTime f1240a;

        C07706(ActivityPTime activityPTime) {
            this.f1240a = activityPTime;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTime.7 */
    class C07717 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivityPTime f1241a;

        C07717(ActivityPTime activityPTime) {
            this.f1241a = activityPTime;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f1241a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTime.8 */
    class C07728 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivityPTime f1242a;

        C07728(ActivityPTime activityPTime) {
            this.f1242a = activityPTime;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTime.9 */
    class C07739 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivityPTime f1243a;

        C07739(ActivityPTime activityPTime) {
            this.f1243a = activityPTime;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public ActivityPTime() {
        this.f1255k = Calendar.getInstance(Locale.getDefault());
        this.f1256l = null;
        this.f1257m = BuildConfig.VERSION_NAME;
        this.f1258n = 0.0d;
        this.f1259o = 0.0d;
        this.f1268x = 0.0d;
        this.f1269y = 0.0d;
        this.f1246b = new Handler();
        this.f1244A = new Runnable() {
            final /* synthetic */ ActivityPTime f1226a;

            {
                this.f1226a = r1;
            }

            public void run() {
                this.f1226a.f1255k = Calendar.getInstance(Locale.getDefault());
                int i = this.f1226a.f1255k.get(11);
                int i2 = this.f1226a.f1255k.get(12);
                double b = C0951j.m3313b((((double) i) + (((double) i2) / 60.0d)) + 0.008333333333333333d);
                C0915a c0915a = new C0915a();
                if (this.f1226a.f1256l != null && this.f1226a.f1256l.size() > 0) {
                    C0915a c0915a2;
                    int i3;
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    Iterator it = this.f1226a.f1256l.iterator();
                    int i7 = 0;
                    while (it.hasNext()) {
                        if (b < ((C0915a) it.next()).m3195d()) {
                            c0915a2 = (C0915a) this.f1226a.f1256l.get(i7);
                            break;
                        }
                        i7++;
                    }
                    c0915a2 = c0915a;
                    C0915a c0915a3 = c0915a2;
                    for (i3 = 0; i3 < this.f1226a.f1256l.size(); i3++) {
                        if (i3 == i7) {
                            ((C0915a) this.f1226a.f1256l.get(i3)).m3192a(true);
                            if (i3 != 0) {
                                i4 = i3 - 1;
                                i5 = ((C0915a) this.f1226a.f1256l.get(i3 - 1)).m3193b();
                                i6 = ((C0915a) this.f1226a.f1256l.get(i3 - 1)).m3194c();
                            } else {
                                i5 = 24;
                                i6 = 0;
                                c0915a3 = (C0915a) this.f1226a.f1256l.get(i3);
                            }
                        } else {
                            ((C0915a) this.f1226a.f1256l.get(i3)).m3192a(false);
                        }
                    }
                    double b2;
                    if (i >= 24 || b <= ((C0915a) this.f1226a.f1256l.get(this.f1226a.f1256l.size() - 1)).m3195d()) {
                        i7 = i2 - i6;
                        if (i - i5 != 0 || i7 > 7) {
                            b2 = C0951j.m3313b((c0915a3.m3195d() - b) + 0.008333333333333333d);
                            i3 = (int) Math.floor(b2);
                            i6 = (int) Math.floor((b2 - ((double) i3)) * 60.0d);
                            if (i3 != 0 || i6 >= 20) {
                                this.f1226a.f1251g.setText(this.f1226a.getString(C0861R.string.next_prayer_more_one_hour, new Object[]{c0915a3.m3190a()}));
                            } else {
                                this.f1226a.f1251g.setText(this.f1226a.getString(C0861R.string.next_prayer_on_one_hour, new Object[]{c0915a3.m3190a()}));
                            }
                            this.f1226a.f1252h.setText("\u00b1 " + App.m2862a(b2, true));
                        } else {
                            c0915a3.m3192a(false);
                            c0915a2 = (C0915a) this.f1226a.f1256l.get(i4);
                            c0915a2.m3192a(true);
                            double b3 = C0951j.m3313b((b - c0915a2.m3195d()) + 0.008333333333333333d);
                            if (i7 <= 1) {
                                this.f1226a.f1251g.setText(this.f1226a.getString(C0861R.string.prayer_now, new Object[]{c0915a2.m3190a()}));
                            } else {
                                this.f1226a.f1251g.setText(this.f1226a.getString(C0861R.string.prayer_just_passed, new Object[]{c0915a2.m3190a()}));
                            }
                            this.f1226a.f1252h.setText("\u00b1 " + App.m2862a(b3, false));
                        }
                    } else {
                        c0915a2 = (C0915a) this.f1226a.f1256l.get(this.f1226a.f1256l.size() - 1);
                        c0915a2.m3192a(true);
                        b2 = C0951j.m3313b((b - c0915a2.m3195d()) + 0.008333333333333333d);
                        i3 = (int) Math.floor(b2);
                        i6 = (int) Math.floor((b2 - ((double) i3)) * 60.0d);
                        if (i3 == 0 && i6 <= 1) {
                            this.f1226a.f1251g.setText(this.f1226a.getString(C0861R.string.isya_prayer_now));
                        } else if (i3 != 0 || i6 > 7) {
                            this.f1226a.f1251g.setText(this.f1226a.getString(C0861R.string.isya_prayer_passed_hour));
                        } else {
                            this.f1226a.f1251g.setText(this.f1226a.getString(C0861R.string.isya_prayer_just_passed));
                        }
                        this.f1226a.f1252h.setText("\u00b1 " + App.m2862a(b2, false));
                    }
                }
                this.f1226a.f1261q.notifyDataSetChanged();
                this.f1226a.f1246b.postDelayed(this, 1000);
            }
        };
    }

    private void m2649a(boolean z) {
        CharSequence charSequence;
        this.f1254j.setVisibility(8);
        this.f1264t.setVisibility(8);
        this.f1265u.setVisibility(8);
        this.f1258n = App.m2856a(this.f1260p, "latitude", 0.0d);
        this.f1259o = App.m2856a(this.f1260p, "longitude", 0.0d);
        int floor = (int) Math.floor(Double.parseDouble(new SimpleDateFormat("Z", Locale.getDefault()).format(this.f1255k.getTime())) / 100.0d);
        this.f1249e.setText(new SimpleDateFormat("d MMMM yyyy", Locale.getDefault()).format(this.f1255k.getTime()));
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.add(6, this.f1260p.getInt("adjustHijrCal", 0));
        this.f1250f.setText(C0941c.m3277a(instance, false));
        this.f1257m = this.f1260p.getString("cityName", BuildConfig.VERSION_NAME);
        if (this.f1257m.equals(BuildConfig.VERSION_NAME)) {
            Object string = getString(C0861R.string.city_unknown);
        } else {
            charSequence = this.f1257m;
        }
        this.f1248d.setText(charSequence);
        C0916b c0916b;
        if ((this.f1258n == 0.0d && this.f1259o == 0.0d) || this.f1257m.equals(BuildConfig.VERSION_NAME) || z) {
            this.f1262r.setVisibility(0);
            this.f1247c.setVisibility(8);
            this.f1265u.setVisibility(0);
            this.f1248d.setText(getString(C0861R.string.loading));
            if (App.m2881f()) {
                LocationManager locationManager = (LocationManager) this.f1263s.getSystemService("location");
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
                if (!isProviderEnabled && !isProviderEnabled2) {
                    m2653c();
                    this.f1248d.setText(charSequence);
                    this.f1262r.setVisibility(8);
                    this.f1254j.setVisibility(0);
                    this.f1254j.setText(getString(C0861R.string.msg_gps_cannot_get_location));
                    this.f1264t.setVisibility(0);
                    return;
                } else if (this.f1268x == 0.0d || this.f1269y == 0.0d) {
                    this.f1248d.setText(charSequence);
                    this.f1262r.setVisibility(8);
                    this.f1254j.setVisibility(0);
                    this.f1254j.setText(getString(C0861R.string.msg_location_notfound_choose_manual));
                    this.f1264t.setVisibility(8);
                    return;
                } else {
                    this.f1258n = this.f1268x;
                    this.f1259o = this.f1269y;
                    this.f1260p.edit().putString("latitude", String.valueOf(this.f1258n)).apply();
                    this.f1260p.edit().putString("longitude", String.valueOf(this.f1259o)).apply();
                    c0916b = new C0916b(this.f1258n, this.f1259o, (double) floor);
                    new C0919a(this.f1260p, this).execute(new C0916b[]{c0916b});
                    this.f1270z = ProgressDialog.show(this, BuildConfig.VERSION_NAME, getString(C0861R.string.loading), true, true);
                    if (Geocoder.isPresent()) {
                        new C0929f(this.f1263s, this.f1258n, this.f1259o, this).execute(new Void[0]);
                        return;
                    } else {
                        new C0928e(this.f1263s, this.f1258n, this.f1259o, this).execute(new Void[0]);
                        return;
                    }
                }
            }
            this.f1248d.setText(charSequence);
            this.f1254j.setVisibility(0);
            this.f1254j.setText(getString(C0861R.string.msg_cannot_get_city_no_internet));
            App.m2871b(getString(C0861R.string.msg_cannot_get_city_no_internet));
            this.f1265u.setVisibility(8);
            this.f1264t.setVisibility(0);
            if (this.f1258n != 0.0d && this.f1259o != 0.0d && !this.f1257m.equals(BuildConfig.VERSION_NAME)) {
                c0916b = new C0916b(this.f1258n, this.f1259o, (double) floor);
                new C0919a(this.f1260p, this).execute(new C0916b[]{c0916b});
                return;
            }
            return;
        }
        c0916b = new C0916b(this.f1258n, this.f1259o, (double) floor);
        new C0919a(this.f1260p, this).execute(new C0916b[]{c0916b});
    }

    private void m2650b() {
        String string = this.f1260p.getString("cityName", BuildConfig.VERSION_NAME);
        String string2 = this.f1260p.getString("countryCode", BuildConfig.VERSION_NAME);
        boolean z = this.f1260p.getBoolean("askCalc", false);
        if (this.f1258n != 0.0d && this.f1259o != 0.0d && !string.equals(BuildConfig.VERSION_NAME) && !z && !string2.equals(BuildConfig.VERSION_NAME)) {
            this.f1260p.edit().putBoolean("askCalc", true).apply();
            App.m2900y();
            this.f1266v.f1451c.m3063a(this);
            this.f1266v.f1451c.m3064b(this);
            m2649a(false);
            m2656d();
        }
    }

    private void m2653c() {
        Builder builder = new Builder(this.f1263s);
        builder.setTitle(getString(C0861R.string.dlg_gps_setting_title));
        builder.setIcon((int) C0861R.drawable.ic_gps);
        builder.setMessage(getString(C0861R.string.dlg_gps_setting_desc));
        builder.setPositiveButton(getString(C0861R.string.setting), new C07717(this));
        builder.setNegativeButton(getString(C0861R.string.cancel), new C07728(this));
        builder.show();
    }

    private void m2654c(String str) {
        if (!(((ActivityPTime) this.f1263s).isFinishing() || this.f1270z == null || !this.f1270z.isShowing())) {
            this.f1270z.dismiss();
        }
        if (!str.trim().equals(BuildConfig.VERSION_NAME)) {
            this.f1248d.setText(str);
            String string = this.f1260p.getString("cityName", BuildConfig.VERSION_NAME);
            String string2 = this.f1260p.getString("subStateName", BuildConfig.VERSION_NAME);
            String string3 = this.f1260p.getString("countryName", BuildConfig.VERSION_NAME);
            if (!string2.equals(BuildConfig.VERSION_NAME)) {
                string = string + ", " + string2;
            }
            if (!string3.equals(BuildConfig.VERSION_NAME)) {
                string = string + " - " + string3;
            }
            if (!string.trim().equals(BuildConfig.VERSION_NAME)) {
                this.f1253i.setText(getString(C0861R.string.city_and_country, new Object[]{string}));
            }
            App.m2900y();
            this.f1266v.f1451c.m3063a(this);
            this.f1266v.f1451c.m3064b(this);
            C0895b.m3111b(this.f1263s);
            m2649a(false);
        } else if (this.f1260p.getBoolean("askCalc", false)) {
            App.m2865a(getString(C0861R.string.msg_cannot_get_city_result_error));
        }
    }

    private void m2656d() {
        if (!((ActivityPTime) this.f1263s).isFinishing()) {
            Builder builder = new Builder(this.f1263s);
            builder.setTitle(getString(C0861R.string.dlg_info_calc_method_change_title));
            builder.setIcon((int) C0861R.drawable.ic_black_action_about);
            builder.setMessage(getString(C0861R.string.dlg_info_calc_method_change_desc));
            builder.setCancelable(false);
            builder.setPositiveButton(getString(C0861R.string.dlg_info_calc_method_change_button), new C07739(this));
            builder.show();
        }
    }

    private void m2658e() {
        CharSequence[] stringArray = getResources().getStringArray(C0861R.array.setLocation);
        Builder builder = new Builder(this);
        builder.setTitle(getString(C0861R.string.dlg_edit_lokasi_title));
        builder.setIcon((int) C0861R.drawable.ic_location_black_dialog);
        builder.setItems(stringArray, new DialogInterface.OnClickListener() {
            final /* synthetic */ ActivityPTime f1227a;

            {
                this.f1227a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (!App.m2881f()) {
                    App.m2871b(this.f1227a.getString(C0861R.string.msg_no_internet_refresh_location));
                } else if (i != 0) {
                    this.f1227a.startActivity(new Intent(this.f1227a, ActivityPTimeMapChooseCity.class));
                } else if (this.f1227a.m2664h()) {
                    this.f1227a.m2649a(true);
                } else {
                    ActivityCompat.requestPermissions(this.f1227a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
                }
            }
        });
        builder.create().show();
    }

    private void m2660f() {
        this.f1258n = App.m2856a(this.f1260p, "latitude", 0.0d);
        this.f1259o = App.m2856a(this.f1260p, "longitude", 0.0d);
        String string = this.f1260p.getString("cityName", BuildConfig.VERSION_NAME);
        if (this.f1258n == 0.0d || this.f1259o == 0.0d || string.equals(BuildConfig.VERSION_NAME)) {
            App.m2871b(getString(C0861R.string.msg_location_not_detected));
            return;
        }
        PackageManager packageManager = this.f1263s.getPackageManager();
        boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.sensor.compass");
        boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.sensor.accelerometer");
        if (!hasSystemFeature || !hasSystemFeature2) {
            Builder builder = new Builder(this.f1263s);
            builder.setMessage(getString(C0861R.string.msg_nohardware_sensor)).setCancelable(false).setNegativeButton(getString(C0861R.string.close), new DialogInterface.OnClickListener() {
                final /* synthetic */ ActivityPTime f1228a;

                {
                    this.f1228a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        } else if (C0943e.m3279a(this.f1258n, this.f1259o) < 100.0d) {
            App.m2865a(getString(C0861R.string.msg_kaba_too_nearby));
        } else {
            startActivity(new Intent(this, ActivityPTimeQibla.class));
        }
    }

    private void m2662g() {
        if (VERSION.SDK_INT <= 10) {
            startActivity(new Intent(this, ActivityPTimeSettingV10.class));
        } else {
            startActivity(new Intent(this, ActivityPTimeSetting.class));
        }
    }

    private boolean m2664h() {
        return C0173a.checkSelfPermission(this.f1263s, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private void m2666i() {
        new Builder(this).setCancelable(true).setMessage(getString(C0861R.string.dlg_athan_isrunning_desc)).setPositiveButton(getString(C0861R.string.yes), new DialogInterface.OnClickListener() {
            final /* synthetic */ ActivityPTime f1230a;

            {
                this.f1230a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.setAction(NotifSholatService.f1958b);
                intent.putExtras(new Bundle());
                this.f1230a.sendBroadcast(intent);
            }
        }).setNegativeButton(getString(C0861R.string.update_button_later), new DialogInterface.OnClickListener() {
            final /* synthetic */ ActivityPTime f1229a;

            {
                this.f1229a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    private void m2667j() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.setFlags(67108864);
        intent.addFlags(65536);
        overridePendingTransition(0, 0);
        finish();
        startActivity(intent);
    }

    synchronized void m2669a() {
        if (m2664h()) {
            this.f1267w = new C1276a(this).m4534a((C0777b) this).m4535a((C0778c) this).m4533a(C2088e.f6702a).m4537b();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
    }

    public void m2670a(int i) {
    }

    public void m2671a(Location location) {
        this.f1268x = location.getLatitude();
        this.f1269y = location.getLongitude();
        if (this.f1268x != 0.0d && this.f1269y != 0.0d && this.f1257m.equals(BuildConfig.VERSION_NAME) && this.f1258n == 0.0d && this.f1259o == 0.0d) {
            m2649a(true);
        }
    }

    public void m2672a(Bundle bundle) {
        LocationRequest a = LocationRequest.m9803a();
        a.m9807a(100);
        a.m9808a(120000);
        if (C0173a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || C0173a.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            C2088e.f6703b.m5333a(this.f1267w, a, this);
            this.f1245a = C2088e.f6703b.m5332a(this.f1267w);
            if (this.f1245a != null) {
                this.f1268x = this.f1245a.getLatitude();
                this.f1269y = this.f1245a.getLongitude();
            }
        }
    }

    public void m2673a(ConnectionResult connectionResult) {
        m2669a();
    }

    public void m2674a(String str) {
        if (str.trim().equals(BuildConfig.VERSION_NAME)) {
            new C0928e(this.f1263s, this.f1258n, this.f1259o, this).execute(new Void[0]);
        } else {
            m2654c(str);
        }
    }

    public void m2675a(ArrayList<C0915a> arrayList) {
        this.f1247c.setVisibility(0);
        String string = this.f1260p.getString("cityName", BuildConfig.VERSION_NAME);
        String string2 = this.f1260p.getString("subStateName", BuildConfig.VERSION_NAME);
        String string3 = this.f1260p.getString("countryName", BuildConfig.VERSION_NAME);
        if (!string2.equals(BuildConfig.VERSION_NAME)) {
            string = string + ", " + string2;
        }
        if (!string3.equals(BuildConfig.VERSION_NAME)) {
            string = string + " - " + string3;
        }
        if (!string.trim().equals(BuildConfig.VERSION_NAME)) {
            this.f1253i.setText(getString(C0861R.string.city_and_country, new Object[]{string}));
        }
        this.f1256l = arrayList;
        this.f1261q = new C0868c(this.f1263s, this.f1256l, this.f1255k);
        this.f1247c.setAdapter(this.f1261q);
        this.f1246b.post(this.f1244A);
        this.f1262r.setVisibility(8);
        this.f1254j.setVisibility(8);
        this.f1264t.setVisibility(8);
        this.f1265u.setVisibility(8);
        m2650b();
    }

    public void m2676b(String str) {
        m2654c(str);
    }

    public void onClick(View view) {
        if (view.getId() == C0861R.id.buttonRefreshLocation) {
            m2658e();
        } else if (view.getId() == C0861R.id.buttonThirty) {
            this.f1258n = App.m2856a(this.f1260p, "latitude", 0.0d);
            this.f1259o = App.m2856a(this.f1260p, "longitude", 0.0d);
            String string = this.f1260p.getString("cityName", BuildConfig.VERSION_NAME);
            if (this.f1258n == 0.0d || this.f1259o == 0.0d || string.equals(BuildConfig.VERSION_NAME)) {
                App.m2871b(getString(C0861R.string.msg_location_not_detected));
            } else {
                startActivity(new Intent(this, ActivityPTimeThirty.class));
            }
        } else if (view.getId() == C0861R.id.buttonLocationNotFoundTryAgain) {
            m2649a(true);
        } else if (view.getId() == C0861R.id.buttonLocationNotFoundManual) {
            startActivity(new Intent(this, ActivityPTimeMapChooseCity.class));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_prayer_time);
        this.f1263s = this;
        this.f1266v = (App) getApplication();
        this.f1266v.f1450b.m3067a(this);
        LayoutParams attributes = getWindow().getAttributes();
        if (this.f1266v.f1450b.f1668g) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
        this.f1260p = this.f1263s.getSharedPreferences("prayer_time_by_andi", 0);
        this.f1247c = (ListView) findViewById(C0861R.id.listPrayerTimes);
        this.f1247c.setOnItemClickListener(this);
        this.f1249e = (TextView) findViewById(C0861R.id.dateGregorian);
        this.f1250f = (TextView) findViewById(C0861R.id.dateHijr);
        this.f1251g = (TextView) findViewById(C0861R.id.nextPrayerNameInfo);
        this.f1252h = (TextView) findViewById(C0861R.id.timeLeft);
        this.f1262r = (ProgressBar) findViewById(C0861R.id.progressSyncLocation);
        this.f1248d = (TextView) findViewById(C0861R.id.textCityName);
        this.f1253i = (TextView) findViewById(C0861R.id.cityAndCountry);
        this.f1254j = (TextView) findViewById(C0861R.id.textLocationNotFound);
        this.f1264t = (Button) findViewById(C0861R.id.buttonLocationNotFoundTryAgain);
        this.f1265u = (Button) findViewById(C0861R.id.buttonLocationNotFoundManual);
        this.f1264t.setOnClickListener(this);
        this.f1265u.setOnClickListener(this);
        ((ImageButton) findViewById(C0861R.id.buttonRefreshLocation)).setOnClickListener(this);
        ((ImageButton) findViewById(C0861R.id.buttonThirty)).setOnClickListener(this);
        ((ImageButton) findViewById(C0861R.id.buttonQibla)).setOnClickListener(new C07651(this));
        ((ImageButton) findViewById(C0861R.id.buttonSetting)).setOnClickListener(new C07662(this));
        this.f1258n = App.m2856a(this.f1260p, "latitude", 0.0d);
        this.f1259o = App.m2856a(this.f1260p, "longitude", 0.0d);
        this.f1257m = this.f1260p.getString("cityName", BuildConfig.VERSION_NAME);
        if (!(this.f1258n == 0.0d || this.f1259o == 0.0d || App.m2897v())) {
            LinearLayout linearLayout = (LinearLayout) findViewById(C0861R.id.bannerAdsPtime);
            View nativeExpressAdView = new NativeExpressAdView(this);
            if (App.m2857a(this.f1263s) > 2) {
                nativeExpressAdView.setAdSize(new AdSize(-1, 80));
            } else {
                nativeExpressAdView.setAdSize(new AdSize(342, 80));
            }
            nativeExpressAdView.setAdUnitId(App.m2893r());
            AdRequest.Builder builder = new AdRequest.Builder();
            linearLayout.addView(nativeExpressAdView);
            nativeExpressAdView.loadAd(builder.build());
            nativeExpressAdView.setAdListener(new C07673(this, linearLayout));
        }
        ((ImageButton) findViewById(C0861R.id.logo)).setOnClickListener(new C07684(this));
        if (m2664h()) {
            m2669a();
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f1267w != null) {
            this.f1267w.m4549c();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str;
        int i2;
        C0915a c0915a = (C0915a) this.f1256l.get(i);
        CharSequence[] stringArray = getResources().getStringArray(C0861R.array.arrTypeAlarm);
        if (c0915a.m3196e() == 1 || c0915a.m3196e() == 3) {
            stringArray = getResources().getStringArray(C0861R.array.arrTypeAlarmImsak);
        }
        String str2 = BuildConfig.VERSION_NAME;
        String str3 = BuildConfig.VERSION_NAME;
        switch (c0915a.m3196e()) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                str = "typeNotificationImsak";
                i2 = this.f1260p.getInt(str, 4);
                str2 = getString(C0861R.string.imsak);
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                str = "typeNotificationSubuh";
                i2 = this.f1260p.getInt(str, 4);
                str2 = getString(C0861R.string.subuh);
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                str = "typeNotificationTerbit";
                i2 = this.f1260p.getInt(str, 4);
                str2 = getString(C0861R.string.sunrise);
                break;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                str = "typeNotificationDzuhur";
                i2 = this.f1260p.getInt(str, 4);
                str2 = getString(C0861R.string.dzuhur);
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                str = "typeNotificationAshar";
                i2 = this.f1260p.getInt(str, 4);
                str2 = getString(C0861R.string.ashar);
                break;
            case C1096c.MapAttrs_liteMode /*6*/:
                str = "typeNotificationMaghrib";
                i2 = this.f1260p.getInt(str, 4);
                str2 = getString(C0861R.string.maghrib);
                break;
            case C1096c.MapAttrs_uiCompass /*7*/:
                str = "typeNotificationIsya";
                i2 = this.f1260p.getInt(str, 4);
                str2 = getString(C0861R.string.isya);
                break;
            default:
                str = str2;
                str2 = str3;
                i2 = 0;
                break;
        }
        if (c0915a.m3196e() == 1 || c0915a.m3196e() == 3) {
            i2--;
        }
        if (!str.equals(BuildConfig.VERSION_NAME)) {
            Builder builder = new Builder(this);
            builder.setTitle(getString(C0861R.string.dlg_notification_title, new Object[]{str2}));
            builder.setIcon((int) C0861R.drawable.ic_alarm_title);
            builder.setSingleChoiceItems(stringArray, i2, new C07695(this, c0915a, str, str2));
            builder.setNegativeButton(getString(C0861R.string.cancel), new C07706(this));
            builder.create().show();
        }
    }

    public void onPause() {
        super.onPause();
        this.f1266v.f1451c.m3064b(this);
        this.f1246b.removeCallbacks(this.f1244A);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    App.m2865a(getString(C0861R.string.msg_request_permission_location));
                    finish();
                    return;
                }
                m2667j();
            default:
        }
    }

    public void onResume() {
        super.onResume();
        this.f1266v.f1451c.m3063a(this);
        this.f1266v.f1451c.m3064b(this);
        if (this.f1260p != null) {
            this.f1260p = this.f1263s.getSharedPreferences("prayer_time_by_andi", 0);
        }
        if (m2664h()) {
            m2649a(false);
        }
        if (this.f1256l != null && this.f1256l.size() > 0) {
            this.f1246b.post(this.f1244A);
        }
        if (NotifSholatService.f1957a) {
            m2666i();
        }
    }

    protected void onStart() {
        super.onStart();
        if (this.f1267w != null) {
            this.f1267w.m4546b();
        }
    }
}
