package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.internal.mf.C1788a;
import com.google.android.gms.internal.mh.C1803a;
import com.google.android.gms.internal.mi.C1805a;
import com.google.android.gms.internal.qr.C1933a;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1108c.C1110a;
import java.util.List;

public interface me extends IInterface {

    /* renamed from: com.google.android.gms.internal.me.a */
    public static abstract class C1799a extends Binder implements me {

        /* renamed from: com.google.android.gms.internal.me.a.a */
        private static class C1798a implements me {
            private IBinder f4932a;

            C1798a(IBinder iBinder) {
                this.f4932a = iBinder;
            }

            public C1108c m7483a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C1108c a = C1110a.m3895a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7484a(C1108c c1108c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    this.f4932a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7485a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, mf mfVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (mfVar != null) {
                        iBinder = mfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4932a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7486a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, qr qrVar, String str2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (qrVar != null) {
                        iBinder = qrVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str2);
                    this.f4932a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7487a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (mfVar != null) {
                        iBinder = mfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4932a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7488a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar, zzgw com_google_android_gms_internal_zzgw, List<String> list) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (mfVar != null) {
                        iBinder = mfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (com_google_android_gms_internal_zzgw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzgw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    this.f4932a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7489a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, zzdy com_google_android_gms_internal_zzdy, String str, mf mfVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (mfVar != null) {
                        iBinder = mfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4932a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7490a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c1108c != null ? c1108c.asBinder() : null);
                    if (com_google_android_gms_internal_zzec != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (mfVar != null) {
                        iBinder = mfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4932a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7491a(zzdy com_google_android_gms_internal_zzdy, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f4932a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7492a(zzdy com_google_android_gms_internal_zzdy, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (com_google_android_gms_internal_zzdy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f4932a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4932a;
            }

            public void m7493b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7494c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7495d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7496e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m7497f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m7498g() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(13, obtain, obtain2, 0);
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

            public mh m7499h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    mh a = C1803a.m7546a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public mi m7500i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    mi a = C1805a.m7573a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle m7501j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle m7502k() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle m7503l() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f4932a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1799a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static me m7504a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof me)) ? new C1798a(iBinder) : (me) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            IBinder iBinder = null;
            Bundle j;
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7468a(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C1788a.m7392a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    C1108c a = m7462a();
                    parcel2.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7464a(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C1788a.m7392a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7472b();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7473c();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_liteMode /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7469a(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), C1788a.m7392a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7466a(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), C1788a.m7392a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7474d();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7475e();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7465a(C1110a.m3895a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C1933a.m8317a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7470a(parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7476f();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean g = m7477g();
                    parcel2.writeNoException();
                    if (g) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    zzgw com_google_android_gms_internal_zzgw;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    C1108c a2 = C1110a.m3895a(parcel.readStrongBinder());
                    zzdy com_google_android_gms_internal_zzdy = parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null;
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    mf a3 = C1788a.m7392a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzgw = (zzgw) zzgw.CREATOR.createFromParcel(parcel);
                    }
                    m7467a(a2, com_google_android_gms_internal_zzdy, readString, readString2, a3, com_google_android_gms_internal_zzgw, parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mh h = m7478h();
                    parcel2.writeNoException();
                    if (h != null) {
                        iBinder = h.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case C1096c.MapAttrs_ambientEnabled /*16*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mi i4 = m7479i();
                    parcel2.writeNoException();
                    if (i4 != null) {
                        iBinder = i4.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = m7480j();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = m7481k();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C1096c.MapAttrs_latLngBoundsSouthWestLatitude /*19*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = m7482l();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C1096c.MapAttrs_latLngBoundsSouthWestLongitude /*20*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7471a(parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m7463a(C1110a.m3895a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C1108c m7462a();

    void m7463a(C1108c c1108c);

    void m7464a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, mf mfVar);

    void m7465a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, qr qrVar, String str2);

    void m7466a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar);

    void m7467a(C1108c c1108c, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar, zzgw com_google_android_gms_internal_zzgw, List<String> list);

    void m7468a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, zzdy com_google_android_gms_internal_zzdy, String str, mf mfVar);

    void m7469a(C1108c c1108c, zzec com_google_android_gms_internal_zzec, zzdy com_google_android_gms_internal_zzdy, String str, String str2, mf mfVar);

    void m7470a(zzdy com_google_android_gms_internal_zzdy, String str);

    void m7471a(zzdy com_google_android_gms_internal_zzdy, String str, String str2);

    void m7472b();

    void m7473c();

    void m7474d();

    void m7475e();

    void m7476f();

    boolean m7477g();

    mh m7478h();

    mi m7479i();

    Bundle m7480j();

    Bundle m7481k();

    Bundle m7482l();
}
