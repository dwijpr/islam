package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hi.C1627a;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final hi f2784a;
    private final int f2785b;
    private final int f2786c;
    private final int f2787d;
    private final int f2788e;
    private final int f2789f;
    private final int f2790g;
    private final int f2791h;
    private final int f2792i;
    private final String f2793j;
    private final int f2794k;
    private final String f2795l;
    private final int f2796m;
    private final int f2797n;
    private final String f2798o;

    public static final class Builder {
        private final C1627a f2769a;
        private int f2770b;
        private int f2771c;
        private int f2772d;
        private int f2773e;
        private int f2774f;
        private int f2775g;
        private int f2776h;
        private int f2777i;
        private String f2778j;
        private int f2779k;
        private String f2780l;
        private int f2781m;
        private int f2782n;
        private String f2783o;

        public Builder() {
            this.f2769a = new C1627a();
            this.f2776h = SearchAdRequest.ERROR_CODE_INTERNAL_ERROR;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f2769a.m6500b(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f2769a.m6494a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f2769a.m6495a((Class) cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f2769a.m6501b(str);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int i) {
            this.f2770b = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.f2771c = i;
            this.f2772d = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.f2773e = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            return this;
        }

        public Builder setBackgroundGradient(int i, int i2) {
            this.f2771c = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.f2772d = i2;
            this.f2773e = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.f2774f = i;
            return this;
        }

        public Builder setBorderThickness(int i) {
            this.f2775g = i;
            return this;
        }

        public Builder setBorderType(int i) {
            this.f2776h = i;
            return this;
        }

        public Builder setCallButtonColor(int i) {
            this.f2777i = i;
            return this;
        }

        public Builder setCustomChannels(String str) {
            this.f2778j = str;
            return this;
        }

        public Builder setDescriptionTextColor(int i) {
            this.f2779k = i;
            return this;
        }

        public Builder setFontFace(String str) {
            this.f2780l = str;
            return this;
        }

        public Builder setHeaderTextColor(int i) {
            this.f2781m = i;
            return this;
        }

        public Builder setHeaderTextSize(int i) {
            this.f2782n = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.f2769a.m6493a(location);
            return this;
        }

        public Builder setQuery(String str) {
            this.f2783o = str;
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f2769a.m6507f(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f2769a.m6502b(z);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = hi.f4251a;
    }

    private SearchAdRequest(Builder builder) {
        this.f2785b = builder.f2770b;
        this.f2786c = builder.f2771c;
        this.f2787d = builder.f2772d;
        this.f2788e = builder.f2773e;
        this.f2789f = builder.f2774f;
        this.f2790g = builder.f2775g;
        this.f2791h = builder.f2776h;
        this.f2792i = builder.f2777i;
        this.f2793j = builder.f2778j;
        this.f2794k = builder.f2779k;
        this.f2795l = builder.f2780l;
        this.f2796m = builder.f2781m;
        this.f2797n = builder.f2782n;
        this.f2798o = builder.f2783o;
        this.f2784a = new hi(builder.f2769a, this);
    }

    hi m4177a() {
        return this.f2784a;
    }

    public int getAnchorTextColor() {
        return this.f2785b;
    }

    public int getBackgroundColor() {
        return this.f2786c;
    }

    public int getBackgroundGradientBottom() {
        return this.f2787d;
    }

    public int getBackgroundGradientTop() {
        return this.f2788e;
    }

    public int getBorderColor() {
        return this.f2789f;
    }

    public int getBorderThickness() {
        return this.f2790g;
    }

    public int getBorderType() {
        return this.f2791h;
    }

    public int getCallButtonColor() {
        return this.f2792i;
    }

    public String getCustomChannels() {
        return this.f2793j;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f2784a.m6515c(cls);
    }

    public int getDescriptionTextColor() {
        return this.f2794k;
    }

    public String getFontFace() {
        return this.f2795l;
    }

    public int getHeaderTextColor() {
        return this.f2796m;
    }

    public int getHeaderTextSize() {
        return this.f2797n;
    }

    public Location getLocation() {
        return this.f2784a.m6517e();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f2784a.m6509a((Class) cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f2784a.m6512b(cls);
    }

    public String getQuery() {
        return this.f2798o;
    }

    public boolean isTestDevice(Context context) {
        return this.f2784a.m6511a(context);
    }
}
