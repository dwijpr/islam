package com.google.android.gms.common.util;

import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.common.util.o */
public class C1389o {
    private static final Pattern f3234a;

    static {
        f3234a = Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean m4973a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
