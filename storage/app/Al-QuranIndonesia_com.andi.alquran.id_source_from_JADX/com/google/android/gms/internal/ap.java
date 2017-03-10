package com.google.android.gms.internal;

import android.os.Process;

class ap implements Runnable {
    private final Runnable f3340a;
    private final int f3341b;

    public ap(Runnable runnable, int i) {
        this.f3340a = runnable;
        this.f3341b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f3341b);
        this.f3340a.run();
    }
}
