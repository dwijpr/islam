package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.C0358f.C0357a;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR;
    final int f704a;
    final long f705b;
    final long f706c;
    final float f707d;
    final long f708e;
    final CharSequence f709f;
    final long f710g;
    List<CustomAction> f711h;
    final long f712i;
    final Bundle f713j;
    private Object f714k;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat.1 */
    static class C03281 implements Creator<PlaybackStateCompat> {
        C03281() {
        }

        public PlaybackStateCompat m1100a(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public PlaybackStateCompat[] m1101a(int i) {
            return new PlaybackStateCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1100a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1101a(i);
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR;
        private final String f699a;
        private final CharSequence f700b;
        private final int f701c;
        private final Bundle f702d;
        private Object f703e;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1 */
        static class C03291 implements Creator<CustomAction> {
            C03291() {
            }

            public CustomAction m1102a(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public CustomAction[] m1103a(int i) {
                return new CustomAction[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1102a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1103a(i);
            }
        }

        static {
            CREATOR = new C03291();
        }

        CustomAction(Parcel parcel) {
            this.f699a = parcel.readString();
            this.f700b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f701c = parcel.readInt();
            this.f702d = parcel.readBundle();
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f699a = str;
            this.f700b = charSequence;
            this.f701c = i;
            this.f702d = bundle;
        }

        public static CustomAction m1104a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0357a.m1261a(obj), C0357a.m1262b(obj), C0357a.m1263c(obj), C0357a.m1264d(obj));
            customAction.f703e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f700b + ", mIcon=" + this.f701c + ", mExtras=" + this.f702d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f699a);
            TextUtils.writeToParcel(this.f700b, parcel, i);
            parcel.writeInt(this.f701c);
            parcel.writeBundle(this.f702d);
        }
    }

    static {
        CREATOR = new C03281();
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f704a = i;
        this.f705b = j;
        this.f706c = j2;
        this.f707d = f;
        this.f708e = j3;
        this.f709f = charSequence;
        this.f710g = j4;
        this.f711h = new ArrayList(list);
        this.f712i = j5;
        this.f713j = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f704a = parcel.readInt();
        this.f705b = parcel.readLong();
        this.f707d = parcel.readFloat();
        this.f710g = parcel.readLong();
        this.f706c = parcel.readLong();
        this.f708e = parcel.readLong();
        this.f709f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f711h = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f712i = parcel.readLong();
        this.f713j = parcel.readBundle();
    }

    public static PlaybackStateCompat m1105a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h = C0358f.m1272h(obj);
        List list = null;
        if (h != null) {
            list = new ArrayList(h.size());
            for (Object a : h) {
                list.add(CustomAction.m1104a(a));
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0358f.m1265a(obj), C0358f.m1266b(obj), C0358f.m1267c(obj), C0358f.m1268d(obj), C0358f.m1269e(obj), C0358f.m1270f(obj), C0358f.m1271g(obj), list, C0358f.m1273i(obj), VERSION.SDK_INT >= 22 ? C0359g.m1274a(obj) : null);
        playbackStateCompat.f714k = obj;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.f704a);
        stringBuilder.append(", position=").append(this.f705b);
        stringBuilder.append(", buffered position=").append(this.f706c);
        stringBuilder.append(", speed=").append(this.f707d);
        stringBuilder.append(", updated=").append(this.f710g);
        stringBuilder.append(", actions=").append(this.f708e);
        stringBuilder.append(", error=").append(this.f709f);
        stringBuilder.append(", custom actions=").append(this.f711h);
        stringBuilder.append(", active item id=").append(this.f712i);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f704a);
        parcel.writeLong(this.f705b);
        parcel.writeFloat(this.f707d);
        parcel.writeLong(this.f710g);
        parcel.writeLong(this.f706c);
        parcel.writeLong(this.f708e);
        TextUtils.writeToParcel(this.f709f, parcel, i);
        parcel.writeTypedList(this.f711h);
        parcel.writeLong(this.f712i);
        parcel.writeBundle(this.f713j);
    }
}
