package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.C0144s.C0142d;

/* renamed from: android.support.design.widget.z */
class C0157z {
    static final C0142d f521a;

    /* renamed from: android.support.design.widget.z.1 */
    static class C01561 implements C0142d {
        C01561() {
        }

        public C0144s m686a() {
            return new C0144s(VERSION.SDK_INT >= 12 ? new C0149u() : new C0146t());
        }
    }

    static {
        f521a = new C01561();
    }

    static C0144s m687a() {
        return f521a.m615a();
    }

    static boolean m688a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
