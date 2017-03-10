package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.ai;

/* renamed from: com.google.android.gms.common.api.e */
public final class C1280e {
    public static C1279d<Status> m4554a(Status status) {
        C1314c.m4624a((Object) status, (Object) "Result must not be null");
        C1279d aiVar = new ai(Looper.getMainLooper());
        aiVar.m5076a((C1263g) status);
        return aiVar;
    }
}
