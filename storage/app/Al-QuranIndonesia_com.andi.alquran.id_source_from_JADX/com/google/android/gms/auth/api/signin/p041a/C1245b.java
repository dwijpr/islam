package com.google.android.gms.auth.api.signin.p041a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.C1314c;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* renamed from: com.google.android.gms.auth.api.signin.a.b */
public class C1245b {
    private static final Lock f2934a;
    private static C1245b f2935b;
    private final Lock f2936c;
    private final SharedPreferences f2937d;

    static {
        f2934a = new ReentrantLock();
    }

    C1245b(Context context) {
        this.f2936c = new ReentrantLock();
        this.f2937d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static C1245b m4406a(Context context) {
        C1314c.m4623a((Object) context);
        f2934a.lock();
        try {
            if (f2935b == null) {
                f2935b = new C1245b(context.getApplicationContext());
            }
            C1245b c1245b = f2935b;
            return c1245b;
        } finally {
            f2934a.unlock();
        }
    }

    private String m4407a(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public GoogleSignInAccount m4408a() {
        return m4409a(m4412c("defaultGoogleSignInAccount"));
    }

    GoogleSignInAccount m4409a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m4412c(m4407a("googleSignInAccount", str));
            if (c != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.m4376a(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    public GoogleSignInOptions m4410b() {
        return m4411b(m4412c("defaultGoogleSignInAccount"));
    }

    GoogleSignInOptions m4411b(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String c = m4412c(m4407a("googleSignInOptions", str));
            if (c != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.m4395a(c);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    protected String m4412c(String str) {
        this.f2936c.lock();
        try {
            String string = this.f2937d.getString(str, null);
            return string;
        } finally {
            this.f2936c.unlock();
        }
    }
}
