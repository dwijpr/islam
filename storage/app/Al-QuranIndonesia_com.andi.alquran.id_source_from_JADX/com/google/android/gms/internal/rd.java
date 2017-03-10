package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@op
public class rd {
    private final rf f5639a;
    private final LinkedList<C1939a> f5640b;
    private final Object f5641c;
    private final String f5642d;
    private final String f5643e;
    private long f5644f;
    private long f5645g;
    private boolean f5646h;
    private long f5647i;
    private long f5648j;
    private long f5649k;
    private long f5650l;

    @op
    /* renamed from: com.google.android.gms.internal.rd.a */
    private static final class C1939a {
        private long f5637a;
        private long f5638b;

        public C1939a() {
            this.f5637a = -1;
            this.f5638b = -1;
        }

        public long m8365a() {
            return this.f5638b;
        }

        public void m8366b() {
            this.f5638b = SystemClock.elapsedRealtime();
        }

        public void m8367c() {
            this.f5637a = SystemClock.elapsedRealtime();
        }

        public Bundle m8368d() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.f5637a);
            bundle.putLong("tclose", this.f5638b);
            return bundle;
        }
    }

    public rd(rf rfVar, String str, String str2) {
        this.f5641c = new Object();
        this.f5644f = -1;
        this.f5645g = -1;
        this.f5646h = false;
        this.f5647i = -1;
        this.f5648j = 0;
        this.f5649k = -1;
        this.f5650l = -1;
        this.f5639a = rfVar;
        this.f5642d = str;
        this.f5643e = str2;
        this.f5640b = new LinkedList();
    }

    public rd(String str, String str2) {
        this(zzv.zzcN(), str, str2);
    }

    public void m8369a() {
        synchronized (this.f5641c) {
            if (this.f5650l != -1 && this.f5645g == -1) {
                this.f5645g = SystemClock.elapsedRealtime();
                this.f5639a.m8396a(this);
            }
            this.f5639a.m8410e().m8435c();
        }
    }

    public void m8370a(long j) {
        synchronized (this.f5641c) {
            this.f5650l = j;
            if (this.f5650l != -1) {
                this.f5639a.m8396a(this);
            }
        }
    }

    public void m8371a(zzdy com_google_android_gms_internal_zzdy) {
        synchronized (this.f5641c) {
            this.f5649k = SystemClock.elapsedRealtime();
            this.f5639a.m8410e().m8433a(com_google_android_gms_internal_zzdy, this.f5649k);
        }
    }

    public void m8372a(boolean z) {
        synchronized (this.f5641c) {
            if (this.f5650l != -1) {
                this.f5647i = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f5645g = this.f5647i;
                    this.f5639a.m8396a(this);
                }
            }
        }
    }

    public void m8373b() {
        synchronized (this.f5641c) {
            if (this.f5650l != -1) {
                C1939a c1939a = new C1939a();
                c1939a.m8367c();
                this.f5640b.add(c1939a);
                this.f5648j++;
                this.f5639a.m8410e().m8434b();
                this.f5639a.m8396a(this);
            }
        }
    }

    public void m8374b(long j) {
        synchronized (this.f5641c) {
            if (this.f5650l != -1) {
                this.f5644f = j;
                this.f5639a.m8396a(this);
            }
        }
    }

    public void m8375b(boolean z) {
        synchronized (this.f5641c) {
            if (this.f5650l != -1) {
                this.f5646h = z;
                this.f5639a.m8396a(this);
            }
        }
    }

    public void m8376c() {
        synchronized (this.f5641c) {
            if (!(this.f5650l == -1 || this.f5640b.isEmpty())) {
                C1939a c1939a = (C1939a) this.f5640b.getLast();
                if (c1939a.m8365a() == -1) {
                    c1939a.m8366b();
                    this.f5639a.m8396a(this);
                }
            }
        }
    }

    public Bundle m8377d() {
        Bundle bundle;
        synchronized (this.f5641c) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f5642d);
            bundle.putString("slotid", this.f5643e);
            bundle.putBoolean("ismediation", this.f5646h);
            bundle.putLong("treq", this.f5649k);
            bundle.putLong("tresponse", this.f5650l);
            bundle.putLong("timp", this.f5645g);
            bundle.putLong("tload", this.f5647i);
            bundle.putLong("pcc", this.f5648j);
            bundle.putLong("tfetch", this.f5644f);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f5640b.iterator();
            while (it.hasNext()) {
                arrayList.add(((C1939a) it.next()).m8368d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
