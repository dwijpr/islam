package com.andi.alquran.p031i;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.andi.alquran.i.k */
public abstract class C0934k implements Runnable {
    protected Handler f1882a;
    boolean f1883b;

    public C0934k(Handler handler) {
        this.f1883b = false;
        this.f1882a = handler;
    }

    protected abstract void m3255a();

    protected void m3256a(Message message) {
        this.f1882a.sendMessage(message);
    }

    public void m3257b() {
        this.f1883b = true;
    }

    public void run() {
        try {
            m3255a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
