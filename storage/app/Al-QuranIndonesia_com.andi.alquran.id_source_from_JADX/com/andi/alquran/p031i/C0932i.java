package com.andi.alquran.p031i;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.andi.alquran.i.i */
public abstract class C0932i implements Runnable {
    protected Handler f1878a;
    boolean f1879b;

    public C0932i(Handler handler) {
        this.f1879b = false;
        this.f1878a = handler;
    }

    protected abstract void m3243a();

    protected void m3244a(Message message) {
        this.f1878a.sendMessage(message);
    }

    public void m3245b() {
        this.f1879b = true;
    }

    public void run() {
        try {
            m3243a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
