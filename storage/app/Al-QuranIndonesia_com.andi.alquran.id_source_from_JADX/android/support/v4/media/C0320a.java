package android.support.v4.media;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

@TargetApi(21)
/* renamed from: android.support.v4.media.a */
class C0320a {

    /* renamed from: android.support.v4.media.a.a */
    static class C0319a {
        public static Object m1067a() {
            return new Builder();
        }

        public static Object m1068a(Object obj) {
            return ((Builder) obj).build();
        }

        public static void m1069a(Object obj, Bitmap bitmap) {
            ((Builder) obj).setIconBitmap(bitmap);
        }

        public static void m1070a(Object obj, Uri uri) {
            ((Builder) obj).setIconUri(uri);
        }

        public static void m1071a(Object obj, Bundle bundle) {
            ((Builder) obj).setExtras(bundle);
        }

        public static void m1072a(Object obj, CharSequence charSequence) {
            ((Builder) obj).setTitle(charSequence);
        }

        public static void m1073a(Object obj, String str) {
            ((Builder) obj).setMediaId(str);
        }

        public static void m1074b(Object obj, CharSequence charSequence) {
            ((Builder) obj).setSubtitle(charSequence);
        }

        public static void m1075c(Object obj, CharSequence charSequence) {
            ((Builder) obj).setDescription(charSequence);
        }
    }

    public static Object m1076a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    public static String m1077a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static void m1078a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static CharSequence m1079b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m1080c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m1081d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m1082e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m1083f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m1084g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }
}
