package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.C0333b.C0335a;
import android.support.v4.media.session.C0351c.C0340a;
import android.support.v4.media.session.C0351c.C0346d;
import android.support.v4.media.session.C0351c.C0346d.C0345a;
import android.util.Log;

class MediaControllerCompat$MediaControllerImplApi21$1 extends ResultReceiver {
    final /* synthetic */ C0346d f688a;

    MediaControllerCompat$MediaControllerImplApi21$1(C0346d c0346d, Handler handler) {
        this.a = c0346d;
        super(handler);
    }

    protected void onReceiveResult(int i, Bundle bundle) {
        if (bundle != null) {
            this.a.f733b = C0335a.m1195a(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
            if (this.a.f735d != null) {
                for (C0340a c0340a : this.a.f735d) {
                    C0330a c0345a = new C0345a(this.a, c0340a);
                    this.a.f734c.put(c0340a, c0345a);
                    c0340a.f721b = true;
                    try {
                        this.a.f733b.m1127a(c0345a);
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback. " + e);
                    }
                }
                this.a.f735d = null;
            }
        }
    }
}
