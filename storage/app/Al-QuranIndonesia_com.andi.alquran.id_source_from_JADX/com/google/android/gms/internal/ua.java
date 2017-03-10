package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public class ua extends ud {
    public static boolean f6025a;
    private Info f6026b;
    private final vn f6027c;
    private String f6028d;
    private boolean f6029e;
    private Object f6030f;

    ua(uf ufVar) {
        super(ufVar);
        this.f6029e = false;
        this.f6030f = new Object();
        this.f6027c = new vn(ufVar.m9156d());
    }

    private static String m9127a(String str) {
        if (vp.m9518b("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, vp.m9518b("MD5").digest(str.getBytes()))});
    }

    private boolean m9128a(Info info, Info info2) {
        Object obj = null;
        CharSequence id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String b = m4275u().m9316b();
        synchronized (this.f6030f) {
            String valueOf;
            String valueOf2;
            if (!this.f6029e) {
                this.f6028d = m9135e();
                this.f6029e = true;
            } else if (TextUtils.isEmpty(this.f6028d)) {
                if (info != null) {
                    obj = info.getId();
                }
                if (obj == null) {
                    valueOf = String.valueOf(id);
                    String valueOf3 = String.valueOf(b);
                    boolean g = m9130g(valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf));
                    return g;
                }
                valueOf2 = String.valueOf(obj);
                valueOf = String.valueOf(b);
                this.f6028d = m9127a(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            }
            valueOf2 = String.valueOf(id);
            valueOf = String.valueOf(b);
            obj = m9127a(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            if (TextUtils.isEmpty(obj)) {
                return false;
            } else if (obj.equals(this.f6028d)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.f6028d)) {
                    valueOf = b;
                } else {
                    m4250b("Resetting the client id because Advertising Id changed.");
                    obj = m4275u().m9317c();
                    m4247a("New client Id", obj);
                }
                String valueOf4 = String.valueOf(id);
                valueOf3 = String.valueOf(obj);
                g = m9130g(valueOf3.length() != 0 ? valueOf4.concat(valueOf3) : new String(valueOf4));
                return g;
            }
        }
    }

    private synchronized Info m9129f() {
        if (this.f6027c.m9502a(1000)) {
            this.f6027c.m9501a();
            Info d = m9134d();
            if (m9128a(this.f6026b, d)) {
                this.f6026b = d;
            } else {
                m4262f("Failed to reset client id on adid change. Not using adid");
                this.f6026b = new Info(BuildConfig.VERSION_NAME, false);
            }
        }
        return this.f6026b;
    }

    private boolean m9130g(String str) {
        try {
            String a = m9127a(str);
            m4250b("Storing hashed adid.");
            FileOutputStream openFileOutput = m4266l().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(a.getBytes());
            openFileOutput.close();
            this.f6028d = a;
            return true;
        } catch (IOException e) {
            m4261e("Error creating hash file", e);
            return false;
        }
    }

    protected void m9131a() {
    }

    public boolean m9132b() {
        m4280A();
        Info f = m9129f();
        return (f == null || f.isLimitAdTrackingEnabled()) ? false : true;
    }

    public String m9133c() {
        m4280A();
        Info f = m9129f();
        CharSequence id = f != null ? f.getId() : null;
        return TextUtils.isEmpty(id) ? null : id;
    }

    protected Info m9134d() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(m4266l());
        } catch (IllegalStateException e) {
            m4260e("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (Throwable th) {
            if (!f6025a) {
                f6025a = true;
                m4258d("Error getting advertiser id", th);
            }
        }
        return info;
    }

    protected String m9135e() {
        Object obj;
        String str = null;
        try {
            FileInputStream openFileInput = m4266l().openFileInput("gaClientIdData");
            byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
            int read = openFileInput.read(bArr, 0, NotificationCompat.FLAG_HIGH_PRIORITY);
            if (openFileInput.available() > 0) {
                m4260e("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                m4266l().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                m4250b("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    str = str2;
                    IOException iOException2 = iOException;
                    m4258d("Error reading Hash file, deleting it", obj);
                    m4266l().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            obj = e4;
            m4258d("Error reading Hash file, deleting it", obj);
            m4266l().deleteFile("gaClientIdData");
            return str;
        }
    }
}
