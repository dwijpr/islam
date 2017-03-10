package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hi.C1627a;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final hi f2312a;

    public static final class Builder {
        private final C1627a f2311a;

        public Builder() {
            this.f2311a = new C1627a();
            this.f2311a.m6501b(AdRequest.DEVICE_ID_EMULATOR);
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f2311a.m6500b(cls, bundle);
            return this;
        }

        public Builder addKeyword(String str) {
            this.f2311a.m6496a(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f2311a.m6494a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f2311a.m6495a((Class) cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f2311a.m6503c(AdRequest.DEVICE_ID_EMULATOR);
            }
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f2311a.m6501b(str);
            return this;
        }

        public AdRequest build() {
            return new AdRequest();
        }

        public Builder setBirthday(Date date) {
            this.f2311a.m6498a(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            C1314c.m4624a((Object) str, (Object) "Content URL must be non-null.");
            C1314c.m4626a(str, (Object) "Content URL must be non-empty.");
            boolean z = str.length() <= AdRequest.MAX_CONTENT_URL_LENGTH;
            Object[] objArr = new Object[AdRequest.GENDER_FEMALE];
            objArr[AdRequest.GENDER_UNKNOWN] = Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH);
            objArr[AdRequest.GENDER_MALE] = Integer.valueOf(str.length());
            C1314c.m4634b(z, "Content URL must not exceed %d in length.  Provided length was %d.", objArr);
            this.f2311a.m6505d(str);
            return this;
        }

        public Builder setGender(int i) {
            this.f2311a.m6492a(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.f2311a.m6504c(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f2311a.m6493a(location);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f2311a.m6507f(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f2311a.m6502b(z);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = hi.f4251a;
    }

    private AdRequest(Builder builder) {
        this.f2312a = new hi(builder.f2311a);
    }

    public Date getBirthday() {
        return this.f2312a.m6510a();
    }

    public String getContentUrl() {
        return this.f2312a.m6513b();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f2312a.m6515c(cls);
    }

    public int getGender() {
        return this.f2312a.m6514c();
    }

    public Set<String> getKeywords() {
        return this.f2312a.m6516d();
    }

    public Location getLocation() {
        return this.f2312a.m6517e();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f2312a.m6509a((Class) cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f2312a.m6512b(cls);
    }

    public boolean isTestDevice(Context context) {
        return this.f2312a.m6511a(context);
    }

    public hi zzbq() {
        return this.f2312a;
    }
}
