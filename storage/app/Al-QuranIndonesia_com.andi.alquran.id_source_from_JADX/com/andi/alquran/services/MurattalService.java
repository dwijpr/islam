package com.andi.alquran.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v7.app.NotificationCompat.Builder;
import android.support.v7.app.NotificationCompat.MediaStyle;
import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.ActivityQuran;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p025b.C0879b;
import com.andi.alquran.p026c.C0885a;
import com.andi.alquran.p026c.C0885a.C0884b;
import java.io.File;

public class MurattalService extends Service {
    public static MediaPlayer f1948a;
    public static boolean f1949b;
    public static String f1950c;
    public BroadcastReceiver f1951d;
    public BroadcastReceiver f1952e;
    public BroadcastReceiver f1953f;
    public BroadcastReceiver f1954g;

    /* renamed from: com.andi.alquran.services.MurattalService.1 */
    class C09561 extends BroadcastReceiver {
        final /* synthetic */ MurattalService f1942a;

        C09561(MurattalService murattalService) {
            this.f1942a = murattalService;
        }

        public void onReceive(Context context, Intent intent) {
            this.f1942a.m3355i();
        }
    }

    /* renamed from: com.andi.alquran.services.MurattalService.2 */
    class C09572 extends BroadcastReceiver {
        final /* synthetic */ MurattalService f1943a;

        C09572(MurattalService murattalService) {
            this.f1943a = murattalService;
        }

        public void onReceive(Context context, Intent intent) {
            if (MurattalService.f1950c.equals("PLAYING")) {
                MurattalService.m3348b();
                this.f1943a.m3355i();
                return;
            }
            MurattalService.m3346a();
            this.f1943a.m3355i();
        }
    }

    /* renamed from: com.andi.alquran.services.MurattalService.3 */
    class C09583 extends BroadcastReceiver {
        final /* synthetic */ MurattalService f1944a;

        C09583(MurattalService murattalService) {
            this.f1944a = murattalService;
        }

        public void onReceive(Context context, Intent intent) {
            int i;
            int i2 = 1;
            SharedPreferences sharedPreferences = App.m2860a().getSharedPreferences("murattal_audio_by_andi", 0);
            int i3 = sharedPreferences.getInt("suraSelected", 1);
            int i4 = sharedPreferences.getInt("ayaSelected", 1);
            int i5 = i4 - 1;
            if (i4 != 1 || i3 <= 1) {
                i = i3;
            } else {
                C0884b a = new C0885a().m3073a(i3 - 1);
                i = a.f1704a;
                i5 = a.f1706c;
            }
            if (!(i3 == 1 && i4 == 1)) {
                i2 = i5;
            }
            Editor edit = sharedPreferences.edit();
            edit.putInt("suraSelected", i);
            edit.putInt("ayaSelected", i2);
            edit.apply();
            if (MurattalService.f1949b) {
                MurattalService.m3349c();
            }
            MurattalService.m3346a();
            this.f1944a.m3355i();
        }
    }

    /* renamed from: com.andi.alquran.services.MurattalService.4 */
    class C09594 extends BroadcastReceiver {
        final /* synthetic */ MurattalService f1945a;

        C09594(MurattalService murattalService) {
            this.f1945a = murattalService;
        }

        public void onReceive(Context context, Intent intent) {
            int i;
            SharedPreferences sharedPreferences = App.m2860a().getSharedPreferences("murattal_audio_by_andi", 0);
            int i2 = sharedPreferences.getInt("suraSelected", 1);
            int i3 = sharedPreferences.getInt("ayaSelected", 1);
            int i4 = new C0885a().m3073a(i2).f1706c;
            int i5 = i3 + 1;
            if (i4 == i3) {
                if (i2 < C0861R.styleable.AppCompatTheme_listMenuViewStyle) {
                    i2++;
                }
                i = i2;
                i2 = 1;
            } else {
                i = i2;
                i2 = i5;
            }
            Editor edit = sharedPreferences.edit();
            edit.putInt("suraSelected", i);
            edit.putInt("ayaSelected", i2);
            edit.apply();
            if (MurattalService.f1949b) {
                MurattalService.m3349c();
            }
            MurattalService.m3346a();
            this.f1945a.m3355i();
        }
    }

    /* renamed from: com.andi.alquran.services.MurattalService.5 */
    static class C09615 implements OnCompletionListener {
        final /* synthetic */ String f1947a;

        /* renamed from: com.andi.alquran.services.MurattalService.5.1 */
        class C09601 implements OnCompletionListener {
            final /* synthetic */ C09615 f1946a;

