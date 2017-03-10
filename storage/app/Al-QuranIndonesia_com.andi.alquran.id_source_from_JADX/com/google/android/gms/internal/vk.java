package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.C1314c;
import java.util.UUID;

public class vk extends ud {
    private SharedPreferences f6228a;
    private long f6229b;
    private long f6230c;
    private final C2043a f6231d;

    /* renamed from: com.google.android.gms.internal.vk.a */
    public final class C2043a {
        final /* synthetic */ vk f6225a;
        private final String f6226b;
        private final long f6227c;

        private C2043a(vk vkVar, String str, long j) {
            this.f6225a = vkVar;
            C1314c.m4625a(str);
            C1314c.m4632b(j > 0);
            this.f6226b = str;
            this.f6227c = j;
        }

        private void m9474c() {
            long a = this.f6225a.m4265k().m4926a();
            Editor edit = this.f6225a.f6228a.edit();
            edit.remove(m9478g());
            edit.remove(m9481b());
            edit.putLong(m9477f(), a);
            edit.commit();
        }

        private long m9475d() {
            long e = m9476e();
            return e == 0 ? 0 : Math.abs(e - this.f6225a.m4265k().m4926a());
        }

        private long m9476e() {
            return this.f6225a.f6228a.getLong(m9477f(), 0);
        }

        private String m9477f() {
            return String.valueOf(this.f6226b).concat(":start");
        }

        private String m9478g() {
            return String.valueOf(this.f6226b).concat(":count");
        }

        public Pair<String, Long> m9479a() {
            long d = m9475d();
            if (d < this.f6227c) {
                return null;
            }
            if (d > this.f6227c * 2) {
                m9474c();
                return null;
            }
            String string = this.f6225a.f6228a.getString(m9481b(), null);
            d = this.f6225a.f6228a.getLong(m9478g(), 0);
            m9474c();
            return (string == null || d <= 0) ? null : new Pair(string, Long.valueOf(d));
        }

        public void m9480a(String str) {
            if (m9476e() == 0) {
                m9474c();
            }
            if (str == null) {
                str = BuildConfig.VERSION_NAME;
            }
            synchronized (this) {
                long j = this.f6225a.f6228a.getLong(m9478g(), 0);
                if (j <= 0) {
                    Editor edit = this.f6225a.f6228a.edit();
                    edit.putString(m9481b(), str);
                    edit.putLong(m9478g(), 1);
                    edit.apply();
                    return;
                }
                Object obj = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1) ? 1 : null;
                Editor edit2 = this.f6225a.f6228a.edit();
                if (obj != null) {
                    edit2.putString(m9481b(), str);
                }
                edit2.putLong(m9478g(), j + 1);
                edit2.apply();
            }
        }

        protected String m9481b() {
            return String.valueOf(this.f6226b).concat(":value");
        }
    }

    protected vk(uf ufVar) {
        super(ufVar);
        this.f6230c = -1;
        this.f6231d = new C2043a("monitoring", m4268n().m9331D(), null);
    }

    protected void m9483a() {
        this.f6228a = m4266l().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public void m9484a(String str) {
        m4264j();
        m4280A();
        Editor edit = this.f6228a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            m4260e("Failed to commit campaign data");
        }
    }

    public long m9485b() {
        m4264j();
        m4280A();
        if (this.f6229b == 0) {
            long j = this.f6228a.getLong("first_run", 0);
            if (j != 0) {
                this.f6229b = j;
            } else {
                j = m4265k().m4926a();
                Editor edit = this.f6228a.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    m4260e("Failed to commit first run time");
                }
                this.f6229b = j;
            }
        }
        return this.f6229b;
    }

    public vn m9486c() {
        return new vn(m4265k(), m9485b());
    }

    public long m9487d() {
        m4264j();
        m4280A();
        if (this.f6230c == -1) {
            this.f6230c = this.f6228a.getLong("last_dispatch", 0);
        }
        return this.f6230c;
    }

    public void m9488e() {
        m4264j();
        m4280A();
        long a = m4265k().m4926a();
        Editor edit = this.f6228a.edit();
        edit.putLong("last_dispatch", a);
        edit.apply();
        this.f6230c = a;
    }

    public String m9489f() {
        m4264j();
        m4280A();
        CharSequence string = this.f6228a.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }

    public C2043a m9490g() {
        return this.f6231d;
    }
}
