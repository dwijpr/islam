package com.andi.alquran;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.recyclerview.BuildConfig;
import android.view.MenuItem;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.andi.alquran.p032j.C0943e;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Locale;

public class ActivityPTimeMapDistance extends AppCompatActivity implements OnMapReadyCallback {
    private double f1285a;
    private double f1286b;
    private String f1287c;
    private GoogleMap f1288d;
    private CameraPosition f1289e;

    /* renamed from: com.andi.alquran.ActivityPTimeMapDistance.1 */
    class C07851 implements OnCameraIdleListener {
        final /* synthetic */ ActivityPTimeMapDistance f1284a;

        C07851(ActivityPTimeMapDistance activityPTimeMapDistance) {
            this.f1284a = activityPTimeMapDistance;
        }

        public void onCameraIdle() {
            CameraPosition cameraPosition = this.f1284a.f1288d.getCameraPosition();
            if (this.f1284a.f1289e == null || this.f1284a.f1289e.zoom != cameraPosition.zoom) {
                this.f1284a.f1289e = this.f1284a.f1288d.getCameraPosition();
                if (this.f1284a.f1289e.zoom > 16.5f) {
                    this.f1284a.f1288d.animateCamera(CameraUpdateFactory.zoomTo(16.5f));
                }
            }
        }
    }

    public ActivityPTimeMapDistance() {
        this.f1289e = null;
    }

    private String m2689a(double d, double d2) {
        return String.format(Locale.getDefault(), "%.0f", new Object[]{Double.valueOf(C0943e.m3279a(d, d2))}) + " KM";
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_maps_distance);
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
        TextView textView = (TextView) findViewById(C0861R.id.distanceInfo);
        SharedPreferences sharedPreferences = getSharedPreferences("prayer_time_by_andi", 0);
        this.f1286b = App.m2856a(sharedPreferences, "latitude", 0.0d);
        this.f1285a = App.m2856a(sharedPreferences, "longitude", 0.0d);
        this.f1287c = sharedPreferences.getString("cityName", BuildConfig.VERSION_NAME);
        if (this.f1287c.equals(BuildConfig.VERSION_NAME)) {
            this.f1287c = "My Location";
        }
        String str = this.f1287c;
        String string = sharedPreferences.getString("subStateName", BuildConfig.VERSION_NAME);
        String string2 = sharedPreferences.getString("countryName", BuildConfig.VERSION_NAME);
        if (!string.equals(BuildConfig.VERSION_NAME)) {
            str = str + ", " + string;
        }
        if (!string2.equals(BuildConfig.VERSION_NAME)) {
            str = str + " - " + string2;
        }
        textView.setText(getString(C0861R.string.qibla_distance_second, new Object[]{m2689a(this.f1286b, this.f1285a), str}));
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0861R.id.map)).getMapAsync(this);
        if (!App.m2881f()) {
            App.m2865a(getString(C0861R.string.msg_no_internet_location));
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        this.f1288d = googleMap;
        MarkerOptions markerOptions = new MarkerOptions();
        LatLng latLng = new LatLng(this.f1286b, this.f1285a);
        markerOptions.position(latLng);
        markerOptions.draggable(false);
        this.f1288d.addMarker(markerOptions).setTitle(this.f1287c);
        markerOptions = new MarkerOptions();
        LatLng latLng2 = new LatLng(21.42242d, 39.8261239d);
        markerOptions.position(latLng2);
        markerOptions.draggable(false);
        Marker addMarker = this.f1288d.addMarker(markerOptions);
        addMarker.setTitle(getString(C0861R.string.kaaba));
        this.f1288d.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 1.0f));
        this.f1288d.getUiSettings().setMapToolbarEnabled(false);
        this.f1288d.getUiSettings().setCompassEnabled(true);
        this.f1288d.addPolyline(new PolylineOptions().geodesic(true).add(latLng).add(latLng2).color(-65536));
        this.f1288d.setOnCameraIdleListener(new C07851(this));
        addMarker.showInfoWindow();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
