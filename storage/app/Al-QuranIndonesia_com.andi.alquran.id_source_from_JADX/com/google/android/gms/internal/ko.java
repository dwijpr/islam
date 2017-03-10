package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@op
public final class ko implements kg {
    private final ki f4643a;
    private final zze f4644b;
    private final mv f4645c;

    /* renamed from: com.google.android.gms.internal.ko.a */
    public static class C1717a {
        private final sx f4642a;

        public C1717a(sx sxVar) {
            this.f4642a = sxVar;
        }

        public Intent m7114a(Context context, Map<String, String> map) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.f4642a != null) {
                str = zzv.zzcJ().m8499a(this.f4642a, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent a = m7116a(parse);
            Intent a2 = m7116a(build);
            ResolveInfo a3 = m7118a(context, a, arrayList);
            if (a3 != null) {
                return m7115a(a, a3);
            }
            if (a2 != null) {
                ResolveInfo a4 = m7117a(context, a2);
                if (a4 != null) {
                    Intent a5 = m7115a(a, a4);
                    if (m7117a(context, a5) != null) {
                        return a5;
                    }
                }
            }
            if (arrayList.size() == 0) {
                return a;
            }
            if (parseBoolean2 && activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                return m7115a(a, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? m7115a(a, (ResolveInfo) arrayList.get(0)) : a;
        }

        public Intent m7115a(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public Intent m7116a(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }

        public ResolveInfo m7117a(Context context, Intent intent) {
            return m7118a(context, intent, new ArrayList());
        }

        public ResolveInfo m7118a(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ResolveInfo resolveInfo;
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (!(queryIntentActivities == null || resolveActivity == null)) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }
    }

    public ko(ki kiVar, zze com_google_android_gms_ads_internal_zze, mv mvVar) {
        this.f4643a = kiVar;
        this.f4644b = com_google_android_gms_ads_internal_zze;
        this.f4645c = mvVar;
    }

    private void m7119a(boolean z) {
        if (this.f4645c != null) {
            this.f4645c.m7704a(z);
        }
    }

    private static boolean m7120a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m7121b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzv.zzcL().m8574b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzv.zzcL().m8560a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzv.zzcL().m8578c();
            }
        }
        return -1;
    }

    private static void m7122b(sx sxVar, Map<String, String> map) {
        Context context = sxVar.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            sg.m8449e("Destination url cannot be empty.");
            return;
        }
        try {
            sxVar.m8776l().m8803a(new zzc(new C1717a(sxVar).m7114a(context, (Map) map)));
        } catch (ActivityNotFoundException e) {
            sg.m8449e(e.getMessage());
        }
    }

    public void m7123a(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            sg.m8449e("Action missing from an open GMSG.");
        } else if (this.f4644b == null || this.f4644b.zzcb()) {
            sy l = sxVar.m8776l();
            if ("expand".equalsIgnoreCase(str)) {
                if (sxVar.m8780p()) {
                    sg.m8449e("Cannot expand WebView that is already expanded.");
                    return;
                }
                m7119a(false);
                l.m8812a(m7120a((Map) map), m7121b(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                m7119a(false);
                if (str != null) {
                    l.m8813a(m7120a((Map) map), m7121b(map), str);
                } else {
                    l.m8814a(m7120a((Map) map), m7121b(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.f4643a == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.f4643a.zza(str, new ArrayList());
                } else {
                    this.f4643a.zza(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                m7119a(true);
                m7122b(sxVar, map);
            } else {
                m7119a(true);
                str = (String) map.get("u");
                l.m8803a(new zzc((String) map.get("i"), !TextUtils.isEmpty(str) ? zzv.zzcJ().m8499a(sxVar, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.f4644b.zzx((String) map.get("u"));
        }
    }
}
