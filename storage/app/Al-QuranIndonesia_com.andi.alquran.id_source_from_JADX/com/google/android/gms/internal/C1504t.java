package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1263g;
import com.google.android.gms.common.api.C1274a.C1267c;
import com.google.android.gms.internal.wm.C1475a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.internal.t */
public interface C1504t {

    /* renamed from: com.google.android.gms.internal.t.a */
    public interface C1501a {
        void m5475a(int i, boolean z);

        void m5476a(Bundle bundle);

        void m5477a(ConnectionResult connectionResult);
    }

    <A extends C1267c, T extends C1475a<? extends C1263g, A>> T m5484a(T t);

    void m5485a();

    void m5486a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    void m5487b();

    boolean m5488c();

    void m5489d();
}
