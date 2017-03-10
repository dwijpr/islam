package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.C1380f;
import java.util.Locale;

@op
public final class po {
    public final int f5489a;
    public final boolean f5490b;
    public final boolean f5491c;
    public final String f5492d;
    public final String f5493e;
    public final boolean f5494f;
    public final boolean f5495g;
    public final boolean f5496h;
    public final boolean f5497i;
    public final String f5498j;
    public final String f5499k;
    public final int f5500l;
    public final int f5501m;
    public final int f5502n;
    public final int f5503o;
    public final int f5504p;
    public final int f5505q;
    public final float f5506r;
    public final int f5507s;
    public final int f5508t;
    public final double f5509u;
    public final boolean f5510v;
    public final boolean f5511w;
    public final int f5512x;
    public final String f5513y;
    public final boolean f5514z;

    /* renamed from: com.google.android.gms.internal.po.a */
    public static final class C1917a {
        private int f5463a;
        private boolean f5464b;
        private boolean f5465c;
        private int f5466d;
        private int f5467e;
        private int f5468f;
        private String f5469g;
        private int f5470h;
        private int f5471i;
        private int f5472j;
        private boolean f5473k;
        private int f5474l;
        private double f5475m;
        private boolean f5476n;
        private String f5477o;
        private boolean f5478p;
        private boolean f5479q;
        private String f5480r;
        private boolean f5481s;
        private boolean f5482t;
        private String f5483u;
        private String f5484v;
        private float f5485w;
        private int f5486x;
        private int f5487y;
        private boolean f5488z;

        public C1917a(Context context) {
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            m8194a(context);
            m8195a(context, packageManager);
            m8196b(context);
            Locale locale = Locale.getDefault();
            this.f5478p = C1917a.m8192a(packageManager, "geo:0,0?q=donuts") != null;
            if (C1917a.m8192a(packageManager, "http://www.google.com") == null) {
                z = false;
            }
            this.f5479q = z;
            this.f5480r = locale.getCountry();
            this.f5481s = gr.m6416a().m8701a();
            this.f5482t = C1380f.m4944c(context);
            this.f5483u = locale.getLanguage();
            this.f5484v = C1917a.m8193a(packageManager);
            Resources resources = context.getResources();
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                if (displayMetrics != null) {
                    this.f5485w = displayMetrics.density;
                    this.f5486x = displayMetrics.widthPixels;
                    this.f5487y = displayMetrics.heightPixels;
                }
            }
        }

        public C1917a(Context context, po poVar) {
            PackageManager packageManager = context.getPackageManager();
            m8194a(context);
            m8195a(context, packageManager);
            m8196b(context);
            m8197c(context);
            this.f5478p = poVar.f5490b;
            this.f5479q = poVar.f5491c;
            this.f5480r = poVar.f5493e;
            this.f5481s = poVar.f5494f;
            this.f5482t = poVar.f5495g;
            this.f5483u = poVar.f5498j;
            this.f5484v = poVar.f5499k;
            this.f5485w = poVar.f5506r;
            this.f5486x = poVar.f5507s;
            this.f5487y = poVar.f5508t;
        }

        private static ResolveInfo m8192a(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String m8193a(PackageManager packageManager) {
            String str = null;
            ResolveInfo a = C1917a.m8192a(packageManager, "market://details?id=com.google.android.gms.ads");
            if (a != null) {
                ActivityInfo activityInfo = a.activityInfo;
                if (activityInfo != null) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                        if (packageInfo != null) {
                            int i = packageInfo.versionCode;
                            String valueOf = String.valueOf(activityInfo.packageName);
                            str = new StringBuilder(String.valueOf(valueOf).length() + 12).append(i).append(".").append(valueOf).toString();
                        }
                    } catch (NameNotFoundException e) {
                    }
                }
            }
            return str;
        }

        private void m8194a(Context context) {
            AudioManager i = zzv.zzcJ().m8553i(context);
            if (i != null) {
                try {
                    this.f5463a = i.getMode();
                    this.f5464b = i.isMusicActive();
                    this.f5465c = i.isSpeakerphoneOn();
                    this.f5466d = i.getStreamVolume(3);
                    this.f5467e = i.getRingerMode();
                    this.f5468f = i.getStreamVolume(2);
                    return;
                } catch (Throwable th) {
                    zzv.zzcN().m8399a(th, "DeviceInfo.gatherAudioInfo");
                }
            }
            this.f5463a = -2;
            this.f5464b = false;
            this.f5465c = false;
            this.f5466d = 0;
            this.f5467e = 0;
            this.f5468f = 0;
        }

        @TargetApi(16)
        private void m8195a(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.f5469g = telephonyManager.getNetworkOperator();
            this.f5471i = telephonyManager.getNetworkType();
            this.f5472j = telephonyManager.getPhoneType();
            this.f5470h = -2;
            this.f5473k = false;
            this.f5474l = -1;
            if (zzv.zzcJ().m8524a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.f5470h = activeNetworkInfo.getType();
                    this.f5474l = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.f5470h = -1;
                }
                if (VERSION.SDK_INT >= 16) {
                    this.f5473k = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        private void m8196b(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra(NotificationCompatApi24.CATEGORY_STATUS, -1);
                this.f5475m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.f5476n = z;
                return;
            }
            this.f5475m = -1.0d;
            this.f5476n = false;
        }

        private void m8197c(Context context) {
            this.f5477o = Build.FINGERPRINT;
            this.f5488z = iu.m6771a(context);
        }

        public po m8198a() {
            return new po(this.f5463a, this.f5478p, this.f5479q, this.f5469g, this.f5480r, this.f5481s, this.f5482t, this.f5464b, this.f5465c, this.f5483u, this.f5484v, this.f5466d, this.f5470h, this.f5471i, this.f5472j, this.f5467e, this.f5468f, this.f5485w, this.f5486x, this.f5487y, this.f5475m, this.f5476n, this.f5473k, this.f5474l, this.f5477o, this.f5488z);
        }
    }

    po(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5, boolean z9) {
        this.f5489a = i;
        this.f5490b = z;
        this.f5491c = z2;
        this.f5492d = str;
        this.f5493e = str2;
        this.f5494f = z3;
        this.f5495g = z4;
        this.f5496h = z5;
        this.f5497i = z6;
        this.f5498j = str3;
        this.f5499k = str4;
        this.f5500l = i2;
        this.f5501m = i3;
        this.f5502n = i4;
        this.f5503o = i5;
        this.f5504p = i6;
        this.f5505q = i7;
        this.f5506r = f;
        this.f5507s = i8;
        this.f5508t = i9;
        this.f5509u = d;
        this.f5510v = z7;
        this.f5511w = z8;
        this.f5512x = i10;
        this.f5513y = str5;
        this.f5514z = z9;
    }
}
