package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.o */
public interface C1497o extends IInterface {

    /* renamed from: com.google.android.gms.location.o.a */
    public static abstract class C1498a extends Binder implements C1497o {

        /* renamed from: com.google.android.gms.location.o.a.a */
        private static class C2097a implements C1497o {
            private IBinder f6709a;

            C2097a(IBinder iBinder) {
                this.f6709a = iBinder;
            }

            public void m9855a(Location location) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6709a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6709a;
            }
        }

        public C1498a() {
            attachInterface(this, "com.google.android.gms.location.ILocationListener");
        }

        public static C1497o m5438a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1497o)) ? new C2097a(iBinder) : (C1497o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.location.ILocationListener");
                    m5437a(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.ILocationListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m5437a(Location location);
}
