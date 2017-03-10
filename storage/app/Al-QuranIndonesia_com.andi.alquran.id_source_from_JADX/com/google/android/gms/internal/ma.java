package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@op
public class ma implements ls {
    private final zzmh f4903a;
    private final md f4904b;
    private final Context f4905c;
    private final lu f4906d;
    private final boolean f4907e;
    private final long f4908f;
    private final long f4909g;
    private final int f4910h;
    private final Object f4911i;
    private boolean f4912j;
    private final Map<sn<ly>, lx> f4913k;
    private final boolean f4914l;
    private List<ly> f4915m;

    /* renamed from: com.google.android.gms.internal.ma.1 */
    class C17931 implements Callable<ly> {
        final /* synthetic */ lx f4899a;
        final /* synthetic */ ma f4900b;

        C17931(ma maVar, lx lxVar) {
            this.f4900b = maVar;
            this.f4899a = lxVar;
        }

        public ly m7437a() {
            synchronized (this.f4900b.f4911i) {
                if (this.f4900b.f4912j) {
                    return null;
                }
                return this.f4899a.m7430a(this.f4900b.f4908f, this.f4900b.f4909g);
            }
        }

        public /* synthetic */ Object call() {
            return m7437a();
        }
    }

    /* renamed from: com.google.android.gms.internal.ma.2 */
    class C17942 implements Runnable {
        final /* synthetic */ sn f4901a;
        final /* synthetic */ ma f4902b;

        C17942(ma maVar, sn snVar) {
            this.f4902b = maVar;
            this.f4901a = snVar;
        }

        public void run() {
            for (sn snVar : this.f4902b.f4913k.keySet()) {
                if (snVar != this.f4901a) {
                    ((lx) this.f4902b.f4913k.get(snVar)).m7432a();
                }
            }
        }
    }

    public ma(Context context, zzmh com_google_android_gms_internal_zzmh, md mdVar, lu luVar, boolean z, boolean z2, long j, long j2, int i) {
        this.f4911i = new Object();
        this.f4912j = false;
        this.f4913k = new HashMap();
        this.f4915m = new ArrayList();
        this.f4905c = context;
        this.f4903a = com_google_android_gms_internal_zzmh;
        this.f4904b = mdVar;
        this.f4906d = luVar;
        this.f4907e = z;
        this.f4914l = z2;
        this.f4908f = j;
        this.f4909g = j2;
        this.f4910h = i;
    }

    private void m7439a(sn<ly> snVar) {
        rq.f5755a.post(new C17942(this, snVar));
    }

    private ly m7440b(List<sn<ly>> list) {
        Throwable e;
        synchronized (this.f4911i) {
            if (this.f4912j) {
                ly lyVar = new ly(-1);
                return lyVar;
            }
            for (sn snVar : list) {
                try {
                    lyVar = (ly) snVar.get();
                    this.f4915m.add(lyVar);
                    if (lyVar != null && lyVar.f4892a == 0) {
                        m7439a(snVar);
                        return lyVar;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    sg.m8447c("Exception while processing an adapter; continuing with other adapters", e);
                } catch (ExecutionException e3) {
                    e = e3;
                    sg.m8447c("Exception while processing an adapter; continuing with other adapters", e);
                }
            }
            m7439a(null);
            return new ly(1);
        }
    }

    private ly m7443c(List<sn<ly>> list) {
        RemoteException max;
        synchronized (this.f4911i) {
            if (this.f4912j) {
                ly lyVar = new ly(-1);
                return lyVar;
            }
            long j = -1;
            sn snVar = null;
            lyVar = null;
            long j2 = this.f4906d.f4865m != -1 ? this.f4906d.f4865m : 10000;
            long j3 = j2;
            for (sn snVar2 : list) {
                ly lyVar2;
                mg mgVar;
                int a;
                ly lyVar3;
                sn snVar3;
                ly lyVar4;
                long a2 = zzv.zzcP().m4926a();
                if (j3 == 0) {
                    try {
                        if (snVar2.isDone()) {
                            lyVar2 = (ly) snVar2.get();
                            this.f4915m.add(lyVar2);
                            if (lyVar2 != null && lyVar2.f4892a == 0) {
                                mgVar = lyVar2.f4897f;
                                if (mgVar != null && mgVar.m7403a() > j) {
                                    a = mgVar.m7403a();
                                    lyVar3 = lyVar2;
                                    snVar3 = snVar2;
                                    lyVar4 = lyVar3;
                                    snVar = snVar3;
                                    lyVar3 = lyVar4;
                                    max = Math.max(j3 - (zzv.zzcP().m4926a() - a2), 0);
                                    j = a;
                                    lyVar = lyVar3;
                                    j3 = max;
                                }
                            }
                            lyVar4 = lyVar;
                            snVar3 = snVar;
                            a = j;
                            snVar = snVar3;
                            lyVar3 = lyVar4;
                            max = Math.max(j3 - (zzv.zzcP().m4926a() - a2), 0);
                            j = a;
                            lyVar = lyVar3;
                            j3 = max;
                        }
                    } catch (InterruptedException e) {
                        max = e;
                        try {
                            sg.m8447c("Exception while processing an adapter; continuing with other adapters", max);
                            j3 = max;
                        } finally {
                            lyVar = j3 - (zzv.zzcP().m4926a() - a2);
                            j = 0;
                            Math.max(lyVar, j);
                            j = j3;
                        }
                    } catch (ExecutionException e2) {
                        max = e2;
                        sg.m8447c("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    } catch (RemoteException e3) {
                        max = e3;
                        sg.m8447c("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    } catch (TimeoutException e4) {
                        max = e4;
                        sg.m8447c("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    }
                }
                lyVar2 = (ly) snVar2.get(j3, TimeUnit.MILLISECONDS);
                this.f4915m.add(lyVar2);
                mgVar = lyVar2.f4897f;
                a = mgVar.m7403a();
                lyVar3 = lyVar2;
                snVar3 = snVar2;
                lyVar4 = lyVar3;
                snVar = snVar3;
                lyVar3 = lyVar4;
                max = Math.max(j3 - (zzv.zzcP().m4926a() - a2), 0);
                j = a;
                lyVar = lyVar3;
                j3 = max;
            }
            m7439a(snVar);
            return lyVar == null ? new ly(1) : lyVar;
        }
    }

    public ly m7446a(List<lt> list) {
        sg.m8444b("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List arrayList = new ArrayList();
        for (lt ltVar : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(ltVar.f4838b);
            sg.m8448d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String lxVar : ltVar.f4839c) {
                lx lxVar2 = new lx(this.f4905c, lxVar, this.f4904b, this.f4906d, ltVar, this.f4903a.f6542c, this.f4903a.f6543d, this.f4903a.f6550k, this.f4907e, this.f4914l, this.f4903a.f6565z, this.f4903a.f6553n);
                sn a = rp.m8474a(newCachedThreadPool, new C17931(this, lxVar2));
                this.f4913k.put(a, lxVar2);
                arrayList.add(a);
            }
        }
        switch (this.f4910h) {
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return m7443c(arrayList);
            default:
                return m7440b(arrayList);
        }
    }

    public void m7447a() {
        synchronized (this.f4911i) {
            this.f4912j = true;
            for (lx a : this.f4913k.values()) {
                a.m7432a();
            }
        }
    }

    public List<ly> m7448b() {
        return this.f4915m;
    }
}
