package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR;
    private final int f686a;
    private final float f687b;

    /* renamed from: android.support.v4.media.RatingCompat.1 */
    static class C03181 implements Creator<RatingCompat> {
        C03181() {
        }

        public RatingCompat m1065a(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public RatingCompat[] m1066a(int i) {
            return new RatingCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1065a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1066a(i);
        }
    }

    static {
        CREATOR = new C03181();
    }

    RatingCompat(int i, float f) {
        this.f686a = i;
        this.f687b = f;
    }

    public int describeContents() {
        return this.f686a;
    }

    public String toString() {
        return "Rating:style=" + this.f686a + " rating=" + (this.f687b < 0.0f ? "unrated" : String.valueOf(this.f687b));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f686a);
        parcel.writeFloat(this.f687b);
    }
}
