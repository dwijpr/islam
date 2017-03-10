package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@op
public class rz {
    Map<Integer, Bitmap> f5814a;
    private AtomicInteger f5815b;

    public rz() {
        this.f5814a = new ConcurrentHashMap();
        this.f5815b = new AtomicInteger(0);
    }

    public int m8671a(Bitmap bitmap) {
        if (bitmap == null) {
            sg.m8444b("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        this.f5814a.put(Integer.valueOf(this.f5815b.get()), bitmap);
        return this.f5815b.getAndIncrement();
    }

    public Bitmap m8672a(Integer num) {
        return (Bitmap) this.f5814a.get(num);
    }

    public void m8673b(Integer num) {
        this.f5814a.remove(num);
    }
}
