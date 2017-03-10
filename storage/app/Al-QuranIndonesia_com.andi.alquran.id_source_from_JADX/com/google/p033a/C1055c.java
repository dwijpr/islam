package com.google.p033a;

import java.lang.reflect.Field;
import java.util.Locale;

/* renamed from: com.google.a.c */
public enum C1055c implements C1054d {
    IDENTITY {
        public String m3764a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String m3765a(Field field) {
            return C1055c.m3762b(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String m3766a(Field field) {
            return C1055c.m3762b(C1055c.m3763b(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String m3767a(Field field) {
            return C1055c.m3763b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String m3768a(Field field) {
            return C1055c.m3763b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    private static String m3759a(char c, String str, int i) {
        return i < str.length() ? c + str.substring(i) : String.valueOf(c);
    }

    private static String m3762b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        char charAt = str.charAt(0);
        while (i < str.length() - 1 && !Character.isLetter(charAt)) {
            stringBuilder.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        return i == str.length() ? stringBuilder.toString() : !Character.isUpperCase(charAt) ? stringBuilder.append(C1055c.m3759a(Character.toUpperCase(charAt), str, i + 1)).toString() : str;
    }

    private static String m3763b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && stringBuilder.length() != 0) {
                stringBuilder.append(str2);
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }
}
