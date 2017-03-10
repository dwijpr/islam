package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.C1314c;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class uo extends ud {
    private volatile String f6124a;
    private Future<String> f6125b;

    /* renamed from: com.google.android.gms.internal.uo.1 */
    class C20331 implements Callable<String> {
        final /* synthetic */ uo f6122a;

        C20331(uo uoVar) {
            this.f6122a = uoVar;
        }

        public String m9309a() {
            return this.f6122a.m9318d();
        }

        public /* synthetic */ Object call() {
            return m9309a();
        }
    }

    /* renamed from: com.google.android.gms.internal.uo.2 */
    class C20342 implements Callable<String> {
        final /* synthetic */ uo f6123a;

        C20342(uo uoVar) {
            this.f6123a = uoVar;
        }

        public String m9310a() {
            return this.f6123a.m9313f();
        }

        public /* synthetic */ Object call() {
            return m9310a();
        }
    }

    protected uo(uf ufVar) {
        super(ufVar);
    }

    private boolean m9312a(Context context, String str) {
        C1314c.m4625a(str);
        C1314c.m4635c("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            m4247a("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    m4261e("Failed to close clientId writing stream", e);
                }
            }
            return true;
        } catch (FileNotFoundException e2) {
            m4261e("Error creating clientId file", e2);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e3) {
                m4261e("Failed to close clientId writing stream", e3);
                return false;
            }
        } catch (IOException e32) {
            m4261e("Error writing to clientId file", e32);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e322) {
                m4261e("Failed to close clientId writing stream", e322);
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3222) {
                    m4261e("Failed to close clientId writing stream", e3222);
                }
            }
        }
    }

    private String m9313f() {
        String e = m9319e();
        try {
            return !m9312a(m4269o().m4374c(), e) ? "0" : e;
        } catch (Exception e2) {
            m4261e("Error saving clientId file", e2);
            return "0";
        }
    }

    protected String m9314a(Context context) {
        FileInputStream fileInputStream;
        Object e;
        Throwable th;
        C1314c.m4635c("ClientId should be loaded from worker thread");
        FileInputStream openFileInput;
        try {
            openFileInput = context.openFileInput("gaClientId");
            try {
                byte[] bArr = new byte[36];
                int read = openFileInput.read(bArr, 0, 36);
                if (openFileInput.available() > 0) {
                    m4260e("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2) {
                        m4261e("Failed to close client id reading stream", e2);
                        return null;
                    }
                } else if (read < 14) {
                    m4260e("clientId file is empty, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e22) {
                        m4261e("Failed to close client id reading stream", e22);
                        return null;
                    }
                } else {
                    openFileInput.close();
                    String str = new String(bArr, 0, read);
                    m4247a("Read client id from disk", str);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e3) {
                            m4261e("Failed to close client id reading stream", e3);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = openFileInput;
                if (fileInputStream != null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e222) {
                    m4261e("Failed to close client id reading stream", e222);
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                try {
                    m4261e("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2222) {
                        m4261e("Failed to close client id reading stream", e2222);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e22222) {
                            m4261e("Failed to close client id reading stream", e22222);
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (IOException e7) {
            e = e7;
            openFileInput = null;
            m4261e("Error reading client id file, deleting it", e);
            context.deleteFile("gaClientId");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    protected void m9315a() {
    }

    public String m9316b() {
        String str;
        m4280A();
        synchronized (this) {
            if (this.f6124a == null) {
                this.f6125b = m4269o().m4369a(new C20331(this));
            }
            if (this.f6125b != null) {
                try {
                    this.f6124a = (String) this.f6125b.get();
                } catch (InterruptedException e) {
                    m4258d("ClientId loading or generation was interrupted", e);
                    this.f6124a = "0";
                } catch (ExecutionException e2) {
                    m4261e("Failed to load or generate client id", e2);
                    this.f6124a = "0";
                }
                if (this.f6124a == null) {
                    this.f6124a = "0";
                }
                m4247a("Loaded clientId", this.f6124a);
                this.f6125b = null;
            }
            str = this.f6124a;
        }
        return str;
    }

    String m9317c() {
        synchronized (this) {
            this.f6124a = null;
            this.f6125b = m4269o().m4369a(new C20342(this));
        }
        return m9316b();
    }

    String m9318d() {
        String a = m9314a(m4269o().m4374c());
        return a == null ? m9313f() : a;
    }

    protected String m9319e() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
