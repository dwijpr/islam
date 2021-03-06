package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.internal.zzd;

public interface zzl extends IInterface {

    public static abstract class zza extends Binder implements zzl {

        /* renamed from: com.google.android.gms.maps.internal.zzl.zza.a */
        private static class C2167a implements zzl {
            private IBinder f6887a;

            C2167a(IBinder iBinder) {
                this.f6887a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6887a;
            }

            public void onIndoorBuildingFocused() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    this.f6887a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_maps_model_internal_zzd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    obtain.writeStrongBinder(com_google_android_gms_maps_model_internal_zzd != null ? com_google_android_gms_maps_model_internal_zzd.asBinder() : null);
                    this.f6887a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        }

        public static zzl zzdG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzl)) ? new C2167a(iBinder) : (zzl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    onIndoorBuildingFocused();
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    zza(com.google.android.gms.maps.model.internal.zzd.zza.zzek(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onIndoorBuildingFocused();

    void zza(zzd com_google_android_gms_maps_model_internal_zzd);
}
