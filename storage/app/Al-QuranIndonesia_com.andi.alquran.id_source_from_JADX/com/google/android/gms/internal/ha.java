package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.md.C1796a;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1108c.C1110a;

public interface ha extends IInterface {

    /* renamed from: com.google.android.gms.internal.ha.a */
    public static abstract class C1616a extends Binder implements ha {

        /* renamed from: com.google.android.gms.internal.ha.a.a */
        private static class C1615a implements ha {
            private IBinder f4228a;

            C1615a(IBinder iBinder) {
                this.f4228a = iBinder;
            }

            public IBinder m6441a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f4228a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder m6442a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i, int i2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f4228a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4228a;
            }
        }

        public static ha m6443a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ha)) ? new C1615a(iBinder) : (ha) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzec com_google_android_gms_internal_zzec = null;
            C1108c a;
            IBinder a2;
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    a = C1110a.m3895a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzec = (zzec) zzec.CREATOR.createFromParcel(parcel);
                    }
                    a2 = m6439a(a, com_google_android_gms_internal_zzec, parcel.readString(), C1796a.m7454a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    a = C1110a.m3895a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzec = (zzec) zzec.CREATOR.createFromParcel(parcel);
                    }
                    a2 = m6440a(a, com_google_android_gms_internal_zzec, parcel.readString(), C1796a.m7454a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder m6439a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i);

    IBinder m6440a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i, int i2);
}
