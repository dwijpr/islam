package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@op
public abstract class fq {
    private static MessageDigest f4102b;
    protected Object f4103a;

    static {
        f4102b = null;
    }

    public fq() {
        this.f4103a = new Object();
    }

    protected MessageDigest m6223a() {
        MessageDigest messageDigest;
        synchronized (this.f4103a) {
            if (f4102b != null) {
                messageDigest = f4102b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        f4102b = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = f4102b;
            }
        }
        return messageDigest;
    }

    abstract byte[] m6224a(String str);
}
