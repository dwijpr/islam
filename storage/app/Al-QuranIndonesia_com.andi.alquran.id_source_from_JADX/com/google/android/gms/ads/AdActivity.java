package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.nd;
import com.google.android.gms.internal.sg;
import com.google.android.gms.p039a.C1111d;

public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private nd f2305a;

    private void m3900a() {
        if (this.f2305a != null) {
            try {
                this.f2305a.zzbp();
            } catch (Throwable e) {
                sg.m8447c("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f2305a.onActivityResult(i, i2, intent);
        } catch (Throwable e) {
            sg.m8447c("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f2305a != null) {
                z = this.f2305a.zzhk();
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f2305a.zzn(C1111d.m3896a((Object) configuration));
        } catch (Throwable e) {
            sg.m8447c("Failed to wrap configuration.", e);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2305a = gr.m6418b().m6415b((Activity) this);
        if (this.f2305a == null) {
            sg.m8449e("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f2305a.onCreate(bundle);
        } catch (Throwable e) {
            sg.m8447c("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f2305a != null) {
                this.f2305a.onDestroy();
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.f2305a != null) {
                this.f2305a.onPause();
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f2305a != null) {
                this.f2305a.onRestart();
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.f2305a != null) {
                this.f2305a.onResume();
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f2305a != null) {
                this.f2305a.onSaveInstanceState(bundle);
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.f2305a != null) {
                this.f2305a.onStart();
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.f2305a != null) {
                this.f2305a.onStop();
            }
        } catch (Throwable e) {
            sg.m8447c("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m3900a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m3900a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m3900a();
    }
}
