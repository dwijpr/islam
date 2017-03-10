package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;

public interface br extends IInterface {

    /* renamed from: com.google.android.gms.internal.br.a */
    public static abstract class C1479a extends Binder implements br {

        /* renamed from: com.google.android.gms.internal.br.a.a */
        private static class C1483a implements br {
            private IBinder f3624a;

            C1483a(IBinder iBinder) {
                this.f3624a = iBinder;
            }

            public void m5339a(zzarm com_google_android_gms_internal_zzarm) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                    if (com_google_android_gms_internal_zzarm != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzarm.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3624a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3624a;
            }
        }

        public C1479a() {
            attachInterface(this, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        }

        public static br m5330a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof br)) ? new C1483a(iBinder) : (br) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                    m5329a(parcel.readInt() != 0 ? (zzarm) zzarm.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m5329a(zzarm com_google_android_gms_internal_zzarm);
}
