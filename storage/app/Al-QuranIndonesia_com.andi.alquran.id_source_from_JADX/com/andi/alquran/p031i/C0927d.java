package com.andi.alquran.p031i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.v7.app.AlertDialog.Builder;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p025b.C0882e;
import com.andi.alquran.p032j.C0940b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.andi.alquran.i.d */
public class C0927d extends AsyncTask<Void, Integer, Boolean> {
    private ProgressDialog f1857a;
    private Context f1858b;
    private int f1859c;

    /* renamed from: com.andi.alquran.i.d.1 */
    class C09251 implements OnClickListener {
        final /* synthetic */ C0927d f1855a;

        C09251(C0927d c0927d) {
            this.f1855a = c0927d;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.andi.alquran.i.d.2 */
    class C09262 implements OnClickListener {
        final /* synthetic */ C0927d f1856a;

        C09262(C0927d c0927d) {
            this.f1856a = c0927d;
        }

        @SuppressLint({"InlinedApi"})
        public void onClick(DialogInterface dialogInterface, int i) {
            if (VERSION.SDK_INT >= 11) {
                new C0937m(this.f1856a.f1858b, this.f1856a.f1859c, App.m2873c()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new C0937m(this.f1856a.f1858b, this.f1856a.f1859c, App.m2873c()).execute(new Void[0]);
            }
        }
    }

    public C0927d(Context context) {
        this.f1859c = App.m2866b();
        this.f1858b = context;
        this.f1857a = new ProgressDialog(context);
        this.f1857a.setProgressStyle(0);
        this.f1857a.setMessage(context.getString(C0861R.string.check_progressing));
        this.f1857a.setCancelable(true);
        this.f1857a.show();
    }

    protected Boolean m3221a(Void... voidArr) {
        String a = new C0940b().m3275a(C0882e.f1682a + "?success=true");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        if (a != null) {
            try {
                this.f1859c = new JSONObject(a).getInt(C0882e.f1688g);
                if (this.f1859c > App.m2866b()) {
                    return Boolean.valueOf(true);
                }
            } catch (JSONException e2) {
                e2.getMessage();
            }
        }
        return Boolean.valueOf(false);
    }

    protected void m3222a(Boolean bool) {
        if (!((Activity) this.f1858b).isFinishing()) {
            if (this.f1857a != null && this.f1857a.isShowing()) {
                this.f1857a.dismiss();
            }
            if (bool.booleanValue()) {
                new Builder(this.f1858b).setIcon((int) C0861R.drawable.ic_black_action_about).setTitle(this.f1858b.getString(C0861R.string.msg_update_content_dialog_title)).setMessage(this.f1858b.getString(C0861R.string.msg_update_content_dialog_desc)).setCancelable(false).setPositiveButton(this.f1858b.getString(C0861R.string.msg_update_content_dialog_button), new C09262(this)).setNegativeButton(this.f1858b.getString(C0861R.string.update_button_later), new C09251(this)).show();
            } else {
                App.m2871b(this.f1858b.getString(C0861R.string.check_app_content_is_updated));
            }
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3221a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3222a((Boolean) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }
}
