package com.google.android.gms.internal;

import com.google.android.gms.common.util.C1386l;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

@op
public class fs {
    public static int m6230a(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        return C1386l.m4958a(bytes, 0, bytes.length, 0);
    }

    static boolean m6231a(int i) {
        return Character.isLetter(i) && (m6232a(UnicodeBlock.of(i)) || m6236c(i));
    }

    private static boolean m6232a(UnicodeBlock unicodeBlock) {
        return unicodeBlock == UnicodeBlock.BOPOMOFO || unicodeBlock == UnicodeBlock.BOPOMOFO_EXTENDED || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlock == UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || unicodeBlock == UnicodeBlock.HANGUL_JAMO || unicodeBlock == UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock == UnicodeBlock.HIRAGANA || unicodeBlock == UnicodeBlock.KATAKANA || unicodeBlock == UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    public static String[] m6233a(String str, boolean z) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char[] toCharArray = str.toCharArray();
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int i4;
            int codePointAt = Character.codePointAt(toCharArray, i3);
            int charCount = Character.charCount(codePointAt);
            if (m6231a(codePointAt)) {
                if (i != 0) {
                    arrayList.add(new String(toCharArray, i2, i3 - i2));
                }
                arrayList.add(new String(toCharArray, i3, charCount));
                i = i2;
                i2 = 0;
            } else if (Character.isLetterOrDigit(codePointAt) || Character.getType(codePointAt) == 6 || Character.getType(codePointAt) == 8) {
                if (i == 0) {
                    i2 = i3;
                }
                i = i2;
                i2 = 1;
            } else if (z && Character.charCount(codePointAt) == 1 && Character.toChars(codePointAt)[0] == '\'') {
                if (i == 0) {
                    i2 = i3;
                }
                i = i2;
                i2 = 1;
            } else if (i != 0) {
                arrayList.add(new String(toCharArray, i2, i3 - i2));
                i = i2;
                i2 = 0;
            } else {
                i4 = i;
                i = i2;
                i2 = i4;
            }
            i3 += charCount;
            i4 = i2;
            i2 = i;
            i = i4;
        }
        if (i != 0) {
            arrayList.add(new String(toCharArray, i2, i3 - i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static byte[] m6234b(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i);
        return allocate.array();
    }

    public static String[] m6235b(String str) {
        return m6233a(str, false);
    }

    private static boolean m6236c(int i) {
        return (i >= 65382 && i <= 65437) || (i >= 65441 && i <= 65500);
    }
}
