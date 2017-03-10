package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzad extends zza {
    public static final Creator<zzad> CREATOR;
    final int f3147a;
    private final Account f3148b;
    private final int f3149c;
    private final GoogleSignInAccount f3150d;

    static {
        CREATOR = new C1315d();
    }

    zzad(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f3147a = i;
        this.f3148b = account;
        this.f3149c = i2;
        this.f3150d = googleSignInAccount;
    }

    public zzad(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account m4868a() {
        return this.f3148b;
    }

    public int m4869b() {
        return this.f3149c;
    }

    public GoogleSignInAccount m4870c() {
        return this.f3150d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1315d.m4636a(this, parcel, i);
    }
}
