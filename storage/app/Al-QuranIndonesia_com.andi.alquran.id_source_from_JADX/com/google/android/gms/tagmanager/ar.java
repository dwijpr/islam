package com.google.android.gms.tagmanager;

import android.util.Log;

public class ar implements C2214o {
    private int f7088a;

    public ar() {
        this.f7088a = 5;
    }

    public void m10207a(String str) {
        if (this.f7088a <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void m10208a(String str, Throwable th) {
        if (this.f7088a <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void m10209b(String str) {
        if (this.f7088a <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void m10210b(String str, Throwable th) {
        if (this.f7088a <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void m10211c(String str) {
        if (this.f7088a <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void m10212d(String str) {
        if (this.f7088a <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }
}
