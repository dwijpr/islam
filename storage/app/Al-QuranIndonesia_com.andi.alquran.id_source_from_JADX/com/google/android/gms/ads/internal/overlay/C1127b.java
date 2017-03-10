package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;
import com.google.android.gms.maps.GoogleMap;

@op
/* renamed from: com.google.android.gms.ads.internal.overlay.b */
class C1127b implements SensorEventListener {
    private final SensorManager f2361a;
    private final Object f2362b;
    private final Display f2363c;
    private final float[] f2364d;
    private final float[] f2365e;
    private float[] f2366f;
    private Handler f2367g;
    private C1126a f2368h;

    /* renamed from: com.google.android.gms.ads.internal.overlay.b.1 */
    class C11251 implements Runnable {
        C11251(C1127b c1127b) {
        }

        public void run() {
            Looper.myLooper().quit();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.b.a */
    interface C1126a {
        void zzho();
    }

    C1127b(Context context) {
        this.f2361a = (SensorManager) context.getSystemService("sensor");
        this.f2363c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.f2364d = new float[9];
        this.f2365e = new float[9];
        this.f2362b = new Object();
    }

    private void m3948a(int i, int i2) {
        float f = this.f2365e[i];
        this.f2365e[i] = this.f2365e[i2];
        this.f2365e[i2] = f;
    }

    int m3949a() {
        return this.f2363c.getRotation();
    }

    void m3950a(C1126a c1126a) {
        this.f2368h = c1126a;
    }

    void m3951a(float[] fArr) {
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.f2362b) {
                if (this.f2366f == null) {
                    this.f2366f = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.f2364d, fArr);
            switch (m3949a()) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    SensorManager.remapCoordinateSystem(this.f2364d, 2, 129, this.f2365e);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    SensorManager.remapCoordinateSystem(this.f2364d, 129, 130, this.f2365e);
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    SensorManager.remapCoordinateSystem(this.f2364d, 130, 1, this.f2365e);
                    break;
                default:
                    System.arraycopy(this.f2364d, 0, this.f2365e, 0, 9);
                    break;
            }
            m3948a(1, 3);
            m3948a(2, 6);
            m3948a(5, 7);
            synchronized (this.f2362b) {
                System.arraycopy(this.f2365e, 0, this.f2366f, 0, 9);
            }
            if (this.f2368h != null) {
                this.f2368h.zzho();
            }
        }
    }

    void m3952b() {
        if (this.f2367g == null) {
            Sensor defaultSensor = this.f2361a.getDefaultSensor(11);
            if (defaultSensor == null) {
                sg.m8446c("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.f2367g = new Handler(handlerThread.getLooper());
            if (!this.f2361a.registerListener(this, defaultSensor, 0, this.f2367g)) {
                sg.m8446c("SensorManager.registerListener failed.");
                m3954c();
            }
        }
    }

    boolean m3953b(float[] fArr) {
        boolean z = false;
        synchronized (this.f2362b) {
            if (this.f2366f == null) {
            } else {
                System.arraycopy(this.f2366f, 0, fArr, 0, this.f2366f.length);
                z = true;
            }
        }
        return z;
    }

    void m3954c() {
        if (this.f2367g != null) {
            this.f2361a.unregisterListener(this);
            this.f2367g.post(new C11251(this));
            this.f2367g = null;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        m3951a(sensorEvent.values);
    }
}
