package com.google.android.gms.internal;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.util.Map;

public class kj {
    public final int f4632a;
    public final byte[] f4633b;
    public final Map<String, String> f4634c;
    public final boolean f4635d;
    public final long f4636e;

    public kj(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.f4632a = i;
        this.f4633b = bArr;
        this.f4634c = map;
        this.f4635d = z;
        this.f4636e = j;
    }

    public kj(byte[] bArr, Map<String, String> map) {
        this(Callback.DEFAULT_DRAG_ANIMATION_DURATION, bArr, map, false, 0);
    }
}
