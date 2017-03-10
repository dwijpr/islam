package com.andi.alquran;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.p009b.C0173a;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.recyclerview.BuildConfig;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.andi.alquran.p022f.C0775c;
import com.andi.alquran.p022f.C0776d;
import com.andi.alquran.p027d.C0895b;
import com.andi.alquran.p031i.C0928e;
import com.andi.alquran.p031i.C0929f;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import java.util.Locale;

public class ActivityPTimeMapChooseCity extends AppCompatActivity implements C0775c, C0776d, OnMapReadyCallback {
    private Context f1276a;
    private SharedPreferences f1277b;
    private ProgressDialog f1278c;
    private double f1279d;
    private double f1280e;
    private GoogleMap f1281f;
    private RelativeLayout f1282g;
    private TextView f1283h;

    /* renamed from: com.andi.alquran.ActivityPTimeMapChooseCity.1 */
    class C07801 implements OnClickListener {
        final /* synthetic */ ActivityPTimeMapChooseCity f1271a;

        C07801(ActivityPTimeMapChooseCity activityPTimeMapChooseCity) {
            this.f1271a = activityPTimeMapChooseCity;
        }

        public void onClick(View view) {
            this.f1271a.m2680b();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeMapChooseCity.2 */
    class C07812 implements OnMyLocationButtonClickListener {
        final /* synthetic */ ActivityPTimeMapChooseCity f1272a;

        C07812(ActivityPTimeMapChooseCity activityPTimeMapChooseCity) {
            this.f1272a = activityPTimeMapChooseCity;
        }

        public boolean onMyLocationButtonClick() {
            LocationManager locationManager = (LocationManager) this.f1272a.f1276a.getSystemService("location");
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
            if (!(isProviderEnabled || isProviderEnabled2)) {
                App.m2871b(this.f1272a.getString(C0861R.string.msg_gps_cannot_get_location));
            }
            return false;
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeMapChooseCity.3 */
    class C07823 implements OnCameraIdleListener {
        final /* synthetic */ ActivityPTimeMapChooseCity f1273a;

        C07823(ActivityPTimeMapChooseCity activityPTimeMapChooseCity) {
            this.f1273a = activityPTimeMapChooseCity;
        }

        public void onCameraIdle() {
            this.f1273a.m2677a();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeMapChooseCity.4 */
    class C07834 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivityPTimeMapChooseCity f1274a;

        C07834(ActivityPTimeMapChooseCity activityPTimeMapChooseCity) {
            this.f1274a = activityPTimeMapChooseCity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.andi.alquran.ActivityPTimeMapChooseCity.5 */
    class C07845 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivityPTimeMapChooseCity f1275a;

        C07845(ActivityPTimeMapChooseCity activityPTimeMapChooseCity) {
            this.f1275a = activityPTimeMapChooseCity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1275a.m2681c();
        }
    }

    private void m2677a() {
        LatLng latLng = this.f1281f.getCameraPosition().target;
        this.f1280e = latLng.latitude;
        this.f1279d = latLng.longitude;
        this.f1283h.setText(String.format(Locale.getDefault(), "Lat: %.3f, Long: %.3f", new Object[]{Double.valueOf(this.f1280e), Double.valueOf(this.f1279d)}));
        this.f1283h.setVisibility(0);
    }

    private void m2680b() {
        Builder builder = new Builder(this);
        builder.setMessage(getString(C0861R.string.dlg_edit_lokasi_maps_desc)).setTitle(getString(C0861R.string.dlg_edit_lokasi_maps_title)).setIcon((int) C0861R.drawable.ic_ask).setPositiveButton(getString(C0861R.string.yes), new C07845(this)).setNegativeButton(getString(C0861R.string.cancel), new C07834(this));
        builder.create().show();
    }

    private void m2681c() {
        LatLng latLng = this.f1281f.getCameraPosition().target;
        this.f1280e = latLng.latitude;
        this.f1279d = latLng.longitude;
        if (App.m2881f()) {
            this.f1278c = ProgressDialog.show(this, BuildConfig.VERSION_NAME, getString(C0861R.string.msg_loading_get_cityname_from_map), true, true);
            if (Geocoder.isPresent()) {
                new C0929f(this.f1276a, this.f1280e, this.f1279d, this).execute(new Void[0]);
                return;
            } else {
                new C0928e(this.f1276a, this.f1280e, this.f1279d, this).execute(new Void[0]);
                return;
            }
        }
        App.m2865a(getString(C0861R.string.msg_cannot_get_city_no_internet));
    }

    private void m2683c(String str) {
        if (!(((ActivityPTimeMapChooseCity) this.f1276a).isFinishing() || this.f1278c == null || !this.f1278c.isShowing())) {
            this.f1278c.dismiss();
        }
        if (str == null) {
            return;
        }
        if (str.trim().equals(BuildConfig.VERSION_NAME)) {
            App.m2865a(getString(C0861R.string.msg_cannot_get_city_result_error));
            return;
        }
        this.f1277b.edit().putString("longitude", String.valueOf(this.f1279d)).apply();
        this.f1277b.edit().putString("latitude", String.valueOf(this.f1280e)).apply();
        App.m2900y();
        C0895b.m3111b(this.f1276a);
        finish();
    }

    public void m2685a(String str) {
        if (str.trim().equals(BuildConfig.VERSION_NAME)) {
            new C0928e(this.f1276a, this.f1280e, this.f1279d, this).execute(new Void[0]);
        } else {
            m2683c(str);
        }
    }

    public void m2686b(String str) {
        m2683c(str);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_maps);
        this.f1276a = this;
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
        }
        this.f1277b = getSharedPreferences("prayer_time_by_andi", 0);
        this.f1280e = App.m2856a(this.f1277b, "latitude", 0.0d);
        this.f1279d = App.m2856a(this.f1277b, "longitude", 0.0d);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0861R.id.mapChoose)).getMapAsync(this);
        this.f1282g = (RelativeLayout) findViewById(C0861R.id.layoutButtonMaps);
        this.f1283h = (TextView) findViewById(C0861R.id.infoMarker);
        ((Button) findViewById(C0861R.id.mapsButtonSave)).setOnClickListener(new C07801(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!((ActivityPTimeMapChooseCity) this.f1276a).isFinishing() && this.f1278c != null && this.f1278c.isShowing()) {
            this.f1278c.dismiss();
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        this.f1281f = googleMap;
        LatLng latLng = new LatLng(this.f1280e, this.f1279d);
        if (this.f1280e == 0.0d && this.f1279d == 0.0d) {
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(latLng).zoom(1.0f).bearing(0.0f).build()));
        } else {
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(latLng).zoom(15.0f).bearing(0.0f).build()));
        }
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        if (C0173a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 && C0173a.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            googleMap.setMyLocationEnabled(true);
            googleMap.setOnMyLocationButtonClickListener(new C07812(this));
        }
        googleMap.setOnCameraIdleListener(new C07823(this));
        this.f1282g.setVisibility(0);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.f1278c != null && this.f1278c.isShowing()) {
            this.f1278c.dismiss();
        }
        finish();
        return true;
    }
}
