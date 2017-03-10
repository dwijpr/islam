package com.andi.alquran.p027d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.andi.alquran.p032j.C0940b;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.andi.alquran.d.c */
public class C0896c {
    public static String m3113a(Context context, double d, double d2) {
        String str = BuildConfig.VERSION_NAME;
        String str2 = BuildConfig.VERSION_NAME;
        String str3 = BuildConfig.VERSION_NAME;
        String str4 = BuildConfig.VERSION_NAME;
        String str5 = BuildConfig.VERSION_NAME;
        String str6 = BuildConfig.VERSION_NAME;
        String str7 = BuildConfig.VERSION_NAME;
        String str8 = BuildConfig.VERSION_NAME;
        SharedPreferences sharedPreferences = context.getSharedPreferences("prayer_time_by_andi", 0);
        try {
            str8 = new C0940b().m3275a("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + d + "," + d2 + "&sensor=false");
            if (str8 == null) {
                return str7;
            }
            JSONObject jSONObject = new JSONObject(str8);
            if (!jSONObject.getString(NotificationCompatApi24.CATEGORY_STATUS).equalsIgnoreCase("OK")) {
                return str7;
            }
            JSONArray jSONArray;
            JSONObject jSONObject2;
            String string;
            String str9;
            int i;
            Editor edit;
            JSONArray jSONArray2 = jSONObject.getJSONArray("results");
            if (jSONArray2.length() >= 2 && jSONArray2.getJSONObject(2) != null && jSONArray2.getJSONObject(2).length() > 0) {
                jSONArray = jSONArray2.getJSONObject(2).getJSONArray("address_components");
                if (jSONArray != null) {
                    str7 = str;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        jSONObject2 = jSONArray.getJSONObject(i2);
                        str = jSONObject2.getString("long_name");
                        string = jSONObject2.getJSONArray("types").getString(0);
                        if (!(TextUtils.isEmpty(str) && str.equals(BuildConfig.VERSION_NAME) && str.length() <= 0 && str == null) && string.equalsIgnoreCase("administrative_area_level_3")) {
                            str7 = str;
                        }
                    }
                    if (jSONArray2.getJSONObject(0) != null && jSONArray2.getJSONObject(0).length() > 0) {
                        jSONArray = jSONArray2.getJSONObject(0).getJSONArray("address_components");
                        if (jSONArray != null) {
                            str9 = str6;
                            str6 = str2;
                            str2 = str7;
                            str7 = str9;
                            for (i = 0; i < jSONArray.length(); i++) {
                                jSONObject2 = jSONArray.getJSONObject(i);
                                str8 = jSONObject2.getString("long_name");
                                str = jSONObject2.getString("short_name");
                                string = jSONObject2.getJSONArray("types").getString(0);
                                if (!(TextUtils.isEmpty(str8) && str8.equals(BuildConfig.VERSION_NAME) && str8.length() <= 0 && str8 == null)) {
                                    if (str2 != null && string.equalsIgnoreCase("administrative_area_level_3")) {
                                        str2 = str8;
                                    }
                                    if (string.equalsIgnoreCase("locality")) {
                                        str6 = str8;
                                    }
                                    if (string.equalsIgnoreCase("administrative_area_level_2")) {
                                        str3 = str8;
                                    }
                                    if (string.equalsIgnoreCase("administrative_area_level_1")) {
                                        str4 = str8;
                                    }
                                    if (string.equalsIgnoreCase("country")) {
                                        str5 = str8;
                                    }
                                }
                                if (!(TextUtils.isEmpty(str) && str.equals(BuildConfig.VERSION_NAME) && str.length() <= 0 && str == null) && string.equalsIgnoreCase("country")) {
                                    str7 = str;
                                }
                            }
                            str = str3;
                            str3 = str2;
                            str9 = str7;
                            str7 = str4;
                            str4 = str6;
                            str6 = str9;
                            if (!str.equals(BuildConfig.VERSION_NAME) || str == null) {
                                if (str7 == null) {
                                    str7 = BuildConfig.VERSION_NAME;
                                }
                                str = str7;
                            } else {
                                str = str != null ? str : BuildConfig.VERSION_NAME;
                            }
                            if (str3.equals(BuildConfig.VERSION_NAME) && str3 != null) {
                                str7 = str3 != null ? str3 : BuildConfig.VERSION_NAME;
                                str4 = str;
                                str = str5;
                            } else if (!str4.equals(BuildConfig.VERSION_NAME) || str4 == null) {
                                str7 = str == null ? str : BuildConfig.VERSION_NAME;
                                str4 = BuildConfig.VERSION_NAME;
                                if (str7.equals(BuildConfig.VERSION_NAME)) {
                                    str = str5;
                                } else {
                                    str7 = str5 == null ? str5 : BuildConfig.VERSION_NAME;
                                    str = BuildConfig.VERSION_NAME;
                                }
                            } else {
                                str7 = str4 != null ? str4 : BuildConfig.VERSION_NAME;
                                str4 = str;
                                str = str5;
                            }
                            edit = sharedPreferences.edit();
                            edit.putString("cityName", str7);
                            str5 = "subStateName";
                            if (str4 == null) {
                                str4 = BuildConfig.VERSION_NAME;
                            }
                            edit.putString(str5, str4);
                            str4 = "countryName";
                            if (str == null) {
                                str = BuildConfig.VERSION_NAME;
                            }
                            edit.putString(str4, str);
                            edit.putString("countryCode", str6 == null ? str6 : BuildConfig.VERSION_NAME);
                            edit.apply();
                            return str7;
                        }
                    }
                    str = str3;
                    str3 = str7;
                    str7 = str4;
                    str4 = str2;
                    if (str.equals(BuildConfig.VERSION_NAME)) {
                    }
                    if (str7 == null) {
                        str7 = BuildConfig.VERSION_NAME;
                    }
                    str = str7;
                    if (str3.equals(BuildConfig.VERSION_NAME)) {
                    }
                    if (str4.equals(BuildConfig.VERSION_NAME)) {
                    }
                    if (str == null) {
                    }
                    str4 = BuildConfig.VERSION_NAME;
                    if (str7.equals(BuildConfig.VERSION_NAME)) {
                        str = str5;
                    } else {
                        if (str5 == null) {
                        }
                        str = BuildConfig.VERSION_NAME;
                    }
                    edit = sharedPreferences.edit();
                    edit.putString("cityName", str7);
                    str5 = "subStateName";
                    if (str4 == null) {
                        str4 = BuildConfig.VERSION_NAME;
                    }
                    edit.putString(str5, str4);
                    str4 = "countryName";
                    if (str == null) {
                        str = BuildConfig.VERSION_NAME;
                    }
                    edit.putString(str4, str);
                    if (str6 == null) {
                    }
                    edit.putString("countryCode", str6 == null ? str6 : BuildConfig.VERSION_NAME);
                    edit.apply();
                    return str7;
                }
            }
            str7 = str;
            jSONArray = jSONArray2.getJSONObject(0).getJSONArray("address_components");
            if (jSONArray != null) {
                str9 = str6;
                str6 = str2;
                str2 = str7;
                str7 = str9;
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject2 = jSONArray.getJSONObject(i);
                    str8 = jSONObject2.getString("long_name");
                    str = jSONObject2.getString("short_name");
                    string = jSONObject2.getJSONArray("types").getString(0);
                    str2 = str8;
                    if (string.equalsIgnoreCase("locality")) {
                        str6 = str8;
                    }
                    if (string.equalsIgnoreCase("administrative_area_level_2")) {
                        str3 = str8;
                    }
                    if (string.equalsIgnoreCase("administrative_area_level_1")) {
                        str4 = str8;
                    }
                    if (string.equalsIgnoreCase("country")) {
                        str5 = str8;
                    }
                    str7 = str;
                }
                str = str3;
                str3 = str2;
                str9 = str7;
                str7 = str4;
                str4 = str6;
                str6 = str9;
                if (str.equals(BuildConfig.VERSION_NAME)) {
                }
                if (str7 == null) {
                    str7 = BuildConfig.VERSION_NAME;
                }
                str = str7;
                if (str3.equals(BuildConfig.VERSION_NAME)) {
                }
                if (str4.equals(BuildConfig.VERSION_NAME)) {
                }
                if (str == null) {
                }
                str4 = BuildConfig.VERSION_NAME;
                if (str7.equals(BuildConfig.VERSION_NAME)) {
                    if (str5 == null) {
                    }
                    str = BuildConfig.VERSION_NAME;
                } else {
                    str = str5;
                }
                edit = sharedPreferences.edit();
                edit.putString("cityName", str7);
                str5 = "subStateName";
                if (str4 == null) {
                    str4 = BuildConfig.VERSION_NAME;
                }
                edit.putString(str5, str4);
                str4 = "countryName";
                if (str == null) {
                    str = BuildConfig.VERSION_NAME;
                }
                edit.putString(str4, str);
                if (str6 == null) {
                }
                edit.putString("countryCode", str6 == null ? str6 : BuildConfig.VERSION_NAME);
                edit.apply();
                return str7;
            }
            str = str3;
            str3 = str7;
            str7 = str4;
            str4 = str2;
            if (str.equals(BuildConfig.VERSION_NAME)) {
            }
            if (str7 == null) {
                str7 = BuildConfig.VERSION_NAME;
            }
            str = str7;
            if (str3.equals(BuildConfig.VERSION_NAME)) {
            }
            if (str4.equals(BuildConfig.VERSION_NAME)) {
            }
            if (str == null) {
            }
            str4 = BuildConfig.VERSION_NAME;
            if (str7.equals(BuildConfig.VERSION_NAME)) {
                str = str5;
            } else {
                if (str5 == null) {
                }
                str = BuildConfig.VERSION_NAME;
            }
            edit = sharedPreferences.edit();
            edit.putString("cityName", str7);
            str5 = "subStateName";
            if (str4 == null) {
                str4 = BuildConfig.VERSION_NAME;
            }
            edit.putString(str5, str4);
            str4 = "countryName";
            if (str == null) {
                str = BuildConfig.VERSION_NAME;
            }
            edit.putString(str4, str);
            if (str6 == null) {
            }
            edit.putString("countryCode", str6 == null ? str6 : BuildConfig.VERSION_NAME);
            edit.apply();
            return str7;
        } catch (Exception e) {
            return BuildConfig.VERSION_NAME;
        }
    }
}
