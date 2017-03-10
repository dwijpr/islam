package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

@op
public class iu implements eo {
    private CustomTabsSession f4431a;
    private CustomTabsClient f4432b;
    private CustomTabsServiceConnection f4433c;
    private C1657a f4434d;

    /* renamed from: com.google.android.gms.internal.iu.a */
    public interface C1657a {
    }

    public static boolean m6771a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(el.m5967a(context));
            }
        }
        return false;
    }

    public CustomTabsSession m6772a() {
        if (this.f4432b == null) {
            this.f4431a = null;
        } else if (this.f4431a == null) {
            this.f4431a = this.f4432b.newSession(null);
        }
        return this.f4431a;
    }

    public void m6773a(Activity activity) {
        if (this.f4433c != null) {
            activity.unbindService(this.f4433c);
            this.f4432b = null;
            this.f4431a = null;
            this.f4433c = null;
        }
    }

    public void m6774a(C1657a c1657a) {
        this.f4434d = c1657a;
    }

    public void m6775b(Activity activity) {
        if (this.f4432b == null) {
            String a = el.m5967a(activity);
            if (a != null) {
                this.f4433c = new en(this);
                CustomTabsClient.bindCustomTabsService(activity, a, this.f4433c);
            }
        }
    }
}
