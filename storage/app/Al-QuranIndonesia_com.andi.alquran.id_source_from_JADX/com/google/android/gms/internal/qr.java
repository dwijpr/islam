package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1108c.C1110a;

public interface qr extends IInterface {

    /* renamed from: com.google.android.gms.internal.qr.a */
    public static abstract class C1933a extends Binder implements qr {

        /* renamed from: com.google.android.gms.internal.qr.a.a */
        private static class C1936a implements qr {
            private IBinder f5590a;

            C1936a(IBinder iBinder) {
                this.f5590a = iBinder;
            }

            public void m8343a(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f5590a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8344a(C1108c c1108c, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    obtain.writeInt(i);
                    this.f5590a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8345a(C1108c c1108c, zzok com_google_android_gms_internal_zzok) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzok != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzok.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f5590a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f5590a;
            }

            public void m8346b(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f5590a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8347b(C1108c c1108c, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    obtain.writeInt(i);
                    this.f5590a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8348c(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f5590a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8349d(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f5590a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8350e(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f5590a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8351f(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f5590a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m8352g(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f5590a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1933a() {
            attachInterface(this, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        }

        public static qr m8317a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qr)) ? new C1936a(iBinder) : (qr) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8307a(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8308a(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8310b(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8312c(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8313d(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_liteMode /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8314e(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8309a(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzok) zzok.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8315f(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8311b(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m8316g(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m8307a(C1108c c1108c);

    void m8308a(C1108c c1108c, int i);

    void m8309a(C1108c c1108c, zzok com_google_android_gms_internal_zzok);

    void m8310b(C1108c c1108c);

    void m8311b(C1108c c1108c, int i);

    void m8312c(C1108c c1108c);

    void m8313d(C1108c c1108c);

    void m8314e(C1108c c1108c);

    void m8315f(C1108c c1108c);

    void m8316g(C1108c c1108c);
}
