package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.C1314c;

@op
public class hx {
    private final Context f4317a;

    public hx(Context context) {
        C1314c.m4624a((Object) context, (Object) "Context can not be null");
        this.f4317a = context;
    }

    public static boolean m6642d() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean m6643a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m6644a(intent);
    }

    public boolean m6644a(Intent intent) {
        C1314c.m4624a((Object) intent, (Object) "Intent can not be null");
        return !this.f4317a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean m6645b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m6644a(intent);
    }

    public boolean m6646c() {
        return m6642d() && this.f4317a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public boolean m6647e() {
        return VERSION.SDK_INT >= 14 && m6644a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
