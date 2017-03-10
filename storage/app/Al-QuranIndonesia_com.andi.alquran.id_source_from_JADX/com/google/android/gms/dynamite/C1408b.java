package com.google.android.gms.dynamite;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1108c.C1110a;

/* renamed from: com.google.android.gms.dynamite.b */
public interface C1408b extends IInterface {

    /* renamed from: com.google.android.gms.dynamite.b.a */
    public static abstract class C1410a extends Binder implements C1408b {

        /* renamed from: com.google.android.gms.dynamite.b.a.a */
        private static class C1409a implements C1408b {
            private IBinder f3256a;

            C1409a(IBinder iBinder) {
                this.f3256a = iBinder;
            }

            public C1108c m5028a(C1108c c1108c, String str, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.f3256a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C1108c a = C1110a.m3895a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3256a;
            }
        }

        public static C1408b m5029a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1408b)) ? new C1409a(iBinder) : (C1408b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                    C1108c a = m5027a(C1110a.m3895a(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C1108c m5027a(C1108c c1108c, String str, byte[] bArr);
}
