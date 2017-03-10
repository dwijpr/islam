package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.v4.view.C0515l.C0514a;
import android.view.LayoutInflater;

@TargetApi(21)
/* renamed from: android.support.v4.view.m */
class C0516m {
    static void m2178a(LayoutInflater layoutInflater, C0183n c0183n) {
        layoutInflater.setFactory2(c0183n != null ? new C0514a(c0183n) : null);
    }
}
