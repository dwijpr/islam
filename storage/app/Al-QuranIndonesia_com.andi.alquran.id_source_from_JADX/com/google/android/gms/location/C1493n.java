package com.google.android.gms.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.location.n */
public interface C1493n extends IInterface {

    /* renamed from: com.google.android.gms.location.n.a */
    public static abstract class C1494a extends Binder implements C1493n {

        /* renamed from: com.google.android.gms.location.n.a.a */
        private static class C2096a implements C1493n {
            private IBinder f6708a;

            C2096a(IBinder iBinder) {
                this.f6708a = iBinder;
            }

            public void m9853a(LocationAvailability locationAvailability) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
                    if (locationAvailability != null) {
                        obtain.writeInt(1);
                        locationAvailability.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6708a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m9854a(LocationResult locationResult) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
                    if (locationResult != null) {
                        obtain.writeInt(1);
                        locationResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6708a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6708a;
            }
        }

        public static C1493n m5431a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1493n)) ? new C2096a(iBinder) : (C1493n) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            LocationAvailability locationAvailability = null;
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    LocationResult locationResult;
                    parcel.enforceInterface("com.google.android.gms.location.ILocationCallback");
                    if (parcel.readInt() != 0) {
                        locationResult = (LocationResult) LocationResult.CREATOR.createFromParcel(parcel);
                    }
                    m5430a(locationResult);
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.location.ILocationCallback");
                    if (parcel.readInt() != 0) {
                        locationAvailability = (LocationAvailability) LocationAvailability.CREATOR.createFromParcel(parcel);
                    }
                    m5429a(locationAvailability);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.ILocationCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m5429a(LocationAvailability locationAvailability);

    void m5430a(LocationResult locationResult);
}
