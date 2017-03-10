package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a.C1240a.C1264b;
import com.google.android.gms.common.api.C1277c;
import com.google.android.gms.common.api.C1279d;
import com.google.android.gms.common.api.C1288n;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.wd.C2058a;
import com.google.android.gms.internal.wm.C1475a;

public class wa extends C1288n<C1264b> implements vy {

    /* renamed from: com.google.android.gms.internal.wa.a */
    static final class C2060a extends C1475a<Status, wb> {
        private final zzzh f6306a;

        /* renamed from: com.google.android.gms.internal.wa.a.1 */
        class C20591 extends C2058a {
            final /* synthetic */ C2060a f6305a;

            C20591(C2060a c2060a) {
                this.f6305a = c2060a;
            }

            public void m9616a(Status status) {
                this.f6305a.m5076a((C1263g) status);
            }

            public void m9617b(Status status) {
                throw new UnsupportedOperationException();
            }
        }

        C2060a(zzzh com_google_android_gms_internal_zzzh, C1277c c1277c) {
            super(vx.f6292c, c1277c);
            this.f6306a = com_google_android_gms_internal_zzzh;
        }

        protected Status m9618a(Status status) {
            return status;
        }

        protected void m9620a(wb wbVar) {
            wd c20591 = new C20591(this);
            try {
                wa.m9623b(this.f6306a);
                wbVar.m9626a(c20591, this.f6306a);
            } catch (Throwable e) {
                Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
                m5324c(new Status(10, "MessageProducer"));
            }
        }

        protected /* synthetic */ C1263g m9621b(Status status) {
            return m9618a(status);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C2060a)) {
                return false;
            }
            return this.f6306a.equals(((C2060a) obj).f6306a);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f6306a);
            return new StringBuilder(String.valueOf(valueOf).length() + 20).append("LogEventMethodImpl(").append(valueOf).append(")").toString();
        }
    }

    wa(Context context) {
        super(context, vx.f6292c, null, new wi());
    }

    public static vy m9622a(Context context) {
        return new wa(context);
    }

    static void m9623b(zzzh com_google_android_gms_internal_zzzh) {
        if (com_google_android_gms_internal_zzzh.f6652j != null && com_google_android_gms_internal_zzzh.f6651i.f3885k.length == 0) {
            com_google_android_gms_internal_zzzh.f6651i.f3885k = com_google_android_gms_internal_zzzh.f6652j.m9584a();
        }
        if (com_google_android_gms_internal_zzzh.f6653k != null && com_google_android_gms_internal_zzzh.f6651i.f3891q.length == 0) {
            com_google_android_gms_internal_zzzh.f6651i.f3891q = com_google_android_gms_internal_zzzh.f6653k.m9584a();
        }
        com_google_android_gms_internal_zzzh.f6645c = eg.m5148a(com_google_android_gms_internal_zzzh.f6651i);
    }

    public C1279d<Status> m9624a(zzzh com_google_android_gms_internal_zzzh) {
        return m4568b(new C2060a(com_google_android_gms_internal_zzzh, m4569c()));
    }
}
