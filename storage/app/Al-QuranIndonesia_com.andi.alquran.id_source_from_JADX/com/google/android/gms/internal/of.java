package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.rc.C1938a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@op
public class of extends rl {
    private final C1155a f5167a;
    private final zzmk f5168b;
    private final C1938a f5169c;
    private final oh f5170d;
    private final Object f5171e;
    private Future<rc> f5172f;

    /* renamed from: com.google.android.gms.internal.of.1 */
    class C18511 implements Runnable {
        final /* synthetic */ rc f5165a;
        final /* synthetic */ of f5166b;

        C18511(of ofVar, rc rcVar) {
            this.f5166b = ofVar;
            this.f5165a = rcVar;
        }

        public void run() {
            this.f5166b.f5167a.zzb(this.f5165a);
        }
    }

    public of(Context context, zzr com_google_android_gms_ads_internal_zzr, C1938a c1938a, cg cgVar, C1155a c1155a, io ioVar) {
        this(c1938a, c1155a, new oh(context, com_google_android_gms_ads_internal_zzr, new rx(context), cgVar, c1938a, ioVar));
    }

    of(C1938a c1938a, C1155a c1155a, oh ohVar) {
        this.f5171e = new Object();
        this.f5169c = c1938a;
        this.f5168b = c1938a.f5595b;
        this.f5167a = c1155a;
        this.f5170d = ohVar;
    }

    private rc m7836a(int i) {
        return new rc(this.f5169c.f5594a.f6542c, null, null, i, null, null, this.f5168b.f6593l, this.f5168b.f6592k, this.f5169c.f5594a.f6548i, false, null, null, null, null, null, this.f5168b.f6590i, this.f5169c.f5597d, this.f5168b.f6588g, this.f5169c.f5599f, this.f5168b.f6595n, this.f5168b.f6596o, this.f5169c.f5601h, null, null, null, null, this.f5169c.f5595b.f6571F, this.f5169c.f5595b.f6572G, null, null, this.f5168b.f6579N);
    }

    public void onStop() {
        synchronized (this.f5171e) {
            if (this.f5172f != null) {
                this.f5172f.cancel(true);
            }
        }
    }

    public void zzcm() {
        rc rcVar;
        int i;
        try {
            synchronized (this.f5171e) {
                this.f5172f = rp.m8473a(this.f5170d);
            }
            rcVar = (rc) this.f5172f.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            sg.m8449e("Timed out waiting for native ad.");
            this.f5172f.cancel(true);
            i = 2;
            rcVar = null;
        } catch (ExecutionException e2) {
            rcVar = null;
            i = 0;
        } catch (InterruptedException e3) {
            rcVar = null;
            i = 0;
        } catch (CancellationException e4) {
            rcVar = null;
            i = 0;
        }
        if (rcVar == null) {
            rcVar = m7836a(i);
        }
        rq.f5755a.post(new C18511(this, rcVar));
    }
}
