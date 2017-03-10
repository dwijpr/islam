package android.support.v4.p009b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.b.i */
public final class C0225i {
    private static final C0221a f546a;

    /* renamed from: android.support.v4.b.i.a */
    interface C0221a {
        Intent m767a(ComponentName componentName);
    }

    /* renamed from: android.support.v4.b.i.b */
    static class C0222b implements C0221a {
        C0222b() {
        }

        public Intent m768a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    /* renamed from: android.support.v4.b.i.c */
    static class C0223c extends C0222b {
        C0223c() {
        }

        public Intent m769a(ComponentName componentName) {
            return C0226j.m771a(componentName);
        }
    }

    /* renamed from: android.support.v4.b.i.d */
    static class C0224d extends C0223c {
        C0224d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f546a = new C0224d();
        } else if (i >= 11) {
            f546a = new C0223c();
        } else {
            f546a = new C0222b();
        }
    }

    public static Intent m770a(ComponentName componentName) {
        return f546a.m767a(componentName);
    }
}
