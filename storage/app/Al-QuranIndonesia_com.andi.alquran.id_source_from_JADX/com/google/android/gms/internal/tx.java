package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.C1230m;
import com.google.android.gms.common.internal.C1314c;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class tx extends C1230m<tx> {
    private String f6010a;
    private int f6011b;
    private int f6012c;
    private String f6013d;
    private String f6014e;
    private boolean f6015f;
    private boolean f6016g;

    public tx() {
        this(false);
    }

    public tx(boolean z) {
        this(z, m9093a());
    }

    public tx(boolean z, int i) {
        C1314c.m4622a(i);
        this.f6011b = i;
        this.f6016g = z;
    }

    static int m9093a() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public void m9094a(int i) {
        this.f6011b = i;
    }

    public /* synthetic */ void m9095a(C1230m c1230m) {
        m9096a((tx) c1230m);
    }

    public void m9096a(tx txVar) {
        if (!TextUtils.isEmpty(this.f6010a)) {
            txVar.m9097a(this.f6010a);
        }
        if (this.f6011b != 0) {
            txVar.m9094a(this.f6011b);
        }
        if (this.f6012c != 0) {
            txVar.m9100b(this.f6012c);
        }
        if (!TextUtils.isEmpty(this.f6013d)) {
            txVar.m9101b(this.f6013d);
        }
        if (!TextUtils.isEmpty(this.f6014e)) {
            txVar.m9104c(this.f6014e);
        }
        if (this.f6015f) {
            txVar.m9102b(this.f6015f);
        }
        if (this.f6016g) {
            txVar.m9098a(this.f6016g);
        }
    }

    public void m9097a(String str) {
        this.f6010a = str;
    }

    public void m9098a(boolean z) {
        this.f6016g = z;
    }

    public String m9099b() {
        return this.f6010a;
    }

    public void m9100b(int i) {
        this.f6012c = i;
    }

    public void m9101b(String str) {
        this.f6013d = str;
    }

    public void m9102b(boolean z) {
        this.f6015f = z;
    }

    public int m9103c() {
        return this.f6011b;
    }

    public void m9104c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f6014e = null;
        } else {
            this.f6014e = str;
        }
    }

    public String m9105d() {
        return this.f6014e;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.f6010a);
        hashMap.put("interstitial", Boolean.valueOf(this.f6015f));
        hashMap.put("automatic", Boolean.valueOf(this.f6016g));
        hashMap.put("screenId", Integer.valueOf(this.f6011b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.f6012c));
        hashMap.put("referrerScreenName", this.f6013d);
        hashMap.put("referrerUri", this.f6014e);
        return C1230m.m4358a((Object) hashMap);
    }
}
