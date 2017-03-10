package com.google.android.gms.internal;

import java.util.Map;

@op
public final class kb implements kg {
    private final kc f4590a;

    public kb(kc kcVar) {
        this.f4590a = kcVar;
    }

    public void m7065a(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            sg.m8449e("App event with no name parameter.");
        } else {
            this.f4590a.onAppEvent(str, (String) map.get("info"));
        }
    }
}
