package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.C1308t;
import com.google.android.gms.common.internal.C1308t.C1309a;
import com.google.android.gms.common.internal.C1362y;
import com.google.android.gms.common.internal.C1362y.C1364a;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.cq.C1426a;
import com.google.android.gms.maps.GoogleMap;

public interface cr extends IInterface {

    /* renamed from: com.google.android.gms.internal.cr.a */
    public static abstract class C1515a extends Binder implements cr {

        /* renamed from: com.google.android.gms.internal.cr.a.a */
        private static class C1514a implements cr {
            private IBinder f3699a;

            C1514a(IBinder iBinder) {
                this.f3699a = iBinder;
            }

            public void m5587a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.f3699a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5588a(int i, Account account, cq cqVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cqVar != null ? cqVar.asBinder() : null);
                    this.f3699a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5589a(C1308t c1308t, int i, boolean z) {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(c1308t != null ? c1308t.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f3699a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5590a(zzad com_google_android_gms_common_internal_zzad, C1362y c1362y) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_common_internal_zzad != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzad.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c1362y != null ? c1362y.asBinder() : null);
                    this.f3699a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5591a(zzd com_google_android_gms_common_internal_zzd, cq cqVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_common_internal_zzd != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzd.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cqVar != null ? cqVar.asBinder() : null);
                    this.f3699a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5592a(cq cqVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(cqVar != null ? cqVar.asBinder() : null);
                    this.f3699a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5593a(zzaxs com_google_android_gms_internal_zzaxs) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzaxs != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaxs.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3699a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5594a(zzaxw com_google_android_gms_internal_zzaxw, cq cqVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzaxw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaxw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cqVar != null ? cqVar.asBinder() : null);
                    this.f3699a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5595a(zzaxz com_google_android_gms_internal_zzaxz, cq cqVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (com_google_android_gms_internal_zzaxz != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzaxz.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cqVar != null ? cqVar.asBinder() : null);
                    this.f3699a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5596a(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f3699a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3699a;
            }
        }

        public static cr m5597a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cr)) ? new C1514a(iBinder) : (cr) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            zzaxz com_google_android_gms_internal_zzaxz = null;
            switch (i) {
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    zzd com_google_android_gms_common_internal_zzd;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzd = (zzd) zzd.CREATOR.createFromParcel(parcel);
                    }
                    m5581a(com_google_android_gms_common_internal_zzd, C1426a.m5055a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    zzaxs com_google_android_gms_internal_zzaxs;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaxs = (zzaxs) zzaxs.CREATOR.createFromParcel(parcel);
                    }
                    m5583a(com_google_android_gms_internal_zzaxs);
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    m5586a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    zzad com_google_android_gms_common_internal_zzad;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzad = (zzad) zzad.CREATOR.createFromParcel(parcel);
                    }
                    m5580a(com_google_android_gms_common_internal_zzad, C1364a.m4865a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    m5577a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    Account account;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(parcel);
                    }
                    m5578a(readInt, account, C1426a.m5055a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    C1308t a = C1309a.m4615a(parcel.readStrongBinder());
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m5579a(a, readInt2, z);
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    zzaxw com_google_android_gms_internal_zzaxw;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaxw = (zzaxw) zzaxw.CREATOR.createFromParcel(parcel);
                    }
                    m5584a(com_google_android_gms_internal_zzaxw, C1426a.m5055a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    m5582a(C1426a.m5055a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzaxz = (zzaxz) zzaxz.CREATOR.createFromParcel(parcel);
                    }
                    m5585a(com_google_android_gms_internal_zzaxz, C1426a.m5055a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m5577a(int i);

    void m5578a(int i, Account account, cq cqVar);

    void m5579a(C1308t c1308t, int i, boolean z);

    void m5580a(zzad com_google_android_gms_common_internal_zzad, C1362y c1362y);

    void m5581a(zzd com_google_android_gms_common_internal_zzd, cq cqVar);

    void m5582a(cq cqVar);

    void m5583a(zzaxs com_google_android_gms_internal_zzaxs);

    void m5584a(zzaxw com_google_android_gms_internal_zzaxw, cq cqVar);

    void m5585a(zzaxz com_google_android_gms_internal_zzaxz, cq cqVar);

    void m5586a(boolean z);
}
