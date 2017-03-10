package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

@TargetApi(21)
/* renamed from: android.support.v4.media.session.d */
class C0354d {

    /* renamed from: android.support.v4.media.session.d.a */
    public interface C0337a {
        void m1197a();

        void m1198a(int i, int i2, int i3, int i4, int i5);

        void m1199a(Bundle bundle);

        void m1200a(CharSequence charSequence);

        void m1201a(Object obj);

        void m1202a(String str, Bundle bundle);

        void m1203a(List<?> list);

        void m1204b(Object obj);
    }

    /* renamed from: android.support.v4.media.session.d.b */
    static class C0352b<T extends C0337a> extends Callback {
        protected final T f745a;

        public C0352b(T t) {
            this.f745a = t;
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            this.f745a.m1198a(playbackInfo.getPlaybackType(), C0353c.m1251b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            this.f745a.m1199a(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f745a.m1204b(mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f745a.m1201a((Object) playbackState);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.f745a.m1203a((List) list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f745a.m1200a(charSequence);
        }

        public void onSessionDestroyed() {
            this.f745a.m1197a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.f745a.m1202a(str, bundle);
        }
    }

    /* renamed from: android.support.v4.media.session.d.c */
    public static class C0353c {
        private static int m1249a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                case C1096c.MapAttrs_uiZoomControls /*11*/:
                case C1096c.MapAttrs_uiZoomGestures /*12*/:
                case C1096c.MapAttrs_zOrderOnTop /*14*/:
                    return 3;
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    return 0;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                    return 8;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    return 4;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                case C1096c.MapAttrs_uiCompass /*7*/:
                case C1096c.MapAttrs_uiRotateGestures /*8*/:
                case C1096c.MapAttrs_uiScrollGestures /*9*/:
                case C1096c.MapAttrs_uiTiltGestures /*10*/:
                    return 5;
                case C1096c.MapAttrs_liteMode /*6*/:
                    return 2;
                case C1096c.MapAttrs_useViewLifecycle /*13*/:
                    return 1;
                default:
                    return 3;
            }
        }

        public static AudioAttributes m1250a(Object obj) {
            return ((PlaybackInfo) obj).getAudioAttributes();
        }

        public static int m1251b(Object obj) {
            return C0353c.m1249a(C0353c.m1250a(obj));
        }
    }

    public static Object m1252a(Activity activity) {
        return activity.getMediaController();
    }

    public static Object m1253a(Context context, Object obj) {
        return new MediaController(context, (Token) obj);
    }

    public static Object m1254a(C0337a c0337a) {
        return new C0352b(c0337a);
    }

    public static Object m1255a(Object obj) {
        return ((MediaController) obj).getSessionToken();
    }

    public static void m1256a(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    public static void m1257a(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }
}
