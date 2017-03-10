package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: android.support.v4.view.e */
public final class C0496e {
    private final C0492a f942a;

    /* renamed from: android.support.v4.view.e.a */
    interface C0492a {
        boolean m2127a(MotionEvent motionEvent);
    }

    /* renamed from: android.support.v4.view.e.b */
    static class C0494b implements C0492a {
        private static final int f917j;
        private static final int f918k;
        private static final int f919l;
        final OnGestureListener f920a;
        OnDoubleTapListener f921b;
        boolean f922c;
        boolean f923d;
        MotionEvent f924e;
        private int f925f;
        private int f926g;
        private int f927h;
        private int f928i;
        private final Handler f929m;
        private boolean f930n;
        private boolean f931o;
        private boolean f932p;
        private MotionEvent f933q;
        private boolean f934r;
        private float f935s;
        private float f936t;
        private float f937u;
        private float f938v;
        private boolean f939w;
        private VelocityTracker f940x;

        /* renamed from: android.support.v4.view.e.b.a */
        private class C0493a extends Handler {
            final /* synthetic */ C0494b f916a;

            C0493a(C0494b c0494b) {
                this.f916a = c0494b;
            }

            C0493a(C0494b c0494b, Handler handler) {
                this.f916a = c0494b;
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                        this.f916a.f920a.onShowPress(this.f916a.f924e);
                    case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                        this.f916a.m2132a();
                    case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                        if (this.f916a.f921b == null) {
                            return;
                        }
                        if (this.f916a.f922c) {
                            this.f916a.f923d = true;
                        } else {
                            this.f916a.f921b.onSingleTapConfirmed(this.f916a.f924e);
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        static {
            f917j = ViewConfiguration.getLongPressTimeout();
            f918k = ViewConfiguration.getTapTimeout();
            f919l = ViewConfiguration.getDoubleTapTimeout();
        }

        public C0494b(Context context, OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f929m = new C0493a(this, handler);
            } else {
                this.f929m = new C0493a(this);
            }
            this.f920a = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                m2133a((OnDoubleTapListener) onGestureListener);
            }
            m2128a(context);
        }

        private void m2128a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f920a == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.f939w = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f927h = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f928i = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f925f = scaledTouchSlop * scaledTouchSlop;
                this.f926g = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        private boolean m2129a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f932p || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f919l)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.f926g;
        }

        private void m2130b() {
            this.f929m.removeMessages(1);
            this.f929m.removeMessages(2);
            this.f929m.removeMessages(3);
            this.f940x.recycle();
            this.f940x = null;
            this.f934r = false;
            this.f922c = false;
            this.f931o = false;
            this.f932p = false;
            this.f923d = false;
            if (this.f930n) {
                this.f930n = false;
            }
        }

        private void m2131c() {
            this.f929m.removeMessages(1);
            this.f929m.removeMessages(2);
            this.f929m.removeMessages(3);
            this.f934r = false;
            this.f931o = false;
            this.f932p = false;
            this.f923d = false;
            if (this.f930n) {
                this.f930n = false;
            }
        }

        void m2132a() {
            this.f929m.removeMessages(3);
            this.f923d = false;
            this.f930n = true;
            this.f920a.onLongPress(this.f924e);
        }

        public void m2133a(OnDoubleTapListener onDoubleTapListener) {
            this.f921b = onDoubleTapListener;
        }

