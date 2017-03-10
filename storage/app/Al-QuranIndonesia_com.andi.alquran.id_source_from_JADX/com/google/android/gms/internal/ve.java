package com.google.android.gms.internal;

import com.google.android.gms.common.util.C1377c;

public class ve {
    private final long f6199a;
    private final int f6200b;
    private double f6201c;
    private long f6202d;
    private final Object f6203e;
    private final String f6204f;
    private final C1377c f6205g;

    public ve(int i, long j, String str, C1377c c1377c) {
        this.f6203e = new Object();
        this.f6200b = i;
        this.f6201c = (double) this.f6200b;
        this.f6199a = j;
        this.f6204f = str;
        this.f6205g = c1377c;
    }

    public ve(String str, C1377c c1377c) {
        this(60, 2000, str, c1377c);
    }

    public boolean m9421a() {
        boolean z;
        synchronized (this.f6203e) {
            long a = this.f6205g.m4926a();
            if (this.f6201c < ((double) this.f6200b)) {
                double d = ((double) (a - this.f6202d)) / ((double) this.f6199a);
                if (d > 0.0d) {
                    this.f6201c = Math.min((double) this.f6200b, d + this.f6201c);
                }
            }
            this.f6202d = a;
            if (this.f6201c >= 1.0d) {
                this.f6201c -= 1.0d;
                z = true;
            } else {
                String str = this.f6204f;
                vf.m9427b(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
                z = false;
            }
        }
        return z;
    }
}
