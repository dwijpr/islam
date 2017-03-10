package com.google.android.gms.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.gms.common.internal.C1314c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

class vi extends ud {
    private static final byte[] f6217c;
    private final String f6218a;
    private final vn f6219b;

    /* renamed from: com.google.android.gms.internal.vi.a */
    private class C2041a {
        final /* synthetic */ vi f6214a;
        private int f6215b;
        private ByteArrayOutputStream f6216c;

        public C2041a(vi viVar) {
            this.f6214a = viVar;
            this.f6216c = new ByteArrayOutputStream();
        }

        public int m9445a() {
            return this.f6215b;
        }

        public boolean m9446a(vc vcVar) {
            C1314c.m4623a((Object) vcVar);
            if (this.f6215b + 1 > this.f6214a.m4268n().m9343l()) {
                return false;
            }
            String a = this.f6214a.m9461a(vcVar, false);
            if (a == null) {
                this.f6214a.m4267m().m9432a(vcVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = a.getBytes();
            int length = bytes.length;
            if (length > this.f6214a.m4268n().m9335d()) {
                this.f6214a.m4267m().m9432a(vcVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.f6216c.size() > 0) {
                length++;
            }
            if (length + this.f6216c.size() > this.f6214a.m4268n().m9337f()) {
                return false;
            }
            try {
                if (this.f6216c.size() > 0) {
                    this.f6216c.write(vi.f6217c);
                }
                this.f6216c.write(bytes);
                this.f6215b++;
                return true;
            } catch (IOException e) {
                this.f6214a.m4261e("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public byte[] m9447b() {
            return this.f6216c.toByteArray();
        }
    }

    static {
        f6217c = "\n".getBytes();
    }

    vi(uf ufVar) {
        super(ufVar);
        this.f6218a = m9449a("GoogleAnalytics", ue.f6042a, VERSION.RELEASE, vp.m9509a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.f6219b = new vn(ufVar.m9156d());
    }

    private int m9448a(URL url, byte[] bArr) {
        Object e;
        Throwable th;
        OutputStream outputStream = null;
        C1314c.m4623a((Object) url);
        C1314c.m4623a((Object) bArr);
        m4252b("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (m4279y()) {
            m4247a("Post payload\n", new String(bArr));
        }
        HttpURLConnection a;
        try {
            m4266l().getPackageName();
            a = m9462a(url);
            try {
                a.setDoOutput(true);
                a.setFixedLengthStreamingMode(bArr.length);
                a.connect();
                outputStream = a.getOutputStream();
                outputStream.write(bArr);
                m9452a(a);
                int responseCode = a.getResponseCode();
                if (responseCode == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                    m4271q().m9150h();
                }
                m4251b("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        m4261e("Error closing http post connection output stream", e2);
                    }
                }
                if (a == null) {
                    return responseCode;
                }
                a.disconnect();
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                try {
                    m4258d("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            m4261e("Error closing http post connection output stream", e4);
                        }
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            m4261e("Error closing http post connection output stream", e22);
                        }
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            a = outputStream;
            m4258d("Network POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            a = outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            throw th;
        }
    }

    private static String m9449a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    private URL m9450a(vc vcVar, String str) {
        String valueOf;
        String valueOf2;
        if (vcVar.m9411f()) {
            valueOf2 = String.valueOf(m4268n().m9345n());
            valueOf = String.valueOf(m4268n().m9347p());
            valueOf = new StringBuilder(((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(valueOf2).append(valueOf).append("?").append(str).toString();
        } else {
            valueOf2 = String.valueOf(m4268n().m9346o());
            valueOf = String.valueOf(m4268n().m9347p());
            valueOf = new StringBuilder(((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(valueOf2).append(valueOf).append("?").append(str).toString();
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            m4261e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void m9451a(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private void m9452a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    m4261e("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    m4261e("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private boolean m9453a(vc vcVar) {
        C1314c.m4623a((Object) vcVar);
        String a = m9461a(vcVar, !vcVar.m9411f());
        if (a == null) {
            m4267m().m9432a(vcVar, "Error formatting hit for upload");
            return true;
        } else if (a.length() <= m4268n().m9334c()) {
            URL a2 = m9450a(vcVar, a);
            if (a2 != null) {
                return m9455b(a2) == Callback.DEFAULT_DRAG_ANIMATION_DURATION;
            } else {
                m4262f("Failed to build collect GET endpoint url");
                return false;
            }
        } else {
            a = m9461a(vcVar, false);
            if (a == null) {
                m4267m().m9432a(vcVar, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = a.getBytes();
            if (bytes.length > m4268n().m9336e()) {
                m4267m().m9432a(vcVar, "Hit payload exceeds size limit");
                return true;
            }
            URL b = m9457b(vcVar);
            if (b != null) {
                return m9448a(b, bytes) == Callback.DEFAULT_DRAG_ANIMATION_DURATION;
            } else {
                m4262f("Failed to build collect POST endpoint url");
                return false;
            }
        }
    }

    private static byte[] m9454a(byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private int m9455b(URL url) {
        C1314c.m4623a((Object) url);
        m4251b("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = m9462a(url);
            httpURLConnection.connect();
            m9452a(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                m4271q().m9150h();
            }
            m4251b("GET status", Integer.valueOf(responseCode));
            if (httpURLConnection == null) {
                return responseCode;
            }
            httpURLConnection.disconnect();
            return responseCode;
        } catch (IOException e) {
            m4258d("Network GET connection error", e);
            return 0;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private int m9456b(URL url, byte[] bArr) {
        HttpURLConnection a;
        Object e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        OutputStream outputStream = null;
        C1314c.m4623a((Object) url);
        C1314c.m4623a((Object) bArr);
        try {
            m4266l().getPackageName();
            byte[] a2 = m9454a(bArr);
            m4249a("POST compressed size, ratio %, url", Integer.valueOf(a2.length), Long.valueOf((100 * ((long) a2.length)) / ((long) bArr.length)), url);
            if (a2.length > bArr.length) {
                m4256c("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(a2.length), Integer.valueOf(bArr.length));
            }
            if (m4279y()) {
                String str = "Post payload";
                String str2 = "\n";
                String valueOf = String.valueOf(new String(bArr));
                m4247a(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            a = m9462a(url);
            try {
                a.setDoOutput(true);
                a.addRequestProperty("Content-Encoding", "gzip");
                a.setFixedLengthStreamingMode(a2.length);
                a.connect();
                OutputStream outputStream2 = a.getOutputStream();
                try {
                    outputStream2.write(a2);
                    outputStream2.close();
                    m9452a(a);
                    int responseCode = a.getResponseCode();
                    if (responseCode == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                        m4271q().m9150h();
                    }
                    m4251b("POST status", Integer.valueOf(responseCode));
                    if (a == null) {
                        return responseCode;
                    }
                    a.disconnect();
                    return responseCode;
                } catch (IOException e2) {
                    e = e2;
                    outputStream = outputStream2;
                    httpURLConnection = a;
                    try {
                        m4258d("Network compressed POST connection error", e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                m4261e("Error closing http compressed post connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        a = httpURLConnection;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                                m4261e("Error closing http compressed post connection output stream", e4);
                            }
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                httpURLConnection = a;
                m4258d("Network compressed POST connection error", e);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return 0;
            } catch (Throwable th4) {
                th = th4;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
            m4258d("Network compressed POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th5) {
            th = th5;
            a = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            throw th;
        }
    }

    private URL m9457b(vc vcVar) {
        String valueOf;
        String valueOf2;
        if (vcVar.m9411f()) {
            valueOf = String.valueOf(m4268n().m9345n());
            valueOf2 = String.valueOf(m4268n().m9347p());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            valueOf = String.valueOf(m4268n().m9346o());
            valueOf2 = String.valueOf(m4268n().m9347p());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            m4261e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String m9458c(vc vcVar) {
        return String.valueOf(vcVar.m9408c());
    }

    private URL m9460d() {
        String valueOf = String.valueOf(m4268n().m9345n());
        String valueOf2 = String.valueOf(m4268n().m9348q());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            m4261e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String m9461a(vc vcVar, boolean z) {
        C1314c.m4623a((Object) vcVar);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : vcVar.m9407b().entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    m9451a(stringBuilder, str, (String) entry.getValue());
                }
            }
            m9451a(stringBuilder, "ht", String.valueOf(vcVar.m9409d()));
            m9451a(stringBuilder, "qt", String.valueOf(m4265k().m4926a() - vcVar.m9409d()));
            if (z) {
                long g = vcVar.m9412g();
                m9451a(stringBuilder, "z", g != 0 ? String.valueOf(g) : m9458c(vcVar));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            m4261e("Failed to encode name or value", e);
            return null;
        }
    }

    HttpURLConnection m9462a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(m4268n().m9328A());
            httpURLConnection.setReadTimeout(m4268n().m9329B());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.f6218a);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    public List<Long> m9463a(List<vc> list) {
        boolean z;
        boolean z2 = true;
        m4264j();
        m4280A();
        C1314c.m4623a((Object) list);
        if (m4268n().m9351t().isEmpty() || !this.f6219b.m9502a(m4268n().m9344m() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = m4268n().m9349r() != un.NONE;
            if (m4268n().m9350s() != up.GZIP) {
                z2 = false;
            }
        }
        return z ? m9464a((List) list, z2) : m9466b((List) list);
    }

    List<Long> m9464a(List<vc> list, boolean z) {
        C1314c.m4632b(!list.isEmpty());
        m4248a("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        C2041a c2041a = new C2041a(this);
        List<Long> arrayList = new ArrayList();
        for (vc vcVar : list) {
            if (!c2041a.m9446a(vcVar)) {
                break;
            }
            arrayList.add(Long.valueOf(vcVar.m9408c()));
        }
        if (c2041a.m9445a() == 0) {
            return arrayList;
        }
        URL d = m9460d();
        if (d == null) {
            m4262f("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int b = z ? m9456b(d, c2041a.m9447b()) : m9448a(d, c2041a.m9447b());
        if (Callback.DEFAULT_DRAG_ANIMATION_DURATION == b) {
            m4247a("Batched upload completed. Hits batched", Integer.valueOf(c2041a.m9445a()));
            return arrayList;
        }
        m4247a("Network error uploading hits. status code", Integer.valueOf(b));
        if (m4268n().m9351t().contains(Integer.valueOf(b))) {
            m4260e("Server instructed the client to stop batching");
            this.f6219b.m9501a();
        }
        return Collections.emptyList();
    }

    protected void m9465a() {
        m4247a("Network initialized. User agent", this.f6218a);
    }

    List<Long> m9466b(List<vc> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (vc vcVar : list) {
            if (!m9453a(vcVar)) {
                break;
            }
            arrayList.add(Long.valueOf(vcVar.m9408c()));
            if (arrayList.size() >= m4268n().m9342k()) {
                break;
            }
        }
        return arrayList;
    }

    public boolean m9467b() {
        NetworkInfo activeNetworkInfo;
        m4264j();
        m4280A();
        try {
            activeNetworkInfo = ((ConnectivityManager) m4266l().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        m4250b("No network connectivity");
        return false;
    }
}
