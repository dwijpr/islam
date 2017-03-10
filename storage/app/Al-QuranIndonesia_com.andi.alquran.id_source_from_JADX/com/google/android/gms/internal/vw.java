package com.google.android.gms.internal;

import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.maps.GoogleMap;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class vw implements vv {
    private final C2051a f6274a;
    private final SSLSocketFactory f6275b;

    /* renamed from: com.google.android.gms.internal.vw.a */
    public interface C2051a {
        String m9569a(String str);
    }

    public vw() {
        this(null);
    }

    public vw(C2051a c2051a) {
        this(c2051a, null);
    }

    public vw(C2051a c2051a, SSLSocketFactory sSLSocketFactory) {
        this.f6274a = c2051a;
        this.f6275b = sSLSocketFactory;
    }

    private HttpURLConnection m9570a(URL url, ml<?> mlVar) {
        HttpURLConnection a = m9574a(url);
        int n = mlVar.m7622n();
        a.setConnectTimeout(n);
        a.setReadTimeout(n);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f6275b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f6275b);
        }
        return a;
    }

    private static HttpEntity m9571a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void m9572a(HttpURLConnection httpURLConnection, ml<?> mlVar) {
        switch (mlVar.m7598a()) {
            case MediationAdRequest.TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED /*-1*/:
                byte[] h = mlVar.m7616h();
                if (h != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", mlVar.m7615g());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(h);
                    dataOutputStream.close();
                }
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                httpURLConnection.setRequestMethod("GET");
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                httpURLConnection.setRequestMethod("POST");
                m9573b(httpURLConnection, mlVar);
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                httpURLConnection.setRequestMethod("PUT");
                m9573b(httpURLConnection, mlVar);
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                httpURLConnection.setRequestMethod("DELETE");
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                httpURLConnection.setRequestMethod("HEAD");
            case C1096c.MapAttrs_cameraZoom /*5*/:
                httpURLConnection.setRequestMethod("OPTIONS");
            case C1096c.MapAttrs_liteMode /*6*/:
                httpURLConnection.setRequestMethod("TRACE");
            case C1096c.MapAttrs_uiCompass /*7*/:
                httpURLConnection.setRequestMethod("PATCH");
                m9573b(httpURLConnection, mlVar);
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void m9573b(HttpURLConnection httpURLConnection, ml<?> mlVar) {
        byte[] k = mlVar.m7619k();
        if (k != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", mlVar.m7618j());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(k);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection m9574a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse m9575a(ml<?> mlVar, Map<String, String> map) {
        String a;
        String c = mlVar.m7610c();
        HashMap hashMap = new HashMap();
        hashMap.putAll(mlVar.m7614f());
        hashMap.putAll(map);
        if (this.f6274a != null) {
            a = this.f6274a.m9569a(c);
            if (a == null) {
                String str = "URL blocked by rewriter: ";
                a = String.valueOf(c);
                throw new IOException(a.length() != 0 ? str.concat(a) : new String(str));
            }
        }
        a = c;
        HttpURLConnection a2 = m9570a(new URL(a), (ml) mlVar);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        m9572a(a2, (ml) mlVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(m9571a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
