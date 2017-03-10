package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.on.C1875a;
import com.google.android.gms.internal.on.C1876b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@op
public class rx {
    public static final C1862a<Void> f5806a;
    private static nm f5807b;
    private static final Object f5808c;

    /* renamed from: com.google.android.gms.internal.rx.a */
    public interface C1862a<T> {
        T m7863b();

        T m7864b(InputStream inputStream);
    }

    /* renamed from: com.google.android.gms.internal.rx.1 */
    class C19831 implements C1862a<Void> {
        C19831() {
        }

        public /* bridge */ /* synthetic */ Object m8650b() {
            return null;
        }

        public /* bridge */ /* synthetic */ Object m8651b(InputStream inputStream) {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.rx.2 */
    class C19842 implements C1875a {
        final /* synthetic */ String f5797a;
        final /* synthetic */ C1989c f5798b;

        C19842(rx rxVar, String str, C1989c c1989c) {
            this.f5797a = str;
            this.f5798b = c1989c;
        }

        public void m8652a(ti tiVar) {
            String str = this.f5797a;
            String valueOf = String.valueOf(tiVar.toString());
            sg.m8449e(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
            this.f5798b.m8662a(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.rx.3 */
    class C19863 extends C1985y {
        final /* synthetic */ byte[] f5800a;
        final /* synthetic */ Map f5801b;

        C19863(rx rxVar, int i, String str, C1876b c1876b, C1875a c1875a, byte[] bArr, Map map) {
            this.f5800a = bArr;
            this.f5801b = map;
            super(i, str, c1876b, c1875a);
        }

        public Map<String, String> m8656f() {
            return this.f5801b == null ? super.m7614f() : this.f5801b;
        }

        public byte[] m8657k() {
            return this.f5800a == null ? super.m7619k() : this.f5800a;
        }
    }

    /* renamed from: com.google.android.gms.internal.rx.b */
    private static class C1988b<T> extends ml<InputStream> {
        private final C1862a<T> f5804a;
        private final C1876b<T> f5805b;

        /* renamed from: com.google.android.gms.internal.rx.b.1 */
        class C19871 implements C1875a {
            final /* synthetic */ C1876b f5802a;
            final /* synthetic */ C1862a f5803b;

            C19871(C1876b c1876b, C1862a c1862a) {
                this.f5802a = c1876b;
                this.f5803b = c1862a;
            }

            public void m8658a(ti tiVar) {
                this.f5802a.m7936a(this.f5803b.m7863b());
            }
        }

        public C1988b(String str, C1862a<T> c1862a, C1876b<T> c1876b) {
            super(0, str, new C19871(c1876b, c1862a));
            this.f5804a = c1862a;
            this.f5805b = c1876b;
        }

        protected on<InputStream> m8659a(kj kjVar) {
            return on.m7938a(new ByteArrayInputStream(kjVar.f4633b), vu.m9566a(kjVar));
        }

        protected void m8660a(InputStream inputStream) {
            this.f5805b.m7936a(this.f5804a.m7864b(inputStream));
        }

        protected /* synthetic */ void m8661a(Object obj) {
            m8660a((InputStream) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.rx.c */
    private class C1989c<T> extends sk<T> implements C1876b<T> {
        private C1989c(rx rxVar) {
        }

        public void m8662a(T t) {
            super.m7304b((Object) t);
        }
    }

    static {
        f5808c = new Object();
        f5806a = new C19831();
    }

    public rx(Context context) {
        m8663a(context);
    }

    private static nm m8663a(Context context) {
        nm nmVar;
        synchronized (f5808c) {
            if (f5807b == null) {
                f5807b = am.m5136a(context.getApplicationContext());
            }
            nmVar = f5807b;
        }
        return nmVar;
    }

    public sn<String> m8664a(int i, String str, Map<String, String> map, byte[] bArr) {
        Object c1989c = new C1989c();
        f5807b.m7769a(new C19863(this, i, str, c1989c, new C19842(this, str, c1989c), bArr, map));
        return c1989c;
    }

    public <T> sn<T> m8665a(String str, C1862a<T> c1862a) {
        Object c1989c = new C1989c();
        f5807b.m7769a(new C1988b(str, c1862a, c1989c));
        return c1989c;
    }

    public sn<String> m8666a(String str, Map<String, String> map) {
        return m8664a(0, str, map, null);
    }
}
