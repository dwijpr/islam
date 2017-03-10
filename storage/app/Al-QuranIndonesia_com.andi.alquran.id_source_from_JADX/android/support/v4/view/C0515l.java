package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.C0513k.C0512a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

@TargetApi(11)
/* renamed from: android.support.v4.view.l */
class C0515l {
    private static Field f947a;
    private static boolean f948b;

    /* renamed from: android.support.v4.view.l.a */
    static class C0514a extends C0512a implements Factory2 {
        C0514a(C0183n c0183n) {
            super(c0183n);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.onCreateView(view, str, context, attributeSet);
        }
    }

    static void m2176a(LayoutInflater layoutInflater, C0183n c0183n) {
        Factory2 c0514a = c0183n != null ? new C0514a(c0183n) : null;
        layoutInflater.setFactory2(c0514a);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            C0515l.m2177a(layoutInflater, (Factory2) factory);
        } else {
            C0515l.m2177a(layoutInflater, c0514a);
        }
    }

    static void m2177a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f948b) {
            try {
                f947a = LayoutInflater.class.getDeclaredField("mFactory2");
                f947a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f948b = true;
        }
        if (f947a != null) {
            try {
                f947a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
