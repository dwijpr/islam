package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.oh.C1864a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@op
public class oj implements C1864a<iy> {
    private final boolean f5248a;
    private final boolean f5249b;

    public oj(boolean z, boolean z2) {
        this.f5248a = z;
        this.f5249b = z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.sx m7912a(com.google.android.gms.internal.sn<com.google.android.gms.internal.sx> r4) {
        /*
        r3 = this;
        r0 = com.google.android.gms.internal.C1648if.ci;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r0.m6682c();	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (java.lang.Integer) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r0.intValue();	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = r4.get(r0, r2);	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
        r0 = (com.google.android.gms.internal.sx) r0;	 Catch:{ InterruptedException -> 0x0016, ExecutionException -> 0x0025, TimeoutException -> 0x002e, CancellationException -> 0x002c }
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = move-exception;
        r1 = "InterruptedException occurred while waiting for video to load";
        com.google.android.gms.internal.sg.m8447c(r1, r0);
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
    L_0x0023:
        r0 = 0;
        goto L_0x0015;
    L_0x0025:
        r0 = move-exception;
    L_0x0026:
        r1 = "Exception occurred while waiting for video to load";
        com.google.android.gms.internal.sg.m8447c(r1, r0);
        goto L_0x0023;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0026;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.oj.a(com.google.android.gms.internal.sn):com.google.android.gms.internal.sx");
    }

    public /* synthetic */ C1660a m7913a(oh ohVar, JSONObject jSONObject) {
        return m7914b(ohVar, jSONObject);
    }

    public iy m7914b(oh ohVar, JSONObject jSONObject) {
        List<sn> a = ohVar.m7889a(jSONObject, "images", true, this.f5248a, this.f5249b);
        Future a2 = ohVar.m7888a(jSONObject, "app_icon", true, this.f5248a);
        sn a3 = ohVar.m7887a(jSONObject, "video");
        Future b = ohVar.m7893b(jSONObject);
        List arrayList = new ArrayList();
        for (sn snVar : a) {
            arrayList.add((ix) snVar.get());
        }
        sx a4 = m7912a(a3);
        return new iy(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (jh) a2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (iv) b.get(), new Bundle(), a4 != null ? a4.m8790z() : null, a4 != null ? a4.m8760b() : null);
    }
}
