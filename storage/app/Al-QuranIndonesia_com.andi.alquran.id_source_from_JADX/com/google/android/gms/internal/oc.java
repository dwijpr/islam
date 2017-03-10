package com.google.android.gms.internal;

import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.rc.C1938a;

@op
public class oc extends rl {
    private final C1155a f5150a;
    private final zzmk f5151b;
    private final C1938a f5152c;

    /* renamed from: com.google.android.gms.internal.oc.1 */
    class C18491 implements Runnable {
        final /* synthetic */ rc f5148a;
        final /* synthetic */ oc f5149b;

        C18491(oc ocVar, rc rcVar) {
            this.f5149b = ocVar;
            this.f5148a = rcVar;
        }

        public void run() {
            this.f5149b.f5150a.zzb(this.f5148a);
        }
    }

    public oc(C1938a c1938a, C1155a c1155a) {
        this.f5152c = c1938a;
        this.f5151b = this.f5152c.f5595b;
        this.f5150a = c1155a;
    }

    private rc m7822a(int i) {
        return new rc(this.f5152c.f5594a.f6542c, null, null, i, null, null, this.f5151b.f6593l, this.f5151b.f6592k, this.f5152c.f5594a.f6548i, false, null, null, null, null, null, this.f5151b.f6590i, this.f5152c.f5597d, this.f5151b.f6588g, this.f5152c.f5599f, this.f5151b.f6595n, this.f5151b.f6596o, this.f5152c.f5601h, null, null, null, null, this.f5152c.f5595b.f6571F, this.f5152c.f5595b.f6572G, null, null, null);
    }

    public void onStop() {
    }

    public void zzcm() {
        rq.f5755a.post(new C18491(this, m7822a(0)));
    }
}
