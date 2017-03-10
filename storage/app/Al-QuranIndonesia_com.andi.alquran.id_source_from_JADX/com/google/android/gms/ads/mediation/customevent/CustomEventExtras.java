package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> f2764a;

    public CustomEventExtras() {
        this.f2764a = new HashMap();
    }

    public Object getExtra(String str) {
        return this.f2764a.get(str);
    }

    public void setExtra(String str, Object obj) {
        this.f2764a.put(str, obj);
    }
}
