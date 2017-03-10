package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class nm {
    private AtomicInteger f5096a;
    private final Map<String, Queue<ml<?>>> f5097b;
    private final Set<ml<?>> f5098c;
    private final PriorityBlockingQueue<ml<?>> f5099d;
    private final PriorityBlockingQueue<ml<?>> f5100e;
    private final cz f5101f;
    private final hk f5102g;
    private final pi f5103h;
    private ii[] f5104i;
    private es f5105j;
    private List<Object> f5106k;

    public nm(cz czVar, hk hkVar) {
        this(czVar, hkVar, 4);
    }

    public nm(cz czVar, hk hkVar, int i) {
        this(czVar, hkVar, i, new gk(new Handler(Looper.getMainLooper())));
    }

    public nm(cz czVar, hk hkVar, int i, pi piVar) {
        this.f5096a = new AtomicInteger();
        this.f5097b = new HashMap();
        this.f5098c = new HashSet();
        this.f5099d = new PriorityBlockingQueue();
        this.f5100e = new PriorityBlockingQueue();
        this.f5106k = new ArrayList();
        this.f5101f = czVar;
        this.f5102g = hkVar;
        this.f5104i = new ii[i];
        this.f5103h = piVar;
    }

    public <T> ml<T> m7769a(ml<T> mlVar) {
        mlVar.m7602a(this);
        synchronized (this.f5098c) {
            this.f5098c.add(mlVar);
        }
        mlVar.m7600a(m7773c());
        mlVar.m7609b("add-to-queue");
        if (mlVar.m7620l()) {
            synchronized (this.f5097b) {
                String d = mlVar.m7612d();
                if (this.f5097b.containsKey(d)) {
                    Queue queue = (Queue) this.f5097b.get(d);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(mlVar);
                    this.f5097b.put(d, queue);
                    if (uj.f6092b) {
                        uj.m9227a("Request for cacheKey=%s is in flight, putting on hold.", d);
                    }
                } else {
                    this.f5097b.put(d, null);
                    this.f5099d.add(mlVar);
                }
            }
        } else {
            this.f5100e.add(mlVar);
        }
        return mlVar;
    }

    public void m7770a() {
        m7771b();
        this.f5105j = new es(this.f5099d, this.f5100e, this.f5101f, this.f5103h);
        this.f5105j.start();
        for (int i = 0; i < this.f5104i.length; i++) {
            ii iiVar = new ii(this.f5100e, this.f5102g, this.f5101f, this.f5103h);
            this.f5104i[i] = iiVar;
            iiVar.start();
        }
    }

    public void m7771b() {
        if (this.f5105j != null) {
            this.f5105j.m5976a();
        }
        for (int i = 0; i < this.f5104i.length; i++) {
            if (this.f5104i[i] != null) {
                this.f5104i[i].m6722a();
            }
        }
    }

    <T> void m7772b(ml<T> mlVar) {
        synchronized (this.f5098c) {
            this.f5098c.remove(mlVar);
        }
        synchronized (this.f5106k) {
            Iterator it = this.f5106k.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (mlVar.m7620l()) {
            synchronized (this.f5097b) {
                Queue queue = (Queue) this.f5097b.remove(mlVar.m7612d());
                if (queue != null) {
                    if (uj.f6092b) {
                        uj.m9227a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f5099d.addAll(queue);
                }
            }
        }
    }

    public int m7773c() {
        return this.f5096a.incrementAndGet();
    }
}
