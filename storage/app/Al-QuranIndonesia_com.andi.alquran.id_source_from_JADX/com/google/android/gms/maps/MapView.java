package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.C1292b;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.internal.zzt.zza;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p039a.C1098e;
import com.google.android.gms.p039a.C1107b;
import com.google.android.gms.p039a.C1111d;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private final C2123b f6805a;

    /* renamed from: com.google.android.gms.maps.MapView.a */
    static class C2122a implements MapLifecycleDelegate {
        private final ViewGroup f6797a;
        private final IMapViewDelegate f6798b;
        private View f6799c;

        /* renamed from: com.google.android.gms.maps.MapView.a.1 */
        class C21211 extends zza {
            final /* synthetic */ OnMapReadyCallback f6796a;

            C21211(C2122a c2122a, OnMapReadyCallback onMapReadyCallback) {
                this.f6796a = onMapReadyCallback;
            }

            public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
                this.f6796a.onMapReady(new GoogleMap(iGoogleMapDelegate));
            }
        }

        public C2122a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.f6798b = (IMapViewDelegate) C1314c.m4623a((Object) iMapViewDelegate);
            this.f6797a = (ViewGroup) C1314c.m4623a((Object) viewGroup);
        }

        public View m9941a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void m9942a() {
            try {
                this.f6798b.onStart();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9943a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void m9944a(Bundle bundle) {
            try {
                this.f6798b.onCreate(bundle);
                this.f6799c = (View) C1111d.m3897a(this.f6798b.getView());
                this.f6797a.removeAllViews();
                this.f6797a.addView(this.f6799c);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9945b() {
            try {
                this.f6798b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9946b(Bundle bundle) {
            try {
                this.f6798b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9947c() {
            try {
                this.f6798b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9948c(Bundle bundle) {
            try {
                this.f6798b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9949d() {
            try {
                this.f6798b.onStop();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9950e() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void m9951f() {
            try {
                this.f6798b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9952g() {
            try {
                this.f6798b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f6798b.getMapAsync(new C21211(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9953h() {
            try {
                this.f6798b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView.b */
    static class C2123b extends C1107b<C2122a> {
        protected C1098e<C2122a> f6800a;
        private final ViewGroup f6801b;
        private final Context f6802c;
        private final GoogleMapOptions f6803d;
        private final List<OnMapReadyCallback> f6804e;

        C2123b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f6804e = new ArrayList();
            this.f6801b = viewGroup;
            this.f6802c = context;
            this.f6803d = googleMapOptions;
        }

        protected void m9954a(C1098e<C2122a> c1098e) {
            this.f6800a = c1098e;
            m9957i();
        }

        public void m9955a(OnMapReadyCallback onMapReadyCallback) {
            if (m3882a() != null) {
                ((C2122a) m3882a()).getMapAsync(onMapReadyCallback);
            } else {
                this.f6804e.add(onMapReadyCallback);
            }
        }

        public void m9956c(Bundle bundle) {
            if (m3882a() != null) {
                ((C2122a) m3882a()).m9948c(bundle);
            }
        }

        public void m9957i() {
            if (this.f6800a != null && m3882a() == null) {
                try {
                    MapsInitializer.initialize(this.f6802c);
                    IMapViewDelegate zza = zzai.zzbq(this.f6802c).zza(C1111d.m3896a(this.f6802c), this.f6803d);
                    if (zza != null) {
                        this.f6800a.m3859a(new C2122a(this.f6801b, zza));
                        for (OnMapReadyCallback mapAsync : this.f6804e) {
                            ((C2122a) m3882a()).getMapAsync(mapAsync);
                        }
                        this.f6804e.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (C1292b e2) {
                }
            }
        }

        public void m9958j() {
            if (m3882a() != null) {
                ((C2122a) m3882a()).m9953h();
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f6805a = new C2123b(this, context, null);
        m9959a();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6805a = new C2123b(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        m9959a();
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6805a = new C2123b(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        m9959a();
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.f6805a = new C2123b(this, context, googleMapOptions);
        m9959a();
    }

    private void m9959a() {
        setClickable(true);
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        C1314c.m4631b("getMapAsync() must be called on the main thread");
        this.f6805a.m9955a(onMapReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.f6805a.m3884a(bundle);
        if (this.f6805a.m3882a() == null) {
            C1107b.m3880b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.f6805a.m3893g();
    }

    public final void onEnterAmbient(Bundle bundle) {
        C1314c.m4631b("onEnterAmbient() must be called on the main thread");
        this.f6805a.m9956c(bundle);
    }

    public final void onExitAmbient() {
        C1314c.m4631b("onExitAmbient() must be called on the main thread");
        this.f6805a.m9958j();
    }

    public final void onLowMemory() {
        this.f6805a.m3894h();
    }

    public final void onPause() {
        this.f6805a.m3890d();
    }

    public final void onResume() {
        this.f6805a.m3889c();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f6805a.m3888b(bundle);
    }

    public final void onStart() {
        this.f6805a.m3887b();
    }

    public final void onStop() {
        this.f6805a.m3891e();
    }
}
