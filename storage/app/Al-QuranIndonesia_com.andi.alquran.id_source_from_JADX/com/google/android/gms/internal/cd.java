package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.C1314c;

public class cd {
    public static Looper m5523a() {
        C1314c.m4629a(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
