package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzj extends zza {
    public static final Creator<zzj> CREATOR;
    private static final List<Integer> f6727a;
    private static final List<Integer> f6728b;
    private static final List<Integer> f6729c;
    private static final List<Integer> f6730d;
    private final int f6731e;
    private final List<Integer> f6732f;

    static {
        f6727a = Collections.unmodifiableList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19)}));
        f6728b = Collections.unmodifiableList(Arrays.asList(new Integer[]{Integer.valueOf(1)}));
        f6729c = Collections.unmodifiableList(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(12), Integer.valueOf(14), Integer.valueOf(16), Integer.valueOf(18), Integer.valueOf(19)}));
        f6730d = Collections.unmodifiableList(Arrays.asList(new Integer[]{Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9), Integer.valueOf(11), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(17)}));
        CREATOR = new C2095m();
    }

    zzj(int i, List<Integer> list) {
        this.f6731e = i;
        this.f6732f = list;
    }

    public int m9898a() {
        return this.f6731e;
    }

    public List<Integer> m9899b() {
        return this.f6732f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2095m.m9850a(this, parcel, i);
    }
}
