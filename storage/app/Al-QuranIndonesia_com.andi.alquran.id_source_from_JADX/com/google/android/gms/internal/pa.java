package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.pb.C1888a;
import com.google.android.gms.maps.GoogleMap;

public interface pa extends IInterface {

    /* renamed from: com.google.android.gms.internal.pa.a */
    public static abstract class C1897a extends Binder implements pa {

        /* renamed from: com.google.android.gms.internal.pa.a.a */
        private static class C1896a implements pa {
            private IBinder f5339a;

            C1896a(IBinder iBinder) {
                this.f5339a = iBinder;
            }

            public zzmk m8066a(zzmh com_google_android_gms_internal_zzmh) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (com_google_android_gms_internal_zzmh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzmh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f5339a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzmk com_google_android_gms_internal_zzmk = obtain2.readInt() != 0 ? (zzmk) zzmk.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzmk;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8067a(zzmh com_google_android_gms_internal_zzmh, pb pbVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (com_google_android_gms_internal_zzmh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzmh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(pbVar != null ? pbVar.asBinder() : null);
                    this.f5339a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f5339a;
            }
        }

        public C1897a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static pa m8068a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof pa)) ? new C1896a(iBinder) : (pa) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzmh com_google_android_gms_internal_zzmh = null;
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzmh = (zzmh) zzmh.CREATOR.createFromParcel(parcel);
                    }
                    zzmk a = m8064a(com_google_android_gms_internal_zzmh);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzmh = (zzmh) zzmh.CREATOR.createFromParcel(parcel);
                    }
                    m8065a(com_google_android_gms_internal_zzmh, C1888a.m7985a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzmk m8064a(zzmh com_google_android_gms_internal_zzmh);

    void m8065a(zzmh com_google_android_gms_internal_zzmh, pb pbVar);
}
