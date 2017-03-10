package android.support.v4.media.session;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.SupportActivity;
import android.support.v4.app.SupportActivity.ExtraData;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.C0330a.C0332a;
import android.support.v4.media.session.C0333b.C0335a;
import android.support.v4.media.session.C0354d.C0337a;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.HashMap;
import java.util.List;

/* renamed from: android.support.v4.media.session.c */
public final class C0351c {
    private final C0342c f743a;
    private final Token f744b;

    /* renamed from: android.support.v4.media.session.c.a */
    public static abstract class C0340a implements DeathRecipient {
        C0336a f720a;
        boolean f721b;
        boolean f722c;
        private final Object f723d;

        /* renamed from: android.support.v4.media.session.c.a.a */
        private class C0336a extends Handler {
            final /* synthetic */ C0340a f717a;

            public void m1196a(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }

            public void handleMessage(Message message) {
                if (this.f717a.f722c) {
                    switch (message.what) {
                        case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                            this.f717a.m1227a((String) message.obj, message.getData());
                        case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                            this.f717a.m1224a((PlaybackStateCompat) message.obj);
                        case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                            this.f717a.m1223a((MediaMetadataCompat) message.obj);
                        case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                            this.f717a.m1225a((C0350h) message.obj);
                        case C1096c.MapAttrs_cameraZoom /*5*/:
                            this.f717a.m1228a((List) message.obj);
                        case C1096c.MapAttrs_liteMode /*6*/:
                            this.f717a.m1226a((CharSequence) message.obj);
                        case C1096c.MapAttrs_uiCompass /*7*/:
                            this.f717a.m1222a((Bundle) message.obj);
                        case C1096c.MapAttrs_uiRotateGestures /*8*/:
                            this.f717a.m1221a();
                        default:
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.c.a.b */
        private class C0338b implements C0337a {
            final /* synthetic */ C0340a f718a;

            C0338b(C0340a c0340a) {
                this.f718a = c0340a;
            }

            public void m1205a() {
                this.f718a.m1221a();
            }

            public void m1206a(int i, int i2, int i3, int i4, int i5) {
                this.f718a.m1225a(new C0350h(i, i2, i3, i4, i5));
            }

            public void m1207a(Bundle bundle) {
                this.f718a.m1222a(bundle);
            }

            public void m1208a(CharSequence charSequence) {
                this.f718a.m1226a(charSequence);
            }

            public void m1209a(Object obj) {
                if (!this.f718a.f721b || VERSION.SDK_INT >= 22) {
                    this.f718a.m1224a(PlaybackStateCompat.m1105a(obj));
                }
            }

            public void m1210a(String str, Bundle bundle) {
                if (!this.f718a.f721b || VERSION.SDK_INT >= 23) {
                    this.f718a.m1227a(str, bundle);
                }
            }

            public void m1211a(List<?> list) {
                this.f718a.m1228a(QueueItem.m1091a((List) list));
            }

            public void m1212b(Object obj) {
                this.f718a.m1223a(MediaMetadataCompat.m1064a(obj));
            }
        }

        /* renamed from: android.support.v4.media.session.c.a.c */
        private class C0339c extends C0332a {
            final /* synthetic */ C0340a f719a;

            C0339c(C0340a c0340a) {
                this.f719a = c0340a;
            }

            public void m1213a() {
                this.f719a.f720a.m1196a(8, null, null);
            }

            public void m1214a(Bundle bundle) {
                this.f719a.f720a.m1196a(7, bundle, null);
            }

            public void m1215a(MediaMetadataCompat mediaMetadataCompat) {
                this.f719a.f720a.m1196a(3, mediaMetadataCompat, null);
            }

            public void m1216a(ParcelableVolumeInfo parcelableVolumeInfo) {
                this.f719a.f720a.m1196a(4, parcelableVolumeInfo != null ? new C0350h(parcelableVolumeInfo.f694a, parcelableVolumeInfo.f695b, parcelableVolumeInfo.f696c, parcelableVolumeInfo.f697d, parcelableVolumeInfo.f698e) : null, null);
            }

            public void m1217a(PlaybackStateCompat playbackStateCompat) {
                this.f719a.f720a.m1196a(2, playbackStateCompat, null);
            }

            public void m1218a(CharSequence charSequence) {
                this.f719a.f720a.m1196a(6, charSequence, null);
            }

            public void m1219a(String str, Bundle bundle) {
                this.f719a.f720a.m1196a(1, str, bundle);
            }

            public void m1220a(List<QueueItem> list) {
                this.f719a.f720a.m1196a(5, list, null);
            }
        }

        public C0340a() {
            this.f722c = false;
            if (VERSION.SDK_INT >= 21) {
                this.f723d = C0354d.m1254a(new C0338b(this));
            } else {
                this.f723d = new C0339c(this);
            }
        }

        public void m1221a() {
        }

        public void m1222a(Bundle bundle) {
        }

        public void m1223a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void m1224a(PlaybackStateCompat playbackStateCompat) {
        }

        public void m1225a(C0350h c0350h) {
        }

        public void m1226a(CharSequence charSequence) {
        }

        public void m1227a(String str, Bundle bundle) {
        }

        public void m1228a(List<QueueItem> list) {
        }
    }

    /* renamed from: android.support.v4.media.session.c.b */
    private static class C0341b extends ExtraData {
        private final C0351c f724a;

        C0341b(C0351c c0351c) {
            this.f724a = c0351c;
        }

        C0351c m1229a() {
            return this.f724a;
        }
    }

    /* renamed from: android.support.v4.media.session.c.c */
    interface C0342c {
    }

    /* renamed from: android.support.v4.media.session.c.d */
    static class C0346d implements C0342c {
        protected final Object f732a;
        private C0333b f733b;
        private HashMap<C0340a, C0345a> f734c;
        private List<C0340a> f735d;

        /* renamed from: android.support.v4.media.session.c.d.a */
        private class C0345a extends C0332a {
            final /* synthetic */ C0346d f730a;
            private C0340a f731b;

            /* renamed from: android.support.v4.media.session.c.d.a.1 */
            class C03431 implements Runnable {
                final /* synthetic */ String f725a;
                final /* synthetic */ Bundle f726b;
                final /* synthetic */ C0345a f727c;

                C03431(C0345a c0345a, String str, Bundle bundle) {
                    this.f727c = c0345a;
                    this.f725a = str;
                    this.f726b = bundle;
                }

                public void run() {
                    this.f727c.f731b.m1227a(this.f725a, this.f726b);
                }
            }

            /* renamed from: android.support.v4.media.session.c.d.a.2 */
            class C03442 implements Runnable {
                final /* synthetic */ PlaybackStateCompat f728a;
                final /* synthetic */ C0345a f729b;

                C03442(C0345a c0345a, PlaybackStateCompat playbackStateCompat) {
                    this.f729b = c0345a;
                    this.f728a = playbackStateCompat;
                }

                public void run() {
                    this.f729b.f731b.m1224a(this.f728a);
                }
            }

            C0345a(C0346d c0346d, C0340a c0340a) {
                this.f730a = c0346d;
                this.f731b = c0340a;
            }

            public void m1231a() {
                throw new AssertionError();
            }

            public void m1232a(Bundle bundle) {
                throw new AssertionError();
            }

            public void m1233a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            public void m1234a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            public void m1235a(PlaybackStateCompat playbackStateCompat) {
                this.f731b.f720a.post(new C03442(this, playbackStateCompat));
            }

            public void m1236a(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void m1237a(String str, Bundle bundle) {
                this.f731b.f720a.post(new C03431(this, str, bundle));
            }

            public void m1238a(List<QueueItem> list) {
                throw new AssertionError();
            }
        }

        public C0346d(Context context, Token token) {
            this.f734c = new HashMap();
            this.f732a = C0354d.m1253a(context, token.m1097a());
            if (this.f732a == null) {
                throw new RemoteException();
            }
            m1242a();
        }

        private void m1242a() {
            m1245a("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new MediaControllerCompat$MediaControllerImplApi21$1(this, new Handler()));
        }

        public void m1245a(String str, Bundle bundle, ResultReceiver resultReceiver) {
            C0354d.m1257a(this.f732a, str, bundle, resultReceiver);
        }
    }

    /* renamed from: android.support.v4.media.session.c.e */
    static class C0347e extends C0346d {
        public C0347e(Context context, Token token) {
            super(context, token);
        }
    }

    /* renamed from: android.support.v4.media.session.c.f */
    static class C0348f extends C0347e {
        public C0348f(Context context, Token token) {
            super(context, token);
        }
    }

    /* renamed from: android.support.v4.media.session.c.g */
    static class C0349g implements C0342c {
        private Token f736a;
        private C0333b f737b;

        public C0349g(Token token) {
            this.f736a = token;
            this.f737b = C0335a.m1195a((IBinder) token.m1097a());
        }
    }

    /* renamed from: android.support.v4.media.session.c.h */
    public static final class C0350h {
        private final int f738a;
        private final int f739b;
        private final int f740c;
        private final int f741d;
        private final int f742e;

        C0350h(int i, int i2, int i3, int i4, int i5) {
            this.f738a = i;
            this.f739b = i2;
            this.f740c = i3;
            this.f741d = i4;
            this.f742e = i5;
        }
    }

    public C0351c(Context context, Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f744b = token;
        if (VERSION.SDK_INT >= 24) {
            this.f743a = new C0348f(context, token);
        } else if (VERSION.SDK_INT >= 23) {
            this.f743a = new C0347e(context, token);
        } else if (VERSION.SDK_INT >= 21) {
            this.f743a = new C0346d(context, token);
        } else {
            this.f743a = new C0349g(this.f744b);
        }
    }

    public static C0351c m1246a(Activity activity) {
        if (activity instanceof SupportActivity) {
            C0341b c0341b = (C0341b) ((SupportActivity) activity).getExtraData(C0341b.class);
            return c0341b != null ? c0341b.m1229a() : null;
        } else if (VERSION.SDK_INT < 21) {
            return null;
        } else {
            Object a = C0354d.m1252a(activity);
            if (a == null) {
                return null;
            }
            try {
                return new C0351c(activity, Token.m1096a(C0354d.m1255a(a)));
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getMediaController. " + e);
                return null;
            }
        }
    }

    public static void m1247a(Activity activity, C0351c c0351c) {
        if (activity instanceof SupportActivity) {
            ((SupportActivity) activity).putExtraData(new C0341b(c0351c));
        }
        if (VERSION.SDK_INT >= 21) {
            Object obj = null;
            if (c0351c != null) {
                obj = C0354d.m1253a((Context) activity, c0351c.m1248a().m1097a());
            }
            C0354d.m1256a(activity, obj);
        }
    }

    public Token m1248a() {
        return this.f744b;
    }
}
