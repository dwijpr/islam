package com.google.p033a.p037d;

import com.andi.alquran.C0861R;
import com.google.ads.AdSize;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import com.google.p033a.p035b.C1033e;
import com.google.p033a.p035b.p036a.C0985e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* renamed from: com.google.a.d.a */
public class C0984a implements Closeable {
    private static final char[] f1989a;
    private final Reader f1990b;
    private boolean f1991c;
    private final char[] f1992d;
    private int f1993e;
    private int f1994f;
    private int f1995g;
    private int f1996h;
    private int f1997i;
    private long f1998j;
    private int f1999k;
    private String f2000l;
    private int[] f2001m;
    private int f2002n;
    private String[] f2003o;
    private int[] f2004p;

    /* renamed from: com.google.a.d.a.1 */
    static class C10621 extends C1033e {
        C10621() {
        }

        public void m3774a(C0984a c0984a) {
            if (c0984a instanceof C0985e) {
                ((C0985e) c0984a).m3481o();
                return;
            }
            int a = c0984a.f1997i;
            if (a == 0) {
                a = c0984a.m3437o();
            }
            if (a == 13) {
                c0984a.f1997i = 9;
            } else if (a == 12) {
                c0984a.f1997i = 8;
            } else if (a == 14) {
                c0984a.f1997i = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + c0984a.m3453f() + " " + " at line " + c0984a.m3442v() + " column " + c0984a.m3443w() + " path " + c0984a.m3463q());
            }
        }
    }

    static {
        f1989a = ")]}'\n".toCharArray();
        C1033e.f2155a = new C10621();
    }

    public C0984a(Reader reader) {
        this.f1991c = false;
        this.f1992d = new char[1024];
        this.f1993e = 0;
        this.f1994f = 0;
        this.f1995g = 0;
        this.f1996h = 0;
        this.f1997i = 0;
        this.f2001m = new int[32];
        this.f2002n = 0;
        int[] iArr = this.f2001m;
        int i = this.f2002n;
        this.f2002n = i + 1;
        iArr[i] = 6;
        this.f2003o = new String[32];
        this.f2004p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f1990b = reader;
    }

    private void m3423A() {
        m3430b(true);
        this.f1993e--;
        if (this.f1993e + f1989a.length <= this.f1994f || m3433b(f1989a.length)) {
            int i = 0;
            while (i < f1989a.length) {
                if (this.f1992d[this.f1993e + i] == f1989a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f1993e += f1989a.length;
        }
    }

    private void m3426a(int i) {
        if (this.f2002n == this.f2001m.length) {
            Object obj = new int[(this.f2002n * 2)];
            Object obj2 = new int[(this.f2002n * 2)];
            Object obj3 = new String[(this.f2002n * 2)];
            System.arraycopy(this.f2001m, 0, obj, 0, this.f2002n);
            System.arraycopy(this.f2004p, 0, obj2, 0, this.f2002n);
            System.arraycopy(this.f2003o, 0, obj3, 0, this.f2002n);
            this.f2001m = obj;
            this.f2004p = obj2;
            this.f2003o = obj3;
        }
        int[] iArr = this.f2001m;
        int i2 = this.f2002n;
        this.f2002n = i2 + 1;
        iArr[i2] = i;
    }

    private boolean m3427a(char c) {
        switch (c) {
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
            case C1096c.MapAttrs_uiTiltGestures /*10*/:
            case C1096c.MapAttrs_uiZoomGestures /*12*/:
            case C1096c.MapAttrs_useViewLifecycle /*13*/:
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
            case C0861R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
            case C0861R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
            case C0861R.styleable.AppCompatTheme_controlBackground /*91*/:
            case C0861R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
            case '{':
            case '}':
                break;
            case C0861R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
            case C0861R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
            case C0861R.styleable.AppCompatTheme_toolbarStyle /*59*/:
            case C0861R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
            case C0861R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                m3444x();
                break;
            default:
                return true;
        }
        return false;
    }

    private boolean m3428a(String str) {
        while (true) {
            if (this.f1993e + str.length() > this.f1994f && !m3433b(str.length())) {
                return false;
            }
            if (this.f1992d[this.f1993e] == '\n') {
                this.f1995g++;
                this.f1996h = this.f1993e + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.f1992d[this.f1993e + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f1993e++;
        }
    }

    private int m3430b(boolean z) {
        char[] cArr = this.f1992d;
        int i = this.f1993e;
        int i2 = this.f1994f;
        while (true) {
            if (i == i2) {
                this.f1993e = i;
                if (m3433b(1)) {
                    i = this.f1993e;
                    i2 = this.f1994f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + m3442v() + " column " + m3443w());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f1995g++;
                this.f1996h = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.f1993e = i3;
                if (i3 == i2) {
                    this.f1993e--;
                    boolean b = m3433b(2);
                    this.f1993e++;
                    if (!b) {
                        return c;
                    }
                }
                m3444x();
                switch (cArr[this.f1993e]) {
                    case C0861R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.f1993e++;
                        if (m3428a("*/")) {
                            i = this.f1993e + 2;
                            i2 = this.f1994f;
                            break;
                        }
                        throw m3431b("Unterminated comment");
                    case C0861R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                        this.f1993e++;
                        m3445y();
                        i = this.f1993e;
                        i2 = this.f1994f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f1993e = i3;
                m3444x();
                m3445y();
                i = this.f1993e;
                i2 = this.f1994f;
            } else {
                this.f1993e = i3;
                return c;
            }
        }
    }

    private IOException m3431b(String str) {
        throw new C1064d(str + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
    }

    private String m3432b(char c) {
        char[] cArr = this.f1992d;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.f1993e;
            int i2 = this.f1994f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f1993e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.f1993e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(m3446z());
                    i = this.f1993e;
                    i2 = this.f1994f;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.f1995g++;
                    this.f1996h = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.f1993e = i3;
        } while (m3433b(1));
        throw m3431b("Unterminated string");
    }

    private boolean m3433b(int i) {
        Object obj = this.f1992d;
        this.f1996h -= this.f1993e;
        if (this.f1994f != this.f1993e) {
            this.f1994f -= this.f1993e;
            System.arraycopy(obj, this.f1993e, obj, 0, this.f1994f);
        } else {
            this.f1994f = 0;
        }
        this.f1993e = 0;
        do {
            int read = this.f1990b.read(obj, this.f1994f, obj.length - this.f1994f);
            if (read == -1) {
                return false;
            }
            this.f1994f = read + this.f1994f;
            if (this.f1995g == 0 && this.f1996h == 0 && this.f1994f > 0 && obj[0] == '\ufeff') {
                this.f1993e++;
                this.f1996h++;
                i++;
            }
        } while (this.f1994f < i);
        return true;
    }

    private void m3435c(char c) {
        char[] cArr = this.f1992d;
        do {
            int i = this.f1993e;
            int i2 = this.f1994f;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f1993e = i;
                    return;
                }
                if (c2 == '\\') {
                    this.f1993e = i;
                    m3446z();
                    i = this.f1993e;
                    i2 = this.f1994f;
                } else if (c2 == '\n') {
                    this.f1995g++;
                    this.f1996h = i;
                }
                i3 = i;
            }
            this.f1993e = i3;
        } while (m3433b(1));
        throw m3431b("Unterminated string");
    }

    private int m3437o() {
        int b;
        int i = this.f2001m[this.f2002n - 1];
        if (i == 1) {
            this.f2001m[this.f2002n - 1] = 2;
        } else if (i == 2) {
            switch (m3430b(true)) {
                case C0861R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    break;
                case C0861R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    m3444x();
                    break;
                case C0861R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    this.f1997i = 4;
                    return 4;
                default:
                    throw m3431b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f2001m[this.f2002n - 1] = 4;
            if (i == 5) {
                switch (m3430b(true)) {
                    case C0861R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                        break;
                    case C0861R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                        m3444x();
                        break;
                    case 125:
                        this.f1997i = 2;
                        return 2;
                    default:
                        throw m3431b("Unterminated object");
                }
            }
            b = m3430b(true);
            switch (b) {
                case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.f1997i = 13;
                    return 13;
                case C0861R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    m3444x();
                    this.f1997i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f1997i = 2;
                        return 2;
                    }
                    throw m3431b("Expected name");
                default:
                    m3444x();
                    this.f1993e--;
                    if (m3427a((char) b)) {
                        this.f1997i = 14;
                        return 14;
                    }
                    throw m3431b("Expected name");
            }
        } else if (i == 4) {
            this.f2001m[this.f2002n - 1] = 5;
            switch (m3430b(true)) {
                case C0861R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    break;
                case C0861R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    m3444x();
                    if ((this.f1993e < this.f1994f || m3433b(1)) && this.f1992d[this.f1993e] == '>') {
                        this.f1993e++;
                        break;
                    }
                default:
                    throw m3431b("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f1991c) {
                m3423A();
            }
            this.f2001m[this.f2002n - 1] = 7;
        } else if (i == 7) {
            if (m3430b(false) == -1) {
                this.f1997i = 17;
                return 17;
            }
            m3444x();
            this.f1993e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m3430b(true)) {
            case C0861R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                if (this.f2002n == 1) {
                    m3444x();
                }
                this.f1997i = 9;
                return 9;
            case C0861R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                m3444x();
                this.f1997i = 8;
                return 8;
            case C0861R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
            case C0861R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                break;
            case C0861R.styleable.AppCompatTheme_controlBackground /*91*/:
                this.f1997i = 3;
                return 3;
            case C0861R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                if (i == 1) {
                    this.f1997i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f1997i = 1;
                return 1;
            default:
                this.f1993e--;
                if (this.f2002n == 1) {
                    m3444x();
                }
                b = m3438r();
                if (b != 0) {
                    return b;
                }
                b = m3439s();
                if (b != 0) {
                    return b;
                }
                if (m3427a(this.f1992d[this.f1993e])) {
                    m3444x();
                    this.f1997i = 10;
                    return 10;
                }
                throw m3431b("Expected value");
        }
        if (i == 1 || i == 2) {
            m3444x();
            this.f1993e--;
            this.f1997i = 7;
            return 7;
        }
        throw m3431b("Unexpected value");
    }

    private int m3438r() {
        String str;
        int i;
        char c = this.f1992d[this.f1993e];
        String str2;
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.f1993e + i2 >= this.f1994f && !m3433b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f1992d[this.f1993e + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.f1993e + length < this.f1994f || m3433b(length + 1)) && m3427a(this.f1992d[this.f1993e + length])) {
            return 0;
        }
        this.f1993e += length;
        this.f1997i = i;
        return i;
    }

    private int m3439s() {
        char[] cArr = this.f1992d;
        int i = this.f1993e;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1994f;
        int i6 = i;
        while (true) {
            Object obj2;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (m3433b(i4 + 1)) {
                    i6 = this.f1993e;
                    i5 = this.f1994f;
                } else if (i3 != 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.f1998j = j;
                    this.f1993e += i4;
                    this.f1997i = 15;
                    return 15;
                } else if (i3 == 2 && i3 != 4 && i3 != 7) {
                    return 0;
                } else {
                    this.f1999k = i4;
                    this.f1997i = 16;
                    return 16;
                }
            }
            char c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case C0861R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case C0861R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case C0861R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case C0861R.styleable.AppCompatTheme_searchViewStyle /*69*/:
                case C0861R.styleable.AppCompatTheme_autoCompleteTextViewStyle /*101*/:
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else if (m3427a(c)) {
                        return 0;
                    }
                    break;
            }
            if (i3 != 2) {
            }
            if (i3 == 2) {
            }
            this.f1999k = i4;
            this.f1997i = 16;
            return 16;
            i4++;
            obj = obj2;
            i2 = i3;
            i3 = i;
        }
    }

    private String m3440t() {
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            String str;
            if (this.f1993e + i < this.f1994f) {
                switch (this.f1992d[this.f1993e + i]) {
                    case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    case C0861R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    case C0861R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    case C0861R.styleable.AppCompatTheme_controlBackground /*91*/:
                    case C0861R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    case '{':
                    case '}':
                        break;
                    case C0861R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case C0861R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    case C0861R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    case C0861R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    case C0861R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                        m3444x();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f1992d.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.f1992d, this.f1993e, i);
                this.f1993e = i + this.f1993e;
                i = !m3433b(1) ? 0 : 0;
            } else if (m3433b(i + 1)) {
            }
            if (stringBuilder == null) {
                str = new String(this.f1992d, this.f1993e, i);
            } else {
                stringBuilder.append(this.f1992d, this.f1993e, i);
                str = stringBuilder.toString();
            }
            this.f1993e = i + this.f1993e;
            return str;
        }
    }

    private void m3441u() {
        do {
            int i = 0;
            while (this.f1993e + i < this.f1994f) {
                switch (this.f1992d[this.f1993e + i]) {
                    case C1096c.MapAttrs_uiScrollGestures /*9*/:
                    case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    case C1096c.MapAttrs_uiZoomGestures /*12*/:
                    case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    case C0861R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    case C0861R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    case C0861R.styleable.AppCompatTheme_controlBackground /*91*/:
                    case C0861R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    case '{':
                    case '}':
                        break;
                    case C0861R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case C0861R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    case C0861R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    case C0861R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    case C0861R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                        m3444x();
                        break;
                    default:
                        i++;
                }
                this.f1993e = i + this.f1993e;
                return;
            }
            this.f1993e = i + this.f1993e;
        } while (m3433b(1));
    }

    private int m3442v() {
        return this.f1995g + 1;
    }

    private int m3443w() {
        return (this.f1993e - this.f1996h) + 1;
    }

    private void m3444x() {
        if (!this.f1991c) {
            throw m3431b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m3445y() {
        char c;
        do {
            if (this.f1993e < this.f1994f || m3433b(1)) {
                char[] cArr = this.f1992d;
                int i = this.f1993e;
                this.f1993e = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.f1995g++;
                    this.f1996h = this.f1993e;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private char m3446z() {
        if (this.f1993e != this.f1994f || m3433b(1)) {
            char[] cArr = this.f1992d;
            int i = this.f1993e;
            this.f1993e = i + 1;
            char c = cArr[i];
            switch (c) {
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    this.f1995g++;
                    this.f1996h = this.f1993e;
                    return c;
                case C0861R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                    return '\b';
                case C0861R.styleable.AppCompatTheme_buttonStyle /*102*/:
                    return '\f';
                case C0861R.styleable.AppCompatTheme_ratingBarStyleSmall /*110*/:
                    return '\n';
                case C0861R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.f1993e + 4 <= this.f1994f || m3433b(4)) {
                        int i2 = this.f1993e;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i++) {
                            char c2 = this.f1992d[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f1992d, this.f1993e, 4));
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                        }
                        this.f1993e += 4;
                        return c;
                    }
                    throw m3431b("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw m3431b("Unterminated escape sequence");
    }

    public void m3447a() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 3) {
            m3426a(1);
            this.f2004p[this.f2002n - 1] = 0;
            this.f1997i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
    }

    public final void m3448a(boolean z) {
        this.f1991c = z;
    }

    public void m3449b() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 4) {
            this.f2002n--;
            int[] iArr = this.f2004p;
            int i2 = this.f2002n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f1997i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
    }

    public void m3450c() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 1) {
            m3426a(3);
            this.f1997i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
    }

    public void close() {
        this.f1997i = 0;
        this.f2001m[0] = 8;
        this.f2002n = 1;
        this.f1990b.close();
    }

    public void m3451d() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 2) {
            this.f2002n--;
            this.f2003o[this.f2002n] = null;
            int[] iArr = this.f2004p;
            int i2 = this.f2002n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f1997i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
    }

    public boolean m3452e() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public C1063b m3453f() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return C1063b.BEGIN_OBJECT;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return C1063b.END_OBJECT;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return C1063b.BEGIN_ARRAY;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return C1063b.END_ARRAY;
            case C1096c.MapAttrs_cameraZoom /*5*/:
            case C1096c.MapAttrs_liteMode /*6*/:
                return C1063b.BOOLEAN;
            case C1096c.MapAttrs_uiCompass /*7*/:
                return C1063b.NULL;
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
            case C1096c.MapAttrs_uiTiltGestures /*10*/:
            case C1096c.MapAttrs_uiZoomControls /*11*/:
                return C1063b.STRING;
            case C1096c.MapAttrs_uiZoomGestures /*12*/:
            case C1096c.MapAttrs_useViewLifecycle /*13*/:
            case C1096c.MapAttrs_zOrderOnTop /*14*/:
                return C1063b.NAME;
            case C1096c.MapAttrs_uiMapToolbar /*15*/:
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                return C1063b.NUMBER;
            case C1096c.MapAttrs_cameraMinZoomPreference /*17*/:
                return C1063b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String m3454g() {
        String t;
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 14) {
            t = m3440t();
        } else if (i == 12) {
            t = m3432b('\'');
        } else if (i == 13) {
            t = m3432b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
        }
        this.f1997i = 0;
        this.f2003o[this.f2002n - 1] = t;
        return t;
    }

    public String m3455h() {
        String t;
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 10) {
            t = m3440t();
        } else if (i == 8) {
            t = m3432b('\'');
        } else if (i == 9) {
            t = m3432b('\"');
        } else if (i == 11) {
            t = this.f2000l;
            this.f2000l = null;
        } else if (i == 15) {
            t = Long.toString(this.f1998j);
        } else if (i == 16) {
            t = new String(this.f1992d, this.f1993e, this.f1999k);
            this.f1993e += this.f1999k;
        } else {
            throw new IllegalStateException("Expected a string but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
        }
        this.f1997i = 0;
        int[] iArr = this.f2004p;
        int i2 = this.f2002n - 1;
        iArr[i2] = iArr[i2] + 1;
        return t;
    }

    public boolean m3456i() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 5) {
            this.f1997i = 0;
            int[] iArr = this.f2004p;
            i = this.f2002n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.f1997i = 0;
            int[] iArr2 = this.f2004p;
            int i2 = this.f2002n - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
        }
    }

    public void m3457j() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 7) {
            this.f1997i = 0;
            int[] iArr = this.f2004p;
            int i2 = this.f2002n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
    }

    public double m3458k() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 15) {
            this.f1997i = 0;
            int[] iArr = this.f2004p;
            int i2 = this.f2002n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f1998j;
        }
        if (i == 16) {
            this.f2000l = new String(this.f1992d, this.f1993e, this.f1999k);
            this.f1993e += this.f1999k;
        } else if (i == 8 || i == 9) {
            this.f2000l = m3432b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f2000l = m3440t();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
        }
        this.f1997i = 11;
        double parseDouble = Double.parseDouble(this.f2000l);
        if (this.f1991c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.f2000l = null;
            this.f1997i = 0;
            int[] iArr2 = this.f2004p;
            int i3 = this.f2002n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new C1064d("JSON forbids NaN and infinities: " + parseDouble + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
    }

    public long m3459l() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        if (i == 15) {
            this.f1997i = 0;
            int[] iArr = this.f2004p;
            int i2 = this.f2002n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f1998j;
        }
        long parseLong;
        if (i == 16) {
            this.f2000l = new String(this.f1992d, this.f1993e, this.f1999k);
            this.f1993e += this.f1999k;
        } else if (i == 8 || i == 9) {
            this.f2000l = m3432b(i == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.f2000l);
                this.f1997i = 0;
                int[] iArr2 = this.f2004p;
                int i3 = this.f2002n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
        }
        this.f1997i = 11;
        double parseDouble = Double.parseDouble(this.f2000l);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f2000l + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
        }
        this.f2000l = null;
        this.f1997i = 0;
        iArr2 = this.f2004p;
        i3 = this.f2002n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    public int m3460m() {
        int i = this.f1997i;
        if (i == 0) {
            i = m3437o();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.f1998j;
            if (this.f1998j != ((long) i)) {
                throw new NumberFormatException("Expected an int but was " + this.f1998j + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
            }
            this.f1997i = 0;
            iArr = this.f2004p;
            i2 = this.f2002n - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            if (i == 16) {
                this.f2000l = new String(this.f1992d, this.f1993e, this.f1999k);
                this.f1993e += this.f1999k;
            } else if (i == 8 || i == 9) {
                this.f2000l = m3432b(i == 8 ? '\'' : '\"');
                try {
                    i = Integer.parseInt(this.f2000l);
                    this.f1997i = 0;
                    iArr = this.f2004p;
                    i2 = this.f2002n - 1;
                    iArr[i2] = iArr[i2] + 1;
                } catch (NumberFormatException e) {
                }
            } else {
                throw new IllegalStateException("Expected an int but was " + m3453f() + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
            }
            this.f1997i = 11;
            double parseDouble = Double.parseDouble(this.f2000l);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                throw new NumberFormatException("Expected an int but was " + this.f2000l + " at line " + m3442v() + " column " + m3443w() + " path " + m3463q());
            }
            this.f2000l = null;
            this.f1997i = 0;
            iArr = this.f2004p;
            i2 = this.f2002n - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return i;
    }

    public void m3461n() {
        int i = 0;
        do {
            int i2 = this.f1997i;
            if (i2 == 0) {
                i2 = m3437o();
            }
            if (i2 == 3) {
                m3426a(1);
                i++;
            } else if (i2 == 1) {
                m3426a(3);
                i++;
            } else if (i2 == 4) {
                this.f2002n--;
                i--;
            } else if (i2 == 2) {
                this.f2002n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m3441u();
            } else if (i2 == 8 || i2 == 12) {
                m3435c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m3435c('\"');
            } else if (i2 == 16) {
                this.f1993e += this.f1999k;
            }
            this.f1997i = 0;
        } while (i != 0);
        int[] iArr = this.f2004p;
        int i3 = this.f2002n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f2003o[this.f2002n - 1] = "null";
    }

    public final boolean m3462p() {
        return this.f1991c;
    }

    public String m3463q() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.f2002n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f2001m[i2]) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    append.append('[').append(this.f2004p[i2]).append(']');
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    append.append('.');
                    if (this.f2003o[i2] == null) {
                        break;
                    }
                    append.append(this.f2003o[i2]);
                    break;
                default:
                    break;
            }
        }
        return append.toString();
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + m3442v() + " column " + m3443w();
    }
}
