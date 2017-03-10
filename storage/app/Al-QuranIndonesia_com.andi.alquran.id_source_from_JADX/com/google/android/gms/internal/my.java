package com.google.android.gms.internal;

import org.json.JSONObject;

@op
public class my {
    private final boolean f5050a;
    private final boolean f5051b;
    private final boolean f5052c;
    private final boolean f5053d;
    private final boolean f5054e;

    /* renamed from: com.google.android.gms.internal.my.a */
    public static final class C1827a {
        private boolean f5045a;
        private boolean f5046b;
        private boolean f5047c;
        private boolean f5048d;
        private boolean f5049e;

        public C1827a m7720a(boolean z) {
            this.f5045a = z;
            return this;
        }

        public my m7721a() {
            return new my();
        }

        public C1827a m7722b(boolean z) {
            this.f5046b = z;
            return this;
        }

        public C1827a m7723c(boolean z) {
            this.f5047c = z;
            return this;
        }

        public C1827a m7724d(boolean z) {
            this.f5048d = z;
            return this;
        }

        public C1827a m7725e(boolean z) {
            this.f5049e = z;
            return this;
        }
    }

    private my(C1827a c1827a) {
        this.f5050a = c1827a.f5045a;
        this.f5051b = c1827a.f5046b;
        this.f5052c = c1827a.f5047c;
        this.f5053d = c1827a.f5048d;
        this.f5054e = c1827a.f5049e;
    }

    public JSONObject m7726a() {
        try {
            return new JSONObject().put("sms", this.f5050a).put("tel", this.f5051b).put("calendar", this.f5052c).put("storePicture", this.f5053d).put("inlineVideo", this.f5054e);
        } catch (Throwable e) {
            sg.m8445b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
