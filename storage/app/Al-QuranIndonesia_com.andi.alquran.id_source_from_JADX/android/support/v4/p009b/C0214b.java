package android.support.v4.p009b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

@TargetApi(21)
/* renamed from: android.support.v4.b.b */
class C0214b {
    public static Drawable m751a(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File m752a(Context context) {
        return context.getNoBackupFilesDir();
    }

    public static File m753b(Context context) {
        return context.getCodeCacheDir();
    }
}
