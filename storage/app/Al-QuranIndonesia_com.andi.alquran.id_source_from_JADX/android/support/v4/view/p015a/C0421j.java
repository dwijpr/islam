package android.support.v4.view.p015a;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@TargetApi(19)
/* renamed from: android.support.v4.view.a.j */
class C0421j {

    /* renamed from: android.support.v4.view.a.j.a */
    interface C0414a {
        Object m1570a(int i);

        List<Object> m1571a(String str, int i);

        boolean m1572a(int i, int i2, Bundle bundle);

        Object m1573b(int i);
    }

    /* renamed from: android.support.v4.view.a.j.1 */
    static class C04201 extends AccessibilityNodeProvider {
        final /* synthetic */ C0414a f866a;

        C04201(C0414a c0414a) {
            this.f866a = c0414a;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return (AccessibilityNodeInfo) this.f866a.m1570a(i);
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.f866a.m1571a(str, i);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            return (AccessibilityNodeInfo) this.f866a.m1573b(i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f866a.m1572a(i, i2, bundle);
        }
    }

    public static Object m1585a(C0414a c0414a) {
        return new C04201(c0414a);
    }
}
