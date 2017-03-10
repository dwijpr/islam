package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.common.C1262a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.C1895p;
import com.google.android.gms.maps.GoogleMap;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    protected int f2972a;

    public GoogleApiActivity() {
        this.f2972a = 0;
    }

    public static PendingIntent m4494a(Context context, PendingIntent pendingIntent, int i) {
        return m4495a(context, pendingIntent, i, true);
    }

    public static PendingIntent m4495a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        return PendingIntent.getActivity(context, 0, m4498b(context, pendingIntent, i, z), 134217728);
    }

    private void m4496a() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.f2972a = 1;
            } catch (Throwable e) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } else {
            C1262a.m4471a().m4490b(this, num.intValue(), 2, this);
            this.f2972a = 1;
        }
    }

    private void m4497a(int i, C1895p c1895p) {
        switch (i) {
            case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                c1895p.m8063c();
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                c1895p.m8061b(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
            default:
        }
    }

    public static Intent m4498b(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void m4499a(int i) {
        setResult(i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f2972a = 0;
            m4499a(i2);
            if (booleanExtra) {
                m4497a(i2, C1895p.m8036a((Context) this));
            }
        } else if (i == 2) {
            this.f2972a = 0;
            m4499a(i2);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f2972a = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f2972a = bundle.getInt("resolution");
        }
        if (this.f2972a != 1) {
            m4496a();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f2972a);
        super.onSaveInstanceState(bundle);
    }
}
