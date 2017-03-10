package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.zza;
import com.google.android.gms.maps.GoogleMap;
import java.util.Date;
import java.util.HashSet;

@op
public final class ms {

    /* renamed from: com.google.android.gms.internal.ms.1 */
    static /* synthetic */ class C18171 {
        static final /* synthetic */ int[] f4996a;
        static final /* synthetic */ int[] f4997b;

        static {
            f4997b = new int[ErrorCode.values().length];
            try {
                f4997b[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4997b[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4997b[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4997b[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f4996a = new int[Gender.values().length];
            try {
                f4996a[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4996a[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4996a[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m7679a(ErrorCode errorCode) {
        switch (C18171.f4997b[errorCode.ordinal()]) {
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return 1;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return 2;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static Gender m7680a(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return Gender.MALE;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static AdSize m7681a(zzec com_google_android_gms_internal_zzec) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < 6) {
            if (adSizeArr[i].getWidth() == com_google_android_gms_internal_zzec.f6456f && adSizeArr[i].getHeight() == com_google_android_gms_internal_zzec.f6453c) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(zza.zza(com_google_android_gms_internal_zzec.f6456f, com_google_android_gms_internal_zzec.f6453c, com_google_android_gms_internal_zzec.f6452b));
    }

    public static MediationAdRequest m7682a(zzdy com_google_android_gms_internal_zzdy) {
        return new MediationAdRequest(new Date(com_google_android_gms_internal_zzdy.f6434b), m7680a(com_google_android_gms_internal_zzdy.f6436d), com_google_android_gms_internal_zzdy.f6437e != null ? new HashSet(com_google_android_gms_internal_zzdy.f6437e) : null, com_google_android_gms_internal_zzdy.f6438f, com_google_android_gms_internal_zzdy.f6443k);
    }
}
