package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hi.C1627a;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final hi f2326a;

    public static final class Builder {
        private final C1627a f2325a;

        public Builder() {
            this.f2325a = new C1627a();
        }

        public Builder addCategoryExclusion(String str) {
            this.f2325a.m6508g(str);
            return this;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f2325a.m6500b(cls, bundle);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.f2325a.m6497a(str, str2);
            return this;
        }

        public Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.f2325a.m6497a(str, TextUtils.join(",", list));
            }
            return this;
        }

        public Builder addKeyword(String str) {
            this.f2325a.m6496a(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f2325a.m6494a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f2325a.m6495a((Class) cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f2325a.m6501b(str);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest();
        }

        public Builder setBirthday(Date date) {
            this.f2325a.m6498a(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            C1314c.m4624a((Object) str, (Object) "Content URL must be non-null.");
            C1314c.m4626a(str, (Object) "Content URL must be non-empty.");
            boolean z = str.length() <= AdRequest.MAX_CONTENT_URL_LENGTH;
            Object[] objArr = new Object[PublisherAdRequest.GENDER_FEMALE];
            objArr[PublisherAdRequest.ERROR_CODE_INTERNAL_ERROR] = Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH);
            objArr[PublisherAdRequest.GENDER_MALE] = Integer.valueOf(str.length());
            C1314c.m4634b(z, "Content URL must not exceed %d in length.  Provided length was %d.", objArr);
            this.f2325a.m6505d(str);
            return this;
        }

        public Builder setGender(int i) {
            this.f2325a.m6492a(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.f2325a.m6504c(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f2325a.m6493a(location);
            return this;
        }

        @Deprecated
        public Builder setManualImpressionsEnabled(boolean z) {
            this.f2325a.m6499a(z);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.f2325a.m6506e(str);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f2325a.m6507f(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f2325a.m6502b(z);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = hi.f4251a;
    }

    private PublisherAdRequest(Builder builder) {
        this.f2326a = new hi(builder.f2325a);
    }

    public static void updateCorrelator() {
    }

    public Date getBirthday() {
        return this.f2326a.m6510a();
    }

    public String getContentUrl() {
        return this.f2326a.m6513b();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f2326a.m6515c(cls);
    }

    public Bundle getCustomTargeting() {
        return this.f2326a.m6525m();
    }

    public int getGender() {
        return this.f2326a.m6514c();
    }

    public Set<String> getKeywords() {
        return this.f2326a.m6516d();
    }

    public Location getLocation() {
        return this.f2326a.m6517e();
    }

    public boolean getManualImpressionsEnabled() {
        return this.f2326a.m6518f();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f2326a.m6509a((Class) cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f2326a.m6512b(cls);
    }

    public String getPublisherProvidedId() {
        return this.f2326a.m6519g();
    }

    public boolean isTestDevice(Context context) {
        return this.f2326a.m6511a(context);
    }

    public hi zzbq() {
        return this.f2326a;
    }
}
