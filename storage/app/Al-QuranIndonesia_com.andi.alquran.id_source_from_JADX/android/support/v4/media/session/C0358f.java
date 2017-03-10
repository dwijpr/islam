package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.os.Bundle;
import java.util.List;

@TargetApi(21)
/* renamed from: android.support.v4.media.session.f */
class C0358f {

    /* renamed from: android.support.v4.media.session.f.a */
    static final class C0357a {
        public static String m1261a(Object obj) {
            return ((CustomAction) obj).getAction();
        }

        public static CharSequence m1262b(Object obj) {
            return ((CustomAction) obj).getName();
        }

        public static int m1263c(Object obj) {
            return ((CustomAction) obj).getIcon();
        }

        public static Bundle m1264d(Object obj) {
            return ((CustomAction) obj).getExtras();
        }
    }

    public static int m1265a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long m1266b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long m1267c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float m1268d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long m1269e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence m1270f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long m1271g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> m1272h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long m1273i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}
