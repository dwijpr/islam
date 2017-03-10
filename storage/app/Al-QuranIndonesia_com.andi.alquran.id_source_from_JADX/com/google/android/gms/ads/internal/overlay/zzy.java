package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.overlay.C1127b.C1126a;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.C1648if;
import com.google.android.gms.internal.ib;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
@op
public class zzy extends Thread implements OnFrameAvailableListener, C1126a {
    private static final float[] f2460a;
    private volatile boolean f2461A;
    private volatile boolean f2462B;
    private final C1127b f2463b;
    private final float[] f2464c;
    private final float[] f2465d;
    private final float[] f2466e;
    private final float[] f2467f;
    private final float[] f2468g;
    private final float[] f2469h;
    private final float[] f2470i;
    private float f2471j;
    private float f2472k;
    private float f2473l;
    private int f2474m;
    private int f2475n;
    private SurfaceTexture f2476o;
    private SurfaceTexture f2477p;
    private int f2478q;
    private int f2479r;
    private int f2480s;
    private FloatBuffer f2481t;
    private final CountDownLatch f2482u;
    private final Object f2483v;
    private EGL10 f2484w;
    private EGLDisplay f2485x;
    private EGLContext f2486y;
    private EGLSurface f2487z;

    static {
        f2460a = new float[]{GroundOverlayOptions.NO_DIMENSION, GroundOverlayOptions.NO_DIMENSION, GroundOverlayOptions.NO_DIMENSION, 1.0f, GroundOverlayOptions.NO_DIMENSION, GroundOverlayOptions.NO_DIMENSION, GroundOverlayOptions.NO_DIMENSION, 1.0f, GroundOverlayOptions.NO_DIMENSION, 1.0f, 1.0f, GroundOverlayOptions.NO_DIMENSION};
    }

    public zzy(Context context) {
        super("SphericalVideoProcessor");
        this.f2481t = ByteBuffer.allocateDirect(f2460a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2481t.put(f2460a).position(0);
        this.f2464c = new float[9];
        this.f2465d = new float[9];
        this.f2466e = new float[9];
        this.f2467f = new float[9];
        this.f2468g = new float[9];
        this.f2469h = new float[9];
        this.f2470i = new float[9];
        this.f2471j = Float.NaN;
        this.f2463b = new C1127b(context);
        this.f2463b.m3950a((C1126a) this);
        this.f2482u = new CountDownLatch(1);
        this.f2483v = new Object();
    }

    private float m3990a(float[] fArr) {
        float[] a = m3995a(fArr, new float[]{0.0f, 1.0f, 0.0f});
        return ((float) Math.atan2((double) a[1], (double) a[0])) - 1.5707964f;
    }

    private int m3991a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m3992a("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            m3992a("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            m3992a("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            m3992a("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                m3992a("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    private void m3992a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", new StringBuilder(String.valueOf(str).length() + 21).append(str).append(": glError ").append(glGetError).toString());
        }
    }

    private void m3993a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = (float) (-Math.sin((double) f));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin((double) f);
        fArr[8] = (float) Math.cos((double) f);
    }

