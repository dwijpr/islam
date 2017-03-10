package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzarj;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class zzf extends zza {
    public static final Creator<zzf> CREATOR;
    public static final Comparator<zzd> f6722a;
    private final int f6723b;
    private final List<zzd> f6724c;
    private final String f6725d;
    private final List<zzarj> f6726e;

    /* renamed from: com.google.android.gms.location.zzf.1 */
    class C21061 implements Comparator<zzd> {
        C21061() {
        }

        public int m9892a(zzd com_google_android_gms_location_zzd, zzd com_google_android_gms_location_zzd2) {
            int b = com_google_android_gms_location_zzd.m9890b();
            int b2 = com_google_android_gms_location_zzd2.m9890b();
            if (b != b2) {
                return b < b2 ? -1 : 1;
            } else {
                b = com_google_android_gms_location_zzd.m9891c();
                b2 = com_google_android_gms_location_zzd2.m9891c();
                return b == b2 ? 0 : b >= b2 ? 1 : -1;
            }
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9892a((zzd) obj, (zzd) obj2);
        }
    }

    static {
        CREATOR = new C2092j();
        f6722a = new C21061();
    }

    zzf(int i, List<zzd> list, String str, List<zzarj> list2) {
        C1314c.m4624a((Object) list, (Object) "transitions can't be null");
        C1314c.m4633b(list.size() > 0, "transitions can't be empty.");
        m9893a(list);
        this.f6723b = i;
        this.f6724c = Collections.unmodifiableList(list);
        this.f6725d = str;
        this.f6726e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    private static void m9893a(List<zzd> list) {
        TreeSet treeSet = new TreeSet(f6722a);
        for (zzd add : list) {
            C1314c.m4633b(treeSet.add(add), String.format("Found duplicated transition: %s.", new Object[]{add}));
        }
    }

    public int m9894a() {
        return this.f6723b;
    }

    public List<zzd> m9895b() {
        return this.f6724c;
    }

    public String m9896c() {
        return this.f6725d;
    }

    public List<zzarj> m9897d() {
        return this.f6726e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzf com_google_android_gms_location_zzf = (zzf) obj;
        return C1313b.m4621a(this.f6724c, com_google_android_gms_location_zzf.f6724c) && C1313b.m4621a(this.f6725d, com_google_android_gms_location_zzf.f6725d) && C1313b.m4621a(this.f6726e, com_google_android_gms_location_zzf.f6726e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f6725d != null ? this.f6725d.hashCode() : 0) + (this.f6724c.hashCode() * 31)) * 31;
        if (this.f6726e != null) {
            i = this.f6726e.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f6724c);
        String str = this.f6725d;
        String valueOf2 = String.valueOf(this.f6726e);
        return new StringBuilder(((String.valueOf(valueOf).length() + 61) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append("ActivityTransitionRequest [mTransitions=").append(valueOf).append(", mTag='").append(str).append("'").append(", mClients=").append(valueOf2).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2092j.m9841a(this, parcel, i);
    }
}
