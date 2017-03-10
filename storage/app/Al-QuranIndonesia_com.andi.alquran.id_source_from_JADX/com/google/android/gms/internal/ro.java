package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.recyclerview.BuildConfig;
import java.util.concurrent.Future;

@op
public final class ro {

    /* renamed from: com.google.android.gms.internal.ro.b */
    public interface C1942b {
        void m8385a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.internal.ro.a */
    private static abstract class C1944a extends rl {
        private C1944a() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.10 */
    class AnonymousClass10 extends C1944a {
        final /* synthetic */ Context f5706a;
        final /* synthetic */ C1942b f5707b;

        AnonymousClass10(Context context, C1942b c1942b) {
            this.f5706a = context;
            this.f5707b = c1942b;
            super();
        }

        public void zzcm() {
            SharedPreferences a = ro.m8453a(this.f5706a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", a.getBoolean("auto_collect_location", false));
            if (this.f5707b != null) {
                this.f5707b.m8385a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.11 */
    class AnonymousClass11 extends C1944a {
        final /* synthetic */ Context f5708a;
        final /* synthetic */ String f5709b;
        final /* synthetic */ long f5710c;

        AnonymousClass11(Context context, String str, long j) {
            this.f5708a = context;
            this.f5709b = str;
            this.f5710c = j;
            super();
        }

        public void zzcm() {
            Editor edit = ro.m8453a(this.f5708a).edit();
            edit.putString("app_settings_json", this.f5709b);
            edit.putLong("app_settings_last_update_ms", this.f5710c);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.12 */
    class AnonymousClass12 extends C1944a {
        final /* synthetic */ Context f5711a;
        final /* synthetic */ C1942b f5712b;

        AnonymousClass12(Context context, C1942b c1942b) {
            this.f5711a = context;
            this.f5712b = c1942b;
            super();
        }

        public void zzcm() {
            SharedPreferences a = ro.m8453a(this.f5711a);
            Bundle bundle = new Bundle();
            bundle.putString("app_settings_json", a.getString("app_settings_json", BuildConfig.VERSION_NAME));
            bundle.putLong("app_settings_last_update_ms", a.getLong("app_settings_last_update_ms", 0));
            if (this.f5712b != null) {
                this.f5712b.m8385a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.13 */
    class AnonymousClass13 extends C1944a {
        final /* synthetic */ Context f5713a;
        final /* synthetic */ long f5714b;

        AnonymousClass13(Context context, long j) {
            this.f5713a = context;
            this.f5714b = j;
            super();
        }

        public void zzcm() {
            Editor edit = ro.m8453a(this.f5713a).edit();
            edit.putLong("app_last_background_time_ms", this.f5714b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.14 */
    class AnonymousClass14 extends C1944a {
        final /* synthetic */ Context f5715a;
        final /* synthetic */ C1942b f5716b;

        AnonymousClass14(Context context, C1942b c1942b) {
            this.f5715a = context;
            this.f5716b = c1942b;
            super();
        }

        public void zzcm() {
            SharedPreferences a = ro.m8453a(this.f5715a);
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", a.getLong("app_last_background_time_ms", 0));
            if (this.f5716b != null) {
                this.f5716b.m8385a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.15 */
    class AnonymousClass15 extends C1944a {
        final /* synthetic */ Context f5717a;
        final /* synthetic */ int f5718b;

        AnonymousClass15(Context context, int i) {
            this.f5717a = context;
            this.f5718b = i;
            super();
        }

        public void zzcm() {
            Editor edit = ro.m8453a(this.f5717a).edit();
            edit.putInt("request_in_session_count", this.f5718b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.1 */
    class C19451 extends C1944a {
        final /* synthetic */ Context f5719a;
        final /* synthetic */ boolean f5720b;

        C19451(Context context, boolean z) {
            this.f5719a = context;
            this.f5720b = z;
            super();
        }

        public void zzcm() {
            Editor edit = ro.m8453a(this.f5719a).edit();
            edit.putBoolean("use_https", this.f5720b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.2 */
    class C19462 extends C1944a {
        final /* synthetic */ Context f5721a;
        final /* synthetic */ C1942b f5722b;

        C19462(Context context, C1942b c1942b) {
            this.f5721a = context;
            this.f5722b = c1942b;
            super();
        }

        public void zzcm() {
            SharedPreferences a = ro.m8453a(this.f5721a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", a.getBoolean("use_https", true));
            if (this.f5722b != null) {
                this.f5722b.m8385a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.3 */
    class C19473 extends C1944a {
        final /* synthetic */ Context f5723a;
        final /* synthetic */ C1942b f5724b;

        C19473(Context context, C1942b c1942b) {
            this.f5723a = context;
            this.f5724b = c1942b;
            super();
        }

        public void zzcm() {
            SharedPreferences a = ro.m8453a(this.f5723a);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", a.getInt("webview_cache_version", 0));
            if (this.f5724b != null) {
                this.f5724b.m8385a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.4 */
    class C19484 extends C1944a {
        final /* synthetic */ Context f5725a;
        final /* synthetic */ boolean f5726b;

        C19484(Context context, boolean z) {
            this.f5725a = context;
            this.f5726b = z;
            super();
        }

        public void zzcm() {
            Editor edit = ro.m8453a(this.f5725a).edit();
            edit.putBoolean("content_url_opted_out", this.f5726b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.5 */
    class C19495 extends C1944a {
        final /* synthetic */ Context f5727a;
        final /* synthetic */ C1942b f5728b;

        C19495(Context context, C1942b c1942b) {
            this.f5727a = context;
            this.f5728b = c1942b;
            super();
        }

        public void zzcm() {
            SharedPreferences a = ro.m8453a(this.f5727a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", a.getBoolean("content_url_opted_out", true));
            if (this.f5728b != null) {
                this.f5728b.m8385a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.6 */
    class C19506 extends C1944a {
        final /* synthetic */ Context f5729a;
        final /* synthetic */ String f5730b;

        C19506(Context context, String str) {
            this.f5729a = context;
            this.f5730b = str;
            super();
        }

        public void zzcm() {
            Editor edit = ro.m8453a(this.f5729a).edit();
            edit.putString("content_url_hashes", this.f5730b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.7 */
    class C19517 extends C1944a {
        final /* synthetic */ Context f5731a;
        final /* synthetic */ C1942b f5732b;

        C19517(Context context, C1942b c1942b) {
            this.f5731a = context;
            this.f5732b = c1942b;
            super();
        }

        public void zzcm() {
            SharedPreferences a = ro.m8453a(this.f5731a);
            Bundle bundle = new Bundle();
            bundle.putString("content_url_hashes", a.getString("content_url_hashes", BuildConfig.VERSION_NAME));
            if (this.f5732b != null) {
                this.f5732b.m8385a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.8 */
    class C19528 extends C1944a {
        final /* synthetic */ Context f5733a;
        final /* synthetic */ String f5734b;

        C19528(Context context, String str) {
            this.f5733a = context;
            this.f5734b = str;
            super();
        }

        public void zzcm() {
            Editor edit = ro.m8453a(this.f5733a).edit();
            edit.putString("content_vertical_hashes", this.f5734b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.ro.9 */
    class C19539 extends C1944a {
        final /* synthetic */ Context f5735a;
        final /* synthetic */ boolean f5736b;

        C19539(Context context, boolean z) {
            this.f5735a = context;
            this.f5736b = z;
            super();
        }

        public void zzcm() {
            Editor edit = ro.m8453a(this.f5735a).edit();
            edit.putBoolean("auto_collect_location", this.f5736b);
            edit.apply();
        }
    }

    public static SharedPreferences m8453a(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static Future m8454a(Context context, int i) {
        return (Future) new AnonymousClass15(context, i).zziw();
    }

    public static Future m8455a(Context context, long j) {
        return (Future) new AnonymousClass13(context, j).zziw();
    }

    public static Future m8456a(Context context, C1942b c1942b) {
        return (Future) new C19462(context, c1942b).zziw();
    }

    public static Future m8457a(Context context, String str) {
        return (Future) new C19506(context, str).zziw();
    }

    public static Future m8458a(Context context, String str, long j) {
        return (Future) new AnonymousClass11(context, str, j).zziw();
    }

    public static Future m8459a(Context context, boolean z) {
        return (Future) new C19451(context, z).zziw();
    }

    public static Future m8460b(Context context, C1942b c1942b) {
        return (Future) new C19473(context, c1942b).zziw();
    }

    public static Future m8461b(Context context, String str) {
        return (Future) new C19528(context, str).zziw();
    }

    public static Future m8462b(Context context, boolean z) {
        return (Future) new C19484(context, z).zziw();
    }

    public static Future m8463c(Context context, C1942b c1942b) {
        return (Future) new C19495(context, c1942b).zziw();
    }

    public static Future m8464c(Context context, boolean z) {
        return (Future) new C19539(context, z).zziw();
    }

    public static Future m8465d(Context context, C1942b c1942b) {
        return (Future) new C19517(context, c1942b).zziw();
    }

    public static Future m8466e(Context context, C1942b c1942b) {
        return (Future) new AnonymousClass10(context, c1942b).zziw();
    }

    public static Future m8467f(Context context, C1942b c1942b) {
        return (Future) new AnonymousClass12(context, c1942b).zziw();
    }

    public static Future m8468g(Context context, C1942b c1942b) {
        return (Future) new AnonymousClass14(context, c1942b).zziw();
    }
}
