package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@op
public abstract class il {
    @op
    public static final il f4409a;
    @op
    public static final il f4410b;
    @op
    public static final il f4411c;

    /* renamed from: com.google.android.gms.internal.il.1 */
    class C16501 extends il {
        C16501() {
        }

        public String m6730a(String str, String str2) {
            return str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.il.2 */
    class C16512 extends il {
        C16512() {
        }

        public String m6731a(String str, String str2) {
            return str != null ? str : str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.il.3 */
    class C16523 extends il {
        C16523() {
        }

        private String m6732a(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String m6733a(String str, String str2) {
            String a = m6732a(str);
            String a2 = m6732a(str2);
            return TextUtils.isEmpty(a) ? a2 : TextUtils.isEmpty(a2) ? a : new StringBuilder((String.valueOf(a).length() + 1) + String.valueOf(a2).length()).append(a).append(",").append(a2).toString();
        }
    }

    static {
        f4409a = new C16501();
        f4410b = new C16512();
        f4411c = new C16523();
    }

    public abstract String m6728a(String str, String str2);

    public final void m6729a(Map<String, String> map, String str, String str2) {
        map.put(str, m6728a((String) map.get(str), str2));
    }
}
