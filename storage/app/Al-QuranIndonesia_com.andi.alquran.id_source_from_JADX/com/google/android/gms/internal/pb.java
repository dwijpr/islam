package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;

public interface pb extends IInterface {

    /* renamed from: com.google.android.gms.internal.pb.a */
    public static abstract class C1888a extends Binder implements pb {

        /* renamed from: com.google.android.gms.internal.pb.a.a */
        private static class C1898a implements pb {
            private IBinder f5340a;

            C1898a(IBinder iBinder) {
                this.f5340a = iBinder;
            }

            public void m8069a(zzmk com_google_android_gms_internal_zzmk) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (com_google_android_gms_internal_zzmk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzmk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f5340a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f5340a;
            }
        }

        public C1888a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdResponseListener");
        }

        public static pb m7985a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof pb)) ? new C1898a(iBinder) : (pb) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    m7984a(parcel.readInt() != 0 ? (zzmk) zzmk.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m7984a(zzmk com_google_android_gms_internal_zzmk);
}
