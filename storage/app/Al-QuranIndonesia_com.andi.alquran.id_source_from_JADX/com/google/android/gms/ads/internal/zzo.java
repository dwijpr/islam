package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.zzf.zza;
import com.google.android.gms.internal.iy;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.jh;
import com.google.android.gms.internal.jh.C1658a;
import com.google.android.gms.internal.kg;
import com.google.android.gms.internal.ly;
import com.google.android.gms.internal.mh;
import com.google.android.gms.internal.mi;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.rc;
import com.google.android.gms.internal.sg;
import com.google.android.gms.internal.sx;
import com.google.android.gms.internal.sy.C1137a;
import com.google.android.gms.p039a.C1108c;
import com.google.android.gms.p039a.C1111d;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

@op
public class zzo {

    /* renamed from: com.google.android.gms.ads.internal.zzo.1 */
    class C11811 implements C1137a {
        final /* synthetic */ iy f2632a;
        final /* synthetic */ String f2633b;
        final /* synthetic */ sx f2634c;

        C11811(iy iyVar, String str, sx sxVar) {
            this.f2632a = iyVar;
            this.f2633b = str;
            this.f2634c = sxVar;
        }

        public void m4095a(sx sxVar, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.f2632a.m6808a());
                jSONObject.put("body", this.f2632a.m6811c());
                jSONObject.put("call_to_action", this.f2632a.m6813e());
                jSONObject.put("price", this.f2632a.m6816h());
                jSONObject.put("star_rating", String.valueOf(this.f2632a.m6814f()));
                jSONObject.put("store", this.f2632a.m6815g());
                jSONObject.put("icon", zzo.m4106a(this.f2632a.m6812d()));
                JSONArray jSONArray = new JSONArray();
                List<Object> b = this.f2632a.m6810b();
                if (b != null) {
                    for (Object a : b) {
                        jSONArray.put(zzo.m4106a(zzo.m4113b(a)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", zzo.m4116b(this.f2632a.m6822n(), this.f2633b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "2");
                this.f2634c.m8758a("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                sg.m8447c("Exception occurred when loading assets", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzo.2 */
    class C11822 implements C1137a {
        final /* synthetic */ iz f2635a;
        final /* synthetic */ String f2636b;
        final /* synthetic */ sx f2637c;

        C11822(iz izVar, String str, sx sxVar) {
            this.f2635a = izVar;
            this.f2636b = str;
            this.f2637c = sxVar;
        }

        public void m4096a(sx sxVar, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.f2635a.m6835a());
                jSONObject.put("body", this.f2635a.m6838c());
                jSONObject.put("call_to_action", this.f2635a.m6840e());
                jSONObject.put("advertiser", this.f2635a.m6841f());
                jSONObject.put("logo", zzo.m4106a(this.f2635a.m6839d()));
                JSONArray jSONArray = new JSONArray();
                List<Object> b = this.f2635a.m6837b();
                if (b != null) {
                    for (Object a : b) {
                        jSONArray.put(zzo.m4106a(zzo.m4113b(a)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", zzo.m4116b(this.f2635a.m6843h(), this.f2636b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "1");
                this.f2637c.m8758a("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                sg.m8447c("Exception occurred when loading assets", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzo.3 */
    class C11833 implements kg {
        final /* synthetic */ CountDownLatch f2638a;

        C11833(CountDownLatch countDownLatch) {
            this.f2638a = countDownLatch;
        }

        public void m4097a(sx sxVar, Map<String, String> map) {
            this.f2638a.countDown();
            sxVar.m8760b().setVisibility(0);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzo.4 */
    class C11844 implements kg {
        final /* synthetic */ CountDownLatch f2639a;

        C11844(CountDownLatch countDownLatch) {
            this.f2639a = countDownLatch;
        }

        public void m4098a(sx sxVar, Map<String, String> map) {
            sg.m8449e("Adapter returned an ad, but assets substitution failed");
            this.f2639a.countDown();
            sxVar.destroy();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzo.5 */
    class C11855 implements kg {
        final /* synthetic */ mh f2640a;
        final /* synthetic */ zza f2641b;
        final /* synthetic */ mi f2642c;

        C11855(mh mhVar, zza com_google_android_gms_ads_internal_zzf_zza, mi miVar) {
            this.f2640a = mhVar;
            this.f2641b = com_google_android_gms_ads_internal_zzf_zza;
            this.f2642c = miVar;
        }

        public void m4099a(sx sxVar, Map<String, String> map) {
            Object b = sxVar.m8760b();
            if (b != null) {
                try {
                    if (this.f2640a != null) {
                        if (this.f2640a.m7527k()) {
                            zzo.m4117b(sxVar);
                            return;
                        }
                        this.f2640a.m7515a(C1111d.m3896a(b));
                        this.f2641b.onClick();
                    } else if (this.f2642c == null) {
                    } else {
                        if (this.f2642c.m7558i()) {
                            zzo.m4117b(sxVar);
                            return;
                        }
                        this.f2642c.m7548a(C1111d.m3896a(b));
                        this.f2641b.onClick();
                    }
                } catch (Throwable e) {
                    sg.m8447c("Unable to call handleClick on mapper", e);
                }
            }
        }
    }

    private static iy m4100a(mh mhVar) {
        return new iy(mhVar.m7514a(), mhVar.m7516b(), mhVar.m7518c(), mhVar.m7520d(), mhVar.m7521e(), mhVar.m7522f(), mhVar.m7523g(), mhVar.m7524h(), null, mhVar.m7528l(), null, null);
    }

    private static iz m4101a(mi miVar) {
        return new iz(miVar.m7547a(), miVar.m7549b(), miVar.m7551c(), miVar.m7553d(), miVar.m7554e(), miVar.m7555f(), null, miVar.m7559j());
    }

    static kg m4103a(mh mhVar, mi miVar, zza com_google_android_gms_ads_internal_zzf_zza) {
        return new C11855(mhVar, com_google_android_gms_ads_internal_zzf_zza, miVar);
    }

    static kg m4104a(CountDownLatch countDownLatch) {
        return new C11833(countDownLatch);
    }

    private static String m4105a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            sg.m8449e("Bitmap is null. Returning empty string");
            return BuildConfig.VERSION_NAME;
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        encodeToString = String.valueOf(encodeToString);
        return encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
    }

    static String m4106a(jh jhVar) {
        if (jhVar == null) {
            sg.m8449e("Image is null. Returning empty string");
            return BuildConfig.VERSION_NAME;
        }
        try {
            Uri b = jhVar.m6785b();
            if (b != null) {
                return b.toString();
            }
        } catch (RemoteException e) {
            sg.m8449e("Unable to get image uri. Trying data uri next");
        }
        return m4115b(jhVar);
    }

    private static void m4109a(sx sxVar, iy iyVar, String str) {
        sxVar.m8776l().m8806a(new C11811(iyVar, str, sxVar));
    }

    private static void m4110a(sx sxVar, iz izVar, String str) {
        sxVar.m8776l().m8806a(new C11822(izVar, str, sxVar));
    }

    private static void m4111a(sx sxVar, CountDownLatch countDownLatch) {
        sxVar.m8776l().m8810a("/nativeExpressAssetsLoaded", m4104a(countDownLatch));
        sxVar.m8776l().m8810a("/nativeExpressAssetsLoadingFailed", m4114b(countDownLatch));
    }

    private static boolean m4112a(sx sxVar, ly lyVar, CountDownLatch countDownLatch) {
        View b = sxVar.m8760b();
        if (b == null) {
            sg.m8449e("AdWebView is null");
            return false;
        }
        b.setVisibility(4);
        List list = lyVar.f4893b.f4851o;
        if (list == null || list.isEmpty()) {
            sg.m8449e("No template ids present in mediation response");
            return false;
        }
        m4111a(sxVar, countDownLatch);
        mh h = lyVar.f4894c.m7478h();
        mi i = lyVar.f4894c.m7479i();
        if (list.contains("2") && h != null) {
            m4109a(sxVar, m4100a(h), lyVar.f4893b.f4850n);
        } else if (!list.contains("1") || i == null) {
            sg.m8449e("No matching template id and mapper");
            return false;
        } else {
            m4110a(sxVar, m4101a(i), lyVar.f4893b.f4850n);
        }
        String str = lyVar.f4893b.f4848l;
        String str2 = lyVar.f4893b.f4849m;
        if (str2 != null) {
            sxVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        } else {
            sxVar.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    private static jh m4113b(Object obj) {
        return obj instanceof IBinder ? C1658a.m6787a((IBinder) obj) : null;
    }

    static kg m4114b(CountDownLatch countDownLatch) {
        return new C11844(countDownLatch);
    }

    private static String m4115b(jh jhVar) {
        try {
            C1108c a = jhVar.m6784a();
            if (a == null) {
                sg.m8449e("Drawable is null. Returning empty string");
                return BuildConfig.VERSION_NAME;
            }
            Drawable drawable = (Drawable) C1111d.m3897a(a);
            if (drawable instanceof BitmapDrawable) {
                return m4105a(((BitmapDrawable) drawable).getBitmap());
            }
            sg.m8449e("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return BuildConfig.VERSION_NAME;
        } catch (RemoteException e) {
            sg.m8449e("Unable to get drawable. Returning empty string");
            return BuildConfig.VERSION_NAME;
        }
    }

    private static JSONObject m4116b(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (bundle.containsKey(str2)) {
                if ("image".equals(jSONObject2.getString(str2))) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(str2, m4105a((Bitmap) obj));
                    } else {
                        sg.m8449e("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(str2) instanceof Bitmap) {
                    sg.m8449e("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
        }
        return jSONObject;
    }

    private static void m4117b(sx sxVar) {
        OnClickListener D = sxVar.m8744D();
        if (D != null) {
            D.onClick(sxVar.m8760b());
        }
    }

    public static void zza(rc rcVar, zza com_google_android_gms_ads_internal_zzf_zza) {
        mi miVar = null;
        if (rcVar != null && zzh(rcVar)) {
            sx sxVar = rcVar.f5612b;
            Object b = sxVar != null ? sxVar.m8760b() : null;
            if (b == null) {
                sg.m8449e("AdWebView is null");
                return;
            }
            try {
                List list = rcVar.f5625o != null ? rcVar.f5625o.f4851o : null;
                if (list == null || list.isEmpty()) {
                    sg.m8449e("No template ids present in mediation response");
                    return;
                }
                mh h = rcVar.f5626p != null ? rcVar.f5626p.m7478h() : null;
                if (rcVar.f5626p != null) {
                    miVar = rcVar.f5626p.m7479i();
                }
                if (list.contains("2") && h != null) {
                    h.m7517b(C1111d.m3896a(b));
                    if (!h.m7526j()) {
                        h.m7525i();
                    }
                    sxVar.m8776l().m8810a("/nativeExpressViewClicked", m4103a(h, null, com_google_android_gms_ads_internal_zzf_zza));
                } else if (!list.contains("1") || miVar == null) {
                    sg.m8449e("No matching template id and mapper");
                } else {
                    miVar.m7550b(C1111d.m3896a(b));
                    if (!miVar.m7557h()) {
                        miVar.m7556g();
                    }
                    sxVar.m8776l().m8810a("/nativeExpressViewClicked", m4103a(null, miVar, com_google_android_gms_ads_internal_zzf_zza));
                }
            } catch (Throwable e) {
                sg.m8447c("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    public static boolean zza(sx sxVar, ly lyVar, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = m4112a(sxVar, lyVar, countDownLatch);
        } catch (Throwable e) {
            sg.m8447c("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    public static View zzg(rc rcVar) {
        if (rcVar == null) {
            sg.m8446c("AdState is null");
            return null;
        } else if (zzh(rcVar) && rcVar.f5612b != null) {
            return rcVar.f5612b.m8760b();
        } else {
            try {
                C1108c a = rcVar.f5626p != null ? rcVar.f5626p.m7462a() : null;
                if (a != null) {
                    return (View) C1111d.m3897a(a);
                }
                sg.m8449e("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                sg.m8447c("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzh(rc rcVar) {
        return (rcVar == null || !rcVar.f5624n || rcVar.f5625o == null || rcVar.f5625o.f4848l == null) ? false : true;
    }
}
