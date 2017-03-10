package android.support.v4.view.p015a;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@TargetApi(16)
/* renamed from: android.support.v4.view.a.i */
class C0419i {

    /* renamed from: android.support.v4.view.a.i.a */
    interface C0410a {
        Object m1562a(int i);

        List<Object> m1563a(String str, int i);

        boolean m1564a(int i, int i2, Bundle bundle);
    }

    /* renamed from: android.support.v4.view.a.i.1 */
    static class C04181 extends AccessibilityNodeProvider {
        final /* synthetic */ C0410a f865a;

        C04181(C0410a c0410a) {
            this.f865a = c0410a;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return (AccessibilityNodeInfo) this.f865a.m1562a(i);
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.f865a.m1563a(str, i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f865a.m1564a(i, i2, bundle);
        }
    }

    public static Object m1584a(C0410a c0410a) {
        return new C04181(c0410a);
    }
}
