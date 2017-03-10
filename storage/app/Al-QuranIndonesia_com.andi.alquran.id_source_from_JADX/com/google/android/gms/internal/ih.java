package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@op
public class ih {
    BlockingQueue<io> f4395a;
    ExecutorService f4396b;
    LinkedHashMap<String, String> f4397c;
    Map<String, il> f4398d;
    String f4399e;
    final Context f4400f;
    final String f4401g;
    private AtomicBoolean f4402h;
    private File f4403i;

    /* renamed from: com.google.android.gms.internal.ih.1 */
    class C16491 implements Runnable {
        final /* synthetic */ ih f4394a;

        C16491(ih ihVar) {
            this.f4394a = ihVar;
        }

        public void run() {
            this.f4394a.m6711a();
        }
    }

    public ih(Context context, String str, String str2, Map<String, String> map) {
        this.f4397c = new LinkedHashMap();
        this.f4398d = new HashMap();
        this.f4400f = context;
        this.f4401g = str;
        this.f4399e = str2;
        this.f4402h = new AtomicBoolean(false);
        this.f4402h.set(((Boolean) C1648if.f4359W.m6682c()).booleanValue());
        if (this.f4402h.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.f4403i = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.f4397c.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.f4395a = new ArrayBlockingQueue(30);
        this.f4396b = Executors.newSingleThreadExecutor();
        this.f4396b.execute(new C16491(this));
        this.f4398d.put("action", il.f4410b);
        this.f4398d.put("ad_format", il.f4410b);
        this.f4398d.put("e", il.f4411c);
    }

    private void m6711a() {
        while (true) {
            try {
                io ioVar = (io) this.f4395a.take();
                String c = ioVar.m6748c();
                if (!TextUtils.isEmpty(c)) {
                    m6714a(m6717a(this.f4397c, ioVar.m6749d()), c);
                }
            } catch (Throwable e) {
                sg.m8447c("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    private void m6713a(File file, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (file != null) {
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (Throwable e2) {
                        sg.m8447c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                        return;
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        sg.m8447c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable e22) {
                                sg.m8447c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e22);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                sg.m8447c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                sg.m8447c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e22);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        }
        sg.m8449e("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
    }

    private void m6714a(Map<String, String> map, String str) {
        String a = m6716a(this.f4399e, map, str);
        if (this.f4402h.get()) {
            m6713a(this.f4403i, a);
        } else {
            zzv.zzcJ().m8512a(this.f4400f, this.f4401g, a);
        }
    }

    public il m6715a(String str) {
        il ilVar = (il) this.f4398d.get(str);
        return ilVar != null ? ilVar : il.f4409a;
    }

    String m6716a(String str, Map<String, String> map, String str2) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder(buildUpon.build().toString());
        stringBuilder.append("&").append("it").append("=").append(str2);
        return stringBuilder.toString();
    }

    Map<String, String> m6717a(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, m6715a(str).m6728a(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public void m6718a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f4397c.put("e", TextUtils.join(",", list));
        }
    }

    public boolean m6719a(io ioVar) {
        return this.f4395a.offer(ioVar);
    }
}
