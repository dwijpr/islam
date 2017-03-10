package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.jd.C1660a;
import com.google.android.gms.internal.og.C1674a;
import com.google.android.gms.internal.rc.C1938a;
import com.google.android.gms.internal.rx.C1862a;
import com.google.android.gms.internal.sm.C1860a;
import com.google.android.gms.p039a.C1111d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class oh implements Callable<rc> {
    static long f5213a;
    private final Context f5214b;
    private final rx f5215c;
    private final zzr f5216d;
    private final cg f5217e;
    private final og f5218f;
    private final Object f5219g;
    private final C1938a f5220h;
    private final io f5221i;
    private boolean f5222j;
    private int f5223k;
    private List<String> f5224l;
    private JSONObject f5225m;

    /* renamed from: com.google.android.gms.internal.oh.1 */
    class C18561 extends C1674a {
        final /* synthetic */ String f5190a;
        final /* synthetic */ C1865b f5191b;
        final /* synthetic */ sk f5192c;
        final /* synthetic */ oh f5193d;

        /* renamed from: com.google.android.gms.internal.oh.1.1 */
        class C18551 implements kg {
            final /* synthetic */ lm f5188a;
            final /* synthetic */ C18561 f5189b;

            C18551(C18561 c18561, lm lmVar) {
                this.f5189b = c18561;
                this.f5188a = lmVar;
            }

            public void m7855a(sx sxVar, Map<String, String> map) {
                try {
                    String str = (String) map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        if (this.f5189b.f5190a.equals(new JSONObject(str).optString("ads_id", BuildConfig.VERSION_NAME))) {
                            this.f5188a.m7290b("/nativeAdPreProcess", this.f5189b.f5191b.f5212a);
                            this.f5189b.f5192c.m7304b(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        }
                    }
                } catch (Throwable e) {
                    sg.m8445b("Malformed native JSON response.", e);
                    this.f5189b.f5193d.m7891a(0);
                    C1314c.m4629a(this.f5189b.f5193d.m7894b(), (Object) "Unable to set the ad state error!");
                    this.f5189b.f5192c.m7304b(null);
                }
            }
        }

        C18561(oh ohVar, String str, C1865b c1865b, sk skVar) {
            this.f5193d = ohVar;
            this.f5190a = str;
            this.f5191b = c1865b;
            this.f5192c = skVar;
        }

        public void m7856a() {
            this.f5192c.m7304b(null);
        }

        public void m7857a(lm lmVar) {
            kg c18551 = new C18551(this, lmVar);
            this.f5191b.f5212a = c18551;
            lmVar.m7287a("/nativeAdPreProcess", c18551);
            try {
                JSONObject jSONObject = new JSONObject(this.f5193d.f5220h.f5595b.f6584c);
                jSONObject.put("ads_id", this.f5190a);
                lmVar.m7289a("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
            } catch (Throwable e) {
                sg.m8447c("Exception occurred while invoking javascript", e);
                this.f5192c.m7304b(null);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.oh.2 */
    class C18572 implements Runnable {
        final /* synthetic */ sk f5194a;
        final /* synthetic */ String f5195b;
        final /* synthetic */ oh f5196c;

        C18572(oh ohVar, sk skVar, String str) {
            this.f5196c = ohVar;
            this.f5194a = skVar;
            this.f5195b = str;
        }

        public void run() {
            this.f5194a.m7304b((jv) this.f5196c.f5216d.zzcs().get(this.f5195b));
        }
    }

    /* renamed from: com.google.android.gms.internal.oh.3 */
    class C18583 implements kg {
        final /* synthetic */ ja f5197a;
        final /* synthetic */ oh f5198b;

        C18583(oh ohVar, ja jaVar) {
            this.f5198b = ohVar;
            this.f5197a = jaVar;
        }

        public void m7858a(sx sxVar, Map<String, String> map) {
            this.f5198b.m7876a(this.f5197a, (String) map.get("asset"));
        }
    }

    /* renamed from: com.google.android.gms.internal.oh.4 */
    class C18594 extends C1674a {
        final /* synthetic */ kg f5199a;

        C18594(oh ohVar, kg kgVar) {
            this.f5199a = kgVar;
        }

        public void m7859a(lm lmVar) {
            lmVar.m7287a("/nativeAdCustomClick", this.f5199a);
        }
    }

    /* renamed from: com.google.android.gms.internal.oh.5 */
    class C18615 implements C1860a<List<ix>, iv> {
        final /* synthetic */ String f5200a;
        final /* synthetic */ Integer f5201b;
        final /* synthetic */ Integer f5202c;
        final /* synthetic */ int f5203d;
        final /* synthetic */ int f5204e;
        final /* synthetic */ int f5205f;
        final /* synthetic */ int f5206g;

        C18615(oh ohVar, String str, Integer num, Integer num2, int i, int i2, int i3, int i4) {
            this.f5200a = str;
            this.f5201b = num;
            this.f5202c = num2;
            this.f5203d = i;
            this.f5204e = i2;
            this.f5205f = i3;
            this.f5206g = i4;
        }

        public iv m7861a(List<ix> list) {
            iv ivVar;
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        ivVar = new iv(this.f5200a, oh.m7881b((List) list), this.f5201b, this.f5202c, this.f5203d > 0 ? Integer.valueOf(this.f5203d) : null, this.f5204e + this.f5205f, this.f5206g);
                        return ivVar;
                    }
                } catch (Throwable e) {
                    sg.m8445b("Could not get attribution icon", e);
                    return null;
                }
            }
            ivVar = null;
            return ivVar;
        }

        public /* synthetic */ Object m7862a(Object obj) {
            return m7861a((List) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.oh.6 */
    class C18636 implements C1862a<ix> {
        final /* synthetic */ boolean f5207a;
        final /* synthetic */ double f5208b;
        final /* synthetic */ boolean f5209c;
        final /* synthetic */ String f5210d;
        final /* synthetic */ oh f5211e;

        C18636(oh ohVar, boolean z, double d, boolean z2, String str) {
            this.f5211e = ohVar;
            this.f5207a = z;
            this.f5208b = d;
            this.f5209c = z2;
            this.f5210d = str;
        }

        public ix m7865a() {
            this.f5211e.m7892a(2, this.f5207a);
            return null;
        }

        @TargetApi(19)
        public ix m7866a(InputStream inputStream) {
            Bitmap decodeStream;
            Options options = new Options();
            options.inDensity = (int) (160.0d * this.f5208b);
            if (!this.f5209c) {
                options.inPreferredConfig = Config.RGB_565;
            }
            try {
                decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Throwable e) {
                sg.m8445b("Error grabbing image.", e);
                decodeStream = null;
            }
            if (decodeStream == null) {
                this.f5211e.m7892a(2, this.f5207a);
                return null;
            }
            if (C1387m.m4965g()) {
                int width = decodeStream.getWidth();
                int height = decodeStream.getHeight();
                rm.m8450a("Decoded image w: " + width + " h:" + height + " bytes: " + decodeStream.getAllocationByteCount());
            }
            return new ix(new BitmapDrawable(Resources.getSystem(), decodeStream), Uri.parse(this.f5210d), this.f5208b);
        }

        public /* synthetic */ Object m7867b() {
            return m7865a();
        }

        @TargetApi(19)
        public /* synthetic */ Object m7868b(InputStream inputStream) {
            return m7866a(inputStream);
        }
    }

    /* renamed from: com.google.android.gms.internal.oh.a */
    public interface C1864a<T extends C1660a> {
        T m7869a(oh ohVar, JSONObject jSONObject);
    }

    /* renamed from: com.google.android.gms.internal.oh.b */
    class C1865b {
        public kg f5212a;

        C1865b(oh ohVar) {
        }
    }

    static {
        f5213a = TimeUnit.SECONDS.toMillis(60);
    }

    public oh(Context context, zzr com_google_android_gms_ads_internal_zzr, rx rxVar, cg cgVar, C1938a c1938a, io ioVar) {
        this.f5219g = new Object();
        this.f5214b = context;
        this.f5216d = com_google_android_gms_ads_internal_zzr;
        this.f5215c = rxVar;
        this.f5220h = c1938a;
        this.f5217e = cgVar;
        this.f5221i = ioVar;
        this.f5218f = m7883a(context, c1938a, com_google_android_gms_ads_internal_zzr, cgVar);
        this.f5218f.m7848a();
        this.f5222j = false;
        this.f5223k = -2;
        this.f5224l = null;
    }

    private C1660a m7870a(C1864a c1864a, JSONObject jSONObject, String str) {
        if (m7894b() || c1864a == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] c = m7882c(jSONObject2, "impression_tracking_urls");
        this.f5224l = c == null ? null : Arrays.asList(c);
        this.f5225m = jSONObject2.optJSONObject("active_view");
        C1660a a = c1864a.m7869a(this, jSONObject);
        if (a == null) {
            sg.m8446c("Failed to retrieve ad assets.");
            return null;
        }
        a.m6804a(new je(this.f5214b, this.f5216d, this.f5218f, this.f5217e, jSONObject, a, this.f5220h.f5594a.f6550k, str));
        return a;
    }

    private sn<ix> m7872a(JSONObject jSONObject, boolean z, boolean z2) {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new sl(new ix(null, Uri.parse(string), optDouble)) : this.f5215c.m8665a(string, new C18636(this, z, optDouble, optBoolean, string));
        } else {
            m7892a(0, z);
            return new sl(null);
        }
    }

    private JSONObject m7874a(String str) {
        if (m7894b()) {
            return null;
        }
        sk skVar = new sk();
        this.f5218f.m7849a(new C18561(this, str, new C1865b(this), skVar));
        return (JSONObject) skVar.get(f5213a, TimeUnit.MILLISECONDS);
    }

    private void m7875a(C1660a c1660a) {
        if (c1660a instanceof ja) {
            ja jaVar = (ja) c1660a;
            C1865b c1865b = new C1865b(this);
            kg c18583 = new C18583(this, jaVar);
            c1865b.f5212a = c18583;
            this.f5218f.m7849a(new C18594(this, c18583));
        }
    }

    private void m7876a(jq jqVar, String str) {
        try {
            ju zzz = this.f5216d.zzz(jqVar.m6904l());
            if (zzz != null) {
                zzz.m7043a(jqVar, str);
            }
        } catch (Throwable e) {
            sg.m8447c(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private rc m7879b(C1660a c1660a) {
        int i;
        synchronized (this.f5219g) {
            i = this.f5223k;
            if (c1660a == null && this.f5223k == -2) {
                i = 0;
            }
        }
        return new rc(this.f5220h.f5594a.f6542c, null, this.f5220h.f5595b.f6585d, i, this.f5220h.f5595b.f6587f, this.f5224l, this.f5220h.f5595b.f6593l, this.f5220h.f5595b.f6592k, this.f5220h.f5594a.f6548i, false, null, null, null, null, null, 0, this.f5220h.f5597d, this.f5220h.f5595b.f6588g, this.f5220h.f5599f, this.f5220h.f5600g, this.f5220h.f5595b.f6596o, this.f5225m, i != -2 ? null : c1660a, null, null, null, this.f5220h.f5595b.f6571F, this.f5220h.f5595b.f6572G, null, this.f5220h.f5595b.f6575J, this.f5220h.f5595b.f6579N);
    }

    private Integer m7880b(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private static List<Drawable> m7881b(List<ix> list) {
        List<Drawable> arrayList = new ArrayList();
        for (ix a : list) {
            arrayList.add((Drawable) C1111d.m3897a(a.m6788a()));
        }
        return arrayList;
    }

    private String[] m7882c(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    og m7883a(Context context, C1938a c1938a, zzr com_google_android_gms_ads_internal_zzr, cg cgVar) {
        return new og(context, c1938a, com_google_android_gms_ads_internal_zzr, cgVar);
    }

    protected C1864a m7884a(JSONObject jSONObject) {
        if (m7894b() || jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.f5220h.f5594a.f6565z != null ? this.f5220h.f5594a.f6565z.f6480b : false;
        boolean z2 = this.f5220h.f5594a.f6565z != null ? this.f5220h.f5594a.f6565z.f6482d : false;
        if ("2".equals(string)) {
            return new oj(z, z2);
        }
        if ("1".equals(string)) {
            return new ok(z, z2);
        }
        if ("3".equals(string)) {
            String string2 = jSONObject.getString("custom_template_id");
            sk skVar = new sk();
            rq.f5755a.post(new C18572(this, skVar, string2));
            if (skVar.get(f5213a, TimeUnit.MILLISECONDS) != null) {
                return new ol(z);
            }
            string2 = "No handler for custom template: ";
            String valueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            sg.m8446c(valueOf.length() != 0 ? string2.concat(valueOf) : new String(string2));
        } else {
            m7891a(0);
        }
        return null;
    }

    oi m7885a(Context context, cg cgVar, C1938a c1938a, io ioVar, zzr com_google_android_gms_ads_internal_zzr) {
        return new oi(context, cgVar, c1938a, ioVar, com_google_android_gms_ads_internal_zzr);
    }

    public rc m7886a() {
        try {
            this.f5218f.m7850b();
            String c = m7895c();
            JSONObject a = m7874a(c);
            C1660a a2 = m7870a(m7884a(a), a, c);
            m7875a(a2);
            return m7879b(a2);
        } catch (CancellationException e) {
            if (!this.f5222j) {
                m7891a(0);
            }
            return m7879b(null);
        } catch (ExecutionException e2) {
            if (this.f5222j) {
                m7891a(0);
            }
            return m7879b(null);
        } catch (InterruptedException e3) {
            if (this.f5222j) {
                m7891a(0);
            }
            return m7879b(null);
        } catch (Throwable e4) {
            sg.m8447c("Malformed native JSON response.", e4);
            if (this.f5222j) {
                m7891a(0);
            }
            return m7879b(null);
        } catch (Throwable e42) {
            sg.m8447c("Timeout when loading native ad.", e42);
            if (this.f5222j) {
                m7891a(0);
            }
            return m7879b(null);
        }
    }

    public sn<sx> m7887a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return new sl(null);
        }
        if (!TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            return m7885a(this.f5214b, this.f5217e, this.f5220h, this.f5221i, this.f5216d).m7910a(optJSONObject);
        }
        sg.m8449e("Required field 'vast_xml' is missing");
        return new sl(null);
    }

    public sn<ix> m7888a(JSONObject jSONObject, String str, boolean z, boolean z2) {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m7872a(jSONObject2, z, z2);
    }

    public List<sn<ix>> m7889a(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<sn<ix>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            m7892a(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(m7872a(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<ix> m7890a(JSONObject jSONObject, String str, boolean z) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m7872a(jSONObject2, optBoolean, z);
    }

    public void m7891a(int i) {
        synchronized (this.f5219g) {
            this.f5222j = true;
            this.f5223k = i;
        }
    }

    public void m7892a(int i, boolean z) {
        if (z) {
            m7891a(i);
        }
    }

    public sn<iv> m7893b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new sl(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer b = m7880b(optJSONObject, "text_color");
        Integer b2 = m7880b(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        int i = (this.f5220h.f5594a.f6565z == null || this.f5220h.f5594a.f6565z.f6479a < 2) ? 1 : this.f5220h.f5594a.f6565z.f6483e;
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = m7889a(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(m7888a(optJSONObject, "image", false, false));
        }
        return sm.m8714a(sm.m8715a(arrayList), new C18615(this, optString, b2, b, optInt, optInt3, optInt2, i));
    }

    public boolean m7894b() {
        boolean z;
        synchronized (this.f5219g) {
            z = this.f5222j;
        }
        return z;
    }

    String m7895c() {
        return UUID.randomUUID().toString();
    }

    public /* synthetic */ Object call() {
        return m7886a();
    }
}
