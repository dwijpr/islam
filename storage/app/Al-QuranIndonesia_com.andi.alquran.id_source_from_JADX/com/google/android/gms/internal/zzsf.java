package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzsf implements Parcelable {
    @Deprecated
    public static final Creator<zzsf> CREATOR;
    private String f6640a;
    private String f6641b;
    private String f6642c;

    /* renamed from: com.google.android.gms.internal.zzsf.1 */
    class C20841 implements Creator<zzsf> {
        C20841() {
        }

        @Deprecated
        public zzsf m9784a(Parcel parcel) {
            return new zzsf(parcel);
        }

        @Deprecated
        public zzsf[] m9785a(int i) {
            return new zzsf[i];
        }

        @Deprecated
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m9784a(parcel);
        }

        @Deprecated
        public /* synthetic */ Object[] newArray(int i) {
            return m9785a(i);
        }
    }

    static {
        CREATOR = new C20841();
    }

    @Deprecated
    zzsf(Parcel parcel) {
        m9786a(parcel);
    }

    @Deprecated
    private void m9786a(Parcel parcel) {
        this.f6640a = parcel.readString();
        this.f6641b = parcel.readString();
        this.f6642c = parcel.readString();
    }

    public String m9787a() {
        return this.f6640a;
    }

    public String m9788b() {
        return this.f6642c;
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6640a);
        parcel.writeString(this.f6641b);
        parcel.writeString(this.f6642c);
    }
}
