package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.internal.gx.C1176a;
import com.google.android.gms.internal.gy.C1612a;
import com.google.android.gms.p039a.C1111d;
import com.google.android.gms.p039a.C1113f;

@op
public final class gh extends C1113f<gy> {
    public gh() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public gx m6324a(Context context, String str, md mdVar) {
        try {
            return C1176a.zzo(((gy) m3898a(context)).m6431a(C1111d.m3896a((Object) context), str, mdVar, 10084000));
        } catch (Throwable e) {
            sg.m8447c("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            sg.m8447c("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m6325a(IBinder iBinder) {
        return m6326b(iBinder);
    }

    protected gy m6326b(IBinder iBinder) {
        return C1612a.m6433a(iBinder);
    }
}
