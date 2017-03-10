package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.internal.gx.C1176a;
import com.google.android.gms.internal.gz.C1154a;
import com.google.android.gms.internal.he.C1186a;
import com.google.android.gms.internal.jk.C1633a;
import com.google.android.gms.internal.md.C1796a;
import com.google.android.gms.internal.nd.C1144a;
import com.google.android.gms.internal.nn.C1150a;
import com.google.android.gms.internal.qa.C1635a;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1108c.C1110a;

public interface hc extends IInterface {

    /* renamed from: com.google.android.gms.internal.hc.a */
    public static abstract class C1122a extends Binder implements hc {

        /* renamed from: com.google.android.gms.internal.hc.a.a */
        private static class C1618a implements hc {
            private IBinder f4230a;

            C1618a(IBinder iBinder) {
                this.f4230a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4230a;
            }

            public gx createAdLoaderBuilder(C1108c c1108c, String str, md mdVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    obtain.writeString(str);
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f4230a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    gx zzo = C1176a.zzo(obtain2.readStrongBinder());
                    return zzo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public nd createAdOverlay(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f4230a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    nd zzT = C1144a.zzT(obtain2.readStrongBinder());
                    return zzT;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public gz createBannerAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
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
                    this.f4230a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    gz zzq = C1154a.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public nn createInAppPurchaseManager(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f4230a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    nn zzY = C1150a.zzY(obtain2.readStrongBinder());
                    return zzY;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public gz createInterstitialAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
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
                    this.f4230a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    gz zzq = C1154a.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public jk createNativeAdViewDelegate(C1108c c1108c, C1108c c1108c2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (c1108c2 != null) {
                        iBinder = c1108c2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4230a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    jk a = C1633a.m6603a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public qa createRewardedVideoAd(C1108c c1108c, md mdVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f4230a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    qa a = C1635a.m6619a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public gz createSearchAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f4230a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    gz zzq = C1154a.zzq(obtain2.readStrongBinder());
                    return zzq;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public he getMobileAdsSettingsManager(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f4230a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    he zzu = C1186a.zzu(obtain2.readStrongBinder());
                    return zzu;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public he getMobileAdsSettingsManagerWithClientJarVersion(C1108c c1108c, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    obtain.writeInt(i);
                    this.f4230a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    he zzu = C1186a.zzu(obtain2.readStrongBinder());
                    return zzu;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1122a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
        }

        public static hc asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hc)) ? new C1618a(iBinder) : (hc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            gz createBannerAdManager;
            he mobileAdsSettingsManager;
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createBannerAdManager(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C1796a.m7454a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createInterstitialAdManager(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C1796a.m7454a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    gx createAdLoaderBuilder = createAdLoaderBuilder(C1110a.m3895a(parcel.readStrongBinder()), parcel.readString(), C1796a.m7454a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createAdLoaderBuilder != null) {
                        iBinder = createAdLoaderBuilder.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    mobileAdsSettingsManager = getMobileAdsSettingsManager(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    jk createNativeAdViewDelegate = createNativeAdViewDelegate(C1110a.m3895a(parcel.readStrongBinder()), C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createNativeAdViewDelegate != null) {
                        iBinder = createNativeAdViewDelegate.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case C1096c.MapAttrs_liteMode /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    qa createRewardedVideoAd = createRewardedVideoAd(C1110a.m3895a(parcel.readStrongBinder()), C1796a.m7454a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createRewardedVideoAd != null) {
                        iBinder = createRewardedVideoAd.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    nn createInAppPurchaseManager = createInAppPurchaseManager(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createInAppPurchaseManager != null) {
                        iBinder = createInAppPurchaseManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    nd createAdOverlay = createAdOverlay(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createAdOverlay != null) {
                        iBinder = createAdOverlay.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    mobileAdsSettingsManager = getMobileAdsSettingsManagerWithClientJarVersion(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createSearchAdManager(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IClientApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    gx createAdLoaderBuilder(C1108c c1108c, String str, md mdVar, int i);

    nd createAdOverlay(C1108c c1108c);

    gz createBannerAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i);

    nn createInAppPurchaseManager(C1108c c1108c);

    gz createInterstitialAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, md mdVar, int i);

    jk createNativeAdViewDelegate(C1108c c1108c, C1108c c1108c2);

    qa createRewardedVideoAd(C1108c c1108c, md mdVar, int i);

    gz createSearchAdManager(C1108c c1108c, zzec com_google_android_gms_internal_zzec, String str, int i);

    he getMobileAdsSettingsManager(C1108c c1108c);

    he getMobileAdsSettingsManagerWithClientJarVersion(C1108c c1108c, int i);
}
