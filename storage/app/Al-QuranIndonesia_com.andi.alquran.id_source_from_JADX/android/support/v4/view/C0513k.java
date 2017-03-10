package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

@TargetApi(9)
/* renamed from: android.support.v4.view.k */
class C0513k {

    /* renamed from: android.support.v4.view.k.a */
    static class C0512a implements Factory {
        final C0183n f946a;

        C0512a(C0183n c0183n) {
            this.f946a = c0183n;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f946a.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f946a + "}";
        }
    }

    static C0183n m2174a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        return factory instanceof C0512a ? ((C0512a) factory).f946a : null;
    }

    static void m2175a(LayoutInflater layoutInflater, C0183n c0183n) {
        layoutInflater.setFactory(c0183n != null ? new C0512a(c0183n) : null);
    }
}
