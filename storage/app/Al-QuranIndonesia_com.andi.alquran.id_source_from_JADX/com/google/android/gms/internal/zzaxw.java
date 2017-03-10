package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaxw extends zza {
    public static final Creator<zzaxw> CREATOR;
    final int f6414a;
    private final Account f6415b;
    private final Scope[] f6416c;
    private final String f6417d;

    static {
        CREATOR = new cs();
    }

    zzaxw(int i, Account account, Scope[] scopeArr, String str) {
        this.f6414a = i;
        this.f6415b = account;
        this.f6416c = scopeArr;
        this.f6417d = str;
    }

    public Account m9755a() {
        return this.f6415b;
    }

    public Scope[] m9756b() {
        return this.f6416c;
    }

    public String m9757c() {
        return this.f6417d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cs.m5598a(this, parcel, i);
    }
}
