package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.wd.C2058a;
import com.google.android.gms.maps.GoogleMap;

public interface we extends IInterface {

    /* renamed from: com.google.android.gms.internal.we.a */
    public static abstract class C2063a extends Binder implements we {

        /* renamed from: com.google.android.gms.internal.we.a.a */
        private static class C2062a implements we {
            private IBinder f6308a;

            C2062a(IBinder iBinder) {
                this.f6308a = iBinder;
            }

            public void m9643a(wd wdVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (wdVar != null) {
                        iBinder = wdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f6308a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m9644a(wd wdVar, zzzh com_google_android_gms_internal_zzzh) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (wdVar != null) {
                        iBinder = wdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (com_google_android_gms_internal_zzzh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzzh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6308a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6308a;
            }
        }

        public static we m9645a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof we)) ? new C2062a(iBinder) : (we) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    m9642a(C2058a.m9615a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzzh) zzzh.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    m9641a(C2058a.m9615a(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m9641a(wd wdVar);

    void m9642a(wd wdVar, zzzh com_google_android_gms_internal_zzzh);
}