        public boolean m2134a(MotionEvent motionEvent) {
            int i;
            int action = motionEvent.getAction();
            if (this.f940x == null) {
                this.f940x = VelocityTracker.obtain();
            }
            this.f940x.addMovement(motionEvent);
            boolean z = (action & 255) == 6;
            int b = z ? C0534t.m2227b(motionEvent) : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (i = 0; i < pointerCount; i++) {
                if (b != i) {
                    f2 += motionEvent.getX(i);
                    f += motionEvent.getY(i);
                }
            }
            b = z ? pointerCount - 1 : pointerCount;
            f2 /= (float) b;
            f /= (float) b;
            boolean hasMessages;
            float b2;
            float a;
            switch (action & 255) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    if (this.f921b != null) {
                        hasMessages = this.f929m.hasMessages(3);
                        if (hasMessages) {
                            this.f929m.removeMessages(3);
                        }
                        if (this.f924e == null || this.f933q == null || !hasMessages || !m2129a(this.f924e, this.f933q, motionEvent)) {
                            this.f929m.sendEmptyMessageDelayed(3, (long) f919l);
                        } else {
                            this.f934r = true;
                            b = (this.f921b.onDoubleTap(this.f924e) | 0) | this.f921b.onDoubleTapEvent(motionEvent);
                            this.f935s = f2;
                            this.f937u = f2;
                            this.f936t = f;
                            this.f938v = f;
                            if (this.f924e != null) {
                                this.f924e.recycle();
                            }
                            this.f924e = MotionEvent.obtain(motionEvent);
                            this.f931o = true;
                            this.f932p = true;
                            this.f922c = true;
                            this.f930n = false;
                            this.f923d = false;
                            if (this.f939w) {
                                this.f929m.removeMessages(2);
                                this.f929m.sendEmptyMessageAtTime(2, (this.f924e.getDownTime() + ((long) f918k)) + ((long) f917j));
                            }
                            this.f929m.sendEmptyMessageAtTime(1, this.f924e.getDownTime() + ((long) f918k));
                            return b | this.f920a.onDown(motionEvent);
                        }
                    }
                    b = 0;
                    this.f935s = f2;
                    this.f937u = f2;
                    this.f936t = f;
                    this.f938v = f;
                    if (this.f924e != null) {
                        this.f924e.recycle();
                    }
                    this.f924e = MotionEvent.obtain(motionEvent);
                    this.f931o = true;
                    this.f932p = true;
                    this.f922c = true;
                    this.f930n = false;
                    this.f923d = false;
                    if (this.f939w) {
                        this.f929m.removeMessages(2);
                        this.f929m.sendEmptyMessageAtTime(2, (this.f924e.getDownTime() + ((long) f918k)) + ((long) f917j));
                    }
                    this.f929m.sendEmptyMessageAtTime(1, this.f924e.getDownTime() + ((long) f918k));
                    return b | this.f920a.onDown(motionEvent);
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    this.f922c = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.f934r) {
                        hasMessages = this.f921b.onDoubleTapEvent(motionEvent) | 0;
                    } else if (this.f930n) {
                        this.f929m.removeMessages(3);
                        this.f930n = false;
                        hasMessages = false;
                    } else if (this.f931o) {
                        hasMessages = this.f920a.onSingleTapUp(motionEvent);
                        if (this.f923d && this.f921b != null) {
                            this.f921b.onSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.f940x;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, (float) this.f928i);
                        b2 = ah.m1647b(velocityTracker, pointerId);
                        a = ah.m1646a(velocityTracker, pointerId);
                        hasMessages = (Math.abs(b2) > ((float) this.f927h) || Math.abs(a) > ((float) this.f927h)) ? this.f920a.onFling(this.f924e, motionEvent, a, b2) : false;
                    }
                    if (this.f933q != null) {
                        this.f933q.recycle();
                    }
                    this.f933q = obtain;
                    if (this.f940x != null) {
                        this.f940x.recycle();
                        this.f940x = null;
                    }
                    this.f934r = false;
                    this.f923d = false;
                    this.f929m.removeMessages(1);
                    this.f929m.removeMessages(2);
                    return hasMessages;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    if (this.f930n) {
                        return false;
                    }
                    a = this.f935s - f2;
                    b2 = this.f936t - f;
                    if (this.f934r) {
                        return false | this.f921b.onDoubleTapEvent(motionEvent);
                    }
                    if (this.f931o) {
                        i = (int) (f2 - this.f937u);
                        int i2 = (int) (f - this.f938v);
                        i = (i * i) + (i2 * i2);
                        if (i > this.f925f) {
                            hasMessages = this.f920a.onScroll(this.f924e, motionEvent, a, b2);
                            this.f935s = f2;
                            this.f936t = f;
                            this.f931o = false;
                            this.f929m.removeMessages(3);
                            this.f929m.removeMessages(1);
                            this.f929m.removeMessages(2);
                        } else {
                            hasMessages = false;
                        }
                        if (i > this.f925f) {
                            this.f932p = false;
                        }
                        return hasMessages;
                    } else if (Math.abs(a) < 1.0f && Math.abs(b2) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.f920a.onScroll(this.f924e, motionEvent, a, b2);
                        this.f935s = f2;
                        this.f936t = f;
                        return onScroll;
                    }
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    m2130b();
                    return false;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    this.f935s = f2;
                    this.f937u = f2;
                    this.f936t = f;
                    this.f938v = f;
                    m2131c();
                    return false;
                case C1096c.MapAttrs_liteMode /*6*/:
                    this.f935s = f2;
                    this.f937u = f2;
                    this.f936t = f;
                    this.f938v = f;
                    this.f940x.computeCurrentVelocity(1000, (float) this.f928i);
                    int b3 = C0534t.m2227b(motionEvent);
                    b = motionEvent.getPointerId(b3);
                    f2 = ah.m1646a(this.f940x, b);
                    float b4 = ah.m1647b(this.f940x, b);
                    for (b = 0; b < pointerCount; b++) {
                        if (b != b3) {
                            int pointerId2 = motionEvent.getPointerId(b);
                            if ((ah.m1647b(this.f940x, pointerId2) * b4) + (ah.m1646a(this.f940x, pointerId2) * f2) < 0.0f) {
                                this.f940x.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.v4.view.e.c */
    static class C0495c implements C0492a {
        private final GestureDetector f941a;

        public C0495c(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.f941a = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean m2135a(MotionEvent motionEvent) {
            return this.f941a.onTouchEvent(motionEvent);
        }
    }

    public C0496e(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public C0496e(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.f942a = new C0495c(context, onGestureListener, handler);
        } else {
            this.f942a = new C0494b(context, onGestureListener, handler);
        }
    }

    public boolean m2136a(MotionEvent motionEvent) {
        return this.f942a.m2127a(motionEvent);
    }
}
