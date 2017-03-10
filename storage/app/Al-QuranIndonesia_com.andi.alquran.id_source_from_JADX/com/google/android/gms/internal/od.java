package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.oa.C1155a;
import com.google.android.gms.internal.rc.C1938a;

@TargetApi(19)
@op
public class od extends ob {
    private Object f5153g;
    private PopupWindow f5154h;
    private boolean f5155i;

    od(Context context, C1938a c1938a, sx sxVar, C1155a c1155a) {
        super(context, c1938a, sxVar, c1155a);
        this.f5153g = new Object();
        this.f5155i = false;
    }

    private void m7823e() {
        synchronized (this.f5153g) {
            this.f5155i = true;
            if ((this.b instanceof Activity) && ((Activity) this.b).isDestroyed()) {
                this.f5154h = null;
            }
            if (this.f5154h != null) {
                if (this.f5154h.isShowing()) {
                    this.f5154h.dismiss();
                }
                this.f5154h = null;
            }
        }
    }

    protected void m7824a(int i) {
        m7823e();
        super.m7791a(i);
    }

    public void cancel() {
        m7823e();
        super.cancel();
    }

    protected void m7825d() {
        Window window = this.b instanceof Activity ? ((Activity) this.b).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.b).isDestroyed()) {
            View frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.c.m8760b(), -1, -1);
            synchronized (this.f5153g) {
                if (this.f5155i) {
                    return;
                }
                this.f5154h = new PopupWindow(frameLayout, 1, 1, false);
                this.f5154h.setOutsideTouchable(true);
                this.f5154h.setClippingEnabled(false);
                sg.m8444b("Displaying the 1x1 popup off the screen.");
                try {
                    this.f5154h.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.f5154h = null;
                }
            }
        }
    }
}
