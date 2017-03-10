package com.google.android.gms.internal;

import android.app.Activity;
import java.util.Map;

public class vo implements uq {
    public Map<String, String> f6246a;

    public String m9504a(Activity activity) {
        return m9505a(activity.getClass().getCanonicalName());
    }

    public String m9505a(String str) {
        String str2 = (String) this.f6246a.get(str);
        return str2 != null ? str2 : str;
    }
}
