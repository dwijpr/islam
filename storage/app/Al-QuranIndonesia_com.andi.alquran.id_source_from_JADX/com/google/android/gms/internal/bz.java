package com.google.android.gms.internal;

import android.content.Context;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.as.C1438a;
import com.google.android.gms.internal.au.C1444a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class bz extends ce {
    private static final String f3649s;
    private Info f3650t;

    static {
        f3649s = bz.class.getSimpleName();
    }

    protected bz(Context context) {
        super(context, BuildConfig.VERSION_NAME);
    }

    public static bz m5469b(Context context) {
        ce.m5456a(context, true);
        return new bz(context);
    }

    protected C1444a m5470a(Context context, View view) {
        return null;
    }

    public String m5471a(String str, String str2) {
        return ba.m5233a(str, str2, true);
    }

    public void m5472a(Info info) {
        this.f3650t = info;
    }

    protected void m5473a(dc dcVar, C1444a c1444a, C1438a c1438a) {
        if (!dcVar.m5705h()) {
            m5465a(m5474b(dcVar, c1444a, c1438a));
        } else if (this.f3650t != null) {
            String id = this.f3650t.getId();
            if (!TextUtils.isEmpty(id)) {
                c1444a.aa = de.m5719a(id);
                c1444a.ab = Integer.valueOf(5);
                c1444a.ac = Boolean.valueOf(this.f3650t.isLimitAdTrackingEnabled());
            }
            this.f3650t = null;
        }
    }

    protected List<Callable<Void>> m5474b(dc dcVar, C1444a c1444a, C1438a c1438a) {
        List<Callable<Void>> arrayList = new ArrayList();
        if (dcVar.m5700c() == null) {
            return arrayList;
        }
        dc dcVar2 = dcVar;
        arrayList.add(new C1524do(dcVar2, cu.m5639n(), cu.m5640o(), c1444a, dcVar.m5715r(), 24));
        return arrayList;
    }
}
