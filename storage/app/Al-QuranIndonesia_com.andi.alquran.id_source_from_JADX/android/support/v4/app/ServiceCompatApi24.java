package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Service;

@TargetApi(24)
class ServiceCompatApi24 {
    ServiceCompatApi24() {
    }

    public static void stopForeground(Service service, int i) {
        service.stopForeground(i);
    }
}
