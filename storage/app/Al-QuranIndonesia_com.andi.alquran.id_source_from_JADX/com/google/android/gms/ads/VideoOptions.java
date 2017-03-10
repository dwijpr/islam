package com.google.android.gms.ads;

import com.google.android.gms.internal.op;

@op
public final class VideoOptions {
    private final boolean f2324a;

    public static final class Builder {
        private boolean f2323a;

        public Builder() {
            this.f2323a = false;
        }

        public VideoOptions build() {
            return new VideoOptions();
        }

        public Builder setStartMuted(boolean z) {
            this.f2323a = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.f2324a = builder.f2323a;
    }

    public boolean getStartMuted() {
        return this.f2324a;
    }
}
