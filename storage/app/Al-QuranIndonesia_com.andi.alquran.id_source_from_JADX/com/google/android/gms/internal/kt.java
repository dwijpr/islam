package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;

@op
public class kt extends rl {
    final sx f4651a;
    final kv f4652b;
    private final String f4653c;

    /* renamed from: com.google.android.gms.internal.kt.1 */
    class C17191 implements Runnable {
        final /* synthetic */ kt f4650a;

        C17191(kt ktVar) {
            this.f4650a = ktVar;
        }

        public void run() {
            zzv.zzdg().m7137b(this.f4650a);
        }
    }

    kt(sx sxVar, kv kvVar, String str) {
        this.f4651a = sxVar;
        this.f4652b = kvVar;
        this.f4653c = str;
        zzv.zzdg().m7135a(this);
    }

    public void onStop() {
        this.f4652b.m7149b();
    }

    public void zzcm() {
        try {
            this.f4652b.m7147a(this.f4653c);
        } finally {
            rq.f5755a.post(new C17191(this));
        }
    }
}
