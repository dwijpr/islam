package com.andi.alquran.p031i;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import com.andi.alquran.p025b.C0882e;
import com.andi.alquran.p032j.C0952k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import p017b.p018a.p019a.p020a.C0723a;
import p017b.p018a.p019a.p020a.C0724b;

/* renamed from: com.andi.alquran.i.m */
public class C0937m extends AsyncTask<Void, Integer, Boolean> {
    private int f1887a;
    private ProgressDialog f1888b;
    private String f1889c;
    private Context f1890d;

    /* renamed from: com.andi.alquran.i.m.1 */
    class C09361 implements OnCancelListener {
        final /* synthetic */ C0937m f1886a;

        C09361(C0937m c0937m) {
            this.f1886a = c0937m;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f1886a.cancel(true);
        }
    }

    public C0937m(Context context, int i, String str) {
        this.f1890d = context;
        this.f1887a = i;
        this.f1889c = str;
        this.f1888b = new ProgressDialog(context);
        this.f1888b.setProgressStyle(1);
        this.f1888b.setMessage(context.getString(C0861R.string.msg_update_content_dialog_progress));
        this.f1888b.setCancelable(true);
        this.f1888b.setCanceledOnTouchOutside(false);
        this.f1888b.setProgress(0);
        this.f1888b.setMax(0);
        this.f1888b.setIndeterminate(false);
        this.f1888b.show();
        this.f1888b.setOnCancelListener(new C09361(this));
    }

    protected Boolean m3267a(Void... voidArr) {
        String file = new File(App.m2882g(), App.m2896u()).toString();
        try {
            URL url = new URL(this.f1889c + File.separator + App.m2896u());
            URLConnection openConnection = url.openConnection();
            openConnection.connect();
            int contentLength = openConnection.getContentLength();
            InputStream bufferedInputStream = new BufferedInputStream(url.openStream(), FragmentTransaction.TRANSIT_EXIT_MASK);
            OutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            long j = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                publishProgress(new Integer[]{Integer.valueOf((int) ((100 * j) / ((long) contentLength)))});
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream.close();
            if (!isCancelled()) {
                this.f1888b.setIndeterminate(true);
                new C0952k(file, App.m2882g().toString() + File.separator).m3323a();
            }
            File file2 = new File(file);
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(C0724b.m2559c(file));
            if (file3.exists() && file3.isDirectory()) {
                C0723a.m2549a(file3);
            }
            return Boolean.valueOf(true);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    protected void m3268a(Boolean bool) {
        if (this.f1888b != null && this.f1888b.isShowing()) {
            this.f1888b.dismiss();
        }
        if (bool.booleanValue()) {
            Editor edit = this.f1890d.getSharedPreferences(C0882e.f1683b, 0).edit();
            edit.putInt(C0882e.f1688g, this.f1887a);
            edit.apply();
            App.m2871b(this.f1890d.getString(C0861R.string.msg_update_content_success));
            return;
        }
        App.m2871b(this.f1890d.getString(C0861R.string.msg_update_content_failed));
    }

    protected void m3269a(Integer... numArr) {
        this.f1888b.setProgress(numArr[0].intValue());
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3267a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3268a((Boolean) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        m3269a((Integer[]) objArr);
    }
}
