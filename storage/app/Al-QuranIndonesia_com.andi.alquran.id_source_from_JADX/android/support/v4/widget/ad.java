package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.C0534t;
import android.support.v4.view.ah;
import android.support.v4.view.aj;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.Arrays;

public class ad {
    private static final Interpolator f1067v;
    private int f1068a;
    private int f1069b;
    private int f1070c;
    private float[] f1071d;
    private float[] f1072e;
    private float[] f1073f;
    private float[] f1074g;
    private int[] f1075h;
    private int[] f1076i;
    private int[] f1077j;
    private int f1078k;
    private VelocityTracker f1079l;
    private float f1080m;
    private float f1081n;
    private int f1082o;
    private int f1083p;
    private C0588u f1084q;
    private final C0052a f1085r;
    private View f1086s;
    private boolean f1087t;
    private final ViewGroup f1088u;
    private final Runnable f1089w;

    /* renamed from: android.support.v4.widget.ad.a */
    public static abstract class C0052a {
        public int m217a(View view) {
            return 0;
        }

        public int m218a(View view, int i, int i2) {
            return 0;
        }

        public void m219a(int i) {
        }

        public void m220a(int i, int i2) {
        }

        public void m221a(View view, float f, float f2) {
        }

        public void m222a(View view, int i, int i2, int i3, int i4) {
        }

        public abstract boolean m223a(View view, int i);

        public int m224b(View view) {
            return 0;
        }

        public int m225b(View view, int i, int i2) {
            return 0;
        }

        public void m226b(int i, int i2) {
        }

        public void m227b(View view, int i) {
        }

        public boolean m228b(int i) {
            return false;
        }

        public int m229c(int i) {
            return i;
        }
    }

    /* renamed from: android.support.v4.widget.ad.1 */
    static class C05511 implements Interpolator {
        C05511() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.widget.ad.2 */
    class C05522 implements Runnable {
        final /* synthetic */ ad f1066a;

        C05522(ad adVar) {
            this.f1066a = adVar;
        }

        public void run() {
            this.f1066a.m2405b(0);
        }
    }

    static {
        f1067v = new C05511();
    }

    private ad(Context context, ViewGroup viewGroup, C0052a c0052a) {
        this.f1070c = -1;
        this.f1089w = new C05522(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0052a == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1088u = viewGroup;
            this.f1085r = c0052a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1082o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1069b = viewConfiguration.getScaledTouchSlop();
            this.f1080m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1081n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1084q = C0588u.m2513a(context, f1067v);
        }
    }

    private float m2376a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private float m2377a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m2378a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1088u.getWidth();
        int i4 = width / 2;
        float a = (m2376a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m2379a(View view, int i, int i2, int i3, int i4) {
        int b = m2387b(i3, (int) this.f1081n, (int) this.f1080m);
        int b2 = m2387b(i4, (int) this.f1081n, (int) this.f1080m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m2378a(i2, b2, this.f1085r.m217a(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m2378a(i, b, this.f1085r.m224b(view)))));
    }

    public static ad m2380a(ViewGroup viewGroup, float f, C0052a c0052a) {
        ad a = m2381a(viewGroup, c0052a);
        a.f1069b = (int) (((float) a.f1069b) * (1.0f / f));
        return a;
    }

    public static ad m2381a(ViewGroup viewGroup, C0052a c0052a) {
        return new ad(viewGroup.getContext(), viewGroup, c0052a);
    }

    private void m2382a(float f, float f2) {
        this.f1087t = true;
        this.f1085r.m221a(this.f1086s, f, f2);
        this.f1087t = false;
        if (this.f1068a == 1) {
            m2405b(0);
        }
    }

    private void m2383a(float f, float f2, int i) {
        m2393e(i);
        float[] fArr = this.f1071d;
        this.f1073f[i] = f;
        fArr[i] = f;
        fArr = this.f1072e;
        this.f1074g[i] = f2;
        fArr[i] = f2;
        this.f1075h[i] = m2392e((int) f, (int) f2);
        this.f1078k |= 1 << i;
    }

    private boolean m2384a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1075h[i] & i2) != i2 || (this.f1083p & i2) == 0 || (this.f1077j[i] & i2) == i2 || (this.f1076i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1069b) && abs2 <= ((float) this.f1069b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f1085r.m228b(i2)) {
            return (this.f1076i[i] & i2) == 0 && abs > ((float) this.f1069b);
        } else {
            int[] iArr = this.f1077j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m2385a(int i, int i2, int i3, int i4) {
        int left = this.f1086s.getLeft();
        int top = this.f1086s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1084q.m2526h();
            m2405b(0);
            return false;
        }
        this.f1084q.m2515a(left, top, i5, i6, m2379a(this.f1086s, i5, i6, i3, i4));
        m2405b(2);
        return true;
    }

