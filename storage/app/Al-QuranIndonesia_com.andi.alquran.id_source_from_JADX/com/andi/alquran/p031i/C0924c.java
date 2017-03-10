package com.andi.alquran.p031i;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog.Builder;
import com.andi.alquran.App;
import com.andi.alquran.BuildConfig;
import com.andi.alquran.C0861R;
import com.andi.alquran.p025b.C0882e;
import com.andi.alquran.p032j.C0940b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.andi.alquran.i.c */
public class C0924c extends AsyncTask<Void, Integer, Boolean> {
    private ProgressDialog f1853a;
    private Context f1854b;

    /* renamed from: com.andi.alquran.i.c.1 */
    class C09221 implements OnClickListener {
        final /* synthetic */ C0924c f1851a;

        C09221(C0924c c0924c) {
            this.f1851a = c0924c;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.i.c.2 */
    class C09232 implements OnClickListener {
        final /* synthetic */ C0924c f1852a;

        C09232(C0924c c0924c) {
            this.f1852a = c0924c;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1852a.f1854b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.andi.alquran.id")));
        }
    }

    public C0924c(Context context) {
        this.f1854b = context;
        this.f1853a = new ProgressDialog(context);
        this.f1853a.setProgressStyle(0);
        this.f1853a.setMessage(context.getString(C0861R.string.check_progressing));
        this.f1853a.setCancelable(true);
        this.f1853a.show();
    }

    protected Boolean m3217a(Void... voidArr) {
        String a = new C0940b().m3275a(C0882e.f1682a + "?success=true");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        if (a != null) {
            try {
                if (new JSONObject(a).getInt(BuildConfig.APPLICATION_ID) > 94) {
                    return Boolean.valueOf(true);
                }
            } catch (JSONException e2) {
                e2.getMessage();
            }
        }
        return Boolean.valueOf(false);
    }

    protected void m3218a(Boolean bool) {
        if (!((Activity) this.f1854b).isFinishing()) {
            if (this.f1853a != null && this.f1853a.isShowing()) {
                this.f1853a.dismiss();
            }
            if (bool.booleanValue()) {
                new Builder(this.f1854b).setIcon((int) C0861R.drawable.ic_black_action_about).setTitle(this.f1854b.getString(C0861R.string.update_title)).setMessage(this.f1854b.getString(C0861R.string.update_description)).setCancelable(false).setPositiveButton(this.f1854b.getString(C0861R.string.update_button_yes), new C09232(this)).setNegativeButton(this.f1854b.getString(C0861R.string.update_button_later), new C09221(this)).show();
            } else {
                App.m2871b(this.f1854b.getString(C0861R.string.check_app_version_is_updated));
            }
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3217a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3218a((Boolean) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }
}
