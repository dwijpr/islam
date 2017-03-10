package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C1261h;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1308t.C1309a;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collection;

public class zzj extends zza {
    public static final Creator<zzj> CREATOR;
    final int f3162a;
    final int f3163b;
    int f3164c;
    String f3165d;
    IBinder f3166e;
    Scope[] f3167f;
    Bundle f3168g;
    Account f3169h;
    long f3170i;

    static {
        CREATOR = new C1343n();
    }

    public zzj(int i) {
        this.f3162a = 3;
        this.f3164c = C1261h.f2969b;
        this.f3163b = i;
    }

    zzj(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.f3162a = i;
        this.f3163b = i2;
        this.f3164c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f3165d = "com.google.android.gms";
        } else {
            this.f3165d = str;
        }
        if (i < 2) {
            this.f3169h = m4875a(iBinder);
        } else {
            this.f3166e = iBinder;
            this.f3169h = account;
        }
        this.f3167f = scopeArr;
        this.f3168g = bundle;
        this.f3170i = j;
    }

    private Account m4875a(IBinder iBinder) {
        return iBinder != null ? C1310a.m4616a(C1309a.m4615a(iBinder)) : null;
    }

    public zzj m4876a(Account account) {
        this.f3169h = account;
        return this;
    }

    public zzj m4877a(Bundle bundle) {
        this.f3168g = bundle;
        return this;
    }

    public zzj m4878a(C1308t c1308t) {
        if (c1308t != null) {
            this.f3166e = c1308t.asBinder();
        }
        return this;
    }

    public zzj m4879a(String str) {
        this.f3165d = str;
        return this;
    }

    public zzj m4880a(Collection<Scope> collection) {
        this.f3167f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1343n.m4754a(this, parcel, i);
    }
}
