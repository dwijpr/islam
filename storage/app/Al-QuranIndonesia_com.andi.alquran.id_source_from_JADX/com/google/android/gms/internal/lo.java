package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@op
public class lo implements ln {
    private final lm f4834a;
    private final HashSet<SimpleEntry<String, kg>> f4835b;

    public lo(lm lmVar) {
        this.f4834a = lmVar;
        this.f4835b = new HashSet();
    }

    public void m7372a() {
        Iterator it = this.f4835b.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((kg) simpleEntry.getValue()).toString());
            rm.m8450a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f4834a.m7290b((String) simpleEntry.getKey(), (kg) simpleEntry.getValue());
        }
        this.f4835b.clear();
    }

    public void m7373a(String str, kg kgVar) {
        this.f4834a.m7287a(str, kgVar);
        this.f4835b.add(new SimpleEntry(str, kgVar));
    }

    public void m7374a(String str, String str2) {
        this.f4834a.m7288a(str, str2);
    }

    public void m7375a(String str, JSONObject jSONObject) {
        this.f4834a.m7289a(str, jSONObject);
    }

    public void m7376b(String str, kg kgVar) {
        this.f4834a.m7290b(str, kgVar);
        this.f4835b.remove(new SimpleEntry(str, kgVar));
    }

    public void m7377b(String str, JSONObject jSONObject) {
        this.f4834a.m7291b(str, jSONObject);
    }
}
