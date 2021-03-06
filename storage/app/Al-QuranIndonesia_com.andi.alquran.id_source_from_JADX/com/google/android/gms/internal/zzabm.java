package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.p014g.C0298a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzabm extends Fragment implements C2057w {
    private static WeakHashMap<FragmentActivity, WeakReference<zzabm>> f6357a;
    private Map<String, C1587v> f6358b;
    private int f6359c;
    private Bundle f6360d;

    /* renamed from: com.google.android.gms.internal.zzabm.1 */
    class C20811 implements Runnable {
        final /* synthetic */ C1587v f6354a;
        final /* synthetic */ String f6355b;
        final /* synthetic */ zzabm f6356c;

        C20811(zzabm com_google_android_gms_internal_zzabm, C1587v c1587v, String str) {
            this.f6356c = com_google_android_gms_internal_zzabm;
            this.f6354a = c1587v;
            this.f6355b = str;
        }

        public void run() {
            if (this.f6356c.f6359c >= 1) {
                this.f6354a.m6280a(this.f6356c.f6360d != null ? this.f6356c.f6360d.getBundle(this.f6355b) : null);
            }
            if (this.f6356c.f6359c >= 2) {
                this.f6354a.m6278a();
            }
            if (this.f6356c.f6359c >= 3) {
                this.f6354a.m6282b();
            }
            if (this.f6356c.f6359c >= 4) {
                this.f6354a.m6285f();
            }
        }
    }

    static {
        f6357a = new WeakHashMap();
    }

    public zzabm() {
        this.f6358b = new C0298a();
        this.f6359c = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzabm m9712a(android.support.v4.app.FragmentActivity r3) {
        /*
        r0 = f6357a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.internal.zzabm) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getSupportFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "SupportLifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.internal.zzabm) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.internal.zzabm;
        r0.<init>();
        r1 = r3.getSupportFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "SupportLifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = f6357a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabm.a(android.support.v4.app.FragmentActivity):com.google.android.gms.internal.zzabm");
    }

    private void m9714b(String str, C1587v c1587v) {
        if (this.f6359c > 0) {
            new Handler(Looper.getMainLooper()).post(new C20811(this, c1587v, str));
        }
    }

    public /* synthetic */ Activity m9715a() {
        return m9718b();
    }

    public <T extends C1587v> T m9716a(String str, Class<T> cls) {
        return (C1587v) cls.cast(this.f6358b.get(str));
    }

    public void m9717a(String str, C1587v c1587v) {
        if (this.f6358b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f6358b.put(str, c1587v);
        m9714b(str, c1587v);
    }

    public FragmentActivity m9718b() {
        return getActivity();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (C1587v a : this.f6358b.values()) {
            a.m6281a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (C1587v a : this.f6358b.values()) {
            a.m6279a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6359c = 1;
        this.f6360d = bundle;
        for (Entry entry : this.f6358b.entrySet()) {
            ((C1587v) entry.getValue()).m6280a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6359c = 4;
        for (C1587v f : this.f6358b.values()) {
            f.m6285f();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f6358b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((C1587v) entry.getValue()).m6283b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.f6359c = 2;
        for (C1587v a : this.f6358b.values()) {
            a.m6278a();
        }
    }

    public void onStop() {
        super.onStop();
        this.f6359c = 3;
        for (C1587v b : this.f6358b.values()) {
            b.m6282b();
        }
    }
}
