package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.C0356e.C0355a;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR;
        private final MediaDescriptionCompat f689a;
        private final long f690b;
        private Object f691c;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.QueueItem.1 */
        static class C03241 implements Creator<QueueItem> {
            C03241() {
            }

            public QueueItem m1088a(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] m1089a(int i) {
                return new QueueItem[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1088a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1089a(i);
            }
        }

        static {
            CREATOR = new C03241();
        }

        QueueItem(Parcel parcel) {
            this.f689a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f690b = parcel.readLong();
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.f689a = mediaDescriptionCompat;
                this.f690b = j;
                this.f691c = obj;
            }
        }

        public static QueueItem m1090a(Object obj) {
            return (obj == null || VERSION.SDK_INT < 21) ? null : new QueueItem(obj, MediaDescriptionCompat.m1060a(C0355a.m1258a(obj)), C0355a.m1259b(obj));
        }

        public static List<QueueItem> m1091a(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            List<QueueItem> arrayList = new ArrayList();
            for (Object a : list) {
                arrayList.add(m1090a(a));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f689a + ", Id=" + this.f690b + " }";
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f689a.writeToParcel(parcel, i);
            parcel.writeLong(this.f690b);
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR;
        private ResultReceiver f692a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1 */
        static class C03251 implements Creator<ResultReceiverWrapper> {
            C03251() {
            }

            public ResultReceiverWrapper m1092a(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] m1093a(int i) {
                return new ResultReceiverWrapper[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1092a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1093a(i);
            }
        }

        static {
            CREATOR = new C03251();
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f692a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f692a.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR;
        private final Object f693a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.Token.1 */
        static class C03261 implements Creator<Token> {
            C03261() {
            }

            public Token m1094a(Parcel parcel) {
                return new Token(VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
            }

            public Token[] m1095a(int i) {
                return new Token[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1094a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1095a(i);
            }
        }

        static {
            CREATOR = new C03261();
        }

        Token(Object obj) {
            this.f693a = obj;
        }

        public static Token m1096a(Object obj) {
            return (obj == null || VERSION.SDK_INT < 21) ? null : new Token(C0356e.m1260a(obj));
        }

        public Object m1097a() {
            return this.f693a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            return this.f693a == null ? token.f693a == null : token.f693a == null ? false : this.f693a.equals(token.f693a);
        }

        public int hashCode() {
            return this.f693a == null ? 0 : this.f693a.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f693a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f693a);
            }
        }
    }
}
