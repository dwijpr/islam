package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.nn;
import com.google.android.gms.internal.sg;

public class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private nn f2765a;

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.f2765a != null) {
                this.f2765a.onActivityResult(i, i2, intent);
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2765a = gr.m6418b().m6411a((Activity) this);
        if (this.f2765a == null) {
            sg.m8449e("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.f2765a.onCreate();
        } catch (Throwable e) {
            sg.m8447c("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f2765a != null) {
                this.f2765a.onDestroy();
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
