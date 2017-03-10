package com.google.android.gms.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@op
class ld {
    private final Object[] f4735a;

    ld(zzdy com_google_android_gms_internal_zzdy, String str, int i) {
        this.f4735a = m7265a(com_google_android_gms_internal_zzdy, str, i);
    }

    private static String m7264a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            String a = obj == null ? "null" : obj instanceof Bundle ? m7264a((Bundle) obj) : obj.toString();
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    private static Object[] m7265a(zzdy com_google_android_gms_internal_zzdy, String str, int i) {
        Set hashSet = new HashSet(Arrays.asList(((String) C1648if.aM.m6682c()).split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(com_google_android_gms_internal_zzdy.f6434b));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(m7264a(com_google_android_gms_internal_zzdy.f6435c));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzdy.f6436d));
        }
        if (hashSet.contains("keywords")) {
            if (com_google_android_gms_internal_zzdy.f6437e != null) {
                arrayList.add(com_google_android_gms_internal_zzdy.f6437e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzdy.f6438f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzdy.f6439g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzdy.f6440h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(com_google_android_gms_internal_zzdy.f6441i);
        }
        if (hashSet.contains("location")) {
            if (com_google_android_gms_internal_zzdy.f6443k != null) {
                arrayList.add(com_google_android_gms_internal_zzdy.f6443k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(com_google_android_gms_internal_zzdy.f6444l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(m7264a(com_google_android_gms_internal_zzdy.f6445m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(m7264a(com_google_android_gms_internal_zzdy.f6446n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (com_google_android_gms_internal_zzdy.f6447o != null) {
                arrayList.add(com_google_android_gms_internal_zzdy.f6447o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(com_google_android_gms_internal_zzdy.f6448p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(com_google_android_gms_internal_zzdy.f6449q);
        }
        return arrayList.toArray();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ld)) {
            return false;
        }
        return Arrays.equals(this.f4735a, ((ld) obj).f4735a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4735a);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.f4735a));
        return new StringBuilder(String.valueOf(valueOf).length() + 24).append("[InterstitialAdPoolKey ").append(valueOf).append("]").toString();
    }
}
