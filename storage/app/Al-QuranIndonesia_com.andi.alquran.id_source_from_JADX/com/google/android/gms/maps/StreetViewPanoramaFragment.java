package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.C1292b;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzaf.zza;
import com.google.android.gms.maps.internal.zzah;
import com.google.android.gms.maps.internal.zzai;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p039a.C1098e;
import com.google.android.gms.p039a.C1107b;
import com.google.android.gms.p039a.C1111d;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class StreetViewPanoramaFragment extends Fragment {
    private final C2130b f6820a;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment.a */
    static class C2129a implements StreetViewLifecycleDelegate {
        private final Fragment f6814a;
        private final IStreetViewPanoramaFragmentDelegate f6815b;

        /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment.a.1 */
        class C21281 extends zza {
            final /* synthetic */ OnStreetViewPanoramaReadyCallback f6813a;

            C21281(C2129a c2129a, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
                this.f6813a = onStreetViewPanoramaReadyCallback;
            }

            public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
                this.f6813a.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
            }
        }

        public C2129a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.f6815b = (IStreetViewPanoramaFragmentDelegate) C1314c.m4623a((Object) iStreetViewPanoramaFragmentDelegate);
            this.f6814a = (Fragment) C1314c.m4623a((Object) fragment);
        }

        public View m9960a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) C1111d.m3897a(this.f6815b.onCreateView(C1111d.m3896a((Object) layoutInflater), C1111d.m3896a((Object) viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9961a() {
        }

        public void m9962a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f6815b.onInflate(C1111d.m3896a((Object) activity), null, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9963a(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f6814a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzah.zza(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f6815b.onCreate(bundle);
        }

        public void m9964b() {
            try {
                this.f6815b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9965b(Bundle bundle) {
            try {
                this.f6815b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9966c() {
            try {
                this.f6815b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9967d() {
        }

        public void m9968e() {
            try {
                this.f6815b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9969f() {
            try {
                this.f6815b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m9970g() {
            try {
                this.f6815b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f6815b.getStreetViewPanoramaAsync(new C21281(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment.b */
    static class C2130b extends C1107b<C2129a> {
        protected C1098e<C2129a> f6816a;
        private final Fragment f6817b;
        private Activity f6818c;
        private final List<OnStreetViewPanoramaReadyCallback> f6819d;

        C2130b(Fragment fragment) {
            this.f6819d = new ArrayList();
            this.f6817b = fragment;
        }

        private void m9971a(Activity activity) {
            this.f6818c = activity;
            m9975i();
        }

        protected void m9973a(C1098e<C2129a> c1098e) {
            this.f6816a = c1098e;
            m9975i();
        }

        public void m9974a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (m3882a() != null) {
                ((C2129a) m3882a()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f6819d.add(onStreetViewPanoramaReadyCallback);
            }
        }

        public void m9975i() {
            if (this.f6818c != null && this.f6816a != null && m3882a() == null) {
                try {
                    MapsInitializer.initialize(this.f6818c);
                    this.f6816a.m3859a(new C2129a(this.f6817b, zzai.zzbq(this.f6818c).zzI(C1111d.m3896a(this.f6818c))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f6819d) {
                        ((C2129a) m3882a()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f6819d.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (C1292b e2) {
                }
            }
        }
    }

    public StreetViewPanoramaFragment() {
        this.f6820a = new C2130b(this);
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        C1314c.m4631b("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f6820a.m9974a(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6820a.m9971a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6820a.m3884a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f6820a.m3881a(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f6820a.m3893g();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f6820a.m3892f();
        super.onDestroyView();
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f6820a.m9971a(activity);
        this.f6820a.m3883a(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.f6820a.m3894h();
        super.onLowMemory();
    }

    public void onPause() {
        this.f6820a.m3890d();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f6820a.m3889c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f6820a.m3888b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
