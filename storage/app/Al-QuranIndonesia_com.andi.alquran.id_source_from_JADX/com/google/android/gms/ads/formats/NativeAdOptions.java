package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.op;

@op
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean f2334a;
    private final int f2335b;
    private final boolean f2336c;
    private final int f2337d;
    private final VideoOptions f2338e;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        private boolean f2329a;
        private int f2330b;
        private boolean f2331c;
        private VideoOptions f2332d;
        private int f2333e;

        public Builder() {
            this.f2329a = false;
            this.f2330b = NativeAdOptions.ORIENTATION_ANY;
            this.f2331c = false;
            this.f2333e = NativeAdOptions.ORIENTATION_PORTRAIT;
        }

        public NativeAdOptions build() {
            return new NativeAdOptions();
        }

        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.f2333e = i;
            return this;
        }

        public Builder setImageOrientation(int i) {
            this.f2330b = i;
            return this;
        }

        public Builder setRequestMultipleImages(boolean z) {
            this.f2331c = z;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.f2329a = z;
            return this;
        }

        public Builder setVideoOptions(VideoOptions videoOptions) {
            this.f2332d = videoOptions;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.f2334a = builder.f2329a;
        this.f2335b = builder.f2330b;
        this.f2336c = builder.f2331c;
        this.f2337d = builder.f2333e;
        this.f2338e = builder.f2332d;
    }

    public int getAdChoicesPlacement() {
        return this.f2337d;
    }

    public int getImageOrientation() {
        return this.f2335b;
    }

    public VideoOptions getVideoOptions() {
        return this.f2338e;
    }

    public boolean shouldRequestMultipleImages() {
        return this.f2336c;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.f2334a;
    }
}
