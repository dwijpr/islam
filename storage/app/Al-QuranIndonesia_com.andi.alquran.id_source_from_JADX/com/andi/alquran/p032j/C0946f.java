package com.andi.alquran.p032j;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.zip.GZIPInputStream;

/* renamed from: com.andi.alquran.j.f */
public class C0946f {

    /* renamed from: com.andi.alquran.j.f.1 */
    static class C09441 extends AsyncTask<String, String, Boolean> {
        final /* synthetic */ Context f1894a;
        final /* synthetic */ Runnable f1895b;
        private ProgressDialog f1896c;

        C09441(Context context, Runnable runnable) {
            this.f1894a = context;
            this.f1895b = runnable;
        }

        protected Boolean m3280a(String... strArr) {
            String[] strArr2 = new String[0];
            try {
                strArr2 = this.f1894a.getAssets().list(BuildConfig.VERSION_NAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
            File g = App.m2882g();
            if (g == null) {
                return Boolean.valueOf(false);
            }
            for (String str : r0) {
                if (str.endsWith(".jpg")) {
                    publishProgress(new String[]{new File(g, str.substring(0, str.lastIndexOf(46))).getName()});
                    if (!C0946f.m3284b(this.f1894a, new String[]{str}, new File(g, str.substring(0, str.lastIndexOf(46))))) {
                        return Boolean.valueOf(false);
                    }
                }
            }
            return Boolean.valueOf(true);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void m3281a(java.lang.Boolean r3) {
            /*
            r2 = this;
            r1 = 0;
            r0 = r2.f1894a;
            r0 = (com.andi.alquran.ActivityBase) r0;
            r0 = r0.isFinishing();
            if (r0 != 0) goto L_0x001e;
        L_0x000b:
            r0 = r2.f1896c;	 Catch:{ IllegalArgumentException -> 0x0028, Exception -> 0x002c, all -> 0x0030 }
            if (r0 == 0) goto L_0x001c;
        L_0x000f:
            r0 = r2.f1896c;	 Catch:{ IllegalArgumentException -> 0x0028, Exception -> 0x002c, all -> 0x0030 }
            r0 = r0.isShowing();	 Catch:{ IllegalArgumentException -> 0x0028, Exception -> 0x002c, all -> 0x0030 }
            if (r0 == 0) goto L_0x001c;
        L_0x0017:
            r0 = r2.f1896c;	 Catch:{ IllegalArgumentException -> 0x0028, Exception -> 0x002c, all -> 0x0030 }
            r0.dismiss();	 Catch:{ IllegalArgumentException -> 0x0028, Exception -> 0x002c, all -> 0x0030 }
        L_0x001c:
            r2.f1896c = r1;
        L_0x001e:
            r0 = r2.f1895b;
            if (r0 == 0) goto L_0x0027;
        L_0x0022:
            r0 = r2.f1895b;
            r0.run();
        L_0x0027:
            return;
        L_0x0028:
            r0 = move-exception;
            r2.f1896c = r1;
            goto L_0x001e;
        L_0x002c:
            r0 = move-exception;
            r2.f1896c = r1;
            goto L_0x001e;
        L_0x0030:
            r0 = move-exception;
            r2.f1896c = r1;
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.andi.alquran.j.f.1.a(java.lang.Boolean):void");
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3280a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m3281a((Boolean) obj);
        }

        protected void onPreExecute() {
            super.onPreExecute();
            CharSequence string = App.f1448m.getString(C0861R.string.msg_extract_data);
            this.f1896c = new ProgressDialog(this.f1894a);
            this.f1896c.setCancelable(false);
            this.f1896c.setMessage(string);
            this.f1896c.setProgressStyle(0);
            this.f1896c.show();
        }
    }

    /* renamed from: com.andi.alquran.j.f.a */
    private static class C0945a extends GZIPInputStream {
        public C0945a(InputStream inputStream) {
            super(inputStream);
        }
    }

    public static void m3282a(Context context, Runnable runnable) {
        new C09441(context, runnable).execute(new String[0]);
    }

    private static boolean m3284b(Context context, String[] strArr, File file) {
        IOException e;
        C0945a c0945a;
        OutputStream outputStream = null;
        try {
            OutputStream fileOutputStream;
            Collection arrayList = new ArrayList();
            for (String open : strArr) {
                arrayList.add(context.getAssets().open(open));
            }
            C0945a c0945a2 = new C0945a(new SequenceInputStream(Collections.enumeration(arrayList)));
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e2) {
                e = e2;
                c0945a = c0945a2;
                e.printStackTrace();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                        file.delete();
                        return false;
                    }
                }
                if (c0945a != null) {
                    c0945a.close();
                }
                file.delete();
                return false;
            }
            try {
                byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
                while (true) {
                    int read = c0945a2.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        c0945a2.close();
                        return true;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                outputStream = fileOutputStream;
                c0945a = c0945a2;
                e.printStackTrace();
                if (outputStream != null) {
                    outputStream.close();
                }
                if (c0945a != null) {
                    c0945a.close();
                }
                file.delete();
                return false;
            }
        } catch (IOException e5) {
            e = e5;
            c0945a = null;
            e.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            if (c0945a != null) {
                c0945a.close();
            }
            file.delete();
            return false;
        }
    }
}
