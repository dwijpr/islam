package com.google.android.gms.internal;

import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.maps.GoogleMap;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class vt implements vv {
    protected final HttpClient f6273a;

    /* renamed from: com.google.android.gms.internal.vt.a */
    public static final class C2050a extends HttpEntityEnclosingRequestBase {
        public C2050a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public vt(HttpClient httpClient) {
        this.f6273a = httpClient;
    }

    private static void m9561a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, ml<?> mlVar) {
        byte[] k = mlVar.m7619k();
        if (k != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(k));
        }
    }

    private static void m9562a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    static HttpUriRequest m9563b(ml<?> mlVar, Map<String, String> map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (mlVar.m7598a()) {
            case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                byte[] h = mlVar.m7616h();
                if (h == null) {
                    return new HttpGet(mlVar.m7610c());
                }
                HttpUriRequest httpPost2 = new HttpPost(mlVar.m7610c());
                httpPost2.addHeader("Content-Type", mlVar.m7615g());
                httpPost2.setEntity(new ByteArrayEntity(h));
                return httpPost2;
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return new HttpGet(mlVar.m7610c());
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                httpPost = new HttpPost(mlVar.m7610c());
                httpPost.addHeader("Content-Type", mlVar.m7618j());
                m9561a(httpPost, (ml) mlVar);
                return httpPost;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                httpPost = new HttpPut(mlVar.m7610c());
                httpPost.addHeader("Content-Type", mlVar.m7618j());
                m9561a(httpPost, (ml) mlVar);
                return httpPost;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return new HttpDelete(mlVar.m7610c());
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return new HttpHead(mlVar.m7610c());
            case C1096c.MapAttrs_cameraZoom /*5*/:
                return new HttpOptions(mlVar.m7610c());
            case C1096c.MapAttrs_liteMode /*6*/:
                return new HttpTrace(mlVar.m7610c());
            case C1096c.MapAttrs_uiCompass /*7*/:
                httpPost = new C2050a(mlVar.m7610c());
                httpPost.addHeader("Content-Type", mlVar.m7618j());
                m9561a(httpPost, (ml) mlVar);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public HttpResponse m9564a(ml<?> mlVar, Map<String, String> map) {
        HttpUriRequest b = m9563b(mlVar, map);
        m9562a(b, (Map) map);
        m9562a(b, mlVar.m7614f());
        HttpParams params = b.getParams();
        int n = mlVar.m7622n();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, n);
        return this.f6273a.execute(b);
    }
}
