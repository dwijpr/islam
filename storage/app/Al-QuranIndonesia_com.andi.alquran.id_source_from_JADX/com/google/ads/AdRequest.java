package com.google.ads;

@Deprecated
public final class AdRequest {
    public static final String LOGTAG = "Ads";
    public static final String TEST_EMULATOR;
    public static final String VERSION = "0.0.0";

    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String f2238a;

        private ErrorCode(String str) {
            this.f2238a = str;
        }

        public String toString() {
            return this.f2238a;
        }
    }

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    static {
        TEST_EMULATOR = com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;
    }

    private AdRequest() {
    }
}
