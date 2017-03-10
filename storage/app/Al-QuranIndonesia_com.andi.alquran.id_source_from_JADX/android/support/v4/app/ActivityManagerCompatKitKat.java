package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.ActivityManager;

@TargetApi(19)
class ActivityManagerCompatKitKat {
    ActivityManagerCompatKitKat() {
    }

    public static boolean isLowRamDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
