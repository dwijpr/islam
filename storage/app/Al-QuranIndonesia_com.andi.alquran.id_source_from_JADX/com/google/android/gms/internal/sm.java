package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@op
public class sm {

    /* renamed from: com.google.android.gms.internal.sm.a */
    public interface C1860a<D, R> {
        R m7860a(D d);
    }

    /* renamed from: com.google.android.gms.internal.sm.1 */
    class C19961 implements Runnable {
        final /* synthetic */ sk f5841a;
        final /* synthetic */ C1860a f5842b;
        final /* synthetic */ sn f5843c;

        C19961(sk skVar, C1860a c1860a, sn snVar) {
            this.f5841a = skVar;
            this.f5842b = c1860a;
            this.f5843c = snVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = r3.f5841a;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r1 = r3.f5842b;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r2 = r3.f5843c;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r2 = r2.get();	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r1 = r1.m7860a(r2);	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r0.m7304b(r1);	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
        L_0x0011:
            return;
        L_0x0012:
            r0 = move-exception;
        L_0x0013:
            r0 = r3.f5841a;
            r1 = 1;
            r0.cancel(r1);
            goto L_0x0011;
        L_0x001a:
            r0 = move-exception;
            goto L_0x0013;
        L_0x001c:
            r0 = move-exception;
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.sm.1.run():void");
        }
    }

    /* renamed from: com.google.android.gms.internal.sm.2 */
    class C19972 implements Runnable {
        final /* synthetic */ AtomicInteger f5844a;
        final /* synthetic */ int f5845b;
        final /* synthetic */ sk f5846c;
        final /* synthetic */ List f5847d;

        C19972(AtomicInteger atomicInteger, int i, sk skVar, List list) {
            this.f5844a = atomicInteger;
            this.f5845b = i;
            this.f5846c = skVar;
            this.f5847d = list;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.f5844a;
            r0 = r0.incrementAndGet();
            r1 = r2.f5845b;
            if (r0 < r1) goto L_0x0015;
        L_0x000a:
            r0 = r2.f5846c;	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r1 = r2.f5847d;	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r1 = com.google.android.gms.internal.sm.m8717c(r1);	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r0.m7304b(r1);	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
        L_0x0015:
            return;
        L_0x0016:
            r0 = move-exception;
        L_0x0017:
            r1 = "Unable to convert list of futures to a future of list";
            com.google.android.gms.internal.sg.m8447c(r1, r0);
            goto L_0x0015;
        L_0x001d:
            r0 = move-exception;
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.sm.2.run():void");
        }
    }

    public static <A, B> sn<B> m8714a(sn<A> snVar, C1860a<A, B> c1860a) {
        sn skVar = new sk();
        snVar.m7300a(new C19961(skVar, c1860a, snVar));
        return skVar;
    }

    public static <V> sn<List<V>> m8715a(List<sn<V>> list) {
        sn skVar = new sk();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (sn a : list) {
            a.m7300a(new C19972(atomicInteger, size, skVar, list));
        }
        return skVar;
    }

    private static <V> List<V> m8717c(List<sn<V>> list) {
        List<V> arrayList = new ArrayList();
        for (sn snVar : list) {
            Object obj = snVar.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
