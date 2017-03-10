package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C1292b;
import com.google.android.gms.common.C1296d;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzc.zza;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p039a.C1111d;

public class zzai {
    private static Context f6875a;
    private static zzc f6876b;

    private static <T> T m10032a(Class<?> cls) {
        String str;
        String valueOf;
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            str = "Unable to instantiate the dynamic class ";
            valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } catch (IllegalAccessException e2) {
            str = "Unable to call the default constructor of ";
            valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private static <T> T m10033a(ClassLoader classLoader, String str) {
        try {
            return m10032a(((ClassLoader) C1314c.m4623a((Object) classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            String str2 = "Unable to find dynamic class ";
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    private static void m10034a(Context context) {
        int a = C1296d.m4595a(context);
        switch (a) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
            default:
                throw new C1292b(a);
        }
    }

    private static zzc m10035b(Context context) {
        Log.i(zzai.class.getSimpleName(), "Making Creator dynamically");
        return zza.zzdt((IBinder) m10033a(m10036c(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static Context m10036c(Context context) {
        if (f6875a == null) {
            f6875a = C1296d.m4597c(context);
        }
        return f6875a;
    }

    public static zzc zzbq(Context context) {
        C1314c.m4623a((Object) context);
        if (f6876b != null) {
            return f6876b;
        }
        m10034a(context);
        f6876b = m10035b(context);
        try {
            f6876b.zzh(C1111d.m3896a(m10036c(context).getResources()), C1296d.f3032a);
            return f6876b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
