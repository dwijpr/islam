package com.andi.alquran.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.andi.alquran.p022f.C0734e;
import com.andi.alquran.p022f.C0909f;
import com.andi.alquran.p028g.p029a.C0910d;
import com.andi.alquran.p028g.p029a.C0911a;
import com.andi.alquran.p028g.p029a.C0913c;
import com.andi.alquran.p028g.p029a.C0914e;
import com.andi.alquran.p031i.C0934k;
import com.andi.alquran.p031i.C0935l;
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

public class SingleDownloadService extends Service implements C0909f {
    public static int f1969b;
    ThreadPoolExecutor f1970a;
    C0934k f1971c;
    public Handler f1972d;
    private ArrayList<C0734e> f1973e;
    private final IBinder f1974f;
    private int f1975g;
    private HashMap<String, C0934k> f1976h;

    /* renamed from: com.andi.alquran.services.SingleDownloadService.a */
    public class C0966a extends Binder {
        final /* synthetic */ SingleDownloadService f1967a;

        public C0966a(SingleDownloadService singleDownloadService) {
            this.f1967a = singleDownloadService;
        }

        public SingleDownloadService m3363a() {
            return this.f1967a;
        }
    }

    /* renamed from: com.andi.alquran.services.SingleDownloadService.b */
    public static class C0967b extends Handler {
        WeakReference<C0909f> f1968a;

        C0967b(C0909f c0909f) {
            this.f1968a = new WeakReference(c0909f);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            C0909f c0909f = (C0909f) this.f1968a.get();
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
        f1969b = 0;
    }

    public SingleDownloadService() {
        this.f1974f = new C0966a(this);
        this.f1970a = null;
        this.f1975g = 0;
        this.f1972d = new C0967b(this);
        this.f1973e = new ArrayList();
        f1969b = C0939a.m3270a() == 1 ? 2 : C0939a.m3270a();
    }

    private C0934k m3364a(C0914e c0914e) {
        return this.f1976h.containsKey(c0914e.m3157f()) ? (C0934k) this.f1976h.get(c0914e.m3157f()) : null;
    }

    public static void m3365a(Context context, C0914e c0914e) {
        Intent intent = new Intent(context, SingleDownloadService.class);
        intent.putExtra("key_single_download", c0914e);
        context.startService(intent);
    }

    private void m3366a(ThreadPoolExecutor threadPoolExecutor, C0914e c0914e) {
        C0934k a = m3364a(c0914e);
        if (a != null) {
            a.m3257b();
        }
    }

    public static void m3367b(Context context, C0914e c0914e) {
        Serializable c0914e2 = new C0914e(c0914e.m3157f(), c0914e.m3158g(), c0914e.m3187a(), true);
        Intent intent = new Intent(context, SingleDownloadService.class);
        intent.putExtra("key_single_download", c0914e2);
        context.startService(intent);
    }

    public void m3368a() {
        if (m3371b().getActiveCount() == 0 || this.f1976h.size() == 0) {
            this.f1976h.clear();
            stopSelfResult(this.f1975g);
            stopSelf();
        }
    }

    public void m3369a(C0734e c0734e) {
        this.f1973e.add(c0734e);
    }

    public void m3370a(C0910d c0910d) {
        m3375d(c0910d);
        this.f1976h.remove(((C0911a) c0910d).m3157f());
    }

    public ThreadPoolExecutor m3371b() {
        if (this.f1970a == null) {
            this.f1970a = (ThreadPoolExecutor) Executors.newFixedThreadPool(f1969b);
        }
        return this.f1970a;
    }

    public void m3372b(C0734e c0734e) {
        if (this.f1973e.indexOf(c0734e) > 0) {
            this.f1973e.remove(c0734e);
        }
    }

    public void m3373b(C0910d c0910d) {
        m3376e(c0910d);
    }

    public void m3374c(C0910d c0910d) {
        m3377f(c0910d);
        this.f1976h.remove(((C0913c) c0910d).m3157f());
    }

    public void m3375d(C0910d c0910d) {
        Iterator it = this.f1973e.iterator();
        while (it.hasNext()) {
            ((C0734e) it.next()).m2566b(c0910d);
        }
    }

    public void m3376e(C0910d c0910d) {
        Iterator it = this.f1973e.iterator();
        while (it.hasNext()) {
            ((C0734e) it.next()).m2565a(c0910d);
        }
    }

    public void m3377f(C0910d c0910d) {
        Iterator it = this.f1973e.iterator();
        while (it.hasNext()) {
            ((C0734e) it.next()).m2567c(c0910d);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f1974f;
    }

    public void onCreate() {
        super.onCreate();
        this.f1976h = new HashMap();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            C0914e c0914e = (C0914e) intent.getSerializableExtra("key_single_download");
            if (c0914e == null) {
                return 0;
            }
            if (this.f1976h.containsKey(c0914e.m3157f()) && !c0914e.m3159h()) {
                return 0;
            }
            this.f1975g = i2;
            this.f1971c = C0935l.m3258a(this.f1972d, c0914e);
            if (!c0914e.m3159h()) {
                this.f1976h.put(c0914e.m3157f(), this.f1971c);
            }
            if (this.f1971c != null) {
                if (c0914e.m3159h()) {
                    m3366a(m3371b(), c0914e);
                } else {
                    m3371b().execute(this.f1971c);
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
