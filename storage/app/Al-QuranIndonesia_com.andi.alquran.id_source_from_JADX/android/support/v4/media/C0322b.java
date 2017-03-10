package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.support.v4.media.C0320a.C0319a;

@TargetApi(23)
/* renamed from: android.support.v4.media.b */
class C0322b extends C0320a {

    /* renamed from: android.support.v4.media.b.a */
    static class C0321a extends C0319a {
        public static void m1085b(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri m1086h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
