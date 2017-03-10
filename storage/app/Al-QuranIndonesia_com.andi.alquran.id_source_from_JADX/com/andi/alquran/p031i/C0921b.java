package com.andi.alquran.p031i;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p022f.C0733b;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.andi.alquran.i.b */
public class C0921b extends AsyncTask<String, Void, Integer> {
    private ProgressDialog f1846a;
    private String f1847b;
    private C0733b f1848c;
    private boolean f1849d;
    private int f1850e;

    /* renamed from: com.andi.alquran.i.b.1 */
    class C09201 implements OnCancelListener {
        final /* synthetic */ C0921b f1845a;

        C09201(C0921b c0921b) {
            this.f1845a = c0921b;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f1845a.cancel(true);
            this.f1845a.f1849d = true;
        }
    }

    public C0921b(Context context, String str, C0733b c0733b) {
        this.f1849d = false;
        this.f1850e = 7000;
        this.f1847b = str;
        this.f1848c = c0733b;
        this.f1849d = false;
        this.f1846a = new ProgressDialog(context);
        this.f1846a.setMessage(context.getString(C0861R.string.msg_checking_server_download));
        this.f1846a.setProgressStyle(0);
        this.f1846a.setCanceledOnTouchOutside(false);
        this.f1846a.show();
        this.f1846a.setOnCancelListener(new C09201(this));
    }

    private int m3210a() {
        if (this.f1849d) {
            return 4;
        }
        String str = App.m2888m() + this.f1847b;
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.setConnectTimeout(this.f1850e);
            httpURLConnection.setReadTimeout(this.f1850e);
            httpURLConnection.setUseCaches(true);
            if (isCancelled()) {
                httpURLConnection.disconnect();
            }
            return httpURLConnection.getResponseCode() == Callback.DEFAULT_DRAG_ANIMATION_DURATION ? 1 : m3212b();
        } catch (Exception e) {
            return m3212b();
        }
    }

    private int m3212b() {
        if (this.f1849d) {
            return 4;
        }
        String str = App.m2889n() + this.f1847b;
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.setConnectTimeout(this.f1850e);
            httpURLConnection.setReadTimeout(this.f1850e);
            httpURLConnection.setUseCaches(true);
            if (isCancelled()) {
                httpURLConnection.disconnect();
            }
            return httpURLConnection.getResponseCode() == Callback.DEFAULT_DRAG_ANIMATION_DURATION ? 2 : m3213c();
        } catch (Exception e) {
            return m3213c();
        }
    }

    private int m3213c() {
        if (this.f1849d) {
            return 4;
        }
        String str = App.m2890o() + this.f1847b;
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.setConnectTimeout(this.f1850e);
            httpURLConnection.setReadTimeout(this.f1850e);
            httpURLConnection.setUseCaches(true);
            if (isCancelled()) {
                httpURLConnection.disconnect();
            }
            return httpURLConnection.getResponseCode() == Callback.DEFAULT_DRAG_ANIMATION_DURATION ? 3 : 0;
        } catch (Exception e) {
            return 0;
        }
    }

    protected Integer m3214a(String... strArr) {
        return Integer.valueOf(m3210a());
    }

    protected void m3215a(Integer num) {
        if (!isCancelled() && !this.f1849d) {
            this.f1848c.m2564a(num.intValue());
            if (this.f1846a != null && this.f1846a.isShowing()) {
                this.f1846a.dismiss();
            }
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3214a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3215a((Integer) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }
}
