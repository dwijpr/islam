package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.support.v7.recyclerview.BuildConfig;
import android.util.Log;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.internal.vx.C2054b;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class wf implements C2054b {
    static Boolean f6313a;
    private static final Charset f6314c;
    final C2064a f6315b;

    /* renamed from: com.google.android.gms.internal.wf.a */
    static class C2064a {
        final ContentResolver f6309a;

        C2064a(Context context) {
            if (context == null || !C2064a.m9646a(context)) {
                this.f6309a = null;
                return;
            }
            this.f6309a = context.getContentResolver();
            dk.m5755b(this.f6309a, "gms:playlog:service:sampling_");
        }

        private static boolean m9646a(Context context) {
            if (wf.f6313a == null) {
                wf.f6313a = Boolean.valueOf(context.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
            }
            return wf.f6313a.booleanValue();
        }

        long m9647a() {
            return this.f6309a == null ? 0 : dk.m5747a(this.f6309a, "android_id", 0);
        }

        String m9648a(String str) {
            if (this.f6309a == null) {
                return null;
            }
            ContentResolver contentResolver = this.f6309a;
            String valueOf = String.valueOf("gms:playlog:service:sampling_");
            String valueOf2 = String.valueOf(str);
            return dk.m5749a(contentResolver, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), null);
        }
    }

    /* renamed from: com.google.android.gms.internal.wf.b */
    static class C2065b {
        public final String f6310a;
        public final long f6311b;
        public final long f6312c;

        public C2065b(String str, long j, long j2) {
            this.f6310a = str;
            this.f6311b = j;
            this.f6312c = j2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2065b)) {
                return false;
            }
            C2065b c2065b = (C2065b) obj;
            return C1313b.m4621a(this.f6310a, c2065b.f6310a) && C1313b.m4621a(Long.valueOf(this.f6311b), Long.valueOf(c2065b.f6311b)) && C1313b.m4621a(Long.valueOf(this.f6312c), Long.valueOf(c2065b.f6312c));
        }

        public int hashCode() {
            return C1313b.m4619a(this.f6310a, Long.valueOf(this.f6311b), Long.valueOf(this.f6312c));
        }
    }

    static {
        f6314c = Charset.forName("UTF-8");
        f6313a = null;
    }

    public wf() {
        this(new C2064a(null));
    }

    public wf(Context context) {
        this(new C2064a(context));
    }

    wf(C2064a c2064a) {
        this.f6315b = (C2064a) C1314c.m4623a((Object) c2064a);
    }

    static long m9649a(long j) {
        return wc.m9632a(ByteBuffer.allocate(8).putLong(j).array());
    }

    static long m9650a(String str, long j) {
        if (str == null || str.isEmpty()) {
            return m9649a(j);
        }
        byte[] bytes = str.getBytes(f6314c);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return wc.m9632a(allocate.array());
    }

    static C2065b m9651a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String str2 = BuildConfig.VERSION_NAME;
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            str2 = "LogSamplerImpl";
            String str3 = "Failed to parse the rule: ";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return new C2065b(str2, parseLong, parseLong2);
            }
            Log.e("LogSamplerImpl", "negative values not supported: " + parseLong + "/" + parseLong2);
            return null;
        } catch (Throwable e) {
            Throwable th = e;
            str3 = "LogSamplerImpl";
            String str4 = "parseLong() failed while parsing: ";
            valueOf = String.valueOf(str);
            Log.e(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), th);
            return null;
        }
    }

    static boolean m9652a(long j, long j2, long j3) {
        if (j2 >= 0 && j3 >= 0) {
            return j3 > 0 && wg.m9654a(j, j3) < j2;
        } else {
            throw new IllegalArgumentException("negative values not supported: " + j2 + "/" + j3);
        }
    }

    public boolean m9653a(String str, int i) {
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        long a = this.f6315b.m9647a();
        C2065b a2 = m9651a(this.f6315b.m9648a(str));
        return a2 != null ? m9652a(m9650a(a2.f6310a, a), a2.f6311b, a2.f6312c) : true;
    }
}
