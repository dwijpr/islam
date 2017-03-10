package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

class fi implements ActivityLifecycleCallbacks {
    private final Application f4034a;
    private final WeakReference<ActivityLifecycleCallbacks> f4035b;

    /* renamed from: com.google.android.gms.internal.fi.a */
    public interface C1564a {
        void m6152a(ActivityLifecycleCallbacks activityLifecycleCallbacks);
    }

    /* renamed from: com.google.android.gms.internal.fi.1 */
    class C15651 implements C1564a {
        final /* synthetic */ Activity f4025a;
        final /* synthetic */ Bundle f4026b;

        C15651(fi fiVar, Activity activity, Bundle bundle) {
            this.f4025a = activity;
            this.f4026b = bundle;
        }

        public void m6153a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityCreated(this.f4025a, this.f4026b);
        }
    }

    /* renamed from: com.google.android.gms.internal.fi.2 */
    class C15662 implements C1564a {
        final /* synthetic */ Activity f4027a;

        C15662(fi fiVar, Activity activity) {
            this.f4027a = activity;
        }

        public void m6154a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityStarted(this.f4027a);
        }
    }

    /* renamed from: com.google.android.gms.internal.fi.3 */
    class C15673 implements C1564a {
        final /* synthetic */ Activity f4028a;

        C15673(fi fiVar, Activity activity) {
            this.f4028a = activity;
        }

        public void m6155a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityResumed(this.f4028a);
        }
    }

    /* renamed from: com.google.android.gms.internal.fi.4 */
    class C15684 implements C1564a {
        final /* synthetic */ Activity f4029a;

        C15684(fi fiVar, Activity activity) {
            this.f4029a = activity;
        }

        public void m6156a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityPaused(this.f4029a);
        }
    }

    /* renamed from: com.google.android.gms.internal.fi.5 */
    class C15695 implements C1564a {
        final /* synthetic */ Activity f4030a;

        C15695(fi fiVar, Activity activity) {
            this.f4030a = activity;
        }

        public void m6157a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityStopped(this.f4030a);
        }
    }

    /* renamed from: com.google.android.gms.internal.fi.6 */
    class C15706 implements C1564a {
        final /* synthetic */ Activity f4031a;
        final /* synthetic */ Bundle f4032b;

        C15706(fi fiVar, Activity activity, Bundle bundle) {
            this.f4031a = activity;
            this.f4032b = bundle;
        }

        public void m6158a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivitySaveInstanceState(this.f4031a, this.f4032b);
        }
    }

    /* renamed from: com.google.android.gms.internal.fi.7 */
    class C15717 implements C1564a {
        final /* synthetic */ Activity f4033a;

        C15717(fi fiVar, Activity activity) {
            this.f4033a = activity;
        }

        public void m6159a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activityLifecycleCallbacks.onActivityDestroyed(this.f4033a);
        }
    }

    public fi(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f4035b = new WeakReference(activityLifecycleCallbacks);
        this.f4034a = application;
    }

    protected void m6160a(C1564a c1564a) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.f4035b.get();
            if (activityLifecycleCallbacks != null) {
                c1564a.m6152a(activityLifecycleCallbacks);
            } else {
                this.f4034a.unregisterActivityLifecycleCallbacks(this);
            }
        } catch (Throwable e) {
            sg.m8445b("Error while dispatching lifecycle callback.", e);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        m6160a(new C15651(this, activity, bundle));
    }

    public void onActivityDestroyed(Activity activity) {
        m6160a(new C15717(this, activity));
    }

    public void onActivityPaused(Activity activity) {
        m6160a(new C15684(this, activity));
    }

    public void onActivityResumed(Activity activity) {
        m6160a(new C15673(this, activity));
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m6160a(new C15706(this, activity, bundle));
    }

    public void onActivityStarted(Activity activity) {
        m6160a(new C15662(this, activity));
    }

    public void onActivityStopped(Activity activity) {
        m6160a(new C15695(this, activity));
    }
}
