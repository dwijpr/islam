package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.api.C1281f;
import com.google.android.gms.maps.GoogleMap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@op
public abstract class kv implements C1281f {
    protected Context f4670a;
    protected String f4671b;
    protected WeakReference<sx> f4672c;

    /* renamed from: com.google.android.gms.internal.kv.1 */
    class C17201 implements Runnable {
        final /* synthetic */ String f4655a;
        final /* synthetic */ String f4656b;
        final /* synthetic */ int f4657c;
        final /* synthetic */ int f4658d;
        final /* synthetic */ boolean f4659e;
        final /* synthetic */ kv f4660f;

        C17201(kv kvVar, String str, String str2, int i, int i2, boolean z) {
            this.f4660f = kvVar;
            this.f4655a = str;
            this.f4656b = str2;
            this.f4657c = i;
            this.f4658d = i2;
            this.f4659e = z;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(NotificationCompatApi24.CATEGORY_EVENT, "precacheProgress");
            hashMap.put("src", this.f4655a);
            hashMap.put("cachedSrc", this.f4656b);
            hashMap.put("bytesLoaded", Integer.toString(this.f4657c));
            hashMap.put("totalBytes", Integer.toString(this.f4658d));
            hashMap.put("cacheReady", this.f4659e ? "1" : "0");
            this.f4660f.m7141a("onPrecacheEvent", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.kv.2 */
    class C17212 implements Runnable {
        final /* synthetic */ String f4661a;
        final /* synthetic */ String f4662b;
        final /* synthetic */ int f4663c;
        final /* synthetic */ kv f4664d;

        C17212(kv kvVar, String str, String str2, int i) {
            this.f4664d = kvVar;
            this.f4661a = str;
            this.f4662b = str2;
            this.f4663c = i;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(NotificationCompatApi24.CATEGORY_EVENT, "precacheComplete");
            hashMap.put("src", this.f4661a);
            hashMap.put("cachedSrc", this.f4662b);
            hashMap.put("totalBytes", Integer.toString(this.f4663c));
            this.f4664d.m7141a("onPrecacheEvent", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.kv.3 */
    class C17223 implements Runnable {
        final /* synthetic */ String f4665a;
        final /* synthetic */ String f4666b;
        final /* synthetic */ String f4667c;
        final /* synthetic */ String f4668d;
        final /* synthetic */ kv f4669e;

        C17223(kv kvVar, String str, String str2, String str3, String str4) {
            this.f4669e = kvVar;
            this.f4665a = str;
            this.f4666b = str2;
            this.f4667c = str3;
            this.f4668d = str4;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(NotificationCompatApi24.CATEGORY_EVENT, "precacheCanceled");
            hashMap.put("src", this.f4665a);
            if (!TextUtils.isEmpty(this.f4666b)) {
                hashMap.put("cachedSrc", this.f4666b);
            }
            hashMap.put("type", this.f4669e.m7142c(this.f4667c));
            hashMap.put("reason", this.f4667c);
            if (!TextUtils.isEmpty(this.f4668d)) {
                hashMap.put("message", this.f4668d);
            }
            this.f4669e.m7141a("onPrecacheEvent", hashMap);
        }
    }

    public kv(sx sxVar) {
        this.f4670a = sxVar.getContext();
        this.f4671b = zzv.zzcJ().m8498a(this.f4670a, sxVar.m8779o().f6636b);
        this.f4672c = new WeakReference(sxVar);
    }

    private void m7141a(String str, Map<String, String> map) {
        sx sxVar = (sx) this.f4672c.get();
        if (sxVar != null) {
            sxVar.m8757a(str, (Map) map);
        }
    }

    private String m7142c(String str) {
        String str2 = "internal";
        Object obj = -1;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    obj = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    obj = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    obj = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    obj = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    obj = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    obj = 8;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    obj = 9;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    obj = null;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    obj = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return "internal";
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return "io";
            case C1096c.MapAttrs_liteMode /*6*/:
            case C1096c.MapAttrs_uiCompass /*7*/:
                return "network";
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
            case C1096c.MapAttrs_uiScrollGestures /*9*/:
                return "policy";
            default:
                return str2;
        }
    }

    public void m7143a() {
    }

    protected void m7144a(String str, String str2, int i) {
        sf.f5831a.post(new C17212(this, str, str2, i));
    }

    protected void m7145a(String str, String str2, int i, int i2, boolean z) {
        sf.f5831a.post(new C17201(this, str, str2, i, i2, z));
    }

    public void m7146a(String str, String str2, String str3, String str4) {
        sf.f5831a.post(new C17223(this, str, str2, str3, str4));
    }

    public abstract boolean m7147a(String str);

    protected String m7148b(String str) {
        return gr.m6416a().m8693a(str);
    }

    public abstract void m7149b();
}
