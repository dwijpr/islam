package com.google.android.gms.internal;

import java.io.IOException;

public class ef extends IOException {
    public ef(String str) {
        super(str);
    }

    static ef m5906a() {
        return new ef("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static ef m5907b() {
        return new ef("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static ef m5908c() {
        return new ef("CodedInputStream encountered a malformed varint.");
    }

    static ef m5909d() {
        return new ef("Protocol message contained an invalid tag (zero).");
    }

    static ef m5910e() {
        return new ef("Protocol message end-group tag did not match expected tag.");
    }

    static ef m5911f() {
        return new ef("Protocol message tag had invalid wire type.");
    }

    static ef m5912g() {
        return new ef("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
