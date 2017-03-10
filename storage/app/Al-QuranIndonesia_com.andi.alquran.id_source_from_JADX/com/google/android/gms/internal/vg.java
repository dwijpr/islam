package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import android.util.Log;
import com.google.android.gms.common.internal.C1314c;
import java.util.Map;
import java.util.Map.Entry;

public class vg extends ud {
    private static String f6207a;
    private static String f6208b;
    private static vg f6209c;

    static {
        f6207a = "3";
        f6208b = "01VDIWEA?";
    }

    public vg(uf ufVar) {
        super(ufVar);
    }

    public static vg m9428b() {
        return f6209c;
    }

    protected String m9429a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        } else {
            if (Math.abs(((Long) l).longValue()) < 100) {
                return String.valueOf(l);
            }
            String str = String.valueOf(l).charAt(0) == '-' ? "-" : BuildConfig.VERSION_NAME;
            String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return stringBuilder.toString();
        }
    }

    protected void m9430a() {
        synchronized (vg.class) {
            f6209c = this;
        }
    }

    public void m9431a(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = (String) uz.f6160c.m9383a();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, uc.m4246c(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            m9434b(i, str, obj, obj2, obj3);
        }
    }

    public void m9432a(vc vcVar, String str) {
        Object obj;
        if (str == null) {
            obj = "no reason provided";
        }
        Object vcVar2 = vcVar != null ? vcVar.toString() : "no hit data";
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(obj);
        m4258d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), vcVar2);
    }

    public void m9433a(Map<String, String> map, String str) {
        Object obj;
        Object stringBuilder;
        if (str == null) {
            obj = "no reason provided";
        }
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(obj);
        m4258d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), stringBuilder);
    }

    public synchronized void m9434b(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            C1314c.m4623a((Object) str);
            if (i >= 0) {
                i2 = i;
            }
            int length = i2 >= f6208b.length() ? f6208b.length() - 1 : i2;
            char c = m4268n().m9332a() ? 'C' : 'c';
            String str2 = f6207a;
            char charAt = f6208b.charAt(length);
            String str3 = ue.f6042a;
            String valueOf = String.valueOf(uc.m4246c(str, m9429a(obj), m9429a(obj2), m9429a(obj3)));
            String stringBuilder = new StringBuilder(((String.valueOf(str2).length() + 3) + String.valueOf(str3).length()) + String.valueOf(valueOf).length()).append(str2).append(charAt).append(c).append(str3).append(":").append(valueOf).toString();
            if (stringBuilder.length() > 1024) {
                stringBuilder = stringBuilder.substring(0, 1024);
            }
            vk n = m4263i().m9166n();
            if (n != null) {
                n.m9490g().m9480a(stringBuilder);
            }
        }
    }
}
