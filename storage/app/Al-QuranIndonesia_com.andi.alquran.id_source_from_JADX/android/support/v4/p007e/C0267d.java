package android.support.v4.p007e;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.e.d */
public final class C0267d {

    /* renamed from: android.support.v4.e.d.a */
    static class C0266a<T> implements Creator<T> {
        final C0043e<T> f579a;

        public C0266a(C0043e<T> c0043e) {
            this.f579a = c0043e;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f579a.createFromParcel(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f579a.newArray(i);
        }
    }

    public static <T> Creator<T> m910a(C0043e<T> c0043e) {
        return VERSION.SDK_INT >= 13 ? C0269g.m911a(c0043e) : new C0266a(c0043e);
    }
}
