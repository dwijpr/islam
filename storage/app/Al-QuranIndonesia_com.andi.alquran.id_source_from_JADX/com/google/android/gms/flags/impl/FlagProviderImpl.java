package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.flags.impl.C1413a.C1414a;
import com.google.android.gms.flags.impl.C1413a.C1416b;
import com.google.android.gms.flags.impl.C1413a.C1418c;
import com.google.android.gms.flags.impl.C1413a.C1420d;
import com.google.android.gms.internal.bd.C1411a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

@DynamiteApi
public class FlagProviderImpl extends C1411a {
    private SharedPreferences zzAN;
    private boolean zztW;

    public FlagProviderImpl() {
        this.zztW = false;
    }

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.zztW ? z : C1414a.m5031a(this.zzAN, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.zztW ? i : C1416b.m5033a(this.zzAN, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.zztW ? j : C1418c.m5035a(this.zzAN, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.zztW ? str2 : C1420d.m5037a(this.zzAN, str, str2);
    }

    public void init(C1108c c1108c) {
        Context context = (Context) C1111d.m3897a(c1108c);
        if (!this.zztW) {
            try {
                this.zzAN = C1422b.m5039a(context.createPackageContext("com.google.android.gms", 0));
                this.zztW = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
