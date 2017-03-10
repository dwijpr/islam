package android.support.v4.p013f;

import android.support.v7.recyclerview.BuildConfig;
import android.text.SpannableStringBuilder;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.Locale;

/* renamed from: android.support.v4.f.a */
public final class C0275a {
    private static C0283e f590a;
    private static final String f591b;
    private static final String f592c;
    private static final C0275a f593d;
    private static final C0275a f594e;
    private final boolean f595f;
    private final int f596g;
    private final C0283e f597h;

    /* renamed from: android.support.v4.f.a.a */
    public static final class C0273a {
        private boolean f581a;
        private int f582b;
        private C0283e f583c;

        public C0273a() {
            m916a(C0275a.m933b(Locale.getDefault()));
        }

        private void m916a(boolean z) {
            this.f581a = z;
            this.f583c = C0275a.f590a;
            this.f582b = 2;
        }

        private static C0275a m917b(boolean z) {
            return z ? C0275a.f594e : C0275a.f593d;
        }

        public C0275a m918a() {
            return (this.f582b == 2 && this.f583c == C0275a.f590a) ? C0273a.m917b(this.f581a) : new C0275a(this.f582b, this.f583c, null);
        }
    }

    /* renamed from: android.support.v4.f.a.b */
    private static class C0274b {
        private static final byte[] f584a;
        private final CharSequence f585b;
        private final boolean f586c;
        private final int f587d;
        private int f588e;
        private char f589f;

        static {
            f584a = new byte[1792];
            for (int i = 0; i < 1792; i++) {
                f584a[i] = Character.getDirectionality(i);
            }
        }

        C0274b(CharSequence charSequence, boolean z) {
            this.f585b = charSequence;
            this.f586c = z;
            this.f587d = charSequence.length();
        }

        private static byte m919a(char c) {
            return c < '\u0700' ? f584a[c] : Character.getDirectionality(c);
        }

        private byte m920e() {
            int i = this.f588e;
            while (this.f588e < this.f587d) {
                CharSequence charSequence = this.f585b;
                int i2 = this.f588e;
                this.f588e = i2 + 1;
                this.f589f = charSequence.charAt(i2);
                if (this.f589f == '>') {
                    return (byte) 12;
                }
                if (this.f589f == '\"' || this.f589f == '\'') {
                    char c = this.f589f;
                    while (this.f588e < this.f587d) {
                        CharSequence charSequence2 = this.f585b;
                        int i3 = this.f588e;
                        this.f588e = i3 + 1;
                        char charAt = charSequence2.charAt(i3);
                        this.f589f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f588e = i;
            this.f589f = '<';
            return (byte) 13;
        }

        private byte m921f() {
            int i = this.f588e;
            while (this.f588e > 0) {
                CharSequence charSequence = this.f585b;
                int i2 = this.f588e - 1;
                this.f588e = i2;
                this.f589f = charSequence.charAt(i2);
                if (this.f589f == '<') {
                    return (byte) 12;
                }
                if (this.f589f == '>') {
                    break;
                } else if (this.f589f == '\"' || this.f589f == '\'') {
                    char c = this.f589f;
                    while (this.f588e > 0) {
                        CharSequence charSequence2 = this.f585b;
                        int i3 = this.f588e - 1;
                        this.f588e = i3;
                        char charAt = charSequence2.charAt(i3);
                        this.f589f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f588e = i;
            this.f589f = '>';
            return (byte) 13;
        }

        private byte m922g() {
            while (this.f588e < this.f587d) {
                CharSequence charSequence = this.f585b;
                int i = this.f588e;
                this.f588e = i + 1;
                char charAt = charSequence.charAt(i);
                this.f589f = charAt;
                if (charAt == ';') {
                    break;
                }
            }
            return (byte) 12;
        }

        private byte m923h() {
            int i = this.f588e;
            while (this.f588e > 0) {
                CharSequence charSequence = this.f585b;
                int i2 = this.f588e - 1;
                this.f588e = i2;
                this.f589f = charSequence.charAt(i2);
                if (this.f589f != '&') {
                    if (this.f589f == ';') {
                        break;
                    }
                }
                return (byte) 12;
            }
            this.f588e = i;
            this.f589f = ';';
            return (byte) 13;
        }

        int m924a() {
            this.f588e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f588e < this.f587d && i == 0) {
                switch (m926c()) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        }
                        return -1;
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        }
                        return 1;
                    case C1096c.MapAttrs_uiScrollGestures /*9*/:
                        break;
                    case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    case C1096c.MapAttrs_uiMapToolbar /*15*/:
                        i3++;
                        i2 = -1;
                        break;
                    case C1096c.MapAttrs_ambientEnabled /*16*/:
                    case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                        i3++;
                        i2 = 1;
                        break;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        i3--;
                        i2 = 0;
                        break;
                    default:
                        i = i3;
                        break;
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f588e > 0) {
                switch (m927d()) {
                    case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    case C1096c.MapAttrs_uiMapToolbar /*15*/:
                        if (i != i3) {
                            i3--;
                            break;
                        }
                        return -1;
                    case C1096c.MapAttrs_ambientEnabled /*16*/:
                    case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                        if (i != i3) {
                            i3--;
                            break;
                        }
                        return 1;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        i3++;
                        break;
                    default:
                        break;
                }
            }
            return 0;
        }

        int m925b() {
            this.f588e = this.f587d;
            int i = 0;
            int i2 = 0;
            while (this.f588e > 0) {
                switch (m927d()) {
                    case GoogleMap.MAP_TYPE_NONE /*0*/:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            }
                            i = i2;
                            break;
                        }
                        return -1;
                    case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            }
                            i = i2;
                            break;
                        }
                        return 1;
                    case C1096c.MapAttrs_uiScrollGestures /*9*/:
                        break;
                    case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    case C1096c.MapAttrs_uiMapToolbar /*15*/:
                        if (i != i2) {
                            i2--;
                            break;
                        }
                        return -1;
                    case C1096c.MapAttrs_ambientEnabled /*16*/:
                    case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                        if (i != i2) {
                            i2--;
                            break;
                        }
                        return 1;
                    case C1096c.MapAttrs_cameraMaxZoomPreference /*18*/:
                        i2++;
                        break;
                    default:
                        if (i != 0) {
                            break;
                        }
                        i = i2;
                        break;
                }
            }
            return 0;
        }

