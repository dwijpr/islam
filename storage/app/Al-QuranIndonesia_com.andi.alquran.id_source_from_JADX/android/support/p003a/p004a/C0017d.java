package android.support.p003a.p004a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.a.a.d */
class C0017d {
    public static float m38a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0017d.m41a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int m39a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0017d.m41a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static boolean m40a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0017d.m41a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static boolean m41a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int m42b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0017d.m41a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
