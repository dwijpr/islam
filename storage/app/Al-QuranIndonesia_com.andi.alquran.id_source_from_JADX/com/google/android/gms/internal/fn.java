package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.util.C1387m;
import java.util.ArrayList;
import java.util.List;

@op
public class fn {
    private final Object f4069a;
    private C1573a f4070b;
    private boolean f4071c;

    @TargetApi(14)
    /* renamed from: com.google.android.gms.internal.fn.a */
    static class C1573a implements ActivityLifecycleCallbacks {
        private Activity f4060a;
        private Context f4061b;
        private final Object f4062c;
        private boolean f4063d;
        private boolean f4064e;
        private List<C1574b> f4065f;
        private Runnable f4066g;
        private boolean f4067h;
        private long f4068i;

        /* renamed from: com.google.android.gms.internal.fn.a.1 */
        class C15721 implements Runnable {
            final /* synthetic */ C1573a f4059a;

            C15721(C1573a c1573a) {
                this.f4059a = c1573a;
            }

            public void run() {
                synchronized (this.f4059a.f4062c) {
                    if (this.f4059a.f4063d && this.f4059a.f4064e) {
                        this.f4059a.f4063d = false;
                        sg.m8444b("App went background");
                        for (C1574b a : this.f4059a.f4065f) {
                            try {
                                a.m6198a(false);
                            } catch (Throwable e) {
                                sg.m8445b("OnForegroundStateChangedListener threw exception.", e);
                            }
                        }
                    } else {
                        sg.m8444b("App is still foreground");
                    }
                }
            }
        }

        C1573a() {
            this.f4062c = new Object();
            this.f4063d = true;
            this.f4064e = false;
            this.f4065f = new ArrayList();
            this.f4067h = false;
        }

        private void m6189a(Activity activity) {
            synchronized (this.f4062c) {
                if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.f4060a = activity;
                }
            }
        }

        public Activity m6194a() {
            return this.f4060a;
        }

        public void m6195a(Application application, Context context) {
            if (!this.f4067h) {
                application.registerActivityLifecycleCallbacks(this);
                if (context instanceof Activity) {
                    m6189a((Activity) context);
                }
                this.f4061b = context;
                this.f4068i = ((Long) C1648if.aE.m6682c()).longValue();
                this.f4067h = true;
            }
        }

        public void m6196a(C1574b c1574b) {
            this.f4065f.add(c1574b);
        }

        public Context m6197b() {
            return this.f4061b;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            synchronized (this.f4062c) {
                if (this.f4060a == null) {
                    return;
                }
                if (this.f4060a.equals(activity)) {
                    this.f4060a = null;
                }
            }
        }

        public void onActivityPaused(Activity activity) {
            m6189a(activity);
            this.f4064e = true;
            if (this.f4066g != null) {
                rq.f5755a.removeCallbacks(this.f4066g);
            }
            Handler handler = rq.f5755a;
            Runnable c15721 = new C15721(this);
            this.f4066g = c15721;
            handler.postDelayed(c15721, this.f4068i);
        }

        public void onActivityResumed(Activity activity) {
            boolean z = false;
            m6189a(activity);
            this.f4064e = false;
            if (!this.f4063d) {
                z = true;
            }
            this.f4063d = true;
            if (this.f4066g != null) {
                rq.f5755a.removeCallbacks(this.f4066g);
            }
            synchronized (this.f4062c) {
                if (z) {
                    for (C1574b a : this.f4065f) {
                        try {
                            a.m6198a(true);
                        } catch (Throwable e) {
                            sg.m8445b("OnForegroundStateChangedListener threw exception.", e);
                        }
                    }
                } else {
                    sg.m8444b("App is still foreground.");
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            m6189a(activity);
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: com.google.android.gms.internal.fn.b */
    public interface C1574b {
        void m6198a(boolean z);
    }

    public fn() {
        this.f4069a = new Object();
        this.f4070b = null;
        this.f4071c = false;
    }

    public Activity m6199a() {
        Activity activity = null;
        synchronized (this.f4069a) {
            if (!C1387m.m4961c()) {
            } else if (this.f4070b != null) {
                activity = this.f4070b.m6194a();
            }
        }
        return activity;
    }

    public void m6200a(Context context) {
        synchronized (this.f4069a) {
            if (!this.f4071c) {
                if (!C1387m.m4961c()) {
                    return;
                } else if (((Boolean) C1648if.aD.m6682c()).booleanValue()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                    if (application == null) {
                        sg.m8449e("Can not cast Context to Application");
                        return;
                    }
                    if (this.f4070b == null) {
                        this.f4070b = new C1573a();
                    }
                    this.f4070b.m6195a(application, context);
                    this.f4071c = true;
                } else {
                    return;
                }
            }
        }
    }

    public void m6201a(C1574b c1574b) {
        synchronized (this.f4069a) {
            if (!C1387m.m4961c()) {
            } else if (((Boolean) C1648if.aD.m6682c()).booleanValue()) {
                if (this.f4070b == null) {
                    this.f4070b = new C1573a();
                }
                this.f4070b.m6196a(c1574b);
            }
        }
    }

    public Context m6202b() {
        Context context = null;
        synchronized (this.f4069a) {
            if (!C1387m.m4961c()) {
            } else if (this.f4070b != null) {
                context = this.f4070b.m6197b();
            }
        }
        return context;
    }
}
