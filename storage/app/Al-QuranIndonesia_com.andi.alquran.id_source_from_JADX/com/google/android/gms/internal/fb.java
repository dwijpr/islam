package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.fc.C1545a;
import com.google.android.gms.internal.fc.C1548d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@op
public class fb implements fd {
    private final Object f3941a;
    private final WeakHashMap<rc, fc> f3942b;
    private final ArrayList<fc> f3943c;
    private final Context f3944d;
    private final zzqa f3945e;
    private final ll f3946f;

    public fb(Context context, zzqa com_google_android_gms_internal_zzqa, ll llVar) {
        this.f3941a = new Object();
        this.f3942b = new WeakHashMap();
        this.f3943c = new ArrayList();
        this.f3944d = context.getApplicationContext();
        this.f3945e = com_google_android_gms_internal_zzqa;
        this.f3946f = llVar;
    }

    public void m6050a(fc fcVar) {
        synchronized (this.f3941a) {
            if (!fcVar.m6096f()) {
                this.f3943c.remove(fcVar);
                Iterator it = this.f3942b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == fcVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void m6051a(zzec com_google_android_gms_internal_zzec, rc rcVar) {
        m6052a(com_google_android_gms_internal_zzec, rcVar, rcVar.f5612b.m8760b());
    }

    public void m6052a(zzec com_google_android_gms_internal_zzec, rc rcVar, View view) {
        m6054a(com_google_android_gms_internal_zzec, rcVar, new C1548d(view, rcVar), null);
    }

    public void m6053a(zzec com_google_android_gms_internal_zzec, rc rcVar, View view, lm lmVar) {
        m6054a(com_google_android_gms_internal_zzec, rcVar, new C1548d(view, rcVar), lmVar);
    }

    public void m6054a(zzec com_google_android_gms_internal_zzec, rc rcVar, fj fjVar, lm lmVar) {
        synchronized (this.f3941a) {
            fc fcVar;
            if (m6056a(rcVar)) {
                fcVar = (fc) this.f3942b.get(rcVar);
            } else {
                fcVar = new fc(this.f3944d, com_google_android_gms_internal_zzec, rcVar, this.f3945e, fjVar);
                fcVar.m6082a((fd) this);
                this.f3942b.put(rcVar, fcVar);
                this.f3943c.add(fcVar);
            }
            if (lmVar != null) {
                fcVar.m6083a(new fe(fcVar, lmVar));
            } else {
                fcVar.m6083a(new ff(fcVar, this.f3946f));
            }
        }
    }

    public void m6055a(zzec com_google_android_gms_internal_zzec, rc rcVar, jd jdVar) {
        m6054a(com_google_android_gms_internal_zzec, rcVar, new C1545a(jdVar), null);
    }

    public boolean m6056a(rc rcVar) {
        boolean z;
        synchronized (this.f3941a) {
            fc fcVar = (fc) this.f3942b.get(rcVar);
            z = fcVar != null && fcVar.m6096f();
        }
        return z;
    }

    public void m6057b(rc rcVar) {
        synchronized (this.f3941a) {
            fc fcVar = (fc) this.f3942b.get(rcVar);
            if (fcVar != null) {
                fcVar.m6094d();
            }
        }
    }

    public void m6058c(rc rcVar) {
        synchronized (this.f3941a) {
            fc fcVar = (fc) this.f3942b.get(rcVar);
            if (fcVar != null) {
                fcVar.m6105o();
            }
        }
    }

    public void m6059d(rc rcVar) {
        synchronized (this.f3941a) {
            fc fcVar = (fc) this.f3942b.get(rcVar);
            if (fcVar != null) {
                fcVar.m6106p();
            }
        }
    }

    public void m6060e(rc rcVar) {
        synchronized (this.f3941a) {
            fc fcVar = (fc) this.f3942b.get(rcVar);
            if (fcVar != null) {
                fcVar.m6107q();
            }
        }
    }
}
