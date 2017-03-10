package com.google.android.gms.internal;

import com.google.android.gms.internal.on.C1875a;
import com.google.android.gms.internal.on.C1876b;
import java.io.UnsupportedEncodingException;

/* renamed from: com.google.android.gms.internal.y */
public class C1985y extends ml<String> {
    private final C1876b<String> f5799a;

    public C1985y(int i, String str, C1876b<String> c1876b, C1875a c1875a) {
        super(i, str, c1875a);
        this.f5799a = c1876b;
    }

    protected on<String> m8653a(kj kjVar) {
        Object str;
        try {
            str = new String(kjVar.f4633b, vu.m9567a(kjVar.f4634c));
        } catch (UnsupportedEncodingException e) {
            str = new String(kjVar.f4633b);
        }
        return on.m7938a(str, vu.m9566a(kjVar));
    }

    protected /* synthetic */ void m8654a(Object obj) {
        m8655a((String) obj);
    }

    protected void m8655a(String str) {
        this.f5799a.m7936a(str);
    }
}
