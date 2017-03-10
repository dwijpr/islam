package com.google.android.gms.maps.internal;

import com.google.android.gms.maps.GoogleMap;

public final class zza {
    public static Boolean zza(byte b) {
        switch (b) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return Boolean.FALSE;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte zze(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
