package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1279d;
import com.google.android.gms.common.api.C1281f;
import com.google.android.gms.common.api.C1282h;
import com.google.android.gms.common.api.C1283i;
import com.google.android.gms.common.api.C1284j;
import com.google.android.gms.common.api.C1285k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.maps.GoogleMap;
import java.lang.ref.WeakReference;

public class aj<R extends C1263g> extends C1285k<R> implements C1282h<R> {
    private C1284j<? super R, ? extends C1263g> f3310a;
    private aj<? extends C1263g> f3311b;
    private volatile C1283i<? super R> f3312c;
    private C1279d<R> f3313d;
    private final Object f3314e;
    private Status f3315f;
    private final WeakReference<C1277c> f3316g;
    private final C1428a f3317h;
    private boolean f3318i;

    /* renamed from: com.google.android.gms.internal.aj.1 */
    class C14271 implements Runnable {
        final /* synthetic */ C1263g f3307a;
        final /* synthetic */ aj f3308b;

        C14271(aj ajVar, C1263g c1263g) {
            this.f3308b = ajVar;
            this.f3307a = c1263g;
        }

        public void run() {
            C1277c c1277c;
            try {
                wo.f3291c.set(Boolean.valueOf(true));
                this.f3308b.f3317h.sendMessage(this.f3308b.f3317h.obtainMessage(0, this.f3308b.f3310a.m4560a(this.f3307a)));
                wo.f3291c.set(Boolean.valueOf(false));
                this.f3308b.m5096b(this.f3307a);
                c1277c = (C1277c) this.f3308b.f3316g.get();
                if (c1277c != null) {
                    c1277c.m4548b(this.f3308b);
                }
            } catch (RuntimeException e) {
                this.f3308b.f3317h.sendMessage(this.f3308b.f3317h.obtainMessage(1, e));
                wo.f3291c.set(Boolean.valueOf(false));
                this.f3308b.m5096b(this.f3307a);
                c1277c = (C1277c) this.f3308b.f3316g.get();
                if (c1277c != null) {
                    c1277c.m4548b(this.f3308b);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                wo.f3291c.set(Boolean.valueOf(false));
                this.f3308b.m5096b(this.f3307a);
                c1277c = (C1277c) this.f3308b.f3316g.get();
                if (c1277c != null) {
                    c1277c.m4548b(this.f3308b);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.aj.a */
    private final class C1428a extends Handler {
        final /* synthetic */ aj f3309a;

        public void handleMessage(Message message) {
            switch (message.what) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    C1279d c1279d = (C1279d) message.obj;
                    synchronized (this.f3309a.f3314e) {
                        if (c1279d != null) {
                            if (c1279d instanceof ae) {
                                this.f3309a.f3311b.m5090a(((ae) c1279d).m5046b());
                            } else {
                                this.f3309a.f3311b.m5102a(c1279d);
                            }
                            break;
                        }
                        this.f3309a.f3311b.m5090a(new Status(13, "Transform returned null"));
                        break;
                    }
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
            }
        }
    }

    private void m5090a(Status status) {
        synchronized (this.f3314e) {
            this.f3315f = status;
            m5095b(this.f3315f);
        }
    }

    private void m5094b() {
        if (this.f3310a != null || this.f3312c != null) {
            C1277c c1277c = (C1277c) this.f3316g.get();
            if (!(this.f3318i || this.f3310a == null || c1277c == null)) {
                c1277c.m4544a(this);
                this.f3318i = true;
            }
            if (this.f3315f != null) {
                m5095b(this.f3315f);
            } else if (this.f3313d != null) {
                this.f3313d.m4553a((C1282h) this);
            }
        }
    }

    private void m5095b(Status status) {
        synchronized (this.f3314e) {
            if (this.f3310a != null) {
                Status a = this.f3310a.m4559a(status);
                C1314c.m4624a((Object) a, (Object) "onFailure must not return null");
                this.f3311b.m5090a(a);
            } else if (m5098c()) {
                this.f3312c.m4557a(status);
            }
        }
    }

    private void m5096b(C1263g c1263g) {
        if (c1263g instanceof C1281f) {
            try {
                ((C1281f) c1263g).m4555a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c1263g);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean m5098c() {
        return (this.f3312c == null || ((C1277c) this.f3316g.get()) == null) ? false : true;
    }

    void m5101a() {
        this.f3312c = null;
    }

    public void m5102a(C1279d<?> c1279d) {
        synchronized (this.f3314e) {
            this.f3313d = c1279d;
            m5094b();
        }
    }

    public void m5103a(R r) {
        synchronized (this.f3314e) {
            if (!r.m4501b().m4505d()) {
                m5090a(r.m4501b());
                m5096b((C1263g) r);
            } else if (this.f3310a != null) {
                ad.m5042a().submit(new C14271(this, r));
            } else if (m5098c()) {
                this.f3312c.m4558b(r);
            }
        }
    }
}
