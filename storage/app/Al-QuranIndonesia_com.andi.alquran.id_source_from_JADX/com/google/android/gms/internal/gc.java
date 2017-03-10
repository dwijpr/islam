package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;

public interface gc extends IInterface {

    /* renamed from: com.google.android.gms.internal.gc.a */
    public static abstract class C1590a extends Binder implements gc {

        /* renamed from: com.google.android.gms.internal.gc.a.a */
        private static class C1589a implements gc {
            private IBinder f4142a;

            C1589a(IBinder iBinder) {
                this.f4142a = iBinder;
            }

            public zzdl m6307a(zzdo com_google_android_gms_internal_zzdo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.cache.ICacheService");
                    if (com_google_android_gms_internal_zzdo != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4142a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzdl com_google_android_gms_internal_zzdl = obtain2.readInt() != 0 ? (zzdl) zzdl.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzdl;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4142a;
            }
        }

        public static gc m6308a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof gc)) ? new C1589a(iBinder) : (gc) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.cache.ICacheService");
                    zzdl a = m6306a(parcel.readInt() != 0 ? (zzdo) zzdo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.cache.ICacheService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzdl m6306a(zzdo com_google_android_gms_internal_zzdo);
}
