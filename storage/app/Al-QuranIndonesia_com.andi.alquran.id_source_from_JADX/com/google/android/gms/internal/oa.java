package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.C1387m;
import com.google.android.gms.internal.rc.C1938a;

@op
public class oa {

    /* renamed from: com.google.android.gms.internal.oa.a */
    public interface C1155a {
        void zzb(rc rcVar);
    }

    public rs m7817a(Context context, zza com_google_android_gms_ads_internal_zza, C1938a c1938a, cg cgVar, sx sxVar, md mdVar, C1155a c1155a, io ioVar) {
        zzmk com_google_android_gms_internal_zzmk = c1938a.f5595b;
        rs oeVar = com_google_android_gms_internal_zzmk.f6589h ? new oe(context, c1938a, mdVar, c1155a, ioVar, sxVar) : (com_google_android_gms_internal_zzmk.f6601t || (com_google_android_gms_ads_internal_zza instanceof zzr)) ? (com_google_android_gms_internal_zzmk.f6601t && (com_google_android_gms_ads_internal_zza instanceof zzr)) ? new of(context, (zzr) com_google_android_gms_ads_internal_zza, c1938a, cgVar, c1155a, ioVar) : new oc(c1938a, c1155a) : (((Boolean) C1648if.f4360X.m6682c()).booleanValue() && com_google_android_gms_internal_zzmk.f6597p) ? new ny(context, c1938a, sxVar, c1155a) : (((Boolean) C1648if.aq.m6682c()).booleanValue() && C1387m.m4965g() && !C1387m.m4967i() && sxVar != null && sxVar.m8775k().f6455e) ? new od(context, c1938a, sxVar, c1155a) : new ob(context, c1938a, sxVar, c1155a);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(oeVar.getClass().getName());
        sg.m8444b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        oeVar.zziw();
        return oeVar;
    }

    public rs m7818a(Context context, C1938a c1938a, py pyVar) {
        rs qpVar = new qp(context, c1938a, pyVar);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(qpVar.getClass().getName());
        sg.m8444b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        qpVar.zziw();
        return qpVar;
    }
}
