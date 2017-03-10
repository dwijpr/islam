package android.support.v4.p009b;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.support.v4.p007e.C0265c;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;

/* renamed from: android.support.v4.b.a */
public class C0173a {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";
    private static final Object sLock;
    private static TypedValue sTempValue;

    static {
        sLock = new Object();
    }

    protected C0173a() {
    }

    private static File buildPath(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            String str = strArr[i];
            File file3 = file2 == null ? new File(str) : str != null ? new File(file2, str) : file2;
            i++;
            file2 = file3;
        }
        return file2;
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        return C0265c.m909a() ? C0216d.m757b(context) : null;
    }

    private static synchronized File createFilesDir(File file) {
        synchronized (C0173a.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w(TAG, "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }

    public static File getCodeCacheDir(Context context) {
        return VERSION.SDK_INT >= 21 ? C0214b.m753b(context) : C0173a.createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    public static final int getColor(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? C0215c.m755b(context, i) : context.getResources().getColor(i);
    }

    public static final ColorStateList getColorStateList(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? C0215c.m754a(context, i) : context.getResources().getColorStateList(i);
    }

    public static File getDataDir(Context context) {
        if (C0265c.m909a()) {
            return C0216d.m756a(context);
        }
        String str = context.getApplicationInfo().dataDir;
        return str != null ? new File(str) : null;
    }

    public static final Drawable getDrawable(Context context, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            return C0214b.m751a(context, i);
        }
        if (i2 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (sLock) {
            if (sTempValue == null) {
                sTempValue = new TypedValue();
            }
            context.getResources().getValue(i, sTempValue, true);
            i2 = sTempValue.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static File[] getExternalCacheDirs(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return C0219g.m763a(context);
        }
        return new File[]{context.getExternalCacheDir()};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        if (VERSION.SDK_INT >= 19) {
            return C0219g.m764a(context, str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    public static final File getNoBackupFilesDir(Context context) {
        return VERSION.SDK_INT >= 21 ? C0214b.m752a(context) : C0173a.createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static File[] getObbDirs(Context context) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return C0219g.m765b(context);
        }
        File a;
        if (i >= 11) {
            a = C0217e.m759a(context);
        } else {
            a = C0173a.buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_OBB, context.getPackageName());
        }
        return new File[]{a};
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        return C0265c.m909a() ? C0216d.m758c(context) : false;
    }

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return C0173a.startActivities(context, intentArr, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0218f.m762a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0217e.m760a(context, intentArr);
            return true;
        }
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0218f.m761a(context, intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }
}
