package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
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

public class SupportStreetViewPanoramaFragment extends Fragment {
    private final C2139b f6856a;

    /* renamed from: com.google.android.gms.maps.SupportStreetViewPanoramaFragment.a */
    static class C2138a implements StreetViewLifecycleDelegate {
        private final Fragment f6850a;
        private final IStreetViewPanoramaFragmentDelegate f6851b;

        /* renamed from: com.google.android.gms.maps.SupportStreetViewPanoramaFragment.a.1 */
        class C21371 extends zza {
            final /* synthetic */ OnStreetViewPanoramaReadyCallback f6849a;

            C21371(C2138a c2138a, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
                this.f6849a = onStreetViewPanoramaReadyCallback;
            }

            public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
                this.f6849a.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
            }
        }

        public C2138a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.f6851b = (IStreetViewPanoramaFragmentDelegate) C1314c.m4623a((Object) iStreetViewPanoramaFragmentDelegate);
            this.f6850a = (Fragment) C1314c.m4623a((Object) fragment);
        }

        public View m10016a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) C1111d.m3897a(this.f6851b.onCreateView(C1111d.m3896a((Object) layoutInflater), C1111d.m3896a((Object) viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10017a() {
        }

        public void m10018a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f6851b.onInflate(C1111d.m3896a((Object) activity), null, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10019a(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f6850a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzah.zza(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f6851b.onCreate(bundle);
        }

        public void m10020b() {
            try {
                this.f6851b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10021b(Bundle bundle) {
            try {
                this.f6851b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10022c() {
            try {
                this.f6851b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10023d() {
        }

        public void m10024e() {
            try {
                this.f6851b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10025f() {
            try {
                this.f6851b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void m10026g() {
            try {
                this.f6851b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f6851b.getStreetViewPanoramaAsync(new C21371(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportStreetViewPanoramaFragment.b */
    static class C2139b extends C1107b<C2138a> {
        protected C1098e<C2138a> f6852a;
        private final Fragment f6853b;
        private Activity f6854c;
        private final List<OnStreetViewPanoramaReadyCallback> f6855d;

        C2139b(Fragment fragment) {
            this.f6855d = new ArrayList();
            this.f6853b = fragment;
        }

        private void m10027a(Activity activity) {
            this.f6854c = activity;
            m10031i();
        }

        protected void m10029a(C1098e<C2138a> c1098e) {
            this.f6852a = c1098e;
            m10031i();
        }

        public void m10030a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (m3882a() != null) {
                ((C2138a) m3882a()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f6855d.add(onStreetViewPanoramaReadyCallback);
            }
        }

        public void m10031i() {
            if (this.f6854c != null && this.f6852a != null && m3882a() == null) {
                try {
                    MapsInitializer.initialize(this.f6854c);
                    this.f6852a.m3859a(new C2138a(this.f6853b, zzai.zzbq(this.f6854c).zzI(C1111d.m3896a(this.f6854c))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f6855d) {
                        ((C2138a) m3882a()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f6855d.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (C1292b e2) {
                }
            }
        }
    }

    public SupportStreetViewPanoramaFragment() {
        this.f6856a = new C2139b(this);
    }

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        C1314c.m4631b("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f6856a.m10030a(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6856a.m10027a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6856a.m3884a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f6856a.m3881a(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f6856a.m3893g();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f6856a.m3892f();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f6856a.m10027a(activity);
        this.f6856a.m3883a(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.f6856a.m3894h();
        super.onLowMemory();
    }

    public void onPause() {
        this.f6856a.m3890d();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f6856a.m3889c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f6856a.m3888b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
