package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public class am {
    public static nm m5136a(Context context) {
        return m5137a(context, null);
    }

    public static nm m5137a(Context context, vv vvVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = new StringBuilder(String.valueOf(packageName).length() + 12).append(packageName).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
        } catch (NameNotFoundException e) {
        }
        if (vvVar == null) {
            vvVar = VERSION.SDK_INT >= 9 ? new vw() : new vt(AndroidHttpClient.newInstance(str));
        }
        nm nmVar = new nm(new vs(file), new vj(vvVar));
        nmVar.m7770a();
        return nmVar;
    }
}
