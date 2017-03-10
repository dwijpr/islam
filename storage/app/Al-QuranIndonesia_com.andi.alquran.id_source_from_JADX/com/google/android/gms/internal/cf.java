package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.as.C1438a;
import com.google.android.gms.internal.au.C1444a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class cf extends ce {
    private static final String f3668s;

    static {
        f3668s = cf.class.getSimpleName();
    }

    protected cf(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static cf m5524a(String str, Context context, boolean z) {
        ce.m5456a(context, z);
        return new cf(context, str, z);
    }

    protected List<Callable<Void>> m5525b(dc dcVar, C1444a c1444a, C1438a c1438a) {
        if (dcVar.m5700c() == null || !this.o) {
            return super.m5467b(dcVar, c1444a, c1438a);
        }
        int r = dcVar.m5715r();
        List<Callable<Void>> arrayList = new ArrayList();
        arrayList.addAll(super.m5467b(dcVar, c1444a, c1438a));
        arrayList.add(new C1524do(dcVar, cu.m5639n(), cu.m5640o(), c1444a, r, 24));
        return arrayList;
    }
}
