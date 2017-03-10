package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.andi.alquran.C0861R;
import com.google.ads.AdSize;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.common.internal.C1330w.C1331a;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: com.google.android.gms.common.internal.x */
public interface C1359x extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.x.a */
    public static abstract class C1361a extends Binder implements C1359x {

        /* renamed from: com.google.android.gms.common.internal.x.a.a */
        private static class C1360a implements C1359x {
            private IBinder f3141a;

            C1360a(IBinder iBinder) {
                this.f3141a = iBinder;
            }

            public void m4860a(C1330w c1330w, zzan com_google_android_gms_common_internal_zzan) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c1330w != null ? c1330w.asBinder() : null);
                    if (com_google_android_gms_common_internal_zzan != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzan.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3141a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m4861a(C1330w c1330w, zzj com_google_android_gms_common_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c1330w != null ? c1330w.asBinder() : null);
                    if (com_google_android_gms_common_internal_zzj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3141a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3141a;
            }
        }

        public static C1359x m4862a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1359x)) ? new C1360a(iBinder) : (C1359x) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzan com_google_android_gms_common_internal_zzan = null;
            C1330w a;
            switch (i) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_liteMode /*6*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiCompass /*7*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    parcel.readStrongBinder();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_uiMapToolbar /*15*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_ambientEnabled /*16*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_latLngBoundsSouthWestLatitude /*19*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readStrongBinder();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_latLngBoundsSouthWestLongitude /*20*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C1096c.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_collapseContentDescription /*23*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_navigationIcon /*24*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_navigationContentDescription /*25*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_logoDescription /*26*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_titleTextColor /*27*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.Toolbar_subtitleTextColor /*28*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModeSplitBackground /*30*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel.readString();
                    parcel.createStringArray();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    C1331a.m4721a(parcel.readStrongBinder());
                    parcel.readInt();
                    parcel.readString();
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                    zzj com_google_android_gms_common_internal_zzj;
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C1331a.m4721a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzj = (zzj) zzj.CREATOR.createFromParcel(parcel);
                    }
                    m4859a(a, com_google_android_gms_common_internal_zzj);
                    parcel2.writeNoException();
                    return true;
                case C0861R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C1331a.m4721a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_internal_zzan = (zzan) zzan.CREATOR.createFromParcel(parcel);
                    }
                    m4858a(a, com_google_android_gms_common_internal_zzan);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m4858a(C1330w c1330w, zzan com_google_android_gms_common_internal_zzan);

    void m4859a(C1330w c1330w, zzj com_google_android_gms_common_internal_zzj);
}
