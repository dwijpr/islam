package android.support.v4.p009b;

import android.content.SharedPreferences.Editor;

/* renamed from: android.support.v4.b.o */
public final class C0234o {

    /* renamed from: android.support.v4.b.o.a */
    public static final class C0233a {
        private static C0233a f560a;
        private final C0232a f561b;

        /* renamed from: android.support.v4.b.o.a.a */
        private static class C0232a {
            C0232a() {
            }

            public void m791a(Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError e) {
                    editor.commit();
                }
            }
        }

        private C0233a() {
            this.f561b = new C0232a();
        }

        public static C0233a m792a() {
            if (f560a == null) {
                f560a = new C0233a();
            }
            return f560a;
        }

        public void m793a(Editor editor) {
            this.f561b.m791a(editor);
        }
    }
}