        byte m926c() {
            this.f589f = this.f585b.charAt(this.f588e);
            if (Character.isHighSurrogate(this.f589f)) {
                int codePointAt = Character.codePointAt(this.f585b, this.f588e);
                this.f588e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f588e++;
            byte a = C0274b.m919a(this.f589f);
            return this.f586c ? this.f589f == '<' ? m920e() : this.f589f == '&' ? m922g() : a : a;
        }

        byte m927d() {
            this.f589f = this.f585b.charAt(this.f588e - 1);
            if (Character.isLowSurrogate(this.f589f)) {
                int codePointBefore = Character.codePointBefore(this.f585b, this.f588e);
                this.f588e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f588e--;
            byte a = C0274b.m919a(this.f589f);
            return this.f586c ? this.f589f == '>' ? m921f() : this.f589f == ';' ? m923h() : a : a;
        }
    }

    static {
        f590a = C0290f.f611c;
        f591b = Character.toString('\u200e');
        f592c = Character.toString('\u200f');
        f593d = new C0275a(false, 2, f590a);
        f594e = new C0275a(true, 2, f590a);
    }

    private C0275a(boolean z, int i, C0283e c0283e) {
        this.f595f = z;
        this.f596g = i;
        this.f597h = c0283e;
    }

    public static C0275a m928a() {
        return new C0273a().m918a();
    }

    private String m929a(CharSequence charSequence, C0283e c0283e) {
        boolean a = c0283e.m950a(charSequence, 0, charSequence.length());
        return (this.f595f || !(a || C0275a.m931b(charSequence) == 1)) ? (!this.f595f || (a && C0275a.m931b(charSequence) != -1)) ? BuildConfig.VERSION_NAME : f592c : f591b;
    }

    private static int m931b(CharSequence charSequence) {
        return new C0274b(charSequence, false).m925b();
    }

    private String m932b(CharSequence charSequence, C0283e c0283e) {
        boolean a = c0283e.m950a(charSequence, 0, charSequence.length());
        return (this.f595f || !(a || C0275a.m934c(charSequence) == 1)) ? (!this.f595f || (a && C0275a.m934c(charSequence) != -1)) ? BuildConfig.VERSION_NAME : f592c : f591b;
    }

    private static boolean m933b(Locale locale) {
        return C0293g.m964a(locale) == 1;
    }

    private static int m934c(CharSequence charSequence) {
        return new C0274b(charSequence, false).m924a();
    }

    public CharSequence m938a(CharSequence charSequence) {
        return m939a(charSequence, this.f597h, true);
    }

    public CharSequence m939a(CharSequence charSequence, C0283e c0283e, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a = c0283e.m950a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (m940b() && z) {
            spannableStringBuilder.append(m932b(charSequence, a ? C0290f.f610b : C0290f.f609a));
        }
        if (a != this.f595f) {
            spannableStringBuilder.append(a ? '\u202b' : '\u202a');
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append('\u202c');
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(m929a(charSequence, a ? C0290f.f610b : C0290f.f609a));
        }
        return spannableStringBuilder;
    }

    public boolean m940b() {
        return (this.f596g & 2) != 0;
    }
}
