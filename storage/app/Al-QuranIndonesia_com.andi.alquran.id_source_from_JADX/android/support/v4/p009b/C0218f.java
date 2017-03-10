package android.support.v4.p009b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

@TargetApi(16)
/* renamed from: android.support.v4.b.f */
class C0218f {
    public static void m761a(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void m762a(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
    }
}
