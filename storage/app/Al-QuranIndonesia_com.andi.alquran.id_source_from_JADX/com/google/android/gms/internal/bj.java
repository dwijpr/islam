package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;

public interface bj extends IInterface {

    /* renamed from: com.google.android.gms.internal.bj.a */
    public static abstract class C1472a extends Binder implements bj {

        /* renamed from: com.google.android.gms.internal.bj.a.a */
        private static class C1471a implements bj {
            private IBinder f3603a;

            C1471a(IBinder iBinder) {
                this.f3603a = iBinder;
            }

            public zzapx m5287a(zzapv com_google_android_gms_internal_zzapv) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.gass.internal.IGassService");
                    if (com_google_android_gms_internal_zzapv != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzapv.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3603a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzapx com_google_android_gms_internal_zzapx = obtain2.readInt() != 0 ? (zzapx) zzapx.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzapx;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3603a;
            }
        }

        public static bj m5288a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bj)) ? new C1471a(iBinder) : (bj) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.gass.internal.IGassService");
                    zzapx a = m5286a(parcel.readInt() != 0 ? (zzapv) zzapv.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.gass.internal.IGassService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzapx m5286a(zzapv com_google_android_gms_internal_zzapv);
}
