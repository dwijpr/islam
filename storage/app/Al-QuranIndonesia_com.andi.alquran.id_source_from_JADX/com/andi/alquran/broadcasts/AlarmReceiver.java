package com.andi.alquran.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p027d.C0894a;
import com.andi.alquran.p027d.C0895b;
import com.andi.alquran.p032j.C0948h;
import com.andi.alquran.services.NotifSholatService;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AlarmReceiver extends BroadcastReceiver {
    private Context f1701a;

    private void m3069a(Intent intent) {
        String stringExtra = intent.getStringExtra("PrayerName");
        String stringExtra2 = intent.getStringExtra("PrayerTime");
        int intExtra = intent.getIntExtra("PrayerId", 0);
        int intExtra2 = intent.getIntExtra("PrayerHour", 0);
        int intExtra3 = intent.getIntExtra("PrayerMinute", 0);
        SharedPreferences sharedPreferences = this.f1701a.getSharedPreferences("prayer_time_by_andi", 0);
        int i = 0;
        switch (intExtra) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                i = sharedPreferences.getInt("typeNotificationImsak", 4);
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                i = sharedPreferences.getInt("typeNotificationSubuh", 4);
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                i = sharedPreferences.getInt("typeNotificationTerbit", 4);
                break;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                i = sharedPreferences.getInt("typeNotificationDzuhur", 4);
                break;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                i = sharedPreferences.getInt("typeNotificationAshar", 4);
                break;
            case C1096c.MapAttrs_liteMode /*6*/:
                i = sharedPreferences.getInt("typeNotificationMaghrib", 4);
                break;
            case C1096c.MapAttrs_uiCompass /*7*/:
                i = sharedPreferences.getInt("typeNotificationIsya", 4);
                break;
        }
        double a = App.m2856a(sharedPreferences, "latitude", 0.0d);
        double a2 = App.m2856a(sharedPreferences, "longitude", 0.0d);
        String string = sharedPreferences.getString("cityName", BuildConfig.VERSION_NAME);
        if (a != 0.0d && a2 != 0.0d && !string.equals(BuildConfig.VERSION_NAME) && i != 4) {
            Calendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
            if (intExtra2 == gregorianCalendar.get(11) && intExtra3 == gregorianCalendar.get(12)) {
                int i2 = gregorianCalendar.get(7);
                boolean z = sharedPreferences.getBoolean("disableJumat", true);
                if (i2 != 6 || !z || intExtra != 4) {
                    if (App.m2868b(sharedPreferences, "typeTimeFormat", 0) == 1) {
                        stringExtra2 = C0894a.m3108a(intExtra2, intExtra3);
                    }
                    string = this.f1701a.getString(C0861R.string.msg_notif_alarm_title, new Object[]{stringExtra});
                    String string2 = this.f1701a.getString(C0861R.string.msg_notif_alarm_desc, new Object[]{stringExtra2, stringExtra});
                    if (intExtra == 1 || intExtra == 3) {
                        string2 = this.f1701a.getString(C0861R.string.msg_notif_alarm_imsak_title, new Object[]{stringExtra});
                        stringExtra2 = this.f1701a.getString(C0861R.string.msg_notif_alarm_imsak_desc, new Object[]{stringExtra2, stringExtra});
                    } else {
                        stringExtra2 = string2;
                        string2 = string;
                    }
                    Intent intent2 = new Intent(this.f1701a, NotifSholatService.class);
                    intent2.putExtra("id", intExtra);
                    intent2.putExtra("title", string2);
                    intent2.putExtra("desc", stringExtra2);
                    intent2.putExtra("typeAlarm", i);
                    intent2.putExtra("prayerHour", intExtra2);
                    intent2.putExtra("prayerMinute", intExtra3);
                    this.f1701a.startService(intent2);
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f1701a = context;
        C0948h.m3287a(context);
        if (intent.getAction().equals(App.f1447a + "_ACTION_BASE") || intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            C0895b.m3111b(context);
        } else if (intent.getAction().equals(App.f1447a + "_ACTION_PRAYER")) {
            m3069a(intent);
        } else if (intent.getAction().equals("android.intent.action.TIME_SET")) {
            C0895b.m3111b(context);
        } else if (intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
            C0895b.m3111b(context);
        }
    }
}
