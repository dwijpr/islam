package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.internal.zzag;
import com.google.android.gms.maps.internal.zze.zza;
import com.google.android.gms.maps.internal.zzg;
import com.google.android.gms.maps.internal.zzh;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.internal.zzj;
import com.google.android.gms.maps.internal.zzk;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.internal.zzn;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.maps.internal.zzq;
import com.google.android.gms.maps.internal.zzr;
import com.google.android.gms.maps.internal.zzs;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.internal.zzv;
import com.google.android.gms.maps.internal.zzw;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.internal.zzz;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.zzb;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate f6769a;
    private UiSettings f6770b;

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends zza {
        final /* synthetic */ OnCameraChangeListener f6743a;

        AnonymousClass10(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.f6743a = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            this.f6743a.onCameraChange(cameraPosition);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends zzi.zza {
        final /* synthetic */ OnCameraMoveStartedListener f6744a;

        AnonymousClass11(GoogleMap googleMap, OnCameraMoveStartedListener onCameraMoveStartedListener) {
            this.f6744a = onCameraMoveStartedListener;
        }

        public void onCameraMoveStarted(int i) {
            this.f6744a.onCameraMoveStarted(i);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends zzu.zza {
        final /* synthetic */ OnMarkerClickListener f6745a;

        AnonymousClass12(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.f6745a = onMarkerClickListener;
        }

        public boolean zza(zzf com_google_android_gms_maps_model_internal_zzf) {
            return this.f6745a.onMarkerClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.13 */
    class AnonymousClass13 extends zzh.zza {
        final /* synthetic */ OnCameraMoveListener f6746a;

        AnonymousClass13(GoogleMap googleMap, OnCameraMoveListener onCameraMoveListener) {
            this.f6746a = onCameraMoveListener;
        }

        public void onCameraMove() {
            this.f6746a.onCameraMove();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.14 */
    class AnonymousClass14 extends zzg.zza {
        final /* synthetic */ OnCameraMoveCanceledListener f6747a;

        AnonymousClass14(GoogleMap googleMap, OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
            this.f6747a = onCameraMoveCanceledListener;
        }

        public void onCameraMoveCanceled() {
            this.f6747a.onCameraMoveCanceled();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.15 */
    class AnonymousClass15 extends com.google.android.gms.maps.internal.zzf.zza {
        final /* synthetic */ OnCameraIdleListener f6748a;

        AnonymousClass15(GoogleMap googleMap, OnCameraIdleListener onCameraIdleListener) {
            this.f6748a = onCameraIdleListener;
        }

        public void onCameraIdle() {
            this.f6748a.onCameraIdle();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.16 */
    class AnonymousClass16 extends zzq.zza {
        final /* synthetic */ OnMapClickListener f6749a;

        AnonymousClass16(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.f6749a = onMapClickListener;
        }

        public void onMapClick(LatLng latLng) {
            this.f6749a.onMapClick(latLng);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.17 */
    class AnonymousClass17 extends zzs.zza {
        final /* synthetic */ OnMapLongClickListener f6750a;

        AnonymousClass17(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.f6750a = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng latLng) {
            this.f6750a.onMapLongClick(latLng);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.18 */
    class AnonymousClass18 extends zzv.zza {
        final /* synthetic */ OnMarkerDragListener f6751a;

        AnonymousClass18(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.f6751a = onMarkerDragListener;
        }

        public void zzb(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.f6751a.onMarkerDragStart(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }

        public void zzc(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.f6751a.onMarkerDragEnd(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }

        public void zzd(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.f6751a.onMarkerDrag(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.19 */
    class AnonymousClass19 extends zzm.zza {
        final /* synthetic */ OnInfoWindowClickListener f6752a;

        AnonymousClass19(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.f6752a = onInfoWindowClickListener;
        }

        public void zze(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.f6752a.onInfoWindowClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C21071 extends zzl.zza {
        final /* synthetic */ OnIndoorStateChangeListener f6753a;

        C21071(GoogleMap googleMap, OnIndoorStateChangeListener onIndoorStateChangeListener) {
            this.f6753a = onIndoorStateChangeListener;
        }

        public void onIndoorBuildingFocused() {
            this.f6753a.onIndoorBuildingFocused();
        }

        public void zza(zzd com_google_android_gms_maps_model_internal_zzd) {
            this.f6753a.onIndoorLevelActivated(new IndoorBuilding(com_google_android_gms_maps_model_internal_zzd));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.20 */
    class AnonymousClass20 extends zzo.zza {
        final /* synthetic */ OnInfoWindowLongClickListener f6754a;

        AnonymousClass20(GoogleMap googleMap, OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
            this.f6754a = onInfoWindowLongClickListener;
        }

        public void zzf(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.f6754a.onInfoWindowLongClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.21 */
    class AnonymousClass21 extends zzn.zza {
        final /* synthetic */ OnInfoWindowCloseListener f6755a;

        AnonymousClass21(GoogleMap googleMap, OnInfoWindowCloseListener onInfoWindowCloseListener) {
            this.f6755a = onInfoWindowCloseListener;
        }

        public void zzg(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.f6755a.onInfoWindowClose(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.22 */
    class AnonymousClass22 extends com.google.android.gms.maps.internal.zzd.zza {
        final /* synthetic */ InfoWindowAdapter f6756a;

        AnonymousClass22(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.f6756a = infoWindowAdapter;
        }

        public C1108c zzh(zzf com_google_android_gms_maps_model_internal_zzf) {
            return C1111d.m3896a(this.f6756a.getInfoWindow(new Marker(com_google_android_gms_maps_model_internal_zzf)));
        }

        public C1108c zzi(zzf com_google_android_gms_maps_model_internal_zzf) {
            return C1111d.m3896a(this.f6756a.getInfoContents(new Marker(com_google_android_gms_maps_model_internal_zzf)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.23 */
    class AnonymousClass23 extends zzx.zza {
        final /* synthetic */ OnMyLocationChangeListener f6757a;

        AnonymousClass23(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.f6757a = onMyLocationChangeListener;
        }

        public void zzF(C1108c c1108c) {
            this.f6757a.onMyLocationChange((Location) C1111d.m3897a(c1108c));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.24 */
    class AnonymousClass24 extends zzw.zza {
        final /* synthetic */ OnMyLocationButtonClickListener f6758a;

        AnonymousClass24(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.f6758a = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() {
            return this.f6758a.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C21082 extends zzr.zza {
        final /* synthetic */ OnMapLoadedCallback f6759a;

        C21082(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.f6759a = onMapLoadedCallback;
        }

        public void onMapLoaded() {
            this.f6759a.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C21093 extends zzk.zza {
        final /* synthetic */ OnGroundOverlayClickListener f6760a;

        C21093(GoogleMap googleMap, OnGroundOverlayClickListener onGroundOverlayClickListener) {
            this.f6760a = onGroundOverlayClickListener;
        }

        public void zza(zzc com_google_android_gms_maps_model_internal_zzc) {
            this.f6760a.onGroundOverlayClick(new GroundOverlay(com_google_android_gms_maps_model_internal_zzc));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C21114 extends ILocationSourceDelegate.zza {
        final /* synthetic */ LocationSource f6762a;

        /* renamed from: com.google.android.gms.maps.GoogleMap.4.1 */
        class C21101 implements OnLocationChangedListener {
            final /* synthetic */ zzp f6761a;

            C21101(C21114 c21114, zzp com_google_android_gms_maps_internal_zzp) {
                this.f6761a = com_google_android_gms_maps_internal_zzp;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.f6761a.zze(location);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C21114(GoogleMap googleMap, LocationSource locationSource) {
            this.f6762a = locationSource;
        }

        public void activate(zzp com_google_android_gms_maps_internal_zzp) {
            this.f6762a.activate(new C21101(this, com_google_android_gms_maps_internal_zzp));
        }

        public void deactivate() {
            this.f6762a.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C21125 extends zzj.zza {
        final /* synthetic */ OnCircleClickListener f6763a;

        C21125(GoogleMap googleMap, OnCircleClickListener onCircleClickListener) {
            this.f6763a = onCircleClickListener;
        }

        public void zza(zzb com_google_android_gms_maps_model_internal_zzb) {
            this.f6763a.onCircleClick(new Circle(com_google_android_gms_maps_model_internal_zzb));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C21136 extends zzz.zza {
        final /* synthetic */ OnPolygonClickListener f6764a;

        C21136(GoogleMap googleMap, OnPolygonClickListener onPolygonClickListener) {
            this.f6764a = onPolygonClickListener;
        }

        public void zza(com.google.android.gms.maps.model.internal.zzg com_google_android_gms_maps_model_internal_zzg) {
            this.f6764a.onPolygonClick(new Polygon(com_google_android_gms_maps_model_internal_zzg));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C21147 extends zzaa.zza {
        final /* synthetic */ OnPolylineClickListener f6765a;

        C21147(GoogleMap googleMap, OnPolylineClickListener onPolylineClickListener) {
            this.f6765a = onPolylineClickListener;
        }

        public void zza(IPolylineDelegate iPolylineDelegate) {
            this.f6765a.onPolylineClick(new Polyline(iPolylineDelegate));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C21158 extends zzag.zza {
        final /* synthetic */ SnapshotReadyCallback f6766a;

        C21158(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.f6766a = snapshotReadyCallback;
        }

        public void onSnapshotReady(Bitmap bitmap) {
            this.f6766a.onSnapshotReady(bitmap);
        }

        public void zzG(C1108c c1108c) {
            this.f6766a.onSnapshotReady((Bitmap) C1111d.m3897a(c1108c));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C21169 extends zzy.zza {
        final /* synthetic */ OnPoiClickListener f6767a;

        C21169(GoogleMap googleMap, OnPoiClickListener onPoiClickListener) {
            this.f6767a = onPoiClickListener;
        }

        public void zza(PointOfInterest pointOfInterest) {
            this.f6767a.onPoiClick(pointOfInterest);
        }
    }

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    @Deprecated
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onCameraMoveStarted(int i);
    }

    public interface OnCircleClickListener {
        void onCircleClick(Circle circle);
    }

    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnPoiClickListener {
        void onPoiClick(PointOfInterest pointOfInterest);
    }

    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.a */
    private static final class C2117a extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback f6768a;

        C2117a(CancelableCallback cancelableCallback) {
            this.f6768a = cancelableCallback;
        }

        public void onCancel() {
            this.f6768a.onCancel();
        }

        public void onFinish() {
            this.f6768a.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f6769a = (IGoogleMapDelegate) C1314c.m4623a((Object) iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.f6769a.addCircle(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            zzc addGroundOverlay = this.f6769a.addGroundOverlay(groundOverlayOptions);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            zzf addMarker = this.f6769a.addMarker(markerOptions);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.f6769a.addPolygon(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.f6769a.addPolyline(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            com.google.android.gms.maps.model.internal.zzh addTileOverlay = this.f6769a.addTileOverlay(tileOverlayOptions);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.f6769a.animateCamera(cameraUpdate.zzIy());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.f6769a.animateCameraWithDurationAndCallback(cameraUpdate.zzIy(), i, cancelableCallback == null ? null : new C2117a(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.f6769a.animateCameraWithCallback(cameraUpdate.zzIy(), cancelableCallback == null ? null : new C2117a(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.f6769a.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.f6769a.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzd focusedBuilding = this.f6769a.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.f6769a.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.f6769a.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.f6769a.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.f6769a.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.f6769a.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.f6770b == null) {
                this.f6770b = new UiSettings(this.f6769a.getUiSettings());
            }
            return this.f6770b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.f6769a.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.f6769a.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.f6769a.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.f6769a.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.f6769a.moveCamera(cameraUpdate.zzIy());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void resetMinMaxZoomPreference() {
        try {
            this.f6769a.resetMinMaxZoomPreference();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.f6769a.setBuildingsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.f6769a.setContentDescription(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.f6769a.setIndoorEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.f6769a.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setInfoWindowAdapter(new AnonymousClass22(this, infoWindowAdapter));
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        try {
            this.f6769a.setLatLngBoundsForCameraTarget(latLngBounds);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        if (locationSource == null) {
            try {
                this.f6769a.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setLocationSource(new C21114(this, locationSource));
    }

    public boolean setMapStyle(MapStyleOptions mapStyleOptions) {
        try {
            return this.f6769a.setMapStyle(mapStyleOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapType(int i) {
        try {
            this.f6769a.setMapType(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMaxZoomPreference(float f) {
        try {
            this.f6769a.setMaxZoomPreference(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMinZoomPreference(float f) {
        try {
            this.f6769a.setMinZoomPreference(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.f6769a.setMyLocationEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.f6769a.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnCameraChangeListener(new AnonymousClass10(this, onCameraChangeListener));
    }

    public final void setOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        if (onCameraIdleListener == null) {
            try {
                this.f6769a.setOnCameraIdleListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnCameraIdleListener(new AnonymousClass15(this, onCameraIdleListener));
    }

    public final void setOnCameraMoveCanceledListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        if (onCameraMoveCanceledListener == null) {
            try {
                this.f6769a.setOnCameraMoveCanceledListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnCameraMoveCanceledListener(new AnonymousClass14(this, onCameraMoveCanceledListener));
    }

    public final void setOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        if (onCameraMoveListener == null) {
            try {
                this.f6769a.setOnCameraMoveListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnCameraMoveListener(new AnonymousClass13(this, onCameraMoveListener));
    }

    public final void setOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        if (onCameraMoveStartedListener == null) {
            try {
                this.f6769a.setOnCameraMoveStartedListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnCameraMoveStartedListener(new AnonymousClass11(this, onCameraMoveStartedListener));
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (onCircleClickListener == null) {
            try {
                this.f6769a.setOnCircleClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnCircleClickListener(new C21125(this, onCircleClickListener));
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener == null) {
            try {
                this.f6769a.setOnGroundOverlayClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnGroundOverlayClickListener(new C21093(this, onGroundOverlayClickListener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        if (onIndoorStateChangeListener == null) {
            try {
                this.f6769a.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnIndoorStateChangeListener(new C21071(this, onIndoorStateChangeListener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.f6769a.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnInfoWindowClickListener(new AnonymousClass19(this, onInfoWindowClickListener));
    }

    public final void setOnInfoWindowCloseListener(OnInfoWindowCloseListener onInfoWindowCloseListener) {
        if (onInfoWindowCloseListener == null) {
            try {
                this.f6769a.setOnInfoWindowCloseListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnInfoWindowCloseListener(new AnonymousClass21(this, onInfoWindowCloseListener));
    }

    public final void setOnInfoWindowLongClickListener(OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        if (onInfoWindowLongClickListener == null) {
            try {
                this.f6769a.setOnInfoWindowLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnInfoWindowLongClickListener(new AnonymousClass20(this, onInfoWindowLongClickListener));
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.f6769a.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnMapClickListener(new AnonymousClass16(this, onMapClickListener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        if (onMapLoadedCallback == null) {
            try {
                this.f6769a.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnMapLoadedCallback(new C21082(this, onMapLoadedCallback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener == null) {
            try {
                this.f6769a.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnMapLongClickListener(new AnonymousClass17(this, onMapLongClickListener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.f6769a.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnMarkerClickListener(new AnonymousClass12(this, onMarkerClickListener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        if (onMarkerDragListener == null) {
            try {
                this.f6769a.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnMarkerDragListener(new AnonymousClass18(this, onMarkerDragListener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        if (onMyLocationButtonClickListener == null) {
            try {
                this.f6769a.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnMyLocationButtonClickListener(new AnonymousClass24(this, onMyLocationButtonClickListener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.f6769a.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnMyLocationChangeListener(new AnonymousClass23(this, onMyLocationChangeListener));
    }

    public final void setOnPoiClickListener(OnPoiClickListener onPoiClickListener) {
        if (onPoiClickListener == null) {
            try {
                this.f6769a.setOnPoiClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnPoiClickListener(new C21169(this, onPoiClickListener));
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener == null) {
            try {
                this.f6769a.setOnPolygonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnPolygonClickListener(new C21136(this, onPolygonClickListener));
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener == null) {
            try {
                this.f6769a.setOnPolylineClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6769a.setOnPolylineClickListener(new C21147(this, onPolylineClickListener));
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.f6769a.setPadding(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.f6769a.setTrafficEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.f6769a.snapshot(new C21158(this, snapshotReadyCallback), (C1111d) (bitmap != null ? C1111d.m3896a((Object) bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.f6769a.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