            C09601(C09615 c09615) {
                this.f1946a = c09615;
            }

            public void onCompletion(MediaPlayer mediaPlayer) {
                MurattalService.m3351e();
            }
        }

        C09615(String str) {
            this.f1947a = str;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            MurattalService.f1948a = MediaPlayer.create(App.m2860a(), Uri.fromFile(new File(App.m2887l() + this.f1947a)));
            MurattalService.f1948a.setOnCompletionListener(new C09601(this));
            MurattalService.f1948a.start();
            MurattalService.f1949b = true;
            MurattalService.f1950c = "PLAYING";
            MurattalService.m3353g();
        }
    }

    /* renamed from: com.andi.alquran.services.MurattalService.6 */
    static class C09626 implements OnCompletionListener {
        C09626() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            MurattalService.m3351e();
        }
    }

    /* renamed from: com.andi.alquran.services.MurattalService.7 */
    static class C09637 implements OnCompletionListener {
        C09637() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            MurattalService.m3351e();
        }
    }

    static {
        f1949b = false;
        f1950c = "INIT";
    }

    public MurattalService() {
        this.f1951d = new C09561(this);
        this.f1952e = new C09572(this);
        this.f1953f = new C09583(this);
        this.f1954g = new C09594(this);
    }

    public static void m3346a() {
        SharedPreferences sharedPreferences = App.m2860a().getSharedPreferences("murattal_audio_by_andi", 0);
        int i = sharedPreferences.getInt("suraSelected", 1);
        int i2 = sharedPreferences.getInt("ayaSelected", 1);
        if (f1950c.equals("INIT")) {
            String b = App.m2870b(i, 0);
            if (!App.m2872c(b).booleanValue()) {
                b = App.m2870b(1, 1);
            }
            String b2 = App.m2870b(i, i2);
            if (!App.m2872c(b2).booleanValue() || i == 1 || i == 9 || i2 != 1) {
                if (App.m2872c(b2).booleanValue()) {
                    f1948a = MediaPlayer.create(App.m2860a(), Uri.fromFile(new File(App.m2887l() + b2)));
                    f1948a.setOnCompletionListener(new C09637());
                    f1948a.start();
                    f1949b = true;
                    f1950c = "PLAYING";
                    m3353g();
                    return;
                }
                m3349c();
                App.m2860a().stopService(new Intent(App.m2860a(), MurattalService.class));
            } else if (App.m2872c(b).booleanValue()) {
                f1948a = MediaPlayer.create(App.m2860a(), Uri.fromFile(new File(App.m2887l() + b)));
                f1948a.setOnCompletionListener(new C09615(b2));
                f1948a.start();
                f1949b = true;
                f1950c = "PLAYING";
                m3353g();
            } else if (App.m2872c(b2).booleanValue()) {
                f1948a = MediaPlayer.create(App.m2860a(), Uri.fromFile(new File(App.m2887l() + b2)));
                f1948a.setOnCompletionListener(new C09626());
                f1948a.start();
                f1949b = true;
                f1950c = "PLAYING";
                m3353g();
            } else {
                m3349c();
                App.m2860a().stopService(new Intent(App.m2860a(), MurattalService.class));
            }
        } else if (f1950c.equals("PAUSE")) {
            f1948a.start();
            f1949b = true;
            f1950c = "PLAYING";
            m3353g();
        }
    }

    public static void m3348b() {
        if (f1948a != null) {
            f1948a.pause();
        }
        f1950c = "PAUSE";
        f1949b = true;
        m3353g();
    }

    public static void m3349c() {
        f1949b = false;
        if (f1948a != null) {
            f1948a.stop();
            f1948a.reset();
        }
        f1950c = "INIT";
        m3353g();
    }

    public static void m3350d() {
        f1949b = true;
        if (f1948a != null) {
            f1948a.stop();
            f1948a.reset();
        }
        f1950c = "INIT";
        m3353g();
    }

    public static void m3351e() {
        int i = 1;
        m3350d();
        SharedPreferences sharedPreferences = App.m2860a().getSharedPreferences("murattal_audio_by_andi", 0);
        int i2 = sharedPreferences.getInt("suraSelected", 1);
        int i3 = sharedPreferences.getInt("ayaSelected", 1);
        int i4 = new C0885a().m3073a(i2).f1706c;
        int i5 = i3 + 1;
        int i6 = sharedPreferences.getInt("repeaterSelected", 1);
        Editor edit;
        if (i6 == 1) {
            if (i4 == i3) {
                i6 = i2 < C0861R.styleable.AppCompatTheme_listMenuViewStyle ? i2 + 1 : 1;
                i5 = 1;
            } else {
                i6 = i2;
            }
            if (i4 == i3 && i2 == C0861R.styleable.AppCompatTheme_listMenuViewStyle) {
                edit = sharedPreferences.edit();
                edit.putInt("suraSelected", 1);
                edit.putInt("ayaSelected", 1);
                edit.apply();
                m3349c();
                App.m2860a().stopService(new Intent(App.m2860a(), MurattalService.class));
                return;
            }
            Editor edit2 = sharedPreferences.edit();
            edit2.putInt("suraSelected", i6);
            edit2.putInt("ayaSelected", i5);
            edit2.apply();
            m3346a();
            m3354h();
        } else if (i6 == 2) {
            if (i4 != i3) {
                i = i5;
            }
            edit = sharedPreferences.edit();
            edit.putInt("suraSelected", i2);
            edit.putInt("ayaSelected", i);
            edit.apply();
            m3346a();
            m3354h();
        } else if (i6 == 3) {
            m3346a();
            m3354h();
        }
    }

    private static void m3353g() {
        Intent intent = new Intent();
        intent.setAction(C0879b.f1651h);
        Bundle bundle = new Bundle();
        bundle.putString("playerStatus", f1950c);
        intent.putExtras(bundle);
        App.m2860a().sendBroadcast(intent);
    }

    private static void m3354h() {
        Intent intent = new Intent();
        intent.setAction(C0879b.f1652i);
        intent.putExtras(new Bundle());
        App.m2860a().sendBroadcast(intent);
    }

    private void m3355i() {
        SharedPreferences sharedPreferences = App.m2860a().getSharedPreferences("murattal_audio_by_andi", 0);
        int i = sharedPreferences.getInt("suraSelected", 1);
        int i2 = sharedPreferences.getInt("ayaSelected", 1);
        CharSequence charSequence = "QS. " + App.m2863a(i) + ": " + i2 + " (Juz: " + App.f1448m.f1453e.m3071a(2, i, i2) + ")";
        String str = getResources().getStringArray(C0861R.array.arrTypeQori)[App.m2868b(PreferenceManager.getDefaultSharedPreferences(this), "qoriSelected", 2) - 1];
        Intent intent = new Intent(this, ActivityQuran.class);
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
        Builder builder = new Builder(this);
        if (f1950c.equals("PAUSE")) {
            builder.setSmallIcon(C0861R.drawable.stat_notify_musicplayer_pause);
        } else {
            builder.setSmallIcon(C0861R.drawable.stat_notify_musicplayer);
        }
        builder.setContentIntent(activity);
        builder.setContentTitle("Qori: " + str);
        builder.setContentText(charSequence);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), C0861R.drawable.album_notif));
        builder.setShowWhen(false);
        builder.setAutoCancel(false);
        builder.addAction(new Action.Builder(C0861R.drawable.ic_action_previous, BuildConfig.VERSION_NAME, PendingIntent.getBroadcast(this, 0, new Intent(C0879b.f1653j), 0)).build());
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, new Intent(C0879b.f1655l), 0);
        if (f1950c.equals("PAUSE") || f1950c.equals("INIT")) {
            builder.addAction(new Action.Builder(C0861R.drawable.ic_action_play, BuildConfig.VERSION_NAME, broadcast).build());
        } else {
            builder.addAction(new Action.Builder(C0861R.drawable.ic_action_pause, BuildConfig.VERSION_NAME, broadcast).build());
        }
        builder.addAction(new Action.Builder(C0861R.drawable.ic_action_next, BuildConfig.VERSION_NAME, PendingIntent.getBroadcast(this, 0, new Intent(C0879b.f1654k), 0)).build());
        builder.setStyle(new MediaStyle().setShowActionsInCompactView(0, 1, 2));
        startForeground(41, builder.build());
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (this.f1951d != null) {
            registerReceiver(this.f1951d, new IntentFilter(C0879b.f1652i));
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.f1952e != null) {
                registerReceiver(this.f1952e, new IntentFilter(C0879b.f1655l));
            }
            if (this.f1953f != null) {
                registerReceiver(this.f1953f, new IntentFilter(C0879b.f1653j));
            }
            if (this.f1954g != null) {
                registerReceiver(this.f1954g, new IntentFilter(C0879b.f1654k));
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f1951d);
        if (VERSION.SDK_INT >= 11) {
            unregisterReceiver(this.f1952e);
            unregisterReceiver(this.f1953f);
            unregisterReceiver(this.f1954g);
        }
    }
}
