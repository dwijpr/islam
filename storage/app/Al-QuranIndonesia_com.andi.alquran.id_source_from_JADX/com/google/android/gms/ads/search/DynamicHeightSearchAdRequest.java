package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.hi;

public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest f2768a;

    public static final class Builder {
        private final com.google.android.gms.ads.search.SearchAdRequest.Builder f2766a;
        private final Bundle f2767b;

        public Builder() {
            this.f2766a = new com.google.android.gms.ads.search.SearchAdRequest.Builder();
            this.f2767b = new Bundle();
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f2766a.addCustomEventExtrasBundle(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f2766a.addNetworkExtras(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f2766a.addNetworkExtrasBundle(cls, bundle);
            return this;
        }

        public DynamicHeightSearchAdRequest build() {
            this.f2766a.addNetworkExtrasBundle(AdMobAdapter.class, this.f2767b);
            return new DynamicHeightSearchAdRequest();
        }

        public Builder setAdBorderSelectors(String str) {
            this.f2767b.putString("csa_adBorderSelectors", str);
            return this;
        }

        public Builder setAdTest(boolean z) {
            this.f2767b.putString("csa_adtest", z ? "on" : "off");
            return this;
        }

        public Builder setAdjustableLineHeight(int i) {
            this.f2767b.putString("csa_adjustableLineHeight", Integer.toString(i));
            return this;
        }

        public Builder setAdvancedOptionValue(String str, String str2) {
            this.f2767b.putString(str, str2);
            return this;
        }

        public Builder setAttributionSpacingBelow(int i) {
            this.f2767b.putString("csa_attributionSpacingBelow", Integer.toString(i));
            return this;
        }

        public Builder setBorderSelections(String str) {
            this.f2767b.putString("csa_borderSelections", str);
            return this;
        }

        public Builder setChannel(String str) {
            this.f2767b.putString("csa_channel", str);
            return this;
        }

        public Builder setColorAdBorder(String str) {
            this.f2767b.putString("csa_colorAdBorder", str);
            return this;
        }

        public Builder setColorAdSeparator(String str) {
            this.f2767b.putString("csa_colorAdSeparator", str);
            return this;
        }

        public Builder setColorAnnotation(String str) {
            this.f2767b.putString("csa_colorAnnotation", str);
            return this;
        }

        public Builder setColorAttribution(String str) {
            this.f2767b.putString("csa_colorAttribution", str);
            return this;
        }

        public Builder setColorBackground(String str) {
            this.f2767b.putString("csa_colorBackground", str);
            return this;
        }

        public Builder setColorBorder(String str) {
            this.f2767b.putString("csa_colorBorder", str);
            return this;
        }

        public Builder setColorDomainLink(String str) {
            this.f2767b.putString("csa_colorDomainLink", str);
            return this;
        }

        public Builder setColorText(String str) {
            this.f2767b.putString("csa_colorText", str);
            return this;
        }

        public Builder setColorTitleLink(String str) {
            this.f2767b.putString("csa_colorTitleLink", str);
            return this;
        }

        public Builder setCssWidth(int i) {
            this.f2767b.putString("csa_width", Integer.toString(i));
            return this;
        }

        public Builder setDetailedAttribution(boolean z) {
            this.f2767b.putString("csa_detailedAttribution", Boolean.toString(z));
            return this;
        }

        @Deprecated
        public Builder setFontFamily(int i) {
            return setFontFamily(Integer.toString(i));
        }

        public Builder setFontFamily(String str) {
            this.f2767b.putString("csa_fontFamily", str);
            return this;
        }

        public Builder setFontFamilyAttribution(String str) {
            this.f2767b.putString("csa_fontFamilyAttribution", str);
            return this;
        }

        public Builder setFontSizeAnnotation(int i) {
            this.f2767b.putString("csa_fontSizeAnnotation", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeAttribution(int i) {
            this.f2767b.putString("csa_fontSizeAttribution", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeDescription(int i) {
            this.f2767b.putString("csa_fontSizeDescription", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeDomainLink(int i) {
            this.f2767b.putString("csa_fontSizeDomainLink", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeTitle(int i) {
            this.f2767b.putString("csa_fontSizeTitle", Integer.toString(i));
            return this;
        }

        public Builder setHostLanguage(String str) {
            this.f2767b.putString("csa_hl", str);
            return this;
        }

        public Builder setIsClickToCallEnabled(boolean z) {
            this.f2767b.putString("csa_clickToCall", Boolean.toString(z));
            return this;
        }

        public Builder setIsLocationEnabled(boolean z) {
            this.f2767b.putString("csa_location", Boolean.toString(z));
            return this;
        }

        public Builder setIsPlusOnesEnabled(boolean z) {
            this.f2767b.putString("csa_plusOnes", Boolean.toString(z));
            return this;
        }

        public Builder setIsSellerRatingsEnabled(boolean z) {
            this.f2767b.putString("csa_sellerRatings", Boolean.toString(z));
            return this;
        }

        public Builder setIsSiteLinksEnabled(boolean z) {
            this.f2767b.putString("csa_siteLinks", Boolean.toString(z));
            return this;
        }

        public Builder setIsTitleBold(boolean z) {
            this.f2767b.putString("csa_titleBold", Boolean.toString(z));
            return this;
        }

        public Builder setIsTitleUnderlined(boolean z) {
            this.f2767b.putString("csa_noTitleUnderline", Boolean.toString(!z));
            return this;
        }

        public Builder setLocationColor(String str) {
            this.f2767b.putString("csa_colorLocation", str);
            return this;
        }

        public Builder setLocationFontSize(int i) {
            this.f2767b.putString("csa_fontSizeLocation", Integer.toString(i));
            return this;
        }

        public Builder setLongerHeadlines(boolean z) {
            this.f2767b.putString("csa_longerHeadlines", Boolean.toString(z));
            return this;
        }

        public Builder setNumber(int i) {
            this.f2767b.putString("csa_number", Integer.toString(i));
            return this;
        }

        public Builder setPage(int i) {
            this.f2767b.putString("csa_adPage", Integer.toString(i));
            return this;
        }

        public Builder setQuery(String str) {
            this.f2766a.setQuery(str);
            return this;
        }

        public Builder setVerticalSpacing(int i) {
            this.f2767b.putString("csa_verticalSpacing", Integer.toString(i));
            return this;
        }
    }

    private DynamicHeightSearchAdRequest(Builder builder) {
        this.f2768a = builder.f2766a.build();
    }

    hi m4161a() {
        return this.f2768a.m4177a();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f2768a.getCustomEventExtrasBundle(cls);
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f2768a.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f2768a.getNetworkExtrasBundle(cls);
    }

    public String getQuery() {
        return this.f2768a.getQuery();
    }

    public boolean isTestDevice(Context context) {
        return this.f2768a.isTestDevice(context);
    }
}
