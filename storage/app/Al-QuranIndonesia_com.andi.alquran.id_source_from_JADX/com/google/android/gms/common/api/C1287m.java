package com.google.android.gms.common.api;

import android.support.v4.p014g.C0298a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.wj;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.api.m */
public class C1287m extends Exception {
    private final C0298a<wj<?>, ConnectionResult> f3012a;

    public C1287m(C0298a<wj<?>, ConnectionResult> c0298a) {
        this.f3012a = c0298a;
    }

    public C0298a<wj<?>, ConnectionResult> m4561a() {
        return this.f3012a;
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (wj wjVar : this.f3012a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.f3012a.get(wjVar);
            if (connectionResult.m4452b()) {
                obj = null;
            }
            String valueOf = String.valueOf(wjVar.m9672a());
            String valueOf2 = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder((String.valueOf(valueOf).length() + 2) + String.valueOf(valueOf2).length()).append(valueOf).append(": ").append(valueOf2).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj != null) {
            stringBuilder.append("None of the queried APIs are available. ");
        } else {
            stringBuilder.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder.append(TextUtils.join("; ", arrayList));
        return stringBuilder.toString();
    }
}
