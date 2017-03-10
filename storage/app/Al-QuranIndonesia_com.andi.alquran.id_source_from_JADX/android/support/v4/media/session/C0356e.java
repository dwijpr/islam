package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;

@TargetApi(21)
/* renamed from: android.support.v4.media.session.e */
class C0356e {

    /* renamed from: android.support.v4.media.session.e.a */
    static class C0355a {
        public static Object m1258a(Object obj) {
            return ((QueueItem) obj).getDescription();
        }

        public static long m1259b(Object obj) {
            return ((QueueItem) obj).getQueueId();
        }
    }

    public static Object m1260a(Object obj) {
        if (obj instanceof Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
