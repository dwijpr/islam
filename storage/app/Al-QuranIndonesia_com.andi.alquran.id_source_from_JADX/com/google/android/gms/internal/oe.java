package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.internal.nz.C1847a;
import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@op
public class oe extends nz {
    ls f5158g;
    protected ly f5159h;
    private md f5160i;
    private lu f5161j;
    private final io f5162k;
    private final sx f5163l;
    private boolean f5164m;

    /* renamed from: com.google.android.gms.internal.oe.1 */
    class C18501 implements Runnable {
        final /* synthetic */ CountDownLatch f5156a;
        final /* synthetic */ oe f5157b;

        C18501(oe oeVar, CountDownLatch countDownLatch) {
            this.f5157b = oeVar;
            this.f5156a = countDownLatch;
        }

        public void run() {
            synchronized (this.f5157b.d) {
                this.f5157b.f5164m = zzo.zza(this.f5157b.f5163l, this.f5157b.f5159h, this.f5156a);
            }
        }
    }

    oe(Context context, C1938a c1938a, md mdVar, C1155a c1155a, io ioVar, sx sxVar) {
        super(context, c1938a, c1155a);
        this.f5160i = mdVar;
        this.f5161j = c1938a.f5596c;
        this.f5162k = ioVar;
        this.f5163l = sxVar;
    }

    private static String m7827a(ly lyVar) {
        String str = lyVar.f4893b.f4840d;
        int b = m7831b(lyVar.f4892a);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(b).append(".").append(lyVar.f4898g).toString();
    }

    private static String m7828a(List<ly> list) {
        String str = BuildConfig.VERSION_NAME;
        if (list == null) {
            return str.toString();
        }
        String str2 = str;
        for (ly lyVar : list) {
            if (!(lyVar == null || lyVar.f4893b == null || TextUtils.isEmpty(lyVar.f4893b.f4840d))) {
                str2 = String.valueOf(str2);
                str = String.valueOf(m7827a(lyVar));
                str2 = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(str).length()).append(str2).append(str).append("_").toString();
            }
        }
        return str2.substring(0, Math.max(0, str2.length() - 1));
    }

    private void m7829a() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        rq.f5755a.post(new C18501(this, countDownLatch));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.d) {
                if (!this.f5164m) {
                    throw new C1847a("View could not be prepared", 0);
                } else if (this.f5163l.m8782r()) {
                    throw new C1847a("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(e);
            throw new C1847a(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
        }
    }

    private static int m7831b(int i) {
        switch (i) {
            case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                return 4;
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return 0;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return 1;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return 2;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return 3;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return 5;
            default:
                return 6;
        }
    }

    protected rc m7832a(int i) {
        zzmh com_google_android_gms_internal_zzmh = this.e.f5594a;
        return new rc(com_google_android_gms_internal_zzmh.f6542c, this.f5163l, this.f.f6585d, i, this.f.f6587f, this.f.f6591j, this.f.f6593l, this.f.f6592k, com_google_android_gms_internal_zzmh.f6548i, this.f.f6589h, this.f5159h != null ? this.f5159h.f4893b : null, this.f5159h != null ? this.f5159h.f4894c : null, this.f5159h != null ? this.f5159h.f4895d : AdMobAdapter.class.getName(), this.f5161j, this.f5159h != null ? this.f5159h.f4896e : null, this.f.f6590i, this.e.f5597d, this.f.f6588g, this.e.f5599f, this.f.f6595n, this.f.f6596o, this.e.f5601h, null, this.f.f6568C, this.f.f6569D, this.f.f6570E, this.f5161j != null ? this.f5161j.f4866n : false, this.f.f6572G, this.f5158g != null ? m7828a(this.f5158g.m7382b()) : null, this.f.f6575J, this.f.f6579N);
    }

    protected void m7833a(long j) {
        boolean z;
        ListIterator listIterator;
        synchronized (this.d) {
            this.f5158g = m7834b(j);
        }
        List arrayList = new ArrayList(this.f5161j.f4853a);
        Bundle bundle = this.e.f5594a.f6542c.f6445m;
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        if (bundle != null) {
            bundle = bundle.getBundle(str);
            if (bundle != null) {
                z = bundle.getBoolean("_skipMediation");
                if (z) {
                    listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        if (!((lt) listIterator.next()).f4839c.contains(str)) {
                            listIterator.remove();
                        }
                    }
                }
                this.f5159h = this.f5158g.m7380a(arrayList);
                switch (this.f5159h.f4892a) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        if (this.f5159h.f4893b != null && this.f5159h.f4893b.f4848l != null) {
                            m7829a();
                            return;
                        }
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                        throw new C1847a("No fill from any mediation ad networks.", 3);
                    default:
                        throw new C1847a("Unexpected mediation result: " + this.f5159h.f4892a, 0);
                }
            }
        }
        z = false;
        if (z) {
            listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((lt) listIterator.next()).f4839c.contains(str)) {
                    listIterator.remove();
                }
            }
        }
        this.f5159h = this.f5158g.m7380a(arrayList);
        switch (this.f5159h.f4892a) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                if (this.f5159h.f4893b != null) {
                }
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                throw new C1847a("No fill from any mediation ad networks.", 3);
            default:
                throw new C1847a("Unexpected mediation result: " + this.f5159h.f4892a, 0);
        }
    }

    ls m7834b(long j) {
        if (this.f5161j.f4864l != -1) {
            return new ma(this.b, this.e.f5594a, this.f5160i, this.f5161j, this.f.f6601t, this.f.f6567B, j, ((Long) C1648if.bo.m6682c()).longValue(), 2);
        }
        return new mb(this.b, this.e.f5594a, this.f5160i, this.f5161j, this.f.f6601t, this.f.f6567B, j, ((Long) C1648if.bo.m6682c()).longValue(), this.f5162k);
    }

    public void onStop() {
        synchronized (this.d) {
            super.onStop();
            if (this.f5158g != null) {
                this.f5158g.m7381a();
            }
        }
    }
}
