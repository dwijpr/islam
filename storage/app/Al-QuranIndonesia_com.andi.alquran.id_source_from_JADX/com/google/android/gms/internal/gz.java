package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.internal.gu.C1591a;
import com.google.android.gms.internal.gv.C1592a;
import com.google.android.gms.internal.hb.C1595a;
import com.google.android.gms.internal.hd.C1606a;
import com.google.android.gms.internal.hg.C1624a;
import com.google.android.gms.internal.is.C1656a;
import com.google.android.gms.internal.nl.C1738a;
import com.google.android.gms.internal.nq.C1842a;
import com.google.android.gms.internal.qc.C1751a;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1108c.C1110a;

public interface gz extends IInterface {

    /* renamed from: com.google.android.gms.internal.gz.a */
    public static abstract class C1154a extends Binder implements gz {

        /* renamed from: com.google.android.gms.internal.gz.a.a */
        private static class C1613a implements gz {
            private IBinder f4226a;

            C1613a(IBinder iBinder) {
                this.f4226a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4226a;
            }

            public void destroy() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getMediationAdapterClassName() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoading() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isReady() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setManualImpressionsEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f4226a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserId(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeString(str);
                    this.f4226a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopLoading() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(gu guVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(guVar != null ? guVar.asBinder() : null);
                    this.f4226a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(gv gvVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(gvVar != null ? gvVar.asBinder() : null);
                    this.f4226a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(hb hbVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(hbVar != null ? hbVar.asBinder() : null);
                    this.f4226a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(hd hdVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(hdVar != null ? hdVar.asBinder() : null);
                    this.f4226a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(is isVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(isVar != null ? isVar.asBinder() : null);
                    this.f4226a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(nl nlVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(nlVar != null ? nlVar.asBinder() : null);
                    this.f4226a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(nq nqVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(nqVar != null ? nqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4226a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(qc qcVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(qcVar != null ? qcVar.asBinder() : null);
                    this.f4226a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzec com_google_android_gms_internal_zzec) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4226a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzfn com_google_android_gms_internal_zzfn) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (com_google_android_gms_internal_zzfn != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzfn.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4226a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzb(zzdy com_google_android_gms_internal_zzdy) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4226a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1108c zzbC() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C1108c a = C1110a.m3895a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzec zzbD() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    zzec com_google_android_gms_internal_zzec = obtain2.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return com_google_android_gms_internal_zzec;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzbF() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public hg zzbG() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f4226a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    hg a = C1624a.m6467a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1154a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static gz zzq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof gz)) ? new C1613a(iBinder) : (gz) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzfn com_google_android_gms_internal_zzfn = null;
            int i3 = 0;
            IBinder asBinder;
            boolean isReady;
            zzec zzbD;
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    C1108c zzbC = zzbC();
                    parcel2.writeNoException();
                    if (zzbC != null) {
                        asBinder = zzbC.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    destroy();
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    isReady = isReady();
                    parcel2.writeNoException();
                    parcel2.writeInt(isReady ? 1 : 0);
                    return true;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    zzdy com_google_android_gms_internal_zzdy;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzdy = (zzdy) zzdy.CREATOR.createFromParcel(parcel);
                    }
                    isReady = zzb(com_google_android_gms_internal_zzdy);
                    parcel2.writeNoException();
                    if (isReady) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    pause();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_liteMode /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    resume();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(C1592a.m6318a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(C1595a.m6348a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    showInterstitial();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    stopLoading();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zzbF();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zzbD = zzbD();
                    parcel2.writeNoException();
                    if (zzbD != null) {
                        parcel2.writeInt(1);
                        zzbD.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        zzbD = (zzec) zzec.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzbD);
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(C1738a.m7210a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(C1842a.m7781a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    String mediationAdapterClassName = getMediationAdapterClassName();
                    parcel2.writeNoException();
                    parcel2.writeString(mediationAdapterClassName);
                    return true;
                case C1096c.MapAttrs_latLngBoundsSouthWestLatitude /*19*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(C1656a.m6769a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_latLngBoundsSouthWestLongitude /*20*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(C1591a.m6311a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(C1606a.m6421a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    boolean z;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setManualImpressionsEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_collapseContentDescription /*23*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    isReady = isLoading();
                    parcel2.writeNoException();
                    if (isReady) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case C0861R.styleable.Toolbar_navigationIcon /*24*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(C1751a.m7230a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_navigationContentDescription /*25*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    setUserId(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_logoDescription /*26*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    hg zzbG = zzbG();
                    parcel2.writeNoException();
                    if (zzbG != null) {
                        asBinder = zzbG.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzfn = (zzfn) zzfn.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzfn);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void destroy();

    String getMediationAdapterClassName();

    boolean isLoading();

    boolean isReady();

    void pause();

    void resume();

    void setManualImpressionsEnabled(boolean z);

    void setUserId(String str);

    void showInterstitial();

    void stopLoading();

    void zza(gu guVar);

    void zza(gv gvVar);

    void zza(hb hbVar);

    void zza(hd hdVar);

    void zza(is isVar);

    void zza(nl nlVar);

    void zza(nq nqVar, String str);

    void zza(qc qcVar);

    void zza(zzec com_google_android_gms_internal_zzec);

    void zza(zzfn com_google_android_gms_internal_zzfn);

    boolean zzb(zzdy com_google_android_gms_internal_zzdy);

    C1108c zzbC();

    zzec zzbD();

    void zzbF();

    hg zzbG();
}