    private void m3994a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = ((fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3])) + (fArr2[2] * fArr3[6]);
        fArr[1] = ((fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4])) + (fArr2[2] * fArr3[7]);
        fArr[2] = ((fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5])) + (fArr2[2] * fArr3[8]);
        fArr[3] = ((fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3])) + (fArr2[5] * fArr3[6]);
        fArr[4] = ((fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4])) + (fArr2[5] * fArr3[7]);
        fArr[5] = ((fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5])) + (fArr2[5] * fArr3[8]);
        fArr[6] = ((fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3])) + (fArr2[8] * fArr3[6]);
        fArr[7] = ((fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4])) + (fArr2[8] * fArr3[7]);
        fArr[8] = ((fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5])) + (fArr2[8] * fArr3[8]);
    }

    private float[] m3995a(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1])) + (fArr[2] * fArr2[2]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1])) + (fArr[5] * fArr2[2]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1])) + (fArr[8] * fArr2[2])};
    }

    private void m3996b(float[] fArr, float f) {
        fArr[0] = (float) Math.cos((double) f);
        fArr[1] = (float) (-Math.sin((double) f));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin((double) f);
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private void m3997e() {
        GLES20.glViewport(0, 0, this.f2475n, this.f2474m);
        m3992a("viewport");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f2478q, "uFOVx");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f2478q, "uFOVy");
        if (this.f2475n > this.f2474m) {
            GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
            GLES20.glUniform1f(glGetUniformLocation2, (((float) this.f2474m) * 0.87266463f) / ((float) this.f2475n));
            return;
        }
        GLES20.glUniform1f(glGetUniformLocation, (((float) this.f2475n) * 0.87266463f) / ((float) this.f2474m));
        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
    }

    private int m3998f() {
        int a = m3991a(35633, m4000h());
        if (a == 0) {
            return 0;
        }
        int a2 = m3991a(35632, m4001i());
        if (a2 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        m3992a("createProgram");
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a);
            m3992a("attachShader");
            GLES20.glAttachShader(glCreateProgram, a2);
            m3992a("attachShader");
            GLES20.glLinkProgram(glCreateProgram);
            m3992a("linkProgram");
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            m3992a("getProgramiv");
            if (iArr[0] != 1) {
                Log.e("SphericalVideoRenderer", "Could not link program: ");
                Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                m3992a("deleteProgram");
                return 0;
            }
            GLES20.glValidateProgram(glCreateProgram);
            m3992a("validateProgram");
        }
        return glCreateProgram;
    }

    private EGLConfig m3999g() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        return !this.f2484w.eglChooseConfig(this.f2485x, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) ? null : iArr[0] > 0 ? eGLConfigArr[0] : null;
    }

    private String m4000h() {
        ib ibVar = C1648if.aS;
        return !((String) ibVar.m6682c()).equals(ibVar.m6681b()) ? (String) ibVar.m6682c() : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
    }

    private String m4001i() {
        ib ibVar = C1648if.aT;
        return !((String) ibVar.m6682c()).equals(ibVar.m6681b()) ? (String) ibVar.m6682c() : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
    }

    void m4002a() {
        while (this.f2480s > 0) {
            this.f2476o.updateTexImage();
            this.f2480s--;
        }
        if (this.f2463b.m3953b(this.f2464c)) {
            if (Float.isNaN(this.f2471j)) {
                this.f2471j = -m3990a(this.f2464c);
            }
            m3996b(this.f2469h, this.f2471j + this.f2472k);
        } else {
            m3993a(this.f2464c, -1.5707964f);
            m3996b(this.f2469h, this.f2472k);
        }
        m3993a(this.f2465d, 1.5707964f);
        m3994a(this.f2466e, this.f2469h, this.f2465d);
        m3994a(this.f2467f, this.f2464c, this.f2466e);
        m3993a(this.f2468g, this.f2473l);
        m3994a(this.f2470i, this.f2468g, this.f2467f);
        GLES20.glUniformMatrix3fv(this.f2479r, 1, false, this.f2470i, 0);
        GLES20.glDrawArrays(5, 0, 4);
        m3992a("drawArrays");
        GLES20.glFinish();
        this.f2484w.eglSwapBuffers(this.f2485x, this.f2487z);
    }

    int m4003b() {
        this.f2478q = m3998f();
        GLES20.glUseProgram(this.f2478q);
        m3992a("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f2478q, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.f2481t);
        m3992a("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        m3992a("enableVertexAttribArray");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        m3992a("genTextures");
        glGetAttribLocation = iArr[0];
        GLES20.glBindTexture(36197, glGetAttribLocation);
        m3992a("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        m3992a("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        m3992a("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        m3992a("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        m3992a("texParameteri");
        this.f2479r = GLES20.glGetUniformLocation(this.f2478q, "uVMat");
        GLES20.glUniformMatrix3fv(this.f2479r, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        return glGetAttribLocation;
    }

    boolean m4004c() {
        this.f2484w = (EGL10) EGLContext.getEGL();
        this.f2485x = this.f2484w.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f2485x == EGL10.EGL_NO_DISPLAY) {
            return false;
        }
        if (!this.f2484w.eglInitialize(this.f2485x, new int[2])) {
            return false;
        }
        EGLConfig g = m3999g();
        if (g == null) {
            return false;
        }
        this.f2486y = this.f2484w.eglCreateContext(this.f2485x, g, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        if (this.f2486y == null || this.f2486y == EGL10.EGL_NO_CONTEXT) {
            return false;
        }
        this.f2487z = this.f2484w.eglCreateWindowSurface(this.f2485x, g, this.f2477p, null);
        return (this.f2487z == null || this.f2487z == EGL10.EGL_NO_SURFACE) ? false : this.f2484w.eglMakeCurrent(this.f2485x, this.f2487z, this.f2487z, this.f2486y);
    }

    boolean m4005d() {
        boolean z = false;
        if (!(this.f2487z == null || this.f2487z == EGL10.EGL_NO_SURFACE)) {
            z = (this.f2484w.eglMakeCurrent(this.f2485x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | 0) | this.f2484w.eglDestroySurface(this.f2485x, this.f2487z);
            this.f2487z = null;
        }
        if (this.f2486y != null) {
            z |= this.f2484w.eglDestroyContext(this.f2485x, this.f2486y);
            this.f2486y = null;
        }
        if (this.f2485x == null) {
            return z;
        }
        z |= this.f2484w.eglTerminate(this.f2485x);
        this.f2485x = null;
        return z;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f2480s++;
        synchronized (this.f2483v) {
            this.f2483v.notifyAll();
        }
    }

    public void run() {
        Object obj = 1;
        if (this.f2477p == null) {
            sg.m8446c("SphericalVideoProcessor started with no output texture.");
            this.f2482u.countDown();
            return;
        }
        boolean c = m4004c();
        int b = m4003b();
        if (this.f2478q == 0) {
            obj = null;
        }
        if (!c || r0 == null) {
            String str = "EGL initialization failed: ";
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.f2484w.eglGetError()));
            valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
            sg.m8446c(valueOf);
            zzv.zzcN().m8399a(new Throwable(valueOf), "SphericalVideoProcessor.run.1");
            m4005d();
            this.f2482u.countDown();
            return;
        }
        this.f2476o = new SurfaceTexture(b);
        this.f2476o.setOnFrameAvailableListener(this);
        this.f2482u.countDown();
        this.f2463b.m3952b();
        try {
            this.f2461A = true;
            while (!this.f2462B) {
                m4002a();
                if (this.f2461A) {
                    m3997e();
                    this.f2461A = false;
                }
                try {
                    synchronized (this.f2483v) {
                        if (!(this.f2462B || this.f2461A || this.f2480s != 0)) {
                            this.f2483v.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        } catch (IllegalStateException e2) {
            sg.m8449e("SphericalVideoProcessor halted unexpectedly.");
        } catch (Throwable th) {
            sg.m8445b("SphericalVideoProcessor died.", th);
            zzv.zzcN().m8399a(th, "SphericalVideoProcessor.run.2");
        } finally {
            this.f2463b.m3954c();
            this.f2476o.setOnFrameAvailableListener(null);
            this.f2476o = null;
            m4005d();
        }
    }

    public void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f2475n = i;
        this.f2474m = i2;
        this.f2477p = surfaceTexture;
    }

    public void zzb(float f, float f2) {
        float f3;
        float f4;
        if (this.f2475n > this.f2474m) {
            f3 = (1.7453293f * f) / ((float) this.f2475n);
            f4 = (1.7453293f * f2) / ((float) this.f2475n);
        } else {
            f3 = (1.7453293f * f) / ((float) this.f2474m);
            f4 = (1.7453293f * f2) / ((float) this.f2474m);
        }
        this.f2472k -= f3;
        this.f2473l -= f4;
        if (this.f2473l < -1.5707964f) {
            this.f2473l = -1.5707964f;
        }
        if (this.f2473l > 1.5707964f) {
            this.f2473l = 1.5707964f;
        }
    }

    public void zzhP() {
        synchronized (this.f2483v) {
            this.f2462B = true;
            this.f2477p = null;
            this.f2483v.notifyAll();
        }
    }

    public SurfaceTexture zzhQ() {
        if (this.f2477p == null) {
            return null;
        }
        try {
            this.f2482u.await();
        } catch (InterruptedException e) {
        }
        return this.f2476o;
    }

    public void zzho() {
        synchronized (this.f2483v) {
            this.f2483v.notifyAll();
        }
    }

    public void zzi(int i, int i2) {
        synchronized (this.f2483v) {
            this.f2475n = i;
            this.f2474m = i2;
            this.f2461A = true;
            this.f2483v.notifyAll();
        }
    }
}
