package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.tagmanager.C2208b.C2215a;

class an implements C2208b {
    private C2195a f7066a;
    private C2195a f7067b;
    private Status f7068c;
    private C2207b f7069d;
    private C2206a f7070e;
    private boolean f7071f;
    private C2226d f7072g;

    /* renamed from: com.google.android.gms.tagmanager.an.a */
    public interface C2206a {
        void m10163a();

        void m10164a(String str);

        String m10165b();
    }

    /* renamed from: com.google.android.gms.tagmanager.an.b */
    private class C2207b extends Handler {
        final /* synthetic */ an f7064a;
        private final C2215a f7065b;

        protected void m10166a(String str) {
            this.f7065b.m10213a(this.f7064a, str);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    m10166a((String) message.obj);
                default:
                    C2238n.m10264a("Don't know how to handle this message.");
            }
        }
    }

    public synchronized void m10167a() {
        if (this.f7071f) {
            C2238n.m10264a("Releasing a released ContainerHolder.");
        } else {
            this.f7071f = true;
            this.f7072g.m10244a(this);
            this.f7066a.m10093b();
            this.f7066a = null;
            this.f7067b = null;
            this.f7070e = null;
            this.f7069d = null;
        }
    }

    public synchronized void m10168a(String str) {
        if (!this.f7071f) {
            this.f7066a.m10092a(str);
        }
    }

    public Status m10169b() {
        return this.f7068c;
    }

    void m10170b(String str) {
        if (this.f7071f) {
            C2238n.m10264a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.f7070e.m10164a(str);
        }
    }

    public synchronized void m10171c() {
        if (this.f7071f) {
            C2238n.m10264a("Refreshing a released ContainerHolder.");
        } else {
            this.f7070e.m10163a();
        }
    }

    String m10172d() {
        if (!this.f7071f) {
            return this.f7066a.m10091a();
        }
        C2238n.m10264a("getContainerId called on a released ContainerHolder.");
        return BuildConfig.VERSION_NAME;
    }

    String m10173e() {
        if (!this.f7071f) {
            return this.f7070e.m10165b();
        }
        C2238n.m10264a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return BuildConfig.VERSION_NAME;
    }
}
