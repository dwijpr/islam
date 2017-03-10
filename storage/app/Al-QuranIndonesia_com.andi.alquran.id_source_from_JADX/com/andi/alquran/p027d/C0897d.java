package com.andi.alquran.p027d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.recyclerview.BuildConfig;
import java.util.List;
import java.util.Locale;

/* renamed from: com.andi.alquran.d.d */
public class C0897d {
    public static String m3114a(Context context, double d, double d2) {
        try {
            List fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(d, d2, 1);
            if (fromLocation.size() > 0) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("prayer_time_by_andi", 0);
                String locality = ((Address) fromLocation.get(0)).getLocality() != null ? ((Address) fromLocation.get(0)).getLocality() : ((Address) fromLocation.get(0)).getFeatureName();
                String subAdminArea = ((Address) fromLocation.get(0)).getSubAdminArea();
                String adminArea = ((Address) fromLocation.get(0)).getAdminArea();
                String countryName = ((Address) fromLocation.get(0)).getCountryName();
                String countryCode = ((Address) fromLocation.get(0)).getCountryCode();
                if (subAdminArea == null || subAdminArea.equals(BuildConfig.VERSION_NAME)) {
                    subAdminArea = adminArea;
                }
                if (locality.equals(countryName)) {
                    countryName = BuildConfig.VERSION_NAME;
                }
                Editor edit = sharedPreferences.edit();
                edit.putString("cityName", locality);
                String str = "subStateName";
                if (subAdminArea == null) {
                    subAdminArea = BuildConfig.VERSION_NAME;
                }
                edit.putString(str, subAdminArea);
                subAdminArea = "countryName";
                if (countryName == null) {
                    countryName = BuildConfig.VERSION_NAME;
                }
                edit.putString(subAdminArea, countryName);
                countryName = "countryCode";
                if (countryCode == null) {
                    countryCode = BuildConfig.VERSION_NAME;
                }
                edit.putString(countryName, countryCode);
                edit.apply();
                return locality;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BuildConfig.VERSION_NAME;
    }
}
