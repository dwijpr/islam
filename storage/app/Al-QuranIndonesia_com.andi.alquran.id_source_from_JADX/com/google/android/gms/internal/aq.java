package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.util.C1387m;

public class aq {
    protected final Context f3342a;

    public aq(Context context) {
        this.f3342a = context;
    }

    public int m5138a(String str) {
        return this.f3342a.checkCallingOrSelfPermission(str);
    }

    public int m5139a(String str, String str2) {
        return this.f3342a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo m5140a(String str, int i) {
        return this.f3342a.getPackageManager().getApplicationInfo(str, i);
    }

    @TargetApi(19)
    public boolean m5141a(int i, String str) {
        if (C1387m.m4965g()) {
            try {
                ((AppOpsManager) this.f3342a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.f3342a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public PackageInfo m5142b(String str, int i) {
        return this.f3342a.getPackageManager().getPackageInfo(str, i);
    }

    public CharSequence m5143b(String str) {
        return this.f3342a.getPackageManager().getApplicationLabel(this.f3342a.getPackageManager().getApplicationInfo(str, 0));
    }
}
