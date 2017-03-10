package com.andi.alquran.p031i;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.ActivityBase;
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

/* renamed from: com.andi.alquran.i.h */
public class C0931h extends AsyncTask<Void, String, Boolean> {
    private String f1873a;
    private ProgressDialog f1874b;
    private Context f1875c;
    private String f1876d;
    private long f1877e;

    public C0931h(Context context, String str) {
        this.f1876d = BuildConfig.VERSION_NAME;
        this.f1877e = 0;
        this.f1873a = str;
        this.f1875c = context;
    }

    private int m3235a(File file) {
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
            i = file2.isDirectory() ? i + m3235a(file2) : i + 1;
        }
        return i;
    }

    private void m3236a() {
        if (System.currentTimeMillis() - this.f1877e > 2000) {
            this.f1877e = System.currentTimeMillis();
            this.f1874b.setProgress(m3235a(new File(this.f1873a)));
        }
    }

    private void m3237a(File file, File file2) {
        if (file == null) {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_src_not_be_null);
            throw new IOException(this.f1876d);
        } else if (file.exists() && !file.isDirectory()) {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_src_path_not_dir, new Object[]{file2});
            throw new IOException(this.f1876d);
        } else if (file2 == null) {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_dst_not_be_null);
            throw new IOException(this.f1876d);
        } else if (!file2.exists() || file2.isDirectory()) {
            m3239b(file, new File(file2, file.getName()));
        } else {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_dst_path_not_dir, new Object[]{file2});
            throw new IOException(this.f1876d);
        }
    }

    private void m3238a(File file, File file2, List<String> list) {
        int i = 0;
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_src_fail_to_list, new Object[]{file});
                throw new IOException(this.f1876d);
            }
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_dst_path_exist_but_not_dir, new Object[]{file2});
                    throw new IOException(this.f1876d);
                }
            } else if (!(file2.mkdirs() || file2.isDirectory())) {
                this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_dst_cannot_mkdir, new Object[]{file2});
                throw new IOException(this.f1876d);
            }
            if (file2.canWrite()) {
                int length = listFiles.length;
                while (i < length) {
                    File file3 = listFiles[i];
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            m3238a(file3, file4, list);
                        } else {
                            m3240c(file3, file4);
                        }
                    }
                    i++;
                }
                return;
            }
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_dst_cannot_created, new Object[]{file2});
            throw new IOException(this.f1876d);
        }
        this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_src_fail_to_list, new Object[]{file});
        throw new IOException(this.f1876d);
    }

    private void m3239b(File file, File file2) {
        int i = 0;
        if (file == null) {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_src_not_be_null);
            throw new IOException(this.f1876d);
        } else if (file2 == null) {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_dst_not_be_null);
            throw new IOException(this.f1876d);
        } else if (!file.exists()) {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_src_path_not_exist, new Object[]{file});
            throw new IOException(this.f1876d);
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
            m3238a(file, file2, list);
        } else {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_src_path_exist_but_not_dir, new Object[]{file});
            throw new IOException(this.f1876d);
        }
    }

    private void m3240c(File file, File file2) {
        if (file2.exists() && file2.isDirectory()) {
            this.f1876d = this.f1875c.getString(C0861R.string.msg_mv_dst_path_exist_but_is_dir, new Object[]{file2});
            throw new IOException(this.f1876d);
        }
        FileChannel channel = new FileInputStream(file).getChannel();
        Object channel2 = new FileOutputStream(file2).getChannel();
        try {
            channel.transferTo(0, channel.size(), channel2);
            file.delete();
            m3236a();
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        }
    }

    protected Boolean m3241a(Void... voidArr) {
        File file = new File(App.m2884i() + File.separator + "mp3");
        File file2 = new File(App.m2884i() + File.separator + "mp3_2");
        File file3 = new File(App.m2884i() + File.separator + "mp3_3");
        File file4 = new File(App.m2884i() + File.separator + "mp3_mahmud");
        File file5 = new File(App.m2884i() + File.separator + "mp3_maher");
        File file6 = new File(App.m2884i() + File.separator + "mp3_ghamdi");
        File file7 = new File(App.m2884i() + File.separator + "mp3_jebril");
        int a = file.exists() ? m3235a(file) + 0 : 0;
        if (file2.exists()) {
            a += m3235a(file2);
        }
        if (file3.exists()) {
            a += m3235a(file3);
        }
        if (file4.exists()) {
            a += m3235a(file4);
        }
        if (file5.exists()) {
            a += m3235a(file5);
        }
        if (file6.exists()) {
            a += m3235a(file6);
        }
        if (file7.exists()) {
            a += m3235a(file7);
        }
        this.f1874b.setMax(a);
        try {
            File file8 = new File(this.f1873a);
            if (file.exists()) {
                m3237a(file, file8);
                C0723a.m2549a(file);
            }
            if (file2.exists()) {
                m3237a(file2, file8);
                C0723a.m2549a(file2);
            }
            if (file3.exists()) {
                m3237a(file3, file8);
                C0723a.m2549a(file3);
            }
            if (file4.exists()) {
                m3237a(file4, file8);
                C0723a.m2549a(file4);
            }
            if (file5.exists()) {
                m3237a(file5, file8);
                C0723a.m2549a(file5);
            }
            if (file6.exists()) {
                m3237a(file6, file8);
                C0723a.m2549a(file6);
            }
            if (file7.exists()) {
                m3237a(file7, file8);
                C0723a.m2549a(file7);
            }
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }

    protected void m3242a(Boolean bool) {
        if (!((ActivityBase) this.f1875c).isFinishing()) {
            if (this.f1874b != null && this.f1874b.isShowing()) {
                this.f1874b.dismiss();
            }
            if (bool.booleanValue()) {
                App.m2871b(this.f1875c.getString(C0861R.string.sdcard_migration_succesfully));
                Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f1875c).edit();
                edit.putString("mp3Directory", this.f1873a);
                edit.putBoolean("haveMigrationAudioFix", true);
                edit.apply();
                return;
            }
            App.m2871b(this.f1876d);
            App.m2871b(this.f1875c.getString(C0861R.string.msg_notsuccess_change_path));
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3241a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3242a((Boolean) obj);
    }

    protected void onPreExecute() {
        this.f1874b = new ProgressDialog(this.f1875c);
        this.f1874b.setTitle(this.f1875c.getString(C0861R.string.msg_loading_move_file_title));
        this.f1874b.setMessage(this.f1875c.getString(C0861R.string.msg_loading_move_file_migration_desc));
        this.f1874b.setIcon(C0861R.drawable.ic_black_move_audio);
        this.f1874b.setProgressStyle(1);
        this.f1874b.setProgress(0);
        this.f1874b.setMax(0);
        this.f1874b.setIndeterminate(false);
        this.f1874b.setCancelable(false);
        if (VERSION.SDK_INT >= 14) {
            this.f1874b.setProgressNumberFormat(null);
        }
        this.f1874b.show();
    }
}
