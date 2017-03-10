package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@op
public final class et {
    private final ex f3922a;

    public et(String str, Context context, boolean z) {
        this.f3922a = ew.m6006a(str, context, z);
    }

    public Uri m5977a(Uri uri, Context context) {
        C1108c a = this.f3922a.m5980a(C1111d.m3896a((Object) uri), C1111d.m3896a((Object) context));
        if (a != null) {
            return (Uri) C1111d.m3897a(a);
        }
        throw new eu();
    }

    public void m5978a(MotionEvent motionEvent) {
        this.f3922a.m5991d(C1111d.m3896a((Object) motionEvent));
    }

    public Uri m5979b(Uri uri, Context context) {
        C1108c b = this.f3922a.m5988b(C1111d.m3896a((Object) uri), C1111d.m3896a((Object) context));
        if (b != null) {
            return (Uri) C1111d.m3897a(b);
        }
        throw new eu();
    }
}
