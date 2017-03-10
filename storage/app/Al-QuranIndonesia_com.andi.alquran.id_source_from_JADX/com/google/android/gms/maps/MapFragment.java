package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
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

@TargetApi(11)
public class MapFragment extends Fragment {
    private final C2120b f6795a;

    /* renamed from: com.google.android.gms.maps.MapFragment.a */
    static class C2119a implements MapLifecycleDelegate {
        private final Fragment f6789a;
        private final IMapFragmentDelegate f6790b;

        /* renamed from: com.google.android.gms.maps.MapFragment.a.1 */
        class C21181 extends zza {
            final /* synthetic */ OnMapReadyCallback f6788a;

            C21181(C2119a c2119a, OnMapReadyCallback onMapReadyCallback) {
                this.f6788a = onMapReadyCallback;
            }

            public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
                this.f6788a.onMapReady(new GoogleMap(iGoogleMapDelegate));
            }
        }

        public C2119a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f6790b = (IMapFragmentDelegate) C1314c.m4623a((Object) iMapFragmentDelegate);
            this.f6789a = (Fragment) C1314c.m4623a((Object) fragment);
        }

        public View m9921a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) C1111d.m3897a(this.f6790b.onCreateView(C1111d.m3896a((Object) layoutInflater), C1111d.m3896a((Object) viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9922a() {
            try {
                this.f6790b.onStart();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9923a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f6790b.onInflate(C1111d.m3896a((Object) activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9924a(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f6789a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzah.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f6790b.onCreate(bundle);
        }

        public void m9925b() {
            try {
                this.f6790b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9926b(Bundle bundle) {
            try {
                this.f6790b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9927c() {
            try {
                this.f6790b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9928c(Bundle bundle) {
            try {
                this.f6790b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9929d() {
            try {
                this.f6790b.onStop();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9930e() {
            try {
                this.f6790b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9931f() {
            try {
                this.f6790b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9932g() {
            try {
                this.f6790b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f6790b.getMapAsync(new C21181(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9933h() {
            try {
                this.f6790b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment.b */
    static class C2120b extends C1107b<C2119a> {
        protected C1098e<C2119a> f6791a;
        private final Fragment f6792b;
        private Activity f6793c;
        private final List<OnMapReadyCallback> f6794d;

        C2120b(Fragment fragment) {
            this.f6794d = new ArrayList();
            this.f6792b = fragment;
        }

        private void m9934a(Activity activity) {
            this.f6793c = activity;
            m9939i();
        }

        protected void m9936a(C1098e<C2119a> c1098e) {
            this.f6791a = c1098e;
            m9939i();
        }

        public void m9937a(OnMapReadyCallback onMapReadyCallback) {
            if (m3882a() != null) {
                ((C2119a) m3882a()).getMapAsync(onMapReadyCallback);
            } else {
                this.f6794d.add(onMapReadyCallback);
            }
        }

        public void m9938c(Bundle bundle) {
            if (m3882a() != null) {
                ((C2119a) m3882a()).m9928c(bundle);
            }
        }

        public void m9939i() {
            if (this.f6793c != null && this.f6791a != null && m3882a() == null) {
                try {
                    MapsInitializer.initialize(this.f6793c);
                    IMapFragmentDelegate zzH = zzai.zzbq(this.f6793c).zzH(C1111d.m3896a(this.f6793c));
                    if (zzH != null) {
                        this.f6791a.m3859a(new C2119a(this.f6792b, zzH));
                        for (OnMapReadyCallback mapAsync : this.f6794d) {
                            ((C2119a) m3882a()).getMapAsync(mapAsync);
                        }
                        this.f6794d.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (C1292b e2) {
                }
            }
        }

        public void m9940j() {
            if (m3882a() != null) {
                ((C2119a) m3882a()).m9933h();
            }
        }
    }

    public MapFragment() {
        this.f6795a = new C2120b(this);
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googleMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        C1314c.m4631b("getMapAsync must be called on the main thread.");
        this.f6795a.m9937a(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6795a.m9934a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6795a.m3884a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = this.f6795a.m3881a(layoutInflater, viewGroup, bundle);
        a.setClickable(true);
        return a;
    }

    public void onDestroy() {
        this.f6795a.m3893g();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f6795a.m3892f();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        C1314c.m4631b("onEnterAmbient must be called on the main thread.");
        this.f6795a.m9938c(bundle);
    }

    public final void onExitAmbient() {
        C1314c.m4631b("onExitAmbient must be called on the main thread.");
        this.f6795a.m9940j();
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f6795a.m9934a(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.f6795a.m3883a(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f6795a.m3894h();
        super.onLowMemory();
    }

    public void onPause() {
        this.f6795a.m3890d();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f6795a.m3889c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f6795a.m3888b(bundle);
    }

    public void onStart() {
        super.onStart();
        this.f6795a.m3887b();
    }

    public void onStop() {
        this.f6795a.m3891e();
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
