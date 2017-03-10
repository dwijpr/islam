package com.google.android.gms.internal;

import android.content.Context;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@op
public class kh implements kg {
    private final Context f4630a;
    private final zzqa f4631b;

    /* renamed from: com.google.android.gms.internal.kh.1 */
    class C17121 implements Runnable {
        final /* synthetic */ Map f4614a;
        final /* synthetic */ sx f4615b;
        final /* synthetic */ kh f4616c;

        /* renamed from: com.google.android.gms.internal.kh.1.1 */
        class C17111 implements Runnable {
            final /* synthetic */ JSONObject f4612a;
            final /* synthetic */ C17121 f4613b;

            C17111(C17121 c17121, JSONObject jSONObject) {
                this.f4613b = c17121;
                this.f4612a = jSONObject;
            }

            public void run() {
                this.f4613b.f4615b.m7291b("fetchHttpRequestCompleted", this.f4612a);
                sg.m8444b("Dispatched http response.");
            }
        }

        C17121(kh khVar, Map map, sx sxVar) {
            this.f4616c = khVar;
            this.f4614a = map;
            this.f4615b = sxVar;
        }

        public void run() {
            sg.m8444b("Received Http request.");
            JSONObject a = this.f4616c.m7106a((String) this.f4614a.get("http_request"));
            if (a == null) {
                sg.m8446c("Response should not be null.");
            } else {
                rq.f5755a.post(new C17111(this, a));
            }
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.kh.a */
    static class C1713a {
        private final String f4617a;
        private final String f4618b;

        public C1713a(String str, String str2) {
            this.f4617a = str;
            this.f4618b = str2;
        }

        public String m7090a() {
            return this.f4617a;
        }

        public String m7091b() {
            return this.f4618b;
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.kh.b */
    static class C1714b {
        private final String f4619a;
        private final URL f4620b;
        private final ArrayList<C1713a> f4621c;
        private final String f4622d;

        public C1714b(String str, URL url, ArrayList<C1713a> arrayList, String str2) {
            this.f4619a = str;
            this.f4620b = url;
            if (arrayList == null) {
                this.f4621c = new ArrayList();
            } else {
                this.f4621c = arrayList;
            }
            this.f4622d = str2;
        }

        public String m7092a() {
            return this.f4619a;
        }

        public URL m7093b() {
            return this.f4620b;
        }

        public ArrayList<C1713a> m7094c() {
            return this.f4621c;
        }

        public String m7095d() {
            return this.f4622d;
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.kh.c */
    class C1715c {
        private final C1716d f4623a;
        private final boolean f4624b;
        private final String f4625c;

        public C1715c(kh khVar, boolean z, C1716d c1716d, String str) {
            this.f4624b = z;
            this.f4623a = c1716d;
            this.f4625c = str;
        }

        public String m7096a() {
            return this.f4625c;
        }

        public C1716d m7097b() {
            return this.f4623a;
        }

        public boolean m7098c() {
            return this.f4624b;
        }
    }

    @op
    /* renamed from: com.google.android.gms.internal.kh.d */
    static class C1716d {
        private final String f4626a;
        private final int f4627b;
        private final List<C1713a> f4628c;
        private final String f4629d;

        public C1716d(String str, int i, List<C1713a> list, String str2) {
            this.f4626a = str;
            this.f4627b = i;
            if (list == null) {
                this.f4628c = new ArrayList();
            } else {
                this.f4628c = list;
            }
            this.f4629d = str2;
        }

        public String m7099a() {
            return this.f4626a;
        }

        public int m7100b() {
            return this.f4627b;
        }

        public Iterable<C1713a> m7101c() {
            return this.f4628c;
        }

        public String m7102d() {
            return this.f4629d;
        }
    }

    public kh(Context context, zzqa com_google_android_gms_internal_zzqa) {
        this.f4630a = context;
        this.f4631b = com_google_android_gms_internal_zzqa;
    }

    protected C1714b m7103a(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            sg.m8445b("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new C1713a(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new C1714b(optString, url, arrayList, optString3);
    }

    protected C1715c m7104a(C1714b c1714b) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) c1714b.m7093b().openConnection();
            zzv.zzcJ().m8515a(this.f4630a, this.f4631b.f6636b, false, httpURLConnection);
            Iterator it = c1714b.m7094c().iterator();
            while (it.hasNext()) {
                C1713a c1713a = (C1713a) it.next();
                httpURLConnection.addRequestProperty(c1713a.m7090a(), c1713a.m7091b());
            }
            if (!TextUtils.isEmpty(c1714b.m7095d())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = c1714b.m7095d().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            List arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String c1713a2 : (List) entry.getValue()) {
                        arrayList.add(new C1713a((String) entry.getKey(), c1713a2));
                    }
                }
            }
            return new C1715c(this, true, new C1716d(c1714b.m7092a(), httpURLConnection.getResponseCode(), arrayList, zzv.zzcJ().m8500a(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new C1715c(this, false, null, e.toString());
        }
    }

    protected JSONObject m7105a(C1716d c1716d) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", c1716d.m7099a());
            if (c1716d.m7102d() != null) {
                jSONObject.put("body", c1716d.m7102d());
            }
            JSONArray jSONArray = new JSONArray();
            for (C1713a c1713a : c1716d.m7101c()) {
                jSONArray.put(new JSONObject().put("key", c1713a.m7090a()).put("value", c1713a.m7091b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", c1716d.m7100b());
        } catch (Throwable e) {
            sg.m8445b("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public JSONObject m7106a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = BuildConfig.VERSION_NAME;
            try {
                obj = jSONObject.optString("http_request_id");
                C1715c a = m7104a(m7103a(jSONObject));
                if (a.m7098c()) {
                    jSONObject2.put("response", m7105a(a.m7097b()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", a.m7096a());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            sg.m8446c("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    public void m7107a(sx sxVar, Map<String, String> map) {
        rp.m8472a(new C17121(this, map, sxVar));
    }
}
