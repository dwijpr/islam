package com.google.android.gms.p039a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.a.c */
public interface C1108c extends IInterface {

    /* renamed from: com.google.android.gms.a.c.a */
    public static abstract class C1110a extends Binder implements C1108c {

        /* renamed from: com.google.android.gms.a.c.a.a */
        private static class C1109a implements C1108c {
            private IBinder f2301a;

            C1109a(IBinder iBinder) {
                this.f2301a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2301a;
            }
        }

        public C1110a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C1108c m3895a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1108c)) ? new C1109a(iBinder) : (C1108c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
