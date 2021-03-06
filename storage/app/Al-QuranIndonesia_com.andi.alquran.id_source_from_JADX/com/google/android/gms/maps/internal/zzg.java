package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;

public interface zzg extends IInterface {

    public static abstract class zza extends Binder implements zzg {

        /* renamed from: com.google.android.gms.maps.internal.zzg.zza.a */
        private static class C2162a implements zzg {
            private IBinder f6882a;

            C2162a(IBinder iBinder) {
                this.f6882a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6882a;
            }

            public void onCameraMoveCanceled() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnCameraMoveCanceledListener");
                    this.f6882a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnCameraMoveCanceledListener");
        }

        public static zzg zzdB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnCameraMoveCanceledListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new C2162a(iBinder) : (zzg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnCameraMoveCanceledListener");
                    onCameraMoveCanceled();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnCameraMoveCanceledListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onCameraMoveCanceled();
}
