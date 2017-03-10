package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@op
public class ic {
    private final Collection<ib> f4327a;
    private final Collection<ib<String>> f4328b;
    private final Collection<ib<String>> f4329c;

    public ic() {
        this.f4327a = new ArrayList();
        this.f4328b = new ArrayList();
        this.f4329c = new ArrayList();
    }

    public List<String> m6693a() {
        List<String> arrayList = new ArrayList();
        for (ib c : this.f4328b) {
            String str = (String) c.m6682c();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void m6694a(ib ibVar) {
        this.f4327a.add(ibVar);
    }

    public List<String> m6695b() {
        List<String> a = m6693a();
        for (ib c : this.f4329c) {
            String str = (String) c.m6682c();
            if (str != null) {
                a.add(str);
            }
        }
        return a;
    }

    public void m6696b(ib<String> ibVar) {
        this.f4328b.add(ibVar);
    }

    public void m6697c(ib<String> ibVar) {
        this.f4329c.add(ibVar);
    }
}
