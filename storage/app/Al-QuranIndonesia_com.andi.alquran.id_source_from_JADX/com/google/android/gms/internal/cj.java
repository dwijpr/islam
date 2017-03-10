package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class cj {
    private static Cipher f3676b;
    private static final Object f3677c;
    private static final Object f3678d;
    private final SecureRandom f3679a;

    /* renamed from: com.google.android.gms.internal.cj.a */
    public class C1507a extends Exception {
        final /* synthetic */ cj f3675a;

        public C1507a(cj cjVar) {
            this.f3675a = cjVar;
        }

        public C1507a(cj cjVar, Throwable th) {
            this.f3675a = cjVar;
            super(th);
        }
    }

    static {
        f3676b = null;
        f3677c = new Object();
        f3678d = new Object();
    }

    public cj(SecureRandom secureRandom) {
        this.f3679a = secureRandom;
    }

    private Cipher m5543a() {
        Cipher cipher;
        synchronized (f3678d) {
            if (f3676b == null) {
                f3676b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f3676b;
        }
        return cipher;
    }

    static void m5544a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public String m5545a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 16) {
            throw new C1507a(this);
        }
        try {
            byte[] doFinal;
            byte[] iv;
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f3677c) {
                m5543a().init(1, secretKeySpec, this.f3679a);
                doFinal = m5543a().doFinal(bArr2);
                iv = m5543a().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            doFinal = new byte[length];
            allocate.get(doFinal);
            return ay.m5225a(doFinal, false);
        } catch (Throwable e) {
            throw new C1507a(this, e);
        } catch (Throwable e2) {
            throw new C1507a(this, e2);
        } catch (Throwable e22) {
            throw new C1507a(this, e22);
        } catch (Throwable e222) {
            throw new C1507a(this, e222);
        } catch (Throwable e2222) {
            throw new C1507a(this, e2222);
        }
    }

    public byte[] m5546a(String str) {
        try {
            byte[] a = ay.m5226a(str, false);
            if (a.length != 32) {
                throw new C1507a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            m5544a(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C1507a(this, e);
        }
    }

    public byte[] m5547a(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new C1507a(this);
        }
        try {
            byte[] a = ay.m5226a(str, false);
            if (a.length <= 16) {
                throw new C1507a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f3677c) {
                m5543a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                a = m5543a().doFinal(a);
            }
            return a;
        } catch (Throwable e) {
            throw new C1507a(this, e);
        } catch (Throwable e2) {
            throw new C1507a(this, e2);
        } catch (Throwable e22) {
            throw new C1507a(this, e22);
        } catch (Throwable e222) {
            throw new C1507a(this, e222);
        } catch (Throwable e2222) {
            throw new C1507a(this, e2222);
        } catch (Throwable e22222) {
            throw new C1507a(this, e22222);
        } catch (Throwable e222222) {
            throw new C1507a(this, e222222);
        }
    }
}
