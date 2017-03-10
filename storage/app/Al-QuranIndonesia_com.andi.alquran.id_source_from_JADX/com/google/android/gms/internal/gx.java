package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.internal.gv.C1592a;
import com.google.android.gms.internal.gw.C1175a;
import com.google.android.gms.internal.hd.C1606a;
import com.google.android.gms.internal.js.C1694a;
import com.google.android.gms.internal.jt.C1696a;
import com.google.android.gms.internal.ju.C1698a;
import com.google.android.gms.internal.jv.C1700a;
import com.google.android.gms.maps.GoogleMap;

public interface gx extends IInterface {

    /* renamed from: com.google.android.gms.internal.gx.a */
    public static abstract class C1176a extends Binder implements gx {

        /* renamed from: com.google.android.gms.internal.gx.a.a */
        private static class C1610a implements gx {
            private IBinder f4224a;

            C1610a(IBinder iBinder) {
                this.f4224a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4224a;
            }

            public void zza(js jsVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    this.f4224a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(jt jtVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(jtVar != null ? jtVar.asBinder() : null);
                    this.f4224a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzgw com_google_android_gms_internal_zzgw) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (com_google_android_gms_internal_zzgw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzgw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4224a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, jv jvVar, ju juVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(jvVar != null ? jvVar.asBinder() : null);
                    if (juVar != null) {
                        iBinder = juVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4224a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(gv gvVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(gvVar != null ? gvVar.asBinder() : null);
                    this.f4224a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(hd hdVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(hdVar != null ? hdVar.asBinder() : null);
                    this.f4224a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public gw zzci() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    this.f4224a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    gw zzn = C1175a.zzn(obtain2.readStrongBinder());
                    return zzn;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1176a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static gx zzo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof gx)) ? new C1610a(iBinder) : (gx) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzgw com_google_android_gms_internal_zzgw = null;
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    IBinder asBinder;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    gw zzci = zzci();
                    parcel2.writeNoException();
                    if (zzci != null) {
                        asBinder = zzci.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzb(C1592a.m6318a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(C1694a.m7039a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(C1696a.m7042a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(parcel.readString(), C1700a.m7048a(parcel.readStrongBinder()), C1698a.m7045a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_liteMode /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzgw = (zzgw) zzgw.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzgw);
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzb(C1606a.m6421a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(js jsVar);

    void zza(jt jtVar);

    void zza(zzgw com_google_android_gms_internal_zzgw);

    void zza(String str, jv jvVar, ju juVar);

    void zzb(gv gvVar);

    void zzb(hd hdVar);

    gw zzci();
}
