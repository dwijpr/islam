package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public abstract class StatsEvent extends zza implements ReflectedParcelable {
    public abstract long m4885a();

    public abstract int m4886b();

    public abstract long m4887c();

    public abstract String m4888d();

    public String toString() {
        long a = m4885a();
        String valueOf = String.valueOf("\t");
        int b = m4886b();
        String valueOf2 = String.valueOf("\t");
        long c = m4887c();
        String valueOf3 = String.valueOf(m4888d());
        return new StringBuilder(((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(a).append(valueOf).append(b).append(valueOf2).append(c).append(valueOf3).toString();
    }
}
