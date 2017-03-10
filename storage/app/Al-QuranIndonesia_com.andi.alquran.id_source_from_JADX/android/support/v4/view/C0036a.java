package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.C0480b.C0376a;
import android.support.v4.view.C0488c.C0381a;
import android.support.v4.view.p015a.C0404c;
import android.support.v4.view.p015a.C0417h;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a */
public class C0036a {
    private static final Object DEFAULT_DELEGATE;
    private static final C0378b IMPL;
    final Object mBridge;

    /* renamed from: android.support.v4.view.a.b */
    interface C0378b {
        C0417h m1347a(Object obj, View view);

        Object m1348a();

        Object m1349a(C0036a c0036a);

        void m1350a(Object obj, View view, int i);

        void m1351a(Object obj, View view, C0404c c0404c);

        boolean m1352a(Object obj, View view, int i, Bundle bundle);

        boolean m1353a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean m1354a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m1355b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void m1356c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void m1357d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.a.d */
    static class C0379d implements C0378b {
        C0379d() {
        }

        public C0417h m1358a(Object obj, View view) {
            return null;
        }

        public Object m1359a() {
            return null;
        }

        public Object m1360a(C0036a c0036a) {
            return null;
        }

        public void m1361a(Object obj, View view, int i) {
        }

        public void m1362a(Object obj, View view, C0404c c0404c) {
        }

        public boolean m1363a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean m1364a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public boolean m1365a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void m1366b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void m1367c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void m1368d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }
    }

    /* renamed from: android.support.v4.view.a.a */
    static class C0380a extends C0379d {

        /* renamed from: android.support.v4.view.a.a.1 */
        class C03771 implements C0376a {
            final /* synthetic */ C0036a f849a;
            final /* synthetic */ C0380a f850b;

            C03771(C0380a c0380a, C0036a c0036a) {
                this.f850b = c0380a;
                this.f849a = c0036a;
            }

            public void m1340a(View view, int i) {
                this.f849a.sendAccessibilityEvent(view, i);
            }

            public void m1341a(View view, Object obj) {
                this.f849a.onInitializeAccessibilityNodeInfo(view, new C0404c(obj));
            }

            public boolean m1342a(View view, AccessibilityEvent accessibilityEvent) {
                return this.f849a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            public boolean m1343a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.f849a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }

            public void m1344b(View view, AccessibilityEvent accessibilityEvent) {
                this.f849a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }

            public void m1345c(View view, AccessibilityEvent accessibilityEvent) {
                this.f849a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            public void m1346d(View view, AccessibilityEvent accessibilityEvent) {
                this.f849a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        C0380a() {
        }

        public Object m1369a() {
            return C0480b.m2081a();
        }

        public Object m1370a(C0036a c0036a) {
            return C0480b.m2082a(new C03771(this, c0036a));
        }

        public void m1371a(Object obj, View view, int i) {
            C0480b.m2083a(obj, view, i);
        }

        public void m1372a(Object obj, View view, C0404c c0404c) {
            C0480b.m2084a(obj, view, c0404c.m1502a());
        }

        public boolean m1373a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return C0480b.m2085a(obj, view, accessibilityEvent);
        }

        public boolean m1374a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return C0480b.m2086a(obj, viewGroup, view, accessibilityEvent);
        }

        public void m1375b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0480b.m2087b(obj, view, accessibilityEvent);
        }

        public void m1376c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0480b.m2088c(obj, view, accessibilityEvent);
        }

        public void m1377d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0480b.m2089d(obj, view, accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.a.c */
    static class C0383c extends C0380a {

        /* renamed from: android.support.v4.view.a.c.1 */
        class C03821 implements C0381a {
            final /* synthetic */ C0036a f851a;
            final /* synthetic */ C0383c f852b;

            C03821(C0383c c0383c, C0036a c0036a) {
                this.f852b = c0383c;
                this.f851a = c0036a;
            }

            public Object m1387a(View view) {
                C0417h accessibilityNodeProvider = this.f851a.getAccessibilityNodeProvider(view);
                return accessibilityNodeProvider != null ? accessibilityNodeProvider.m1580a() : null;
            }

            public void m1388a(View view, int i) {
                this.f851a.sendAccessibilityEvent(view, i);
            }

            public void m1389a(View view, Object obj) {
                this.f851a.onInitializeAccessibilityNodeInfo(view, new C0404c(obj));
            }

            public boolean m1390a(View view, int i, Bundle bundle) {
                return this.f851a.performAccessibilityAction(view, i, bundle);
            }

            public boolean m1391a(View view, AccessibilityEvent accessibilityEvent) {
                return this.f851a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            public boolean m1392a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.f851a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }

            public void m1393b(View view, AccessibilityEvent accessibilityEvent) {
                this.f851a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }

            public void m1394c(View view, AccessibilityEvent accessibilityEvent) {
                this.f851a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            public void m1395d(View view, AccessibilityEvent accessibilityEvent) {
                this.f851a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        C0383c() {
        }

        public C0417h m1396a(Object obj, View view) {
            Object a = C0488c.m2125a(obj, view);
            return a != null ? new C0417h(a) : null;
        }

        public Object m1397a(C0036a c0036a) {
            return C0488c.m2124a(new C03821(this, c0036a));
        }

        public boolean m1398a(Object obj, View view, int i, Bundle bundle) {
            return C0488c.m2126a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            IMPL = new C0383c();
        } else if (VERSION.SDK_INT >= 14) {
            IMPL = new C0380a();
        } else {
            IMPL = new C0379d();
        }
        DEFAULT_DELEGATE = IMPL.m1348a();
    }

    public C0036a() {
        this.mBridge = IMPL.m1349a(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.m1353a(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public C0417h getAccessibilityNodeProvider(View view) {
        return IMPL.m1347a(DEFAULT_DELEGATE, view);
    }

    Object getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.m1355b(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0404c c0404c) {
        IMPL.m1351a(DEFAULT_DELEGATE, view, c0404c);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.m1356c(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.m1354a(DEFAULT_DELEGATE, viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return IMPL.m1352a(DEFAULT_DELEGATE, view, i, bundle);
    }

    public void sendAccessibilityEvent(View view, int i) {
        IMPL.m1350a(DEFAULT_DELEGATE, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.m1357d(DEFAULT_DELEGATE, view, accessibilityEvent);
    }
}
