package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.recyclerview.BuildConfig;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.le.C1755a;
import com.google.android.gms.internal.po.C1917a;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

@op
public class lc {
    private final Map<ld, le> f4732a;
    private final LinkedList<ld> f4733b;
    private kz f4734c;

    public lc() {
        this.f4732a = new HashMap();
        this.f4733b = new LinkedList();
    }

    static Bundle m7247a(zzdy com_google_android_gms_internal_zzdy) {
        Bundle bundle = com_google_android_gms_internal_zzdy.f6445m;
        return bundle == null ? null : bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    }

    private static void m7248a(Bundle bundle, String str) {
        String[] split = str.split("/", 2);
        if (split.length != 0) {
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            Bundle bundle2 = bundle.getBundle(str2);
            if (bundle2 != null) {
                m7248a(bundle2, split[1]);
            }
        }
    }

    private static void m7249a(String str, ld ldVar) {
        if (sg.m8443a(2)) {
            rm.m8450a(String.format(str, new Object[]{ldVar}));
        }
    }

    private String[] m7250a(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    static zzdy m7251b(zzdy com_google_android_gms_internal_zzdy) {
        zzdy d = m7254d(com_google_android_gms_internal_zzdy);
        Bundle a = m7247a(d);
        if (a == null) {
            a = new Bundle();
            d.f6445m.putBundle("com.google.ads.mediation.admob.AdMobAdapter", a);
        }
        a.putBoolean("_skipMediation", true);
        return d;
    }

    private boolean m7252b(String str) {
        try {
            return Pattern.matches((String) C1648if.aR.m6682c(), str);
        } catch (Throwable e) {
            zzv.zzcN().m8399a(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    static boolean m7253c(zzdy com_google_android_gms_internal_zzdy) {
        Bundle bundle = com_google_android_gms_internal_zzdy.f6445m;
        if (bundle == null) {
            return false;
        }
        bundle = bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle != null && bundle.containsKey("_skipMediation");
    }

    static zzdy m7254d(zzdy com_google_android_gms_internal_zzdy) {
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzdy.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzdy com_google_android_gms_internal_zzdy2 = (zzdy) zzdy.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        zzdy.m9766a(com_google_android_gms_internal_zzdy2);
        return com_google_android_gms_internal_zzdy2;
    }

    private static zzdy m7255e(zzdy com_google_android_gms_internal_zzdy) {
        zzdy d = m7254d(com_google_android_gms_internal_zzdy);
        for (String a : ((String) C1648if.aN.m6682c()).split(",")) {
            m7248a(d.f6445m, a);
        }
        return d;
    }

    private String m7256e() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.f4733b.iterator();
            while (it.hasNext()) {
                stringBuilder.append(Base64.encodeToString(((ld) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    stringBuilder.append("\u0000");
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return BuildConfig.VERSION_NAME;
        }
    }

    C1755a m7257a(zzdy com_google_android_gms_internal_zzdy, String str) {
        if (m7252b(str)) {
            return null;
        }
        le leVar;
        int i = new C1917a(this.f4734c.m7157a()).m8198a().f5501m;
        zzdy e = m7255e(com_google_android_gms_internal_zzdy);
        ld ldVar = new ld(e, str, i);
        le leVar2 = (le) this.f4732a.get(ldVar);
        if (leVar2 == null) {
            m7249a("Interstitial pool created at %s.", ldVar);
            leVar2 = new le(e, str, i);
            this.f4732a.put(ldVar, leVar2);
            leVar = leVar2;
        } else {
            leVar = leVar2;
        }
        this.f4733b.remove(ldVar);
        this.f4733b.add(ldVar);
        leVar.m7278g();
        while (this.f4733b.size() > ((Integer) C1648if.aO.m6682c()).intValue()) {
            ld ldVar2 = (ld) this.f4733b.remove();
            le leVar3 = (le) this.f4732a.get(ldVar2);
            m7249a("Evicting interstitial queue for %s.", ldVar2);
            while (leVar3.m7275d() > 0) {
                leVar3.m7269a(null).f4736a.zzck();
            }
            this.f4732a.remove(ldVar2);
        }
        while (leVar.m7275d() > 0) {
            C1755a a = leVar.m7269a(e);
            if (!a.f4740e || zzv.zzcP().m4926a() - a.f4739d <= 1000 * ((long) ((Integer) C1648if.aQ.m6682c()).intValue())) {
                String str2 = a.f4737b != null ? " (inline) " : " ";
                m7249a(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), ldVar);
                return a;
            }
            m7249a("Expired interstitial at %s.", ldVar);
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m7258a() {
        /*
        r9 = this;
        r8 = 2;
        r0 = r9.f4734c;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = r9.f4732a;
        r0 = r0.entrySet();
        r3 = r0.iterator();
    L_0x0010:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0076;
    L_0x0016:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (com.google.android.gms.internal.ld) r1;
        r0 = r0.getValue();
        r0 = (com.google.android.gms.internal.le) r0;
        r2 = com.google.android.gms.internal.sg.m8443a(r8);
        if (r2 == 0) goto L_0x0056;
    L_0x002e:
        r2 = r0.m7275d();
        r4 = r0.m7276e();
        if (r4 >= r2) goto L_0x0056;
    L_0x0038:
        r5 = "Loading %s/%s pooled interstitials for %s.";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r2 - r4;
        r4 = java.lang.Integer.valueOf(r4);
        r6[r7] = r4;
        r4 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r4] = r2;
        r6[r8] = r1;
        r2 = java.lang.String.format(r5, r6);
        com.google.android.gms.internal.rm.m8450a(r2);
    L_0x0056:
        r0.m7277f();
    L_0x0059:
        r4 = r0.m7275d();
        r2 = com.google.android.gms.internal.C1648if.aP;
        r2 = r2.m6682c();
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        if (r4 >= r2) goto L_0x0010;
    L_0x006b:
        r2 = "Pooling and loading one new interstitial for %s.";
        m7249a(r2, r1);
        r2 = r9.f4734c;
        r0.m7271a(r2);
        goto L_0x0059;
    L_0x0076:
        r9.m7260b();
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.lc.a():void");
    }

    void m7259a(kz kzVar) {
        if (this.f4734c == null) {
            this.f4734c = kzVar.m7160b();
            m7262c();
        }
    }

    void m7260b() {
        if (this.f4734c != null) {
            Editor edit = this.f4734c.m7157a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Entry entry : this.f4732a.entrySet()) {
                ld ldVar = (ld) entry.getKey();
                le leVar = (le) entry.getValue();
                if (leVar.m7279h()) {
                    edit.putString(ldVar.toString(), new lg(leVar).m7285a());
                    m7249a("Saved interstitial queue for %s.", ldVar);
                }
            }
            edit.putString("PoolKeys", m7256e());
            edit.apply();
        }
    }

    void m7261b(zzdy com_google_android_gms_internal_zzdy, String str) {
        if (this.f4734c != null) {
            int i = new C1917a(this.f4734c.m7157a()).m8198a().f5501m;
            zzdy e = m7255e(com_google_android_gms_internal_zzdy);
            ld ldVar = new ld(e, str, i);
            le leVar = (le) this.f4732a.get(ldVar);
            if (leVar == null) {
                m7249a("Interstitial pool created at %s.", ldVar);
                leVar = new le(e, str, i);
                this.f4732a.put(ldVar, leVar);
            }
            leVar.m7272a(this.f4734c, com_google_android_gms_internal_zzdy);
            leVar.m7278g();
            m7249a("Inline entry added to the queue at %s.", ldVar);
        }
    }

    void m7262c() {
        if (this.f4734c != null) {
            SharedPreferences sharedPreferences = this.f4734c.m7157a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            m7263d();
            try {
                Map hashMap = new HashMap();
                for (Entry entry : sharedPreferences.getAll().entrySet()) {
                    if (!((String) entry.getKey()).equals("PoolKeys")) {
                        lg a = lg.m7284a((String) entry.getValue());
                        ld ldVar = new ld(a.f4754a, a.f4755b, a.f4756c);
                        if (!this.f4732a.containsKey(ldVar)) {
                            this.f4732a.put(ldVar, new le(a.f4754a, a.f4755b, a.f4756c));
                            hashMap.put(ldVar.toString(), ldVar);
                            m7249a("Restored interstitial queue for %s.", ldVar);
                        }
                    }
                }
                for (Object obj : m7250a(sharedPreferences.getString("PoolKeys", BuildConfig.VERSION_NAME))) {
                    ld ldVar2 = (ld) hashMap.get(obj);
                    if (this.f4732a.containsKey(ldVar2)) {
                        this.f4733b.add(ldVar2);
                    }
                }
            } catch (Throwable th) {
                zzv.zzcN().m8399a(th, "InterstitialAdPool.restore");
                sg.m8447c("Malformed preferences value for InterstitialAdPool.", th);
                this.f4732a.clear();
                this.f4733b.clear();
            }
        }
    }

    void m7263d() {
        while (this.f4733b.size() > 0) {
            ld ldVar = (ld) this.f4733b.remove();
            le leVar = (le) this.f4732a.get(ldVar);
            m7249a("Flushing interstitial queue for %s.", ldVar);
            while (leVar.m7275d() > 0) {
                leVar.m7269a(null).f4736a.zzck();
            }
            this.f4732a.remove(ldVar);
        }
    }
}
