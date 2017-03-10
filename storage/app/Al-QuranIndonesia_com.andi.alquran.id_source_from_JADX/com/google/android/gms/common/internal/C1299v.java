package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p039a.C1108c;

/* renamed from: com.google.android.gms.common.internal.v */
public interface C1299v extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.v.a */
    public static abstract class C1300a extends Binder implements C1299v {
        public C1300a() {
            attachInterface(this, "com.google.android.gms.common.internal.ICertData");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                    C1108c a = m4602a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                    int b = m4603b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.ICertData");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C1108c m4602a();

    int m4603b();
}
