package com.andi.alquran.p031i;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import p017b.p018a.p019a.p020a.C0723a;

/* renamed from: com.andi.alquran.i.g */
public class C0930g extends AsyncTask<Void, String, Boolean> {
    private String f1868a;
    private ProgressDialog f1869b;
    private Context f1870c;
    private String f1871d;
    private long f1872e;

    public C0930g(Context context, String str) {
        this.f1871d = BuildConfig.VERSION_NAME;
        this.f1872e = 0;
        this.f1868a = str;
        this.f1870c = context;
    }

    private int m3227a(File file) {
        int i = 0;
        if (!file.isDirectory()) {
            return 1;
        }
        if (file == null) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            i = file2.isDirectory() ? i + m3227a(file2) : i + 1;
        }
        return i;
    }

    private void m3228a() {
        if (System.currentTimeMillis() - this.f1872e > 2000) {
            this.f1872e = System.currentTimeMillis();
            this.f1869b.setProgress(m3227a(new File(this.f1868a + File.separator + "QuranMurottal")));
        }
    }

    private void m3229a(File file, File file2) {
        if (file == null) {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_src_not_be_null);
            throw new IOException(this.f1871d);
        } else if (file.exists() && !file.isDirectory()) {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_src_path_not_dir, new Object[]{file2});
            throw new IOException(this.f1871d);
        } else if (file2 == null) {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_dst_not_be_null);
            throw new IOException(this.f1871d);
        } else if (!file2.exists() || file2.isDirectory()) {
            m3231b(file, new File(file2, file.getName()));
        } else {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_dst_path_not_dir, new Object[]{file2});
            throw new IOException(this.f1871d);
        }
    }

    private void m3230a(File file, File file2, List<String> list) {
        int i = 0;
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_src_fail_to_list, new Object[]{file});
                throw new IOException(this.f1871d);
            }
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_dst_path_exist_but_not_dir, new Object[]{file2});
                    throw new IOException(this.f1871d);
                }
            } else if (!(file2.mkdirs() || file2.isDirectory())) {
                this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_dst_cannot_mkdir, new Object[]{file2});
                throw new IOException(this.f1871d);
            }
            if (file2.canWrite()) {
                int length = listFiles.length;
                while (i < length) {
                    File file3 = listFiles[i];
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            m3230a(file3, file4, list);
                        } else {
                            m3232c(file3, file4);
                        }
                    }
                    i++;
                }
                return;
            }
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_dst_cannot_created, new Object[]{file2});
            throw new IOException(this.f1871d);
        }
        this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_src_fail_to_list, new Object[]{file});
        throw new IOException(this.f1871d);
    }

    private void m3231b(File file, File file2) {
        int i = 0;
        if (file == null) {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_src_not_be_null);
            throw new IOException(this.f1871d);
        } else if (file2 == null) {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_dst_not_be_null);
            throw new IOException(this.f1871d);
        } else if (!file.exists()) {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_src_path_not_exist, new Object[]{file});
            throw new IOException(this.f1871d);
        } else if (file.isDirectory()) {
            List list = null;
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath()) && file != null) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    list = new ArrayList(listFiles.length);
                    int length = listFiles.length;
                    while (i < length) {
                        list.add(new File(file2, listFiles[i].getName()).getCanonicalPath());
                        i++;
                    }
                }
            }
            m3230a(file, file2, list);
        } else {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_src_path_exist_but_not_dir, new Object[]{file});
            throw new IOException(this.f1871d);
        }
    }

    private void m3232c(File file, File file2) {
        if (file2.exists() && file2.isDirectory()) {
            this.f1871d = this.f1870c.getString(C0861R.string.msg_mv_dst_path_exist_but_is_dir, new Object[]{file2});
            throw new IOException(this.f1871d);
        }
        FileChannel channel = new FileInputStream(file).getChannel();
        Object channel2 = new FileOutputStream(file2).getChannel();
        try {
            channel.transferTo(0, channel.size(), channel2);
            file.delete();
            m3228a();
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        }
    }

    protected Boolean m3233a(Void... voidArr) {
        File file = new File(this.f1868a);
        File file2 = new File(App.m2884i());
        this.f1869b.setMax(m3227a(file2));
        try {
            m3229a(file2, file);
            C0723a.m2549a(file2);
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }

    protected void m3234a(Boolean bool) {
        if (!((Activity) this.f1870c).isFinishing()) {
            if (this.f1869b != null && this.f1869b.isShowing()) {
                this.f1869b.dismiss();
            }
            if (bool.booleanValue()) {
                App.m2871b(this.f1870c.getString(C0861R.string.msg_success_change_path));
                Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f1870c).edit();
                edit.putString("mp3Directory", this.f1868a + File.separator + "QuranMurottal");
                edit.apply();
                return;
            }
            App.m2865a(this.f1871d);
            App.m2871b(this.f1870c.getString(C0861R.string.msg_notsuccess_change_path));
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3233a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3234a((Boolean) obj);
    }

    protected void onPreExecute() {
        this.f1869b = new ProgressDialog(this.f1870c);
        this.f1869b.setTitle(this.f1870c.getString(C0861R.string.msg_loading_move_file_title));
        this.f1869b.setMessage(this.f1870c.getString(C0861R.string.msg_loading_move_file_desc));
        this.f1869b.setIcon(C0861R.drawable.ic_black_move_audio);
        this.f1869b.setProgressStyle(1);
        this.f1869b.setProgress(0);
        this.f1869b.setMax(0);
        this.f1869b.setIndeterminate(false);
        this.f1869b.setCancelable(false);
        if (VERSION.SDK_INT >= 14) {
            this.f1869b.setProgressNumberFormat(null);
        }
        this.f1869b.show();
    }
}
