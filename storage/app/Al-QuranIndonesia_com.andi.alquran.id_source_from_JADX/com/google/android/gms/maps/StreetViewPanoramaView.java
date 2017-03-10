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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzaf.zza;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p039a.C1098e;
import com.google.android.gms.p039a.C1107b;
import com.google.android.gms.p039a.C1111d;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private final C2133b f6840a;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.a */
    static class C2132a implements StreetViewLifecycleDelegate {
        private final ViewGroup f6832a;
        private final IStreetViewPanoramaViewDelegate f6833b;
        private View f6834c;

        /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.a.1 */
        class C21311 extends zza {
            final /* synthetic */ OnStreetViewPanoramaReadyCallback f6831a;

            C21311(C2132a c2132a, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
                this.f6831a = onStreetViewPanoramaReadyCallback;
            }

            public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
                this.f6831a.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
            }
        }

        public C2132a(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.f6833b = (IStreetViewPanoramaViewDelegate) C1314c.m4623a((Object) iStreetViewPanoramaViewDelegate);
            this.f6832a = (ViewGroup) C1314c.m4623a((Object) viewGroup);
        }

        public View m9982a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void m9983a() {
        }

        public void m9984a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void m9985a(Bundle bundle) {
            try {
                this.f6833b.onCreate(bundle);
                this.f6834c = (View) C1111d.m3897a(this.f6833b.getView());
                this.f6832a.removeAllViews();
                this.f6832a.addView(this.f6834c);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9986b() {
            try {
                this.f6833b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9987b(Bundle bundle) {
            try {
                this.f6833b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9988c() {
            try {
                this.f6833b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9989d() {
        }

        public void m9990e() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void m9991f() {
            try {
                this.f6833b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9992g() {
            try {
                this.f6833b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f6833b.getStreetViewPanoramaAsync(new C21311(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.b */
    static class C2133b extends C1107b<C2132a> {
        protected C1098e<C2132a> f6835a;
        private final ViewGroup f6836b;
        private final Context f6837c;
        private final StreetViewPanoramaOptions f6838d;
        private final List<OnStreetViewPanoramaReadyCallback> f6839e;

        C2133b(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.f6839e = new ArrayList();
            this.f6836b = viewGroup;
            this.f6837c = context;
            this.f6838d = streetViewPanoramaOptions;
        }

        protected void m9993a(C1098e<C2132a> c1098e) {
            this.f6835a = c1098e;
            m9995i();
        }

        public void m9994a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (m3882a() != null) {
                ((C2132a) m3882a()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f6839e.add(onStreetViewPanoramaReadyCallback);
            }
        }

        public void m9995i() {
            if (this.f6835a != null && m3882a() == null) {
                try {
                    this.f6835a.m3859a(new C2132a(this.f6836b, zzai.zzbq(this.f6837c).zza(C1111d.m3896a(this.f6837c), this.f6838d)));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f6839e) {
                        ((C2132a) m3882a()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f6839e.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (C1292b e2) {
                }
            }
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.f6840a = new C2133b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6840a = new C2133b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6840a = new C2133b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.f6840a = new C2133b(this, context, streetViewPanoramaOptions);
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        C1314c.m4631b("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f6840a.m9994a(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.f6840a.m3884a(bundle);
        if (this.f6840a.m3882a() == null) {
            C1107b.m3880b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.f6840a.m3893g();
    }

    public final void onLowMemory() {
        this.f6840a.m3894h();
    }

    public final void onPause() {
        this.f6840a.m3890d();
    }

    public final void onResume() {
        this.f6840a.m3889c();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f6840a.m3888b(bundle);
    }
}
