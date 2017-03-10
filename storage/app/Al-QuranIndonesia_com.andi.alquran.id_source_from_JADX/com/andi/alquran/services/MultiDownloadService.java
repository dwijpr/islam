package com.andi.alquran.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import com.andi.alquran.ActivityAudioManager;
import com.andi.alquran.C0861R;
import com.andi.alquran.p022f.C0734e;
import com.andi.alquran.p022f.C0909f;
import com.andi.alquran.p025b.C0879b;
import com.andi.alquran.p028g.p029a.C0910d;
import com.andi.alquran.p028g.p029a.C0911a;
import com.andi.alquran.p028g.p029a.C0912b;
import com.andi.alquran.p028g.p029a.C0913c;
import com.andi.alquran.p028g.p029a.C0914e;
import com.andi.alquran.p031i.C0932i;
import com.andi.alquran.p031i.C0933j;
import com.andi.alquran.p032j.C0939a;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.maps.GoogleMap;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiDownloadService extends Service implements C0909f {
    public static int f1926b;
    ThreadPoolExecutor f1927a;
    C0932i f1928c;
    public ArrayList<String> f1929d;
    public ArrayList<C0912b> f1930e;
    public Handler f1931f;
    private ArrayList<C0734e> f1932g;
    private final IBinder f1933h;
    private int f1934i;
    private HashMap<String, C0932i> f1935j;
    private HashMap<String, Integer> f1936k;
    private NotificationManager f1937l;
    private Builder f1938m;
    private int f1939n;
    private SharedPreferences f1940o;
    private Editor f1941p;

    /* renamed from: com.andi.alquran.services.MultiDownloadService.a */
    public class C0954a extends Binder {
        final /* synthetic */ MultiDownloadService f1924a;

        public C0954a(MultiDownloadService multiDownloadService) {
            this.f1924a = multiDownloadService;
        }

        public MultiDownloadService m3326a() {
            return this.f1924a;
        }
    }

    /* renamed from: com.andi.alquran.services.MultiDownloadService.b */
    public static class C0955b extends Handler {
        WeakReference<C0909f> f1925a;

        C0955b(C0909f c0909f) {
            this.f1925a = new WeakReference(c0909f);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            C0909f c0909f = (C0909f) this.f1925a.get();
            if (c0909f != null) {
                switch (message.what) {
                    case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                        if (message.obj instanceof C0913c) {
                            c0909f.m3156c((C0913c) message.obj);
                            break;
                        }
                        break;
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                        if (message.obj instanceof C0911a) {
                            c0909f.m3155b((C0911a) message.obj);
                            break;
                        }
                        break;
                    case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                        if (message.obj instanceof C0911a) {
                            c0909f.m3154a((C0911a) message.obj);
                            break;
                        }
                        break;
                }
                c0909f.m3153a();
            }
        }
    }

    static {
        f1926b = 0;
    }

    public MultiDownloadService() {
        this.f1933h = new C0954a(this);
        this.f1927a = null;
        this.f1934i = 0;
        this.f1939n = 501;
        this.f1931f = new C0955b(this);
        this.f1932g = new ArrayList();
        f1926b = C0939a.m3270a() == 1 ? 2 : C0939a.m3270a();
    }

    private C0932i m3327a(C0914e c0914e) {
        return this.f1935j.containsKey(c0914e.m3157f()) ? (C0932i) this.f1935j.get(c0914e.m3157f()) : null;
    }

    public static void m3328a(Context context, C0914e c0914e) {
        Intent intent = new Intent(context, MultiDownloadService.class);
        intent.putExtra("key_multi_download", c0914e);
        context.startService(intent);
    }

    private void m3329a(ThreadPoolExecutor threadPoolExecutor, C0914e c0914e) {
        C0932i a = m3327a(c0914e);
        if (a != null) {
            a.m3245b();
        }
    }

    public static void m3330b(Context context, C0914e c0914e) {
        Serializable c0914e2 = new C0914e(c0914e.m3157f(), c0914e.m3158g(), c0914e.m3187a(), true);
        Intent intent = new Intent(context, MultiDownloadService.class);
        intent.putExtra("key_multi_download", c0914e2);
        context.startService(intent);
    }

    private void m3331e() {
        Intent intent = new Intent();
        intent.setAction(C0879b.f1649f);
        sendBroadcast(intent);
    }

    private void m3332f() {
        Intent intent = new Intent();
        intent.setAction(C0879b.f1650g);
        sendBroadcast(intent);
    }

    public void m3333a() {
        if (m3342d().getActiveCount() == 0 || this.f1935j.size() == 0) {
            this.f1935j.clear();
            this.f1936k.clear();
            this.f1929d.clear();
            if (this.f1940o == null) {
                this.f1940o = getSharedPreferences("murattal_audio_by_andi", 0);
            }
            this.f1941p = this.f1940o.edit();
            this.f1941p.putBoolean("multiDownloadIsRunning", false);
            this.f1941p.apply();
            m3332f();
            stopSelfResult(this.f1934i);
            stopSelf();
        }
    }

    public void m3334a(C0734e c0734e) {
        this.f1932g.add(c0734e);
    }

    public void m3335a(C0910d c0910d) {
        m3343d(c0910d);
        m3331e();
        this.f1935j.remove(((C0911a) c0910d).m3157f());
    }

    public void m3336a(ArrayList<C0912b> arrayList) {
        this.f1930e = arrayList;
    }

    public ArrayList<C0912b> m3337b() {
        return this.f1930e;
    }

    public void m3338b(C0734e c0734e) {
        if (this.f1932g.indexOf(c0734e) > 0) {
            this.f1932g.remove(c0734e);
        }
    }

    public void m3339b(C0910d c0910d) {
        int i;
        int size;
        m3344e(c0910d);
        if (this.f1940o == null) {
            this.f1940o = getSharedPreferences("murattal_audio_by_andi", 0);
        }
        this.f1941p = this.f1940o.edit();
        this.f1941p.putBoolean("multiDownloadIsRunning", true);
        this.f1941p.apply();
        if (((C0911a) c0910d).m3160a().intValue() >= 100) {
            this.f1935j.remove(((C0911a) c0910d).m3157f());
        }
        if (this.f1936k.containsKey(((C0911a) c0910d).m3157f())) {
            this.f1936k.remove(((C0911a) c0910d).m3157f());
            this.f1936k.put(((C0911a) c0910d).m3157f(), ((C0911a) c0910d).m3160a());
        }
        if (this.f1929d.size() > 0) {
            int i2 = 0;
            for (i = 0; i < this.f1929d.size(); i++) {
                i2 += ((Integer) this.f1936k.get((String) this.f1929d.get(i))).intValue();
            }
            i = i2 / this.f1929d.size();
            size = this.f1929d.size();
        } else {
            size = 1;
            i = 100;
        }
        if (i < 100) {
            this.f1938m.setAutoCancel(false);
            this.f1938m.setContentText(getString(C0861R.string.msg_download_multi_notif_progress, new Object[]{Integer.valueOf(size), Integer.valueOf(i)}));
            this.f1938m.setProgress(100, i, false);
        } else {
            this.f1938m.setSmallIcon(C0861R.drawable.ic_notif_download_complete);
            this.f1938m.setContentText(getString(C0861R.string.msg_download_multi_notif_complete));
            this.f1938m.setProgress(0, 0, false);
            this.f1938m.setAutoCancel(true);
        }
        if (this.f1937l != null) {
            this.f1937l.notify(this.f1939n, this.f1938m.build());
        }
    }

    public void m3340c(C0910d c0910d) {
        m3345f(c0910d);
        this.f1935j.remove(((C0913c) c0910d).m3157f());
        this.f1936k.remove(((C0913c) c0910d).m3157f());
        this.f1929d.remove(((C0913c) c0910d).m3157f());
        if (this.f1935j.size() == 0 && this.f1937l != null) {
            this.f1937l.cancel(this.f1939n);
        }
    }

    public boolean m3341c() {
        return this.f1935j != null && this.f1935j.size() > 0;
    }

    public ThreadPoolExecutor m3342d() {
        if (this.f1927a == null) {
            this.f1927a = (ThreadPoolExecutor) Executors.newFixedThreadPool(f1926b);
        }
        return this.f1927a;
    }

    public void m3343d(C0910d c0910d) {
        Iterator it = this.f1932g.iterator();
        while (it.hasNext()) {
            ((C0734e) it.next()).m2566b(c0910d);
        }
    }

    public void m3344e(C0910d c0910d) {
        Iterator it = this.f1932g.iterator();
        while (it.hasNext()) {
            ((C0734e) it.next()).m2565a(c0910d);
        }
    }

    public void m3345f(C0910d c0910d) {
        Iterator it = this.f1932g.iterator();
        while (it.hasNext()) {
            ((C0734e) it.next()).m2567c(c0910d);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f1933h;
    }

    public void onCreate() {
        super.onCreate();
        this.f1935j = new HashMap();
        this.f1936k = new HashMap();
        this.f1929d = new ArrayList();
        this.f1940o = getSharedPreferences("murattal_audio_by_andi", 0);
        this.f1937l = (NotificationManager) getSystemService("notification");
        this.f1938m = new Builder(this);
        this.f1938m.setContentTitle(getString(C0861R.string.msg_download_multi_notif_title)).setContentText(getString(C0861R.string.msg_download_multi_notif_starting)).setSmallIcon(C0861R.drawable.ic_notif_downloading).setLargeIcon(BitmapFactory.decodeResource(getResources(), C0861R.drawable.ic_launcher)).setShowWhen(false);
        Intent intent = new Intent(this, ActivityAudioManager.class);
        intent.addFlags(805306368);
        this.f1938m.setContentIntent(PendingIntent.getActivity(this, 0, intent, 134217728));
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            C0914e c0914e = (C0914e) intent.getSerializableExtra("key_multi_download");
            if (c0914e == null) {
                return 0;
            }
            if (this.f1935j.containsKey(c0914e.m3157f()) && !c0914e.m3159h()) {
                return 0;
            }
            this.f1934i = i2;
            this.f1928c = C0933j.m3246a(this.f1931f, c0914e);
            if (!c0914e.m3159h()) {
                this.f1935j.put(c0914e.m3157f(), this.f1928c);
                this.f1936k.put(c0914e.m3157f(), Integer.valueOf(0));
                this.f1929d.add(c0914e.m3157f());
            }
            if (this.f1928c != null) {
                if (c0914e.m3159h()) {
                    m3329a(m3342d(), c0914e);
                } else {
                    m3342d().execute(this.f1928c);
                    this.f1937l.notify(this.f1939n, this.f1938m.build());
                }
            }
            return 1;
        } catch (NullPointerException e) {
            return 0;
        } catch (Exception e2) {
            return 0;
        }
    }
}
