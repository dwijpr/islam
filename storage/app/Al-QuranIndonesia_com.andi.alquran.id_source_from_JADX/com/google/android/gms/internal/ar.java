package com.google.android.gms.internal;

import android.content.Context;

public class ar {
    private static ar f3343b;
    private aq f3344a;

    static {
        f3343b = new ar();
    }

    public ar() {
        this.f3344a = null;
    }

    public static aq m5144b(Context context) {
        return f3343b.m5145a(context);
    }

    public synchronized aq m5145a(Context context) {
        if (this.f3344a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f3344a = new aq(context);
        }
        return this.f3344a;
    }
}
