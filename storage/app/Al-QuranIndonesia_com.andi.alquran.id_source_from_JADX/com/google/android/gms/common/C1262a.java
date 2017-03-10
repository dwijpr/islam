package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.recyclerview.BuildConfig;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.C1114a.C1094a;
import com.google.android.gms.C1114a.C1095b;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.C1339l;
import com.google.android.gms.common.internal.C1340m;
import com.google.android.gms.common.util.C1380f;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.C1937r;
import com.google.android.gms.internal.C1937r.C1725a;
import com.google.android.gms.internal.C2057w;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.a */
public class C1262a extends C1261h {
    public static final int f2970a;
    private static final C1262a f2971c;

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.android.gms.common.a.a */
    private class C1260a extends Handler {
        final /* synthetic */ C1262a f2966a;
        private final Context f2967b;

        public C1260a(C1262a c1262a, Context context) {
            this.f2966a = c1262a;
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f2967b = context.getApplicationContext();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    int a = this.f2966a.m4472a(this.f2967b);
                    if (this.f2966a.m4485a(a)) {
                        this.f2966a.m4481a(this.f2967b, a);
                    }
                default:
                    Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + message.what);
            }
        }
    }

    static {
        f2971c = new C1262a();
        f2970a = C1261h.f2969b;
    }

    C1262a() {
    }

    public static C1262a m4471a() {
        return f2971c;
    }

    public int m4472a(Context context) {
        return super.m4460a(context);
    }

    public Dialog m4473a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m4475a((Context) activity, i, C1340m.m4749a(activity, m4489b(activity, i, "d"), i2), onCancelListener);
    }

    public Dialog m4474a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(C1339l.m4746c(activity, 18));
        builder.setPositiveButton(BuildConfig.VERSION_NAME, null);
        Dialog create = builder.create();
        m4480a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @TargetApi(14)
    Dialog m4475a(Context context, int i, C1340m c1340m, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (C1387m.m4961c()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(context, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(C1339l.m4746c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence e = C1339l.m4748e(context, i);
        if (e != null) {
            builder.setPositiveButton(e, c1340m);
        }
        e = C1339l.m4742a(context, i);
        if (e != null) {
            builder.setTitle(e);
        }
        return builder.create();
    }

    public PendingIntent m4476a(Context context, int i, int i2) {
        return super.m4461a(context, i, i2);
    }

    public PendingIntent m4477a(Context context, int i, int i2, String str) {
        return super.m4462a(context, i, i2, str);
    }

    public PendingIntent m4478a(Context context, ConnectionResult connectionResult) {
        return connectionResult.m4451a() ? connectionResult.m4454d() : m4476a(context, connectionResult.m4453c(), 0);
    }

    public C1937r m4479a(Context context, C1725a c1725a) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver c1937r = new C1937r(c1725a);
        context.registerReceiver(c1937r, intentFilter);
        c1937r.m8360a(context);
        if (m4464a(context, "com.google.android.gms")) {
            return c1937r;
        }
        c1725a.m7163a();
        c1937r.m8359a();
        return null;
    }

    @TargetApi(11)
    void m4480a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            SupportErrorDialogFragment.m4457a(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else if (C1387m.m4959a()) {
            ErrorDialogFragment.m4456a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public void m4481a(Context context, int i) {
        m4482a(context, i, null);
    }

    public void m4482a(Context context, int i, String str) {
        m4483a(context, i, str, m4477a(context, i, 0, "n"));
    }

    @TargetApi(20)
    void m4483a(Context context, int i, String str, PendingIntent pendingIntent) {
        if (i == 18) {
            m4493c(context);
        } else if (pendingIntent != null) {
            Notification build;
            int i2;
            CharSequence b = C1339l.m4745b(context, i);
            CharSequence d = C1339l.m4747d(context, i);
            Resources resources = context.getResources();
            if (C1380f.m4943b(context)) {
                C1314c.m4628a(C1387m.m4966h());
                build = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(b).setStyle(new BigTextStyle().bigText(d)).addAction(C1094a.common_full_open_on_phone, resources.getString(C1095b.common_open_on_phone), pendingIntent).build();
            } else {
                build = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(resources.getString(C1095b.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(pendingIntent).setContentTitle(b).setContentText(d).setLocalOnly(true).setStyle(new NotificationCompat.BigTextStyle().bigText(d)).build();
            }
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    C1295j.f3030f.set(false);
                    i2 = 10436;
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (str == null) {
                notificationManager.notify(i2, build);
            } else {
                notificationManager.notify(str, i2, build);
            }
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public void m4484a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = m4478a(context, connectionResult);
        if (a != null) {
            m4483a(context, connectionResult.m4453c(), null, GoogleApiActivity.m4494a(context, a, i));
        }
    }

    public final boolean m4485a(int i) {
        return super.m4463a(i);
    }

    public boolean m4486a(Activity activity, C2057w c2057w, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m4475a((Context) activity, i, C1340m.m4750a(c2057w, m4489b(activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        m4480a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public int m4487b(Context context) {
        return super.m4465b(context);
    }

    @Deprecated
    public Intent m4488b(int i) {
        return super.m4466b(i);
    }

    public Intent m4489b(Context context, int i, String str) {
        return super.m4467b(context, i, str);
    }

    public boolean m4490b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m4473a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m4480a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public boolean m4491b(Context context, int i) {
        return super.m4468b(context, i);
    }

    public final String m4492c(int i) {
        return super.m4469c(i);
    }

    void m4493c(Context context) {
        new C1260a(this, context).sendEmptyMessageDelayed(1, 120000);
    }
}
