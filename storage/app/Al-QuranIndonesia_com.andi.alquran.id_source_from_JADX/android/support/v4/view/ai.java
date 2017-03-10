package android.support.v4.view;

import android.annotation.TargetApi;
import android.view.VelocityTracker;

@TargetApi(11)
class ai {
    public static float m1648a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    public static float m1649b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
