package com.google.android.gms.internal;

import android.content.Context;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.internal.qk.C1932a;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@op
public class qp extends rl implements qo {
    private final C1938a f5578a;
    private final Context f5579b;
    private final ArrayList<Future> f5580c;
    private final ArrayList<String> f5581d;
    private final HashMap<String, qj> f5582e;
    private final List<qk> f5583f;
    private final HashSet<String> f5584g;
    private final Object f5585h;
    private final py f5586i;
    private final long f5587j;

    /* renamed from: com.google.android.gms.internal.qp.1 */
    class C19341 implements Runnable {
        final /* synthetic */ rc f5574a;
        final /* synthetic */ qp f5575b;

        C19341(qp qpVar, rc rcVar) {
            this.f5575b = qpVar;
            this.f5574a = rcVar;
        }

        public void run() {
            this.f5575b.f5586i.zzb(this.f5574a);
        }
    }

    /* renamed from: com.google.android.gms.internal.qp.2 */
    class C19352 implements Runnable {
        final /* synthetic */ rc f5576a;
        final /* synthetic */ qp f5577b;

        C19352(qp qpVar, rc rcVar) {
            this.f5577b = qpVar;
            this.f5576a = rcVar;
        }

        public void run() {
            this.f5577b.f5586i.zzb(this.f5576a);
        }
    }

    public qp(Context context, C1938a c1938a, py pyVar) {
        this(context, c1938a, pyVar, ((Long) C1648if.aC.m6682c()).longValue());
    }

    qp(Context context, C1938a c1938a, py pyVar, long j) {
        this.f5580c = new ArrayList();
        this.f5581d = new ArrayList();
        this.f5582e = new HashMap();
        this.f5583f = new ArrayList();
        this.f5584g = new HashSet();
        this.f5585h = new Object();
        this.f5579b = context;
        this.f5578a = c1938a;
        this.f5586i = pyVar;
        this.f5587j = j;
    }

    private static int m8330a(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return 1;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return 2;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return 4;
            case C1096c.MapAttrs_liteMode /*6*/:
                return 0;
            case C1096c.MapAttrs_uiCompass /*7*/:
                return 3;
            default:
                return 6;
        }
    }

    private rc m8332a() {
        return m8333a(3, null, null);
    }

    private rc m8333a(int i, String str, lt ltVar) {
        return new rc(this.f5578a.f5594a.f6542c, null, this.f5578a.f5595b.f6585d, i, this.f5578a.f5595b.f6587f, this.f5578a.f5595b.f6591j, this.f5578a.f5595b.f6593l, this.f5578a.f5595b.f6592k, this.f5578a.f5594a.f6548i, this.f5578a.f5595b.f6589h, ltVar, null, str, this.f5578a.f5596c, null, this.f5578a.f5595b.f6590i, this.f5578a.f5597d, this.f5578a.f5595b.f6588g, this.f5578a.f5599f, this.f5578a.f5595b.f6595n, this.f5578a.f5595b.f6596o, this.f5578a.f5601h, null, this.f5578a.f5595b.f6568C, this.f5578a.f5595b.f6569D, this.f5578a.f5595b.f6570E, this.f5578a.f5595b.f6571F, this.f5578a.f5595b.f6572G, m8337b(), this.f5578a.f5595b.f6575J, this.f5578a.f5595b.f6579N);
    }

    private rc m8334a(String str, lt ltVar) {
        return m8333a(-2, str, ltVar);
    }

    private static String m8335a(qk qkVar) {
        String str = qkVar.f5568b;
        int a = m8330a(qkVar.f5569c);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(a).append(".").append(qkVar.f5570d).toString();
    }

    private void m8336a(String str, String str2, lt ltVar) {
        synchronized (this.f5585h) {
            qq b = this.f5586i.m8232b(str);
            if (b == null || b.m8342b() == null || b.m8341a() == null) {
                this.f5583f.add(new C1932a().m8306b(ltVar.f4840d).m8304a(str).m8303a(0).m8302a(7).m8305a());
                return;
            }
            rl a = m8338a(str, str2, ltVar, b);
            this.f5580c.add((Future) a.zziw());
            this.f5581d.add(str);
            this.f5582e.put(str, a);
        }
    }

    private String m8337b() {
        StringBuilder stringBuilder = new StringBuilder(BuildConfig.VERSION_NAME);
        if (this.f5583f == null) {
            return stringBuilder.toString();
        }
        for (qk qkVar : this.f5583f) {
            if (!(qkVar == null || TextUtils.isEmpty(qkVar.f5568b))) {
                stringBuilder.append(String.valueOf(m8335a(qkVar)).concat("_"));
            }
        }
        return stringBuilder.substring(0, Math.max(0, stringBuilder.length() - 1));
    }

    protected qj m8338a(String str, String str2, lt ltVar, qq qqVar) {
        return new qj(this.f5579b, str, str2, ltVar, this.f5578a, qqVar, this, this.f5587j);
    }

    public void m8339a(String str) {
        synchronized (this.f5585h) {
            this.f5584g.add(str);
        }
    }

    public void m8340a(String str, int i) {
    }

    public void onStop() {
    }

    public void zzcm() {
        String str;
        qj qjVar;
        for (lt ltVar : this.f5578a.f5596c.f4853a) {
            String str2 = ltVar.f4845i;
            for (String str3 : ltVar.f4839c) {
                String str32;
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str32) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str32)) {
                    try {
                        str32 = new JSONObject(str2).getString("class_name");
                    } catch (Throwable e) {
                        sg.m8445b("Unable to determine custom event class name, skipping...", e);
                    }
                }
                m8336a(str32, str2, ltVar);
            }
        }
        int i = 0;
        while (i < this.f5580c.size()) {
            try {
                ((Future) this.f5580c.get(i)).get();
                synchronized (this.f5585h) {
                    str = (String) this.f5581d.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        qjVar = (qj) this.f5582e.get(str);
                        if (qjVar != null) {
                            this.f5583f.add(qjVar.m8291a());
                        }
                    }
                }
                synchronized (this.f5585h) {
                    if (this.f5584g.contains(this.f5581d.get(i))) {
                        str = (String) this.f5581d.get(i);
                        sf.f5831a.post(new C19341(this, m8334a(str, this.f5582e.get(str) != null ? ((qj) this.f5582e.get(str)).m8296b() : null)));
                        return;
                    }
                    i++;
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                synchronized (this.f5585h) {
                }
                str = (String) this.f5581d.get(i);
                if (!TextUtils.isEmpty(str)) {
                    qjVar = (qj) this.f5582e.get(str);
                    if (qjVar != null) {
                        this.f5583f.add(qjVar.m8291a());
                    }
                }
            } catch (Throwable e3) {
                sg.m8447c("Unable to resolve rewarded adapter.", e3);
                synchronized (this.f5585h) {
                }
                str = (String) this.f5581d.get(i);
                if (!TextUtils.isEmpty(str)) {
                    qjVar = (qj) this.f5582e.get(str);
                    if (qjVar != null) {
                        this.f5583f.add(qjVar.m8291a());
                    }
                }
            } catch (Throwable e32) {
                Throwable th = e32;
                synchronized (this.f5585h) {
                }
                str = (String) this.f5581d.get(i);
                if (!TextUtils.isEmpty(str)) {
                    qjVar = (qj) this.f5582e.get(str);
                    if (qjVar != null) {
                        this.f5583f.add(qjVar.m8291a());
                    }
                }
            }
        }
        sf.f5831a.post(new C19352(this, m8332a()));
    }
}
