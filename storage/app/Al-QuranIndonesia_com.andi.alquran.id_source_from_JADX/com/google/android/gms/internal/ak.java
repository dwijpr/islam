package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a.C1268d;
import com.google.android.gms.common.api.C1274a.C1269f;
import com.google.android.gms.common.api.C1289o;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.wm.C1475a;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class ak {
    public static final Status f3323a;
    private static final wo<?>[] f3324c;
    final Set<wo<?>> f3325b;
    private final C1429b f3326d;
    private final Map<C1268d<?>, C1269f> f3327e;

    /* renamed from: com.google.android.gms.internal.ak.b */
    interface C1429b {
        void m5104a(wo<?> woVar);
    }

    /* renamed from: com.google.android.gms.internal.ak.1 */
    class C14301 implements C1429b {
        final /* synthetic */ ak f3319a;

        C14301(ak akVar) {
            this.f3319a = akVar;
        }

        public void m5105a(wo<?> woVar) {
            this.f3319a.f3325b.remove(woVar);
            if (woVar.m5074a() != null) {
                null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ak.a */
    private static class C1431a implements DeathRecipient, C1429b {
        private final WeakReference<wo<?>> f3320a;
        private final WeakReference<C1289o> f3321b;
        private final WeakReference<IBinder> f3322c;

        private C1431a(wo<?> woVar, C1289o c1289o, IBinder iBinder) {
            this.f3321b = new WeakReference(c1289o);
            this.f3320a = new WeakReference(woVar);
            this.f3322c = new WeakReference(iBinder);
        }

        private void m5106a() {
            wo woVar = (wo) this.f3320a.get();
            C1289o c1289o = (C1289o) this.f3321b.get();
            if (!(c1289o == null || woVar == null)) {
                c1289o.m4571a(woVar.m5074a().intValue());
            }
            IBinder iBinder = (IBinder) this.f3322c.get();
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void m5107a(wo<?> woVar) {
            m5106a();
        }

        public void binderDied() {
            m5106a();
        }
    }

    static {
        f3323a = new Status(8, "The connection to Google Play services was lost");
        f3324c = new wo[0];
    }

    public ak(Map<C1268d<?>, C1269f> map) {
        this.f3325b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f3326d = new C14301(this);
        this.f3327e = map;
    }

    private static void m5109a(wo<?> woVar, C1289o c1289o, IBinder iBinder) {
        if (woVar.m5081d()) {
            woVar.m5078a(new C1431a(c1289o, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            woVar.m5078a(null);
            woVar.m5082e();
            c1289o.m4571a(woVar.m5074a().intValue());
        } else {
            C1429b c1431a = new C1431a(c1289o, iBinder, null);
            woVar.m5078a(c1431a);
            try {
                iBinder.linkToDeath(c1431a, 0);
            } catch (RemoteException e) {
                woVar.m5082e();
                c1289o.m4571a(woVar.m5074a().intValue());
            }
        }
    }

    public void m5110a() {
        for (wo woVar : (wo[]) this.f3325b.toArray(f3324c)) {
            woVar.m5078a(null);
            if (woVar.m5074a() != null) {
                woVar.m5085h();
                m5109a(woVar, null, ((C1269f) this.f3327e.get(((C1475a) woVar).m5321b())).m4521h());
                this.f3325b.remove(woVar);
            } else if (woVar.m5083f()) {
                this.f3325b.remove(woVar);
            }
        }
    }

    void m5111a(wo<? extends C1263g> woVar) {
        this.f3325b.add(woVar);
        woVar.m5078a(this.f3326d);
    }

    public void m5112a(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f3325b.size());
    }

    public void m5113b() {
        for (wo d : (wo[]) this.f3325b.toArray(f3324c)) {
            d.m5080d(f3323a);
        }
    }
}
