package android.support.v4.p009b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import java.io.File;

@TargetApi(11)
/* renamed from: android.support.v4.b.e */
class C0217e {
    public static File m759a(Context context) {
        return context.getObbDir();
    }

    static void m760a(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }
}
