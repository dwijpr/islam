package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.google.android.gms.analytics.k */
public final class C1228k implements C1224p {
    private static final Uri f2873a;
    private final LogPrinter f2874b;

    /* renamed from: com.google.android.gms.analytics.k.1 */
    class C12271 implements Comparator<C1230m> {
        C12271(C1228k c1228k) {
        }

        public int m4339a(C1230m c1230m, C1230m c1230m2) {
            return c1230m.getClass().getCanonicalName().compareTo(c1230m2.getClass().getCanonicalName());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4339a((C1230m) obj, (C1230m) obj2);
        }
    }

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        f2873a = builder.build();
    }

    public C1228k() {
        this.f2874b = new LogPrinter(4, "GA/LogCatTransport");
    }

    public Uri m4340a() {
        return f2873a;
    }

    public void m4341a(C1229l c1229l) {
        List<C1230m> arrayList = new ArrayList(c1229l.m4348b());
        Collections.sort(arrayList, new C12271(this));
        StringBuilder stringBuilder = new StringBuilder();
        for (C1230m obj : arrayList) {
            Object obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj2);
            }
        }
        this.f2874b.println(stringBuilder.toString());
    }
}
