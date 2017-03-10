package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR;
    public int f694a;
    public int f695b;
    public int f696c;
    public int f697d;
    public int f698e;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo.1 */
    static class C03271 implements Creator<ParcelableVolumeInfo> {
        C03271() {
        }

        public ParcelableVolumeInfo m1098a(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        public ParcelableVolumeInfo[] m1099a(int i) {
            return new ParcelableVolumeInfo[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1098a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1099a(i);
        }
    }

    static {
        CREATOR = new C03271();
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f694a = parcel.readInt();
        this.f696c = parcel.readInt();
        this.f697d = parcel.readInt();
        this.f698e = parcel.readInt();
        this.f695b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f694a);
        parcel.writeInt(this.f696c);
        parcel.writeInt(this.f697d);
        parcel.writeInt(this.f698e);
        parcel.writeInt(this.f695b);
    }
}
