package android.support.v4.p009b;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

/* renamed from: android.support.v4.b.n */
public final class C0231n {
    public static int m789a(Context context, String str) {
        return C0231n.m790a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int m790a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return AppOpsManagerCompat.noteProxyOp(context, permissionToOp, str2) != 0 ? -2 : 0;
    }
}
