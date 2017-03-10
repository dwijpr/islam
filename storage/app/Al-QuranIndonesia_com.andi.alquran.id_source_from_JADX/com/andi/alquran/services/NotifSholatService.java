package com.andi.alquran.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v7.app.NotificationCompat.Builder;
import android.support.v7.app.NotificationCompat.MediaStyle;
import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.ActivityPTime;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p032j.C0948h;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class NotifSholatService extends Service {
    public static boolean f1957a;
    public static String f1958b;
    public BroadcastReceiver f1959c;
    private MediaPlayer f1960d;
    private String f1961e;
    private String f1962f;
    private int f1963g;
    private int f1964h;
    private AudioManager f1965i;
    private int f1966j;

    /* renamed from: com.andi.alquran.services.NotifSholatService.1 */
    class C09641 implements OnCompletionListener {
        final /* synthetic */ NotifSholatService f1955a;

        C09641(NotifSholatService notifSholatService) {
            this.f1955a = notifSholatService;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f1955a.m3360c();
        }
    }

    /* renamed from: com.andi.alquran.services.NotifSholatService.2 */
    class C09652 extends BroadcastReceiver {
        final /* synthetic */ NotifSholatService f1956a;

        C09652(NotifSholatService notifSholatService) {
            this.f1956a = notifSholatService;
        }

        public void onReceive(Context context, Intent intent) {
            this.f1956a.m3361d();
        }
    }

    static {
        f1957a = false;
        f1958b = "qINScom.andi.alquran.id";
    }

    public NotifSholatService() {
        this.f1961e = BuildConfig.VERSION_NAME;
        this.f1962f = BuildConfig.VERSION_NAME;
        this.f1963g = 1;
        this.f1964h = 0;
        this.f1965i = null;
        this.f1966j = 0;
        this.f1959c = new C09652(this);
    }

    private void m3356a() {
        Intent intent = new Intent(App.m2860a(), ActivityPTime.class);
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(App.m2860a(), 0, intent, 134217728);
        Builder builder = new Builder(App.m2860a());
        builder.setContentIntent(activity);
        builder.setContentTitle(this.f1961e);
        builder.setContentText(this.f1962f);
        builder.setSmallIcon(C0861R.drawable.ic_notif_alarm);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), C0861R.drawable.ic_launcher));
        builder.setShowWhen(false);
        builder.setAutoCancel(false);
        builder.setOngoing(true);
        builder.addAction(new Action.Builder(C0861R.drawable.ic_action_stop, getString(C0861R.string.stop), PendingIntent.getBroadcast(this, 0, new Intent(f1958b), 0)).build());
        builder.setStyle(new MediaStyle().setShowActionsInCompactView(0));
        C0948h.m3286a();
        startForeground(this.f1963g, builder.build());
    }

    private void m3358b() {
        Intent intent = new Intent(App.m2860a(), ActivityPTime.class);
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(App.m2860a(), 0, intent, 134217728);
        Builder builder = new Builder(App.m2860a());
        builder.setContentIntent(activity);
        builder.setContentTitle(this.f1961e);
        builder.setContentText(this.f1962f);
        builder.setSmallIcon(C0861R.drawable.ic_notif_alarm);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), C0861R.drawable.ic_launcher));
        builder.setShowWhen(false);
        builder.setAutoCancel(true);
        builder.setOngoing(false);
        if (this.f1964h == 1) {
            builder.setSound(RingtoneManager.getDefaultUri(4));
        } else if (this.f1964h == 2) {
            builder.setSound(RingtoneManager.getDefaultUri(2));
        }
        ((NotificationManager) getSystemService("notification")).notify(this.f1963g, builder.build());
        stopSelf();
    }

    private void m3360c() {
        if (this.f1965i != null) {
            this.f1965i.setStreamVolume(3, this.f1966j, 0);
        }
        if (f1957a && this.f1960d != null && this.f1960d.isPlaying()) {
            this.f1960d.stop();
        }
        f1957a = false;
        stopForeground(true);
        m3358b();
    }

    private void m3361d() {
        if (this.f1965i != null) {
            this.f1965i.setStreamVolume(3, this.f1966j, 0);
        }
        if (f1957a && this.f1960d != null && this.f1960d.isPlaying()) {
            this.f1960d.stop();
        }
        f1957a = false;
        C0948h.m3286a();
        stopSelf();
    }

    void m3362a(Intent intent, int i) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("id", 0);
            String stringExtra = intent.getStringExtra("title");
            String stringExtra2 = intent.getStringExtra("desc");
            int intExtra2 = intent.getIntExtra("typeAlarm", 0);
            int intExtra3 = intent.getIntExtra("prayerHour", 0);
            int intExtra4 = intent.getIntExtra("prayerMinute", 0);
            Calendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
            if (intExtra3 == gregorianCalendar.get(11) && intExtra4 == gregorianCalendar.get(12)) {
                this.f1963g = intExtra;
                this.f1961e = stringExtra;
                this.f1962f = stringExtra2;
                this.f1964h = intExtra2;
                if (this.f1964h == 0) {
                    int i2 = getSharedPreferences("prayer_time_by_andi", 0).getInt("volumeAdzan", 60);
                    this.f1965i = (AudioManager) getSystemService("audio");
                    this.f1966j = this.f1965i.getStreamVolume(3);
                    this.f1965i.setStreamVolume(3, (this.f1965i.getStreamMaxVolume(3) * i2) / 100, 0);
                    this.f1960d = MediaPlayer.create(this, intExtra == 2 ? Uri.parse("android.resource://com.andi.alquran.id/2131230721") : Uri.parse("android.resource://com.andi.alquran.id/2131230720"));
                    this.f1960d.setOnCompletionListener(new C09641(this));
                    this.f1960d.start();
                    f1957a = true;
                    m3356a();
                    return;
                }
                m3358b();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (this.f1959c != null) {
            registerReceiver(this.f1959c, new IntentFilter(f1958b));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f1959c);
    }

    public void onStart(Intent intent, int i) {
        m3362a(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m3362a(intent, i2);
        return 3;
    }
}
