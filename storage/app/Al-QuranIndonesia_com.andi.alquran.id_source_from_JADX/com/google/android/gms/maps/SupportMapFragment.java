package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.C1292b;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzah;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.internal.zzt.zza;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p039a.C1098e;
import com.google.android.gms.p039a.C1107b;
import com.google.android.gms.p039a.C1111d;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
    private final C2136b f6848a;

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.a */
    static class C2135a implements MapLifecycleDelegate {
        private final Fragment f6842a;
        private final IMapFragmentDelegate f6843b;

        /* renamed from: com.google.android.gms.maps.SupportMapFragment.a.1 */
        class C21341 extends zza {
            final /* synthetic */ OnMapReadyCallback f6841a;

            C21341(C2135a c2135a, OnMapReadyCallback onMapReadyCallback) {
                this.f6841a = onMapReadyCallback;
            }

            public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
                this.f6841a.onMapReady(new GoogleMap(iGoogleMapDelegate));
            }
        }

        public C2135a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f6843b = (IMapFragmentDelegate) C1314c.m4623a((Object) iMapFragmentDelegate);
            this.f6842a = (Fragment) C1314c.m4623a((Object) fragment);
        }

        public View m9996a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) C1111d.m3897a(this.f6843b.onCreateView(C1111d.m3896a((Object) layoutInflater), C1111d.m3896a((Object) viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9997a() {
            try {
                this.f6843b.onStart();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9998a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f6843b.onInflate(C1111d.m3896a((Object) activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9999a(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f6842a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzah.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f6843b.onCreate(bundle);
        }

        public void m10000b() {
            try {
                this.f6843b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10001b(Bundle bundle) {
            try {
                this.f6843b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10002c() {
            try {
                this.f6843b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10003c(Bundle bundle) {
            try {
                this.f6843b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10004d() {
            try {
                this.f6843b.onStop();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10005e() {
            try {
                this.f6843b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10006f() {
            try {
                this.f6843b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10007g() {
            try {
                this.f6843b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f6843b.getMapAsync(new C21341(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10008h() {
            try {
                this.f6843b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.b */
    static class C2136b extends C1107b<C2135a> {
        protected C1098e<C2135a> f6844a;
        private final Fragment f6845b;
        private Activity f6846c;
        private final List<OnMapReadyCallback> f6847d;

        C2136b(Fragment fragment) {
            this.f6847d = new ArrayList();
            this.f6845b = fragment;
        }

        private void m10009a(Activity activity) {
            this.f6846c = activity;
            m10014i();
        }

        protected void m10011a(C1098e<C2135a> c1098e) {
            this.f6844a = c1098e;
            m10014i();
        }

        public void m10012a(OnMapReadyCallback onMapReadyCallback) {
            if (m3882a() != null) {
                ((C2135a) m3882a()).getMapAsync(onMapReadyCallback);
            } else {
                this.f6847d.add(onMapReadyCallback);
            }
        }

        public void m10013c(Bundle bundle) {
            if (m3882a() != null) {
                ((C2135a) m3882a()).m10003c(bundle);
            }
        }

        public void m10014i() {
            if (this.f6846c != null && this.f6844a != null && m3882a() == null) {
                try {
                    MapsInitializer.initialize(this.f6846c);
                    IMapFragmentDelegate zzH = zzai.zzbq(this.f6846c).zzH(C1111d.m3896a(this.f6846c));
                    if (zzH != null) {
                        this.f6844a.m3859a(new C2135a(this.f6845b, zzH));
                        for (OnMapReadyCallback mapAsync : this.f6847d) {
                            ((C2135a) m3882a()).getMapAsync(mapAsync);
                        }
                        this.f6847d.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (C1292b e2) {
                }
            }
        }

        public void m10015j() {
            if (m3882a() != null) {
                ((C2135a) m3882a()).m10008h();
            }
        }
    }

    public SupportMapFragment() {
        this.f6848a = new C2136b(this);
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions googleMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        C1314c.m4631b("getMapAsync must be called on the main thread.");
        this.f6848a.m10012a(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6848a.m10009a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6848a.m3884a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = this.f6848a.m3881a(layoutInflater, viewGroup, bundle);
        a.setClickable(true);
        return a;
    }

    public void onDestroy() {
        this.f6848a.m3893g();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f6848a.m3892f();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        C1314c.m4631b("onEnterAmbient must be called on the main thread.");
        this.f6848a.m10013c(bundle);
    }

    public final void onExitAmbient() {
        C1314c.m4631b("onExitAmbient must be called on the main thread.");
        this.f6848a.m10015j();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f6848a.m10009a(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.f6848a.m3883a(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f6848a.m3894h();
        super.onLowMemory();
    }

    public void onPause() {
        this.f6848a.m3890d();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f6848a.m3889c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f6848a.m3888b(bundle);
    }

    public void onStart() {
        super.onStart();
        this.f6848a.m3887b();
    }

    public void onStop() {
        this.f6848a.m3891e();
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
