package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    /* renamed from: com.google.android.gms.tagmanager.PreviewActivity.1 */
    class C21941 implements OnClickListener {
        C21941(PreviewActivity previewActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void m10089a(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C21941(this));
        create.show();
    }

    public void onCreate(Bundle bundle) {
        String valueOf;
        String str;
        try {
            super.onCreate(bundle);
            C2238n.m10268c("Preview activity");
            Uri data = getIntent().getData();
            if (!C2226d.m10237a((Context) this).m10243a(data)) {
                valueOf = String.valueOf(data);
                valueOf = new StringBuilder(String.valueOf(valueOf).length() + 73).append("Cannot preview the app with the uri: ").append(valueOf).append(". Launching current version instead.").toString();
                C2238n.m10266b(valueOf);
                m10089a("Preview failure", valueOf, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                String str2 = "Invoke the launch activity for package name: ";
                valueOf = String.valueOf(getPackageName());
                C2238n.m10268c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                startActivity(launchIntentForPackage);
                return;
            }
            str = "No launch activity found for package name: ";
            valueOf = String.valueOf(getPackageName());
            C2238n.m10268c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } catch (Exception e) {
            str = "Calling preview threw an exception: ";
            valueOf = String.valueOf(e.getMessage());
            C2238n.m10264a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
