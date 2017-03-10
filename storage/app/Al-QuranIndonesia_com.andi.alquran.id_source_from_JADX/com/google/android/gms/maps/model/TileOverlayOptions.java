package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.internal.zzi;

public final class TileOverlayOptions extends zza {
    public static final Creator<TileOverlayOptions> CREATOR;
    private final int f6991a;
    private zzi f6992b;
    private TileProvider f6993c;
    private boolean f6994d;
    private float f6995e;
    private boolean f6996f;
    private float f6997g;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.1 */
    class C21821 implements TileProvider {
        final /* synthetic */ TileOverlayOptions f6988a;
        private final zzi f6989b;

        C21821(TileOverlayOptions tileOverlayOptions) {
            this.f6988a = tileOverlayOptions;
            this.f6989b = this.f6988a.f6992b;
        }

        public Tile getTile(int i, int i2, int i3) {
            try {
                return this.f6989b.getTile(i, i2, i3);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.2 */
    class C21832 extends zzi.zza {
        final /* synthetic */ TileProvider f6990a;

        C21832(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
            this.f6990a = tileProvider;
        }

        public Tile getTile(int i, int i2, int i3) {
            return this.f6990a.getTile(i, i2, i3);
        }
    }

    static {
        CREATOR = new zzp();
    }

    public TileOverlayOptions() {
        this.f6994d = true;
        this.f6996f = true;
        this.f6997g = 0.0f;
        this.f6991a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2, float f2) {
        this.f6994d = true;
        this.f6996f = true;
        this.f6997g = 0.0f;
        this.f6991a = i;
        this.f6992b = zzi.zza.zzeq(iBinder);
        this.f6993c = this.f6992b == null ? null : new C21821(this);
        this.f6994d = z;
        this.f6995e = f;
        this.f6996f = z2;
        this.f6997g = f2;
    }

    int m10065a() {
        return this.f6991a;
    }

    IBinder m10066b() {
        return this.f6992b.asBinder();
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.f6996f = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.f6996f;
    }

    public TileProvider getTileProvider() {
        return this.f6993c;
    }

    public float getTransparency() {
        return this.f6997g;
    }

    public float getZIndex() {
        return this.f6995e;
    }

    public boolean isVisible() {
        return this.f6994d;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.f6993c = tileProvider;
        this.f6992b = this.f6993c == null ? null : new C21832(this, tileProvider);
        return this;
    }

    public TileOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        C1314c.m4633b(z, "Transparency must be in the range [0..1]");
        this.f6997g = f;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.f6994d = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.m10085a(this, parcel, i);
    }

    public TileOverlayOptions zIndex(float f) {
        this.f6995e = f;
        return this;
    }
}
