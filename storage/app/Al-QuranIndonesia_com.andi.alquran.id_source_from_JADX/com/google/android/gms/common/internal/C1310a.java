package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C1295j;
import com.google.android.gms.common.internal.C1308t.C1309a;

/* renamed from: com.google.android.gms.common.internal.a */
public class C1310a extends C1309a {
    int f3042a;

    public static Account m4616a(C1308t c1308t) {
        Account account = null;
        if (c1308t != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = c1308t.m4614a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account m4617a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f3042a) {
            if (C1295j.m4581a(null, callingUid)) {
                this.f3042a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        return this == obj ? true : !(obj instanceof C1310a) ? false : account.equals(account);
    }
}
