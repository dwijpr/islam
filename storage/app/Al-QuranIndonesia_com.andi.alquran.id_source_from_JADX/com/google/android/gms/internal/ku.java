package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@op
public class ku implements Iterable<kt> {
    private final List<kt> f4654a;

    public ku() {
        this.f4654a = new LinkedList();
    }

    private kt m7133c(sx sxVar) {
        Iterator it = zzv.zzdg().iterator();
        while (it.hasNext()) {
            kt ktVar = (kt) it.next();
            if (ktVar.f4651a == sxVar) {
                return ktVar;
            }
        }
        return null;
    }

    public int m7134a() {
        return this.f4654a.size();
    }

    public void m7135a(kt ktVar) {
        this.f4654a.add(ktVar);
    }

    public boolean m7136a(sx sxVar) {
        kt c = m7133c(sxVar);
        if (c == null) {
            return false;
        }
        c.f4652b.m7149b();
        return true;
    }

    public void m7137b(kt ktVar) {
        this.f4654a.remove(ktVar);
    }

    public boolean m7138b(sx sxVar) {
        return m7133c(sxVar) != null;
    }

    public Iterator<kt> iterator() {
        return this.f4654a.iterator();
    }
}
