package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.internal.he.C1186a;
import com.google.android.gms.internal.hf.C1622a;
import com.google.android.gms.p039a.C1111d;
import com.google.android.gms.p039a.C1113f;

@op
public class ho extends C1113f<hf> {
    public ho() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    protected /* synthetic */ Object m6594a(IBinder iBinder) {
        return m6596b(iBinder);
    }

    public he m6595b(Context context) {
        try {
            return C1186a.zzu(((hf) m3898a(context)).m6446a(C1111d.m3896a((Object) context), 10084000));
        } catch (Throwable e) {
            sg.m8447c("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (Throwable e2) {
            sg.m8447c("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    protected hf m6596b(IBinder iBinder) {
        return C1622a.m6448a(iBinder);
    }
}
