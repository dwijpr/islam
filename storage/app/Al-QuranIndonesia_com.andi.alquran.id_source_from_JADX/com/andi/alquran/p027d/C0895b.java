package com.andi.alquran.p027d;

import android.app.AlarmManager;
import android.app.AlarmManager.AlarmClockInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.andi.alquran.App;
import com.andi.alquran.broadcasts.AlarmReceiver;
import com.andi.alquran.p028g.C0915a;
import com.andi.alquran.p032j.C0950i;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.andi.alquran.d.b */
public class C0895b {
    public static void m3110a(Context context) {
        boolean z = context.getSharedPreferences("prayer_time_by_andi", 0).getBoolean("forcingNotifLollipop", true);
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
        gregorianCalendar.set(11, 23);
        gregorianCalendar.set(12, 59);
        gregorianCalendar.set(13, 59);
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.setAction(App.f1447a + "_ACTION_BASE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 354, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompatApi24.CATEGORY_ALARM);
        alarmManager.cancel(broadcast);
        if (VERSION.SDK_INT < 21) {
            alarmManager.set(0, gregorianCalendar.getTimeInMillis(), broadcast);
        } else if (z) {
            alarmManager.setAlarmClock(new AlarmClockInfo(gregorianCalendar.getTimeInMillis(), broadcast), broadcast);
        } else {
            alarmManager.set(0, gregorianCalendar.getTimeInMillis(), broadcast);
        }
    }

    public static void m3111b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("prayer_time_by_andi", 0);
        C0950i c0950i = new C0950i(App.m2868b(sharedPreferences, "typeCalc", 0), App.m2868b(sharedPreferences, "typeJuristic", 0), App.m2868b(sharedPreferences, "typeTimeFormat", 0), App.m2868b(sharedPreferences, "typeAdjustHighLat", 3));
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        int floor = (int) Math.floor(Double.parseDouble(new SimpleDateFormat("Z", Locale.getDefault()).format(instance.getTime())) / 100.0d);
        double a = App.m2856a(sharedPreferences, "latitude", 0.0d);
        double a2 = App.m2856a(sharedPreferences, "longitude", 0.0d);
        boolean z = sharedPreferences.getBoolean("forcingNotifLollipop", true);
        ArrayList a3 = c0950i.m3305a(sharedPreferences, instance, a, a2, (double) floor);
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
        Iterator it = a3.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            C0915a c0915a = (C0915a) it.next();
            int i3 = gregorianCalendar.get(11);
            int i4 = gregorianCalendar.get(12);
            switch (c0915a.m3196e()) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    i2 = sharedPreferences.getInt("typeNotificationImsak", 4);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    i2 = sharedPreferences.getInt("typeNotificationSubuh", 4);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    i2 = sharedPreferences.getInt("typeNotificationTerbit", 4);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i2 = sharedPreferences.getInt("typeNotificationDzuhur", 4);
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    i2 = sharedPreferences.getInt("typeNotificationAshar", 4);
                    break;
                case C1096c.MapAttrs_liteMode /*6*/:
                    i2 = sharedPreferences.getInt("typeNotificationMaghrib", 4);
                    break;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    i2 = sharedPreferences.getInt("typeNotificationIsya", 4);
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (i2 != 4) {
                i = true;
            }
            if (c0915a.m3193b() > i3 || (c0915a.m3193b() == i3 && c0915a.m3194c() > i4)) {
                instance.set(11, c0915a.m3193b());
                instance.set(12, c0915a.m3194c());
                instance.set(13, 0);
                Intent intent = new Intent(context, AlarmReceiver.class);
                intent.setAction(App.f1447a + "_ACTION_PRAYER");
                intent.putExtra("PrayerId", c0915a.m3196e());
                intent.putExtra("PrayerName", c0915a.m3190a());
                intent.putExtra("PrayerTime", c0915a.m3197f());
                intent.putExtra("PrayerHour", c0915a.m3193b());
                intent.putExtra("PrayerMinute", c0915a.m3194c());
                PendingIntent broadcast = PendingIntent.getBroadcast(context, c0915a.m3196e() + 123, intent, 134217728);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompatApi24.CATEGORY_ALARM);
                alarmManager.cancel(broadcast);
                if (i2 == 4) {
                    alarmManager.cancel(broadcast);
                } else if (VERSION.SDK_INT < 21) {
                    alarmManager.set(0, instance.getTimeInMillis(), broadcast);
                } else if (z) {
                    alarmManager.setAlarmClock(new AlarmClockInfo(instance.getTimeInMillis(), broadcast), broadcast);
                } else {
                    alarmManager.set(0, instance.getTimeInMillis(), broadcast);
                }
            }
        }
        if (i != 0) {
            C0895b.m3110a(context);
        } else {
            C0895b.m3112c(context);
        }
    }

    private static void m3112c(Context context) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.setAction(App.f1447a + "_ACTION_BASE");
        ((AlarmManager) context.getSystemService(NotificationCompatApi24.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(context, 354, intent, 134217728));
    }
}
