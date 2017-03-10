package com.google.p033a.p035b.p036a;

import com.google.p033a.C0974s;
import com.google.p033a.C0976r;
import com.google.p033a.C1073e;
import com.google.p033a.p034a.C0969b;
import com.google.p033a.p035b.C1030c;
import com.google.p033a.p038c.C1061a;

/* renamed from: com.google.a.b.a.d */
public final class C0982d implements C0974s {
    private final C1030c f1988a;

    public C0982d(C1030c c1030c) {
        this.f1988a = c1030c;
    }

    static C0976r<?> m3421a(C1030c c1030c, C1073e c1073e, C1061a<?> c1061a, C0969b c0969b) {
        Class a = c0969b.m3395a();
        if (C0976r.class.isAssignableFrom(a)) {
            return (C0976r) c1030c.m3717a(C1061a.m3771b(a)).m3701a();
        }
        if (C0974s.class.isAssignableFrom(a)) {
            return ((C0974s) c1030c.m3717a(C1061a.m3771b(a)).m3701a()).m3402a(c1073e, c1061a);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    public <T> C0976r<T> m3422a(C1073e c1073e, C1061a<T> c1061a) {
        C0969b c0969b = (C0969b) c1061a.m3772a().getAnnotation(C0969b.class);
        return c0969b == null ? null : C0982d.m3421a(this.f1988a, c1073e, c1061a, c0969b);
    }
}
