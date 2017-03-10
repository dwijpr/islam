package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.C0320a.C0319a;
import android.support.v4.media.C0322b.C0321a;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR;
    private final String f671a;
    private final CharSequence f672b;
    private final CharSequence f673c;
    private final CharSequence f674d;
    private final Bitmap f675e;
    private final Uri f676f;
    private final Bundle f677g;
    private final Uri f678h;
    private Object f679i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat.1 */
    static class C03151 implements Creator<MediaDescriptionCompat> {
        C03151() {
        }

        public MediaDescriptionCompat m1049a(Parcel parcel) {
            return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.m1060a(C0320a.m1076a(parcel));
        }

        public MediaDescriptionCompat[] m1050a(int i) {
            return new MediaDescriptionCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1049a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1050a(i);
        }
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat.a */
    public static final class C0316a {
        private String f663a;
        private CharSequence f664b;
        private CharSequence f665c;
        private CharSequence f666d;
        private Bitmap f667e;
        private Uri f668f;
        private Bundle f669g;
        private Uri f670h;

        public C0316a m1051a(Bitmap bitmap) {
            this.f667e = bitmap;
            return this;
        }

        public C0316a m1052a(Uri uri) {
            this.f668f = uri;
            return this;
        }

        public C0316a m1053a(Bundle bundle) {
            this.f669g = bundle;
            return this;
        }

        public C0316a m1054a(CharSequence charSequence) {
            this.f664b = charSequence;
            return this;
        }

        public C0316a m1055a(String str) {
            this.f663a = str;
            return this;
        }

        public MediaDescriptionCompat m1056a() {
            return new MediaDescriptionCompat(this.f663a, this.f664b, this.f665c, this.f666d, this.f667e, this.f668f, this.f669g, this.f670h);
        }

        public C0316a m1057b(Uri uri) {
            this.f670h = uri;
            return this;
        }

        public C0316a m1058b(CharSequence charSequence) {
            this.f665c = charSequence;
            return this;
        }

        public C0316a m1059c(CharSequence charSequence) {
            this.f666d = charSequence;
            return this;
        }
    }

    static {
        CREATOR = new C03151();
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f671a = parcel.readString();
        this.f672b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f673c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f674d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f675e = (Bitmap) parcel.readParcelable(null);
        this.f676f = (Uri) parcel.readParcelable(null);
        this.f677g = parcel.readBundle();
        this.f678h = (Uri) parcel.readParcelable(null);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f671a = str;
        this.f672b = charSequence;
        this.f673c = charSequence2;
        this.f674d = charSequence3;
        this.f675e = bitmap;
        this.f676f = uri;
        this.f677g = bundle;
        this.f678h = uri2;
    }

    public static MediaDescriptionCompat m1060a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Bundle bundle;
        MediaDescriptionCompat a;
        C0316a c0316a = new C0316a();
        c0316a.m1055a(C0320a.m1077a(obj));
        c0316a.m1054a(C0320a.m1079b(obj));
        c0316a.m1058b(C0320a.m1080c(obj));
        c0316a.m1059c(C0320a.m1081d(obj));
        c0316a.m1051a(C0320a.m1082e(obj));
        c0316a.m1052a(C0320a.m1083f(obj));
        Bundle g = C0320a.m1084g(obj);
        Uri uri = g == null ? null : (Uri) g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        if (uri != null) {
            if (g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && g.size() == 2) {
                bundle = null;
                c0316a.m1053a(bundle);
                if (uri != null) {
                    c0316a.m1057b(uri);
                } else if (VERSION.SDK_INT >= 23) {
                    c0316a.m1057b(C0322b.m1086h(obj));
                }
                a = c0316a.m1056a();
                a.f679i = obj;
                return a;
            }
            g.remove("android.support.v4.media.description.MEDIA_URI");
            g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = g;
        c0316a.m1053a(bundle);
        if (uri != null) {
            c0316a.m1057b(uri);
        } else if (VERSION.SDK_INT >= 23) {
            c0316a.m1057b(C0322b.m1086h(obj));
        }
        a = c0316a.m1056a();
        a.f679i = obj;
        return a;
    }

    public Object m1061a() {
        if (this.f679i != null || VERSION.SDK_INT < 21) {
            return this.f679i;
        }
        Object a = C0319a.m1067a();
        C0319a.m1073a(a, this.f671a);
        C0319a.m1072a(a, this.f672b);
        C0319a.m1074b(a, this.f673c);
        C0319a.m1075c(a, this.f674d);
        C0319a.m1069a(a, this.f675e);
        C0319a.m1070a(a, this.f676f);
        Bundle bundle = this.f677g;
        if (VERSION.SDK_INT < 23 && this.f678h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f678h);
        }
        C0319a.m1071a(a, bundle);
        if (VERSION.SDK_INT >= 23) {
            C0321a.m1085b(a, this.f678h);
        }
        this.f679i = C0319a.m1068a(a);
        return this.f679i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f672b + ", " + this.f673c + ", " + this.f674d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f671a);
            TextUtils.writeToParcel(this.f672b, parcel, i);
            TextUtils.writeToParcel(this.f673c, parcel, i);
            TextUtils.writeToParcel(this.f674d, parcel, i);
            parcel.writeParcelable(this.f675e, i);
            parcel.writeParcelable(this.f676f, i);
            parcel.writeBundle(this.f677g);
            parcel.writeParcelable(this.f678h, i);
            return;
        }
        C0320a.m1078a(m1061a(), parcel, i);
    }
}
