package android.support.v4.view;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

@TargetApi(16)
/* renamed from: android.support.v4.view.c */
class C0488c {

    /* renamed from: android.support.v4.view.c.a */
    public interface C0381a {
        Object m1378a(View view);

        void m1379a(View view, int i);

        void m1380a(View view, Object obj);

        boolean m1381a(View view, int i, Bundle bundle);

        boolean m1382a(View view, AccessibilityEvent accessibilityEvent);

        boolean m1383a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m1384b(View view, AccessibilityEvent accessibilityEvent);

        void m1385c(View view, AccessibilityEvent accessibilityEvent);

        void m1386d(View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.c.1 */
    static class C04871 extends AccessibilityDelegate {
        final /* synthetic */ C0381a f915a;

        C04871(C0381a c0381a) {
            this.f915a = c0381a;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f915a.m1382a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return (AccessibilityNodeProvider) this.f915a.m1378a(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f915a.m1384b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f915a.m1380a(view, (Object) accessibilityNodeInfo);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f915a.m1385c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f915a.m1383a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f915a.m1381a(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f915a.m1379a(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f915a.m1386d(view, accessibilityEvent);
        }
    }

    public static Object m2124a(C0381a c0381a) {
        return new C04871(c0381a);
    }

    public static Object m2125a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m2126a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
