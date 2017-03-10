package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.common.internal.s */
public class C1352s {
    private static final Uri f3137a;
    private static final Uri f3138b;

    static {
        f3137a = Uri.parse("http://plus.google.com/");
        f3138b = f3137a.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent m4793a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent m4794a(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent m4795a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(C1352s.m4796b(str, str2));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    private static Uri m4796b(String str, String str2) {
        Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        return appendQueryParameter.build();
    }
}
