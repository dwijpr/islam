package android.support.v4.p009b;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;

@TargetApi(19)
/* renamed from: android.support.v4.b.g */
class C0219g {
    public static File[] m763a(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] m764a(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] m765b(Context context) {
        return context.getObbDirs();
    }
}
