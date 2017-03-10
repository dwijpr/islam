package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.C1292b;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private static boolean f6806a;

    static {
        f6806a = false;
    }

    private MapsInitializer() {
    }

    public static synchronized int initialize(Context context) {
        int i = 0;
        synchronized (MapsInitializer.class) {
            C1314c.m4624a((Object) context, (Object) "Context is null");
            if (!f6806a) {
                try {
                    zza(zzai.zzbq(context));
                    f6806a = true;
                } catch (C1292b e) {
                    i = e.f3024a;
                }
            }
        }
        return i;
    }

    public static void zza(zzc com_google_android_gms_maps_internal_zzc) {
        try {
            CameraUpdateFactory.zza(com_google_android_gms_maps_internal_zzc.zzIQ());
            BitmapDescriptorFactory.zza(com_google_android_gms_maps_internal_zzc.zzIR());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
