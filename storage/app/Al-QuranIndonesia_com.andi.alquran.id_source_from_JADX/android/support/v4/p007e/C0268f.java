package android.support.v4.p007e;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

@TargetApi(13)
/* renamed from: android.support.v4.e.f */
class C0268f<T> implements ClassLoaderCreator<T> {
    private final C0043e<T> f580a;

    public C0268f(C0043e<T> c0043e) {
        this.f580a = c0043e;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f580a.createFromParcel(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f580a.createFromParcel(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f580a.newArray(i);
    }
}
