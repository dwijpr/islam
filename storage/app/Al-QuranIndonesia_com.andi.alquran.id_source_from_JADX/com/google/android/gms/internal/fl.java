package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@op
public class fl {
    private final Object f4052a;
    private int f4053b;
    private List<fk> f4054c;

    public fl() {
        this.f4052a = new Object();
        this.f4054c = new LinkedList();
    }

    public fk m6177a() {
        fk fkVar = null;
        int i = 0;
        synchronized (this.f4052a) {
            if (this.f4054c.size() == 0) {
                sg.m8444b("Queue empty");
                return null;
            } else if (this.f4054c.size() >= 2) {
                int i2 = RtlSpacingHelper.UNDEFINED;
                int i3 = 0;
                for (fk fkVar2 : this.f4054c) {
                    fk fkVar3;
                    int i4;
                    int i5 = fkVar2.m6175i();
                    if (i5 > i2) {
                        i = i5;
                        fkVar3 = fkVar2;
                        i4 = i3;
                    } else {
                        i4 = i;
                        fkVar3 = fkVar;
                        i = i2;
                    }
                    i3++;
                    i2 = i;
                    fkVar = fkVar3;
                    i = i4;
                }
                this.f4054c.remove(i);
                return fkVar;
            } else {
                fkVar2 = (fk) this.f4054c.get(0);
                fkVar2.m6171e();
                return fkVar2;
            }
        }
    }

    public boolean m6178a(fk fkVar) {
        boolean z;
        synchronized (this.f4052a) {
            if (this.f4054c.contains(fkVar)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean m6179b(fk fkVar) {
        synchronized (this.f4052a) {
            Iterator it = this.f4054c.iterator();
            while (it.hasNext()) {
                fk fkVar2 = (fk) it.next();
                if (!((Boolean) C1648if.ae.m6682c()).booleanValue() || zzv.zzcN().m8405b()) {
                    if (((Boolean) C1648if.ag.m6682c()).booleanValue() && !zzv.zzcN().m8407c() && fkVar != fkVar2 && fkVar2.m6170d().equals(fkVar.m6170d())) {
                        it.remove();
                        return true;
                    }
                } else if (fkVar != fkVar2 && fkVar2.m6167b().equals(fkVar.m6167b())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public void m6180c(fk fkVar) {
        synchronized (this.f4052a) {
            if (this.f4054c.size() >= 10) {
                sg.m8444b("Queue is full, current size = " + this.f4054c.size());
                this.f4054c.remove(0);
            }
            int i = this.f4053b;
            this.f4053b = i + 1;
            fkVar.m6164a(i);
            this.f4054c.add(fkVar);
        }
    }
}
