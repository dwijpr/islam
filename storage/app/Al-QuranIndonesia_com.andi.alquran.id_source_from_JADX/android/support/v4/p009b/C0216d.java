package android.support.v4.p009b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;

@TargetApi(24)
/* renamed from: android.support.v4.b.d */
class C0216d {
    public static File m756a(Context context) {
        return context.getDataDir();
    }

    public static Context m757b(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    public static boolean m758c(Context context) {
        return context.isDeviceProtectedStorage();
    }
}
