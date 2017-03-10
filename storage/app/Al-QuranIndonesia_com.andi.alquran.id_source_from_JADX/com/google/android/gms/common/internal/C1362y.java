package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.internal.y */
public interface C1362y extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.y.a */
    public static abstract class C1364a extends Binder implements C1362y {

        /* renamed from: com.google.android.gms.common.internal.y.a.a */
        private static class C1363a implements C1362y {
            private IBinder f3142a;

            C1363a(IBinder iBinder) {
                this.f3142a = iBinder;
            }

            public void m4864a(zzaf com_google_android_gms_common_internal_zzaf) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                    if (com_google_android_gms_common_internal_zzaf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzaf.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3142a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3142a;
            }
        }

        public static C1362y m4865a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1362y)) ? new C1363a(iBinder) : (C1362y) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                    m4863a(parcel.readInt() != 0 ? (zzaf) zzaf.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m4863a(zzaf com_google_android_gms_common_internal_zzaf);
}
