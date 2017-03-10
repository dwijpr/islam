package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.MediaMetadata;
import android.os.Parcel;

@TargetApi(21)
/* renamed from: android.support.v4.media.c */
class C0323c {
    public static void m1087a(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }
}