    private boolean m2386a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1085r.m224b(view) > 0;
        boolean z2 = this.f1085r.m217a(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f1069b * this.f1069b)) : z ? Math.abs(f) > ((float) this.f1069b) : z2 ? Math.abs(f2) > ((float) this.f1069b) : false;
    }

    private int m2387b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m2388b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2384a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2384a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2384a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2384a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1076i;
            iArr[i] = iArr[i] | i2;
            this.f1085r.m226b(i2, i);
        }
    }

    private void m2389b(int i, int i2, int i3, int i4) {
        int b;
        int a;
        int left = this.f1086s.getLeft();
        int top = this.f1086s.getTop();
        if (i3 != 0) {
            b = this.f1085r.m225b(this.f1086s, i, i3);
            aj.m1882e(this.f1086s, b - left);
        } else {
            b = i;
        }
        if (i4 != 0) {
            a = this.f1085r.m218a(this.f1086s, i2, i4);
            aj.m1880d(this.f1086s, a - top);
        } else {
            a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1085r.m222a(this.f1086s, b, a, b - left, a - top);
        }
    }

    private void m2390c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m2395f(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1073f[pointerId] = x;
                this.f1074g[pointerId] = y;
            }
        }
    }

    private void m2391d(int i) {
        if (this.f1071d != null && m2399a(i)) {
            this.f1071d[i] = 0.0f;
            this.f1072e[i] = 0.0f;
            this.f1073f[i] = 0.0f;
            this.f1074g[i] = 0.0f;
            this.f1075h[i] = 0;
            this.f1076i[i] = 0;
            this.f1077j[i] = 0;
            this.f1078k &= (1 << i) ^ -1;
        }
    }

    private int m2392e(int i, int i2) {
        int i3 = 0;
        if (i < this.f1088u.getLeft() + this.f1082o) {
            i3 = 1;
        }
        if (i2 < this.f1088u.getTop() + this.f1082o) {
            i3 |= 4;
        }
        if (i > this.f1088u.getRight() - this.f1082o) {
            i3 |= 2;
        }
        return i2 > this.f1088u.getBottom() - this.f1082o ? i3 | 8 : i3;
    }

    private void m2393e(int i) {
        if (this.f1071d == null || this.f1071d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f1071d != null) {
                System.arraycopy(this.f1071d, 0, obj, 0, this.f1071d.length);
                System.arraycopy(this.f1072e, 0, obj2, 0, this.f1072e.length);
                System.arraycopy(this.f1073f, 0, obj3, 0, this.f1073f.length);
                System.arraycopy(this.f1074g, 0, obj4, 0, this.f1074g.length);
                System.arraycopy(this.f1075h, 0, obj5, 0, this.f1075h.length);
                System.arraycopy(this.f1076i, 0, obj6, 0, this.f1076i.length);
                System.arraycopy(this.f1077j, 0, obj7, 0, this.f1077j.length);
            }
            this.f1071d = obj;
            this.f1072e = obj2;
            this.f1073f = obj3;
            this.f1074g = obj4;
            this.f1075h = obj5;
            this.f1076i = obj6;
            this.f1077j = obj7;
        }
    }

    private void m2394f() {
        if (this.f1071d != null) {
            Arrays.fill(this.f1071d, 0.0f);
            Arrays.fill(this.f1072e, 0.0f);
            Arrays.fill(this.f1073f, 0.0f);
            Arrays.fill(this.f1074g, 0.0f);
            Arrays.fill(this.f1075h, 0);
            Arrays.fill(this.f1076i, 0);
            Arrays.fill(this.f1077j, 0);
            this.f1078k = 0;
        }
    }

    private boolean m2395f(int i) {
        if (m2399a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void m2396g() {
        this.f1079l.computeCurrentVelocity(1000, this.f1080m);
        m2382a(m2377a(ah.m1646a(this.f1079l, this.f1070c), this.f1081n, this.f1080m), m2377a(ah.m1647b(this.f1079l, this.f1070c), this.f1081n, this.f1080m));
    }

    public int m2397a() {
        return this.f1068a;
    }

    public void m2398a(View view, int i) {
        if (view.getParent() != this.f1088u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1088u + ")");
        }
        this.f1086s = view;
        this.f1070c = i;
        this.f1085r.m227b(view, i);
        m2405b(1);
    }

    public boolean m2399a(int i) {
        return (this.f1078k & (1 << i)) != 0;
    }

    public boolean m2400a(int i, int i2) {
        if (this.f1087t) {
            return m2385a(i, i2, (int) ah.m1646a(this.f1079l, this.f1070c), (int) ah.m1647b(this.f1079l, this.f1070c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2401a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.C0534t.m2226a(r14);
        r1 = android.support.v4.view.C0534t.m2227b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m2415e();
    L_0x000d:
        r2 = r13.f1079l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f1079l = r2;
    L_0x0017:
        r2 = r13.f1079l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f1068a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = r14.getPointerId(r2);
        r13.m2383a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m2414d(r0, r1);
        r1 = r13.f1086s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f1068a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m2408b(r0, r2);
    L_0x0048:
        r0 = r13.f1075h;
        r0 = r0[r2];
        r1 = r13.f1083p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f1085r;
        r3 = r13.f1083p;
        r0 = r0 & r3;
        r1.m220a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = r14.getPointerId(r1);
        r2 = r14.getX(r1);
        r1 = r14.getY(r1);
        r13.m2383a(r2, r1, r0);
        r3 = r13.f1068a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f1075h;
        r1 = r1[r0];
        r2 = r13.f1083p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f1085r;
        r3 = r13.f1083p;
        r1 = r1 & r3;
        r2.m220a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f1068a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m2414d(r2, r1);
        r2 = r13.f1086s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m2408b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f1071d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f1072e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = r14.getPointerCount();
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = r14.getPointerId(r1);
        r0 = r13.m2395f(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = r14.getX(r1);
        r4 = r14.getY(r1);
        r5 = r13.f1071d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f1072e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m2414d(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m2386a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f1085r;
        r10 = (int) r5;
        r8 = r9.m225b(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f1085r;
        r12 = (int) r6;
        r10 = r11.m218a(r4, r10, r12);
        r11 = r13.f1085r;
        r11 = r11.m224b(r4);
        r12 = r13.f1085r;
        r12 = r12.m217a(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m2390c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m2388b(r5, r6, r3);
        r5 = r13.f1068a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m2408b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = r14.getPointerId(r1);
        r13.m2391d(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m2415e();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ad.a(android.view.MotionEvent):boolean");
    }

    public boolean m2402a(View view, int i, int i2) {
        this.f1086s = view;
        this.f1070c = -1;
        boolean a = m2385a(i, i2, 0, 0);
        if (!(a || this.f1068a != 0 || this.f1086s == null)) {
            this.f1086s = null;
        }
        return a;
    }

    public boolean m2403a(boolean z) {
        if (this.f1068a == 2) {
            int i;
            boolean g = this.f1084q.m2525g();
            int b = this.f1084q.m2520b();
            int c = this.f1084q.m2521c();
            int left = b - this.f1086s.getLeft();
            int top = c - this.f1086s.getTop();
            if (left != 0) {
                aj.m1882e(this.f1086s, left);
            }
            if (top != 0) {
                aj.m1880d(this.f1086s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1085r.m222a(this.f1086s, b, c, left, top);
            }
            if (g && b == this.f1084q.m2522d() && c == this.f1084q.m2523e()) {
                this.f1084q.m2526h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f1088u.post(this.f1089w);
                } else {
                    m2405b(0);
                }
            }
        }
        return this.f1068a == 2;
    }

    public int m2404b() {
        return this.f1082o;
    }

    void m2405b(int i) {
        this.f1088u.removeCallbacks(this.f1089w);
        if (this.f1068a != i) {
            this.f1068a = i;
            this.f1085r.m219a(i);
            if (this.f1068a == 0) {
                this.f1086s = null;
            }
        }
    }

    public void m2406b(MotionEvent motionEvent) {
        int i = 0;
        int a = C0534t.m2226a(motionEvent);
        int b = C0534t.m2227b(motionEvent);
        if (a == 0) {
            m2415e();
        }
        if (this.f1079l == null) {
            this.f1079l = VelocityTracker.obtain();
        }
        this.f1079l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = motionEvent.getPointerId(0);
                d = m2414d((int) x, (int) y);
                m2383a(x, y, i);
                m2408b(d, i);
                i2 = this.f1075h[i];
                if ((this.f1083p & i2) != 0) {
                    this.f1085r.m220a(i2 & this.f1083p, i);
                }
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                if (this.f1068a == 1) {
                    m2396g();
                }
                m2415e();
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                if (this.f1068a != 1) {
                    i2 = motionEvent.getPointerCount();
                    while (i < i2) {
                        a = motionEvent.getPointerId(i);
                        if (m2395f(a)) {
                            float x2 = motionEvent.getX(i);
                            float y2 = motionEvent.getY(i);
                            float f = x2 - this.f1071d[a];
                            float f2 = y2 - this.f1072e[a];
                            m2388b(f, f2, a);
                            if (this.f1068a != 1) {
                                d = m2414d((int) x2, (int) y2);
                                if (m2386a(d, f, f2) && m2408b(d, a)) {
                                }
                            }
                            m2390c(motionEvent);
                        }
                        i++;
                    }
                    m2390c(motionEvent);
                } else if (m2395f(this.f1070c)) {
                    i = motionEvent.findPointerIndex(this.f1070c);
                    x = motionEvent.getX(i);
                    i2 = (int) (x - this.f1073f[this.f1070c]);
                    i = (int) (motionEvent.getY(i) - this.f1074g[this.f1070c]);
                    m2389b(this.f1086s.getLeft() + i2, this.f1086s.getTop() + i, i2, i);
                    m2390c(motionEvent);
                }
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                if (this.f1068a == 1) {
                    m2382a(0.0f, 0.0f);
                }
                m2415e();
            case C1096c.MapAttrs_cameraZoom /*5*/:
                i = motionEvent.getPointerId(b);
                x = motionEvent.getX(b);
                y = motionEvent.getY(b);
                m2383a(x, y, i);
                if (this.f1068a == 0) {
                    m2408b(m2414d((int) x, (int) y), i);
                    i2 = this.f1075h[i];
                    if ((this.f1083p & i2) != 0) {
                        this.f1085r.m220a(i2 & this.f1083p, i);
                    }
                } else if (m2412c((int) x, (int) y)) {
                    m2408b(this.f1086s, i);
                }
            case C1096c.MapAttrs_liteMode /*6*/:
                a = motionEvent.getPointerId(b);
                if (this.f1068a == 1 && a == this.f1070c) {
                    b = motionEvent.getPointerCount();
                    while (i < b) {
                        int pointerId = motionEvent.getPointerId(i);
                        if (pointerId != this.f1070c) {
                            if (m2414d((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.f1086s && m2408b(this.f1086s, pointerId)) {
                                i = this.f1070c;
                                if (i == -1) {
                                    m2396g();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m2396g();
                    }
                }
                m2391d(a);
            default:
        }
    }

    public boolean m2407b(int i, int i2) {
        if (!m2399a(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f1073f[i2] - this.f1071d[i2];
        float f2 = this.f1074g[i2] - this.f1072e[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f1069b * this.f1069b)) : z ? Math.abs(f) > ((float) this.f1069b) : z2 ? Math.abs(f2) > ((float) this.f1069b) : false;
    }

    boolean m2408b(View view, int i) {
        if (view == this.f1086s && this.f1070c == i) {
            return true;
        }
        if (view == null || !this.f1085r.m223a(view, i)) {
            return false;
        }
        this.f1070c = i;
        m2398a(view, i);
        return true;
    }

    public boolean m2409b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m2410c() {
        return this.f1086s;
    }

    public boolean m2411c(int i) {
        int length = this.f1071d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m2407b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m2412c(int i, int i2) {
        return m2409b(this.f1086s, i, i2);
    }

    public int m2413d() {
        return this.f1069b;
    }

    public View m2414d(int i, int i2) {
        for (int childCount = this.f1088u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1088u.getChildAt(this.f1085r.m229c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void m2415e() {
        this.f1070c = -1;
        m2394f();
        if (this.f1079l != null) {
            this.f1079l.recycle();
            this.f1079l = null;
        }
    }
}
