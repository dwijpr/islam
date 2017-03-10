package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1274a;
import com.google.android.gms.common.api.C1277c.C0777b;
import com.google.android.gms.common.api.C1277c.C0778c;
import com.google.android.gms.common.internal.C1314c;

public class wp implements C0777b, C0778c {
    public final C1274a<?> f6337a;
    private final int f6338b;
    private wq f6339c;

    public wp(C1274a<?> c1274a, int i) {
        this.f6337a = c1274a;
        this.f6338b = i;
    }

    private void m9693a() {
        C1314c.m4624a(this.f6339c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public void m9694a(int i) {
        m9693a();
        this.f6339c.m2642a(i);
    }

    public void m9695a(Bundle bundle) {
        m9693a();
        this.f6339c.m2643a(bundle);
    }

    public void m9696a(ConnectionResult connectionResult) {
        m9693a();
        this.f6339c.m7738a(connectionResult, this.f6337a, this.f6338b);
    }

    public void m9697a(wq wqVar) {
        this.f6339c = wqVar;
    }
}
