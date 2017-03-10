package com.andi.alquran;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.recyclerview.BuildConfig;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.andi.alquran.customviews.C0893a;
import com.andi.alquran.p025b.C0879b;
import com.andi.alquran.p032j.C0943e;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import java.util.Locale;

public class ActivityPTimeQibla extends AppCompatActivity implements SensorListener {
    public static double f1291a;
    private SensorManager f1292b;
    private int f1293c;
    private C0893a f1294d;
    private SharedPreferences f1295e;
    private SharedPreferences f1296f;
    private InterstitialAd f1297g;

    /* renamed from: com.andi.alquran.ActivityPTimeQibla.1 */
    class C07861 implements OnClickListener {
        final /* synthetic */ ActivityPTimeQibla f1290a;

        C07861(ActivityPTimeQibla activityPTimeQibla) {
            this.f1290a = activityPTimeQibla;
        }

        public void onClick(View view) {
            this.f1290a.startActivity(new Intent(this.f1290a, ActivityPTimeMapDistance.class));
        }
    }

    public ActivityPTimeQibla() {
        this.f1293c = 1;
        this.f1297g = null;
    }

    private String m2691a(double d, double d2) {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objArr = new Object[]{Double.valueOf(C0943e.m3279a(d, d2))};
        return getString(C0861R.string.qibla_distance, new Object[]{stringBuilder.append(String.format(Locale.getDefault(), "%.0f", objArr)).append(" KM").toString()});
    }

    private void m2692a() {
        if (this.f1297g != null && this.f1297g.isLoaded()) {
            this.f1297g.show();
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = this.f1296f.edit();
            edit.putLong(C0879b.f1647d, currentTimeMillis);
            edit.apply();
        }
    }

    protected double m2693a(double d, double d2, double d3, double d4) {
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d3);
        double toRadians3 = Math.toRadians(d4 - d2);
        return (Math.toDegrees(Math.atan2(Math.sin(toRadians3) * Math.cos(toRadians2), (Math.cos(toRadians) * Math.sin(toRadians2)) - ((Math.sin(toRadians) * Math.cos(toRadians2)) * Math.cos(toRadians3)))) + 360.0d) % 360.0d;
    }

    public void onAccuracyChanged(int i, int i2) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_qibla);
        App app = (App) getApplication();
        app.f1450b.m3067a(this);
        LayoutParams attributes = getWindow().getAttributes();
        if (app.f1450b.f1668g) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(C0861R.string.activity_title_qibla));
        }
        this.f1295e = getSharedPreferences("prayer_time_by_andi", 0);
        this.f1296f = getSharedPreferences(C0879b.f1644a, 0);
        TextView textView = (TextView) findViewById(C0861R.id.cityNameQibla);
        TextView textView2 = (TextView) findViewById(C0861R.id.countryNameQibla);
        TextView textView3 = (TextView) findViewById(C0861R.id.distanceKabah);
        TextView textView4 = (TextView) findViewById(C0861R.id.degreeKabah);
        double a = App.m2856a(this.f1295e, "latitude", 0.0d);
        double a2 = App.m2856a(this.f1295e, "longitude", 0.0d);
        String string = this.f1295e.getString("cityName", BuildConfig.VERSION_NAME);
        String string2 = this.f1295e.getString("subStateName", BuildConfig.VERSION_NAME);
        CharSequence string3 = this.f1295e.getString("countryName", BuildConfig.VERSION_NAME);
        textView.setText(string + (!string2.equals(BuildConfig.VERSION_NAME) ? ", " + string2 : BuildConfig.VERSION_NAME));
        if (string3.equals(BuildConfig.VERSION_NAME)) {
            textView2.setVisibility(4);
        } else {
            textView2.setVisibility(0);
            textView2.setText(string3);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C0861R.id.containerCompass);
        relativeLayout.setOnClickListener(new C07861(this));
        f1291a = m2693a(a, a2, 21.42242d, 39.8261239d);
        this.f1294d = new C0893a(this);
        relativeLayout.addView(this.f1294d);
        this.f1294d.invalidate();
        this.f1292b = (SensorManager) getSystemService("sensor");
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objArr = new Object[]{Double.valueOf(f1291a)};
        textView4.setText(getString(C0861R.string.qibla_degree, new Object[]{stringBuilder.append(String.format(Locale.ENGLISH, "%.2f", objArr)).append('\u00b0').toString()}));
        textView3.setText(m2691a(a, a2));
        if (!App.m2897v() && this.f1296f.getLong(C0879b.f1647d, 0) + ((long) ((C0879b.f1648e * 60) * 1000)) < System.currentTimeMillis()) {
            this.f1297g = new InterstitialAd(this);
            this.f1297g.setAdUnitId(App.m2895t());
            this.f1297g.loadAd(new Builder().build());
        }
    }

    public void onDestroy() {
        m2692a();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onPause() {
        super.onPause();
        this.f1292b.unregisterListener(this);
    }

    public void onResume() {
        super.onResume();
        this.f1292b.registerListener(this, this.f1293c);
        if (this.f1295e == null) {
            this.f1295e = getSharedPreferences("prayer_time_by_andi", 0);
        }
    }

    public void onSensorChanged(int i, float[] fArr) {
        if (i == this.f1293c) {
            int i2 = (int) fArr[0];
            this.f1294d.m3107a((float) i2, (float) i2);
        }
    }
}
