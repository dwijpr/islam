package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.internal.C1319o;
import com.google.android.gms.common.internal.C1338k;
import com.google.android.gms.internal.bt.C1487a;

public class bm extends C1319o<bt> {
    protected final cb<bt> f3617e;
    private final String f3618f;

    /* renamed from: com.google.android.gms.internal.bm.1 */
    class C14731 implements cb<bt> {
        final /* synthetic */ bm f3616a;

        C14731(bm bmVar) {
            this.f3616a = bmVar;
        }

        public void m5305a() {
            this.f3616a.m4681s();
        }

        public bt m5306b() {
            return (bt) this.f3616a.m4683u();
        }

        public /* synthetic */ IInterface m5307c() {
            return m5306b();
        }
    }

    public bm(Context context, Looper looper, C0777b c0777b, C0778c c0778c, String str, C1338k c1338k) {
        super(context, looper, 23, c1338k, c0777b, c0778c);
        this.f3617e = new C14731(this);
        this.f3618f = str;
    }

    protected /* synthetic */ IInterface m5309a(IBinder iBinder) {
        return m5310b(iBinder);
    }

    protected bt m5310b(IBinder iBinder) {
        return C1487a.m5417a(iBinder);
    }

    protected String m5311i() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String m5312j() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected Bundle m5313r() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f3618f);
        return bundle;
    }
}
